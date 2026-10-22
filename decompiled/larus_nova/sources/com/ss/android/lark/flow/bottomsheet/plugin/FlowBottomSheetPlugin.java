package com.ss.android.lark.flow.bottomsheet.plugin;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.flow.chat.titlebar.FlowTitleBarComponent;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import v99.f;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowBottomSheetPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f421987t = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ITitlebarComponent f421988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IKeyboardComponent f421989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.c f421990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FlowBottomSheetPluginViewModel f421991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public wxa.a f421992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f421993l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f421994m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f421995n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f421996o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f421997p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f421998q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f421999r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f422000s;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final boolean A() {
        return false;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void E() {
        Log.i("ChatBottomSheetPlugin", "onStop invoke");
        FlowBottomSheetPluginViewModel r100 = this.f421991j;
        if (r100 == null) goto L6;
        r100.sendTimeDuration();
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin, com.ss.android.lark.chat.chatwindow.biz.plugin.core.d
    public final void onStart() {
        Log.i("ChatBottomSheetPlugin", "onStart invoke");
        FlowBottomSheetPluginViewModel r100 = this.f421991j;
        if (r100 == null) goto L6;
        r100.recordStartTime();
        return;
    }

    public FlowBottomSheetPlugin() {
        this.f421993l = new Object();
        this.f421996o = LazyKt.lazy(FlowBottomSheetPlugin$halfScreenRightActionInterceptor$2.INSTANCE);
        this.f421997p = LazyKt.lazy(FlowBottomSheetPlugin$halfScreenLeftActionInterceptor$2.INSTANCE);
        this.f421998q = LazyKt.lazy(new FlowBottomSheetPlugin$backHitPointActionInterceptor$2(this));
        this.f421999r = LazyKt.lazy(new FlowBottomSheetPlugin$expandAction$2(this));
        this.f422000s = LazyKt.lazy(new FlowBottomSheetPlugin$closeAction$2(this));
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        super.D();
        FlowBottomSheetPluginViewModel r100 = this.f421991j;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        this.f421991j = null;
    }

    public static final Lazy F(FlowBottomSheetPlugin r100) {
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r101 = r100.f421990i;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r101 = null;
    L5:
        final Fragment r102 = r101.getFragment();
        return FragmentViewModelLazyKt.createViewModelLazy(r102, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new FlowBottomSheetPlugin$special$$inlined$activityViewModels$default$1(r102), new FlowBottomSheetPlugin$special$$inlined$activityViewModels$default$2(r102));
    }

    public final void G(com.ss.android.lark.keyboard.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f421994m == true) goto L9;
        this.f421994m = true;
        r100.e().of(this.f421993l).c(k2b.a.class, new FlowBottomSheetPlugin$ensureObserveSuppressMarginChange$1(this));
        return;
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        this.f421990i = r100;
        boolean r102 = r100.u().D();
        String r103 = r101.f488505e;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        FlowBottomSheetPluginViewModel r105 = new FlowBottomSheetPluginViewModel(r103);
        this.f421991j = r105;
        r105.create();
    L12:
        if (r102 == true) goto L15;
        return;
    L15:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.inapppush.reply") == true) goto L17;
        return;
    L17:
        this.f421988g = (ITitlebarComponent) r100.a(ITitlebarComponent.class);
        this.f421989h = (IKeyboardComponent) r100.a(IKeyboardComponent.class);
        Log.i("ChatBottomSheetPlugin", "start chat window by bottom sheet");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r106 = this.f421990i;
        com.ss.android.lark.keyboard.b r107 = null;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r106 = null;
    L20:
        Fragment r108 = r106.getFragment();
        if (r108 == null) goto L26;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r109 = this.f421990i;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r109 = null;
    L25:
        r109.getViewModel(ChatWindowOpenViewModel.class).getInitializeStateLiveData().observe(r108.getViewLifecycleOwner(), new c(this, r108));
    L26:
        ITitlebarComponent r110 = this.f421988g;
        if (r110 == null) goto L31;
        FlowTitleBarComponent.LeftAreaImpl r111 = r110.x00();
        if (r111 == null) goto L31;
        r111.b((FlowBottomSheetPlugin$backHitPointActionInterceptor$2.a) this.f421998q.getValue());
    L31:
        Map<ImExtensionType, List<Class<?>>> r112 = com.ss.android.lark.im.base.d.f425883a;
        wxa.b r113 = (wxa.b) CollectionsKt.firstOrNull(com.ss.android.lark.im.base.d.b(ImExtensionType.ATTACHMENT_ABILITY, wxa.b.class));
        if (r113 == null) goto L37;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r114 = this.f421990i;
        if (r114 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r114 = null;
    L36:
        f r115 = r113.a(r114.getFragment());
    L38:
        this.f421992k = r115;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r116 = this.f421990i;
        if (r116 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r116 = null;
    L41:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r116.getFragment()), null, null, new FlowBottomSheetPlugin$initAttachmentStateFlow$1(this, null), 3, null);
        IKeyboardComponent r117 = this.f421989h;
        if (r117 == null) goto L44;
        r107 = r117.n();
    L44:
        G(r107);
        IKeyboardComponent r118 = this.f421989h;
        if (r118 == null) goto L48;
        r118.m7(new com.ss.android.lark.flow.bottomsheet.plugin.a(this));
        return;
    L48:
        return;
    L37:
        r115 = null;
        goto L38
    L5:
        if (r103.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
