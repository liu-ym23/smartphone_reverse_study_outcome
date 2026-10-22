package com.larus.uaigc.avatar.instruction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.home.impl.sdk.k1;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderV2Binding;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import tx9.u3;
import v19.y6;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003*\u0002\u001b\"\u0018\u00002\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001a\u0010$\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u001eH\u0014J\b\u0010(\u001a\u00020\u001eH\u0016J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001eH\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#¨\u00060"}, d2 = {"Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding;", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding;", "setBinding", "(Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding;)V", "coverBinding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionbarImageTemplateCoverHolderV2Binding;", "adapter", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarSelectorWidgetAdapter;", "controller", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorController;", "getController", "()Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarDigitalAvatarTemplateInstructionTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarDigitalAvatarTemplateInstructionTemplate;", "collected", "", "digitalAvatarTemplateDialogCallback", "com/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget$digitalAvatarTemplateDialogCallback$1", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget$digitalAvatarTemplateDialogCallback$1;", "selectDigitalAvatarTemplateInfo", "", "templateInfo", "Lcom/larus/bmhome/avatar/api/DigitalAvatarTemplate;", "itemClickCallback", "com/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget$itemClickCallback$1", "Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget$itemClickCallback$1;", "init", "attrs", "Landroid/util/AttributeSet;", "onDetachedFromWindow", "onBindView", "bindObservers", "requestTemplateList", "reportCreationRecommendOpCounter", "templatePrimaryKey", "", "goToDigitalAvatarTemplateList", "CountOption", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigitalAvatarTemplateListSelectorWidget extends AbsInstructionWidget {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f370304l = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding f370305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusItemActionbarImageTemplateCoverHolderV2Binding f370306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DigitalAvatarSelectorWidgetAdapter f370307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f370308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f370309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f370310k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/uaigc/avatar/instruction/DigitalAvatarTemplateListSelectorWidget$CountOption;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CountOption {
        public static final a Companion = null;
        public static final int DECR = 2;
        public static final int INCR = 1;
        public static final int UNKNOWN = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f370311a = null;

            static {
                f370311a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f370311a;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DigitalAvatarTemplateListSelectorWidget f370312a;

        public a(DigitalAvatarTemplateListSelectorWidget r100) {
            this.f370312a = r100;
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DigitalAvatarTemplateListSelectorWidget f370313a;

        public b(DigitalAvatarTemplateListSelectorWidget r100) {
            this.f370313a = r100;
        }

        @Override // com.larus.uaigc.avatar.instruction.e
        public final void a(com.larus.bmhome.actionbar.model.f r410, int r411) {
            Intrinsics.checkNotNullParameter(r410, MapController.ITEM_LAYER_TAG);
            i r100 = DigitalAvatarTemplateListSelectorWidget.o6(this.f370313a);
            if (r100 == null) goto L5;
            r100.f370324m = null;
        L5:
            com.larus.bmhome.actionbar.model.e r101 = DigitalAvatarTemplateListSelectorWidget.s6(this.f370313a);
            if (r101 == null) goto L20;
            List<com.larus.bmhome.actionbar.model.f> r102 = r101.f295081c;
            if (r102 == null) goto L20;
            Iterator<T> r103 = r102.iterator();
        L11:
            if (r103.hasNext() == false) goto L18;
            Object r104 = r103.next();
            if (((com.larus.bmhome.actionbar.model.f) r104).f295101a != r410.f295101a) goto L15;
            boolean r105 = true;
        L16:
            if (r105 == false) goto L11;
        L19:
            com.larus.bmhome.actionbar.model.f r106 = (com.larus.bmhome.actionbar.model.f) r104;
        L21:
            if (r106 == null) goto L33;
            com.larus.bmhome.actionbar.model.e r107 = DigitalAvatarTemplateListSelectorWidget.s6(this.f370313a);
            if (r107 == null) goto L36;
            List<com.larus.bmhome.actionbar.model.f> r108 = r107.f295081c;
            if (r108 == null) goto L36;
            Iterator<T> r109 = r108.iterator();
        L28:
            if (r109.hasNext() == false) goto L36;
            com.larus.bmhome.actionbar.model.f r110 = (com.larus.bmhome.actionbar.model.f) r109.next();
            if (r110.f295101a == r410.f295101a) goto L31;
            r110.f295108h = 0;
            goto L28
        L31:
            r110.f295108h = 1;
        L36:
            com.larus.bmhome.view.actionbar.edit.c r111 = this.f370313a.getViewModel();
            if (r111 == null) goto L44;
            ChatParam r112 = r111.getChatParam();
            if (r112 == null) goto L44;
            String r113 = r112.f296890b;
            if (r113 == null) goto L44;
            String r114 = r113;
        L45:
            String r115 = String.valueOf(r410.f295101a);
            com.larus.bmhome.view.actionbar.edit.c r116 = this.f370313a.getViewModel();
            if (r116 == null) goto L53;
            ChatParam r117 = r116.getChatParam();
            if (r117 == null) goto L53;
            String r118 = r117.f296893e;
            if (r118 == null) goto L53;
            String r119 = r118;
        L54:
            u3.l(r114, r115, "chat_action_bar", r119, "replica", "avatar2image", "default", null, Integer.valueOf(r411), null, null, 4, null, null, null, "action_bar_template", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -140416, 31);
            DigitalAvatarTemplateListSelectorWidget r120 = this.f370313a;
            long r121 = r410.f295101a;
            r120.getClass();
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DigitalAvatarTemplateListSelectorWidget$reportCreationRecommendOpCounter$1(r121, null), 2, null);
            com.larus.bmhome.view.actionbar.edit.c r122 = this.f370313a.getViewModel();
            if (r122 == null) goto L69;
            r122.onInstructionDigitalAvatarTemplateSelected(r410);
            return;
        L69:
            return;
        L53:
            r119 = "";
        L44:
            r114 = "";
            goto L45
        L33:
            i r123 = DigitalAvatarTemplateListSelectorWidget.o6(this.f370313a);
            if (r123 == null) goto L36;
            r123.f370324m = r410;
            goto L36
        L15:
            r105 = false;
            goto L16
        L18:
            r104 = null;
        L20:
            r106 = null;
            goto L21
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.uaigc.avatar.instruction.q] */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v9, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.home.impl.sdk.k1] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.uaigc.avatar.instruction.p] */
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
        @Override // com.larus.uaigc.avatar.instruction.e
        public final void b(com.larus.bmhome.actionbar.model.f r310, int r410, View r411) {
            Intrinsics.checkNotNullParameter(r310, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r411, "view");
            com.larus.bmhome.actionbar.model.e r100 = DigitalAvatarTemplateListSelectorWidget.s6(this.f370313a);
            String r101 = null;
            if (r100 == null) goto L22;
            List<com.larus.bmhome.actionbar.model.f> r102 = r100.f295081c;
            if (r102 == null) goto L22;
            List<com.larus.bmhome.actionbar.model.f> r103 = r102;
            ?? r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
            Iterator r105 = r103.iterator();
        L8:
            if (r105.hasNext() == false) goto L23;
            com.larus.bmhome.actionbar.model.f r106 = (com.larus.bmhome.actionbar.model.f) r105.next();
            String r107 = String.valueOf(r106.f295101a);
            int r108 = 3;
            Integer r109 = null;
            g1 r110 = r106.f295105e;
            if (r110 == null) goto L12;
            Image r111 = gy9.d.b(r110);
        L13:
            g1 r112 = r106.f295106f;
            if (r112 == null) goto L16;
            Image r113 = gy9.d.b(r112);
        L17:
            g1 r114 = r106.f295107g;
            if (r114 == null) goto L20;
            Image r115 = gy9.d.b(r114);
        L21:
            r104.add(new UserCreation(r107, r108, r109, new UserCreationContent(new UserCreationUserAvatar(new ImageInfo(r113, r111, r115, null, null, null, null, null, null, 1016), r106.f295103c, 26), 59), 131052));
            goto L8
        L20:
            r115 = null;
            goto L21
        L16:
            r113 = null;
            goto L17
        L12:
            r111 = null;
        L23:
            final ?? r116 = r104;
            i r117 = DigitalAvatarTemplateListSelectorWidget.o6(this.f370313a);
            if (r117 == null) goto L28;
            boolean r118 = true;
            if (r117.f370323l != true) goto L28;
        L29:
            if (r118 == false) goto L31;
            final int r119 = r410 - 1;
        L32:
            IFlowSdkDepend r120 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r120 == null) goto L39;
            r120.w();
            ?? r121 = k1.f346194a;
            Fragment r122 = this.f370313a.getFragment();
            if (r122 == null) goto L37;
            FragmentManager r123 = r122.getParentFragmentManager();
        L38:
            final DigitalAvatarTemplateListSelectorWidget r124 = this.f370313a;
            r121.n(r123, r116, r119, new p(r116, r124), new q(r119, r124));
            goto L39
        L37:
            r123 = null;
        L39:
            String r125 = String.valueOf(r310.f295101a);
            com.larus.bmhome.view.actionbar.edit.c r126 = this.f370313a.getViewModel();
            if (r126 == null) goto L44;
            ChatParam r127 = r126.getChatParam();
            if (r127 == null) goto L44;
            String r128 = r127.f296890b;
        L45:
            com.larus.bmhome.view.actionbar.edit.c r129 = this.f370313a.getViewModel();
            if (r129 == null) goto L50;
            ChatParam r130 = r129.getChatParam();
            if (r130 == null) goto L50;
            r101 = r130.f296893e;
        L50:
            u3.g(r128, r125, "replica", "avatar2image", null, "default", null, null, null, "click_action_bar", "action_bar_template", Integer.valueOf(r410), r101, 11, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -30256, 7);
            return;
        L44:
            r128 = null;
            goto L45
        L31:
            r119 = r410;
        L28:
            r118 = false;
        L22:
            r104 = CollectionsKt.emptyList();
            goto L23
        }
    }

    public final LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding getBinding() {
        LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding r100 = this.f370305f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final i getController() {
        return (i) getController();
    }

    private final com.larus.bmhome.actionbar.model.e getCurrentBindData() {
        i r100 = getController();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f370325n;
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        u r100 = getInstructionItem();
        boolean r101 = false;
        if (r100 == null) goto L5;
        boolean r102 = Intrinsics.areEqual(r100.f295479f, Boolean.TRUE);
    L6:
        if (r102 == false) goto L8;
        e1.x(getBinding().f373189b);
    L8:
        u r103 = getInstructionItem();
        if (r103 == null) goto L11;
        String r104 = r103.f295476c;
    L13:
        if (o0.d(r104) == false) goto L19;
        TextView r105 = getBinding().f373192e;
        u r106 = getInstructionItem();
        if (r106 == null) goto L17;
        String r107 = r106.f295476c;
    L18:
        r105.setText(r107);
        e1.x(getBinding().f373192e);
        goto L19
    L17:
        r107 = null;
    L19:
        i r108 = getController();
        if (r108 != null) goto L22;
    L24:
        if (r101 == false) goto L26;
        this.f370307h = new DigitalAvatarSelectorWidgetAdapter(this.f370310k, new j(this));
    L27:
        getBinding().f373190c.setAdapter(this.f370307h);
        getBinding().f373190c.addItemDecoration(new DigitalAvatarTemplateListSelectorWidget$onBindView$2());
        y6.f(getBinding().f373190c, new k(this), new l(this), 0.0f, new m(this), 57);
        DigitalAvatarSelectorWidgetAdapter r109 = this.f370307h;
        if (r109 == null) goto L35;
        com.larus.bmhome.actionbar.model.e r110 = getCurrentBindData();
        if (r110 == null) goto L32;
        List<com.larus.bmhome.actionbar.model.f> r111 = r110.f295081c;
    L33:
        r109.submitList(r111);
        goto L35
    L32:
        r111 = null;
    L35:
        if (this.f370308i == true) goto L42;
        this.f370308i = true;
        CoroutineScope r112 = getComponentScope();
        if (r112 == null) goto L41;
        BuildersKt.launch$default(r112, null, null, new DigitalAvatarTemplateListSelectorWidget$bindObservers$1(this, null), 3, null);
        return;
    L41:
        return;
    L42:
        return;
    L26:
        this.f370307h = new DigitalAvatarSelectorWidgetAdapter(this.f370310k, null);
        goto L27
    L22:
        if (r108.f370323l != true) goto L24;
        r101 = true;
        goto L24
    L11:
        r104 = null;
        goto L13
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("onDetachedFromWindow ,current state is ");
        Fragment r102 = getFragment();
        if (r102 == null) goto L7;
        Lifecycle r103 = r102.getLifecycle();
        if (r103 == null) goto L7;
        Lifecycle.State r104 = r103.getCurrentState();
    L8:
        r101.append(r104);
        r100.i("DigitalAvatarTemplateListSelectorWidget", r101.toString());
        return;
    L7:
        r104 = null;
        goto L8
    }

    public DigitalAvatarTemplateListSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        super(r100, r101, 6, 0);
        this.f370309j = new a(this);
        this.f370310k = new b(this);
    }

    public static final /* synthetic */ i o6(DigitalAvatarTemplateListSelectorWidget r100) {
        return r100.getController();
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.e s6(DigitalAvatarTemplateListSelectorWidget r100) {
        return r100.getCurrentBindData();
    }

    public final void setBinding(LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f370305f = r100;
    }

    public final void u6(ab8.a r110) {
        i r100 = getController();
        com.larus.bmhome.actionbar.model.f r101 = null;
        if (r100 == null) goto L5;
        r100.f370324m = null;
    L5:
        i r102 = getController();
        if (r102 == null) goto L24;
        com.larus.bmhome.actionbar.model.e r103 = getCurrentBindData();
        if (r103 == null) goto L22;
        List<com.larus.bmhome.actionbar.model.f> r104 = r103.f295081c;
        if (r104 == null) goto L22;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L20;
        Object r106 = r105.next();
        if (((com.larus.bmhome.actionbar.model.f) r106).f295101a != r110.a()) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L13;
    L21:
        com.larus.bmhome.actionbar.model.f r108 = (com.larus.bmhome.actionbar.model.f) r106;
    L23:
        r102.f370324m = r108;
        goto L24
    L17:
        r107 = false;
        goto L18
    L20:
        r106 = null;
    L22:
        r108 = null;
    L24:
        i r109 = getController();
        if (r109 == null) goto L27;
        com.larus.bmhome.actionbar.model.f r111 = r109.f370324m;
    L28:
        if (r111 == null) goto L40;
        com.larus.bmhome.actionbar.model.e r112 = getCurrentBindData();
        if (r112 == null) goto L43;
        List<com.larus.bmhome.actionbar.model.f> r113 = r112.f295081c;
        if (r113 == null) goto L43;
        Iterator<T> r114 = r113.iterator();
    L35:
        if (r114.hasNext() == false) goto L43;
        com.larus.bmhome.actionbar.model.f r115 = (com.larus.bmhome.actionbar.model.f) r114.next();
        if (r115.f295101a == r110.a()) goto L38;
        r115.f295108h = 0;
        goto L35
    L38:
        r115.f295108h = 1;
    L43:
        com.larus.bmhome.view.actionbar.edit.c r116 = getViewModel();
        if (r116 == null) goto L72;
        ChatParam r117 = r116.getChatParam();
        if (r117 == null) goto L72;
        String r118 = r117.f296889a;
        if (r118 == null) goto L72;
        IAIChatRenderTraceService.Companion r119 = IAIChatRenderTraceService.f365896a;
        Pair[] r120 = new Pair[6];
        UserCreation r121 = r110.f2499a;
        if (r121 == null) goto L52;
        String r122 = r121.f364987a;
    L53:
        r120[0] = TuplesKt.to("from_template_id", r122);
        UserCreation r123 = r110.f2499a;
        if (r123 == null) goto L56;
        String r124 = zp9.d.d(r123);
    L57:
        r120[1] = TuplesKt.to("from_template_type", r124);
        UserCreation r125 = r110.f2499a;
        if (r125 == null) goto L62;
        UserCreationTrackParams r126 = r125.f365000n;
        if (r126 == null) goto L62;
        String r127 = r126.f365040a;
    L63:
        r120[2] = TuplesKt.to("template_rec_req_id", r127);
        UserCreation r128 = r110.f2499a;
        if (r128 == null) goto L66;
        String r129 = zp9.d.b(r128);
    L67:
        r120[3] = TuplesKt.to("from_template_source", r129);
        r120[4] = TuplesKt.to("is_from_template", "1");
        UserCreation r130 = r110.f2499a;
        if (r130 == null) goto L70;
        String r131 = r130.f364995i;
    L71:
        r120[5] = TuplesKt.to("template_rec_extra", r131);
        r119.c(r118, MapsKt.mapOf(r120));
        goto L72
    L70:
        r131 = null;
        goto L71
    L66:
        r129 = null;
    L62:
        r127 = null;
        goto L63
    L56:
        r124 = null;
        goto L57
    L52:
        r122 = null;
    L72:
        com.larus.bmhome.view.actionbar.edit.c r132 = getViewModel();
        if (r132 == null) goto L90;
        i r133 = getController();
        if (r133 == null) goto L77;
        r101 = r133.f370324m;
    L77:
        r132.onInstructionDigitalAvatarTemplateSelected(r101);
        return;
    L90:
        return;
    L40:
        i r134 = getController();
        if (r134 == null) goto L43;
        r134.f370324m = new com.larus.bmhome.actionbar.model.f(r110.a(), r110.e(), r110.d(), r110.b(), r110.c(), null, 138);
        goto L43
    L27:
        r111 = null;
        goto L28
    }

    public static Object i6(DigitalAvatarTemplateListSelectorWidget r100, int r101) {
        com.larus.bmhome.actionbar.model.e r102 = r100.getCurrentBindData();
        if (r102 == null) goto L7;
        List<com.larus.bmhome.actionbar.model.f> r103 = r102.f295081c;
        if (r103 == null) goto L7;
        com.larus.bmhome.actionbar.model.f r104 = (com.larus.bmhome.actionbar.model.f) CollectionsKt.getOrNull(r103, r101);
    L8:
        StringBuilder r105 = new StringBuilder();
        if (r104 == null) goto L11;
        long r106 = r104.f295101a;
    L12:
        r105.append(r106);
        r105.append('_');
        if (r104 == null) goto L16;
        String r107 = r104.f295103c;
        if (r107 == null) goto L16;
    L17:
        r105.append(r107);
        return r105.toString();
    L16:
        r107 = "";
        goto L17
    L11:
        r106 = 0;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_action_bar_editor_widget_digital_avatar_template_selector_v2, this);
        int r102 = R.id.bottom_divider;
        View r103 = ViewBindings.findChildViewById(this, R.id.bottom_divider);
        if (r103 == null) goto L13;
        r102 = R.id.digital_avatar_template_list;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(this, R.id.digital_avatar_template_list);
        if (r104 == null) goto L13;
        r102 = R.id.share_container;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.share_container);
        if (r105 == null) goto L13;
        r102 = R.id.tv_digital_avatar_selector_title;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_digital_avatar_selector_title);
        if (r106 == null) goto L13;
        setBinding(new LarusLayoutActionBarEditorWidgetDigitalAvatarTemplateSelectorV2Binding(this, r103, r104, r105, r106));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public static boolean k6(DigitalAvatarTemplateListSelectorWidget r100, int r101, RecyclerView.ViewHolder r102) {
        Intrinsics.checkNotNullParameter(r102, "<unused var>");
        i r103 = r100.getController();
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
        if (r101 != 0) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r103.f370323l != true) goto L7;
        r104 = true;
        goto L8
    }

    public static void n6(DigitalAvatarTemplateListSelectorWidget r310, int r311, RecyclerView.ViewHolder r312) {
        int r100 = r311;
        Intrinsics.checkNotNullParameter(r312, "<unused var>");
        com.larus.bmhome.actionbar.model.e r101 = r310.getCurrentBindData();
        String r102 = null;
        if (r101 == null) goto L7;
        List<com.larus.bmhome.actionbar.model.f> r103 = r101.f295081c;
        if (r103 == null) goto L7;
        com.larus.bmhome.actionbar.model.f r104 = (com.larus.bmhome.actionbar.model.f) CollectionsKt.getOrNull(r103, r100);
    L8:
        com.larus.bmhome.view.actionbar.edit.c r105 = r310.getViewModel();
        if (r105 == null) goto L13;
        ChatParam r106 = r105.getChatParam();
        if (r106 == null) goto L13;
        String r107 = r106.f296890b;
    L14:
        if (r104 == null) goto L16;
        Long r108 = Long.valueOf(r104.f295101a);
    L17:
        String r109 = String.valueOf(r108);
        i r110 = r310.getController();
        if (r110 == null) goto L22;
        boolean r111 = true;
        if (r110.f370323l != true) goto L22;
    L23:
        if (r111 == true) goto L26;
        r100 = r100 + 1;
    L26:
        String r112 = String.valueOf(r100);
        com.larus.bmhome.view.actionbar.edit.c r113 = r310.getViewModel();
        if (r113 == null) goto L31;
        ChatParam r114 = r113.getChatParam();
        if (r114 == null) goto L31;
        r102 = r114.f296893e;
    L31:
        u3.k(r107, r109, "replica", "avatar2image", null, null, null, null, null, VoiceInputFrom.ACTION_BAR, "chat", r112, null, r102, null, null, null, null, null, "create_button_panel", null, null, null, false, null, null, null, null, null, null, -536080);
        return;
    L22:
        r111 = false;
        goto L23
    L16:
        r108 = null;
    L13:
        r107 = null;
    L7:
        r104 = null;
        goto L8
    }
}
