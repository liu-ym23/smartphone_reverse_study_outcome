package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\r\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/MusicOperateView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/b;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", "a", "Ljava/lang/String;", "getRequestPage", "()Ljava/lang/String;", "setRequestPage", "(Ljava/lang/String;)V", "requestPage", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "getMusicOperateLl", "()Landroid/widget/LinearLayout;", "setMusicOperateLl", "(Landroid/widget/LinearLayout;)V", "musicOperateLl", "Lcom/bytedance/android/live/core/widget/HSImageView;", "d", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getMusicOperateIv", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "setMusicOperateIv", "(Lcom/bytedance/android/live/core/widget/HSImageView;)V", "musicOperateIv", "Landroid/view/View;", "e", "Landroid/view/View;", "getRedDot", "()Landroid/view/View;", "setRedDot", "(Landroid/view/View;)V", "redDot", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class MusicOperateView extends RelativeLayout implements b, LifecycleOwnerCompat {
    public String a;
    public final LifecycleRegistry b;
    public LinearLayout c;
    public HSImageView d;
    public View e;

    public void c(boolean r1) {
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public void onRelease() {
    }

    public final void k() {
        LinearLayout r0 = this.c;
        if (r0 == null) goto L5;
        r0.setPadding(0, 0, 0, 0);
    L5:
        View r1 = this.e;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.setCurrentState(Lifecycle.State.DESTROYED);
    }

    public Lifecycle getLifecycleCompat() {
        return this.b;
    }

    public final HSImageView getMusicOperateIv() {
        return this.d;
    }

    public final LinearLayout getMusicOperateLl() {
        return this.c;
    }

    public final View getRedDot() {
        return this.e;
    }

    public final String getRequestPage() {
        return this.a;
    }

    public void g(int r2) {
        if (r2 != 0) goto L4;
        setVisibility(0);
        return;
    L4:
        if (r2 == 8) goto L6;
        setVisibility(4);
        return;
    L6:
        setVisibility(8);
    }

    public void h(MusicOperateType r2) {
        Intrinsics.checkNotNullParameter(r2, "musicOperateType");
        UtilityKotlinExtentionsKt.f(this);
    }

    public final void setMusicOperateIv(HSImageView r1) {
        this.d = r1;
    }

    public final void setMusicOperateLl(LinearLayout r1) {
        this.c = r1;
    }

    public final void setRedDot(View r1) {
        this.e = r1;
    }

    public final void setRequestPage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public MusicOperateView(final MusicOperateType r5, Context r6) {
        Intrinsics.checkNotNullParameter(r5, "musicOperateType");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, null, 0);
        this.a = "";
        LifecycleRegistry r0 = new LifecycleRegistry(this);
        this.b = r0;
        r0.setCurrentState(Lifecycle.State.CREATED);
        ViewGroup.LayoutParams r1 = getLayoutParams();
        if (r1 == null) goto L5;
        r1.width = s1.f(42.0f);
        r1.height = s1.f(32.0f);
    L6:
        setLayoutParams(r1);
        LayoutInflater.from(r6).inflate(2131566487, this, true);
        setPadding(s1.f(10.0f), 0, 0, 0);
        this.c = (LinearLayout) findViewById(2131380509);
        this.d = findViewById(2131380508);
        this.e = findViewById(2131384095);
        k();
        setOnClickListener(x0.a(new AnonymousClass1(this, r5)));
        h(r5);
        return;
    L5:
        r1 = new ViewGroup.LayoutParams(s1.f(42.0f), s1.f(32.0f));
        goto L6
    }
}
