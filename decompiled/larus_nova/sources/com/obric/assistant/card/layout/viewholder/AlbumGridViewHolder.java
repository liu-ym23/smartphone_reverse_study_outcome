package com.obric.assistant.card.layout.viewholder;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.card.databinding.ObricCardPhotoGridContainerBinding;
import com.obric.assistant.card.databinding.ObricCardPhotoGridItemBinding;
import com.obric.assistant.card.layout.adapter.AppEntityListAdapter;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder;
import com.obric.assistant.card.provider.PrivilegedUriProvider;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/AlbumGridViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/abs/AbsCardItemViewHolder;", "Lcom/obric/assistant/card/layout/bean/wrapper/PhotoEntityGridStyleWrapper;", "Lcom/obric/assistant/card/databinding/ObricCardPhotoGridContainerBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "defaultPaddingStart", "", "defaultPaddingTop", "defaultPaddingEnd", "defaultPaddingBottom", "itemGap", "getItemGap", "()I", "itemGap$delegate", "Lkotlin/Lazy;", "onBind", "", "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "isDeleted", "", "isRefreshed", "Companion", "MyAdapter", "MyViewHolder", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumGridViewHolder extends AbsCardItemViewHolder<mca.c, ObricCardPhotoGridContainerBinding> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f386338p = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtMostHeightRecyclerView f386339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f386340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f386341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f386342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f386343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f386344o;

    public static final class Companion {
        public Companion() {
        }

        public static Uri b(PhotoEntity r100) {
            Intrinsics.checkNotNullParameter(r100, "photoEntity");
            if (r100.getAssetType() != AssetTypeEnum.VIDEO) goto L5;
            boolean r101 = true;
        L6:
            int r102 = PrivilegedUriProvider.f386540b;
            return PrivilegedUriProvider.a.a(r100.getFile().getContentUrl(), r100.getPackageName(), r101, r101);
        L5:
            r101 = false;
            goto L6
        }

        public static ImageRequestBuilder a(ImageRequestBuilder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "builder");
            return r100.setResizeOptions(new ResizeOptions(r101, r101)).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build());
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0083 -> B:25:0x004d). Please report as a decompilation issue!!! */
        public final Object c(final int r110, List<PhotoEntity> r111, Continuation<? super Unit> r112) {
            if ((r112 instanceof AlbumGridViewHolder$Companion$prefetchThumbnails$1) == false) goto L7;
            AlbumGridViewHolder$Companion$prefetchThumbnails$1 r100 = (AlbumGridViewHolder$Companion$prefetchThumbnails$1) r112;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r113 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            if (r103 == 0) goto L20;
            if (r103 != 1) goto L19;
            r110 = r100.I$0;
            Iterator r114 = (Iterator) r100.L$0;
            ResultKt.throwOnFailure(r113);     // Catch: Exception -> L14 CancellationException -> L16
            r114 = r114;
        L26:
            if (r114.hasNext() == false) goto L34;
            PhotoEntity r115 = (PhotoEntity) r114.next();
            JobKt.ensureActive(r100.getContext());
            Companion r104 = AlbumGridViewHolder.f386338p;
            String r105 = b(r115).toString();     // Catch: Exception -> L14 CancellationException -> L16
            Function1 r106 = new com.obric.assistant.card.layout.viewholder.b(r110);     // Catch: Exception -> L14 CancellationException -> L16
            r100.L$0 = r114;     // Catch: Exception -> L14 CancellationException -> L16
            r100.I$0 = r110;     // Catch: Exception -> L14 CancellationException -> L16
            r100.label = 1;     // Catch: Exception -> L14 CancellationException -> L16
            if (ImageLoaderKt.A(r105, "obric_chat.cards", null, null, r106, r100, 28) != r102) goto L26;
            return r102;
        L34:
            return Unit.INSTANCE;
        L16:
            e = move-exception;
            throw e;
        L14:
            e = move-exception;
            FLogger.f375446a.w("AlbumGridViewHolder", "prefetch thumbnail failed: " + e.getMessage(), e);
            r114 = r114;
            goto L26
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L20:
            ResultKt.throwOnFailure(r113);
            if (r111.isEmpty() == true) goto L23;
            r114 = r111.iterator();
            goto L26
        L23:
            return Unit.INSTANCE;
        L7:
            r100 = new AlbumGridViewHolder$Companion$prefetchThumbnails$1(this, r112);
            goto L8
        }
    }

    public static final class a extends RecyclerView.Adapter<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AlbumGridViewHolder f386346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<PhotoEntity> f386347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f386348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f386349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f386350e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AppEntityListAdapter.PageType f386351f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public MessageExtraForViewHolder f386352g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Lazy f386353h;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            AppEntityListAdapter.PageType r100 = this.f386351f;
            if (r100 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("pageType");
            r100 = null;
        L6:
            if (r100 != AppEntityListAdapter.PageType.ChatPage) goto L10;
            return RangesKt.coerceAtMost(((ArrayList) this.f386347b).size(), 6);
        L10:
            return ((ArrayList) this.f386347b).size();
        }

        public a(AlbumGridViewHolder r110) {
            Intrinsics.checkNotNullParameter(r110, "parentViewHolder");
            this.f386346a = r110;
            this.f386347b = new ArrayList();
            this.f386348c = 1;
            this.f386349d = 1;
            this.f386352g = new MessageExtraForViewHolder(false, false, null, null, null, null, null, 127);
            this.f386353h = LazyKt.lazy(new e(this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            final b r112 = (b) r110;
            Intrinsics.checkNotNullParameter(r112, "holder");
            PhotoEntity r100 = (PhotoEntity) ListProtector.get(this.f386347b, r111);
            int r101 = this.f386348c;
            if (r111 >= r101) goto L5;
            boolean r102 = true;
        L7:
            if ((r111 / r101) != (this.f386349d - 1)) goto L9;
            boolean r103 = true;
        L11:
            if ((r111 % r101) != 0) goto L13;
            boolean r104 = true;
        L14:
            int r105 = getItemCount();
            int r106 = this.f386348c;
            if (r105 >= r106) goto L17;
            int r107 = getItemCount() - 1;
        L19:
            if ((r111 % this.f386348c) != r107) goto L21;
            boolean r108 = true;
        L22:
            if (r102 == false) goto L25;
            if (r104 == false) goto L25;
            boolean r109 = true;
        L26:
            if (r102 == false) goto L29;
            if (r108 == false) goto L29;
            boolean r113 = true;
        L30:
            if (r103 == false) goto L33;
            if (r104 == false) goto L33;
            boolean r114 = true;
        L34:
            if (r103 == false) goto L37;
            if (r108 == false) goto L37;
            boolean r115 = true;
        L38:
            r112.getClass();
            if (r114 == false) goto L42;
            if (r115 == false) goto L42;
            int r116 = R.drawable.obric_card_video_icon_mask_b;
        L47:
            r112.f386354a.f386200e.setBackgroundResource(r116);
            if (r109 == false) goto L54;
            if (r113 == false) goto L54;
            if (r114 == false) goto L54;
            if (r115 == false) goto L54;
            r112.f386354a.f386197b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(this.f386350e));
            r112.f386354a.f386197b.setBackgroundResource(R.drawable.obric_card_image_placeholder);
        L69:
            GenericDraweeHierarchy r117 = r112.f386354a.f386197b.getHierarchy();
            ScalingUtils.ScaleType r118 = ScalingUtils.ScaleType.CENTER;
            r117.setPlaceholderImage(R.drawable.obric_card_photo_load_failed, r118);
            r112.f386354a.f386197b.getHierarchy().setFailureImage(R.drawable.obric_card_photo_load_failed, r118);
            if (r100.getAssetType() != AssetTypeEnum.VIDEO) goto L72;
            boolean r119 = true;
        L73:
            Companion r120 = AlbumGridViewHolder.f386338p;
            Uri r121 = Companion.b(r100);
            String r122 = r121.toString();
            if (Intrinsics.areEqual(r112.f386355b, r122) == true) goto L76;
            r112.f386355b = r122;
            ImageLoaderKt.x(r112.f386354a.f386197b, r121, "obric_chat.cards", null, new c(r112, this), 4);
        L76:
            ImageView r123 = r112.f386354a.f386199d;
            if (r119 == false) goto L79;
            int r124 = 0;
        L80:
            r123.setVisibility(r124);
            View r125 = r112.f386354a.f386200e;
            if (r119 == false) goto L83;
            int r126 = 0;
        L84:
            r125.setVisibility(r126);
            int r127 = ((ArrayList) this.f386347b).size() - getItemCount();
            if (r111 != (getItemCount() - 1)) goto L87;
            boolean r128 = true;
        L88:
            if (r128 == false) goto L91;
            if (r127 <= 0) goto L91;
            r112.f386354a.f386198c.setVisibility(0);
            r112.f386354a.f386198c.setText(r112.itemView.getContext().getString(R.string.obric_card_photo_more_count, new Object[]{Integer.valueOf(r127)}));
            e1.d(r112.f386354a.f386198c, new d(this));
        L92:
            this.f386346a.W3(r112.itemView, this.f386347b, r100, r111);
            return;
        L91:
            r112.f386354a.f386198c.setVisibility(8);
            r112.f386354a.f386198c.setOnClickListener(null);
            goto L92
        L87:
            r128 = false;
            goto L88
        L83:
            r126 = 8;
            goto L84
        L79:
            r124 = 8;
            goto L80
        L72:
            r119 = false;
        L54:
            if (r109 == false) goto L57;
            if (r114 == false) goto L57;
            GenericDraweeHierarchy r129 = r112.f386354a.f386197b.getHierarchy();
            float r130 = this.f386350e;
            r129.setRoundingParams(RoundingParams.fromCornersRadii(r130, 0.0f, 0.0f, r130));
            r112.f386354a.f386197b.setBackgroundResource(R.drawable.obric_card_image_placeholder_l);
        L57:
            if (r113 == false) goto L60;
            if (r115 == false) goto L60;
            GenericDraweeHierarchy r131 = r112.f386354a.f386197b.getHierarchy();
            float r132 = this.f386350e;
            r131.setRoundingParams(RoundingParams.fromCornersRadii(0.0f, r132, r132, 0.0f));
            r112.f386354a.f386197b.setBackgroundResource(R.drawable.obric_card_image_placeholder_r);
        L60:
            if (r109 == false) goto L62;
            r112.f386354a.f386197b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(this.f386350e, 0.0f, 0.0f, 0.0f));
            r112.f386354a.f386197b.setBackgroundResource(R.drawable.obric_card_image_placeholder_tl);
            goto L69
        L62:
            if (r113 == false) goto L64;
            r112.f386354a.f386197b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, this.f386350e, 0.0f, 0.0f));
            r112.f386354a.f386197b.setBackgroundResource(R.drawable.obric_card_image_placeholder_tr);
            goto L69
        L64:
            if (r114 == false) goto L66;
            r112.f386354a.f386197b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, 0.0f, this.f386350e));
            r112.f386354a.f386197b.setBackgroundResource(R.drawable.obric_card_image_placeholder_bl);
            goto L69
        L66:
            if (r115 == false) goto L68;
            r112.f386354a.f386197b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, this.f386350e, 0.0f));
            r112.f386354a.f386197b.setBackgroundResource(R.drawable.obric_card_image_placeholder_br);
            goto L69
        L68:
            r112.f386354a.f386197b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, 0.0f, 0.0f));
            r112.f386354a.f386197b.setBackgroundResource(R.drawable.obric_card_image_placeholder_no);
        L42:
            if (r114 == false) goto L44;
            r116 = R.drawable.obric_card_video_icon_mask_bl;
            goto L47
        L44:
            if (r115 == false) goto L46;
            r116 = R.drawable.obric_card_video_icon_mask_br;
            goto L47
        L46:
            r116 = R.drawable.obric_card_video_icon_mask;
        L37:
            r115 = false;
        L33:
            r114 = false;
        L29:
            r113 = false;
        L25:
            r109 = false;
            goto L26
        L21:
            r108 = false;
            goto L22
        L17:
            r107 = r106 - 1;
            goto L19
        L13:
            r104 = false;
            goto L14
        L9:
            r103 = false;
            goto L11
        L5:
            r102 = false;
            goto L7
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            this.f386350e = r100.getContext().getResources().getDimension(R.dimen.obric_card_photo_angle);
            return new b(ObricCardPhotoGridItemBinding.a(LayoutInflater.from(r100.getContext()), r100));
        }
    }

    public static final class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ObricCardPhotoGridItemBinding f386354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f386355b;

        public b(ObricCardPhotoGridItemBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "viewBinding");
            super(r100.f386196a);
            this.f386354a = r100;
        }
    }

    static {
        f386338p = new Companion();
    }

    public AlbumGridViewHolder(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.obric_card_photo_grid_container, r100, false);
        if (r101 == null) goto L7;
        super(new ObricCardPhotoGridContainerBinding((AtMostHeightRecyclerView) r101), false);
        AtMostHeightRecyclerView r102 = ((ObricCardPhotoGridContainerBinding) this.f386391a).f386195a;
        this.f386339j = r102;
        this.f386340k = r102.getPaddingStart();
        this.f386341l = r102.getPaddingTop();
        this.f386342m = r102.getPaddingEnd();
        this.f386343n = r102.getPaddingBottom();
        this.f386344o = LazyKt.lazy(new com.obric.assistant.card.layout.viewholder.a(this));
        r102.setAdapter(new a(this));
        r102.setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        r102.setHasFixedSize(true);
        r102.addItemDecoration(new AnonymousClass1(this));
        return;
    L7:
        throw new NullPointerException("rootView");
    }

    public static final int X3(AlbumGridViewHolder r100) {
        return ((Number) r100.f386344o.getValue()).intValue();
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r100, mca.c r101, int r110, boolean r111, boolean r112) {
        mca.c r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "messageExtra");
        Intrinsics.checkNotNullParameter(r102, "entity");
        AppEntityListAdapter.PageType r113 = this.f386396f;
        AppEntityListAdapter.PageType r114 = null;
        if (r113 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        r113 = null;
    L6:
        int r103 = 1;
        if (r113 != AppEntityListAdapter.PageType.ShowAllPage) goto L9;
        boolean r115 = true;
    L10:
        AtMostHeightRecyclerView r104 = this.f386339j;
        if (r115 == false) goto L13;
        int r105 = 0;
    L14:
        if (r115 == false) goto L16;
        int r106 = 0;
    L17:
        if (r115 == false) goto L19;
        int r107 = 0;
    L20:
        if (r115 == false) goto L22;
        int r116 = 0;
    L23:
        r104.setPaddingRelative(r105, r106, r107, r116);
        RecyclerView.Adapter r117 = this.f386339j.getAdapter();
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type com.obric.assistant.card.layout.viewholder.AlbumGridViewHolder.MyAdapter");
        a r118 = (a) r117;
        Collection r108 = r102.f513249a;
        AppEntityListAdapter.PageType r109 = this.f386396f;
        if (r109 == null) goto L26;
        r114 = r109;
    L27:
        r118.getClass();
        Intrinsics.checkNotNullParameter(r108, "photoList");
        Intrinsics.checkNotNullParameter(r114, "pageType");
        Intrinsics.checkNotNullParameter(r100, "messageExtra");
        r118.f386351f = r114;
        r118.f386352g = r100;
        ((ArrayList) r118.f386347b).clear();
        ((ArrayList) r118.f386347b).addAll(r108);
        r118.f386348c = 3;
        int r119 = r118.getItemCount() / 3;
        if ((r118.getItemCount() % 3) != 0) goto L30;
        r103 = 0;
    L30:
        r118.f386349d = r119 + r103;
        r118.notifyDataSetChanged();
        return;
    L26:
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        goto L27
    L22:
        r116 = this.f386343n;
        goto L23
    L19:
        r107 = this.f386342m;
        goto L20
    L16:
        r106 = this.f386341l;
        goto L17
    L13:
        r105 = this.f386340k;
        goto L14
    L9:
        r115 = false;
        goto L10
    }
}
