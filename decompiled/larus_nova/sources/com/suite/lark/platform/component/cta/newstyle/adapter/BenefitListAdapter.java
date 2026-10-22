package com.suite.lark.platform.component.cta.newstyle.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.cta.databinding.ItemBenefitListBinding;
import goc.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import loc.e;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u001a\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00030\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/adapter/BenefitListAdapter;", "Lcom/ss/android/lark/base/adapter/LarkRecyclerViewBaseAdapter;", "Lcom/suite/lark/platform/component/cta/newstyle/adapter/BenefitListAdapter$BenefitViewHolder;", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Benefit;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "getItems", "", "getItem", "position", "", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "submitList", "items", "", "BenefitViewHolder", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BenefitListAdapter extends LarkRecyclerViewBaseAdapter<BenefitViewHolder, b.C6046b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f460539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AsyncListDiffer<b.C6046b> f460540b;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/adapter/BenefitListAdapter$BenefitViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/suite/lark/platform/component/cta/databinding/ItemBenefitListBinding;", "<init>", "(Lcom/suite/lark/platform/component/cta/databinding/ItemBenefitListBinding;)V", "benefitIcon", "Landroid/widget/ImageView;", "getBenefitIcon", "()Landroid/widget/ImageView;", "benefitText", "Landroid/widget/TextView;", "getBenefitText", "()Landroid/widget/TextView;", RootDescription.ROOT_ELEMENT, "Landroid/widget/LinearLayout;", "getRoot", "()Landroid/widget/LinearLayout;", "Companion", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BenefitViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f460541d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f460542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f460543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinearLayout f460544c;

        public static final class a {
        }

        static {
        }

        public BenefitViewHolder(ItemBenefitListBinding r100) {
            super(r100.f460499a);
            this.f460542a = r100.f460500b;
            this.f460543b = r100.f460501c;
            this.f460544c = r100.f460499a;
        }
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter
    public final List<b.C6046b> getItems() {
        return this.f460540b.getCurrentList();
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getItems().size();
    }

    public final Context getContext() {
        return this.f460539a;
    }

    public BenefitListAdapter(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f460539a = r100;
        this.f460540b = new AsyncListDiffer(this, new BenefitListAdapter$differ$1());
    }

    @Override // com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter
    public final b.C6046b getItem(int r100) {
        return (b.C6046b) ListProtector.get(this.f460540b.getCurrentList(), r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BenefitViewHolder r102 = (BenefitViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        b.C6046b r103 = (b.C6046b) ListProtector.get(this.f460540b.getCurrentList(), r101);
        ImageView r104 = r102.f460542a;
        Context r105 = this.f460539a;
        String r106 = r103.b();
        String r107 = "";
        if (r106 != null) goto L5;
        r106 = "";
    L5:
        e.a(r104, r105, r106, Integer.valueOf(R.color.icon_n3));
        TextView r108 = r102.f460543b;
        String r109 = r103.a();
        if (r109 == null) goto L9;
        r107 = r109;
    L9:
        r108.setText(r107);
        int r110 = UIUtils.dp2px(this.f460539a, 12.0f);
        ViewGroup.LayoutParams r111 = r102.f460544c.getLayoutParams();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        if (r101 != (getItemCount() - 1)) goto L12;
        r112.setMargins(0, 0, 0, 0);
    L13:
        r102.f460544c.setLayoutParams(r112);
        return;
    L12:
        r112.setMargins(0, 0, 0, r110);
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r102 = BenefitViewHolder.f460541d;
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.item_benefit_list, r100, false);
        int r104 = R.id.benefit_arrow_icon;
        if (((ImageView) ViewBindings.findChildViewById(r103, R.id.benefit_arrow_icon)) == null) goto L11;
        r104 = R.id.benefit_icon;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r103, R.id.benefit_icon);
        if (r105 == null) goto L11;
        r104 = R.id.benefit_text;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.benefit_text);
        if (r106 == null) goto L11;
        return new BenefitViewHolder(new ItemBenefitListBinding((LinearLayout) r103, r105, r106));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
