package com.bytedance.ee.bear.middleground.permission.permsdkimpl.model;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B1\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permsdkimpl/model/DlpParamEntity;", "", "shouldCheck", "", "<init>", "(Z)V", "token", "", "type", "", WikiFolderPushPlugin.OPT, "creatorTenantId", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "operate", "getOperate", "setOperate", "getCreatorTenantId", "setCreatorTenantId", "getShouldCheck", "()Z", "setShouldCheck", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DlpParamEntity {
    private String creatorTenantId;
    private String operate;
    private boolean shouldCheck;
    private String token;
    private int type;

    public final String getCreatorTenantId() {
        return this.creatorTenantId;
    }

    public final String getOperate() {
        return this.operate;
    }

    public final boolean getShouldCheck() {
        return this.shouldCheck;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getType() {
        return this.type;
    }

    public DlpParamEntity(boolean r100) {
        this.type = -1;
        this.creatorTenantId = "";
        this.shouldCheck = r100;
    }

    public final void setCreatorTenantId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.creatorTenantId = r100;
    }

    public final void setOperate(String r100) {
        this.operate = r100;
    }

    public final void setShouldCheck(boolean r100) {
        this.shouldCheck = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public DlpParamEntity(String r100, Integer r101, String r102, String r103) {
        int r104 = -1;
        this.type = -1;
        this.creatorTenantId = "";
        this.shouldCheck = true;
        this.token = r100;
        if (r101 == null) goto L5;
        r104 = r101.intValue();
    L5:
        this.type = r104;
        this.operate = r102;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.creatorTenantId = r103;
    }
}
