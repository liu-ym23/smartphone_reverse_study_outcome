package com.bytedance.component.lyric_v2.core;

import kotlin.jvm.internal.Intrinsics;
import ng4.j;
import ng4.l;

/* JADX INFO: loaded from: classes15.dex */
public final class LyricComponentManager$parseCallback$1 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LyricComponentManager f203056a;

    public LyricComponentManager$parseCallback$1(LyricComponentManager r100) {
        this.f203056a = r100;
    }

    @Override // ng4.j
    public final void b(final l r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f203056a.f203052k.a(new Object[]{"onParseSuccess: 解析成功", r100});
        this.f203056a.f(new LyricComponentManager$parseCallback$1$onParseSuccess$1(r100));
        if (this.f203056a.e(r100) == false) goto L6;
        this.f203056a.f203052k.a(new Object[]{"onParseSuccess: 解析成功，初始化绘制节点", r100});
        LyricComponentManager r101 = this.f203056a;
        r101.f203049h.a(r100, r101.f203051j);
        this.f203056a.f(new LyricComponentManager$parseCallback$1$onParseSuccess$2(r100));
        return;
    }

    @Override // ng4.j
    public final void a(final l r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        this.f203056a.f203052k.b(new Object[]{"onParseFail: 解析失败", r100, r101});
        this.f203056a.f(new LyricComponentManager$parseCallback$1$onParseFail$1(r100, r101));
    }
}
