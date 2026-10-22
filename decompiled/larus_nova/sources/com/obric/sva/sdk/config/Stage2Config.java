package com.obric.sva.sdk.config;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\bM\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 V2\u00020\u0001:\u0001VBß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003Já\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020THÖ\u0001J\t\u0010U\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001aR \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001aR \u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0018\"\u0004\b:\u0010\u001aR \u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001a¨\u0006W"}, d2 = {"Lcom/obric/sva/sdk/config/Stage2Config;", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "date", "version", "description", "Kwsfile", "KwsmodelVersion", "KwsengineVersion", "Kwsmd5", "Kws_key", "Kws_key_md5", "Voiceprint_file", "Voiceprint_modelVersion", "Voiceprint_engineVersion", "Voiceprint_md5", "Voiceprint_key", "Voiceprint_key_md5", "Kws_rawfile_md5", "Voiceprint_rawfile_md5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "setModel", "(Ljava/lang/String;)V", "getDate", "setDate", "getVersion", "setVersion", "getDescription", "setDescription", "getKwsfile", "setKwsfile", "getKwsmodelVersion", "setKwsmodelVersion", "getKwsengineVersion", "setKwsengineVersion", "getKwsmd5", "setKwsmd5", "getKws_key", "setKws_key", "getKws_key_md5", "setKws_key_md5", "getVoiceprint_file", "setVoiceprint_file", "getVoiceprint_modelVersion", "setVoiceprint_modelVersion", "getVoiceprint_engineVersion", "setVoiceprint_engineVersion", "getVoiceprint_md5", "setVoiceprint_md5", "getVoiceprint_key", "setVoiceprint_key", "getVoiceprint_key_md5", "setVoiceprint_key_md5", "getKws_rawfile_md5", "setKws_rawfile_md5", "getVoiceprint_rawfile_md5", "setVoiceprint_rawfile_md5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Stage2Config {
    public static final Companion Companion = null;

    @SerializedName("kws-key")
    private String Kws_key;

    @SerializedName("kws-key-md5")
    private String Kws_key_md5;

    @SerializedName("kws-rawfile-md5")
    private String Kws_rawfile_md5;

    @SerializedName("kws-engine-version")
    private String KwsengineVersion;

    @SerializedName("kws-file")
    private String Kwsfile;

    @SerializedName("kws-md5")
    private String Kwsmd5;

    @SerializedName("kws-model-version")
    private String KwsmodelVersion;

    @SerializedName("voiceprint-engine-version")
    private String Voiceprint_engineVersion;

    @SerializedName("voiceprint-file")
    private String Voiceprint_file;

    @SerializedName("voiceprint-key")
    private String Voiceprint_key;

    @SerializedName("voiceprint-key-md5")
    private String Voiceprint_key_md5;

    @SerializedName("voiceprint-md5")
    private String Voiceprint_md5;

    @SerializedName("voiceprint-model-version")
    private String Voiceprint_modelVersion;

    @SerializedName("voiceprint-rawfile-md5")
    private String Voiceprint_rawfile_md5;

    @SerializedName("date")
    private String date;

    @SerializedName("description")
    private String description;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private String model;

    @SerializedName("version")
    private String version;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/sva/sdk/config/Stage2Config$Companion;", "", "<init>", "()V", "fromJson", "Lcom/obric/sva/sdk/config/Stage2Config;", "_json", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Stage2Config fromJson(String r100) {
            Intrinsics.checkNotNullParameter(r100, "_json");
            return (Stage2Config) GsonProtectorUtils.fromJson(new Gson(), r100, Stage2Config.class);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Stage2Config() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    public static /* synthetic */ Stage2Config copy$default(Stage2Config r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = r110.model;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.date;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = r110.version;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = r110.description;
    L19:
        if ((r316 & 16) == 0) goto L21;
        String r104 = r110.Kwsfile;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = r110.KwsmodelVersion;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = r110.KwsengineVersion;
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r107 = r110.Kwsmd5;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r113 = r110.Kws_key;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r114 = r110.Kws_key_md5;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r115 = r110.Voiceprint_file;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r116 = r110.Voiceprint_modelVersion;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r117 = r110.Voiceprint_engineVersion;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r118 = r110.Voiceprint_md5;
    L58:
        String r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        String r119 = r110.Voiceprint_key;
    L62:
        String r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        String r120 = r110.Voiceprint_key_md5;
    L66:
        String r320 = r120;
        if ((r316 & 65536) == 0) goto L69;
        String r121 = r110.Kws_rawfile_md5;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        String r108 = r110.Voiceprint_rawfile_md5;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r318, r319, r320, r121, r108);
    L73:
        r108 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
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
        return this.model;
    }

    public final String component10() {
        return this.Kws_key_md5;
    }

    public final String component11() {
        return this.Voiceprint_file;
    }

    public final String component12() {
        return this.Voiceprint_modelVersion;
    }

    public final String component13() {
        return this.Voiceprint_engineVersion;
    }

    public final String component14() {
        return this.Voiceprint_md5;
    }

    public final String component15() {
        return this.Voiceprint_key;
    }

    public final String component16() {
        return this.Voiceprint_key_md5;
    }

    public final String component17() {
        return this.Kws_rawfile_md5;
    }

    public final String component18() {
        return this.Voiceprint_rawfile_md5;
    }

    public final String component2() {
        return this.date;
    }

    public final String component3() {
        return this.version;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.Kwsfile;
    }

    public final String component6() {
        return this.KwsmodelVersion;
    }

    public final String component7() {
        return this.KwsengineVersion;
    }

    public final String component8() {
        return this.Kwsmd5;
    }

    public final String component9() {
        return this.Kws_key;
    }

    public final Stage2Config copy(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318) {
        return new Stage2Config(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Stage2Config) == true) goto L8;
        return false;
    L8:
        Stage2Config r101 = (Stage2Config) r100;
        if (Intrinsics.areEqual(this.model, r101.model) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.date, r101.date) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.Kwsfile, r101.Kwsfile) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.KwsmodelVersion, r101.KwsmodelVersion) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.KwsengineVersion, r101.KwsengineVersion) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.Kwsmd5, r101.Kwsmd5) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.Kws_key, r101.Kws_key) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.Kws_key_md5, r101.Kws_key_md5) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.Voiceprint_file, r101.Voiceprint_file) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.Voiceprint_modelVersion, r101.Voiceprint_modelVersion) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.Voiceprint_engineVersion, r101.Voiceprint_engineVersion) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.Voiceprint_md5, r101.Voiceprint_md5) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.Voiceprint_key, r101.Voiceprint_key) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.Voiceprint_key_md5, r101.Voiceprint_key_md5) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.Kws_rawfile_md5, r101.Kws_rawfile_md5) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.Voiceprint_rawfile_md5, r101.Voiceprint_rawfile_md5) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public int hashCode() {
        String r100 = this.model;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.date;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.version;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.description;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.Kwsfile;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.KwsmodelVersion;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.KwsengineVersion;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.Kwsmd5;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.Kws_key;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.Kws_key_md5;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.Voiceprint_file;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.Voiceprint_modelVersion;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.Voiceprint_engineVersion;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.Voiceprint_md5;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.Voiceprint_key;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.Voiceprint_key_md5;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.Kws_rawfile_md5;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.Voiceprint_rawfile_md5;
        if (r152 == null) goto L75;
        r101 = r152.hashCode();
    L75:
        return r151 + r101;
    L69:
        r150 = r149.hashCode();
        goto L70
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
        return "Stage2Config(model=" + this.model + ", date=" + this.date + ", version=" + this.version + ", description=" + this.description + ", Kwsfile=" + this.Kwsfile + ", KwsmodelVersion=" + this.KwsmodelVersion + ", KwsengineVersion=" + this.KwsengineVersion + ", Kwsmd5=" + this.Kwsmd5 + ", Kws_key=" + this.Kws_key + ", Kws_key_md5=" + this.Kws_key_md5 + ", Voiceprint_file=" + this.Voiceprint_file + ", Voiceprint_modelVersion=" + this.Voiceprint_modelVersion + ", Voiceprint_engineVersion=" + this.Voiceprint_engineVersion + ", Voiceprint_md5=" + this.Voiceprint_md5 + ", Voiceprint_key=" + this.Voiceprint_key + ", Voiceprint_key_md5=" + this.Voiceprint_key_md5 + ", Kws_rawfile_md5=" + this.Kws_rawfile_md5 + ", Voiceprint_rawfile_md5=" + this.Voiceprint_rawfile_md5 + ')';
    }

    public final String getDate() {
        return this.date;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getKws_key() {
        return this.Kws_key;
    }

    public final String getKws_key_md5() {
        return this.Kws_key_md5;
    }

    public final String getKws_rawfile_md5() {
        return this.Kws_rawfile_md5;
    }

    public final String getKwsengineVersion() {
        return this.KwsengineVersion;
    }

    public final String getKwsfile() {
        return this.Kwsfile;
    }

    public final String getKwsmd5() {
        return this.Kwsmd5;
    }

    public final String getKwsmodelVersion() {
        return this.KwsmodelVersion;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getVoiceprint_engineVersion() {
        return this.Voiceprint_engineVersion;
    }

    public final String getVoiceprint_file() {
        return this.Voiceprint_file;
    }

    public final String getVoiceprint_key() {
        return this.Voiceprint_key;
    }

    public final String getVoiceprint_key_md5() {
        return this.Voiceprint_key_md5;
    }

    public final String getVoiceprint_md5() {
        return this.Voiceprint_md5;
    }

    public final String getVoiceprint_modelVersion() {
        return this.Voiceprint_modelVersion;
    }

    public final String getVoiceprint_rawfile_md5() {
        return this.Voiceprint_rawfile_md5;
    }

    public final void setDate(String r100) {
        this.date = r100;
    }

    public final void setDescription(String r100) {
        this.description = r100;
    }

    public final void setKws_key(String r100) {
        this.Kws_key = r100;
    }

    public final void setKws_key_md5(String r100) {
        this.Kws_key_md5 = r100;
    }

    public final void setKws_rawfile_md5(String r100) {
        this.Kws_rawfile_md5 = r100;
    }

    public final void setKwsengineVersion(String r100) {
        this.KwsengineVersion = r100;
    }

    public final void setKwsfile(String r100) {
        this.Kwsfile = r100;
    }

    public final void setKwsmd5(String r100) {
        this.Kwsmd5 = r100;
    }

    public final void setKwsmodelVersion(String r100) {
        this.KwsmodelVersion = r100;
    }

    public final void setModel(String r100) {
        this.model = r100;
    }

    public final void setVersion(String r100) {
        this.version = r100;
    }

    public final void setVoiceprint_engineVersion(String r100) {
        this.Voiceprint_engineVersion = r100;
    }

    public final void setVoiceprint_file(String r100) {
        this.Voiceprint_file = r100;
    }

    public final void setVoiceprint_key(String r100) {
        this.Voiceprint_key = r100;
    }

    public final void setVoiceprint_key_md5(String r100) {
        this.Voiceprint_key_md5 = r100;
    }

    public final void setVoiceprint_md5(String r100) {
        this.Voiceprint_md5 = r100;
    }

    public final void setVoiceprint_modelVersion(String r100) {
        this.Voiceprint_modelVersion = r100;
    }

    public final void setVoiceprint_rawfile_md5(String r100) {
        this.Voiceprint_rawfile_md5 = r100;
    }

    public Stage2Config(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210) {
        this.model = r100;
        this.date = r101;
        this.version = r102;
        this.description = r103;
        this.Kwsfile = r104;
        this.KwsmodelVersion = r105;
        this.KwsengineVersion = r106;
        this.Kwsmd5 = r110;
        this.Kws_key = r111;
        this.Kws_key_md5 = r112;
        this.Voiceprint_file = r113;
        this.Voiceprint_modelVersion = r114;
        this.Voiceprint_engineVersion = r115;
        this.Voiceprint_md5 = r116;
        this.Voiceprint_key = r117;
        this.Voiceprint_key_md5 = r118;
        this.Kws_rawfile_md5 = r119;
        this.Voiceprint_rawfile_md5 = r210;
    }

    public /* synthetic */ Stage2Config(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r318 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        String r109 = null;
    L74:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L59
    L53:
        r114 = r312;
        goto L55
    L49:
        r113 = r311;
        goto L51
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r219;
        goto L43
    L37:
        r110 = r218;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
