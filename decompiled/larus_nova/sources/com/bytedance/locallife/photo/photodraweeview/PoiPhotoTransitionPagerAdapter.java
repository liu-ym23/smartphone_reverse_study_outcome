package com.bytedance.locallife.photo.photodraweeview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.dmt.ui.widget.DmtLoadingLayout;
import com.bytedance.locallife.photo.internal.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.locallife.photo.internal.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/photo/photodraweeview/PoiPhotoTransitionPagerAdapter;", "Lcom/bytedance/locallife/photo/internal/photodraweeview/transition/TransitionPagerAdapter;", "Lcom/bytedance/locallife/photo/photodraweeview/PoiTransitionViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PhotoVH", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiPhotoTransitionPagerAdapter extends TransitionPagerAdapter<PoiTransitionViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<b> f262082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Map<String, String>> f262083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f262084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f262085e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f262086f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f262087g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f262088h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f262089i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f262090j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f262091k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super Integer, Unit> f262092l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f262093m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Integer, WeakReference<PoiTransitionViewHolder>> f262094n;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/photo/photodraweeview/PoiPhotoTransitionPagerAdapter$PhotoVH;", "Lcom/bytedance/locallife/photo/photodraweeview/PoiTransitionViewHolder;", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
    public final class PhotoVH extends PoiTransitionViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f262095d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TransitionPhotoDraweeView f262096a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DmtLoadingLayout f262097b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PoiPhotoTransitionPagerAdapter f262098c;

        public PhotoVH(PoiPhotoTransitionPagerAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f262098c = r100;
            super(r101, 0);
            this.f262096a = (TransitionPhotoDraweeView) r101.findViewById(R.id.photo_view);
            this.f262097b = (DmtLoadingLayout) r101.findViewById(R.id.status_loading);
        }
    }

    public static final class a {
    }

    static {
    }

    public PoiPhotoTransitionPagerAdapter() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f262082b.size();
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.transition.TransitionPagerAdapter
    public final void onDestroy() {
        vn6.b.a("GoodsDetailImageDismiss");
        Iterator r100 = ((LinkedHashMap) this.f262094n).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        PoiTransitionViewHolder r101 = (PoiTransitionViewHolder) ((WeakReference) r100.next()).get();
        goto L4
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.transition.TransitionPagerAdapter
    public final void S80(int r100) {
        Map<Integer, WeakReference<PoiTransitionViewHolder>> r101 = this.f262094n;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        WeakReference r103 = (WeakReference) r102.get(Integer.valueOf(r100));
        if (r103 == null) goto L6;
        PoiTransitionViewHolder r104 = (PoiTransitionViewHolder) r103.get();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f262082b.size() > r100) goto L7;
        return 0;
    L7:
        return ((b) ListProtector.get(this.f262082b, r100)).getType();
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.transition.TransitionPagerAdapter
    public final void onPageSelected(int r100) {
        Map<Integer, WeakReference<PoiTransitionViewHolder>> r101 = this.f262094n;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        WeakReference r103 = (WeakReference) r102.get(Integer.valueOf(r100));
        if (r103 == null) goto L6;
        PoiTransitionViewHolder r104 = (PoiTransitionViewHolder) r103.get();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        PoiTransitionViewHolder r102 = (PoiTransitionViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Integer r103 = Integer.valueOf(r101);
        this.f262094n.put(r103, new WeakReference(r102));
        if ((r102 instanceof PhotoVH) == false) goto L24;
        PhotoVH r104 = (PhotoVH) r102;
        String r105 = ((b) ListProtector.get(this.f262082b, r101)).f262101b;
        Function1<? super Integer, Unit> r106 = this.f262092l;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "url");
        Intrinsics.checkNotNullParameter(r106, "clickListener");
        r104.f262097b.setVisibility(0);
        Boolean r107 = r104.f262098c.f262089i;
        Boolean r108 = Boolean.TRUE;
        if (Intrinsics.areEqual(r107, r108) == false) goto L7;
        ResizeOptions r109 = new ResizeOptions(UIUtils.getScreenWidth(r104.itemView.getContext()) / 2, UIUtils.getScreenHeight(r104.itemView.getContext()) / 2, 10240.0f);
    L8:
        ImageRequestBuilder r110 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r105)).setResizeOptions(r109);
        if (Intrinsics.areEqual(r104.f262098c.f262091k, r108) == false) goto L11;
        r110.setRotationOptions(RotationOptions.autoRotateAtRenderTime());
    L11:
        Map<String, Map<String, String>> r111 = r104.f262098c.f262083c;
        if (r111 == null) goto L15;
        Map<String, String> r112 = r111.get(r105);
        if (r112 == null) goto L15;
    L16:
        ImageRequest r113 = r110.setHttpHeader(r112).build();
        r104.f262096a.setController(Fresco.newDraweeControllerBuilder().setControllerListener(new c(r104, r104.f262098c, r101)).setImageRequest(r113).setAutoPlayAnimations(true).build());
        GenericDraweeHierarchy r114 = r104.f262096a.getHierarchy();
        PoiPhotoTransitionPagerAdapter r115 = r104.f262098c;
        GenericDraweeHierarchy r116 = r114;
        Integer r117 = r115.f262084d;
        if (r117 == null) goto L19;
        r116.setFailureImage(r117.intValue(), ScalingUtils.ScaleType.CENTER);
    L19:
        Integer r118 = r115.f262085e;
        if (r118 == null) goto L22;
        r116.setPlaceholderImage(r118.intValue(), ScalingUtils.ScaleType.CENTER);
    L22:
        r104.f262096a.setOnClickListener(new d(r106, r101));
        vn6.b.a("GoodsDetailImageShow");
        return;
    L15:
        r112 = MapsKt.emptyMap();
        goto L16
    L7:
        r109 = new ResizeOptions(UIUtils.getScreenWidth(r104.itemView.getContext()) / 2, UIUtils.getScreenHeight(r104.itemView.getContext()) / 2);
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 2) goto L6;
        return new PoiTransitionViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.poi_photo_look_more, r100, false), 2);
    L6:
        return new PhotoVH(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.poi_photo_transition_view_holder_view, r100, false));
    }

    public PoiPhotoTransitionPagerAdapter(List r100, String r101, String r102, boolean r103, String r104, Boolean r105, Map r106, Boolean r110, int r111) {
        if ((r111 & 16) == 0) goto L6;
        r101 = null;
    L6:
        if ((r111 & 32) == 0) goto L9;
        r102 = null;
    L9:
        if ((r111 & 64) == 0) goto L12;
        r103 = false;
    L12:
        if ((r111 & 128) == 0) goto L15;
        r104 = null;
    L15:
        if ((r111 & 256) == 0) goto L18;
        r105 = Boolean.FALSE;
    L18:
        if ((r111 & 512) == 0) goto L21;
        r106 = null;
    L21:
        if ((r111 & 1024) == 0) goto L23;
        r110 = Boolean.FALSE;
    L23:
        Intrinsics.checkNotNullParameter(r100, "itemList");
        this.f262082b = r100;
        this.f262083c = null;
        this.f262084d = null;
        this.f262085e = null;
        this.f262086f = r101;
        this.f262087g = r102;
        this.f262088h = r104;
        this.f262089i = r105;
        this.f262090j = r106;
        this.f262091k = r110;
        this.f262092l = PoiPhotoTransitionPagerAdapter$clickListener$1.INSTANCE;
        this.f262094n = new LinkedHashMap();
        if (r103 == false) goto L27;
        this.f262082b.add(new b(2, null, 1022));
        return;
    }
}
