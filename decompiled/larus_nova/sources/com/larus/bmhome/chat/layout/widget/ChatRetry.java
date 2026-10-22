package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.larus.chat.common.databinding.LarusWidgetChatRetryBinding;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ChatRetry;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/chat/layout/widget/IChatRetry;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusWidgetChatRetryBinding;", "init", "", "value", "", "retryAlreadyShow", "getRetryAlreadyShow", "()Z", "hide", "showRetry", "onRetry", "Landroid/view/View$OnClickListener;", "showUserBreak", "onUserBreak", "showProgress", "changeImgSrc", "resource", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatRetry extends FrameLayout implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusWidgetChatRetryBinding f304777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f304778b;

    public static final class a {
    }

    static {
    }

    public final void b() {
        LarusWidgetChatRetryBinding r100 = this.f304777a;
        if (r100 == null) goto L7;
        ImageView r101 = r100.f324083c;
        if (r101 == null) goto L7;
        r101.setVisibility(8);
    L7:
        LarusWidgetChatRetryBinding r102 = this.f304777a;
        if (r102 == null) goto L12;
        ProgressBar r103 = r102.f324082b;
        if (r103 == null) goto L12;
        r103.setVisibility(8);
    L12:
        setVisibility(8);
        this.f304778b = false;
    }

    public boolean getRetryAlreadyShow() {
        return this.f304778b;
    }

    public ChatRetry(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        c(r100);
    }

    public final void a(int r100) {
        LarusWidgetChatRetryBinding r101 = this.f304777a;
        if (r101 == null) goto L8;
        ImageView r102 = r101.f324083c;
        if (r102 == null) goto L9;
        r102.setImageResource(r100);
        return;
    L9:
        return;
    }

    public final void c(Context r100) {
        this.f304777a = LarusWidgetChatRetryBinding.a(LayoutInflater.from(r100), this);     // Catch: Throwable -> L4
    L6:
        b();
        return;
    L4:
        th = move-exception;
        FLogger.f375446a.e("ChatRetry", "inflate err. msg=" + th.getMessage());
        goto L6
    }

    public final void d(View.OnClickListener r100) {
        LarusWidgetChatRetryBinding r101 = this.f304777a;
        if (r101 == null) goto L7;
        ProgressBar r102 = r101.f324082b;
        if (r102 == null) goto L7;
        r102.setVisibility(8);
    L7:
        LarusWidgetChatRetryBinding r103 = this.f304777a;
        if (r103 == null) goto L12;
        ImageView r104 = r103.f324083c;
        if (r104 == null) goto L12;
        r104.setVisibility(0);
    L12:
        setVisibility(0);
        LarusWidgetChatRetryBinding r105 = this.f304777a;
        if (r105 == null) goto L17;
        ImageView r106 = r105.f324083c;
        if (r106 == null) goto L17;
        r106.setOnClickListener(r100);
    L17:
        this.f304778b = true;
    }

    public final void e(View.OnClickListener r100) {
        LarusWidgetChatRetryBinding r101 = this.f304777a;
        if (r101 == null) goto L7;
        ProgressBar r102 = r101.f324082b;
        if (r102 == null) goto L7;
        r102.setVisibility(8);
    L7:
        LarusWidgetChatRetryBinding r103 = this.f304777a;
        if (r103 == null) goto L12;
        ImageView r104 = r103.f324083c;
        if (r104 == null) goto L12;
        r104.setVisibility(0);
    L12:
        setVisibility(0);
        LarusWidgetChatRetryBinding r105 = this.f304777a;
        if (r105 == null) goto L18;
        ImageView r106 = r105.f324083c;
        if (r106 == null) goto L19;
        r106.setOnClickListener(r100);
        return;
    L19:
        return;
    }

    public ChatRetry(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        c(r100);
    }

    public ChatRetry(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        c(r100);
    }
}
