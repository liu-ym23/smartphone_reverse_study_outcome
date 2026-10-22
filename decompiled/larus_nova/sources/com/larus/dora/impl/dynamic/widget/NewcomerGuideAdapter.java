package com.larus.dora.impl.dynamic.widget;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.dora.impl.databinding.LarusDoraItemNewcomerGuideBinding;
import com.larus.nova.R;
import com.larus.platform.model.NewcomerGuideItem;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003)*+B'\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u001c\u0010\u001b\u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J$\u0010\u001f\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!H\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0016J\u0014\u0010&\u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u0000H\u0016J\u0014\u0010'\u001a\u00020\b2\n\u0010\u001c\u001a\u00060\u0003R\u00020\u0000H\u0016J\b\u0010(\u001a\u00020\bH\u0002R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/platform/model/NewcomerGuideItem;", "Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter$ViewHolder;", "onItemClick", "Lkotlin/Function3;", "", "", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "gradientColors", "", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "loadingDrawable$delegate", "Lkotlin/Lazy;", "logger", "Lcom/larus/dora/api/util/DoraLogger;", "loadingAnimator", "Landroid/animation/ValueAnimator;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "onCurrentListChanged", "previousList", "", "currentList", "onDetachedFromRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onViewRecycled", "onViewDetachedFromWindow", "stopAnimation", "Companion", "DiffCallback", "ViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewcomerGuideAdapter extends ListAdapter<NewcomerGuideItem, ViewHolder> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f335497f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<NewcomerGuideItem, Integer, String, Unit> f335498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f335499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f335500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g49.d f335501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f335502e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/platform/model/NewcomerGuideItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<NewcomerGuideItem> {
        public DiffCallback() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areContentsTheSame(NewcomerGuideItem r100, NewcomerGuideItem r101) {
            NewcomerGuideItem r102 = r100;
            NewcomerGuideItem r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            return Intrinsics.areEqual(r102, r103);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areItemsTheSame(NewcomerGuideItem r100, NewcomerGuideItem r101) {
            NewcomerGuideItem r102 = r100;
            NewcomerGuideItem r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            return Intrinsics.areEqual(r102.getId(), r103.getId());
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraItemNewcomerGuideBinding;", "<init>", "(Lcom/larus/dora/impl/dynamic/widget/NewcomerGuideAdapter;Lcom/larus/dora/impl/databinding/LarusDoraItemNewcomerGuideBinding;)V", "value", "Lcom/larus/platform/model/NewcomerGuideItem;", "currentItem", "getCurrentItem", "()Lcom/larus/platform/model/NewcomerGuideItem;", "", "resolvedText", "getResolvedText", "()Ljava/lang/String;", "bind", "", MapController.ITEM_LAYER_TAG, "setTextWithIcon", "textView", "Landroid/widget/TextView;", "text", "isLoading", "", "updateFocusState", "progress", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f335503e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LarusDoraItemNewcomerGuideBinding f335504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NewcomerGuideItem f335505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f335506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ NewcomerGuideAdapter f335507d;

        public final void T3(float r100) {
            g49.d r101 = this.f335507d.f335501d;
            g49.d.a("NewcomerGuideAdapter", "updateFocusState() called: progress=" + r100);
            if (r100 <= 0.9f) goto L5;
            float r102 = (r100 - 0.9f) / 0.1f;
        L6:
            this.f335504a.f332720d.setShadowColor(Color.argb((int) (41 * r102), 0, 0, 0));
            if (r100 <= 0.9f) goto L9;
            TextView r103 = this.f335504a.f332718b;
            final NewcomerGuideAdapter r104 = this.f335507d;
            r103.post(new h(this, r104));
            return;
        L9:
            this.f335504a.f332718b.getPaint().setShader(null);
            TextView r105 = this.f335504a.f332718b;
            r105.setTextColor(v19.c.a(R.attr.larus_neutral_50, r105.getContext(), R.color.larus_neutral_50));
            return;
        L5:
            r102 = 0.0f;
            goto L6
        }

        public ViewHolder(NewcomerGuideAdapter r100, LarusDoraItemNewcomerGuideBinding r101) {
            Intrinsics.checkNotNullParameter(r101, "binding");
            this.f335507d = r100;
            super(r101.f332717a);
            this.f335504a = r101;
            this.f335506c = "";
        }
    }

    public static final class a {
    }

    static {
    }

    public final void y2() {
        ValueAnimator r100 = this.f335502e;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        Animatable r101 = null;
        this.f335502e = null;
        Drawable r102 = (Drawable) this.f335500c.getValue();
        if (r102 == null) goto L8;
        r102.setCallback(null);
    L8:
        Object r103 = (Drawable) this.f335500c.getValue();
        if ((r103 instanceof Animatable) == false) goto L12;
        r101 = (Animatable) r103;
    L12:
        if (r101 != null) goto L14;
    L16:
        g49.d.a("NewcomerGuideAdapter", "stopAnimation() called");
        return;
    L14:
        if (r101.isRunning() == false) goto L16;
        r101.stop();
        g49.d.a("NewcomerGuideAdapter", "stopAnimation() called for Animatable");
        goto L16
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (getCurrentList().isEmpty() == false) goto L6;
        return 0;
    L6:
        if (getCurrentList().size() < 2) goto L11;
        return Integer.MAX_VALUE;
    L11:
        return getCurrentList().size();
    }

    public NewcomerGuideAdapter(l r100) {
        Intrinsics.checkNotNullParameter(r100, "onItemClick");
        super(new DiffCallback());
        this.f335498a = r100;
        this.f335499b = new int[]{ColorProtector.parseColor("#9966FF"), ColorProtector.parseColor("#FF5D8B"), ColorProtector.parseColor("#FFA54D")};
        this.f335500c = LazyKt.lazy(new g());
        this.f335501d = g49.d.f480008a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
        y2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewDetachedFromWindow(r101);
        y2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        y2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        final ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        if (getCurrentList().isEmpty() == false) goto L6;
        return;
    L6:
        if (getCurrentList().size() < 2) goto L8;
        final NewcomerGuideItem r111 = getItem(r110 % getCurrentList().size());
    L9:
        Intrinsics.checkNotNull(r111);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r111, MapController.ITEM_LAYER_TAG);
        r101.f335505b = r111;
        String r102 = r111.getTitleKey();
        String r103 = "";
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        String r104 = r111.getTitleText();
        boolean r105 = true;
        if (r104 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == true) goto L25;
        String r107 = r111.getTitleText();
        if (r107 == null) goto L38;
        r103 = r107;
    L38:
        r101.f335506c = r103;
        boolean r108 = r111.isLoading();
        g49.d r109 = r101.f335507d.f335501d;
        g49.d.a("NewcomerGuideAdapter", "bind() called with: item.titleKey=" + r102 + ", isLoading=" + r108);
        TextView r112 = r101.f335504a.f332718b;
        g49.d r113 = r101.f335507d.f335501d;
        g49.d.a("NewcomerGuideAdapter", "setTextWithIcon() called: isLoading=" + r108 + ", text=" + r103);
        StringBuilder r114 = new StringBuilder();
        r114.append(r103);
        r114.append(tb2.c.DEFAULT_TEXT);
        SpannableString r115 = new SpannableString(r114.toString());
        r115.setSpan(new k(c7.b(14), r108, r101.f335507d, r112), r115.length() - 2, r115.length(), 33);
        r112.setText(r115);
        g49.d r116 = r101.f335507d.f335501d;
        g49.d.a("NewcomerGuideAdapter", "setTextWithIcon() set text with ReplacementSpan");
        if (r108 == false) goto L41;
        r101.f335504a.f332717a.setScaleX(1.0f);
        r101.f335504a.f332717a.setScaleY(1.0f);
        r101.f335504a.f332717a.setAlpha(1.0f);
        r101.T3(1.0f);
    L41:
        ConstraintLayout r117 = r101.f335504a.f332719c;
        final NewcomerGuideAdapter r118 = r101.f335507d;
        e1.d(r117, new i(r101, r111, r118));
        return;
    L25:
        if (r102.length() > 0) goto L28;
        r105 = false;
    L28:
        if (r105 == true) goto L30;
    L32:
        String r119 = r102;
    L33:
        AppHost.Companion r120 = AppHost.f326268a;
        int r121 = r120.getApplication().getResources().getIdentifier(r119, "string", r120.getApplication().getPackageName());
        if (r121 == 0) goto L36;
        r103 = r120.getApplication().getString(r121);
    L37:
        Intrinsics.checkNotNull(r103);
        goto L38
    L36:
        r103 = r102;
        goto L37
    L30:
        if (StringsKt.startsWith$default(r102, "larus_", false, 2, null) == true) goto L32;
        r119 = "larus_".concat(r102);
        goto L33
    L15:
        if (r104.length() == 0) goto L18;
        r106 = false;
        goto L19
    L8:
        r111 = getItem(r110);
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_dora_item_newcomer_guide, r100, false);
        int r103 = R.id.guideContent;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.guideContent);
        if (r104 == null) goto L11;
        r103 = R.id.item_card;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(r102, R.id.item_card);
        if (r105 == null) goto L11;
        r103 = R.id.shadow_layout;
        ShadowLayout r106 = (ShadowLayout) ViewBindings.findChildViewById(r102, R.id.shadow_layout);
        if (r106 == null) goto L11;
        return new ViewHolder(this, new LarusDoraItemNewcomerGuideBinding((ConstraintLayout) r102, r104, r105, r106));
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public final void onCurrentListChanged(List<NewcomerGuideItem> r100, List<NewcomerGuideItem> r101) {
        Intrinsics.checkNotNullParameter(r100, "previousList");
        Intrinsics.checkNotNullParameter(r101, "currentList");
        super.onCurrentListChanged(r100, r101);
        notifyDataSetChanged();
    }
}
