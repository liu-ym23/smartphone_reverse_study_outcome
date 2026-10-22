package com.bytedance.ee.bear.document.synced.block.references.entity;

import a45.a;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0003/01B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010.\u001a\u00020\u000eH\u0016R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "references", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$References;", "Lkotlin/collections/ArrayList;", "getReferences", "()Ljava/util/ArrayList;", "setReferences", "(Ljava/util/ArrayList;)V", "bp", "", "getBp", "()Ljava/lang/String;", "setBp", "(Ljava/lang/String;)V", "noPermissionCount", "", "getNoPermissionCount", "()I", "setNoPermissionCount", "(I)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "totalCount", "getTotalCount", "setTotalCount", "host", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$Host;", "getHost", "()Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$Host;", "setHost", "(Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$Host;)V", "parent", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$Parent;", "getParent", "()Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$Parent;", "setParent", "(Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$Parent;)V", "toString", "References", "Host", "Parent", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocReferencesResult implements Serializable, NonProguard {
    private String bp;

    @SerializedName("has_more")
    private boolean hasMore;
    private Host host;

    @SerializedName("no_permission_count")
    private int noPermissionCount;
    private Parent parent;
    private ArrayList<References> references;

    @SerializedName("total_count")
    private int totalCount;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$Host;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "permitted", "", "getPermitted", "()Z", "setPermitted", "(Z)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Host implements Serializable, NonProguard {
        private boolean permitted;
        private String title;
        private String url;

        public Host() {
        }

        public final boolean getPermitted() {
            return this.permitted;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setPermitted(boolean r1) {
            this.permitted = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }

        public final void setUrl(String r1) {
            this.url = r1;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$Parent;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "permitted", "", "getPermitted", "()Z", "setPermitted", "(Z)V", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Parent implements Serializable, NonProguard {
        private boolean permitted;
        private String title;
        private String url;

        public Parent() {
        }

        public final boolean getPermitted() {
            return this.permitted;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setPermitted(boolean r1) {
            this.permitted = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }

        public final void setUrl(String r1) {
            this.url = r1;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010%\u001a\u00020&H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000b¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult$References;", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/IReferencesModel;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "createTime", "", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "objId", "getObjId", "setObjId", "title", "getTitle", "setTitle", "permitted", "", "getPermitted", "()Z", "setPermitted", "(Z)V", "tagFirst", "getTagFirst", "setTagFirst", "tagSecond", "getTagSecond", "setTagSecond", "type", "", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class References implements Serializable, NonProguard, a {

        @SerializedName("create_time")
        private Long createTime;

        @SerializedName("obj_id")
        private String objId;
        private boolean permitted;
        private transient String tagFirst;
        private transient String tagSecond;
        private String title;
        private String url;

        public References() {
        }

        @Override // a45.a
        public int type() {
            return 0;
        }

        public final Long getCreateTime() {
            return this.createTime;
        }

        public final String getObjId() {
            return this.objId;
        }

        public final boolean getPermitted() {
            return this.permitted;
        }

        public final String getTagFirst() {
            return this.tagFirst;
        }

        public final String getTagSecond() {
            return this.tagSecond;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setCreateTime(Long r1) {
            this.createTime = r1;
        }

        public final void setObjId(String r1) {
            this.objId = r1;
        }

        public final void setPermitted(boolean r1) {
            this.permitted = r1;
        }

        public final void setTagFirst(String r1) {
            this.tagFirst = r1;
        }

        public final void setTagSecond(String r1) {
            this.tagSecond = r1;
        }

        public final void setTitle(String r1) {
            this.title = r1;
        }

        public final void setUrl(String r1) {
            this.url = r1;
        }
    }

    public DocReferencesResult() {
    }

    public String toString() {
        return "DocReferencesResult(bp=" + this.bp + ", no_permission_count=" + this.noPermissionCount + ", has_more=" + this.hasMore + ", total_count=" + this.totalCount + ')';
    }

    public final String getBp() {
        return this.bp;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final Host getHost() {
        return this.host;
    }

    public final int getNoPermissionCount() {
        return this.noPermissionCount;
    }

    public final Parent getParent() {
        return this.parent;
    }

    public final ArrayList<References> getReferences() {
        return this.references;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final void setBp(String r1) {
        this.bp = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setHost(Host r1) {
        this.host = r1;
    }

    public final void setNoPermissionCount(int r1) {
        this.noPermissionCount = r1;
    }

    public final void setParent(Parent r1) {
        this.parent = r1;
    }

    public final void setReferences(ArrayList<References> r1) {
        this.references = r1;
    }

    public final void setTotalCount(int r1) {
        this.totalCount = r1;
    }
}
