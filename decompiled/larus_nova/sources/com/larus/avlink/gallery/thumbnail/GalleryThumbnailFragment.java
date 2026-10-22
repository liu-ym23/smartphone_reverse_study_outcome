package com.larus.avlink.gallery.thumbnail;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.avlink.gallery.AlbumUtils;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.view.GridSpacingItemDecoration;
import com.larus.avlink.gallery.view.RecyclerViewSwipeMultiSelectHelper;
import com.larus.avlink.gallery.viewmodel.ThumbnailViewModel;
import com.larus.avlink.impl.databinding.LarusFragmentGalleryDetailBinding;
import com.larus.avlink.n1;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonVerticalDialog;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001'\b\u0007\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0003defB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001eJ&\u0010+\u001a\u0004\u0018\u00010\u000e2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00104\u001a\u00020*H\u0002J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020\u0016H\u0016J\b\u00107\u001a\u00020*H\u0016J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0002J\u0010\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u0019H\u0002J\u0010\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020%H\u0002J\b\u0010>\u001a\u00020*H\u0002J\b\u0010?\u001a\u00020*H\u0002J\u0018\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u0016H\u0002J\b\u0010C\u001a\u00020*H\u0002J\b\u0010D\u001a\u00020*H\u0002J\b\u0010E\u001a\u00020*H\u0002J\u0010\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020\u0016H\u0002J\b\u0010H\u001a\u00020*H\u0002J\b\u0010I\u001a\u00020*H\u0002J\b\u0010J\u001a\u00020\u0019H\u0002J\"\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00162\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010OH\u0002J\u000e\u0010P\u001a\u00020*H\u0082@¢\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u00020*2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TH\u0002J\b\u0010V\u001a\u00020*H\u0002J\b\u0010W\u001a\u00020*H\u0016J\b\u0010X\u001a\u00020*H\u0016J\b\u0010Y\u001a\u00020*H\u0016J\b\u0010Z\u001a\u00020*H\u0016J\u0010\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020\u0016H\u0016J\u0010\u0010]\u001a\u00020*2\u0006\u0010\\\u001a\u00020\u0016H\u0016J\b\u0010^\u001a\u00020*H\u0016J\b\u0010_\u001a\u00020*H\u0002J\u0010\u0010`\u001a\u00020*2\u0006\u0010a\u001a\u00020\u0016H\u0002J\u0018\u0010b\u001a\u00020*2\u0006\u0010a\u001a\u00020\u00162\u0006\u0010c\u001a\u00020\u0016H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006g"}, d2 = {"Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/larus/avlink/gallery/viewmodel/ThumbnailDataChangeListener;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusFragmentGalleryDetailBinding;", "viewModel", "Lcom/larus/avlink/gallery/viewmodel/ThumbnailViewModel;", "adapter", "Lcom/larus/avlink/gallery/thumbnail/ThumbnailListAdapter;", "syncBtn", "Landroid/widget/TextView;", "deleteBtn", "Landroid/view/View;", "cancelSelectBtn", "syncNumberText", "albumStateListener", "Lcom/larus/avlink/gallery/thumbnail/FlowAlbumCountChangeListener;", "sceneStateChangeListener", "Lcom/larus/avlink/common/SceneStateChangeListener;", "currentImageCount", "", "currentVideoCount", "isDeleteInProgress", "", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "isDismissRequested", "listener", "Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailListener;", "swipeMultiSelectHelper", "Lcom/larus/avlink/gallery/view/RecyclerViewSwipeMultiSelectHelper;", "swipeSelectionState", "Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailFragment$SwipeSelectionState;", "dismissDragEnabled", "defaultDimAmount", "", "bottomSheetCallback", "com/larus/avlink/gallery/thumbnail/GalleryThumbnailFragment$bottomSheetCallback$1", "Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailFragment$bottomSheetCallback$1;", "setListener", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "initViewModel", "initView", "getTheme", "dismiss", "initBottomSheetDialog", "setupBottomSheetDismissHotZone", "setBottomSheetDragEnabled", "enabled", "applyWindowDimAmount", "dimAmount", "setupObservers", "observeAlbumStateChanges", "updateSyncNumberText", DecodeProducer.EXTRA_IMAGE_COUNT, "videoCount", "showWarningBanner", "updateSyncButtonText", "updateDeleteButtonState", "updateBottomContainerAlpha", "selectedCount", "updateSelectBtn", "handleSyncButtonClick", "checkStorageSpace", "createDeleteConfirmDialog", "Landroidx/fragment/app/DialogFragment;", "deleteCount", "onConfirm", "Lkotlin/Function0;", "handleDeleteButtonClick", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performDelete", "selectedItems", "", "Lcom/larus/avlink/gallery/model/ThumbnailMetadata;", "restoreDeleteButton", WidgetCostModule.TYPE_ON_START, "onStop", "onResume", "onDataRefreshed", "onThumbnailDeleted", "count", "onThumbnailSynced", "onDestroyView", "setupSwipeMultiSelection", "beginSwipeSelection", "anchorPosition", "applySwipeSelection", "currentPosition", "Companion", "SwipeSelectionState", "SwipeSelectionMode", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryThumbnailFragment extends BottomSheetDialogFragment implements com.larus.avlink.gallery.viewmodel.d {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f292730x = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusFragmentGalleryDetailBinding f292731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ThumbnailViewModel f292732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ThumbnailListAdapter f292733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f292734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ConstraintLayout f292735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f292736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f292737j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e0 f292738k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g0 f292739l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f292740m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f292741n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f292742o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public BottomSheetBehavior<?> f292743p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f292744q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h0 f292745r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerViewSwipeMultiSelectHelper f292746s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b f292747t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f292748u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f292749v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d f292750w;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/gallery/thumbnail/GalleryThumbnailFragment$SwipeSelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "REMOVE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SwipeSelectionMode extends Enum<SwipeSelectionMode> {
        public static final SwipeSelectionMode ADD = null;
        public static final SwipeSelectionMode REMOVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SwipeSelectionMode[] f292751a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f292752b = null;

        public static EnumEntries<SwipeSelectionMode> getEntries() {
            return f292752b;
        }

        static {
            SwipeSelectionMode r100 = new SwipeSelectionMode("ADD", 0);
            ADD = r100;
            SwipeSelectionMode r101 = new SwipeSelectionMode("REMOVE", 1);
            REMOVE = r101;
            SwipeSelectionMode[] r102 = {r100, r101};
            f292751a = r102;
            f292752b = EnumEntriesKt.enumEntries(r102);
        }

        public static SwipeSelectionMode[] values() {
            return (SwipeSelectionMode[]) f292751a.clone();
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

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f292753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<ThumbnailMetadata> f292754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SwipeSelectionMode f292755c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f292753a == r101.f292753a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f292754b, r101.f292754b) == true) goto L15;
            return false;
        L15:
            if (this.f292755c == r101.f292755c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f292753a * 31) + this.f292754b.hashCode()) * 31) + this.f292755c.hashCode();
        }

        public final String toString() {
            return "SwipeSelectionState(anchorPosition=" + this.f292753a + ", initialSelectedItems=" + this.f292754b + ", mode=" + this.f292755c + ')';
        }

        public b(int r100, Set<ThumbnailMetadata> r101, SwipeSelectionMode r102) {
            Intrinsics.checkNotNullParameter(r101, "initialSelectedItems");
            Intrinsics.checkNotNullParameter(r102, "mode");
            this.f292753a = r100;
            this.f292754b = r101;
            this.f292755c = r102;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f292756a = null;

        static {
            int[] r100 = new int[SwipeSelectionMode.values().length];
            r100[SwipeSelectionMode.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SwipeSelectionMode.REMOVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f292756a = r100;
        }
    }

    public static final class d extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryThumbnailFragment f292757a;

        public d(GalleryThumbnailFragment r100) {
            this.f292757a = r100;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            GalleryThumbnailFragment r102 = this.f292757a;
            if (r102.f292748u == true) goto L5;
            return;
        L5:
            if (r102.f292744q == true) goto L22;
            r102.V90(r102.f292749v * RangesKt.coerceIn(r101, 0.0f, 1.0f));
            if (r101 < 0.3f) goto L17;
            return;
        L17:
            this.f292757a.dismiss();     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r103 = DialogFragmentLancet.sLastShowStack;
            if (r103 == null) goto L21;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L21:
            return;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            if (r101 != 5) goto L7;
            GalleryThumbnailFragment r102 = this.f292757a;
            int r103 = GalleryThumbnailFragment.f292730x;
            r102.V90(0.0f);
            GalleryThumbnailFragment r104 = this.f292757a;
            r104.f292744q = true;
            GalleryThumbnailFragment.S90(r104);
            return;
        L7:
            if (r101 != 3) goto L9;
            GalleryThumbnailFragment r105 = this.f292757a;
            r105.V90(r105.f292749v);
        L9:
            GalleryThumbnailFragment r106 = this.f292757a;
            BottomSheetBehavior<?> r107 = r106.f292743p;
            if (r107 != null) goto L13;
            return;
        L13:
            if (r106.f292748u == false) goto L15;
            return;
        L15:
            if (r101 != 4) goto L19;
            r107.setState(3);
            return;
        }
    }

    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f292758a;

        public e(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f292758a = r100;
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
            return this.f292758a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f292758a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment$onResume$1", f = "GalleryThumbnailFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTM_DNS_TIME}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GalleryThumbnailFragment this$0;

        public AnonymousClass1(GalleryThumbnailFragment r100, Continuation<? super AnonymousClass1> r101) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            if (this.this$0.isAdded() == false) goto L17;
            FLogger.f375446a.d("GalleryThumbnailFragment", "Secondary refresh triggered after onResume delay");
            ThumbnailViewModel r103 = this.this$0.f292732e;
            if (r103 == null) goto L17;
            r103.refreshThumbnailList(true);
        L17:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            this.label = 1;
            if (DelayKt.delay(500, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    @Override // com.larus.avlink.gallery.viewmodel.d
    public final void VO() {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.larus_ThumbnailBottomSheetDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f292743p = null;
        this.f292744q = false;
        super.onDestroyView();
        RecyclerViewSwipeMultiSelectHelper r100 = this.f292746s;
        if (r100 == null) goto L5;
        r100.b();
        r100.f292931a.removeOnItemTouchListener(r100);
        r100.a();
    L5:
        this.f292746s = null;
        this.f292747t = null;
        e0 r101 = this.f292738k;
        if (r101 == null) goto L8;
        ThumbnailManager r102 = ThumbnailManager.f292763a;
        ThumbnailManager.p(r101);
    L8:
        g0 r103 = this.f292739l;
        if (r103 == null) goto L11;
        b98.b.e(r103);
    L11:
        this.f292731d = null;
        ThumbnailManager.f292776n = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayList] */
    public final void W90() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r101 = true;
        if (r100 == null) goto L9;
        DeviceService r102 = r100.device();
        if (r102 == null) goto L9;
        if (r102.u() != 2) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L19;
        LarusFragmentGalleryDetailBinding r104 = this.f292731d;
        if (r104 == null) goto L47;
        ConstraintLayout r105 = r104.f293210a;
        if (r105 == null) goto L48;
        Context r106 = r105.getContext();
        if (r106 == null) goto L49;
        t19.s.f544207a.g(r106, R.string.larus_dora_album_device_disconnect_cn, false);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L19:
        ThumbnailViewModel r107 = this.f292732e;
        if (r107 == null) goto L27;
        List<ThumbnailMetadata> r108 = r107.m8540getSelectedItems();
        if (r108 == null) goto L27;
        List<ThumbnailMetadata> r109 = r108;
        ?? r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r111 = r109.iterator();
    L25:
        if (r111.hasNext() == false) goto L29;
        r110.add(Long.valueOf(((ThumbnailMetadata) r111.next()).getImageUuid()));
    L29:
        if (r110.isEmpty() == false) goto L32;
        FLogger.f375446a.i("GalleryThumbnailFragment", "No thumbnails selected");
        return;
    L32:
        int r112 = AlbumUtils.f292333a;
        StatFs r113 = new StatFs(Environment.getDataDirectory().getPath());
        if ((r113.getAvailableBlocksLong() * r113.getBlockSizeLong()) >= 524288000) goto L42;
        LarusFragmentGalleryDetailBinding r114 = this.f292731d;
        if (r114 == null) goto L41;
        ConstraintLayout r115 = r114.f293210a;
        if (r115 == null) goto L41;
        Context r116 = r115.getContext();
        if (r116 == null) goto L41;
        t19.s.f544207a.g(r116, R.string.larus_dora_album_storage_full_cn, false);
    L41:
        r101 = false;
    L42:
        if (r101 == true) goto L44;
        return;
    L44:
        FLogger.f375446a.i("GalleryThumbnailFragment", "Starting sync for " + r110.size() + " thumbnails, exiting fragment");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new GalleryThumbnailFragment$handleSyncButtonClick$2(this, r110, null), 3, null);
        return;
    L27:
        r110 = CollectionsKt.emptyList();
    L9:
        r103 = false;
        goto L10
    }

    public final void X90() {
        FLogger.f375446a.i("GalleryThumbnailFragment", "showWarningBanner");
        TextView r100 = this.f292737j;
        if (r100 == null) goto L5;
        r100.setText(AppHost.f326268a.getApplication().getString(R.string.larus_dora_album_partial_unsynced_cn));
    L5:
        Drawable r101 = ContextCompat.getDrawable(AppHost.f326268a.getApplication(), R.drawable.larus_question_circle);
        TextView r102 = this.f292737j;
        if (r102 == null) goto L8;
        r102.setCompoundDrawablesWithIntrinsicBounds(null, null, r101, null);
    L8:
        TextView r103 = this.f292737j;
        if (r103 == null) goto L11;
        r103.setCompoundDrawablePadding(i5.r0());
    L11:
        TextView r104 = this.f292737j;
        if (r104 == null) goto L25;
        int r105 = 0;
        if (r104 == null) goto L16;
        int r106 = r104.getPaddingLeft();
    L17:
        TextView r107 = this.f292737j;
        if (r107 == null) goto L20;
        int r108 = r107.getPaddingTop();
    L21:
        int r109 = i5.q();
        TextView r110 = this.f292737j;
        if (r110 == null) goto L24;
        r105 = r110.getPaddingBottom();
    L24:
        r104.setPadding(r106, r108, r109, r105);
        goto L25
    L20:
        r108 = 0;
        goto L21
    L16:
        r106 = 0;
    L25:
        TextView r111 = this.f292737j;
        if (r111 == null) goto L29;
        r111.setOnClickListener(new com.larus.avlink.gallery.thumbnail.b());
        return;
    }

    public final void Y90() {
        ThumbnailViewModel r100 = this.f292732e;
        boolean r101 = false;
        if (r100 == null) goto L9;
        LiveData<Integer> r102 = r100.getSelectedCount();
        if (r102 == null) goto L9;
        Integer r103 = r102.getValue();
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        ConstraintLayout r105 = this.f292735h;
        if (r105 == null) goto L15;
        if (r104 <= 0) goto L14;
        r101 = true;
    L14:
        r105.setEnabled(r101);
    L15:
        if (r104 != 0) goto L17;
        float r106 = 0.3f;
    L18:
        LarusFragmentGalleryDetailBinding r107 = this.f292731d;
        if (r107 == null) goto L24;
        ConstraintLayout r108 = r107.f293212c;
        if (r108 == null) goto L25;
        r108.setAlpha(r106);
        return;
    L25:
        return;
    L24:
        return;
    L17:
        r106 = 1.0f;
    L9:
        r104 = 0;
        goto L10
    }

    public final void Z90() {
        ThumbnailViewModel r100 = this.f292732e;
        if (r100 == null) goto L9;
        LiveData<Boolean> r101 = r100.isAllSelected();
        if (r101 == null) goto L9;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L9;
        boolean r103 = r102.booleanValue();
    L10:
        TextView r104 = this.f292736i;
        if (r104 == null) goto L18;
        Application r105 = AppHost.f326268a.getApplication();
        if (r103 == false) goto L15;
        int r106 = R.string.larus_dora_album_deselect_all_cn;
    L16:
        r104.setText(r105.getString(r106));
        return;
    L15:
        r106 = R.string.larus_dora_album_select_all_cn;
        goto L16
    L18:
        return;
    L9:
        r103 = false;
        goto L10
    }

    public final void aa0() {
        ThumbnailViewModel r100 = this.f292732e;
        boolean r101 = false;
        if (r100 == null) goto L9;
        LiveData<Integer> r102 = r100.getSelectedCount();
        if (r102 == null) goto L9;
        Integer r103 = r102.getValue();
        if (r103 == null) goto L9;
        int r104 = r103.intValue();
    L10:
        ThumbnailViewModel r105 = this.f292732e;
        if (r105 == null) goto L13;
        int r106 = r105.getThumbnailCount();
    L14:
        String r107 = AppHost.f326268a.getApplication().getString(R.string.larus_dora_album_start_sync_cn);
        if (r104 == 0) goto L18;
        r107 = r107 + 65288 + r104 + 65289;
    L18:
        TextView r108 = this.f292734g;
        if (r108 == null) goto L21;
        r108.setText(r107);
    L21:
        TextView r109 = this.f292734g;
        if (r109 == null) goto L28;
        if (r106 <= 0) goto L26;
        if (r104 <= 0) goto L26;
        r101 = true;
    L26:
        r109.setEnabled(r101);
        return;
    L28:
        return;
    L13:
        r106 = 0;
    L9:
        r104 = 0;
        goto L10
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void dismiss() {
        if (this.f292744q == false) goto L5;
        return;
    L5:
        this.f292744q = true;
        BottomSheetBehavior<?> r100 = this.f292743p;
        if (r100 != null) goto L8;
        S90(this);
        return;
    L8:
        if (r100.getState() != 5) goto L10;
        S90(this);
        return;
    L10:
        r100.setState(5);
    }

    public GalleryThumbnailFragment() {
        this.f292750w = new d(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        FLogger.f375446a.i("GalleryThumbnailFragment", "Fragment resumed, refreshing thumbnail list with force");
        ThumbnailViewModel r100 = this.f292732e;
        if (r100 == null) goto L5;
        r100.refreshThumbnailList(true);
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        ThumbnailViewModel.Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        if (ThumbnailViewModel.access$getDataChangeListeners$cp().contains(this) == true) goto L5;
        ThumbnailViewModel.access$getDataChangeListeners$cp().add(this);
        FLogger.f375446a.i("ThumbnailViewModel", "Registered data change listener, total: " + ThumbnailViewModel.access$getDataChangeListeners$cp().size());
    L5:
        FLogger.f375446a.i("GalleryThumbnailFragment", "Registered data change listener");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ThumbnailViewModel.Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ThumbnailViewModel.access$getDataChangeListeners$cp().remove(this);
        FLogger r100 = FLogger.f375446a;
        r100.i("ThumbnailViewModel", "Unregistered data change listener, total: " + ThumbnailViewModel.access$getDataChangeListeners$cp().size());
        r100.i("GalleryThumbnailFragment", "Unregistered data change listener");
    }

    public static void S90(BottomSheetDialogFragment r100) {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.larus.avlink.gallery.viewmodel.d
    public final void HZ(int r100) {
        FLogger.f375446a.i("GalleryThumbnailFragment", "Thumbnail deleted notification: " + r100 + " items");
    }

    public final void V90(float r100) {
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setDimAmount(RangesKt.coerceIn(r100, 0.0f, this.f292749v));
        return;
    L9:
        return;
    }

    @Override // com.larus.avlink.gallery.viewmodel.d
    public final void cQ(int r100) {
        FLogger.f375446a.i("GalleryThumbnailFragment", "Thumbnail synced notification: " + r100 + " items");
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.avlink.gallery.thumbnail.s] */
    public static final Object T90(final GalleryThumbnailFragment r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof GalleryThumbnailFragment$handleDeleteButtonClick$1) == false) goto L7;
        GalleryThumbnailFragment$handleDeleteButtonClick$1 r102 = (GalleryThumbnailFragment$handleDeleteButtonClick$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        Integer r107 = (Integer) r104;
        if (r107 != null) goto L21;
    L22:
        LarusFragmentGalleryDetailBinding r108 = r100.f292731d;
        if (r108 == null) goto L45;
        ConstraintLayout r109 = r108.f293210a;
        if (r109 == null) goto L45;
        Context r110 = r109.getContext();
        if (r110 == null) goto L45;
        t19.s.f544207a.g(r110, R.string.larus_dora_album_device_disconnect_cn, false);
    L45:
        return Unit.INSTANCE;
    L21:
        if (r107.intValue() != 2) goto L22;
        ThumbnailViewModel r111 = r100.f292732e;
        if (r111 == null) goto L34;
        final List<ThumbnailMetadata> r112 = r111.m8540getSelectedItems();
        if (r112 == null) goto L34;
    L35:
        int r113 = r112.size();
        ?? r114 = new s(r100, r112);
        String r115 = r100.getString(R.string.larus_dora_album_confirm_deletion_cn);
        Intrinsics.checkNotNullParameter(r115, "title");
        String r116 = r100.getString(R.string.larus_dora_album_delete_check_cn);
        Intrinsics.checkNotNullParameter(r116, "message");
        a0 r117 = new a0(r113, r114);
        AppHost.Companion r118 = AppHost.f326268a;
        String r119 = r118.getApplication().getString(R.string.larus_dora_alert_confirm_btn_cn);
        Intrinsics.checkNotNullParameter(r117, "listener");
        b0 r120 = new b0(r100);
        String r121 = r118.getApplication().getString(R.string.larus_dora_alert_cancel_btn_cn);
        Integer r122 = Integer.valueOf(FakePickerAvatarCreator.GRAY);
        Intrinsics.checkNotNullParameter(r120, "listener");
        CommonVerticalDialog r123 = new CommonVerticalDialog();
        r123.f327237e = r115;
        r123.f327238f = r116;
        r123.f327239g = r119;
        r123.f327240h = r117;
        r123.f327241i = r121;
        r123.f327243k = r122;
        r123.f327242j = r120;
        FragmentManager r124 = r100.getParentFragmentManager();
        LandscapeRestrictionOperation r125 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r123, "DeleteConfirmDialog", r125);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r124, r123, r125) == true) goto L41;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L39:
        r123.show(r124, "DeleteConfirmDialog");
    L41:
        return Unit.INSTANCE;
    L34:
        r112 = CollectionsKt.emptyList();
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r126 = Dispatchers.getIO();
        GalleryThumbnailFragment$handleDeleteButtonClick$doraState$1 r127 = new GalleryThumbnailFragment$handleDeleteButtonClick$doraState$1(null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r126, r127, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new GalleryThumbnailFragment$handleDeleteButtonClick$1(r100, r101);
        goto L8
    }

    public final void U90(int r100, int r101) {
        b r102 = this.f292747t;
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.f292753a == r100) goto L8;
        return;
    L8:
        ThumbnailListAdapter r103 = this.f292733f;
        if (r103 == null) goto L41;
        List<ThumbnailMetadata> r104 = r103.getCurrentList();
        if (r104 != null) goto L14;
        return;
    L14:
        if (r104.isEmpty() == false) goto L16;
        return;
    L16:
        int r105 = Math.min(r102.f292753a, r101);
        int r106 = Math.max(r102.f292753a, r101);
        boolean r107 = false;
        if (r105 >= 0) goto L19;
    L21:
        boolean r108 = false;
    L22:
        if (r108 == false) goto L42;
        if (r106 >= 0) goto L25;
    L27:
        if (r107 == false) goto L45;
        Set r109 = CollectionsKt.toSet(r104.subList(r105, r106 + 1));
        Set<ThumbnailMetadata> r110 = CollectionsKt.toMutableSet(r102.f292754b);
        SwipeSelectionMode r111 = r102.f292755c;
        int r112 = c.f292756a[r111.ordinal()];
        if (r112 != 1) goto L32;
        r110.addAll(r109);
    L37:
        ThumbnailViewModel r113 = this.f292732e;
        if (r113 == null) goto L43;
        r113.applySelection(r110);
        return;
    L43:
        return;
    L32:
        if (r112 != 2) goto L35;
        r110.removeAll(r109);
        goto L37
    L35:
        throw new NoWhenBranchMatchedException();
    L45:
        return;
    L25:
        if (r106 >= r104.size()) goto L27;
        r107 = true;
        goto L27
    L42:
        return;
    L19:
        if (r105 >= r104.size()) goto L21;
        r108 = true;
        goto L22
    }

    public final void ba0(int r100, int r101) {
        n1.d("GalleryThumbnailFragment", "updateSyncNumberText: imageCount=" + r100 + ", videoCount=" + r101);
        int r102 = i5.r0();
        if (r100 != 0) goto L7;
        if (r101 != 0) goto L7;
        String r103 = "没有媒体未同步";
    L12:
        TextView r104 = this.f292737j;
        if (r104 == null) goto L15;
        r104.setText(r103);
    L15:
        Drawable r105 = ContextCompat.getDrawable(AppHost.f326268a.getApplication(), R.drawable.larus_ic_album_real_sync);
        TextView r106 = this.f292737j;
        if (r106 == null) goto L18;
        r106.setCompoundDrawablesWithIntrinsicBounds(r105, null, null, null);
    L18:
        TextView r107 = this.f292737j;
        if (r107 == null) goto L21;
        r107.setCompoundDrawablePadding(r102);
    L21:
        TextView r108 = this.f292737j;
        if (r108 == null) goto L31;
        if (r108 == null) goto L25;
        int r109 = r108.getPaddingTop();
    L26:
        TextView r110 = this.f292737j;
        if (r110 == null) goto L29;
        int r111 = r110.getPaddingBottom();
    L30:
        r108.setPadding(0, r109, 0, r111);
        goto L31
    L29:
        r111 = 0;
        goto L30
    L25:
        r109 = 0;
    L31:
        TextView r112 = this.f292737j;
        if (r112 == null) goto L35;
        r112.setOnClickListener(null);
        return;
    L35:
        return;
    L7:
        if (r100 != 0) goto L9;
        r103 = AppHost.f326268a.getApplication().getString(R.string.larus_dora_album_sync_banner_video_only, new Object[]{Integer.valueOf(r101)});
        goto L12
    L9:
        if (r101 != 0) goto L11;
        r103 = AppHost.f326268a.getApplication().getString(R.string.larus_dora_album_sync_banner_photo_only, new Object[]{Integer.valueOf(r100)});
        goto L12
    L11:
        r103 = AppHost.f326268a.getApplication().getString(R.string.larus_dora_album_sync_banner_diff, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)});
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f292732e = (ThumbnailViewModel) new ViewModelProvider(this).get(ThumbnailViewModel.class);
        Dialog r112 = getDialog();
        if ((r112 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r113 = (BottomSheetDialog) r112;
    L6:
        if (r113 == null) goto L8;
        View r114 = r113.findViewById(R.id.design_bottom_sheet);
    L9:
        int r100 = com.larus.utils.m0.f375450a;
        int r101 = com.larus.utils.m0.a(getContext());
        com.larus.utils.i0.f375410a.getClass();
        int r102 = (r101 - com.larus.utils.i0.g()) - com.larus.utils.i0.e();
        if (r114 == null) goto L18;
        ViewGroup.LayoutParams r103 = r114.getLayoutParams();
        r103.height = r102;
        r114.setLayoutParams(r103);
        r114.setBackgroundResource(android.R.color.transparent);
        Window r115 = r113.getWindow();
        if (r115 == null) goto L16;
        WindowManager.LayoutParams r116 = r115.getAttributes();
        if (r116 == null) goto L16;
        float r117 = r116.dimAmount;
    L17:
        this.f292749v = r117;
        V90(r117);
        BottomSheetBehavior<?> r118 = BottomSheetBehavior.from(r114);
        r118.setState(3);
        r118.setPeekHeight(0);
        r118.setHideable(true);
        r118.setSkipCollapsed(true);
        r118.setBottomSheetCallback(this.f292750w);
        this.f292743p = r118;
    L16:
        r117 = 0.0f;
    L18:
        LarusFragmentGalleryDetailBinding r119 = this.f292731d;
        if (r119 == null) goto L23;
        ConstraintLayout r120 = r119.f293213d;
        if (r120 == null) goto L23;
        r120.setOnTouchListener(new l(this));
    L23:
        LarusFragmentGalleryDetailBinding r121 = this.f292731d;
        if (r121 == null) goto L28;
        RecyclerView r122 = r121.f293211b;
        if (r122 == null) goto L28;
        r122.setOnTouchListener(new n(this));
    L28:
        LarusFragmentGalleryDetailBinding r123 = this.f292731d;
        if (r123 == null) goto L44;
        ConstraintLayout r124 = r123.f293213d;
        if (r124 == null) goto L44;
        ImageView r125 = (ImageView) r124.findViewWithTag("close_icon");
        if (r125 != null) goto L38;
        View r126 = r124.getChildAt(0);
        if ((r126 instanceof ImageView) == false) goto L37;
        r125 = (ImageView) r126;
        goto L38
    L37:
        r125 = null;
    L38:
        if (r125 == null) goto L40;
        r125.setImageResource(R.drawable.larus_ic_close);
    L40:
        if (r125 == null) goto L42;
        r125.setColorFilter(ContextCompat.getColor(r124.getContext(), R.color.larus_neutral_100));
    L42:
        if (r125 == null) goto L44;
        r125.setOnClickListener(new w(this));
    L44:
        LarusFragmentGalleryDetailBinding r127 = this.f292731d;
        if (r127 == null) goto L56;
        ConstraintLayout r128 = r127.f293213d;
        if (r128 == null) goto L56;
        View r129 = r128.getChildAt(2);
        if ((r129 instanceof TextView) == false) goto L51;
        TextView r130 = (TextView) r129;
    L52:
        this.f292736i = r130;
        if (r130 == null) goto L55;
        r130.setOnClickListener(new x(this));
    L55:
        Z90();
        goto L56
    L51:
        r130 = null;
    L56:
        LarusFragmentGalleryDetailBinding r131 = this.f292731d;
        if (r131 == null) goto L61;
        ConstraintLayout r132 = r131.f293210a;
        if (r132 == null) goto L61;
        TextView r133 = (TextView) r132.findViewById(R.id.sync_number);
    L62:
        this.f292737j = r133;
        LarusFragmentGalleryDetailBinding r134 = this.f292731d;
        if (r134 == null) goto L67;
        RecyclerView r135 = r134.f293211b;
        if (r135 == null) goto L67;
        r135.setLayoutManager(new GridLayoutManager(r135.getContext(), 3));
        r135.setItemAnimator(null);
        r135.setNestedScrollingEnabled(false);
        ThumbnailListAdapter r136 = new ThumbnailListAdapter(new c0(this, r135));
        this.f292733f = r136;
        r135.setAdapter(r136);
        r135.addItemDecoration(new GridSpacingItemDecoration(i5.z(), Boolean.FALSE));
    L67:
        LarusFragmentGalleryDetailBinding r137 = this.f292731d;
        if (r137 == null) goto L76;
        RecyclerView r104 = r137.f293211b;
        if (r104 == null) goto L76;
        RecyclerViewSwipeMultiSelectHelper r138 = this.f292746s;
        if (r138 == null) goto L75;
        r138.b();
        r138.f292931a.removeOnItemTouchListener(r138);
        r138.a();
    L75:
        this.f292746s = new RecyclerViewSwipeMultiSelectHelper(r104, new o(this), new GalleryThumbnailFragment$setupSwipeMultiSelection$2(this), new GalleryThumbnailFragment$setupSwipeMultiSelection$3(this), new p(this), null, null);
    L76:
        TextView r139 = this.f292734g;
        if (r139 == null) goto L79;
        r139.setOnClickListener(new y(this));
    L79:
        LarusFragmentGalleryDetailBinding r140 = this.f292731d;
        if (r140 == null) goto L90;
        ConstraintLayout r141 = r140.f293212c;
        if (r141 == null) goto L90;
        View r142 = r141.getChildAt(0);
        if ((r142 instanceof ConstraintLayout) == false) goto L86;
        ConstraintLayout r143 = (ConstraintLayout) r142;
    L87:
        if (r143 == null) goto L89;
        r143.setOnClickListener(new z(this));
    L89:
        this.f292735h = r143;
        goto L90
    L86:
        r143 = null;
    L90:
        aa0();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getMain(), null, new GalleryThumbnailFragment$initView$6(this, null), 2, null);
        Y90();
        ThumbnailViewModel r144 = this.f292732e;
        if (r144 == null) goto L95;
        LiveData<List<ThumbnailMetadata>> r145 = r144.getThumbnailList();
        if (r145 == null) goto L95;
        r145.observe(getViewLifecycleOwner(), new e(new com.larus.avlink.gallery.thumbnail.c(this)));
    L95:
        ThumbnailViewModel r146 = this.f292732e;
        if (r146 == null) goto L100;
        LiveData<Set<ThumbnailMetadata>> r147 = r146.getSelectedItems();
        if (r147 == null) goto L100;
        r147.observe(getViewLifecycleOwner(), new e(new com.larus.avlink.gallery.thumbnail.d(this)));
    L100:
        ThumbnailViewModel r148 = this.f292732e;
        if (r148 == null) goto L105;
        LiveData<Integer> r149 = r148.getSelectedCount();
        if (r149 == null) goto L105;
        r149.observe(getViewLifecycleOwner(), new e(new com.larus.avlink.gallery.thumbnail.e(this)));
    L105:
        ThumbnailViewModel r150 = this.f292732e;
        if (r150 == null) goto L110;
        LiveData<Boolean> r151 = r150.isSelectionMode();
        if (r151 == null) goto L110;
        r151.observe(getViewLifecycleOwner(), new e(new f(this)));
    L110:
        ThumbnailViewModel r152 = this.f292732e;
        if (r152 == null) goto L115;
        LiveData<Boolean> r153 = r152.isAllSelected();
        if (r153 == null) goto L115;
        r153.observe(getViewLifecycleOwner(), new e(new g(this)));
    L115:
        ThumbnailViewModel r154 = this.f292732e;
        if (r154 == null) goto L120;
        LiveData<String> r155 = r154.getErrorMessage();
        if (r155 == null) goto L120;
        r155.observe(getViewLifecycleOwner(), new e(new h(this)));
    L120:
        ThumbnailViewModel r156 = this.f292732e;
        if (r156 == null) goto L125;
        LiveData<List<Long>> r157 = r156.getDeleteCompleteEvent();
        if (r157 == null) goto L125;
        r157.observe(getViewLifecycleOwner(), new e(new i(this)));
    L125:
        ThumbnailViewModel r158 = this.f292732e;
        if (r158 == null) goto L130;
        LiveData<Integer> r159 = r158.getSyncCompleteEvent();
        if (r159 == null) goto L130;
        r159.observe(getViewLifecycleOwner(), new e(new j(this)));
    L130:
        e0 r160 = new e0(this);
        this.f292738k = r160;
        ThumbnailManager r161 = ThumbnailManager.f292763a;
        ThumbnailManager.g(r160);
        g0 r162 = new g0(this);
        this.f292739l = r162;
        b98.b.c(r162);
        ThumbnailManager.s(WidgetService.PARAM_FRAGMENT);
        ThumbnailManager.f292776n = new m(this);
        return;
    L61:
        r133 = null;
        goto L62
    L8:
        r114 = null;
        goto L9
    L5:
        r113 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_fragment_gallery_detail, r101, false);
        int r104 = R.id.album_list;
        RecyclerView r105 = (RecyclerView) ViewBindings.findChildViewById(r103, R.id.album_list);
        if (r105 == null) goto L25;
        r104 = R.id.bottom_container;
        ConstraintLayout r106 = (ConstraintLayout) ViewBindings.findChildViewById(r103, R.id.bottom_container);
        if (r106 == null) goto L25;
        r104 = R.id.closeIcon;
        if (((ImageView) ViewBindings.findChildViewById(r103, R.id.closeIcon)) == null) goto L25;
        r104 = R.id.delete_btn;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r103, R.id.delete_btn)) == null) goto L25;
        r104 = R.id.deleteIcon;
        if (((ImageView) ViewBindings.findChildViewById(r103, R.id.deleteIcon)) == null) goto L25;
        r104 = R.id.delete_text;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.delete_text)) == null) goto L25;
        r104 = R.id.select_all;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.select_all)) == null) goto L25;
        r104 = R.id.start_sync;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r103, R.id.start_sync);
        if (r107 == null) goto L25;
        r104 = R.id.sync_number;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.sync_number)) == null) goto L25;
        r104 = R.id.top_container;
        ConstraintLayout r108 = (ConstraintLayout) ViewBindings.findChildViewById(r103, R.id.top_container);
        if (r108 == null) goto L25;
        ConstraintLayout r109 = (ConstraintLayout) r103;
        this.f292731d = new LarusFragmentGalleryDetailBinding(r109, r105, r106, r107, r108);
        this.f292734g = r107;
        return r109;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
