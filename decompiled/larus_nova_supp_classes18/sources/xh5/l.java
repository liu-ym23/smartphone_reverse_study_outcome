package xh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.PermissionAction;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements NetService.c<ShareFolderUserPermission> {
    public final FolderVersion a;
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public final Result parse(String r26) {
        if (r26 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L33;
        JSONObject r5 = new JSONObject(r26).optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Throwable -> L29
        if (r5 != null) goto L15;
        r5 = new JSONObject();     // Catch: Throwable -> L29
    L15:
        if (this.a.isShareFolderV1() == true) goto L34;
        r5.optBoolean("is_owner");     // Catch: Throwable -> L29
        JSONObject r6 = r5.optJSONObject("actions");     // Catch: Throwable -> L29
        if (r6 != null) goto L20;
        r6 = new JSONObject();     // Catch: Throwable -> L29
    L20:
        PermissionAction r7 = new PermissionAction(r6.optInt("view"), r6.optInt("edit"), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32764, null);     // Catch: Throwable -> L29
        r7.setManage_collaborator(r6.optInt("manage_collaborator"));     // Catch: Throwable -> L29
        r7.setManage_meta(r6.optInt("manage_meta"));     // Catch: Throwable -> L29
        r7.setCreate_sub_node(r6.optInt("create_sub_node"));     // Catch: Throwable -> L29
        r7.setDownload(r6.optInt(OperationName.OPERATION_DOWNLOAD));     // Catch: Throwable -> L29
        r7.setCollect(r6.optInt("collect"));     // Catch: Throwable -> L29
        r7.setOperate_from_dusbin(r6.optInt("operate_from_dusbin"));     // Catch: Throwable -> L29
        r7.setOperate_entity(r6.optInt("operate_entity"));     // Catch: Throwable -> L29
        r7.setInvite_full_access(r6.optInt("invite_full_access"));     // Catch: Throwable -> L29
        r7.setInvite_can_edit(r6.optInt("invite_can_edit"));     // Catch: Throwable -> L29
        r7.setInvite_can_view(r6.optInt("invite_can_view"));     // Catch: Throwable -> L29
        r7.setBe_moved(r6.optInt("be_moved"));     // Catch: Throwable -> L29
        r7.setMove_from(r6.optInt("move_from"));     // Catch: Throwable -> L29
        r7.setMove_to(r6.optInt("move_to"));     // Catch: Throwable -> L29
        if (r7.getManage_meta() != 1) goto L24;
        int r11 = 3;
    L35:
        return new ShareFolderUserPermission(r11, r7, this.a, this.b, r5.toString());
    L24:
        if (r7.getEdit() != 1) goto L26;
        r11 = 2;
        goto L35
    L26:
        r11 = 1;
        goto L35
    L34:
        return new ShareFolderUserPermission(r5.optInt("perm", 1), null, this.a, this.b, r5.toString(), 2, null);
    L29:
        th = move-exception;
        tt5.a.e("FolderUserPermissionParser", "parse()...json = " + r26, th, false);
        return new ShareFolderUserPermission(0, null, null, false, null, 31, null);
    L33:
        return new ShareFolderUserPermission(0, null, null, false, null, 31, null);
    L5:
        if (r26.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public l(FolderVersion r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "version");
        this.a = r2;
        this.b = r3;
    }
}
