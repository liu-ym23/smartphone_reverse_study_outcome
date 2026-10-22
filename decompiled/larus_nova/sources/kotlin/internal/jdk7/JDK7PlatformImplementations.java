package kotlin.internal.jdk7;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.heytap.mcssdk.constant.b;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", a.KEY_EXCEPTION, "getSuppressed", "", "sdkIsNullOrAtLeast", "", "version", "", "ReflectSdkVersion", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class JDK7PlatformImplementations extends PlatformImplementations {

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion;", "", "()V", b.C, "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE = null;
        public static final Integer sdkVersion = null;

        private ReflectSdkVersion() {
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        static {
            INSTANCE = new ReflectSdkVersion();
            Integer r100 = null;
            Object r101 = INVOKESTATIC_kotlin_internal_jdk7_JDK7PlatformImplementations$ReflectSdkVersion_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.Build$VERSION").getField("SDK_INT").get(null);     // Catch: Throwable -> L7
            if ((r101 instanceof Integer) == false) goto L8;
            Integer r102 = (Integer) r101;     // Catch: Throwable -> L7
        L9:
            if (r102 != null) goto L11;
        L16:
            sdkVersion = r100;
            return;
        L11:
            if (r102.intValue() <= 0) goto L13;
            boolean r103 = true;
        L14:
            if (r103 == false) goto L16;
            r100 = r102;
            goto L16
        L13:
            r103 = false;
        L8:
            r102 = null;
            goto L9
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_kotlin_internal_jdk7_JDK7PlatformImplementations$ReflectSdkVersion_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
    }

    public JDK7PlatformImplementations() {
    }

    private final boolean sdkIsNullOrAtLeast(int r100) {
        Integer r101 = ReflectSdkVersion.sdkVersion;
        if (r101 != null) goto L5;
    L8:
        return true;
    L5:
        if (r101.intValue() >= r100) goto L8;
        return false;
    }

    @Override // kotlin.internal.PlatformImplementations
    public List<Throwable> getSuppressed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, a.KEY_EXCEPTION);
        if (sdkIsNullOrAtLeast(19) == false) goto L6;
        return ArraysKt.asList(r100.getSuppressed());
    L6:
        return super.getSuppressed(r100);
    }

    @Override // kotlin.internal.PlatformImplementations
    public void addSuppressed(Throwable r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "cause");
        Intrinsics.checkNotNullParameter(r101, a.KEY_EXCEPTION);
        if (sdkIsNullOrAtLeast(19) == false) goto L5;
        r100.addSuppressed(r101);
        return;
    L5:
        super.addSuppressed(r100, r101);
    }
}
