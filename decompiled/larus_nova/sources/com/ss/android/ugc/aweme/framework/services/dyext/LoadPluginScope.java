package com.ss.android.ugc.aweme.framework.services.dyext;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006¢\u0006\u0002\u0010\u0007J#\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/LoadPluginScope;", "", "()V", "getService", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "klass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class LoadPluginScope {
    public LoadPluginScope() {
    }

    public final <T> T getService(KClass<T> r100) {
        return (T) ServiceManager.get().getService(JvmClassMappingKt.getJavaClass(r100));
    }

    public final <T> T getService(Class<T> r100) {
        return (T) ServiceManager.get().getService(r100);
    }
}
