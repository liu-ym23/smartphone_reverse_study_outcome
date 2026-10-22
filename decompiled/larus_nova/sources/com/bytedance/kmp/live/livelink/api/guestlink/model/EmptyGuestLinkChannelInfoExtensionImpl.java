package com.bytedance.kmp.live.livelink.api.guestlink.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.message.guestlink.k;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010<\u001a\u00020\u0002¢\u0006\u0004\b=\u0010>J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u001c\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR8\u0010%\u001a\u001e\u0012\b\u0012\u00060\u001ej\u0002`\u001f\u0018\u00010\u001dj\u000e\u0012\b\u0012\u00060\u001ej\u0002`\u001f\u0018\u0001` 8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010(\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR0\u0010,\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020)\u0018\u0001` 8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\u001c\u0010/\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR\u001e\u00105\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00108\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR\u001c\u0010;\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000f¨\u0006?"}, d2 = {"Lcom/bytedance/kmp/live/livelink/api/guestlink/model/EmptyGuestLinkChannelInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/base/model/message/guestlink/a;", "Lpb6/a;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getCallDuration", "()J", "setCallDuration", "(J)V", "callDuration", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "getChannelBackground", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "setChannelBackground", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)V", "channelBackground", "getChannelId", "setChannelId", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelUserCount", "setChannelUserCount", "channelUserCount", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getChannelUsers", "()Ljava/util/List;", "setChannelUsers", "(Ljava/util/List;)V", "channelUsers", "getLinkThreshold", "setLinkThreshold", "linkThreshold", "Lcom/bytedance/android/live/base/model/message/guestlink/k;", "getLinkedUsers", "setLinkedUsers", "linkedUsers", "getScore", "setScore", a.KEY_SCORE, "", "getScoreStr", "()Ljava/lang/String;", "setScoreStr", "(Ljava/lang/String;)V", "scoreStr", "getStartTimeMs", "setStartTimeMs", "startTimeMs", "getVersion", "setVersion", "version", "base", "<init>", "(Lcom/bytedance/android/live/base/model/message/guestlink/a;)V", "multi-link-service-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class EmptyGuestLinkChannelInfoExtensionImpl extends ModelExtensionBase<com.bytedance.android.live.base.model.message.guestlink.a, pb6.a> implements pb6.a, com.bytedance.android.live.base.model.message.guestlink.a {
    private final /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.a $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<com.bytedance.android.live.base.model.message.guestlink.a>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<com.bytedance.android.live.base.model.message.guestlink.a>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public long getCallDuration() {
        return this.$$delegate_0.getCallDuration();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public IVoiceLiveTheme getChannelBackground() {
        return this.$$delegate_0.getChannelBackground();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public long getChannelId() {
        return this.$$delegate_0.getChannelId();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public long getChannelUserCount() {
        return this.$$delegate_0.getChannelUserCount();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public List<IBaseUser> getChannelUsers() {
        return this.$$delegate_0.getChannelUsers();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public long getLinkThreshold() {
        return this.$$delegate_0.getLinkThreshold();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public List<k> getLinkedUsers() {
        return this.$$delegate_0.getLinkedUsers();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public long getScore() {
        return this.$$delegate_0.getScore();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public String getScoreStr() {
        return this.$$delegate_0.getScoreStr();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public long getStartTimeMs() {
        return this.$$delegate_0.getStartTimeMs();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public long getVersion() {
        return this.$$delegate_0.getVersion();
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setCallDuration(long r100) {
        this.$$delegate_0.setCallDuration(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setChannelBackground(IVoiceLiveTheme r100) {
        this.$$delegate_0.setChannelBackground(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setChannelId(long r100) {
        this.$$delegate_0.setChannelId(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setChannelUserCount(long r100) {
        this.$$delegate_0.setChannelUserCount(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setChannelUsers(List<? extends IBaseUser> r100) {
        this.$$delegate_0.setChannelUsers(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setLinkThreshold(long r100) {
        this.$$delegate_0.setLinkThreshold(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setLinkedUsers(List<? extends k> r100) {
        this.$$delegate_0.setLinkedUsers(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setScore(long r100) {
        this.$$delegate_0.setScore(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setScoreStr(String r100) {
        this.$$delegate_0.setScoreStr(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setStartTimeMs(long r100) {
        this.$$delegate_0.setStartTimeMs(r100);
    }

    @Override // pb6.a, com.bytedance.android.live.base.model.message.guestlink.a
    public void setVersion(long r100) {
        this.$$delegate_0.setVersion(r100);
    }

    public EmptyGuestLinkChannelInfoExtensionImpl(com.bytedance.android.live.base.model.message.guestlink.a r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
