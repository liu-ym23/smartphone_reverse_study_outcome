package com.ss.android.lark.chat.entity.chatter;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 *2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001*B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J0\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u001dJ\t\u0010$\u001a\u00020\u0005HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006+"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/UserPrivateDescription;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "userId", "", "descriptionId", "", "content", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "getDescriptionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getContent", "hasContent", "", "isValid", "isClearMarker", "isFailedMarker", "isItemSame", "diffable", "isContentSame", "equals", "other", "", "hashCode", "", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/ss/android/lark/chat/entity/chatter/UserPrivateDescription;", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserPrivateDescription implements Parcelable, Serializable, y28.b<UserPrivateDescription> {
    public static final Parcelable.Creator<UserPrivateDescription> CREATOR = null;
    public static final a Companion = null;
    private final String content;
    private final Long descriptionId;
    private final String userId;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Parcelable.Creator<UserPrivateDescription> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserPrivateDescription createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Long r102 = null;
        L7:
            return new UserPrivateDescription(r101, r102, r100.readString());
        L5:
            r102 = Long.valueOf(r100.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UserPrivateDescription[] newArray(int r100) {
            return new UserPrivateDescription[r100];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public static /* synthetic */ UserPrivateDescription copy$default(UserPrivateDescription r100, String r101, Long r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.userId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.descriptionId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.content;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.userId;
    }

    public final Long component2() {
        return this.descriptionId;
    }

    public final String component3() {
        return this.content;
    }

    public final UserPrivateDescription copy(String r100, Long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return new UserPrivateDescription(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String toString() {
        return "UserPrivateDescription(userId=" + this.userId + ", descriptionId=" + this.descriptionId + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.userId);
        Long r102 = this.descriptionId;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.content);
        return;
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    @JvmStatic
    public static final UserPrivateDescription clearMarker() {
        Companion.getClass();
        return new UserPrivateDescription("", -9999L, null);
    }

    @JvmStatic
    public static final UserPrivateDescription failedMarker() {
        Companion.getClass();
        return new UserPrivateDescription("", Long.valueOf(ChatThemeInfo.FAKE_ID), null);
    }

    public final boolean hasContent() {
        String r100 = this.content;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }

    public int hashCode() {
        int r100 = this.userId.hashCode() * 31;
        Long r101 = this.descriptionId;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.content;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final boolean isClearMarker() {
        if (this.userId.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L15;
        Long r101 = this.descriptionId;
        if (r101 == null) goto L15;
        if (r101.longValue() != (-9999)) goto L15;
        if (this.content != null) goto L15;
        return true;
    L15:
        return false;
    L5:
        r100 = false;
        goto L6
    }

    public final boolean isFailedMarker() {
        if (this.userId.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L15;
        Long r101 = this.descriptionId;
        if (r101 == null) goto L15;
        if (r101.longValue() != ChatThemeInfo.FAKE_ID) goto L15;
        if (this.content != null) goto L15;
        return true;
    L15:
        return false;
    L5:
        r100 = false;
        goto L6
    }

    public final boolean isValid() {
        if (this.descriptionId == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getDescriptionId() {
        return this.descriptionId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserPrivateDescription) == true) goto L8;
        return false;
    L8:
        UserPrivateDescription r101 = (UserPrivateDescription) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.descriptionId, r101.descriptionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((UserPrivateDescription) r100);
    }

    public boolean isItemSame(UserPrivateDescription r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.userId, r100.userId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.descriptionId, r100.descriptionId) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isContentSame(UserPrivateDescription r100) {
        return equals(r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((UserPrivateDescription) r100);
    }

    public UserPrivateDescription(String r100, Long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.userId = r100;
        this.descriptionId = r101;
        this.content = r102;
    }
}
