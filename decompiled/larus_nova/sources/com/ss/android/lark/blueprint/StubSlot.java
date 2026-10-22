package com.ss.android.lark.blueprint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0014J$\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\u0007H\u0016R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/blueprint/StubSlot;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "onLayout", "", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, RXScreenCaptureService.KEY_INDEX, "params", "Landroid/view/ViewGroup$LayoutParams;", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "getVisibility", "removeView", "view", "getChildCount", "getChildAt", "index", "blueprint_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StubSlot extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f410629a;

    public StubSlot(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StubSlot(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        WeakReference<View> r100 = this.f410629a;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        if (r101 != null) goto L8;
        return 0;
    L8:
        return 1;
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.view.View
    public int getVisibility() {
        WeakReference<View> r100 = this.f410629a;
        if (r100 == null) goto L9;
        View r101 = r100.get();
        if (r101 == null) goto L9;
        return r101.getVisibility();
    L9:
        return super.getVisibility();
    }

    @Override // android.view.ViewGroup
    public final View getChildAt(int r100) {
        WeakReference<View> r101 = this.f410629a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r101;
    L8:
        if (r102 != null) goto L10;
        return;
    L10:
        WeakReference<View> r103 = this.f410629a;
        if (r103 == null) goto L13;
        View r104 = r103.get();
    L14:
        if (r100 == r104) goto L16;
        return;
    L16:
        super.removeView(r100);
        this.f410629a = null;
        int r105 = r102.indexOfChild(r100);
        r102.removeViewInLayout(r100);
        r102.addView(this, r105);
        return;
    L13:
        r104 = null;
        goto L14
    L7:
        r102 = null;
        goto L8
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        WeakReference<View> r101 = this.f410629a;
        if (r101 == null) goto L7;
        View r102 = r101.get();
        if (r102 == null) goto L7;
        r102.setVisibility(r100);
    L7:
        super.setVisibility(8);
    }

    public StubSlot(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setWillNotDraw(true);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        WeakReference<View> r103 = this.f410629a;
        ViewGroup r104 = null;
        if (r103 == null) goto L5;
        View r105 = r103.get();
    L6:
        if (r105 == null) goto L8;
        return;
    L8:
        if (r100 != null) goto L10;
        return;
    L10:
        ViewParent r106 = getParent();
        if ((r106 instanceof ViewGroup) == false) goto L13;
        r104 = (ViewGroup) r106;
    L13:
        if (r104 != null) goto L15;
        return;
    L15:
        int r107 = r104.indexOfChild(this);
        r104.removeViewInLayout(this);
        r100.setId(getId());
        if (r102 != null) goto L18;
    L22:
        r104.addView(r100, r107, getLayoutParams());
        this.f410629a = new WeakReference(r100);
        return;
    L18:
        if (r102.width < 0) goto L20;
    L21:
        getLayoutParams().width = r102.width;
        getLayoutParams().height = r102.height;
        goto L22
    L20:
        if (r102.height < 0) goto L22;
    L5:
        r105 = null;
        goto L6
    }

    public /* synthetic */ StubSlot(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
