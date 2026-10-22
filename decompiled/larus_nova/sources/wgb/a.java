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
public final class a<T> extends com.ss.android.lark.chatwindow.view.tip.b<T> {

    /* JADX INFO: renamed from: wgb.a$a, reason: collision with other inner class name */
    public static final class C8111a {
    }

    static {
    }

    @Override // com.ss.android.lark.chatwindow.view.tip.a
    public final String d() {
        return ICUUtils.icuFormat(UIUtils.getQuantityString(this.f417104c, R.plurals.LarkIM_Msg_NumNew_Button, c()), "num", Long.valueOf(c()));
    }

    public final void k(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutParams");
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f417111i == false) goto L10;
        int r102 = this.f417108f + UIHelper.dp2px(10.0f);
    L11:
        r101.bottomMargin = r102;
        return;
    L10:
        r102 = UIHelper.dp2px(119.0f);
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    public a(Context r100, r7b.c r101) {
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
