package com.ss.android.lark.chameleonv2.container.webcontainer.config;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0011j\b\u0012\u0004\u0012\u00020\u0005`\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0011j\b\u0012\u0004\u0012\u00020\u0005`\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R.\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0011j\b\u0012\u0004\u0012\u00020\u0005`\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R \u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/config/ChameleonInterceptorConfig;", "Ljava/io/Serializable;", "<init>", "()V", "bizName", "", "getBizName", "()Ljava/lang/String;", "setBizName", "(Ljava/lang/String;)V", "fullMatchForPath", "", "getFullMatchForPath", "()Z", "setFullMatchForPath", "(Z)V", "hosts", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getHosts", "()Ljava/util/ArrayList;", "setHosts", "(Ljava/util/ArrayList;)V", "paths", "getPaths", "setPaths", "schemes", "getSchemes", "setSchemes", "openConfig", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/config/ChameleonOpenConfig;", "getOpenConfig", "()Lcom/ss/android/lark/chameleonv2/container/webcontainer/config/ChameleonOpenConfig;", "setOpenConfig", "(Lcom/ss/android/lark/chameleonv2/container/webcontainer/config/ChameleonOpenConfig;)V", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonInterceptorConfig implements Serializable {

    @SerializedName("bizName")
    private String bizName;

    @SerializedName("fullMatchForPath")
    private boolean fullMatchForPath;

    @SerializedName("hosts")
    private ArrayList<String> hosts;

    @SerializedName("openConfig")
    private ChameleonOpenConfig openConfig;

    @SerializedName("paths")
    private ArrayList<String> paths;

    @SerializedName("schemes")
    private ArrayList<String> schemes;

    public ChameleonInterceptorConfig() {
        this.bizName = "";
        this.fullMatchForPath = true;
        this.hosts = new ArrayList();
        this.paths = new ArrayList();
        this.schemes = new ArrayList();
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final boolean getFullMatchForPath() {
        return this.fullMatchForPath;
    }

    public final ArrayList<String> getHosts() {
        return this.hosts;
    }

    public final ChameleonOpenConfig getOpenConfig() {
        return this.openConfig;
    }

    public final ArrayList<String> getPaths() {
        return this.paths;
    }

    public final ArrayList<String> getSchemes() {
        return this.schemes;
    }

    public final void setBizName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bizName = r100;
    }

    public final void setFullMatchForPath(boolean r100) {
        this.fullMatchForPath = r100;
    }

    public final void setHosts(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hosts = r100;
    }

    public final void setOpenConfig(ChameleonOpenConfig r100) {
        this.openConfig = r100;
    }

    public final void setPaths(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.paths = r100;
    }

    public final void setSchemes(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.schemes = r100;
    }
}
