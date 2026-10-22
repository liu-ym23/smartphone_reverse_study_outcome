package com.bytedance.applet.debugger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bytedance.ai.api.DebugEntranceMode;
import com.bytedance.ai.api.DebuggerMode;
import com.bytedance.ai.api.DebuggerOpenArgs;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.g4;
import com.larus.bmhome.setting.IFragmentProvider;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.chat.ChatTitleBarIcon;
import com.larus.platform.api.g0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006*\u0002\u001d \b\u0000\u0018\u0000 `2\u00020\u0001:\u0001`B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010/\u001a\u00020-H\u0016J\u000e\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u0005J\b\u00102\u001a\u00020-H\u0002J\b\u00103\u001a\u0004\u0018\u00010\u0001J\u0006\u00104\u001a\u00020\u0019J\u000e\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020+J\u0010\u00107\u001a\u00020-2\u0006\u00101\u001a\u00020\u0005H\u0002J\u0010\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u0001H\u0002J \u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020<2\u0006\u00101\u001a\u00020\u00052\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020%H\u0002J4\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020>2\u0010\b\u0002\u0010C\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010D2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010DH\u0002J\u0010\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020\u0019H\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010\u001b2\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010K\u001a\u00020-H\u0002J\u0010\u0010L\u001a\u00020-2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010M\u001a\u00020-2\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010N\u001a\u00020-H\u0002J\b\u0010O\u001a\u00020-H\u0002J\u0010\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020-H\u0002J\b\u0010T\u001a\u00020-H\u0002J\u001a\u0010U\u001a\u00020-2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010Y\u001a\u00020-H\u0002J\u0010\u0010Z\u001a\u00020[2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010\\\u001a\u00020<2\u0006\u0010B\u001a\u00020>H\u0002J\u0010\u0010]\u001a\u00020W2\u0006\u0010B\u001a\u00020>H\u0002J\u0010\u0010^\u001a\u00020<2\u0006\u0010=\u001a\u00020RH\u0002J\b\u0010_\u001a\u00020-H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/bytedance/applet/debugger/AppletDebuggerHostFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "initialOpenArgs", "Lcom/bytedance/ai/api/DebuggerOpenArgs;", "getInitialOpenArgs", "()Lcom/bytedance/ai/api/DebuggerOpenArgs;", "initialOpenArgs$delegate", "Lkotlin/Lazy;", "activeOpenArgs", "currentOpenArgs", "getCurrentOpenArgs", "conversationCreator", "Lcom/bytedance/applet/debugger/DebuggerConversationCreator;", "viewModel", "Lcom/bytedance/applet/debugger/DebuggerSessionViewModel;", "getViewModel", "()Lcom/bytedance/applet/debugger/DebuggerSessionViewModel;", "viewModel$delegate", "serviceManagerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "chatInteractionEnabled", "", "observedBlockAbility", "Lcom/larus/bmhome/view/actionbar/api/IChatUIBlockAbility;", "uiBlockChangeListener", "com/bytedance/applet/debugger/AppletDebuggerHostFragment$uiBlockChangeListener$1", "Lcom/bytedance/applet/debugger/AppletDebuggerHostFragment$uiBlockChangeListener$1;", "titleBarConfig", "com/bytedance/applet/debugger/AppletDebuggerHostFragment$titleBarConfig$1", "Lcom/bytedance/applet/debugger/AppletDebuggerHostFragment$titleBarConfig$1;", "chatHostConfig", "Lcom/larus/chat/ChatHostConfig;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "onNewOpenArgs", "args", "observeViewModel", "getChatFragment", "onHostBackPressed", "onResult", "bundle", "attachChat", "configureChat", "fragment", "createChatBundle", "conversationId", "", "mode", "Lcom/bytedance/ai/api/DebuggerMode;", "showTitleMenu", "anchor", "switchMode", "target", "onSuccess", "Lkotlin/Function0;", "onFailure", "setChatInteractionEnabled", "enabled", "bindChatBlockAbility", "chat", "Lcom/larus/bmhome/chat/fragment/IChatFragment;", "ensureChatInteractionBlock", "refreshChatBottom", "updateModeOnChat", "confirmClearHistory", "openSearch", "handleDebugEntrance", "targetDebugEntranceMode", "Lcom/bytedance/ai/api/DebugEntranceMode;", "openIntelligentServicePage", "openServiceManager", "handleServiceManagerResult", "resultCode", "", "data", "exitDebugger", "modeText", "", "modeSwitchText", "modeSwitchIcon", "debugEntranceModeText", "initDebugContext", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebuggerHostFragment extends Fragment {
    public static final /* synthetic */ int m = 0;
    public final Lazy d;
    public DebuggerOpenArgs e;
    public final DebuggerConversationCreator f;
    public final Lazy g;
    public final ActivityResultLauncher<Intent> h;
    public boolean i;
    public ss8.g j;
    public final g k;
    public final qy8.a l;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DebuggerMode.values().length];
            r0[DebuggerMode.ONLINE_PREVIEW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[DebuggerMode.LOCAL_DEBUG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            a = r0;
            int[] r1 = new int[DebugEntranceMode.values().length];
            r1[DebugEntranceMode.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[DebugEntranceMode.CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            b = r1;
        }
    }

    public static final class c implements qy8.c {
        public final /* synthetic */ AppletDebuggerHostFragment a;

        public final boolean a() {
            return false;
        }

        public final void b() {
        }

        public c(AppletDebuggerHostFragment r1) {
            this.a = r1;
        }

        public final void c(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            AppletDebuggerHostFragment r3 = this.a;
            int r0 = AppletDebuggerHostFragment.m;
            FragmentActivity r4 = r3.getActivity();
            if (r4 == null) goto L6;
            r4.finish();
            return;
        }
    }

    public static final class d implements qy8.f {
        public d() {
        }

        public final void a() {
        }

        public final void b(Fragment r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, "chatBundle");
        }
    }

    public static final class e implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public e(j r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public static final class f implements g4 {
        public final /* synthetic */ AppletDebuggerHostFragment a;

        public final void a() {
        }

        public final void b() {
        }

        public final boolean c() {
            return true;
        }

        public final boolean d() {
            return false;
        }

        public final boolean h() {
            return true;
        }

        public final boolean i() {
            return true;
        }

        public final CharSequence f() {
            AppletDebuggerHostFragment r0 = this.a;
            int r1 = AppletDebuggerHostFragment.m;
            return r0.V90((DebuggerMode) r0.U90().getMode().getValue());
        }

        public final CharSequence g() {
            return this.a.getString(2131894392);
        }

        public f(AppletDebuggerHostFragment r1) {
            this.a = r1;
        }

        public final void e(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            AppletDebuggerHostFragment.S90(this.a, r2);
        }

        public final boolean j(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            AppletDebuggerHostFragment.S90(this.a, r2);
            return true;
        }
    }

    public static final class g implements ss8.g.b {
        public final /* synthetic */ AppletDebuggerHostFragment a;

        public final void b() {
        }

        public g(AppletDebuggerHostFragment r1) {
            this.a = r1;
        }

        public final void a(ChatUIBlockConfig r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "config");
            ChatUIBlockConfig r0 = ChatUIBlockConfig.HIDE_INPUT_BAR;
            if (r3 != r0) goto L23;
            if (r4 == true) goto L24;
            AppletDebuggerHostFragment r5 = this.a;
            if (r5.i == true) goto L27;
            Fragment r6 = r5.getChatFragment();
            if ((r6 instanceof xe8.a) == false) goto L11;
            xe8.a r7 = (xe8.a) r6;
        L12:
            if (r7 == null) goto L28;
            ss8.g r8 = r5.T90(r7);
            if (r8 != null) goto L18;
            return;
        L18:
            if (r8.bc(r0) == true) goto L25;
            r8.J10(r0);
            p1 r9 = r7.WF().getAbility(p1.class);
            if (r9 == null) goto L26;
            r9.cb(false);
            return;
        L26:
            return;
        L25:
            return;
        L28:
            return;
        L11:
            r7 = null;
            goto L12
        L27:
            return;
        L24:
            return;
        }
    }

    static {
    }

    public final DebuggerSessionViewModel U90() {
        return (DebuggerSessionViewModel) this.g.getValue();
    }

    public final void onDestroyView() {
        ss8.g r0 = this.j;
        if (r0 == null) goto L5;
        r0.aZ(this.k);
    L5:
        this.j = null;
        super.onDestroyView();
    }

    public AppletDebuggerHostFragment() {
        this.d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new com.bytedance.applet.debugger.f(this));
        this.f = new DebuggerConversationCreator();
        Function0 r0 = new com.bytedance.applet.debugger.g(this);
        final Function0<Fragment> r1 = new AppletDebuggerHostFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DebuggerSessionViewModel.class), new AppletDebuggerHostFragment$special$$inlined$viewModels$default$2(r1), r0);
        this.h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new h(this));
        this.i = true;
        this.k = new g(this);
        f r9 = new f(this);
        this.l = new qy8.a(new c(this), new d(), null, null, false, SetsKt.setOf(new ChatTitleBarIcon[]{ChatTitleBarIcon.BACK, ChatTitleBarIcon.TTS, ChatTitleBarIcon.REAL_TIME_CALL}), r9, null, null, 29692);
    }

    public final Fragment getChatFragment() {
        return getChildFragmentManager().findFragmentByTag("applet_debugger_chat");
    }

    public final ss8.g T90(xe8.a r3) {
        ss8.g r4 = r3.WF().getAbility(ss8.g.class);
        if (r4 == null) goto L9;
        ss8.g r0 = this.j;
        if (r0 == r4) goto L9;
        if (r0 == null) goto L8;
        r0.aZ(this.k);
    L8:
        this.j = r4;
        r4.ds(this.k);
    L9:
        return r4;
    }

    public final CharSequence V90(DebuggerMode r2) {
        int r3 = b.a[r2.ordinal()];
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L8;
        return getString(2131894381);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return getString(2131894382);
    }

    public final void W90(boolean r3) {
        this.i = r3;
        Fragment r0 = getChatFragment();
        if ((r0 instanceof xe8.a) == false) goto L5;
        xe8.a r1 = (xe8.a) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        ss8.g r2 = T90(r1);
        if (r3 == false) goto L12;
        if (r2 == null) goto L14;
        r2.bN(ChatUIBlockConfig.HIDE_INPUT_BAR);
    L14:
        p1 r4 = r1.WF().getAbility(p1.class);
        if (r4 == null) goto L18;
        r4.cb(false);
        return;
    L18:
        return;
    L12:
        if (r2 == null) goto L14;
        r2.J10(ChatUIBlockConfig.HIDE_INPUT_BAR);
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public final void X90(DebuggerMode r5) {
        xe8.a r0 = getChatFragment();
        if (r0 != null) goto L5;
        return;
    L5:
        Bundle r1 = r0.getArguments();
        if (r1 == null) goto L9;
        r1.putString("applet_debugger_mode", r5.getValue());
    L9:
        if ((r0 instanceof xe8.a) == false) goto L11;
        xe8.a r2 = r0;
    L12:
        if (r2 == null) goto L21;
        t1a.b r3 = r2.WF();
        if (r3 == null) goto L22;
        ry8.b r4 = r3.getAbility(ry8.b.class);
        if (r4 == null) goto L23;
        g0 r6 = r4.C5();
        if (r6 == null) goto L24;
        g0.a.b(r6, getString(2131894392), false, 6);
        g0.a.a(r6, V90(r5).toString(), 0, 14);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r2 = null;
        goto L12
    }

    public static final void S90(final AppletDebuggerHostFragment r134, final View r135) {
        Context r10 = r134.getContext();
        if (r10 == null) goto L37;
        boolean r1 = ((y) r134.U90().getSessionState().getValue()) instanceof y.a;
        Object r2 = r134.U90().getMode().getValue();
        final DebuggerMode r3 = DebuggerMode.ONLINE_PREVIEW;
        if (r2 != r3) goto L8;
        r3 = DebuggerMode.LOCAL_DEBUG;
    L8:
        Object r4 = r134.U90().getDebugEntranceMode().getValue();
        final DebugEntranceMode r5 = DebugEntranceMode.OPEN;
        if (r4 != r5) goto L11;
        r5 = DebugEntranceMode.CLOSE;
    L11:
        l0[] r6 = new l0[5];
        int[] r7 = b.a;
        int r8 = r7[r3.ordinal()];
        if (r8 == 1) goto L17;
        if (r8 != 2) goto L16;
        String r9 = r134.getString(2131894389);
    L18:
        String r14 = r9;
        int r11 = r7[r3.ordinal()];
        if (r11 == 1) goto L24;
        if (r11 != 2) goto L23;
        int r12 = 2131240842;
    L25:
        r6[0] = new l0(2131894390, 0, r14, null, null, null, null, Integer.valueOf(r12), null, false, false, null, null, null, r1, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -32902, 127);
        r6[1] = new l0(2131894371, 2131894371, null, null, null, null, null, 2131240841, null, false, false, null, null, null, r1, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -32900, 127);
        r6[2] = new l0(2131894386, 2131894386, null, null, null, null, null, 2131241967, null, false, false, null, null, null, r1, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -32900, 127);
        int r13 = b.b[r5.ordinal()];
        if (r13 == 1) goto L31;
        if (r13 != 2) goto L30;
        String r15 = r134.getString(2131894376);
    L32:
        r6[3] = new l0(2131894376, 0, r15, null, null, null, null, 2131242797, null, false, false, null, null, null, r1, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -32902, 127);
        r6[4] = new l0(2131894387, 2131894387, null, null, null, null, null, 2131240845, null, false, false, null, null, null, r1, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -32900, 127);
        List r16 = CollectionsKt.listOf(r6);
        View r17 = CreateMenu.f(new CreateMenu(r10), r16, 0, false, null, null, null, null, new m(r135, r134, r3, r5), 510);
        int r18 = 1;
        Balloon r0 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r135, r17, false, null, null, r134.getViewLifecycleOwner(), null, 92);
        if (com.larus.utils.i.h(r10) == false) goto L35;
        r18 = -1;
    L35:
        r17.measure(0, 0);
        r0.x(r135, (r18 * (r135.getMeasuredWidth() - r17.getMeasuredWidth())) / 2, -i5.Q());
        return;
    L30:
        throw new NoWhenBranchMatchedException();
    L31:
        r15 = r134.getString(2131894384);
        goto L32
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        r12 = 2131240843;
        goto L25
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r9 = r134.getString(2131894391);
        goto L18
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.applet.debugger.j] */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        this.e = (DebuggerOpenArgs) this.d.getValue();
        xe8.a r10 = getChildFragmentManager().findFragmentByTag("applet_debugger_chat");
        if (r10 != null) goto L24;
        DebuggerOpenArgs r11 = this.e;
        if (r11 != null) goto L7;
        r11 = (DebuggerOpenArgs) this.d.getValue();
    L7:
        IFragmentProvider r1 = (IFragmentProvider) ServiceManager.get().getService(IFragmentProvider.class);
        if (r1 == null) goto L29;
        String r2 = r11.getConversationId();
        DebuggerMode r3 = (DebuggerMode) U90().getMode().getValue();
        Bundle r4 = new Bundle();
        r4.putString("argConversationId", r2);
        r4.putString("argBotId", r11.getBotId());
        r4.putString("argPreviousPage", "applet_debugger");
        r4.putString("enter_method", r11.getEntryFrom());
        r4.putBoolean("is_create_sub_conversation", true);
        r4.putString("applet_debugger_mode", r3.getValue());
        xe8.a r12 = r1.a(r4, new com.larus.bmhome.setting.f());
        if (r12 == null) goto L29;
        if ((r12 instanceof xe8.a) == false) goto L15;
        xe8.a r5 = r12;
    L16:
        if (r5 == null) goto L18;
        r5.AY(this.l);
    L18:
        FragmentTransaction r6 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "applet_debugger_chat", 2131363152) == true) goto L22;
        r6 = r6.replace(2131363152, r12, "applet_debugger_chat");
    L22:
        r6.runOnCommit(new i(this)).commitAllowingStateLoss();
        U90().onDebuggerPageReady();
        goto L29
    L15:
        r5 = null;
    L29:
        String r13 = com.larus.platform.service.o.a.getDeviceId();
        Function0 r14 = com.larus.platform.service.q.a.f().a;
        if (r14 == null) goto L33;
        String r15 = (String) r14.invoke();
        if (r15 == null) goto L33;
    L34:
        IAISDKDebugService.a.s(r13, r15, 0);
        U90().getClearChatHistoryResult().observe(getViewLifecycleOwner(), new e(new j(this)));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AppletDebuggerHostFragment$observeViewModel$2(this, null), 3, null);
        return;
    L33:
        r15 = "";
        goto L34
    L24:
        if ((r10 instanceof xe8.a) == false) goto L26;
        xe8.a r16 = r10;
    L27:
        if (r16 == null) goto L29;
        r16.AY(this.l);
        goto L29
    L26:
        r16 = null;
        goto L27
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FragmentContainerView r4 = new FragmentContainerView(requireContext());
        r4.setId(2131363152);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return r4;
    }
}
