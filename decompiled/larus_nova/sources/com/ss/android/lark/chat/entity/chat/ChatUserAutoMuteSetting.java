package com.ss.android.lark.chat.entity.chat;

import com.hihonor.honorid.core.data.UserInfo;
import java.io.Serializable;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012*\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u001a\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003Ja\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032,\b\u0002\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R5\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005j\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatUserAutoMuteSetting;", "Ljava/io/Serializable;", "autoMuteConfig", "Lcom/ss/android/lark/chat/entity/chat/AutoMuteConfig;", "botAutoMute", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "noticeType", "Lcom/bytedance/lark/pb/basic/v1/ChatUserAutoMuteSetting$NoticeType;", UserInfo.UPDATE_TIME, "showTopBanner", "", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/AutoMuteConfig;Ljava/util/LinkedHashMap;Lcom/bytedance/lark/pb/basic/v1/ChatUserAutoMuteSetting$NoticeType;JZ)V", "getAutoMuteConfig", "()Lcom/ss/android/lark/chat/entity/chat/AutoMuteConfig;", "getBotAutoMute", "()Ljava/util/LinkedHashMap;", "getNoticeType", "()Lcom/bytedance/lark/pb/basic/v1/ChatUserAutoMuteSetting$NoticeType;", "getUpdateTime", "()J", "getShowTopBanner", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatUserAutoMuteSetting implements Serializable {
    private final AutoMuteConfig autoMuteConfig;
    private final LinkedHashMap<Long, AutoMuteConfig> botAutoMute;
    private final com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType noticeType;
    private final boolean showTopBanner;
    private final long updateTime;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatUserAutoMuteSetting copy$default(ChatUserAutoMuteSetting r100, AutoMuteConfig r101, LinkedHashMap r102, com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType r103, long r104, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.autoMuteConfig;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.botAutoMute;
    L8:
        LinkedHashMap r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.noticeType;
    L11:
        com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.updateTime;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.showTopBanner;
    L17:
        AutoMuteConfig r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final AutoMuteConfig component1() {
        return this.autoMuteConfig;
    }

    public final LinkedHashMap<Long, AutoMuteConfig> component2() {
        return this.botAutoMute;
    }

    public final com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType component3() {
        return this.noticeType;
    }

    public final long component4() {
        return this.updateTime;
    }

    public final boolean component5() {
        return this.showTopBanner;
    }

    public final ChatUserAutoMuteSetting copy(AutoMuteConfig r100, LinkedHashMap<Long, AutoMuteConfig> r110, com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType r111, long r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r111, "noticeType");
        return new ChatUserAutoMuteSetting(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatUserAutoMuteSetting) == true) goto L8;
        return false;
    L8:
        ChatUserAutoMuteSetting r101 = (ChatUserAutoMuteSetting) r100;
        if (Intrinsics.areEqual(this.autoMuteConfig, r101.autoMuteConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botAutoMute, r101.botAutoMute) == true) goto L15;
        return false;
    L15:
        if (this.noticeType == r101.noticeType) goto L18;
        return false;
    L18:
        if (this.updateTime == r101.updateTime) goto L21;
        return false;
    L21:
        if (this.showTopBanner == r101.showTopBanner) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        AutoMuteConfig r100 = this.autoMuteConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        LinkedHashMap<Long, AutoMuteConfig> r104 = this.botAutoMute;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.noticeType.hashCode()) * 31;
        long r106 = this.updateTime;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        if (this.showTopBanner == false) goto L13;
        int r108 = 1231;
    L15:
        return r107 + r108;
    L13:
        r108 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ChatUserAutoMuteSetting(autoMuteConfig=" + this.autoMuteConfig + ", botAutoMute=" + this.botAutoMute + ", noticeType=" + this.noticeType + ", updateTime=" + this.updateTime + ", showTopBanner=" + this.showTopBanner + ')';
    }

    public final AutoMuteConfig getAutoMuteConfig() {
        return this.autoMuteConfig;
    }

    public final LinkedHashMap<Long, AutoMuteConfig> getBotAutoMute() {
        return this.botAutoMute;
    }

    public final com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType getNoticeType() {
        return this.noticeType;
    }

    public final boolean getShowTopBanner() {
        return this.showTopBanner;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public ChatUserAutoMuteSetting(AutoMuteConfig r100, LinkedHashMap<Long, AutoMuteConfig> r101, com.bytedance.lark.pb.basic.v1.ChatUserAutoMuteSetting.NoticeType r102, long r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r102, "noticeType");
        this.autoMuteConfig = r100;
        this.botAutoMute = r101;
        this.noticeType = r102;
        this.updateTime = r103;
        this.showTopBanner = r104;
    }
}
