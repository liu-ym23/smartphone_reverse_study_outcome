package com.ss.android.lark.feed.shared.data.preview;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.TagData;
import com.bytedance.lark.pb.feed.v1.Digest;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.ss.android.lark.biz.im.api.MuteUrgentInfo;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import ieb.a;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public class FeedPreview extends UIFeedCard implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient LarkNameTag f421142a;
    private int atInfoCount;
    private String customStatusIconKey;
    private List<DigestElement> draftDigestMessage;
    private boolean isCustomer;
    private boolean isDelayed;
    private boolean isDisplayedInDelayedFeed;
    private boolean isSimpleTenant;
    private boolean isTranslateEmojiCode;
    private String lastMessageId;
    private int lastMessagePosition;
    private String markText;
    private MuteUrgentInfo muteUrgentInfo;
    private Digest originDigest;
    private TagData tagData;

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(isRemind()), Boolean.valueOf(this.isShortCutFeed), Integer.valueOf(this.lastMessagePosition), this.lastMessageId, this.markText, Boolean.valueOf(this.isDelayed), Boolean.valueOf(this.isFlag), Boolean.valueOf(this.isDisplayedInDelayedFeed), this.muteUrgentInfo, Integer.valueOf(this.atInfoCount), Boolean.valueOf(this.isCustomer), Boolean.valueOf(this.isSimpleTenant), Boolean.valueOf(this.isTranslateEmojiCode), this.f421142a, this.customStatusIconKey});
    }

    public FeedPreview() {
        this.isTranslateEmojiCode = false;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public FeedPreview clone() throws CloneNotSupportedException {
        FeedPreview r100 = (FeedPreview) super.clone();
        r100.originDigest = this.originDigest;
        r100.lastMessagePosition = this.lastMessagePosition;
        r100.lastMessageId = this.lastMessageId;
        r100.markText = this.markText;
        r100.isDelayed = this.isDelayed;
        r100.isDisplayedInDelayedFeed = this.isDisplayedInDelayedFeed;
        r100.muteUrgentInfo = this.muteUrgentInfo;
        r100.atInfoCount = this.atInfoCount;
        r100.isCustomer = this.isCustomer;
        r100.isSimpleTenant = this.isSimpleTenant;
        r100.tagData = this.tagData;
        r100.isTranslateEmojiCode = this.isTranslateEmojiCode;
        r100.draftDigestMessage = this.draftDigestMessage;
        r100.f421142a = this.f421142a;
        r100.customStatusIconKey = this.customStatusIconKey;
        return r100;
    }

    @Override // ieb.a
    public int getJumpPriority() {
        if (isRemind() == false) goto L9;
        if (getUnreadCount() <= 0) goto L9;
        return 2;
    L9:
        if (isRemind() == false) goto L11;
        return 0;
    L11:
        if (getUnreadCount() <= 0) goto L16;
        return 1;
    L16:
        return 0;
    }

    public boolean isHeaderData() {
        if (getRankPriority() > 35) goto L5;
        return true;
    L5:
        return false;
    }

    public int getAtInfoCount() {
        return this.atInfoCount;
    }

    public String getCustomStatusIconKey() {
        return this.customStatusIconKey;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public List<DigestElement> getDraftDigestMessage() {
        return this.draftDigestMessage;
    }

    public LarkNameTag getFeedNameTag() {
        return this.f421142a;
    }

    public String getLastMessageId() {
        return this.lastMessageId;
    }

    public int getLastMessagePosition() {
        return this.lastMessagePosition;
    }

    public String getMarkText() {
        return this.markText;
    }

    public MuteUrgentInfo getMuteUrgentInfo() {
        return this.muteUrgentInfo;
    }

    public Digest getOriginDigest() {
        return this.originDigest;
    }

    public TagData getTagData() {
        return this.tagData;
    }

    public boolean isCustomer() {
        return this.isCustomer;
    }

    public boolean isDelayed() {
        return this.isDelayed;
    }

    public boolean isDisplayedInDelayedFeed() {
        return this.isDisplayedInDelayedFeed;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean isFlag() {
        return this.isFlag;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard, com.ss.android.lark.feed.app.entity.IBadgeable
    public boolean isRemind() {
        return this.isRemind;
    }

    public boolean isSimpleTenant() {
        return this.isSimpleTenant;
    }

    public boolean isTranslateEmojiCode() {
        return this.isTranslateEmojiCode;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public /* bridge */ /* synthetic */ UIFeedCard clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo8637clone() throws CloneNotSupportedException {
        return clone();
    }

    public FeedPreview(FeedPreview r100) {
        super(r100);
        this.isTranslateEmojiCode = false;
        setId(r100.getId());
        setFeedType(r100.getFeedType());
        setType(r100.getType());
        setDisplayTime(r100.getDisplayTime());
        setRankTime(r100.getRankTime());
        setUid(r100.getUid());
        setCheckUser(r100.isCheckUser());
        setAvatarKey(r100.getAvatarKey());
        setRemind(r100.isRemind());
        setShortCut(r100.isShortCut());
        setOriginDigest(r100.getOriginDigest());
        setMarkText(r100.getMarkText());
        setMuteUrgentInfo(r100.muteUrgentInfo);
        setAtInfoCount(r100.atInfoCount);
        setDelayed(r100.isDelayed());
        setFlag(r100.isFlag());
        setDisplayedInDelayedFeed(r100.isDisplayedInDelayedFeed());
        setTranslateEmojiCode(r100.isTranslateEmojiCode());
        setFeedNameTag(r100.getFeedNameTag());
        setCustomStatusIconKey(r100.getCustomStatusIconKey());
        setMuteNoticeType(r100.getMuteNoticeType());
        setRedBadge(r100.isRedBadge());
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L46:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L46;
        if (super.equals(r100) == true) goto L13;
        return false;
    L13:
        FeedPreview r101 = (FeedPreview) r100;
        if (this.isShortCutFeed == r101.isShortCutFeed) goto L16;
    L44:
        return false;
    L16:
        if (this.lastMessagePosition != r101.lastMessagePosition) goto L44;
        if (this.isDelayed != r101.isDelayed) goto L44;
        if (this.isFlag != r101.isFlag) goto L44;
        if (this.isDisplayedInDelayedFeed != r101.isDisplayedInDelayedFeed) goto L44;
        if (this.atInfoCount != r101.atInfoCount) goto L44;
        if (this.isCustomer != r101.isCustomer) goto L44;
        if (this.isSimpleTenant != r101.isSimpleTenant) goto L44;
        if (this.isTranslateEmojiCode != r101.isTranslateEmojiCode) goto L44;
        if (Objects.equals(this.lastMessageId, r101.lastMessageId) == false) goto L44;
        if (Objects.equals(this.markText, r101.markText) == false) goto L44;
        if (Objects.equals(this.muteUrgentInfo, r101.muteUrgentInfo) == false) goto L44;
        if (Objects.equals(this.f421142a, r101.f421142a) == false) goto L44;
        if (Objects.equals(this.customStatusIconKey, r101.customStatusIconKey) == false) goto L44;
        if (super.equals(r100) == false) goto L44;
        return true;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public boolean exactlyCompare(Object r100) {
        if ((r100 instanceof FeedPreview) == true) goto L5;
        return false;
    L5:
        if (this != r100) goto L8;
        return true;
    L8:
        FeedPreview r101 = (FeedPreview) r100;
        if (TextUtils.equals(this.markText, r101.markText) == true) goto L12;
        return false;
    L12:
        if (this.muteUrgentInfo == r101.muteUrgentInfo) goto L15;
        return false;
    L15:
        if (this.isCustomer == r101.isCustomer) goto L18;
        return false;
    L18:
        if (this.isDelayed == r101.isDelayed()) goto L21;
        return false;
    L21:
        if (this.isFlag == r101.isFlag()) goto L24;
        return false;
    L24:
        if (this.isDisplayedInDelayedFeed == r101.isDisplayedInDelayedFeed()) goto L27;
        return false;
    L27:
        if (r101.isTranslateEmojiCode == this.isTranslateEmojiCode) goto L30;
        return false;
    L30:
        if (TextUtils.equals(this.customStatusIconKey, r101.customStatusIconKey) == true) goto L33;
        return false;
    L33:
        if (Objects.equals(this.f421142a, r101.f421142a) == true) goto L36;
        return false;
    L36:
        return super.exactlyCompare(r100);
    }

    public void setAtInfoCount(int r100) {
        this.atInfoCount = r100;
    }

    public void setCustomStatusIconKey(String r100) {
        this.customStatusIconKey = r100;
    }

    public void setCustomer(boolean r100) {
        this.isCustomer = r100;
    }

    public void setDelayed(boolean r100) {
        this.isDelayed = r100;
    }

    public void setDisplayedInDelayedFeed(boolean r100) {
        this.isDisplayedInDelayedFeed = r100;
    }

    public void setFeedNameTag(LarkNameTag r100) {
        this.f421142a = r100;
    }

    @Override // com.ss.android.lark.feed.app.entity.UIFeedCard
    public void setFlag(boolean r100) {
        this.isFlag = r100;
    }

    public void setLastMessageId(String r100) {
        this.lastMessageId = r100;
    }

    public void setLastMessagePosition(int r100) {
        this.lastMessagePosition = r100;
    }

    public void setMarkText(String r100) {
        this.markText = r100;
    }

    public void setMuteUrgentInfo(MuteUrgentInfo r100) {
        this.muteUrgentInfo = r100;
    }

    public void setOriginDigest(Digest r100) {
        this.originDigest = r100;
    }

    public void setSimpleTenant(boolean r100) {
        this.isSimpleTenant = r100;
    }

    public void setTagData(TagData r100) {
        this.tagData = r100;
    }

    public void setTranslateEmojiCode(boolean r100) {
        this.isTranslateEmojiCode = r100;
    }
}
