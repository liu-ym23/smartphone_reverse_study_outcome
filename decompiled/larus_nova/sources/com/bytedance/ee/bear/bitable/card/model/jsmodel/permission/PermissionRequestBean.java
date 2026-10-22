package com.bytedance.ee.bear.bitable.card.model.jsmodel.permission;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/PermissionRequestBean;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "entity", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/PermissionEntity;", "getEntity", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/PermissionEntity;", "setEntity", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/PermissionEntity;)V", WikiFolderPushPlugin.OPT, "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/OperationType;", "getOperation", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/OperationType;", "setOperation", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/OperationType;)V", "param", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/ParamBean;", "getParam", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/ParamBean;", "setParam", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/ParamBean;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionRequestBean implements NonProguard {
    private PermissionEntity entity;
    private OperationType operation;
    private ParamBean param;

    public PermissionRequestBean() {
    }

    @JSONField(serialzeFeatures = {SerializerFeature.WriteEnumUsingToString})
    public final PermissionEntity getEntity() {
        return this.entity;
    }

    @JSONField(serialzeFeatures = {SerializerFeature.WriteEnumUsingToString})
    public final OperationType getOperation() {
        return this.operation;
    }

    public final ParamBean getParam() {
        return this.param;
    }

    public final void setEntity(PermissionEntity r100) {
        this.entity = r100;
    }

    public final void setOperation(OperationType r100) {
        this.operation = r100;
    }

    public final void setParam(ParamBean r100) {
        this.param = r100;
    }
}
