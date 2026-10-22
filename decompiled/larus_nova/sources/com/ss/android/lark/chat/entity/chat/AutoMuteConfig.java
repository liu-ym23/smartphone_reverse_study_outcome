package com.ss.android.lark.chat.entity.chat;

import com.bytedance.lark.pb.basic.v1.MuteWay;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/AutoMuteConfig;", "Ljava/io/Serializable;", "isMute", "", "position", "", "badgeCount", "muteWay", "Lcom/bytedance/lark/pb/basic/v1/MuteWay;", "<init>", "(ZJJLcom/bytedance/lark/pb/basic/v1/MuteWay;)V", "()Z", "getPosition", "()J", "getBadgeCount", "getMuteWay", "()Lcom/bytedance/lark/pb/basic/v1/MuteWay;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoMuteConfig implements Serializable {
    private final long badgeCount;
    private final boolean isMute;
    private final MuteWay muteWay;
    private final long position;

    public static /* synthetic */ AutoMuteConfig copy$default(AutoMuteConfig r100, boolean r101, long r102, long r103, MuteWay r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.isMute;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.position;
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.badgeCount;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r110 = r100.muteWay;
    L14:
        boolean r106 = r101;
        return r100.copy(r106, r104, r105, r110);
    }

    public final boolean component1() {
        return this.isMute;
    }

    public final long component2() {
        return this.position;
    }

    public final long component3() {
        return this.badgeCount;
    }

    public final MuteWay component4() {
        return this.muteWay;
    }

    public final AutoMuteConfig copy(boolean r100, long r110, long r111, MuteWay r112) {
        Intrinsics.checkNotNullParameter(r112, "muteWay");
        return new AutoMuteConfig(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AutoMuteConfig) == true) goto L8;
        return false;
    L8:
        AutoMuteConfig r101 = (AutoMuteConfig) r100;
        if (this.isMute == r101.isMute) goto L12;
        return false;
    L12:
        if (this.position == r101.position) goto L15;
        return false;
    L15:
        if (this.badgeCount == r101.badgeCount) goto L18;
        return false;
    L18:
        if (this.muteWay == r101.muteWay) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.isMute == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.position;
        int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.badgeCount;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.muteWay.hashCode();
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "AutoMuteConfig(isMute=" + this.isMute + ", position=" + this.position + ", badgeCount=" + this.badgeCount + ", muteWay=" + this.muteWay + ')';
    }

    public final long getBadgeCount() {
        return this.badgeCount;
    }

    public final MuteWay getMuteWay() {
        return this.muteWay;
    }

    public final long getPosition() {
        return this.position;
    }

    public final boolean isMute() {
        return this.isMute;
    }

    public AutoMuteConfig(boolean r100, long r101, long r102, MuteWay r103) {
        Intrinsics.checkNotNullParameter(r103, "muteWay");
        this.isMute = r100;
        this.position = r101;
        this.badgeCount = r102;
        this.muteWay = r103;
    }
}
