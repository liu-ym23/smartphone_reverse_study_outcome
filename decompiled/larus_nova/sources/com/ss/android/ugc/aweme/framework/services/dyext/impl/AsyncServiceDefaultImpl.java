package com.ss.android.ugc.aweme.framework.services.dyext.impl;

import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.dyext.AsyncResult;
import com.ss.android.ugc.aweme.framework.services.dyext.api.IAsyncService;
import com.ss.android.ugc.aweme.framework.services.dyext.config.PluginLoadConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JS\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00050\u000e¢\u0006\u0002\b\u000fH\u0016J!\u0010\u0010\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/impl/AsyncServiceDefaultImpl;", "Lcom/ss/android/ugc/aweme/framework/services/dyext/api/IAsyncService;", "()V", "asyncExecute", "Lcom/ss/android/ugc/aweme/framework/services/dyext/AsyncResult;", "R", ExifInterface.GPS_DIRECTION_TRUE, "clz", "Ljava/lang/Class;", "callHandler", "Landroid/os/Handler;", "pluginLoadConfig", "Lcom/ss/android/ugc/aweme/framework/services/dyext/config/PluginLoadConfig;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ensureReady", "(Ljava/lang/Class;)Ljava/lang/Object;", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class AsyncServiceDefaultImpl implements IAsyncService {
    public AsyncServiceDefaultImpl() {
    }

    @Override // com.ss.android.ugc.aweme.framework.services.dyext.api.IAsyncService
    public <T> T ensureReady(Class<T> r100) {
        return (T) ServiceManager.get().getService(r100);
    }

    @Override // com.ss.android.ugc.aweme.framework.services.dyext.api.IAsyncService
    public <T, R> AsyncResult<R> asyncExecute(Class<T> r100, Handler r101, PluginLoadConfig r102, Function1<? super T, ? extends R> r103) {
        return new ImmediateAsyncResult(r103.invoke((Object) ServiceManager.get().getService(r100)));
    }
}
