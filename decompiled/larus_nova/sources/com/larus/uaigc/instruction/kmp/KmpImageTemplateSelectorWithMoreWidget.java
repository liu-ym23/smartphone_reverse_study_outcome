package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.actionbar.model.n;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderV2Binding;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;
import com.larus.uaigc.instruction.widget.ImageSelectorWithMoreWidgetAdapter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.q;
import cq8.w;
import cq8.z;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;
import v19.y6;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001/\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u001a\u00101\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u00102\u001a\u00020)2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u00103\u001a\u00020)H\u0014J\u0010\u00104\u001a\u00020)2\u0006\u0010\u000f\u001a\u000205H\u0014J\u0010\u00106\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u00107\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u00108\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u00109\u001a\u00020)H\u0002J\b\u0010:\u001a\u00020)H\u0002J\u0010\u0010;\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010>\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\b\u0010?\u001a\u00020)H\u0003J\b\u0010@\u001a\u00020)H\u0002J\b\u0010A\u001a\u00020)H\u0002J\u001c\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020!2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eRW\u0010\u001f\u001aK\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0004\n\u0002\u00100R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/larus/uaigc/instruction/kmp/KmpImageTemplateSelectorWithMoreWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;", "adapter", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/ImageTemplateSelectorWithMoreDescriptor;", "isBound", "", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "widgetScope", "Lkotlinx/coroutines/CoroutineScope;", "coverBinding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionbarImageTemplateCoverHolderV2Binding;", "showCover", "localImageList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "pendingInitialScrollPosition", "Ljava/lang/Integer;", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "conversationId", "Landroid/net/Uri;", "localImagePath", "", "getSendMessageTrackExtMap", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$SendMessageTrackExtMap;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "itemClickCallback", "com/larus/uaigc/instruction/kmp/KmpImageTemplateSelectorWithMoreWidget$itemClickCallback$1", "Lcom/larus/uaigc/instruction/kmp/KmpImageTemplateSelectorWithMoreWidget$itemClickCallback$1;", "init", "bindInstructionViewModel", "onDetachedFromWindow", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onBindView", "bindHeader", "createImageTemplateAdapter", "bindExposureTracking", "bindRecyclerViewSpacing", "scheduleInitialScroll", "initialScrollListener", "Landroid/view/View$OnLayoutChangeListener;", ChameleonOpenTracker.Stage.RENDER, "bindObservers", "requestTemplateList", "goToImageTemplateList", "selectImageTemplateInternal", MapController.ITEM_LAYER_TAG, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpImageTemplateSelectorWithMoreWidget extends AbsKmpInstructionWidget implements com.larus.bmhome.instruction.kmp.b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f373375s = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetImageSelectorV2Binding f373376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageSelectorWithMoreWidgetAdapter f373377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public w f373378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f373379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.larus.bmhome.view.actionbar.edit.c f373380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CoroutineScope f373381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LarusItemActionbarImageTemplateCoverHolderV2Binding f373382l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f373383m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<com.larus.bmhome.actionbar.model.w> f373384n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f373385o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final g f373386p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f373387q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h f373388r;

    public static final class a implements vz9.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpImageTemplateSelectorWithMoreWidget f373389a;

        @Override // vz9.d
        public final void b(com.larus.bmhome.actionbar.model.w r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        }

        public a(KmpImageTemplateSelectorWithMoreWidget r100) {
            this.f373389a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v5 */
        @Override // vz9.d
        public final void a(com.larus.bmhome.actionbar.model.w r510, int r511) {
            Intrinsics.checkNotNullParameter(r510, MapController.ITEM_LAYER_TAG);
            w r100 = this.f373389a.f373378h;
            if (r100 != null) goto L5;
            return;
        L5:
            n r101 = r100.f464982f;
            if (r101 == null) goto L8;
            ?? r102 = Intrinsics.areEqual(r101.f295325c, Boolean.TRUE);
        L9:
            Iterator r103 = this.f373389a.f373384n.iterator();
        L10:
            Integer r104 = null;
            if (r103.hasNext() == false) goto L15;
            Object r105 = r103.next();
            if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r105).f295510a, r510.f295510a) == false) goto L10;
        L16:
            com.larus.bmhome.actionbar.model.w r106 = (com.larus.bmhome.actionbar.model.w) r105;
            if (r106 == null) goto L20;
            r104 = r106.f295528s;
        L20:
            if (r102 != 0) goto L26;
            if (r104 == null) goto L26;
            if (r104.intValue() != 1) goto L26;
            boolean r107 = true;
        L27:
            z r108 = r100.f464980d;
            String r109 = r100.f464979c;
            Long r110 = r510.f295510a;
            if (r110 == null) goto L61;
            r108.a(new q(r109, r110.longValue(), r107));
            Iterator<com.larus.bmhome.actionbar.model.w> r111 = this.f373389a.f373384n.iterator();
            int r112 = 0;
        L31:
            if (r111.hasNext() == false) goto L36;
            if (Intrinsics.areEqual(r111.next().f295510a, r510.f295510a) == true) goto L38;
            r112 = r112 + 1;
        L38:
            if (this.f373389a.f373383m == false) goto L40;
            r112 = r112 - 1;
            int r113 = r511 - 1;
        L41:
            z0 r114 = r100.f464988l;
            String r115 = r114.f465007a;
            String r116 = r114.f465009c;
            String r117 = r114.f465010d;
            String r118 = r114.f465012f;
            String r119 = r114.f465013g;
            String r120 = r114.f465016j;
            String r121 = r510.f295511b;
            String r122 = String.valueOf(r510.f295510a);
            n r123 = r100.f464982f;
            if (r123 == null) goto L49;
            Integer r124 = r123.f295324b;
            if (r124 == null) goto L49;
            if (r112 != r124.intValue()) goto L49;
            int r125 = 1;
        L50:
            Integer r126 = Integer.valueOf(r125);
            Integer r210 = Integer.valueOf(r102);
            Integer r211 = Integer.valueOf(r113 + 1);
            if (r107 == true) goto L53;
            String r127 = "select";
        L54:
            tx9.b.e(r115, r116, r117, r118, r119, r120, null, r121, r122, r126, r210, r211, r127, null, null, null, null, "original", null, null, null, null, null, null, r114.f465015i, null, null, null, null, null, null, null, null, null, null, null, null, -33824704, 127);
            return;
        L53:
            r127 = "cancel";
        L49:
            r125 = 0;
            goto L50
        L40:
            r113 = r511;
            goto L41
        L36:
            r112 = -1;
            goto L38
        L61:
            return;
        L26:
            r107 = false;
            goto L27
        L15:
            r105 = null;
            goto L16
        L8:
            r102 = 0;
            goto L9
        }
    }

    public KmpImageTemplateSelectorWithMoreWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpImageTemplateSelectorWithMoreWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Lifecycle.State r100 = null;
        CoroutineScopeKt.cancel$default(this.f373381k, null, 1, null);
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onDetachedFromWindow, current state is ");
        Fragment r103 = getFragment();
        if (r103 == null) goto L7;
        Lifecycle r104 = r103.getLifecycle();
        if (r104 == null) goto L7;
        r100 = r104.getCurrentState();
    L7:
        r102.append(r100);
        r101.i("KmpImageTemplateSelectorWithMoreWidget", r102.toString());
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(com.larus.bmhome.view.actionbar.edit.c r100) {
        this.f373380j = r100;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r210) {
        Intrinsics.checkNotNullParameter(r210, "descriptor");
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r100 = null;
        if ((r210 instanceof w) == false) goto L5;
        w r101 = (w) r210;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        this.f373378h = r101;
        if (this.f373379i == true) goto L44;
        this.f373379i = true;
        BuildersKt.launch$default(this.f373381k, null, null, new KmpImageTemplateSelectorWithMoreWidget$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(this.f373381k, null, null, new KmpImageTemplateSelectorWithMoreWidget$bindObservers$2(this, null), 3, null);
        BuildersKt.launch$default(this.f373381k, null, null, new KmpImageTemplateSelectorWithMoreWidget$bindObservers$3(this, null), 3, null);
        BuildersKt.launch$default(this.f373381k, null, null, new KmpImageTemplateSelectorWithMoreWidget$bindObservers$4(this, null), 3, null);
        if (r101.f464984h == false) goto L17;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r102 = this.f373376f;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L15:
        e1.x(r102.f373205b);
    L17:
        if (o0.d(r101.f464983g) == false) goto L25;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r103 = this.f373376f;
        if (r103 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L21:
        r103.f373208e.setText(r101.f464983g);
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r104 = this.f373376f;
        if (r104 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L24:
        e1.x(r104.f373208e);
    L25:
        boolean r105 = r101.f464986j;
        this.f373383m = r105;
        if (r105 == false) goto L28;
        ImageSelectorWithMoreWidgetAdapter r106 = new ImageSelectorWithMoreWidgetAdapter(this.f373387q, new d(this));
    L29:
        this.f373377g = r106;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r107 = this.f373376f;
        if (r107 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L32:
        y6.d(r107.f373206c, new e(this), null, null, new f(this), 13);
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r108 = this.f373376f;
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L35:
        r108.f373206c.addItemDecoration(new KmpImageTemplateSelectorWithMoreWidget$bindRecyclerViewSpacing$1());
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r109 = this.f373376f;
        if (r109 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L38:
        r109.f373206c.setAdapter(this.f373377g);
        int r110 = r101.f464989m;
        if (r110 <= 0) goto L44;
        this.f373385o = Integer.valueOf(r110 + (this.f373383m ? 1 : 0));
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r111 = this.f373376f;
        if (r111 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L43:
        r111.f373206c.addOnLayoutChangeListener(this.f373388r);
        goto L44
    L28:
        r106 = new ImageSelectorWithMoreWidgetAdapter(this.f373387q, null);
    L44:
        n r112 = r101.f464982f;
        if (r112 == null) goto L47;
        List<com.larus.bmhome.actionbar.model.w> r113 = r112.f295323a;
    L48:
        if (r113 != null) goto L50;
        r113 = CollectionsKt.emptyList();
    L50:
        List<com.larus.bmhome.actionbar.model.w> r114 = r113;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator<T> r116 = r114.iterator();
    L52:
        if (r116.hasNext() == false) goto L54;
        r115.add(com.larus.bmhome.actionbar.model.w.a((com.larus.bmhome.actionbar.model.w) r116.next(), null, null, null, null, null, null, 8388607));
        goto L52
    L54:
        ImageSelectorWithMoreWidgetAdapter r117 = this.f373377g;
        if (r117 == null) goto L57;
        Lazy<JSONObject> r118 = ImageSelectorWithMoreWidgetAdapter.f373457e;
        r117.y2(r115, true);
    L57:
        this.f373384n = r115;
        com.larus.bmhome.view.actionbar.edit.c r119 = this.f373380j;
        if (r119 == null) goto L61;
        r119.setCurImageList(r115);
    L61:
        if (r101.f464989m >= 0) goto L63;
        return;
    L63:
        if (this.f373385o != null) goto L74;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r120 = this.f373376f;
        if (r120 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L68:
        RecyclerView.LayoutManager r121 = r100.f373206c.getLayoutManager();
        if (r121 == null) goto L75;
        r121.scrollToPosition(r101.f464989m + (this.f373383m ? 1 : 0));
        return;
    L75:
        return;
    L67:
        r100 = r120;
        goto L68
    L74:
        return;
    L47:
        r113 = null;
        goto L48
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f373376f = LarusLayoutActionBarEditorWidgetImageSelectorV2Binding.a(LayoutInflater.from(r100), this);
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.larus.uaigc.instruction.kmp.h] */
    public KmpImageTemplateSelectorWithMoreWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f373381k = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.f373384n = CollectionsKt.emptyList();
        this.f373386p = new g(this);
        this.f373387q = new a(this);
        this.f373388r = new h(this);
    }

    public /* synthetic */ KmpImageTemplateSelectorWithMoreWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
