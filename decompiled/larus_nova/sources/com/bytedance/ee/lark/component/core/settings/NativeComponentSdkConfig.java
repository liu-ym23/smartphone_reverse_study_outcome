package com.bytedance.ee.lark.component.core.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@AppConfig(key = "native_component_sdk_config")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/lark/component/core/settings/NativeComponentSdkConfig;", "Ljava/io/Serializable;", "<init>", "()V", "nativeViewLayoutRefactor", "", "getNativeViewLayoutRefactor", "()Z", "setNativeViewLayoutRefactor", "(Z)V", "platformViewPluginReuse", "getPlatformViewPluginReuse", "setPlatformViewPluginReuse", "callComponentOnRemove", "getCallComponentOnRemove", "setCallComponentOnRemove", "legacySdkInitCheck", "getLegacySdkInitCheck", "setLegacySdkInitCheck", "Companion", "native-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeComponentSdkConfig implements Serializable {
    public static final a Companion = null;

    @SerializedName("call_component_on_remove")
    private boolean callComponentOnRemove;

    @SerializedName("legacy_sdk_init_check")
    private boolean legacySdkInitCheck;

    @SerializedName("native_view_layout_refactor")
    private boolean nativeViewLayoutRefactor;

    @SerializedName("platform_view_plugin_reuse")
    private boolean platformViewPluginReuse;

    public static final class a {
        public static boolean a() {
            NativeComponentSdkConfig r100 = (NativeComponentSdkConfig) SettingManager.getInstance().get(NativeComponentSdkConfig.class);     // Catch: Exception -> L8
            if (r100 == null) goto L10;
            if (r100.getCallComponentOnRemove() != true) goto L10;
            return true;
        L10:
            return false;
        L8:
            e = move-exception;
            Log.e("NativeComponentSdkConfig", "get config exception: " + e.getMessage());
            goto L10
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public NativeComponentSdkConfig() {
    }

    public static final boolean isCallComponentOnRemove() {
        Companion.getClass();
        return a.a();
    }

    public static final boolean isLegacySdkInitCheck() {
        Companion.getClass();
        NativeComponentSdkConfig r100 = (NativeComponentSdkConfig) SettingManager.getInstance().get(NativeComponentSdkConfig.class);     // Catch: Exception -> L9
        if (r100 == null) goto L11;
        if (r100.getLegacySdkInitCheck() != true) goto L11;
        return true;
    L11:
        return false;
    L9:
        e = move-exception;
        Log.e("NativeComponentSdkConfig", "get config exception: " + e.getMessage());
        goto L11
    }

    public static final boolean isNativeViewLayoutRefactor() {
        Companion.getClass();
        NativeComponentSdkConfig r100 = (NativeComponentSdkConfig) SettingManager.getInstance().get(NativeComponentSdkConfig.class);     // Catch: Exception -> L9
        if (r100 == null) goto L11;
        if (r100.getNativeViewLayoutRefactor() != true) goto L11;
        return true;
    L11:
        return false;
    L9:
        e = move-exception;
        Log.e("NativeComponentSdkConfig", "get config exception: " + e.getMessage());
        goto L11
    }

    public static final boolean isPlatformViewPluginReuse() {
        Companion.getClass();
        NativeComponentSdkConfig r100 = (NativeComponentSdkConfig) SettingManager.getInstance().get(NativeComponentSdkConfig.class);     // Catch: Exception -> L9
        if (r100 == null) goto L11;
        if (r100.getPlatformViewPluginReuse() != true) goto L11;
        return true;
    L11:
        return false;
    L9:
        e = move-exception;
        Log.e("NativeComponentSdkConfig", "get config exception: " + e.getMessage());
        goto L11
    }

    public final boolean getCallComponentOnRemove() {
        return this.callComponentOnRemove;
    }

    public final boolean getLegacySdkInitCheck() {
        return this.legacySdkInitCheck;
    }

    public final boolean getNativeViewLayoutRefactor() {
        return this.nativeViewLayoutRefactor;
    }

    public final boolean getPlatformViewPluginReuse() {
        return this.platformViewPluginReuse;
    }

    public final void setCallComponentOnRemove(boolean r100) {
        this.callComponentOnRemove = r100;
    }

    public final void setLegacySdkInitCheck(boolean r100) {
        this.legacySdkInitCheck = r100;
    }

    public final void setNativeViewLayoutRefactor(boolean r100) {
        this.nativeViewLayoutRefactor = r100;
    }

    public final void setPlatformViewPluginReuse(boolean r100) {
        this.platformViewPluginReuse = r100;
    }
}
