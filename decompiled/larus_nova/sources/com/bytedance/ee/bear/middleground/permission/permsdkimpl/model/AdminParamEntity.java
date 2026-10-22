package com.bytedance.ee.bear.middleground.permission.permsdkimpl.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permsdkimpl/model/AdminParamEntity;", "", "shouldCheck", "", "<init>", "(Z)V", "token", "", "type", "Lcom/ss/android/lark/docs/icon/util/DocumentType;", "permissionType", "", "(Ljava/lang/String;Lcom/ss/android/lark/docs/icon/util/DocumentType;I)V", "getType", "()Lcom/ss/android/lark/docs/icon/util/DocumentType;", "setType", "(Lcom/ss/android/lark/docs/icon/util/DocumentType;)V", "getPermissionType", "()I", "setPermissionType", "(I)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getShouldCheck", "()Z", "setShouldCheck", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdminParamEntity {
    private int permissionType;
    private boolean shouldCheck;
    private String token;
    private e type;

    public final int getPermissionType() {
        return this.permissionType;
    }

    public final boolean getShouldCheck() {
        return this.shouldCheck;
    }

    public final String getToken() {
        return this.token;
    }

    public final e getType() {
        return this.type;
    }

    public AdminParamEntity(boolean r100) {
        this.type = e.f541294e;
        this.token = "";
        this.shouldCheck = r100;
    }

    public final void setPermissionType(int r100) {
        this.permissionType = r100;
    }

    public final void setShouldCheck(boolean r100) {
        this.shouldCheck = r100;
    }

    public final void setToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.token = r100;
    }

    public final void setType(e r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public AdminParamEntity(String r100, e r101, int r102) {
        e r103 = e.f541294e;
        this.type = r103;
        this.token = "";
        this.shouldCheck = true;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.token = r100;
        this.permissionType = r102;
        if (r101 != null) goto L8;
        r101 = r103;
    L8:
        this.type = r101;
    }
}
