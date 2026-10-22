package com.obric.assistant.tipoff;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b9\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÁ\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010E\u001a\u00020FJ\u0013\u0010G\u001a\u00020\b2\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020FHÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001J\u0016\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020FR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010!\"\u0004\b\"\u0010#R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0018R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0018R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0018R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0018¨\u0006Q"}, d2 = {"Lcom/obric/assistant/tipoff/ObricTipOffDialogExtraParams;", "Landroid/os/Parcelable;", "dialogTitle", "", "dialogSubtitle", "inputHint", "commitBtnText", "isFromDislike", "", "dislikeExtraBundle", "Landroid/os/Bundle;", "guiLogList", "", "omniTaskId", "feedbackMsgId", "feedbackSource", "feedbackBizType", "searchTool", "feedbackTrackBotId", "feedbackTrackConversationId", "feedbackTrackMessageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/os/Bundle;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDialogTitle", "()Ljava/lang/String;", "setDialogTitle", "(Ljava/lang/String;)V", "getDialogSubtitle", "setDialogSubtitle", "getInputHint", "setInputHint", "getCommitBtnText", "setCommitBtnText", "()Z", "setFromDislike", "(Z)V", "getDislikeExtraBundle", "()Landroid/os/Bundle;", "setDislikeExtraBundle", "(Landroid/os/Bundle;)V", "getGuiLogList", "()Ljava/util/List;", "setGuiLogList", "(Ljava/util/List;)V", "getOmniTaskId", "setOmniTaskId", "getFeedbackMsgId", "getFeedbackSource", "getFeedbackBizType", "getSearchTool", "getFeedbackTrackBotId", "getFeedbackTrackConversationId", "getFeedbackTrackMessageId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTipOffDialogExtraParams implements Parcelable {
    public static final Parcelable.Creator<ObricTipOffDialogExtraParams> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f393446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f393447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f393448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f393449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f393450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f393451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f393452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f393453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f393454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f393455j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f393456k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f393457l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f393458m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f393459n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f393460o;

    public static final class a implements Parcelable.Creator<ObricTipOffDialogExtraParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ObricTipOffDialogExtraParams createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            boolean r104 = true;
        L7:
            return new ObricTipOffDialogExtraParams(r100, r101, r102, r103, r104, r110.readBundle(ObricTipOffDialogExtraParams.class.getClassLoader()), r110.createStringArrayList(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString());
        L5:
            r104 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ObricTipOffDialogExtraParams[] newArray(int r100) {
            return new ObricTipOffDialogExtraParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ObricTipOffDialogExtraParams() {
        this(null, null, null, null, false, null, null, null, null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricTipOffDialogExtraParams) == true) goto L8;
        return false;
    L8:
        ObricTipOffDialogExtraParams r101 = (ObricTipOffDialogExtraParams) r100;
        if (Intrinsics.areEqual(this.f393446a, r101.f393446a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f393447b, r101.f393447b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f393448c, r101.f393448c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f393449d, r101.f393449d) == true) goto L21;
        return false;
    L21:
        if (this.f393450e == r101.f393450e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f393451f, r101.f393451f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f393452g, r101.f393452g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f393453h, r101.f393453h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f393454i, r101.f393454i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f393455j, r101.f393455j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f393456k, r101.f393456k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f393457l, r101.f393457l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f393458m, r101.f393458m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f393459n, r101.f393459n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f393460o, r101.f393460o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f393446a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f393447b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f393448c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f393449d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f393450e == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        Bundle r115 = this.f393451f;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        List<String> r118 = this.f393452g;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.f393453h;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.f393454i;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        String r127 = this.f393455j;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        String r130 = this.f393456k;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        String r133 = this.f393457l;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        String r136 = this.f393458m;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        String r139 = this.f393459n;
        if (r139 != null) goto L57;
        int r140 = 0;
    L58:
        int r141 = (r138 + r140) * 31;
        String r142 = this.f393460o;
        if (r142 == null) goto L63;
        r101 = r142.hashCode();
    L63:
        return r141 + r101;
    L57:
        r140 = r139.hashCode();
        goto L58
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = 1237;
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

    public final String toString() {
        return "ObricTipOffDialogExtraParams(dialogTitle=" + this.f393446a + ", dialogSubtitle=" + this.f393447b + ", inputHint=" + this.f393448c + ", commitBtnText=" + this.f393449d + ", isFromDislike=" + this.f393450e + ", dislikeExtraBundle=" + this.f393451f + ", guiLogList=" + this.f393452g + ", omniTaskId=" + this.f393453h + ", feedbackMsgId=" + this.f393454i + ", feedbackSource=" + this.f393455j + ", feedbackBizType=" + this.f393456k + ", searchTool=" + this.f393457l + ", feedbackTrackBotId=" + this.f393458m + ", feedbackTrackConversationId=" + this.f393459n + ", feedbackTrackMessageId=" + this.f393460o + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f393446a);
        r100.writeString(this.f393447b);
        r100.writeString(this.f393448c);
        r100.writeString(this.f393449d);
        r100.writeInt(this.f393450e ? 1 : 0);
        r100.writeBundle(this.f393451f);
        r100.writeStringList(this.f393452g);
        r100.writeString(this.f393453h);
        r100.writeString(this.f393454i);
        r100.writeString(this.f393455j);
        r100.writeString(this.f393456k);
        r100.writeString(this.f393457l);
        r100.writeString(this.f393458m);
        r100.writeString(this.f393459n);
        r100.writeString(this.f393460o);
    }

    public ObricTipOffDialogExtraParams(String r100, String r101, String r102, String r103, boolean r104, Bundle r105, List<String> r106, String r107, String r108, String r110, String r111, String r112, String r113, String r114, String r115) {
        this.f393446a = r100;
        this.f393447b = r101;
        this.f393448c = r102;
        this.f393449d = r103;
        this.f393450e = r104;
        this.f393451f = r105;
        this.f393452g = r106;
        this.f393453h = r107;
        this.f393454i = r108;
        this.f393455j = r110;
        this.f393456k = r111;
        this.f393457l = r112;
        this.f393458m = r113;
        this.f393459n = r114;
        this.f393460o = r115;
    }
}
