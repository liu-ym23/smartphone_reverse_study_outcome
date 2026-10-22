package com.obric.assistant.interaction.impl.window;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.IBinder;
import android.view.ViewParent;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowReflectionCompat;", "", "<init>", "()V", "ViewRootImplRef", "ActivityThreadRef", "LoadedApkRef", "ContextImplRef", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowReflectionCompat {
    public static final ChatWindowReflectionCompat INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¨\u0006\b"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowReflectionCompat$ActivityThreadRef;", "", "<init>", "()V", "current", "instrumentation", "Landroid/app/Instrumentation;", INotificationHitPoint.NoticeType.AT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ActivityThreadRef {
        public static final ActivityThreadRef INSTANCE = null;

        static {
            INSTANCE = new ActivityThreadRef();
        }

        private ActivityThreadRef() {
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        public final Object current() {
            Method r100 = INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ActivityThreadRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);     // Catch: Throwable -> L5
            r100.setAccessible(true);     // Catch: Throwable -> L5
            return r100.invoke(null, new Object[0]);
        L8:
            return null;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ActivityThreadRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

        public final Instrumentation instrumentation(Object r100) {
            if (r100 == null) goto L14;
            Field r101 = r100.getClass().getDeclaredField("mInstrumentation");     // Catch: Throwable -> L10
            r101.setAccessible(true);     // Catch: Throwable -> L10
            Object r102 = r101.get(r100);     // Catch: Throwable -> L10
            if ((r102 instanceof Instrumentation) == false) goto L13;
            return (Instrumentation) r102;
        L13:
            return null;
        L15:
            return null;
        L14:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bJ\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u001f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowReflectionCompat$ContextImplRef;", "", "<init>", "()V", "cls", "Ljava/lang/Class;", "getCls", "()Ljava/lang/Class;", "cls$delegate", "Lkotlin/Lazy;", "createActivityContext", "Landroid/content/Context;", INotificationHitPoint.NoticeType.AT, "loadedApk", "activityInfo", "Landroid/content/pm/ActivityInfo;", "token", "Landroid/os/IBinder;", "displayId", "", "overrideConfig", "Landroid/content/res/Configuration;", "setOuterContext", "", "contextImpl", RNParamRegisterEventHandler.SRC_OUTER, "findField", "Ljava/lang/reflect/Field;", "c", "name", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ContextImplRef {
        public static final ContextImplRef INSTANCE = null;
        private static final Lazy cls$delegate = null;

        private ContextImplRef() {
        }

        public static /* synthetic */ Method a(Class[] r100) {
            return createActivityContext$lambda$3(r100);
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        public static /* synthetic */ Class b() {
            return cls_delegate$lambda$0();
        }

        static {
            INSTANCE = new ContextImplRef();
            cls$delegate = LazyKt.lazy(new m());
        }

        private static final Class cls_delegate$lambda$0() {
            return INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ContextImpl");
        }

        private final Class<?> getCls() {
            return (Class) cls$delegate.getValue();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

        private static final Method createActivityContext$lambda$3(Class[] r100) {
            Intrinsics.checkNotNullParameter(r100, "signature");
            ContextImplRef r101 = INSTANCE;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
            Method r103 = r101.getCls().getDeclaredMethod("createActivityContext", (Class[]) Arrays.copyOf(r100, r100.length));     // Catch: Throwable -> L5
            r103.setAccessible(true);     // Catch: Throwable -> L5
            Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L5
        L8:
            if (Result.m9455isFailureimpl(r104) == false) goto L11;
            r104 = null;
        L11:
            return (Method) r104;
        L5:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L8
        }

        private final Field findField(Class<?> r100, String r101) {
        L2:
            if (r100 == null) goto L6;
            Field r102 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L5
            r102.setAccessible(true);     // Catch: NoSuchFieldException -> L5
            return r102;
        L5:
            r100 = r100.getSuperclass();
            goto L2
        L6:
            return null;
        }

        public final void setOuterContext(Context r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "contextImpl");
            Intrinsics.checkNotNullParameter(r101, RNParamRegisterEventHandler.SRC_OUTER);
            Method r102 = getCls().getDeclaredMethod("setOuterContext", new Class[]{Context.class});     // Catch: Throwable -> L5
            r102.setAccessible(true);     // Catch: Throwable -> L5
            r102.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L5
            return;
        L5:
            Field r103 = findField(getCls(), "mOuterContext");     // Catch: Throwable -> L9
            if (r103 == null) goto L14;
            r103.set(r100, r101);     // Catch: Throwable -> L9
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
            return;
        L14:
            return;
        L9:
            Unit r105 = Unit.INSTANCE;
        }

        public final Context createActivityContext(Object r110, Object r111, ActivityInfo r112, IBinder r113, int r210, Configuration r211) {
            Intrinsics.checkNotNullParameter(r112, "activityInfo");
            Intrinsics.checkNotNullParameter(r113, "token");
            if (r110 == null) goto L28;
            if (r111 == null) goto L31;
            Method r100 = (Method) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(CollectionsKt.listOf(new Class[][]{new Class[]{INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread"), INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.LoadedApk"), ActivityInfo.class, IBinder.class, Integer.TYPE, Configuration.class}, new Class[]{INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread"), INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ContextImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.LoadedApk"), ActivityInfo.class, IBinder.class}})), new n()));
            if (r100 != null) goto L27;
        L12:
            Integer r101 = null;
        L14:
            if (r101 != null) goto L17;
        L19:
            if (r101 != null) goto L22;
            return null;
        L22:
            if (r101.intValue() != 4) goto L30;
            Object r102 = r100.invoke(null, new Object[]{r110, r111, r112, r113});     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.content.Context");     // Catch: Throwable -> L26
            Context r103 = (Context) r102;     // Catch: Throwable -> L26
        L25:
            return r103;
        L30:
            return null;
        L17:
            if (r101.intValue() != 6) goto L19;
            Object r104 = r100.invoke(null, new Object[]{r110, r111, r112, r113, Integer.valueOf(r210), r211});     // Catch: Throwable -> L26
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.content.Context");     // Catch: Throwable -> L26
            r103 = (Context) r104;     // Catch: Throwable -> L26
            goto L25
        L27:
            Class<?>[] r105 = r100.getParameterTypes();     // Catch: Throwable -> L26
            if (r105 == null) goto L12;
            r101 = Integer.valueOf(r105.length);     // Catch: Throwable -> L26
            goto L14
        L32:
            return null;
        L31:
            return null;
        L28:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n¨\u0006\r"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowReflectionCompat$LoadedApkRef;", "", "<init>", "()V", "fromActivityThread", "app", "Landroid/app/Application;", "viaNoCheck", "fromContextImpl", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "obtain", "anyContext", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadedApkRef {
        public static final LoadedApkRef INSTANCE = null;

        static {
            INSTANCE = new LoadedApkRef();
        }

        private LoadedApkRef() {
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$LoadedApkRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

        public final Object fromActivityThread(Application r100) {
            Intrinsics.checkNotNullParameter(r100, "app");
            Object r101 = ActivityThreadRef.INSTANCE.current();
            if (r101 != null) goto L5;
            return null;
        L5:
            String r102 = r100.getPackageName();
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L23
            Field r104 = r101.getClass().getDeclaredField("mPackages");     // Catch: Throwable -> L23
            r104.setAccessible(true);     // Catch: Throwable -> L23
            Object r105 = r104.get(r101);     // Catch: Throwable -> L23
            if ((r105 instanceof Map) == false) goto L9;
            Map r106 = (Map) r105;     // Catch: Throwable -> L23
        L10:
            if (r106 == null) goto L12;
            Object r107 = r106.get(r102);     // Catch: Throwable -> L23
        L14:
            if ((r107 instanceof WeakReference) == false) goto L16;
            WeakReference r108 = (WeakReference) r107;     // Catch: Throwable -> L23
        L17:
            if (r108 == null) goto L21;
            Object r109 = r108.get();     // Catch: Throwable -> L23
            if (r109 == null) goto L21;
            return r109;
        L21:
            Result.m9449constructorimpl(null);     // Catch: Throwable -> L23
        L45:
            Field r110 = r101.getClass().getDeclaredField("mResourcePackages");     // Catch: Throwable -> L42
            r110.setAccessible(true);     // Catch: Throwable -> L42
            Object r111 = r110.get(r101);     // Catch: Throwable -> L42
            if ((r111 instanceof Map) == false) goto L28;
            Map r112 = (Map) r111;     // Catch: Throwable -> L42
        L29:
            if (r112 == null) goto L31;
            Object r113 = r112.get(r102);     // Catch: Throwable -> L42
        L33:
            if ((r113 instanceof WeakReference) == false) goto L35;
            WeakReference r114 = (WeakReference) r113;     // Catch: Throwable -> L42
        L36:
            if (r114 == null) goto L40;
            Object r115 = r114.get();     // Catch: Throwable -> L42
            if (r115 == null) goto L40;
            return r115;
        L40:
            Result.m9449constructorimpl(null);     // Catch: Throwable -> L42
        L44:
            return null;
        L35:
            r114 = null;
            goto L36
        L31:
            r113 = null;
            goto L33
        L28:
            r112 = null;
        L42:
            th = move-exception;
            Result.Companion r116 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L44
        L16:
            r108 = null;
            goto L17
        L12:
            r107 = null;
            goto L14
        L9:
            r106 = null;
        L23:
            th = move-exception;
            Result.Companion r117 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L45
        }

        public final Object fromContextImpl(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        L4:
            if ((r100 instanceof ContextWrapper) == false) goto L18;
            r100 = ((ContextWrapper) r100).getBaseContext();
            goto L4
        L18:
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
            Field r102 = r100.getClass().getDeclaredField("mLoadedApk");     // Catch: Throwable -> L9
            r102.setAccessible(true);     // Catch: Throwable -> L9
            return r102.get(r100);
        L9:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            Field r104 = r100.getClass().getDeclaredField("mPackageInfo");     // Catch: Throwable -> L13
            r104.setAccessible(true);     // Catch: Throwable -> L13
            return r104.get(r100);
        L13:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return null;
        }

        public final Object viaNoCheck(Application r110) {
            Intrinsics.checkNotNullParameter(r110, "app");
            Object r100 = ActivityThreadRef.INSTANCE.current();
            if (r100 != null) goto L5;
            return null;
        L5:
            Class<?> r101 = r100.getClass();
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
            Object r103 = Result.m9449constructorimpl(r110.getPackageManager().getApplicationInfo(r110.getPackageName(), 0));     // Catch: Throwable -> L8
        L11:
            if (Result.m9455isFailureimpl(r103) == false) goto L13;
            r103 = null;
        L13:
            ApplicationInfo r104 = (ApplicationInfo) r103;
            if (r104 != null) goto L70;
            return null;
        L70:
            Object r105 = Result.m9449constructorimpl(INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$LoadedApkRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.res.CompatibilityInfo"));     // Catch: Throwable -> L18
        L21:
            if (Result.m9455isFailureimpl(r105) == false) goto L23;
            r105 = null;
        L23:
            Class r106 = (Class) r105;
            if (r106 != null) goto L66;
            return null;
        L66:
            Field r107 = r106.getDeclaredField("DEFAULT_COMPATIBILITY_INFO");     // Catch: Throwable -> L29
            r107.setAccessible(true);     // Catch: Throwable -> L29
            Object r108 = Result.m9449constructorimpl(r107.get(null));     // Catch: Throwable -> L29
        L32:
            if (Result.m9455isFailureimpl(r108) == false) goto L34;
            r108 = null;
        L34:
            if (r108 != null) goto L36;
            return null;
        L36:
            Iterator r109 = CollectionsKt.listOf(new Class[][]{new Class[]{ApplicationInfo.class, r106}, new Class[]{ApplicationInfo.class, r106, ClassLoader.class}}).iterator();
        L38:
            if (r109.hasNext() == false) goto L65;
            Class[] r111 = (Class[]) r109.next();
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L42
            Method r113 = r101.getDeclaredMethod("getPackageInfoNoCheck", (Class[]) Arrays.copyOf(r111, r111.length));     // Catch: Throwable -> L42
            r113.setAccessible(true);     // Catch: Throwable -> L42
            Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L42
        L45:
            if (Result.m9455isFailureimpl(r114) == false) goto L47;
            r114 = null;
        L47:
            Method r115 = (Method) r114;
            if (r115 == null) goto L38;
            int r116 = r111.length;
            if (r116 == 2) goto L55;
            if (r116 != 3) goto L38;
            Object[] r117 = {r104, r108, r110.getClassLoader()};
        L72:
            Object r118 = Result.m9449constructorimpl(r115.invoke(r100, Arrays.copyOf(r117, r117.length)));     // Catch: Throwable -> L58
        L61:
            if (Result.m9455isFailureimpl(r118) == false) goto L63;
            r118 = null;
        L63:
            if (r118 == null) goto L38;
            return r118;
        L58:
            th = move-exception;
            Result.Companion r119 = Result.Companion;
            r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L61
        L55:
            r117 = new Object[]{r104, r108};
        L42:
            th = move-exception;
            Result.Companion r120 = Result.Companion;
            r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L45
        L65:
            return null;
        L29:
            th = move-exception;
            Result.Companion r121 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L18:
            th = move-exception;
            Result.Companion r122 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L8:
            th = move-exception;
            Result.Companion r123 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L11
        }

        public final Object obtain(Application r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "app");
            Intrinsics.checkNotNullParameter(r101, "anyContext");
            Object r102 = fromActivityThread(r100);
            if (r102 != null) goto L8;
            Object r103 = viaNoCheck(r100);
            if (r103 == null) goto L7;
            return r103;
        L7:
            return fromContextImpl(r101);
        L8:
            return r102;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowReflectionCompat$ViewRootImplRef;", "", "<init>", "()V", "windowTokenMethod", "Ljava/lang/reflect/Method;", "getWindowTokenMethod", "()Ljava/lang/reflect/Method;", "windowTokenMethod$delegate", "Lkotlin/Lazy;", "getWindowToken", "Landroid/os/IBinder;", "parent", "Landroid/view/ViewParent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewRootImplRef {
        public static final ViewRootImplRef INSTANCE = null;
        private static final Lazy windowTokenMethod$delegate = null;

        private ViewRootImplRef() {
        }

        public static /* synthetic */ Method a() {
            return windowTokenMethod_delegate$lambda$3();
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        static {
            INSTANCE = new ViewRootImplRef();
            windowTokenMethod$delegate = LazyKt.lazy(new o());
        }

        private final Method getWindowTokenMethod() {
            return (Method) windowTokenMethod$delegate.getValue();
        }

        private static final Method windowTokenMethod_delegate$lambda$3() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
            Method r101 = INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ViewRootImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.ViewRootImpl").getDeclaredMethod("getWindowToken", new Class[0]);     // Catch: Throwable -> L4
            r101.setAccessible(true);     // Catch: Throwable -> L4
            Object r102 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L4
        L6:
            Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
            if (r103 == null) goto L10;
            FLogger.f375446a.w("ChatWindowReflectionCompat", "ViewRootImpl.getWindowToken is unavailable", r103);
        L10:
            if (Result.m9455isFailureimpl(r102) == false) goto L13;
            r102 = null;
        L13:
            return (Method) r102;
        L4:
            th = move-exception;
            Result.Companion r104 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L6
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowReflectionCompat$ViewRootImplRef_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

        public final IBinder getWindowToken(ViewParent r100) {
            Method r101 = getWindowTokenMethod();
            Object r102 = null;
            if (r101 != null) goto L6;
            return null;
        L6:
            if (r101.getDeclaringClass().isInstance(r100) == true) goto L25;
            return null;
        L25:
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
            Object r104 = r101.invoke(r100, new Object[0]);     // Catch: Throwable -> L14
            if ((r104 instanceof IBinder) == false) goto L11;
            IBinder r105 = (IBinder) r104;     // Catch: Throwable -> L14
        L12:
            Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L14
        L16:
            Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
            if (r107 == null) goto L20;
            FLogger.f375446a.w("ChatWindowReflectionCompat", "Cannot read parent Window token", r107);
        L20:
            if (Result.m9455isFailureimpl(r106) == true) goto L24;
            r102 = r106;
        L24:
            return (IBinder) r102;
        L11:
            r105 = null;
        L14:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L16
        }
    }

    static {
        INSTANCE = new ChatWindowReflectionCompat();
    }

    private ChatWindowReflectionCompat() {
    }
}
