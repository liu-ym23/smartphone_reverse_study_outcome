package com.ss.android.ugc.aweme.framework.services.dyext.api;

import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.framework.services.dyext.AsyncResult;
import com.ss.android.ugc.aweme.framework.services.dyext.config.PluginLoadConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JS\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00040\r¢\u0006\u0002\b\u000eH&J!\u0010\u000f\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/api/IAsyncService;", "", "asyncExecute", "Lcom/ss/android/ugc/aweme/framework/services/dyext/AsyncResult;", "R", ExifInterface.GPS_DIRECTION_TRUE, "clz", "Ljava/lang/Class;", "callHandler", "Landroid/os/Handler;", "pluginLoadConfig", "Lcom/ss/android/ugc/aweme/framework/services/dyext/config/PluginLoadConfig;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ensureReady", "(Ljava/lang/Class;)Ljava/lang/Object;", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public interface IAsyncService {
    <T, R> AsyncResult<R> asyncExecute(Class<T> r100, Handler r101, PluginLoadConfig r102, Function1<? super T, ? extends R> r103);

    <T> T ensureReady(Class<T> r100);
}
