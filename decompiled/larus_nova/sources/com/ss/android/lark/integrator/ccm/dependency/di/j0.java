package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService$requestUrlPreview$1;
import com.bytedance.ee.bear.dto.DocImagesForwardData;
import com.bytedance.ee.bear.dto.DocShareTextData;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j0 extends c0c.b implements com.bytedance.ee.bear.lark.dependency.t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.lark.dependency.t f427854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f427855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.lark.dependency.t> f427856d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void K2(String r100, String r101, String r102, RichText r110, Message.PartialReplyInfo r111) {
        this.f427854b.K2(r100, r101, r102, r110, r111);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void O(List r100, AssociatedPreviewService$requestUrlPreview$1.AnonymousClass1.AnonymousClass2 r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        this.f427854b.O(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final boolean Qc() {
        return this.f427854b.Qc();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void V0(Context r100, DocShareTextData r101) {
        this.f427854b.V0(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final Map<String, Chatter> a0(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return this.f427854b.a0(r100);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void a6(String r100, String r101, RichText r102, IGetDataCallback r103) {
        this.f427854b.a6(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void aa(Context r100, DocImagesForwardData r101) {
        this.f427854b.aa(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void bd(Context r100, DocShareTextData r101, int r102) {
        this.f427854b.bd(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void getTranslateLanguages(IGetDataCallback<TranslateLanguageSetting> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        this.f427854b.getTranslateLanguages(r100);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final boolean isDocSmartComposeEnabled() {
        return this.f427854b.isDocSmartComposeEnabled();
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final Map<String, Chatter> l0(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        return this.f427854b.l0(r100);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void m7(Context r100, String r101) {
        this.f427854b.m7(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void n(Context r100, String r101) {
        this.f427854b.n(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void n3(FragmentActivity r100, ForwardTemplate r101) {
        this.f427854b.n3(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void sendMessage(com.ss.android.lark.biz.im.api.j1 r100, IGetDataCallback<String> r101) {
        this.f427854b.sendMessage(r100, r101);
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("MessagingDependencyProxy", MapMonitorConst.EVENT_DESTROY);
        Intrinsics.checkNotNullParameter(r100, "toState");
    }

    public j0(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.lark.dependency.t> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), com.bytedance.ee.bear.lark.dependency.t.class), com.bytedance.ee.bear.lark.dependency.t.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f427854b = r103.b();
        this.f427855c = r101;
        this.f427856d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        tt5.a.h("MessagingDependencyProxy", "preparing");
        com.ss.android.lark.passportc.internal.v r102 = this.f427855c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        com.bytedance.ee.bear.lark.dependency.t r104 = (com.bytedance.ee.bear.lark.dependency.t) e0c.k.b(r102.c(r103), com.bytedance.ee.bear.lark.dependency.t.class);
        this.f427856d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
