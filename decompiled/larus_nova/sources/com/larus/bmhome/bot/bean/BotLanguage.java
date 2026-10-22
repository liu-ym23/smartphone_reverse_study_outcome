package com.larus.bmhome.bot.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006!"}, d2 = {"Lcom/larus/bmhome/bot/bean/BotLanguage;", "Landroid/os/Parcelable;", UserInfo.LANGUAGECODE, "", "language", "languageLocal", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLanguageCode", "()Ljava/lang/String;", "setLanguageCode", "(Ljava/lang/String;)V", "getLanguage", "setLanguage", "getLanguageLocal", "setLanguageLocal", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotLanguage implements Parcelable {
    public static final Parcelable.Creator<BotLanguage> CREATOR = null;

    @SerializedName("language")
    private String language;

    @SerializedName("language_code")
    private String languageCode;

    @SerializedName("language_loc")
    private String languageLocal;

    public static final class a implements Parcelable.Creator<BotLanguage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotLanguage createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new BotLanguage(r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final BotLanguage[] newArray(int r100) {
            return new BotLanguage[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotLanguage) == true) goto L8;
        return false;
    L8:
        BotLanguage r101 = (BotLanguage) r100;
        if (Intrinsics.areEqual(this.languageCode, r101.languageCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.language, r101.language) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.languageLocal, r101.languageLocal) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.languageCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.language;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.languageLocal;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotLanguage(languageCode=" + this.languageCode + ", language=" + this.language + ", languageLocal=" + this.languageLocal + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.languageCode);
        r100.writeString(this.language);
        r100.writeString(this.languageLocal);
    }

    public BotLanguage() {
        this("", "", "");
    }

    public final String b() {
        return this.language;
    }

    public final String c() {
        return this.languageCode;
    }

    public final String d() {
        return this.languageLocal;
    }

    public static BotLanguage a(BotLanguage r100) {
        return new BotLanguage(r100.languageCode, r100.language, r100.languageLocal);
    }

    public BotLanguage(String r100, String r101, String r102) {
        this.languageCode = r100;
        this.language = r101;
        this.languageLocal = r102;
    }
}
