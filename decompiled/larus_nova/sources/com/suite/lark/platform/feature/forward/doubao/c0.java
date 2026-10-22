package com.suite.lark.platform.feature.forward.doubao;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes36.dex */
public final class c0 extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardDoubaoActivity f461319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f461320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Float f461321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f461322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f461323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f461324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Drawable f461325g;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        ForwardDoubaoActivity r101 = this.f461319a;
        String r102 = this.f461320b;
        if (r100 != null) goto L5;
        r100 = this.f461325g;
    L5:
        Drawable r103 = r100;
        Float r104 = this.f461321c;
        String r105 = this.f461322d;
        Function1<String, Unit> r106 = this.f461323e;
        boolean r107 = this.f461324f;
        int r108 = ForwardDoubaoActivity.f461251p;
        r101.D1(r102, r103, r104, r105, r106, r107);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        ForwardDoubaoActivity r102 = this.f461319a;
        String r103 = this.f461320b;
        Float r104 = this.f461321c;
        String r105 = this.f461322d;
        Function1<String, Unit> r106 = this.f461323e;
        boolean r107 = this.f461324f;
        int r108 = ForwardDoubaoActivity.f461251p;
        r102.D1(r103, r101, r104, r105, r106, r107);
    }

    public c0(ForwardDoubaoActivity r100, String r101, String r102, Function1 r103, boolean r104, Drawable r105) {
        this.f461319a = r100;
        this.f461320b = r101;
        this.f461321c = null;
        this.f461322d = r102;
        this.f461323e = r103;
        this.f461324f = r104;
        this.f461325g = r105;
    }
}
