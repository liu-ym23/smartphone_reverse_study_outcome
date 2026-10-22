package com.larus.bmhome.chat.auth;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.databinding.LarusLayoutViewPluginHintBinding;
import com.larus.bmhome.databinding.LarusLayoutViewPluginItemBinding;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B,\u0012#\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u001a\u0010\u0017\u001a\u00020\u000e2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0005R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/auth/PluginListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/chat/auth/model/PluginItem;", "Lcom/larus/bmhome/chat/auth/PluginHolder;", "getDrawable", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "res", "Landroid/graphics/drawable/Drawable;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemViewType", "setOnItemClickListener", "listener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PluginListAdapter extends ListAdapter<PluginItem, PluginHolder> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PluginListAdapter$Companion$DIFFER$1 f297291c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, Drawable> f297292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super PluginItem, Unit> f297293b;

    public static final class a {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 != 0) goto L4;
        return 0;
    L4:
        return 1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.auth.PluginListAdapter$Companion$DIFFER$1] */
    static {
        f297291c = new PluginListAdapter$Companion$DIFFER$1();
    }

    public PluginListAdapter(c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "getDrawable");
        super(f297291c);
        this.f297292a = r100;
        this.f297293b = new w();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        PluginHolder r102 = (PluginHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        List<PluginItem> r103 = getCurrentList();
        if (r101 >= 0) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
        Object r105 = ListProtector.get(r103, r101);
    L11:
        PluginItem r106 = (PluginItem) r105;
        if (r106 == null) goto L15;
        r102.T3(r106, r101, getCurrentList().size(), this.f297292a, this.f297293b);
        return;
    L15:
        return;
    L10:
        r105 = null;
        goto L11
    L5:
        if (r101 >= r103.size()) goto L7;
        r104 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        if (r111 != 0) goto L9;
        View r112 = LayoutInflater.from(r110.getContext()).inflate(R.layout.larus_layout_view_plugin_hint, r110, false);
        if (r112 == null) goto L8;
        RecyclerView.ViewHolder r113 = new PluginItemHintHolder(new LarusLayoutViewPluginHintBinding((TextView) r112));
    L26:
        return r113;
    L8:
        throw new NullPointerException("rootView");
    L9:
        View r114 = LayoutInflater.from(r110.getContext()).inflate(R.layout.larus_layout_view_plugin_item, r110, false);
        int r100 = R.id.auth_arrow;
        if (((ImageView) ViewBindings.findChildViewById(r114, R.id.auth_arrow)) == null) goto L28;
        r100 = R.id.auth_group;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r114, R.id.auth_group)) == null) goto L28;
        r100 = R.id.auth_text;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r114, R.id.auth_text);
        if (r101 == null) goto L28;
        r100 = R.id.author;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r114, R.id.author);
        if (r102 == null) goto L28;
        ConstraintLayout r103 = (ConstraintLayout) r114;
        r100 = R.id.desc;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r114, R.id.desc);
        if (r104 == null) goto L28;
        r100 = R.id.divider;
        View r105 = ViewBindings.findChildViewById(r114, R.id.divider);
        if (r105 == null) goto L28;
        r100 = R.id.icon;
        SimpleDraweeView r106 = (SimpleDraweeView) ViewBindings.findChildViewById(r114, R.id.icon);
        if (r106 == null) goto L28;
        r100 = R.id.name;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r114, R.id.name);
        if (r115 == null) goto L28;
        r113 = new PluginItemContentHolder(new LarusLayoutViewPluginItemBinding(r103, r101, r102, r103, r104, r105, r106, r115));
    L28:
        throw new NullPointerException("Missing required view with ID: ".concat(r114.getResources().getResourceName(r100)));
    }
}
