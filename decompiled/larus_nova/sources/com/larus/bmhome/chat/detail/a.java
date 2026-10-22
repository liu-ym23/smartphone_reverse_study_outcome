package com.larus.bmhome.chat.detail;

import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.z;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Message f302702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f302703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f302704c;

    @Override // com.larus.bmhome.chat.detail.i
    public final void v() {
    }

    @Override // com.larus.bmhome.chat.detail.i
    public final String c() {
        Message r100 = this.f302702a;
        if (r100 == null) goto L7;
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L7;
        return r101.get("deep_research_id");
    L7:
        return null;
    }

    public a() {
        this.f302703b = "";
        this.f302704c = "";
    }

    @Override // com.larus.bmhome.chat.detail.i
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f302704c = r100;
    }

    @Override // com.larus.bmhome.chat.detail.i
    public final void j(Message r100) {
        this.f302702a = r100;
    }

    @Override // com.larus.bmhome.chat.detail.i
    public final void setConversationId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f302703b = r100;
    }

    @Override // com.larus.bmhome.chat.detail.i
    public final void d(by7.e r210, BotModel r211, String r212, long r213, CustomMarkdownTextView r214, String r215, int r310, boolean r311, String r312, AbstractCommonDetailFragment.c r313) {
        Intrinsics.checkNotNullParameter(r215, "clickFrom");
        z r100 = ILegacyChatUiServiceDelegate.f297164b.F8();
        if (r100 == null) goto L6;
        z.a.a(r100, r210, r211, r212, r213, r214, this.f302702a, r215, null, null, false, r310, r311, r312, r313, true, null, null, null, 492416);
        return;
    }
}
