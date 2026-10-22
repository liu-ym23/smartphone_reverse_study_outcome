package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.sticker_office.databinding.ItemOfficeCustomStickerAddBinding;
import com.ss.android.lark.sticker_office.databinding.ItemOfficeCustomStickerImageBinding;
import com.ss.android.lark.sticker_office.databinding.ItemOfficeCustomStickerLoadingBinding;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005@ABCDB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rJ\u0014\u0010\u001c\u001a\u00020\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\rJ\u0006\u0010!\u001a\u00020\u001aJ\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0016J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\rH\u0016J\b\u0010*\u001a\u00020\rH\u0016J\u0018\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\rH\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010,\u001a\u000200H\u0002J\u0018\u00101\u001a\u00020\u001a2\u0006\u0010,\u001a\u0002022\u0006\u00103\u001a\u00020\u000bH\u0003J\u0010\u00104\u001a\u0002052\u0006\u00103\u001a\u00020\u000bH\u0002J\u0010\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u000208H\u0002J\u0018\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u0002082\u0006\u00103\u001a\u00020\u000bH\u0002J\b\u0010;\u001a\u00020\u001aH\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u0010%\u001a\u00020\rH\u0002J\u0012\u0010>\u001a\u0004\u0018\u00010?2\u0006\u00103\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "listener", "Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter$OnStickerListener;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter$OnStickerListener;)V", "itemList", "", "Lcom/ss/android/lark/chat/entity/sticker/Sticker;", "parentWidth", "", "itemWidth", "imageSize", "stickerPreviewPopWindow", "Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeEmojiPreviewPopWindow;", "showPreviewStickerId", "", "containerHorizontalPadding", "itemHorizontalPadding", "itemVerticalPadding", "imageMaxSize", "imageCorner", "updateParentWidth", "", "width", "setData", "list", "", "addLoadingItem", "count", "removeLoadingItem", "isStickerPreviewShowing", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "bindAdd", "Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter$AddViewHolder;", "bindLoading", "Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter$LoadingViewHolder;", "bindSticker", "Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter$ImageViewHolder;", "sticker", "calculateStickerImageSize", "Landroid/graphics/Point;", "updateItemPadding", "view", "Landroid/view/View;", "showStickerPreview", "anchorView", "dismissStickerPreview", "getShownPosition", "Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeEmojiPreviewPopWindow$Position;", "getLocalStickerFileInfo", "Lcom/ss/android/lark/keyboard/plugin/tool/face/StickerFileInfo;", "Companion", "OnStickerListener", "ImageViewHolder", "AddViewHolder", "LoadingViewHolder", "sticker-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCustomStickerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f440860l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f440861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f440862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Sticker> f440863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f440864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f440865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OfficeEmojiPreviewPopWindow f440866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f440867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f440868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f440869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f440870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f440871k;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter$AddViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/ss/android/lark/sticker_office/databinding/ItemOfficeCustomStickerAddBinding;", "<init>", "(Lcom/ss/android/lark/sticker_office/databinding/ItemOfficeCustomStickerAddBinding;)V", "getViewBinding", "()Lcom/ss/android/lark/sticker_office/databinding/ItemOfficeCustomStickerAddBinding;", "sticker-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AddViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ItemOfficeCustomStickerAddBinding f440872a;

        public AddViewHolder(ItemOfficeCustomStickerAddBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "viewBinding");
            super(r100.f440850a);
            this.f440872a = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/ss/android/lark/sticker_office/databinding/ItemOfficeCustomStickerImageBinding;", "<init>", "(Lcom/ss/android/lark/sticker_office/databinding/ItemOfficeCustomStickerImageBinding;)V", "getViewBinding", "()Lcom/ss/android/lark/sticker_office/databinding/ItemOfficeCustomStickerImageBinding;", "sticker-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ImageViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ItemOfficeCustomStickerImageBinding f440873a;

        public ImageViewHolder(ItemOfficeCustomStickerImageBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "viewBinding");
            super(r100.f440852a);
            this.f440873a = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/sticker_office/ui/custom_sticker/panel/OfficeCustomStickerAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/ss/android/lark/sticker_office/databinding/ItemOfficeCustomStickerLoadingBinding;", "<init>", "(Lcom/ss/android/lark/sticker_office/databinding/ItemOfficeCustomStickerLoadingBinding;)V", "getViewBinding", "()Lcom/ss/android/lark/sticker_office/databinding/ItemOfficeCustomStickerLoadingBinding;", "sticker-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadingViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ItemOfficeCustomStickerLoadingBinding f440874a;

        public LoadingViewHolder(ItemOfficeCustomStickerLoadingBinding r100) {
            Intrinsics.checkNotNullParameter(r100, "viewBinding");
            super(r100.f440854a);
            this.f440874a = r100;
        }
    }

    public static final class a {
    }

    public interface b {
        void a(AppCompatImageView r100, com.ss.android.lark.keyboard.plugin.tool.face.d r101);

        void b(Sticker r100);

        void c(View r100);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f440863c).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        String r101 = ((Sticker) ListProtector.get(this.f440863c, r100)).getStickerId();
        if (Intrinsics.areEqual(r101, "_add_") == false) goto L6;
        return 1;
    L6:
        if (Intrinsics.areEqual(r101, "_loading_") == false) goto L8;
        return 2;
    L8:
        return 0;
    }

    public final void setData(final List<? extends Sticker> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        OfficeEmojiPreviewPopWindow r101 = this.f440866f;
        if (r101 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    L5:
        this.f440866f = null;
        DiffUtil.calculateDiff(new OfficeCustomStickerAdapter$setData$result$1(this, r100)).dispatchUpdatesTo(this);
        ((ArrayList) this.f440863c).clear();
        ArrayList r102 = (ArrayList) this.f440863c;
        r102.addAll(r100);
    }

    public OfficeCustomStickerAdapter(OfficeCustomStickerFragment r100, OfficeCustomStickerFragment$stickerAdapter$2.a r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f440861a = r100;
        this.f440862b = r101;
        this.f440863c = new ArrayList();
        this.f440867g = UIHelper.dp2px(8.0f);
        this.f440868h = UIHelper.dp2px(4.0f);
        this.f440869i = UIHelper.dp2px(6.0f);
        this.f440870j = UIHelper.dp2px(85.0f);
        this.f440871k = UIHelper.dp2px(12.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r210, int r211) {
        Intrinsics.checkNotNullParameter(r210, "holder");
        if (this.f440865e > 0) goto L5;
        return;
    L5:
        Sticker r100 = (Sticker) ListProtector.get(this.f440863c, r211);
        if ((r210 instanceof AddViewHolder) == false) goto L13;
        AddViewHolder r101 = (AddViewHolder) r210;
        FrameLayout r102 = r101.f440872a.f440850a;
        int r103 = this.f440869i;
        r102.setPadding(r102.getPaddingLeft(), r103, r102.getPaddingRight(), r103);
        FrameLayout r104 = r101.f440872a.f440851b;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L11;
        int r106 = this.f440865e;
        r105.width = r106;
        r105.height = r106;
        r104.setLayoutParams(r105);
        r101.f440872a.f440850a.setOnClickListener(new com.ss.android.lark.sticker_office.ui.custom_sticker.panel.a(this, r101));
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L13:
        if ((r210 instanceof LoadingViewHolder) == false) goto L20;
        LoadingViewHolder r107 = (LoadingViewHolder) r210;
        FrameLayout r108 = r107.f440874a.f440854a;
        int r109 = this.f440869i;
        r108.setPadding(r108.getPaddingLeft(), r109, r108.getPaddingRight(), r109);
        FrameLayout r110 = r107.f440874a.f440855b;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L18;
        int r112 = this.f440865e;
        r111.width = r112;
        r111.height = r112;
        r110.setLayoutParams(r111);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L20:
        if ((r210 instanceof ImageViewHolder) == false) goto L37;
        ImageViewHolder r113 = (ImageViewHolder) r210;
        FrameLayout r114 = r113.f440873a.f440852a;
        int r115 = this.f440869i;
        r114.setPadding(r114.getPaddingLeft(), r115, r114.getPaddingRight(), r115);
        int r116 = r100.getOriginImageWidth();
        int r117 = r100.getOriginImageHeight();
        if (r116 <= 0) goto L29;
        if (r117 <= 0) goto L29;
        if (r116 < r117) goto L28;
        int r118 = this.f440865e;
        Point r119 = new Point(r118, RangesKt.coerceAtLeast((int) ((r118 * r117) / r116), 1));
    L30:
        AppCompatImageView r120 = r113.f440873a.f440853b;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if (r121 == null) goto L34;
        r121.width = r119.x;
        r121.height = r119.y;
        r120.setLayoutParams(r121);
        AppCompatImageView r122 = r113.f440873a.f440853b;
        r122.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r122.setOnTouchListener(new com.ss.android.lark.sticker_office.ui.custom_sticker.panel.b(this));
        r122.setOnLongClickListener(new c(r122, this, r113, r100));
        r122.setOnClickListener(new d(this, r100, r122));
        b6c.a.C0273a.f17896a.a(r122.getContext(), r119.x, r119.y, r100.getImageKey(), r122, -2, R.drawable.kb_emoji_load_holder, null, 0, r119.x, r119.y, this.f440871k);
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L28:
        r119 = new Point(RangesKt.coerceAtLeast((int) ((this.f440865e * r116) / r117), 1), this.f440865e);
    L29:
        int r123 = this.f440865e;
        r119 = new Point(r123, r123);
        goto L30
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        int r103 = R.id.image;
        if (r101 != 1) goto L5;
        View r104 = r102.inflate(R.layout.item_office_custom_sticker_add, r100, false);
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r104, R.id.addBackground);
        if (r105 != null) goto L21;
        r103 = R.id.addBackground;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r104.getResources().getResourceName(r103)));
    L21:
        if (((AppCompatImageView) ViewBindings.findChildViewById(r104, R.id.image)) == null) goto L26;
        RecyclerView.ViewHolder r106 = new AddViewHolder(new ItemOfficeCustomStickerAddBinding((FrameLayout) r104, r105));
    L23:
        return r106;
    L5:
        if (r101 == 2) goto L11;
        View r107 = r102.inflate(R.layout.item_office_custom_sticker_image, r100, false);
        AppCompatImageView r108 = (AppCompatImageView) ViewBindings.findChildViewById(r107, R.id.image);
        if (r108 == null) goto L10;
        r106 = new ImageViewHolder(new ItemOfficeCustomStickerImageBinding((FrameLayout) r107, r108));
        goto L23
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r107.getResources().getResourceName(R.id.image)));
    L11:
        View r109 = r102.inflate(R.layout.item_office_custom_sticker_loading, r100, false);
        if (((AppCompatImageView) ViewBindings.findChildViewById(r109, R.id.image)) == null) goto L17;
        r103 = R.id.loadingContainer;
        FrameLayout r110 = (FrameLayout) ViewBindings.findChildViewById(r109, R.id.loadingContainer);
        if (r110 == null) goto L17;
        r106 = new LoadingViewHolder(new ItemOfficeCustomStickerLoadingBinding((FrameLayout) r109, r110));
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r109.getResources().getResourceName(r103)));
    }
}
