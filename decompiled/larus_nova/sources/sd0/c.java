package sd0;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lsd0/c;", "", "", RemoteMessageConst.MSGID, "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "f", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "itemId", "b", "", "title", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "itemType", "c", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/base/model/message/a5;", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c {

    @SerializedName("display_text")
    private final a5 displayText;

    @SerializedName("item_id")
    private final Long itemId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final Long itemType;

    @SerializedName("msg_id")
    private final Long msgId;

    @SerializedName("title")
    private final String title;

    @SerializedName("user")
    private final IBaseUser user;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.msgId, r101.msgId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.user, r101.user) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.displayText, r101.displayText) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.msgId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        IBaseUser r104 = this.user;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.itemId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.title;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.itemType;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        a5 r116 = this.displayText;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoShareResponse(msgId=" + this.msgId + ", user=" + this.user + ", itemId=" + this.itemId + ", title=" + this.title + ", itemType=" + this.itemType + ", displayText=" + this.displayText + ")";
    }

    public c() {
        this.msgId = null;
        this.user = null;
        this.itemId = null;
        this.title = null;
        this.itemType = null;
        this.displayText = null;
    }

    public final a5 a() {
        return this.displayText;
    }

    public final Long b() {
        return this.itemId;
    }

    public final Long c() {
        return this.itemType;
    }

    public final Long d() {
        return this.msgId;
    }

    public final String e() {
        return this.title;
    }

    public final IBaseUser f() {
        return this.user;
    }
}
