package com.larus.login.impl.logindialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.login.impl.databinding.LarusVerifyLongWaitLoginOptionItemBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zj9.k;
import zj9.l;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/login/impl/logindialog/VerifyLongWaitLoginOptionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/login/impl/logindialog/VerifyLongWaitLoginOptionsAdapter$ViewHolder;", "data", "", "Lcom/larus/login/impl/logindialog/VerifyLongWaitLoginOptionItemModel;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getBgRes", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VerifyLongWaitLoginOptionsAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f357847a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/login/impl/logindialog/VerifyLongWaitLoginOptionsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/login/impl/databinding/LarusVerifyLongWaitLoginOptionItemBinding;", "<init>", "(Lcom/larus/login/impl/databinding/LarusVerifyLongWaitLoginOptionItemBinding;)V", "bindItem", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/login/impl/logindialog/VerifyLongWaitLoginOptionItemModel;", "bgRes", "", "needDivider", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f357848b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusVerifyLongWaitLoginOptionItemBinding f357849a;

        public ViewHolder(LarusVerifyLongWaitLoginOptionItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f357630d);
            this.f357849a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f357847a.size();
    }

    public VerifyLongWaitLoginOptionsAdapter(List<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f357847a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        if (r101 >= (this.f357847a.size() - 1)) goto L5;
        boolean r103 = true;
    L6:
        final k r104 = (k) CollectionsKt.getOrNull(this.f357847a, r101);
        int r105 = this.f357847a.size();
        if (r105 > 1) goto L9;
        int r106 = R.drawable.larus_bg_item_selector_only;
    L15:
        if (r104 != null) goto L17;
        r102.getClass();
        return;
    L17:
        e1.x(r102.f357849a.f357630d);
        r102.f357849a.f357630d.setBackgroundResource(r106);
        r102.f357849a.f357629c.setImageResource(r104.f572538a);
        r102.f357849a.f357631e.setText(r104.f572539b);
        e1.y(r102.f357849a.f357628b, r103);
        r102.f357849a.f357630d.setOnClickListener(new l(r104));
        return;
    L9:
        if (r101 != 0) goto L12;
        r106 = R.drawable.larus_bg_login_item_first;
        goto L15
    L12:
        if (r101 != (r105 - 1)) goto L14;
        r106 = R.drawable.larus_bg_login_item_last;
        goto L15
    L14:
        r106 = R.drawable.larus_bg_login_item_middle;
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_verify_long_wait_login_option_item, r100, false);
        int r103 = R.id.arrow;
        if (((ImageView) ViewBindings.findChildViewById(r102, R.id.arrow)) == null) goto L13;
        r103 = R.id.divider;
        View r104 = ViewBindings.findChildViewById(r102, R.id.divider);
        if (r104 == null) goto L13;
        r103 = R.id.icon;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r102, R.id.icon);
        if (r105 == null) goto L13;
        ConstraintLayout r106 = (ConstraintLayout) r102;
        r103 = R.id.title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.title);
        if (r107 == null) goto L13;
        return new ViewHolder(new LarusVerifyLongWaitLoginOptionItemBinding(r106, r104, r105, r106, r107));
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
