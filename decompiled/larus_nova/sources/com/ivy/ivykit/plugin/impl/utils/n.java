package com.ivy.ivykit.plugin.impl.utils;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class n extends com.bytedance.ies.bullet.service.base.a {

    public static final class a implements com.bytedance.ies.bullet.service.base.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qx7.b f278444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f278445b;

        @Override // com.bytedance.ies.bullet.service.base.i
        public final void hide() {
            a(null, null).setVisibility(8);
        }

        @Override // com.bytedance.ies.bullet.service.base.i
        public final void show() {
            a(null, null).setVisibility(0);
        }

        public a(qx7.b r100, Context r101) {
            this.f278444a = r100;
            this.f278445b = r101;
        }

        @Override // com.bytedance.ies.bullet.service.base.i
        public final View a(Function0<Unit> r100, Function0<Unit> r101) {
            return this.f278444a.a(this.f278445b, r101);
        }
    }

    public static final class b implements com.bytedance.ies.bullet.service.base.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qx7.b f278446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f278447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f278448c;

        @Override // com.bytedance.ies.bullet.service.base.q
        public final View getView() {
            return this.f278446a.b(this.f278447b, this.f278448c);
        }

        @Override // com.bytedance.ies.bullet.service.base.q
        public final void hide() {
            getView().setVisibility(8);
        }

        @Override // com.bytedance.ies.bullet.service.base.q
        public final void show() {
            getView().setVisibility(0);
        }

        public b(qx7.b r100, Context r101, String r102) {
            this.f278446a = r100;
            this.f278447b = r101;
            this.f278448c = r102;
        }
    }

    public n() {
    }

    @Override // com.bytedance.ies.bullet.service.base.a, com.bytedance.ies.bullet.service.base.p0
    public final FrameLayout.LayoutParams B0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.bytedance.ies.bullet.service.base.a, com.bytedance.ies.bullet.service.base.p0
    public final FrameLayout.LayoutParams c0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return new FrameLayout.LayoutParams(-1, -1);
    }

    @Override // com.bytedance.ies.bullet.service.base.a, com.bytedance.ies.bullet.service.base.p0
    public final com.bytedance.ies.bullet.service.base.q b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        String r102 = mx7.c.f516265a;
        qx7.b r103 = mx7.c.f516287w;
        if (r103 != null) goto L7;
        return null;
    L7:
        return new b(r103, r100, r101);
    }

    @Override // com.bytedance.ies.bullet.service.base.a, com.bytedance.ies.bullet.service.base.p0
    public final com.bytedance.ies.bullet.service.base.i n(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        String r102 = mx7.c.f516265a;
        qx7.b r103 = mx7.c.f516287w;
        if (r103 != null) goto L7;
        return null;
    L7:
        return new a(r103, r100);
    }
}
