package com.ss.android.lark.audio.voiceinput.utils;

import com.ss.android.lark.log.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ByteBuffer> f409443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f409444b;

    /* JADX INFO: renamed from: com.ss.android.lark.audio.voiceinput.utils.a$a, reason: collision with other inner class name */
    public static final class C4755a {
    }

    static {
    }

    public final ByteString b() {
        if (((ArrayList) this.f409443a).isEmpty() == true) goto L5;
        ByteBuffer r100 = ByteBuffer.allocate(this.f409444b);
        Iterator r101 = ((ArrayList) this.f409443a).iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ByteBuffer r102 = (ByteBuffer) r101.next();
        r102.flip();
        r100.put(r102);
        goto L8
    L10:
        Log.d("ByteBufferAggregator", "aggregate, bufferList size is " + ((ArrayList) this.f409443a).size() + ", buffer size is " + this.f409444b);
        r100.flip();
        ByteString.a r103 = ByteString.Companion;
        Intrinsics.checkNotNull(r100);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        byte[] r104 = new byte[r100.remaining()];
        r100.get(r104);
        return new ByteString(r104);
    L5:
        return ByteString.EMPTY;
    }

    public final void c() {
        ((ArrayList) this.f409443a).clear();
        this.f409444b = 0;
    }

    public a() {
        this.f409443a = new ArrayList();
    }

    public final void a(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        int r101 = r100.limit();
        ByteBuffer r102 = ByteBuffer.allocate(r101);
        if (r100.position() == 0) goto L5;
        r100.flip();
    L5:
        r102.put(r100);
        List<ByteBuffer> r103 = this.f409443a;
        Intrinsics.checkNotNull(r102);
        ((ArrayList) r103).add(r102);
        this.f409444b += r101;
    }
}
