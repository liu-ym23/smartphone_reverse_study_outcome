package com.bytedance.ee.bear.document.alert;

import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/document/alert/FailType;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()I", "setType", "(I)V", "errorCode", "getErrorCode", "setErrorCode", DrivePreviewOpenItem.EXTRA_MOUNT_POINT, "", "getMount_point", "()Ljava/lang/String;", "setMount_point", "(Ljava/lang/String;)V", "mount_token", "getMount_token", "setMount_token", "scene", "getScene", "setScene", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FailType implements NonProguard {
    public static final int CREATE_COPY_FAIL = 2;
    public static final a Companion = null;
    public static final int DEPARTMENT_QUOTA_EXCEED = 12;
    public static final int OTHERS_TENANT_QUOTA_EXCEED = 13;
    public static final int TENANT_QUOTA_EXCEED = 11;
    public static final int TRANSLATE_FAIL = 1;
    public static final int UPLOAD_FAIL = 0;
    public static final int USER_FULL_QUOTA = 6;
    private int errorCode;
    private String mount_point;
    private String mount_token;
    private String scene;
    private int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FailType() {
        this.type = -1;
        this.errorCode = -1;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getMount_point() {
        return this.mount_point;
    }

    public final String getMount_token() {
        return this.mount_token;
    }

    public final String getScene() {
        return this.scene;
    }

    public final int getType() {
        return this.type;
    }

    public final void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public final void setMount_point(String r1) {
        this.mount_point = r1;
    }

    public final void setMount_token(String r1) {
        this.mount_token = r1;
    }

    public final void setScene(String r1) {
        this.scene = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }
}
