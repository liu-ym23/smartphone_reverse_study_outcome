package com.bytedance.awemeopen.apps.framework.feed.pinch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/BasePinchBar;", "Landroid/widget/FrameLayout;", "", "getLayoutResId", "getPlayPauseViewVisibility", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "mRootView", "Lr14/c;", "b", "Lr14/c;", "getMAweme", "()Lr14/c;", "setMAweme", "(Lr14/c;)V", "mAweme", "", "c", "Ljava/lang/String;", "getMEventType", "()Ljava/lang/String;", "setMEventType", "(Ljava/lang/String;)V", "mEventType", "Lsz3/c;", "d", "Lsz3/c;", "getMPinchParams", "()Lsz3/c;", "setMPinchParams", "(Lsz3/c;)V", "mPinchParams", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class BasePinchBar extends FrameLayout {
    public final View a;
    public r14.c b;
    public String c;
    public sz3.c d;
    public final PinchPlayPauseView e;

    public int getLayoutResId() {
        return 2131561096;
    }

    public final int getPlayPauseViewVisibility() {
        return this.e.getVisibility();
    }

    public final r14.c getMAweme() {
        return this.b;
    }

    public final String getMEventType() {
        return this.c;
    }

    public final sz3.c getMPinchParams() {
        return this.d;
    }

    public final View getMRootView() {
        return this.a;
    }

    public final void a(boolean r2) {
        if (r2 == false) goto L4;
        PinchPlayPauseView r3 = this.e;
        r3.setImageResource(r3.b);
        return;
    L4:
        PinchPlayPauseView r4 = this.e;
        int r0 = PinchPlayPauseView.d;
        r4.l(2131099796);
    }

    public final void setMAweme(r14.c r1) {
        this.b = r1;
    }

    public final void setMEventType(String r1) {
        this.c = r1;
    }

    public final void setMPinchParams(sz3.c r1) {
        this.d = r1;
    }

    public BasePinchBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        View r5 = FrameLayout.inflate(r2, getLayoutResId(), this);
        this.a = r5;
        this.e = (PinchPlayPauseView) r5.findViewById(2131382455);
    }
}
