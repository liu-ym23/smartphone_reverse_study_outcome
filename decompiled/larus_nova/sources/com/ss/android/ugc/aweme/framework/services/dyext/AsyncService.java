package com.ss.android.ugc.aweme.framework.services.dyext;

import android.content.Context;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.event.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.dyext.api.IAsyncService;
import com.ss.android.ugc.aweme.framework.services.dyext.config.PluginLoadConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 **\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001*B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J-\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0001\u0010\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\b\rH\u0007J5\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\b\rH\u0007J\r\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J-\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0001\u0010\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\b\rH\u0016J7\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0001\u0010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\b\rH\u0016JH\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000028\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0017H\u0016J1\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u001d0\fH\u0016J1\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u001d0\fH\u0016JH\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u000028\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0017H\u0007J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010%\u001a\u00020&H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020)H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010'\u001a\u00020\u000fH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/AsyncService;", ExifInterface.GPS_DIRECTION_TRUE, "", "clz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "pluginLoadConfig", "Lcom/ss/android/ugc/aweme/framework/services/dyext/config/PluginLoadConfig;", NotificationCompat.CATEGORY_CALL, "Lcom/ss/android/ugc/aweme/framework/services/dyext/AsyncResult;", "R", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "loadPlugin", "", "ensureReady", "()Ljava/lang/Object;", "execute", "callHandler", "Landroid/os/Handler;", "onLoadFinish", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "", a.KEY_EXCEPTION, "", "onLoadStart", "Lcom/ss/android/ugc/aweme/framework/services/dyext/CancellableJob;", "job", "onLoading", "", "percent", "onLoadingFinish", "scene", "", "withDialog", "activity", "Landroid/content/Context;", "Companion", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public class AsyncService<T> {
    public static final Companion Companion = null;
    private final Class<T> clz;
    private final PluginLoadConfig pluginLoadConfig;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/AsyncService$Companion;", "", "()V", "from", "Lcom/ss/android/ugc/aweme/framework/services/dyext/AsyncService;", ExifInterface.GPS_DIRECTION_TRUE, "clz", "Ljava/lang/Class;", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final <T> AsyncService<T> from(Class<T> r100) {
            return new AsyncService(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final <T> AsyncService<T> from(Class<T> r100) {
        return Companion.from(r100);
    }

    public T ensureReady() {
        return (T) ((IAsyncService) ServiceManager.get().getService(IAsyncService.class)).ensureReady(this.clz);
    }

    public AsyncService(Class<T> r100) {
        this.clz = r100;
        this.pluginLoadConfig = new PluginLoadConfig();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "execute(block)", imports = {}))
    public final <R> AsyncResult<R> call(Function1<? super T, ? extends R> r100) {
        return execute(r100);
    }

    public <R> AsyncResult<R> execute(Function1<? super T, ? extends R> r100) {
        return execute(null, r100);
    }

    public AsyncService<T> onLoadFinish(Function2<? super Boolean, ? super Throwable, Unit> r100) {
        this.pluginLoadConfig.setOnLoadFinishCallback(r100);
        return this;
    }

    public AsyncService<T> onLoadStart(Function1<? super CancellableJob, Unit> r100) {
        this.pluginLoadConfig.setOnLoadStartCallback(r100);
        return this;
    }

    public AsyncService<T> onLoading(Function1<? super Integer, Unit> r100) {
        this.pluginLoadConfig.setOnLoadingCallback(r100);
        return this;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "onLoadFinish(callback)", imports = {}))
    public final AsyncService<T> onLoadingFinish(Function2<? super Boolean, ? super Throwable, Unit> r100) {
        return onLoadFinish(r100);
    }

    public AsyncService<T> scene(String r100) {
        this.pluginLoadConfig.setScene(r100);
        return this;
    }

    public AsyncService<T> withDialog(Context r100) {
        this.pluginLoadConfig.setWithDialog(true);
        this.pluginLoadConfig.setContext(r100);
        return this;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "withDialog(context)", imports = {}))
    public final AsyncService<T> withDialog(boolean r100) {
        this.pluginLoadConfig.setWithDialog(r100);
        return this;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "该方法已废弃", replaceWith = @ReplaceWith(expression = "execute(block)", imports = {}))
    public final <R> AsyncResult<R> call(boolean r100, Function1<? super T, ? extends R> r101) {
        return execute(r101);
    }

    public <R> AsyncResult<R> execute(Handler r100, Function1<? super T, ? extends R> r101) {
        IAsyncService r102 = (IAsyncService) ServiceManager.get().getService(IAsyncService.class);
        this.pluginLoadConfig.setStartTime(System.currentTimeMillis());
        return r102.asyncExecute(this.clz, r100, this.pluginLoadConfig, r101);
    }
}
