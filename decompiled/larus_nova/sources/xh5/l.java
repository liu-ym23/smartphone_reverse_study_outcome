package xh5;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.PermissionAction;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements NetService.c<ShareFolderUserPermission> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FolderVersion f563885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f563886b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r210) {
        if (r210 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L33;
        JSONObject r101 = new JSONObject(r210).optJSONObject("data");     // Catch: Throwable -> L29
        if (r101 != null) goto L15;
        r101 = new JSONObject();     // Catch: Throwable -> L29
    L15:
        if (this.f563885a.isShareFolderV1() == true) goto L34;
        r101.optBoolean("is_owner");     // Catch: Throwable -> L29
        JSONObject r102 = r101.optJSONObject(SlcCommonAction.KEY_ACTIONS);     // Catch: Throwable -> L29
        if (r102 != null) goto L20;
        r102 = new JSONObject();     // Catch: Throwable -> L29
    L20:
        PermissionAction r103 = new PermissionAction(r102.optInt("view"), r102.optInt("edit"), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32764, null);     // Catch: Throwable -> L29
        r103.setManage_collaborator(r102.optInt("manage_collaborator"));     // Catch: Throwable -> L29
        r103.setManage_meta(r102.optInt("manage_meta"));     // Catch: Throwable -> L29
        r103.setCreate_sub_node(r102.optInt("create_sub_node"));     // Catch: Throwable -> L29
        r103.setDownload(r102.optInt("download"));     // Catch: Throwable -> L29
        r103.setCollect(r102.optInt(ShareChannel.COLLECT));     // Catch: Throwable -> L29
        r103.setOperate_from_dusbin(r102.optInt("operate_from_dusbin"));     // Catch: Throwable -> L29
        r103.setOperate_entity(r102.optInt("operate_entity"));     // Catch: Throwable -> L29
        r103.setInvite_full_access(r102.optInt("invite_full_access"));     // Catch: Throwable -> L29
        r103.setInvite_can_edit(r102.optInt("invite_can_edit"));     // Catch: Throwable -> L29
        r103.setInvite_can_view(r102.optInt("invite_can_view"));     // Catch: Throwable -> L29
        r103.setBe_moved(r102.optInt("be_moved"));     // Catch: Throwable -> L29
        r103.setMove_from(r102.optInt("move_from"));     // Catch: Throwable -> L29
        r103.setMove_to(r102.optInt("move_to"));     // Catch: Throwable -> L29
        if (r103.getManage_meta() != 1) goto L24;
        int r110 = 3;
    L35:
        return new ShareFolderUserPermission(r110, r103, this.f563885a, this.f563886b, r101.toString());
    L24:
        if (r103.getEdit() != 1) goto L26;
        r110 = 2;
        goto L35
    L26:
        r110 = 1;
        goto L35
    L34:
        return new ShareFolderUserPermission(r101.optInt("perm", 1), null, this.f563885a, this.f563886b, r101.toString(), 2, null);
    L29:
        th = move-exception;
        tt5.a.e("FolderUserPermissionParser", "parse()...json = " + r210, th, false);
        return new ShareFolderUserPermission(0, null, null, false, null, 31, null);
    L33:
        return new ShareFolderUserPermission(0, null, null, false, null, 31, null);
    L5:
        if (r210.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    public l(FolderVersion r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "version");
        this.f563885a = r100;
        this.f563886b = r101;
    }
}
