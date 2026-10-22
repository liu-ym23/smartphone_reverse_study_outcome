package com.squareup.wire;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class WireFiledWorkaround {
    public WireFiledWorkaround() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_squareup_wire_WireFiledWorkaround_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> r100) {
        Class r101 = getBuilderType(r100);
        LinkedHashMap r102 = new LinkedHashMap();
        Field[] r103 = r100.getDeclaredFields();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L14;
        Field r106 = r103[r105];
        WireField r107 = (WireField) r106.getAnnotation(WireField.class);     // Catch: Throwable -> L7
    L8:
        if (r107 != null) goto L10;
        r107 = toWireFiled((WireFieldNoEnum) r106.getAnnotation(WireFieldNoEnum.class));
    L10:
        if (r107 == null) goto L12;
        r102.put(Integer.valueOf(r107.tag()), new FieldBinding(r107, r106, r101));
    L12:
        r105 = r105 + 1;
    L7:
        r107 = null;
        goto L8
    L14:
        return new RuntimeMessageAdapter(r100, r101, Collections.unmodifiableMap(r102));
    }

    private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> r100) {
        return INVOKESTATIC_com_squareup_wire_WireFiledWorkaround_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100.getName().concat("$Builder"));
    L6:
        throw new IllegalArgumentException("No builder class found for message type ".concat(r100.getName()));
    }

    private static WireField toWireFiled(final WireFieldNoEnum r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass1(r100);
    }
}
