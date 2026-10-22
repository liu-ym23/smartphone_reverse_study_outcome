package com.bytedance.applet.impl;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.api.AppletV2Service;
import com.bytedance.ai.api.ToastIconType;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.applet.debug.AppletDebugManager;
import com.bytedance.applet.model.bottomsheet.DoubaoBottomSheetDialogFragment;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.PermissionApplyBlock;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.IFlowMessageService;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.api.g5;
import com.larus.platform.api.i4;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.a3;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J=\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\n2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\u001dH\u0016JB\u0010 \u001a\u00020\u000728\u0010!\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00070\"H\u0016J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\nH\u0016JC\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\u001dH\u0016JB\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u00102\u001a\u0004\u0018\u00010\n2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0016J=\u00106\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/2\u0006\u0010\t\u001a\u00020\n2#\u0010\u001c\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J3\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J$\u0010<\u001a\u00020\u00072\u0006\u00109\u001a\u00020=2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J$\u0010>\u001a\u00020\u00072\u0006\u00109\u001a\u00020?2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00070\u001dH\u0016Jz\u0010A\u001a\u00020\u00072\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000205042\u0006\u00109\u001a\u00020=2\u0006\u0010C\u001a\u00020\u00052\b\u0010D\u001a\u0004\u0018\u00010\n2\b\u0010E\u001a\u0004\u0018\u00010\n28\u0010\u001c\u001a4\u0012\u0013\u0012\u00110;¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00070\"H\u0016JL\u0010F\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010\n28\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(G\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00070\"H\u0016Je\u0010H\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u00010\n2Q\u0010\u001c\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(J\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(K\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00070IH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/bytedance/applet/impl/AppletV2ServiceImpl;", "Lcom/bytedance/ai/api/AppletV2Service;", "<init>", "()V", "isPublicVersion", "", "init", "", "updateAppList", "appletId", "", "resendUserQueryAfterLogin", "messageId", "success", "reason", "getNativeLoginCard", "Landroid/view/View;", "isDebugMode", "result", "(Ljava/lang/String;)Ljava/lang/Boolean;", "handleDebugScanCode", "code", "resendQueryMsg", "queryMsgId", "requestPermission", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "permissionName", "completion", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "checkMusicLoginStatus", "callback", "Lkotlin/Function2;", "isLogin", "errorMsg", "showToast", "toastIconType", "Lcom/bytedance/ai/api/ToastIconType;", "toastContent", "updatePermissionApplyMsgContent", "msgId", "cardIs", "contentDataStr", "onAppletSystemSheetMenuItemClick", "context", "Landroid/content/Context;", "itemId", "", "appletName", "extraInfo", "", "", "openAppletSettings", "errorMessage", "appletOnRequestLunaMusicAuth", "config", "Lcom/bytedance/ai/api/AppletRequestLunaMusicConfig;", "Lcom/bytedance/ai/api/OperateResult;", "showMiniApplicationDialog", "Lcom/bytedance/ai/api/MiniApplicationDialogConfig;", "showDoubaoBottomSheet", "Lcom/bytedance/ai/api/AppletBottomSheetConfig;", "Lcom/bytedance/ai/api/AppletBottomSheetResult;", "requestAppletFirstPartyAuth", "traceInfo", "isMiniApplication", "requiredScope", "optionalScope", "checkAppletFirstPartyAuthStatus", "isAuthorized", "getAppletFirstPartyAuthToken", "Lkotlin/Function3;", "openId", "accessToken", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletV2ServiceImpl implements AppletV2Service {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ToastIconType.values().length];
            r0[ToastIconType.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ToastIconType.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ToastIconType.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ToastIconType.FAILURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements com.larus.platform.api.g1.c {
        public final /* synthetic */ Function1<Boolean, Unit> a;
        public final /* synthetic */ FragmentActivity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function0<Unit> d;

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
            if (ContextCompat.checkSelfPermission(this.b, this.c) != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            this.d.invoke();
            return;
        L8:
            this.a.invoke(Boolean.FALSE);
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final void onGoSettingsDialogDismiss(boolean r2) {
            if (r2 == true) goto L5;
            this.a.invoke(Boolean.FALSE);
            return;
        }

        public c(Function1 r1, FragmentActivity r2, String r3, z0 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            if (r2 == false) goto L6;
            this.d.invoke();
            return;
        L6:
            if (r5 == true) goto L9;
            this.a.invoke(Boolean.FALSE);
            return;
        }
    }

    public static final class d implements a3 {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        public final void a(LocationResult r1, Integer r2, GeoLocationInfo r3) {
            Intrinsics.checkNotNullParameter(r1, "code");
            this.a.invoke(Boolean.TRUE);
        }
    }

    public static final class e implements IIMCallback<Message> {
        public final /* synthetic */ Function1<Boolean, Unit> a;

        public final boolean mustInMain() {
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(Function1<? super Boolean, Unit> r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            this.a.invoke(Boolean.FALSE);
        }

        public final void onSuccess(Object r2) {
            Intrinsics.checkNotNullParameter((Message) r2, "result");
            this.a.invoke(Boolean.TRUE);
        }
    }

    static {
    }

    public final void init() {
        StringsKt.startsWith$default(com.larus.platform.service.g.a.b(), "obric", false, 2, null);
    }

    public AppletV2ServiceImpl() {
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appletId");
        AIManager r0 = AIManager.a;
        AIManager.f(r2);
    }

    public final void c(Function2<? super Boolean, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        vv3.a.a().b(new y0(r3));
    }

    public final Boolean l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        boolean r0 = AppletDebugManager.a;
        return Boolean.valueOf(AppletDebugManager.b(r2));
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.applet.debug.a] */
    public final Boolean m(String r9) {
        Intrinsics.checkNotNullParameter(r9, "code");
        boolean r1 = AppletDebugManager.a;
        Intrinsics.checkNotNullParameter(r9, "code");
        String r0 = null;
        String r2 = new JSONObject(r9).optString("action");     // Catch: Exception -> L5
    L6:
        boolean r3 = Intrinsics.areEqual(r2, "start_real_device_debug");
        Uri r4 = UriProtector.parse(r9);
        boolean r5 = true;
        if (Intrinsics.areEqual(r4.getScheme(), "doubaoapp") == true) goto L9;
    L13:
        boolean r6 = false;
    L14:
        if (r3 == true) goto L17;
        if (r6 == true) goto L17;
        com.bytedance.ai.utils.g.a.i("AppletDebugManager", "not a supported debug QR code");
        r5 = false;
    L24:
        return Boolean.valueOf(r5);
    L17:
        Function0 r7 = com.larus.platform.service.q.a.f().a;
        if (r7 == null) goto L20;
        r0 = (String) r7.invoke();
    L20:
        if (r0 != null) goto L22;
        r0 = "";
    L22:
        IAISDKDebugService.a.d(r9, r0, new com.bytedance.applet.debug.a());
        goto L24
    L9:
        if (Intrinsics.areEqual(r4.getHost(), "local_debug") == false) goto L13;
        if (com.larus.utils.o0.d(com.bytedance.ies.bullet.service.router.d.a(r4, "short_token")) == false) goto L13;
        r6 = true;
    L5:
        com.bytedance.ai.utils.g.a.i("AppletDebugManager", "scan code is not legacy json debug payload");
        r2 = null;
        goto L6
    }

    public final void e(String r13, n1 r14) {
        Intrinsics.checkNotNullParameter(r14, "completion");
        WeakReference<com.larus.login.api.g0> r1 = com.bytedance.applet.utils.o.b;
        Intrinsics.checkNotNullParameter(r14, "completion");
        ISdkDouyinAuth r0 = com.larus.platform.service.i0.a();
        if (r0 != null) goto L5;
        r14.invoke(null, null, "loginService is null");
        return;
    L5:
        boolean r3 = true;
        if (AccountService.a.isLogin().booleanValue() == true) goto L8;
        r14.invoke(null, null, "user is not logged in");
        return;
    L8:
        g5 r2 = r0.b();
        if (r2 != null) goto L12;
        r14.invoke(null, null, "douyin access token is null");
        return;
    L12:
        if (r2.f > System.currentTimeMillis()) goto L15;
        r14.invoke(null, null, "douyin access token is expired");
        return;
    L15:
        if (r13 == null) goto L32;
        List r15 = StringsKt.split$default(r13, new String[]{","}, false, 0, 6, null);
        if (r15 == null) goto L32;
        List r16 = r15;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r17 = r16.iterator();
    L20:
        if (r17.hasNext() == false) goto L22;
        r6.add(StringsKt.trim((String) r17.next()).toString());
        goto L20
    L22:
        ArrayList r18 = new ArrayList();
        Iterator r7 = r6.iterator();
    L24:
        if (r7.hasNext() == false) goto L31;
        Object r8 = r7.next();
        if (((String) r8).length() <= 0) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == false) goto L24;
        r18.add(r8);
        goto L24
    L28:
        r9 = false;
        goto L29
    L31:
        Set r19 = CollectionsKt.toSet(r18);
    L33:
        if (r19 != null) goto L35;
        r19 = SetsKt.emptySet();
    L35:
        String r10 = r2.c;
        if (r10 == null) goto L53;
        List r5 = StringsKt.split$default(r10, new String[]{","}, false, 0, 6, null);
        if (r5 == null) goto L53;
        List r11 = r5;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r4 = r11.iterator();
    L41:
        if (r4.hasNext() == false) goto L43;
        r12.add(StringsKt.trim((String) r4.next()).toString());
        goto L41
    L43:
        ArrayList r20 = new ArrayList();
        Iterator r21 = r12.iterator();
    L45:
        if (r21.hasNext() == false) goto L52;
        Object r22 = r21.next();
        if (((String) r22).length() <= 0) goto L49;
        boolean r23 = true;
    L50:
        if (r23 == false) goto L45;
        r20.add(r22);
        goto L45
    L49:
        r23 = false;
        goto L50
    L52:
        Set r24 = CollectionsKt.toSet(r20);
    L54:
        if (r24 != null) goto L57;
        r24 = SetsKt.emptySet();
    L57:
        if (r24.isEmpty() == false) goto L59;
        r14.invoke(null, null, "douyin granted scopes is empty");
        return;
    L59:
        Set r110 = SetsKt.minus(r19, r24);
        if ((!r110.isEmpty()) == false) goto L62;
        r14.invoke(null, null, "douyin required scopes not granted: " + CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null));
        return;
    L62:
        String r111 = r2.b;
        if (r111 != null) goto L65;
    L68:
        boolean r25 = true;
    L69:
        if (r25 == false) goto L71;
        r14.invoke(null, null, "douyin openId is empty");
        return;
    L71:
        String r26 = r2.a;
        if (r26 != null) goto L74;
    L77:
        if (r3 == false) goto L79;
        r14.invoke(null, null, "douyin accessToken is empty");
        return;
    L79:
        r14.invoke(r111, r26, null);
        return;
    L74:
        if (StringsKt.isBlank(r26) == true) goto L77;
        r3 = false;
        goto L77
    L65:
        if (StringsKt.isBlank(r111) == true) goto L68;
        r25 = false;
    L53:
        r24 = null;
    L32:
        r19 = null;
        goto L33
    }

    public final void f(String r12, m1 r13) {
        Intrinsics.checkNotNullParameter(r13, "completion");
        WeakReference<com.larus.login.api.g0> r1 = com.bytedance.applet.utils.o.b;
        Intrinsics.checkNotNullParameter(r13, "completion");
        ISdkDouyinAuth r0 = com.larus.platform.service.i0.a();
        if (r0 == null) goto L42;
        boolean r4 = true;
        if (AccountService.a.isLogin().booleanValue() != true) goto L42;
        if (r0.e() == true) goto L10;
        r13.invoke(Boolean.FALSE, null);
        return;
    L10:
        g5 r2 = r0.b();
        if (r2 == null) goto L13;
        Long r3 = Long.valueOf(r2.f);
    L14:
        if (r3 != null) goto L17;
        FLogger.a.i("FirstPartyAuthManager", "checkFirstPartyAuthStatus, token or expireAt is null");
        r13.invoke(Boolean.FALSE, null);
        return;
    L17:
        if (r3.longValue() > System.currentTimeMillis()) goto L19;
        FLogger.a.i("FirstPartyAuthManager", "checkFirstPartyAuthStatus, token expired");
        r13.invoke(Boolean.FALSE, null);
        return;
    L19:
        if (r12 != null) goto L21;
    L24:
        if (r4 == false) goto L26;
        FLogger.a.i("FirstPartyAuthManager", "checkFirstPartyAuthStatus, authorized (no scope required)");
        r13.invoke(Boolean.TRUE, null);
        return;
    L26:
        String r5 = r2.c;
        if (r5 == null) goto L36;
        List r6 = StringsKt.split$default(r5, new String[]{","}, false, 0, 6, null);
        if (r6 == null) goto L36;
        List r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L32:
        if (r9.hasNext() == false) goto L34;
        r8.add(StringsKt.trim((String) r9.next()).toString());
        goto L32
    L34:
        Set r10 = CollectionsKt.toSet(r8);
        if (r10 == null) goto L36;
    L37:
        Set r11 = r10;
        List r14 = StringsKt.split$default(r12, new String[]{","}, false, 0, 6, null);
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L39:
        if (r16.hasNext() == false) goto L41;
        r15.add(StringsKt.trim((String) r16.next()).toString());
        goto L39
    L41:
        Set r17 = CollectionsKt.toSet(r15);
        boolean r18 = r11.containsAll(r17);
        FLogger.a.i("FirstPartyAuthManager", "checkFirstPartyAuthStatus, isAuthorized:" + r18 + ", grantedScopes:" + r11 + ", requiredScopes:" + r17);
        r13.invoke(Boolean.valueOf(r18), null);
        return;
    L36:
        r10 = SetsKt.emptySet();
        goto L37
    L21:
        if (StringsKt.isBlank(r12) == true) goto L24;
        r4 = false;
        goto L24
    L13:
        r3 = null;
    L42:
        FLogger.a.i("FirstPartyAuthManager", "checkFirstPartyAuthStatus, not logged in");
        r13.invoke(Boolean.FALSE, null);
    }

    public final void h(com.bytedance.ai.api.g r5, o1 r6) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r6, "callback");
        i4 r0 = new i4(r5.a, r5.b, r5.c, r5.d);
        vv3.a.a().c(r0, new a1(r6));
    }

    public final void i(com.bytedance.ai.api.p r12, k1 r13) {
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r13, "callback");
        vv3.a.a().a(new com.larus.platform.api.m(r12.a, r12.b, r12.c, r12.d, r12.e, r12.g, r12.f, r12.h), new b1(r13));
    }

    public final void k(ToastIconType r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "toastIconType");
        Intrinsics.checkNotNullParameter(r9, "toastContent");
        int r10 = b.a[r8.ordinal()];
        if (r10 != 1) goto L5;
        t19.s.j(t19.s.a, AppHost.a.getApplication(), r9, null, false, 28);
        return;
    L5:
        if (r10 != 2) goto L7;
        t19.s r11 = t19.s.a;
        Application r0 = AppHost.a.getApplication();
        r11.getClass();
        t19.s.p(r0, r9);
        return;
    L7:
        if (r10 != 3) goto L9;
        t19.s r12 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        r12.getClass();
        t19.s.t(r1, r9);
        return;
    L9:
        if (r10 != 4) goto L12;
        t19.s r13 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        r13.getClass();
        t19.s.c(r2, r9);
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final void n(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "queryMsgId");
        if (StringsKt.isBlank(r5) == false) goto L5;
        com.bytedance.ai.utils.g.a.e("AppletV2ServiceImpl", "resendQueryMsg: empty messageId");
    L5:
        IFlowMessageService r0 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
        if (r0 != null) goto L8;
        com.bytedance.ai.utils.g.a.e("AppletV2ServiceImpl", "resendQueryMsg: IFlowMessageService not available");
    L8:
        if (r0 == null) goto L15;
        Pair[] r2 = new Pair[1];
        if (r6 == false) goto L12;
        String r7 = CommentScene.COMMENTSCENE_NO_AWEME;
    L13:
        r2[0] = TuplesKt.to("permission_interact", r7);
        r0.g(r5, true, MapsKt.mutableMapOf(r2), "resend");
        return;
    L12:
        r7 = "2";
        goto L13
    }

    public final void p(final com.bytedance.ai.api.e r4, final p1 r5) {
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "callback");
        WeakReference<DoubaoBottomSheetDialogFragment> r2 = iw3.q.a;
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "callback");
        final AtomicBoolean r0 = new AtomicBoolean(false);
        com.larus.utils.t0.e(new iw3.n(r4, r0, r5));
    }

    public final void a(Context r2, String r3, com.bytedance.ai.bridge.method.authorize.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "appletId");
        Intrinsics.checkNotNullParameter(r4, "completion");
        x0.a.getClass();
        x0.b(r2, r3, r4);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.applet.impl.z0] */
    public final void g(FragmentActivity r9, final String r10, final Function1<? super Boolean, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "permissionName");
        Intrinsics.checkNotNullParameter(r11, "completion");
        if (r9 != null) goto L6;
        r11.invoke(Boolean.FALSE);
        return;
    L6:
        ?? r0 = new z0(r10, r11);
        com.larus.platform.service.i2 r1 = com.larus.platform.service.i2.b;
        com.larus.platform.api.g1.a.b(r9, CollectionsKt.listOf(r10), new c(r11, r9, r10, r0), null, null, 56);
    }

    public final void j(String r85, String r86, String r87, Function1<? super Boolean, Unit> r88) {
        Intrinsics.checkNotNullParameter(r85, "msgId");
        Intrinsics.checkNotNullParameter(r86, "cardIs");
        Intrinsics.checkNotNullParameter(r87, "contentDataStr");
        Intrinsics.checkNotNullParameter(r88, "completion");
        BlockContent r1 = new BlockContent(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new PermissionApplyBlock(r87), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -65, 31, null);
        Block r15 = new Block(BlockType.BLOCK_TYPE_PERMISSION_APPLY.getValue(), r86, null, r1, false, null, null, null, 244, null);
        com.larus.im.d.e().w(r85, CollectionsKt.listOf(r15), new e(r88));
    }

    public final void d(AppletAppActivity r9, int r10, String r11, String r12, Map r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        boolean r0 = true;
        if (r10 != 1) goto L5;
        if (r11 != null) goto L13;
    L16:
        if (r0 == false) goto L19;
        com.bytedance.ai.utils.g.a.e("AppletV2ServiceImpl", "pin applet " + r11 + " failed: empty appletId");
        return;
    L19:
        if (r13 == null) goto L29;
        Object r14 = r13.get("isPin");
        if ((r14 instanceof Boolean) == false) goto L23;
        Boolean r15 = (Boolean) r14;
    L24:
        if (r15 == null) goto L30;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppletV2ServiceImpl$onAppletSystemSheetMenuItemClick$1$1$1(r11, r15.booleanValue(), this, null), 3, null);
        return;
    L30:
        return;
    L23:
        r15 = null;
        goto L24
    L29:
        return;
    L13:
        if (r11.length() == 0) goto L16;
        r0 = false;
        goto L16
    L5:
        if (r10 != 2) goto L7;
        x0.a.getClass();
        x0.b(r9, r11, null);
        return;
    L7:
        if (r10 != 6) goto L31;
        JSONObject r16 = new JSONObject();
        r16.put("doubao_apps_key", r11);
        r16.put("doubao_apps_name", r12);
        com.larus.platform.service.q.a.a(r9, r16.toString());
        return;
    }

    public final void o(Map r2, com.bytedance.ai.api.p r3, boolean r4, String r5, l1 r6) {
        Intrinsics.checkNotNullParameter(r2, "traceInfo");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r6, "completion");
        com.bytedance.applet.utils.o.a(r3, r2, r4, r5, r6);
    }
}
