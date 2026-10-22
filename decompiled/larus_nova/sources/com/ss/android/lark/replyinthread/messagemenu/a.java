package com.ss.android.lark.replyinthread.messagemenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.c;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import yya.i;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements i {
    @Override // yya.i
    public final Map<String, Object> R4() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "reply"), TuplesKt.to(PickerReporterConstants.KEY.TARGET, "none")});
    }

    @Override // yya.i
    public final boolean c() {
        return false;
    }

    @Override // yya.i
    public final Integer e() {
        return null;
    }

    @Override // yya.i
    public final boolean f() {
        return false;
    }

    @Override // yya.i
    public final d g() {
        return null;
    }

    @Override // yya.i
    public final boolean isEnable() {
        return true;
    }

    @Override // yya.i
    public final void onHide() {
    }

    @Override // yya.i
    public final void onShow() {
    }

    @Override // yya.i
    public MessageActionType getType() {
        return MessageActionType.REPLY;
    }

    @Override // yya.i
    public final boolean isVisible() {
        throw null;
    }

    @Override // yya.i
    public final void d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "actionControl");
    }

    @Override // yya.i
    public final Drawable getIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = d6b.a.f467214a;
        return UDIconUtils.getIconDrawable(r100, R.drawable.ud_icon_reply_cn_outlined, UDColorUtils.getColor(r100, R.color.chat_operation_item_color_selector));
    }

    @Override // yya.i
    public final String getLabel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return UIHelper.getString(R.string.Lark_Legacy_ReplyNow);
    }

    @Override // yya.i
    public final View getView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    @Override // yya.i
    public final void b(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r101 == true) goto L6;
        return;
    L6:
        throw null;
    }
}
