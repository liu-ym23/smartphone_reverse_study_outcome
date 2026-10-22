package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.im.bean.bot.IconItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003JQ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006("}, d2 = {"Lcom/larus/bmhome/auth/ConversationMode;", "Landroid/os/Parcelable;", CommonConstant.KEY_DISPLAY_NAME, "", "newConversationTitle", "welcomeTitle", "conversationModeKey", "icon", "Lcom/larus/im/bean/bot/IconItem;", "darkModeIcon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/bot/IconItem;Lcom/larus/im/bean/bot/IconItem;)V", "getDisplayName", "()Ljava/lang/String;", "getNewConversationTitle", "getWelcomeTitle", "getConversationModeKey", "getIcon", "()Lcom/larus/im/bean/bot/IconItem;", "getDarkModeIcon", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationMode implements Parcelable {
    public static final Parcelable.Creator<ConversationMode> CREATOR = null;

    @SerializedName("conversation_mode_key")
    private final String conversationModeKey;

    @SerializedName("dark_mode_icon")
    private final IconItem darkModeIcon;

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("icon")
    private final IconItem icon;

    @SerializedName("new_conversation_title")
    private final String newConversationTitle;

    @SerializedName("welcome_title")
    private final String welcomeTitle;

    public static final class a implements Parcelable.Creator<ConversationMode> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConversationMode createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ConversationMode(r100.readString(), r100.readString(), r100.readString(), r100.readString(), (IconItem) r100.readSerializable(), (IconItem) r100.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final ConversationMode[] newArray(int r100) {
            return new ConversationMode[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ConversationMode() {
        this(null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationMode) == true) goto L8;
        return false;
    L8:
        ConversationMode r101 = (ConversationMode) r100;
        if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.newConversationTitle, r101.newConversationTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.welcomeTitle, r101.welcomeTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.conversationModeKey, r101.conversationModeKey) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.darkModeIcon, r101.darkModeIcon) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.displayName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.newConversationTitle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.welcomeTitle;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.conversationModeKey;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        IconItem r113 = this.icon;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        IconItem r116 = this.darkModeIcon;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationMode(displayName=" + this.displayName + ", newConversationTitle=" + this.newConversationTitle + ", welcomeTitle=" + this.welcomeTitle + ", conversationModeKey=" + this.conversationModeKey + ", icon=" + this.icon + ", darkModeIcon=" + this.darkModeIcon + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.displayName);
        r100.writeString(this.newConversationTitle);
        r100.writeString(this.welcomeTitle);
        r100.writeString(this.conversationModeKey);
        r100.writeSerializable(this.icon);
        r100.writeSerializable(this.darkModeIcon);
    }

    public final String a() {
        return this.conversationModeKey;
    }

    public final IconItem b() {
        return this.darkModeIcon;
    }

    public final String c() {
        return this.displayName;
    }

    public final IconItem d() {
        return this.icon;
    }

    public final String e() {
        return this.newConversationTitle;
    }

    public final String g() {
        return this.welcomeTitle;
    }

    public ConversationMode(String r100, String r101, String r102, String r103, IconItem r104, IconItem r105) {
        this.displayName = r100;
        this.newConversationTitle = r101;
        this.welcomeTitle = r102;
        this.conversationModeKey = r103;
        this.icon = r104;
        this.darkModeIcon = r105;
    }
}
