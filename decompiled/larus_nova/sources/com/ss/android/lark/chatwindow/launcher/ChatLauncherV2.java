package com.ss.android.lark.chatwindow.launcher;

import android.app.Activity;
import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.biz.im.api.bundle.v2.base.BaseBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatBundleInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import f0c.h;
import h7b.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class ChatLauncherV2 implements c, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f416965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>> f416966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>> f416967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CoroutineScope f416968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d> f416969e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f416970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Fragment f416971b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f416970a, r101.f416970a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f416971b, r101.f416971b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f416970a.hashCode() * 31;
            Fragment r101 = this.f416971b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "LaunchContext(context=" + this.f416970a + ", fragment=" + this.f416971b + ')';
        }

        public final Context getContext() {
            return this.f416970a;
        }

        public b(Context r100, Fragment r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f416970a = r100;
            this.f416971b = r101;
        }
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

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f416965a;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        CoroutineScope r101 = this.f416968d;
        if (r101 == null) goto L5;
        CoroutineScopeKt.cancel$default(r101, null, 1, null);
    L5:
        this.f416968d = null;
    }

    @Inject
    public ChatLauncherV2(m r100, Map<ILaunchDataInput.LaunchDataType, Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>>> r101, Map<RealLaunchData.ChatDirection, Provider<com.ss.android.lark.chatwindow.launcher.starter.a>> r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "transformers");
        Intrinsics.checkNotNullParameter(r102, "starters");
        this.f416965a = r100;
        this.f416966b = r101;
        this.f416967c = r102;
        r100.d(this);
        this.f416969e = new ArrayList();
    }

    @Override // com.ss.android.lark.chatwindow.launcher.c
    public final void U7(Context r110, Fragment r111, ChatBundleInput r112, final IGetDataCallback<Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "chatBundleInput");
        if (r113 == null) goto L5;
        IGetDataCallback<c.a> r100 = new ChatLauncherV2$openChat$callbackActual$1$1(r113);
    L7:
        if (this.f416968d != null) goto L10;
        this.f416968d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    L10:
        if (r111 == null) goto L15;
        CoroutineScope r101 = LifecycleOwnerKt.getLifecycleScope(r111);
        if (r101 == null) goto L15;
    L21:
        CoroutineScope r102 = r101;
        if (r102 != null) goto L24;
    L25:
        Log.e(ChatWindowViewModel.LAUNCHER_TAG, "scope is null!, not start chat");
        Unit r103 = Unit.INSTANCE;
        return;
    L24:
        if (BuildersKt.launch$default(r102, null, null, new ChatLauncherV2$openChatActual$1(r112, this, r110, r111, r100, null), 3, null) == null) goto L25;
        return;
    L15:
        if ((r110 instanceof ComponentActivity) == true) goto L17;
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "openChat: context is not ComponentActivity, use globalScope");
        r101 = this.f416968d;
        goto L21
    L17:
        if (UIUtils.isActivityRunning((Activity) r110) == false) goto L19;
        r101 = LifecycleKt.getCoroutineScope(((ComponentActivity) r110).getLifecycle());
        goto L21
    L19:
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "openChat: activity is not running, use globalScope");
        r101 = this.f416968d;
        goto L21
    L5:
        r100 = null;
        goto L7
    }

    public final Object a(Context r210, Fragment r211, ChatBundleInput r212, Continuation<? super c.b> r213) {
        Context r100 = r210;
        if ((r213 instanceof ChatLauncherV2$openChat$2) == false) goto L7;
        ChatLauncherV2$openChat$2 r101 = (ChatLauncherV2$openChat$2) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ChatBundleV2 r106 = (ChatBundleV2) r101.L$1;
        com.ss.android.lark.chatwindow.launcher.transform.d r107 = (com.ss.android.lark.chatwindow.launcher.transform.d) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L62:
        if (((Boolean) r103).booleanValue() == false) goto L65;
        return new c.b.C4880b(new c.a(r106.f409992i.f410012a, r107.f416988b));
    L65:
        return new c.b.a("starter executeStart failed");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        b r108 = (b) r101.L$1;
        Context r109 = (Context) r101.L$0;
        ResultKt.throwOnFailure(r103);
        Object r110 = ((Result) r103).m9458unboximpl();
        b r111 = r108;
        r100 = r109;
    L42:
        if (Result.m9456isSuccessimpl(r110) == true) goto L44;
        Throwable r112 = Result.m9452exceptionOrNullimpl(r110);
        if (r112 == null) goto L69;
        String r113 = r112.getMessage();
    L70:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r110);
        if (r114 == null) goto L76;
        if ((r114 instanceof ErrorResult) == false) goto L76;
        i.c(r100, (ErrorResult) r114, null);
    L76:
        if (r113 != null) goto L79;
        r113 = "transform failed";
    L79:
        return new c.b.a(r113);
    L69:
        r113 = null;
        goto L70
    L44:
        if (Result.m9455isFailureimpl(r110) == false) goto L46;
        r110 = null;
    L46:
        r107 = (com.ss.android.lark.chatwindow.launcher.transform.d) r110;
        if (r107 != null) goto L50;
        Log.e(ChatWindowViewModel.LAUNCHER_TAG, "openChat failed, chatBundle is null");
        return new c.b.a("openChat failed, chatBundle is null");
    L50:
        ChatBundleV2 r115 = r107.f416987a;
        Provider<com.ss.android.lark.chatwindow.launcher.starter.a> r116 = this.f416967c.get(r115.f409992i.f410014c);
        if (r116 == null) goto L53;
        com.ss.android.lark.chatwindow.launcher.starter.a r117 = r116.get();
    L54:
        if (r117 != null) goto L57;
        Log.e(ChatWindowViewModel.LAUNCHER_TAG, "openChat failed, starter is null");
        return new c.b.a("openChat failed, starter is null");
    L57:
        r101.L$0 = r107;
        r101.L$1 = r115;
        r101.label = 2;
        r103 = r117.a(r111, r107, r101);
        if (r103 != r104) goto L60;
        return r104;
    L60:
        r106 = r115;
        goto L62
    L53:
        r117 = null;
        goto L54
    L16:
        ResultKt.throwOnFailure(r103);
        r111 = new b(r100, r211);
        if (r212.f409975i.isValid() == true) goto L20;
        Log.e(ChatWindowViewModel.LAUNCHER_TAG, "openChat failed, chatId or chatterId is empty");
        return new c.b.a("launchData is invalid");
    L20:
        Iterator r118 = ((ArrayList) this.f416969e).iterator();
    L22:
        if (r118.hasNext() == false) goto L24;
        ((d) r118.next()).load();
        goto L22
    L24:
        SourceType r119 = r212.f409966a.f410021e;
        if (r119 != null) goto L27;
    L31:
        Provider<com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput>> r120 = this.f416966b.get(r212.f409975i.type());
        if (r120 == null) goto L34;
        com.ss.android.lark.chatwindow.launcher.transform.a<? extends ILaunchDataInput> r121 = r120.get();
    L35:
        if (r121 == null) goto L37;
        ILaunchDataInput r122 = r212.f409975i;
        BaseBundle r123 = new BaseBundle(r212.f409966a, r212.f409967b, r212.f409968c, r212.f409969d, r212.f409970e, r212.f409971f, r212.f409972g, r212.f409973h);
        r101.L$0 = r100;
        r101.L$1 = r111;
        r101.label = 1;
        r110 = r121.a(r122, r123, r101);
        if (r110 != r104) goto L42;
        return r104;
    L37:
        return new c.b.a("launch data is invalid, transform is null");
    L34:
        r121 = null;
        goto L35
    L27:
        if (r119 == SourceType.FEED) goto L31;
        if (r119 == SourceType.SHORTCUT) goto L31;
        ChatCoreModule.a().getPerfEnterChatMonitor().a(r119.value);
        PerfLog.start("open_chat", "");
    L7:
        r101 = new ChatLauncherV2$openChat$2(this, r213);
        goto L8
    }
}
