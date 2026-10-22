package hy;

import com.alipay.sdk.m.u.i;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserLinkmicContent;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {
    public static final AnchorLinkUser a(List<AnchorLinkUser> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getOrganizer");
        Iterator<AnchorLinkUser> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        AnchorLinkUser r102 = r101.next();
        if (r102.getAnchorAuthRole() != ListUserLinkmicContent.AnchorAuthRole.AnchorAuthRoleOrganizer.ordinal()) goto L4;
        return r102;
    L8:
        return null;
    }

    public static final String b(List<AnchorLinkUser> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toAnchorLinkString");
        StringBuilder r101 = new StringBuilder("LinkAnchors{size=");
        r101.append(r100.size());
        r101.append(",");
        Iterator<AnchorLinkUser> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L29;
        AnchorLinkUser r103 = r102.next();
        r101.append("[");
        if (r103.getUser() == null) goto L19;
        r101.append("id=");
        IBaseUser r104 = r103.getUser();
        Long r105 = null;
        if (r104 == null) goto L10;
        String r106 = r104.getIdString();
    L11:
        r101.append(r106);
        r101.append(",name=");
        IBaseUser r107 = r103.getUser();
        if (r107 == null) goto L14;
        String r108 = r107.getNickName();
    L15:
        r101.append(r108);
        r101.append(",room=");
        IBaseUser r109 = r103.getUser();
        if (r109 == null) goto L18;
        r105 = Long.valueOf(r109.getLiveRoomId());
    L18:
        r101.append(r105);
        r101.append(",");
        goto L19
    L14:
        r108 = null;
        goto L15
    L10:
        r106 = null;
    L19:
        r101.append("link_id=");
        r101.append(r103.getLinkMicIdStr());
        r101.append(",link_status=");
        r101.append(r103.getStatus());
        r101.append(",");
        if (r103.getPkRole() == 0) goto L23;
        r101.append("pk_role=");
        r101.append(r103.getPkRole());
        r101.append(",");
    L23:
        if (r103.getAnchorLinkMicIdInfo() == null) goto L26;
        r101.append("linkMicIdInfo=");
        r101.append(r103.getAnchorLinkMicIdInfo());
        r101.append(",");
    L26:
        if (r103.getAnchorAuthRole() == 0) goto L28;
        r101.append("anchor_auth_role=");
        r101.append(r103.getAnchorAuthRole());
    L28:
        r101.append("]");
        goto L4
    L29:
        r101.append(i.f25855d);
        return r101.toString();
    }
}
