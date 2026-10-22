package com.suite.lark.platform.feature.forward.doubao;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.image.api.SimpleTarget;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e0 extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardDoubaoActivity f461334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f461335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Float f461336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f461337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f461338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f461339f;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        ForwardDoubaoActivity r101 = this.f461334a;
        String r102 = this.f461335b;
        Intrinsics.checkNotNull(r102);
        Float r103 = this.f461336c;
        String r104 = this.f461337d;
        Function1<String, Unit> r105 = this.f461338e;
        boolean r106 = this.f461339f;
        int r107 = ForwardDoubaoActivity.f461251p;
        r101.D1(r102, r100, r103, r104, r105, r106);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        ForwardDoubaoActivity r102 = this.f461334a;
        String r103 = this.f461335b;
        Intrinsics.checkNotNull(r103);
        Float r104 = this.f461336c;
        String r105 = this.f461337d;
        Function1<String, Unit> r106 = this.f461338e;
        boolean r107 = this.f461339f;
        int r108 = ForwardDoubaoActivity.f461251p;
        r102.D1(r103, r101, r104, r105, r106, r107);
    }

    public e0(ForwardDoubaoActivity r100, String r101, String r102, Function1 r103, boolean r104) {
        this.f461334a = r100;
        this.f461335b = r101;
        this.f461336c = null;
        this.f461337d = r102;
        this.f461338e = r103;
        this.f461339f = r104;
    }
}
