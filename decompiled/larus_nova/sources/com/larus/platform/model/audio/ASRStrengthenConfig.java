package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/larus/platform/model/audio/ASRStrengthenConfig;", "Ljava/io/Serializable;", "inputHintStyle", "", "asrSpeakStyle", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getInputHintStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAsrSpeakStyle", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/platform/model/audio/ASRStrengthenConfig;", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ASRStrengthenConfig implements Serializable {
    public static final int ASR_SPEAK_STYLE_BORDER = 2;
    public static final int ASR_SPEAK_STYLE_BORDER_WITH_ICON = 1;
    public static final int ASR_SPEAK_STYLE_DEFAULT = 0;
    public static final int ASR_SPEAK_STYLE_UNDERLINE = 3;
    public static final a Companion = null;
    public static final int INPUT_HINT_STYLE_DEFAULT = 0;
    public static final int INPUT_HINT_STYLE_SPANNABLE_TEXT = 2;
    public static final int INPUT_HINT_STYLE_TEXT = 1;
    private static final ASRStrengthenConfig V0 = null;
    private static final ASRStrengthenConfig V1_CN = null;
    private static final ASRStrengthenConfig V1_I18N = null;
    private static final ASRStrengthenConfig V2_CN = null;
    private static final ASRStrengthenConfig V2_I18N = null;
    private static final ASRStrengthenConfig V3_CN = null;
    private static final ASRStrengthenConfig V4_CN = null;
    private static final ASRStrengthenConfig V5_CN = null;

    @SerializedName("asr_strengthen_button_style")
    private final Integer asrSpeakStyle;

    @SerializedName("input_placeholder_style")
    private final Integer inputHintStyle;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ASRStrengthenConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ASRStrengthenConfig copy$default(ASRStrengthenConfig r100, Integer r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.inputHintStyle;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.asrSpeakStyle;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.inputHintStyle;
    }

    public final Integer component2() {
        return this.asrSpeakStyle;
    }

    public final ASRStrengthenConfig copy(Integer r100, Integer r101) {
        return new ASRStrengthenConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ASRStrengthenConfig) == true) goto L8;
        return false;
    L8:
        ASRStrengthenConfig r101 = (ASRStrengthenConfig) r100;
        if (Intrinsics.areEqual(this.inputHintStyle, r101.inputHintStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asrSpeakStyle, r101.asrSpeakStyle) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.inputHintStyle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.asrSpeakStyle;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ASRStrengthenConfig(inputHintStyle=" + this.inputHintStyle + ", asrSpeakStyle=" + this.asrSpeakStyle + ')';
    }

    static {
        Companion = new a();
        V0 = new ASRStrengthenConfig(0, 0);
        ASRStrengthenConfig r100 = new ASRStrengthenConfig(1, 0);
        V1_CN = r100;
        ASRStrengthenConfig r101 = new ASRStrengthenConfig(2, 0);
        V2_CN = r101;
        V3_CN = new ASRStrengthenConfig(0, 1);
        V4_CN = new ASRStrengthenConfig(0, 2);
        V5_CN = new ASRStrengthenConfig(0, 3);
        V1_I18N = r100;
        V2_I18N = r101;
    }

    public static final /* synthetic */ ASRStrengthenConfig access$getV0$cp() {
        return V0;
    }

    public static final /* synthetic */ ASRStrengthenConfig access$getV1_CN$cp() {
        return V1_CN;
    }

    public static final /* synthetic */ ASRStrengthenConfig access$getV1_I18N$cp() {
        return V1_I18N;
    }

    public static final /* synthetic */ ASRStrengthenConfig access$getV2_CN$cp() {
        return V2_CN;
    }

    public static final /* synthetic */ ASRStrengthenConfig access$getV2_I18N$cp() {
        return V2_I18N;
    }

    public static final /* synthetic */ ASRStrengthenConfig access$getV3_CN$cp() {
        return V3_CN;
    }

    public static final /* synthetic */ ASRStrengthenConfig access$getV4_CN$cp() {
        return V4_CN;
    }

    public static final /* synthetic */ ASRStrengthenConfig access$getV5_CN$cp() {
        return V5_CN;
    }

    public final Integer getAsrSpeakStyle() {
        return this.asrSpeakStyle;
    }

    public final Integer getInputHintStyle() {
        return this.inputHintStyle;
    }

    public ASRStrengthenConfig(Integer r100, Integer r101) {
        this.inputHintStyle = r100;
        this.asrSpeakStyle = r101;
    }

    public /* synthetic */ ASRStrengthenConfig(Integer r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
