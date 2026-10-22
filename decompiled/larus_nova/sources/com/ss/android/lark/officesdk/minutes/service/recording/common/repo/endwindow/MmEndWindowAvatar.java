package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowAvatar;", "Ljava/io/Serializable;", "avatarKey", "", "avatarUrl", "userId", "fakeNameId", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarKey", "()Ljava/lang/String;", "getAvatarUrl", "getUserId", "getFakeNameId", "getType", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmEndWindowAvatar implements Serializable {
    public static final a Companion = null;
    public static final String TYPE_LARK_USER = "lark_user";
    public static final String TYPE_SPEAKER = "speaker";
    private final String avatarKey;
    private final String avatarUrl;
    private final String fakeNameId;
    private final String type;
    private final String userId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MmEndWindowAvatar() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MmEndWindowAvatar copy$default(MmEndWindowAvatar r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.avatarKey;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.avatarUrl;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.userId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.fakeNameId;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.type;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.avatarKey;
    }

    public final String component2() {
        return this.avatarUrl;
    }

    public final String component3() {
        return this.userId;
    }

    public final String component4() {
        return this.fakeNameId;
    }

    public final String component5() {
        return this.type;
    }

    public final MmEndWindowAvatar copy(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "avatarKey");
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r111, "fakeNameId");
        Intrinsics.checkNotNullParameter(r112, "type");
        return new MmEndWindowAvatar(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmEndWindowAvatar) == true) goto L8;
        return false;
    L8:
        MmEndWindowAvatar r101 = (MmEndWindowAvatar) r100;
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fakeNameId, r101.fakeNameId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.avatarKey.hashCode() * 31) + this.avatarUrl.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.fakeNameId.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "MmEndWindowAvatar(avatarKey='" + this.avatarKey + "', avatarUrl=" + this.avatarUrl + "', userId='" + this.userId + "', fakeNameId='" + this.fakeNameId + "', type='" + this.type + "')";
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getFakeNameId() {
        return this.fakeNameId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public MmEndWindowAvatar(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "avatarKey");
        Intrinsics.checkNotNullParameter(r101, "avatarUrl");
        Intrinsics.checkNotNullParameter(r102, "userId");
        Intrinsics.checkNotNullParameter(r103, "fakeNameId");
        Intrinsics.checkNotNullParameter(r104, "type");
        this.avatarKey = r100;
        this.avatarUrl = r101;
        this.userId = r102;
        this.fakeNameId = r103;
        this.type = r104;
    }

    public /* synthetic */ MmEndWindowAvatar(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = "";
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
