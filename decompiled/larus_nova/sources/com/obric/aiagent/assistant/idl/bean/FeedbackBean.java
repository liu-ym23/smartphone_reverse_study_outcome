package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cR%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/FeedbackBean;", "Landroid/os/Parcelable;", "filePath", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "description", "needReportVoc", "", "launchReportAppWhenNoPermission", "needShowToast", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;ZZZ)V", "getFilePath", "()Ljava/util/ArrayList;", "getDescription", "()Ljava/lang/String;", "getNeedReportVoc", "()Z", "getLaunchReportAppWhenNoPermission", "getNeedShowToast", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackBean implements Parcelable {
    public static final Parcelable.Creator<FeedbackBean> CREATOR = null;
    private final String description;
    private final ArrayList<String> filePath;
    private final boolean launchReportAppWhenNoPermission;
    private final boolean needReportVoc;
    private final boolean needShowToast;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<FeedbackBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeedbackBean createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ArrayList<String> r101 = r100.createStringArrayList();
            String r102 = r100.readString();
            if (r100.readInt() == 0) goto L5;
            boolean r103 = true;
        L7:
            if (r100.readInt() == 0) goto L9;
            boolean r104 = true;
        L11:
            if (r100.readInt() == 0) goto L13;
            boolean r105 = true;
        L15:
            return new FeedbackBean(r101, r102, r103, r104, r105);
        L13:
            r105 = false;
            goto L15
        L9:
            r104 = false;
            goto L11
        L5:
            r103 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FeedbackBean[] newArray(int r100) {
            return new FeedbackBean[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedbackBean copy$default(FeedbackBean r100, ArrayList r101, String r102, boolean r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.filePath;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.description;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.needReportVoc;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.launchReportAppWhenNoPermission;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.needShowToast;
    L17:
        ArrayList r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final ArrayList<String> component1() {
        return this.filePath;
    }

    public final String component2() {
        return this.description;
    }

    public final boolean component3() {
        return this.needReportVoc;
    }

    public final boolean component4() {
        return this.launchReportAppWhenNoPermission;
    }

    public final boolean component5() {
        return this.needShowToast;
    }

    public final FeedbackBean copy(ArrayList<String> r100, String r101, boolean r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r101, "description");
        return new FeedbackBean(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedbackBean) == true) goto L8;
        return false;
    L8:
        FeedbackBean r101 = (FeedbackBean) r100;
        if (Intrinsics.areEqual(this.filePath, r101.filePath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L15;
        return false;
    L15:
        if (this.needReportVoc == r101.needReportVoc) goto L18;
        return false;
    L18:
        if (this.launchReportAppWhenNoPermission == r101.launchReportAppWhenNoPermission) goto L21;
        return false;
    L21:
        if (this.needShowToast == r101.needShowToast) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        ArrayList<String> r100 = this.filePath;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + this.description.hashCode()) * 31;
        int r103 = 1231;
        if (this.needReportVoc == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.launchReportAppWhenNoPermission == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.needShowToast == true) goto L19;
        r103 = 1237;
    L19:
        return r107 + r103;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "FeedbackBean(filePath=" + this.filePath + ", description=" + this.description + ", needReportVoc=" + this.needReportVoc + ", launchReportAppWhenNoPermission=" + this.launchReportAppWhenNoPermission + ", needShowToast=" + this.needShowToast + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeStringList(this.filePath);
        r100.writeString(this.description);
        r100.writeInt(this.needReportVoc ? 1 : 0);
        r100.writeInt(this.launchReportAppWhenNoPermission ? 1 : 0);
        r100.writeInt(this.needShowToast ? 1 : 0);
    }

    public final String getDescription() {
        return this.description;
    }

    public final ArrayList<String> getFilePath() {
        return this.filePath;
    }

    public final boolean getLaunchReportAppWhenNoPermission() {
        return this.launchReportAppWhenNoPermission;
    }

    public final boolean getNeedReportVoc() {
        return this.needReportVoc;
    }

    public final boolean getNeedShowToast() {
        return this.needShowToast;
    }

    public FeedbackBean(ArrayList<String> r100, String r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "description");
        this.filePath = r100;
        this.description = r101;
        this.needReportVoc = r102;
        this.launchReportAppWhenNoPermission = r103;
        this.needShowToast = r104;
    }

    public /* synthetic */ FeedbackBean(ArrayList r100, String r101, boolean r110, boolean r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r113 & 16) == 0) goto L9;
        boolean r103 = false;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
