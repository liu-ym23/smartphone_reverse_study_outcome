package com.larus.office.plugins.inputv2.coordinator.runtime.integration;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.keyframes.model.KFFeature;
import com.larus.business.floatchat.api.IAIFloatChatService;
import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.inputv2.a2;
import com.larus.office.plugins.inputv2.coordinator.runtime.conversation.OfficeChatConversationCoordinator;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class OfficeChatIntegrationCoordinator {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f362857p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f362858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f362859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f362860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f362861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f362862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnAttachStateChangeListener f362863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f362864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f362865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OfficeChatConversationCoordinator.b f362866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f362867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f362868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f362869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f362870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f362871n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.larus.office.plugins.inputv2.adapter.g f362872o;

    public static final class a {
    }

    public /* synthetic */ class b implements dw8.h, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeChatIntegrationCoordinator f362873a;

        public b(OfficeChatIntegrationCoordinator r100) {
            this.f362873a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof dw8.h) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, this.f362873a, OfficeChatIntegrationCoordinator.class, "handleConversationDeleted", "handleConversationDeleted(Ljava/lang/String;)Z", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.office.plugins.inputv2.coordinator.runtime.integration.a] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // dw8.h
        public final void a(String r100) {
            final OfficeChatIntegrationCoordinator r101 = this.f362873a;
            OfficeChatConversationCoordinator r102 = r101.f362859b.f362894a;
            r102.getClass();
            boolean r103 = true;
            if (r100 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == true) goto L17;
            OfficeInputParam r105 = r102.f362815c.invoke();
            if (r105 == null) goto L13;
            String r106 = r105.getConversationId();
        L15:
            if (Intrinsics.areEqual(r106, r100) == false) goto L17;
        L18:
            if (r103 == false) goto L24;
            if (r100 == null) goto L25;
            r101.e();
            final long r107 = r101.f362871n;
            r101.f362859b.f362894a.d(r100, r107, new com.larus.office.plugins.inputv2.coordinator.runtime.integration.a(r101, r107));
            r101.a("conversation_deleted_pending");
            return;
        L25:
            return;
        L24:
            return;
        L13:
            r106 = null;
        L17:
            r103 = false;
            goto L18
        L5:
            if (StringsKt.isBlank(r100) == true) goto L8;
            r104 = false;
            goto L9
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeChatIntegrationCoordinator f362874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f362875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OfficeChatConversationCoordinator.b f362876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ChameleonPluginHost f362877d;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            r100.removeOnAttachStateChangeListener(this);
            OfficeChatIntegrationCoordinator r101 = this.f362874a;
            if (r101.f362863f != this) goto L6;
            r101.f362863f = null;
            r101.f362862e = null;
        L6:
            if (r101.f(this.f362875b, this.f362876c.f362827c) == true) goto L8;
            return;
        L8:
            if (this.f362874a.c(this.f362877d, this.f362875b, this.f362876c) == false) goto L12;
            this.f362874a.f362861d.f362900c.invoke(this.f362877d);
            return;
        }

        public c(OfficeChatIntegrationCoordinator r100, FrameLayout r101, OfficeChatConversationCoordinator.b r102, ChameleonPluginHost r103) {
            this.f362874a = r100;
            this.f362875b = r101;
            this.f362876c = r102;
            this.f362877d = r103;
        }
    }

    static {
    }

    public final void e() {
        this.f362871n++;
        Job r100 = this.f362865h;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f362865h = null;
        this.f362866i = null;
        View r101 = this.f362862e;
        View.OnAttachStateChangeListener r102 = this.f362863f;
        if (r101 == null) goto L9;
        if (r102 == null) goto L9;
        r101.removeOnAttachStateChangeListener(r102);
    L9:
        this.f362862e = null;
        this.f362863f = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.List] */
    public final boolean a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        ChameleonPluginHost r100 = this.f362858a.f362901a.invoke();
        if (r100 == null) goto L7;
        Fragment r101 = r100.getFragment();
        if (r101 == null) goto L7;
        FragmentManager r102 = r101.getChildFragmentManager();
    L8:
        com.larus.office.plugins.inputv2.adapter.g r103 = this.f362872o;
        if (r103 == null) goto L11;
        Fragment r104 = r103.f362678a;
    L12:
        if (r102 == null) goto L21;
        List<Fragment> r105 = r102.getFragments();
        if (r105 == null) goto L21;
        ?? r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L17:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((Fragment) r108).getTag(), "office_ai_chat_input_v2") == false) goto L17;
        r106.add(r108);
    L22:
        if (r106 != 0) goto L24;
        r106 = CollectionsKt.emptyList();
    L24:
        List r109 = CollectionsKt.toMutableList((Collection) r106);
        if (r104 != null) goto L27;
    L29:
        boolean r111 = false;
    L30:
        if (r111 == true) goto L32;
    L34:
        this.f362859b.f362894a.n();
        this.f362861d.f362899b.invoke(r103, r110);
        if (r103 == null) goto L37;
        r103.m();
    L37:
        this.f362872o = null;
        if (r109.isEmpty() == false) goto L41;
        return true;
    L41:
        if (r102 != null) goto L43;
    L72:
        FLogger.f375446a.e("OfficeChatIntegration", "移除 wrapper 失败, FragmentManager 不可用, reason=".concat(r110));
        return false;
    L43:
        if (r102.isDestroyed() == true) goto L72;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L51
        FragmentTransaction r113 = r102.beginTransaction();     // Catch: Throwable -> L51
        Iterator r114 = r109.iterator();     // Catch: Throwable -> L51
    L47:
        if (r114.hasNext() == false) goto L49;
        r113.remove((Fragment) r114.next());     // Catch: Throwable -> L51
        goto L47
    L49:
        r113.commitNowAllowingStateLoss();     // Catch: Throwable -> L51
        Object r115 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L51
    L53:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L67;
        FLogger.f375446a.e("OfficeChatIntegration", "同步移除 wrapper 失败, reason=".concat(r110), r116);
        FragmentTransaction r117 = r102.beginTransaction();     // Catch: Throwable -> L62
        Iterator r118 = r109.iterator();     // Catch: Throwable -> L62
    L58:
        if (r118.hasNext() == false) goto L60;
        r117.remove((Fragment) r118.next());     // Catch: Throwable -> L62
        goto L58
    L60:
        Object r119 = Result.m9449constructorimpl(Integer.valueOf(r117.commitAllowingStateLoss()));     // Catch: Throwable -> L62
    L64:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L67;
        FLogger.f375446a.e("OfficeChatIntegration", "异步移除 wrapper 失败, reason=".concat(r110), r120);
    L62:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L67:
        Boolean r122 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r115) == false) goto L71;
        r115 = r122;
    L71:
        return ((Boolean) r115).booleanValue();
    L51:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L53
    L32:
        if (r109.contains(r104) == true) goto L34;
        r109.add(r104);
        goto L34
    L27:
        if (r104.isAdded() != true) goto L29;
        r111 = true;
    L21:
        r106 = 0;
        goto L22
    L11:
        r104 = null;
    L7:
        r102 = null;
        goto L8
    }

    public final void h(String r110) {
        Intrinsics.checkNotNullParameter(r110, "source");
        this.f362870m = r110;
        final ChameleonPluginHost r100 = this.f362858a.f362901a.invoke();
        final FrameLayout r111 = this.f362858a.f362902b.invoke();
        if (this.f362867j == false) goto L57;
        if (r100 == null) goto L57;
        if (r111 == null) goto L57;
        if (this.f362858a.f362906f.invoke().booleanValue() == false) goto L11;
        this.f362860c.f362897a.invoke("embedded#".concat(r110));
        FLogger.f375446a.i("OfficeChatIntegration", "内嵌 Bitable 不创建自身 wrapper, source=".concat(r110));
        return;
    L11:
        com.larus.office.plugins.inputv2.adapter.g r101 = this.f362872o;
        if (r101 == null) goto L18;
        Fragment r102 = r101.f362678a;
        if (r102 == null) goto L18;
        if (r102.isAdded() != true) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L21;
        return;
    L21:
        com.bytedance.ee.bear.document.d r104 = this.f362858a.f362905e.invoke();
        if (r104 != null) goto L24;
    L26:
        boolean r105 = false;
    L27:
        if (r105 == false) goto L30;
        FLogger.f375446a.i("OfficeChatIntegration", "版本文档不创建 wrapper");
        return;
    L30:
        final long r112 = this.f362871n;
        if (this.f362868k == false) goto L35;
        g(r100, r111, r112);
        return;
    L35:
        if (this.f362869l == true) goto L69;
        Long r106 = this.f362864g;
        if (r106 != null) goto L40;
    L42:
        com.larus.office.h r107 = this.f362858a.f362904d.invoke();
        if (r107 != null) goto L46;
        this.f362869l = true;
        FLogger.f375446a.e("OfficeChatIntegration", "OfficeHostAbilityProvider 不可用");
        return;
    L46:
        this.f362864g = Long.valueOf(r112);
        final AtomicBoolean r113 = new AtomicBoolean(false);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L49
        r107.pd("AIChatPluginV2#createInputFragment", new com.larus.office.plugins.inputv2.coordinator.runtime.integration.b(r113, this, r100, r111, r112));     // Catch: Throwable -> L49
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L49
    L52:
        if (Result.m9452exceptionOrNullimpl(r109) != null) goto L54;
        return;
    L54:
        if (r113.compareAndSet(false, true) == false) goto L71;
        t0.f375468a.post(new com.larus.office.plugins.inputv2.coordinator.runtime.integration.c(this, r100, r111, r112));
        return;
    L71:
        return;
    L49:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    L40:
        if (r106.longValue() != r112) goto L42;
        return;
    L69:
        return;
    L24:
        if (r104.isEditionDoc() != true) goto L26;
        r105 = true;
    L18:
        r103 = false;
    L57:
        FLogger r115 = FLogger.f375446a;
        StringBuilder r116 = new StringBuilder("暂不创建, source=");
        r116.append(r110);
        r116.append(", loaded=");
        r116.append(this.f362867j);
        r116.append(", hasHost=");
        if (r100 == null) goto L60;
        boolean r117 = true;
    L61:
        r116.append(r117);
        r116.append(", hasContainer=");
        if (r111 == null) goto L64;
        boolean r118 = true;
    L65:
        r116.append(r118);
        r115.i("OfficeChatIntegration", r116.toString());
        return;
    L64:
        r118 = false;
        goto L65
    L60:
        r117 = false;
        goto L61
    }

    public final boolean f(FrameLayout r100, long r101) {
        if (this.f362871n == r101) goto L5;
    L7:
        return false;
    L5:
        if (this.f362858a.f362902b.invoke() != r100) goto L7;
        return true;
    }

    public final boolean c(ChameleonPluginHost r110, FrameLayout r111, OfficeChatConversationCoordinator.b r112) {
        FragmentManager r100 = r110.getFragment().getChildFragmentManager();
        if (f(r111, r112.f362827c) == true) goto L5;
    L89:
        return false;
    L5:
        if (r110.getFragment().isAdded() == false) goto L89;
        if (r100.isDestroyed() == true) goto L89;
        if (r111.isAttachedToWindow() == false) goto L89;
        if (r111.getId() != (-1)) goto L15;
        r111.setId(View.generateViewId());
    L15:
        if (a("replace_before_integrate") == true) goto L17;
        return false;
    L17:
        IAIFloatChatService r113 = (IAIFloatChatService) ServiceManager.get().getService(IAIFloatChatService.class);
        com.larus.office.plugins.inputv2.adapter.g r101 = null;
        if (r113 != null) goto L95;
        Fragment r114 = null;
    L34:
        if (r114 != null) goto L36;
        return false;
    L36:
        int r102 = com.larus.office.plugins.inputv2.adapter.g.f362677s;
        Intrinsics.checkNotNullParameter(r114, WidgetService.PARAM_FRAGMENT);
        if ((r114 instanceof dw8.s) == false) goto L39;
        dw8.s r103 = (dw8.s) r114;
    L41:
        if ((r114 instanceof dw8.q) == false) goto L43;
        dw8.q r104 = (dw8.q) r114;
    L45:
        if (r103 == null) goto L52;
        if (r104 == null) goto L52;
        r101 = new com.larus.office.plugins.inputv2.adapter.g(r114, r103, r104);     // Catch: Throwable -> L50
    L61:
        if (r101 != null) goto L90;
        return false;
    L90:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L79
        b r106 = new b(this);     // Catch: Throwable -> L79
        if (r101.f362693p == false) goto L93;
    L70:
        FragmentTransaction r107 = r100.beginTransaction();     // Catch: Throwable -> L79
        int r108 = r111.getId();     // Catch: Throwable -> L79
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r107, r114, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "office_ai_chat_input_v2", r108) == true) goto L74;
        r107 = r107.add(r108, r114, "office_ai_chat_input_v2");     // Catch: Throwable -> L79
    L74:
        r107.commitNowAllowingStateLoss();     // Catch: Throwable -> L79
        if (f(r111, r112.f362827c) == false) goto L78;
        this.f362859b.f362896c.a(r114, r101);     // Catch: Throwable -> L79
        this.f362872o = r101;     // Catch: Throwable -> L79
        this.f362859b.f362894a.b(r101, r112.f362827c);     // Catch: Throwable -> L79
        this.f362861d.f362898a.invoke(r101, Long.valueOf(r112.f362827c));     // Catch: Throwable -> L79
        Object r115 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L79
    L81:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L84;
        FLogger.f375446a.e("OfficeChatIntegration", "挂载 wrapper 失败", r116);
        r101.m();
        a("integrate_failed");
    L84:
        Boolean r117 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r115) == false) goto L88;
        r115 = r117;
    L88:
        return ((Boolean) r115).booleanValue();
    L78:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L79
    L93:
        r101.f362679b.gP(r106);     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "更新会话删除 handler 失败", th);     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L50:
        th = move-exception;
        FLogger.f375446a.e("OfficeChatInputAdapter", "创建 Adapter 失败, 注册 Host 状态监听异常", th);
    L52:
        FLogger r109 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder("创建 Adapter 失败, fragment=");
        r119.append(r114.getClass().getName());
        r119.append(", hasController=");
        boolean r120 = true;
        if (r103 == null) goto L55;
        boolean r121 = true;
    L56:
        r119.append(r121);
        r119.append(", hasAbilityHost=");
        if (r104 != null) goto L60;
        r120 = false;
    L60:
        r119.append(r120);
        r109.e("OfficeChatInputAdapter", r119.toString());
        goto L61
    L55:
        r121 = false;
        goto L56
    L43:
        r104 = null;
        goto L45
    L39:
        r103 = null;
        goto L41
    L95:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L25
        int r123 = a2.f362666a;     // Catch: Throwable -> L25
        Bundle r124 = a2.a(r112.f362825a, r112.f362826b, this.f362858a.f362903c.invoke(), this.f362858a.f362904d.invoke(), this.f362859b.f362895b.b(this.f362870m), this.f362859b.f362895b.a(this.f362870m), this.f362858a.f362908h.invoke().booleanValue());     // Catch: Throwable -> L25
        Integer r125 = this.f362858a.f362907g.invoke();     // Catch: Throwable -> L25
        if (r125 == null) goto L23;
        r124.putInt("argHostChatBackgroundColor", r125.intValue());     // Catch: Throwable -> L25
    L23:
        Object r126 = Result.m9449constructorimpl(r113.a(r124));     // Catch: Throwable -> L25
    L27:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);
        if (r127 == null) goto L31;
        FLogger.f375446a.e("OfficeChatIntegration", "创建 wrapper 失败", r127);
    L31:
        if (Result.m9455isFailureimpl(r126) == false) goto L33;
        r126 = null;
    L33:
        r114 = (Fragment) r126;
    L25:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    public final void d(ChameleonPluginHost r100, FrameLayout r101, OfficeChatConversationCoordinator.b r102) {
        View r103 = this.f362862e;
        View.OnAttachStateChangeListener r104 = this.f362863f;
        if (r103 == null) goto L6;
        if (r104 == null) goto L6;
        r103.removeOnAttachStateChangeListener(r104);
    L6:
        this.f362862e = null;
        this.f362863f = null;
        if (f(r101, r102.f362827c) == false) goto L27;
        com.larus.office.plugins.inputv2.adapter.g r105 = this.f362872o;
        if (r105 == null) goto L15;
        Fragment r106 = r105.f362678a;
        if (r106 == null) goto L15;
        boolean r107 = true;
        if (r106.isAdded() != true) goto L15;
    L16:
        if (r107 == false) goto L19;
        return;
    L19:
        if (r101.isAttachedToWindow() == true) goto L21;
        c r108 = new c(this, r101, r102, r100);
        this.f362862e = r101;
        this.f362863f = r108;
        r101.addOnAttachStateChangeListener(r108);
        return;
    L21:
        if (c(r100, r101, r102) == false) goto L26;
        this.f362861d.f362900c.invoke(r100);
        return;
    L26:
        return;
    L15:
        r107 = false;
        goto L16
    }

    public final void g(ChameleonPluginHost r110, FrameLayout r111, long r112) {
        OfficeChatConversationCoordinator.b r100 = this.f362866i;
        LifecycleCoroutineScope r101 = null;
        boolean r102 = true;
        if (r100 != null) goto L5;
    L14:
        Job r103 = this.f362865h;
        if (r103 != null) goto L17;
    L19:
        boolean r104 = false;
    L20:
        if (r104 == false) goto L22;
        return;
    L22:
        IAIFloatChatService r105 = (IAIFloatChatService) ServiceManager.get().getService(IAIFloatChatService.class);
        LifecycleOwner r106 = r110.getFragment().getViewLifecycleOwnerLiveData().getValue();
        if (r106 == null) goto L25;
        r101 = LifecycleOwnerKt.getLifecycleScope(r106);
    L25:
        LifecycleCoroutineScope r107 = r101;
        if (r105 == null) goto L31;
        if (r107 == null) goto L31;
        this.f362865h = BuildersKt.launch$default(r107, null, null, new OfficeChatIntegrationCoordinator$prepareAndIntegrate$3(this, r105, r112, r111, r110, null), 3, null);
        return;
    L31:
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("准备会话失败, hasService=");
        if (r105 == null) goto L34;
        boolean r113 = true;
    L35:
        r109.append(r113);
        r109.append(", hasScope=");
        if (r107 != null) goto L39;
        r102 = false;
    L39:
        r109.append(r102);
        r108.e("OfficeChatIntegration", r109.toString());
        return;
    L34:
        r113 = false;
        goto L35
    L17:
        if (r103.isActive() != true) goto L19;
        r104 = true;
        goto L20
    L5:
        if (r100.f362827c != r112) goto L7;
        boolean r114 = true;
    L8:
        if (r114 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L14;
        d(r110, r111, r100);
        return;
    L7:
        r114 = false;
        goto L8
    }

    public OfficeChatIntegrationCoordinator(h r100, e r101, f r102, g r103) {
        Intrinsics.checkNotNullParameter(r100, "runtime");
        Intrinsics.checkNotNullParameter(r101, "dependencies");
        Intrinsics.checkNotNullParameter(r102, KFFeature.EFFECT_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r103, "lifecycleCallbacks");
        this.f362858a = r100;
        this.f362859b = r101;
        this.f362860c = r102;
        this.f362861d = r103;
        this.f362870m = "AIChatPluginV2#createInputFragment";
    }

    public final void b(ChameleonPluginHost r100, FrameLayout r101, long r102, boolean r103) {
        Long r104 = this.f362864g;
        if (r104 == null) goto L9;
        if (r104.longValue() != r102) goto L9;
        this.f362864g = null;
    L9:
        if (f(r101, r102) == true) goto L12;
        FLogger.f375446a.i("OfficeChatIntegration", "忽略迟到 Flow ready callback, generation=" + r102);
        return;
    L12:
        this.f362868k = r103;
        this.f362869l = !r103;
        if (r103 == true) goto L15;
        return;
    L15:
        g(r100, r101, r102);
    }
}
