package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JM\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0007*\u00020\b\"\u000e\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00070\n\"\u0014\b\u0002\u0010\u0006*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\rH\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/jedi/arch/MiddlewareBindingFactoryReflectImpl;", "Lcom/bytedance/jedi/arch/MiddlewareBindingFactory;", "()V", "isFirstTimeCreated", "", "create", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", "VM", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/jedi/arch/MiddlewareBinding;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/jedi/arch/MiddlewareBinding;", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MiddlewareBindingFactoryReflectImpl implements MiddlewareBindingFactory {
    private boolean isFirstTimeCreated;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public MiddlewareBindingFactoryReflectImpl() {
        this.isFirstTimeCreated = true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_jedi_arch_MiddlewareBindingFactoryReflectImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    @Override // com.bytedance.jedi.arch.MiddlewareBindingFactory
    public <S extends State, VM extends JediViewModel<S>, T extends MiddlewareBinding<S, VM>> T create(Class<VM> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        String r101 = r100.getName().concat("_MiddlewareBinding");
    L22:
        MiddlewareBindingKt.access$getCachedMiddlewareClasses$p().put(r101, null);
        this.isFirstTimeCreated = false;
        return null;
    L4:
        if (this.isFirstTimeCreated == false) goto L25;
        Object r102 = MiddlewareBindingKt.access$getCachedMiddlewareClasses$p().get(r101);     // Catch: Exception -> L22
        if (((Class) r102) == null) goto L9;
    L12:
        Class r103 = (Class) r102;     // Catch: Exception -> L22
        if (r103 != null) goto L15;
        r103 = INVOKESTATIC_com_bytedance_jedi_arch_MiddlewareBindingFactoryReflectImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101);     // Catch: Exception -> L22
        MiddlewareBindingKt.access$getCachedMiddlewareClasses$p().put(r101, r103);     // Catch: Exception -> L22
    L15:
        Object r104 = r103.newInstance();     // Catch: Exception -> L22
        if ((r104 instanceof MiddlewareBinding) == false) goto L18;
        MiddlewareBinding r105 = (MiddlewareBinding) r104;     // Catch: Exception -> L22
    L19:
        if (r105 == null) goto L26;
        this.isFirstTimeCreated = false;     // Catch: Exception -> L22
        return (T) r105;
    L26:
        return null;
    L18:
        r105 = null;
        goto L19
    L9:
        if (MiddlewareBindingKt.access$getCachedMiddlewareClasses$p().containsKey(r101) == false) goto L12;
        this.isFirstTimeCreated = false;     // Catch: Exception -> L22
        return null;
    L25:
        return null;
    }
}
