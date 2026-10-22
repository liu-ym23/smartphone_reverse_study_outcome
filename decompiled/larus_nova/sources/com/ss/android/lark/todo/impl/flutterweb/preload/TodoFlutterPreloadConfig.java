package com.ss.android.lark.todo.impl.flutterweb.preload;

import com.google.gson.annotations.SerializedName;
import com.lynx.canvas.KryptonCamera;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@AppConfig(key = "todo_flutter_preload_config")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\fH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/preload/TodoFlutterPreloadConfig;", "", "<init>", "()V", "enablePreload", "", "getEnablePreload", "()Z", "setEnablePreload", "(Z)V", "low", "", "", "getLow", "()Ljava/util/List;", "setLow", "(Ljava/util/List;)V", KryptonCamera.Config.RESOLUTION_MEDIUM, "getMedium", "setMedium", "high", "getHigh", "setHigh", "toString", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoFlutterPreloadConfig {
    public static final a Companion = null;
    private static final String TAG = "TodoFlutterPreloadConfig";
    private static TodoFlutterPreloadConfig inst;

    @SerializedName("enable_preload")
    private boolean enablePreload;

    @SerializedName("high")
    private List<String> high;

    @SerializedName("low")
    private List<String> low;

    @SerializedName(KryptonCamera.Config.RESOLUTION_MEDIUM)
    private List<String> medium;

    public static final class a {
        public a() {
        }

        public static boolean a(String r100) {
            Log.i("TodoWeb", "call isPreloadEnabled " + r100);
            if (TodoFlutterPreloadConfig.access$getInst$cp().getEnablePreload() == true) goto L6;
            Log.i("TodoWeb", "preload(" + r100 + ") is not enabled");
            return false;
        L6:
            DevicePerfUtils.DevicePerfLevel r101 = DevicePerfUtils.d();
            if (r101.ordinal() < DevicePerfUtils.DevicePerfLevel.LOW.ordinal()) goto L13;
            if (TodoFlutterPreloadConfig.access$getInst$cp().getLow().contains(r100) == true) goto L22;
            Log.i("TodoWeb", "low device preload(" + r100 + ") is not enabled");
            return false;
        L22:
            return true;
        L13:
            if (r101.ordinal() < DevicePerfUtils.DevicePerfLevel.MIDDLE.ordinal()) goto L19;
            if (TodoFlutterPreloadConfig.access$getInst$cp().getMedium().contains(r100) == true) goto L24;
            Log.i("TodoWeb", "medium device preload(" + r100 + ") is not enabled");
            return false;
        L24:
            return true;
        L19:
            if (TodoFlutterPreloadConfig.access$getInst$cp().getHigh().contains(r100) == true) goto L25;
            Log.i("TodoWeb", "high device preload(" + r100 + ") is not enabled");
            return false;
        L25:
            return true;
        }
    }

    static {
        Companion = new a();
        inst = new TodoFlutterPreloadConfig();
    }

    public String toString() {
        return "TodoFlutterPreloadConfig(enablePreload=" + this.enablePreload + ", low=" + this.low + ", medium=" + this.medium + ", high=" + this.high + ')';
    }

    public TodoFlutterPreloadConfig() {
        this.low = CollectionsKt.emptyList();
        this.medium = CollectionsKt.emptyList();
        this.high = CollectionsKt.emptyList();
    }

    public static final /* synthetic */ TodoFlutterPreloadConfig access$getInst$cp() {
        return inst;
    }

    public final boolean getEnablePreload() {
        return this.enablePreload;
    }

    public final List<String> getHigh() {
        return this.high;
    }

    public final List<String> getLow() {
        return this.low;
    }

    public final List<String> getMedium() {
        return this.medium;
    }

    public static final /* synthetic */ void access$setInst$cp(TodoFlutterPreloadConfig r100) {
        inst = r100;
    }

    public final void setEnablePreload(boolean r100) {
        this.enablePreload = r100;
    }

    public final void setHigh(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.high = r100;
    }

    public final void setLow(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.low = r100;
    }

    public final void setMedium(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.medium = r100;
    }
}
