package com.bytedance.gkfs.io;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.ArrayIteratorsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f245213a = 0;

    static {
    }

    public static void a(PolarisFileOutputStreamWrapper r110, long r111, List r112) throws IOException {
        CharIterator r100 = ArrayIteratorsKt.iterator(q.f245249a);
    L4:
        if (r100.hasNext() == false) goto L6;
        r110.write(r100.next().charValue());
        goto L4
    L6:
        r110.write(1);
        r110.write(new byte[]{(byte) (r111 >>> 56), (byte) (r111 >>> 48), (byte) (r111 >>> 40), (byte) (r111 >>> 32), (byte) (r111 >>> 24), (byte) (r111 >>> 16), (byte) (r111 >>> 8), (byte) r111});
        int r113 = ((ArrayList) r112).size();
        r110.write(new byte[]{(byte) (r113 >>> 8), (byte) r113});
        Iterator r114 = r112.iterator();
    L8:
        if (r114.hasNext() == false) goto L17;
        f r115 = (f) r114.next();
        String r116 = r115.f245200a.f245192a;
        if (r116 == null) goto L16;
        char[] r117 = r116.toCharArray();
        int r101 = r117.length;
        int r102 = 0;
    L12:
        if (r102 >= r101) goto L14;
        r110.write(r117[r102]);
        r102 = r102 + 1;
        goto L12
    L14:
        int r118 = (int) r115.f245201b;
        r110.write(new byte[]{(byte) (r118 >>> 24), (byte) (r118 >>> 16), (byte) (r118 >>> 8), (byte) r118});
        goto L8
    L16:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
