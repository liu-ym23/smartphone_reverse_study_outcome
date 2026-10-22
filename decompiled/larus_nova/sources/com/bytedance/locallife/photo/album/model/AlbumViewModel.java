package com.bytedance.locallife.photo.album.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.bytedance.locallife.model.album.PhotoData;
import com.bytedance.locallife.model.album.PoiAlbumParams;
import com.bytedance.locallife.model.album.TabInfo;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.locallife.photo.album.AlbumApi;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J0\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nJ\"\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ$\u0010\u0014\u001a\u00020\u00022\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R3\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+0.j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+`/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00104\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u00106R%\u00109\u001a\u0010\u0012\f\u0012\n 8*\u0004\u0018\u00010\u00060\u0006078\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\"\u0010=\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010&\u001a\u0004\b>\u0010(\"\u0004\b?\u0010*R(\u0010A\u001a\b\u0012\u0004\u0012\u00020@078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010:\u001a\u0004\bB\u0010<\"\u0004\bC\u0010DR&\u0010G\u001a\u00060Ej\u0002`F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LRF\u0010O\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060Mj\u0002`N0.j\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u00060Mj\u0002`N`/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u00101\u001a\u0004\bP\u00103\"\u0004\bQ\u0010RR2\u0010T\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110S078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010:\u001a\u0004\bU\u0010<\"\u0004\bV\u0010DR,\u0010W\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010\u001a\u001a\u0004\b^\u0010\u001c\"\u0004\b_\u0010\u001eR(\u0010`\u001a\b\u0012\u0004\u0012\u00020\u0004078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010:\u001a\u0004\ba\u0010<\"\u0004\bb\u0010DR*\u0010c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010X\u001a\u0004\bd\u0010Z\"\u0004\be\u0010\\R$\u0010f\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110S078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010:R'\u0010h\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110S0g8\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u001d\u0010l\u001a\b\u0012\u0004\u0012\u00020\u0004078\u0006¢\u0006\f\n\u0004\bl\u0010:\u001a\u0004\bm\u0010<R)\u0010p\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020o0n078\u0006¢\u0006\f\n\u0004\bp\u0010:\u001a\u0004\bq\u0010<R3\u0010r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0.j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n`/8\u0006¢\u0006\f\n\u0004\br\u00101\u001a\u0004\bs\u00103R$\u0010t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010\u001a\u001a\u0004\bu\u0010\u001c\"\u0004\bv\u0010\u001eR\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020o078\u0006¢\u0006\f\n\u0004\bw\u0010:\u001a\u0004\bx\u0010<R\u001d\u0010y\u001a\b\u0012\u0004\u0012\u00020\u0004078\u0006¢\u0006\f\n\u0004\by\u0010:\u001a\u0004\bz\u0010<R3\u0010{\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020o0.j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020o`/8\u0006¢\u0006\f\n\u0004\b{\u00101\u001a\u0004\b|\u00103R\"\u0010}\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b}\u0010\u001a\u001a\u0004\b~\u0010\u001c\"\u0004\b\u007f\u0010\u001eR \u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020o078\u0006¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010:\u001a\u0005\b\u0081\u0001\u0010<R&\u0010\u0082\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010\u001a\u001a\u0005\b\u0083\u0001\u0010\u001c\"\u0005\b\u0084\u0001\u0010\u001eR2\u0010\u0087\u0001\u001a\u000e\u0012\n\u0012\b0\u0085\u0001j\u0003`\u0086\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010X\u001a\u0005\b\u0088\u0001\u0010Z\"\u0005\b\u0089\u0001\u0010\\R&\u0010\u008a\u0001\u001a\u000e\u0012\n\u0012\b0\u0085\u0001j\u0003`\u0086\u0001078\u0006¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010:\u001a\u0005\b\u008b\u0001\u0010<R,\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\n078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010:\u001a\u0005\b\u008d\u0001\u0010<\"\u0005\b\u008e\u0001\u0010DR(\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008f\u0001\u0010\u001a\u001a\u0005\b\u0090\u0001\u0010\u001c\"\u0005\b\u0091\u0001\u0010\u001eR&\u0010\u0092\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010 \u001a\u0005\b\u0092\u0001\u0010\"\"\u0005\b\u0093\u0001\u0010$R,\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\n078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010:\u001a\u0005\b\u0095\u0001\u0010<\"\u0005\b\u0096\u0001\u0010DR&\u0010\u0097\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010 \u001a\u0005\b\u0098\u0001\u0010\"\"\u0005\b\u0099\u0001\u0010$R(\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010\u001a\u001a\u0005\b\u009b\u0001\u0010\u001c\"\u0005\b\u009c\u0001\u0010\u001eR(\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009d\u0001\u0010\u001a\u001a\u0005\b\u009e\u0001\u0010\u001c\"\u0005\b\u009f\u0001\u0010\u001eR2\u0010¢\u0001\u001a\u000e\u0012\n\u0012\b0 \u0001j\u0003`¡\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u0010:\u001a\u0005\b£\u0001\u0010<\"\u0005\b¤\u0001\u0010DR,\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\n078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¥\u0001\u0010:\u001a\u0005\b¦\u0001\u0010<\"\u0005\b§\u0001\u0010DR3\u0010©\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¨\u00010S078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b©\u0001\u0010:\u001a\u0005\bª\u0001\u0010<\"\u0005\b«\u0001\u0010DR2\u0010¬\u0001\u001a\u000e\u0012\n\u0012\b0 \u0001j\u0003`¡\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¬\u0001\u0010:\u001a\u0005\b\u00ad\u0001\u0010<\"\u0005\b®\u0001\u0010D¨\u0006±\u0001"}, d2 = {"Lcom/bytedance/locallife/photo/album/model/AlbumViewModel;", "Landroidx/lifecycle/ViewModel;", "", "requestTabInfo", "", "tabId", "", "requestMode", "requestAlbumPage", "topItemId", "", "needUpdateToFeed", "updateTabInfo", "requestVideoPage", "filterTabId", "", "Lcom/bytedance/locallife/model/album/TabInfo;", "Lcom/bytedance/locallife/photo/album/model/TabInfo;", "tabs", "initTabId", "initVideoFilterTabsOnce", "requestTopBottomData", "initAlbumData", "clearAlbumData", "checkHasDeletePhoto", "poiEnterId", "Ljava/lang/String;", "getPoiEnterId", "()Ljava/lang/String;", "setPoiEnterId", "(Ljava/lang/String;)V", "maxErrorNum", "I", "getMaxErrorNum", "()I", "setMaxErrorNum", "(I)V", "hasMobEnterAlbum", "Z", "getHasMobEnterAlbum", "()Z", "setHasMobEnterAlbum", "(Z)V", "Lcom/bytedance/locallife/photo/album/model/AlbumPageModel;", "albumPageModel", "Lcom/bytedance/locallife/photo/album/model/AlbumPageModel;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pageModels", "Ljava/util/HashMap;", "getPageModels", "()Ljava/util/HashMap;", "videoPageModel", "getVideoPageModel", "()Lcom/bytedance/locallife/photo/album/model/AlbumPageModel;", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "tagHeightLiveData", "Landroidx/lifecycle/MutableLiveData;", "getTagHeightLiveData", "()Landroidx/lifecycle/MutableLiveData;", "hasVideoData", "getHasVideoData", "setHasVideoData", "Lcom/bytedance/locallife/photo/album/model/AlbumPageStatus;", "albumPageStatus", "getAlbumPageStatus", "setAlbumPageStatus", "(Landroidx/lifecycle/MutableLiveData;)V", "Lcom/bytedance/locallife/model/album/PoiAlbumParams;", "Lcom/bytedance/locallife/photo/album/model/PoiAlbumParams;", "albumParams", "Lcom/bytedance/locallife/model/album/PoiAlbumParams;", "getAlbumParams", "()Lcom/bytedance/locallife/model/album/PoiAlbumParams;", "setAlbumParams", "(Lcom/bytedance/locallife/model/album/PoiAlbumParams;)V", "Lcom/bytedance/locallife/model/album/AlbumPageInfo;", "Lcom/bytedance/locallife/photo/album/model/AlbumPageInfo;", "albumInfo", "getAlbumInfo", "setAlbumInfo", "(Ljava/util/HashMap;)V", "", "tabInfo", "getTabInfo", "setTabInfo", "albumTabList", "Ljava/util/List;", "getAlbumTabList", "()Ljava/util/List;", "setAlbumTabList", "(Ljava/util/List;)V", "currentSelectTabId", "getCurrentSelectTabId", "setCurrentSelectTabId", "currentSelectTabLiveData", "getCurrentSelectTabLiveData", "setCurrentSelectTabLiveData", "videoInfo", "getVideoInfo", "setVideoInfo", "_videoFilterTabInfo", "Landroidx/lifecycle/LiveData;", "videoFilterTabInfo", "Landroidx/lifecycle/LiveData;", "getVideoFilterTabInfo", "()Landroidx/lifecycle/LiveData;", "selectedVideoFilterTabId", "getSelectedVideoFilterTabId", "Lkotlin/Pair;", "Lcom/bytedance/locallife/photo/album/model/RequestStatus;", "videoPageRequestStatus", "getVideoPageRequestStatus", "videoShowMob", "getVideoShowMob", "currentAwemeId", "getCurrentAwemeId", "setCurrentAwemeId", "tabRequestStatus", "getTabRequestStatus", "albumPageRequestStatus", "getAlbumPageRequestStatus", "requestStatusMap", "getRequestStatusMap", "requestFailMsg", "getRequestFailMsg", "setRequestFailMsg", "videoRequestStatus", "getVideoRequestStatus", "videoRequestFailMsg", "getVideoRequestFailMsg", "setVideoRequestFailMsg", "Lcom/bytedance/locallife/model/album/PhotoData;", "Lcom/bytedance/locallife/photo/album/model/PhotoData;", "errorPicList", "getErrorPicList", "setErrorPicList", "errorPicChange", "getErrorPicChange", "deletePhotoStatus", "getDeletePhotoStatus", "setDeletePhotoStatus", "photoReportSchema", "getPhotoReportSchema", "setPhotoReportSchema", "isHasTab", "setHasTab", "tabInfoReady", "getTabInfoReady", "setTabInfoReady", "currentTabIndex", "getCurrentTabIndex", "setCurrentTabIndex", "galleryHeaderLynx", "getGalleryHeaderLynx", "setGalleryHeaderLynx", "galleryBottomLynx", "getGalleryBottomLynx", "setGalleryBottomLynx", "Ltv6/b;", "Lcom/bytedance/locallife/photo/album/model/LynxInfo;", "bottomLynxInfoTrip", "getBottomLynxInfoTrip", "setBottomLynxInfoTrip", "hideAlbumUploadButton", "getHideAlbumUploadButton", "setHideAlbumUploadButton", "Lcom/bytedance/locallife/photo/album/model/n;", "rightMoreItems", "getRightMoreItems", "setRightMoreItems", "commonBottomLynxInfo", "getCommonBottomLynxInfo", "setCommonBottomLynxInfo", "<init>", "()V", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class AlbumViewModel extends ViewModel {
    private final MutableLiveData<List<TabInfo>> _videoFilterTabInfo;
    private HashMap<String, AlbumPageInfo> albumInfo;
    private final AlbumPageModel albumPageModel;
    private final MutableLiveData<String> albumPageRequestStatus;
    private MutableLiveData<AlbumPageStatus> albumPageStatus;
    private PoiAlbumParams albumParams;
    private List<TabInfo> albumTabList;
    private MutableLiveData<tv6.b> bottomLynxInfoTrip;
    private MutableLiveData<tv6.b> commonBottomLynxInfo;
    private String currentAwemeId;
    private String currentSelectTabId;
    private MutableLiveData<String> currentSelectTabLiveData;
    private int currentTabIndex;
    private MutableLiveData<Boolean> deletePhotoStatus;
    private final MutableLiveData<PhotoData> errorPicChange;
    private List<PhotoData> errorPicList;
    private String galleryBottomLynx;
    private String galleryHeaderLynx;
    private boolean hasMobEnterAlbum;
    private boolean hasVideoData;
    private MutableLiveData<Boolean> hideAlbumUploadButton;
    private int isHasTab;
    private int maxErrorNum;
    private final HashMap<String, AlbumPageModel> pageModels;
    private String photoReportSchema;
    private String poiEnterId;
    private String requestFailMsg;
    private final HashMap<String, RequestStatus> requestStatusMap;
    private MutableLiveData<List<n>> rightMoreItems;
    private final MutableLiveData<String> selectedVideoFilterTabId;
    private MutableLiveData<List<TabInfo>> tabInfo;
    private MutableLiveData<Boolean> tabInfoReady;
    private final MutableLiveData<RequestStatus> tabRequestStatus;
    private final MutableLiveData<Integer> tagHeightLiveData;
    private final LiveData<List<TabInfo>> videoFilterTabInfo;
    private List<String> videoInfo;
    private final AlbumPageModel videoPageModel;
    private final MutableLiveData<Pair<String, RequestStatus>> videoPageRequestStatus;
    private String videoRequestFailMsg;
    private final MutableLiveData<RequestStatus> videoRequestStatus;
    private final HashMap<String, Boolean> videoShowMob;

    public final void clearAlbumData() {
    }

    public AlbumViewModel() {
        this.poiEnterId = "";
        this.maxErrorNum = 5;
        this.albumPageModel = new AlbumPageModel();
        this.pageModels = new HashMap();
        this.videoPageModel = new AlbumPageModel();
        this.tagHeightLiveData = new MutableLiveData(0);
        this.albumPageStatus = new MutableLiveData();
        this.albumParams = new PoiAlbumParams(null, null, null, null, null, null, null, 0, null, false, null, null, false, 0, null, null, null, null, false, false, null, null, false, false, false, 0, null, null, false, 536870911, null);
        this.albumInfo = new HashMap();
        this.tabInfo = new MutableLiveData();
        this.albumTabList = CollectionsKt.emptyList();
        this.currentSelectTabId = "";
        this.currentSelectTabLiveData = new MutableLiveData();
        MutableLiveData<List<TabInfo>> r100 = new MutableLiveData();
        this._videoFilterTabInfo = r100;
        this.videoFilterTabInfo = r100;
        this.selectedVideoFilterTabId = new MutableLiveData();
        this.videoPageRequestStatus = new MutableLiveData();
        this.videoShowMob = new HashMap();
        this.tabRequestStatus = new MutableLiveData();
        this.albumPageRequestStatus = new MutableLiveData();
        this.requestStatusMap = new HashMap();
        this.requestFailMsg = "";
        this.videoRequestStatus = new MutableLiveData();
        this.videoRequestFailMsg = "";
        this.errorPicList = new ArrayList();
        this.errorPicChange = new MutableLiveData();
        this.deletePhotoStatus = new MutableLiveData();
        this.tabInfoReady = new MutableLiveData();
        this.bottomLynxInfoTrip = new MutableLiveData();
        this.hideAlbumUploadButton = new MutableLiveData();
        this.rightMoreItems = new MutableLiveData();
        this.commonBottomLynxInfo = new MutableLiveData();
    }

    public final void checkHasDeletePhoto() {
        ConcurrentHashMap<String, HashMap<String, AlbumPageInfo>> r100 = b.f261973a;
        String r101 = this.poiEnterId;
        Intrinsics.checkNotNullParameter(r101, "key");
        ConcurrentHashMap<String, Boolean> r102 = b.f261975c;
        Boolean r103 = r102.get(r101);
        if (r103 != null) goto L5;
        boolean r104 = false;
    L6:
        if (r104 == false) goto L9;
        this.deletePhotoStatus.setValue(Boolean.TRUE);
        this.errorPicChange.setValue(null);
        String r105 = this.poiEnterId;
        Intrinsics.checkNotNullParameter(r105, "key");
        r102.put(r105, Boolean.FALSE);
        return;
    L9:
        return;
    L5:
        r104 = r103.booleanValue();
        goto L6
    }

    public final void initAlbumData() {
        ConcurrentHashMap<String, HashMap<String, AlbumPageInfo>> r100 = b.f261973a;
        String r101 = this.poiEnterId;
        Intrinsics.checkNotNullParameter(r101, "key");
        b.f261975c.put(r101, Boolean.FALSE);
        HashMap<String, AlbumPageInfo> r102 = new HashMap();
        ConcurrentHashMap<String, HashMap<String, AlbumPageInfo>> r103 = b.f261973a;
        if (r103.containsKey(r101) == false) goto L5;
        com.bytedance.locallife.biz.common.utils.c.a("PoiAlbumDataStoreManager", "addCategoryData duplicate key: " + r101);
    L6:
        ArrayList r104 = new ArrayList();
        ConcurrentHashMap<String, List<PhotoData>> r105 = b.f261974b;
        if (r105.containsKey(r101) == false) goto L9;
        com.bytedance.locallife.biz.common.utils.c.a("PoiAlbumDataStoreManager", "addErrorPhoto duplicate key: " + r101);
    L10:
        String r106 = this.poiEnterId;
        Intrinsics.checkNotNullParameter(r106, "key");
        HashMap<String, AlbumPageInfo> r107 = r103.get(r106);
        if (r107 != null) goto L13;
        r107 = new HashMap();
    L13:
        this.albumInfo = r107;
        String r108 = this.poiEnterId;
        Intrinsics.checkNotNullParameter(r108, "key");
        List<PhotoData> r109 = r105.get(r108);
        if (r109 != null) goto L16;
        r109 = new ArrayList();
    L16:
        this.errorPicList = r109;
        return;
    L9:
        r105.put(r101, r104);
        goto L10
    L5:
        r103.put(r101, r102);
        goto L6
    }

    public final void requestTabInfo() {
        AlbumPageModel r100 = this.albumPageModel;
        MutableLiveData<List<TabInfo>> r101 = this.tabInfo;
        HashMap<String, AlbumPageInfo> r102 = this.albumInfo;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "tabInfo");
        Intrinsics.checkNotNullParameter(r102, "albumInfo");
        Intrinsics.checkNotNullParameter(this, "viewModel");
        getAlbumParams().getPoiId();
        getAlbumParams().getPoiBackendType();
        ((AlbumApi) r100.f261965b.getValue()).albumMiddlePage(20, getAlbumParams().getPoiId(), CustomAlbumViewModel.DEFAULT_TAB_ID, 1, getAlbumParams().getPoiBackendType(), 0, "").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, r101, r102), new i(this));
    }

    public final void requestTopBottomData() {
        AlbumPageModel r100 = this.albumPageModel;
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "viewModel");
        AlbumApi r101 = (AlbumApi) r100.f261965b.getValue();
        String r102 = getAlbumParams().getPoiId();
        String r103 = getAlbumParams().getPoiBackendType();
        PoiBundle r104 = getAlbumParams().getPoiBundle();
        String r105 = null;
        if (r104 == null) goto L5;
        String r106 = r104.enterId;
    L6:
        PoiBundle r107 = getAlbumParams().getPoiBundle();
        if (r107 == null) goto L9;
        String r108 = r107.enterMethod;
    L10:
        String r109 = getAlbumParams().getEnterFrom();
        PoiBundle r110 = getAlbumParams().getPoiBundle();
        if (r110 == null) goto L13;
        String r111 = r110.awemeid;
    L14:
        PoiBundle r112 = getAlbumParams().getPoiBundle();
        if (r112 == null) goto L17;
        String r113 = r112.forwardParams;
    L18:
        if (r113 != null) goto L37;
    L34:
        r105 = "";
    L35:
        r101.poiDetailCo(r102, r103, r106, r108, r109, r111, r105, 4, 2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        return;
    L37:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L22
        Object r115 = Result.m9449constructorimpl((HashMap) com.bytedance.locallife.common.utils.d.b().fromJson(r113, HashMap.class));     // Catch: Throwable -> L22
    L25:
        if (Result.m9455isFailureimpl(r115) == false) goto L27;
        r115 = null;
    L27:
        HashMap r116 = (HashMap) r115;
        if (r116 == null) goto L34;
        Object r117 = r116.get(LiveLocalLifeRoomInfo.SALE_CHANNEL);
        if ((r117 instanceof String) == false) goto L33;
        r105 = (String) r117;
    L33:
        if (r105 != null) goto L35;
    L22:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L17:
        r113 = null;
        goto L18
    L13:
        r111 = null;
        goto L14
    L9:
        r108 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }

    public final HashMap<String, AlbumPageInfo> getAlbumInfo() {
        return this.albumInfo;
    }

    public final MutableLiveData<String> getAlbumPageRequestStatus() {
        return this.albumPageRequestStatus;
    }

    public final MutableLiveData<AlbumPageStatus> getAlbumPageStatus() {
        return this.albumPageStatus;
    }

    public final PoiAlbumParams getAlbumParams() {
        return this.albumParams;
    }

    public final List<TabInfo> getAlbumTabList() {
        return this.albumTabList;
    }

    public final MutableLiveData<tv6.b> getBottomLynxInfoTrip() {
        return this.bottomLynxInfoTrip;
    }

    public final MutableLiveData<tv6.b> getCommonBottomLynxInfo() {
        return this.commonBottomLynxInfo;
    }

    public final String getCurrentAwemeId() {
        return this.currentAwemeId;
    }

    public final String getCurrentSelectTabId() {
        return this.currentSelectTabId;
    }

    public final MutableLiveData<String> getCurrentSelectTabLiveData() {
        return this.currentSelectTabLiveData;
    }

    public final int getCurrentTabIndex() {
        return this.currentTabIndex;
    }

    public final MutableLiveData<Boolean> getDeletePhotoStatus() {
        return this.deletePhotoStatus;
    }

    public final MutableLiveData<PhotoData> getErrorPicChange() {
        return this.errorPicChange;
    }

    public final List<PhotoData> getErrorPicList() {
        return this.errorPicList;
    }

    public final String getGalleryBottomLynx() {
        return this.galleryBottomLynx;
    }

    public final String getGalleryHeaderLynx() {
        return this.galleryHeaderLynx;
    }

    public final boolean getHasMobEnterAlbum() {
        return this.hasMobEnterAlbum;
    }

    public final boolean getHasVideoData() {
        return this.hasVideoData;
    }

    public final MutableLiveData<Boolean> getHideAlbumUploadButton() {
        return this.hideAlbumUploadButton;
    }

    public final int getMaxErrorNum() {
        return this.maxErrorNum;
    }

    public final HashMap<String, AlbumPageModel> getPageModels() {
        return this.pageModels;
    }

    public final String getPhotoReportSchema() {
        return this.photoReportSchema;
    }

    public final String getPoiEnterId() {
        return this.poiEnterId;
    }

    public final String getRequestFailMsg() {
        return this.requestFailMsg;
    }

    public final HashMap<String, RequestStatus> getRequestStatusMap() {
        return this.requestStatusMap;
    }

    public final MutableLiveData<List<n>> getRightMoreItems() {
        return this.rightMoreItems;
    }

    public final MutableLiveData<String> getSelectedVideoFilterTabId() {
        return this.selectedVideoFilterTabId;
    }

    public final MutableLiveData<List<TabInfo>> getTabInfo() {
        return this.tabInfo;
    }

    public final MutableLiveData<Boolean> getTabInfoReady() {
        return this.tabInfoReady;
    }

    public final MutableLiveData<RequestStatus> getTabRequestStatus() {
        return this.tabRequestStatus;
    }

    public final MutableLiveData<Integer> getTagHeightLiveData() {
        return this.tagHeightLiveData;
    }

    public final LiveData<List<TabInfo>> getVideoFilterTabInfo() {
        return this.videoFilterTabInfo;
    }

    public final List<String> getVideoInfo() {
        return this.videoInfo;
    }

    public final AlbumPageModel getVideoPageModel() {
        return this.videoPageModel;
    }

    public final MutableLiveData<Pair<String, RequestStatus>> getVideoPageRequestStatus() {
        return this.videoPageRequestStatus;
    }

    public final String getVideoRequestFailMsg() {
        return this.videoRequestFailMsg;
    }

    public final MutableLiveData<RequestStatus> getVideoRequestStatus() {
        return this.videoRequestStatus;
    }

    public final HashMap<String, Boolean> getVideoShowMob() {
        return this.videoShowMob;
    }

    public final int isHasTab() {
        return this.isHasTab;
    }

    public final void setAlbumInfo(HashMap<String, AlbumPageInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.albumInfo = r100;
    }

    public final void setAlbumPageStatus(MutableLiveData<AlbumPageStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.albumPageStatus = r100;
    }

    public final void setAlbumParams(PoiAlbumParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.albumParams = r100;
    }

    public final void setAlbumTabList(List<TabInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.albumTabList = r100;
    }

    public final void setBottomLynxInfoTrip(MutableLiveData<tv6.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bottomLynxInfoTrip = r100;
    }

    public final void setCommonBottomLynxInfo(MutableLiveData<tv6.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commonBottomLynxInfo = r100;
    }

    public final void setCurrentAwemeId(String r100) {
        this.currentAwemeId = r100;
    }

    public final void setCurrentSelectTabId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentSelectTabId = r100;
    }

    public final void setCurrentSelectTabLiveData(MutableLiveData<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentSelectTabLiveData = r100;
    }

    public final void setCurrentTabIndex(int r100) {
        this.currentTabIndex = r100;
    }

    public final void setDeletePhotoStatus(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deletePhotoStatus = r100;
    }

    public final void setErrorPicList(List<PhotoData> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorPicList = r100;
    }

    public final void setGalleryBottomLynx(String r100) {
        this.galleryBottomLynx = r100;
    }

    public final void setGalleryHeaderLynx(String r100) {
        this.galleryHeaderLynx = r100;
    }

    public final void setHasMobEnterAlbum(boolean r100) {
        this.hasMobEnterAlbum = r100;
    }

    public final void setHasTab(int r100) {
        this.isHasTab = r100;
    }

    public final void setHasVideoData(boolean r100) {
        this.hasVideoData = r100;
    }

    public final void setHideAlbumUploadButton(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hideAlbumUploadButton = r100;
    }

    public final void setMaxErrorNum(int r100) {
        this.maxErrorNum = r100;
    }

    public final void setPhotoReportSchema(String r100) {
        this.photoReportSchema = r100;
    }

    public final void setPoiEnterId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.poiEnterId = r100;
    }

    public final void setRequestFailMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestFailMsg = r100;
    }

    public final void setRightMoreItems(MutableLiveData<List<n>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rightMoreItems = r100;
    }

    public final void setTabInfo(MutableLiveData<List<TabInfo>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabInfo = r100;
    }

    public final void setTabInfoReady(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabInfoReady = r100;
    }

    public final void setVideoInfo(List<String> r100) {
        this.videoInfo = r100;
    }

    public final void setVideoRequestFailMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoRequestFailMsg = r100;
    }

    public final void initVideoFilterTabsOnce(List<TabInfo> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tabs");
        List<TabInfo> r102 = this._videoFilterTabInfo.getValue();
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        if (r103 == false) goto L10;
        return;
    L10:
        if (r100.isEmpty() == false) goto L12;
        return;
    L12:
        List<TabInfo> r104 = CollectionsKt.toMutableList(r100);
        StringBuilder r105 = new StringBuilder("initVideoFilterTabsOnce = ");
        List<TabInfo> r106 = r104;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = r106.iterator();
    L14:
        if (r108.hasNext() == false) goto L16;
        r107.add(((TabInfo) r108.next()).getTabName());
        goto L14
    L16:
        r105.append(r107);
        com.bytedance.locallife.biz.common.utils.c.a("AlbumViewModel", r105.toString());
        this._videoFilterTabInfo.setValue(r104);
        if (r101 == null) goto L21;
        this.selectedVideoFilterTabId.setValue(r101);
        return;
    L21:
        return;
    L5:
        if ((!r102.isEmpty()) != true) goto L7;
        r103 = true;
        goto L7
    }

    public final void requestAlbumPage(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "tabId");
        if (this.pageModels.get(r110) != null) goto L5;
        this.pageModels.put(r110, new AlbumPageModel());
    L5:
        AlbumPageModel r100 = this.pageModels.get(r110);
        if (r100 == null) goto L23;
        HashMap<String, AlbumPageInfo> r101 = this.albumInfo;
        Intrinsics.checkNotNullParameter(r110, "tabId");
        Intrinsics.checkNotNullParameter(r101, "albumInfo");
        Intrinsics.checkNotNullParameter(this, "viewModel");
        if (r100.f261964a == true) goto L24;
        r100.f261964a = true;
        getAlbumParams().getPoiId();
        AlbumPageInfo r102 = r101.get(r110);
        if (r102 == null) goto L15;
        Integer r103 = r102.getNextOffset();
        if (r103 == null) goto L15;
        r103.intValue();
    L15:
        getAlbumParams().getPoiBackendType();
        AlbumApi r104 = (AlbumApi) r100.f261965b.getValue();
        String r105 = getAlbumParams().getPoiId();
        AlbumPageInfo r106 = r101.get(r110);
        if (r106 == null) goto L20;
        Integer r107 = r106.getNextOffset();
        if (r107 == null) goto L20;
        int r112 = r107.intValue();
    L21:
        r104.albumMiddlePage(20, r105, r110, r112, getAlbumParams().getPoiBackendType(), 0, "").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r110, r100, r111, r101, this), new e(r110, this, r100));
        return;
    L20:
        r112 = 1;
        goto L21
    L24:
        return;
    }

    public final void requestVideoPage(String r100, int r101, boolean r102) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        requestVideoPage(r100, "", r101, r102, false);
    }

    public static /* synthetic */ void initVideoFilterTabsOnce$default(AlbumViewModel r100, List r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.initVideoFilterTabsOnce(r101, r102);
    }

    public final void requestVideoPage(String r100, String r101, int r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "tabId");
        Intrinsics.checkNotNullParameter(r101, "topItemId");
        com.bytedance.locallife.biz.common.utils.c.a("AlbumViewModel", "requestVideoPage tabId = " + r100 + ", updateTabInfo = " + r104);
        this.videoPageModel.getClass();
        Intrinsics.checkNotNullParameter(r100, "tabId");
        Intrinsics.checkNotNullParameter(r101, "topItemId");
        Intrinsics.checkNotNullParameter(this, "viewModel");
    }

    public static /* synthetic */ void requestVideoPage$default(AlbumViewModel r100, String r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.requestVideoPage(r101, r102, r103);
    }

    public static /* synthetic */ void requestVideoPage$default(AlbumViewModel r100, String r101, String r102, int r103, boolean r110, boolean r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r104 = false;
    L6:
        r100.requestVideoPage(r101, r102, r103, r110, r104);
        return;
    L5:
        r104 = r111;
        goto L6
    }
}
