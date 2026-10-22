package wgb;

import android.content.Context;
import android.view.ViewGroup;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f<T> extends com.ss.android.lark.chatwindow.view.tip.c<T> {
    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final int c() {
        return this.f417113g - this.f417114h;
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final String d() {
        return ICUUtils.icuFormat(UIUtils.getQuantityString(this.f417104c, R.plurals.LarkIM_Msg_NumNew_Button, this.f417113g - this.f417114h), "num", Long.valueOf(this.f417113g - this.f417114h));
    }

    public final void k(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutParams");
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
    L6:
        if (r101 == null) goto L9;
        r101.topMargin = UIHelper.dp2px(8.0f) + this.f417103b.j();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public f(Context r100, r7b.c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataStrategy");
        super(r100, r101);
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final String a(Message r100, String r101) {
        String r102 = super.a(r100, r101);
        if (r100.getType() == Message.Type.DOUBAO) goto L18;
        boolean r103 = false;
        if (r100.isAtAll() != true) goto L8;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        return ICUUtils.icuFormat(UIUtils.getString(this.f417104c, R.string.LarkIM_Msg_NameMentionedAll_Button), "name", r101);
    L13:
        if (r100.isOtherAtMe() != true) goto L15;
        r103 = true;
    L15:
        if (r103 == true) goto L17;
        return r102;
    L17:
        return ICUUtils.icuFormat(UIUtils.getString(this.f417104c, R.string.LarkIM_Msg_NameMentionedYou_Button), "name", r101);
    L8:
        r104 = false;
        goto L10
    L18:
        return ICUUtils.icuFormat(UIUtils.getString(this.f417104c, R.string.LarkIM_Group_ReplyFromDoubao_Toast), "brandName", r101);
    }
}
