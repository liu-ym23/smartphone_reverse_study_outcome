package com.bytedance.locallife.live.goodsshelves.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard;
import com.bytedance.locallife.live.goodsshelves.manager.ShelfDefaultTabManager;
import com.bytedance.locallife.live.goodsshelves.view.LiveLocalLifeShelfCardLynxView;
import com.bytedance.locallife.live.goodsshelves.viewmodel.LiveGoodsShelvesViewModel;
import com.bytedance.locallife.live.util.j0;
import com.larus.nova.R;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/viewholder/LiveLocalLifeGoodsShelvesLynxNativeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeGoodsShelvesLynxNativeViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f260308i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveLocalLifeShelfCardLynxView f260309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f260310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveGoodsShelvesViewModel f260311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveLocalLifeGoodsShelvesLynxViewHolder f260312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveLocalLifeGoodsShelvesViewHolder f260313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f260314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveGoodsShelvesCard f260315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f260316h;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLocalLifeGoodsShelvesLynxNativeViewHolder f260317a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        public a(LiveLocalLifeGoodsShelvesLynxNativeViewHolder r100) {
            this.f260317a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            Set<String> r101 = gv6.c.f482831a;
            gv6.c.a(this.f260317a.f260315g);
            this.f260317a.f260310b.invoke();
        }
    }

    public LiveLocalLifeGoodsShelvesLynxNativeViewHolder(LiveLocalLifeShelfCardLynxView r100, Function0<Unit> r101, LiveGoodsShelvesViewModel r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "checkShowListener");
        super(r100);
        this.f260309a = r100;
        this.f260310b = r101;
        this.f260311c = r102;
        ShelfDefaultTabManager.b();
        this.f260316h = -1;
        this.f260312d = new LiveLocalLifeGoodsShelvesLynxViewHolder(r100.getLynxView(), r101, r102);
        r100.setViewHolder(this);
        r100.setAttachStateListener(new a(this));
    }

    public final void T3(LiveGoodsShelvesCard r110, int r111, FragmentActivity r112, int r113, int r114, boolean r115, com.bytedance.locallife.live.goodsshelves.manager.i r116, Boolean r117) {
        this.f260314f = true;
        if (this.f260313e != null) goto L11;
        LiveLocalLifeShelfCardLynxView r100 = this.f260309a;
        LiveLocalLifeGoodsShelvesViewHolder r101 = null;
        if (r100.f260269c != null) goto L7;
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.saas_poi_item_live_goods_shelves, null);
        r100.f260269c = r102;
        r100.addView(r102, UIUtils.getScreenWidth(r100.getContext()), j0.c(128));
    L7:
        View r103 = this.f260309a.getNativeLayout();
        if (r103 == null) goto L10;
        r101 = new LiveLocalLifeGoodsShelvesViewHolder(r103, false, this.f260311c);
    L10:
        this.f260313e = r101;
    L11:
        View r104 = this.f260309a.getNativeLayout();
        if (r104 == null) goto L15;
        r104.setVisibility(0);
    L15:
        this.f260309a.getLynxView().setVisibility(8);
        LiveLocalLifeGoodsShelvesViewHolder r105 = this.f260313e;
        if (r105 == null) goto L19;
        r105.U3(r110, r112, r113, r114, r115, r116, r117);
        return;
    }
}
