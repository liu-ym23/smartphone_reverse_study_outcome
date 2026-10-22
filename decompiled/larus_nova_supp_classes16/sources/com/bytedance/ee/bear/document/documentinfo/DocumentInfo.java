package com.bytedance.ee.bear.document.documentinfo;

import android.text.TextUtils;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.audit.HostDocumentInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.util.io.NonProguard;
import eu5.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 q2\u00020\u0001:\u0001qBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020(J\u0014\u00105\u001a\u0002022\f\u00106\u001a\b\u0012\u0004\u0012\u00020*07J\u0010\u00108\u001a\u0004\u0018\u00010*2\u0006\u00109\u001a\u00020\tJ\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*0;J\u000e\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020%J\u0006\u0010$\u001a\u00020%J\u000e\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\tJ\u0006\u0010@\u001a\u00020%J\u0006\u0010A\u001a\u00020%J\u0006\u0010B\u001a\u00020%J\u0006\u0010C\u001a\u00020%J\u0006\u0010D\u001a\u00020%J\u0006\u0010E\u001a\u00020%J\u0006\u0010F\u001a\u00020%J\u0010\u0010G\u001a\u0002022\b\u0010H\u001a\u0004\u0018\u00010\tJ\u000e\u0010I\u001a\u0002022\u0006\u0010J\u001a\u00020\u0003J\u000e\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020\u0005J\u000e\u0010M\u001a\u0002022\u0006\u0010N\u001a\u00020\fJ\u0006\u0010O\u001a\u00020\fJ\u0006\u0010P\u001a\u00020\tJ\u0006\u0010Q\u001a\u00020\tJ\u0006\u0010R\u001a\u00020\tJ\u0006\u0010S\u001a\u00020\tJ\u0006\u0010T\u001a\u00020\tJ\u0006\u0010U\u001a\u00020\tJ\u0006\u0010V\u001a\u00020\tJ\u0006\u0010W\u001a\u00020%J\u0006\u0010X\u001a\u00020%J\u0006\u0010Y\u001a\u00020%J\u0006\u0010Z\u001a\u00020%J\u000e\u0010[\u001a\u0002022\u0006\u0010W\u001a\u00020%J\u000e\u0010\\\u001a\u0002022\u0006\u0010X\u001a\u00020%J\u000e\u0010]\u001a\u0002022\u0006\u0010Y\u001a\u00020%J\u000e\u0010^\u001a\u0002022\u0006\u0010Z\u001a\u00020%J\u0006\u0010_\u001a\u00020\tJ\b\u0010`\u001a\u0004\u0018\u00010\tJ\u0006\u0010a\u001a\u00020\tJ\u0006\u0010b\u001a\u00020cJ\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\u0007HÆ\u0003J\t\u0010g\u001a\u00020\tHÆ\u0003J\t\u0010h\u001a\u00020\tHÆ\u0003J\t\u0010i\u001a\u00020\fHÆ\u0003J\t\u0010j\u001a\u00020\tHÆ\u0003JO\u0010k\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001J\u0013\u0010l\u001a\u00020%2\b\u0010m\u001a\u0004\u0018\u00010nHÖ\u0003J\t\u0010o\u001a\u00020\fHÖ\u0001J\t\u0010p\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020*0'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006r"}, d2 = {"Lcom/bytedance/ee/bear/document/documentinfo/DocumentInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "docMetaInfo", "Lcom/bytedance/ee/bear/DocMetaInfo;", "docPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;", "version", "Lcom/bytedance/ee/bear/list/dto/DocVersion;", "url", "", "objToken", "type", "", "spaceId", "<init>", "(Lcom/bytedance/ee/bear/DocMetaInfo;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;Lcom/bytedance/ee/bear/list/dto/DocVersion;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getDocMetaInfo", "()Lcom/bytedance/ee/bear/DocMetaInfo;", "setDocMetaInfo", "(Lcom/bytedance/ee/bear/DocMetaInfo;)V", "getDocPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;", "setDocPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;)V", "getVersion", "()Lcom/bytedance/ee/bear/list/dto/DocVersion;", "setVersion", "(Lcom/bytedance/ee/bear/list/dto/DocVersion;)V", "getUrl", "()Ljava/lang/String;", "getObjToken", "getType", "()I", "getSpaceId", "setSpaceId", "(Ljava/lang/String;)V", "isOfflineInfo", "", "permHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "blockInfoMap", "Lcom/bytedance/ee/bear/document/documentinfo/BlockInfo;", "docObjInfo", "Lcom/bytedance/ee/bear/DocObjInfo;", "getDocObjInfo", "()Lcom/bytedance/ee/bear/DocObjInfo;", "setDocObjInfo", "(Lcom/bytedance/ee/bear/DocObjInfo;)V", "updatePermHashMap", "", "outObjToken", "userPermission", "updateBlockInfo", "blockInfos", "", "getBlockInfo", "token", "getBlockInfos", "", "setOfflineInfo", "offline", "getDocPermissionByToken", "referObjToken", "canEdit", "canRead", "adminPerceiveControl", "canPerceive", "isOwner", "canCopy", "canDownload", "setTitle", "newTitle", "updateMetaInfo", "metaInfo", "updateDocPermission", "permission", "updateCanSecLabelCode", "canSetSecLabelCode", "getCanSecLabelCode", "getTitle", "getCreatorUid", "getCreatorName", "getCreateTime", "getCreatorTenantId", "getOwnerUid", "getSubType", "isPined", "isStared", "isSubscribe", "isSubscribeComment", "setPined", "setStared", "setSubscribe", "setSubscribeComment", "getIcon", "getIconInfo", "getAppId", "convertToHostDocumentInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/audit/HostDocumentInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static /* synthetic */ DocumentInfo copy$default(DocumentInfo r5, DocMetaInfo r6, DocPermission r7, DocVersion r8, String r9, String r10, int r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.docMetaInfo;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.docPermission;
    L8:
        DocPermission r16 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.version;
    L11:
        DocVersion r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.url;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.objToken;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.type;
    L20:
        int r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.spaceId;
    L23:
        DocMetaInfo r17 = r6;
        return r5.copy(r17, r16, r0, r1, r2, r3, r12);
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

    public final DocumentInfo copy(DocMetaInfo r10, DocPermission r11, DocVersion r12, String r13, String r14, int r16, String r17) {
        Intrinsics.checkNotNullParameter(r10, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r11, "docPermission");
        Intrinsics.checkNotNullParameter(r12, "version");
        Intrinsics.checkNotNullParameter(r13, "url");
        Intrinsics.checkNotNullParameter(r14, "objToken");
        Intrinsics.checkNotNullParameter(r17, "spaceId");
        return new DocumentInfo(r10, r11, r12, r13, r14, r16, r17);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocumentInfo) == true) goto L8;
        return false;
    L8:
        DocumentInfo r6 = (DocumentInfo) r5;
        if (Intrinsics.areEqual(this.docMetaInfo, r6.docMetaInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.docPermission, r6.docPermission) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.objToken, r6.objToken) == true) goto L24;
        return false;
    L24:
        if (this.type == r6.type) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.spaceId, r6.spaceId) == true) goto L29;
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
        return this.docPermission.a.canCopy();
    }

    public final boolean canDownload() {
        return this.docPermission.a.canDownload();
    }

    public final boolean canEdit() {
        return this.docPermission.a.canEdit();
    }

    public final boolean canPerceive() {
        return this.docPermission.a.canPerceive();
    }

    public final boolean canRead() {
        return this.docPermission.a.canRead();
    }

    public final HostDocumentInfo convertToHostDocumentInfo() {
        HostDocumentInfo r0 = new HostDocumentInfo();
        r0.setDocMetaInfo(this.docMetaInfo);
        r0.setObjToken(this.objToken);
        r0.setType(Integer.valueOf(this.type));
        r0.setSpaceId(this.spaceId);
        r0.setWikiInfo(this.docObjInfo.getWikiInfo());
        return r0;
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
        String r0 = b.a.getResources().getString(2131887103);
    L6:
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        r0 = this.docMetaInfo.getTitle();
        goto L6
    }

    public final boolean isOfflineInfo() {
        if (this.isOfflineInfo == false) goto L7;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.f() == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean isOwner() {
        return this.docPermission.b.isOwner();
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

    public final BlockInfo getBlockInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
        return this.blockInfoMap.get(r2);
    }

    public final IDocUserPermission getDocPermissionByToken(String r8) {
        Intrinsics.checkNotNullParameter(r8, "referObjToken");
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        e r0 = e.a.a;
        boolean r1 = false;
        if (com.bytedance.ee.bear.middleground.permission.b.g() == true) goto L5;
        tt5.a.h(TAG, "getDocPermissionByToken host perm");
        if (isOfflineInfo() == false) goto L28;
        IDocUserPermission r9 = this.permHashMap.get(r8);
        StringBuilder r2 = new StringBuilder("getDocPermissionByToken ");
        if (r9 != null) goto L23;
        r1 = true;
    L23:
        r2.append(r1);
        tt5.a.h(TAG, r2.toString());
        if (r9 == null) goto L26;
        return r9;
    L26:
        return new DefaultDocUserPermission();
    L28:
        return this.docPermission.a;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        tt5.a.h(TAG, "getDocPermissionByToken default userperm");
        return new DefaultDocUserPermission();
    L7:
        if (isOfflineInfo() == true) goto L9;
        this.permHashMap.put(this.objToken, this.docPermission.a);
    L9:
        IDocUserPermission r10 = this.permHashMap.get(r8);
        StringBuilder r3 = new StringBuilder("getDocPermissionByToken ");
        if (r10 != null) goto L12;
        r1 = true;
    L12:
        r3.append(r1);
        r3.append(" ,");
        r3.append(isOfflineInfo());
        tt5.a.h(TAG, r3.toString());
        if (r10 == null) goto L15;
        return r10;
    L15:
        return new DefaultDocUserPermission();
    }

    public final void setDocMetaInfo(DocMetaInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.docMetaInfo = r2;
    }

    public final void setDocObjInfo(DocObjInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.docObjInfo = r2;
    }

    public final void setDocPermission(DocPermission r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.docPermission = r2;
    }

    public final void setOfflineInfo(boolean r1) {
        this.isOfflineInfo = r1;
    }

    public final void setPined(boolean r2) {
        this.docMetaInfo.setPined(r2);
    }

    public final void setSpaceId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.spaceId = r2;
    }

    public final void setStared(boolean r2) {
        this.docMetaInfo.setStared(r2);
    }

    public final void setSubscribe(boolean r2) {
        this.docObjInfo.setSubscribed(r2);
    }

    public final void setSubscribeComment(boolean r2) {
        this.docObjInfo.setSubscribeComment(r2);
    }

    public final void setTitle(String r2) {
        DocMetaInfo r0 = this.docMetaInfo;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.setTitle(r2);
    }

    public final void setVersion(DocVersion r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.version = r2;
    }

    public final void updateBlockInfo(List<BlockInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "blockInfos");
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        BlockInfo r0 = (BlockInfo) r5.next();
        if (this.blockInfoMap.containsKey(r0.getToken()) == true) goto L7;
        this.blockInfoMap.put(r0.getToken(), r0);
        goto L4
    L7:
        BlockInfo r1 = this.blockInfoMap.get(r0.getToken());
        if (r1 == null) goto L4;
        r1.update(r0);
        goto L4
    }

    public final void updateCanSecLabelCode(int r2) {
        this.docMetaInfo.setCanSetSecLabelCode(r2);
    }

    public final void updateDocPermission(DocPermission r2) {
        Intrinsics.checkNotNullParameter(r2, "permission");
        this.docPermission = r2;
    }

    public final void updateMetaInfo(DocMetaInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "metaInfo");
        this.docMetaInfo = r2;
    }

    public final void updatePermHashMap(String r4, IDocUserPermission r5) {
        Intrinsics.checkNotNullParameter(r4, "outObjToken");
        Intrinsics.checkNotNullParameter(r5, "userPermission");
        if (r4.equals(this.objToken) == true) goto L5;
    L7:
        this.permHashMap.put(r4, r5);
        tt5.a.h(TAG, "updatePermHashMap enter");
        return;
    L5:
        if (isOfflineInfo() == true) goto L7;
        this.permHashMap.put(this.objToken, this.docPermission.a);
        goto L7
    }

    public DocumentInfo(DocMetaInfo r13, DocPermission r14, DocVersion r16, String r17, String r18, int r19, String r110) {
        Intrinsics.checkNotNullParameter(r13, "docMetaInfo");
        Intrinsics.checkNotNullParameter(r14, "docPermission");
        Intrinsics.checkNotNullParameter(r16, "version");
        Intrinsics.checkNotNullParameter(r17, "url");
        Intrinsics.checkNotNullParameter(r18, "objToken");
        Intrinsics.checkNotNullParameter(r110, "spaceId");
        this.docMetaInfo = r13;
        this.docPermission = r14;
        this.version = r16;
        this.url = r17;
        this.objToken = r18;
        this.type = r19;
        this.spaceId = r110;
        this.permHashMap = new ConcurrentHashMap();
        this.blockInfoMap = new ConcurrentHashMap();
        this.docObjInfo = new DocObjInfo(false, false, false, false, null, null, 0, 127, null);
    }

    public /* synthetic */ DocumentInfo(DocMetaInfo r11, DocPermission r12, DocVersion r13, String r14, String r16, int r17, String r18, int r19, DefaultConstructorMarker r110) {
        if ((r19 & 8) == 0) goto L5;
        String r6 = "";
    L7:
        if ((r19 & 16) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r19 & 32) == 0) goto L13;
        int r8 = 0;
    L15:
        if ((r19 & 64) == 0) goto L17;
        String r9 = "";
    L18:
        this(r11, r12, r13, r6, r7, r8, r9);
        return;
    L17:
        r9 = r18;
        goto L18
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r14;
        goto L7
    }
}
