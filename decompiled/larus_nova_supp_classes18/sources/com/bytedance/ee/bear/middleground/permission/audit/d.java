package com.bytedance.ee.bear.middleground.permission.audit;

import android.app.Application;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.WikiNavInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.DriveData;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.pb.security_event.DocSecLabel;
import com.ss.android.lark.pb.security_event.Document;
import com.ss.android.lark.pb.security_event.EntityType;
import com.ss.android.lark.pb.security_event.ModuleType;
import com.ss.android.lark.pb.security_event.RenderItem;
import com.ss.android.lark.pb.security_event.User;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static e g() {
        return (e) org.koin.java.a.c(e.class, null, null, 6);
    L5:
        e = move-exception;
        tt5.a.d("AuditApiImplV2", "doAudit fail. auditManager not found. err: " + e);
        return null;
    }

    public static boolean h() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = LarkContext.getApplication();
        r0.getClass();
        UserSession r2 = ((com.ss.android.lark.passportc.convention.a) k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b();
        return ((dn4.a) k.b(((v) k.a(r1, v.class)).c(r2), dn4.a.class)).a().isCurrentEnable("ccm.mobile.audit_report_disable_space_drive_download");
    }

    public static EntityType a(Integer r3) {
        EntityType r0 = EntityType.EntityDocID;
        int r1 = r0.getValue();
        if (r3 != null) goto L6;
    L8:
        EntityType r2 = EntityType.EntitySheetID;
        int r4 = r2.getValue();
        if (r3 != null) goto L12;
    L14:
        EntityType r5 = EntityType.EntityFileID;
        int r6 = r5.getValue();
        if (r3 != null) goto L18;
    L20:
        EntityType r7 = EntityType.EntityFolderID;
        int r8 = r7.getValue();
        if (r3 != null) goto L24;
    L26:
        EntityType r9 = EntityType.EntityMindNoteID;
        int r10 = r9.getValue();
        if (r3 != null) goto L30;
    L32:
        EntityType r11 = EntityType.EntityBitableID;
        int r12 = r11.getValue();
        if (r3 != null) goto L36;
    L38:
        EntityType r13 = EntityType.EntityDocxID;
        int r14 = r13.getValue();
        if (r3 != null) goto L42;
    L44:
        EntityType r15 = EntityType.EntityWikiToken;
        int r16 = r15.getValue();
        if (r3 == null) goto L51;
        if (r3.intValue() != r16) goto L51;
        return r15;
    L51:
        return EntityType.EntityTypeUnknown;
    L42:
        if (r3.intValue() != r14) goto L44;
        return r13;
    L36:
        if (r3.intValue() != r12) goto L38;
        return r11;
    L30:
        if (r3.intValue() != r10) goto L32;
        return r9;
    L24:
        if (r3.intValue() != r8) goto L26;
        return r7;
    L18:
        if (r3.intValue() != r6) goto L20;
        return r5;
    L12:
        if (r3.intValue() != r4) goto L14;
        return r2;
    L6:
        if (r3.intValue() != r1) goto L8;
        return r0;
    }

    public static ModuleType c(sbb.e r1) {
        Intrinsics.checkNotNullParameter(r1, "docType");
        if (Intrinsics.areEqual(r1, sbb.e.g) == false) goto L6;
        return ModuleType.ModuleDocs;
    L6:
        if (Intrinsics.areEqual(r1, sbb.e.h) == false) goto L9;
        return ModuleType.ModuleSheets;
    L9:
        if (Intrinsics.areEqual(r1, sbb.e.l) == false) goto L12;
        return ModuleType.ModuleFiles;
    L12:
        if (Intrinsics.areEqual(r1, sbb.e.f) == false) goto L15;
        return ModuleType.ModuleFolders;
    L15:
        if (Intrinsics.areEqual(r1, sbb.e.k) == false) goto L18;
        return ModuleType.ModuleMindNote;
    L18:
        if (Intrinsics.areEqual(r1, sbb.e.i) == false) goto L21;
        return ModuleType.ModuleBitable;
    L21:
        if (Intrinsics.areEqual(r1, sbb.e.o) == false) goto L24;
        return ModuleType.ModuleDocx;
    L24:
        return ModuleType.ModuleUnknown;
    }

    public static EntityType d(sbb.e r1) {
        Intrinsics.checkNotNullParameter(r1, "docType");
        if (Intrinsics.areEqual(r1, sbb.e.g) == false) goto L6;
        return EntityType.EntityDocID;
    L6:
        if (Intrinsics.areEqual(r1, sbb.e.h) == false) goto L9;
        return EntityType.EntitySheetID;
    L9:
        if (Intrinsics.areEqual(r1, sbb.e.l) == false) goto L12;
        return EntityType.EntityFileID;
    L12:
        if (Intrinsics.areEqual(r1, sbb.e.f) == false) goto L15;
        return EntityType.EntityFolderID;
    L15:
        if (Intrinsics.areEqual(r1, sbb.e.k) == false) goto L18;
        return EntityType.EntityMindNoteID;
    L18:
        if (Intrinsics.areEqual(r1, sbb.e.i) == false) goto L21;
        return EntityType.EntityBitableID;
    L21:
        if (Intrinsics.areEqual(r1, sbb.e.o) == false) goto L24;
        return EntityType.EntityDocxID;
    L24:
        if (Intrinsics.areEqual(r1, sbb.e.y) == false) goto L27;
        return EntityType.EntityDocxID;
    L27:
        if (Intrinsics.areEqual(r1, sbb.e.n) == false) goto L30;
        return EntityType.EntityWikiToken;
    L30:
        return EntityType.EntityTypeUnknown;
    }

    public static String f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "appFileId");
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L13;
        JSONObject r1 = new JSONObject();
        r1.put("app_id", r2);
        r1.put("app_file_id", r3);
        String r4 = r1.toString();
        Intrinsics.checkNotNull(r4);
        return r4;
    L13:
        return r3;
    L5:
        if (r2.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static void i(List r1, Boolean r2) {
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L5;
        ArrayList r0 = (ArrayList) r1;
        r0.add(new RenderItem.Builder().Key("CCM_op_status").Value("failure").build());
        ArrayList r3 = (ArrayList) r1;
        r3.add(new RenderItem.Builder().Key("ccm_err_msg").Value("Suite_Admin_DrawerValspacedownloadattachment_Kccmerrmsgvsecurityerr").build());
        return;
    L5:
        ArrayList r4 = (ArrayList) r1;
        r4.add(new RenderItem.Builder().Key("CCM_op_status").Value("success").build());
    }

    public static Document b(HostDocumentInfo r8, dj5.a r9, DriveData r10) {
        boolean r0 = false;
        if (r8 == null) goto L12;
        String r2 = r8.getObjToken();
        if (r2 == null) goto L12;
        if (r2.length() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 != true) goto L12;
        boolean r4 = true;
    L13:
        String r5 = "";
        String r6 = null;
        if (r4 == false) goto L23;
        if (r8 == null) goto L18;
        String r7 = r8.getDocToken();
        if (r7 == null) goto L18;
    L27:
        if (r10 == null) goto L30;
        sbb.e r11 = r10.getType();
        if (r11 == null) goto L30;
    L36:
        Intrinsics.checkNotNull(r11);
        EntityType r12 = d(r11);
        if (r8 == null) goto L39;
        Integer r13 = r8.getEntityType();
    L40:
        if (r13 != null) goto L42;
    L44:
        Document.Builder r14 = new Document.Builder().ID(r7).Type(r12);
        if (r8 == null) goto L50;
        DocMetaInfo r15 = r8.getDocMetaInfo();
        if (r15 == null) goto L50;
        String r16 = r15.getTitle();
        if (r16 == null) goto L50;
    L59:
        Document.Builder r17 = r14.Title(r16);
        if (r8 == null) goto L65;
        DocMetaInfo r18 = r8.getDocMetaInfo();
        if (r18 == null) goto L65;
        String r19 = r18.getCreatorTenantId();
        if (r19 == null) goto L65;
    L68:
        Document.Builder r110 = r17.TenantID(r19);
        DocSecLabel.Builder r20 = new DocSecLabel.Builder();
        if (r8 == null) goto L75;
        DocMetaInfo r21 = r8.getDocMetaInfo();
        if (r21 == null) goto L75;
        SecretLevel r22 = r21.getSecretLevel();
        if (r22 == null) goto L75;
        String r23 = r22.getId();
    L76:
        DocSecLabel.Builder r24 = r20.LabelID(r23);
        if (r8 == null) goto L83;
        DocMetaInfo r25 = r8.getDocMetaInfo();
        if (r25 == null) goto L83;
        SecretLevel r26 = r25.getSecretLevel();
        if (r26 == null) goto L83;
        String r27 = r26.getName();
    L84:
        Document.Builder r111 = r110.DocSecLabel(r24.LabelNameCN(r27).build());
        if (r8 == null) goto L96;
        DocMetaInfo r28 = r8.getDocMetaInfo();
        if (r28 == null) goto L96;
        String r29 = r28.getOwnerUid();
        if (r29 == null) goto L96;
        if (r29.length() <= 0) goto L93;
        boolean r30 = true;
    L94:
        if (r30 != true) goto L96;
        r0 = true;
        goto L96
    L93:
        r30 = false;
    L96:
        if (r0 == false) goto L101;
        if (r8 == null) goto L103;
        DocMetaInfo r1 = r8.getDocMetaInfo();
        if (r1 == null) goto L103;
        String r31 = r1.getOwnerUid();
    L104:
        Document.Builder r112 = r111.Owner(new User.Builder().UserID(r31).build());
        if (r9 == null) goto L110;
        String r32 = r9.b;
        if (r32 == null) goto L110;
        r5 = r32;
    L110:
        Document.Builder r113 = r112.WikiID(r5);
        if (r9 == null) goto L116;
        String r33 = r9.a;
        if (r33 == null) goto L116;
    L115:
        r6 = r33;
    L125:
        return r113.WikiToken(r6).build();
    L116:
        if (r8 == null) goto L118;
        r33 = r8.getWikiToken();
    L119:
        if (r33 != null) goto L115;
        if (r8 == null) goto L125;
        WikiNavInfo r34 = r8.getWikiInfo();
        if (r34 == null) goto L125;
        r6 = r34.getWikiToken();
        goto L125
    L118:
        r33 = null;
    L103:
        r31 = null;
        goto L104
    L101:
        if (r8 == null) goto L103;
        r31 = r8.getOwnerUid();
    L83:
        r27 = null;
    L75:
        r23 = null;
    L65:
        if (r8 == null) goto L67;
        r19 = r8.getCreatorTenantId();
        goto L68
    L67:
        r19 = null;
    L50:
        if (r8 == null) goto L52;
        r16 = r8.getTitle();
    L53:
        if (r16 != null) goto L59;
        if (r10 == null) goto L56;
        r16 = r10.getName();
    L57:
        if (r16 != null) goto L59;
        r16 = "";
        goto L59
    L56:
        r16 = null;
        goto L57
    L52:
        r16 = null;
        goto L53
    L42:
        if (r12.getValue() != EntityType.EntityTypeUnknown.getValue()) goto L44;
        r12 = a(r8.getEntityType());
        goto L44
    L39:
        r13 = null;
    L30:
        if (r8 == null) goto L34;
        Integer r35 = r8.getType();
        if (r35 == null) goto L34;
        int r36 = r35.intValue();
    L35:
        r11 = sbb.e.d(r36);
    L34:
        r36 = sbb.e.e.b;
    L18:
        if (r10 == null) goto L20;
        r7 = r10.getToken();
    L21:
        if (r7 != null) goto L27;
    L26:
        r7 = "";
        goto L27
    L20:
        r7 = null;
        goto L21
    L23:
        if (r8 == null) goto L26;
        r7 = r8.getObjToken();
        if (r7 != null) goto L27;
    L9:
        r3 = false;
    L12:
        r4 = false;
        goto L13
    }

    public static EntityType e(String r1, String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "appFileId");
        boolean r4 = false;
        if (r3 == null) goto L5;
        boolean r5 = r3.booleanValue();
    L6:
        if (r5 == true) goto L16;
        if (r1 != null) goto L10;
    L11:
        r4 = true;
    L12:
        if (r4 == false) goto L15;
        return EntityType.EntityFileID;
    L15:
        return EntityType.EntityDriverSDKFileID;
    L10:
        if (r1.length() != 0) goto L12;
    L16:
        return EntityType.EntityLocalFile;
    L5:
        r5 = false;
        goto L6
    }
}
