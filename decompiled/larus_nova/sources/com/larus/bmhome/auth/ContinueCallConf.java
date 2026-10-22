package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006 "}, d2 = {"Lcom/larus/bmhome/auth/ContinueCallConf;", "Landroid/os/Parcelable;", "showOnInputASR", "", "showOnActionbar", "showOnSpeakText", "showOnSpeakIcon", "<init>", "(ZZZZ)V", "getShowOnInputASR", "()Z", "getShowOnActionbar", "getShowOnSpeakText", "getShowOnSpeakIcon", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContinueCallConf implements Parcelable {
    public static final Parcelable.Creator<ContinueCallConf> CREATOR = null;

    @SerializedName("show_on_action_bar")
    private final boolean showOnActionbar;

    @SerializedName("show_on_input_asr")
    private final boolean showOnInputASR;

    @SerializedName("show_on_speak_icon")
    private final boolean showOnSpeakIcon;

    @SerializedName("show_on_speak_text")
    private final boolean showOnSpeakText;

    public static final class a implements Parcelable.Creator<ContinueCallConf> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ContinueCallConf createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            boolean r101 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            if (r100.readInt() == 0) goto L9;
            boolean r103 = true;
        L11:
            if (r100.readInt() == 0) goto L13;
            boolean r104 = true;
        L15:
            if (r100.readInt() == 0) goto L18;
            r101 = true;
        L18:
            return new ContinueCallConf(r102, r103, r104, r101);
        L13:
            r104 = false;
            goto L15
        L9:
            r103 = false;
            goto L11
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ContinueCallConf[] newArray(int r100) {
            return new ContinueCallConf[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ContinueCallConf() {
        this(false, false, false, false);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ContinueCallConf) == true) goto L8;
        return false;
    L8:
        ContinueCallConf r101 = (ContinueCallConf) r100;
        if (this.showOnInputASR == r101.showOnInputASR) goto L12;
        return false;
    L12:
        if (this.showOnActionbar == r101.showOnActionbar) goto L15;
        return false;
    L15:
        if (this.showOnSpeakText == r101.showOnSpeakText) goto L18;
        return false;
    L18:
        if (this.showOnSpeakIcon == r101.showOnSpeakIcon) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.showOnInputASR == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.showOnActionbar == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.showOnSpeakText == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.showOnSpeakIcon == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ContinueCallConf(showOnInputASR=" + this.showOnInputASR + ", showOnActionbar=" + this.showOnActionbar + ", showOnSpeakText=" + this.showOnSpeakText + ", showOnSpeakIcon=" + this.showOnSpeakIcon + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.showOnInputASR ? 1 : 0);
        r100.writeInt(this.showOnActionbar ? 1 : 0);
        r100.writeInt(this.showOnSpeakText ? 1 : 0);
        r100.writeInt(this.showOnSpeakIcon ? 1 : 0);
    }

    public final boolean a() {
        return this.showOnActionbar;
    }

    public final boolean b() {
        return this.showOnInputASR;
    }

    public final boolean c() {
        return this.showOnSpeakIcon;
    }

    public final boolean d() {
        return this.showOnSpeakText;
    }

    public ContinueCallConf(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.showOnInputASR = r100;
        this.showOnActionbar = r101;
        this.showOnSpeakText = r102;
        this.showOnSpeakIcon = r103;
    }
}
