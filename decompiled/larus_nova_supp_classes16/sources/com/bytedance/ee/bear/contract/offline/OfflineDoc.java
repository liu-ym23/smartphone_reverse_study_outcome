package com.bytedance.ee.bear.contract.offline;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfflineDoc implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<OfflineDoc> CREATOR = null;
    public static final String DASH_DELIMITER = "_";
    private static final String OTHER = "other";
    private static final String TAB_OTHER = "tab_other";
    private boolean canPreloadIfFileOpen;
    private int downloadStatus;
    private String edit_time;
    private String edition_id;
    private String fakeToken;
    private String filepath;
    private int force_update;
    private String from_source;
    private int id;
    private boolean isWifiOnly;

    @JSONField(name = "is_wiki")
    private boolean isWiki;
    private String name;
    private String obj_token;
    private boolean onlyPreLoadFeed;
    private int owner_type;
    private long preloadManagerEnqueueTime;
    private int preload_priority;
    private String reqId;
    private String subFrom;
    private int syncPriority;
    private int syncState;
    private long taskManagerEnqueueTime;
    private String token;
    private long triggerTime;
    private int type;
    private String url;
    private DocWikiInfo wikiInfo;

    @JSONField(name = "wiki_space_id")
    private String wikiSpaceId;

    public class a implements Parcelable.Creator<OfflineDoc> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final OfflineDoc createFromParcel(Parcel r2) {
            return new OfflineDoc(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final OfflineDoc[] newArray(int r1) {
            return new OfflineDoc[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getObj_token() {
        DocWikiInfo r0 = this.wikiInfo;
        if (r0 == null) goto L7;
        return r0.getObj_token();
    L7:
        return this.obj_token;
    }

    public String getOriginToken() {
        DocWikiInfo r0 = this.wikiInfo;
        if (r0 == null) goto L7;
        return r0.getWiki_token();
    L7:
        return this.obj_token;
    }

    public String getToken() {
        DocWikiInfo r0 = this.wikiInfo;
        if (r0 == null) goto L7;
        return r0.getWiki_token();
    L7:
        return this.token;
    }

    public int hashCode() {
        int r1 = 0;
        if (TextUtils.isEmpty(this.token) == true) goto L10;
        int r0 = this.token.hashCode() * 31;
        String r2 = this.edition_id;
        if (r2 == null) goto L8;
        r1 = r2.hashCode();
    L8:
        return r0 + r1;
    L10:
        if (TextUtils.isEmpty(this.obj_token) == true) goto L14;
        return this.obj_token.hashCode();
    L14:
        if (TextUtils.isEmpty(this.fakeToken) == false) goto L16;
        return 0;
    L16:
        return this.fakeToken.hashCode();
    }

    public String toString() {
        return "OfflineDoc{id=" + this.id + ", syncPriority=" + this.syncPriority + ", preloadPriority=" + this.preload_priority + ", syncState=" + this.syncState + ", onlyPreLoadFeed=" + this.onlyPreLoadFeed + ", canPreloadIfFileOpen=" + this.canPreloadIfFileOpen + ", type=" + this.type + ", force_update=" + this.force_update + ", isWifiOnly=" + this.isWifiOnly + ", isWiki=" + this.isWiki + ", from_source=" + this.from_source + ", owner_type=" + this.owner_type + ", downloadStatus=" + this.downloadStatus + '}';
    }

    public OfflineDoc() {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = OTHER;
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
    }

    public OfflineDoc clone() {
        return (OfflineDoc) super.clone();
    L4:
        th = move-exception;
        tt5.a.f("offlinedoc", th, false);
        return null;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public String getEdit_time() {
        return this.edit_time;
    }

    public String getEdition_id() {
        return this.edition_id;
    }

    public String getFakeToken() {
        return this.fakeToken;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public int getForce_update() {
        return this.force_update;
    }

    public String getFrom_source() {
        return this.from_source;
    }

    public int getId() {
        return this.id;
    }

    public boolean getIs_wiki() {
        return this.isWiki;
    }

    public String getName() {
        return this.name;
    }

    public int getOwner_type() {
        return this.owner_type;
    }

    public long getPreloadManagerEnqueueTime() {
        return this.preloadManagerEnqueueTime;
    }

    public int getPreload_priority() {
        return this.preload_priority;
    }

    public String getReqId() {
        return this.reqId;
    }

    public String getSubFrom() {
        return this.subFrom;
    }

    public int getSyncPriority() {
        return this.syncPriority;
    }

    public int getSyncState() {
        return this.syncState;
    }

    public long getTaskManagerEnqueueTime() {
        return this.taskManagerEnqueueTime;
    }

    public long getTriggerTime() {
        return this.triggerTime;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public DocWikiInfo getWikiInfo() {
        return this.wikiInfo;
    }

    public String getWikiSpaceId() {
        return this.wikiSpaceId;
    }

    public boolean isCanPreloadIfFileOpen() {
        return this.canPreloadIfFileOpen;
    }

    public boolean isOnlyPreLoadFeed() {
        return this.onlyPreLoadFeed;
    }

    public boolean isWifiOnly() {
        return this.isWifiOnly;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m117clone() throws CloneNotSupportedException {
        return clone();
    }

    public OfflineDoc(Parcel r4) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        boolean r0 = false;
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = OTHER;
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.id = r4.readInt();
        this.fakeToken = r4.readString();
        this.filepath = r4.readString();
        this.wikiSpaceId = r4.readString();
        this.name = r4.readString();
        this.token = r4.readString();
        this.edit_time = r4.readString();
        this.obj_token = r4.readString();
        this.url = r4.readString();
        this.syncPriority = r4.readInt();
        this.syncState = r4.readInt();
        if (r4.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this.onlyPreLoadFeed = r1;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.canPreloadIfFileOpen = r2;
        this.type = r4.readInt();
        this.force_update = r4.readInt();
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.isWifiOnly = r3;
        if (r4.readByte() == 0) goto L17;
        r0 = true;
    L17:
        this.isWiki = r0;
        this.from_source = r4.readString();
        this.subFrom = r4.readString();
        this.owner_type = r4.readInt();
        return;
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfflineDoc) == false) goto L30;
        OfflineDoc r6 = (OfflineDoc) r5;
        if (TextUtils.isEmpty(this.obj_token) == true) goto L19;
        if (TextUtils.isEmpty(r6.obj_token) == true) goto L19;
        if (this.obj_token.equals(r6.obj_token) == true) goto L14;
    L16:
        return false;
    L14:
        if (Objects.equals(this.edition_id, r6.edition_id) == false) goto L16;
        return true;
    L19:
        if (TextUtils.isEmpty(this.fakeToken) == true) goto L25;
        if (TextUtils.isEmpty(r6.fakeToken) == true) goto L25;
        return this.fakeToken.equals(r6.fakeToken);
    L25:
        if (TextUtils.isEmpty(this.token) == true) goto L30;
        if (TextUtils.isEmpty(r6.token) == true) goto L30;
        return this.token.equals(r6.token);
    L30:
        return false;
    }

    public void setCanPreloadIfFileOpen(boolean r1) {
        this.canPreloadIfFileOpen = r1;
    }

    public void setDownloadStatus(int r1) {
        this.downloadStatus = r1;
    }

    public void setEdit_time(String r1) {
        this.edit_time = r1;
    }

    public void setEdition_id(String r1) {
        this.edition_id = r1;
    }

    public void setFakeToken(String r1) {
        this.fakeToken = r1;
    }

    public void setFilepath(String r1) {
        this.filepath = r1;
    }

    public void setForce_update(int r1) {
        this.force_update = r1;
    }

    public void setFrom_source(String r1) {
        this.from_source = r1;
    }

    public void setId(int r1) {
        this.id = r1;
    }

    public void setIsWiki(boolean r1) {
        this.isWiki = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setObj_token(String r1) {
        this.obj_token = r1;
    }

    public void setOnlyPreLoadFeed(boolean r1) {
        this.onlyPreLoadFeed = r1;
    }

    public void setOwner_type(int r1) {
        this.owner_type = r1;
    }

    public void setPreloadManagerEnqueueTime(long r1) {
        this.preloadManagerEnqueueTime = r1;
    }

    public void setPreload_priority(int r1) {
        this.preload_priority = r1;
    }

    public void setReqId(String r1) {
        this.reqId = r1;
    }

    public void setSubFrom(String r1) {
        this.subFrom = r1;
    }

    public void setSyncPriority(int r1) {
        this.syncPriority = r1;
    }

    public void setSyncState(int r1) {
        this.syncState = r1;
    }

    public void setTaskManagerEnqueueTime(long r1) {
        this.taskManagerEnqueueTime = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setTriggerTime(long r1) {
        this.triggerTime = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public void setWifiOnly(boolean r1) {
        this.isWifiOnly = r1;
    }

    public void setWikiInfo(DocWikiInfo r1) {
        this.wikiInfo = r1;
    }

    public void setWikiSpaceId(String r1) {
        this.wikiSpaceId = r1;
    }

    public OfflineDoc(String r4, int r5) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = OTHER;
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.token = r4;
        this.type = r5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.id);
        r1.writeString(this.fakeToken);
        r1.writeString(this.filepath);
        r1.writeString(this.wikiSpaceId);
        r1.writeString(this.name);
        r1.writeString(this.token);
        r1.writeString(this.edit_time);
        r1.writeString(this.obj_token);
        r1.writeString(this.url);
        r1.writeInt(this.syncPriority);
        r1.writeInt(this.syncState);
        r1.writeByte(this.onlyPreLoadFeed ? 1 : 0);
        r1.writeByte(this.canPreloadIfFileOpen ? 1 : 0);
        r1.writeInt(this.type);
        r1.writeInt(this.force_update);
        r1.writeByte(this.isWifiOnly ? 1 : 0);
        r1.writeByte(this.isWiki ? 1 : 0);
        r1.writeString(this.from_source);
        r1.writeString(this.subFrom);
        r1.writeInt(this.owner_type);
    }

    public OfflineDoc(String r4, String r5, int r6, String r7) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = OTHER;
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.obj_token = r4;
        this.url = r5;
        this.type = r6;
        this.from_source = r7;
    }

    public OfflineDoc(String r4, String r5, int r6, String r7, int r8) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = OTHER;
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.obj_token = r4;
        this.url = r5;
        this.type = r6;
        this.force_update = r8;
        this.from_source = r7;
    }

    public OfflineDoc(String r4, String r5, int r6, String r7, boolean r8) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = OTHER;
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.obj_token = r4;
        this.url = r5;
        this.type = r6;
        this.isWifiOnly = r8;
        this.from_source = r7;
    }

    public OfflineDoc(String r4, String r5, String r6, int r7, int r8) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = OTHER;
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.obj_token = r4;
        this.url = r6;
        this.syncPriority = r7;
        this.fakeToken = r5;
        this.type = r8;
    }
}
