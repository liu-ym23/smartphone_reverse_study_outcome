package com.bytedance.ee.bear.basesdk.business.comment;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.storage.LarkKVStorage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "commentId", "", "commentType", "", "replyId", "index", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BaseCommentPlugin$init$8 extends Lambda implements Function4<String, Integer, String, Integer, Unit> {
    final /* synthetic */ a this$0;

    public BaseCommentPlugin$init$8(a r100) {
        this.this$0 = r100;
        super(4);
    }

    public final void invoke(String r100, int r101, String r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r102, "replyId");
        TranslateLanguageSetting r103 = (TranslateLanguageSetting) LarkKVStorage.p(new com.ss.android.lark.storage.a(ChameleonResConstants.CCM_ROOT_DIR), "translate", true).getJSONObject("config", TranslateLanguageSetting.class);
        JSONObject r104 = new JSONObject();
        r104.put("commentId", r100);
        r104.put("commentType", Integer.valueOf(r101));
        r104.put("replyId", r102);
        r104.put("index", Integer.valueOf(r110));
        if (r103 == null) goto L6;
        String r105 = r103.getTargetLanguageKey();
        if (r105 == null) goto L6;
    L7:
        r104.put("targetLanguage", r105);
        r104.put("action", "translate");
        a r106 = this.this$0;
        int r107 = a.f206587a;
        r106.getClass();
        return;
    L6:
        r105 = "";
        goto L7
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Integer r101, String r102, Integer r103) {
        invoke(r100, r101.intValue(), r102, r103.intValue());
        return Unit.INSTANCE;
    }
}
