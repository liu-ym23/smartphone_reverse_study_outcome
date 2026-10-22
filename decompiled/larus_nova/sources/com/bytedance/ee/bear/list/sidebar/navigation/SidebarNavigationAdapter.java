package com.bytedance.ee.bear.list.sidebar.navigation;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelFactory;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.utils.ContextsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0014\u001a\u00020\u00102\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000fJ\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0014J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/list/sidebar/navigation/SidebarNavigationAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/list/sidebar/navigation/SidebarNavigationItem;", "Lcom/chad/library/adapter/base/BaseViewHolder;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "data", "", "isPadMode", "", "position", "", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/List;ZI)V", "listener", "Lkotlin/Function1;", "", "driveItemView", "Landroid/view/View;", "selectedPosition", "setOnItemClickListener", "convert", "helper", MapController.ITEM_LAYER_TAG, "getDriveItemView", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarNavigationAdapter extends BaseQuickAdapter<b, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super b, Unit> f229595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f229596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f229597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f229598d;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SidebarNavigationAdapter f229599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<b> f229600b;

        public a(SidebarNavigationAdapter r100, List<b> r101) {
            this.f229599a = r100;
            this.f229600b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ForsetiViewMode r101 = (ForsetiViewMode) r100;
            if (this.f229599a.f229598d < this.f229600b.size()) goto L5;
            tt5.a.d(SidebarNavigationAdapter.y2(), "selectedPosition is out of range");
            return;
        L5:
            SidebarNavigationAdapter r102 = this.f229599a;
            r102.notifyItemChanged(r102.f229598d);
        }
    }

    public static final /* synthetic */ String y2() {
        return BaseQuickAdapter.TAG;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, b r101) {
        b r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "helper");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        int r103 = r100.getAdapterPosition();
        if (this.f229597c == true) goto L7;
        LKUIRoundedImageView2 r104 = (LKUIRoundedImageView2) r100.itemView.findViewById(R.id.sidebar_navi_item_bg);
        if (r104 == null) goto L24;
        r104.setBackgroundColor(r102.f229621c);
    L24:
        AppCompatImageView r105 = (AppCompatImageView) r100.itemView.findViewById(R.id.sidebar_navi_item_icon);
        TextView r106 = (TextView) r100.itemView.findViewById(R.id.sidebar_navi_item_title);
        r105.setImageResource(r102.f229620b);
        int r107 = r102.f229623e;
        if (r107 == 0) goto L27;
        l.c(r105, r107);
    L28:
        r106.setText(r102.f229622d);
        r100.itemView.setOnClickListener(new com.bytedance.ee.bear.list.sidebar.navigation.a(this, r103, r102));
        if (r102.f229619a != NavigationEnum.SIDEBAR_DRIVE.f228307id) goto L32;
        this.f229596b = r100.itemView;
        return;
    L32:
        return;
    L27:
        r105.setImageTintList(null);
        goto L28
    L7:
        com.ss.android.lark.forsetiutils.b r108 = com.ss.android.lark.forsetiutils.b.f424768a;
        Activity r109 = ContextsKt.findActivity(r100.itemView.getContext());
        if ((r109 instanceof FragmentActivity) == false) goto L10;
        FragmentActivity r110 = (FragmentActivity) r109;
    L11:
        r108.getClass();
        ForsetiViewMode r111 = com.ss.android.lark.forsetiutils.b.a(r110);
        boolean r112 = true;
        if (r111 != null) goto L14;
    L16:
        boolean r113 = false;
    L17:
        if (r113 == false) goto L19;
        r100.itemView.setSelected(false);
        goto L24
    L19:
        View r114 = r100.itemView;
        if (r103 == this.f229598d) goto L23;
        r112 = false;
    L23:
        r114.setSelected(r112);
        goto L24
    L14:
        if (r111.isCompact() != true) goto L16;
        r113 = true;
        goto L17
    L10:
        r110 = null;
        goto L11
    }

    public SidebarNavigationAdapter(Fragment r100, List<b> r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r102 == false) goto L5;
        int r104 = R.layout.sidebar_navigation_item_androidpad;
    L6:
        super(r104, r101);
        this.f229597c = r102;
        this.f229598d = r103;
        if (ForsetiHelper.n() == false) goto L10;
        ((ForsetiViewModel) new ViewModelProvider(r100, new ForsetiViewModelFactory(r100.requireActivity())).get(ForsetiViewModel.class)).getViewMode().observe(r100.getViewLifecycleOwner(), new a(this, r101));
        return;
    L10:
        return;
    L5:
        r104 = R.layout.sidebar_navigation_item;
        goto L6
    }
}
