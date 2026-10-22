package com.bytedance.ee.bear.bitable.core.infoarch.basemain.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bitable.infoarch.toolbar.BitableToolbarContainer;
import com.bytedance.ee.bear.bitable.infoarch.view.BitableViewContainer;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/view/OfficeBaseMainTopLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "interceptTouchEvent", "", "viewContainer", "Lcom/bytedance/ee/bear/bitable/infoarch/view/BitableViewContainer;", "getViewContainer", "()Lcom/bytedance/ee/bear/bitable/infoarch/view/BitableViewContainer;", "toolbarContainer", "Lcom/bytedance/ee/bear/bitable/infoarch/toolbar/BitableToolbarContainer;", "getToolbarContainer", "()Lcom/bytedance/ee/bear/bitable/infoarch/toolbar/BitableToolbarContainer;", "setInterceptListener", "", "listener", "Lkotlin/Function0;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onHeaderOffsetChanged", "absOffset", "", "headerHeight", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBaseMainTopLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f210534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableViewContainer f210535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitableToolbarContainer f210536c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f210537a;

        public a(Function0<Unit> r100) {
            this.f210537a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f210537a.invoke();
        }
    }

    public final BitableToolbarContainer getToolbarContainer() {
        return this.f210536c;
    }

    public final BitableViewContainer getViewContainer() {
        return this.f210535b;
    }

    public OfficeBaseMainTopLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f210534a == false) goto L7;
        return true;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setInterceptListener(Function0<Unit> r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L5:
        this.f210534a = r101;
        if (r100 == null) goto L8;
        setOnClickListener(new a(r100));
        return;
    L8:
        setOnClickListener(null);
        return;
    L4:
        r101 = false;
        goto L5
    }

    public OfficeBaseMainTopLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setOrientation(1);
        setClipChildren(true);
        setClipToPadding(true);
        AttributeSet r102 = null;
        int r103 = 6;
        int r104 = 0;
        BitableViewContainer r105 = new BitableViewContainer(r100, r102, r103, r104);
        r105.setId(R.id.bitable_view_container);
        r105.setClipChildren(false);
        r105.setClipToPadding(false);
        this.f210535b = r105;
        BitableToolbarContainer r106 = new BitableToolbarContainer(r100, r102, r103, r104);
        r106.setId(R.id.bitable_toolbar_container);
        this.f210536c = r106;
        addView(r105, new LinearLayout.LayoutParams(-1, -2));
        addView(r106, new LinearLayout.LayoutParams(-1, -2));
    }
}
