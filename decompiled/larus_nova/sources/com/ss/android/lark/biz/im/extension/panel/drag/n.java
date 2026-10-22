package com.ss.android.lark.biz.im.extension.panel.drag;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f410552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f410553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f410554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f410555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f410556e;

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.m
    public final int a() {
        return this.f410555d;
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.m
    public final float b() {
        return this.f410554c;
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.m
    public final a c() {
        return this.f410552a;
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.m
    public final float d() {
        return this.f410553b;
    }

    public n(h r100) {
        Intrinsics.checkNotNullParameter(r100, "endHeight");
        this.f410552a = r100;
        this.f410553b = 0.0f;
        this.f410554c = 1.0f;
        this.f410555d = R.color.bg_mask;
        this.f410556e = true;
    }
}
