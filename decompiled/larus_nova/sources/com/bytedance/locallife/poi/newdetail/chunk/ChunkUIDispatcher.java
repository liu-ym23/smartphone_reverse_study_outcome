package com.bytedance.locallife.poi.newdetail.chunk;

import com.bytedance.locallife.common.utils.h;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class ChunkUIDispatcher implements com.bytedance.locallife.poi.newdetail.chunk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f262998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f262999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<b> f263000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f263001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f263002e;

    public static final class a {
    }

    static {
    }

    public ChunkUIDispatcher() {
        this(1500, 500);
    }

    @Override // com.bytedance.locallife.poi.newdetail.chunk.a
    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "chunkUpdater");
        if (Intrinsics.areEqual(((LinkedList) this.f263000c).peek(), r100) == true) goto L10;
        b r101 = (b) ((LinkedList) this.f263000c).peek();
        if (r101 == null) goto L7;
        r101.name();
    L7:
        r100.name();
        return;
    L10:
        if (this.f263000c.isEmpty() == true) goto L19;
        b r102 = (b) ((LinkedList) this.f263000c).poll();
        if (r102 == null) goto L19;
        if (r102.isReady() == false) goto L19;
        r102.update();
    L19:
        if (this.f263000c.isEmpty() == false) goto L25;
        b(false, true, true);
        return;
    }

    public ChunkUIDispatcher(long r100, long r101) {
        this.f262998a = r100;
        this.f262999b = r101;
        this.f263000c = new LinkedList();
        this.f263001d = new h(this.f262999b, new ChunkUIDispatcher$intervalTimer$1(this));
        this.f263002e = new h(this.f262998a, new ChunkUIDispatcher$timeoutCheckTimer$1(this));
    }

    public final void b(boolean r100, boolean r101, boolean r102) {
        if (r102 == false) goto L12;
        com.bytedance.locallife.common.utils.c r103 = this.f263001d.f257148b;
        monitor-enter(r103);
        r103.f257139e = true;     // Catch: Throwable -> L9
        r103.f257141g = false;     // Catch: Throwable -> L9
        r103.f257142h = false;     // Catch: Throwable -> L9
        r103.f257143i.removeMessages(1);     // Catch: Throwable -> L9
        monitor-exit(r103);
    L9:
        th = move-exception;
        throw th;
    L12:
        if (r101 == false) goto L14;
        this.f263002e.a();
    L14:
        if (r100 == true) goto L16;
        return;
    L16:
        if (this.f263001d.b() == true) goto L19;
        this.f263001d.c();
    L19:
        if (this.f263002e.b() == true) goto L25;
        this.f263002e.c();
        return;
    }
}
