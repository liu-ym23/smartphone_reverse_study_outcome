package com.ss.android.lark.audio.voiceinput.processor;

import java.nio.ByteBuffer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {
    public static void a(int r100, Function1 r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r101, "producer");
        Intrinsics.checkNotNullParameter(r102, "consumer");
        int r103 = (int) Math.ceil((((double) r100) * 1.0d) / ((double) 1048576));
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L12;
        if (r103 > 1) goto L7;
        int r105 = r100;
    L11:
        r102.invoke((ByteBuffer) r101.invoke(ByteBuffer.allocate(r105)));
        r104 = r104 + 1;
        goto L3
    L7:
        if (r104 != (r103 - 1)) goto L9;
        r105 = r100 - (r104 * 1048576);
        goto L11
    L9:
        r105 = 1048576;
        goto L11
    }
}
