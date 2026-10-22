package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmLarkSpeakerInfoToJS;", "Ljava/io/Serializable;", "id", "", "name", "department", "avatar", "Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmSpeakerAvatarToJS;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmSpeakerAvatarToJS;)V", "getId", "()Ljava/lang/String;", "getName", "getDepartment", "getAvatar", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmSpeakerAvatarToJS;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmLarkSpeakerInfoToJS implements Serializable {
    public static final a Companion = null;

    @SerializedName("avatar")
    private final MmSpeakerAvatarToJS avatar;

    @SerializedName("department")
    private final String department;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f435892id;

    @SerializedName("name")
    private final String name;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MmLarkSpeakerInfoToJS copy$default(MmLarkSpeakerInfoToJS r100, String r101, String r102, String r103, MmSpeakerAvatarToJS r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f435892id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.department;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.avatar;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f435892id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.department;
    }

    public final MmSpeakerAvatarToJS component4() {
        return this.avatar;
    }

    public final MmLarkSpeakerInfoToJS copy(String r100, String r101, String r102, MmSpeakerAvatarToJS r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        return new MmLarkSpeakerInfoToJS(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmLarkSpeakerInfoToJS) == true) goto L8;
        return false;
    L8:
        MmLarkSpeakerInfoToJS r101 = (MmLarkSpeakerInfoToJS) r100;
        if (Intrinsics.areEqual(this.f435892id, r101.f435892id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.department, r101.department) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.f435892id.hashCode() * 31) + this.name.hashCode()) * 31;
        String r101 = this.department;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        MmSpeakerAvatarToJS r105 = this.avatar;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MmLarkSpeakerInfoToJS(id=" + this.f435892id + ", name=" + this.name + ", department=" + this.department + ", avatar=" + this.avatar + ')';
    }

    public final MmSpeakerAvatarToJS getAvatar() {
        return this.avatar;
    }

    public final String getDepartment() {
        return this.department;
    }

    public final String getId() {
        return this.f435892id;
    }

    public final String getName() {
        return this.name;
    }

    public MmLarkSpeakerInfoToJS(String r100, String r101, String r102, MmSpeakerAvatarToJS r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f435892id = r100;
        this.name = r101;
        this.department = r102;
        this.avatar = r103;
    }

    public /* synthetic */ MmLarkSpeakerInfoToJS(String r100, String r101, String r102, MmSpeakerAvatarToJS r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
