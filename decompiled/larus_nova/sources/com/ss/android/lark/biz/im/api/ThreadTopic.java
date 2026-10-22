package com.ss.android.lark.biz.im.api;

import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.Channel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public class ThreadTopic implements Serializable, y28.b<ThreadTopic> {
    private Long aiChatModeId;
    private String anonymousId;
    private String avatarKey;
    private int badgeCount;
    private Channel channel;
    private long filterRankTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f409897id;
    private boolean isAnonymousEnable;
    private boolean isBadged;
    private boolean isFollow;
    private Boolean isMock;
    private boolean isNoTraceDelete;
    private boolean isRemind;
    private boolean isVisible;
    private String lastMsgId;
    private int lastMsgPos;
    private int lastMsgPosBadgeCount;
    private List<String> lastReplyIds;
    private String lastVisibleMsgId;
    private int lastVisibleMsgPos;
    private List<String> latestAtMessageIds;
    private int originBadgeCount;
    private String ownerId;
    private int position;
    private int readPos;
    private int readPosBadgeCount;
    private int replyCount;
    private String rootMsgId;
    private SceneInfo sceneInfo;
    private ThreadStateInfo stateInfo;
    private String subTitle;
    private String topic;
    private long updateTime;

    public String toString() {
        return "id:" + this.f409897id + ", lastMsgPos:" + this.lastMsgPos + ", readMsgPos:" + this.readPos + ", lastMsgBadgeCount:" + this.lastMsgPosBadgeCount + ", readBadgeCount:" + this.readPosBadgeCount + ",isFollow:" + this.isFollow + ", replyCount" + this.replyCount + ", isMock: " + this.isMock + ", aiChatModeId: " + this.aiChatModeId;
    }

    public ThreadTopic() {
        this.topic = "";
        this.rootMsgId = "";
        this.lastMsgId = "";
    }

    public Long getAIChatModeId() {
        return this.aiChatModeId;
    }

    public String getAnonymousId() {
        return this.anonymousId;
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public int getBadgeCount() {
        return this.badgeCount;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public long getFilterRankTime() {
        return this.filterRankTime;
    }

    public String getId() {
        return this.f409897id;
    }

    public String getLastMsgId() {
        return this.lastMsgId;
    }

    public int getLastMsgPos() {
        return this.lastMsgPos;
    }

    public int getLastMsgPosBadgeCount() {
        return this.lastMsgPosBadgeCount;
    }

    public List<String> getLastReplyIds() {
        return this.lastReplyIds;
    }

    public String getLastVisibleMsgId() {
        return this.lastVisibleMsgId;
    }

    public int getLastVisibleMsgPos() {
        return this.lastVisibleMsgPos;
    }

    public List<String> getLatestAtMessageIds() {
        return this.latestAtMessageIds;
    }

    public int getOriginBadgeCount() {
        return this.originBadgeCount;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public int getPosition() {
        return this.position;
    }

    public int getReadPos() {
        return this.readPos;
    }

    public int getReadPosBadgeCount() {
        return this.readPosBadgeCount;
    }

    public int getReplyCount() {
        return this.replyCount;
    }

    public String getRootMsgId() {
        return this.rootMsgId;
    }

    public SceneInfo getSceneInfo() {
        return this.sceneInfo;
    }

    public ThreadStateInfo getStateInfo() {
        return this.stateInfo;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTopic() {
        return this.topic;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isAnonymousEnable() {
        return this.isAnonymousEnable;
    }

    public boolean isBadged() {
        return this.isBadged;
    }

    public boolean isFollow() {
        return this.isFollow;
    }

    public Boolean isMock() {
        return this.isMock;
    }

    public boolean isNoTraceDelete() {
        return this.isNoTraceDelete;
    }

    public boolean isRemind() {
        return this.isRemind;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public boolean isContentSame(ThreadTopic r100) {
        if (this.replyCount == r100.replyCount) goto L6;
        return false;
    L6:
        if (this.isFollow == r100.isFollow) goto L9;
        return false;
    L9:
        if (this.isNoTraceDelete == r100.isNoTraceDelete) goto L12;
        return false;
    L12:
        if (Objects.equals(this.avatarKey, r100.avatarKey) == true) goto L15;
        return false;
    L15:
        if (this.filterRankTime == r100.filterRankTime) goto L18;
        return false;
    L18:
        if (y28.a.c(this.stateInfo, r100.stateInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public boolean isItemSame(ThreadTopic r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        return Objects.equals(this.f409897id, r100.getId());
    }

    public boolean isSameOnPush(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThreadTopic) == true) goto L8;
        return false;
    L8:
        ThreadTopic r101 = (ThreadTopic) r100;
        if (r101.isContentSame(this) == true) goto L12;
        return false;
    L12:
        if (r101.getLastMsgPos() == getLastMsgPos()) goto L15;
        return false;
    L15:
        if (r101.getLastMsgPosBadgeCount() == getLastMsgPosBadgeCount()) goto L18;
        return false;
    L18:
        if (r101.getReadPos() == getReadPos()) goto L21;
        return false;
    L21:
        if (r101.getReadPosBadgeCount() == getReadPosBadgeCount()) goto L24;
        return false;
    L24:
        if (r101.getLastVisibleMsgPos() == getLastVisibleMsgPos()) goto L27;
        return false;
    L27:
        if (Objects.equals(r101.getLastReplyIds(), getLastReplyIds()) == true) goto L30;
        return false;
    L30:
        if (r101.getBadgeCount() == getBadgeCount()) goto L32;
    L40:
        return false;
    L32:
        if (r101.isVisible() != isVisible()) goto L40;
        if (r101.isBadged() != isBadged()) goto L40;
        if (r101.getOriginBadgeCount() != getOriginBadgeCount()) goto L40;
        if (r101.isRemind() != isRemind()) goto L40;
        return true;
    }

    public void setAIChatModeId(Long r100) {
        this.aiChatModeId = r100;
    }

    public void setAnonymousEnable(boolean r100) {
        this.isAnonymousEnable = r100;
    }

    public void setAnonymousId(String r100) {
        this.anonymousId = r100;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setBadgeCount(int r100) {
        this.badgeCount = r100;
    }

    public void setBadged(boolean r100) {
        this.isBadged = r100;
    }

    public void setChannel(Channel r100) {
        this.channel = r100;
    }

    public void setFilterRankTime(long r100) {
        this.filterRankTime = r100;
    }

    public void setFollow(boolean r100) {
        this.isFollow = r100;
    }

    public void setId(String r100) {
        this.f409897id = r100;
    }

    public void setLastMsgId(String r100) {
        this.lastMsgId = r100;
    }

    public void setLastMsgPos(int r100) {
        this.lastMsgPos = r100;
    }

    public void setLastMsgPosBadgeCount(int r100) {
        this.lastMsgPosBadgeCount = r100;
    }

    public void setLastReplyIds(List<String> r100) {
        ArrayList r101 = new ArrayList(r100);
        if (CollectionUtils.isNotEmpty(r101) == false) goto L5;
        Collections.reverse(r101);
    L5:
        this.lastReplyIds = r101;
    }

    public void setLastVisibleMsgId(String r100) {
        this.lastVisibleMsgId = r100;
    }

    public void setLastVisibleMsgPos(int r100) {
        this.lastVisibleMsgPos = r100;
    }

    public void setLatestAtMessageIds(List<String> r100) {
        ArrayList r101 = new ArrayList(r100);
        if (CollectionUtils.isNotEmpty(r101) == false) goto L5;
        Collections.reverse(r101);
    L5:
        this.latestAtMessageIds = r101;
    }

    public void setMock(Boolean r100) {
        this.isMock = r100;
    }

    public void setNoTraceDelete(boolean r100) {
        this.isNoTraceDelete = r100;
    }

    public void setOriginBadgeCount(int r100) {
        this.originBadgeCount = r100;
    }

    public void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }

    public void setReadPos(int r100) {
        this.readPos = r100;
    }

    public void setReadPosBadgeCount(int r100) {
        this.readPosBadgeCount = r100;
    }

    public void setRemind(boolean r100) {
        this.isRemind = r100;
    }

    public void setReplyCount(int r100) {
        this.replyCount = r100;
    }

    public void setRootMsgId(String r100) {
        this.rootMsgId = r100;
    }

    public void setSceneInfo(SceneInfo r100) {
        this.sceneInfo = r100;
    }

    public void setStateInfo(ThreadStateInfo r100) {
        this.stateInfo = r100;
    }

    public void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public void setTopic(String r100) {
        this.topic = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public void setVisible(boolean r100) {
        this.isVisible = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((ThreadTopic) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((ThreadTopic) r100);
    }
}
