package com.ss.android.lark.chat.entity.redpacket;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.image.entity.PassThroughImage;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/entity/redpacket/RedPacketDisplayName;", "Ljava/io/Serializable;", "backgroundImage", "Lcom/ss/android/lark/image/entity/PassThroughImage;", CommonConstant.KEY_DISPLAY_NAME, "", "<init>", "(Lcom/ss/android/lark/image/entity/PassThroughImage;Ljava/lang/String;)V", "getBackgroundImage", "()Lcom/ss/android/lark/image/entity/PassThroughImage;", "getDisplayName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RedPacketDisplayName implements Serializable {
    private final PassThroughImage backgroundImage;
    private final String displayName;

    public static /* synthetic */ RedPacketDisplayName copy$default(RedPacketDisplayName r100, PassThroughImage r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.backgroundImage;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.displayName;
    L9:
        return r100.copy(r101, r102);
    }

    public final PassThroughImage component1() {
        return this.backgroundImage;
    }

    public final String component2() {
        return this.displayName;
    }

    public final RedPacketDisplayName copy(PassThroughImage r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
        return new RedPacketDisplayName(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RedPacketDisplayName) == true) goto L8;
        return false;
    L8:
        RedPacketDisplayName r101 = (RedPacketDisplayName) r100;
        if (Intrinsics.areEqual(this.backgroundImage, r101.backgroundImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        PassThroughImage r100 = this.backgroundImage;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.displayName.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "RedPacketDisplayName(backgroundImage=" + this.backgroundImage + ", displayName=" + this.displayName + ')';
    }

    public final PassThroughImage getBackgroundImage() {
        return this.backgroundImage;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public RedPacketDisplayName(PassThroughImage r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, CommonConstant.KEY_DISPLAY_NAME);
        this.backgroundImage = r100;
        this.displayName = r101;
    }
}
