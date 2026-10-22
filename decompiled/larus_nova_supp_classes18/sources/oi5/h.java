package oi5;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final FolderPermSetInfo b(ShareFolderInfo r16, ShareParams r17) {
        Intrinsics.checkNotNullParameter(r16, "shareInfo");
        Intrinsics.checkNotNullParameter(r17, "params");
        return new FolderPermSetInfo(r17.getType(), r17.getUrl(), r17.getToken(), r17.getDocName(), r17.getOwnerUid(), r17.getOwnerName(), r16.d, r16.e, r16.g, r16.i, r17.getSpaceId(), r17.getFolderVersion(), r17.isShareRoot());
    }

    @JvmStatic
    public static final DocPermSetInfo c(ShareDocInfo r18, boolean r19, ShareParams r20) {
        Intrinsics.checkNotNullParameter(r18, "shareInfo");
        Intrinsics.checkNotNullParameter(r20, "params");
        DocVersion r2 = r18.d;
        if (r20.getType() != 44) goto L6;
        r2 = new DocVersion(5);
        r20.setWiki(false);
    L6:
        if (r20.getType() != 28) goto L8;
        r2 = new DocVersion(0);
    L8:
        String r7 = r18.b;
        int r8 = r18.getType();
        String r9 = r18.c;
        boolean r10 = r20.isWiki();
        DocMetaInfo r11 = r18.e;
        DocPermission r12 = new DocPermission(r18.f, 2);
        return new DocPermSetInfo(r7, r8, r9, r10, r11, r12, r2, r20.getPasswordSharingEnable(), r20.getTransferOwnerEnable(), r19, DocUserPermission.USER_PERM_FULL_ACCESS);
    }

    public static void a(HashMap r5, String r6, String r7, ShareParams r8) {
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r8 == null) goto L6;
        String r1 = r8.getToken();
        if (r1 == null) goto L6;
    L7:
        r5.put("file_id", du5.b.g(r1));
        if (r8 == null) goto L10;
        int r2 = r8.getType();
    L11:
        r5.put("file_type", sbb.e.f(r2));
        boolean r3 = false;
        if (r8 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L19;
        String r9 = ThumbGlideUrl.SOURCE_VC;
    L20:
        r5.put("app_form", r9);
        if (r8 == null) goto L24;
        String r10 = r8.getSubType();
        if (r10 == null) goto L24;
    L25:
        r5.put("sub_file_type", r10);
        if (r8 == null) goto L29;
        String r11 = r8.getModule();
        if (r11 == null) goto L29;
    L30:
        r5.put("module", r11);
        if (r8 == null) goto L34;
        String r12 = r8.getSubModule();
        if (r12 == null) goto L34;
    L35:
        r5.put("sub_module", r12);
        if (r6 != null) goto L38;
        r6 = "";
    L38:
        r5.put("user_permission", r6);
        if (r7 != null) goto L41;
        r7 = "";
    L41:
        r5.put("file_permission", r7);
        if (r8 != null) goto L44;
    L46:
        if (r3 == false) goto L48;
        String r13 = "true";
    L49:
        r5.put("is_owner", r13);
        return;
    L48:
        r13 = "false";
        goto L49
    L44:
        if (r8.isOwner() != true) goto L46;
        r3 = true;
    L34:
        r12 = "";
    L29:
        r11 = "";
    L24:
        r10 = "";
        goto L25
    L19:
        r9 = "none";
        goto L20
    L14:
        if (r8.isAtVC() != true) goto L16;
        r4 = true;
        goto L17
    L10:
        r2 = -1;
    L6:
        r1 = "";
        goto L7
    }
}
