package com.bytedance.ies.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ies.xelement.viewpager.Pager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/CustomViewPager;", "Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseCustomViewPager;", "", MapController.ITEM_LAYER_TAG, "", "setCurrentItem", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public final class CustomViewPager extends BaseCustomViewPager {
    public CustomViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (getMAllowHorizontalGesture() == true) goto L29;
        if (r100 == null) goto L6;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L7:
        boolean r102 = false;
        if (r101 != null) goto L11;
    L13:
        if (r101 != null) goto L16;
    L30:
        Pager.g r103 = getMInterceptTouchEventListener();
        if (r103 == null) goto L33;
        r103.a(r102);
    L33:
        return r102;
    L16:
        if (r101.intValue() != 2) goto L30;
        if (getMActivePointerId() == (-1)) goto L30;
        int r104 = r100.findPointerIndex(getMActivePointerId());
        float r105 = r100.getX(r104);
        float r106 = r100.getY(r104);
        if ((Math.abs(r105 - getMLastMotionX()) * 0.5f) <= Math.abs(r106 - getMLastMotionY())) goto L30;
        setMLastMotionX(r105);
        setMLastMotionY(r106);
        Field r107 = getIsUnableToDrag();
        if (r107 == null) goto L25;
        r107.setAccessible(true);
    L25:
        if (r107 == null) goto L30;
        if (r107.getBoolean(this) == false) goto L30;
        r107.set(this, Boolean.FALSE);
        goto L30
    L11:
        if (r101.intValue() != 0) goto L13;
        setMLastMotionX(r100.getX());
        setMLastMotionY(r100.getY());
        setMActivePointerId(r100.getPointerId(0));
        goto L30
    L6:
        r101 = null;
        goto L7
    L29:
        r102 = super.onInterceptTouchEvent(r100);
        goto L30
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100) {
        PagerAdapter r101 = super.getAdapter();
        if (r101 != null) goto L5;
    L7:
        super.setCurrentItem(r100);
        return;
    L5:
        if (this.f250591g == false) goto L7;
        r100 = (r101.getCount() - r100) - 1;
        goto L7
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int r100, boolean r101) {
        PagerAdapter r102 = super.getAdapter();
        if (r102 != null) goto L5;
    L7:
        super.setCurrentItem(r100, r101);
        return;
    L5:
        if (this.f250591g == false) goto L7;
        r100 = (r102.getCount() - r100) - 1;
        goto L7
    }
}
