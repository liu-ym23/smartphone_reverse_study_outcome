package com.larus.avlink.gallery.view;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.AlbumUtils;
import com.larus.bmhome.chat.dora.VideoThumbnailHelper;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 12\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00011B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ$\u0010\u000e\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J&\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\"\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J*\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J(\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!J(\u0010\"\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\rH\u0016J6\u0010+\u001a\u00020\u000f2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0-2\b\u0010.\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u00100\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/avlink/gallery/view/AlbumListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/bigimg/MediaItem;", "Lcom/larus/avlink/gallery/view/AlbumViewHolder;", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "callback", "Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/larus/avlink/gallery/view/AlbumListHolderCallback;)V", "data", "", "itemCount", "", "setData", "", "onSubmitted", "Lkotlin/Function0;", "clear", "removeItem", "position", "deleteItemsByUrls", "urls", "", "insert", "file", "updateItem", MapController.ITEM_LAYER_TAG, "renameItem", "preName", "newName", "setSelectMode", "isSelectMode", "", "submitData", "getDeepCopyData", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceItemWhere", "predicate", "Lkotlin/Function1;", "replacement", "getItem", "getItemViewType", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumListAdapter extends ListAdapter<com.larus.bmhome.bigimg.t1, AlbumViewHolder> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AlbumListAdapter$Companion$DIFF_CALLBACK$1 f292840d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleCoroutineScope f292841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f292842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends com.larus.bmhome.bigimg.t1> f292843c;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.avlink.gallery.view.AlbumListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f292840d = new AlbumListAdapter$Companion$DIFF_CALLBACK$1();
    }

    public final List<com.larus.bmhome.bigimg.t1> y2() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.f292843c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add(com.larus.bmhome.bigimg.t1.a.a((com.larus.bmhome.bigimg.t1) r101.next(), null, false, false, 1023));
        goto L4
    L6:
        return r100;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public final /* bridge */ /* synthetic */ com.larus.bmhome.bigimg.t1 getItem(int r100) {
        return z2(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return z2(r100).getMediaType();
    }

    public final com.larus.bmhome.bigimg.t1 z2(int r100) {
        return (com.larus.bmhome.bigimg.t1) super.getItem(r100);
    }

    public AlbumListAdapter(LifecycleCoroutineScope r100, MineAlbumFragment.e r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(f292840d);
        this.f292841a = r100;
        this.f292842b = r101;
        this.f292843c = CollectionsKt.emptyList();
    }

    public final void insert(com.larus.bmhome.bigimg.t1 r100, Function0<Unit> r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<com.larus.bmhome.bigimg.t1> r102 = y2();
        ListProtector.add(r102, 0, com.larus.bmhome.bigimg.t1.a.a(r100, null, false, false, 1023));
        this.f292843c = r102;
        submitList(r102, new e(r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        AlbumViewHolder r112 = (AlbumViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        final com.larus.bmhome.bigimg.t1 r113 = z2(r111);
        if ((r112 instanceof AlbumVideoItemHolder) == false) goto L51;
        final AlbumVideoItemHolder r114 = (AlbumVideoItemHolder) r112;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        FLogger r100 = FLogger.f375446a;
        r100.i("AlbumVideoItemHolder", "bindData, item=" + r113 + ", absoluteAdapterPosition = " + r114.getAbsoluteAdapterPosition());
        if ((r113 instanceof yt8.p) == false) goto L7;
        yt8.p r101 = (yt8.p) r113;
    L8:
        if (r101 == null) goto L11;
        String r102 = r101.f569197d;
        if (r102 == null) goto L11;
    L12:
        int r103 = VideoThumbnailHelper.f302937a;
        Context r104 = r114.itemView.getContext();
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "mediaID");
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104.getCacheDir(), "video_thumb_" + r102.hashCode() + ".jpg");
        if (r105.exists() == false) goto L15;
        String r106 = r105.getAbsolutePath();
    L17:
        if (r106 == null) goto L21;
        r100.i("AlbumVideoItemHolder", "Using cached thumbnail for mediaID: " + r102 + ", path: " + r106);
        ImageViewWithLastMotion r107 = r114.f292865c;
        if (r107 == null) goto L23;
        ImageLoaderKt.x(r107, Uri.fromFile(new PolarisFileWrapper(r106)), null, null, new t(), 6);
    L23:
        if (r113.d() == false) goto L27;
        com.larus.utils.e1.x(r114.f292868f);
        com.larus.utils.e1.x(r114.f292869g);
        View r108 = r114.f292866d;
        if (r108 == null) goto L43;
        com.larus.utils.e1.o(r108);
    L43:
        TextView r109 = r114.f292867e;
        if (r109 == null) goto L46;
        int r115 = AlbumUtils.f292333a;
        r109.setText(AlbumUtils.d((long) (((yt8.p) r113).f569204k / ((double) 1000))));
    L46:
        TextView r116 = r114.f292867e;
        if (r116 == null) goto L49;
        com.larus.utils.e1.x(r116);
    L49:
        r114.itemView.setOnTouchListener(new u(r114));
        com.larus.utils.e1.d(r114.itemView, new v(r114, r113));
        r114.itemView.setOnLongClickListener(new w(r114, r113));
        return;
    L27:
        com.larus.utils.e1.o(r114.f292868f);
        com.larus.utils.e1.o(r114.f292869g);
        if (r113.b() == false) goto L40;
        View r117 = r114.f292866d;
        if (r117 == null) goto L33;
        com.larus.utils.e1.x(r117);
    L33:
        if (r113.isSelected() == false) goto L37;
        View r118 = r114.f292866d;
        if (r118 == null) goto L43;
        r118.setBackgroundResource(R.drawable.larus_ic_album_item_selected);
        goto L43
    L37:
        View r119 = r114.f292866d;
        if (r119 == null) goto L43;
        r119.setBackgroundResource(R.drawable.larus_ic_album_item_unselected);
        goto L43
    L40:
        View r120 = r114.f292866d;
        if (r120 == null) goto L43;
        com.larus.utils.e1.o(r120);
        goto L43
    L21:
        r100.i("AlbumVideoItemHolder", "No cached thumbnail, generating for mediaID: " + r102 + ", path: " + r113.getPath());
        BuildersKt.launch$default(r114.f292864b, Dispatchers.getIO(), null, new AlbumVideoItemHolder$bindData$1(r114, r102, r113, null), 2, null);
        goto L23
    L15:
        r106 = null;
    L11:
        r102 = r113.getPath();
        goto L12
    L7:
        r101 = null;
        goto L8
    L51:
        if ((r112 instanceof AlbumImageViewHolder) == false) goto L80;
        final AlbumImageViewHolder r121 = (AlbumImageViewHolder) r112;
        r121.getClass();
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        PolarisFileWrapper r122 = new PolarisFileWrapper(r113.getPath());
        if (r122.exists() == true) goto L55;
        FLogger.f375446a.e("AlbumViewHolder", "bindData, File not found, item=" + r113);
    L56:
        ImageLoaderKt.x(r121.f292833b, UriProtector.parse(MSkiaImageRegionDecoder.FILE_PREFIX + r113.getPath()), null, null, new com.larus.avlink.gallery.view.a(r113), 6);
        if (r113.d() == false) goto L61;
        com.larus.utils.e1.x(r121.f292835d);
        com.larus.utils.e1.x(r121.f292836e);
        View r123 = r121.f292834c;
        if (r123 == null) goto L77;
        com.larus.utils.e1.o(r123);
    L77:
        r121.itemView.setOnTouchListener(new b(r121));
        com.larus.utils.e1.d(r121.itemView, new c(r121, r113));
        r121.itemView.setOnLongClickListener(new d(r121, r113));
        return;
    L61:
        com.larus.utils.e1.o(r121.f292835d);
        com.larus.utils.e1.o(r121.f292836e);
        if (r113.b() == false) goto L74;
        View r124 = r121.f292834c;
        if (r124 == null) goto L67;
        com.larus.utils.e1.x(r124);
    L67:
        if (r113.isSelected() == false) goto L71;
        View r125 = r121.f292834c;
        if (r125 == null) goto L77;
        r125.setBackgroundResource(R.drawable.larus_ic_album_item_selected);
        goto L77
    L71:
        View r126 = r121.f292834c;
        if (r126 == null) goto L77;
        r126.setBackgroundResource(R.drawable.larus_ic_album_item_unselected);
        goto L77
    L74:
        View r127 = r121.f292834c;
        if (r127 == null) goto L77;
        com.larus.utils.e1.o(r127);
        goto L77
    L55:
        FLogger.f375446a.i("AlbumViewHolder", "bindData, File found, item=" + r113 + ", size=" + r122.length());
        goto L56
    L80:
        throw new IllegalArgumentException("Unknown ViewHolder type: ".concat(r112.getClass().getSimpleName()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_album_holder, r100, false);
        int r103 = R.id.album_item_processing;
        if (((ProgressBar) ViewBindings.findChildViewById(r102, R.id.album_item_processing)) == null) goto L22;
        r103 = R.id.album_item_select;
        if (ViewBindings.findChildViewById(r102, R.id.album_item_select) == null) goto L22;
        r103 = R.id.duration;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.duration)) == null) goto L22;
        r103 = R.id.gallery_mask;
        if (ViewBindings.findChildViewById(r102, R.id.gallery_mask) == null) goto L22;
        r103 = R.id.image;
        if (((ImageViewWithLastMotion) ViewBindings.findChildViewById(r102, R.id.image)) == null) goto L22;
        ConstraintLayout r104 = (ConstraintLayout) r102;
        if (r101 == 1) goto L20;
        if (r101 != 2) goto L18;
        return new AlbumVideoItemHolder(r104, this.f292842b, this.f292841a);
    L18:
        throw new IllegalArgumentException("Unknown view type: " + r101);
    L20:
        return new AlbumImageViewHolder(r104, this.f292842b, this.f292841a);
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
