package com.bytedance.ee.bear.drive.biz.ai;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.drive.biz.bubblemenu.BubbleMenuVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.DrivePermissionViewModel;
import com.bytedance.ee.bear.drive.biz.preview.orientation.DriveOrientationPlugin;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.lark.dependency.e0;
import com.bytedance.ee.bear.lark.dependency.k;
import com.bytedance.ee.plugin.common.ttpdfreader.TTReaderSelectionInfo;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.inline.ai.api.Template;
import com.ss.android.lark.inline.ai.api.Templates;
import com.ss.android.lark.pb.office_ai_inline.QuickAction;
import com.ss.android.lark.pb.office_ai_inline.QuickActionParam;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import slb.h;
import slb.j;
import slb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0002J\u0016\u0010+\u001a\u00020%2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000-2\u0006\u0010\u001f\u001a\u00020 J\b\u00101\u001a\u00020%H\u0002J\b\u00102\u001a\u00020\u0012H\u0002J\b\u00103\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b!\u0010\"¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/ai/DriveInlineAIPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "bubbleMenuVM", "Lcom/bytedance/ee/bear/drive/biz/bubblemenu/BubbleMenuVM;", "driveViewModel", "Lcom/bytedance/ee/bear/drive/core/DriveViewModel;", "drivePermissionVM", "Lcom/bytedance/ee/bear/drive/biz/permission/DrivePermissionViewModel;", "menuItems", "", "Lcom/bytedance/ee/bear/drive/biz/bubblemenu/BubbleMenuItem;", "promptGroups", "Lcom/ss/android/lark/inline/ai/api/PromptGroup;", "orientationPlugin", "Lcom/bytedance/ee/bear/drive/biz/preview/orientation/DriveOrientationPlugin;", "isPad", "", "aiDependency", "Lcom/bytedance/ee/bear/lark/dependency/IQuickLaunchBarAIDependency;", "getAiDependency", "()Lcom/bytedance/ee/bear/lark/dependency/IQuickLaunchBarAIDependency;", "aiDependency$delegate", "Lkotlin/Lazy;", "content", "", "getContent", "()Ljava/lang/String;", "gson", "Lcom/google/gson/Gson;", "inlineAISdk", "Lcom/ss/android/lark/inline/ai/api/IInlineAISdk;", "getInlineAISdk", "()Lcom/ss/android/lark/inline/ai/api/IInlineAISdk;", "inlineAISdk$delegate", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "initMenus", "clearMenus", "buildPromptsAndMenus", "quickActions", "", "Lcom/ss/android/lark/pb/office_ai_inline/QuickAction;", "buildOperateButtons", "Lcom/ss/android/lark/inline/ai/api/OperateButton;", "toastIfCanNotCopy", "checkOrientation", "canCopy", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveInlineAIPlugin extends AbsDrivePlugin {
    private static final String COPY_TOKEN = "LARK-PSDA-ccm_android_drive_inline_ai_content_copy";
    public static final a Companion = null;
    private static final String TAG = "DriveInlineAIPlugin";
    private final Lazy aiDependency$delegate;
    private BubbleMenuVM bubbleMenuVM;
    private DrivePermissionViewModel drivePermissionVM;
    private DriveViewModel driveViewModel;
    private final Gson gson;
    private final Lazy inlineAISdk$delegate;
    private final boolean isPad;
    private final List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> menuItems;
    private DriveOrientationPlugin orientationPlugin;
    private final List<m> promptGroups;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements UDToast.b {
        public final /* synthetic */ DriveInlineAIPlugin a;

        public b(DriveInlineAIPlugin r1) {
            this.a = r1;
        }

        public final void a(com.ss.android.lark.compose.foundation.toast.b r2) {
            Intrinsics.checkNotNullParameter(r2, "toast");
            DriveInlineAIPlugin.access$getActivity(this.a).setRequestedOrientation(1);
        }
    }

    public static final class c implements slb.e.a {
        public final /* synthetic */ DriveInlineAIPlugin a;
        public final /* synthetic */ Ref.IntRef b;

        public final void onError(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            tt5.a.e(DriveInlineAIPlugin.TAG, "getPrompt failed! retryTimes = " + this.b.element, r4, false);
            Ref.IntRef r5 = this.b;
            int r0 = r5.element;
            if (r0 >= 2) goto L6;
            r5.element = r0 + 1;
            DriveInlineAIPlugin.access$getInlineAISdk(this.a).c(null, this);
            return;
        }

        public final void onSuccess(List<QuickAction> r2) {
            Intrinsics.checkNotNullParameter(r2, "quickActions");
            DriveInlineAIPlugin.access$buildPromptsAndMenus(this.a, r2);
        }

        public c(DriveInlineAIPlugin r1, Ref.IntRef r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.ai.DriveInlineAIPlugin$onAttachToHost$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.drive.biz.ai.DriveInlineAIPlugin$onAttachToHost$1", f = "DriveInlineAIPlugin.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DriveInlineAIPlugin this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.ai.DriveInlineAIPlugin$onAttachToHost$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ DriveInlineAIPlugin a;

            public a(DriveInlineAIPlugin r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                boolean r4 = ((Boolean) r2).booleanValue();
                tt5.a.h(DriveInlineAIPlugin.TAG, "inline ai showing changed: " + r4);
                if (r4 == true) goto L8;
                BubbleMenuVM r5 = DriveInlineAIPlugin.access$getBubbleMenuVM$p(this.a);
                if (r5 == null) goto L8;
                r5.clearSelectionData();
            L8:
                if (DriveInlineAIPlugin.access$isPad$p(this.a) == true) goto L13;
                DriveOrientationPlugin r6 = DriveInlineAIPlugin.access$getOrientationPlugin$p(this.a);
                if (r6 == null) goto L13;
                r6.forcePortrait(r4);
            L13:
                return Unit.INSTANCE;
            }
        }

        public C03451(DriveInlineAIPlugin r1, Continuation<? super C03451> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03451(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            i1 r6 = DriveInlineAIPlugin.access$getInlineAISdk(this.this$0).isShowing();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final boolean canCopy() {
        DriveViewModel r0 = this.driveViewModel;
        if (r0 != null) goto L5;
        return false;
    L5:
        BaseOpenEntity r2 = r0.getOpenEntity();
        if (r2 == null) goto L8;
        String r3 = r2.getMountPoint();
    L9:
        String r5 = r3;
        String r6 = r0.getFileId();
        w75.c r1 = r0.getIFileModel();     // Catch: Throwable -> L15
        if (r1 == null) goto L17;
        String r4 = r1.a();     // Catch: Throwable -> L15
        if (r4 == null) goto L17;
    L18:
        String r8 = r4;
        Object r7 = ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).getLiveCopyEscape().getValue();
        Boolean r9 = Boolean.TRUE;
        if (Intrinsics.areEqual(r7, r9) == false) goto L21;
    L29:
        return true;
    L21:
        if (s55.a.l(s55.a.a, "CONTENT_COPY", r5, r6, eu5.b.a, r8, null, null, null, null, 992) == false) goto L33;
        DrivePermissionViewModel r10 = this.drivePermissionVM;
        if (r10 == null) goto L27;
        MutableLiveData<Boolean> r11 = r10.getLiveOuterRawCopyable();
        if (r11 == null) goto L27;
        boolean r12 = Intrinsics.areEqual(r11.getValue(), r9);
    L28:
        if (r12 == true) goto L29;
        return false;
    L27:
        r12 = false;
        goto L28
    L33:
        return false;
    L17:
        r4 = "";
    L15:
        th = move-exception;
        tt5.a.e(TAG, "get tenantId error", th, false);
        goto L17
    L8:
        r3 = null;
        goto L9
    }

    private final boolean checkOrientation() {
        if (this.isPad == false) goto L6;
        return true;
    L6:
        if (CollectionsKt.listOf(new Integer[]{0, 8}).contains(Integer.valueOf(getActivity().getRequestedOrientation())) == true) goto L8;
        return true;
    L8:
        UDToast.a r0 = UDToast.build(getActivity());
        r0.b.e(2131889345);
        r0.b(2131889356, new b(this));
        r0.h();
        return false;
    }

    private final void clearMenus() {
        BubbleMenuVM r0 = this.bubbleMenuVM;
        if (r0 == null) goto L5;
        r0.removeMenus(this.menuItems);
    L5:
        this.menuItems.clear();
    }

    private final e0 getAiDependency() {
        return (e0) this.aiDependency$delegate.getValue();
    }

    private final slb.e getInlineAISdk() {
        return (slb.e) this.inlineAISdk$delegate.getValue();
    }

    private final void initMenus() {
        tt5.a.h(TAG, "initMenus, menuItems size = " + this.menuItems.size());
        if ((!this.menuItems.isEmpty()) == false) goto L5;
        return;
    L5:
        getInlineAISdk().c(null, new c(this, new Ref.IntRef()));
    }

    public DriveInlineAIPlugin() {
        this.menuItems = new ArrayList();
        this.promptGroups = new ArrayList();
        this.isPad = ku5.c.k(LarkContext.getApplication());
        this.aiDependency$delegate = LazyKt.lazy(DriveInlineAIPlugin$aiDependency$2.INSTANCE);
        this.gson = new Gson();
        this.inlineAISdk$delegate = LazyKt.lazy(new DriveInlineAIPlugin$inlineAISdk$2(this));
    }

    private final String getContent() {
        if (canCopy() == false) goto L24;
        StringBuilder r0 = new StringBuilder();
        BubbleMenuVM r2 = this.bubbleMenuVM;
        if (r2 == null) goto L19;
        LiveData<com.bytedance.ee.bear.drive.biz.bubblemenu.d> r3 = r2.getSelectionDataLiveData();
        if (r3 == null) goto L19;
        com.bytedance.ee.bear.drive.biz.bubblemenu.d r4 = (com.bytedance.ee.bear.drive.biz.bubblemenu.d) r3.getValue();
        if (r4 == null) goto L19;
        List<TTReaderSelectionInfo> r5 = r4.a;
        if (r5 == null) goto L19;
        Iterator<T> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        String r7 = ((TTReaderSelectionInfo) r6.next()).selectedText;
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        r0.append(r7);
    L19:
        String r1 = r0.toString();
        Intrinsics.checkNotNull(r1);
        return r1;
    L24:
        return "";
    }

    private final void toastIfCanNotCopy() {
        if (canCopy() == true) goto L9;
        String r0 = LarkContext.getApplication().getString(2131889160);
        e0 r1 = getAiDependency();
        if (r1 == null) goto L7;
        r1.a();
    L7:
        String r2 = UIHelper.mustacheFormat(r0, "aiName", "");
        Context r3 = getHost().getContext();
        Intrinsics.checkNotNull(r2);
        UDToast.show(r3, r2);
        return;
    }

    public static final /* synthetic */ boolean access$checkOrientation(DriveInlineAIPlugin r0) {
        return r0.checkOrientation();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveInlineAIPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ BubbleMenuVM access$getBubbleMenuVM$p(DriveInlineAIPlugin r0) {
        return r0.bubbleMenuVM;
    }

    public static final /* synthetic */ String access$getContent(DriveInlineAIPlugin r0) {
        return r0.getContent();
    }

    public static final /* synthetic */ Gson access$getGson$p(DriveInlineAIPlugin r0) {
        return r0.gson;
    }

    public static final /* synthetic */ slb.e access$getInlineAISdk(DriveInlineAIPlugin r0) {
        return r0.getInlineAISdk();
    }

    public static final /* synthetic */ DriveOrientationPlugin access$getOrientationPlugin$p(DriveInlineAIPlugin r0) {
        return r0.orientationPlugin;
    }

    public static final /* synthetic */ List access$getPromptGroups$p(DriveInlineAIPlugin r0) {
        return r0.promptGroups;
    }

    public static final /* synthetic */ boolean access$isPad$p(DriveInlineAIPlugin r0) {
        return r0.isPad;
    }

    public static final /* synthetic */ void access$toastIfCanNotCopy(DriveInlineAIPlugin r0) {
        r0.toastIfCanNotCopy();
    }

    private final void buildPromptsAndMenus(List<QuickAction> r40) {
        if (r40.isEmpty() == false) goto L6;
        tt5.a.k(TAG, "buildPromptsAndMenus, but quickActions is empty!");
        return;
    L6:
        this.promptGroups.clear();
        String r9 = "";
        m r2 = new m("", new ArrayList());
        this.promptGroups.add(r2);
        e0 r0 = getAiDependency();
        if (r0 == null) goto L9;
        r0.a();
    L9:
        List<com.bytedance.ee.bear.drive.biz.bubblemenu.c> r1 = this.menuItems;
        e0 r3 = getAiDependency();
        if (r3 == null) goto L12;
        r3.i();
    L12:
        r1.add(new com.bytedance.ee.bear.drive.biz.bubblemenu.c("MyAI", "", 0, C03431.INSTANCE, new C03442(this)));
        Iterator r4 = r40.iterator();
        int r13 = 1;
    L14:
        if (r4.hasNext() == false) goto L80;
        QuickAction r5 = (QuickAction) r4.next();
        final Function0<Map<String, ? extends String>> r6 = new DriveInlineAIPlugin$buildPromptsAndMenus$3$prompt$1(this);
        Function0<List<? extends h>> r7 = new DriveInlineAIPlugin$buildPromptsAndMenus$3$prompt$2(this);
        Map<String, Pair<String, Integer>> r8 = com.bytedance.ee.bear.drive.biz.ai.b.a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "contextParams");
        Intrinsics.checkNotNullParameter(r7, "buttons");
        String r10 = (String) r5.mextra_map.get("Comment");
        boolean r11 = false;
        if (r10 != null) goto L18;
    L21:
        boolean r12 = true;
    L23:
        if (r12 == false) goto L25;
        tt5.a.h("DriveInlineAICompat", "extra comment is empty");
        Map r14 = new LinkedHashMap();
    L33:
        Object r16 = r14.get("type");
        if ((r16 instanceof String) == false) goto L36;
        String r17 = (String) r16;
    L37:
        if (r17 != null) goto L39;
        r17 = r9;
    L39:
        Object r18 = r14.get(CustomHeaderConfig.Menu.Style.ICON_STYLE);
        if ((r18 instanceof String) == false) goto L42;
        String r19 = (String) r18;
    L43:
        if (r19 != null) goto L45;
        r19 = r9;
    L45:
        String r110 = r5.mid;
        Map r111 = com.ss.android.lark.inline.ai.d.a;
        if (r19.length() != 0) goto L49;
        r11 = true;
    L49:
        if (r11 == true) goto L51;
    L54:
        int r112 = com.ss.android.lark.inline.ai.d.a(r19);
        String r20 = r5.mname;
        List r21 = r5.mparam_details;
        ArrayList r113 = new ArrayList();
        Iterator r22 = r21.iterator();
    L56:
        if (r22.hasNext() == false) goto L60;
        Object r23 = r22.next();
        if (((QuickActionParam) r23).mneed_confirm.booleanValue() == false) goto L56;
        r113.add(r23);
        goto L56
    L60:
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r26 = r113.iterator();
    L62:
        if (r26.hasNext() == false) goto L64;
        QuickActionParam r114 = (QuickActionParam) r26.next();
        r24.add(new Template(r114.mdisplay_name, r114.mplace_holder, r114.mname, null, 8, null));
        r4 = r4;
        r26 = r26;
        goto L62
    L64:
        Iterator r27 = r4;
        Templates r28 = new Templates(r5.mname, new ArrayList(r24));
        if (Intrinsics.areEqual(r17, "translate") == false) goto L78;
        String r29 = r5.mid;
        if (((k) org.koin.java.a.c(k.class, null, null, 6)).isUsPackage() == false) goto L69;
        ArrayList r30 = new ArrayList();
        r30.addAll(com.bytedance.ee.bear.drive.biz.ai.b.a.keySet());
        Object r31 = r30;
    L70:
        ArrayList r115 = new ArrayList();
        Iterator r32 = ((Iterable) r31).iterator();
    L72:
        if (r32.hasNext() == false) goto L77;
        final Pair<String, Integer> r116 = com.bytedance.ee.bear.drive.biz.ai.b.a.get((String) r32.next());
        if (r116 == null) goto L72;
        String r37 = r9;
        r115.add(new j(r29, "translate", 0, LarkContext.getApplication().getString(((Number) r116.getSecond()).intValue()), null, null, null, new com.bytedance.ee.bear.drive.biz.ai.a(new DriveInlineAICompatKt$buildTranslatePrompts$1$1$1(r116, r6), r7), r29 + '_' + ((String) r116.getFirst()), 32));
        r32 = r32;
        r9 = r37;
        r13 = r13;
        goto L72
    L77:
        String r38 = r9;
        int r39 = r13;
    L79:
        final j r33 = new j(r110, r17, r112, r20, r28, null, r115, new com.bytedance.ee.bear.drive.biz.ai.a(r6, r7), null, 288);
        r2.b.add(r33);
        this.menuItems.add(new com.bytedance.ee.bear.drive.biz.bubblemenu.c(r5.mid, r5.mname, r39, DriveInlineAIPlugin$buildPromptsAndMenus$3$1.INSTANCE, new DriveInlineAIPlugin$buildPromptsAndMenus$3$2(this, r33)));
        r13 = r39 + 1;
        r4 = r27;
        r9 = r38;
        goto L14
    L69:
        r31 = CollectionsKt.listOf(new String[]{"SimplifiedChinese", "English"});
        goto L70
    L78:
        r38 = r9;
        r39 = r13;
        r115 = null;
        goto L79
    L51:
        if (Intrinsics.areEqual(r17, "translate") == false) goto L53;
        r19 = "TranslateOutlined";
        goto L54
    L53:
        r19 = r9;
        goto L54
    L42:
        r19 = null;
        goto L43
    L36:
        r17 = null;
        goto L37
    L25:
        Gson r117 = new Gson();
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L28
        r14 = (Map) r117.fromJson(r10, new HashMap().getClass());     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Object r34 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r34) == false) goto L32;
        tt5.a.e("DriveInlineAICompat", "parse json failed", Result.exceptionOrNull-impl(r34), false);
    L32:
        r14 = new LinkedHashMap();
        goto L33
    L18:
        if (r10.length() == 0) goto L21;
        r12 = false;
        goto L23
    L80:
        BubbleMenuVM r36 = this.bubbleMenuVM;
        if (r36 == null) goto L100;
        r36.addMenus(this.menuItems);
        return;
    }

    public final List<h> buildOperateButtons(final slb.e r6) {
        Intrinsics.checkNotNullParameter(r6, "inlineAISdk");
        return CollectionsKt.listOf(new h[]{new h("retry", LarkContext.getApplication().getString(2131889182), new AnonymousClass1(r6)), new h("copy", LarkContext.getApplication().getString(2131889152), new AnonymousClass2(this)), new h("quit", LarkContext.getApplication().getString(2131889161), new AnonymousClass3(r6))});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r8) {
        Intrinsics.checkNotNullParameter(r8, "host");
        super.onAttachToHost(r8);
        this.driveViewModel = r8.c;
        this.drivePermissionVM = (DrivePermissionViewModel) viewModel(DrivePermissionViewModel.class);
        this.bubbleMenuVM = (BubbleMenuVM) viewModel(BubbleMenuVM.class);
        this.orientationPlugin = (DriveOrientationPlugin) findPlugin(DriveOrientationPlugin.class);
        LifecycleOwner r9 = r8.getLifecycleOwner();
        if (r9 == null) goto L5;
        CoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r9);
    L6:
        if (r1 == null) goto L8;
        BuildersKt.launch$default(r1, null, null, new C03451(this, null), 3, null);
    L8:
        e0 r10 = getAiDependency();
        if (r10 == null) goto L11;
        r10.l();
    L11:
        tt5.a.h(TAG, "my ai enable: false");
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        clearMenus();
        getInlineAISdk().d("exit_page");
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$buildPromptsAndMenus(DriveInlineAIPlugin r0, List r1) {
        r0.buildPromptsAndMenus(r1);
    }
}
