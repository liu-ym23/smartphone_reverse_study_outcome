package com.bytedance.ee.bear.middleground.permission.audit;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.DriveData;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.pb.security_event.AppDetail;
import com.ss.android.lark.pb.security_event.ClientType;
import com.ss.android.lark.pb.security_event.CommonDrawer;
import com.ss.android.lark.pb.security_event.ContainerType;
import com.ss.android.lark.pb.security_event.Document;
import com.ss.android.lark.pb.security_event.EntityType;
import com.ss.android.lark.pb.security_event.Env;
import com.ss.android.lark.pb.security_event.Event;
import com.ss.android.lark.pb.security_event.Extend;
import com.ss.android.lark.pb.security_event.FlagType;
import com.ss.android.lark.pb.security_event.ModuleType;
import com.ss.android.lark.pb.security_event.ObjectDetail;
import com.ss.android.lark.pb.security_event.ObjectEntity;
import com.ss.android.lark.pb.security_event.OperationType;
import com.ss.android.lark.pb.security_event.OperatorEntity;
import com.ss.android.lark.pb.security_event.PermissionSettingType;
import com.ss.android.lark.pb.security_event.RenderItem;
import com.ss.android.lark.pb.security_event.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AuditApiImpl implements com.bytedance.ee.bear.middleground_permission_export.model.c {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    public final Event.Builder n() {
        return new Event.Builder().TenantID(((b0) this.a.getValue()).getTenantId()).Operator(new OperatorEntity.Builder().Type(EntityType.EntityUserID).Value(((b0) this.a.getValue()).getUid()).Detail(null).build()).Env(new Env.Builder().Client(ClientType.ClientAndroid).DID(((b0) this.a.getValue()).getDeviceId()).Location("").UA(((b0) this.a.getValue()).h()).IP("").Flag(FlagType.FlagNormal).build()).TimeStamp(String.valueOf(System.currentTimeMillis()));
    }

    public AuditApiImpl() {
        this.a = LazyKt.lazy(AuditApiImpl$infoService$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void j(String r5, String r6, Boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "appFileId");
        tt5.a.b("AuditApiImplV2", "do audit for drive. moduleType: ModuleIMFile, operationType: OperationDownload, appId: " + r5 + ", appFileId: " + r6 + ", localFile: " + r7 + ", thirdPartyAppID:null");
        e r0 = d.g();
        if (r0 == null) goto L6;
        r0.d(n().Module(ModuleType.ModuleIMFile).Operation(OperationType.OperationDownload).Objects(CollectionsKt.mutableListOf(new ObjectEntity[]{new ObjectEntity.Builder().Type(d.e(r5, r6, r7)).Value(d.f(r5, r6)).Detail(null).build()})).build());
        return;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void l(sbb.e r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "documentType");
        e r0 = d.g();
        if (r0 == null) goto L6;
        Event.Builder r10 = n().Module(d.c(r7)).Operation(OperationType.OperationSpaceDocClickDocPlugin).Objects(CollectionsKt.mutableListOf(new ObjectEntity[]{new ObjectEntity.Builder().Type(d.d(r7)).Value(r8).Detail(new ObjectDetail.Builder().ContainerID(r8).build()).build()}));
        Extend.Builder r1 = new Extend.Builder();
        CommonDrawer.Builder r2 = new CommonDrawer.Builder();
        ArrayList r3 = new ArrayList();
        r3.add(new RenderItem.Builder().Key("relation_url").Value(r9).build());
        r3.add(new RenderItem.Builder().Key("relation_doc_id").Value(r8).build());
        Unit r11 = Unit.INSTANCE;
        r0.d(r10.Extend(r1.CommonDrawer(r2.ItemList(r3).build()).status(Status.Success).build()).build());
        return;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void a(String r5, String r6, Boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "appFileId");
        tt5.a.b("AuditApiImplV2", "do audit for drive. moduleType: ModuleAPP, operationType: OperationDownload, appId: " + r5 + ", appFileId: " + r6 + ", localFile: " + r7 + ", thirdPartyAppID:" + r8);
        e r0 = d.g();
        if (r0 == null) goto L10;
        Event.Builder r1 = n().Module(ModuleType.ModuleAPP).Operation(OperationType.OperationDownload);
        ObjectEntity[] r2 = new ObjectEntity[1];
        ObjectEntity.Builder r9 = new ObjectEntity.Builder().Type(d.e(r5, r6, r7)).Value(d.f(r5, r6));
        if (r8 == null) goto L7;
        ObjectDetail r10 = new ObjectDetail.Builder().ThirdPartyAppID(r8).PermissionSettingType(PermissionSettingType.PermissionSettingTypeUnknown).build();
    L8:
        r2[0] = r9.Detail(r10).build();
        r0.d(r1.Objects(CollectionsKt.mutableListOf(r2)).build());
        return;
    L7:
        r10 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void b(sbb.e r5, String r6, ContainerType r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "documentType");
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "containerType");
        Intrinsics.checkNotNullParameter(r8, "containerId");
        e r0 = d.g();
        if (r0 == null) goto L6;
        Event.Builder r1 = n().Module(d.c(r5)).Operation(OperationType.OperationCopyContent);
        ArrayList r2 = new ArrayList();
        r2.add(new ObjectEntity.Builder().Type(d.d(r5)).Value(r6).Detail(new ObjectDetail.Builder().ContainerType(r7).ContainerID(r8).build()).build());
        Unit r9 = Unit.INSTANCE;
        r0.d(r1.Objects(r2).Extend(new Extend.Builder().AppDetail(AppDetail.AppDetailUnknown).status(Status.Success).build()).build());
        return;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void d(sbb.e r5, String r6, ContainerType r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "documentType");
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "containerType");
        Intrinsics.checkNotNullParameter(r8, "containerId");
        e r0 = d.g();
        if (r0 == null) goto L6;
        Event.Builder r1 = n().Module(d.c(r5)).Operation(OperationType.OperationPrint);
        ArrayList r2 = new ArrayList();
        r2.add(new ObjectEntity.Builder().Type(d.d(r5)).Value(r6).Detail(new ObjectDetail.Builder().ContainerType(r7).ContainerID(r8).build()).build());
        Unit r9 = Unit.INSTANCE;
        r0.d(r1.Objects(r2).Extend(new Extend.Builder().AppDetail(AppDetail.AppDetailUnknown).status(Status.Success).build()).build());
        return;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void e(sbb.e r5, String r6, ContainerType r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "documentType");
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "containerType");
        Intrinsics.checkNotNullParameter(r8, "containerId");
        e r0 = d.g();
        if (r0 == null) goto L6;
        Event.Builder r1 = n().Module(d.c(r5)).Operation(OperationType.OperationFrontExport);
        ArrayList r2 = new ArrayList();
        r2.add(new ObjectEntity.Builder().Type(d.d(r5)).Value(r6).Detail(new ObjectDetail.Builder().ContainerType(r7).ContainerID(r8).build()).build());
        Unit r9 = Unit.INSTANCE;
        r0.d(r1.Objects(r2).Extend(new Extend.Builder().AppDetail(AppDetail.AppDetailUnknown).status(Status.Success).build()).build());
        return;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void g(String r6, String r7, Boolean r8, Boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "appFileId");
        tt5.a.b("AuditApiImplV2", "do audit for drive. moduleType: ModuleIMFile, operationType: OperationOpenWith3rdApp, appId: " + r6 + ", appFileId: " + r7 + ", localFile: " + r8 + ", thirdPartyAppID:null");
        ArrayList r0 = new ArrayList();
        int r1 = d.a;
        d.i(r0, Boolean.valueOf(Intrinsics.areEqual(r9, Boolean.FALSE)));
        CommonDrawer r10 = new CommonDrawer.Builder().ItemList(r0).build();
        if (r10 == null) goto L5;
        Extend r11 = new Extend.Builder().CommonDrawer(r10).build();
    L6:
        e r2 = d.g();
        if (r2 == null) goto L10;
        r2.d(n().Module(ModuleType.ModuleIMFile).Operation(OperationType.OperationOpenWith3rdApp).Objects(CollectionsKt.mutableListOf(new ObjectEntity[]{new ObjectEntity.Builder().Type(d.e(r6, r7, r8)).Value(d.f(r6, r7)).Detail(null).build()})).Extend(r11).build());
        return;
    L10:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void i(HostDocumentInfo r16, dj5.a r17, DriveData r18, Boolean r19) {
        Intrinsics.checkNotNullParameter(r18, "driveData");
        CommonDrawer.Builder r4 = new CommonDrawer.Builder();
        int r5 = d.a;
        Intrinsics.checkNotNullParameter(r18, "driveData");
        ArrayList r3 = new ArrayList();
        String r6 = r16.getObjToken();
        if (r6 != null) goto L5;
    L10:
        boolean r7 = false;
    L11:
        String r8 = "";
        if (r7 == false) goto L16;
        String r9 = r16.getDocToken();
        if (r9 != null) goto L20;
    L18:
        r9 = "";
    L20:
        if (TextUtils.isEmpty(r9) == true) goto L22;
        tt5.a.h("AuditApiImplV2", "getDownloadRenderItemList(), docToken is not Empty");
        r3.add(new RenderItem.Builder().Key("attachment_id").Value(r18.getToken()).build());
        r3.add(new RenderItem.Builder().Key("attachment_type").Value(r18.getMimeType()).build());
        r3.add(new RenderItem.Builder().Key("attachment_name").Value(r18.getName()).build());
    L23:
        d.i(r3, r19);
        r4.ItemList(r3);
        CommonDrawer r10 = r4.build();
        String r11 = null;
        if (r10 == null) goto L26;
        Extend r12 = new Extend.Builder().CommonDrawer(r10).build();
    L27:
        Document r13 = d.b(r16, r17, r18);
        Integer r14 = r16.getType();
        if (r14 == null) goto L30;
        int r15 = r14.intValue();
    L31:
        sbb.e r110 = sbb.e.d(r15);
        String r111 = r16.getObjToken();
        if (r111 != null) goto L34;
    L39:
        boolean r112 = false;
    L40:
        if (r112 == false) goto L46;
        String r113 = r16.getDocToken();
        if (r113 != null) goto L50;
        r113 = r18.getToken();
        if (r113 != null) goto L50;
    L48:
        r113 = "";
    L50:
        if (r16.getEntityType() == null) goto L52;
        EntityType r114 = d.a(r16.getEntityType());
    L53:
        tt5.a.h("AuditApiImplV2", "doAuditDownloadCommon() documentType=" + r110 + ",entityType = " + r114 + 12289 + r16.getEntityType() + ", appId = " + r18.getAppId() + ", isForbidden=" + r19);
        e r2 = d.g();
        if (r2 == null) goto L103;
        Event.Builder r20 = n().Module(ModuleType.ModuleFiles);
        String r1 = r18.getAppId();
        if (r1 == null) goto L84;
        int r115 = r1.hashCode();
        if (r115 == 1576) goto L81;
        if (r115 == 1604) goto L78;
        if (r115 == 449676720) goto L75;
        if (r115 == 1664) goto L72;
        if (r115 != 1665) goto L84;
        if (r1.equals("45") == false) goto L84;
    L83:
        OperationType r21 = OperationType.OperationSpaceDownloadAttachment;
    L85:
        Event.Builder r22 = r20.Operation(r21);
        ObjectEntity[] r23 = new ObjectEntity[1];
        ObjectEntity.Builder r24 = new ObjectEntity.Builder().Type(r114).Value(r113);
        ObjectDetail.Builder r116 = new ObjectDetail.Builder();
        if (r17 == null) goto L88;
        String r117 = r17.a;
    L89:
        if (r117 == null) goto L91;
        ContainerType r118 = ContainerType.Wiki;
    L92:
        ObjectDetail.Builder r119 = r116.ContainerType(r118);
        if (r17 == null) goto L95;
        r11 = r17.a;
    L95:
        if (r11 == null) goto L101;
        if (r17 == null) goto L101;
        String r0 = r17.a;
        if (r0 == null) goto L101;
        r8 = r0;
    L101:
        r23[0] = r24.Detail(r119.ContainerID(r8).Document(r13).build()).build();
        r2.d(r22.Objects(CollectionsKt.mutableListOf(r23)).Extend(r12).build());
        return;
    L91:
        r118 = ContainerType.ContainerTypeUnknown;
        goto L92
    L88:
        r117 = null;
        goto L89
    L72:
        if (r1.equals("44") == true) goto L83;
    L75:
        if (r1.equals("26_local") == false) goto L84;
    L78:
        if (r1.equals("26") == true) goto L83;
    L81:
        if (r1.equals("19") == true) goto L83;
    L84:
        r21 = OperationType.OperationDownload;
        goto L85
    L103:
        return;
    L52:
        Intrinsics.checkNotNull(r110);
        r114 = d.d(r110);
        goto L53
    L46:
        r113 = r16.getObjToken();
        if (r113 != null) goto L50;
    L34:
        if (r111.length() != 0) goto L36;
        boolean r120 = true;
    L37:
        if (r120 != true) goto L39;
        r112 = true;
        goto L40
    L36:
        r120 = false;
        goto L37
    L30:
        r15 = 12;
        goto L31
    L26:
        r12 = null;
        goto L27
    L22:
        tt5.a.h("AuditApiImplV2", "getDownloadRenderItemList(), docToken is Empty ");
        goto L23
    L16:
        r9 = r16.getObjToken();
        if (r9 != null) goto L20;
    L5:
        if (r6.length() != 0) goto L7;
        boolean r25 = true;
    L8:
        if (r25 != true) goto L10;
        r7 = true;
        goto L11
    L7:
        r25 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void k(String r5, String r6, Boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "appFileId");
        tt5.a.b("AuditApiImplV2", "do audit for drive. moduleType: ModuleAPP, operationType: OperationOpenWith3rdApp, appId: " + r5 + ", appFileId: " + r6 + ", localFile: " + r7 + ", thirdPartyAppID:" + r8);
        e r0 = d.g();
        if (r0 == null) goto L10;
        Event.Builder r1 = n().Module(ModuleType.ModuleAPP).Operation(OperationType.OperationOpenWith3rdApp);
        ObjectEntity[] r2 = new ObjectEntity[1];
        ObjectEntity.Builder r9 = new ObjectEntity.Builder().Type(d.e(r5, r6, r7)).Value(d.f(r5, r6));
        if (r8 == null) goto L7;
        ObjectDetail r10 = new ObjectDetail.Builder().ThirdPartyAppID(r8).PermissionSettingType(PermissionSettingType.PermissionSettingTypeUnknown).build();
    L8:
        r2[0] = r9.Detail(r10).build();
        r0.d(r1.Objects(CollectionsKt.mutableListOf(r2)).build());
        return;
    L7:
        r10 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void c(sbb.e r5, String r6, AppDetail r7, ContainerType r8, String r9) {
        Intrinsics.checkNotNullParameter(r5, "documentType");
        Intrinsics.checkNotNullParameter(r6, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "appDetail");
        Intrinsics.checkNotNullParameter(r8, "containerType");
        Intrinsics.checkNotNullParameter(r9, "containerId");
        e r0 = d.g();
        if (r0 == null) goto L6;
        Event.Builder r1 = n().Module(d.c(r5)).Operation(OperationType.OperationShareTo3rdApp);
        ArrayList r2 = new ArrayList();
        r2.add(new ObjectEntity.Builder().Type(d.d(r5)).Value(r6).Detail(new ObjectDetail.Builder().ContainerType(r8).ContainerID(r9).build()).build());
        Unit r10 = Unit.INSTANCE;
        r0.d(r1.Objects(r2).Extend(new Extend.Builder().AppDetail(r7).status(Status.Success).build()).build());
        return;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void m(String r6, String r7, Boolean r8, String r9, Boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "appFileId");
        tt5.a.b("AuditApiImplV2", "do audit for drive. moduleType: ModuleFiles, operationType: OperationOpenWith3rdApp, appId: " + r6 + ", appFileId: " + r7 + ", localFile: " + r8 + ", thirdPartyAppID:" + r9);
        ArrayList r0 = new ArrayList();
        int r1 = d.a;
        d.i(r0, Boolean.valueOf(Intrinsics.areEqual(r10, Boolean.FALSE)));
        CommonDrawer r11 = new CommonDrawer.Builder().ItemList(r0).build();
        ObjectDetail r2 = null;
        if (r11 == null) goto L5;
        Extend r12 = new Extend.Builder().CommonDrawer(r11).build();
    L6:
        e r3 = d.g();
        if (r3 == null) goto L13;
        Event.Builder r4 = n().Module(ModuleType.ModuleFiles).Operation(OperationType.OperationOpenWith3rdApp);
        ObjectEntity[] r5 = new ObjectEntity[1];
        ObjectEntity.Builder r13 = new ObjectEntity.Builder().Type(d.e(r6, r7, r8)).Value(d.f(r6, r7));
        if (r9 == null) goto L11;
        r2 = new ObjectDetail.Builder().ThirdPartyAppID(r9).PermissionSettingType(PermissionSettingType.PermissionSettingTypeUnknown).build();
    L11:
        r5[0] = r13.Detail(r2).build();
        r3.d(r4.Objects(CollectionsKt.mutableListOf(r5)).Extend(r12).build());
        return;
    L13:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void h(String r5, String r6, Boolean r7, String r8, Boolean r9, Boolean r10) {
        Intrinsics.checkNotNullParameter(r6, "appFileId");
        tt5.a.b("AuditApiImplV2", "do audit for drive. moduleType: ModuleFiles, operationType: OperationDownload, appId: " + r5 + ", appFileId: " + r6 + ", localFile: " + r7 + ", thirdPartyAppID:" + r8);
        int r0 = d.a;
        ObjectDetail r1 = null;
        if (r9 != null) goto L6;
        if (r10 != null) goto L6;
        CommonDrawer r11 = null;
    L14:
        if (r11 == null) goto L16;
        Extend r12 = new Extend.Builder().CommonDrawer(r11).status(Status.Success).build();
    L17:
        e r13 = d.g();
        if (r13 == null) goto L24;
        Event.Builder r2 = n().Module(ModuleType.ModuleFiles).Operation(OperationType.OperationDownload);
        ObjectEntity[] r3 = new ObjectEntity[1];
        ObjectEntity.Builder r14 = new ObjectEntity.Builder().Type(d.e(r5, r6, r7)).Value(d.f(r5, r6));
        if (r8 == null) goto L22;
        r1 = new ObjectDetail.Builder().ThirdPartyAppID(r8).PermissionSettingType(PermissionSettingType.PermissionSettingTypeUnknown).build();
    L22:
        r3[0] = r14.Detail(r1).build();
        r13.d(r2.Objects(CollectionsKt.mutableListOf(r3)).Extend(r12).build());
        return;
    L24:
        return;
    L16:
        r12 = null;
    L6:
        CommonDrawer.Builder r4 = new CommonDrawer.Builder();
        ArrayList r15 = new ArrayList();
        r4.ItemList(r15);
        Boolean r16 = Boolean.TRUE;
        if (Intrinsics.areEqual(r9, r16) == false) goto L10;
        String r17 = ExportShareModel.EXPORT_SHARE_TYPE_IMAGE;
    L13:
        r15.add(new RenderItem.Builder().Key("ccm_download_type").Value(r17).build());
        r11 = r4.build();
        goto L14
    L10:
        if (Intrinsics.areEqual(r10, r16) == false) goto L12;
        r17 = "video";
        goto L13
    L12:
        r17 = DocumentType.FILE_NAME;
        goto L13
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.c
    public final void f(sbb.e r4, HostDocumentInfo r5, ContainerType r6, String r7, dj5.a r8, List<RenderItem> r9, Boolean r10) {
        Intrinsics.checkNotNullParameter(r4, "documentType");
        Intrinsics.checkNotNullParameter(r6, "containerType");
        Intrinsics.checkNotNullParameter(r7, "containerId");
        Intrinsics.checkNotNullParameter(r9, "renderList");
        CommonDrawer.Builder r0 = new CommonDrawer.Builder();
        ArrayList r1 = new ArrayList();
        d.i(r1, r10);
        Iterator<T> r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r1.add((RenderItem) r11.next());
        goto L4
    L6:
        r0.ItemList(r1);
        CommonDrawer r12 = r0.build();
        if (r12 == null) goto L9;
        Extend r13 = new Extend.Builder().CommonDrawer(r12).build();
    L10:
        Document r14 = d.b(r5, r8, null);
        tt5.a.h("AuditApiImplV2", "doAuditCopyCommon() documentType=" + r4 + ",  containerType=" + r6 + ", isForbidden=" + r10);
        e r15 = d.g();
        if (r15 == null) goto L20;
        Event.Builder r2 = n().Module(ModuleType.ModuleFiles).Operation(OperationType.OperationCopyContent);
        ObjectEntity[] r3 = new ObjectEntity[1];
        ObjectEntity.Builder r16 = new ObjectEntity.Builder().Type(d.d(r4));
        if (r5 == null) goto L16;
        String r17 = r5.getObjToken();
        if (r17 == null) goto L16;
    L17:
        r3[0] = r16.Value(r17).Detail(new ObjectDetail.Builder().ContainerType(r6).ContainerID(r7).Document(r14).build()).build();
        r15.d(r2.Objects(CollectionsKt.mutableListOf(r3)).Extend(r13).build());
        return;
    L16:
        r17 = "";
        goto L17
    L20:
        return;
    L9:
        r13 = null;
        goto L10
    }
}
