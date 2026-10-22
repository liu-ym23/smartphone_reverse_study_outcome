package com.bytedance.ee.bear.bitable.anniex.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\b\u0018\u00010\u000bR\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0007J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\u000bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/anniex/view/BitableLynxAnimationView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/airbnb/lottie/LottieAnimationView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "tag", "", "assetsScheme", "lottieView", "Lcom/bytedance/ee/bear/bitable/anniex/view/BitableLynxAnimationView$AnimationView;", "createView", "Landroid/content/Context;", "setLoop", "", "value", "", "setAutoplay", "autoplay", "setJson", "setLocalSrc", "srcUrl", "AnimationView", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableLynxAnimationView extends LynxUI<LottieAnimationView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f206762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f206763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimationView f206764c;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020#H\u0014J\u0018\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0010H\u0014J(\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010H\u0014J\u0006\u0010.\u001a\u00020#J\u0006\u0010/\u001a\u00020#J\u0006\u00100\u001a\u00020#J\u0006\u00101\u001a\u00020#J\b\u00102\u001a\u00020#H\u0002J\b\u00103\u001a\u00020#H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/bitable/anniex/view/BitableLynxAnimationView$AnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Lcom/bytedance/ee/bear/bitable/anniex/view/BitableLynxAnimationView;Landroid/content/Context;)V", "loop", "", "getLoop", "()Z", "setLoop", "(Z)V", "autoplay", "getAutoplay", "setAutoplay", "loopCount", "", "getLoopCount", "()Ljava/lang/Integer;", "setLoopCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "json", "", "getJson", "()Ljava/lang/String;", "setJson", "(Ljava/lang/String;)V", "localSrc", "getLocalSrc", "setLocalSrc", "attached", "pendingPlay", "sourceReleasedOnDetach", "onAttachedToWindow", "", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "onSizeChanged", "w", "h", "oldw", "oldh", "applyAll", "applyRepeat", "applySource", "applyAutoplay", "releaseAnimationState", "tryPlay", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AnimationView extends LottieAnimationView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f206765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f206766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f206767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f206768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f206769e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f206770f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f206771g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f206772h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ BitableLynxAnimationView f206773i;

        @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
        public final void onDetachedFromWindow() {
            this.f206770f = false;
            String r100 = this.f206773i.f206762a;
            StringBuilder r101 = new StringBuilder("onDetachedFromWindow: isAnimating=");
            AnimationView r102 = this.f206773i.f206764c;
            if (r102 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r101.append(r103);
            tt5.a.h(r100, r101.toString());
            this.f206771g = false;
            this.f206772h = true;
        L15:
            th = move-exception;
            tt5.a.l(this.f206773i.f206762a, "releaseAnimationState failed", th);
        L17:
            super.onDetachedFromWindow();
            return;
        L10:
            if (isAnimating() == false) goto L12;
            cancelAnimation();     // Catch: Throwable -> L15
        L13:
            setProgress(0.0f);     // Catch: Throwable -> L15
            setImageDrawable(null);     // Catch: Throwable -> L15
            goto L17
        L12:
            clearAnimation();     // Catch: Throwable -> L15
            goto L13
        L5:
            if (r102.isAnimating() != true) goto L7;
            r103 = true;
            goto L8
        }

        public final void j() {
            if (this.f206766b == true) goto L8;
            this.f206771g = false;
            if (isAnimating() == false) goto L10;
            tt5.a.h(this.f206773i.f206762a, "applyAutoplay: cancelAnimation");
            cancelAnimation();
            return;
        L10:
            return;
        L8:
            n();
        }

        public final void l() {
            if (this.f206765a == false) goto L5;
            int r100 = -1;
        L10:
            setRepeatCount(r100);
            tt5.a.h(this.f206773i.f206762a, "applyRepeat: loop=" + this.f206765a + ", loopCount=" + this.f206767c + ", repeatCount=" + getRepeatCount());
            return;
        L5:
            Integer r101 = this.f206767c;
            if (r101 == null) goto L9;
            if (r101 == null) goto L9;
            r100 = r101.intValue();
        L9:
            r100 = 0;
            goto L10
        }

        public final void m() {
            String r100 = this.f206768d;
            boolean r101 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == true) goto L11;
            tt5.a.h(this.f206773i.f206762a, "applySource: jsonLength=" + r100.length());
            setAnimationFromJson(r100, null);
            return;
        L11:
            String r103 = this.f206769e;
            if (r103 != null) goto L14;
        L15:
            r101 = true;
        L16:
            if (r101 == true) goto L18;
            tt5.a.h(this.f206773i.f206762a, "applySource: localSrc=" + this.f206769e);
            setAnimation(this.f206769e);
            return;
        L18:
            tt5.a.h(this.f206773i.f206762a, "applySource: use default loading_anim");
            setAnimation(R.raw.loading_anim);
            return;
        L14:
            if (r103.length() != 0) goto L16;
        L5:
            if (r100.length() == 0) goto L8;
            r102 = false;
            goto L9
        }

        public final void n() {
            if (this.f206766b == true) goto L9;
            this.f206771g = false;
            tt5.a.b(this.f206773i.f206762a, "tryPlay skipped: autoplay=false");
            if (isAnimating() == false) goto L30;
            cancelAnimation();
            return;
        L30:
            return;
        L9:
            if (this.f206770f == true) goto L13;
            tt5.a.b(this.f206773i.f206762a, "tryPlay skipped: not attached");
            return;
        L13:
            if (getVisibility() == 0) goto L15;
        L19:
            boolean r100 = false;
        L20:
            if (r100 == true) goto L25;
            this.f206771g = true;
            tt5.a.b(this.f206773i.f206762a, "tryPlay deferred: visibility=" + getVisibility() + ", size=" + getWidth() + Permission.EXECUTE + getHeight());
            if (isAnimating() == false) goto L31;
            pauseAnimation();
            return;
        L31:
            return;
        L25:
            this.f206771g = false;
            if (isAnimating() == true) goto L28;
            tt5.a.h(this.f206773i.f206762a, "tryPlay: playAnimation");
            playAnimation();
            return;
        L28:
            tt5.a.b(this.f206773i.f206762a, "tryPlay skipped: already animating");
            return;
        L15:
            if (getWidth() <= 0) goto L19;
            if (getHeight() <= 0) goto L19;
            r100 = true;
            goto L20
        }

        @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.f206770f = true;
            tt5.a.h(this.f206773i.f206762a, "onAttachedToWindow: pendingPlay=" + this.f206771g);
            if (this.f206772h == false) goto L6;
            tt5.a.h(this.f206773i.f206762a, "onAttachedToWindow: reapply source after detach");
            l();
            m();
            this.f206772h = false;
        L6:
            if (this.f206773i.f206764c != null) goto L8;
            return;
        L8:
            if (this.f206771g == false) goto L10;
            this.f206771g = false;
            n();
            return;
        L10:
            n();
        }

        public final boolean getAutoplay() {
            return this.f206766b;
        }

        public final String getJson() {
            return this.f206768d;
        }

        public final String getLocalSrc() {
            return this.f206769e;
        }

        public final boolean getLoop() {
            return this.f206765a;
        }

        public final Integer getLoopCount() {
            return this.f206767c;
        }

        public final void setAutoplay(boolean r100) {
            this.f206766b = r100;
        }

        public final void setJson(String r100) {
            this.f206768d = r100;
        }

        public final void setLocalSrc(String r100) {
            this.f206769e = r100;
        }

        public final void setLoop(boolean r100) {
            this.f206765a = r100;
        }

        public final void setLoopCount(Integer r100) {
            this.f206767c = r100;
        }

        public AnimationView(BitableLynxAnimationView r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f206773i = r100;
            super(r101);
        }

        @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
        public final void onVisibilityChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "changedView");
            tt5.a.b(this.f206773i.f206762a, "onVisibilityChanged: visibility=" + r101);
            n();
        }

        @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
        public final void onSizeChanged(int r100, int r101, int r102, int r103) {
            super.onSizeChanged(r100, r101, r102, r103);
            tt5.a.b(this.f206773i.f206762a, "onSizeChanged: " + r102 + Permission.EXECUTE + r103 + " -> " + r100 + Permission.EXECUTE + r101);
            n();
        }
    }

    public BitableLynxAnimationView(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f206762a = "BaseLynxAnimaView#" + hashCode();
        this.f206763b = "appAsset";
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        tt5.a.h(this.f206762a, "createView");
        AnimationView r101 = new AnimationView(this, r100);
        this.f206764c = r101;
        r101.setRepeatCount(0);
        r101.setSaveEnabled(false);
        r101.l();
        r101.m();
        r101.j();
        return r101;
    }

    @LynxProp(name = "autoplay")
    public final void setAutoplay(boolean r100) {
        tt5.a.h(this.f206762a, "setAutoplay: " + r100);
        AnimationView r101 = this.f206764c;
        if (r101 == null) goto L5;
        r101.setAutoplay(r100);
    L5:
        AnimationView r102 = this.f206764c;
        if (r102 == null) goto L9;
        r102.j();
        return;
    }

    @LynxProp(name = "json")
    public final void setJson(String r100) {
        String r101 = this.f206762a;
        StringBuilder r102 = new StringBuilder("setJson: length=");
        if (r100 == null) goto L5;
        int r103 = r100.length();
    L6:
        r102.append(r103);
        tt5.a.h(r101, r102.toString());
        AnimationView r104 = this.f206764c;
        if (r104 == null) goto L9;
        r104.setJson(r100);
    L9:
        AnimationView r105 = this.f206764c;
        if (r105 == null) goto L13;
        r105.m();
        return;
    L13:
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @LynxProp(name = "src-local")
    public final void setLocalSrc(String r100) {
        tt5.a.h(this.f206762a, "setLocalSrc: " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L11;
        AnimationView r101 = this.f206764c;
        if (r101 == null) goto L7;
        r101.setLocalSrc(null);
    L7:
        AnimationView r102 = this.f206764c;
        if (r102 == null) goto L23;
        r102.m();
        return;
    L23:
        return;
    L11:
        Uri r103 = UriProtector.parse(r100);
        String r104 = r103.getScheme();
        String r105 = r103.getHost();
        if (Intrinsics.areEqual(this.f206763b, r104) == true) goto L14;
    L21:
        tt5.a.k(this.f206762a, "setLocalSrc ignored: unsupported src " + r100);
        return;
    L14:
        if (TextUtils.isEmpty(r105) == true) goto L21;
        AnimationView r106 = this.f206764c;
        if (r106 == null) goto L18;
        r106.setLocalSrc(r105);
    L18:
        AnimationView r107 = this.f206764c;
        if (r107 == null) goto L24;
        r107.m();
        return;
    }

    @LynxProp(name = "loop")
    public final void setLoop(boolean r100) {
        tt5.a.h(this.f206762a, "setLoop: " + r100);
        AnimationView r101 = this.f206764c;
        if (r101 == null) goto L5;
        r101.setLoop(r100);
    L5:
        AnimationView r102 = this.f206764c;
        if (r102 == null) goto L9;
        r102.l();
        return;
    }
}
