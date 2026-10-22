package com.larus.photopicker.v2.impl.viewmodel;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.locallife.dito.data.DitoNode;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.photopicker.v2.impl.data.model.LazyLoadConfig;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.model.EntryMode;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaNonUISettings;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.platform.model.preview.ResourceRefKind;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoRef;
import dr9.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import pp9.i;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010Q\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u001cJ\b\u0010U\u001a\u00020RH\u0002J\u0006\u0010V\u001a\u000202J\u000e\u0010W\u001a\u00020R2\u0006\u0010X\u001a\u000202J\u0006\u0010Y\u001a\u000202J\u000e\u0010Z\u001a\u00020R2\u0006\u0010X\u001a\u000202J(\u0010[\u001a\u00020R2\b\u0010\\\u001a\u0004\u0018\u00010T2\u0016\b\u0002\u0010]\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020R\u0018\u00010^J4\u0010_\u001a\u00020R2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u0002020^2\u0016\b\u0002\u0010]\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020R\u0018\u00010^H\u0002J\u0010\u0010a\u001a\u00020R2\b\b\u0002\u0010b\u001a\u00020cJ\u0006\u0010d\u001a\u00020RJ\u0006\u0010e\u001a\u00020RJ\u0018\u0010f\u001a\u0004\u0018\u00010g2\u0006\u0010h\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010iJ\u000e\u0010j\u001a\u0002022\u0006\u0010k\u001a\u00020gJ\u0006\u0010l\u001a\u00020RJ\u000e\u0010m\u001a\u00020R2\u0006\u0010n\u001a\u00020cJ\u000e\u0010o\u001a\u00020R2\u0006\u0010p\u001a\u00020&J\u0006\u0010q\u001a\u00020&J\u0006\u0010r\u001a\u000202J\u000e\u0010s\u001a\u00020R2\u0006\u0010t\u001a\u00020,J\u000e\u0010u\u001a\u00020R2\u0006\u0010v\u001a\u000202J\u000e\u0010w\u001a\u00020R2\u0006\u0010x\u001a\u00020(J\u0016\u0010y\u001a\u0002022\u0006\u0010x\u001a\u00020(2\u0006\u0010z\u001a\u000202J\u0006\u0010{\u001a\u00020RJ\u0006\u0010|\u001a\u00020RJ\u0016\u0010}\u001a\u00020R2\u0006\u0010k\u001a\u00020(2\u0006\u0010~\u001a\u00020,J\u0016\u0010\u007f\u001a\u00020R2\u0006\u0010k\u001a\u00020(2\u0006\u0010~\u001a\u00020,J\u000f\u0010\u0080\u0001\u001a\u00020,2\u0006\u0010k\u001a\u00020(J\u0010\u0010\u0081\u0001\u001a\u00020R2\u0007\u0010\u0082\u0001\u001a\u00020&J2\u0010\u0083\u0001\u001a\u00020R2\u0007\u0010\u0084\u0001\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020(2\u0007\u0010\u0085\u0001\u001a\u0002022\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001cH\u0002J\u001e\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001c2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020g0\u001cH\u0002J)\u0010\u0089\u0001\u001a\u00020R2\u0006\u0010x\u001a\u00020(2\u0007\u0010\u0085\u0001\u001a\u0002022\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001cH\u0002J>\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001c2\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001c2\u0006\u0010x\u001a\u00020(2\u0007\u0010\u0085\u0001\u001a\u0002022\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001cH\u0002J)\u0010\u008b\u0001\u001a\u00020,2\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020(0\u001c2\u0006\u0010k\u001a\u00020(2\u0007\u0010\u008d\u0001\u001a\u00020,H\u0002J#\u0010\u008e\u0001\u001a\u00020R2\u0007\u0010\u008f\u0001\u001a\u00020\u00052\u0006\u0010k\u001a\u00020(2\u0007\u0010\u0090\u0001\u001a\u00020,H\u0002J,\u0010\u0083\u0001\u001a\u00020R2\u0007\u0010\u0084\u0001\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020(2\u0007\u0010\u0085\u0001\u001a\u0002022\u0007\u0010\u0091\u0001\u001a\u00020,H\u0002J\u0012\u0010\u0092\u0001\u001a\u00020R2\u0007\u0010\u0084\u0001\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u001c0\u001f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u0002020\u001b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001d\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010>R#\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020,0B0\u001b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010>R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u001b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010>R\u0017\u0010G\u001a\b\u0012\u0004\u0012\u0002020\u001b¢\u0006\b\n\u0000\u001a\u0004\bH\u0010>R\u0011\u0010I\u001a\u00020J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010N\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0004\n\u0002\u0010OR\u000e\u0010P\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0093\u0001"}, d2 = {"Lcom/larus/photopicker/v2/impl/viewmodel/MediaGalleryLiveDataViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "mediaRepository", "Lcom/larus/photopicker/v2/impl/data/MediaRepository;", "uiConfig", "Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "getUiConfig", "()Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "setUiConfig", "(Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;)V", "nonUiSettings", "Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;", "getNonUiSettings", "()Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;", "setNonUiSettings", "(Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;)V", "lazyLoadConfig", "Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;", "getLazyLoadConfig", "()Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;", "setLazyLoadConfig", "(Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;)V", "_folders", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/photopicker/v2/impl/model/UIMediaFolder;", "folders", "Landroidx/lifecycle/LiveData;", "getFolders", "()Landroidx/lifecycle/LiveData;", "_currentFolder", "currentFolder", "getCurrentFolder", "currentTab", "Lcom/larus/photopicker/v2/impl/model/MediaTab;", "_fastMediaItems", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "fastMediaItems", "getFastMediaItems", "curPreviewPosition", "", "getCurPreviewPosition", "()I", "setCurPreviewPosition", "(I)V", "isNeedAnimWhenEnterPreview", "", "()Z", "setNeedAnimWhenEnterPreview", "(Z)V", "enterPreviewPageEntryMode", "Lcom/larus/photopicker/v2/impl/model/EntryMode;", "getEnterPreviewPageEntryMode", "()Lcom/larus/photopicker/v2/impl/model/EntryMode;", "setEnterPreviewPageEntryMode", "(Lcom/larus/photopicker/v2/impl/model/EntryMode;)V", "showPreviewFragment", "getShowPreviewFragment", "()Landroidx/lifecycle/MutableLiveData;", "currentPreviewItems", "getCurrentPreviewItems", "enterOrExitPreviewPage", "Lkotlin/Pair;", "getEnterOrExitPreviewPage", "capturePositionViewRect", "Lcom/larus/photopicker/v2/impl/model/EnterExitAnimationData;", "getCapturePositionViewRect", "closeTitleFolder", "getCloseTitleFolder", "selectionManager", "Lcom/larus/photopicker/v2/impl/viewmodel/SelectionManager;", "getSelectionManager", "()Lcom/larus/photopicker/v2/impl/viewmodel/SelectionManager;", "injectInputMode", "maxSelectCountBeforeForceSingle", "Ljava/lang/Integer;", "initialSelectionRestoreCompleted", "init", "", "initialSelectionUris", "Landroid/net/Uri;", "restoreInitialSelection", "isInitialSelectionRestoreCompleted", "setInjectInputMode", "enabled", "isInjectInputMode", "setAllowReplaceWhenSingle", "removeSelectionByUri", "uri", "onRemoved", "Lkotlin/Function1;", "removeSelectionByPredicate", "predicate", "initFastMediaItems", "delayDuration", "", "initMediaFolders", "refreshMediaFoldersAfterPermissionChange", "queryMediaItem", "Lcom/larus/photopicker/v2/impl/data/model/MediaItem;", "uriString", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMediaItemAndSelect", "mediaItem", "setFirstFolder", "setCurrentFolder", "folderId", "setCurrentTab", "tab", "getCurrentTab", "canShowTabs", "updateMaxSelectCount", "maxSelectCount", "updateForceSinglePick", "forceSinglePick", "toggleSelection", "curSelectedMediaItem", "setSelectionImmediately", "selected", "clearSelection", "closeTitleFolderEntrance", "enterPreviewMediaPage", "position", "enterPreviewMediaPageFromBottomSelector", "getCurMediaItemPositionInPreview", DitoNode.LOAD_MORE, "mediaTab", "refreshCurFolderSelectedStatus", "curFolder", "isSelected", "selectedSnapshot", "buildFastUIMediaItems", "mediaItems", "refreshFastMediaSelectedStatus", "refreshMediaItemsSelectedStatus", "resolvePreviewPosition", "previewItems", "fallbackPosition", "reportCurrentFolderNotReady", "action", "fastMediaSize", "selectionOrder", "refreshFolderSelectableByType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaGalleryLiveDataViewModel extends ViewModel {
    private final String TAG;
    private final MutableLiveData<op9.c> _currentFolder;
    private final MutableLiveData<List<op9.d>> _fastMediaItems;
    private final MutableLiveData<List<op9.c>> _folders;
    private final MutableLiveData<op9.a> capturePositionViewRect;
    private final MutableLiveData<Boolean> closeTitleFolder;
    private int curPreviewPosition;
    private final LiveData<op9.c> currentFolder;
    private final MutableLiveData<List<op9.d>> currentPreviewItems;
    private MediaTab currentTab;
    private final MutableLiveData<Pair<Boolean, Integer>> enterOrExitPreviewPage;
    private EntryMode enterPreviewPageEntryMode;
    private final LiveData<List<op9.d>> fastMediaItems;
    private final LiveData<List<op9.c>> folders;
    private boolean initialSelectionRestoreCompleted;
    private boolean injectInputMode;
    private boolean isNeedAnimWhenEnterPreview;
    private LazyLoadConfig lazyLoadConfig;
    private Integer maxSelectCountBeforeForceSingle;
    private com.larus.photopicker.v2.impl.data.d mediaRepository;
    private MediaNonUISettings nonUiSettings;
    private final d selectionManager;
    private final MutableLiveData<Boolean> showPreviewFragment;
    private MediaGalleryUIConfig uiConfig;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f364692a;

        public a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f364692a = r100;
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
            return this.f364692a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f364692a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$clearSelection$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$clearSelection$1", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_ENABLE_ABR}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$clearSelection$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$clearSelection$1$2", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ op9.c $curFolder;
            final /* synthetic */ Set<op9.d> $curSelectedItems;
            int label;
            final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

            public AnonymousClass2(MediaGalleryLiveDataViewModel r100, op9.c r101, Set<op9.d> r102, Continuation<? super AnonymousClass2> r103) {
                this.this$0 = r100;
                this.$curFolder = r101;
                this.$curSelectedItems = r102;
                super(2, r103);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass2(this.this$0, this.$curFolder, this.$curSelectedItems, r101);
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
            public final Object invokeSuspend(Object r110) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L20;
                ResultKt.throwOnFailure(r110);
                List r111 = (List) MediaGalleryLiveDataViewModel.access$get_folders$p(this.this$0).getValue();
                if (r111 == null) goto L18;
                op9.c r100 = this.$curFolder;
                Set<op9.d> r101 = this.$curSelectedItems;
                MediaGalleryLiveDataViewModel r102 = this.this$0;
                Iterator r112 = r111.iterator();
            L8:
                if (r112.hasNext() == false) goto L18;
                op9.c r103 = (op9.c) r112.next();
                if (r103.f524787a == r100.f524787a) goto L8;
                Iterator<T> r104 = r101.iterator();
            L14:
                if (r104.hasNext() == false) goto L16;
                MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r102, r103, (op9.d) r104.next(), false, 0);
                goto L14
            L16:
                MediaGalleryLiveDataViewModel.access$refreshFolderSelectableByType(r102, r103);
            L18:
                return Unit.INSTANCE;
            L20:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(MediaGalleryLiveDataViewModel r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            op9.c r103 = (op9.c) MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).getValue();
            if (r103 == null) goto L11;
            Set r104 = (Set) this.this$0.getSelectionManager().f364705g.getValue();
            if (r104 == null) goto L15;
            MediaGalleryLiveDataViewModel r105 = this.this$0;
            Iterator r106 = r104.iterator();
        L18:
            if (r106.hasNext() == false) goto L20;
            MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r105, r103, (op9.d) r106.next(), false, 0);
            goto L18
        L20:
            d r107 = this.this$0.getSelectionManager();
            r107.getClass();
            e0.d("SelectionManager", "clearSelection");
            r107.f364704f.setValue(new LinkedHashSet());
            r107.f364706h.setValue(Boolean.TRUE);
            String r108 = MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0);
            StringBuilder r109 = new StringBuilder("clearSelection, curFolder=");
            mp9.b r110 = r103.f524788b;
            if (r110 == null) goto L23;
            String r111 = r110.f514727b;
        L24:
            r109.append(r111);
            e0.d(r108, r109.toString());
            MediaGalleryLiveDataViewModel.access$refreshFolderSelectableByType(this.this$0, r103);
            MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).postValue(r103);
            CoroutineDispatcher r112 = Dispatchers.getDefault();
            AnonymousClass2 r113 = new AnonymousClass2(this.this$0, r103, r104, null);
            this.label = 1;
            if (BuildersKt.withContext(r112, r113, this) != r101) goto L28;
            return r101;
        L23:
            r111 = null;
            goto L24
        L15:
            return Unit.INSTANCE;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$initFastMediaItems$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$initFastMediaItems$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0, 1}, l = {254, 258, 261}, m = "invokeSuspend", n = {"repository", "repository"}, s = {"L$0", "L$0"})
    public static final class C114981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayDuration;
        Object L$0;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        public C114981(MediaGalleryLiveDataViewModel r100, long r101, Continuation<? super C114981> r102) {
            this.this$0 = r100;
            this.$delayDuration = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114981(this.this$0, this.$delayDuration, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114981) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L11;
            if (r101 == 2) goto L10;
            if (r101 != 3) goto L9;
            ResultKt.throwOnFailure(r110);
        L27:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            com.larus.photopicker.v2.impl.data.d r102 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r110);
        L23:
            int r111 = e0.f364440a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "[" + MediaGalleryLiveDataViewModel.access$getCurrentTab$p(this.this$0) + "] start initMediaFolders loadFolders");
            List<MediaTab> r112 = this.this$0.getUiConfig().f364484a;
            this.L$0 = null;
            this.label = 3;
            if (r102.e(r112, this) != r100) goto L27;
            return r100;
        L11:
            r102 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r110);
        L20:
            MediaGalleryLiveDataViewModel.access$get_fastMediaItems$p(this.this$0).setValue(MediaGalleryLiveDataViewModel.access$buildFastUIMediaItems(this.this$0, (List) r110));
            long r103 = this.$delayDuration;
            this.L$0 = r102;
            this.label = 2;
            if (DelayKt.delay(r103, this) != r100) goto L23;
            return r100;
        L12:
            ResultKt.throwOnFailure(r110);
            com.larus.photopicker.v2.impl.data.d r113 = MediaGalleryLiveDataViewModel.access$getMediaRepository$p(this.this$0);
            if (r113 == null) goto L15;
            int r104 = e0.f364440a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "[" + MediaGalleryLiveDataViewModel.access$getCurrentTab$p(this.this$0) + "] start initFastMediaItems loadFolders");
            int r105 = this.this$0.getLazyLoadConfig().f364369c;
            List<MediaTab> r106 = this.this$0.getUiConfig().f364484a;
            this.L$0 = r113;
            this.label = 1;
            Object r107 = r113.f(1, r105, r106, this);
            if (r107 != r100) goto L19;
            return r100;
        L19:
            r102 = r113;
            r110 = r107;
            goto L20
        L15:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$initMediaFolders$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$initMediaFolders$1", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        public C114991(MediaGalleryLiveDataViewModel r100, Continuation<? super C114991> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114991(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114991) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            com.larus.photopicker.v2.impl.data.d r103 = MediaGalleryLiveDataViewModel.access$getMediaRepository$p(this.this$0);
            if (r103 == null) goto L11;
            int r104 = e0.f364440a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "[" + MediaGalleryLiveDataViewModel.access$getCurrentTab$p(this.this$0) + "] initMediaFolders: loadFolders");
            List<MediaTab> r105 = this.this$0.getUiConfig().f364484a;
            this.label = 1;
            if (r103.e(r105, this) != r101) goto L16;
            return r101;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$loadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$loadMore$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0, 0, 1, 1}, l = {570, 576, 579}, m = "invokeSuspend", n = {"repository", "filter", "repository", "filter"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C115001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MediaTab $mediaTab;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        public C115001(MediaGalleryLiveDataViewModel r100, MediaTab r101, Continuation<? super C115001> r102) {
            this.this$0 = r100;
            this.$mediaTab = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C115001(this.this$0, this.$mediaTab, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C115001) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L11;
            if (r101 == 2) goto L10;
            if (r101 != 3) goto L9;
            ResultKt.throwOnFailure(r110);
        L43:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            mp9.a r102 = (mp9.a) this.L$1;
            com.larus.photopicker.v2.impl.data.d r103 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r110);
        L39:
            int r111 = ((Number) r110).intValue();
            int r104 = e0.f364440a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "4.loadMore: Load next page, curPage: " + r111);
            int r105 = this.this$0.getLazyLoadConfig().f364368b;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (r103.i(r111 + 1, r105, r102, this) != r100) goto L43;
            return r100;
        L11:
            r102 = (mp9.a) this.L$1;
            com.larus.photopicker.v2.impl.data.d r106 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r110);
        L32:
            if (((Boolean) r110).booleanValue() == true) goto L35;
            int r112 = e0.f364440a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "3.loadMore: No more items");
            return Unit.INSTANCE;
        L35:
            this.L$0 = r106;
            this.L$1 = r102;
            this.label = 2;
            r110 = r106.b(r102, this);
            if (r110 != r100) goto L38;
            return r100;
        L38:
            r103 = r106;
            goto L39
        L12:
            ResultKt.throwOnFailure(r110);
            com.larus.photopicker.v2.impl.data.d r113 = MediaGalleryLiveDataViewModel.access$getMediaRepository$p(this.this$0);
            if (r113 == null) goto L15;
            op9.c r107 = (op9.c) MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).getValue();
            if (r107 == null) goto L19;
            Long r108 = Boxing.boxLong(r107.f524787a);
        L20:
            if (r108 != null) goto L23;
            int r114 = e0.f364440a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(this.this$0), "2.loadMore: Folder has not been initialized, don't need to loadMore");
            return Unit.INSTANCE;
        L23:
            op9.c r109 = (op9.c) MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).getValue();
            if (r109 == null) goto L26;
            Long r115 = Boxing.boxLong(r109.f524787a);
        L27:
            r102 = new mp9.a(r115, this.$mediaTab);
            this.L$0 = r113;
            this.L$1 = r102;
            this.label = 1;
            Object r116 = r113.d(r102, this);
            if (r116 != r100) goto L30;
            return r100;
        L30:
            r106 = r113;
            r110 = r116;
            goto L32
        L26:
            r115 = null;
            goto L27
        L19:
            r108 = null;
            goto L20
        L15:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$refreshMediaFoldersAfterPermissionChange$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$refreshMediaFoldersAfterPermissionChange$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT}, m = "invokeSuspend", n = {"repository", "destination$iv$iv"}, s = {"L$0", "L$1"})
    public static final class C115011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        public C115011(MediaGalleryLiveDataViewModel r100, Continuation<? super C115011> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C115011(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C115011) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a2 -> B:27:0x00aa). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r110);
        L58:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Long r102 = (Long) this.L$3;
            Iterator r103 = (Iterator) this.L$2;
            Collection r104 = (Collection) this.L$1;
            com.larus.photopicker.v2.impl.data.d r105 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r110);
            com.larus.photopicker.v2.impl.data.d r106 = r105;
            Collection r107 = r104;
            Iterator r108 = r103;
            Long r109 = r102;
            Object r111 = r100;
            C115011 r112 = this;
        L27:
            if (r110 != null) goto L29;
            boolean r113 = true;
        L30:
            if (r113 == true) goto L33;
            r109 = null;
        L33:
            if (r109 == null) goto L35;
            r107.add(r109);
        L35:
            C115011 r114 = r112;
            r100 = r111;
            Iterator r115 = r108;
            Collection r116 = r107;
            com.larus.photopicker.v2.impl.data.d r117 = r106;
        L22:
            if (r115.hasNext() == false) goto L36;
            op9.d r118 = (op9.d) r115.next();
            String r119 = r118.f524790a.f514733b.toString();
            Long r120 = Boxing.boxLong(r118.f524790a.f514732a);
            r120.longValue();
            r114.L$0 = r117;
            r114.L$1 = r116;
            r114.L$2 = r115;
            r114.L$3 = r120;
            r114.label = 1;
            Object r121 = r117.a(r119, r114);
            if (r121 != r100) goto L26;
            return r100;
        L26:
            Object r122 = r100;
            r112 = r114;
            r110 = r121;
            r106 = r117;
            r107 = r116;
            r108 = r115;
            r109 = r120;
            r111 = r122;
            goto L27
        L36:
            Set r123 = CollectionsKt.toSet((List) r116);
            if ((true ^ r123.isEmpty()) == false) goto L54;
            int r124 = e0.f364440a;
            e0.d(MediaGalleryLiveDataViewModel.access$getTAG$p(r114.this$0), "Remove inaccessible selections after permission change: " + r123);
            d r125 = r114.this$0.getSelectionManager();
            r125.getClass();
            Intrinsics.checkNotNullParameter(r123, "mediaItemIds");
            if (r123.isEmpty() == true) goto L54;
            Set<op9.d> r126 = r125.f364704f.getValue();
            if (r126 == null) goto L54;
            ArrayList r127 = new ArrayList();
            Iterator<T> r128 = r126.iterator();
        L46:
            if (r128.hasNext() == false) goto L50;
            Object r129 = r128.next();
            if (r123.contains(Long.valueOf(((op9.d) r129).f524790a.f514732a)) == true) goto L46;
            r127.add(r129);
            goto L46
        L50:
            LinkedHashSet r130 = (LinkedHashSet) CollectionsKt.toCollection(r127, new LinkedHashSet());
            if (r130.size() == r126.size()) goto L54;
            int r131 = e0.f364440a;
            e0.d("SelectionManager", "removeSelectionsByIds: " + r123);
            r125.f364704f.setValue(r130);
            r125.n();
        L54:
            List<MediaTab> r132 = r114.this$0.getUiConfig().f364484a;
            r114.L$0 = null;
            r114.L$1 = null;
            r114.L$2 = null;
            r114.L$3 = null;
            r114.label = 2;
            if (r117.e(r132, r114) != r100) goto L58;
            return r100;
        L29:
            r113 = false;
            goto L30
        L10:
            ResultKt.throwOnFailure(r110);
            com.larus.photopicker.v2.impl.data.d r133 = MediaGalleryLiveDataViewModel.access$getMediaRepository$p(this.this$0);
            if (r133 == null) goto L13;
            Set r134 = (Set) this.this$0.getSelectionManager().f364705g.getValue();
            if (r134 == null) goto L17;
            List r135 = CollectionsKt.toList(r134);
        L18:
            if (r135 != null) goto L20;
            r135 = CollectionsKt.emptyList();
        L20:
            r117 = r133;
            r116 = new ArrayList();
            r114 = this;
            r115 = r135.iterator();
            goto L22
        L17:
            r135 = null;
            goto L18
        L13:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$removeSelectionByPredicate$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$removeSelectionByPredicate$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0}, l = {VideoRef.VALUE_VIDEO_REF_PALLAS_VID_LABELS}, m = "invokeSuspend", n = {"targetItem"}, s = {"L$0"})
    public static final class C115021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<op9.d, Unit> $onRemoved;
        final /* synthetic */ Function1<op9.d, Boolean> $predicate;
        Object L$0;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$removeSelectionByPredicate$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$removeSelectionByPredicate$1$1", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C44651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ op9.c $curFolder;
            final /* synthetic */ List<op9.d> $selectedSnapshot;
            final /* synthetic */ op9.d $targetItem;
            int label;
            final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

            public C44651(MediaGalleryLiveDataViewModel r100, op9.c r101, op9.d r102, List<op9.d> r103, Continuation<? super C44651> r104) {
                this.this$0 = r100;
                this.$curFolder = r101;
                this.$targetItem = r102;
                this.$selectedSnapshot = r103;
                super(2, r104);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C44651(this.this$0, this.$curFolder, this.$targetItem, this.$selectedSnapshot, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C44651) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L17;
                ResultKt.throwOnFailure(r110);
                List r111 = (List) MediaGalleryLiveDataViewModel.access$get_folders$p(this.this$0).getValue();
                if (r111 == null) goto L14;
                op9.c r100 = this.$curFolder;
                MediaGalleryLiveDataViewModel r101 = this.this$0;
                op9.d r102 = this.$targetItem;
                List<op9.d> r103 = this.$selectedSnapshot;
                Iterator r112 = r111.iterator();
            L8:
                if (r112.hasNext() == false) goto L23;
                op9.c r104 = (op9.c) r112.next();
                if (r104.f524787a == r100.f524787a) goto L8;
                MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r101, r104, r102, false, r103);
                MediaGalleryLiveDataViewModel.access$refreshFolderSelectableByType(r101, r104);
                goto L8
            L23:
                return Unit.INSTANCE;
            L14:
                return null;
            L17:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C115021(MediaGalleryLiveDataViewModel r100, Function1<? super op9.d, Boolean> r101, Function1<? super op9.d, Unit> r102, Continuation<? super C115021> r103) {
            this.this$0 = r100;
            this.$predicate = r101;
            this.$onRemoved = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C115021(this.this$0, this.$predicate, this.$onRemoved, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C115021) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            op9.d r102 = (op9.d) this.L$0;
            ResultKt.throwOnFailure(r110);
        L37:
            Function1<op9.d, Unit> r111 = this.$onRemoved;
            if (r111 == null) goto L41;
            r111.invoke(r102);
        L41:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            Set r112 = (Set) this.this$0.getSelectionManager().f364705g.getValue();
            if (r112 == null) goto L12;
            List r113 = CollectionsKt.toList(r112);
            if (r113 == null) goto L12;
        L13:
            Function1<op9.d, Boolean> r103 = this.$predicate;
            Iterator r114 = r113.iterator();
        L15:
            if (r114.hasNext() == false) goto L19;
            Object r104 = r114.next();
            if (r103.invoke((op9.d) r104).booleanValue() == false) goto L15;
        L20:
            op9.d r115 = (op9.d) r104;
            if (r115 == null) goto L23;
            op9.c r105 = (op9.c) MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).getValue();
            if (r105 == null) goto L27;
            this.this$0.getSelectionManager().l(r115);
            Set r106 = (Set) this.this$0.getSelectionManager().f364705g.getValue();
            if (r106 == null) goto L32;
            List r107 = CollectionsKt.toList(r106);
            if (r107 == null) goto L32;
        L33:
            List r108 = r107;
            MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(this.this$0, r105, r115, false, r108);
            MediaGalleryLiveDataViewModel.access$refreshFolderSelectableByType(this.this$0, r105);
            MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).postValue(r105);
            CoroutineDispatcher r109 = Dispatchers.getDefault();
            C44651 r116 = new C44651(this.this$0, r105, r115, r108, null);
            this.L$0 = r115;
            this.label = 1;
            if (BuildersKt.withContext(r109, r116, this) != r100) goto L36;
            return r100;
        L36:
            r102 = r115;
        L32:
            r107 = CollectionsKt.emptyList();
            goto L33
        L27:
            return Unit.INSTANCE;
        L23:
            return Unit.INSTANCE;
        L19:
            r104 = null;
        L12:
            r113 = CollectionsKt.emptyList();
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$restoreInitialSelection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$restoreInitialSelection$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0, 0}, l = {190}, m = "invokeSuspend", n = {"repository", "destination$iv$iv"}, s = {"L$0", "L$1"})
    public static final class C115031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Uri> $initialUris;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C115031(MediaGalleryLiveDataViewModel r100, List<? extends Uri> r101, Continuation<? super C115031> r102) {
            this.this$0 = r100;
            this.$initialUris = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C115031(this.this$0, this.$initialUris, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C115031) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0062 -> B:17:0x0069). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            int r102 = 0;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            Iterator r103 = (Iterator) this.L$2;
            Collection r104 = (Collection) this.L$1;
            com.larus.photopicker.v2.impl.data.d r105 = (com.larus.photopicker.v2.impl.data.d) this.L$0;
            ResultKt.throwOnFailure(r110);
            com.larus.photopicker.v2.impl.data.d r106 = r105;
            Collection r107 = r104;
            Iterator r108 = r103;
            Object r109 = r100;
            C115031 r111 = this;
        L17:
            mp9.c r112 = (mp9.c) r110;
            if (r112 == null) goto L40;
            op9.d r113 = op9.e.c(r112, false, 0);
        L22:
            if (r113 == null) goto L24;
            r107.add(r113);
        L24:
            C115031 r114 = r111;
            r100 = r109;
            Iterator r115 = r108;
            Collection r116 = r107;
            com.larus.photopicker.v2.impl.data.d r117 = r106;
        L10:
            if (r115.hasNext() == false) goto L25;
            Uri r118 = (Uri) r115.next();
            if (r117 == null) goto L21;
            String r119 = r118.toString();
            r114.L$0 = r117;
            r114.L$1 = r116;
            r114.L$2 = r115;
            r114.label = 1;
            Object r120 = r117.a(r119, r114);
            if (r120 != r100) goto L16;
            return r100;
        L16:
            Object r121 = r100;
            r111 = r114;
            r110 = r120;
            r106 = r117;
            r107 = r116;
            r108 = r115;
            r109 = r121;
            goto L17
        L21:
            Object r122 = r100;
            r111 = r114;
            r113 = null;
            r106 = r117;
            r107 = r116;
            r108 = r115;
            r109 = r122;
            goto L22
        L25:
            List r123 = (List) r116;
            MediaGalleryLiveDataViewModel.access$setInitialSelectionRestoreCompleted$p(r114.this$0, true);
            d r124 = r114.this$0.getSelectionManager();
            r124.getClass();
            Intrinsics.checkNotNullParameter(r123, "items");
            HashSet r125 = new HashSet();
            ArrayList r126 = new ArrayList();
            Iterator r127 = r123.iterator();
        L27:
            if (r127.hasNext() == false) goto L31;
            Object r128 = r127.next();
            if (r125.add(Long.valueOf(((op9.d) r128).f524790a.f514732a)) == false) goto L27;
            r126.add(r128);
            goto L27
        L31:
            ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
            Iterator r130 = r126.iterator();
        L33:
            if (r130.hasNext() == false) goto L38;
            Object r131 = r130.next();
            int r132 = r102 + 1;
            if (r102 >= 0) goto L37;
            CollectionsKt.throwIndexOverflow();
        L37:
            r129.add(op9.d.a((op9.d) r131, null, true, r132, false, 25));
            r102 = r132;
            goto L33
        L38:
            r124.f364704f.setValue((LinkedHashSet) CollectionsKt.toCollection(r129, new LinkedHashSet()));
            r124.n();
            return Unit.INSTANCE;
        L40:
            r111 = r111;
            r113 = null;
            r106 = r106;
            r107 = r107;
            r108 = r108;
            r109 = r109;
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            com.larus.photopicker.v2.impl.data.d r133 = MediaGalleryLiveDataViewModel.access$getMediaRepository$p(this.this$0);
            List<Uri> r134 = this.$initialUris;
            r116 = new ArrayList();
            r115 = r134.iterator();
            r117 = r133;
            r114 = this;
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$setSelectionImmediately$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$setSelectionImmediately$1", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SOCKET_ERR_CODE}, m = "invokeSuspend", n = {}, s = {})
    public static final class C115041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ op9.c $curFolder;
        final /* synthetic */ op9.d $curSelectedMediaItem;
        final /* synthetic */ boolean $isSelected;
        final /* synthetic */ List<op9.d> $selectedSnapshot;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$setSelectionImmediately$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$setSelectionImmediately$1$1", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C44661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ op9.c $curFolder;
            final /* synthetic */ op9.d $curSelectedMediaItem;
            final /* synthetic */ boolean $isSelected;
            final /* synthetic */ List<op9.d> $selectedSnapshot;
            int label;
            final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

            public C44661(MediaGalleryLiveDataViewModel r100, op9.c r101, op9.d r102, boolean r103, List<op9.d> r104, Continuation<? super C44661> r105) {
                this.this$0 = r100;
                this.$curFolder = r101;
                this.$curSelectedMediaItem = r102;
                this.$isSelected = r103;
                this.$selectedSnapshot = r104;
                super(2, r105);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C44661(this.this$0, this.$curFolder, this.$curSelectedMediaItem, this.$isSelected, this.$selectedSnapshot, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C44661) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r110);
                List r111 = (List) MediaGalleryLiveDataViewModel.access$get_folders$p(this.this$0).getValue();
                if (r111 == null) goto L14;
                op9.c r100 = this.$curFolder;
                MediaGalleryLiveDataViewModel r101 = this.this$0;
                op9.d r102 = this.$curSelectedMediaItem;
                boolean r103 = this.$isSelected;
                List<op9.d> r104 = this.$selectedSnapshot;
                Iterator r112 = r111.iterator();
            L8:
                if (r112.hasNext() == false) goto L14;
                op9.c r105 = (op9.c) r112.next();
                if (r105.f524787a == r100.f524787a) goto L8;
                MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r101, r105, r102, r103, r104);
                MediaGalleryLiveDataViewModel.access$refreshFolderSelectableByType(r101, r105);
            L14:
                return Unit.INSTANCE;
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C115041(MediaGalleryLiveDataViewModel r100, op9.c r101, op9.d r102, boolean r103, List<op9.d> r104, Continuation<? super C115041> r105) {
            this.this$0 = r100;
            this.$curFolder = r101;
            this.$curSelectedMediaItem = r102;
            this.$isSelected = r103;
            this.$selectedSnapshot = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C115041(this.this$0, this.$curFolder, this.$curSelectedMediaItem, this.$isSelected, this.$selectedSnapshot, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C115041) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            CoroutineDispatcher r111 = Dispatchers.getDefault();
            C44661 r102 = new C44661(this.this$0, this.$curFolder, this.$curSelectedMediaItem, this.$isSelected, this.$selectedSnapshot, null);
            this.label = 1;
            if (BuildersKt.withContext(r111, r102, this) != r100) goto L12;
            return r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$updateForceSinglePick$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$updateForceSinglePick$1", f = "MediaGalleryLiveDataViewModel.kt", i = {0}, l = {400}, m = "invokeSuspend", n = {"keep"}, s = {"L$0"})
    public static final class C115051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $forceSinglePick;
        Object L$0;
        int label;
        final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

        /* JADX INFO: renamed from: com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$updateForceSinglePick$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel$updateForceSinglePick$1$2", f = "MediaGalleryLiveDataViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ op9.c $curFolder;
            final /* synthetic */ List<op9.d> $selectedSnapshot;
            int label;
            final /* synthetic */ MediaGalleryLiveDataViewModel this$0;

            public AnonymousClass2(MediaGalleryLiveDataViewModel r100, op9.c r101, List<op9.d> r102, Continuation<? super AnonymousClass2> r103) {
                this.this$0 = r100;
                this.$curFolder = r101;
                this.$selectedSnapshot = r102;
                super(2, r103);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass2(this.this$0, this.$curFolder, this.$selectedSnapshot, r101);
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
            public final Object invokeSuspend(Object r110) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L20;
                ResultKt.throwOnFailure(r110);
                List r111 = (List) MediaGalleryLiveDataViewModel.access$get_folders$p(this.this$0).getValue();
                if (r111 == null) goto L17;
                op9.c r100 = this.$curFolder;
                List<op9.d> r101 = this.$selectedSnapshot;
                MediaGalleryLiveDataViewModel r102 = this.this$0;
                Iterator r112 = r111.iterator();
            L8:
                if (r112.hasNext() == false) goto L26;
                op9.c r103 = (op9.c) r112.next();
                if (r103.f524787a == r100.f524787a) goto L8;
                Iterator<T> r104 = r101.iterator();
            L14:
                if (r104.hasNext() == false) goto L8;
                MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r102, r103, (op9.d) r104.next(), false, 0);
                goto L14
            L26:
                return Unit.INSTANCE;
            L17:
                return null;
            L20:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C115051(MediaGalleryLiveDataViewModel r100, boolean r101, Continuation<? super C115051> r102) {
            this.this$0 = r100;
            this.$forceSinglePick = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C115051(this.this$0, this.$forceSinglePick, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C115051) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            op9.d r102 = (op9.d) this.L$0;
            ResultKt.throwOnFailure(r110);
        L31:
            op9.d r103 = r102;
        L32:
            d r111 = this.this$0.getSelectionManager();
            r111.getClass();
            e0.d("SelectionManager", "clearSelection");
            r111.f364704f.setValue(new LinkedHashSet());
            r111.f364706h.setValue(Boolean.TRUE);
            this.this$0.toggleSelection(r103);
        L39:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            MediaGalleryLiveDataViewModel r112 = this.this$0;
            r112.setUiConfig(MediaGalleryUIConfig.a(r112.getUiConfig(), 0, this.$forceSinglePick, null, -9));
            Set r113 = (Set) this.this$0.getSelectionManager().f364705g.getValue();
            if (r113 == null) goto L11;
            List r114 = CollectionsKt.toList(r113);
        L12:
            if (r114 != null) goto L15;
            r114 = CollectionsKt.emptyList();
        L15:
            if (this.$forceSinglePick == true) goto L17;
            Integer r115 = MediaGalleryLiveDataViewModel.access$getMaxSelectCountBeforeForceSingle$p(this.this$0);
            if (r115 == null) goto L36;
            int r116 = r115.intValue();
        L37:
            MediaGalleryLiveDataViewModel.access$setMaxSelectCountBeforeForceSingle$p(this.this$0, null);
            this.this$0.getSelectionManager().m(r116);
            goto L39
        L36:
            r116 = this.this$0.getUiConfig().f364486c;
            goto L37
        L17:
            if (MediaGalleryLiveDataViewModel.access$getMaxSelectCountBeforeForceSingle$p(this.this$0) != null) goto L19;
            MediaGalleryLiveDataViewModel r104 = this.this$0;
            MediaGalleryLiveDataViewModel.access$setMaxSelectCountBeforeForceSingle$p(r104, Boxing.boxInt(r104.getUiConfig().f364486c));
        L19:
            this.this$0.getSelectionManager().m(1);
            if (r114.size() <= 1) goto L39;
            r103 = (op9.d) CollectionsKt.last(r114);
            op9.c r105 = (op9.c) MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).getValue();
            if (r105 == null) goto L32;
            MediaGalleryLiveDataViewModel r106 = this.this$0;
            Iterator r107 = r114.iterator();
        L25:
            if (r107.hasNext() == false) goto L27;
            MediaGalleryLiveDataViewModel.access$refreshCurFolderSelectedStatus(r106, r105, (op9.d) r107.next(), false, 0);
            goto L25
        L27:
            MediaGalleryLiveDataViewModel.access$get_currentFolder$p(this.this$0).postValue(r105);
            CoroutineDispatcher r108 = Dispatchers.getDefault();
            AnonymousClass2 r109 = new AnonymousClass2(this.this$0, r105, r114, null);
            this.L$0 = r103;
            this.label = 1;
            if (BuildersKt.withContext(r108, r109, this) != r100) goto L30;
            return r100;
        L30:
            r102 = r103;
            goto L31
        L11:
            r114 = null;
            goto L12
        }
    }

    public static /* synthetic */ Unit Mo(MediaGalleryLiveDataViewModel r100, MediaGalleryUIConfig r101, List r102) {
        return init$lambda$9(r100, r101, r102);
    }

    public static /* synthetic */ boolean yo(Uri r100, op9.d r101) {
        return removeSelectionByUri$lambda$14(r100, r101);
    }

    public final boolean canShowTabs() {
        if (this.uiConfig.f364484a.size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void closeTitleFolderEntrance() {
        this.closeTitleFolder.setValue(Boolean.TRUE);
    }

    public final List<Uri> initialSelectionUris() {
        g r100 = g.f469794a;
        InputDraftSnapshot r101 = g.d(this.uiConfig.f364503t);
        if (r101 == null) goto L5;
        List<AttachmentSnapshot> r102 = r101.getAttachments();
    L6:
        if (r102 != null) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L33;
        AttachmentSnapshot r105 = (AttachmentSnapshot) r104.next();
        String r106 = r105.getExtra().get("preview_attachment_source_media_uri");
        boolean r107 = true;
        if (r106 != null) goto L14;
    L19:
        ResourceRef r108 = r105.effectiveRef();
        if (r108 != null) goto L22;
    L30:
        r106 = null;
    L31:
        if (r106 == null) goto L10;
        r103.add(r106);
        goto L10
    L22:
        if (r108.getKind() == ResourceRefKind.LOCAL_URI) goto L25;
        r107 = false;
    L25:
        if (r107 == true) goto L28;
        r108 = null;
    L28:
        if (r108 == null) goto L30;
        r106 = r108.getUri();
        goto L31
    L14:
        if ((!StringsKt.isBlank(r106)) == true) goto L17;
        r106 = null;
    L17:
        if (r106 == null) goto L19;
    L33:
        List r109 = CollectionsKt.plus(r103, this.uiConfig.f364505v);
        ArrayList r110 = new ArrayList();
        Iterator r111 = r109.iterator();
    L35:
        if (r111.hasNext() == false) goto L48;
        String r112 = (String) r111.next();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L39
        Object r114 = Result.m9449constructorimpl(UriProtector.parse(r112));     // Catch: Throwable -> L39
    L42:
        if (Result.m9455isFailureimpl(r114) == false) goto L44;
        r114 = null;
    L44:
        Uri r115 = (Uri) r114;
        if (r115 == null) goto L35;
        r110.add(r115);
    L39:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L42
    L48:
        return CollectionsKt.distinct(r110);
    L5:
        r102 = null;
        goto L6
    }

    public final void setFirstFolder() {
        List<op9.c> r100 = this._folders.getValue();
        if (r100 == null) goto L12;
        op9.c r101 = (op9.c) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L13;
        int r102 = e0.f364440a;
        String r103 = this.TAG;
        StringBuilder r104 = new StringBuilder("setFirstFolder: ");
        mp9.b r105 = r101.f524788b;
        if (r105 == null) goto L9;
        String r106 = r105.f514727b;
    L10:
        r104.append(r106);
        e0.d(r103, r104.toString());
        refreshFolderSelectableByType(r101);
        this._currentFolder.setValue(r101);
        return;
    L9:
        r106 = null;
        goto L10
    L13:
        return;
    }

    public MediaGalleryLiveDataViewModel() {
        this.TAG = "MediaGalleryLiveDataViewModel";
        this.uiConfig = MediaGalleryUIConfig.G.a();
        this.nonUiSettings = MediaNonUISettings.f364536f;
        this.lazyLoadConfig = LazyLoadConfig.f364366e;
        MutableLiveData<List<op9.c>> r100 = new MutableLiveData(CollectionsKt.emptyList());
        this._folders = r100;
        this.folders = r100;
        MutableLiveData<op9.c> r101 = new MutableLiveData();
        this._currentFolder = r101;
        this.currentFolder = r101;
        this.currentTab = MediaTab.ALL;
        MutableLiveData<List<op9.d>> r102 = new MutableLiveData();
        this._fastMediaItems = r102;
        this.fastMediaItems = r102;
        this.enterPreviewPageEntryMode = EntryMode.INIT;
        this.showPreviewFragment = new MutableLiveData();
        this.currentPreviewItems = new MutableLiveData();
        this.enterOrExitPreviewPage = new MutableLiveData();
        this.capturePositionViewRect = new MutableLiveData();
        this.closeTitleFolder = new MutableLiveData();
        this.selectionManager = new d();
        this.initialSelectionRestoreCompleted = true;
    }

    private final void restoreInitialSelection() {
        List<Uri> r100 = initialSelectionUris();
        if (r100.isEmpty() == false) goto L6;
        this.initialSelectionRestoreCompleted = true;
        return;
    L6:
        this.initialSelectionRestoreCompleted = false;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C115031(this, r100, null), 3, null);
    }

    public final void clearSelection() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void initMediaFolders() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C114991(this, null), 3, null);
    }

    public final void refreshMediaFoldersAfterPermissionChange() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C115011(this, null), 3, null);
    }

    public final MutableLiveData<op9.a> getCapturePositionViewRect() {
        return this.capturePositionViewRect;
    }

    public final MutableLiveData<Boolean> getCloseTitleFolder() {
        return this.closeTitleFolder;
    }

    public final int getCurPreviewPosition() {
        return this.curPreviewPosition;
    }

    public final LiveData<op9.c> getCurrentFolder() {
        return this.currentFolder;
    }

    public final MutableLiveData<List<op9.d>> getCurrentPreviewItems() {
        return this.currentPreviewItems;
    }

    public final MediaTab getCurrentTab() {
        return this.currentTab;
    }

    public final MutableLiveData<Pair<Boolean, Integer>> getEnterOrExitPreviewPage() {
        return this.enterOrExitPreviewPage;
    }

    public final EntryMode getEnterPreviewPageEntryMode() {
        return this.enterPreviewPageEntryMode;
    }

    public final LiveData<List<op9.d>> getFastMediaItems() {
        return this.fastMediaItems;
    }

    public final LiveData<List<op9.c>> getFolders() {
        return this.folders;
    }

    public final LazyLoadConfig getLazyLoadConfig() {
        return this.lazyLoadConfig;
    }

    public final MediaNonUISettings getNonUiSettings() {
        return this.nonUiSettings;
    }

    public final d getSelectionManager() {
        return this.selectionManager;
    }

    public final MutableLiveData<Boolean> getShowPreviewFragment() {
        return this.showPreviewFragment;
    }

    public final MediaGalleryUIConfig getUiConfig() {
        return this.uiConfig;
    }

    public final boolean isInitialSelectionRestoreCompleted() {
        return this.initialSelectionRestoreCompleted;
    }

    public final boolean isInjectInputMode() {
        return this.injectInputMode;
    }

    public final boolean isNeedAnimWhenEnterPreview() {
        return this.isNeedAnimWhenEnterPreview;
    }

    public static final /* synthetic */ MediaTab access$getCurrentTab$p(MediaGalleryLiveDataViewModel r100) {
        return r100.currentTab;
    }

    public static final /* synthetic */ Integer access$getMaxSelectCountBeforeForceSingle$p(MediaGalleryLiveDataViewModel r100) {
        return r100.maxSelectCountBeforeForceSingle;
    }

    public static final /* synthetic */ com.larus.photopicker.v2.impl.data.d access$getMediaRepository$p(MediaGalleryLiveDataViewModel r100) {
        return r100.mediaRepository;
    }

    public static final /* synthetic */ String access$getTAG$p(MediaGalleryLiveDataViewModel r100) {
        return r100.TAG;
    }

    public static final /* synthetic */ MutableLiveData access$get_currentFolder$p(MediaGalleryLiveDataViewModel r100) {
        return r100._currentFolder;
    }

    public static final /* synthetic */ MutableLiveData access$get_fastMediaItems$p(MediaGalleryLiveDataViewModel r100) {
        return r100._fastMediaItems;
    }

    public static final /* synthetic */ MutableLiveData access$get_folders$p(MediaGalleryLiveDataViewModel r100) {
        return r100._folders;
    }

    private final List<op9.d> buildFastUIMediaItems(List<mp9.c> r110) {
        if (r110.isEmpty() == true) goto L5;
        Set r100 = (Set) this.selectionManager.f364705g.getValue();
        if (r100 == null) goto L16;
        Set r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
        int r104 = 0;
    L10:
        if (r103.hasNext() == false) goto L15;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        r102.add(TuplesKt.to(Long.valueOf(((op9.d) r105).f524790a.f514732a), Integer.valueOf(r106)));
        r104 = r106;
        goto L10
    L15:
        Map r107 = MapsKt.toMap(r102);
    L17:
        if (r107 != null) goto L19;
        r107 = MapsKt.emptyMap();
    L19:
        List<mp9.c> r111 = r110;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L21:
        if (r112.hasNext() == false) goto L30;
        mp9.c r109 = (mp9.c) r112.next();
        Integer r113 = (Integer) r107.get(Long.valueOf(r109.f514732a));
        if (r113 == null) goto L25;
        int r114 = r113.intValue();
    L26:
        if (r114 <= 0) goto L28;
        boolean r115 = true;
    L29:
        op9.d r116 = op9.e.c(r109, r115, r114);
        r108.add(op9.d.a(r116, null, false, 0, this.selectionManager.f(r116), 15));
        goto L21
    L28:
        r115 = false;
        goto L29
    L25:
        r114 = 0;
        goto L26
    L30:
        return r108;
    L16:
        r107 = null;
        goto L17
    L5:
        return CollectionsKt.emptyList();
    }

    private final void refreshFolderSelectableByType(op9.c r110) {
        Iterator<T> r100 = this.uiConfig.f364484a.iterator();
    L4:
        if (r100.hasNext() == false) goto L19;
        MediaTab r101 = (MediaTab) r100.next();
        List<op9.d> r102 = r110.f524789c.get(r101);
        if (r102 == null) goto L4;
        if (r102.isEmpty() == true) goto L4;
        List<op9.d> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
        boolean r106 = false;
    L12:
        if (r105.hasNext() == false) goto L17;
        op9.d r107 = (op9.d) r105.next();
        boolean r111 = this.selectionManager.f(r107);
        if (r107.f524794e == r111) goto L16;
        r107 = op9.d.a(r107, null, false, 0, r111, 15);
        r106 = true;
    L16:
        r104.add(r107);
        goto L12
    L17:
        if (r106 == false) goto L4;
        r110.f524789c.put(r101, r104);
        goto L4
    }

    public final int getCurMediaItemPositionInPreview(op9.d r110) {
        Intrinsics.checkNotNullParameter(r110, "mediaItem");
        List<op9.d> r100 = this.currentPreviewItems.getValue();
        if (r100 == null) goto L14;
        Iterator<op9.d> r101 = r100.iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L18;
        if (r101.next().f524790a.f514732a != r110.f524790a.f514732a) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L17;
        r102 = r102 + 1;
        goto L6
    L17:
        return r102;
    L10:
        r103 = false;
        goto L11
    L18:
        return -1;
    L14:
        return -1;
    }

    public final void initFastMediaItems(long r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C114981(this, r100, null), 3, null);
    }

    public final boolean insertMediaItemAndSelect(mp9.c r110) {
        Intrinsics.checkNotNullParameter(r110, "mediaItem");
        List<op9.c> r100 = this._folders.getValue();
        if (r100 == null) goto L102;
        op9.c r101 = (op9.c) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L102;
        long r102 = r101.f524787a;
        op9.c r103 = this._currentFolder.getValue();
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L14;
        setFirstFolder();
    L14:
        MediaTab r105 = (MediaTab) CollectionsKt.firstOrNull(this.uiConfig.f364484a);
        if (r105 != null) goto L17;
        r105 = MediaTab.ALL;
    L17:
        op9.c r106 = this._currentFolder.getValue();
        if (r106 != null) goto L20;
        return false;
    L20:
        List<op9.d> r107 = r106.f524789c.get(r105);
        if (r107 != null) goto L23;
        r107 = CollectionsKt.emptyList();
    L23:
        Iterator<T> r108 = r107.iterator();
    L24:
        Object r109 = null;
        if (r108.hasNext() == false) goto L35;
        Object r111 = r108.next();
        mp9.c r112 = ((op9.d) r111).f524790a;
        if (r112.f514732a != r110.f514732a) goto L29;
    L32:
        boolean r113 = true;
    L33:
        if (r113 == false) goto L24;
    L36:
        op9.d r114 = (op9.d) r111;
        if (r114 != null) goto L39;
        com.larus.photopicker.v2.impl.data.d r115 = this.mediaRepository;
        if (r115 != null) goto L45;
        return false;
    L45:
        List<mp9.b> r116 = r115.h(r110);
        if (r116 != null) goto L48;
        return false;
    L48:
        List<op9.c> r117 = this._folders.getValue();
        if (r117 != null) goto L51;
        r117 = CollectionsKt.emptyList();
    L51:
        List<mp9.b> r118 = r116;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator r120 = r118.iterator();
    L53:
        if (r120.hasNext() == false) goto L66;
        mp9.b r121 = (mp9.b) r120.next();
        Iterator<T> r122 = r117.iterator();
    L56:
        if (r122.hasNext() == false) goto L64;
        Object r123 = r122.next();
        Iterator r124 = r120;
        if (((op9.c) r123).f524787a != r121.f514726a) goto L60;
        boolean r125 = true;
    L61:
        if (r125 == true) goto L65;
        r120 = r124;
    L65:
        r119.add(op9.e.b(r121, (op9.c) r123, this.selectionManager));
        r120 = r124;
        goto L53
    L60:
        r125 = false;
        goto L61
    L64:
        r124 = r120;
        r123 = null;
        goto L65
    L66:
        this._folders.setValue(r119);
        Iterator r126 = r119.iterator();
    L68:
        if (r126.hasNext() == false) goto L75;
        Object r127 = r126.next();
        if (((op9.c) r127).f524787a != r102) goto L72;
        boolean r128 = true;
    L73:
        if (r128 == false) goto L68;
    L76:
        op9.c r129 = (op9.c) r127;
        if (r129 != null) goto L80;
        return true;
    L80:
        this._currentFolder.setValue(r129);
        List<op9.d> r130 = r129.f524789c.get(r105);
        if (r130 != null) goto L83;
        r130 = CollectionsKt.emptyList();
    L83:
        Iterator<T> r131 = r130.iterator();
    L85:
        if (r131.hasNext() == false) goto L95;
        Object r132 = r131.next();
        mp9.c r133 = ((op9.d) r132).f524790a;
        if (r133.f514732a != r110.f514732a) goto L89;
    L92:
        boolean r134 = true;
    L93:
        if (r134 == false) goto L85;
        r109 = r132;
        goto L95
    L89:
        if (Intrinsics.areEqual(r133.f514733b, r110.f514733b) == true) goto L92;
        r134 = false;
    L95:
        op9.d r135 = (op9.d) r109;
        if (r135 != null) goto L98;
        return true;
    L98:
        if (this.selectionManager.g(r135.f524790a.f514732a) == true) goto L123;
        toggleSelection(r135);
        return true;
    L123:
        return true;
    L72:
        r128 = false;
        goto L73
    L75:
        r127 = null;
        goto L76
    L39:
        if (this.selectionManager.g(r114.f524790a.f514732a) == true) goto L41;
        toggleSelection(r114);
    L41:
        return true;
    L29:
        if (Intrinsics.areEqual(r112.f514733b, r110.f514733b) == true) goto L32;
        r113 = false;
        goto L33
    L35:
        r111 = null;
        goto L36
    L9:
        if (r103.f524787a != r102) goto L11;
        r104 = true;
    L102:
        return false;
    }

    public final void loadMore(MediaTab r110) {
        Intrinsics.checkNotNullParameter(r110, "mediaTab");
        int r100 = e0.f364440a;
        String r101 = this.TAG;
        StringBuilder r102 = new StringBuilder("1.loadMore curFolder: ");
        op9.c r103 = this._currentFolder.getValue();
        if (r103 == null) goto L7;
        mp9.b r104 = r103.f524788b;
        if (r104 == null) goto L7;
        String r105 = r104.f514727b;
    L8:
        r102.append(r105);
        r102.append(", curTab: ");
        r102.append(this.currentTab);
        r102.append(", curMediaTab: ");
        r102.append(r110);
        r102.append(", curMediaList: ");
        op9.c r106 = this._currentFolder.getValue();
        if (r106 == null) goto L15;
        Map<MediaTab, List<op9.d>> r107 = r106.f524789c;
        if (r107 == null) goto L15;
        List<op9.d> r108 = r107.get(this.currentTab);
        if (r108 == null) goto L15;
        Integer r109 = Integer.valueOf(r108.size());
    L16:
        r102.append(r109);
        e0.d(r101, r102.toString());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C115001(this, r110, null), 3, null);
        return;
    L15:
        r109 = null;
    L7:
        r105 = null;
        goto L8
    }

    public final void setAllowReplaceWhenSingle(boolean r100) {
        d r101 = this.selectionManager;
        r101.getClass();
        int r102 = e0.f364440a;
        e0.d("SelectionManager", "setAllowReplaceWhenSingle: enable: " + r100);
        r101.f364710l = r100;
        if (r100 == false) goto L6;
        r101.f364706h.setValue(Boolean.TRUE);
        return;
    }

    public final void setCurPreviewPosition(int r100) {
        this.curPreviewPosition = r100;
    }

    public final void setCurrentFolder(long r100) {
        List<op9.c> r101 = this._folders.getValue();
        if (r101 == null) goto L26;
        Iterator<T> r102 = r101.iterator();
    L5:
        String r103 = null;
        if (r102.hasNext() == false) goto L13;
        Object r104 = r102.next();
        if (((op9.c) r104).f524787a != r100) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L5;
    L14:
        op9.c r106 = (op9.c) r104;
        if (r106 == null) goto L27;
        int r107 = e0.f364440a;
        String r108 = this.TAG;
        StringBuilder r109 = new StringBuilder("setCurrentFolder: ");
        mp9.b r110 = r106.f524788b;
        if (r110 == null) goto L19;
        r103 = r110.f514727b;
    L19:
        r109.append(r103);
        e0.d(r108, r109.toString());
        refreshFolderSelectableByType(r106);
        this._currentFolder.setValue(r106);
        return;
    L27:
        return;
    L10:
        r105 = false;
        goto L11
    L13:
        r104 = null;
        goto L14
    }

    public final void setCurrentTab(MediaTab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        this.currentTab = r100;
    }

    public final void setEnterPreviewPageEntryMode(EntryMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterPreviewPageEntryMode = r100;
    }

    public final void setInjectInputMode(boolean r100) {
        this.injectInputMode = r100;
    }

    public final void setLazyLoadConfig(LazyLoadConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lazyLoadConfig = r100;
    }

    public final void setNeedAnimWhenEnterPreview(boolean r100) {
        this.isNeedAnimWhenEnterPreview = r100;
    }

    public final void setNonUiSettings(MediaNonUISettings r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nonUiSettings = r100;
    }

    public final void setUiConfig(MediaGalleryUIConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uiConfig = r100;
    }

    public final void toggleSelection(op9.d r100) {
        Intrinsics.checkNotNullParameter(r100, "curSelectedMediaItem");
        setSelectionImmediately(r100, !this.selectionManager.g(r100.f524790a.f514732a));
    }

    public final void updateForceSinglePick(boolean r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C115051(this, r100, null), 3, null);
    }

    public final void updateMaxSelectCount(int r100) {
        MediaGalleryUIConfig r101 = MediaGalleryUIConfig.a(this.uiConfig, r100, false, null, -5);
        this.uiConfig = r101;
        if (r101.f364487d == false) goto L5;
        this.maxSelectCountBeforeForceSingle = Integer.valueOf(r100);
        this.selectionManager.m(1);
    L6:
        op9.c r102 = this._currentFolder.getValue();
        if (r102 == null) goto L10;
        refreshFolderSelectableByType(r102);
        this._currentFolder.setValue(r102);
        return;
    L10:
        return;
    L5:
        this.selectionManager.m(r100);
        goto L6
    }

    public static final /* synthetic */ List access$buildFastUIMediaItems(MediaGalleryLiveDataViewModel r100, List r101) {
        return r100.buildFastUIMediaItems(r101);
    }

    public static final /* synthetic */ void access$refreshFolderSelectableByType(MediaGalleryLiveDataViewModel r100, op9.c r101) {
        r100.refreshFolderSelectableByType(r101);
    }

    public static final /* synthetic */ void access$setInitialSelectionRestoreCompleted$p(MediaGalleryLiveDataViewModel r100, boolean r101) {
        r100.initialSelectionRestoreCompleted = r101;
    }

    public static final /* synthetic */ void access$setMaxSelectCountBeforeForceSingle$p(MediaGalleryLiveDataViewModel r100, Integer r101) {
        r100.maxSelectCountBeforeForceSingle = r101;
    }

    private final void removeSelectionByPredicate(Function1<? super op9.d, Boolean> r100, Function1<? super op9.d, Unit> r101) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C115021(this, r100, r101, null), 3, null);
    }

    private static final boolean removeSelectionByUri$lambda$14(Uri r100, op9.d r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        if (Intrinsics.areEqual(r101.f524790a.f514733b, r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r101.f524790a.f514733b.toString(), r100.toString()) == true) goto L8;
        return false;
    }

    public final void enterPreviewMediaPage(op9.d r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "mediaItem");
        op9.c r102 = this._currentFolder.getValue();
        List<op9.d> r103 = null;
        if (r102 == null) goto L7;
        Map<MediaTab, List<op9.d>> r104 = r102.f524789c;
        if (r104 == null) goto L7;
        List<op9.d> r105 = r104.get(this.currentTab);
    L8:
        if (r105 != null) goto L10;
        r105 = CollectionsKt.emptyList();
    L10:
        List<op9.d> r106 = this._fastMediaItems.getValue();
        if (r106 != null) goto L14;
        r106 = CollectionsKt.emptyList();
    L14:
        if ((!r105.isEmpty()) == false) goto L16;
        List<op9.d> r107 = r105;
    L17:
        if (r107 == null) goto L19;
        r103 = r107;
    L22:
        List<op9.d> r108 = r103;
        if (r108 != null) goto L25;
    L28:
        boolean r109 = true;
    L29:
        if (r109 == false) goto L33;
        int r110 = e0.f364440a;
        e0.c(this.TAG, "enterPreviewMediaPage preview list is null or empty, position: " + r101);
        return;
    L33:
        if (r105.isEmpty() == false) goto L35;
        int r111 = e0.f364440a;
        e0.d(this.TAG, "enterPreviewMediaPage fallback fastMediaItems, position=" + r101 + ", fastSize=" + r106.size());
        reportCurrentFolderNotReady("enter_preview", r100, r106.size());
    L35:
        this.enterPreviewPageEntryMode = EntryMode.NORMAL;
        this.currentPreviewItems.setValue(r103);
        this.curPreviewPosition = resolvePreviewPosition(r103, r100, r101);
        this.isNeedAnimWhenEnterPreview = true;
        this.showPreviewFragment.setValue(Boolean.TRUE);
        return;
    L25:
        if (r108.isEmpty() == true) goto L28;
        r109 = false;
        goto L29
    L19:
        if ((!r106.isEmpty()) == false) goto L22;
        r103 = r106;
        goto L22
    L16:
        r107 = null;
    L7:
        r105 = null;
        goto L8
    }

    public final void enterPreviewMediaPageFromBottomSelector(op9.d r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "mediaItem");
        Set r102 = (Set) this.selectionManager.f364705g.getValue();
        if (r102 == null) goto L6;
        List<op9.d> r103 = CollectionsKt.toList(r102);
        if (r103 == null) goto L6;
    L8:
        if (r103.isEmpty() == false) goto L11;
        int r104 = e0.f364440a;
        e0.c(this.TAG, "enterPreviewMediaPageFromBottomSelector preview list is null or empty, position: " + r101);
        return;
    L11:
        this.enterPreviewPageEntryMode = EntryMode.BOTTOM;
        this.currentPreviewItems.setValue(r103);
        this.curPreviewPosition = r101;
        this.isNeedAnimWhenEnterPreview = true;
        this.showPreviewFragment.setValue(Boolean.TRUE);
        return;
    L6:
        r103 = CollectionsKt.emptyList();
        goto L8
    }

    public final Object queryMediaItem(String r100, Continuation<? super mp9.c> r101) {
        com.larus.photopicker.v2.impl.data.d r102 = this.mediaRepository;
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.a(r100, r101);
    }

    public final void removeSelectionByUri(final Uri r100, Function1<? super op9.d, Unit> r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100, Uri.EMPTY) == true) goto L9;
        removeSelectionByPredicate(new com.larus.photopicker.v2.impl.viewmodel.a(r100), r101);
        return;
    }

    public final boolean setSelectionImmediately(op9.d r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "curSelectedMediaItem");
        if (this.selectionManager.g(r110.f524790a.f514732a) != r111) goto L6;
        return true;
    L6:
        if (r111 == true) goto L8;
    L10:
        boolean r100 = this.selectionManager.l(r110);
        if (r100 == r111) goto L13;
        return false;
    L13:
        Set r101 = (Set) this.selectionManager.f364705g.getValue();
        if (r101 == null) goto L16;
        List<op9.d> r102 = CollectionsKt.toList(r101);
    L17:
        if (r102 != null) goto L19;
        r102 = CollectionsKt.emptyList();
    L19:
        List<op9.d> r103 = r102;
        op9.c r104 = this._currentFolder.getValue();
        if (r104 != null) goto L26;
        refreshFastMediaSelectedStatus(r110, r100, r103);
        List<op9.d> r105 = this._fastMediaItems.getValue();
        if (r105 != null) goto L24;
        r105 = CollectionsKt.emptyList();
    L24:
        reportCurrentFolderNotReady("set_selection_immediately", r110, r105.size());
        return true;
    L26:
        refreshCurFolderSelectedStatus(r104, r110, r100, r103);
        refreshFolderSelectableByType(r104);
        this._currentFolder.setValue(r104);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C115041(this, r104, r110, r100, r103, null), 3, null);
        return true;
    L16:
        r102 = null;
        goto L17
    L8:
        if (this.selectionManager.a(r110) == true) goto L10;
        return false;
    }

    private static final Unit init$lambda$9(MediaGalleryLiveDataViewModel r110, MediaGalleryUIConfig r111, List r112) {
        int r100 = e0.f364440a;
        e0.d(r110.TAG, "1. Repository folder change, total " + r112.size() + " folders");
        List<op9.c> r101 = r110._folders.getValue();
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        Object r102 = null;
        if (r101.isEmpty() == false) goto L11;
        e0.d(r110.TAG, "2.1 Full update folders");
        Intrinsics.checkNotNull(r112);
        List r103 = r112;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L9:
        if (r105.hasNext() == false) goto L58;
        r104.add(op9.e.b((mp9.b) r105.next(), null, r110.selectionManager));
    L58:
        if ((!r104.isEmpty()) == false) goto L83;
        op9.c r106 = r110._currentFolder.getValue();
        if (r106 == null) goto L62;
        long r107 = r106.f524787a;
    L63:
        int r108 = e0.f364440a;
        String r109 = r110.TAG;
        StringBuilder r113 = new StringBuilder("3. [Start]Update current folder=");
        r113.append(r107);
        r113.append(", ");
        op9.c r114 = r110._currentFolder.getValue();
        if (r114 == null) goto L68;
        mp9.b r115 = r114.f524788b;
        if (r115 == null) goto L68;
        String r116 = r115.f514727b;
    L69:
        r113.append(r116);
        e0.d(r109, r113.toString());
        Iterator r117 = r104.iterator();
    L71:
        if (r117.hasNext() == false) goto L78;
        Object r118 = r117.next();
        if (((op9.c) r118).f524787a != r107) goto L75;
        boolean r119 = true;
    L76:
        if (r119 == false) goto L71;
        r102 = r118;
        goto L78
    L75:
        r119 = false;
    L78:
        op9.c r120 = (op9.c) r102;
        if (r120 != null) goto L81;
        int r121 = e0.f364440a;
        e0.c(r110.TAG, "3.2 [End]Update current folder=" + r107 + ", not found, maybe deleted");
        r120 = (op9.c) CollectionsKt.first(r104);
    L81:
        int r122 = e0.f364440a;
        e0.d(r110.TAG, "3.1 [End]Update current folder=" + r107 + ", " + r120.f524788b.f514727b);
        r110.refreshFolderSelectableByType(r120);
        r110._currentFolder.setValue(r120);
        r110._folders.setValue(r104);
    L68:
        r116 = null;
        goto L69
    L62:
        r107 = ((op9.c) CollectionsKt.first(r104)).f524787a;
    L83:
        return Unit.INSTANCE;
    L11:
        e0.d(r110.TAG, "2.2 Diff update folders");
        Intrinsics.checkNotNull(r112);
        List r123 = r112;
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
        Iterator r125 = r123.iterator();
    L13:
        if (r125.hasNext() == false) goto L56;
        mp9.b r126 = (mp9.b) r125.next();
        Iterator<T> r127 = r101.iterator();
    L16:
        if (r127.hasNext() == false) goto L23;
        Object r128 = r127.next();
        if (((op9.c) r128).f524787a != r126.f514726a) goto L20;
        boolean r129 = true;
    L21:
        if (r129 == false) goto L16;
    L24:
        op9.c r130 = (op9.c) r128;
        if (r130 != null) goto L27;
        r130 = op9.e.b(r126, null, r110.selectionManager);
    L55:
        r124.add(r130);
        goto L13
    L27:
        List<MediaTab> r131 = r111.f364484a;
        if ((r131 instanceof Collection) == true) goto L30;
    L32:
        Iterator<T> r132 = r131.iterator();
    L34:
        if (r132.hasNext() == false) goto L52;
        MediaTab r133 = (MediaTab) r132.next();
        List<mp9.c> r134 = r126.f514731f.get(r133);
        if (r134 != null) goto L38;
        r134 = CollectionsKt.emptyList();
    L38:
        List<mp9.c> r135 = r134;
        ArrayList r136 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        Iterator<T> r137 = r135.iterator();
    L40:
        if (r137.hasNext() == false) goto L42;
        r136.add(Long.valueOf(((mp9.c) r137.next()).f514732a));
        goto L40
    L42:
        List<op9.d> r138 = r130.f524789c.get(r133);
        if (r138 != null) goto L45;
        r138 = CollectionsKt.emptyList();
    L45:
        List<op9.d> r139 = r138;
        ArrayList r140 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r139, 10));
        Iterator<T> r141 = r139.iterator();
    L47:
        if (r141.hasNext() == false) goto L50;
        r140.add(Long.valueOf(((op9.d) r141.next()).f524790a.f514732a));
        goto L47
    L50:
        if ((!Intrinsics.areEqual(r136, r140)) == false) goto L34;
        boolean r142 = true;
    L53:
        if (r142 == false) goto L55;
        r130 = op9.e.b(r126, r130, r110.selectionManager);
    L52:
        r142 = false;
        goto L53
    L30:
        if (r131.isEmpty() == false) goto L32;
    L20:
        r129 = false;
        goto L21
    L23:
        r128 = null;
        goto L24
    L56:
        r104 = r124;
        goto L58
    }

    private final void refreshFastMediaSelectedStatus(op9.d r100, boolean r101, List<op9.d> r102) {
        MutableLiveData<List<op9.d>> r103 = this._fastMediaItems;
        List<op9.d> r104 = r103.getValue();
        if (r104 != null) goto L5;
        r104 = CollectionsKt.emptyList();
    L5:
        r103.setValue(refreshMediaItemsSelectedStatus(r104, r100, r101, r102));
        List<op9.d> r105 = this.currentPreviewItems.getValue();
        if (r105 != null) goto L8;
        return;
    L8:
        if ((!r105.isEmpty()) == true) goto L11;
        r105 = null;
    L11:
        if (r105 == null) goto L15;
        this.currentPreviewItems.setValue(refreshMediaItemsSelectedStatus(r105, r100, r101, r102));
        return;
    }

    private final void reportCurrentFolderNotReady(String r100, op9.d r101, int r102) {
        Lazy r103 = i.f530229a;
        JSONObject r104 = new JSONObject();
        r104.put("is_success", 1);
        r104.put("data_type", "current_folder_not_ready");
        r104.put("action", r100);
        r104.put("fast_media_size", r102);
        r104.put(AppConstants.BUNDLE_MEDIA_ID, r101.f524790a.f514732a);
        r104.put("tab", this.currentTab.getMobName());
        i.b(r104);
    }

    private final int resolvePreviewPosition(List<op9.d> r100, op9.d r110, int r111) {
        Iterator<op9.d> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        if (r101.next().f524790a.f514732a != r110.f524790a.f514732a) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        r102 = r102 + 1;
    L13:
        if (r102 < 0) goto L16;
        return r102;
    L16:
        return RangesKt.coerceIn(r111, 0, CollectionsKt.getLastIndex(r100));
    L8:
        r103 = false;
        goto L9
    L12:
        r102 = -1;
        goto L13
    }

    public static /* synthetic */ void initFastMediaItems$default(MediaGalleryLiveDataViewModel r100, long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 300;
    L5:
        r100.initFastMediaItems(r101);
    }

    private final void refreshCurFolderSelectedStatus(op9.c r210, op9.d r211, boolean r212, int r213) {
        com.larus.photopicker.v2.impl.data.d r100 = this.mediaRepository;
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<T> r101 = this.uiConfig.f364484a.iterator();
    L7:
        if (r101.hasNext() == false) goto L21;
        MediaTab r110 = (MediaTab) r101.next();
        List<op9.d> r111 = r210.f524789c.get(r110);
        if (r111 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L7;
        int r103 = r100.c(r210.f524787a, r110, r211.f524790a.f514732a);
        if (r103 < 0) goto L7;
        List<op9.d> r104 = CollectionsKt.toMutableList(r111);
        ListProtector.set(r104, r103, op9.d.a((op9.d) ListProtector.get(r104, r103), null, r212, r213, false, 25));
        r210.f524789c.put(r110, r104);
        goto L7
    L11:
        if (r111.isEmpty() == true) goto L14;
        r102 = false;
        goto L15
    }

    private final List<op9.d> refreshMediaItemsSelectedStatus(List<op9.d> r110, op9.d r111, boolean r112, List<op9.d> r113) {
        if (r110.isEmpty() == false) goto L5;
        return r110;
    L5:
        List<op9.d> r100 = r113;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L12;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        r101.add(TuplesKt.to(Long.valueOf(((op9.d) r104).f524790a.f514732a), Integer.valueOf(r105)));
        r103 = r105;
        goto L7
    L12:
        Map r106 = MapsKt.toMap(r101);
        List<op9.d> r107 = r110;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
        boolean r114 = false;
    L14:
        if (r109.hasNext() == false) goto L50;
        op9.d r115 = (op9.d) r109.next();
        Integer r116 = (Integer) r106.get(Long.valueOf(r115.f524790a.f514732a));
        if (r116 == null) goto L18;
        int r117 = r116.intValue();
    L20:
        if (r117 > 0) goto L27;
        if (r115.f524790a.f514732a != r111.f524790a.f514732a) goto L25;
        if (r112 == true) goto L27;
    L25:
        boolean r118 = false;
    L28:
        if (r118 == false) goto L40;
        Integer r119 = Integer.valueOf(r117);
        if (r119.intValue() <= 0) goto L32;
        boolean r120 = true;
    L33:
        if (r120 == true) goto L36;
        r119 = null;
    L36:
        if (r119 == null) goto L38;
        int r121 = r119.intValue();
    L39:
        int r122 = r121;
    L41:
        boolean r123 = this.selectionManager.f(r115);
        if (r115.f524791b == r118) goto L44;
    L47:
        r115 = op9.d.a(r115, null, r118, r122, r123, 9);
        r114 = true;
    L48:
        r108.add(r115);
        goto L14
    L44:
        if (r115.f524792c != r122) goto L47;
        if (r115.f524794e == r123) goto L48;
    L38:
        r121 = r113.size();
        goto L39
    L32:
        r120 = false;
        goto L33
    L40:
        r122 = 0;
    L27:
        r118 = true;
        goto L28
    L18:
        r117 = 0;
        goto L20
    L50:
        if (r114 == false) goto L53;
        return r108;
    L53:
        return r110;
    }

    /* JADX WARN: Type inference failed for: r10v5, types: [com.larus.photopicker.v2.impl.viewmodel.b] */
    public final void init(com.larus.photopicker.v2.impl.data.d r100, LazyLoadConfig r110, final MediaGalleryUIConfig r111, MediaNonUISettings r112) {
        Intrinsics.checkNotNullParameter(r100, "mediaRepository");
        Intrinsics.checkNotNullParameter(r110, "lazyLoadConfig");
        Intrinsics.checkNotNullParameter(r111, "uiConfig");
        Intrinsics.checkNotNullParameter(r112, "nonUiSettings");
        this.mediaRepository = r100;
        this.lazyLoadConfig = r110;
        this.uiConfig = r111;
        this.nonUiSettings = r112;
        Iterator<T> r113 = r111.f364484a.iterator();
    L4:
        if (r113.hasNext() == false) goto L11;
        Object r101 = r113.next();
        if (((MediaTab) r101).getId() != r111.F) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L4;
    L12:
        MediaTab r103 = (MediaTab) r101;
        if (r103 != null) goto L17;
        r103 = (MediaTab) CollectionsKt.firstOrNull(r111.f364484a);
        if (r103 != null) goto L17;
        r103 = MediaTab.ALL;
    L17:
        this.currentTab = r103;
        d r114 = this.selectionManager;
        int r104 = r111.f364486c;
        boolean r105 = r111.f364490g;
        boolean r106 = r112.f364537a;
        int r107 = r112.f364538b;
        CreationReferenceAlbumConfig r108 = r112.f364539c;
        long r109 = r112.f364540d;
        r114.getClass();
        int r115 = e0.f364440a;
        e0.d("SelectionManager", "init: maxSelectCount: " + r104 + ", isSupportVideo: " + r105 + ", enableSeparateMediaSelection: " + r106 + ", maxSelectVideoCount: " + r107 + ", maxVideoDuration: " + r109);
        r114.f364699a = r104;
        r114.f364700b = r105;
        r114.f364701c = r106;
        r114.f364702d = r107;
        r114.f364711m = r108;
        r114.f364703e = r109;
        r114.n();
        restoreInitialSelection();
        r100.g().observeForever(new a(new b(this, r111)));
        return;
    L8:
        r102 = false;
        goto L9
    L11:
        r101 = null;
        goto L12
    }

    private final void refreshCurFolderSelectedStatus(op9.c r100, op9.d r101, boolean r102, List<op9.d> r103) {
        int r104 = 0;
        if (r102 == true) goto L5;
        refreshCurFolderSelectedStatus(r100, r101, false, 0);
    L5:
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        int r107 = r104 + 1;
        if (r104 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        refreshCurFolderSelectedStatus(r100, (op9.d) r106, true, r107);
        r104 = r107;
        goto L7
    }

    public static final /* synthetic */ void access$refreshCurFolderSelectedStatus(MediaGalleryLiveDataViewModel r100, op9.c r101, op9.d r102, boolean r103, int r104) {
        r100.refreshCurFolderSelectedStatus(r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void removeSelectionByPredicate$default(MediaGalleryLiveDataViewModel r100, Function1 r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.removeSelectionByPredicate(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void removeSelectionByUri$default(MediaGalleryLiveDataViewModel r100, Uri r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.removeSelectionByUri(r101, r102);
    }

    public static final /* synthetic */ void access$refreshCurFolderSelectedStatus(MediaGalleryLiveDataViewModel r100, op9.c r101, op9.d r102, boolean r103, List r104) {
        r100.refreshCurFolderSelectedStatus(r101, r102, r103, r104);
    }
}
