package com.google.crypto.tink.shaded.protobuf;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.agconnect.config.impl.Utils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public final class GeneratedMessageLite$SerializedForm implements Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] asBytes;
    private final Class<?> messageClass;
    private final String messageClassName;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public Object readResolve() throws ObjectStreamException {
        Class<?> r100 = this.messageClass;     // Catch: InvalidProtocolBufferException -> L9 IllegalAccessException -> L11 SecurityException -> L13 ClassNotFoundException -> L15 NoSuchFieldException -> L23
        if (r100 != null) goto L7;
        r100 = INVOKESTATIC_com_google_crypto_tink_shaded_protobuf_GeneratedMessageLite$SerializedForm_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(this.messageClassName);     // Catch: InvalidProtocolBufferException -> L9 IllegalAccessException -> L11 SecurityException -> L13 ClassNotFoundException -> L15 NoSuchFieldException -> L23
    L7:
        Field r101 = r100.getDeclaredField(Utils.DEFAULT_NAME);     // Catch: InvalidProtocolBufferException -> L9 IllegalAccessException -> L11 SecurityException -> L13 ClassNotFoundException -> L15 NoSuchFieldException -> L23
        r101.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L9 IllegalAccessException -> L11 SecurityException -> L13 ClassNotFoundException -> L15 NoSuchFieldException -> L23
        ((g) r101.get(null)).newBuilderForType();     // Catch: InvalidProtocolBufferException -> L9 IllegalAccessException -> L11 SecurityException -> L13 ClassNotFoundException -> L15 NoSuchFieldException -> L23
        throw null;
    L9:
        e = move-exception;
        throw new RuntimeException("Unable to understand proto buffer", e);
    L15:
        e = move-exception;
        throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
    L11:
        e = move-exception;
        throw new RuntimeException("Unable to call parsePartialFrom", e);
    L23:
        Class<?> r102 = this.messageClass;     // Catch: InvalidProtocolBufferException -> L29 IllegalAccessException -> L31 SecurityException -> L33 NoSuchFieldException -> L35 ClassNotFoundException -> L37
        if (r102 != null) goto L27;
        r102 = INVOKESTATIC_com_google_crypto_tink_shaded_protobuf_GeneratedMessageLite$SerializedForm_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(this.messageClassName);     // Catch: InvalidProtocolBufferException -> L29 IllegalAccessException -> L31 SecurityException -> L33 NoSuchFieldException -> L35 ClassNotFoundException -> L37
    L27:
        Field r103 = r102.getDeclaredField("defaultInstance");     // Catch: InvalidProtocolBufferException -> L29 IllegalAccessException -> L31 SecurityException -> L33 NoSuchFieldException -> L35 ClassNotFoundException -> L37
        r103.setAccessible(true);     // Catch: InvalidProtocolBufferException -> L29 IllegalAccessException -> L31 SecurityException -> L33 NoSuchFieldException -> L35 ClassNotFoundException -> L37
        ((g) r103.get(null)).newBuilderForType();     // Catch: InvalidProtocolBufferException -> L29 IllegalAccessException -> L31 SecurityException -> L33 NoSuchFieldException -> L35 ClassNotFoundException -> L37
        throw null;
    L13:
        e = move-exception;
        throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e);
    L29:
        e = move-exception;
        throw new RuntimeException("Unable to understand proto buffer", e);
    L37:
        e = move-exception;
        throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
    L31:
        e = move-exception;
        throw new RuntimeException("Unable to call parsePartialFrom", e);
    L35:
        e = move-exception;
        throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e);
    L33:
        e = move-exception;
        throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e);
    }

    public GeneratedMessageLite$SerializedForm(g r100) {
        this.messageClass = r100.getClass();
        this.messageClassName = r100.getClass().getName();
        this.asBytes = r100.toByteArray();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_crypto_tink_shaded_protobuf_GeneratedMessageLite$SerializedForm_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static GeneratedMessageLite$SerializedForm of(g r100) {
        return new GeneratedMessageLite$SerializedForm(r100);
    }
}
