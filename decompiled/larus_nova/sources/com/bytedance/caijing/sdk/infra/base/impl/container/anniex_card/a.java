package com.bytedance.caijing.sdk.infra.base.impl.container.anniex_card;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import com.ss.android.lark.utils.statistics.PerfLog;
import ed4.g;
import ed4.i;
import java.util.List;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnieXLynxView f202472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ra.a f202473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f202474c;

    /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.impl.container.anniex_card.a$a, reason: collision with other inner class name */
    public final class C2925a implements com.bytedance.android.anniex.ui.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f202475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f202476b;

        @Override // com.bytedance.android.anniex.ui.e
        public final void l(q1.b r100) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void o(q1.b r100) {
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void a(TemplateBundle r100) {
            Intrinsics.checkNotNullParameter(r100, "templateBundle");
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void c(AnnieXLynxView r100) {
            i r101 = this.f202475a;
            if (r101 == null) goto L6;
            r101.onPageUpdate(this.f202476b);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void e(AnnieXLynxView r100) {
            i r101 = this.f202475a;
            if (r101 == null) goto L6;
            r101.onFirstScreen(this.f202476b);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void f(AnnieXLynxView r100) {
            i r101 = this.f202475a;
            if (r101 == null) goto L6;
            r101.onDataUpdated(this.f202476b);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void onTimingSetup(Map<String, Object> r100) {
            i r101 = this.f202475a;
            if (r101 == null) goto L6;
            r101.onTimingSetup(r100);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void p(AnnieXLynxView r100) {
            i r101 = this.f202475a;
            if (r101 == null) goto L6;
            r101.onRuntimeReady(this.f202476b);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final String shouldRedirectImageUrl(String r100) {
            i r101 = this.f202475a;
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.shouldRedirectImageUrl(r100);
        }

        public C2925a(a r100, i r101) {
            this.f202476b = r100;
            this.f202475a = r101;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void b(AnnieXLynxView r100, String r101) {
            i r102 = this.f202475a;
            if (r102 == null) goto L6;
            r102.onLoadFailed(this.f202476b, new ed4.e(null, r101));
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void d(Uri r100, AnnieXLynxView r101) {
            i r102 = this.f202475a;
            if (r102 == null) goto L6;
            r102.onLoadUriSuccess(r100, this.f202476b);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void g(AnnieXLynxView r100, LynxError r101) {
            i r102 = this.f202475a;
            if (r102 == null) goto L10;
            a r103 = this.f202476b;
            if (r101 == null) goto L7;
            r103.getClass();
            ed4.e r104 = new ed4.e(Integer.valueOf(r101.getErrorCode()), r101.getMsg());
        L8:
            r102.onReceivedError(r103, r104);
            return;
        L7:
            r104 = null;
            goto L8
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void j(AnnieXLynxView r100, JSONObject r101) {
            i r102 = this.f202475a;
            if (r102 == null) goto L6;
            r102.onUpdatePerfReady(this.f202476b, r101);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void k(AnnieXLynxView r100, String r101) {
            i r102 = this.f202475a;
            if (r102 == null) goto L6;
            r102.onPageStart(this.f202476b, r101);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void m(AnnieXLynxView r100, JSONObject r101) {
            i r102 = this.f202475a;
            if (r102 == null) goto L6;
            r102.onFirstLoadPerfReady(this.f202476b, r101);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void n(Uri r100, AnnieXLynxView r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            i r102 = this.f202475a;
            if (r102 == null) goto L6;
            r102.onLoadStart(r100, this.f202476b);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void onLoadFail(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
            i r102 = this.f202475a;
            if (r102 == null) goto L6;
            r102.onLoadFail(r100, r101, this.f202476b);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void onTemplateReady(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "resFrom");
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void q(AnnieXLynxView r100, String r101) {
            i r102 = this.f202475a;
            if (r102 == null) goto L6;
            r102.onReceivedError(this.f202476b, new ed4.e(null, r101));
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void onModuleMethodInvoked(String r100, String r101, int r102) {
            i r103 = this.f202475a;
            if (r103 == null) goto L6;
            r103.onModuleMethodInvoked(r100, r101, r102);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
            i r103 = this.f202475a;
            if (r103 == null) goto L6;
            r103.onTimingUpdate(r100, r101, r102);
            return;
        }

        @Override // com.bytedance.android.anniex.ui.e
        public final void loadImage(Context r100, String r101, String r102, float r103, float r104, Transformer r105, m.a r106) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r106, "handler");
            com.bytedance.android.anniex.ui.e.b.a(r100, r106);
        }
    }

    @Override // ed4.g
    public final String getContainerID() {
        return this.f202473b.f536749g;
    }

    @Override // ed4.g
    public final void onHide() {
        this.f202472a.F();
    }

    @Override // ed4.g
    public final void onShow() {
        this.f202472a.H();
    }

    @Override // cd4.p, com.android.ttcjpaysdk.base.framework.container.abs.IRelease
    public final void release() {
        this.f202472a.destroy();
    }

    @Override // ed4.g
    public final View getView() {
        return this.f202472a;
    }

    @Override // ed4.g
    public final void c(List<? extends cd4.m> r100) {
        this.f202472a.n(new e(r100), null);
    }

    @Override // id4.c
    public final <T extends jd4.a> T getCtx(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        m16.b r101 = (m16.b) this.f202472a.t(m16.b.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.c(r100);
    }

    @Override // ed4.g
    public final void h(i r100) {
        this.f202472a.E(this.f202473b, Long.valueOf(System.currentTimeMillis()));
        this.f202472a.A(this.f202473b, null, new C2925a(this, r100));
    }

    @Override // id4.c
    public final <T extends jd4.a> void removeCtx(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        m16.b r101 = (m16.b) this.f202472a.t(m16.b.class);
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    @Override // ed4.g
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L5;
        this.f202472a.updateGlobalProps(MapsKt.toMutableMap(r100));
        return;
    }

    @Override // ed4.g
    public final void f(ed4.b r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "cardModel");
        ra.a r102 = this.f202474c.d(r100);
        if (r102 == null) goto L6;
        this.f202473b = r102;
        AnnieXLynxView.J(this.f202472a, r102, new C2925a(this, r101), 2);
        return;
    }

    @Override // id4.c
    public final <T extends jd4.a> void putCtx(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        m16.b r102 = (m16.b) this.f202472a.t(m16.b.class);
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    @Override // ed4.g
    public final void sendEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        AnnieXLynxView r102 = this.f202472a;
        int r103 = AnnieXLynxView.B;
        r102.O(r100, r101, true);
    }

    public a(AnnieXLynxView r100, ra.a r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "annieCard");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "modelFactory");
        this.f202472a = r100;
        this.f202473b = r101;
        this.f202474c = r102;
    }
}
