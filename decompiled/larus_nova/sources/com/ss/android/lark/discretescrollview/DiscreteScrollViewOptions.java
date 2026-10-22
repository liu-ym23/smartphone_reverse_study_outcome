package com.ss.android.lark.discretescrollview;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes35.dex */
public class DiscreteScrollViewOptions {
    private static final int TRANSITION_TIME = 100;
    private static DiscreteScrollViewOptions instance;
    private final String KEY_TRANSITION_TIME;

    public class a implements PopupMenu.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.Adapter f420442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DiscreteScrollView f420443b;

        @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem r100) {
            int r101 = CastIntegerProtector.parseInt(String.valueOf(r100.getTitle())) - 1;
            RecyclerView.Adapter r102 = this.f420442a;
            if ((r102 instanceof InfiniteScrollAdapter) == true) goto L6;
            this.f420443b.smoothScrollToPosition(r101);
            return true;
        L6:
            ((InfiniteScrollAdapter) r102).getClass();
            throw null;
        }

        public a(RecyclerView.Adapter r100, DiscreteScrollView r101) {
            this.f420442a = r100;
            this.f420443b = r101;
        }
    }

    public static void configureTransitionTime(DiscreteScrollView r100) {
    }

    public static int getTransitionTime() {
        return 100;
    }

    private DiscreteScrollViewOptions(Context r100) {
        this.KEY_TRANSITION_TIME = "pref_key_transition_time";
    }

    public static void init(Context r100) {
        instance = new DiscreteScrollViewOptions(r100);
    }

    public static void smoothScrollToUserSelectedPosition(DiscreteScrollView r100, View r101) {
        PopupMenu r102 = new PopupMenu(r100.getContext(), r101, GravityCompat.START);
        Menu r103 = r102.getMenu();
        RecyclerView.Adapter r104 = r100.getAdapter();
        if ((r104 instanceof InfiniteScrollAdapter) == true) goto L12;
        int r105 = 0;
        if (r104 == null) goto L7;
        int r106 = r104.getItemCount();
    L8:
        if (r105 >= r106) goto L10;
        r105 = r105 + 1;
        r103.add(String.valueOf(r105));
        goto L8
    L10:
        r102.setOnMenuItemClickListener(new a(r104, r100));
        r102.show();
        return;
    L7:
        r106 = 0;
        goto L8
    L12:
        ((InfiniteScrollAdapter) r104).getClass();
        throw null;
    }
}
