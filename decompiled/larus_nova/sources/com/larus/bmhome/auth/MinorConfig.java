package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.minor.model.MinorConfigItems;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006'"}, d2 = {"Lcom/larus/bmhome/auth/MinorConfig;", "Landroid/os/Parcelable;", "chatBot", "", "showVideo", "enterWeb", "aiCreation", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getChatBot", "()Ljava/lang/Boolean;", "setChatBot", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getShowVideo", "setShowVideo", "getEnterWeb", "setEnterWeb", "getAiCreation", "setAiCreation", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/bmhome/auth/MinorConfig;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinorConfig implements Parcelable {
    public static final Parcelable.Creator<MinorConfig> CREATOR = null;

    @SerializedName(MinorConfigItems.AI_CREATION)
    private Boolean aiCreation;

    @SerializedName("chat_bot")
    private Boolean chatBot;

    @SerializedName(MinorConfigItems.ENTER_WEB)
    private Boolean enterWeb;

    @SerializedName(MinorConfigItems.SHOW_VIDEO)
    private Boolean showVideo;

    public static final class a implements Parcelable.Creator<MinorConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MinorConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            boolean r101 = false;
            Boolean r102 = null;
            if (r100.readInt() != 0) goto L6;
            Boolean r103 = null;
        L11:
            if (r100.readInt() != 0) goto L14;
            Boolean r104 = null;
        L19:
            if (r100.readInt() != 0) goto L22;
            Boolean r105 = null;
        L27:
            if (r100.readInt() == 0) goto L34;
            if (r100.readInt() == 0) goto L32;
            r101 = true;
        L32:
            r102 = Boolean.valueOf(r101);
        L34:
            return new MinorConfig(r103, r104, r105, r102);
        L22:
            if (r100.readInt() == 0) goto L24;
            boolean r106 = true;
        L25:
            r105 = Boolean.valueOf(r106);
            goto L27
        L24:
            r106 = false;
            goto L25
        L14:
            if (r100.readInt() == 0) goto L16;
            boolean r107 = true;
        L17:
            r104 = Boolean.valueOf(r107);
            goto L19
        L16:
            r107 = false;
            goto L17
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r108 = true;
        L9:
            r103 = Boolean.valueOf(r108);
            goto L11
        L8:
            r108 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final MinorConfig[] newArray(int r100) {
            return new MinorConfig[r100];
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
        if ((r100 instanceof MinorConfig) == true) goto L8;
        return false;
    L8:
        MinorConfig r101 = (MinorConfig) r100;
        if (Intrinsics.areEqual(this.chatBot, r101.chatBot) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showVideo, r101.showVideo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enterWeb, r101.enterWeb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.aiCreation, r101.aiCreation) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.chatBot;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.showVideo;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.enterWeb;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.aiCreation;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public final String toString() {
        return "MinorConfig(chatBot=" + this.chatBot + ", showVideo=" + this.showVideo + ", enterWeb=" + this.enterWeb + ", aiCreation=" + this.aiCreation + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Boolean r102 = this.chatBot;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.showVideo;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Boolean r104 = this.enterWeb;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        Boolean r105 = this.aiCreation;
        if (r105 != null) goto L17;
        r100.writeInt(0);
        return;
    L17:
        r100.writeInt(1);
        r100.writeInt(r105.booleanValue() ? 1 : 0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public MinorConfig() {
        Boolean r100 = Boolean.FALSE;
        this(r100, r100, r100, r100);
    }

    public MinorConfig(Boolean r100, Boolean r101, Boolean r102, Boolean r103) {
        this.chatBot = r100;
        this.showVideo = r101;
        this.enterWeb = r102;
        this.aiCreation = r103;
    }
}
