package kc2;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.r;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import vh7.e;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends c implements r {
    public static final int UPDATE_FIELD_CONTENT = 8;
    public static final int UPDATE_FIELD_MESSAGE_ID = 4;
    public static final int UPDATE_FIELD_NONE = 0;
    public static final int UPDATE_FIELD_READ_STATUS = 2;
    public static final int UPDATE_FIELD_SEND_STATUS = 1;
    public static final int UPDATE_FIELD_USER_INFO = 16;
    public long audioDuration;
    public String audioPath;
    public String audioUrl;
    public String content;
    public boolean isResend;
    private MessageIdentity messageIdentity;
    public transient String msgId;
    public IPublicAreaCommon publicAreaCommon;
    public int readStatus;
    private a5 rtfContent;
    public int sendStatus;
    public int updateField;
    public String updatePath;
    public IBaseUser userInfo;

    @Override // com.bytedance.android.live.base.model.message.r, vh7.c
    public <R extends e<r>> R castTo(Class<R> r100) {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.r, vh7.c
    public <R extends e<r>> R castToOrNull(Class<R> r100) {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.t
    public byte[] getRawPayload() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.r, com.bytedance.android.live.base.model.message.u3
    public IBaseUser getUserInMessage() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void isAnchorAsrResult(boolean r100) {
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public boolean isAnchorAsrResult() {
        return false;
    }

    @Override // com.bytedance.android.live.base.model.message.r, com.bytedance.android.live.base.model.message.u3
    public IPublicAreaCommon getOrInitPublicAreaCommon() {
        if (this.publicAreaCommon != null) goto L6;
        this.publicAreaCommon = (IPublicAreaCommon) f.c(IPublicAreaCommon.class);
    L6:
        return this.publicAreaCommon;
    }

    public a() {
        this.updateField = 0;
        this.userInfo = null;
        this.messageIdentity = null;
        this.rtfContent = null;
        this.sendStatus = 0;
        this.readStatus = 0;
        setMessageMethod("WebcastAudioChatMessage");
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public long getAudioDuration() {
        return this.audioDuration;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public String getAudioPath() {
        return this.audioPath;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public String getAudioUrl() {
        return this.audioUrl;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public String getChatContent() {
        return this.content;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public String getContent() {
        return this.content;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public MessageIdentity getMessageIdentity() {
        return this.messageIdentity;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public String getMsgId() {
        return this.msgId;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public int getReadStatus() {
        return this.readStatus;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public a5 getRtfContent() {
        return this.rtfContent;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public int getSendStatus() {
        return this.sendStatus;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public IBaseUser getUserInfo() {
        return this.userInfo;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void setAudioDuration(long r100) {
        this.audioDuration = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void setAudioPath(String r100) {
        this.audioPath = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void setAudioUrl(String r100) {
        this.audioUrl = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void setContent(String r100) {
        this.content = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void setMessageIdentity(MessageIdentity r100) {
        this.messageIdentity = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void setMsgId(String r100) {
        this.msgId = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void setReadStatus(int r100) {
        this.readStatus = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void setRtfContent(a5 r100) {
        this.rtfContent = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void setSendStatus(int r100) {
        this.sendStatus = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r
    public void setUserInfo(IBaseUser r100) {
        this.userInfo = r100;
    }
}
