package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.chat.common.databinding.LarusWidgetChatRetryWithTextBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u000bH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ChatRetryWithText;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/layout/widget/IChatRetry;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusWidgetChatRetryWithTextBinding;", "init", "", "cinit", "value", "", "retryAlreadyShow", "getRetryAlreadyShow", "()Z", "hide", "showRetry", "onRetry", "Landroid/view/View$OnClickListener;", "showUserBreak", "onUserBreak", "showProgress", "changeImgSrc", "resource", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatRetryWithText extends FrameLayout implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusWidgetChatRetryWithTextBinding f304779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f304780b;

    public final void a() {
        LarusWidgetChatRetryWithTextBinding r100 = this.f304779a;
        LarusWidgetChatRetryWithTextBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        r100.f324086c.setVisibility(8);
        LarusWidgetChatRetryWithTextBinding r102 = this.f304779a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L8:
        r102.f324087d.setVisibility(8);
        LarusWidgetChatRetryWithTextBinding r103 = this.f304779a;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        r101.f324085b.setVisibility(8);
        setVisibility(8);
        this.f304780b = false;
        return;
    L11:
        r101 = r103;
        goto L12
    }

    public boolean getRetryAlreadyShow() {
        return this.f304780b;
    }

    public ChatRetryWithText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        b(r100);
    }

    public final void b(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.larus_widget_chat_retry_with_text, this);
        int r101 = R.id.progress;
        ProgressBar r102 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.progress);
        if (r102 == null) goto L11;
        r101 = R.id.retry;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(this, R.id.retry);
        if (r103 == null) goto L11;
        r101 = R.id.retry_text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.retry_text);
        if (r104 == null) goto L11;
        this.f304779a = new LarusWidgetChatRetryWithTextBinding(this, r102, r103, r104);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r101)));
    }

    public final void c(View.OnClickListener r100) {
        LarusWidgetChatRetryWithTextBinding r101 = this.f304779a;
        LarusWidgetChatRetryWithTextBinding r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L5:
        r101.f324085b.setVisibility(8);
        LarusWidgetChatRetryWithTextBinding r103 = this.f304779a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L8:
        r103.f324086c.setVisibility(0);
        LarusWidgetChatRetryWithTextBinding r104 = this.f304779a;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L11:
        r104.f324087d.setVisibility(0);
        setVisibility(0);
        LarusWidgetChatRetryWithTextBinding r105 = this.f304779a;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r102.f324084a.setOnClickListener(r100);
        this.f304780b = true;
        return;
    L14:
        r102 = r105;
        goto L15
    }

    public ChatRetryWithText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        b(r100);
    }

    public ChatRetryWithText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        b(r100);
    }
}
