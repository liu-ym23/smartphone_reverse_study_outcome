package com.larus.slides.impl.select;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.slides.biz.impl.databinding.LarusSlidesItemGenerateImageBinding;
import com.larus.slides.biz.impl.databinding.LarusSlidesLayoutBotEditErrorLayBinding;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u001a\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u0004H\u0016J;\u0010$\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2%\b\u0002\u0010&\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R7\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R+\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/slides/impl/select/GenerateImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "defaultImageWidth", "", "defaultImageHeight", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "dataList", "", "Lcom/larus/slides/impl/select/GenerateImageViewHolder$GenerateImageItemData;", "onItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClick", "getOnItemLongClick", "setOnItemLongClick", "outerAnyImageSet", "", "success", "internalFinalImageSet", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "refreshData", "data", "onAnyImageSet", "DiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenerateImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f369567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f369568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<GenerateImageViewHolder.b> f369569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Integer, Unit> f369570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super Integer, Unit> f369571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f369572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f369573g;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/slides/impl/select/GenerateImageAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/slides/impl/select/GenerateImageViewHolder$GenerateImageItemData;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<GenerateImageViewHolder.b> f369574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<GenerateImageViewHolder.b> f369575b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            if (r100 != r101) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            return this.f369575b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            return this.f369574a.size();
        }

        public DiffCallback(List<GenerateImageViewHolder.b> r100, List<GenerateImageViewHolder.b> r101) {
            Intrinsics.checkNotNullParameter(r100, "oldItems");
            Intrinsics.checkNotNullParameter(r101, "newItems");
            this.f369574a = r100;
            this.f369575b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            GenerateImageViewHolder.b r102 = (GenerateImageViewHolder.b) ListProtector.get(this.f369575b, r101);
            GenerateImageViewHolder.b r103 = (GenerateImageViewHolder.b) ListProtector.get(this.f369574a, r100);
            if (r102.f369593a == r103.f369593a) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(r102.f369597e, r103.f369597e) == false) goto L9;
            if (Intrinsics.areEqual(r102.f369599g, r103.f369599g) == false) goto L9;
            return true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f369569c.size();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.slides.impl.select.c] */
    public GenerateImageAdapter(Integer r100, Integer r101) {
        this.f369567a = r100;
        this.f369568b = r101;
        this.f369569c = CollectionsKt.emptyList();
        this.f369573g = new c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v0, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, java.lang.Integer] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, final int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        final GenerateImageViewHolder.b r100 = (GenerateImageViewHolder.b) CollectionsKt.getOrNull(this.f369569c, r111);
        if (r100 == null) goto L34;
        Uri r101 = null;
        if ((r110 instanceof GenerateImageViewHolder) == false) goto L7;
        final GenerateImageViewHolder r102 = (GenerateImageViewHolder) r110;
    L8:
        if (r102 == null) goto L34;
        Intrinsics.checkNotNullParameter(r100, "data");
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = r100.f369600h;
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        ?? r105 = r100.f369601i;
        r104.element = r105;
        T r106 = r103.element;
        if (r106 == 0) goto L16;
        if (r105 == 0) goto L16;
        if (((Number) r106).intValue() <= 0) goto L16;
        if (((Number) r104.element).intValue() <= 0) goto L16;
    L17:
        r102.f369589a.f369350c.post(new q(r103, r104, r102));
        if (r100.f369593a == false) goto L20;
        r102.f369589a.f369350c.getHierarchy().setPlaceholderImage(R.color.larus_base_2);
        e1.o(r102.f369589a.f369351d);
        e1.o(r102.f369589a.f369354g);
        e1.x(r102.f369589a.f369349b.f369364a);
        LarusSlidesItemGenerateImageBinding r107 = r102.f369589a;
        r107.f369349b.f369366c.setText(r107.f369348a.getContext().getString(R.string.larus_generation_failed_error_message));
        goto L34
    L20:
        r102.f369589a.f369350c.getHierarchy().setPlaceholderImage(R.drawable.larus_bg_ugc_create_placeholder);
        e1.x(r102.f369589a.f369350c);
        e1.o(r102.f369589a.f369349b.f369364a);
        final SimpleDraweeView r108 = r102.f369589a.f369350c;
        String r109 = r100.f369594b;
        if (r109 == null) goto L23;
        r101 = UriProtector.parse(r109);
    L23:
        final Function1 r112 = new r(r100, r102);
        final boolean r113 = false;
        final Integer r114 = null;
        final Integer r115 = null;
        final boolean r116 = false;
        Intrinsics.checkNotNullParameter(r108, "<this>");
        ImageLoaderKt.x(r108, r101, "slides_generate_image_view_holder", null, new com.larus.slides.impl.select.utils.h(r113, r116, r108, r112, r115, r114), 4);
        if (r100.f369594b != null) goto L34;
        if (r100.f369599g == null) goto L34;
        if (r102.f369589a.f369351d.getVisibility() != 0) goto L30;
        boolean r117 = true;
    L31:
        if (r117 == true) goto L33;
        e1.x(r102.f369589a.f369351d);
        e1.o(r102.f369589a.f369354g);
        r102.f369589a.f369352e.setRepeatMode(1);
        r102.f369589a.f369352e.setRepeatCount(-1);
        r102.f369589a.f369352e.setAnimation("lottie/ai_img_loading.json");
        r102.f369589a.f369352e.playAnimation();
    L33:
        r102.f369589a.f369353f.setText(r102.f369589a.f369348a.getContext().getString(R.string.larus_generating_loading) + ' ' + r100.f369599g + '%');
        goto L34
    L30:
        r117 = false;
    L16:
        r103.element = r102.f369590b;
        r104.element = r102.f369591c;
        goto L17
    L7:
        r102 = null;
    L34:
        e1.d(r110.itemView, new a(this, r111));
        r110.itemView.setOnLongClickListener(new b(this, r111));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        View r112 = LayoutInflater.from(r110.getContext()).inflate(R.layout.larus_slides_item_generate_image, r110, false);
        int r100 = R.id.error_lay;
        View r101 = ViewBindings.findChildViewById(r112, R.id.error_lay);
        if (r101 == null) goto L21;
        FrameLayout r102 = (FrameLayout) r101;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r101, R.id.tips);
        if (r103 == null) goto L19;
        LarusSlidesLayoutBotEditErrorLayBinding r104 = new LarusSlidesLayoutBotEditErrorLayBinding(r102, r102, r103);
        r100 = R.id.image;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r112, R.id.image);
        if (r105 == null) goto L21;
        r100 = R.id.progress_container;
        LinearLayout r106 = (LinearLayout) ViewBindings.findChildViewById(r112, R.id.progress_container);
        if (r106 == null) goto L21;
        r100 = R.id.progress_icon;
        LottieAdapterView r113 = (LottieAdapterView) ViewBindings.findChildViewById(r112, R.id.progress_icon);
        if (r113 == null) goto L21;
        r100 = R.id.progress_tv;
        TextView r114 = (TextView) ViewBindings.findChildViewById(r112, R.id.progress_tv);
        if (r114 == null) goto L21;
        r100 = R.id.watermark;
        ImageView r115 = (ImageView) ViewBindings.findChildViewById(r112, R.id.watermark);
        if (r115 == null) goto L21;
        return new GenerateImageViewHolder(new LarusSlidesItemGenerateImageBinding((FrameLayout) r112, r104, r105, r106, r113, r114, r115), this.f369567a, this.f369568b, this.f369573g);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(R.id.tips)));
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r100)));
    }
}
