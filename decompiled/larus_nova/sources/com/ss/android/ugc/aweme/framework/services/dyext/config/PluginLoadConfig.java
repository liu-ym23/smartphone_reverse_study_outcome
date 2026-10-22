package com.ss.android.ugc.aweme.framework.services.dyext.config;

import android.content.Context;
import com.bytedance.android.ec.core.event.a;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.dyext.CancellableJob;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bRN\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R7\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR7\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/config/PluginLoadConfig;", "", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "onLoadFinishCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", a.KEY_EXCEPTION, "", "getOnLoadFinishCallback", "()Lkotlin/jvm/functions/Function2;", "setOnLoadFinishCallback", "(Lkotlin/jvm/functions/Function2;)V", "onLoadStartCallback", "Lkotlin/Function1;", "Lcom/ss/android/ugc/aweme/framework/services/dyext/CancellableJob;", "job", "getOnLoadStartCallback", "()Lkotlin/jvm/functions/Function1;", "setOnLoadStartCallback", "(Lkotlin/jvm/functions/Function1;)V", "onLoadingCallback", "", "percent", "getOnLoadingCallback", "setOnLoadingCallback", "scene", "", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", DyPayConstant.KEY_START_TIME, "", "getStartTime", "()J", "setStartTime", "(J)V", "withDialog", "getWithDialog", "()Z", "setWithDialog", "(Z)V", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class PluginLoadConfig {
    private Context context;
    private Function2<? super Boolean, ? super Throwable, Unit> onLoadFinishCallback;
    private Function1<? super CancellableJob, Unit> onLoadStartCallback;
    private Function1<? super Integer, Unit> onLoadingCallback;
    private String scene;
    private long startTime;
    private boolean withDialog;

    public PluginLoadConfig() {
        this.scene = "";
        this.startTime = -1;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function2<Boolean, Throwable, Unit> getOnLoadFinishCallback() {
        return this.onLoadFinishCallback;
    }

    public final Function1<CancellableJob, Unit> getOnLoadStartCallback() {
        return this.onLoadStartCallback;
    }

    public final Function1<Integer, Unit> getOnLoadingCallback() {
        return this.onLoadingCallback;
    }

    public final String getScene() {
        return this.scene;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final boolean getWithDialog() {
        return this.withDialog;
    }

    public final void setContext(Context r100) {
        this.context = r100;
    }

    public final void setOnLoadFinishCallback(Function2<? super Boolean, ? super Throwable, Unit> r100) {
        this.onLoadFinishCallback = r100;
    }

    public final void setOnLoadStartCallback(Function1<? super CancellableJob, Unit> r100) {
        this.onLoadStartCallback = r100;
    }

    public final void setOnLoadingCallback(Function1<? super Integer, Unit> r100) {
        this.onLoadingCallback = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }

    public final void setWithDialog(boolean r100) {
        this.withDialog = r100;
    }
}
