package com.ss.android.lark.chatbase.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0006\u0010\u0017\u001a\u00020\u0000J\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chatbase/view/ChatMessageEditStatusView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "iconWrapper", "Landroid/view/ViewGroup;", "ivEditStatusFailed", "Landroid/widget/ImageView;", "progressEditLoading", "Landroid/widget/ProgressBar;", "tvEditStatus", "Landroid/widget/TextView;", "showLoadFailed", "retryHandler", "Lkotlin/Function0;", "", DyPayConstant.KEY_SHOW_LOADING, "setSize", "iconSizePx", "textSizePx", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatMessageEditStatusView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f416904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f416905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f416906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f416907d;

    public ChatMessageEditStatusView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public ChatMessageEditStatusView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public ChatMessageEditStatusView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final void b() {
        TextView r100 = this.f416907d;
        SpannableStringBuilder r101 = new SpannableStringBuilder();
        ForegroundColorSpan r102 = new ForegroundColorSpan(UIUtils.getColor(getContext(), R.color.text_link_normal));
        int r103 = r101.length();
        r101.append(getContext().getString(R.string.Lark_IM_EditMessage_MessageUpdating_Text));
        r101.setSpan(r102, r103, r101.length(), 17);
        r100.setText(new SpannedString(r101));
        this.f416905b.setVisibility(8);
        this.f416906c.setVisibility(0);
    }

    public final void a(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "retryHandler");
        TextView r101 = this.f416907d;
        SpannableStringBuilder r102 = new SpannableStringBuilder();
        ForegroundColorSpan r103 = new ForegroundColorSpan(UIUtils.getColor(getContext(), R.color.function_danger_fill_default));
        int r104 = r102.length();
        r102.append(getContext().getString(R.string.Lark_IM_EditMessage_MessageUpdateFailed_Text));
        r102.setSpan(r103, r104, r102.length(), 17);
        r102.setSpan(new c(r100), 0, r102.length(), 33);
        r101.setText(new SpannedString(r102));
        this.f416905b.setVisibility(0);
        this.f416906c.setVisibility(8);
    }

    public ChatMessageEditStatusView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        LayoutInflater.from(r100).inflate(R.layout.chat_window_msg_editstatus_view, this, true);
        this.f416904a = (ViewGroup) findViewById(R.id.msg_edit_status_icon_wrapper);
        ImageView r104 = (ImageView) findViewById(R.id.iv_msg_edit_status_failed);
        this.f416905b = r104;
        ProgressBar r105 = (ProgressBar) findViewById(R.id.progressbar_msg_edit_status);
        this.f416906c = r105;
        TextView r106 = (TextView) findViewById(R.id.tv_msg_edit_status);
        this.f416907d = r106;
        r106.setMovementMethod(LinkMovementMethod.getInstance());
        r106.setHighlightColor(0);
        zz7.a.a(r104, 14);
        zz7.a.a(r105, 14);
        zz7.a.c(r106, 12);
    }
}
