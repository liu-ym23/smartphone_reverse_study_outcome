package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J[\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u0003J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006*"}, d2 = {"Lcom/larus/bmhome/auth/SpeechLanguage;", "Landroid/os/Parcelable;", "idx", "", "language", "", "languageEN", "languageLocal", "ttsVoiceTypeId", "ttsLanguage", "asrLanguage", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIdx", "()I", "getLanguage", "()Ljava/lang/String;", "getLanguageEN", "getLanguageLocal", "getTtsVoiceTypeId", "getTtsLanguage", "getAsrLanguage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechLanguage implements Parcelable {
    public static final Parcelable.Creator<SpeechLanguage> CREATOR = null;

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_ASR_LANGUAGE_STRING)
    private final String asrLanguage;

    @SerializedName("idx")
    private final int idx;

    @SerializedName("language")
    private final String language;

    @SerializedName("language_en")
    private final String languageEN;

    @SerializedName("language_loc")
    private final String languageLocal;

    @SerializedName("tts_language")
    private final String ttsLanguage;

    @SerializedName("tts_voice_type_id")
    private final String ttsVoiceTypeId;

    public static final class a implements Parcelable.Creator<SpeechLanguage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpeechLanguage createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new SpeechLanguage(r110.readInt(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SpeechLanguage[] newArray(int r100) {
            return new SpeechLanguage[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SpeechLanguage() {
        this(-1, "", "", "", "", "", "");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechLanguage) == true) goto L8;
        return false;
    L8:
        SpeechLanguage r101 = (SpeechLanguage) r100;
        if (this.idx == r101.idx) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.languageEN, r101.languageEN) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.languageLocal, r101.languageLocal) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ttsVoiceTypeId, r101.ttsVoiceTypeId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ttsLanguage, r101.ttsLanguage) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.asrLanguage, r101.asrLanguage) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.idx * 31;
        String r101 = this.language;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.languageEN;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.languageLocal;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.ttsVoiceTypeId;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.ttsLanguage;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.asrLanguage;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "SpeechLanguage(idx=" + this.idx + ", language=" + this.language + ", languageEN=" + this.languageEN + ", languageLocal=" + this.languageLocal + ", ttsVoiceTypeId=" + this.ttsVoiceTypeId + ", ttsLanguage=" + this.ttsLanguage + ", asrLanguage=" + this.asrLanguage + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.idx);
        r100.writeString(this.language);
        r100.writeString(this.languageEN);
        r100.writeString(this.languageLocal);
        r100.writeString(this.ttsVoiceTypeId);
        r100.writeString(this.ttsLanguage);
        r100.writeString(this.asrLanguage);
    }

    public final String a() {
        return this.asrLanguage;
    }

    public final int b() {
        return this.idx;
    }

    public final String c() {
        return this.language;
    }

    public SpeechLanguage(int r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.idx = r100;
        this.language = r101;
        this.languageEN = r102;
        this.languageLocal = r103;
        this.ttsVoiceTypeId = r104;
        this.ttsLanguage = r105;
        this.asrLanguage = r106;
    }
}
