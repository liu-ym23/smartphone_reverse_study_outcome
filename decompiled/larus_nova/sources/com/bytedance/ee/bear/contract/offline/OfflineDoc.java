package com.bytedance.ee.bear.contract.offline;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f217120id;
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
        public final OfflineDoc createFromParcel(Parcel r100) {
            return new OfflineDoc(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final OfflineDoc[] newArray(int r100) {
            return new OfflineDoc[r100];
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
        DocWikiInfo r100 = this.wikiInfo;
        if (r100 == null) goto L7;
        return r100.getObj_token();
    L7:
        return this.obj_token;
    }

    public String getOriginToken() {
        DocWikiInfo r100 = this.wikiInfo;
        if (r100 == null) goto L7;
        return r100.getWiki_token();
    L7:
        return this.obj_token;
    }

    public String getToken() {
        DocWikiInfo r100 = this.wikiInfo;
        if (r100 == null) goto L7;
        return r100.getWiki_token();
    L7:
        return this.token;
    }

    public int hashCode() {
        int r100 = 0;
        if (TextUtils.isEmpty(this.token) == true) goto L10;
        int r101 = this.token.hashCode() * 31;
        String r102 = this.edition_id;
        if (r102 == null) goto L8;
        r100 = r102.hashCode();
    L8:
        return r101 + r100;
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
        return "OfflineDoc{id=" + this.f217120id + ", syncPriority=" + this.syncPriority + ", preloadPriority=" + this.preload_priority + ", syncState=" + this.syncState + ", onlyPreLoadFeed=" + this.onlyPreLoadFeed + ", canPreloadIfFileOpen=" + this.canPreloadIfFileOpen + ", type=" + this.type + ", force_update=" + this.force_update + ", isWifiOnly=" + this.isWifiOnly + ", isWiki=" + this.isWiki + ", from_source=" + this.from_source + ", owner_type=" + this.owner_type + ", downloadStatus=" + this.downloadStatus + '}';
    }

    public OfflineDoc() {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = "other";
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
        return this.f217120id;
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
    public /* bridge */ /* synthetic */ Object m8324clone() throws CloneNotSupportedException {
        return clone();
    }

    public OfflineDoc(Parcel r100) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        boolean r101 = false;
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = "other";
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.f217120id = r100.readInt();
        this.fakeToken = r100.readString();
        this.filepath = r100.readString();
        this.wikiSpaceId = r100.readString();
        this.name = r100.readString();
        this.token = r100.readString();
        this.edit_time = r100.readString();
        this.obj_token = r100.readString();
        this.url = r100.readString();
        this.syncPriority = r100.readInt();
        this.syncState = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.onlyPreLoadFeed = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.canPreloadIfFileOpen = r103;
        this.type = r100.readInt();
        this.force_update = r100.readInt();
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.isWifiOnly = r104;
        if (r100.readByte() == 0) goto L17;
        r101 = true;
    L17:
        this.isWiki = r101;
        this.from_source = r100.readString();
        this.subFrom = r100.readString();
        this.owner_type = r100.readInt();
        return;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfflineDoc) == false) goto L30;
        OfflineDoc r101 = (OfflineDoc) r100;
        if (TextUtils.isEmpty(this.obj_token) == true) goto L19;
        if (TextUtils.isEmpty(r101.obj_token) == true) goto L19;
        if (this.obj_token.equals(r101.obj_token) == true) goto L14;
    L16:
        return false;
    L14:
        if (Objects.equals(this.edition_id, r101.edition_id) == false) goto L16;
        return true;
    L19:
        if (TextUtils.isEmpty(this.fakeToken) == true) goto L25;
        if (TextUtils.isEmpty(r101.fakeToken) == true) goto L25;
        return this.fakeToken.equals(r101.fakeToken);
    L25:
        if (TextUtils.isEmpty(this.token) == true) goto L30;
        if (TextUtils.isEmpty(r101.token) == true) goto L30;
        return this.token.equals(r101.token);
    L30:
        return false;
    }

    public void setCanPreloadIfFileOpen(boolean r100) {
        this.canPreloadIfFileOpen = r100;
    }

    public void setDownloadStatus(int r100) {
        this.downloadStatus = r100;
    }

    public void setEdit_time(String r100) {
        this.edit_time = r100;
    }

    public void setEdition_id(String r100) {
        this.edition_id = r100;
    }

    public void setFakeToken(String r100) {
        this.fakeToken = r100;
    }

    public void setFilepath(String r100) {
        this.filepath = r100;
    }

    public void setForce_update(int r100) {
        this.force_update = r100;
    }

    public void setFrom_source(String r100) {
        this.from_source = r100;
    }

    public void setId(int r100) {
        this.f217120id = r100;
    }

    public void setIsWiki(boolean r100) {
        this.isWiki = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setObj_token(String r100) {
        this.obj_token = r100;
    }

    public void setOnlyPreLoadFeed(boolean r100) {
        this.onlyPreLoadFeed = r100;
    }

    public void setOwner_type(int r100) {
        this.owner_type = r100;
    }

    public void setPreloadManagerEnqueueTime(long r100) {
        this.preloadManagerEnqueueTime = r100;
    }

    public void setPreload_priority(int r100) {
        this.preload_priority = r100;
    }

    public void setReqId(String r100) {
        this.reqId = r100;
    }

    public void setSubFrom(String r100) {
        this.subFrom = r100;
    }

    public void setSyncPriority(int r100) {
        this.syncPriority = r100;
    }

    public void setSyncState(int r100) {
        this.syncState = r100;
    }

    public void setTaskManagerEnqueueTime(long r100) {
        this.taskManagerEnqueueTime = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setTriggerTime(long r100) {
        this.triggerTime = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setWifiOnly(boolean r100) {
        this.isWifiOnly = r100;
    }

    public void setWikiInfo(DocWikiInfo r100) {
        this.wikiInfo = r100;
    }

    public void setWikiSpaceId(String r100) {
        this.wikiSpaceId = r100;
    }

    public OfflineDoc(String r100, int r101) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = "other";
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.token = r100;
        this.type = r101;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f217120id);
        r100.writeString(this.fakeToken);
        r100.writeString(this.filepath);
        r100.writeString(this.wikiSpaceId);
        r100.writeString(this.name);
        r100.writeString(this.token);
        r100.writeString(this.edit_time);
        r100.writeString(this.obj_token);
        r100.writeString(this.url);
        r100.writeInt(this.syncPriority);
        r100.writeInt(this.syncState);
        r100.writeByte(this.onlyPreLoadFeed ? 1 : 0);
        r100.writeByte(this.canPreloadIfFileOpen ? 1 : 0);
        r100.writeInt(this.type);
        r100.writeInt(this.force_update);
        r100.writeByte(this.isWifiOnly ? 1 : 0);
        r100.writeByte(this.isWiki ? 1 : 0);
        r100.writeString(this.from_source);
        r100.writeString(this.subFrom);
        r100.writeInt(this.owner_type);
    }

    public OfflineDoc(String r100, String r101, int r102, String r103) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = "other";
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.obj_token = r100;
        this.url = r101;
        this.type = r102;
        this.from_source = r103;
    }

    public OfflineDoc(String r100, String r101, int r102, String r103, int r104) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = "other";
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.obj_token = r100;
        this.url = r101;
        this.type = r102;
        this.force_update = r104;
        this.from_source = r103;
    }

    public OfflineDoc(String r100, String r101, int r102, String r103, boolean r104) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = "other";
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.obj_token = r100;
        this.url = r101;
        this.type = r102;
        this.isWifiOnly = r104;
        this.from_source = r103;
    }

    public OfflineDoc(String r100, String r101, String r102, int r103, int r104) {
        this.syncPriority = OfflineDocsPriority.Low_Priority.ordinal();
        this.force_update = 0;
        this.isWifiOnly = false;
        this.from_source = TAB_OTHER;
        this.subFrom = "other";
        this.onlyPreLoadFeed = false;
        this.canPreloadIfFileOpen = false;
        this.preload_priority = OfflineDocsPriority.Middle_Priority.ordinal();
        this.triggerTime = -1;
        this.downloadStatus = 0;
        this.obj_token = r100;
        this.url = r102;
        this.syncPriority = r103;
        this.fakeToken = r101;
        this.type = r104;
    }
}
