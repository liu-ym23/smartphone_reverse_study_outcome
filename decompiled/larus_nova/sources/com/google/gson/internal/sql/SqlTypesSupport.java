package com.google.gson.internal.sql;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class SqlTypesSupport {
    public static final DefaultDateTypeAdapter.DateType<? extends Date> DATE_DATE_TYPE = null;
    public static final TypeAdapterFactory DATE_FACTORY = null;
    public static final boolean SUPPORTS_SQL_TYPES = false;
    public static final DefaultDateTypeAdapter.DateType<? extends Date> TIMESTAMP_DATE_TYPE = null;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY = null;
    public static final TypeAdapterFactory TIME_FACTORY = null;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        INVOKESTATIC_com_google_gson_internal_sql_SqlTypesSupport_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("java.sql.Date");     // Catch: ClassNotFoundException -> L4
        boolean r100 = true;
    L5:
        SUPPORTS_SQL_TYPES = r100;
        if (r100 == false) goto L8;
        final Class<java.sql.Date> r101 = java.sql.Date.class;
        DATE_DATE_TYPE = new AnonymousClass1(r101);
        final Class<Timestamp> r102 = Timestamp.class;
        TIMESTAMP_DATE_TYPE = new AnonymousClass2(r102);
        DATE_FACTORY = SqlDateTypeAdapter.FACTORY;
        TIME_FACTORY = SqlTimeTypeAdapter.FACTORY;
        TIMESTAMP_FACTORY = SqlTimestampTypeAdapter.FACTORY;
        return;
    L8:
        DATE_DATE_TYPE = null;
        TIMESTAMP_DATE_TYPE = null;
        DATE_FACTORY = null;
        TIME_FACTORY = null;
        TIMESTAMP_FACTORY = null;
        return;
    L4:
        r100 = false;
        goto L5
    }

    private SqlTypesSupport() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_google_gson_internal_sql_SqlTypesSupport_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
