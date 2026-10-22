package com.larus.settings.provider;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/settings/provider/LLMDisclaimerPageUrlConfig;", "", "entrySystemSetting", "", "entrySystemSettingAbout", "entryMainBotFooter", "entryNormalBotFooter", "entryEPBotFooter", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEntrySystemSetting", "()Ljava/lang/String;", "getEntrySystemSettingAbout", "getEntryMainBotFooter", "getEntryNormalBotFooter", "getEntryEPBotFooter", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LLMDisclaimerPageUrlConfig {

    @SerializedName("entry_ep_bot_footer")
    private final String entryEPBotFooter;

    @SerializedName("entry_main_bot_footer")
    private final String entryMainBotFooter;

    @SerializedName("entry_normal_bot_footer")
    private final String entryNormalBotFooter;

    @SerializedName("entry_system_setting")
    private final String entrySystemSetting;

    @SerializedName("entry_system_setting_about")
    private final String entrySystemSettingAbout;

    public LLMDisclaimerPageUrlConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ LLMDisclaimerPageUrlConfig copy$default(LLMDisclaimerPageUrlConfig r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.entrySystemSetting;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.entrySystemSettingAbout;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.entryMainBotFooter;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.entryNormalBotFooter;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.entryEPBotFooter;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.entrySystemSetting;
    }

    public final String component2() {
        return this.entrySystemSettingAbout;
    }

    public final String component3() {
        return this.entryMainBotFooter;
    }

    public final String component4() {
        return this.entryNormalBotFooter;
    }

    public final String component5() {
        return this.entryEPBotFooter;
    }

    public final LLMDisclaimerPageUrlConfig copy(String r100, String r101, String r110, String r111, String r112) {
        return new LLMDisclaimerPageUrlConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LLMDisclaimerPageUrlConfig) == true) goto L8;
        return false;
    L8:
        LLMDisclaimerPageUrlConfig r101 = (LLMDisclaimerPageUrlConfig) r100;
        if (Intrinsics.areEqual(this.entrySystemSetting, r101.entrySystemSetting) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entrySystemSettingAbout, r101.entrySystemSettingAbout) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entryMainBotFooter, r101.entryMainBotFooter) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.entryNormalBotFooter, r101.entryNormalBotFooter) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entryEPBotFooter, r101.entryEPBotFooter) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.entrySystemSetting;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.entrySystemSettingAbout;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.entryMainBotFooter;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.entryNormalBotFooter;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.entryEPBotFooter;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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

    public String toString() {
        return "LLMDisclaimerPageUrlConfig(entrySystemSetting=" + this.entrySystemSetting + ", entrySystemSettingAbout=" + this.entrySystemSettingAbout + ", entryMainBotFooter=" + this.entryMainBotFooter + ", entryNormalBotFooter=" + this.entryNormalBotFooter + ", entryEPBotFooter=" + this.entryEPBotFooter + ')';
    }

    public final String getEntryEPBotFooter() {
        return this.entryEPBotFooter;
    }

    public final String getEntryMainBotFooter() {
        return this.entryMainBotFooter;
    }

    public final String getEntryNormalBotFooter() {
        return this.entryNormalBotFooter;
    }

    public final String getEntrySystemSetting() {
        return this.entrySystemSetting;
    }

    public final String getEntrySystemSettingAbout() {
        return this.entrySystemSettingAbout;
    }

    public LLMDisclaimerPageUrlConfig(String r100, String r101, String r102, String r103, String r104) {
        this.entrySystemSetting = r100;
        this.entrySystemSettingAbout = r101;
        this.entryMainBotFooter = r102;
        this.entryNormalBotFooter = r103;
        this.entryEPBotFooter = r104;
    }

    public /* synthetic */ LLMDisclaimerPageUrlConfig(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
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
