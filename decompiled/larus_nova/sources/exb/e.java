package exb;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.google.gson.annotations.SerializedName;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import otb.o;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0005R \u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/officewebview/platform/PlatformViewStateModel;", "", "viewId", "", "<init>", "(Ljava/lang/String;)V", "getViewId", "()Ljava/lang/String;", SVGRenderEngine.RECT, "Lcom/ss/android/lark/officesdk/di/core/deps/webview/ViewRect;", "getRect", "()Lcom/ss/android/lark/officesdk/di/core/deps/webview/ViewRect;", "factoryReg", "", "getFactoryReg", "()Z", "setFactoryReg", "(Z)V", "pluginAdd", "getPluginAdd", "setPluginAdd", "tag", "getTag", "setTag", "extra", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("extra")
    private Object extra;

    @SerializedName("factory_reg")
    private boolean factoryReg;

    @SerializedName("plugin_add")
    private boolean pluginAdd;

    @SerializedName(SVGRenderEngine.RECT)
    private final o rect;

    @SerializedName("tag")
    private String tag;

    @SerializedName(BitableResourceData.KEY_VIEW_ID)
    private final String viewId;

    public final Object a() {
        return this.extra;
    }

    public final boolean b() {
        return this.factoryReg;
    }

    public final boolean c() {
        return this.pluginAdd;
    }

    public final o d() {
        return this.rect;
    }

    public final String e() {
        return this.tag;
    }

    public final String f() {
        return this.viewId;
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        this.viewId = r100;
        this.rect = new o();
    }

    public final void g(boolean r100) {
        this.factoryReg = r100;
    }

    public final void h(boolean r100) {
        this.pluginAdd = r100;
    }
}
