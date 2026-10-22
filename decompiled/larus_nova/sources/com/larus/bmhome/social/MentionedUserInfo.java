package com.larus.bmhome.social;

import com.hihonor.honorid.core.data.UserInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003Je\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010/\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\bHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00064"}, d2 = {"Lcom/larus/bmhome/social/MentionedUserInfo;", "Ljava/io/Serializable;", "id", "", "name", "isInGroup", "", "spanStartInt", "", "spanEndIndex", "type", "avatarUrl", "description", UserInfo.UPDATE_TIME, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZIIILjava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "()Z", "setInGroup", "(Z)V", "getSpanStartInt", "()I", "setSpanStartInt", "(I)V", "getSpanEndIndex", "setSpanEndIndex", "getType", "setType", "getAvatarUrl", "getDescription", "getUpdateTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MentionedUserInfo implements Serializable {
    private final String avatarUrl;
    private final String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f313982id;
    private boolean isInGroup;
    private String name;
    private int spanEndIndex;
    private int spanStartInt;
    private int type;
    private final long updateTime;

    public static /* synthetic */ MentionedUserInfo copy$default(MentionedUserInfo r110, String r111, String r112, boolean r113, int r114, int r115, int r116, String r117, String r210, long r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.f313982id;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r212 & 4) == 0) goto L13;
        boolean r102 = r110.isInGroup;
    L15:
        if ((r212 & 8) == 0) goto L17;
        int r103 = r110.spanStartInt;
    L19:
        if ((r212 & 16) == 0) goto L21;
        int r104 = r110.spanEndIndex;
    L23:
        if ((r212 & 32) == 0) goto L25;
        int r105 = r110.type;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.avatarUrl;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.description;
    L35:
        if ((r212 & 256) == 0) goto L37;
        long r118 = r110.updateTime;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118);
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.f313982id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.isInGroup;
    }

    public final int component4() {
        return this.spanStartInt;
    }

    public final int component5() {
        return this.spanEndIndex;
    }

    public final int component6() {
        return this.type;
    }

    public final String component7() {
        return this.avatarUrl;
    }

    public final String component8() {
        return this.description;
    }

    public final long component9() {
        return this.updateTime;
    }

    public final MentionedUserInfo copy(String r110, String r111, boolean r112, int r113, int r114, int r115, String r116, String r210, long r211) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r210, "description");
        return new MentionedUserInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MentionedUserInfo) == true) goto L8;
        return false;
    L8:
        MentionedUserInfo r101 = (MentionedUserInfo) r100;
        if (Intrinsics.areEqual(this.f313982id, r101.f313982id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (this.isInGroup == r101.isInGroup) goto L18;
        return false;
    L18:
        if (this.spanStartInt == r101.spanStartInt) goto L21;
        return false;
    L21:
        if (this.spanEndIndex == r101.spanEndIndex) goto L24;
        return false;
    L24:
        if (this.type == r101.type) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L33;
        return false;
    L33:
        if (this.updateTime == r101.updateTime) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.f313982id.hashCode() * 31) + this.name.hashCode()) * 31;
        if (this.isInGroup == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((((((r100 + r101) * 31) + this.spanStartInt) * 31) + this.spanEndIndex) * 31) + this.type) * 31;
        String r103 = this.avatarUrl;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (((r102 + r104) * 31) + this.description.hashCode()) * 31;
        long r106 = this.updateTime;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "MentionedUserInfo(id=" + this.f313982id + ", name=" + this.name + ", isInGroup=" + this.isInGroup + ", spanStartInt=" + this.spanStartInt + ", spanEndIndex=" + this.spanEndIndex + ", type=" + this.type + ", avatarUrl=" + this.avatarUrl + ", description=" + this.description + ", updateTime=" + this.updateTime + ')';
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.f313982id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSpanEndIndex() {
        return this.spanEndIndex;
    }

    public final int getSpanStartInt() {
        return this.spanStartInt;
    }

    public final int getType() {
        return this.type;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final boolean isInGroup() {
        return this.isInGroup;
    }

    public final void setInGroup(boolean r100) {
        this.isInGroup = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setSpanEndIndex(int r100) {
        this.spanEndIndex = r100;
    }

    public final void setSpanStartInt(int r100) {
        this.spanStartInt = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public MentionedUserInfo(String r100, String r101, boolean r102, int r103, int r104, int r105, String r106, String r107, long r110) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r107, "description");
        this.f313982id = r100;
        this.name = r101;
        this.isInGroup = r102;
        this.spanStartInt = r103;
        this.spanEndIndex = r104;
        this.type = r105;
        this.avatarUrl = r106;
        this.description = r107;
        this.updateTime = r110;
    }

    public /* synthetic */ MentionedUserInfo(String r110, String r111, boolean r112, int r113, int r114, int r210, String r211, String r212, long r213, int r214, DefaultConstructorMarker r215) {
        if ((r214 & 8) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r214 & 16) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r214 & 32) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r214 & 64) == 0) goto L17;
        String r115 = null;
    L19:
        if ((r214 & 128) == 0) goto L21;
        String r116 = "";
    L23:
        if ((r214 & 256) == 0) goto L25;
        long r117 = 0;
    L26:
        this(r110, r111, r112, r100, r101, r102, r115, r116, r117);
        return;
    L25:
        r117 = r213;
        goto L26
    L21:
        r116 = r212;
        goto L23
    L17:
        r115 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
