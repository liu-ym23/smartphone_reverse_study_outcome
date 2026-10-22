package com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permsdkimpl/offline/OfflinePermissionModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", WikiFolderPushPlugin.DATA, "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/permsdkimpl/offline/OfflinePermissionModel$PermissionData;", "getData", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setData", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "PermissionData", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflinePermissionModel implements NonProguard {
    private CopyOnWriteArrayList<PermissionData> data;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permsdkimpl/offline/OfflinePermissionModel$PermissionData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", ResourceData.KEY_TOKEN, "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "permission", "getPermission", "setPermission", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PermissionData implements NonProguard {
        private String permission;
        private String token;

        public PermissionData() {
            this.token = "";
            this.permission = "";
        }

        public final String getPermission() {
            return this.permission;
        }

        public final String getToken() {
            return this.token;
        }

        public final void setPermission(String r1) {
            this.permission = r1;
        }

        public final void setToken(String r1) {
            this.token = r1;
        }
    }

    public OfflinePermissionModel() {
        this.data = new CopyOnWriteArrayList();
    }

    public final CopyOnWriteArrayList<PermissionData> getData() {
        return this.data;
    }

    public final void setData(CopyOnWriteArrayList<PermissionData> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.data = r2;
    }
}
