package com.bytedance.ee.bear.drive.loader.download.platform.abs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/abs/AbsDriveExecutor;", "Lcom/bytedance/ee/bear/drive/loader/download/platform/abs/IApiExecutor;", "appId", "", "userComponentAbility", "Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;)V", "getUserComponentAbility", "()Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "setUserComponentAbility", "(Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;)V", "getAppId", "Companion", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDriveExecutor implements IApiExecutor {
    public static final Companion Companion = null;
    public static final String TAG = "AbsDriveExecutor";
    private String appId;
    private a95.a userComponentAbility;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/abs/AbsDriveExecutor$Companion;", "", "<init>", "()V", "TAG", "", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.abs.IApiExecutor
    public String getAppId() {
        return this.appId;
    }

    public final a95.a getUserComponentAbility() {
        return this.userComponentAbility;
    }

    public final void setUserComponentAbility(a95.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userComponentAbility = r2;
    }

    public AbsDriveExecutor(String r2, a95.a r3) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        this.appId = r2;
        this.userComponentAbility = r3;
    }
}
