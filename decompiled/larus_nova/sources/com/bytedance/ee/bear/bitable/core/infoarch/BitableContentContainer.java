package com.bytedance.ee.bear.bitable.core.infoarch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/BitableContentContainer;", "Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scrollDown", "", "getScrollDown", "()Ljava/lang/Boolean;", "setScrollDown", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "lastY", "", "getLastY", "()F", "setLastY", "(F)V", "downY", "getDownY", "setDownY", "downX", "getDownX", "setDownX", "scrollApi", "Lcom/bytedance/ee/bear/bitable/core/infoarch/IScrollApi;", "getScrollApi", "()Lcom/bytedance/ee/bear/bitable/core/infoarch/IScrollApi;", "setScrollApi", "(Lcom/bytedance/ee/bear/bitable/core/infoarch/IScrollApi;)V", "enableScroll", "getEnableScroll", "()Z", "setEnableScroll", "(Z)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableContentContainer extends RoundFrameLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f210171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f210172h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f210173i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f210174j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f210175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f210176l;

    public BitableContentContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableContentContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final float getDownX() {
        return this.f210174j;
    }

    public final float getDownY() {
        return this.f210173i;
    }

    public final boolean getEnableScroll() {
        return this.f210176l;
    }

    public final float getLastY() {
        return this.f210172h;
    }

    public final e getScrollApi() {
        return this.f210175k;
    }

    public final Boolean getScrollDown() {
        return this.f210171g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 == 0) goto L30;
        boolean r102 = false;
        if (r101 != 1) goto L7;
        Boolean r103 = this.f210171g;
        if (r103 == null) goto L29;
        boolean r104 = r103.booleanValue();
        if ((r100.getY() - this.f210173i) >= 0.0f) goto L18;
        boolean r105 = true;
    L19:
        boolean r106 = Intrinsics.areEqual(Boolean.valueOf(r105), this.f210171g);
        if (Math.abs(r100.getX() - this.f210174j) >= Math.abs(r100.getY() - this.f210173i)) goto L23;
        r102 = true;
    L23:
        if (this.f210176l == false) goto L29;
        if (r106 == false) goto L29;
        if (r102 == false) goto L29;
        e r107 = this.f210175k;
        if (r107 == null) goto L29;
        r107.a(r104);
        goto L29
    L18:
        r105 = false;
    L29:
        this.f210171g = null;
    L32:
        return super.dispatchTouchEvent(r100);
    L7:
        if (r101 != 2) goto L32;
        if ((r100.getY() - this.f210172h) >= 0.0f) goto L12;
        r102 = true;
    L12:
        this.f210171g = Boolean.valueOf(r102);
        this.f210172h = r100.getY();
        goto L32
    L30:
        this.f210173i = r100.getY();
        this.f210174j = r100.getX();
        this.f210172h = r100.getY();
        goto L32
    }

    public final void setDownX(float r100) {
        this.f210174j = r100;
    }

    public final void setDownY(float r100) {
        this.f210173i = r100;
    }

    public final void setEnableScroll(boolean r100) {
        this.f210176l = r100;
    }

    public final void setLastY(float r100) {
        this.f210172h = r100;
    }

    public final void setScrollApi(e r100) {
        this.f210175k = r100;
    }

    public final void setScrollDown(Boolean r100) {
        this.f210171g = r100;
    }

    public BitableContentContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f226534f = false;
    }

    public /* synthetic */ BitableContentContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
