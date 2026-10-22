package com.obric.sva.sdk.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.media.AudioRecord;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.base.Constant;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.controller.HotwordRecorderMgr;
import com.obric.sva.sdk.effectplatform.EffectConstant;
import com.obric.sva.sdk.sami.SamiPhoneEnrollManager;
import com.obric.sva.sdk.sami.SamiWakeupParamProvider;
import com.obric.sva.sdk.service.WakeupService;
import com.obric.sva.sdk.session.SessionType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J \u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0007J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001eH\u0007J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0007J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0007J\u0014\u0010&\u001a\u00020\u0010*\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J\f\u0010*\u001a\u00020\u0010*\u00020'H\u0007J\u000e\u0010+\u001a\u00020,2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010-\u001a\u00020,2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010.\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020,2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007JB\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020,2\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001008H\u0007J\u0013\u00109\u001a\u00020\u0005*\u0004\u0018\u00010:H\u0007¢\u0006\u0002\u0010;J\u000e\u0010<\u001a\u00020\u0010*\u0004\u0018\u00010=H\u0007J\u0017\u0010>\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020@0?H\u0007¢\u0006\u0002\u0010AJ+\u0010B\u001a\u00020\u00102\u001c\u0010C\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100E\u0012\u0006\u0012\u0004\u0018\u00010\u00010DH\u0007¢\u0006\u0002\u0010FJ\b\u0010I\u001a\u00020,H\u0007J\b\u0010J\u001a\u000205H\u0007J\b\u0010K\u001a\u000205H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00050\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR\u0011\u0010G\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bH\u0010\n¨\u0006L"}, d2 = {"Lcom/obric/sva/sdk/utils/KtUtils;", "", "<init>", "()V", "TAG", "", "GENESIS_R", TriggerTiming.NOW, "kotlin.jvm.PlatformType", "getNow", "()Ljava/lang/String;", "sProcessName", "getSProcessName", "setSProcessName", "(Ljava/lang/String;)V", "onAccountLogout", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onEnterpriseAccountLogout", "onAccountBecomeActive", "newUid", "onAccountSwitchAway", "onAccountLogin", "reloadSamiCore", "Flogger", "name", "tag", "msg", "findSessionTypeBySmName", "Lcom/obric/sva/sdk/session/SessionType;", "smName", "findSmNameBySessionType", InteractConst.WAKEUP_SESSION_TYPE, "md5", "filePath", "stream", "Ljava/io/InputStream;", "setBlur", "Landroid/widget/TextView;", "radius", "", "clearBlur", "isMainProcess", "", "isWakeupProcess", "getCurProcessName", "isDozeModeEnable", "readBuffer", "", "audioRecord", "Landroid/media/AudioRecord;", "targetLength", "", "onlyCache", "action", "Lkotlin/Function3;", "short", "", "(Ljava/lang/Double;)Ljava/lang/String;", "closeQuitely", "Ljava/io/Closeable;", "closeAll", "", "Landroid/os/ParcelFileDescriptor;", "([Landroid/os/ParcelFileDescriptor;)V", "runInIo", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)V", "platformName", "getPlatformName", "isMainUser", "myUserId", "myPid", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KtUtils {
    private static final String GENESIS_R = "genesis-r";
    public static final KtUtils INSTANCE = null;
    public static final String TAG = "KtUtils";
    private static String sProcessName;

    /* JADX INFO: renamed from: com.obric.sva.sdk.utils.KtUtils$runInIo$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes34.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.sva.sdk.utils.KtUtils$runInIo$1", f = "KtUtils.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super AnonymousClass1> r101) {
            this.$block = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$block, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Function1<Continuation<? super Unit>, Object> r103 = this.$block;
            this.label = 1;
            if (r103.invoke(this) != r101) goto L12;
            return r101;
        }
    }

    private KtUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @JvmStatic
    public static final int myUserId() {
        Method r100 = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);     // Catch: Exception -> L5
        r100.setAccessible(true);     // Catch: Exception -> L5
        Object r101 = r100.invoke(null, new Object[0]);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L5
        int r102 = ((Integer) r101).intValue();     // Catch: Exception -> L5
    L6:
        LogUtils.d(TAG, "myUserId " + r102, new Object[0]);
        return r102;
    L5:
        r102 = Process.myUid() / 100000;
        goto L6
    }

    static {
        INSTANCE = new KtUtils();
        sProcessName = "";
    }

    private final String getCurProcessName() {
        boolean r100 = true;
        if (sProcessName.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        return sProcessName;
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L16;
        String r102 = Application.getProcessName();
        if (r102 != null) goto L14;
        r102 = "";
    L14:
        sProcessName = r102;
    L16:
        if (sProcessName.length() > 0) goto L19;
        r100 = false;
    L19:
        if (r100 == true) goto L21;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L36
        InputStreamReader r104 = new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/self/cmdline"));     // Catch: Throwable -> L36
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L31
    L24:
        int r106 = r104.read();     // Catch: Throwable -> L31
        if (r106 <= 0) goto L27;
        r105.append((char) r106);     // Catch: Throwable -> L31
        goto L24
    L27:
        String r107 = r105.toString();     // Catch: Throwable -> L31
    L29:
        CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L36
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L36
    L39:
        if (Result.m9456isSuccessimpl(r108) == false) goto L41;
        sProcessName = (String) r108;
    L41:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L45;
        LogUtils.e(TAG, "getCurProcessName failed: " + r109.getMessage(), new Object[0]);
    L45:
        return sProcessName;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L21:
        return sProcessName;
    L5:
        r101 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean isMainUser() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 23) goto L5;
        UserManager r101 = (UserManager) ContextCompat.getSystemService(AppHost.f326268a.getApplication(), UserManager.class);
    L10:
        if (r100 < 23) goto L14;
        if (r101 == null) goto L13;
        boolean r102 = r101.isSystemUser();
    L15:
        LogUtils.d(TAG, "isMainUser? " + r102, new Object[0]);
        return r102;
    L13:
        r102 = true;
        goto L15
    L14:
        r102 = false;
        goto L15
    L5:
        Object r103 = AppHost.f326268a.getApplication().getSystemService("user");
        if ((r103 instanceof UserManager) == false) goto L8;
        r101 = (UserManager) r103;
        goto L10
    L8:
        r101 = null;
        goto L10
    }

    public final String getNow() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
    }

    @JvmStatic
    public static final int myPid() {
        int r100 = Process.myPid();
        LogUtils.d(TAG, "myPid " + r100, new Object[0]);
        return r100;
    }

    public final String getPlatformName() {
        String r100 = t9a.b.a().d();
        LogUtils.d(TAG, "@platform name@ is " + r100, new Object[0]);
        if (Intrinsics.areEqual(r100.toLowerCase(Locale.ROOT), GENESIS_R) == true) goto L7;
        return "default";
    L7:
        return GENESIS_R;
    }

    public final String getSProcessName() {
        return sProcessName;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_sva_sdk_utils_KtUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @JvmStatic
    public static final void clearBlur(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LogUtils.i(TAG, "setBlur radius : clear", new Object[0]);
        r100.getPaint().setMaskFilter(null);
        r100.postInvalidate();
    }

    @JvmStatic
    public static final void closeAll(ParcelFileDescriptor[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        closeQuitely(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    @JvmStatic
    public static final void closeQuitely(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @JvmStatic
    public static final SessionType findSessionTypeBySmName(String r100) {
        if (r100 == null) goto L4;
        SessionType r101 = Global.sSessionTypeMap.get(r100);
        if (r101 == null) goto L9;
        return r101;
    L9:
        if (StringsKt.contains$default(r100, "breath", false, 2, null) == false) goto L12;
        return SessionType.BREATH;
    L12:
        return SessionType.VOICE;
    L4:
        return SessionType.VOICE;
    }

    @JvmStatic
    public static final String findSmNameBySessionType(SessionType r100) {
        Intrinsics.checkNotNullParameter(r100, InteractConst.WAKEUP_SESSION_TYPE);
        Map<String, SessionType> r101 = Global.sSessionTypeMap;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, SessionType>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, SessionType> r104 = r103.next();
        if (r104.getValue() != r100) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L4;
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L8:
        r105 = false;
        goto L9
    L11:
        String r106 = (String) CollectionsKt.firstOrNull(r102.keySet());
        if (r106 != null) goto L20;
        return "";
    L20:
        return r106;
    }

    @JvmStatic
    public static final boolean isDozeModeEnable(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Settings.Secure.getInt(r100.getContentResolver(), Constant.DOZE_ALWAYS_ON, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @JvmStatic
    public static final String md5(String r110) {
        Intrinsics.checkNotNullParameter(r110, "filePath");
        if (rna.c.c(r110) == true) goto L6;
        LogUtils.e(TAG, "md5 : file not exist", new Object[0]);
        return "";
    L6:
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110);
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r110);     // Catch: Exception -> L16
        MessageDigest r111 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L16
        byte[] r102 = new byte[8192];     // Catch: Exception -> L16
    L8:
        int r103 = r101.read(r102);     // Catch: Exception -> L16
        if (r103 == (-1)) goto L11;
        r111.update(r102, 0, r103);     // Catch: Exception -> L16
        goto L8
    L11:
        byte[] r112 = r111.digest();     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L16
        int r104 = r112.length;     // Catch: Exception -> L16
        String r105 = "";
        int r106 = 0;
    L12:
        if (r106 >= r104) goto L14;
        r105 = r105 + String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r112[r106])}, 1));     // Catch: Exception -> L16
        r106 = r106 + 1;     // Catch: Exception -> L16
        goto L12
    L14:
        r101.close();     // Catch: Exception -> L16
        LogUtils.e(TAG, "md5 : [" + r105 + "] of file " + r100.getName(), new Object[0]);     // Catch: Exception -> L16
        return r105;
    L16:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final void onAccountLogin(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String[] r101 = rna.b.j(r100.getApplicationContext());
        boolean r102 = true;
        if (r101[0].length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        String r104 = "";
        if (r103 == true) goto L9;
    L14:
        String r105 = "";
    L16:
        if (r105.length() == 0) goto L20;
        r102 = false;
    L20:
        if (r102 == false) goto L22;
        LogUtils.d(TAG, "empty uid or did", new Object[0]);
    L22:
        Intrinsics.checkNotNullParameter(r105, ST.UUID_DEVICE);
        if (rna.b.k(StringsKt.substringBefore(r105, '-', ""), StringsKt.substringAfter(r105, '-', "")) == false) goto L25;
        r104 = r105;
    L26:
        rna.b.f538735a = r104;
        LogUtils.i(TAG, "onLogin , cache uid/did and broadcast model download intent", new Object[0]);
        Intent r106 = new Intent();
        r106.setAction(EffectConstant.USER_LOGIN_INTENT);
        r106.setPackage("com.larus.nova");
        r100.sendBroadcast(r106);
        return;
    L25:
        rna.b.l(r105);
        goto L26
    L9:
        if (r101[1].length() <= 0) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L14;
        r105 = r101[0] + '-' + r101[1];
        goto L16
    L11:
        r107 = false;
        goto L12
    L5:
        r103 = false;
        goto L6
    }

    @JvmStatic
    public static final void onAccountLogout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LogUtils.i(TAG, "onLogout, destroy wakeup service samicore, and set wakeup status to OFF", new Object[0]);
        Global.sWakeupStatus = false;
        Global.setBreathStatus(false);
        sna.f.c(Global.SETTINGS_VOICE_ASSISTANT_WAKEUP_STATUS, -1);
        sna.f.c(Constant.BREATH_WAKEUP_STATUS, -1);
        Intent r101 = new Intent();
        r101.setAction(Global.DESTROY_SAMICORE_ACTIVITY_ACTION);
        r101.setPackage("com.larus.nova");
        r101.setClass(r100, WakeupService.class);
        r100.startService(r101);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        SamiPhoneEnrollManager.INSTANCE.releasePhoneEnrollHandle("personal_logout");     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        LogUtils.e(TAG, "onAccountLogout release phone enroll handle failed: " + r104.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void onAccountSwitchAway(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LogUtils.i(TAG, "onAccountSwitchAway: release phone enroll handle only", new Object[0]);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        SamiPhoneEnrollManager.INSTANCE.releasePhoneEnrollHandle("switch_away");     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        LogUtils.e(TAG, "onAccountSwitchAway release handle failed: " + r103.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void onEnterpriseAccountLogout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LogUtils.i(TAG, "onEnterpriseAccountLogout: release phone enroll handle only", new Object[0]);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        SamiPhoneEnrollManager.INSTANCE.releasePhoneEnrollHandle("enterprise_logout");     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        LogUtils.e(TAG, "onEnterpriseAccountLogout release handle failed: " + r103.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void reloadSamiCore(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LogUtils.i(TAG, "reloadSamiCore: send RELOAD_SAMICORE_ACTIVITY_ACTION", new Object[0]);
        Intent r101 = new Intent();
        r101.setAction(Global.RELOAD_SAMICORE_ACTIVITY_ACTION);
        r101.setPackage("com.larus.nova");
        r101.setClass(r100, WakeupService.class);
        r100.startService(r101);
    }

    @JvmStatic
    public static final void runInIo(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r100, null), 3, null);
    }

    @JvmStatic
    /* JADX INFO: renamed from: short, reason: not valid java name */
    public static final String m8597short(Double r100) {
        if (r100 != null) goto L5;
        return "nil";
    L5:
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        return String.format("%.5f", Arrays.copyOf(new Object[]{r100}, 1));
    }

    public final boolean isMainProcess(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = getCurProcessName();
        if (StringsKt.contains$default(r101, ":", false, 2, null) == false) goto L6;
        return false;
    L6:
        return Intrinsics.areEqual(r101, r100.getPackageName());
    }

    public final boolean isWakeupProcess(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return StringsKt.contains$default(getCurProcessName(), ":interactor", false, 2, null);
    }

    public final void setSProcessName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        sProcessName = r100;
    }

    @JvmStatic
    public static final String md5(InputStream r110) {
        Intrinsics.checkNotNullParameter(r110, "stream");
        MessageDigest r100 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
        byte[] r101 = new byte[8192];     // Catch: Exception -> L12
    L4:
        int r102 = r110.read(r101);     // Catch: Exception -> L12
        if (r102 == (-1)) goto L7;
        r100.update(r101, 0, r102);     // Catch: Exception -> L12
        goto L4
    L7:
        byte[] r103 = r100.digest();     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L12
        int r104 = r103.length;     // Catch: Exception -> L12
        String r105 = "";
        int r106 = 0;
    L8:
        if (r106 >= r104) goto L10;
        r105 = r105 + String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r103[r106])}, 1));     // Catch: Exception -> L12
        r106 = r106 + 1;     // Catch: Exception -> L12
        goto L8
    L10:
        r110.close();     // Catch: Exception -> L12
        LogUtils.e(TAG, "md5 : [" + r105 + ']', new Object[0]);     // Catch: Exception -> L12
        return r105;
    L12:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    @JvmStatic
    public static final void onAccountBecomeActive(Context r100, String r101) {
        String r102 = "";
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "newUid");
        LogUtils.i(TAG, "onAccountBecomeActive newUidLen=" + r101.length(), new Object[0]);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        SamiPhoneEnrollManager.INSTANCE.releasePhoneEnrollHandle("account_active");     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L11;
        LogUtils.e(TAG, "onAccountBecomeActive release handle failed: " + r105.getMessage(), new Object[0]);
    L11:
        if (StringsKt.isBlank(r101) == false) goto L13;
        return;
    L13:
        Context r106 = r100.getApplicationContext();
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L19
        String r107 = (String) ArraysKt.getOrNull(rna.b.j(r106), 1);     // Catch: Throwable -> L19
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L19
    L21:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L25;
        LogUtils.e(TAG, "onAccountBecomeActive get did failed: " + r109.getMessage(), new Object[0]);
    L25:
        if (Result.m9455isFailureimpl(r108) == false) goto L27;
        r108 = "";
    L27:
        String r110 = (String) r108;
        if (StringsKt.isBlank(r110) == false) goto L31;
        LogUtils.w(TAG, "onAccountBecomeActive skip prepareBaseSnapshot: did blank", new Object[0]);
        return;
    L31:
        String r111 = r101 + '-' + r110;
        String r112 = rna.b.f538735a;     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r111, ST.UUID_DEVICE);     // Catch: Throwable -> L42
        if (r111 != null) goto L35;
        String r113 = "";
    L37:
        if (rna.b.k(StringsKt.substringBefore(r113, '-', ""), StringsKt.substringAfter(r113, '-', "")) == false) goto L39;
        r102 = r111;
    L40:
        rna.b.f538735a = r102;     // Catch: Throwable -> L42
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L55;
        LogUtils.e(TAG, "onAccountBecomeActive setUidAndDid failed: " + r115.getMessage(), new Object[0]);
    L55:
        SamiWakeupParamProvider.INSTANCE.prepareBaseSnapshot(r100, r111);     // Catch: Throwable -> L49
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L49
    L51:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L63;
        LogUtils.e(TAG, "onAccountBecomeActive prepareBaseSnapshot failed: " + r117.getMessage(), new Object[0]);
        return;
    L63:
        return;
    L49:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    L39:
        rna.b.l(r111);     // Catch: Throwable -> L42
        goto L40
    L35:
        r113 = r111;
    L42:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L19:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final void setBlur(TextView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LogUtils.i(TAG, "setBlur radius : [" + r101 + ']', new Object[0]);
        r100.getPaint().setMaskFilter(new BlurMaskFilter(r101, BlurMaskFilter.Blur.NORMAL));
        r100.postInvalidate();
    }

    @JvmStatic
    public static final void Flogger(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
        Class r103 = INVOKESTATIC_com_obric_sva_sdk_utils_KtUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.larus.utils.logger.FLogger");     // Catch: Throwable -> L5
        Object r104 = r103.getDeclaredField("INSTANCE").get(null);     // Catch: Throwable -> L5
        r103.getMethod(r100, new Class[]{String.class, String.class}).invoke(r104, new Object[]{r101, r102});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        LogUtils.e(TAG, "Flogger error , use Sdk Logger", new Object[0]);
        LogUtils.e(TAG, r102, new Object[0]);
    }

    @JvmStatic
    public static final byte[] readBuffer(AudioRecord r100, int r101, boolean r102, Function3<? super Integer, ? super Integer, ? super byte[], Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "audioRecord");
        Intrinsics.checkNotNullParameter(r110, "action");
        byte[] r103 = new byte[r101];
        LogUtils.i(TAG, "readBuffer: onlyCache = " + r102, new Object[0]);
        if (HotwordRecorderMgr.ensureStarted(r100, SessionType.VOICE) == true) goto L6;
        LogUtils.d(TAG, "readBuffer: startRecording failed before first read", new Object[0]);
        return r103;
    L6:
        int r104 = 0;
    L7:
        if (r104 >= r101) goto L20;
        if (r100.getRecordingState() == 1) goto L20;
        if ((r104 + r101) <= r101) goto L13;
        int r105 = r101 - r104;
    L14:
        int r106 = r100.read(r103, r104, r105);
        if (r106 < 0) goto L16;
        r110.invoke(Integer.valueOf(r104), Integer.valueOf(r106), r103);
        r104 = r104 + r106;
        if (r102 == false) goto L7;
        if (r106 != 0) goto L7;
    L16:
        LogUtils.d(TAG, "startHotWordRecording: read failed!  error = " + r106, new Object[0]);
        goto L20
    L13:
        r105 = r101;
    L20:
        return r103;
    }

    public static /* synthetic */ byte[] readBuffer$default(AudioRecord r100, int r101, boolean r102, Function3 r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = false;
    L6:
        return readBuffer(r100, r101, r102, r103);
    }
}
