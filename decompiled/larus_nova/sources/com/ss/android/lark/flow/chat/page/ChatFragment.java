package com.ss.android.lark.flow.chat.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import javax.inject.Inject;
import jdb.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import zsb.d;

/* JADX INFO: loaded from: classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KB\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010.\u001a\u00020\u001eH\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0002J\u001a\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u0002032\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J \u00104\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00105\u001a\u00020,2\u0006\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010:J\u0012\u0010;\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\"\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\b\u0010@\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010A\u001a\u00020\u001e2\b\u0010B\u001a\u0004\u0018\u00010CJ\n\u0010D\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010E\u001a\u00020FH\u0016J\u0012\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006L"}, d2 = {"Lcom/ss/android/lark/flow/chat/page/ChatFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "startTimeSec", "", "chatFragmentFactory", "Lcom/ss/android/lark/biz/im/api/page/ChatFragmentFactory;", "getChatFragmentFactory", "()Lcom/ss/android/lark/biz/im/api/page/ChatFragmentFactory;", "setChatFragmentFactory", "(Lcom/ss/android/lark/biz/im/api/page/ChatFragmentFactory;)V", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "getFgService", "()Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "setFgService", "(Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", "dataPreLoaderV2", "Lcom/ss/android/lark/chat/chatwindow/chat/preloaderv2/IDataPreloadManagerV2;", "getDataPreLoaderV2", "()Lcom/ss/android/lark/chat/chatwindow/chat/preloaderv2/IDataPreloadManagerV2;", "setDataPreLoaderV2", "(Lcom/ss/android/lark/chat/chatwindow/chat/preloaderv2/IDataPreloadManagerV2;)V", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "onCreateView", "Landroid/widget/FrameLayout;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onStop", "sendDuration", "onViewCreated", "view", "Landroid/view/View;", "setupContentFragment", "args", "chatBundle", "Lcom/ss/android/lark/biz/im/api/bundle/IChatBundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "launchContentFragmentImpl", "onActivityResult", "requestCode", "", "resultCode", "data", "onProvideAssistContent", "assistContent", "Landroid/app/assist/AssistContent;", "findContentFragment", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "shouldNotifyPush", "", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatFragment extends Hilt_ChatFragment implements d0c.c, d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f422695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Inject
    public oya.a f422696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Inject
    public g f422697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d f422698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Fragment f422699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f422700k;

    public static final class a {
    }

    static {
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
        return d0c.b.a(this);
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
        return d0c.b.b(this);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        Log.i("ChatFragment", "onStart invoke");
        super.onStart();
        this.f422695f = System.currentTimeMillis() / ((long) 1000);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        Log.i("ChatFragment", "onStop invoke");
        super.onStop();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getIO(), null, new ChatFragment$sendDuration$1(this, null), 2, null);
    }

    @Inject
    public ChatFragment() {
        this.f422700k = "";
    }

    public final Fragment T90() {
        if (isAdded() == true) goto L5;
        Log.e("ChatFragment", "fragment not added");
        return null;
    L5:
        return getChildFragmentManager().findFragmentByTag("content_fragment");
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    @Override // zsb.d
    public final boolean Cy(Notice r100) {
        return t0.a(r100, this.f422700k);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        if (r100 != null) goto L16;
    L6:
        super.onCreate(r100);     // Catch: Exception -> L4
    L12:
        v4b.a.a(requireContext());
        return;
    L4:
        e = move-exception;
        ImSdk r101 = ImSdk.f425890a;
        boolean r102 = ImSdk.f425892c;
        boolean r103 = OfficeSDKManager.isAvailable();
        if (r103 == false) goto L14;
        if (r102 == true) goto L12;
    L14:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r103 + ", im sdk ready: " + r102 + ", onCreateFail. fallback. " + e.getMessage());
        int r104 = gza.a.f483430a;
        return;
    L16:
        r100.remove("android:support:fragments");     // Catch: Exception -> L4
        goto L6
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = requireArguments();
        String r103 = fxa.a.a(r102).getChatId();
        if (r103 == null) goto L10;
        this.f422700k = r103;
        if (T90() != null) goto L7;
        Log.i("ChatFragment", "onViewCreated setupContentFragment");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatFragment$setupContentFragment$1(this, r102, null), 3, null);
        return;
    L7:
        Log.w("ChatFragment", "onViewCreated fragment existed");
        return;
    L10:
        throw new IllegalStateException("chatId == null".toString());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Fragment r103 = T90();
        if (r103 == null) goto L6;
        r103.onActivityResult(r100, r101, r102);
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = new FrameLayout(r100.getContext());
        r103.setId(R.id.chat_container);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r103;
    }
}
