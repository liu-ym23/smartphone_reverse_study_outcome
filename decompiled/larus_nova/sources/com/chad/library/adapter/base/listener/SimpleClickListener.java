package com.chad.library.adapter.base.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public abstract class SimpleClickListener implements RecyclerView.OnItemTouchListener {
    public static String TAG = "SimpleClickListener";
    protected BaseQuickAdapter baseQuickAdapter;
    private GestureDetectorCompat mGestureDetector;
    private boolean mIsPrepressed;
    private boolean mIsShowPress;
    private View mPressedView;
    private RecyclerView recyclerView;

    public class ItemTouchHelperGestureListener implements GestureDetector.OnGestureListener {
        private RecyclerView recyclerView;
        final /* synthetic */ SimpleClickListener this$0;

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            return false;
        }

        private void resetPressedView(final View r100) {
            if (r100 == null) goto L4;
            r100.postDelayed(new AnonymousClass1(this, r100), 50);
        L4:
            SimpleClickListener.access$002(this.this$0, false);
            SimpleClickListener.access$102(this.this$0, null);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent r100) {
            SimpleClickListener.access$002(this.this$0, true);
            SimpleClickListener.access$102(this.this$0, this.recyclerView.findChildViewUnder(r100.getX(), r100.getY()));
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent r110) {
            if (this.recyclerView.getScrollState() == 0) goto L6;
            return;
        L6:
            if (SimpleClickListener.access$000(this.this$0) == true) goto L8;
            return;
        L8:
            if (SimpleClickListener.access$100(this.this$0) == null) goto L55;
            SimpleClickListener.access$100(this.this$0).performHapticFeedback(0);
            BaseViewHolder r100 = (BaseViewHolder) this.recyclerView.getChildViewHolder(SimpleClickListener.access$100(this.this$0));
            int r101 = r100.getAdapterPosition();
            if (r101 != (-1)) goto L13;
            return;
        L13:
            if (SimpleClickListener.access$300(this.this$0, r101) == true) goto L56;
            HashSet<Integer> r102 = r100.getItemChildLongClickViewIds();
            Set<Integer> r103 = r100.getNestViews();
            if (r102 != null) goto L17;
        L31:
            boolean r104 = false;
        L32:
            if (r104 == true) goto L57;
            SimpleClickListener r105 = this.this$0;
            r105.onItemLongClick(r105.baseQuickAdapter, SimpleClickListener.access$100(r105), r101 - this.this$0.baseQuickAdapter.getHeaderLayoutCount());
            SimpleClickListener r106 = this.this$0;
            SimpleClickListener.access$400(r106, r110, SimpleClickListener.access$100(r106));
            SimpleClickListener.access$100(this.this$0).setPressed(true);
            if (r102 == null) goto L41;
            Iterator<Integer> r111 = r102.iterator();
        L37:
            if (r111.hasNext() == false) goto L41;
            Integer r107 = r111.next();
            View r108 = SimpleClickListener.access$100(this.this$0).findViewById(r107.intValue());
            if (r108 == null) goto L37;
            r108.setPressed(false);
        L41:
            SimpleClickListener.access$202(this.this$0, true);
            return;
        L57:
            return;
        L17:
            if (r102.size() <= 0) goto L31;
            Iterator<Integer> r109 = r102.iterator();
        L20:
            if (r109.hasNext() == false) goto L31;
            Integer r112 = r109.next();
            View r113 = SimpleClickListener.access$100(this.this$0).findViewById(r112.intValue());
            if (this.this$0.inRangeOfView(r113, r110) == false) goto L20;
            if (r113.isEnabled() == false) goto L20;
            if (r103 != null) goto L27;
        L29:
            SimpleClickListener.access$400(this.this$0, r110, r113);
            SimpleClickListener r114 = this.this$0;
            BaseQuickAdapter r115 = r114.baseQuickAdapter;
            r114.onItemChildLongClick(r115, r113, r101 - r115.getHeaderLayoutCount());
            r113.setPressed(true);
            SimpleClickListener.access$202(this.this$0, true);
        L30:
            r104 = true;
            goto L32
        L27:
            if (r103.contains(r112) == false) goto L29;
        L56:
            return;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent r100) {
            if (SimpleClickListener.access$000(this.this$0) == true) goto L5;
            return;
        L5:
            if (SimpleClickListener.access$100(this.this$0) == null) goto L9;
            SimpleClickListener.access$202(this.this$0, true);
            return;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent r110) {
            if (SimpleClickListener.access$000(this.this$0) == true) goto L5;
        L54:
            return true;
        L5:
            if (SimpleClickListener.access$100(this.this$0) == null) goto L54;
            if (this.recyclerView.getScrollState() == 0) goto L9;
            return false;
        L9:
            View r100 = SimpleClickListener.access$100(this.this$0);
            BaseViewHolder r101 = (BaseViewHolder) this.recyclerView.getChildViewHolder(r100);
            int r102 = r101.getAdapterPosition();
            if (r102 != (-1)) goto L13;
            return false;
        L13:
            if (SimpleClickListener.access$300(this.this$0, r102) == false) goto L15;
            return false;
        L15:
            int r103 = r102 - this.this$0.baseQuickAdapter.getHeaderLayoutCount();
            HashSet<Integer> r104 = r101.getChildClickViewIds();
            Set<Integer> r105 = r101.getNestViews();
            if (r104 != null) goto L18;
        L42:
            SimpleClickListener.access$400(this.this$0, r110, r100);
            SimpleClickListener.access$100(this.this$0).setPressed(true);
            if (r104 != null) goto L45;
        L52:
            SimpleClickListener r111 = this.this$0;
            r111.onItemClick(r111.baseQuickAdapter, r100, r103);
        L53:
            resetPressedView(r100);
            goto L54
        L45:
            if (r104.size() <= 0) goto L52;
            Iterator<Integer> r112 = r104.iterator();
        L48:
            if (r112.hasNext() == false) goto L52;
            View r106 = r100.findViewById(r112.next().intValue());
            if (r106 == null) goto L48;
            r106.setPressed(false);
            goto L48
        L18:
            if (r104.size() <= 0) goto L42;
            Iterator<Integer> r107 = r104.iterator();
        L21:
            if (r107.hasNext() == false) goto L35;
            Integer r108 = r107.next();
            View r109 = r100.findViewById(r108.intValue());
            if (r109 == null) goto L21;
            if (this.this$0.inRangeOfView(r109, r110) == true) goto L27;
        L34:
            r109.setPressed(false);
            goto L21
        L27:
            if (r109.isEnabled() == false) goto L34;
            if (r105 != null) goto L30;
        L32:
            SimpleClickListener.access$400(this.this$0, r110, r109);
            r109.setPressed(true);
            SimpleClickListener r113 = this.this$0;
            r113.onItemChildClick(r113.baseQuickAdapter, r109, r103);
            resetPressedView(r109);
            return true;
        L30:
            if (r105.contains(r108) == false) goto L32;
            return false;
        L35:
            SimpleClickListener.access$400(this.this$0, r110, r100);
            SimpleClickListener.access$100(this.this$0).setPressed(true);
            Iterator<Integer> r114 = r104.iterator();
        L37:
            if (r114.hasNext() == false) goto L41;
            View r115 = r100.findViewById(r114.next().intValue());
            if (r115 == null) goto L37;
            r115.setPressed(false);
            goto L37
        L41:
            SimpleClickListener r116 = this.this$0;
            r116.onItemClick(r116.baseQuickAdapter, r100, r103);
            goto L53
        }

        public ItemTouchHelperGestureListener(SimpleClickListener r100, RecyclerView r101) {
            this.this$0 = r100;
            this.recyclerView = r101;
        }
    }

    private boolean isHeaderOrFooterView(int r100) {
        if (r100 != 1365) goto L5;
    L12:
        return true;
    L5:
        if (r100 == 273) goto L12;
        if (r100 == 819) goto L12;
        if (r100 == 546) goto L12;
        return false;
    }

    public abstract void onItemChildClick(BaseQuickAdapter r100, View r101, int r102);

    public abstract void onItemChildLongClick(BaseQuickAdapter r100, View r101, int r102);

    public abstract void onItemClick(BaseQuickAdapter r100, View r101, int r102);

    public abstract void onItemLongClick(BaseQuickAdapter r100, View r101, int r102);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    public SimpleClickListener() {
        this.mIsPrepressed = false;
        this.mIsShowPress = false;
        this.mPressedView = null;
    }

    public static /* synthetic */ boolean access$000(SimpleClickListener r100) {
        return r100.mIsPrepressed;
    }

    public static /* synthetic */ View access$100(SimpleClickListener r100) {
        return r100.mPressedView;
    }

    private boolean isHeaderOrFooterPosition(int r100) {
        if (this.baseQuickAdapter != null) goto L8;
        RecyclerView r101 = this.recyclerView;
        if (r101 == null) goto L7;
        this.baseQuickAdapter = (BaseQuickAdapter) r101.getAdapter();
        goto L8
    L7:
        return false;
    L8:
        int r102 = this.baseQuickAdapter.getItemViewType(r100);
        if (r102 != 1365) goto L11;
    L16:
        return true;
    L11:
        if (r102 == 273) goto L16;
        if (r102 == 819) goto L16;
        if (r102 == 546) goto L16;
        return false;
    }

    public static /* synthetic */ boolean access$002(SimpleClickListener r100, boolean r101) {
        r100.mIsPrepressed = r101;
        return r101;
    }

    public static /* synthetic */ View access$102(SimpleClickListener r100, View r101) {
        r100.mPressedView = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(SimpleClickListener r100, boolean r101) {
        r100.mIsShowPress = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$300(SimpleClickListener r100, int r101) {
        return r100.isHeaderOrFooterPosition(r101);
    }

    private void setPressViewHotSpot(MotionEvent r100, View r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getBackground() == null) goto L8;
        r101.getBackground().setHotspot(r100.getRawX(), r100.getY() - r101.getY());
        return;
    }

    public boolean inRangeOfView(View r100, MotionEvent r101) {
        int[] r102 = new int[2];
        if (r100 != null) goto L5;
    L17:
        return false;
    L5:
        if (r100.isShown() == false) goto L17;
        r100.getLocationOnScreen(r102);
        int r103 = r102[0];
        int r104 = r102[1];
        if (r101.getRawX() < r103) goto L17;
        if (r101.getRawX() > (r103 + r100.getWidth())) goto L17;
        if (r101.getRawY() < r104) goto L17;
        if (r101.getRawY() > (r104 + r100.getHeight())) goto L17;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
        RecyclerView r102 = this.recyclerView;
        if (r102 != null) goto L5;
        this.recyclerView = r100;
        this.baseQuickAdapter = (BaseQuickAdapter) r100.getAdapter();
        this.mGestureDetector = new GestureDetectorCompat(this.recyclerView.getContext(), new ItemTouchHelperGestureListener(this, this.recyclerView));
    L8:
        if (this.mGestureDetector.onTouchEvent(r101) == false) goto L10;
    L21:
        return false;
    L10:
        if (r101.getActionMasked() != 1) goto L21;
        if (this.mIsShowPress == false) goto L21;
        View r103 = this.mPressedView;
        if (r103 == null) goto L20;
        BaseViewHolder r104 = (BaseViewHolder) this.recyclerView.getChildViewHolder(r103);
        if (r104 != null) goto L18;
    L19:
        this.mPressedView.setPressed(false);
        goto L20
    L18:
        if (isHeaderOrFooterView(r104.getItemViewType()) == false) goto L19;
    L20:
        this.mIsShowPress = false;
        this.mIsPrepressed = false;
        goto L21
    L5:
        if (r102 == r100) goto L8;
        this.recyclerView = r100;
        this.baseQuickAdapter = (BaseQuickAdapter) r100.getAdapter();
        this.mGestureDetector = new GestureDetectorCompat(this.recyclerView.getContext(), new ItemTouchHelperGestureListener(this, this.recyclerView));
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView r100, MotionEvent r101) {
        this.mGestureDetector.onTouchEvent(r101);
    }

    public static /* synthetic */ void access$400(SimpleClickListener r100, MotionEvent r101, View r102) {
        r100.setPressViewHotSpot(r101, r102);
    }
}
