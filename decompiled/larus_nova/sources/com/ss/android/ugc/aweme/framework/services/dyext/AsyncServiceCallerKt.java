package com.ss.android.ugc.aweme.framework.services.dyext;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"asyncService", "Lcom/ss/android/ugc/aweme/framework/services/dyext/AsyncService;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/KClass;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "asyncSpi", "dy-ext-spi_release"}, k = 2, mv = {1, 1, 15})
public final class AsyncServiceCallerKt {
    public static final <T> AsyncService<T> asyncService(KClass<T> r100) {
        return AsyncService.Companion.from(JvmClassMappingKt.getJavaClass(r100));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "asyncService()", imports = {}))
    public static final <T> AsyncService<T> asyncSpi(KClass<T> r100) {
        return AsyncService.Companion.from(JvmClassMappingKt.getJavaClass(r100));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "asyncService()", imports = {}))
    public static final <T> AsyncService<T> asyncService(KClass<T> r100, Context r101) {
        return AsyncService.Companion.from(JvmClassMappingKt.getJavaClass(r100));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "asyncService()", imports = {}))
    public static final <T> AsyncService<T> asyncSpi(KClass<T> r100, Context r101) {
        return AsyncService.Companion.from(JvmClassMappingKt.getJavaClass(r100));
    }
}
