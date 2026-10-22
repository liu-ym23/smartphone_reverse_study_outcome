package com.bytedance.locallife.photo.photopage.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.dmt.ui.widget.ButtonStyle;
import com.bytedance.ies.dmt.ui.widget.DmtStatusView;
import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.bytedance.locallife.model.album.PhotoData;
import com.bytedance.locallife.model.album.PoiAlbumParams;
import com.bytedance.locallife.model.album.TabInfo;
import com.bytedance.locallife.photo.album.model.AlbumPageStatus;
import com.bytedance.locallife.photo.album.model.AlbumReportMode;
import com.bytedance.locallife.photo.album.model.AlbumViewModel;
import com.bytedance.locallife.photo.album.model.RequestStatus;
import com.bytedance.locallife.photo.photopage.adapter.AlbumBlankDecoration;
import com.bytedance.locallife.photo.photopage.adapter.PoiAlbumPageAdapter;
import com.bytedance.locallife.photo.photopage.view.PoiAlbumBaseViewHolder;
import com.bytedance.locallife.photo.stub.utils.RcHelper$buildBaseRecyclerView$1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/fragment/PoiAlbumFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/locallife/photo/album/model/k;", "albumTagClickEvent", "", "onTagClick", "Lcom/bytedance/locallife/photo/album/model/j;", "albumReportError", "onReportError", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiAlbumFragment extends Fragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f262177o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f262178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AlbumViewModel f262179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f262180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f262181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PoiAlbumPageAdapter f262182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GridLayoutManager f262183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f262184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f262185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f262186l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f262187m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f262188n;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiAlbumFragment f262189a;

        public b(PoiAlbumFragment r100) {
            this.f262189a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PoiAlbumFragment.T90(this.f262189a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public PoiAlbumFragment() {
        this.f262178d = new LinkedHashMap();
        this.f262181g = 1;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        vn6.b.c(this);
        PoiAlbumPageAdapter r100 = this.f262182h;
        if (r100 == null) goto L10;
        Iterator r101 = ((LinkedHashMap) r100.f262159h).entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        PoiAlbumBaseViewHolder r102 = (PoiAlbumBaseViewHolder) ((WeakReference) ((Map.Entry) r101.next()).getValue()).get();
        if (r102 == null) goto L6;
        r102.u();
        goto L6
    L16:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f262178d).clear();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        PoiAlbumPageAdapter r100 = this.f262182h;
        if (r100 == null) goto L10;
        Iterator r101 = ((LinkedHashMap) r100.f262159h).entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        PoiAlbumBaseViewHolder r102 = (PoiAlbumBaseViewHolder) ((WeakReference) ((Map.Entry) r101.next()).getValue()).get();
        if (r102 == null) goto L6;
        r102.U3();
        goto L6
    L16:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        PoiAlbumPageAdapter r100 = this.f262182h;
        if (r100 == null) goto L10;
        Iterator r101 = ((LinkedHashMap) r100.f262159h).entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        PoiAlbumBaseViewHolder r102 = (PoiAlbumBaseViewHolder) ((WeakReference) ((Map.Entry) r101.next()).getValue()).get();
        if (r102 == null) goto L6;
        r102.V3();
    L10:
        String r103 = this.f262185k;
        if (r103 == null) goto L45;
        AlbumViewModel r104 = this.f262179e;
        boolean r105 = false;
        if (r104 == null) goto L23;
        HashMap<String, AlbumPageInfo> r106 = r104.getAlbumInfo();
        if (r106 == null) goto L23;
        AlbumPageInfo r107 = r106.get(r103);
        if (r107 == null) goto L23;
        List<PhotoData> r108 = r107.getPhotoData();
        if (r108 == null) goto L23;
        if (r108.isEmpty() == true) goto L23;
        boolean r109 = true;
    L24:
        if (r109 == false) goto L46;
        PoiAlbumPageAdapter r110 = this.f262182h;
        if (r110 == null) goto L32;
        List<T> r111 = r110.f262151c;
        if (r111 == 0) goto L32;
        if (r111.isEmpty() == true) goto L32;
        r105 = true;
    L32:
        if (r105 == true) goto L47;
        AlbumViewModel r112 = this.f262179e;
        if (r112 == null) goto L38;
        HashMap<String, RequestStatus> r113 = r112.getRequestStatusMap();
        if (r113 == null) goto L38;
        RequestStatus r114 = r113.put(r103, RequestStatus.SUCCESS);
    L38:
        this.f262181g = 1;
        U90(r103);
        return;
    L47:
        return;
    L46:
        return;
    L23:
        r109 = false;
        goto L24
    }

    public static final void T90(final PoiAlbumFragment r210) {
        if (r210.getUserVisibleHint() == false) goto L217;
        GridLayoutManager r100 = r210.f262183i;
        if (r100 == null) goto L208;
        int r101 = r100.findFirstCompletelyVisibleItemPosition();
        GridLayoutManager r102 = r210.f262183i;
        if (r102 == null) goto L209;
        int r103 = r102.findLastCompletelyVisibleItemPosition();
        PoiAlbumPageAdapter r104 = r210.f262182h;
        if (r104 != null) goto L12;
    L51:
        String r105 = r210.f262185k;
        if (r105 == null) goto L218;
        Integer r106 = r210.f262184j;
        if (r106 == null) goto L210;
        int r107 = r106.intValue();
        AlbumViewModel r108 = r210.f262179e;
        if (r108 == null) goto L65;
        HashMap<String, AlbumPageInfo> r109 = r108.getAlbumInfo();
        if (r109 == null) goto L65;
        AlbumPageInfo r110 = r109.get(r105);
        if (r110 == null) goto L65;
        List<PhotoData> r111 = r110.getPhotoData();
        if (r111 == null) goto L65;
        int r112 = r111.size();
    L66:
        if (r112 <= 0) goto L219;
        AlbumViewModel r113 = r210.f262179e;
        if (r113 == null) goto L77;
        MutableLiveData<List<TabInfo>> r114 = r113.getTabInfo();
        if (r114 == null) goto L77;
        List<TabInfo> r115 = r114.getValue();
        if (r115 == null) goto L77;
        TabInfo r116 = (TabInfo) ListProtector.get(r115, r107);
        if (r116 == null) goto L77;
        String r117 = r116.getTabName();
    L78:
        AlbumViewModel r118 = r210.f262179e;
        if (r118 == null) goto L87;
        PoiAlbumParams r119 = r118.getAlbumParams();
        if (r119 == null) goto L87;
        String r120 = r119.getAnchorTabId();
        if (r120 == null) goto L87;
        if (com.bytedance.locallife.common.utils.j.a(r120) != true) goto L87;
        boolean r121 = true;
    L88:
        if (r121 == false) goto L135;
        AlbumViewModel r122 = r210.f262179e;
        if (r122 == null) goto L110;
        MutableLiveData<List<TabInfo>> r123 = r122.getTabInfo();
        if (r123 == null) goto L110;
        List<TabInfo> r124 = r123.getValue();
        if (r124 == null) goto L110;
        Iterator<TabInfo> r125 = r124.iterator();
        int r126 = 0;
    L97:
        if (r125.hasNext() == false) goto L108;
        String r127 = r125.next().getTabId();
        AlbumViewModel r128 = r210.f262179e;
        if (r128 == null) goto L103;
        PoiAlbumParams r129 = r128.getAlbumParams();
        if (r129 == null) goto L103;
        String r130 = r129.getAnchorTabId();
    L105:
        if (Intrinsics.areEqual(r127, r130) == true) goto L109;
        r126 = r126 + 1;
    L109:
        r107 = r126;
    L111:
        AlbumViewModel r131 = r210.f262179e;
        if (r131 == null) goto L134;
        MutableLiveData<List<TabInfo>> r132 = r131.getTabInfo();
        if (r132 == null) goto L134;
        List<TabInfo> r133 = r132.getValue();
        if (r133 == null) goto L134;
        Iterator<T> r134 = r133.iterator();
    L119:
        if (r134.hasNext() == false) goto L129;
        Object r135 = r134.next();
        String r136 = ((TabInfo) r135).getTabId();
        AlbumViewModel r137 = r210.f262179e;
        if (r137 == null) goto L125;
        PoiAlbumParams r138 = r137.getAlbumParams();
        if (r138 == null) goto L125;
        String r139 = r138.getAnchorTabId();
    L127:
        if (Intrinsics.areEqual(r136, r139) == false) goto L119;
    L130:
        TabInfo r140 = (TabInfo) r135;
        if (r140 == null) goto L134;
        r117 = r140.getTabName();
        if (r117 != null) goto L135;
    L125:
        r139 = null;
        goto L127
    L129:
        r135 = null;
    L134:
        r117 = "";
    L103:
        r130 = null;
        goto L105
    L108:
        r126 = -1;
    L110:
        r107 = 1;
    L135:
        if (r101 > r103) goto L179;
    L136:
        if (r101 < 0) goto L139;
        if (r101 >= r112) goto L139;
        boolean r141 = true;
    L140:
        if (r141 == false) goto L176;
        AlbumViewModel r142 = r210.f262179e;
        if (r142 == null) goto L150;
        HashMap<String, AlbumPageInfo> r143 = r142.getAlbumInfo();
        if (r143 == null) goto L150;
        AlbumPageInfo r144 = r143.get(r105);
        if (r144 == null) goto L150;
        List<PhotoData> r145 = r144.getPhotoData();
        if (r145 == null) goto L150;
        final PhotoData r146 = (PhotoData) ListProtector.get(r145, r101);
    L151:
        int r147 = com.bytedance.locallife.photo.photopage.a.f262144a;
        AlbumViewModel r148 = r210.f262179e;
        if (r148 == null) goto L156;
        PoiAlbumParams r149 = r148.getAlbumParams();
        if (r149 == null) goto L156;
        PoiBundle r150 = r149.getPoiBundle();
    L157:
        AlbumViewModel r151 = r210.f262179e;
        if (r151 == null) goto L162;
        PoiAlbumParams r152 = r151.getAlbumParams();
        if (r152 == null) goto L162;
        int r153 = r152.getPoiPicMode();
    L163:
        Integer r154 = Integer.valueOf(r107);
        AlbumViewModel r155 = r210.f262179e;
        if (r155 == null) goto L168;
        PoiAlbumParams r156 = r155.getAlbumParams();
        if (r156 == null) goto L168;
        String r157 = r156.getScreenMode();
    L169:
        AlbumViewModel r158 = r210.f262179e;
        if (r158 == null) goto L174;
        PoiAlbumParams r159 = r158.getAlbumParams();
        if (r159 == null) goto L174;
        Boolean r211 = Boolean.valueOf(r159.isHomePoiStyle());
    L175:
        com.bytedance.locallife.photo.photopage.a.f(r150, "album_page", r153, r101, r146, r117, r154, r157, null, r211, new PoiAlbumFragment$mobVisiblePicShow$3(r146, r210), ISmModel.VERSION_0700);
    L174:
        r211 = null;
    L168:
        r157 = null;
    L162:
        r153 = 0;
    L156:
        r150 = null;
    L150:
        r146 = null;
    L176:
        if (r101 == r103) goto L179;
        r101 = r101 + 1;
    L139:
        r141 = false;
    L179:
        if (r103 < (r112 - 3)) goto L211;
        AlbumViewModel r160 = r210.f262179e;
        if (r160 == null) goto L187;
        HashMap<String, AlbumPageInfo> r161 = r160.getAlbumInfo();
        if (r161 == null) goto L187;
        AlbumPageInfo r162 = r161.get(r105);
        if (r162 == null) goto L187;
        boolean r163 = Intrinsics.areEqual(r162.getHasMore(), Boolean.TRUE);
    L188:
        if (r163 == false) goto L194;
        PoiAlbumPageAdapter r164 = r210.f262182h;
        if (r164 != null) goto L192;
        return;
    L192:
        if (r164.f262153a == true) goto L213;
        r164.f262153a = true;
        r164.y2(true);
        return;
    L213:
        return;
    L194:
        PoiAlbumPageAdapter r165 = r210.f262182h;
        if (r165 != null) goto L197;
        return;
    L197:
        if (r165.f262153a == false) goto L216;
        r165.f262153a = false;
        r165.y2(false);
        return;
    L216:
        return;
    L187:
        r163 = false;
        goto L188
    L211:
        return;
    L87:
        r121 = false;
    L77:
        r117 = null;
        goto L78
    L219:
        return;
    L65:
        r112 = 0;
        goto L66
    L210:
        return;
    L218:
        return;
    L12:
        if (r101 == r104.f262160i) goto L14;
    L16:
        if (r101 > r103) goto L34;
        int r166 = r101;
    L19:
        if (r166 >= r104.f262160i) goto L21;
    L22:
        RecyclerView r167 = r104.f262155d;
        if (r167 == null) goto L25;
        RecyclerView.ViewHolder r168 = r167.findViewHolderForAdapterPosition(r166);
    L27:
        if ((r168 instanceof PoiAlbumBaseViewHolder) == false) goto L29;
        PoiAlbumBaseViewHolder r169 = (PoiAlbumBaseViewHolder) r168;
    L30:
        if (r169 == null) goto L32;
        r169.X3();
    L32:
        if (r166 == r103) goto L34;
        r166 = r166 + 1;
        goto L19
    L29:
        r169 = null;
        goto L30
    L25:
        r168 = null;
        goto L27
    L21:
        if (r166 <= r104.f262161j) goto L32;
    L34:
        int r170 = r104.f262160i;
        int r171 = r104.f262161j;
        if (r170 > r171) goto L50;
    L36:
        if (r170 < r101) goto L38;
        if (r170 > r103) goto L38;
    L48:
        if (r170 == r171) goto L50;
        r170 = r170 + 1;
    L38:
        RecyclerView r172 = r104.f262155d;
        if (r172 == null) goto L41;
        RecyclerView.ViewHolder r173 = r172.findViewHolderForAdapterPosition(r170);
    L43:
        if ((r173 instanceof PoiAlbumBaseViewHolder) == false) goto L45;
        PoiAlbumBaseViewHolder r174 = (PoiAlbumBaseViewHolder) r173;
    L46:
        if (r174 == null) goto L48;
        r174.W3();
        goto L48
    L45:
        r174 = null;
        goto L46
    L41:
        r173 = null;
    L50:
        r104.f262160i = r101;
        r104.f262161j = r103;
        goto L51
    L14:
        if (r103 != r104.f262161j) goto L16;
    L209:
        return;
    L208:
        return;
    }

    public final View S90(int r100) {
        if (this.f262178d != null) goto L5;
        this.f262178d = new LinkedHashMap();
    L5:
        View r101 = this.f262178d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        Integer r104 = Integer.valueOf(r100);
        this.f262178d.put(r104, r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void U90(String r100) {
        View r101 = S90(R.id.fragment_status_view);
        Collection r102 = null;
        if (r101 != null) goto L5;
        r101 = null;
    L5:
        DmtStatusView r103 = (DmtStatusView) r101;
        if (r103 == null) goto L9;
        r103.setVisibility(8);
    L9:
        View r104 = S90(R.id.album_recycle_view);
        if (r104 != null) goto L12;
        r104 = null;
    L12:
        RecyclerView r105 = (RecyclerView) r104;
        int r106 = 0;
        if (r105 == null) goto L16;
        r105.setVisibility(0);
    L16:
        AlbumViewModel r107 = this.f262179e;
        if (r107 == null) goto L69;
        HashMap<String, AlbumPageInfo> r108 = r107.getAlbumInfo();
        if (r108 == null) goto L70;
        AlbumPageInfo r109 = r108.get(r100);
        if (r109 == null) goto L71;
        List<PhotoData> r110 = r109.getPhotoData();
        if (r110 == null) goto L72;
        PoiAlbumPageAdapter r111 = this.f262182h;
        if (r111 == null) goto L27;
        r102 = r111.f262151c;
    L27:
        if (r102 != null) goto L32;
        if (r111 == null) goto L32;
        r111.f262151c = new ArrayList();
    L32:
        if (this.f262181g != 1) goto L46;
        PoiAlbumPageAdapter r112 = this.f262182h;
        if (r112 == null) goto L38;
        List<T> r113 = r112.f262151c;
        if (r113 == 0) goto L38;
        r113.clear();
    L38:
        PoiAlbumPageAdapter r114 = this.f262182h;
        if (r114 == null) goto L43;
        List<T> r115 = r114.f262151c;
        if (r115 == 0) goto L43;
        r115.addAll(r110);
    L43:
        PoiAlbumPageAdapter r116 = this.f262182h;
        if (r116 == null) goto L61;
        r116.notifyDataSetChanged();
    L61:
        int r117 = this.f262187m;
        if (r117 > 0) goto L64;
        return;
    L64:
        if (this.f262188n == true) goto L74;
        RecyclerView r118 = this.f262180f;
        if (r118 == null) goto L75;
        r118.post(new t(this, r117));
        return;
    L75:
        return;
    L74:
        return;
    L46:
        PoiAlbumPageAdapter r119 = this.f262182h;
        if (r119 == null) goto L51;
        List<T> r120 = r119.f262151c;
        if (r120 == 0) goto L51;
        r106 = r120.size();
    L51:
        List r121 = CollectionsKt.drop(r110, r106);
        List r122 = r121;
        if ((true ^ r122.isEmpty()) == false) goto L61;
        PoiAlbumPageAdapter r123 = this.f262182h;
        if (r123 == null) goto L58;
        List<T> r124 = r123.f262151c;
        if (r124 == 0) goto L58;
        r124.addAll(r122);
    L58:
        PoiAlbumPageAdapter r125 = this.f262182h;
        if (r125 == null) goto L61;
        r125.notifyItemRangeInserted(r106, r121.size());
        goto L61
    L72:
        return;
    L71:
        return;
    L70:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        this.f262184j = Integer.valueOf(r101.getInt("tab_index"));
        this.f262185k = r101.getString("tab_id");
        this.f262187m = r101.getInt("scroll_index");
    L5:
        vn6.b.b(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReportError(com.bytedance.locallife.photo.album.model.j r100) {
        Intrinsics.checkNotNullParameter(r100, "albumReportError");
        if (Intrinsics.areEqual(r100.f261993a, this.f262185k) == true) goto L6;
        return;
    L6:
        if (r100.f261994b != AlbumReportMode.OPEN.getValue()) goto L11;
        RecyclerView r101 = this.f262180f;
        if (r101 == null) goto L11;
        r101.setPadding(0, 0, 0, 0);
    L11:
        if (r100.f261994b != AlbumReportMode.CLOSE.getValue()) goto L26;
        RecyclerView r102 = this.f262180f;
        if (r102 == null) goto L22;
        AlbumViewModel r103 = this.f262179e;
        if (r103 == null) goto L20;
        MutableLiveData<Integer> r104 = r103.getTagHeightLiveData();
        if (r104 == null) goto L20;
        Integer r105 = r104.getValue();
        if (r105 == null) goto L20;
    L21:
        r102.setPadding(0, r105.intValue(), 0, 0);
    L20:
        r105 = 0;
    L22:
        RecyclerView r106 = this.f262180f;
        if (r106 == null) goto L27;
        r106.scrollToPosition(0);
        return;
    L27:
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onTagClick(com.bytedance.locallife.photo.album.model.k r100) {
        Intrinsics.checkNotNullParameter(r100, "albumTagClickEvent");
        if (Intrinsics.areEqual(r100.f261995a, this.f262185k) == false) goto L8;
        RecyclerView r101 = this.f262180f;
        if (r101 == null) goto L9;
        r101.scrollToPosition(0);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        PoiAlbumPageAdapter r101 = this.f262182h;
        if (r101 == null) goto L10;
        Iterator r102 = ((LinkedHashMap) r101.f262159h).entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        PoiAlbumBaseViewHolder r103 = (PoiAlbumBaseViewHolder) ((WeakReference) ((Map.Entry) r102.next()).getValue()).get();
        if (r103 == null) goto L6;
        r103.Y3();
    L10:
        if (r100 == false) goto L20;
        RecyclerView r104 = this.f262180f;
        if (r104 == null) goto L21;
        r104.post(new b(this));
        return;
    L21:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f262179e = (AlbumViewModel) com.bytedance.locallife.common.utils.m.a(getActivity(), AlbumViewModel.class);
        String r112 = this.f262185k;
        MutableLiveData<String> r113 = null;
        if (r112 == null) goto L22;
        Context r100 = getContext();
        com.bytedance.ies.dmt.ui.widget.b r101 = new com.bytedance.ies.dmt.ui.widget.b();
        Context r102 = r100.getApplicationContext();
        r101.f248443a = R.drawable.img_s_s_network_error;
        r101.f248444b = r102.getResources().getDrawable(R.drawable.img_s_s_network_error);
        r101.f248451i = true;
        String r103 = r102.getString(R.string.uikit_network_error);
        r101.f248445c = r103;
        if (TextUtils.isEmpty(r103) == true) goto L135;
        r101.f248452j = true;
        r101.f248446d = r102.getString(R.string.uikit_check_and_retry);
        r101.f248453k = true;
        ButtonStyle r104 = ButtonStyle.BORDER;
        s r105 = new s(this, r112);
        r101.f248447e = r104;
        r101.f248448f = r102.getString(R.string.uikit_retry);
        r101.f248449g = r105;
        r101.f248454l = true;
        Context r106 = getContext();
        com.bytedance.ies.dmt.ui.widget.b r107 = new com.bytedance.ies.dmt.ui.widget.b();
        Context r108 = r106.getApplicationContext();
        String r109 = r108.getString(R.string.poi_empty);
        r107.f248445c = r109;
        if (TextUtils.isEmpty(r109) == true) goto L133;
        r107.f248452j = true;
        r107.f248446d = r108.getString(R.string.poi_later);
        r107.f248453k = true;
        r r114 = new r(this, r112);
        r107.f248447e = r104;
        r107.f248448f = r108.getString(R.string.uikit_retry);
        r107.f248449g = r114;
        r107.f248454l = true;
        View r115 = S90(R.id.fragment_status_view);
        if (r115 != null) goto L12;
        r115 = null;
    L12:
        DmtStatusView r116 = (DmtStatusView) r115;
        if (r116 == null) goto L15;
        DmtStatusView.a r117 = DmtStatusView.a.a(getContext());
        r117.e(r101);
        r117.c(r107);
        r116.setBuilder(r117);
    L15:
        View r118 = S90(R.id.fragment_status_view);
        if (r118 != null) goto L18;
        r118 = null;
    L18:
        DmtStatusView r119 = (DmtStatusView) r118;
        if (r119 == null) goto L22;
        r119.setForceLightTheme(Boolean.TRUE);
        goto L22
    L133:
        throw new IllegalArgumentException("title should not be empty string!");
    L135:
        throw new IllegalArgumentException("title should not be empty string!");
    L22:
        String r120 = this.f262185k;
        if (r120 == null) goto L51;
        Integer r121 = this.f262184j;
        if (r121 == null) goto L51;
        final int r122 = r121.intValue();
        AlbumViewModel r123 = this.f262179e;
        if (r123 == null) goto L36;
        PoiAlbumPageAdapter r124 = new PoiAlbumPageAdapter(this.f262180f, r123, r122, r120, this);
        this.f262182h = r124;
        RecyclerView r125 = this.f262180f;
        if (r125 == null) goto L33;
        r125.setAdapter(r124);
    L33:
        PoiAlbumPageAdapter r126 = this.f262182h;
        if (r126 == null) goto L36;
        r126.f262154b = new PoiAlbumFragment$initRecycleView$1$1(this);
    L36:
        Context r127 = getContext();
        if (r127 == null) goto L41;
        RecyclerView r128 = this.f262180f;
        if (r128 == null) goto L41;
        r128.addItemDecoration(new AlbumBlankDecoration(r127));
    L41:
        RecyclerView r129 = this.f262180f;
        final p r130 = new p(this, r120);
        int r131 = zx6.b.f573888a;
        Intrinsics.checkNotNullParameter(r130, "listener");
        if (r129 == null) goto L45;
        r129.addOnScrollListener(new RcHelper$buildBaseRecyclerView$1(r130));
    L45:
        RecyclerView r132 = this.f262180f;
        if (r132 == null) goto L48;
        r132.addOnScrollListener(new PoiAlbumFragment$initRecycleView$4(this, r122));
    L48:
        RecyclerView r133 = this.f262180f;
        if (r133 == null) goto L51;
        new wn6.d(r133, new q());
    L51:
        String r134 = this.f262185k;
        if (r134 == null) goto L79;
        AlbumViewModel r135 = this.f262179e;
        if (r135 == null) goto L59;
        MutableLiveData<String> r136 = r135.getAlbumPageRequestStatus();
        if (r136 == null) goto L59;
        r136.observe(this, new k(r134, this));
    L59:
        AlbumViewModel r137 = this.f262179e;
        if (r137 == null) goto L64;
        MutableLiveData<AlbumPageStatus> r138 = r137.getAlbumPageStatus();
        if (r138 == null) goto L64;
        r138.observe(this, new l(this));
    L64:
        AlbumViewModel r139 = this.f262179e;
        if (r139 == null) goto L69;
        MutableLiveData<PhotoData> r140 = r139.getErrorPicChange();
        if (r140 == null) goto L69;
        r140.observe(this, new m(this));
    L69:
        AlbumViewModel r141 = this.f262179e;
        if (r141 == null) goto L74;
        MutableLiveData<Boolean> r142 = r141.getDeletePhotoStatus();
        if (r142 == null) goto L74;
        r142.observe(this, new n(this));
    L74:
        AlbumViewModel r143 = this.f262179e;
        if (r143 == null) goto L79;
        MutableLiveData<Integer> r144 = r143.getTagHeightLiveData();
        if (r144 == null) goto L79;
        r144.observe(this, new o(this));
    L79:
        String r145 = this.f262185k;
        if (r145 == null) goto L139;
        AlbumViewModel r146 = this.f262179e;
        if (r146 == null) goto L87;
        HashMap<String, AlbumPageInfo> r147 = r146.getAlbumInfo();
        if (r147 == null) goto L87;
        AlbumPageInfo r148 = r147.get(r145);
    L88:
        if (r148 == null) goto L102;
        List<PhotoData> r149 = r148.getPhotoData();
        if (r149 != null) goto L92;
    L94:
        boolean r150 = false;
    L95:
        if (r150 == false) goto L102;
        AlbumViewModel r151 = this.f262179e;
        if (r151 == null) goto L101;
        HashMap<String, RequestStatus> r152 = r151.getRequestStatusMap();
        if (r152 == null) goto L101;
        RequestStatus r153 = r152.put(r145, RequestStatus.SUCCESS);
    L101:
        this.f262181g = 1;
        U90(r145);
        return;
    L92:
        if ((!r149.isEmpty()) != true) goto L94;
        r150 = true;
    L102:
        if (r148 == null) goto L104;
        return;
    L104:
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L116;
        AlbumViewModel r154 = this.f262179e;
        if (r154 == null) goto L110;
        HashMap<String, RequestStatus> r155 = r154.getRequestStatusMap();
        if (r155 == null) goto L110;
        RequestStatus r156 = r155.put(r145, RequestStatus.FAIL);
    L110:
        AlbumViewModel r157 = this.f262179e;
        if (r157 == null) goto L113;
        r113 = r157.getAlbumPageRequestStatus();
    L113:
        if (r113 == null) goto L140;
        r113.setValue(r145);
        return;
    L140:
        return;
    L116:
        AlbumViewModel r158 = this.f262179e;
        if (r158 == null) goto L121;
        HashMap<String, RequestStatus> r159 = r158.getRequestStatusMap();
        if (r159 == null) goto L121;
        RequestStatus r160 = r159.put(r145, RequestStatus.LOADING);
    L121:
        AlbumViewModel r161 = this.f262179e;
        if (r161 == null) goto L124;
        r113 = r161.getAlbumPageRequestStatus();
    L124:
        if (r113 == null) goto L127;
        r113.setValue(r145);
    L127:
        AlbumViewModel r162 = this.f262179e;
        if (r162 == null) goto L130;
        r162.requestAlbumPage(r145, 1);
    L130:
        this.f262181g = 1;
        return;
    L87:
        r148 = null;
        goto L88
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.poi_fragment_poi_album_page, r101, false);
        GridLayoutManager r104 = new GridLayoutManager(getContext(), 2);
        this.f262183i = r104;
        r104.setOrientation(1);
        RecyclerView r105 = (RecyclerView) r103.findViewById(R.id.album_recycle_view);
        this.f262180f = r105;
        if (r105 == null) goto L6;
        r105.setLayoutManager(this.f262183i);
    L6:
        return r103;
    }
}
