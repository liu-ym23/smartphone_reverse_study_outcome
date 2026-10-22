package com.bytedance.locallife.dito.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public interface f {

    public static final class a {
        public static RecyclerView a(f r100, View r101) {
            if (r101 != null) goto L5;
        L26:
            return null;
        L5:
            if (r101.getVisibility() != 0) goto L26;
            if ((r101 instanceof RecyclerView) == false) goto L17;
            RecyclerView r102 = (RecyclerView) r101;
            RecyclerView.LayoutManager r103 = r102.getLayoutManager();
            boolean r104 = false;
            if (r103 != null) goto L12;
        L14:
            if (r104 == false) goto L17;
            return r102;
        L12:
            if (r103.canScrollVertically() != true) goto L14;
            r104 = true;
        L17:
            if ((r101 instanceof ViewGroup) == true) goto L19;
            return null;
        L19:
            ViewGroup r105 = (ViewGroup) r101;
            int r106 = r105.getChildCount() - 1;
        L21:
            if ((-1) >= r106) goto L26;
            RecyclerView r107 = r100.l(r105.getChildAt(r106));
            if (r107 != null) goto L24;
            r106 = r106 - 1;
            goto L21
        L24:
            return r107;
        }
    }

    boolean B();

    void a(RecyclerView r100, ListEdge r101, int r102);

    boolean c();

    View getNestedContainerView();

    View getNestedScrollTarget();

    String getNodeTagWhenNestedScroll();

    boolean h();

    boolean i();

    boolean j();

    NestedJudgmentEdge k();

    RecyclerView l(View r100);

    boolean o();

    List<com.bytedance.locallife.dito.view.a> r();

    void s();
}
