package com.bytedance.locallife.pdp.album.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.bytedance.locallife.model.album.PhotoData;
import com.bytedance.locallife.model.album.PoiAlbumParams;
import com.bytedance.locallife.model.album.TabInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 R2\u00020\u0001:\u0003STUB\u0007¢\u0006\u0004\bP\u0010QJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00198\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR#\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u00198\u0006¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001dR>\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0%j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&`'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R#\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/0.8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0006¢\u0006\f\n\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001dR3\u00106\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0%j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e`'8\u0006¢\u0006\f\n\u0004\b6\u0010)\u001a\u0004\b7\u0010+R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\f\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010\u0010R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010C\u001a\b\u0012\u0004\u0012\u00020B0\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010\u001b\u001a\u0004\bD\u0010\u001d\"\u0004\bE\u0010FR(\u0010G\u001a\b\u0012\u0004\u0012\u00020B0\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010\u001b\u001a\u0004\bH\u0010\u001d\"\u0004\bI\u0010FR\"\u0010J\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010\f\u001a\u0004\bK\u0010\u000e\"\u0004\bL\u0010\u0010R\"\u0010M\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010\f\u001a\u0004\bN\u0010\u000e\"\u0004\bO\u0010\u0010¨\u0006V"}, d2 = {"Lcom/bytedance/locallife/pdp/album/model/CustomAlbumViewModel;", "Landroidx/lifecycle/ViewModel;", "", "poiId", "poiName", "", "clearAlbumData", "requestTabData", "tabId", "", "requestMode", "requestAlbumPage", "Ljava/lang/String;", "getPoiName", "()Ljava/lang/String;", "setPoiName", "(Ljava/lang/String;)V", "getPoiId", "setPoiId", "productId", "getProductId", "setProductId", "poiBackendType", "getPoiBackendType", "setPoiBackendType", "Landroidx/lifecycle/MutableLiveData;", "currentTabIndex", "Landroidx/lifecycle/MutableLiveData;", "getCurrentTabIndex", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/locallife/pdp/album/model/CustomAlbumViewModel$RequestStatus;", "firstRequestStatus", "getFirstRequestStatus", "", "Lcom/bytedance/locallife/model/album/TabInfo;", "tabInfo", "getTabInfo", "Ljava/util/HashMap;", "Lcom/bytedance/locallife/model/album/AlbumPageInfo;", "Lkotlin/collections/HashMap;", "albumInfo", "Ljava/util/HashMap;", "getAlbumInfo", "()Ljava/util/HashMap;", "setAlbumInfo", "(Ljava/util/HashMap;)V", "", "", "requestingStatus", "Ljava/util/Map;", "getRequestingStatus", "()Ljava/util/Map;", "albumPageRequestStatus", "getAlbumPageRequestStatus", "requestStatusMap", "getRequestStatusMap", "requestFailMsg", "getRequestFailMsg", "setRequestFailMsg", "Lcom/bytedance/locallife/model/album/PoiAlbumParams;", "albumParams", "Lcom/bytedance/locallife/model/album/PoiAlbumParams;", "getAlbumParams", "()Lcom/bytedance/locallife/model/album/PoiAlbumParams;", "setAlbumParams", "(Lcom/bytedance/locallife/model/album/PoiAlbumParams;)V", "Ltv6/b;", "topLynxInfo", "getTopLynxInfo", "setTopLynxInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "bottomLynxInfo", "getBottomLynxInfo", "setBottomLynxInfo", "galleryHeaderLynx", "getGalleryHeaderLynx", "setGalleryHeaderLynx", "galleryBottomLynx", "getGalleryBottomLynx", "setGalleryBottomLynx", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "RequestStatus", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class CustomAlbumViewModel extends ViewModel {
    public static final a Companion = null;
    public static final int DEFAULT_CURSOR = 20;
    public static final String DEFAULT_TAB_ID = "00";
    private HashMap<String, AlbumPageInfo> albumInfo;
    private final MutableLiveData<String> albumPageRequestStatus;
    private PoiAlbumParams albumParams;
    private MutableLiveData<tv6.b> bottomLynxInfo;
    private final MutableLiveData<Integer> currentTabIndex;
    private final MutableLiveData<RequestStatus> firstRequestStatus;
    private String galleryBottomLynx;
    private String galleryHeaderLynx;
    private String poiBackendType;
    private String poiId;
    private String poiName;
    private String productId;
    private String requestFailMsg;
    private final HashMap<String, RequestStatus> requestStatusMap;
    private final Map<String, Boolean> requestingStatus;
    private final MutableLiveData<List<TabInfo>> tabInfo;
    private MutableLiveData<tv6.b> topLynxInfo;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/pdp/album/model/CustomAlbumViewModel$RequestStatus;", "", "", "status", "I", "getStatus", "()I", "FAIL", "SUCCESS", "LOADING", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final enum RequestStatus extends Enum<RequestStatus> {
        public static final RequestStatus FAIL = null;
        public static final RequestStatus LOADING = null;
        public static final RequestStatus SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RequestStatus[] f260974a = null;
        private final int status;

        public static RequestStatus valueOf(String r100) {
            return (RequestStatus) r27.a.a(RequestStatus.class, r100);
        }

        public static RequestStatus[] values() {
            return (RequestStatus[]) f260974a.clone();
        }

        static {
            RequestStatus r100 = new RequestStatus("FAIL", 0, 0);
            FAIL = r100;
            RequestStatus r101 = new RequestStatus("SUCCESS", 1, 1);
            SUCCESS = r101;
            RequestStatus r102 = new RequestStatus("LOADING", 2, 2);
            LOADING = r102;
            f260974a = new RequestStatus[]{r100, r101, r102};
        }

        public final int getStatus() {
            return this.status;
        }

        public RequestStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.status = r102;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f260975a = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f260976a = null;

            static {
                f260976a = new a();
            }

            public a() {
            }
        }

        static {
            f260975a = a.f260976a;
        }

        @GET("/data/v1/life/trip/product_hotel_album")
        Observable<tv6.a> a(@Query(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT) int r100, @Query("poi_id") String r101, @Query("product_id") String r102, @Query("tab_id") String r103, @Query("page_index") int r104, @Query("poi_backend_type") String r105);
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomAlbumViewModel f260977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f260978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f260979c;

        public c(CustomAlbumViewModel r100, String r101, int r102) {
            this.f260977a = r100;
            this.f260978b = r101;
            this.f260979c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AlbumPageInfo r101 = ((tv6.a) r100).a();
            if (r101 == null) goto L39;
            int r102 = this.f260979c;
            CustomAlbumViewModel r103 = this.f260977a;
            String r104 = this.f260978b;
            if (r102 != 1) goto L7;
            r103.getAlbumInfo().put(r104, r101);
        L38:
            r103.getRequestStatusMap().put(r104, RequestStatus.SUCCESS);
            r103.getAlbumPageRequestStatus().setValue(r104);
            goto L39
        L7:
            if (r102 != 4) goto L38;
            List<PhotoData> r105 = r101.getPhotoData();
            if (r105 == null) goto L19;
            Iterator<T> r106 = r105.iterator();
        L13:
            if (r106.hasNext() == false) goto L19;
            PhotoData r107 = (PhotoData) r106.next();
            AlbumPageInfo r108 = r103.getAlbumInfo().get(r104);
            if (r108 == null) goto L13;
            List<PhotoData> r109 = r108.getPhotoData();
            if (r109 == null) goto L13;
            r109.add(r107);
        L19:
            List<String> r110 = r101.getPhotoDataForLynx();
            if (r110 == null) goto L29;
            Iterator<T> r111 = r110.iterator();
        L23:
            if (r111.hasNext() == false) goto L29;
            String r112 = (String) r111.next();
            AlbumPageInfo r113 = r103.getAlbumInfo().get(r104);
            if (r113 == null) goto L23;
            List<String> r114 = r113.getPhotoDataForLynx();
            if (r114 == null) goto L23;
            r114.add(r112);
        L29:
            AlbumPageInfo r115 = r103.getAlbumInfo().get(r104);
            if (r115 == null) goto L33;
            r115.setHasMore(r101.getHasMore());
        L33:
            AlbumPageInfo r116 = r103.getAlbumInfo().get(r104);
            if (r116 == null) goto L38;
            r116.setNextOffset(r101.getNextOffset());
        L39:
            this.f260977a.getRequestingStatus().put(this.f260978b, Boolean.FALSE);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomAlbumViewModel f260980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f260981b;

        public d(CustomAlbumViewModel r100, String r101) {
            this.f260980a = r100;
            this.f260981b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f260980a.getRequestStatusMap().put(this.f260981b, RequestStatus.FAIL);
            this.f260980a.getAlbumPageRequestStatus().setValue(this.f260981b);
            this.f260980a.setRequestFailMsg(String.valueOf(((Throwable) r100).getMessage()));
            this.f260980a.getRequestingStatus().put(this.f260981b, Boolean.FALSE);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomAlbumViewModel f260982a;

        public e(CustomAlbumViewModel r100) {
            this.f260982a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tv6.a r101 = (tv6.a) r100;
            if (r101.h() == null) goto L5;
        L7:
            AlbumPageInfo r102 = r101.a();
            if (r102 == null) goto L19;
            CustomAlbumViewModel r103 = this.f260982a;
            String r104 = r102.getTabId();
            if (r104 == null) goto L19;
            r103.getAlbumInfo().put(r104, r102);
            r103.getRequestStatusMap().put(r104, RequestStatus.SUCCESS);
            r103.getAlbumPageRequestStatus().setValue(r104);
            AlbumPageInfo r105 = r103.getAlbumInfo().get(r104);
            if (r105 == null) goto L15;
            r105.setHasMore(r102.getHasMore());
        L15:
            AlbumPageInfo r106 = r103.getAlbumInfo().get(r104);
            if (r106 == null) goto L19;
            r106.setNextOffset(r102.getNextOffset());
        L19:
            this.f260982a.getFirstRequestStatus().postValue(RequestStatus.SUCCESS);
            this.f260982a.getTabInfo().postValue(r101.h());
            this.f260982a.getTopLynxInfo().postValue(new tv6.b(r101.j(), r101.i()));
            this.f260982a.getBottomLynxInfo().postValue(new tv6.b(r101.c(), r101.b()));
            CustomAlbumViewModel r107 = this.f260982a;
            String r108 = r101.e();
            String r109 = "";
            if (r108 != null) goto L22;
            r108 = "";
        L22:
            r107.setGalleryHeaderLynx(r108);
            CustomAlbumViewModel r110 = this.f260982a;
            String r111 = r101.d();
            if (r111 == null) goto L26;
            r109 = r111;
        L26:
            r110.setGalleryBottomLynx(r109);
            return;
        L5:
            if (r101.a() != null) goto L7;
            this.f260982a.getFirstRequestStatus().setValue(RequestStatus.FAIL);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomAlbumViewModel f260983a;

        public f(CustomAlbumViewModel r100) {
            this.f260983a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f260983a.getFirstRequestStatus().setValue(RequestStatus.FAIL);
        }
    }

    static {
        Companion = new a();
    }

    public final void requestTabData() {
        b.f260975a.getClass();
        qt6.b r100 = HostServiceUtilsKt.S();
        r100.h();
        ((b) r100.create("https://life-service-open.scsjsd.com", b.class)).a(20, this.poiId, this.productId, DEFAULT_TAB_ID, 1, this.poiBackendType).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new f(this));
    }

    public CustomAlbumViewModel() {
        this.poiName = "";
        this.poiId = "";
        this.productId = "";
        this.poiBackendType = "";
        this.currentTabIndex = new MutableLiveData();
        this.firstRequestStatus = new MutableLiveData();
        this.tabInfo = new MutableLiveData();
        this.albumInfo = new HashMap();
        this.requestingStatus = new LinkedHashMap();
        this.albumPageRequestStatus = new MutableLiveData();
        this.requestStatusMap = new HashMap();
        this.requestFailMsg = "";
        this.topLynxInfo = new MutableLiveData();
        this.bottomLynxInfo = new MutableLiveData();
        this.galleryHeaderLynx = "";
        this.galleryBottomLynx = "";
    }

    public final HashMap<String, AlbumPageInfo> getAlbumInfo() {
        return this.albumInfo;
    }

    public final MutableLiveData<String> getAlbumPageRequestStatus() {
        return this.albumPageRequestStatus;
    }

    public final PoiAlbumParams getAlbumParams() {
        return this.albumParams;
    }

    public final MutableLiveData<tv6.b> getBottomLynxInfo() {
        return this.bottomLynxInfo;
    }

    public final MutableLiveData<Integer> getCurrentTabIndex() {
        return this.currentTabIndex;
    }

    public final MutableLiveData<RequestStatus> getFirstRequestStatus() {
        return this.firstRequestStatus;
    }

    public final String getGalleryBottomLynx() {
        return this.galleryBottomLynx;
    }

    public final String getGalleryHeaderLynx() {
        return this.galleryHeaderLynx;
    }

    public final String getPoiBackendType() {
        return this.poiBackendType;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getRequestFailMsg() {
        return this.requestFailMsg;
    }

    public final HashMap<String, RequestStatus> getRequestStatusMap() {
        return this.requestStatusMap;
    }

    public final Map<String, Boolean> getRequestingStatus() {
        return this.requestingStatus;
    }

    public final MutableLiveData<List<TabInfo>> getTabInfo() {
        return this.tabInfo;
    }

    public final MutableLiveData<tv6.b> getTopLynxInfo() {
        return this.topLynxInfo;
    }

    public final void setAlbumInfo(HashMap<String, AlbumPageInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.albumInfo = r100;
    }

    public final void setAlbumParams(PoiAlbumParams r100) {
        this.albumParams = r100;
    }

    public final void setBottomLynxInfo(MutableLiveData<tv6.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bottomLynxInfo = r100;
    }

    public final void setGalleryBottomLynx(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.galleryBottomLynx = r100;
    }

    public final void setGalleryHeaderLynx(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.galleryHeaderLynx = r100;
    }

    public final void setPoiBackendType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.poiBackendType = r100;
    }

    public final void setPoiId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.poiId = r100;
    }

    public final void setPoiName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.poiName = r100;
    }

    public final void setProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.productId = r100;
    }

    public final void setRequestFailMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestFailMsg = r100;
    }

    public final void setTopLynxInfo(MutableLiveData<tv6.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.topLynxInfo = r100;
    }

    public final void clearAlbumData(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "poiId");
        this.firstRequestStatus.setValue(RequestStatus.LOADING);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.poiName = r101;
        this.poiId = r100;
        this.tabInfo.setValue(new ArrayList());
        this.albumInfo.clear();
    }

    public final void requestAlbumPage(String r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "tabId");
        Boolean r101 = this.requestingStatus.get(r100);
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L5;
        return;
    L5:
        this.requestingStatus.put(r100, r102);
        b.f260975a.getClass();
        qt6.b r103 = HostServiceUtilsKt.S();
        r103.h();
        b r104 = (b) r103.create("https://life-service-open.scsjsd.com", b.class);
        String r105 = this.poiId;
        String r106 = this.productId;
        AlbumPageInfo r107 = this.albumInfo.get(r100);
        if (r107 == null) goto L10;
        Integer r108 = r107.getNextOffset();
        if (r108 == null) goto L10;
        int r109 = r108.intValue();
    L11:
        r104.a(20, r105, r106, r100, r109, this.poiBackendType).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r100, r110), new d(this, r100));
        return;
    L10:
        r109 = 1;
        goto L11
    }
}
