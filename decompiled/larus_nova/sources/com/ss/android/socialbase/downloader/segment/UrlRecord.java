package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes38.dex */
class UrlRecord {
    private final AtomicLong downloadBytes;
    private int failedTimes;
    private int hashCode;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    final String f449588ip;
    final String ipFamily;
    private boolean isCurrentFailed;
    final boolean isMainUrl;
    private String key;
    private final List<SegmentReader> readers;
    final String url;

    public synchronized int getCurrentUsers() {
        monitor-enter(this);
        int r100 = this.readers.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isCurrentFailed() {
        monitor-enter(this);
        boolean r100 = this.isCurrentFailed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void recordFailed() {
        monitor-enter(this);
        this.failedTimes++;     // Catch: Throwable -> L6
        this.isCurrentFailed = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void recordSucceed() {
        monitor-enter(this);
        this.isCurrentFailed = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private String getKey() {
        if (this.key != null) goto L9;
        StringBuilder r100 = new StringBuilder();
        r100.append(this.url);
        r100.append("_");
        String r101 = this.f449588ip;
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r100.append(r101);
        r100.append("_");
        r100.append(this.isMainUrl);
        this.key = r100.toString();
    L9:
        return this.key;
    }

    public long getDownloadBytes() {
        long r100 = this.downloadBytes.get();
        Iterator<SegmentReader> r101 = this.readers.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100 = r100 + r101.next().getReadingBytes();
        goto L4
    L6:
        return r100;
    }

    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        this.hashCode = getKey().hashCode();
    L6:
        return this.hashCode;
    }

    public String toString() {
        return "UrlRecord{url='" + this.url + "', ip='" + this.f449588ip + "', ipFamily='" + this.ipFamily + "', isMainUrl=" + this.isMainUrl + ", failedTimes=" + this.failedTimes + ", isCurrentFailed=" + this.isCurrentFailed + '}';
    }

    private String getIpFamily(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        int r101 = r100.lastIndexOf(".");     // Catch: Throwable -> L10
        if (r101 > 0) goto L7;
        return null;
    L7:
        if (r101 >= r100.length()) goto L18;
        return r100.substring(0, r101);
    L18:
        return null;
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    L16:
        return null;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlRecord) == true) goto L10;
        return false;
    L10:
        return getKey().equals(((UrlRecord) r100).getKey());
    }

    public void increaseDownloadBytes(long r100) {
        this.downloadBytes.addAndGet(r100);
    }

    public synchronized void recordUnUse(SegmentReader r100) {
        monitor-enter(this);
        this.readers.remove(r100);     // Catch: Throwable -> L6
    L4:
        monitor-exit(this);
    }

    public synchronized void recordUse(SegmentReader r100) {
        monitor-enter(this);
        this.readers.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public UrlRecord(String r100, String r101) {
        this.readers = new ArrayList();
        this.downloadBytes = new AtomicLong();
        this.url = r100;
        this.isMainUrl = false;
        this.f449588ip = r101;
        this.ipFamily = getIpFamily(r101);
    }

    public UrlRecord(String r100, boolean r101) {
        this.readers = new ArrayList();
        this.downloadBytes = new AtomicLong();
        this.url = r100;
        this.isMainUrl = r101;
        this.f449588ip = null;
        this.ipFamily = null;
    }
}
