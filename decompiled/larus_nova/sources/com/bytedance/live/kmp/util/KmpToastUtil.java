package com.bytedance.live.kmp.util;

import android.content.Context;
import android.os.Looper;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class KmpToastUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f255165a = 0;

    static {
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, kotlin.Unit] */
    public static void a(final String r100, final int r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return;
    L12:
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L15;
        f.a(new KmpToastUtil$centerToast$1(r100, r101));
        return;
    L15:
        Context r103 = s1.getContext();
        if (r103 != null) goto L18;
        return;
    L18:
        kjc.c r104 = new kjc.c();
        if (3 != kjc.a.a()) goto L22;
        kjc.b<T> r105 = r104.f503730a;
        ((bi6.a) vh6.c.b(bi6.a.class)).x(r100, r101);
        r105.f503729a = Unit.INSTANCE;
        r104.f503731b = true;
    L22:
        if (r104.f503731b == true) goto L24;
        kjc.b<T> r106 = r104.f503730a;
        ((bi6.a) vh6.c.b(bi6.a.class)).centerToast(r103, r100, r101);
        r106.f503729a = Unit.INSTANCE;
    L24:
        T r107 = r104.f503730a.f503729a;
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
