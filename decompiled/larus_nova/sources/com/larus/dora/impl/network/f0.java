package com.larus.dora.impl.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003JK\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R(\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/larus/dora/impl/network/UserSettings;", "", "userExperienceStatus", "", "multiUserSettings", "Lcom/larus/dora/impl/network/MultiUserSettings;", "voiceSettings", "Lcom/larus/dora/impl/network/VoiceSettings;", "notificationAppList", "", "Lcom/larus/dora/impl/network/NLAppInfo;", "userSettingsExtra", "Lcom/larus/dora/impl/network/UserSettingsExtra;", "<init>", "(ILcom/larus/dora/impl/network/MultiUserSettings;Lcom/larus/dora/impl/network/VoiceSettings;Ljava/util/List;Lcom/larus/dora/impl/network/UserSettingsExtra;)V", "getUserExperienceStatus", "()I", "getMultiUserSettings", "()Lcom/larus/dora/impl/network/MultiUserSettings;", "getVoiceSettings", "()Lcom/larus/dora/impl/network/VoiceSettings;", "getNotificationAppList", "()Ljava/util/List;", "setNotificationAppList", "(Ljava/util/List;)V", "getUserSettingsExtra", "()Lcom/larus/dora/impl/network/UserSettingsExtra;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f0 {

    @SerializedName("multi_user_settings")
    private final r multiUserSettings;

    @SerializedName("notification_app_list")
    private List<s> notificationAppList;

    @SerializedName("user_experience_status")
    private final int userExperienceStatus;

    @SerializedName("extra_params")
    private final g0 userSettingsExtra;

    @SerializedName("voice_settings")
    private final i0 voiceSettings;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (this.userExperienceStatus == r101.userExperienceStatus) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.multiUserSettings, r101.multiUserSettings) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.voiceSettings, r101.voiceSettings) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.notificationAppList, r101.notificationAppList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userSettingsExtra, r101.userSettingsExtra) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.userExperienceStatus * 31;
        r r101 = this.multiUserSettings;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        i0 r105 = this.voiceSettings;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<s> r108 = this.notificationAppList;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        g0 r111 = this.userSettingsExtra;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserSettings(userExperienceStatus=" + this.userExperienceStatus + ", multiUserSettings=" + this.multiUserSettings + ", voiceSettings=" + this.voiceSettings + ", notificationAppList=" + this.notificationAppList + ", userSettingsExtra=" + this.userSettingsExtra + ')';
    }

    public final r b() {
        return this.multiUserSettings;
    }

    public final List<s> c() {
        return this.notificationAppList;
    }

    public final g0 d() {
        return this.userSettingsExtra;
    }

    public /* synthetic */ f0(List r100, g0 r101, int r110) {
        if ((r110 & 1) == 0) goto L5;
        int r102 = 2;
    L7:
        if ((r110 & 8) == 0) goto L9;
        List r103 = null;
    L11:
        if ((r110 & 16) == 0) goto L13;
        g0 r104 = null;
    L14:
        this(r102, null, null, r103, r104);
        return;
    L13:
        r104 = r101;
        goto L14
    L9:
        r103 = r100;
        goto L11
    L5:
        r102 = 0;
        goto L7
    }

    public static f0 a(f0 r100, List r101, g0 r102, int r110) {
        if ((r110 & 1) == 0) goto L5;
        int r103 = r100.userExperienceStatus;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r r104 = r100.multiUserSettings;
    L11:
        if ((r110 & 4) == 0) goto L13;
        i0 r105 = r100.voiceSettings;
    L15:
        if ((r110 & 8) == 0) goto L17;
        r101 = r100.notificationAppList;
    L17:
        List r106 = r101;
        if ((r110 & 16) == 0) goto L20;
        r102 = r100.userSettingsExtra;
    L20:
        r100.getClass();
        return new f0(r103, r104, r105, r106, r102);
    L13:
        r105 = null;
        goto L15
    L9:
        r104 = null;
        goto L11
    L5:
        r103 = 0;
        goto L7
    }

    public f0(int r100, r r101, i0 r102, List<s> r103, g0 r104) {
        this.userExperienceStatus = r100;
        this.multiUserSettings = r101;
        this.voiceSettings = r102;
        this.notificationAppList = r103;
        this.userSettingsExtra = r104;
    }
}
