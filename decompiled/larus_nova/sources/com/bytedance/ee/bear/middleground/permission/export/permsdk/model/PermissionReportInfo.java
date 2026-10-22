package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionReportInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "domain", "", "getDomain", "()Ljava/lang/String;", "setDomain", "(Ljava/lang/String;)V", "blockType", "getBlockType", "setBlockType", WikiFolderPushPlugin.OPT, "getOperation", "setOperation", "type", "getType", "setType", "allow", "", "getAllow", "()Z", "setAllow", "(Z)V", "hasNet", "getHasNet", "setHasNet", "useCache", "getUseCache", "setUseCache", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionReportInfo implements NonProguard {
    private boolean allow;
    private String blockType;
    private String domain;
    private boolean hasNet;
    private String operation;
    private String type;
    private boolean useCache;

    public PermissionReportInfo() {
        this.domain = BizDomain.FileBizDomainCCM.getBiz();
        this.blockType = "DEFAULT_NONE";
        this.operation = "";
        this.type = "unknown";
        this.allow = true;
        this.hasNet = true;
    }

    public final boolean getAllow() {
        return this.allow;
    }

    public final String getBlockType() {
        return this.blockType;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final boolean getHasNet() {
        return this.hasNet;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getUseCache() {
        return this.useCache;
    }

    public final void setAllow(boolean r100) {
        this.allow = r100;
    }

    public final void setBlockType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.blockType = r100;
    }

    public final void setDomain(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.domain = r100;
    }

    public final void setHasNet(boolean r100) {
        this.hasNet = r100;
    }

    public final void setOperation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.operation = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public final void setUseCache(boolean r100) {
        this.useCache = r100;
    }
}
