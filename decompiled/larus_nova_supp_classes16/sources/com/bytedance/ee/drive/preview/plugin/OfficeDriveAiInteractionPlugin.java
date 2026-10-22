package com.bytedance.ee.drive.preview.plugin;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.ai.DrivePreviewAiResourceContextVM;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewAiChangeReason;
import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewCategory;
import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewPermissionState;
import com.bytedance.ee.drive.preview.ai.OfficeDrivePreviewState;
import i75.h;
import ir5.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t75.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @2\u00020\u0001:\u0003>?@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\rH\u0002J\u000f\u0010*\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u0010,J\u0012\u0010-\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\tH\u0002J\u0018\u00104\u001a\u00020\u00132\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\tH\u0002J.\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u000f2\b\u00109\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010;\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\r2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00180=H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/bytedance/ee/drive/preview/plugin/OfficeDriveAiInteractionPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "aiAbility", "Lcom/bytedance/ee/drive/preview/ai/IOfficeDrivePreviewAiAbility;", "containerAbility", "Lcom/bytedance/ee/bear/drive/core/ai/IDrivePreviewAiContainerHostAbility;", "aiHost", "Lcom/bytedance/ee/drive/preview/ai/OfficeDrivePreviewAiHost;", "currentSnapshot", "Lcom/bytedance/ee/bear/drive/core/ai/DrivePreviewAiPageSnapshot;", "lastDispatchedSelectionText", "", "latestAiPreviewState", "Lcom/bytedance/ee/drive/preview/ai/OfficeDrivePreviewState;", "latestAiPreviewErrCode", "Lcom/bytedance/ee/bear/drive/loader/model/ErrCode;", "hasObservedCurrentPreviewStart", "", "loadListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "previewAttached", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "onDetachPreview", "onDetachFromHost", "attachAndDispatchVisiblePage", "detachIfNeeded", "observePermission", "observeSelection", "observeWpsEditMode", "updateWpsEditBottomSuppression", "observePreviewShowStatus", "applyCurrentReaderStatusIfNeeded", "applyCurrentPermissionIfNeeded", "isCurrentDriveAiPreviewSuccessRequired", "canMutateCurrentAiPreviewState", "scene", "currentPreviewShowStatusForObservedRound", "", "()Ljava/lang/Integer;", "dispatchSelectionText", "selectedText", "buildSelectionContext", "Lcom/bytedance/ee/drive/preview/ai/OfficeDrivePreviewSelectionContext;", "expectedIdentity", "Lcom/bytedance/ee/drive/preview/plugin/OfficeDriveAiInteractionPlugin$SelectionProviderIdentity;", "expectedHost", "clearCurrentSelection", "dispatchContext", "reason", "Lcom/bytedance/ee/drive/preview/ai/OfficeDrivePreviewAiChangeReason;", "previewState", "expectedSnapshot", "errCode", "safeCall", "block", "Lkotlin/Function0;", "AiLoadListener", "SelectionProviderIdentity", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDriveAiInteractionPlugin extends AbsDrivePlugin {
    public static final b Companion = null;
    private static final long SLOW_CALLBACK_THRESHOLD_MS = 100;
    private static final String TAG = "OfficeDriveAiInteractionPlugin";
    private ir5.a aiAbility;
    private ir5.d aiHost;
    private i containerAbility;
    private t75.e currentSnapshot;
    private boolean hasObservedCurrentPreviewStart;
    private String lastDispatchedSelectionText;
    private ErrCode latestAiPreviewErrCode;
    private OfficeDrivePreviewState latestAiPreviewState;
    private u75.b.a loadListener;
    private boolean previewAttached;

    public final class a extends u75.b.C0306b {
        public final /* synthetic */ OfficeDriveAiInteractionPlugin a;

        /* JADX INFO: renamed from: com.bytedance.ee.drive.preview.plugin.OfficeDriveAiInteractionPlugin$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0204a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[InfoCode.values().length];
                r0[InfoCode.LoadStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[InfoCode.FileInfoSuccess.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[InfoCode.HitCache.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public a(OfficeDriveAiInteractionPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r5) {
            Intrinsics.checkNotNullParameter(r5, "code");
            if (OfficeDriveAiInteractionPlugin.access$canMutateCurrentAiPreviewState(this.a, "fileLoaderFailed") == true) goto L5;
            return;
        L5:
            OfficeDriveAiInteractionPlugin.access$setLatestAiPreviewState$p(this.a, OfficeDrivePreviewState.LOAD_FAILED);
            OfficeDriveAiInteractionPlugin.access$setLatestAiPreviewErrCode$p(this.a, r5);
            ((DrivePreviewAiResourceContextVM) OfficeDriveAiInteractionPlugin.access$viewModel(this.a, DrivePreviewAiResourceContextVM.class)).setLoadReady(false);
            OfficeDriveAiInteractionPlugin r6 = this.a;
            OfficeDriveAiInteractionPlugin.access$dispatchContext(r6, OfficeDrivePreviewAiChangeReason.PREVIEW_STATE_CHANGED, OfficeDriveAiInteractionPlugin.access$getLatestAiPreviewState$p(r6), OfficeDriveAiInteractionPlugin.access$getCurrentSnapshot$p(this.a), OfficeDriveAiInteractionPlugin.access$getLatestAiPreviewErrCode$p(this.a));
        }

        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r11, T r12) {
            Intrinsics.checkNotNullParameter(r11, "code");
            if (OfficeDriveAiInteractionPlugin.access$canMutateCurrentAiPreviewState(this.a, "fileLoaderInfo") == true) goto L5;
            return;
        L5:
            int r13 = C0204a.a[r11.ordinal()];
            ErrCode r14 = null;
            boolean r0 = true;
            if (r13 != 1) goto L8;
            OfficeDriveAiInteractionPlugin r16 = this.a;
            OfficeDrivePreviewState r4 = OfficeDrivePreviewState.LOADING;
            OfficeDriveAiInteractionPlugin.access$setLatestAiPreviewState$p(r16, r4);
            OfficeDriveAiInteractionPlugin.access$setLatestAiPreviewErrCode$p(this.a, null);
            OfficeDriveAiInteractionPlugin.access$setHasObservedCurrentPreviewStart$p(this.a, false);
            ((DrivePreviewAiResourceContextVM) OfficeDriveAiInteractionPlugin.access$viewModel(this.a, DrivePreviewAiResourceContextVM.class)).setLoadReady(false);
            OfficeDriveAiInteractionPlugin r2 = this.a;
            OfficeDriveAiInteractionPlugin.dispatchContext$default(r2, OfficeDrivePreviewAiChangeReason.PREVIEW_STATE_CHANGED, r4, OfficeDriveAiInteractionPlugin.access$getCurrentSnapshot$p(r2), null, 8, null);
            return;
        L8:
            if (r13 != 2) goto L10;
        L12:
            boolean r17 = OfficeDriveAiInteractionPlugin.access$isCurrentDriveAiPreviewSuccessRequired(this.a);
            OfficeDrivePreviewState r3 = OfficeDriveAiInteractionPlugin.access$getLatestAiPreviewState$p(this.a);
            Intrinsics.checkNotNullParameter(r3, "currentState");
            if (r3 != OfficeDrivePreviewState.NO_PERMISSION) goto L15;
        L20:
            OfficeDrivePreviewState r5 = r3;
            OfficeDriveAiInteractionPlugin.access$setLatestAiPreviewState$p(this.a, r5);
            OfficeDrivePreviewState r6 = OfficeDrivePreviewState.LOAD_FAILED;
            if (r5 == r6) goto L23;
            OfficeDriveAiInteractionPlugin.access$setLatestAiPreviewErrCode$p(this.a, null);
        L23:
            DrivePreviewAiResourceContextVM r7 = (DrivePreviewAiResourceContextVM) OfficeDriveAiInteractionPlugin.access$viewModel(this.a, DrivePreviewAiResourceContextVM.class);
            OfficeDrivePreviewState r8 = OfficeDrivePreviewState.LOADED;
            if (r5 != r8) goto L26;
            boolean r9 = true;
        L27:
            r7.setLoadReady(r9);
            ErrCode r10 = OfficeDriveAiInteractionPlugin.access$getLatestAiPreviewErrCode$p(this.a);
            if (r5 == r6) goto L31;
            r0 = false;
        L31:
            if (r0 == false) goto L33;
            r14 = r10;
        L33:
            OfficeDriveAiInteractionPlugin r1 = this.a;
            OfficeDriveAiInteractionPlugin.access$dispatchContext(r1, OfficeDrivePreviewAiChangeReason.PREVIEW_STATE_CHANGED, r5, OfficeDriveAiInteractionPlugin.access$getCurrentSnapshot$p(r1), r14);
            if (r17 == true) goto L39;
            if (r5 != r8) goto L40;
            OfficeDriveAiInteractionPlugin r18 = this.a;
            OfficeDriveAiInteractionPlugin.dispatchContext$default(r18, OfficeDrivePreviewAiChangeReason.IMAGE_INFO_CHANGED, r5, OfficeDriveAiInteractionPlugin.access$getCurrentSnapshot$p(r18), null, 8, null);
            return;
        L40:
            return;
        L39:
            return;
        L26:
            r9 = false;
            goto L27
        L15:
            if (com.bytedance.ee.drive.preview.plugin.a.a(r3) == true) goto L20;
            if (r17 == true) goto L20;
            r3 = OfficeDrivePreviewState.LOADED;
            goto L20
        L10:
            if (r13 == 3) goto L12;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c {
        public static final /* synthetic */ int d = 0;
        public final int a;
        public final String b;
        public final String c;

        public static final class a {
            public static c a(t75.e r5) {
                Intrinsics.checkNotNullParameter(r5, "snapshot");
                int r1 = r5.a;
                String r2 = r5.c.getFileId();
                BaseOpenEntity r6 = r5.c;
                String r4 = null;
                if ((r6 instanceof BaseSpaceOpenEntity) == false) goto L5;
                BaseSpaceOpenEntity r7 = (BaseSpaceOpenEntity) r6;
            L6:
                if (r7 == null) goto L8;
                r4 = r7.getVersion();
            L8:
                if (r4 != null) goto L11;
                r4 = "";
            L11:
                return new c(r1, r2, r4);
            L5:
                r7 = null;
                goto L6
            }
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "SelectionProviderIdentity(index=" + this.a + ", resourceKey=" + this.b + ", resourceVersion=" + this.c + ')';
        }

        public c(int r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "resourceKey");
            Intrinsics.checkNotNullParameter(r4, "resourceVersion");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ OfficeDriveAiInteractionPlugin a;

        public d(OfficeDriveAiInteractionPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            u55.b r9 = (u55.b) r8;
            DrivePreviewAiResourceContextVM r0 = (DrivePreviewAiResourceContextVM) OfficeDriveAiInteractionPlugin.access$viewModel(this.a, DrivePreviewAiResourceContextVM.class);
            if (r9 != null) goto L5;
        L9:
            boolean r1 = false;
        L10:
            r0.setPermissionReadable(r1);
            if (r9 != null) goto L15;
            OfficeDrivePreviewState r10 = OfficeDrivePreviewState.LOADING;
        L13:
            OfficeDrivePreviewState r2 = r10;
            OfficeDriveAiInteractionPlugin r3 = this.a;
            OfficeDriveAiInteractionPlugin.dispatchContext$default(r3, OfficeDrivePreviewAiChangeReason.PERMISSION_CHANGED, r2, OfficeDriveAiInteractionPlugin.access$getCurrentSnapshot$p(r3), null, 8, null);
            return;
        L15:
            if (r9.e() == true) goto L17;
        L20:
            r10 = OfficeDrivePreviewState.NO_PERMISSION;
            goto L13
        L17:
            if (r9.j() == true) goto L20;
            r10 = OfficeDrivePreviewState.LOADED;
            goto L13
        L5:
            if (r9.e() == false) goto L9;
            if (r9.j() == true) goto L9;
            r1 = true;
            goto L10
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ OfficeDriveAiInteractionPlugin a;

        public e(OfficeDriveAiInteractionPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            Integer r10 = (Integer) r9;
            if (OfficeDriveAiInteractionPlugin.access$canMutateCurrentAiPreviewState(this.a, "previewShowStatus") == true) goto L6;
            return;
        L6:
            if (OfficeDriveAiInteractionPlugin.access$isCurrentDriveAiPreviewSuccessRequired(this.a) == false) goto L33;
            boolean r0 = true;
            if (r10 != null) goto L12;
        L14:
            OfficeDrivePreviewState r11 = com.bytedance.ee.drive.preview.plugin.a.b(OfficeDriveAiInteractionPlugin.access$getLatestAiPreviewState$p(this.a), r10, OfficeDriveAiInteractionPlugin.access$getHasObservedCurrentPreviewStart$p(this.a));
            if (r11 == null) goto L34;
            OfficeDriveAiInteractionPlugin.access$setLatestAiPreviewState$p(this.a, r11);
            OfficeDrivePreviewState r1 = OfficeDrivePreviewState.LOAD_FAILED;
            ErrCode r2 = null;
            if (r11 == r1) goto L20;
            OfficeDriveAiInteractionPlugin.access$setLatestAiPreviewErrCode$p(this.a, null);
        L20:
            DrivePreviewAiResourceContextVM r3 = (DrivePreviewAiResourceContextVM) OfficeDriveAiInteractionPlugin.access$viewModel(this.a, DrivePreviewAiResourceContextVM.class);
            if (r11 != OfficeDrivePreviewState.LOADED) goto L23;
            boolean r4 = true;
        L24:
            r3.setLoadReady(r4);
            OfficeDriveAiInteractionPlugin r5 = this.a;
            OfficeDrivePreviewAiChangeReason r6 = OfficeDrivePreviewAiChangeReason.PREVIEW_STATE_CHANGED;
            t75.e r7 = OfficeDriveAiInteractionPlugin.access$getCurrentSnapshot$p(r5);
            ErrCode r8 = OfficeDriveAiInteractionPlugin.access$getLatestAiPreviewErrCode$p(this.a);
            if (r11 == r1) goto L28;
            r0 = false;
        L28:
            if (r0 == false) goto L30;
            r2 = r8;
        L30:
            OfficeDriveAiInteractionPlugin.access$dispatchContext(r5, r6, r11, r7, r2);
            return;
        L23:
            r4 = false;
            goto L24
        L34:
            return;
        L12:
            if (r10.intValue() != 1) goto L14;
            OfficeDriveAiInteractionPlugin.access$setHasObservedCurrentPreviewStart$p(this.a, true);
            goto L14
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ OfficeDriveAiInteractionPlugin a;

        public f(OfficeDriveAiInteractionPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            OfficeDriveAiInteractionPlugin r0 = this.a;
            OfficeDriveAiInteractionPlugin.access$dispatchSelectionText(r0, (String) r2);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ OfficeDriveAiInteractionPlugin a;

        public g(OfficeDriveAiInteractionPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            OfficeDriveAiInteractionPlugin.access$updateWpsEditBottomSuppression(this.a);
        }
    }

    static {
        Companion = new b();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        this.previewAttached = false;
        i r1 = this.containerAbility;
        if (r1 == null) goto L5;
        r1.J3(this, false);
    L5:
        i r2 = this.containerAbility;
        if (r2 == null) goto L8;
        r2.K9(this);
    L8:
        ((DrivePreviewAiResourceContextVM) viewModel(DrivePreviewAiResourceContextVM.class)).setConsumerEnabled(false);
        this.currentSnapshot = null;
        this.lastDispatchedSelectionText = null;
        super.onDetachPreview();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void applyCurrentPermissionIfNeeded() {
        if (canMutateCurrentAiPreviewState("applyPermission") == true) goto L5;
        return;
    L5:
        u55.b r0 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (r0 != null) goto L8;
    L12:
        boolean r1 = false;
    L13:
        ((DrivePreviewAiResourceContextVM) viewModel(DrivePreviewAiResourceContextVM.class)).setPermissionReadable(r1);
        if (r0 != null) goto L22;
        OfficeDrivePreviewState r2 = this.latestAiPreviewState;
        Intrinsics.checkNotNullParameter(r2, "currentState");
        if (r2 != OfficeDrivePreviewState.NO_PERMISSION) goto L19;
    L39:
        this.latestAiPreviewState = r2;
        if (r2 == OfficeDrivePreviewState.LOAD_FAILED) goto L43;
        this.latestAiPreviewErrCode = null;
        return;
    L43:
        return;
    L19:
        if (com.bytedance.ee.drive.preview.plugin.a.a(r2) == true) goto L39;
        r2 = OfficeDrivePreviewState.LOADING;
        goto L39
    L22:
        if (r1 == true) goto L24;
        r2 = OfficeDrivePreviewState.NO_PERMISSION;
        goto L39
    L24:
        boolean r3 = isCurrentDriveAiPreviewSuccessRequired();
        OfficeDrivePreviewState r4 = this.latestAiPreviewState;
        Integer r5 = currentPreviewShowStatusForObservedRound();
        Intrinsics.checkNotNullParameter(r4, "currentState");
        if (r4 != OfficeDrivePreviewState.NO_PERMISSION) goto L34;
        if (r3 == false) goto L32;
        if (r5 != null) goto L30;
    L31:
        r2 = OfficeDrivePreviewState.LOADING;
        goto L39
    L30:
        if (r5.intValue() != 2) goto L31;
    L32:
        r2 = OfficeDrivePreviewState.LOADED;
        goto L39
    L34:
        if (com.bytedance.ee.drive.preview.plugin.a.a(r4) == false) goto L36;
    L35:
        r2 = r4;
        goto L39
    L36:
        if (r3 == true) goto L35;
        r4 = OfficeDrivePreviewState.LOADED;
        goto L35
    L8:
        if (r0.e() == false) goto L12;
        if (r0.j() == true) goto L12;
        r1 = true;
        goto L13
    }

    private final void applyCurrentReaderStatusIfNeeded() {
        if (canMutateCurrentAiPreviewState("applyReaderStatus") == true) goto L6;
        return;
    L6:
        if (isCurrentDriveAiPreviewSuccessRequired() == true) goto L8;
        return;
    L8:
        OfficeDrivePreviewState r0 = com.bytedance.ee.drive.preview.plugin.a.b(this.latestAiPreviewState, (Integer) ((PreviewViewModel) viewModel(PreviewViewModel.class)).liveInnerPreviewShowStatus().getValue(), this.hasObservedCurrentPreviewStart);
        if (r0 != null) goto L11;
        return;
    L11:
        this.latestAiPreviewState = r0;
        if (r0 == OfficeDrivePreviewState.LOAD_FAILED) goto L15;
        this.latestAiPreviewErrCode = null;
        return;
    }

    private final void attachAndDispatchVisiblePage() {
        i r0 = this.containerAbility;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.aiAbility != null) goto L8;
        return;
    L8:
        final t75.c r1 = r0.Ea(this);
        if (r1 != null) goto L11;
        return;
    L11:
        this.aiHost = r1.a;
        t75.e r2 = r0.Mk();
        if (r2 != null) goto L14;
        return;
    L14:
        this.currentSnapshot = r2;
        this.latestAiPreviewState = OfficeDrivePreviewState.LOADING;
        this.latestAiPreviewErrCode = null;
        boolean r3 = false;
        this.hasObservedCurrentPreviewStart = false;
        applyCurrentReaderStatusIfNeeded();
        applyCurrentPermissionIfNeeded();
        ((DrivePreviewAiResourceContextVM) viewModel(DrivePreviewAiResourceContextVM.class)).setConsumerEnabled(true);
        DrivePreviewAiResourceContextVM r4 = (DrivePreviewAiResourceContextVM) viewModel(DrivePreviewAiResourceContextVM.class);
        if (this.latestAiPreviewState != OfficeDrivePreviewState.LOADED) goto L17;
        r3 = true;
    L17:
        r4.setLoadReady(r3);
        int r5 = c.d;
        final c r6 = c.a.a(r2);
        r0.Cf(this, new AnonymousClass1(this, r6, r1), new AnonymousClass2(this, r6, r1));
        if (r1.b == false) goto L21;
        safeCall("onAiContainersAttached", new AnonymousClass3(this, r1));
    L21:
        if (r1.b == false) goto L23;
        OfficeDrivePreviewAiChangeReason r7 = OfficeDrivePreviewAiChangeReason.CONTAINER_ATTACHED;
    L24:
        dispatchContext$default(this, r7, this.latestAiPreviewState, this.currentSnapshot, null, 8, null);
        dispatchSelectionText((String) ((DrivePreviewAiResourceContextVM) viewModel(DrivePreviewAiResourceContextVM.class)).getSelectionText().getValue());
        return;
    L23:
        r7 = OfficeDrivePreviewAiChangeReason.CURRENT_FILE_CHANGED;
        goto L24
    }

    private final Integer currentPreviewShowStatusForObservedRound() {
        if (this.hasObservedCurrentPreviewStart == true) goto L7;
        return null;
    L7:
        return (Integer) ((PreviewViewModel) viewModel(PreviewViewModel.class)).liveInnerPreviewShowStatus().getValue();
    }

    private final void detachIfNeeded() {
        i r0 = this.containerAbility;
        if (r0 == null) goto L5;
        r0.K9(this);
    L5:
        i r1 = this.containerAbility;
        boolean r2 = false;
        if (r1 != null) goto L8;
    L10:
        final ir5.d r3 = this.aiHost;
        if (r2 == false) goto L14;
        if (r3 == null) goto L14;
        safeCall("onAiContainersDetached", new C03531(this, r3));
    L14:
        this.currentSnapshot = null;
        this.lastDispatchedSelectionText = null;
        this.aiHost = null;
        return;
    L8:
        if (r1.k2(this) != true) goto L10;
        r2 = true;
        goto L10
    }

    private final boolean isCurrentDriveAiPreviewSuccessRequired() {
        t75.e r0 = this.currentSnapshot;
        if (r0 != null) goto L5;
        return false;
    L5:
        f85.a r2 = (f85.a) getHost().c.getFileModel();
        if (r2 == null) goto L11;
        f85.a.C0229a r3 = (f85.a.C0229a) r2.a;
        if (r3 == null) goto L11;
        String r4 = r3.k;
        if (r4 == null) goto L11;
    L12:
        if (r4 == null) goto L16;
        String r1 = r4.toLowerCase(Locale.ROOT);
        if (r1 == null) goto L16;
        String r5 = StringsKt.removePrefix(r1, ".");
    L17:
        if (r5 != null) goto L20;
        r5 = "";
    L20:
        if (r5.length() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == true) goto L25;
        return false;
    L25:
        if (h.k(r5) == false) goto L27;
    L38:
        return true;
    L27:
        if (h.g(r5) == true) goto L38;
        if (h.h(r5) == true) goto L38;
        if (h.f(r5) == true) goto L38;
        if (h.j(r5) == true) goto L38;
        if ("wps".equalsIgnoreCase(r5) == true) goto L38;
        if ("et".equalsIgnoreCase(r5) == true) goto L38;
        return false;
    L22:
        r6 = false;
    L16:
        r5 = null;
    L11:
        r4 = r0.c.getFileExt();
        goto L12
    }

    private final void observePermission() {
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new d(this));
    }

    private final void observePreviewShowStatus() {
        ((PreviewViewModel) viewModel(PreviewViewModel.class)).liveInnerPreviewShowStatus().observe(getLifecycleOwner(), new e(this));
    }

    private final void observeSelection() {
        ((DrivePreviewAiResourceContextVM) viewModel(DrivePreviewAiResourceContextVM.class)).getSelectionText().observe(getLifecycleOwner(), new f(this));
    }

    private final void observeWpsEditMode() {
        ((PreviewViewModel) viewModel(PreviewViewModel.class)).liveInnerExtraViewVisible().observe(getLifecycleOwner(), new g(this));
    }

    private final void updateWpsEditBottomSuppression() {
        boolean r1 = false;
        if (this.previewAttached == false) goto L14;
        f85.a r0 = (f85.a) getHost().c.getFileModel();
        if (r0 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L14;
        if (Intrinsics.areEqual(((PreviewViewModel) viewModel(PreviewViewModel.class)).liveInnerExtraViewVisible().getValue(), Boolean.FALSE) == false) goto L14;
        r1 = true;
        goto L14
    L7:
        if (r0.q != 2) goto L9;
        r2 = true;
    L14:
        i r3 = this.containerAbility;
        if (r3 == null) goto L18;
        r3.J3(this, r1);
        return;
    }

    public OfficeDriveAiInteractionPlugin() {
        this.latestAiPreviewState = OfficeDrivePreviewState.LOADING;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        this.previewAttached = true;
        updateWpsEditBottomSuppression();
        attachAndDispatchVisiblePage();
    }

    public static final /* synthetic */ ir5.a access$getAiAbility$p(OfficeDriveAiInteractionPlugin r0) {
        return r0.aiAbility;
    }

    public static final /* synthetic */ t75.e access$getCurrentSnapshot$p(OfficeDriveAiInteractionPlugin r0) {
        return r0.currentSnapshot;
    }

    public static final /* synthetic */ boolean access$getHasObservedCurrentPreviewStart$p(OfficeDriveAiInteractionPlugin r0) {
        return r0.hasObservedCurrentPreviewStart;
    }

    public static final /* synthetic */ ErrCode access$getLatestAiPreviewErrCode$p(OfficeDriveAiInteractionPlugin r0) {
        return r0.latestAiPreviewErrCode;
    }

    public static final /* synthetic */ OfficeDrivePreviewState access$getLatestAiPreviewState$p(OfficeDriveAiInteractionPlugin r0) {
        return r0.latestAiPreviewState;
    }

    public static final /* synthetic */ boolean access$isCurrentDriveAiPreviewSuccessRequired(OfficeDriveAiInteractionPlugin r0) {
        return r0.isCurrentDriveAiPreviewSuccessRequired();
    }

    public static final /* synthetic */ void access$updateWpsEditBottomSuppression(OfficeDriveAiInteractionPlugin r0) {
        r0.updateWpsEditBottomSuppression();
    }

    private final boolean canMutateCurrentAiPreviewState(String r6) {
        t75.e r0 = this.currentSnapshot;
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        i r2 = this.containerAbility;
        if (r2 == null) goto L17;
        t75.e r3 = r2.Mk();
        if (r3 == null) goto L17;
        if (r0.a == r3.a) goto L13;
    L15:
        if (r1 == true) goto L17;
        tt5.a.h(TAG, "skip " + r6 + " ai state mutation, expected=" + r0.a + '/' + du5.b.k(r0.c.getFileId()) + ", latest=" + r3.a + '/' + du5.b.k(r3.c.getFileId()));
        goto L17
    L13:
        if (Intrinsics.areEqual(r0.c.getFileId(), r3.c.getFileId()) == false) goto L15;
        r1 = true;
    L17:
        return r1;
    }

    private final void dispatchSelectionText(final String r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r2, this.lastDispatchedSelectionText) == false) goto L7;
        return;
    L7:
        this.lastDispatchedSelectionText = r2;
        safeCall("onDrivePreviewSelectionContextChanged", new C03551(this, r2));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        this.aiAbility = (ir5.a) r3.getHostAbilityOrNull(ir5.a.class);
        this.containerAbility = (i) r3.getHostAbilityOrNull(i.class);
        tt5.a.h(TAG, "onAttachToHost, aiAbility = " + this.aiAbility + ", containerAbility = " + this.containerAbility);
        this.loadListener = new a(this);
        u75.b r4 = r3.c();
        u75.b.a r0 = this.loadListener;
        Intrinsics.checkNotNull(r0);
        r4.c(r0);
        observePreviewShowStatus();
        observePermission();
        observeSelection();
        observeWpsEditMode();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        this.previewAttached = false;
        i r1 = this.containerAbility;
        if (r1 == null) goto L5;
        r1.J3(this, false);
    L5:
        i r2 = this.containerAbility;
        if (r2 == null) goto L8;
        r2.K9(this);
    L8:
        detachIfNeeded();
        u75.b.a r3 = this.loadListener;
        if (r3 == null) goto L11;
        r4.c().g(r3);
    L11:
        this.loadListener = null;
        ((DrivePreviewAiResourceContextVM) viewModel(DrivePreviewAiResourceContextVM.class)).setConsumerEnabled(false);
        this.lastDispatchedSelectionText = null;
        this.containerAbility = null;
        this.aiAbility = null;
        super.onDetachFromHost(r4);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ boolean access$canMutateCurrentAiPreviewState(OfficeDriveAiInteractionPlugin r0, String r1) {
        return r0.canMutateCurrentAiPreviewState(r1);
    }

    public static final /* synthetic */ void access$dispatchSelectionText(OfficeDriveAiInteractionPlugin r0, String r1) {
        r0.dispatchSelectionText(r1);
    }

    public static final /* synthetic */ void access$setHasObservedCurrentPreviewStart$p(OfficeDriveAiInteractionPlugin r0, boolean r1) {
        r0.hasObservedCurrentPreviewStart = r1;
    }

    public static final /* synthetic */ void access$setLatestAiPreviewErrCode$p(OfficeDriveAiInteractionPlugin r0, ErrCode r1) {
        r0.latestAiPreviewErrCode = r1;
    }

    public static final /* synthetic */ void access$setLatestAiPreviewState$p(OfficeDriveAiInteractionPlugin r0, OfficeDrivePreviewState r1) {
        r0.latestAiPreviewState = r1;
    }

    public static final /* synthetic */ ViewModel access$viewModel(OfficeDriveAiInteractionPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    private final ir5.i buildSelectionContext(c r12, ir5.d r13) {
        String r1 = null;
        if (this.aiHost == r13) goto L5;
        return null;
    L5:
        if (r13.isValid() == true) goto L7;
        return null;
    L7:
        if (getHost().canRead().booleanValue() == false) goto L85;
        i r0 = this.containerAbility;
        if (r0 != null) goto L12;
        return null;
    L12:
        t75.e r2 = r0.Mk();
        if (r2 != null) goto L15;
        return null;
    L15:
        int r3 = c.d;
        if (Intrinsics.areEqual(c.a.a(r2), r12) == true) goto L18;
        return null;
    L18:
        u55.b r14 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (r14 != null) goto L21;
        return null;
    L21:
        if (r14.e() == true) goto L23;
        return null;
    L23:
        if (r14.j() == true) goto L86;
        DrivePreviewAiResourceContextVM r16 = (DrivePreviewAiResourceContextVM) viewModel(DrivePreviewAiResourceContextVM.class);
        t75.f r4 = (t75.f) r16.getSnapshot().getValue();
        if (r4 != null) goto L29;
        return null;
    L29:
        if (r16.isCaptureEnabled() == true) goto L31;
        return null;
    L31:
        if (r4.a != r16.getCurrentGeneration()) goto L87;
        f85.a r17 = (f85.a) getHost().c.getFileModel();
        if (r17 == null) goto L38;
        f85.a.C0229a r18 = (f85.a.C0229a) r17.a;
        if (r18 == null) goto L38;
        String r19 = r18.o;
    L39:
        if (r19 != null) goto L41;
        r19 = "";
    L41:
        String r7 = r19;
        int r110 = com.bytedance.ee.drive.preview.plugin.d.a;
        String r5 = r13.getSessionId();
        String r6 = r2.c.getFileId();
        String r111 = r2.c.getFileExt();
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "resourceKey");
        Intrinsics.checkNotNullParameter(r7, "resourceVersion");
        Intrinsics.checkNotNullParameter(r4, "snapshot");
        List<t75.g> r112 = r4.b;
        ArrayList r8 = new ArrayList();
        Iterator<T> r113 = r112.iterator();
    L42:
        boolean r9 = false;
        if (r113.hasNext() == false) goto L64;
        t75.g r10 = (t75.g) r113.next();
        t75.d r11 = r10.a;
        int r20 = r11.a;
        if (r20 > 0) goto L47;
    L49:
        boolean r21 = false;
    L50:
        if (r21 == true) goto L53;
        r11 = null;
    L53:
        if (r11 != null) goto L56;
    L59:
        ir5.h r22 = null;
    L61:
        if (r22 == null) goto L42;
        r8.add(r22);
        goto L42
    L56:
        if (r10.b.length() != 0) goto L58;
        r9 = true;
    L58:
        if (r9 == true) goto L59;
        r22 = new ir5.h(new ir5.f(r11.a, r11.b), r10.b, r10.c);
        goto L61
    L47:
        if (r11.b < r20) goto L49;
        r21 = true;
        goto L50
    L64:
        if (r6.length() != 0) goto L66;
        r9 = true;
    L66:
        if (r9 == false) goto L69;
        return null;
    L69:
        if (r111 == null) goto L74;
        String r114 = r111.toLowerCase(Locale.ROOT);
        if (r114 == null) goto L74;
        r1 = StringsKt.removePrefix(r114, ".");
    L74:
        return new ir5.i(r5, r6, r1, r7, r8);
    L38:
        r19 = null;
        goto L39
    L87:
        return null;
    L86:
        return null;
    L85:
        return null;
    }

    private final boolean clearCurrentSelection(c r4, ir5.d r5) {
        if (this.aiHost == r5) goto L5;
    L31:
        tt5.a.h(TAG, "clearCurrentSelection rejected: invalid host or permission");
        return false;
    L5:
        if (r5.isValid() == false) goto L31;
        if (getHost().canRead().booleanValue() == false) goto L31;
        u55.b r6 = (u55.b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (r6 != null) goto L12;
    L29:
        tt5.a.h(TAG, "clearCurrentSelection rejected: realtime permission unavailable");
        return false;
    L12:
        if (r6.e() == false) goto L29;
        if (r6.j() == true) goto L29;
        i r7 = this.containerAbility;
        if (r7 == null) goto L19;
        t75.e r8 = r7.Mk();
    L20:
        if (r8 != null) goto L23;
        tt5.a.h(TAG, "clearCurrentSelection rejected: current page unavailable");
        return false;
    L23:
        int r0 = c.d;
        if (Intrinsics.areEqual(c.a.a(r8), r4) == true) goto L27;
        tt5.a.h(TAG, "clearCurrentSelection rejected: page identity changed");
        return false;
    L27:
        ((BubbleMenuVM) viewModel(BubbleMenuVM.class)).clearSelectionData();
        tt5.a.h(TAG, "clearCurrentSelection accepted and submitted");
        return true;
    L19:
        r8 = null;
        goto L20
    }

    private final void safeCall(String r10, Function0<Unit> r11) {
        long r3 = System.currentTimeMillis();
        r11.invoke();     // Catch: Throwable -> L8
        long r7 = System.currentTimeMillis() - r3;
        if (r7 <= 100) goto L13;
        StringBuilder r12 = new StringBuilder();
    L7:
        r12.append(r10);
        r12.append(" cost ");
        r12.append(r7);
        r12.append("ms");
        tt5.a.k(TAG, r12.toString());
        return;
    L13:
        return;
    L8:
        th = move-exception;
        tt5.a.e(TAG, r10 + " failed", th, false);     // Catch: Throwable -> L14
        r7 = System.currentTimeMillis() - r3;
        if (r7 <= 100) goto L24;
        r12 = new StringBuilder();
        goto L7
    L24:
        return;
    L14:
        th = move-exception;
        long r8 = System.currentTimeMillis() - r3;
        if (r8 <= 100) goto L18;
        tt5.a.k(TAG, r10 + " cost " + r8 + "ms");
    L18:
        throw th;
    }

    public static final /* synthetic */ ir5.i access$buildSelectionContext(OfficeDriveAiInteractionPlugin r0, c r1, ir5.d r2) {
        return r0.buildSelectionContext(r1, r2);
    }

    public static final /* synthetic */ boolean access$clearCurrentSelection(OfficeDriveAiInteractionPlugin r0, c r1, ir5.d r2) {
        return r0.clearCurrentSelection(r1, r2);
    }

    private final void dispatchContext(OfficeDrivePreviewAiChangeReason r29, OfficeDrivePreviewState r30, t75.e r31, ErrCode r32) {
        OfficeDrivePreviewState r1 = r30;
        final ir5.a r3 = this.aiAbility;
        if (r3 != null) goto L5;
        return;
    L5:
        final ir5.d r4 = this.aiHost;
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.isValid() == true) goto L11;
        return;
    L11:
        i r5 = this.containerAbility;
        if (r5 != null) goto L14;
        return;
    L14:
        t75.e r6 = r5.Mk();
        if (r6 != null) goto L17;
        return;
    L17:
        if (r31 != null) goto L19;
        t75.e r7 = r6;
    L21:
        if (r7.a == r6.a) goto L23;
    L84:
        tt5.a.h(TAG, "drop stale ai context, expected=" + r7.a + '/' + r7.c.getFileId() + ", latest=" + r6.a + '/' + r6.c.getFileId());
        return;
    L23:
        if (Intrinsics.areEqual(r7.c.getFileId(), r6.c.getFileId()) == false) goto L84;
        long r11 = r5.gg();
        g85.f r8 = com.bytedance.ee.drive.preview.plugin.c.a;
        String r10 = r4.getSessionId();
        DrivePluginHost r9 = getHost();
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r9, "host");
        Intrinsics.checkNotNullParameter(r6, "pageSnapshot");
        Intrinsics.checkNotNullParameter(r29, "changeReason");
        Intrinsics.checkNotNullParameter(r1, "previewState");
        BaseOpenEntity r12 = r6.c;
        w75.a r13 = r9.c.getFileModel();
        if (r13 == null) goto L28;
        w75.b r14 = r13.c();
    L29:
        if (r14 == null) goto L32;
        String r16 = r14.k;
        if (r16 == null) goto L32;
    L33:
        String r19 = r16;
        boolean r17 = r9.canRead().booleanValue();
        String r18 = r12.getFileId();
        WikiInfo r110 = r9.c.getWikiInfo();
        if (r110 == null) goto L36;
        int r111 = r110.getObjType();
    L37:
        String r112 = r9.c.getFileName();
        if (r112 != null) goto L40;
        r112 = r12.getFileName();
    L40:
        String r113 = r112;
        if (r14 == null) goto L43;
        Long r20 = Long.valueOf(r14.c);
    L44:
        OfficeDrivePreviewCategory r21 = com.bytedance.ee.drive.preview.plugin.c.a(r19);
        int r22 = r6.a;
        int r23 = r6.b;
        if (com.bytedance.ee.drive.preview.plugin.c.a(r19) == OfficeDrivePreviewCategory.IMAGE) goto L47;
        ir5.e r24 = null;
    L48:
        String r26 = r12.getAppId();
        if (r9.c.isHistoryMode() == false) goto L51;
        Map r27 = MapsKt.mapOf(TuplesKt.to("is_history_mode", "true"));
    L52:
        ir5.c r28 = new ir5.c(r18, r111, r113, r19, r20, r21, r22, r23, r24, r26, r27);
        if (r32 != ErrCode.PERMISSION_DENIED) goto L55;
    L71:
        OfficeDrivePreviewPermissionState r33 = OfficeDrivePreviewPermissionState.NO_READ_PERMISSION;
    L72:
        ir5.g r34 = new ir5.g(r17, r33);
        if (r32 != null) goto L75;
        int r2 = -1;
    L76:
        switch(r2) {
            case -1: goto L82;
            case 0: goto L77;
            case 1: goto L81;
            case 2: goto L81;
            case 3: goto L81;
            case 4: goto L81;
            case 5: goto L81;
            case 6: goto L80;
            case 7: goto L79;
            case 8: goto L79;
            case 9: goto L78;
            case 10: goto L78;
            case 11: goto L78;
            case 12: goto L78;
            default: goto L77;
        };
    L77:
        r1 = OfficeDrivePreviewState.LOAD_FAILED;
        goto L82
    L78:
        r1 = OfficeDrivePreviewState.PASSWORD_PROTECTED;
        goto L82
    L79:
        r1 = OfficeDrivePreviewState.SIZE_LIMIT;
        goto L82
    L80:
        r1 = OfficeDrivePreviewState.FILE_NOT_SUPPORT;
        goto L82
    L81:
        r1 = OfficeDrivePreviewState.NO_PERMISSION;
    L82:
        final ir5.b r114 = new ir5.b(r10, r11, r28, r34, new j(r1), r29, r9.c.isVCFollowMode());
        safeCall("onDrivePreviewAiContextChanged", new C03541(r3, r4, r114));
        return;
    L75:
        r2 = com.bytedance.ee.drive.preview.plugin.c.a.a[r32.ordinal()];
        goto L76
    L55:
        if (r32 == ErrCode.POLICY_DENIED) goto L71;
        if (r32 != ErrCode.CAC_PREVIEW_CONTROL) goto L60;
    L70:
        r33 = OfficeDrivePreviewPermissionState.SECURITY_BLOCKED;
        goto L72
    L60:
        if (r32 == ErrCode.TNS_BLOCK_VIEW) goto L70;
        if (r32 == ErrCode.PERM_ADMIN_CONTROL) goto L70;
        if (r17 == true) goto L67;
        r33 = OfficeDrivePreviewPermissionState.NO_READ_PERMISSION;
        goto L72
    L67:
        if (r1 != OfficeDrivePreviewState.LOADING) goto L69;
        r33 = OfficeDrivePreviewPermissionState.CHECKING;
        goto L72
    L69:
        r33 = OfficeDrivePreviewPermissionState.CAN_READ;
        goto L72
    L51:
        r27 = MapsKt.emptyMap();
        goto L52
    L47:
        r24 = new ir5.e();
        goto L48
    L43:
        r20 = null;
        goto L44
    L36:
        r111 = 12;
    L32:
        r16 = r12.getFileExt();
        goto L33
    L28:
        r14 = null;
        goto L29
    L19:
        r7 = r31;
        goto L21
    }

    public static final /* synthetic */ void access$dispatchContext(OfficeDriveAiInteractionPlugin r0, OfficeDrivePreviewAiChangeReason r1, OfficeDrivePreviewState r2, t75.e r3, ErrCode r4) {
        r0.dispatchContext(r1, r2, r3, r4);
    }

    public static /* synthetic */ void dispatchContext$default(OfficeDriveAiInteractionPlugin r0, OfficeDrivePreviewAiChangeReason r1, OfficeDrivePreviewState r2, t75.e r3, ErrCode r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.dispatchContext(r1, r2, r3, r4);
    }
}
