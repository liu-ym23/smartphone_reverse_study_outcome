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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface t {
    void K2(String r1, String r2, String r3, RichText r4, Message.PartialReplyInfo r5);

    void O(List r1, AssociatedPreviewService$requestUrlPreview$1.AnonymousClass1.AnonymousClass2 r2);

    boolean Qc();

    void V0(Context r1, DocShareTextData r2);

    Map<String, Chatter> a0(List<String> r1);

    void a6(String r1, String r2, RichText r3, IGetDataCallback r4);

    void aa(Context r1, DocImagesForwardData r2);

    void bd(Context r1, DocShareTextData r2, int r3);

    void getTranslateLanguages(IGetDataCallback<TranslateLanguageSetting> r1);

    boolean isDocSmartComposeEnabled();

    Map<String, Chatter> l0(List<String> r1);

    void m7(Context r1, String r2);

    void n(Context r1, String r2);

    void n3(FragmentActivity r1, ForwardTemplate r2);

    void sendMessage(j1 r1, IGetDataCallback<String> r2);
}
