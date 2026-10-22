package com.bytedance.live.richcontent.utils;

import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f255804a = 0;

    static {
    }

    @JvmStatic
    public static final void a(lk6.b r100, ImageStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "span");
        Intrinsics.checkNotNullParameter(r101, "style");
        int r102 = r101.f255761j;
        int r103 = r101.f255762k;
        r100.f509576a = r102;
        r100.f509577b = r103;
        int r104 = r101.f255765n;
        int r105 = r101.f255766o;
        r100.f509580e = r104;
        r100.f509581f = r105;
        r100.f509578c = r101.f255763l.getValue();
        r100.f509579d = r101.f255764m;
    }
}
