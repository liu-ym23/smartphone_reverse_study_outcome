package com.ss.android.lark.widget.recyclerview;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.tonicartos.superslim.LayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public abstract class RecyclerViewScrollDetector extends RecyclerView.OnScrollListener {
    private int mScrollThreshold;
    private int mScrolledDy;
    private List<Integer> scrolledIndexList;

    public abstract void onScrollPassed(int r100, int r101);

    public abstract void onScrollStop(int r100, int r101);

    public abstract void onScrollToBottom();

    public RecyclerViewScrollDetector() {
        this.mScrollThreshold = 8;
        this.mScrolledDy = 0;
        this.scrolledIndexList = new ArrayList();
    }

    public void setScrollThreshold(int r100) {
        this.mScrollThreshold = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r100, int r101) {
        if (r101 == 0) goto L5;
        return;
    L5:
        if (this.scrolledIndexList.size() <= 0) goto L7;
        Collections.sort(this.scrolledIndexList);
        int r102 = ((Integer) ListProtector.get(this.scrolledIndexList, 0)).intValue();
        List<Integer> r103 = this.scrolledIndexList;
        int r104 = ((Integer) ListProtector.get(r103, r103.size() - 1)).intValue();
        Log.i("scroll test", "startPosition:" + r102 + "; endPosition: " + r104);
        onScrollStop(r102, r104);
    L7:
        this.scrolledIndexList.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView r100, int r101, int r102) {
        this.mScrolledDy += r102;
        if (r100 != null) goto L6;
    L4:
        boolean r103 = false;
    L9:
        if (Math.abs(this.mScrolledDy) <= this.mScrollThreshold) goto L28;
        this.mScrolledDy = 0;
        if ((r100.getLayoutManager() instanceof LinearLayoutManager) == false) goto L14;
        LinearLayoutManager r104 = (LinearLayoutManager) r100.getLayoutManager();
        int r105 = r104.findFirstVisibleItemPosition();
        int r106 = r104.findLastVisibleItemPosition() + 1;
    L16:
        if (r105 < 0) goto L28;
        if (r106 < 0) goto L28;
        if (r103 == true) goto L20;
        onScrollPassed(r105, r106);
    L20:
        if (r105 > r106) goto L28;
        if (this.scrolledIndexList.contains(Integer.valueOf(r105)) == true) goto L25;
        this.scrolledIndexList.add(Integer.valueOf(r105));
    L25:
        r105 = r105 + 1;
        goto L20
    L14:
        if ((r100.getLayoutManager() instanceof LayoutManager) == true) goto L26;
        r105 = -1;
        r106 = -1;
        goto L16
    L26:
        ((LayoutManager) r100.getLayoutManager()).q();
        throw null;
    L28:
        if (r103 == false) goto L35;
        onScrollToBottom();
        return;
    L35:
        return;
    L6:
        if ((r100.computeVerticalScrollExtent() + r100.computeVerticalScrollOffset()) < r100.computeVerticalScrollRange()) goto L4;
        r103 = true;
        goto L9
    }
}
