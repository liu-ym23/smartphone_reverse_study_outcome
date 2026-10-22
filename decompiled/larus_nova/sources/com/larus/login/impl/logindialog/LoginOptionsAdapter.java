package com.larus.login.impl.logindialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.login.impl.databinding.LarusAccountLoginDialogItemBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zj9.a;
import zj9.g;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/login/impl/logindialog/LoginOptionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/login/impl/logindialog/LoginOptionsAdapter$ViewHolder;", "data", "", "Lcom/larus/login/impl/logindialog/LoginOptionsItemModel;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginOptionsAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f357837a;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/login/impl/logindialog/LoginOptionsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/login/impl/databinding/LarusAccountLoginDialogItemBinding;", "<init>", "(Lcom/larus/login/impl/databinding/LarusAccountLoginDialogItemBinding;)V", "bindItem", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/login/impl/logindialog/LoginOptionsItemModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f357838b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusAccountLoginDialogItemBinding f357839a;

        public ViewHolder(LarusAccountLoginDialogItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "binding");
            super(r100.f357406a);
            this.f357839a = r100;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f357837a.size();
    }

    public LoginOptionsAdapter(List<g> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f357837a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final g r103 = (g) CollectionsKt.getOrNull(this.f357837a, r101);
        if (r103 != null) goto L5;
        r102.getClass();
        return;
    L5:
        e1.x(r102.f357839a.f357406a);
        r102.f357839a.f357407b.setImageResource(r103.f572526c);
        Button r104 = r102.f357839a.f357408c;
        r104.setText(r103.f572527d);
        r104.setTextColor(ContextCompat.getColor(r104.getContext(), r103.f572528e));
        r104.setBackgroundResource(r103.f572529f);
        r104.setOnClickListener(new a(r103));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_account_login_dialog_item, r100, false);
        int r103 = R.id.button_iv;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r102, R.id.button_iv);
        if (r104 == null) goto L9;
        r103 = R.id.button_login;
        Button r105 = (Button) ViewBindings.findChildViewById(r102, R.id.button_login);
        if (r105 == null) goto L9;
        FrameLayout r106 = (FrameLayout) r102;
        return new ViewHolder(new LarusAccountLoginDialogItemBinding(r106, r104, r105, r106));
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
