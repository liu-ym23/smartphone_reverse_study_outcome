package com.obric.assistant.interaction.impl.performance;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/interaction/impl/performance/WindowAnimationBoostCoordinator;", "", "<init>", "()V", "TAG", "", "SYS_FW_BRIDGE_CLASS", "ANIMA_PROMOTION_OPT_CLASS", "GET_FACTORY_METHOD", "GET_ANIMA_PROMOTION_OPT_METHOD", "APPLY_ANIMA_PROMOTION_BOOST_METHOD", "ANIMA_PROMOTION_TYPE_FIELD", "DEFAULT_WINDOW_ANIMATION_DURATION_MS", "", "SLIDE_WINDOW_ANIMATION_DURATION_MS", "resolveFailureLogged", "Ljava/util/concurrent/atomic/AtomicBoolean;", "applyFailureLogged", "animaPromotionApi", "Lcom/obric/assistant/interaction/impl/performance/WindowAnimationBoostCoordinator$AnimaPromotionApi;", "getAnimaPromotionApi", "()Lcom/obric/assistant/interaction/impl/performance/WindowAnimationBoostCoordinator$AnimaPromotionApi;", "animaPromotionApi$delegate", "Lkotlin/Lazy;", "boost", "", "source", "durationMs", "AnimaPromotionApi", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowAnimationBoostCoordinator {
    private static final String ANIMA_PROMOTION_OPT_CLASS = "android.view.IAnimaPromotionOpt";
    private static final String ANIMA_PROMOTION_TYPE_FIELD = "ANIMA_PROMOTION_ASSISTANT_WINDOW_POPUP";
    private static final String APPLY_ANIMA_PROMOTION_BOOST_METHOD = "applyAnimaPromotionBoost";
    public static final int DEFAULT_WINDOW_ANIMATION_DURATION_MS = 400;
    private static final String GET_ANIMA_PROMOTION_OPT_METHOD = "getAnimaPromotionOpt";
    private static final String GET_FACTORY_METHOD = "getFactory";
    public static final WindowAnimationBoostCoordinator INSTANCE = null;
    public static final int SLIDE_WINDOW_ANIMATION_DURATION_MS = 700;
    private static final String SYS_FW_BRIDGE_CLASS = "android.app.SysFwBridge";
    private static final String TAG = "WindowAnimationBoost";
    private static final Lazy animaPromotionApi$delegate = null;
    private static final AtomicBoolean applyFailureLogged = null;
    private static final AtomicBoolean resolveFailureLogged = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/interaction/impl/performance/WindowAnimationBoostCoordinator$AnimaPromotionApi;", "", SocialConstants.PARAM_RECEIVER, "applyMethod", "Ljava/lang/reflect/Method;", "type", "", "<init>", "(Ljava/lang/Object;Ljava/lang/reflect/Method;I)V", "getReceiver", "()Ljava/lang/Object;", "getApplyMethod", "()Ljava/lang/reflect/Method;", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnimaPromotionApi {
        private final Method applyMethod;
        private final Object receiver;
        private final int type;

        public static /* synthetic */ AnimaPromotionApi copy$default(AnimaPromotionApi r100, Object r101, Method r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.receiver;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.applyMethod;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.type;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final Object component1() {
            return this.receiver;
        }

        public final Method component2() {
            return this.applyMethod;
        }

        public final int component3() {
            return this.type;
        }

        public final AnimaPromotionApi copy(Object r100, Method r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
            Intrinsics.checkNotNullParameter(r101, "applyMethod");
            return new AnimaPromotionApi(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AnimaPromotionApi) == true) goto L8;
            return false;
        L8:
            AnimaPromotionApi r101 = (AnimaPromotionApi) r100;
            if (Intrinsics.areEqual(this.receiver, r101.receiver) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.applyMethod, r101.applyMethod) == true) goto L15;
            return false;
        L15:
            if (this.type == r101.type) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.receiver.hashCode() * 31) + this.applyMethod.hashCode()) * 31) + this.type;
        }

        public String toString() {
            return "AnimaPromotionApi(receiver=" + this.receiver + ", applyMethod=" + this.applyMethod + ", type=" + this.type + ')';
        }

        public final Method getApplyMethod() {
            return this.applyMethod;
        }

        public final Object getReceiver() {
            return this.receiver;
        }

        public final int getType() {
            return this.type;
        }

        public AnimaPromotionApi(Object r100, Method r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
            Intrinsics.checkNotNullParameter(r101, "applyMethod");
            this.receiver = r100;
            this.applyMethod = r101;
            this.type = r102;
        }
    }

    private WindowAnimationBoostCoordinator() {
    }

    public static /* synthetic */ AnimaPromotionApi a() {
        return animaPromotionApi_delegate$lambda$2();
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static final AnimaPromotionApi animaPromotionApi_delegate$lambda$2() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = INVOKESTATIC_com_obric_assistant_interaction_impl_performance_WindowAnimationBoostCoordinator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(SYS_FW_BRIDGE_CLASS).getMethod(GET_FACTORY_METHOD, new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L5
        Object r103 = r102.getClass().getMethod(GET_ANIMA_PROMOTION_OPT_METHOD, new Class[0]).invoke(r102, new Object[0]);     // Catch: Throwable -> L5
        Class<?> r104 = r103.getClass();     // Catch: Throwable -> L5
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L5
        Method r106 = r104.getMethod(APPLY_ANIMA_PROMOTION_BOOST_METHOD, new Class[]{r105, r105});     // Catch: Throwable -> L5
        int r107 = INVOKESTATIC_com_obric_assistant_interaction_impl_performance_WindowAnimationBoostCoordinator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(ANIMA_PROMOTION_OPT_CLASS).getField(ANIMA_PROMOTION_TYPE_FIELD).getInt(null);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L5
        Object r108 = Result.m9449constructorimpl(new AnimaPromotionApi(r103, r106, r107));     // Catch: Throwable -> L5
    L7:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L13;
        if (resolveFailureLogged.compareAndSet(false, true) == false) goto L13;
        FLogger.f375446a.d(TAG, "resolve anima promotion API failed, error=".concat(r109.getClass().getSimpleName()));
    L13:
        if (Result.m9455isFailureimpl(r108) == true) goto L17;
        r100 = r108;
    L17:
        return (AnimaPromotionApi) r100;
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    static {
        INSTANCE = new WindowAnimationBoostCoordinator();
        resolveFailureLogged = new AtomicBoolean(false);
        applyFailureLogged = new AtomicBoolean(false);
        animaPromotionApi$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new b());
    }

    private final AnimaPromotionApi getAnimaPromotionApi() {
        return (AnimaPromotionApi) animaPromotionApi$delegate.getValue();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_performance_WindowAnimationBoostCoordinator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public final void boost(String r100, int r110) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (r110 > 0) goto L25;
        FLogger.f375446a.w(TAG, "boost ignored, source=" + r100 + ", durationMs=" + r110);
        return;
    L25:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        AnimaPromotionApi r102 = getAnimaPromotionApi();     // Catch: Throwable -> L13
        if (r102 != null) goto L10;
        boolean r103 = false;
    L11:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L13
    L15:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L21;
        if (applyFailureLogged.compareAndSet(false, true) == false) goto L21;
        FLogger.f375446a.d(TAG, "applyAssistantWindowAnimationBoost failed, source=" + r100 + ", durationMs=" + r110 + ", error=" + r105.getClass().getSimpleName());
    L21:
        if (Result.m9456isSuccessimpl(r104) == false) goto L23;
        ((Boolean) r104).booleanValue();
        applyFailureLogged.set(false);
    L23:
        Result.m9455isFailureimpl(r104);
        return;
    L10:
        r102.getApplyMethod().invoke(r102.getReceiver(), new Object[]{Integer.valueOf(r102.getType()), Integer.valueOf(r110)});     // Catch: Throwable -> L13
        r103 = true;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
