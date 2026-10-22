package com.bytedance.locallife.pdp.album.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.ability.model.AbilityEnum;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.bytedance.locallife.model.album.PhotoData;
import com.bytedance.locallife.model.album.PoiAlbumParams;
import com.bytedance.locallife.model.album.TabInfo;
import com.bytedance.locallife.pdp.album.adapter.BaseAdapter;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/pdp/album/page/PictureRecyclerViewAdapter;", "Lcom/bytedance/locallife/pdp/album/adapter/BaseAdapter;", "Lcom/bytedance/locallife/pdp/album/page/PictureRecyclerViewAdapter$b;", "b", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PictureRecyclerViewAdapter extends BaseAdapter<b> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CustomAlbumViewModel f260996m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f260997n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f260998o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f260999p;

    public static final class a implements PictureViewHolder.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PictureRecyclerViewAdapter f261000a;

        public a(PictureRecyclerViewAdapter r100) {
            this.f261000a = r100;
        }

        @Override // com.bytedance.locallife.pdp.album.page.PictureViewHolder.a
        public final void a(int r110, SimpleDraweeView r111) {
            Intrinsics.checkNotNullParameter(r111, "anchorView");
            if (HostServiceUtilsKt.h().b(AbilityEnum.ALBUM_SERVICE) == true) goto L5;
            return;
        L5:
            AlbumPageInfo r100 = this.f261000a.f260996m.getAlbumInfo().get(this.f261000a.f260998o);
            if (r100 == null) goto L29;
            PictureRecyclerViewAdapter r101 = this.f261000a;
            com.bytedance.locallife.host.photo.b r102 = HostServiceUtilsKt.W();
            PoiAlbumParams r103 = r101.f260996m.getAlbumParams();
            if (r103 == null) goto L10;
            String r104 = r103.getTraceSessionId();
        L11:
            HashMap r105 = new HashMap();
            r105.put("poi_name", r101.f260996m.getPoiName());
            PoiAlbumParams r106 = r101.f260996m.getAlbumParams();
            if (r106 == null) goto L15;
            String r107 = r106.getExtraParams();
            if (r107 == null) goto L15;
        L16:
            r105.put("extra_params", r107);
            Unit r108 = Unit.INSTANCE;
            Integer r109 = r100.getTabCount();
            if (r109 == null) goto L19;
            int r112 = r109.intValue();
        L20:
            Pair[] r113 = new Pair[2];
            List<TabInfo> r114 = r101.f260996m.getTabInfo().getValue();
            if (r114 == null) goto L26;
            TabInfo r115 = (TabInfo) ListProtector.get(r114, r101.f260997n);
            if (r115 == null) goto L26;
            String r116 = r115.getTabName();
            if (r116 == null) goto L26;
        L27:
            r113[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r116);
            r113[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_ORDER, String.valueOf(r101.f260997n));
            r102.e0(1, r104, r105, r112, MapsKt.hashMapOf(r113), r100, r101.f260998o, r110, r101.f260996m.getGalleryHeaderLynx(), r101.f260996m.getGalleryBottomLynx(), r111);
            return;
        L26:
            r116 = "";
            goto L27
        L19:
            r112 = 20;
        L15:
            r107 = SliceInitService.DEFAULT_SWITCH;
            goto L16
        L10:
            r104 = null;
            goto L11
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f261001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f261002b;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f261001a == r101.f261001a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f261002b, r101.f261002b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f261001a * 31) + this.f261002b.hashCode();
        }

        public final String toString() {
            return "AlbumData(type=" + this.f261001a + ", data=" + this.f261002b + ')';
        }

        public final int getType() {
            return this.f261001a;
        }

        public b(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f261001a = 0;
            this.f261002b = r100;
        }
    }

    @Override // com.bytedance.locallife.pdp.album.adapter.RecyclerViewWithFooterAdapter
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if ((r100 instanceof PictureViewHolder) == false) goto L34;
        AlbumPageInfo r102 = this.f260996m.getAlbumInfo().get(this.f260998o);
        if (r102 == null) goto L9;
        List<PhotoData> r103 = r102.getPhotoData();
        if (r103 == null) goto L9;
        int r104 = r103.size();
    L10:
        if (r101 < 0) goto L35;
        if (r101 >= r104) goto L37;
        AlbumPageInfo r105 = this.f260996m.getAlbumInfo().get(this.f260998o);
        if (r105 == null) goto L18;
        List<PhotoData> r106 = r105.getPhotoData();
        if (r106 == null) goto L18;
        PhotoData r107 = (PhotoData) ListProtector.get(r106, r101);
    L19:
        if (r107 == null) goto L22;
        r107.setTabId(this.f260998o);
    L22:
        if (r107 == null) goto L25;
        r107.setIndex(Integer.valueOf(r101));
    L25:
        PictureViewHolder r108 = (PictureViewHolder) r100;
        a r109 = this.f260999p;
        if (r107 != null) goto L28;
        r108.getClass();
        return;
    L28:
        rp6.a.b(r108.f261004b, r107.getUrl(), -1, -1);
        DuxTextView r110 = r108.f261005c;
        if (TextUtils.isEmpty(r107.getNameForShow()) == true) goto L31;
        String r111 = r107.getNameForShow();
    L32:
        r110.setText(r111);
        r108.f261003a.setRadius((int) UIUtils.dip2Px(r108.itemView.getContext(), 4.0f));
        r108.f261003a.setOnClickListener(new com.bytedance.locallife.pdp.album.page.b(r109, r101, r108));
        return;
    L31:
        r111 = r107.getTabName();
    L18:
        r107 = null;
        goto L19
    L37:
        return;
    L35:
        return;
    L9:
        r104 = 0;
        goto L10
    }

    @Override // com.bytedance.locallife.pdp.album.adapter.RecyclerViewWithFooterAdapter
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
        if (r100 == null) goto L4;
        Context r102 = r100.getContext();
    L6:
        return new PictureViewHolder(LayoutInflater.from(r102).inflate(R.layout.saas_goods_photo_item, r100, false));
    L4:
        r102 = null;
        goto L6
    }

    public PictureRecyclerViewAdapter(CustomAlbumViewModel r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "tabId");
        this.f260996m = r100;
        this.f260997n = r101;
        this.f260998o = r102;
        if (true == this.f260962a) goto L5;
        this.f260962a = true;
        y2(true);
    L5:
        this.f260950c = -16777216;
        this.f260951d = -16777216;
        TextView r103 = this.f260953f;
        if (r103 == null) goto L8;
        r103.setText(R.string.trade_goods_cur_no_more);
    L8:
        this.f260952e = R.string.trade_goods_cur_no_more;
        this.f260999p = new a(this);
    }
}
