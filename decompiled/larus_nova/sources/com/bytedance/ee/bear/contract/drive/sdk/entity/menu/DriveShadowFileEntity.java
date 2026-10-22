package com.bytedance.ee.bear.contract.drive.sdk.entity.menu;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DriveShadowFileEntity;", "Ljava/io/Serializable;", "<init>", "()V", "builder", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DriveShadowFileEntity$Builder;", "(Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DriveShadowFileEntity$Builder;)V", "shadowFileEnable", "", "getShadowFileEnable", "()Z", "setShadowFileEnable", "(Z)V", "shadowFileUUID", "", "getShadowFileUUID", "()Ljava/lang/String;", "setShadowFileUUID", "(Ljava/lang/String;)V", "Companion", "Builder", "contentmanager-drive-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveShadowFileEntity implements Serializable {
    public static final b Companion = null;
    public static final String SHADOW_FILE_DATA = "extra_shadow_file_data";
    private boolean shadowFileEnable;
    private String shadowFileUUID;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f217017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f217018b;

        public a() {
            this.f217018b = "";
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public DriveShadowFileEntity() {
        this.shadowFileEnable = false;
        this.shadowFileUUID = "";
    }

    public final boolean getShadowFileEnable() {
        return this.shadowFileEnable;
    }

    public final String getShadowFileUUID() {
        return this.shadowFileUUID;
    }

    public DriveShadowFileEntity(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.shadowFileEnable = r100.f217017a;
        this.shadowFileUUID = r100.f217018b;
    }

    public final void setShadowFileEnable(boolean r100) {
        this.shadowFileEnable = r100;
    }

    public final void setShadowFileUUID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shadowFileUUID = r100;
    }
}
