package com.ss.android.lark.audio.voiceinput.processor;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<ByteBuffer> f409350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f409351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f409352c;

    public a() {
        this.f409350a = new ConcurrentLinkedQueue();
        this.f409352c = 1048576;
    }

    public final void a(Function1<? super ByteBuffer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        int r101 = (int) Math.ceil((((double) this.f409351b) * 1.0d) / ((double) this.f409352c));
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L16;
        if (r101 > 1) goto L7;
        int r103 = this.f409351b;
    L11:
        ByteBuffer r104 = ByteBuffer.allocate(r103);
    L13:
        if ((!this.f409350a.isEmpty()) == false) goto L15;
        r104.put(this.f409350a.poll());
        goto L13
    L15:
        Intrinsics.checkNotNull(r104);
        r100.invoke(r104);
        r102 = r102 + 1;
        goto L3
    L7:
        if (r102 != (r101 - 1)) goto L9;
        r103 = this.f409351b - (this.f409352c * r102);
        goto L11
    L9:
        r103 = this.f409352c;
        goto L11
    }
}
