package com.larus.photopicker.v2.impl.ui;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.databinding.LarusItemFooterMediaBinding;
import com.larus.photopicker.v2.impl.databinding.LarusItemHeaderPermissionBinding;
import com.larus.photopicker.v2.impl.databinding.LarusItemMediaBinding;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.j2;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.photopicker.v2.impl.model.MediaViewType;
import com.larus.utils.m0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import op9.d;
import op9.e;
import up9.q;
import v19.c;
import v19.i5;
import vp9.f;
import vp9.j;
import vp9.m;
import vp9.u;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r*\u0001#\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BQ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020'H\u0016J\u0006\u0010)\u001a\u00020\u000bJ\u0010\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0018\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0007H\u0016J&\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00072\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0016J\u0018\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0007H\u0016J\b\u00105\u001a\u00020\u0007H\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u000207H\u0002J\u0010\u00108\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0002J\u000e\u00109\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020<J\u001e\u0010=\u001a\u00020\u000b2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001072\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u0016J\u000e\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u0007J\u000e\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u0007J\u0010\u0010H\u001a\u00020\u000b2\b\b\u0001\u0010/\u001a\u00020\u0007J\u000e\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u0016J\u000e\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u0006M"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaListAdapterV2;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "spanCount", "", "scrollThreshold", "loadMoreCallback", "Lkotlin/Function0;", "", "onItemClick", "Lkotlin/Function3;", "Lcom/larus/photopicker/v2/impl/ui/ClickType;", "<init>", "(Landroid/content/Context;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "TAG", "", "resizeOption", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "addPartImageEnable", "", "headerDataSize", "footerDataSize", "footerData", "curMediaListState", "Lcom/larus/photopicker/v2/impl/ui/MediaListStateData;", "headerData", "getHeaderData", "()Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "headerData$delegate", "Lkotlin/Lazy;", "lastItemCount", "scrollListener", "com/larus/photopicker/v2/impl/ui/MediaListAdapterV2$scrollListener$1", "Lcom/larus/photopicker/v2/impl/ui/MediaListAdapterV2$scrollListener$1;", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "release", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "getItemCount", "getAllData", "", "getDataPosition", "getDataRealPosition", "findDataPositionByUri", "uri", "Landroid/net/Uri;", "submitListOuter", "list", "curMediaTab", "Lcom/larus/photopicker/v2/impl/model/MediaTab;", "isAddPartImageEnable", "headerVisibleOrGone", "visible", "footerVisibleOrGone", "height", "updateCornerRadius", "spacing", "updateSelectView", "updateSelectable", "selectable", "setCurMediaListState", "state", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaListAdapterV2 extends ListAdapter<d, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f364627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f364628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f364629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function3<? super d, ? super Integer, ? super ClickType, Unit> f364630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f364631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ResizeOptions f364632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f364633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f364634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f364635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f364636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public m f364637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f364638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f364639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MediaListAdapterV2$scrollListener$1 f364640n;

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getCurrentList().size() + this.f364635i;
    }

    public final boolean A2(boolean r100) {
        if (this.f364633g == true) goto L5;
        return false;
    L5:
        int r101 = this.f364634h;
        if (r101 != 1) goto L8;
        if (r100 == false) goto L8;
    L10:
        return false;
    L8:
        if (r101 != 0) goto L11;
        if (r100 == false) goto L10;
    L11:
        if (r100 == false) goto L13;
        this.f364634h = 1;
        List r102 = CollectionsKt.toMutableList(getCurrentList());
        ListProtector.add(r102, 0, (d) this.f364638l.getValue());
        submitList(r102);
    L14:
        return true;
    L13:
        this.f364634h = 0;
        List r103 = CollectionsKt.toMutableList(getCurrentList());
        r103.remove((d) this.f364638l.getValue());
        submitList(r103);
        goto L14
    }

    public final void C2(@ViewHolderSelectViewType int r100) {
        int r101 = e0.f364440a;
        e0.d(this.f364631e, "updateSelectView: " + r100);
        m r102 = this.f364637k;
        if (r100 == r102.f556683d) goto L6;
        r102.f556683d = r100;
        notifyItemRangeChanged(0, getItemCount(), new f("selectViewVisible"));
        return;
    }

    public final void D2(boolean r100) {
        int r101 = e0.f364440a;
        e0.d(this.f364631e, "updateSelectable: " + r100);
        m r102 = this.f364637k;
        if (r100 == r102.f556682c) goto L6;
        r102.f556682c = r100;
        notifyItemRangeChanged(0, getItemCount());
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 >= getCurrentList().size()) goto L5;
    L8:
        List<d> r101 = getCurrentList();
        if (r100 < 0) goto L16;
        if (r100 >= r101.size()) goto L16;
        return ((d) ListProtector.get(r101, r100)).f524793d.getType();
    L16:
        return super.getItemViewType(r100);
    L5:
        if (r100 >= getItemCount()) goto L8;
        return MediaViewType.FOOTER.getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        r100.addOnScrollListener(this.f364640n);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
        r100.removeOnScrollListener(this.f364640n);
    }

    public final void y2(int r100) {
        this.f364636j = r100;
        if (r100 <= 0) goto L5;
        this.f364635i = this.f364627a;
        notifyItemInserted(getItemCount());
        return;
    L5:
        if (r100 != 0) goto L9;
        notifyItemRangeRemoved(getCurrentList().size(), this.f364635i);
        this.f364635i = 0;
        return;
    }

    public final int z2(int r100) {
        return RangesKt.coerceAtMost(r100 + this.f364634h, getItemCount() - 1);
    }

    public final void B2(List<d> r100, MediaTab r101) {
        Intrinsics.checkNotNullParameter(r101, "curMediaTab");
        int r102 = e0.f364440a;
        String r103 = this.f364631e;
        StringBuilder r104 = new StringBuilder("[");
        r104.append(r101);
        r104.append("] submitListOuter，list=");
        if (r100 == null) goto L5;
        Integer r105 = Integer.valueOf(r100.size());
    L6:
        r104.append(r105);
        e0.d(r103, r104.toString());
        if (this.f364634h <= 0) goto L12;
        if (r100 == null) goto L14;
        List r106 = CollectionsKt.toMutableList(r100);
        if (r106 == null) goto L15;
        ListProtector.add(r106, 0, (d) this.f364638l.getValue());
        super.submitList(r106);
        return;
    L15:
        return;
    L14:
        return;
    L12:
        super.submitList(r100);
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof MediaViewHolder) == false) goto L10;
        final d r102 = getItem(r101);
        final int r103 = RangesKt.coerceAtLeast(r101 - this.f364634h, 0);
        final MediaViewHolder r104 = (MediaViewHolder) r100;
        Intrinsics.checkNotNull(r102);
        m r105 = this.f364637k;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "mediaItem");
        Intrinsics.checkNotNullParameter(r105, "mediaListState");
        r104.f364670e = r102;
        r104.f364671f = r103;
        final Uri r106 = r102.f524790a.f514733b;
        GenericDraweeHierarchy r107 = r104.f364666a.f364415b.getHierarchy();
        r107.setPlaceholderImage(R.drawable.larus_tools_media_import_bg_thumbnail_place_holder);
        r107.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        r107.setFadeDuration(10);
        ImageLoaderKt.y(r104.f364666a.f364415b, r106.toString(), "photo_picker_v2_MediaViewHolder", new u(r104, r106, r102, r103), 4);
        if (r102.f524790a.getType() != MediaType.VIDEO) goto L7;
        r104.f364666a.f364419f.setVisibility(0);
        r104.f364666a.f364419f.setText(e.a(r102));
    L8:
        r104.U3(r102, r105);
        r104.V3(r105);
        r104.T3(r102, r105);
        r104.W3(r102, r102.f524791b);
        return;
    L7:
        r104.f364666a.f364419f.setVisibility(8);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r110 != MediaViewType.HEADER.getType()) goto L11;
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_header_permission, r100, false);
        if (r101 == null) goto L9;
        return new HeaderMediaDataViewHolder(new LarusItemHeaderPermissionBinding((AspectRatioFrameLayout) r101), this.f364630d);
    L9:
        throw new NullPointerException("rootView");
    L11:
        if (r110 != MediaViewType.FOOTER.getType()) goto L18;
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_footer_media, r100, false);
        if (r102 == null) goto L17;
        return new FooterMediaDataViewHolder(new LarusItemFooterMediaBinding(r102));
    L17:
        throw new NullPointerException("rootView");
    L18:
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_media, r100, false);
        int r111 = R.id.media_image_view;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r103, R.id.media_image_view);
        if (r104 == null) goto L31;
        r111 = R.id.media_item_select_indicator_check_box;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.media_item_select_indicator_check_box);
        if (r105 == null) goto L31;
        r111 = R.id.media_item_select_indicator_container;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.media_item_select_indicator_container);
        if (r106 == null) goto L31;
        r111 = R.id.media_item_shadow_view;
        View r107 = ViewBindings.findChildViewById(r103, R.id.media_item_shadow_view);
        if (r107 == null) goto L31;
        r111 = R.id.media_item_video_duration;
        AppCompatTextView r108 = (AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.media_item_video_duration);
        if (r108 == null) goto L31;
        return new MediaViewHolder(new LarusItemMediaBinding((AspectRatioFrameLayout) r103, r104, r105, r106, r107, r108), this.f364632f, this.f364630d);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r111)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        r102.size();
        if ((r100 instanceof HeaderMediaDataViewHolder) == false) goto L6;
        ((HeaderMediaDataViewHolder) r100).getClass();
        return;
    L6:
        if ((r100 instanceof FooterMediaDataViewHolder) == false) goto L15;
        FooterMediaDataViewHolder r103 = (FooterMediaDataViewHolder) r100;
        int r104 = this.f364636j;
        boolean r105 = true;
        if (r101 == (getItemCount() - 1)) goto L11;
        r105 = false;
    L11:
        if (r105 == false) goto L13;
        ViewGroup.LayoutParams r106 = r103.f364617a.f364412a.getLayoutParams();
        r106.height = r104;
        r103.f364617a.f364412a.setLayoutParams(r106);
        return;
    L13:
        r103.getClass();
        return;
    L15:
        if ((r100 instanceof MediaViewHolder) == false) goto L27;
        Object r107 = CollectionsKt.lastOrNull(r102);
        if ((r107 instanceof f) == false) goto L20;
        ((MediaViewHolder) r100).V3(this.f364637k);
        return;
    L20:
        if ((r107 instanceof vp9.e) == true) goto L22;
        onBindViewHolder(r100, r101);
        return;
    L22:
        ((vp9.e) r107).getClass();
        ((MediaViewHolder) r100).U3(null, this.f364637k);
        throw null;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.larus.photopicker.v2.impl.ui.MediaListAdapterV2$scrollListener$1] */
    public MediaListAdapterV2(Context r100, int r101, int r102, j2 r103, q r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "loadMoreCallback");
        Intrinsics.checkNotNullParameter(r104, "onItemClick");
        super(new MediaDiffCallback());
        this.f364627a = r101;
        this.f364628b = r102;
        this.f364629c = r103;
        this.f364630d = r104;
        this.f364631e = "MediaListAdapterV2";
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f364632f = ResizeOptions.forSquareSize(m0.b(r100) / r101);
        RoundingParams r105 = RoundingParams.fromCornersRadius(i5.h());
        r105.setBorder(ContextCompat.getColor(r100, c.b(R.attr.larus_neutral_transparent_1, r100, R.color.larus_neutral_transparent_1)), i5.b());
        this.f364637k = new m(r105, -1, 0, false);
        this.f364638l = LazyKt.lazy(new j());
        this.f364640n = new MediaListAdapterV2$scrollListener$1(this);
    }
}
