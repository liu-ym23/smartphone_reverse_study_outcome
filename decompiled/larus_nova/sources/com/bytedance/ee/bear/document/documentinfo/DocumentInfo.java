package com.bytedance.ee.bear.document.documentinfo;

import android.text.TextUtils;
import com.alipay.sdk.m.x.d;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.nova.R;
import eu5.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 q2\u00020\u0001:\u0001qBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020(J\u0014\u00105\u001a\u0002022\f\u00106\u001a\b\u0012\u0004\u0012\u00020*07J\u0010\u00108\u001a\u0004\u0018\u00010*2\u0006\u00109\u001a\u00020\tJ\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*0;J\u000e\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020%J\u0006\u0010$\u001a\u00020%J\u000e\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\tJ\u0006\u0010@\u001a\u00020%J\u0006\u0010A\u001a\u00020%J\u0006\u0010B\u001a\u00020%J\u0006\u0010C\u001a\u00020%J\u0006\u0010D\u001a\u00020%J\u0006\u0010E\u001a\u00020%J\u0006\u0010F\u001a\u00020%J\u0010\u0010G\u001a\u0002022\b\u0010H\u001a\u0004\u0018\u00010\tJ\u000e\u0010I\u001a\u0002022\u0006\u0010J\u001a\u00020\u0003J\u000e\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020\u0005J\u000e\u0010M\u001a\u0002022\u0006\u0010N\u001a\u00020\fJ\u0006\u0010O\u001a\u00020\fJ\u0006\u0010P\u001a\u00020\tJ\u0006\u0010Q\u001a\u00020\tJ\u0006\u0010R\u001a\u00020\tJ\u0006\u0010S\u001a\u00020\tJ\u0006\u0010T\u001a\u00020\tJ\u0006\u0010U\u001a\u00020\tJ\u0006\u0010V\u001a\u00020\tJ\u0006\u0010W\u001a\u00020%J\u0006\u0010X\u001a\u00020%J\u0006\u0010Y\u001a\u00020%J\u0006\u0010Z\u001a\u00020%J\u000e\u0010[\u001a\u0002022\u0006\u0010W\u001a\u00020%J\u000e\u0010\\\u001a\u0002022\u0006\u0010X\u001a\u00020%J\u000e\u0010]\u001a\u0002022\u0006\u0010Y\u001a\u00020%J\u000e\u0010^\u001a\u0002022\u0006\u0010Z\u001a\u00020%J\u0006\u0010_\u001a\u00020\tJ\b\u0010`\u001a\u0004\u0018\u00010\tJ\u0006\u0010a\u001a\u00020\tJ\u0006\u0010b\u001a\u00020cJ\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0007HÆ\u0003J\t\u0010g\u001a\u00020\tHÆ\u0003J\t\u0010h\u001a\u00020\tHÆ\u0003J\t\u0010i\u001a\u00020\fHÆ\u0003J\t\u0010j\u001a\u00020\tHÆ\u0003JO\u0010k\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0013\u0010l\u001a\u00020%2\b\u0010m\u001a\u0004\u0018\u00010nHÖ\u0003J\t\u0010o\u001a\u00020\fHÖ\u0001J\t\u0010p\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006r"}, d2 = {"Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "docMetaInfo", "Lcom/bytedance/ee/bear/DocMetaInfo;", "docPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;", "version", "Lcom/bytedance/ee/bear/list/dto/DocVersion;", "url", "", "objToken", "type", "", "spaceId", "<init>", "(Lcom/bytedance/ee/bear/DocMetaInfo;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;Lcom/bytedance/ee/bear/list/dto/DocVersion;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getDocMetaInfo", "()Lcom/bytedance/ee/bear/DocMetaInfo;", "setDocMetaInfo", "(Lcom/bytedance/ee/bear/DocMetaInfo;)V", "getDocPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;", "setDocPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;)V", "getVersion", "()Lcom/bytedance/ee/bear/list/dto/DocVersion;", "setVersion", "(Lcom/bytedance/ee/bear/list/dto/DocVersion;)V", "getUrl", "()Ljava/lang/String;", "getObjToken", "getType", "()I", "getSpaceId", "setSpaceId", "(Ljava/lang/String;)V", "isOfflineInfo", "", "permHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "blockInfoMap", "Lcom/bytedance/ee/bear/document/documentinfo/BlockInfo;", "docObjInfo", "Lcom/bytedance/ee/bear/DocObjInfo;", "getDocObjInfo", "()Lcom/bytedance/ee/bear/DocObjInfo;", "setDocObjInfo", "(Lcom/bytedance/ee/bear/DocObjInfo;)V", "updatePermHashMap", "", "outObjToken", "userPermission", "updateBlockInfo", "blockInfos", "", "getBlockInfo", "token", "getBlockInfos", "", "setOfflineInfo", OperationName.OPERATION_OFFLINE_AVAILABLE, "getDocPermissionByToken", "referObjToken", "canEdit", "canRead", "adminPerceiveControl", "canPerceive", "isOwner", "canCopy", "canDownload", d.f25925o, "newTitle", "updateMetaInfo", "metaInfo", "updateDocPermission", "permission", "updateCanSecLabelCode", "canSetSecLabelCode", "getCanSecLabelCode", "getTitle", "getCreatorUid", "getCreatorName", "getCreateTime", "getCreatorTenantId", "getOwnerUid", "getSubType", "isPined", "isStared", "isSubscribe", "isSubscribeComment", "setPined", "setStared", "setSubscribe", "setSubscribeComment", "getIcon", "getIconInfo", "getAppId", "convertToHostDocumentInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/audit/HostDocumentInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentInfo implements NonProguard {
    public static final a Companion = null;
    public static final String TAG = "DocumentInfo";
    private ConcurrentHashMap<String, BlockInfo> blockInfoMap;
    private DocMetaInfo docMetaInfo;
    private DocObjInfo docObjInfo;
    private DocPermission docPermission;
    private boolean isOfflineInfo;
    private final String objToken;
    private ConcurrentHashMap<String, IDocUserPermission> permHashMap;
    private String spaceId;
    private final int type;
    private final String url;
    private DocVersion version;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ DocumentInfo copy$default(DocumentInfo r100, DocMetaInfo r101, DocPermission r102, DocVersion r103, String r104, String r110, int r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.docMetaInfo;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.docPermission;
    L8:
        DocPermission r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.version;
    L11:
        DocVersion r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.url;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.objToken;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.type;
    L20:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.spaceId;
    L23:
        DocMetaInfo r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final DocMetaInfo component1() {
        return this.docMetaInfo;
    }

    public final DocPermission component2() {
        return this.docPermission;
    }

    public final DocVersion component3() {
        return this.version;
    }

    public final String component4() {
        return this.url;
    }

    public final String component5() {
        return this.objToken;
    }

    public final int component6() {
        return this.type;
    }

    public final String component7() {
        return this.spaceId;
    }

    public final DocumentInfo copy(DocMetaInfo r110, DocPermission r111, DocVersion r112, String r113, String r114, int r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r111, "docPermission");
        Intrinsics.checkNotNullParameter(r112, "version");
        Intrinsics.checkNotNullParameter(r113, "url");
        Intrinsics.checkNotNullParameter(r114, "objToken");
        Intrinsics.checkNotNullParameter(r116, "spaceId");
        return new DocumentInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocumentInfo) == true) goto L8;
        return false;
    L8:
        DocumentInfo r101 = (DocumentInfo) r100;
        if (Intrinsics.areEqual(this.docMetaInfo, r101.docMetaInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.docPermission, r101.docPermission) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.objToken, r101.objToken) == true) goto L24;
        return false;
    L24:
        if (this.type == r101.type) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.spaceId, r101.spaceId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.docMetaInfo.hashCode() * 31) + this.docPermission.hashCode()) * 31) + this.version.hashCode()) * 31) + this.url.hashCode()) * 31) + this.objToken.hashCode()) * 31) + this.type) * 31) + this.spaceId.hashCode();
    }

    public String toString() {
        return "DocumentInfo(docMetaInfo=" + this.docMetaInfo + ", docPermission=" + this.docPermission + ", version=" + this.version + ", url=" + this.url + ", objToken=" + this.objToken + ", type=" + this.type + ", spaceId=" + this.spaceId + ')';
    }

    public final boolean canCopy() {
        return this.docPermission.f234419a.canCopy();
    }

    public final boolean canDownload() {
        return this.docPermission.f234419a.canDownload();
    }

    public final boolean canEdit() {
        return this.docPermission.f234419a.canEdit();
    }

    public final boolean canPerceive() {
        return this.docPermission.f234419a.canPerceive();
    }

    public final boolean canRead() {
        return this.docPermission.f234419a.canRead();
    }

    public final HostDocumentInfo convertToHostDocumentInfo() {
        HostDocumentInfo r100 = new HostDocumentInfo();
        r100.setDocMetaInfo(this.docMetaInfo);
        r100.setObjToken(this.objToken);
        r100.setType(Integer.valueOf(this.type));
        r100.setSpaceId(this.spaceId);
        r100.setWikiInfo(this.docObjInfo.getWikiInfo());
        return r100;
    }

    public final String getAppId() {
        return this.docMetaInfo.getAppId();
    }

    public final int getCanSecLabelCode() {
        return this.docMetaInfo.getCanSetSecLabelCode();
    }

    public final String getCreateTime() {
        return this.docMetaInfo.getCreateTime();
    }

    public final String getCreatorName() {
        return this.docMetaInfo.getCreatorName();
    }

    public final String getCreatorTenantId() {
        return this.docMetaInfo.getCreatorTenantId();
    }

    public final String getCreatorUid() {
        return this.docMetaInfo.getCreatorUid();
    }

    public final String getIcon() {
        return this.docMetaInfo.getIcon();
    }

    public final String getIconInfo() {
        return this.docMetaInfo.getIcon_info();
    }

    public final String getOwnerUid() {
        return this.docMetaInfo.getOwnerUid();
    }

    public final String getSubType() {
        return this.docMetaInfo.getSubType();
    }

    public final String getTitle() {
        if (this.docMetaInfo.getSecureKeyDelete() == false) goto L5;
        String r100 = b.f474075a.getResources().getString(R.string.CreationDoc_Docs_KeyInvalid);
    L6:
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        r100 = this.docMetaInfo.getTitle();
        goto L6
    }

    public final boolean isOfflineInfo() {
        if (this.isOfflineInfo == false) goto L7;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.f499003a.f() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean isOwner() {
        return this.docPermission.f234420b.isOwner();
    }

    public final boolean isPined() {
        return this.docMetaInfo.isPined();
    }

    public final boolean isStared() {
        return this.docMetaInfo.isStared();
    }

    public final boolean isSubscribe() {
        return this.docObjInfo.isSubscribed();
    }

    public final boolean isSubscribeComment() {
        return this.docObjInfo.isSubscribeComment();
    }

    public final boolean adminPerceiveControl() {
        if (canRead() == false) goto L5;
    L7:
        return false;
    L5:
        if (canPerceive() == false) goto L7;
        return true;
    }

    public final Map<String, BlockInfo> getBlockInfos() {
        return this.blockInfoMap;
    }

    public final DocMetaInfo getDocMetaInfo() {
        return this.docMetaInfo;
    }

    public final DocObjInfo getDocObjInfo() {
        return this.docObjInfo;
    }

    public final DocPermission getDocPermission() {
        return this.docPermission;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final DocVersion getVersion() {
        return this.version;
    }

    public final BlockInfo getBlockInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return this.blockInfoMap.get(r100);
    }

    public final IDocUserPermission getDocPermissionByToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "referObjToken");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        e r101 = e.a.f499003a;
        boolean r102 = false;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == true) goto L5;
        tt5.a.h(TAG, "getDocPermissionByToken host perm");
        if (isOfflineInfo() == false) goto L28;
        IDocUserPermission r103 = this.permHashMap.get(r100);
        StringBuilder r104 = new StringBuilder("getDocPermissionByToken ");
        if (r103 != null) goto L23;
        r102 = true;
    L23:
        r104.append(r102);
        tt5.a.h(TAG, r104.toString());
        if (r103 == null) goto L26;
        return r103;
    L26:
        return new DefaultDocUserPermission();
    L28:
        return this.docPermission.f234419a;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        tt5.a.h(TAG, "getDocPermissionByToken default userperm");
        return new DefaultDocUserPermission();
    L7:
        if (isOfflineInfo() == true) goto L9;
        this.permHashMap.put(this.objToken, this.docPermission.f234419a);
    L9:
        IDocUserPermission r105 = this.permHashMap.get(r100);
        StringBuilder r106 = new StringBuilder("getDocPermissionByToken ");
        if (r105 != null) goto L12;
        r102 = true;
    L12:
        r106.append(r102);
        r106.append(" ,");
        r106.append(isOfflineInfo());
        tt5.a.h(TAG, r106.toString());
        if (r105 == null) goto L15;
        return r105;
    L15:
        return new DefaultDocUserPermission();
    }

    public final void setDocMetaInfo(DocMetaInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docMetaInfo = r100;
    }

    public final void setDocObjInfo(DocObjInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docObjInfo = r100;
    }

    public final void setDocPermission(DocPermission r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.docPermission = r100;
    }

    public final void setOfflineInfo(boolean r100) {
        this.isOfflineInfo = r100;
    }

    public final void setPined(boolean r100) {
        this.docMetaInfo.setPined(r100);
    }

    public final void setSpaceId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.spaceId = r100;
    }

    public final void setStared(boolean r100) {
        this.docMetaInfo.setStared(r100);
    }

    public final void setSubscribe(boolean r100) {
        this.docObjInfo.setSubscribed(r100);
    }

    public final void setSubscribeComment(boolean r100) {
        this.docObjInfo.setSubscribeComment(r100);
    }

    public final void setTitle(String r100) {
        DocMetaInfo r101 = this.docMetaInfo;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.setTitle(r100);
    }

    public final void setVersion(DocVersion r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.version = r100;
    }

    public final void updateBlockInfo(List<BlockInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "blockInfos");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        BlockInfo r102 = (BlockInfo) r101.next();
        if (this.blockInfoMap.containsKey(r102.getToken()) == true) goto L7;
        this.blockInfoMap.put(r102.getToken(), r102);
        goto L4
    L7:
        BlockInfo r103 = this.blockInfoMap.get(r102.getToken());
        if (r103 == null) goto L4;
        r103.update(r102);
        goto L4
    }

    public final void updateCanSecLabelCode(int r100) {
        this.docMetaInfo.setCanSetSecLabelCode(r100);
    }

    public final void updateDocPermission(DocPermission r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        this.docPermission = r100;
    }

    public final void updateMetaInfo(DocMetaInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "metaInfo");
        this.docMetaInfo = r100;
    }

    public final void updatePermHashMap(String r100, IDocUserPermission r101) {
        Intrinsics.checkNotNullParameter(r100, "outObjToken");
        Intrinsics.checkNotNullParameter(r101, "userPermission");
        if (r100.equals(this.objToken) == true) goto L5;
    L7:
        this.permHashMap.put(r100, r101);
        tt5.a.h(TAG, "updatePermHashMap enter");
        return;
    L5:
        if (isOfflineInfo() == true) goto L7;
        this.permHashMap.put(this.objToken, this.docPermission.f234419a);
        goto L7
    }

    public DocumentInfo(DocMetaInfo r110, DocPermission r111, DocVersion r112, String r113, String r114, int r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r111, "docPermission");
        Intrinsics.checkNotNullParameter(r112, "version");
        Intrinsics.checkNotNullParameter(r113, "url");
        Intrinsics.checkNotNullParameter(r114, "objToken");
        Intrinsics.checkNotNullParameter(r116, "spaceId");
        this.docMetaInfo = r110;
        this.docPermission = r111;
        this.version = r112;
        this.url = r113;
        this.objToken = r114;
        this.type = r115;
        this.spaceId = r116;
        this.permHashMap = new ConcurrentHashMap();
        this.blockInfoMap = new ConcurrentHashMap();
        this.docObjInfo = new DocObjInfo(false, false, false, false, null, null, 0, 127, null);
    }

    public /* synthetic */ DocumentInfo(DocMetaInfo r110, DocPermission r111, DocVersion r112, String r113, String r114, int r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 8) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r117 & 16) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r117 & 32) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r117 & 64) == 0) goto L17;
        String r103 = "";
    L18:
        this(r110, r111, r112, r100, r101, r102, r103);
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
