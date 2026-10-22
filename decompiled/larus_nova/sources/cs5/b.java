package cs5;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.lark.component.AbstractNativeComponent;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends ViewGroup implements cs5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public as5.b f465178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Rect> f465179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f465180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, View> f465181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f465182e;

    public class a implements as5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f465183a;

        public a(b r100) {
            this.f465183a = r100;
        }

        @Override // as5.a
        public final void a(tr5.a r100) {
            String r101 = r100.getViewId();
            View r102 = this.f465183a.d(r101);
            r100.onRemove();
            ((HashMap) this.f465183a.f465181d).remove(r101);
            if (r102 == null) goto L6;
            b.c(this.f465183a, r102);
            this.f465183a.requestLayout();
            return;
        }

        @Override // as5.a
        public final void b(tr5.a r100) {
            if (r100 != null) goto L6;
            Log.e("NativeViewLayout", "onDataUpdated, nativeComponent is null");
            return;
        L6:
            String r101 = r100.getViewId();
            Log.d("NativeViewLayout", "onDataUpdated, viewId = " + r100.getViewId());
            View r102 = this.f465183a.d(r101);
            if (r102 == null) goto L10;
            r100.onUpdateView(r102, r100.getData());
            return;
        }

        @Override // as5.a
        public final void c(AbstractNativeComponent r100) {
            String r101 = r100.getViewId();
            Log.d("NativeViewLayout", "onDataAdded, viewId = " + r101);
            if (((HashSet) this.f465183a.f465180c).contains(r101) == true) goto L5;
            return;
        L5:
            if (((HashMap) this.f465183a.f465181d).containsKey(r101) == true) goto L7;
        L9:
            ((HashMap) this.f465183a.f465181d).put(r101, r100.onCreateView(this.f465183a.getContext(), r100.getData()));
        L10:
            int r102 = r100.getWidth();
            int r103 = r100.getHeight();
            if (r102 <= 0) goto L14;
            if (r103 <= 0) goto L14;
            this.f465183a.g(r101, r102, r103);
            return;
        L14:
            Log.d("NativeViewLayout", "onDataAdded, invalid width = " + r102 + " height = " + r103);
            return;
        L7:
            if (((HashMap) this.f465183a.f465181d).get(r101) == null) goto L9;
            Log.d("NativeViewLayout", "onDataAdded, view has already created, viewId = " + r101);
            goto L10
        }
    }

    /* JADX INFO: renamed from: cs5.b$b, reason: collision with other inner class name */
    public static class C5576b extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f465184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f465185b;

        public C5576b(int r100, int r101) {
            super(r100, r101);
            this.f465184a = 0;
        }
    }

    @Override // cs5.a
    public final void b() {
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C5576b(-2, -2);
    }

    public b(Context r100) {
        super(r100);
        this.f465179b = new HashMap();
        this.f465180c = new HashSet();
        this.f465181d = new HashMap();
        this.f465182e = new a(this);
    }

    @Override // cs5.a
    public final void a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        ((HashSet) this.f465180c).add(r100);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof C5576b;
    }

    public final View d(String r100) {
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L13;
        View r102 = getChildAt(r101);
        if (r102 == null) goto L12;
        C5576b r103 = (C5576b) r102.getLayoutParams();
        if (r103 == null) goto L12;
        if (r100.equals(r103.f465185b) == false) goto L12;
        return r102;
    L12:
        r101 = r101 + 1;
        goto L4
    L13:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Log.d("NativeViewLayout", "dispatchTouchEvent, ev = " + r100.getAction());
        return super.dispatchTouchEvent(r100);
    }

    public final Rect e(tr5.a r100) {
        String r101 = r100.getViewId();
        return (Rect) ((HashMap) this.f465179b).get(r101);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Log.d("NativeViewLayout", "onInterceptTouchEvent, ev = " + r100.getAction());
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Log.d("NativeViewLayout", "onTouchEvent, ev = " + r100.getAction());
        return super.onTouchEvent(r100);
    }

    @Override // cs5.a
    public void setNativeComponentProvider(as5.b r100) {
        as5.b r101 = this.f465178a;
        if (r101 == null) goto L5;
        a r102 = this.f465182e;
        r101.f16129a.remove(r102);
    L5:
        this.f465178a = r100;
        a r103 = this.f465182e;
        r100.f16129a.add(r103);
    }

    public static /* synthetic */ void c(b r100, View r101) {
        r100.detachViewFromParent(r101);
    }

    public final void f(tr5.a r100, View r101) {
        Rect r102 = e(r100);
        if (r102 != null) goto L6;
        Log.e("NativeViewLayout", "scrollToNewLocation location is null, viewId= " + r100.getViewId());
        return;
    L6:
        int r103 = r101.getTop();
        int r104 = r102.left - r101.getLeft();
        int r105 = r102.top - r103;
        r101.offsetLeftAndRight(r104);
        r101.offsetTopAndBottom(r105);
        C5576b r106 = (C5576b) r101.getLayoutParams();
        r106.getClass();
        ((ViewGroup.LayoutParams) r106).width = r102.width();
        ((ViewGroup.LayoutParams) r106).height = r102.height();
        Log.d("NativeViewLayout", "scrollToNewLocation id: " + r100.getViewId() + "offsetY: " + r105 + " newtop: " + r101.getTop() + " oldTop: " + r103);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = 0;
        if (r102 == Integer.MIN_VALUE) goto L6;
        if (r102 == 1073741824) goto L6;
        r103 = 0;
    L6:
        int r105 = View.MeasureSpec.getMode(r101);
        int r106 = View.MeasureSpec.getSize(r101);
        if (r105 == Integer.MIN_VALUE) goto L10;
        if (r105 == 1073741824) goto L10;
    L11:
        measureChildren(r100, r101);
        setMeasuredDimension(r103, r104);
        return;
    L10:
        r104 = r106;
        goto L11
    }

    public final void g(String r100, int r101, int r110) {
        Log.d("NativeViewLayout", "updateBounds, viewId = " + r100 + " x: 0 y: 0 width: " + r101 + " height: " + r110);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        Log.e("NativeViewLayout", "updateBounds with empty viewId");
        return;
    L6:
        tr5.a r102 = this.f465178a.f16130b.get(r100);
        if (r102 != null) goto L10;
        ((HashMap) this.f465179b).put(r100, new Rect(0, 0, r101, r110));
        Log.e("NativeViewLayout", "updateBounds, viewId: " + r100 + " has not added");
        return;
    L10:
        ((HashMap) this.f465179b).put(r100, new Rect(0, 0, r101, r110));
        if (d(r100) == null) goto L22;
        Log.d("NativeViewLayout", "updateBounds, view not null, relayout");
        Rect r103 = e(r102);
        if (r103 != null) goto L15;
        Log.e("NativeViewLayout", "relayoutView location is null");
        return;
    L15:
        String r104 = r102.getViewId();
        View r111 = (View) ((HashMap) this.f465181d).get(r104);
        if (r111 != null) goto L19;
        Log.e("NativeViewLayout", "relayoutView view has not created, viewId: " + r104);
        r111 = r102.onCreateView(getContext(), r102.getData());
        ((HashMap) this.f465181d).put(r104, r111);
    L19:
        if (r111.isLayoutRequested() == false) goto L21;
        Log.d("NativeViewLayout", "relayoutView, measure and layout");
        r111.measure(View.MeasureSpec.makeMeasureSpec(r103.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(r103.height(), 1073741824));
        r111.layout(r103.left, r103.top, r103.right, r103.bottom);
        return;
    L21:
        cleanupLayoutState(r111);
        f(r102, r111);
        return;
    L22:
        Log.d("NativeViewLayout", "updateBounds, view is null, need make, viewId = " + r100);
        r102.setWidthAndHeight(r101, r110);
        Rect r105 = e(r102);
        if (r105 != null) goto L25;
        Log.e("NativeViewLayout", "makeAndAddView location is null");
        return;
    L25:
        int r106 = r102.getZIndex();
        int r112 = getChildCount() - 1;
        int r107 = 0;
    L26:
        if (r107 > r112) goto L34;
        int r108 = (r107 + r112) / 2;
        View r109 = getChildAt(r108);
        if (r109 != null) goto L30;
        int r113 = 0;
    L31:
        if (r113 >= r106) goto L32;
        r107 = r108 + 1;
        goto L26
    L32:
        r112 = r108 - 1;
        goto L26
    L30:
        r113 = ((C5576b) r109.getLayoutParams()).f465184a;
        goto L31
    L34:
        C5576b r114 = new C5576b(r105.width(), r105.height());
        r114.f465184a = r102.getZIndex();
        r114.f465185b = r102.getViewId();
        r102.getViewType();
        String r115 = r102.getViewId();
        View r116 = (View) ((HashMap) this.f465181d).get(r115);
        if (r116 != null) goto L37;
        Log.e("NativeViewLayout", "makeAndAddView view has not created, viewId: " + r115);
        r116 = r102.onCreateView(getContext(), r102.getData());
        ((HashMap) this.f465181d).put(r115, r116);
    L37:
        addViewInLayout(r116, r107, r114);
        if (r116.isLayoutRequested() == false) goto L40;
        Log.d("NativeViewLayout", "makeAndAddView, measure and layout");
        r116.measure(View.MeasureSpec.makeMeasureSpec(r105.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(r105.height(), 1073741824));
        r116.layout(r105.left, r105.top, r105.right, r105.bottom);
        return;
    L40:
        cleanupLayoutState(r116);
        f(r102, r116);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        Log.d("NativeViewLayout", "onLayout changed= " + r100 + "left= " + r101 + "top= " + r102 + "right= " + r103 + "bottom= " + r104);
        int r105 = getChildCount();
        int r106 = 0;
        int r107 = 0;
    L3:
        if (r106 >= r105) goto L5;
        View r108 = getChildAt(r106);
        int r109 = r108.getMeasuredWidth();
        int r110 = r108.getMeasuredHeight();
        r108.layout(r101, r107, r109, r110);
        r107 = r107 + r110;
        r106 = r106 + 1;
        goto L3
    }
}
