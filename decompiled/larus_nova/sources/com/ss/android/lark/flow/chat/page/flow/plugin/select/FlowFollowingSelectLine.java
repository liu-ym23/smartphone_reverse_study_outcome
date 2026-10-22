package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/flow/plugin/select/FlowFollowingSelectLine;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTipTextView", "Landroid/widget/TextView;", "mExceedLimitDialog", "Landroid/app/Dialog;", "selectLimit", "getSelectLimit", "()I", "setSelectLimit", "(I)V", "value", "currentSelectCount", "getCurrentSelectCount", "setCurrentSelectCount", "selectTipClickListener", "Landroid/view/View$OnClickListener;", "getSelectTipClickListener", "()Landroid/view/View$OnClickListener;", "setSelectTipClickListener", "(Landroid/view/View$OnClickListener;)V", "initViews", "", "setupTextTip", "showSelectCountLimitExceededDialog", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowFollowingSelectLine extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f422800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LKUIDialog f422801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f422802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f422803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View.OnClickListener f422804e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowFollowingSelectLine f422805a;

        public b(FlowFollowingSelectLine r100) {
            this.f422805a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f422805a.getSelectTipClickListener();
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    static {
    }

    public final void a() {
        int r100 = UIHelper.dp2px(12.0f);
        setPaddingRelative(r100, 0, r100, 0);
        TextView r101 = new TextView(getContext());
        r101.setTextSize(14.0f);
        r101.setTextColor(v2c.a.b(r101.getContext(), R.color.flow_ud_neutral_100));
        r101.setBackgroundResource(R.drawable.bg_flow_multi_select_line);
        r101.setCompoundDrawablePadding(UIHelper.dp2px(4.0f));
        int r102 = UIHelper.dp2px(14.0f);
        Drawable r103 = AppCompatResources.getDrawable(r101.getContext(), R.drawable.flow_ud_ic_arrow_down_tail_outlined);
        TextView r104 = null;
        if (r103 == null) goto L7;
        Drawable r105 = r103.mutate();
        if (r105 == null) goto L7;
        r105.setBounds(0, 0, r102, r102);
    L8:
        r101.setCompoundDrawablesRelative(r105, null, null, null);
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        r106.gravity = 16;
        r106.setMarginStart(UIHelper.dp2px(34.0f));
        r101.setLayoutParams(r106);
        r101.setGravity(16);
        int r107 = UIHelper.dp2px(14.0f);
        int r108 = UIHelper.dp2px(8.0f);
        r101.setPaddingRelative(r107, r108, r107, r108);
        r101.setOnClickListener(new b(this));
        this.f422800a = r101;
        addView(r101);
        TextView r109 = this.f422800a;
        if (r109 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mTipTextView");
    L12:
        r104.setText(R.string.LarkIM_Msg_SelectToHere_Button);
        return;
    L11:
        r104 = r109;
    L7:
        r105 = null;
        goto L8
    }

    public final int getCurrentSelectCount() {
        return this.f422803d;
    }

    public final int getSelectLimit() {
        return this.f422802c;
    }

    public final View.OnClickListener getSelectTipClickListener() {
        return this.f422804e;
    }

    public FlowFollowingSelectLine(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a();
    }

    public final void setCurrentSelectCount(int r100) {
        if (this.f422803d != r100) goto L5;
        return;
    L5:
        if (r100 < this.f422802c) goto L23;
        boolean r101 = true;
        if (this.f422801b != null) goto L9;
        com.larksuite.component.ui.dialog.d r102 = new com.larksuite.component.ui.dialog.d(getContext());
        r102.f284132c.message(R.string.LarkIM_Msg_MaxSelect100Msgs_Toast);
        r102.f284132c.titleLineCount(3);
        r102.a(R.id.lkui_dialog_btn_right, R.string.Lark_Legacy_IKnow, FlowFollowingSelectLine$showSelectCountLimitExceededDialog$1.f422806a);
        r102.f284132c.cancelable(true);
        this.f422801b = r102.c();
    L9:
        LKUIDialog r103 = this.f422801b;
        if (r103 != null) goto L12;
    L14:
        r101 = false;
    L15:
        if (r101 == false) goto L23;
        LKUIDialog r104 = this.f422801b;
        if (r104 == null) goto L23;
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r104);
        goto L23
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L22:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        goto L23
    L12:
        if (r103.isShowing() == true) goto L14;
    L23:
        this.f422803d = r100;
    }

    public final void setSelectLimit(int r100) {
        this.f422802c = r100;
    }

    public final void setSelectTipClickListener(View.OnClickListener r100) {
        this.f422804e = r100;
    }

    public FlowFollowingSelectLine(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        a();
    }

    public FlowFollowingSelectLine(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        a();
    }
}
