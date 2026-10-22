package com.ss.android.lark.search.dto.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.dyres.DyResUtils;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0001CBÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020*J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÕ\u0001\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017¨\u0006D"}, d2 = {"Lcom/ss/android/lark/search/dto/setting/LanguageConfig;", "", "zhCN", "", "zhTW", "zhHK", "enUS", "esUS", "jaJP", "idID", "deDE", "frFR", "itIT", "ptBR", "viVN", "ruRU", "hiIN", "thTH", "koKR", "msMY", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getZhCN", "()Ljava/lang/String;", "getZhTW", "getZhHK", "getEnUS", "getEsUS", "getJaJP", "getIdID", "getDeDE", "getFrFR", "getItIT", "getPtBR", "getViVN", "getRuRU", "getHiIN", "getThTH", "getKoKR", "getMsMY", "getLabelTextByLocale", "currentLocale", "Ljava/util/Locale;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LanguageConfig {
    public static final a Companion = null;
    public static final String TAG = "SearchInChatQAQueryConfig.LanguageConfig";

    @SerializedName(DyResUtils.ResI18n.de_DE)
    private final String deDE;

    @SerializedName(DyResUtils.ResI18n.en_US)
    private final String enUS;

    @SerializedName(DyResUtils.ResI18n.es_ES)
    private final String esUS;

    @SerializedName(DyResUtils.ResI18n.fr_FR)
    private final String frFR;

    @SerializedName(DyResUtils.ResI18n.hi_IN)
    private final String hiIN;

    @SerializedName("id_ID")
    private final String idID;

    @SerializedName(DyResUtils.ResI18n.it_IT)
    private final String itIT;

    @SerializedName(DyResUtils.ResI18n.ja_JP)
    private final String jaJP;

    @SerializedName(DyResUtils.ResI18n.ko_KR)
    private final String koKR;

    @SerializedName("ms_MY")
    private final String msMY;

    @SerializedName(DyResUtils.ResI18n.pt_BR)
    private final String ptBR;

    @SerializedName(DyResUtils.ResI18n.ru_RU)
    private final String ruRU;

    @SerializedName(DyResUtils.ResI18n.th_TH)
    private final String thTH;

    @SerializedName(DyResUtils.ResI18n.vi_VN)
    private final String viVN;

    @SerializedName("zh_CN")
    private final String zhCN;

    @SerializedName("zh_HK")
    private final String zhHK;

    @SerializedName("zh_TW")
    private final String zhTW;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LanguageConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ LanguageConfig copy$default(LanguageConfig r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.zhCN;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.zhTW;
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = r110.zhHK;
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = r110.enUS;
    L19:
        if ((r315 & 16) == 0) goto L21;
        String r104 = r110.esUS;
    L23:
        if ((r315 & 32) == 0) goto L25;
        String r105 = r110.jaJP;
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r106 = r110.idID;
    L31:
        if ((r315 & 128) == 0) goto L33;
        String r107 = r110.deDE;
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r113 = r110.frFR;
    L39:
        if ((r315 & 512) == 0) goto L41;
        String r114 = r110.itIT;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r115 = r110.ptBR;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r116 = r110.viVN;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        String r117 = r110.ruRU;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        String r118 = r110.hiIN;
    L58:
        String r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        String r119 = r110.thTH;
    L62:
        String r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        String r120 = r110.koKR;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        String r108 = r110.msMY;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.zhCN;
    }

    public final String component10() {
        return this.itIT;
    }

    public final String component11() {
        return this.ptBR;
    }

    public final String component12() {
        return this.viVN;
    }

    public final String component13() {
        return this.ruRU;
    }

    public final String component14() {
        return this.hiIN;
    }

    public final String component15() {
        return this.thTH;
    }

    public final String component16() {
        return this.koKR;
    }

    public final String component17() {
        return this.msMY;
    }

    public final String component2() {
        return this.zhTW;
    }

    public final String component3() {
        return this.zhHK;
    }

    public final String component4() {
        return this.enUS;
    }

    public final String component5() {
        return this.esUS;
    }

    public final String component6() {
        return this.jaJP;
    }

    public final String component7() {
        return this.idID;
    }

    public final String component8() {
        return this.deDE;
    }

    public final String component9() {
        return this.frFR;
    }

    public final LanguageConfig copy(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316) {
        return new LanguageConfig(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LanguageConfig) == true) goto L8;
        return false;
    L8:
        LanguageConfig r101 = (LanguageConfig) r100;
        if (Intrinsics.areEqual(this.zhCN, r101.zhCN) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.zhTW, r101.zhTW) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.zhHK, r101.zhHK) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enUS, r101.enUS) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.esUS, r101.esUS) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.jaJP, r101.jaJP) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.idID, r101.idID) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.deDE, r101.deDE) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.frFR, r101.frFR) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.itIT, r101.itIT) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.ptBR, r101.ptBR) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.viVN, r101.viVN) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.ruRU, r101.ruRU) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.hiIN, r101.hiIN) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.thTH, r101.thTH) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.koKR, r101.koKR) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.msMY, r101.msMY) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        String r100 = this.zhCN;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.zhTW;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.zhHK;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.enUS;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.esUS;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.jaJP;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.idID;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.deDE;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.frFR;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.itIT;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.ptBR;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.viVN;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.ruRU;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.hiIN;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.thTH;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.koKR;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.msMY;
        if (r149 == null) goto L71;
        r101 = r149.hashCode();
    L71:
        return r148 + r101;
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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

    public String toString() {
        return "LanguageConfig(zhCN=" + this.zhCN + ", zhTW=" + this.zhTW + ", zhHK=" + this.zhHK + ", enUS=" + this.enUS + ", esUS=" + this.esUS + ", jaJP=" + this.jaJP + ", idID=" + this.idID + ", deDE=" + this.deDE + ", frFR=" + this.frFR + ", itIT=" + this.itIT + ", ptBR=" + this.ptBR + ", viVN=" + this.viVN + ", ruRU=" + this.ruRU + ", hiIN=" + this.hiIN + ", thTH=" + this.thTH + ", koKR=" + this.koKR + ", msMY=" + this.msMY + ')';
    }

    public final String getDeDE() {
        return this.deDE;
    }

    public final String getEnUS() {
        return this.enUS;
    }

    public final String getEsUS() {
        return this.esUS;
    }

    public final String getFrFR() {
        return this.frFR;
    }

    public final String getHiIN() {
        return this.hiIN;
    }

    public final String getIdID() {
        return this.idID;
    }

    public final String getItIT() {
        return this.itIT;
    }

    public final String getJaJP() {
        return this.jaJP;
    }

    public final String getKoKR() {
        return this.koKR;
    }

    public final String getMsMY() {
        return this.msMY;
    }

    public final String getPtBR() {
        return this.ptBR;
    }

    public final String getRuRU() {
        return this.ruRU;
    }

    public final String getThTH() {
        return this.thTH;
    }

    public final String getViVN() {
        return this.viVN;
    }

    public final String getZhCN() {
        return this.zhCN;
    }

    public final String getZhHK() {
        return this.zhHK;
    }

    public final String getZhTW() {
        return this.zhTW;
    }

    public final String getLabelTextByLocale(Locale r100) {
        Intrinsics.checkNotNullParameter(r100, "currentLocale");
        Iterator r101 = KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(LanguageConfig.class)).iterator();
    L3:
        String r102 = null;
        if (r101.hasNext() == false) goto L19;
        KProperty1 r103 = (KProperty1) r101.next();
        String r104 = r103.getName();
        if (r104.length() != 4) goto L7;
        CharSequence r105 = r104.subSequence(0, 2);
        CharSequence r106 = r104.subSequence(2, r104.length());
        if (Intrinsics.areEqual(r100.getLanguage(), r105) == false) goto L3;
        if (Intrinsics.areEqual(r100.getCountry(), r106) == false) goto L3;
        Log.i(TAG, "matched locale ".concat(r104));
        Object r107 = r103.get(this);     // Catch: Exception -> L17
        if ((r107 instanceof String) == false) goto L16;
        r102 = (String) r107;     // Catch: Exception -> L17
    L16:
        return r102;
    L17:
        e = move-exception;
        Log.e(TAG, "parse value for " + r103.getName() + " failed exception: " + e.getMessage());
        goto L3
    L7:
        Log.e(TAG, "unRecognized property " + r104 + ", use default name");
        goto L3
    L19:
        Log.i(TAG, "no match locale");
        return null;
    }

    public LanguageConfig(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119) {
        this.zhCN = r100;
        this.zhTW = r101;
        this.zhHK = r102;
        this.enUS = r103;
        this.esUS = r104;
        this.jaJP = r105;
        this.idID = r106;
        this.deDE = r110;
        this.frFR = r111;
        this.itIT = r112;
        this.ptBR = r113;
        this.viVN = r114;
        this.ruRU = r115;
        this.hiIN = r116;
        this.thTH = r117;
        this.koKR = r118;
        this.msMY = r119;
    }

    public /* synthetic */ LanguageConfig(String r110, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r316 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r115 = null;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r116 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r316 & 65536) == 0) goto L69;
        String r109 = null;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115, r116, r108, r117, r109);
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r116 = r312;
        goto L59
    L53:
        r115 = r311;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = r219;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
