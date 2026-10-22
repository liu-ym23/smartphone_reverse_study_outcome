package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.dto.ObjBizType;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u0006\u0007\b\tB\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$Data;", "Ljava/io/Serializable;", "<init>", "()V", "Data", "FolderInfo", "WikiInfo", "IRecentData", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecentOperationResult extends Result<Data> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$Data;", "Ljava/io/Serializable;", "<init>", "()V", "recentList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$IRecentData;", "Lkotlin/collections/ArrayList;", "getRecentList", "()Ljava/util/ArrayList;", "setRecentList", "(Ljava/util/ArrayList;)V", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Data implements Serializable {
        private ArrayList<a> recentList;

        public Data() {
        }

        public final ArrayList<a> getRecentList() {
            return this.recentList;
        }

        public final void setRecentList(ArrayList<a> r1) {
            this.recentList = r1;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00108\u001a\u00020\u000fH\u0016J\u0012\u00109\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\b\u0010=\u001a\u00020'H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010>\u001a\u00020'H\u0016J\n\u00105\u001a\u0004\u0018\u00010\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u001a\u0010-\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010\u0013R\u001c\u00100\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\b\"\u0004\b7\u0010\n¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$FolderInfo;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$IRecentData;", "<init>", "()V", "objToken", "", "getObjToken", "()Ljava/lang/String;", "setObjToken", "(Ljava/lang/String;)V", ResourceData.KEY_TOKEN, "getToken", "setToken", ResourceData.KEY_TYPE, "", "getType", "()I", "setType", "(I)V", "name", "getName", "setName", "ownerId", "getOwnerId", "setOwnerId", "ownerType", "getOwnerType", "setOwnerType", "shareVersion", "getShareVersion", "setShareVersion", "objSubType", "", "getObjSubType", "()J", "setObjSubType", "(J)V", "isShareFolder", "", "()Z", "setShareFolder", "(Z)V", "isExternal", "setExternal", "objBizType", "getObjBizType", "setObjBizType", "parentInfo", "getParentInfo", "()Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$FolderInfo;", "setParentInfo", "(Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$FolderInfo;)V", "iconInfo", "getIconInfo", "setIconInfo", "iconRes", "title", "context", "Landroid/content/Context;", "description", "external", "isShareFolderWithOwner", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class FolderInfo implements Serializable, a {
        private String iconInfo;
        private boolean isExternal;
        private boolean isShareFolder;
        private String name;
        private int objBizType;
        private long objSubType;
        private String objToken;
        private String ownerId;
        private int ownerType;
        private FolderInfo parentInfo;
        private int shareVersion;
        private String token;
        private int type;

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public String description() {
            FolderInfo r0 = this.parentInfo;
            if (r0 == null) goto L6;
            String r1 = r0.name;
            if (r1 == null) goto L6;
            return r1;
        L6:
            return "";
        }

        public int iconRes() {
            FolderVersion.a r0 = FolderVersion.Companion;
            int r1 = this.ownerType;
            boolean r2 = this.isShareFolder;
            r0.getClass();
            if (FolderVersion.a.b(r1, r2) == false) goto L6;
            return rbb.b.g();
        L6:
            return ua5.a.i(this.type);
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public boolean isShareFolderWithOwner() {
            FolderVersion.a r0 = FolderVersion.Companion;
            int r1 = this.ownerType;
            boolean r2 = this.isShareFolder;
            r0.getClass();
            return FolderVersion.a.b(r1, r2);
        }

        public FolderInfo() {
            this.objToken = "";
            this.token = "";
            this.name = "";
            this.ownerId = "";
            this.objBizType = ObjBizType.SPACE.getType();
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public boolean external() {
            return this.isExternal;
        }

        public final String getIconInfo() {
            return this.iconInfo;
        }

        public final String getName() {
            return this.name;
        }

        public final int getObjBizType() {
            return this.objBizType;
        }

        public final long getObjSubType() {
            return this.objSubType;
        }

        public final String getObjToken() {
            return this.objToken;
        }

        public final String getOwnerId() {
            return this.ownerId;
        }

        public final int getOwnerType() {
            return this.ownerType;
        }

        public final FolderInfo getParentInfo() {
            return this.parentInfo;
        }

        public final int getShareVersion() {
            return this.shareVersion;
        }

        public final String getToken() {
            return this.token;
        }

        public final int getType() {
            return this.type;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public String iconInfo() {
            return this.iconInfo;
        }

        public final boolean isExternal() {
            return this.isExternal;
        }

        public final boolean isShareFolder() {
            return this.isShareFolder;
        }

        public int objBizType() {
            return this.objBizType;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public String token() {
            return this.objToken;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public int type() {
            return this.type;
        }

        public final void setExternal(boolean r1) {
            this.isExternal = r1;
        }

        public final void setIconInfo(String r1) {
            this.iconInfo = r1;
        }

        public final void setName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.name = r2;
        }

        public final void setObjBizType(int r1) {
            this.objBizType = r1;
        }

        public final void setObjSubType(long r1) {
            this.objSubType = r1;
        }

        public final void setObjToken(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.objToken = r2;
        }

        public final void setOwnerId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.ownerId = r2;
        }

        public final void setOwnerType(int r1) {
            this.ownerType = r1;
        }

        public final void setParentInfo(FolderInfo r1) {
            this.parentInfo = r1;
        }

        public final void setShareFolder(boolean r1) {
            this.isShareFolder = r1;
        }

        public final void setShareVersion(int r1) {
            this.shareVersion = r1;
        }

        public final void setToken(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.token = r2;
        }

        public final void setType(int r1) {
            this.type = r1;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public String title(Context r4) {
            String r0 = t0.j(r4, this.name, this.objSubType);
            if (TextUtils.isEmpty(r0) == false) goto L5;
            String r1 = t0.e(r4, this.type);
            Intrinsics.checkNotNull(r1);
            return r1;
        L5:
            Intrinsics.checkNotNull(r0);
            return r0;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010,\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\u0006\u0010\u001a\u001a\u00020\u0006J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u000fH\u0016J\b\u00104\u001a\u000201H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u001a\u0010\u001d\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010 \u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010\nR\u001e\u0010#\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\b\"\u0004\b+\u0010\n¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$WikiInfo;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/bear/wikiv2/selector/RecentOperationResult$IRecentData;", "<init>", "()V", WikiFolderPushPlugin.WIKI_TOKEN, "", "getWikiToken", "()Ljava/lang/String;", "setWikiToken", "(Ljava/lang/String;)V", "objToken", "getObjToken", "setObjToken", "objType", "", "getObjType", "()I", "setObjType", "(I)V", "title", "getTitle", "setTitle", "spaceId", "getSpaceId", "setSpaceId", "spaceName", "getSpaceName", "setSpaceName", "objBizType", "getObjBizType", "setObjBizType", "wikiSpaceCreateUid", "getWikiSpaceCreateUid", "setWikiSpaceCreateUid", "wikiSpaceType", "getWikiSpaceType", "()Ljava/lang/Integer;", "setWikiSpaceType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "iconInfo", "getIconInfo", "setIconInfo", "iconRes", "context", "Landroid/content/Context;", "description", "external", "", ResourceData.KEY_TOKEN, ResourceData.KEY_TYPE, "isShareFolderWithOwner", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class WikiInfo implements Serializable, a {
        private String iconInfo;
        private int objBizType;
        private String objToken;
        private int objType;
        private String spaceId;
        private String spaceName;
        private String title;
        private String wikiSpaceCreateUid;
        private Integer wikiSpaceType;
        private String wikiToken;

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public boolean external() {
            return false;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public boolean isShareFolderWithOwner() {
            return false;
        }

        public int iconRes() {
            int r0 = this.objType;
            if (r0 != sbb.e.l.b) goto L6;
            return ua5.a.h(com.bytedance.ee.util.io.a.c(this.title));
        L6:
            return ua5.a.i(r0);
        }

        public final String spaceName() {
            Integer r0 = this.wikiSpaceType;
            if (r0 == null) goto L12;
            if (this.wikiSpaceCreateUid == null) goto L12;
            if (r0.intValue() != 2) goto L12;
            if (TextUtils.equals(this.wikiSpaceCreateUid, ((b0) org.koin.java.a.c(b0.class, null, null, 6)).getUid()) == false) goto L12;
            String r1 = eu5.b.a().getString(2131888790);
            Intrinsics.checkNotNull(r1);
            return r1;
        L12:
            return this.spaceName;
        }

        public WikiInfo() {
            this.wikiToken = "";
            this.objToken = "";
            this.title = "";
            this.spaceId = "";
            this.spaceName = "";
            this.objBizType = ObjBizType.WIKI.getType();
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public String description() {
            return spaceName();
        }

        public final String getIconInfo() {
            return this.iconInfo;
        }

        public final int getObjBizType() {
            return this.objBizType;
        }

        public final String getObjToken() {
            return this.objToken;
        }

        public final int getObjType() {
            return this.objType;
        }

        public final String getSpaceId() {
            return this.spaceId;
        }

        public final String getSpaceName() {
            return this.spaceName;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getWikiSpaceCreateUid() {
            return this.wikiSpaceCreateUid;
        }

        public final Integer getWikiSpaceType() {
            return this.wikiSpaceType;
        }

        public final String getWikiToken() {
            return this.wikiToken;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public String iconInfo() {
            return this.iconInfo;
        }

        public int objBizType() {
            return this.objBizType;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public String token() {
            return this.objToken;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public int type() {
            return this.objType;
        }

        public final void setIconInfo(String r1) {
            this.iconInfo = r1;
        }

        public final void setObjBizType(int r1) {
            this.objBizType = r1;
        }

        public final void setObjToken(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.objToken = r2;
        }

        public final void setObjType(int r1) {
            this.objType = r1;
        }

        public final void setSpaceId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.spaceId = r2;
        }

        public final void setSpaceName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.spaceName = r2;
        }

        public final void setTitle(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.title = r2;
        }

        public final void setWikiSpaceCreateUid(String r1) {
            this.wikiSpaceCreateUid = r1;
        }

        public final void setWikiSpaceType(Integer r1) {
            this.wikiSpaceType = r1;
        }

        public final void setWikiToken(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.wikiToken = r2;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.RecentOperationResult.a
        public String title(Context r2) {
            if (TextUtils.isEmpty(this.title) == false) goto L6;
            return t0.e(r2, this.objType);
        L6:
            return this.title;
        }
    }

    public interface a {
        String description();

        boolean external();

        String iconInfo();

        boolean isShareFolderWithOwner();

        String title(Context r1);

        String token();

        int type();
    }

    public RecentOperationResult() {
    }
}
