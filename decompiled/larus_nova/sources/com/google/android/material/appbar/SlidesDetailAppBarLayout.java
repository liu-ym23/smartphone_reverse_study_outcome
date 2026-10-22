package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.awemeopen.apps.photo.viewmodel.SlidesDetailSizeVM;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\bH\u0014R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/google/android/material/appbar/SlidesDetailAppBarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "appBarUpOffsetDev", "", "getAppBarUpOffsetDev", "()I", "needAdjustNestedPreScrollRange", "", "getNeedAdjustNestedPreScrollRange", "()Z", "setNeedAdjustNestedPreScrollRange", "(Z)V", "sizeVM", "Lcom/bytedance/awemeopen/apps/photo/viewmodel/SlidesDetailSizeVM;", "getSizeVM", "()Lcom/bytedance/awemeopen/apps/photo/viewmodel/SlidesDetailSizeVM;", "sizeVM$delegate", "Lkotlin/Lazy;", "getUpNestedPreScrollRange", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SlidesDetailAppBarLayout extends AppBarLayout {
    public Map<Integer, View> _$_findViewCache;
    private boolean needAdjustNestedPreScrollRange;
    private final Lazy sizeVM$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public SlidesDetailAppBarLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 2, 0 == true ? 1 : 0);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int r100) {
        Map<Integer, View> r101 = this._$_findViewCache;
        View r102 = r101.get(Integer.valueOf(r100));
        if (r102 != null) goto L9;
        View r103 = findViewById(r100);
        if (r103 == null) goto L7;
        r101.put(Integer.valueOf(r100), r103);
        return r103;
    L7:
        return null;
    L9:
        return r102;
    }

    private final SlidesDetailSizeVM getSizeVM() {
        return (SlidesDetailSizeVM) this.sizeVM$delegate.getValue();
    }

    @Override // com.google.android.material.appbar.AppBarLayout
    public int getUpNestedPreScrollRange() {
        if (this.needAdjustNestedPreScrollRange == false) goto L6;
        return super.getUpNestedPreScrollRange() - getAppBarUpOffsetDev();
    L6:
        return super.getUpNestedPreScrollRange();
    }

    private final int getAppBarUpOffsetDev() {
        SlidesDetailSizeVM r100 = getSizeVM();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getAppBarUpOffsetDev();
    }

    public final boolean getNeedAdjustNestedPreScrollRange() {
        return this.needAdjustNestedPreScrollRange;
    }

    public final void setNeedAdjustNestedPreScrollRange(boolean r100) {
        this.needAdjustNestedPreScrollRange = r100;
    }

    public SlidesDetailAppBarLayout(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this._$_findViewCache = new LinkedHashMap();
        super(r100, r101);
        this.needAdjustNestedPreScrollRange = true;
        this.sizeVM$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SlidesDetailAppBarLayout$sizeVM$2(r100));
    }

    public /* synthetic */ SlidesDetailAppBarLayout(Context r100, AttributeSet r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
