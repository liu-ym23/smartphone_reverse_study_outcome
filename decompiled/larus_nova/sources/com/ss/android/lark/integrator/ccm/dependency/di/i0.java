package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService$requestUrlPreview$1;
import com.bytedance.ee.bear.dto.DocImagesForwardData;
import com.bytedance.ee.bear.dto.DocShareTextData;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.integrator.ccm.dependency.forward.CCMForward;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes36.dex */
@UserScope
public class i0 implements com.bytedance.ee.bear.lark.dependency.t {
    @Override // com.bytedance.ee.bear.lark.dependency.t
    public boolean Qc() {
        return true;
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final boolean isDocSmartComposeEnabled() {
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).isDocSmartComposeEnabled();
    }

    @Inject
    public i0() {
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final Map<String, Chatter> a0(List<String> r100) {
        return ((com.ss.android.lark.im.sdk.service.h) LarkContext.spiByDwarf(com.ss.android.lark.im.sdk.service.h.class)).a0(r100);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void getTranslateLanguages(IGetDataCallback<TranslateLanguageSetting> r100) {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).getTranslateLanguages(r100);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final Map<String, Chatter> l0(List<String> r100) {
        return ((com.ss.android.lark.im.sdk.service.h) LarkContext.spiByDwarf(com.ss.android.lark.im.sdk.service.h.class)).l0(r100);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void O(List r100, AssociatedPreviewService$requestUrlPreview$1.AnonymousClass1.AnonymousClass2 r101) {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).chatPreviewApi().O(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public void V0(Context r100, DocShareTextData r101) {
        bd(r100, r101, -1);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public void aa(Context r100, DocImagesForwardData r101) {
        CCMForward.a(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void m7(Context r100, String r101) {
        IIMApi r102 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r102 == null) goto L5;
        com.ss.android.lark.biz.im.api.l1.a r103 = new com.ss.android.lark.biz.im.api.l1.a();
        r103.f410298e = r101;
        r102.openReplyInThread(r100, r103.a());
        return;
    L5:
        tt5.a.d("MessagingDependencyImpl", "openReplyInThread()... imApi is null!");
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void n(Context r100, String r101) {
        IIMApi r102 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        ChatBundle.a r103 = new ChatBundle.a();
        r103.f409934a = r101;
        r103.f409939f = 67108864;
        r102.openChat(r100, new ChatBundle(r103));
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public void n3(FragmentActivity r100, ForwardTemplate r101) {
        com.ss.android.lark.forwardv2.e.c(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void sendMessage(com.ss.android.lark.biz.im.api.j1 r100, IGetDataCallback<String> r101) {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).sendMessage(r100, r101);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public void bd(Context r100, DocShareTextData r101, int r102) {
        CCMForward.b(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void a6(String r100, String r101, RichText r102, IGetDataCallback r103) {
        IIMApi r104 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        kya.a.C6633a r105 = new kya.a.C6633a();
        r105.f415271c = r100;
        r105.D = true;
        r105.A = r101;
        r105.B = r102;
        r104.sendMessage(r105.b(), r103);
    }

    @Override // com.bytedance.ee.bear.lark.dependency.t
    public final void K2(String r100, String r101, String r102, RichText r103, Message.PartialReplyInfo r104) {
        IIMApi r105 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        com.ss.android.lark.biz.im.api.j1.a r106 = new com.ss.android.lark.biz.im.api.j1.a();
        r106.f415271c = r100;
        r106.f415269a = r101;
        r106.f415270b = r102;
        r106.f415287s = r104;
        r106.A = r103;
        r105.sendMessage(r106.b());
    }
}
