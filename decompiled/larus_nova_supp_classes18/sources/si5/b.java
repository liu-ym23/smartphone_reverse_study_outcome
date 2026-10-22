package si5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    Flowable a(String r1);

    Flowable<Result<String>> b(String r1, int r2, String r3);

    Flowable<ShareFolderUserPermission> c(String r1, FolderVersion r2, boolean r3);

    Flowable<InviteResult> d(ArrayList<UserInfo> r1, boolean r2, String r3, String r4, String r5);

    Flowable<ShareFolderPermission> e(String r1, FolderVersion r2, boolean r3);
}
