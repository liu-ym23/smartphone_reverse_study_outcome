package yh5;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenySource;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermissionV2;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements c, ph5.f {
    public final b a;

    public static final class a {
    }

    public static final class b implements ph5.e {
        public final /* synthetic */ l a;

        public b(l r1) {
            this.a = r1;
        }

        @Override // ph5.e
        public final void a(Context r2, PermissionResponse r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "response");
            this.a.getClass();
            tt5.a.h("UserPermissionCheckService-PermissionSDK", "handleUIAction " + r3.getAllow());
            int r4 = f.a;
            f.a.f(r3);
            if (r3.getAllow() == false) goto L6;
            return;
        L6:
            if (r3.getDenySource().getDenyType() != DenyType.AUDIT_CONTROL) goto L9;
            Toast.showFailureText(eu5.b.a, 2131887246);
            return;
        }
    }

    static {
    }

    @Override // yh5.c
    public final void a(PermissionRequest r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    @Override // ph5.f
    public final String getIdentify() {
        return "UserPermissionCheckService";
    }

    public final PermissionResponse c() {
        return new PermissionResponse(yh5.b.a(), true, this.a);
    }

    public l() {
        this.a = new b(this);
    }

    public static DenySource d(Integer r2) {
        if (r2 == null) goto L9;
        if (r2.intValue() != 202) goto L7;
        return new DenySource(DenyType.AUDIT_CONTROL, UiType.HIDDEN);
    L7:
        return new DenySource(DenyType.USER_PERMISSION, UiType.DISABLED);
    L9:
        return new DenySource(DenyType.USER_PERMISSION, UiType.DISABLED);
    }

    @Override // yh5.c
    public final PermissionResponse b(PermissionRequest r17, UserPermissionEntity r18) {
        Intrinsics.checkNotNullParameter(r17, "request");
        StringBuilder r2 = new StringBuilder("execute ");
        r2.append(r17);
        r2.append(", ");
        if (r18 == null) goto L5;
        Object r4 = r18.getUserPermission();
    L6:
        r2.append(r4);
        tt5.a.h("UserPermissionCheckService-PermissionSDK", r2.toString());
        HashMap<String, Integer> r3 = qh5.a.a;
        if (qh5.a.a(r17.getSceneKey(), r17.getOperation(), 16) == false) goto L9;
        int r5 = f.a;
        if (f.a.d(r17, r18) == false) goto L14;
        tt5.a.h("UserPermissionCheckService", "Escaped operation" + r17.getOperation());
        return c();
    L14:
        if (r18 == null) goto L16;
        Object r6 = r18.getUserPermission();
    L17:
        if (r6 != null) goto L20;
        PermissionResponse r7 = c();
        r7.setCacheReqRequest(r17);
        return r7;
    L20:
        Object r8 = r18.getUserPermission();
        if ((r8 instanceof IDocUserPermission) == false) goto L188;
        String r9 = r17.getOperation();
        Object r10 = r18.getUserPermission();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission");
        IDocUserPermission r11 = (IDocUserPermission) r10;
        switch(r9.hashCode()) {
            case -2139176152: goto L180;
            case -2108140338: goto L172;
            case -2084521848: goto L168;
            case -2020546396: goto L164;
            case -1920837826: goto L160;
            case -1653150172: goto L156;
            case -1280169617: goto L152;
            case -1246605097: goto L148;
            case -1116803173: goto L144;
            case -1100593978: goto L140;
            case -1035969260: goto L136;
            case -731856599: goto L132;
            case -591771213: goto L124;
            case -363473906: goto L120;
            case -94940873: goto L116;
            case -59583341: goto L112;
            case -42017632: goto L108;
            case 2123274: goto L104;
            case 2537853: goto L101;
            case 2634405: goto L97;
            case 129630631: goto L93;
            case 187734238: goto L89;
            case 598255768: goto L85;
            case 676113374: goto L81;
            case 678394240: goto L77;
            case 678905371: goto L73;
            case 992359671: goto L69;
            case 1337088923: goto L65;
            case 1357920891: goto L61;
            case 1418490941: goto L57;
            case 1532498568: goto L53;
            case 1609350180: goto L50;
            case 1668381247: goto L46;
            case 1688439000: goto L42;
            case 1864951829: goto L38;
            case 2059143092: goto L34;
            case 2073776377: goto L30;
            case 2074287508: goto L26;
            default: goto L183;
        };
    L183:
        tt5.a.d("UserPermissionCheckService", "getDocumentResponse false");
    L184:
        boolean r12 = false;
    L185:
        PermissionResponse r1 = e(r9, r11, r12);
        r1.setCacheReqRequest(r17);
        return r1;
    L26:
        if (r9.equals("INVITE_SINGLE_PAGE_VIEW") == false) goto L183;
        r12 = r11.canInviteSinglePageView();
        goto L185
    L30:
        if (r9.equals("INVITE_SINGLE_PAGE_EDIT") == false) goto L183;
        r12 = r11.canInviteSinglePageEdit();
        goto L185
    L34:
        if (r9.equals("EXPORT") == false) goto L183;
        r12 = r11.canExport();
        goto L185
    L38:
        if (r9.equals("MOVE_THIS_NODE") == false) goto L183;
        r12 = r11.canMoveThisNode();
        goto L185
    L42:
        if (r9.equals("CREATE_COPY") == false) goto L183;
        r12 = r11.canCreateCopy();
        goto L185
    L46:
        if (r9.equals("COMMENT") == false) goto L183;
        r12 = r11.canComment();
        goto L185
    L50:
        if (r9.equals("ATTACHMENT_DOWNLOAD") == false) goto L183;
    L170:
        r12 = r11.canDownload();
        goto L185
    L53:
        if (r9.equals("APPLY_EMBED") == false) goto L183;
        r12 = r11.canApplyEmbed();
        goto L185
    L57:
        if (r9.equals("MANAGE_CONTAINER_PERMISSION_META") == false) goto L183;
        r12 = r11.canManageContainerPermissionMeta();
        goto L185
    L61:
        if (r9.equals("SINGLE_PAGE_FULL_ACCESS") == false) goto L183;
        r12 = r11.isSinglePageFullAccess();
        goto L185
    L65:
        if (r9.equals("MANAGE_PERMISSION_META") == false) goto L183;
        r12 = r11.canManagePermissionMeta();
        goto L185
    L69:
        if (r9.equals("DELETE_ENTITY") == false) goto L183;
        r12 = r11.canOperateEntity();
        goto L185
    L73:
        if (r9.equals("INVITE_VIEW") == false) goto L183;
        r12 = r11.canInviteView();
        goto L185
    L77:
        if (r9.equals("INVITE_EDIT") == false) goto L183;
        r12 = r11.canInviteEdit();
        goto L185
    L81:
        if (r9.equals("MANAGE_VERSION") == false) goto L183;
        r12 = r11.canRenameAndCreateEdition();
        goto L185
    L85:
        if (r9.equals("MANAGE_SINGLE_PERMISSION_META") == false) goto L183;
        r12 = r11.canManageSinglePagePermissionMeta();
        goto L185
    L89:
        if (r9.equals("INVITE_FULL_ACCESS") == false) goto L183;
        r12 = r11.canInviteFullAccess();
        goto L185
    L93:
        if (r9.equals("COPY_BY_LEADER") == false) goto L183;
        r12 = r11.isCopyAuthByLeader();
        goto L185
    L97:
        if (r9.equals("VIEW") == false) goto L183;
        r12 = r11.canRead();
        goto L185
    L101:
        if (r9.equals("SAVE") == true) goto L170;
    L104:
        if (r9.equals("EDIT") == false) goto L183;
        r12 = r11.canEdit();
        goto L185
    L108:
        if (r9.equals("MANAGE_COLLABORATOR") == false) goto L183;
        r12 = r11.canManageCollaborator();
        goto L185
    L112:
        if (r9.equals("INVITE_SINGLE_FULL_ACCESS") == false) goto L183;
        r12 = r11.canInviteSinglePageFullAccess();
        goto L185
    L116:
        if (r9.equals("PERCEIVE_CONTROL") == false) goto L183;
        r12 = r11.matchPerceiveControl();
        goto L185
    L120:
        if (r9.equals("VIEW_PREVIEW") == false) goto L183;
        r12 = r11.canPreview();
        goto L185
    L124:
        if (r9.equals("VIEW_DOC_HISTORY") == false) goto L183;
        if (r11.isFullAccess() == false) goto L129;
    L178:
        r12 = true;
        goto L185
    L129:
        if (r11.isSinglePageFullAccess() == false) goto L184;
    L132:
        if (r9.equals("SECRET_MODIFY") == false) goto L183;
        r12 = r11.canModifySecretLevel();
        goto L185
    L136:
        if (r9.equals("FULL_ACCESS") == false) goto L183;
        r12 = r11.isFullAccess();
        goto L185
    L140:
        if (r9.equals("MOVE_TO_HERE") == false) goto L183;
        r12 = r11.canMoveToHere();
        goto L185
    L144:
        if (r9.equals("CONTENT_COPY") == false) goto L183;
        r12 = r11.canCopy();
        goto L185
    L148:
        if (r9.equals("VIEW_BY_LEADER") == false) goto L183;
        r12 = r11.isViewAuthByLeader();
        goto L185
    L152:
        if (r9.equals("MOVE_SUB_NODE") == false) goto L183;
        r12 = r11.canMoveSubNode();
        goto L185
    L156:
        if (r9.equals("DELETE_VERSION") == false) goto L183;
        r12 = r11.canOperateEntity();
        goto L185
    L160:
        if (r9.equals("MANAGE_CONTAINER_COLLABORATOR") == false) goto L183;
        r12 = r11.canManageContainerCollaborator();
        goto L185
    L164:
        if (r9.equals("CREATE_SUB_NODE") == false) goto L183;
        r12 = r11.canCreateSubNode();
        goto L185
    L168:
        if (r9.equals("DOWNLOAD") == true) goto L170;
    L172:
        if (r9.equals("INVITE_MOST_FULL_ACCESS") == false) goto L183;
        if (r11.canInviteFullAccess() == true) goto L178;
        if (r11.canInviteSinglePageFullAccess() == false) goto L184;
    L180:
        if (r9.equals("SECRET_LEVEL_VISIBLE") == false) goto L183;
        r12 = r11.canVisitSecretLevel();
        goto L185
    L188:
        if ((r8 instanceof ShareFolderUserPermission) == false) goto L244;
        String r13 = r17.getOperation();
        Object r14 = r18.getUserPermission();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission");
        ShareFolderUserPermission r15 = (ShareFolderUserPermission) r14;
        switch(r13.hashCode()) {
            case -2020546396: goto L237;
            case -1280169617: goto L233;
            case -1100593978: goto L229;
            case -42017632: goto L225;
            case 2123274: goto L221;
            case 2634405: goto L217;
            case 187734238: goto L213;
            case 678394240: goto L209;
            case 678905371: goto L205;
            case 1337088923: goto L197;
            case 1864951829: goto L193;
            default: goto L241;
        };
    L241:
        tt5.a.d("UserPermissionCheckService", "getFolderResponse false");
        boolean r16 = false;
    L242:
        PermissionResponse r19 = e(r13, r15, r16);
        r19.setCacheReqRequest(r17);
        return r19;
    L193:
        if (r13.equals("MOVE_THIS_NODE") == false) goto L241;
        boolean r20 = r15.canBeMoved();
    L240:
        r16 = r20;
        goto L242
    L197:
        if (r13.equals("MANAGE_PERMISSION_META") == false) goto L241;
        HashMap<String, Serializable> r21 = r18.getOptionalUserPermMap();
        if (r21 == null) goto L202;
        Serializable r22 = r21.get(UserPermissionEntity.IS_OWNER);
    L203:
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type kotlin.Boolean");
        r20 = r15.canManagePermissionMeta(((Boolean) r22).booleanValue());
        goto L240
    L202:
        r22 = null;
        goto L203
    L205:
        if (r13.equals("INVITE_VIEW") == false) goto L241;
        r20 = r15.canInviteView();
        goto L240
    L209:
        if (r13.equals("INVITE_EDIT") == false) goto L241;
        r20 = r15.canInviteEdit();
        goto L240
    L213:
        if (r13.equals("INVITE_FULL_ACCESS") == false) goto L241;
        r20 = r15.canInviteFullAccess();
        goto L240
    L217:
        if (r13.equals("VIEW") == false) goto L241;
        r20 = r15.canView();
        goto L240
    L221:
        if (r13.equals("EDIT") == false) goto L241;
        r20 = r15.canEdit();
        goto L240
    L225:
        if (r13.equals("MANAGE_COLLABORATOR") == false) goto L241;
        r20 = r15.canManagerCollaborator();
        goto L240
    L229:
        if (r13.equals("MOVE_TO_HERE") == false) goto L241;
        r20 = r15.canMoveToHere();
        goto L240
    L233:
        if (r13.equals("MOVE_SUB_NODE") == false) goto L241;
        r20 = r15.canMoveSubNode();
        goto L240
    L237:
        if (r13.equals("CREATE_SUB_NODE") == false) goto L241;
        r20 = r15.canCreateSubNode();
        goto L240
    L244:
        PermissionResponse r23 = c();
        r23.setCacheReqRequest(r17);
        return r23;
    L16:
        r6 = null;
        goto L17
    L9:
        return c();
    L5:
        r4 = null;
        goto L6
    }

    public final PermissionResponse e(String r2, Object r3, boolean r4) {
        if (r4 == false) goto L5;
        DenySource r5 = yh5.b.a();
    L42:
        return new PermissionResponse(r5, r4, this.a);
    L5:
        if (com.bytedance.ee.bear.middleground.permission.b.e() == true) goto L7;
    L40:
        r5 = new DenySource(DenyType.USER_PERMISSION, UiType.DISABLED);
        goto L42
    L7:
        if ((r3 instanceof DocUserPermissionV2) == false) goto L40;
        HashMap<String, Integer> r6 = ((DocUserPermissionV2) r3).getControlPointMap();
        switch(r2.hashCode()) {
            case -2084521848: goto L36;
            case -1116803173: goto L32;
            case 2123274: goto L28;
            case 2634405: goto L24;
            case 1668381247: goto L20;
            case 1688439000: goto L16;
            case 2059143092: goto L12;
            default: goto L39;
        };
    L39:
        r5 = new DenySource(DenyType.USER_PERMISSION, UiType.DISABLED);
        goto L42
    L12:
        if (r2.equals("EXPORT") == false) goto L39;
        r5 = d(r6.get("export"));
        goto L42
    L16:
        if (r2.equals("CREATE_COPY") == false) goto L39;
        r5 = d(r6.get("create_copy"));
        goto L42
    L20:
        if (r2.equals("COMMENT") == false) goto L39;
        r5 = d(r6.get("comment"));
        goto L42
    L24:
        if (r2.equals("VIEW") == false) goto L39;
        r5 = d(r6.get("view"));
        goto L42
    L28:
        if (r2.equals("EDIT") == false) goto L39;
        r5 = d(r6.get("edit"));
        goto L42
    L32:
        if (r2.equals("CONTENT_COPY") == false) goto L39;
        r5 = d(r6.get("content_copy"));
        goto L42
    L36:
        if (r2.equals("DOWNLOAD") == false) goto L39;
        r5 = d(r6.get(OperationName.OPERATION_DOWNLOAD));
        goto L42
    }
}
