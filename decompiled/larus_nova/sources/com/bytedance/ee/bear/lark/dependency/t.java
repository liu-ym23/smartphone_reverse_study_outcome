package com.bytedance.ee.bear.lark.dependency;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService$requestUrlPreview$1;
import com.bytedance.ee.bear.dto.DocImagesForwardData;
import com.bytedance.ee.bear.dto.DocShareTextData;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.j1;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public interface t {
    void K2(String r100, String r101, String r102, RichText r103, Message.PartialReplyInfo r104);

    void O(List r100, AssociatedPreviewService$requestUrlPreview$1.AnonymousClass1.AnonymousClass2 r101);

    boolean Qc();

    void V0(Context r100, DocShareTextData r101);

    Map<String, Chatter> a0(List<String> r100);

    void a6(String r100, String r101, RichText r102, IGetDataCallback r103);

    void aa(Context r100, DocImagesForwardData r101);

    void bd(Context r100, DocShareTextData r101, int r102);

    void getTranslateLanguages(IGetDataCallback<TranslateLanguageSetting> r100);

    boolean isDocSmartComposeEnabled();

    Map<String, Chatter> l0(List<String> r100);

    void m7(Context r100, String r101);

    void n(Context r100, String r101);

    void n3(FragmentActivity r100, ForwardTemplate r101);

    void sendMessage(j1 r100, IGetDataCallback<String> r101);
}
