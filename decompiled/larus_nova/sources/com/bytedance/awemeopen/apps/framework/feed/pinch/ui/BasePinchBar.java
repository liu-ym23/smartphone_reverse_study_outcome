package com.bytedance.awemeopen.apps.framework.feed.pinch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/BasePinchBar;", "Landroid/widget/FrameLayout;", "", "getLayoutResId", "getPlayPauseViewVisibility", "Landroid/view/View;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "mRootView", "Lr14/c;", "b", "Lr14/c;", "getMAweme", "()Lr14/c;", "setMAweme", "(Lr14/c;)V", "mAweme", "", "c", "Ljava/lang/String;", "getMEventType", "()Ljava/lang/String;", "setMEventType", "(Ljava/lang/String;)V", "mEventType", "Lsz3/c;", "d", "Lsz3/c;", "getMPinchParams", "()Lsz3/c;", "setMPinchParams", "(Lsz3/c;)V", "mPinchParams", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class BasePinchBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f195771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r14.c f195772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f195773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public sz3.c f195774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PinchPlayPauseView f195775e;

    public int getLayoutResId() {
        return R.layout.familiar_view_video_pinch_bar;
    }

    public final int getPlayPauseViewVisibility() {
        return this.f195775e.getVisibility();
    }

    public final r14.c getMAweme() {
        return this.f195772b;
    }

    public final String getMEventType() {
        return this.f195773c;
    }

    public final sz3.c getMPinchParams() {
        return this.f195774d;
    }

    public final View getMRootView() {
        return this.f195771a;
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        PinchPlayPauseView r101 = this.f195775e;
        r101.setImageResource(r101.f195779b);
        return;
    L4:
        PinchPlayPauseView r102 = this.f195775e;
        int r103 = PinchPlayPauseView.f195777d;
        r102.l(R.color.ConstTextInverse);
    }

    public final void setMAweme(r14.c r100) {
        this.f195772b = r100;
    }

    public final void setMEventType(String r100) {
        this.f195773c = r100;
    }

    public final void setMPinchParams(sz3.c r100) {
        this.f195774d = r100;
    }

    public BasePinchBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        View r103 = FrameLayout.inflate(r100, getLayoutResId(), this);
        this.f195771a = r103;
        this.f195775e = (PinchPlayPauseView) r103.findViewById(R.id.play_view);
    }
}
