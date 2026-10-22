package com.ss.android.lark.im.base.page;

import android.app.assist.AssistContent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.platform.dispatcher.d;
import com.ss.android.lark.platform.dispatcher.i;
import d0c.b;
import d0c.c;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l3c.j;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\"\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0012\u0010(\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\f\u0010-\u001a\u00020\u001a*\u00020.H$J\f\u0010/\u001a\u00020\u001a*\u00020.H\u0014J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0014J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020401H\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u00065"}, d2 = {"Lcom/ss/android/lark/im/base/page/BasePageFragment;", "Lcom/ss/android/lark/base/frame/FrameFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "pluginFactory", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginFactory;", "getPluginFactory", "()Lcom/ss/android/lark/biz/im/api/page/plugin/PluginFactory;", "setPluginFactory", "(Lcom/ss/android/lark/biz/im/api/page/plugin/PluginFactory;)V", "configuratorFactory", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorFactory;", "getConfiguratorFactory", "()Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorFactory;", "setConfiguratorFactory", "(Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorFactory;)V", "dispatcher", "Lcom/ss/android/lark/platform/dispatcher/CompositeDispatcherImpl;", "getDispatcher", "()Lcom/ss/android/lark/platform/dispatcher/CompositeDispatcherImpl;", "dispatcher$delegate", "Lkotlin/Lazy;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "handleBack", "", "onNewIntent", "intent", "onProvideAssistContent", "assistContent", "Landroid/app/assist/AssistContent;", "initComponents", "Lcom/ss/android/lark/scaffold/ScaffoldScope;", "initViewModels", "configuratorTypes", "", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "pluginTypes", "Lcom/ss/android/lark/biz/im/api/page/plugin/PluginType;", "im-biz-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BasePageFragment extends Hilt_BasePageFragment implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Inject
    public qya.a f425885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Inject
    public pya.a f425886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f425887h;

    public abstract void V90(j r100);

    public void W90(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public final com.ss.android.lark.platform.dispatcher.b U90() {
        return (com.ss.android.lark.platform.dispatcher.b) this.f425887h.getValue();
    }

    public BasePageFragment() {
        this.f425887h = LazyKt.lazy(LazyThreadSafetyMode.NONE, BasePageFragment$dispatcher$2.INSTANCE);
    }

    public List<ConfiguratorType> T90() {
        return CollectionsKt.emptyList();
    }

    public List<PluginType> X90() {
        return CollectionsKt.emptyList();
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.ss.android.lark.base.frame.FrameFragment
    public final boolean l1() {
        return U90().f();
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.base.frame.FrameFragment
    public void A0(Intent r100) {
        Iterator<com.ss.android.lark.platform.dispatcher.h> r101 = U90().f438647c.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        com.ss.android.lark.platform.dispatcher.h r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r103.A0(r100);
        r102 = r104;
        goto L4
    }

    @Override // com.ss.android.lark.base.frame.FrameFragment
    public final void aP(AssistContent r100) {
        Iterator<i> r101 = U90().f438648d.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        i r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r103.a();
        r102 = r104;
        goto L4
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        final OnBackPressedDispatcher r101 = requireActivity().getOnBackPressedDispatcher();
        OnBackPressedDispatcherKt.addCallback$default(r101, this, false, new AnonymousClass1(this, r101), 2, null);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        l3c.i.a(this, r100, new C118761(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        CopyOnWriteArrayList<d> r103 = U90().f438645a;
        if ((r103 instanceof Collection) == true) goto L5;
    L7:
        Iterator<d> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L16;
        if (r104.next().onActivityResult(r100, r101, r102) == false) goto L9;
        return;
    L16:
        return;
    L5:
        if (r103.isEmpty() == false) goto L7;
    }
}
