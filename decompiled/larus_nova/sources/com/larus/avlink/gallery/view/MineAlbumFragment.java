package com.larus.avlink.gallery.view;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.api.DoraGResourceServiceDelegate;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.executor.MediaSyncExecutor;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.share.AlbumDeleteDialog;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment;
import com.larus.avlink.gallery.viewmodel.GalleryViewModel;
import com.larus.avlink.impl.databinding.LarusFragmentMineAlbumListBinding;
import com.larus.avlink.impl.databinding.LarusPageAlbumListEmptyBinding;
import com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusAccountDialogBinding;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.larus.voice_setting.voice.base.ProfileInfoBaseFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import v19.i5;
import v19.m5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002+.\b\u0007\u0018\u0000 \u008e\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\b\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u0002012\u0006\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u000201H\u0016J\b\u00108\u001a\u000201H\u0016J\b\u00109\u001a\u000201H\u0002J&\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010B\u001a\u0002012\u0006\u0010C\u001a\u00020;2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010D\u001a\u000201H\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u000201H\u0002J\u001c\u0010H\u001a\u0002012\f\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JH\u0082@¢\u0006\u0002\u0010LJ\u0014\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010NH\u0002J\u0016\u0010P\u001a\u0002012\u0006\u0010O\u001a\u00020NH\u0082@¢\u0006\u0002\u0010QJ\u0018\u0010R\u001a\u0002012\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u000201H\u0002J\b\u0010X\u001a\u00020\u0018H\u0002J\b\u0010Y\u001a\u000201H\u0002J\b\u0010Z\u001a\u000201H\u0002J\b\u0010[\u001a\u000201H\u0016J\b\u0010\\\u001a\u000201H\u0002J\u0010\u0010]\u001a\u0002012\u0006\u0010^\u001a\u00020_H\u0002J\u0018\u0010`\u001a\u0002012\u0006\u0010^\u001a\u00020_2\u0006\u0010a\u001a\u00020_H\u0002J\u0016\u0010b\u001a\u0002012\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\n0JH\u0016J\b\u0010d\u001a\u000201H\u0002J\b\u0010e\u001a\u000201H\u0002J\b\u0010f\u001a\u000201H\u0002J\b\u0010g\u001a\u000201H\u0002J\b\u0010h\u001a\u000201H\u0002J&\u0010i\u001a\u0002012\u001c\b\u0002\u0010j\u001a\u0016\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u000201\u0018\u00010kH\u0002J\b\u0010l\u001a\u000201H\u0016J&\u0010m\u001a\u0002012\u001c\b\u0002\u0010j\u001a\u0016\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u000201\u0018\u00010kH\u0002J\b\u0010n\u001a\u000201H\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010o\u001a\u000201H\u0016J!\u0010p\u001a\u0002012\b\u0010q\u001a\u0004\u0018\u00010_2\b\u0010r\u001a\u0004\u0018\u00010_H\u0016¢\u0006\u0002\u0010sJ\b\u0010t\u001a\u000201H\u0016J\b\u0010u\u001a\u000201H\u0016J\u0010\u0010v\u001a\u0002012\u0006\u0010w\u001a\u00020_H\u0016J\b\u0010x\u001a\u000201H\u0016J\u0010\u0010y\u001a\u0002012\u0006\u0010z\u001a\u00020\nH\u0016J\b\u0010{\u001a\u000201H\u0016J\b\u0010|\u001a\u000201H\u0016J\b\u0010}\u001a\u000201H\u0016J\b\u0010~\u001a\u000201H\u0016J\u0013\u0010\u007f\u001a\u0002012\t\u00103\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\t\u0010\u0081\u0001\u001a\u000201H\u0016J\t\u0010\u0082\u0001\u001a\u000201H\u0016J\t\u0010\u0083\u0001\u001a\u000201H\u0016J\t\u0010\u0084\u0001\u001a\u000201H\u0016J!\u0010\u0085\u0001\u001a\u0002012\u0016\u0010\u0086\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u000201\u0018\u00010\u0087\u0001H\u0016J\u0012\u0010\u0088\u0001\u001a\u0002012\u0007\u0010\u0089\u0001\u001a\u00020_H\u0016J\u001b\u0010\u008a\u0001\u001a\u0002012\u0007\u0010\u008b\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\nH\u0016J\t\u0010\u008d\u0001\u001a\u000201H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006\u0092\u0001"}, d2 = {"Lcom/larus/avlink/gallery/view/MineAlbumFragment;", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "Lcom/larus/platform/api/IMineAlbumFragment;", "Lcom/larus/avlink/api/AlbumItemDeleteListener;", "Lcom/larus/avlink/gallery/view/AlbumSyncBanner$SyncActionHandler;", "Lcom/larus/avlink/gallery/service/MediaSyncStateListener;", "Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailListener;", "<init>", "()V", "tag", "", "binding", "Lcom/larus/avlink/impl/databinding/LarusFragmentMineAlbumListBinding;", "sharePop", "Landroid/widget/PopupWindow;", "listAdapter", "Lcom/larus/avlink/gallery/view/AlbumListAdapter;", "swipeMultiSelectHelper", "Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper;", "selectedPaths", "", "swipeSelectionState", "Lcom/larus/avlink/gallery/view/MineAlbumFragment$SwipeSelectionState;", "forceAddOnNextSwipeSelection", "", "isSelectMode", "syncBanner", "Lcom/larus/avlink/gallery/view/AlbumSyncBanner;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/avlink/gallery/viewmodel/GalleryViewModel;", "shouldAutoStartSync", "currentPhotoViewerDialog", "Lcom/larus/bmhome/bigimg/BigImageLocalPhotoViewerDialog;", "photoViewerUpdateCallback", "Lcom/larus/avlink/gallery/view/MineAlbumFragment$PhotoViewerUpdateCallback;", "runOnceRecover", "isDoraMediaAlbum", "checkJob", "Lkotlinx/coroutines/Job;", "sharePanelLayoutController", "Lcom/larus/avlink/gallery/share/AlbumSharePanelLayoutController;", "skipNextOnResumeCheck", "doralink", "com/larus/avlink/gallery/view/MineAlbumFragment$doralink$1", "Lcom/larus/avlink/gallery/view/MineAlbumFragment$doralink$1;", "albumListCallback", "com/larus/avlink/gallery/view/MineAlbumFragment$albumListCallback$1", "Lcom/larus/avlink/gallery/view/MineAlbumFragment$albumListCallback$1;", "uploadFeedback", "", "onStateChange", "state", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onPause", "onResume", "exitSelectMode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "checkStartSync", "enterPageTrace", "startFileMigration", "initViewModel", "checkAndSyncUnsynchronizedMedia", "mediaList", "", "Lcom/larus/bmhome/bigimg/MediaItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValidMetadata", "Lcom/larus/avlink/gallery/model/MediaMetadata;", "metadata", "syncMediaToAlbum", "(Lcom/larus/avlink/gallery/model/MediaMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFileExifDateTime", "file", "Ljava/io/File;", "timestamp", "", "showEmptyView", "isSaveToGalleryEnabled", "showSharePanel", "updateSharePopupTitle", "onDestroyView", "setupSwipeMultiSelection", "beginSwipeSelection", "anchorPosition", "", "applySwipeSelection", "currentPosition", "onDelete", "map", "initView", "loadData", "setupInjectEntry", "refreshInjectEntry", "updateCalendarIndicator", "checkAndUpdateUI", "onDiff", "Lkotlin/Function2;", "showMediaDiff", "showDiffInternal", "showPermissionGuide", "onDefaultLanding", "onStartWifiRequested", "photoCnt", "videoCnt", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "onWifiConnecting", "onTransferStarted", "onProgressUpdated", "progress", "onTransferCompleted", LynxVideoManagerLite.EVENT_ON_ERROR, "error", "onNoData", "onLowPower", "onRecording", "onNoSpace", "updateSyncBannerState", "Lcom/larus/avlink/model/BannerEvent;", "onSyncClicked", "openThumbDetailPage", "onWifiSettingRequested", "onTransferComplete", "onRequestPermission", "callback", "Lkotlin/Function1;", "onRecoveryStarted", "fileCount", "onRecoveryFailed", "mediaId", "reason", "onRecoveryCompleted", "Companion", "PhotoViewerUpdateCallback", "SwipeSelectionState", "SwipeSelectionMode", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MineAlbumFragment extends ProfileInfoBaseFragment implements com.larus.platform.api.x0, w88.a, AlbumSyncBanner.b, u98.a, com.larus.avlink.gallery.thumbnail.h0 {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public final f B;
    public final e C;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f292900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LarusFragmentMineAlbumListBinding f292901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PopupWindow f292902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AlbumListAdapter f292903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerViewSwipeMultiSelectHelper f292904n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Set<String> f292905o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f292906p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f292907q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f292908r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AlbumSyncBanner f292909s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public GalleryViewModel f292910t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f292911u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public BigImageLocalPhotoViewerDialog f292912v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public b f292913w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f292914x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Job f292915y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public v98.d f292916z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/gallery/view/MineAlbumFragment$SwipeSelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "REMOVE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SwipeSelectionMode extends Enum<SwipeSelectionMode> {
        public static final SwipeSelectionMode ADD = null;
        public static final SwipeSelectionMode REMOVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SwipeSelectionMode[] f292917a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f292918b = null;

        public static EnumEntries<SwipeSelectionMode> getEntries() {
            return f292918b;
        }

        static {
            SwipeSelectionMode r100 = new SwipeSelectionMode("ADD", 0);
            ADD = r100;
            SwipeSelectionMode r101 = new SwipeSelectionMode("REMOVE", 1);
            REMOVE = r101;
            SwipeSelectionMode[] r102 = {r100, r101};
            f292917a = r102;
            f292918b = EnumEntriesKt.enumEntries(r102);
        }

        public static SwipeSelectionMode[] values() {
            return (SwipeSelectionMode[]) f292917a.clone();
        }

        public static SwipeSelectionMode valueOf(String r100) {
            return (SwipeSelectionMode) r27.a.a(SwipeSelectionMode.class, r100);
        }

        public SwipeSelectionMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(String r100, String r101, com.larus.bmhome.bigimg.t1 r102);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f292919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f292920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SwipeSelectionMode f292921c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f292919a == r101.f292919a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f292920b, r101.f292920b) == true) goto L15;
            return false;
        L15:
            if (this.f292921c == r101.f292921c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f292919a * 31) + this.f292920b.hashCode()) * 31) + this.f292921c.hashCode();
        }

        public final String toString() {
            return "SwipeSelectionState(anchorPosition=" + this.f292919a + ", initialSelectedPaths=" + this.f292920b + ", mode=" + this.f292921c + ')';
        }

        public c(int r100, Set<String> r101, SwipeSelectionMode r102) {
            Intrinsics.checkNotNullParameter(r101, "initialSelectedPaths");
            Intrinsics.checkNotNullParameter(r102, "mode");
            this.f292919a = r100;
            this.f292920b = r101;
            this.f292921c = r102;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f292922a = null;

        static {
            int[] r100 = new int[SwipeSelectionMode.values().length];
            r100[SwipeSelectionMode.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SwipeSelectionMode.REMOVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f292922a = r100;
        }
    }

    public static final class e implements com.larus.avlink.gallery.view.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MineAlbumFragment f292923a;

        public static final class a implements com.larus.bmhome.bigimg.l1 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MineAlbumFragment f292924a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f292925b;

            public a(MineAlbumFragment r100, Context r101) {
                this.f292924a = r100;
                this.f292925b = r101;
            }

            @Override // com.larus.bmhome.bigimg.l1
            public final void a(Function0<Unit> r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "confirmCallback");
                Intrinsics.checkNotNullParameter(r101, "path");
                GalleryViewModel r102 = this.f292924a.f292910t;
                if (r102 == null) goto L6;
                r102.deleteSingleFile(this.f292925b, StringsKt.removePrefix(r101, MSkiaImageRegionDecoder.FILE_PREFIX), r100);
                return;
            }
        }

        public static final class b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MineAlbumFragment f292926a;

            public b(MineAlbumFragment r100) {
                this.f292926a = r100;
            }

            @Override // com.larus.avlink.gallery.view.MineAlbumFragment.b
            public final void a(String r100, String r101, com.larus.bmhome.bigimg.t1 r102) {
                Intrinsics.checkNotNullParameter(r100, "mediaId");
                Intrinsics.checkNotNullParameter(r101, "newPath");
                BigImageLocalPhotoViewerDialog r103 = this.f292926a.f292912v;
                if (r103 == null) goto L6;
                r103.m(r100, r101, r102);
                return;
            }
        }

        public e(MineAlbumFragment r100) {
            this.f292923a = r100;
        }

        /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.avlink.gallery.view.p1] */
        public final void c(Context r110, int r111) {
            AlbumListAdapter r100 = this.f292923a.f292903m;
            if (r100 == null) goto L5;
            List<com.larus.bmhome.bigimg.t1> r101 = r100.getCurrentList();
        L6:
            if (r101 != null) goto L8;
            return;
        L8:
            List<com.larus.bmhome.bigimg.t1> r102 = r101;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L9:
            int r105 = 0;
            if (r104.hasNext() == false) goto L12;
            com.larus.bmhome.bigimg.t1 r106 = (com.larus.bmhome.bigimg.t1) r104.next();
            r103.add(com.larus.bmhome.bigimg.t1.a.a(r106, MSkiaImageRegionDecoder.FILE_PREFIX + r106.getPath(), false, false, 1021));
            goto L9
        L12:
            ArrayList r107 = new ArrayList();
            LarusFragmentMineAlbumListBinding r108 = this.f292923a.f292901k;
            if (r108 == null) goto L17;
            RecyclerView r109 = r108.f293217d;
            if (r109 == null) goto L17;
            RecyclerView.LayoutManager r112 = r109.getLayoutManager();
        L18:
            if (r112 == null) goto L27;
            int r113 = r112.getChildCount();
        L20:
            if (r105 >= r113) goto L27;
            View r114 = r112.getChildAt(r105);
            if (r114 == null) goto L26;
            int r115 = r112.getPosition(r114);
            ImageViewWithLastMotion r116 = (ImageViewWithLastMotion) r114.findViewById(R.id.image);
            if (r116 == null) goto L26;
            r107.add(new Pair(Integer.valueOf(r115), r116));
        L26:
            r105 = r105 + 1;
        L27:
            MineAlbumFragment r117 = this.f292923a;
            List r118 = CollectionsKt.toList(r103);
            uo8.k r119 = new uo8.k(MapsKt.emptyMap(), null);
            final MineAlbumFragment r120 = this.f292923a;
            r117.f292912v = com.larus.bmhome.bigimg.k.d(r110, r107, r118, r111, r119, new a(r120, r110), new p1(r120), 32);
            MineAlbumFragment r121 = this.f292923a;
            r121.f292913w = new b(r121);
            return;
        L17:
            r112 = null;
            goto L18
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.larus.avlink.gallery.view.f
        public final void a(com.larus.bmhome.bigimg.t1 r100, int r101, View r102) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, BaseSwitches.V);
            MineAlbumFragment r103 = this.f292923a;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
            Context r105 = r103.getContext();     // Catch: Throwable -> L17
            if (r105 != null) goto L7;
        L15:
            Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L19:
            Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
            if (r107 == null) goto L25;
            FLogger.f375446a.e("MineAlbumFragment", "Error occurred.", r107);
            return;
        L25:
            return;
        L7:
            if (r103.f292908r == true) goto L9;
            c(r105, r101);     // Catch: Throwable -> L17
            goto L15
        L9:
            if (r100.d() == false) goto L11;
            return;
        L11:
            GalleryViewModel r108 = r103.f292910t;     // Catch: Throwable -> L17
            if (r108 == null) goto L15;
            r108.toggleItemSelection(r100);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L19
        }

        @Override // com.larus.avlink.gallery.view.f
        public final void b(com.larus.bmhome.bigimg.t1 r100, int r101, View r110, float r111, float r112) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r110, BaseSwitches.V);
            if (AppHost.f326268a.isTestChannel() == false) goto L6;
            t19.s.j(t19.s.f544207a, r110.getContext(), "Current item: " + r100.g() + ", " + r100.getName(), null, false, 28);
        L6:
            if (r100.d() == false) goto L8;
            return;
        L8:
            MineAlbumFragment r102 = this.f292923a;
            if (r102.f292908r == true) goto L12;
            if (r101 == (-1)) goto L12;
            boolean r103 = true;
        L13:
            r102.f292907q = r103;
            GalleryViewModel r104 = r102.f292910t;
            if (r104 == null) goto L16;
            r104.handleLongClick(r100);
        L16:
            if (r103 == true) goto L18;
            return;
        L18:
            RecyclerViewSwipeMultiSelectHelper r105 = this.f292923a.f292904n;
            if (r105 == null) goto L25;
            float r106 = r110.getLeft() + r111;
            float r113 = r110.getTop() + r112;
            if (r101 == (-1)) goto L26;
            r105.b();
            r105.a();
            r105.f292943m = r101;
            r105.f292944n = r101;
            r105.f292945o = r106;
            r105.f292946p = r113;
            r105.f292947q = r106;
            r105.f292948r = r113;
            r105.f292950t = true;
            return;
        L26:
            return;
        L25:
            return;
        L12:
            r103 = false;
            goto L13
        }
    }

    public static final class f implements t39.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MineAlbumFragment f292927a;

        public f(MineAlbumFragment r100) {
            this.f292927a = r100;
        }

        @Override // t39.n
        public final void e(int r100, int r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, "productName");
            FLogger.f375446a.i("MineAlbumFragment", "onDoraLinkChanged: state=" + r100);
            if (r100 == (-1)) goto L9;
            if (r100 == 0) goto L9;
            if (r100 != 2) goto L15;
            MineAlbumFragment r104 = this.f292927a;
            int r105 = MineAlbumFragment.D;
            r104.ba0(null);
            return;
        L15:
            return;
        L9:
            AlbumSyncBanner r106 = this.f292927a.f292909s;
            if (r106 == null) goto L14;
            r106.T5(z98.a.d.f571029b);
            return;
        }
    }

    public static final class g implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f292928a;

        public g(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f292928a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f292928a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f292928a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.MineAlbumFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment$onViewCreated$2", f = "MineAlbumFragment.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            GalleryStoragePolicyManager r103 = GalleryStoragePolicyManager.f292721a;
            this.label = 1;
            r103.getClass();
            if (GalleryStoragePolicyManager.j(this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    @Override // u98.a
    public final void A10() {
        FLogger.f375446a.i("MineAlbumFragment", "Hardware media sync: No new data");
        N30();
        Context r100 = getContext();
        if (r100 == null) goto L8;
        String r101 = r100.getString(R.string.larus_dora_album_storage_full_cn);
        if (r101 == null) goto L9;
        t19.s.j(t19.s.f544207a, getContext(), r101, null, false, 28);
        return;
    L9:
        return;
    }

    @Override // u98.a
    public final void Ff() {
        FLogger.f375446a.i("MineAlbumFragment", "Hardware media sync: No new data");
    }

    @Override // u98.a
    public final void Mv() {
        FLogger.f375446a.d("MineAlbumFragment", "Hardware media load: Transfer started");
        AlbumSyncBanner r100 = this.f292909s;
        if (r100 == null) goto L6;
        r100.T5(z98.a.j.f571036b);
        return;
    }

    @Override // u98.a
    public final void Po() {
        FLogger.f375446a.i("MineAlbumFragment", "Hardware media load: Transfer completed");
        AlbumSyncBanner r100 = this.f292909s;
        if (r100 == null) goto L5;
        r100.T5(z98.a.i.f571035b);
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MineAlbumFragment$onTransferCompleted$1(this, null), 3, null);
    }

    @Override // u98.a
    public final void QR() {
        GalleryViewModel r100 = this.f292910t;
        if (r100 == null) goto L6;
        r100.onRecoveryCompleted();
        return;
    }

    @Override // u98.a
    public final void V00() {
        FLogger.f375446a.i("MineAlbumFragment", "Hardware media sync: Low power");
        AlbumSyncBanner r100 = this.f292909s;
        if (r100 == null) goto L6;
        r100.T5(z98.a.e.f571030b);
        return;
    }

    @Override // u98.a
    public final void WQ() {
        FLogger.f375446a.i("MineAlbumFragment", "Hardware media sync: Recording");
        AlbumSyncBanner r100 = this.f292909s;
        if (r100 == null) goto L6;
        r100.T5(z98.a.g.f571032b);
        return;
    }

    @Override // com.larus.avlink.gallery.thumbnail.h0
    public final void ZA() {
        com.larus.avlink.gallery.l.a r100 = com.larus.avlink.gallery.l.f292610a.get();
        if (r100 == null) goto L6;
        FLogger.f375446a.i("MineAlbumFragment", "Found pending sync request from GalleryThumbnailFragment: photos=" + r100.f292612a + ", videos=" + r100.f292613b);
        da0(Integer.valueOf(r100.f292612a), Integer.valueOf(r100.f292613b));
        return;
    }

    public final void ca0() {
        if (this.f292911u == false) goto L5;
        this.f292911u = false;
        FLogger.f375446a.i("MineAlbumFragment", "onResume: shouldAutoStartSync = true, check and auto start sync");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MineAlbumFragment$checkStartSync$1(this, null), 2, null);
        return;
    L5:
        FLogger.f375446a.i("MineAlbumFragment", "onResume: shouldAutoStartSync = false, normal check and update UI");
        ba0(null);
    }

    public final void ea0() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(Keva.getRepo("dora_kv_env", 0).getBoolean("key_dataset_inject_enabled", false)));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = r102;
    L9:
        boolean r103 = ((Boolean) r101).booleanValue();
        LarusFragmentMineAlbumListBinding r104 = this.f292901k;
        if (r104 == null) goto L19;
        AppCompatTextView r105 = r104.f293216c;
        if (r105 == null) goto L20;
        if (r103 == false) goto L15;
        com.larus.utils.e1.x(r105);
        return;
    L15:
        com.larus.utils.e1.o(r105);
        return;
    L20:
        return;
    L19:
        return;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final RecyclerView getRecyclerView() {
        LarusFragmentMineAlbumListBinding r100 = this.f292901k;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f293217d;
    }

    public final void ha0() {
        AlbumSyncBanner r100 = this.f292909s;
        if (r100 == null) goto L5;
        r100.T5(z98.a.f.f571031b);
    L5:
        LarusFragmentMineAlbumListBinding r101 = this.f292901k;
        ViewGroup.MarginLayoutParams r102 = null;
        if (r101 == null) goto L10;
        RecyclerView r103 = r101.f293217d;
        if (r103 == null) goto L10;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L12:
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        r102 = (ViewGroup.MarginLayoutParams) r104;
    L14:
        if (r102 == null) goto L17;
        r102.topMargin = 0;
        return;
    L17:
        return;
    L10:
        r104 = null;
        goto L12
    }

    @Override // com.larus.avlink.gallery.view.AlbumSyncBanner.b
    public final void ib() {
        GalleryThumbnailFragment r100 = new GalleryThumbnailFragment();
        Intrinsics.checkNotNullParameter(this, "listener");
        r100.f292745r = this;
        FragmentManager r101 = getChildFragmentManager();
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "AlbumBottomSheetDialog", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, "AlbumBottomSheetDialog");
        return;
    }

    public final void ja0() {
        PopupWindow r100 = this.f292902l;
        if (r100 == null) goto L40;
        GalleryViewModel r101 = this.f292910t;
        if (r101 == null) goto L7;
        int r102 = r101.getSelectedCount();
    L8:
        GalleryViewModel r103 = this.f292910t;
        if (r103 == null) goto L13;
        LiveData<Boolean> r104 = r103.getHasSelectAll();
        if (r104 == null) goto L13;
        boolean r105 = Intrinsics.areEqual(r104.getValue(), Boolean.TRUE);
    L14:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        View r106 = r100.getContentView();
        TextView r107 = null;
        if (r106 == null) goto L17;
        FrameLayout r108 = (FrameLayout) r106.findViewById(R.id.album_share_container);
    L18:
        View r109 = r100.getContentView();
        if (r109 == null) goto L21;
        r107 = (TextView) r109.findViewById(R.id.album_share_title);
    L21:
        if (r102 != 0) goto L26;
        if (r108 == null) goto L24;
        r108.setAlpha(0.3f);
    L24:
        if (r107 == null) goto L31;
        r107.setText(AppHost.f326268a.getApplication().getString(R.string.larus_dora_device_select_picture_cn));
    L31:
        View r110 = r100.getContentView();
        if (r110 == null) goto L41;
        TextView r111 = (TextView) r110.findViewById(R.id.album_select_title);
        if (r111 == null) goto L42;
        if (r105 == true) goto L37;
        String r112 = AppHost.f326268a.getApplication().getString(R.string.larus_dora_album_select_all_cn);
    L38:
        r111.setText(r112);
        return;
    L37:
        r112 = AppHost.f326268a.getApplication().getString(R.string.larus_dora_album_deselect_all_cn);
        goto L38
    L42:
        return;
    L41:
        return;
    L26:
        if (r102 <= 0) goto L31;
        if (r108 == null) goto L29;
        r108.setAlpha(1.0f);
    L29:
        if (r107 == null) goto L31;
        r107.setText(AppHost.f326268a.getApplication().getString(R.string.larus_dora_album_share_select_title, new Object[]{Integer.valueOf(r102)}));
        goto L31
    L17:
        r108 = null;
    L13:
        r105 = false;
        goto L14
    L7:
        r102 = 0;
        goto L8
    }

    @Override // com.larus.platform.api.x0
    public final void k00() {
        FLogger.f375446a.i("MineAlbumFragment", "onDefaultLanding, isResumed=" + isResumed());
        this.f292911u = true;
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        PopupWindow r100 = this.f292902l;
        if (r100 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L5:
        super.onPause();
        GalleryViewModel r101 = this.f292910t;
        if (r101 == null) goto L8;
        r101.exitSelectMode();
    L8:
        this.A = false;
    }

    public final void showEmptyView() {
        LarusFragmentMineAlbumListBinding r100 = this.f292901k;
        if (r100 == null) goto L9;
        LarusPageAlbumListEmptyBinding r101 = r100.f293215b;
        if (r101 == null) goto L9;
        AppCompatImageView r102 = r101.f293260b;
        if (r102 == null) goto L9;
        r102.setImageResource(DoraGResourceServiceDelegate.f291642b.h());
    L9:
        IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r104 = false;
        if (r103 == null) goto L16;
        VisionService r105 = r103.V();
        if (r105 == null) goto L16;
        if (r105.q() != true) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L21;
        String r107 = ia8.b.f488929a;
        if (ia8.b.a(AppHost.f326268a.getApplication()) == true) goto L21;
        r104 = true;
    L21:
        if (r104 == true) goto L29;
        LarusFragmentMineAlbumListBinding r108 = this.f292901k;
        if (r108 == null) goto L36;
        LarusPageAlbumListEmptyBinding r109 = r108.f293215b;
        if (r109 == null) goto L36;
        AppCompatTextView r110 = r109.f293261c;
        if (r110 == null) goto L36;
        int r111 = com.larus.utils.j0.f375426a;
        r110.setText(com.larus.utils.j0.d(R.string.larus_dora_album_empty_cn));
    L36:
        LarusFragmentMineAlbumListBinding r112 = this.f292901k;
        if (r112 == null) goto L44;
        LarusPageAlbumListEmptyBinding r113 = r112.f293215b;
        if (r113 == null) goto L45;
        ConstraintLayout r114 = r113.f293259a;
        if (r114 == null) goto L46;
        com.larus.utils.e1.x(r114);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L29:
        LarusFragmentMineAlbumListBinding r115 = this.f292901k;
        if (r115 == null) goto L36;
        LarusPageAlbumListEmptyBinding r116 = r115.f293215b;
        if (r116 == null) goto L36;
        AppCompatTextView r117 = r116.f293261c;
        if (r117 == null) goto L36;
        int r118 = com.larus.utils.j0.f375426a;
        r117.setText(com.larus.utils.j0.d(R.string.larus_dora_album_system_album_authorization_cn));
    L16:
        r106 = false;
        goto L17
    }

    public MineAlbumFragment() {
        this.f292900j = "MineAlbumFragment" + hashCode();
        this.f292905o = new LinkedHashSet();
        this.A = true;
        this.B = new f(this);
        this.C = new e(this);
    }

    @Override // u98.a
    public final void N30() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getMain().getImmediate(), null, new MineAlbumFragment$showMediaDiff$1(this, null), 2, null);
    }

    @Override // com.larus.avlink.gallery.view.AlbumSyncBanner.b
    public final void TF() {
        Context r100 = getContext();
        if (r100 == null) goto L36;
        int r101 = ja8.g.f497957a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = false;
        Intent r103 = new Intent("android.settings.WIFI_SETTINGS");     // Catch: Exception -> L7
        r103.setFlags(268435456);     // Catch: Exception -> L7
        r100.startActivity(r103);     // Catch: Exception -> L7
        boolean r104 = true;
    L9:
        if (r104 == false) goto L32;
        FLogger.f375446a.i("WiFiSettingsUtil", "Successfully opened WiFi settings directly");     // Catch: Exception -> L27
        return;
    L32:
        Intent r105 = new Intent("android.settings.WIRELESS_SETTINGS");     // Catch: Exception -> L14
        r105.setFlags(268435456);     // Catch: Exception -> L14
        r100.startActivity(r105);     // Catch: Exception -> L14
        boolean r106 = true;
    L16:
        if (r106 == false) goto L30;
        FLogger.f375446a.i("WiFiSettingsUtil", "Successfully opened wireless settings");     // Catch: Exception -> L27
        return;
    L30:
        Intent r107 = new Intent("android.settings.SETTINGS");     // Catch: Exception -> L21
        r107.setFlags(268435456);     // Catch: Exception -> L21
        r100.startActivity(r107);     // Catch: Exception -> L21
        r102 = true;
    L23:
        if (r102 == false) goto L25;
        FLogger.f375446a.i("WiFiSettingsUtil", "Successfully opened general settings as fallback");     // Catch: Exception -> L27
        return;
    L25:
        FLogger.f375446a.e("WiFiSettingsUtil", "Failed to open any settings page");     // Catch: Exception -> L27
        return;
    L21:
        e = move-exception;
        FLogger.f375446a.w("WiFiSettingsUtil", "Failed to open general settings: " + e.getMessage());     // Catch: Exception -> L27
        goto L23
    L14:
        e = move-exception;
        FLogger.f375446a.w("WiFiSettingsUtil", "Failed to open wireless settings: " + e.getMessage());     // Catch: Exception -> L27
        r106 = false;
        goto L16
    L7:
        e = move-exception;
        FLogger.f375446a.w("WiFiSettingsUtil", "Failed to open WiFi settings directly: " + e.getMessage());     // Catch: Exception -> L27
        r104 = false;
    L27:
        e = move-exception;
        FLogger.f375446a.e("WiFiSettingsUtil", "Exception when opening WiFi settings: " + e.getMessage());
        return;
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ActivityResultCaller r100 = getParentFragment();
        if ((r100 instanceof com.larus.voice_setting.voice.base.a) == false) goto L5;
        com.larus.voice_setting.voice.base.a r101 = (com.larus.voice_setting.voice.base.a) r100;
    L7:
        if (r101 == null) goto L9;
        r101.n40(true);
    L9:
        PopupWindow r102 = this.f292902l;
        if (r102 == null) goto L12;
        PopupWindowLancet.handleDismissBeforeOrigin(r102);
        r102.dismiss();
    L12:
        v98.d r103 = this.f292916z;
        if (r103 == null) goto L15;
        r103.f553821d = null;
        r103.a(0);
    L15:
        super.onDestroyView();
        RecyclerViewSwipeMultiSelectHelper r104 = this.f292904n;
        if (r104 == null) goto L18;
        r104.b();
        r104.f292931a.removeOnItemTouchListener(r104);
        r104.a();
    L18:
        this.f292904n = null;
        this.f292916z = null;
        this.f292906p = null;
        Job r105 = this.f292915y;
        if (r105 == null) goto L21;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L21:
        this.f292915y = null;
        MediaSyncExecutor.f292561i = null;
        FLogger.f375446a.d("MediaSyncExecutor", "Removed delete listener");
        IDoraService r106 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r106 == null) goto L24;
        r106.q0(this.B);
    L24:
        MediaSyncCoordinator r107 = MediaSyncCoordinator.f292370a;
        MediaSyncCoordinator.x(this);
        GalleryViewModel r108 = this.f292910t;
        if (r108 == null) goto L28;
        r108.unregisterMediaLifecycleListener();
        return;
    L28:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        GalleryViewModel r100 = this.f292910t;
        if (r100 == null) goto L5;
        String r101 = ia8.b.f488929a;
        r100.updatePermissionState(ia8.b.a(getContext()));
    L5:
        GalleryViewModel r102 = this.f292910t;
        if (r102 == null) goto L9;
        r102.loadLocalMedia();
    L9:
        if (this.A == true) goto L11;
        ca0();
    L11:
        MediaSyncExecutor r103 = MediaSyncExecutor.f292553a;
        MediaSyncExecutor.c(null);
        ea0();
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final String tag() {
        return this.f292900j;
    }

    @Override // u98.a
    public final void RK(int r100) {
        FLogger.f375446a.d("MineAlbumFragment", "Hardware media load: Progress " + r100 + '%');
        AlbumSyncBanner r101 = this.f292909s;
        if (r101 == null) goto L5;
        r101.T5(z98.a.j.f571036b);
    L5:
        GalleryViewModel r102 = this.f292910t;
        if (r102 == null) goto L9;
        r102.updateSyncProgress(r100);
        return;
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final void U90(AppBarLayoutStateListener.State r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r100 != AppBarLayoutStateListener.State.COLLAPSED) goto L9;
        LarusFragmentMineAlbumListBinding r101 = this.f292901k;
        if (r101 == null) goto L15;
        AppCompatTextView r102 = r101.f293221h;
        if (r102 == null) goto L16;
        com.larus.utils.e1.x(r102);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        LarusFragmentMineAlbumListBinding r103 = this.f292901k;
        if (r103 == null) goto L18;
        AppCompatTextView r104 = r103.f293221h;
        if (r104 == null) goto L19;
        com.larus.utils.e1.o(r104);
        return;
    L19:
        return;
    }

    @Override // u98.a
    public final void VD(int r100) {
        GalleryViewModel r101 = this.f292910t;
        if (r101 == null) goto L6;
        r101.onRecoveryStarted(r100);
        return;
    }

    public final void ba0(Function2<? super Integer, ? super Integer, Unit> r100) {
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r102 = false;
        if (r101 == null) goto L9;
        DeviceService r103 = r101.device();
        if (r103 == null) goto L9;
        if (r103.u() != 2) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L26;
        AlbumSyncBanner r105 = this.f292909s;
        if (r105 != null) goto L14;
    L16:
        if (r102 == false) goto L24;
        AlbumSyncBanner r106 = this.f292909s;
        if (r106 == null) goto L27;
        LifecycleOwner r107 = r106.f292847c;
        if (r107 == null) goto L28;
        LifecycleCoroutineScope r108 = LifecycleOwnerKt.getLifecycleScope(r107);
        if (r108 == null) goto L29;
        BuildersKt.launch$default(r108, null, null, new AlbumSyncBanner$eraseError$1(r106, null), 3, null);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L24:
        ga0(r100);
        return;
    L14:
        if (r105.V5() != true) goto L16;
        r102 = true;
        goto L16
    L26:
        return;
    L9:
        r104 = false;
        goto L10
    }

    @Override // com.larus.avlink.gallery.view.AlbumSyncBanner.b
    public final void bj(final Function1<? super Boolean, Unit> r100) {
        ia8.b.b(this, new h1(this, r100));
    }

    public final void ga0(Function2<? super Integer, ? super Integer, Unit> r100) {
        LarusFragmentMineAlbumListBinding r101 = this.f292901k;
        Pair<Integer, Integer> r102 = null;
        if (r101 == null) goto L7;
        RecyclerView r103 = r101.f293217d;
        if (r103 == null) goto L7;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L9:
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
    L12:
        boolean r106 = false;
        if (r105 == null) goto L40;
        r105.topMargin = 0;
    L40:
        IDoraService r107 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L37
        if (r107 == null) goto L20;
        VisionService r108 = r107.V();     // Catch: Exception -> L37
        if (r108 == null) goto L20;
        r102 = r108.l();     // Catch: Exception -> L37
    L20:
        if (r102 != null) goto L22;
    L28:
        GalleryViewModel r109 = this.f292910t;     // Catch: Exception -> L37
        if (r109 != null) goto L31;
    L33:
        if (r106 == false) goto L35;
        ha0();     // Catch: Exception -> L37
        return;
    L35:
        m40(z98.a.c.f571028b);     // Catch: Exception -> L37
        return;
    L31:
        if (r109.shouldShowPermissionGuide() != true) goto L33;
        r106 = true;
        goto L33
    L22:
        if (r102.getSecond().intValue() == 0) goto L24;
    L25:
        m40(new z98.a.h(r102.getFirst().intValue(), r102.getSecond().intValue()));     // Catch: Exception -> L37
        if (r100 == null) goto L41;
        r100.invoke(r102.getFirst(), r102.getSecond());     // Catch: Exception -> L37
        return;
    L41:
        return;
    L24:
        if (r102.getFirst().intValue() == 0) goto L28;
    L37:
        e = move-exception;
        FLogger.f375446a.e(GalleryViewModel.TAG, "Error getting media diff: " + e.getMessage(), e);
        return;
    L11:
        r105 = null;
    L7:
        r104 = null;
        goto L9
    }

    @Override // u98.a
    public final void m40(z98.a r100) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new MineAlbumFragment$updateSyncBannerState$1(r100, this, null), 2, null);
    }

    @Override // u98.a
    public final void onError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        FLogger.f375446a.e("MineAlbumFragment", "Hardware media sync: Error - ".concat(r100));
        AlbumSyncBanner r101 = this.f292909s;
        if (r101 == null) goto L6;
        r101.T5(z98.a.n.f571040b);
        return;
    }

    @Override // w88.a
    public final void qU(final List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "map");
        ArrayList r100 = (ArrayList) r110;
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        FLogger r101 = FLogger.f375446a;
        r101.i("MineAlbumFragment", "onDelete received " + r100.size() + " paths");
        StringBuilder r102 = new StringBuilder("onDelete paths: ");
        r102.append(CollectionsKt.joinToString$default(r110, "\n  ", null, null, 0, null, null, 62, null));
        r101.d("MineAlbumFragment", r102.toString());
        com.larus.utils.y.c(new x0(this, r110));
    }

    public static void fa0(PolarisFileWrapper r100, long r110) {
        String r101 = FilesKt.getExtension(r100);     // Catch: Exception -> L26
        Locale r102 = Locale.ROOT;     // Catch: Exception -> L26
        if (CollectionsKt.listOf(new String[]{"jpg", LoadParams.ImageFormat.JPEG, LoadParams.ImageFormat.PNG, "webp"}).contains(r101.toLowerCase(r102)) == true) goto L7;
        return;
    L7:
        if (r100.exists() == true) goto L9;
    L24:
        FLogger.f375446a.w("MineAlbumFragment", "Skip EXIF write, file not writable: " + r100.getAbsolutePath());     // Catch: Exception -> L26
        return;
    L9:
        if (r100.canWrite() == false) goto L24;
        RandomAccessFile r103 = new RandomAccessFile(r100, "rw");     // Catch: Exception -> L26
        ExifInterface r104 = new ExifInterface(r103.getFD());     // Catch: Throwable -> L19
        String r111 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", r102).format(new Date(r110 * ((long) 1000)));     // Catch: Throwable -> L19
        r104.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME, r111);     // Catch: Throwable -> L19
        if (Build.VERSION.SDK_INT < 24) goto L15;
        r104.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME_ORIGINAL, r111);     // Catch: Throwable -> L19
        r104.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME_DIGITIZED, r111);     // Catch: Throwable -> L19
    L15:
        r104.saveAttributes();     // Catch: Throwable -> L19
        FLogger.f375446a.d("MineAlbumFragment", "Successfully set EXIF date for " + r100.getName() + " to: " + r111);     // Catch: Throwable -> L19
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        CloseableKt.closeFinally(r103, null);     // Catch: Exception -> L26
        return;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Exception -> L26
        throw th;     // Catch: Exception -> L26
    L26:
        e = move-exception;
        FLogger.f375446a.e("MineAlbumFragment", "Failed to set EXIF date for " + r100.getName() + ": " + e.getMessage(), e);
    }

    public final void aa0(int r100, int r101) {
        c r102 = this.f292906p;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.f292919a == r100) goto L8;
        return;
    L8:
        AlbumListAdapter r103 = this.f292903m;
        if (r103 == null) goto L46;
        List<com.larus.bmhome.bigimg.t1> r104 = r103.getCurrentList();
        if (r104 != null) goto L14;
        return;
    L14:
        if (r104.isEmpty() == false) goto L16;
        return;
    L16:
        int r105 = Math.min(r102.f292919a, r101);
        int r106 = Math.max(r102.f292919a, r101);
        boolean r107 = false;
        if (r105 >= 0) goto L19;
    L21:
        boolean r108 = false;
    L22:
        if (r108 == false) goto L47;
        if (r106 >= 0) goto L25;
    L27:
        if (r107 == false) goto L50;
        List<com.larus.bmhome.bigimg.t1> r109 = r104.subList(r105, r106 + 1);
        LinkedHashSet r110 = new LinkedHashSet();
        Iterator<T> r111 = r109.iterator();
    L31:
        if (r111.hasNext() == false) goto L33;
        r110.add(((com.larus.bmhome.bigimg.t1) r111.next()).getPath());
        goto L31
    L33:
        Set<String> r112 = CollectionsKt.toMutableSet(r102.f292920b);
        SwipeSelectionMode r113 = r102.f292921c;
        int r114 = d.f292922a[r113.ordinal()];
        if (r114 != 1) goto L36;
        r112.addAll(r110);
    L41:
        GalleryViewModel r115 = this.f292910t;
        if (r115 == null) goto L48;
        r115.applySelectedPaths(r112);
        return;
    L48:
        return;
    L36:
        if (r114 != 2) goto L39;
        r112.removeAll(r110);
        goto L41
    L39:
        throw new NoWhenBranchMatchedException();
    L50:
        return;
    L25:
        if (r106 >= r104.size()) goto L27;
        r107 = true;
        goto L27
    L47:
        return;
    L19:
        if (r105 >= r104.size()) goto L21;
        r108 = true;
        goto L22
    }

    public final void da0(Integer r100, Integer r101) {
        FLogger r102 = FLogger.f375446a;
        r102.i("MineAlbumFragment", "Starting UI sync via HardwareMediaLoadService");
        if (com.larus.avlink.gallery.f.a() == false) goto L7;
        m40(z98.a.e.f571030b);
        r102.i("MineAlbumFragment", "Low battery mode, skipping sync");
        return;
    L7:
        if (b98.b.b(3) == false) goto L10;
        m40(z98.a.g.f571032b);
        r102.i("MineAlbumFragment", "Video recording, skipping sync");
        return;
    L10:
        MediaSyncCoordinator.f292370a.u(MediaSyncCoordinator.SyncMode.MANUAL, true, r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object ia0(MediaMetadata r410, Continuation<? super Unit> r411) {
        if ((r411 instanceof MineAlbumFragment$syncMediaToAlbum$1) == false) goto L7;
        MineAlbumFragment$syncMediaToAlbum$1 r100 = (MineAlbumFragment$syncMediaToAlbum$1) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        String r105 = (String) r100.L$2;
        ContentResolver r106 = (ContentResolver) r100.L$1;
        MediaMetadata r107 = (MediaMetadata) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L14
        MediaMetadata r110 = r107;
    L25:
        MediaMetadata r108 = (MediaMetadata) r102;     // Catch: Exception -> L73
        if (r108 != null) goto L28;
        MediaMetadata r111 = r110;
    L29:
        Long r109 = r111.getSystemGalleryId();     // Catch: Exception -> L73
        String r112 = r111.getFinalFilePath();     // Catch: Exception -> L73
        if (r112 != null) goto L33;
        r112 = r111.getFilePath();     // Catch: Exception -> L73
    L33:
        if (r112.length() != 0) goto L35;
        boolean r113 = true;
    L85:
        if (r113 == false) goto L38;
    L71:
        FLogger.f375446a.e("MineAlbumFragment", "File not found: ".concat(r112));     // Catch: Exception -> L59
        return Unit.INSTANCE;
    L38:
        if (m5.c(r112) == false) goto L71;
        long r114 = 0;
        if (r109 == null) goto L51;
        if (r109.longValue() <= 0) goto L51;
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L73
        if (com.larus.avlink.gallery.c.i(r106, r109.toString()) == false) goto L48;
        FLogger.f375446a.d("MineAlbumFragment", "Media already synced: " + r105 + ", systemGalleryId: " + r109);     // Catch: Exception -> L73
        return Unit.INSTANCE;
    L48:
        FLogger.f375446a.i("MineAlbumFragment", "Media was deleted from album, re-syncing: " + r105);     // Catch: Exception -> L73
    L51:
        long r115 = r111.getCreateTime() / ((long) 1000);     // Catch: Exception -> L59
        PolarisFileWrapper r116 = new PolarisFileWrapper(r112);     // Catch: Exception -> L59
        String r117 = r111.getMediaType();     // Catch: Exception -> L59
        if (r117 != null) goto L54;
    L56:
        boolean r118 = false;
    L57:
        if (r118 == false) goto L61;
        fa0(r116, r115);     // Catch: Exception -> L59
    L61:
        Intrinsics.checkNotNull(r106);     // Catch: Exception -> L59
        Uri r119 = com.larus.avlink.gallery.c.f(r106, r116.getName(), r116.getAbsolutePath(), r111);     // Catch: Exception -> L59
        if (r119 != null) goto L65;
        FLogger.f375446a.e("MineAlbumFragment", "Failed to insert media file: " + r116.getName());     // Catch: Exception -> L59
        return Unit.INSTANCE;
    L65:
        String r120 = r119.getLastPathSegment();     // Catch: Exception -> L59
        if (r120 == null) goto L70;
        Long r121 = StringsKt.toLongOrNull(r120);     // Catch: Exception -> L59
        if (r121 == null) goto L70;
        r114 = r121.longValue();     // Catch: Exception -> L59
    L70:
        long r122 = r114;
        AlbumDataBaseHelper r123 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L59
        MediaMetadata r124 = MediaMetadata.copy$default(r111, null, 0, Boxing.boxLong(r122), null, null, null, 0, 0, 0, 0, 0, AudioStats.AUDIO_AMPLITUDE_NONE, 0, null, null, null, null, null, null, null, null, null, null, 0, 16777211, null);     // Catch: Exception -> L59
        r123.getClass();     // Catch: Exception -> L59
        AlbumDataBaseHelper.A(r124);     // Catch: Exception -> L59
        FLogger.f375446a.i("MineAlbumFragment", "Successfully synced media: " + r105 + ", uri=" + r119 + ", systemGalleryId: " + r122);     // Catch: Exception -> L59
    L79:
        return Unit.INSTANCE;
    L54:
        if (StringsKt.contains$default(r117, "image", false, 2, null) != true) goto L56;
        r118 = true;
    L59:
        e = e;
        String r125 = r113;
    L77:
        FLogger.f375446a.e(r125, "Exception syncing media " + r110.getUniqId() + ": " + e.getMessage(), e);
        goto L79
    L35:
        r113 = false;
        goto L85
    L28:
        r111 = r108;
    L14:
        e = e;
        r110 = r107;
    L74:
        r125 = "MineAlbumFragment";
        goto L77
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        r106 = AppHost.f326268a.getApplication().getContentResolver();     // Catch: Exception -> L75
        String r126 = r410.getUniqId();     // Catch: Exception -> L75
        AlbumDataBaseHelper r127 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L75
        r110 = r410;
        r100.L$0 = r110;     // Catch: Exception -> L73
        r100.L$1 = r106;     // Catch: Exception -> L73
        r100.L$2 = r126;     // Catch: Exception -> L73
        r100.label = 1;     // Catch: Exception -> L73
        Object r128 = r127.o(r126, r100);     // Catch: Exception -> L73
        if (r128 != r103) goto L24;
        return r103;
    L24:
        r105 = r126;
        r102 = r128;
    L73:
        e = e;
    L75:
        e = e;
        r110 = r410;
    L7:
        r100 = new MineAlbumFragment$syncMediaToAlbum$1(this, r411);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        r110.getViewTreeObserver().addOnWindowFocusChangeListener(new m0(this));
        MediaSyncExecutor r100 = MediaSyncExecutor.f292553a;
        Intrinsics.checkNotNullParameter(this, "listener");
        MediaSyncExecutor.f292561i = this;
        FLogger r101 = FLogger.f375446a;
        r101.d("MediaSyncExecutor", "Registered delete listener");
        IDoraService r102 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r102 == null) goto L5;
        r102.G(this.B);
    L5:
        MediaSyncCoordinator r103 = MediaSyncCoordinator.f292370a;
        MediaSyncCoordinator.p(this);
        MediaSyncCoordinator.f292375f = MediaSyncCoordinator.SyncMode.MANUAL;
        OnBackPressedCallback r104 = new MineAlbumFragment$initView$callback$1(this);
        FragmentActivity r105 = getActivity();
        if (r105 == null) goto L10;
        OnBackPressedDispatcher r106 = r105.getOnBackPressedDispatcher();
        if (r106 == null) goto L10;
        r106.addCallback(getViewLifecycleOwner(), r104);
    L10:
        LarusFragmentMineAlbumListBinding r107 = this.f292901k;
        if (r107 == null) goto L15;
        RecyclerView r108 = r107.f293217d;
        if (r108 == null) goto L15;
        this.f292916z = new v98.d(r108, i5.h0());
        r108.setLayoutManager(new GridLayoutManager(r108.getContext(), 3));
        r108.setItemAnimator(null);
        AlbumListAdapter r109 = new AlbumListAdapter(LifecycleOwnerKt.getLifecycleScope(this), this.C);
        this.f292903m = r109;
        r108.setAdapter(r109);
        r108.setItemViewCacheSize(10);
        r108.addItemDecoration(new GridSpacingItemDecoration(i5.z(), Boolean.FALSE));
    L15:
        LarusFragmentMineAlbumListBinding r112 = this.f292901k;
        if (r112 == null) goto L24;
        RecyclerView r113 = r112.f293217d;
        if (r113 == null) goto L24;
        RecyclerViewSwipeMultiSelectHelper r114 = this.f292904n;
        if (r114 == null) goto L23;
        r114.b();
        r114.f292931a.removeOnItemTouchListener(r114);
        r114.a();
    L23:
        Function0 r115 = new c1(this);
        MineAlbumFragment$setupSwipeMultiSelection$2 r116 = new MineAlbumFragment$setupSwipeMultiSelection$2(this);
        MineAlbumFragment$setupSwipeMultiSelection$3 r117 = new MineAlbumFragment$setupSwipeMultiSelection$3(this);
        Function0 r118 = new d1(this);
        Function0 r119 = new e1(this);
        Resources r120 = r113.getResources();
        this.f292904n = new RecyclerViewSwipeMultiSelectHelper(r113, r115, r116, r117, r118, r119, Float.valueOf(WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics()).density * 32.0f));
    L24:
        LarusFragmentMineAlbumListBinding r121 = this.f292901k;
        if (r121 == null) goto L29;
        RecyclerView r122 = r121.f293217d;
        if (r122 == null) goto L29;
        r122.addOnScrollListener(new MineAlbumFragment$initView$2(this));
    L29:
        X90();
        LarusFragmentMineAlbumListBinding r123 = this.f292901k;
        if (r123 == null) goto L32;
        AlbumSyncBanner r124 = r123.f293219f;
    L33:
        this.f292909s = r124;
        if (r124 == null) goto L36;
        r124.setSyncActionHandler(this);
    L36:
        AlbumSyncBanner r125 = this.f292909s;
        if (r125 == null) goto L40;
        r125.setLifecycleOwner(this);
    L40:
        if (getParentFragment() != null) goto L42;
        this.f292914x = true;
    L42:
        LarusFragmentMineAlbumListBinding r126 = this.f292901k;
        if (r126 == null) goto L47;
        AppCompatTextView r127 = r126.f293216c;
        if (r127 == null) goto L47;
        com.larus.utils.e1.d(r127, new g1(this));
    L47:
        ea0();
        Bundle r128 = getArguments();
        if (r128 == null) goto L56;
        String r129 = r128.getString("auto_sync");
        if (r129 == null) goto L56;
        if (Intrinsics.areEqual(r129, "true") == false) goto L56;
        View r130 = getView();
        if (r130 == null) goto L56;
        r130.postDelayed(new t0(this), 500);
    L56:
        GalleryViewModel r131 = (GalleryViewModel) new ViewModelProvider(this).get(GalleryViewModel.class);
        this.f292910t = r131;
        if (r131 == null) goto L59;
        r131.registerMediaLifecycleListener();
    L59:
        GalleryViewModel r132 = this.f292910t;
        if (r132 == null) goto L64;
        LiveData<List<com.larus.bmhome.bigimg.t1>> r133 = r132.getLocalMediaList();
        if (r133 == null) goto L64;
        r133.observe(getViewLifecycleOwner(), new g(new i1(this)));
    L64:
        GalleryViewModel r134 = this.f292910t;
        if (r134 == null) goto L69;
        LiveData<Boolean> r135 = r134.getLocalMediaLoadResult$dora_avlink_impl_release();
        if (r135 == null) goto L69;
        r135.observe(getViewLifecycleOwner(), new g(new m1(this)));
    L69:
        GalleryViewModel r136 = this.f292910t;
        if (r136 == null) goto L74;
        LiveData<Boolean> r137 = r136.getShowEmpty();
        if (r137 == null) goto L74;
        r137.observe(getViewLifecycleOwner(), new g(new n1(this)));
    L74:
        GalleryViewModel r138 = this.f292910t;
        if (r138 == null) goto L79;
        LiveData<Set<String>> r139 = r138.getSelectedItems();
        if (r139 == null) goto L79;
        r139.observe(getViewLifecycleOwner(), new g(new o1(this)));
    L79:
        GalleryViewModel r140 = this.f292910t;
        if (r140 == null) goto L84;
        LiveData<Boolean> r141 = r140.getHasSelectAll();
        if (r141 == null) goto L84;
        r141.observe(getViewLifecycleOwner(), new g(new n0(this)));
    L84:
        GalleryViewModel r142 = this.f292910t;
        if (r142 == null) goto L89;
        LiveData<Boolean> r143 = r142.isSelectMode();
        if (r143 == null) goto L89;
        r143.observe(getViewLifecycleOwner(), new g(new o0(this)));
    L89:
        GalleryViewModel r144 = this.f292910t;
        if (r144 == null) goto L94;
        LiveData<Integer> r145 = r144.getSyncProgress();
        if (r145 == null) goto L94;
        r145.observe(getViewLifecycleOwner(), new g(new p0(this)));
    L94:
        GalleryViewModel r146 = this.f292910t;
        if (r146 == null) goto L99;
        LiveData<Boolean> r147 = r146.getPermissionGranted();
        if (r147 == null) goto L99;
        r147.observe(getViewLifecycleOwner(), new g(new q0(this)));
    L99:
        GalleryViewModel r148 = this.f292910t;
        if (r148 == null) goto L104;
        LiveData<AlbumDeleteDialog> r149 = r148.getDeleteDialogEvent();
        if (r149 == null) goto L104;
        r149.observe(getViewLifecycleOwner(), new g(new r0(this)));
    L104:
        GalleryViewModel r150 = this.f292910t;
        if (r150 == null) goto L109;
        LiveData<CommonDialog> r151 = r150.getSimpleDialogEvent();
        if (r151 == null) goto L109;
        r151.observe(getViewLifecycleOwner(), new g(new s0(this)));
    L109:
        GalleryViewModel r152 = this.f292910t;
        if (r152 == null) goto L114;
        LiveData<Boolean> r153 = r152.getShowSharePanelEvent();
        if (r153 == null) goto L114;
        r153.observe(getViewLifecycleOwner(), new g(new j1(this)));
    L114:
        GalleryViewModel r154 = this.f292910t;
        if (r154 == null) goto L119;
        LiveData<GalleryViewModel.b> r155 = r154.getMediaReplaceEvent();
        if (r155 == null) goto L119;
        r155.observe(getViewLifecycleOwner(), new g(new k1(this)));
    L119:
        GalleryViewModel r156 = this.f292910t;
        if (r156 == null) goto L124;
        LiveData<String> r157 = r156.getSingleFileDeletedEvent();
        if (r157 == null) goto L124;
        r157.observe(getViewLifecycleOwner(), new g(new l1(this)));
    L124:
        r101.i(this.f292900j, "[loadData] - delegating to ViewModel");
        LarusFragmentMineAlbumListBinding r158 = this.f292901k;
        if (r158 == null) goto L131;
        LarusAccountDialogBinding r159 = r158.f293218e;
        if (r159 == null) goto L131;
        ConstraintLayout r160 = r159.f326606a;
        if (r160 == null) goto L131;
        com.larus.utils.e1.x(r160);
    L131:
        GalleryViewModel r161 = this.f292910t;
        if (r161 == null) goto L134;
        r161.loadLocalMedia();
    L134:
        com.larus.avlink.gallery.e.f292493a.getClass();
        com.larus.avlink.gallery.e.a();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass2(null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MineAlbumFragment$startFileMigration$1(null), 2, null);
        Bundle r162 = getArguments();
        if (r162 == null) goto L141;
        String r163 = r162.getString("previous_page");
        if (r163 == null) goto L141;
        Map<String, ? extends Object> r164 = MapsKt.mapOf(new Pair[]{TuplesKt.to("previous_page", r163), TuplesKt.to("current_page", "dora_album")});
        IDoraService r165 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r165 == null) goto L141;
        r165.A0(CheckPointType.ENTER_PAGE, r164);
    L141:
        ca0();
        return;
    L32:
        r124 = null;
        goto L33
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009e -> B:32:0x00a3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0192 -> B:86:0x0196). Please report as a decompilation issue!!! */
    public static final Object Z90(MineAlbumFragment r110, List r111, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1) == false) goto L7;
        MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1 r100 = (MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        MineAlbumFragment r102 = r110;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        boolean r106 = false;
        if (r105 == 0) goto L22;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        MediaMetadata r107 = (MediaMetadata) r100.L$2;
        Iterator r108 = (Iterator) r100.L$1;
        List r112 = (List) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L15
    L86:
        FLogger.f375446a.d("MineAlbumFragment", "Synced media: " + r107.getUniqId());     // Catch: Exception -> L15
    L77:
        if (r108.hasNext() == false) goto L93;
        r107 = (MediaMetadata) r108.next();     // Catch: Exception -> L96 CancellationException -> L98
        JobKt.ensureActive(r100.getContext());     // Catch: Exception -> L96 CancellationException -> L98
        Long r109 = r107.getSystemGalleryId();     // Catch: Exception -> L15
        if (r109 == null) goto L83;
        if (r109.longValue() > 0) goto L77;
    L83:
        r100.L$0 = r112;     // Catch: Exception -> L15
        r100.L$1 = r108;     // Catch: Exception -> L15
        r100.L$2 = r107;     // Catch: Exception -> L15
        r100.label = 2;     // Catch: Exception -> L15
        if (r102.ia0(r107, r100) != r104) goto L86;
    L115:
        return r104;
    L93:
        FLogger.f375446a.i("MineAlbumFragment", "Completed syncing " + r112.size() + " media to system gallery");     // Catch: Exception -> L96 CancellationException -> L98
    L100:
        return Unit.INSTANCE;
    L15:
        e = move-exception;
        FLogger r113 = FLogger.f375446a;     // Catch: Exception -> L96 CancellationException -> L98
        StringBuilder r114 = new StringBuilder();     // Catch: Exception -> L96 CancellationException -> L98
        r114.append("Failed to sync media ");     // Catch: Exception -> L96 CancellationException -> L98
        if (r107 == null) goto L91;
        String r115 = r107.getUniqId();     // Catch: Exception -> L96 CancellationException -> L98
    L92:
        r114.append(r115);     // Catch: Exception -> L96 CancellationException -> L98
        r114.append(": ");     // Catch: Exception -> L96 CancellationException -> L98
        r114.append(e.getMessage());     // Catch: Exception -> L96 CancellationException -> L98
        r113.e("MineAlbumFragment", r114.toString(), e);     // Catch: Exception -> L96 CancellationException -> L98
        goto L77
    L91:
        r115 = null;
        goto L92
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Iterator r116 = (Iterator) r100.L$1;
        Collection r117 = (Collection) r100.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L96 CancellationException -> L98
    L32:
        MediaMetadata r118 = (MediaMetadata) r103;     // Catch: Exception -> L96 CancellationException -> L98
        if (r118 == null) goto L35;
        Long r119 = r118.getSystemGalleryId();     // Catch: Exception -> L96 CancellationException -> L98
    L36:
        if (r118 != null) goto L38;
    L40:
        boolean r120 = false;
    L41:
        if (r120 == false) goto L53;
        if (r119 != null) goto L45;
    L50:
        boolean r121 = true;
    L51:
        if (r121 == false) goto L53;
    L54:
        if (r118 == null) goto L28;
        r117.add(r118);     // Catch: Exception -> L96 CancellationException -> L98
    L28:
        if (r116.hasNext() == false) goto L56;
        com.larus.bmhome.bigimg.t1 r122 = (com.larus.bmhome.bigimg.t1) r116.next();     // Catch: Exception -> L96 CancellationException -> L98
        AlbumDataBaseHelper r123 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L96 CancellationException -> L98
        String r124 = r122.g();     // Catch: Exception -> L96 CancellationException -> L98
        r100.L$0 = r117;     // Catch: Exception -> L96 CancellationException -> L98
        r100.L$1 = r116;     // Catch: Exception -> L96 CancellationException -> L98
        r100.label = 1;     // Catch: Exception -> L96 CancellationException -> L98
        r103 = r123.o(r124, r100);     // Catch: Exception -> L96 CancellationException -> L98
        if (r103 != r104) goto L32;
    L56:
        ArrayList r125 = new ArrayList();     // Catch: Exception -> L96 CancellationException -> L98
        Iterator r126 = ((List) r117).iterator();     // Catch: Exception -> L96 CancellationException -> L98
    L58:
        if (r126.hasNext() == false) goto L63;
        Object r127 = r126.next();     // Catch: Exception -> L96 CancellationException -> L98
        if (((MediaMetadata) r127).isCompleted() == false) goto L58;
        r125.add(r127);     // Catch: Exception -> L96 CancellationException -> L98
        goto L58
    L63:
        if (r125.isEmpty() == false) goto L65;
        FLogger.f375446a.d("MineAlbumFragment", "No unsynchronized media found");     // Catch: Exception -> L96 CancellationException -> L98
        return Unit.INSTANCE;
    L65:
        FLogger r128 = FLogger.f375446a;     // Catch: Exception -> L96 CancellationException -> L98
        r128.i("MineAlbumFragment", "Found " + r125.size() + " unsynchronized media, starting sync");     // Catch: Exception -> L96 CancellationException -> L98
        String r129 = ia8.b.f488929a;     // Catch: Exception -> L96 CancellationException -> L98
        boolean r130 = ia8.b.a(AppHost.f326268a.getApplication());     // Catch: Exception -> L96 CancellationException -> L98
        IDoraService r131 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L96 CancellationException -> L98
        if (r131 == null) goto L72;
        VisionService r132 = r131.V();     // Catch: Exception -> L96 CancellationException -> L98
        if (r132 == null) goto L72;
        if (r132.q() != true) goto L72;
        r106 = true;
    L72:
        if (r130 == false) goto L94;
        if (r106 == false) goto L94;
        r112 = r125;
        r108 = r125.iterator();     // Catch: Exception -> L96 CancellationException -> L98
    L94:
        r128.w("MineAlbumFragment", "Skip sync: hasPermission=" + r130 + ", isSaveEnabled=" + r106);     // Catch: Exception -> L96 CancellationException -> L98
        return Unit.INSTANCE;
    L45:
        if (r119.longValue() == 0) goto L50;
        if (r119.longValue() == (-1)) goto L50;
        r121 = false;
    L53:
        r118 = null;
        goto L54
    L38:
        if (r118.isCompleted() != true) goto L40;
        r120 = true;
        goto L41
    L35:
        r119 = null;
        goto L36
    L22:
        ResultKt.throwOnFailure(r103);
        if (r111.isEmpty() == false) goto L26;
        FLogger.f375446a.d("MineAlbumFragment", "No media found");     // Catch: Exception -> L96 CancellationException -> L98
        return Unit.INSTANCE;
    L26:
        r117 = new ArrayList();     // Catch: Exception -> L96 CancellationException -> L98
        r116 = r111.iterator();     // Catch: Exception -> L96 CancellationException -> L98
    L98:
        FLogger.f375446a.i("MineAlbumFragment", "checkAndSyncUnsynchronizedMedia cancelled");
    L96:
        e = move-exception;
        FLogger.f375446a.e("MineAlbumFragment", "Error checking unsynchronized media: " + e.getMessage(), e);
    L7:
        r102 = r110;
        r100 = new MineAlbumFragment$checkAndSyncUnsynchronizedMedia$1(r102, r210);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.larus_fragment_mine_album_list, r111, false);
        int r101 = R.id.album_empty;
        View r102 = ViewBindings.findChildViewById(r100, R.id.album_empty);
        if (r102 == null) goto L39;
        ConstraintLayout r103 = (ConstraintLayout) r102;
        int r104 = R.id.img_collect_empty;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r102, R.id.img_collect_empty);
        if (r105 == null) goto L37;
        r104 = R.id.tv_collect_empty;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.tv_collect_empty);
        if (r106 == null) goto L37;
        LarusPageAlbumListEmptyBinding r107 = new LarusPageAlbumListEmptyBinding(r103, r105, r106);
        r101 = R.id.album_error;
        View r108 = ViewBindings.findChildViewById(r100, R.id.album_error);
        if (r108 == null) goto L39;
        int r109 = R.id.profile_info_error_icon;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r108, R.id.profile_info_error_icon)) == null) goto L35;
        r109 = R.id.profile_info_error_text;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r108, R.id.profile_info_error_text)) == null) goto L35;
        ConstraintLayout r113 = (ConstraintLayout) r108;
        r101 = R.id.album_inject_entry;
        AppCompatTextView r114 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.album_inject_entry);
        if (r114 == null) goto L39;
        r101 = R.id.album_list;
        RecyclerView r115 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.album_list);
        if (r115 == null) goto L39;
        r101 = R.id.album_loading;
        View r116 = ViewBindings.findChildViewById(r100, R.id.album_loading);
        if (r116 == null) goto L39;
        ConstraintLayout r117 = (ConstraintLayout) r116;
        int r118 = R.id.google_login_loading_bar;
        FrameLayout r119 = (FrameLayout) ViewBindings.findChildViewById(r116, R.id.google_login_loading_bar);
        if (r119 == null) goto L33;
        r118 = R.id.loading_page;
        if (((ProgressBar) ViewBindings.findChildViewById(r116, R.id.loading_page)) == null) goto L33;
        LarusAccountDialogBinding r120 = new LarusAccountDialogBinding(r117, r119);
        r101 = R.id.album_sync_banner;
        AlbumSyncBanner r121 = (AlbumSyncBanner) ViewBindings.findChildViewById(r100, R.id.album_sync_banner);
        if (r121 == null) goto L39;
        r101 = R.id.albumion_item_cover;
        View r122 = ViewBindings.findChildViewById(r100, R.id.albumion_item_cover);
        if (r122 == null) goto L39;
        r101 = R.id.calendar_indicator;
        AppCompatTextView r123 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.calendar_indicator);
        if (r123 == null) goto L39;
        ConstraintLayout r124 = (ConstraintLayout) r100;
        this.f292901k = new LarusFragmentMineAlbumListBinding(r124, r107, r114, r115, r120, r121, r122, r123);
        return r124;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r116.getResources().getResourceName(r118)));
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r108.getResources().getResourceName(r109)));
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r104)));
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
