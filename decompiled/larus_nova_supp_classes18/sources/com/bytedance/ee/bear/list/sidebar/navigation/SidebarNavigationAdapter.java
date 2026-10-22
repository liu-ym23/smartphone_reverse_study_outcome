package com.bytedance.ee.bear.list.sidebar.navigation;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModel;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelFactory;
import com.bytedance.ee.bear.list.homepage.navigation.NavigationEnum;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.ui.l;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.ss.android.lark.api.bean.ForsetiViewMode;
import com.ss.android.lark.utils.ContextsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0014\u001a\u00020\u00102\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000fJ\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0014J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/list/sidebar/navigation/SidebarNavigationAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/list/sidebar/navigation/SidebarNavigationItem;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "fragment", "Landroidx/fragment/app/Fragment;", WikiFolderPushPlugin.DATA, "", "isPadMode", "", "position", "", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/List;ZI)V", "listener", "Lkotlin/Function1;", "", "driveItemView", "Landroid/view/View;", "selectedPosition", "setOnItemClickListener", "convert", "helper", "item", "getDriveItemView", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarNavigationAdapter extends BaseQuickAdapter<b, BaseViewHolder> {
    public Function1<? super b, Unit> a;
    public View b;
    public final boolean c;
    public int d;

    public static final class a<T> implements Observer {
        public final /* synthetic */ SidebarNavigationAdapter a;
        public final /* synthetic */ List<b> b;

        public a(SidebarNavigationAdapter r1, List<b> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            ForsetiViewMode r3 = (ForsetiViewMode) r2;
            if (this.a.d < this.b.size()) goto L5;
            tt5.a.d(SidebarNavigationAdapter.y2(), "selectedPosition is out of range");
            return;
        L5:
            SidebarNavigationAdapter r4 = this.a;
            r4.notifyItemChanged(r4.d);
        }
    }

    public static final /* synthetic */ String y2() {
        return BaseQuickAdapter.TAG;
    }

    public final void convert(BaseViewHolder r7, Object r8) {
        b r9 = (b) r8;
        Intrinsics.checkNotNullParameter(r7, "helper");
        Intrinsics.checkNotNullParameter(r9, "item");
        int r0 = r7.getAdapterPosition();
        if (this.c == true) goto L7;
        LKUIRoundedImageView2 r1 = ((RecyclerView.ViewHolder) r7).itemView.findViewById(2131386415);
        if (r1 == null) goto L24;
        r1.setBackgroundColor(r9.c);
    L24:
        AppCompatImageView r2 = ((RecyclerView.ViewHolder) r7).itemView.findViewById(2131386416);
        TextView r3 = (TextView) ((RecyclerView.ViewHolder) r7).itemView.findViewById(2131386417);
        r2.setImageResource(r9.b);
        int r4 = r9.e;
        if (r4 == 0) goto L27;
        l.c(r2, r4);
    L28:
        r3.setText(r9.d);
        ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new com.bytedance.ee.bear.list.sidebar.navigation.a(this, r0, r9));
        if (r9.a != NavigationEnum.SIDEBAR_DRIVE.id) goto L32;
        this.b = ((RecyclerView.ViewHolder) r7).itemView;
        return;
    L32:
        return;
    L27:
        r2.setImageTintList(null);
        goto L28
    L7:
        com.ss.android.lark.forsetiutils.b r5 = com.ss.android.lark.forsetiutils.b.a;
        FragmentActivity r6 = ContextsKt.findActivity(((RecyclerView.ViewHolder) r7).itemView.getContext());
        if ((r6 instanceof FragmentActivity) == false) goto L10;
        FragmentActivity r10 = r6;
    L11:
        r5.getClass();
        ForsetiViewMode r11 = com.ss.android.lark.forsetiutils.b.a(r10);
        boolean r12 = true;
        if (r11 != null) goto L14;
    L16:
        boolean r13 = false;
    L17:
        if (r13 == false) goto L19;
        ((RecyclerView.ViewHolder) r7).itemView.setSelected(false);
        goto L24
    L19:
        View r14 = ((RecyclerView.ViewHolder) r7).itemView;
        if (r0 == this.d) goto L23;
        r12 = false;
    L23:
        r14.setSelected(r12);
        goto L24
    L14:
        if (r11.isCompact() != true) goto L16;
        r13 = true;
        goto L17
    L10:
        r10 = null;
        goto L11
    }

    public SidebarNavigationAdapter(Fragment r2, List<b> r3, boolean r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        if (r4 == false) goto L5;
        int r0 = 2131564866;
    L6:
        super(r0, r3);
        this.c = r4;
        this.d = r5;
        if (ForsetiHelper.n() == false) goto L10;
        new ViewModelProvider(r2, new ForsetiViewModelFactory(r2.requireActivity())).get(ForsetiViewModel.class).getViewMode().observe(r2.getViewLifecycleOwner(), new a(this, r3));
        return;
    L10:
        return;
    L5:
        r0 = 2131564865;
        goto L6
    }
}
