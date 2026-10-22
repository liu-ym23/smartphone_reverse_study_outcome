package com.bytedance.live.livelink.kmp.impl.core.sei;

import com.bytedance.live.kmp.core.KmpEnv;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class AndroidPublishSeiCache extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f255427c;

    public AndroidPublishSeiCache(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkService");
        super(r100);
    }

    @Override // com.bytedance.live.livelink.kmp.impl.core.sei.a
    public final ByteBuffer a(Object r100) {
        if ((r100 instanceof ByteBuffer) == false) goto L7;
        return (ByteBuffer) r100;
    L7:
        if ((r100 instanceof String) == false) goto L37;
        int r101 = ((String) r100).length();
        ByteBuffer r102 = this.f255427c;
        if (r102 != null) goto L11;
    L12:
        this.f255427c = ByteBuffer.allocateDirect(r101 + 64);
        int r103 = ej6.a.f472874a;
        ej6.a.c("CommonSeiManager", "sei length " + r101 + " and 1024 is too large.");
    L13:
        final Ref.IntRef r104 = new Ref.IntRef();
        r104.element = 0;
        int r105 = 3;
    L14:
        int r106 = r105 - 1;
        if (r105 <= 0) goto L25;
        pi6.a.a(this.f255427c, r100, new AndroidPublishSeiCache$getByteBufferFromSei$1(r104));
        if (r104.element != 0) goto L25;
        ByteBuffer r107 = this.f255427c;
        if (r107 == null) goto L22;
        int r108 = r107.capacity();
    L23:
        this.f255427c = ByteBuffer.allocateDirect(r108 * 2);
        r105 = r106;
        goto L14
    L22:
        r108 = 0;
    L25:
        if (r104.element <= 0) goto L36;
        ByteBuffer r109 = this.f255427c;
        if (r109 == null) goto L29;
        r109.position(0);
    L29:
        ByteBuffer r110 = this.f255427c;
        if (r110 == null) goto L32;
        r110.limit(r104.element);
    L32:
        ByteBuffer r111 = this.f255427c;
        if (r111 != null) goto L35;
        return null;
    L35:
        return r111.slice();
    L36:
        KmpEnv r112 = KmpEnv.f255139a;
        com.bytedance.live.kmp.core.b.a();
        goto L37
    L11:
        if (r102.capacity() >= (r101 + 64)) goto L13;
    L37:
        return null;
    }
}
