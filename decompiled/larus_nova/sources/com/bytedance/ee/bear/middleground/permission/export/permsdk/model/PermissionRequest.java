package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import du5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/PermissionRequest;", "", "baseEntity", "Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;", WikiFolderPushPlugin.OPT, "", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;Ljava/lang/String;)V", "getBaseEntity", "()Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;", "setBaseEntity", "(Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BaseEntity;)V", "getOperation", "()Ljava/lang/String;", "setOperation", "(Ljava/lang/String;)V", "sceneKey", "getSceneKey", "setSceneKey", "toString", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionRequest {
    private BaseEntity baseEntity;
    private String operation;
    private String sceneKey;

    public String toString() {
        return "PermissionRequest-token=" + b.g(this.baseEntity.getToken()) + " type=" + this.baseEntity.getType() + ",domain=" + this.baseEntity.getDomain() + ", op=" + this.operation + ' ';
    }

    public final BaseEntity getBaseEntity() {
        return this.baseEntity;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final String getSceneKey() {
        return this.sceneKey;
    }

    public final void setBaseEntity(BaseEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseEntity = r100;
    }

    public final void setOperation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.operation = r100;
    }

    public final void setSceneKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sceneKey = r100;
    }

    public PermissionRequest(BaseEntity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "baseEntity");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        this.baseEntity = r100;
        this.operation = r101;
        this.sceneKey = "default";
    }
}
