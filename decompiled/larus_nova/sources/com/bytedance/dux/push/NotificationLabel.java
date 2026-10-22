package com.bytedance.dux.push;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007B'\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR.\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\"\u0010,\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#¨\u00065"}, d2 = {"Lcom/bytedance/dux/push/NotificationLabel;", "Landroidx/cardview/widget/CardView;", "Landroid/view/View$OnClickListener;", "l", "", "setOnClickListener", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Landroid/view/ViewGroup;", "value", "b", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "parent", "Landroidx/customview/widget/ViewDragHelper;", "c", "Landroidx/customview/widget/ViewDragHelper;", "getViewDragHelper", "()Landroidx/customview/widget/ViewDragHelper;", "setViewDragHelper", "(Landroidx/customview/widget/ViewDragHelper;)V", "viewDragHelper", "", "d", "Z", "getDismissSettling", "()Z", "setDismissSettling", "(Z)V", "dismissSettling", "e", "getOpenSettling", "setOpenSettling", "openSettling", "h", "getInterceptingEvents", "setInterceptingEvents", "interceptingEvents", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class NotificationLabel extends CardView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f205527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f205528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewDragHelper f205529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f205530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f205531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnClickListener f205532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NotificationLabel$dragCallback$1 f205533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f205534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<a> f205535i;

    public interface a {
        void a();

        void b();
    }

    public NotificationLabel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NotificationLabel(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void computeScroll() {
        ViewDragHelper r100 = this.f205529c;
        if (r100 == null) goto L19;
        Intrinsics.checkNotNull(r100);
        if (r100.continueSettling(true) == false) goto L8;
        invalidate();
        return;
    L8:
        if (this.f205530d == false) goto L14;
        this.f205530d = false;
        Iterator<T> r101 = this.f205535i.iterator();
    L11:
        if (r101.hasNext() == false) goto L24;
        ((a) r101.next()).a();
        goto L11
    L24:
        return;
    L14:
        if (this.f205531e == false) goto L23;
        this.f205531e = false;
        Iterator<T> r102 = this.f205535i.iterator();
    L17:
        if (r102.hasNext() == false) goto L25;
        ((a) r102.next()).b();
        goto L17
    L25:
        return;
    L23:
        return;
    }

    public final boolean getDismissSettling() {
        return this.f205530d;
    }

    public final boolean getInterceptingEvents() {
        return this.f205534h;
    }

    public final boolean getOpenSettling() {
        return this.f205531e;
    }

    @Override // android.view.View, android.view.ViewParent
    public final ViewGroup getParent() {
        return this.f205528b;
    }

    public final String getTAG() {
        return this.f205527a;
    }

    public final ViewDragHelper getViewDragHelper() {
        return this.f205529c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        boolean r101 = this.f205534h;
        int r102 = r100.getActionMasked();
        if (r102 != 0) goto L5;
        int r103 = (int) r100.getX();
        int r104 = (int) r100.getY();
        Intrinsics.checkNotNullParameter(this, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Rect r105 = new Rect();
        ViewGroupUtils.getDescendantRect(this.f205528b, this, r105);
        r101 = r105.contains(r103, r104);
        this.f205534h = r101;
    L11:
        if (r101 == false) goto L18;
        ViewGroup r106 = this.f205528b;
        if (this.f205529c != null) goto L16;
        if (r106 == null) goto L16;
        this.f205529c = ViewDragHelper.create(r106, 1.0f, this.f205533g);
    L16:
        ViewDragHelper r107 = this.f205529c;
        Intrinsics.checkNotNull(r107);
        return r107.shouldInterceptTouchEvent(r100);
    L18:
        return false;
    L5:
        if (r102 != 1) goto L7;
    L9:
        this.f205534h = false;
        goto L11
    L7:
        if (r102 == 3) goto L9;
        goto L9
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ViewDragHelper r101 = this.f205529c;
        if (r101 == null) goto L8;
        if (r101 == null) goto L10;
        r101.processTouchEvent(r100);
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    public final void setDismissSettling(boolean r100) {
        this.f205530d = r100;
    }

    public final void setInterceptingEvents(boolean r100) {
        this.f205534h = r100;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        this.f205532f = r100;
    }

    public final void setOpenSettling(boolean r100) {
        this.f205531e = r100;
    }

    public final void setParent(ViewGroup r100) {
        this.f205528b = r100;
        if (this.f205529c != null) goto L7;
        if (r100 == null) goto L8;
        this.f205529c = ViewDragHelper.create(r100, 1.0f, this.f205533g);
        return;
    L8:
        return;
    }

    public final void setViewDragHelper(ViewDragHelper r100) {
        this.f205529c = r100;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.dux.push.NotificationLabel$dragCallback$1] */
    public NotificationLabel(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205527a = "NotificationLabel";
        this.f205533g = new NotificationLabel$dragCallback$1(this);
        this.f205535i = new ArrayList();
    }

    public /* synthetic */ NotificationLabel(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
