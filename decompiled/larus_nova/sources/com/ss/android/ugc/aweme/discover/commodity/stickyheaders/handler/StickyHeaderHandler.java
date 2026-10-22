package com.ss.android.ugc.aweme.discover.commodity.stickyheaders.handler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.commodity.stickyheaders.StickyHeader;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class StickyHeaderHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f450355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Fragment> f450356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView.ViewHolder f450357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f450358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Integer> f450359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f450360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f450361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f450362h;

    public static class StickyHeaderViewModel extends ViewModel {
        private WeakReference<ViewGroup> mStickyHeaderContainerRef;

        public ViewGroup getStickyHeaderContainer() {
            WeakReference<ViewGroup> r100 = this.mStickyHeaderContainerRef;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.get();
        }

        public StickyHeaderViewModel() {
        }

        public void setStickyHeaderContainer(ViewGroup r100) {
            this.mStickyHeaderContainerRef = new WeakReference(r100);
        }
    }

    public final void c() {
        final int r100 = this.f450361g;
        Fragment r101 = this.f450356b.get();
        ViewGroup r102 = b(this.f450355a);
        if (r102 == null) goto L6;
        r102.post(new AnonymousClass2(this, r100));
        return;
    }

    public static ViewGroup b(RecyclerView r100) {
        Context r101 = r100.getContext();
        if ((r101 instanceof FragmentActivity) == true) goto L5;
        return null;
    L5:
        return ((StickyHeaderViewModel) ViewModelProviders.of((FragmentActivity) r101).get(StickyHeaderViewModel.class)).getStickyHeaderContainer();
    }

    public final void a(int r100) {
        if (this.f450358d == null) goto L9;
        Logger.a("FilterMix", "detachHeader position = " + r100);
        Fragment r101 = this.f450356b.get();
        ViewGroup r102 = b(this.f450355a);
        if (r102 == null) goto L7;
        r102.removeView(this.f450358d);
    L7:
        this.f450358d.setTag(R.id.search_sticky_view_tag, null);
        this.f450355a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f450362h);
        this.f450358d = null;
        this.f450357c = null;
        return;
    }

    public StickyHeaderHandler(RecyclerView r100, Fragment r101) {
        this.f450361g = -1;
        this.f450362h = new AnonymousClass1(this);
        this.f450355a = r100;
        this.f450356b = new WeakReference(r101);
    }

    public final void d(int r100, Map<Integer, View> r101, ViewHolderFactory r102, boolean r103) {
        if (r103 == false) goto L5;
        int r104 = -1;
    L23:
        if (r104 == this.f450361g) goto L52;
        if (r104 != (-1)) goto L26;
        this.f450360f = true;
        c();
        this.f450361g = -1;
        return;
    L26:
        this.f450361g = r104;
        int r105 = r102.f450367b;
        RecyclerView.Adapter r106 = r102.f450368c.getAdapter();
        Intrinsics.checkNotNull(r106);
        if (r105 == r106.getItemViewType(r104)) goto L38;
        RecyclerView.Adapter r107 = r102.f450368c.getAdapter();
        Intrinsics.checkNotNull(r107);
        r102.f450367b = r107.getItemViewType(r104);
        RecyclerView.Adapter r108 = r102.f450368c.getAdapter();
        Intrinsics.checkNotNull(r108);
        ViewParent r109 = r102.f450368c.getParent();
        if (r109 == null) goto L37;
        RecyclerView.ViewHolder r110 = r108.createViewHolder((ViewGroup) r109, r102.f450367b);
        r102.f450366a = r110;
        boolean r111 = r110 instanceof StickyHeader;
        Object r112 = r110;
        if (r111 == true) goto L33;
        r112 = null;
    L33:
        StickyHeader r113 = (StickyHeader) r112;
        if (r113 == null) goto L38;
        r113.V0(r102.f450368c);
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L38:
        RecyclerView.ViewHolder r114 = r102.f450366a;
        Logger.a("FilterMix", "attachHeader viewHolder = " + r114.toString() + " itemViewType: " + r114.getItemViewType() + " hashCode = " + r114.hashCode());
        RecyclerView.ViewHolder r115 = this.f450357c;
        if (r115 == null) goto L42;
        if (r115 != r114) goto L42;
        this.f450360f = false;
        return;
    L42:
        a(this.f450361g);
        this.f450357c = r114;
        r114.itemView.setTag(R.id.search_sticky_view_tag, "sticky_view_mark");
        this.f450355a.getAdapter().onBindViewHolder(this.f450357c, r104);
        View r116 = this.f450357c.itemView;
        this.f450358d = r116;
        r116.setVisibility(4);
        this.f450355a.getViewTreeObserver().addOnGlobalLayoutListener(this.f450362h);
        Fragment r117 = this.f450356b.get();
        ViewGroup r118 = b(this.f450355a);
        if (r118 == null) goto L48;
        ViewParent r119 = this.f450358d.getParent();
        if ((r119 instanceof ViewGroup) == false) goto L47;
        ((ViewGroup) r119).removeView(this.f450358d);
    L47:
        r118.addView(this.f450358d);
    L48:
        this.f450360f = false;
        return;
    L52:
        return;
    L5:
        View r120 = (View) ((LinkedHashMap) r101).get(Integer.valueOf(r100));
        if (r120 != null) goto L8;
    L10:
        boolean r121 = false;
    L11:
        if (r121 == false) goto L15;
        int r122 = this.f450359e.indexOf(Integer.valueOf(r100));
        if (r122 <= 0) goto L15;
        r104 = ((Integer) ListProtector.get(this.f450359e, r122 - 1)).intValue();
    L15:
        Iterator<Integer> r123 = this.f450359e.iterator();
        int r124 = -1;
    L17:
        if (r123.hasNext() == false) goto L21;
        Integer r125 = r123.next();
        if (r125.intValue() > r100) goto L21;
        r124 = r125.intValue();
    L21:
        r104 = r124;
        goto L23
    L8:
        if (r120.getY() <= 0.0f) goto L10;
        r121 = true;
        goto L11
    }
}
