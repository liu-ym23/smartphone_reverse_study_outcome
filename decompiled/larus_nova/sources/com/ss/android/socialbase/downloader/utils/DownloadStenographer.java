package com.ss.android.socialbase.downloader.utils;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadStenographer {
    private static final int MAX_NODE_COUNT = 20;
    private static final int SECONDS_TO_MILLS = 1000;
    private int count;
    private Node head;
    private int maxCount;
    private Node tail;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.DownloadStenographer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Node {
        long curBytes;
        Node next;
        Node prev;
        long when;

        private Node() {
        }

        public /* synthetic */ Node(AnonymousClass1 r100) {
            this();
        }
    }

    private Node obtainNode() {
        int r100 = this.count;
        AnonymousClass1 r101 = null;
        if (r100 < this.maxCount) goto L10;
        Node r102 = this.tail;
        if (r102 == null) goto L10;
        Node r103 = r102.prev;
        r102.prev = null;
        this.tail = r103;
        if (r103 == null) goto L9;
        r103.next = null;
    L9:
        return r102;
    L10:
        this.count = r100 + 1;
        return new Node(r101);
    }

    public DownloadStenographer() {
        this.maxCount = 10;
    }

    public DownloadStenographer(int r100) {
        if (r100 <= 20) goto L5;
        r100 = 20;
    L5:
        this.maxCount = r100;
    }

    private Node findFirstNodeNearWhen(long r100) {
        Node r101 = this.head;
        Node r102 = null;
    L3:
        if (r101 == null) goto L7;
        if (r101.when <= r100) goto L7;
        r102 = r101;
        r101 = r101.next;
    L7:
        if (r101 == null) goto L13;
        if (r102 == null) goto L13;
        if (r101 == r102) goto L13;
        if ((r100 - r101.when) >= (r102.when - r100)) goto L13;
        return r101;
    L13:
        return r102;
    }

    public long getRecentDownloadSpeed(long r100, long r110) {
        monitor-enter(this);
        Node r101 = this.head;     // Catch: Throwable -> L20
        if (r101 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L7:
        Node r102 = findFirstNodeNearWhen(r100);     // Catch: Throwable -> L20
        if (r102 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L11:
        long r103 = r101.curBytes - r102.curBytes;     // Catch: Throwable -> L20
        long r111 = r110 - r102.when;     // Catch: Throwable -> L20
        if (r103 >= 0) goto L14;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L14:
        if (r111 <= 0) goto L18;
        long r104 = r103 / r111;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return r104;
    L20:
        th = move-exception;
        throw th;
    }

    public boolean markProgress(long r100, long r110) {
        monitor-enter(this);
        Node r101 = this.head;     // Catch: Throwable -> L26
        if (r101 != null) goto L6;
    L20:
        Node r102 = obtainNode();     // Catch: Throwable -> L26
        r102.curBytes = r100;     // Catch: Throwable -> L26
        r102.when = r110;     // Catch: Throwable -> L26
        if (r101 == null) goto L23;
        r102.next = r101;     // Catch: Throwable -> L26
        r101.prev = r102;     // Catch: Throwable -> L26
    L23:
        this.head = r102;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return true;
    L6:
        if (r100 >= r101.curBytes) goto L8;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L26
        return false;
    L8:
        if (r110 < r101.when) goto L17;
        Node r103 = r101.next;     // Catch: Throwable -> L26
        if (r103 == null) goto L20;
        if ((r110 - r103.when) >= 1000) goto L20;
        r101.curBytes = r100;     // Catch: Throwable -> L26
        r101.when = r110;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return true;
    L26:
        th = move-exception;
        throw th;
    }
}
