package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Deprecated(message = "old data flow")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012JD\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0004J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/resp/ConversationPage;", "Landroid/os/Parcelable;", "pageList", "", "", "bizType", "defaultStatus", "showActionBar", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getPageList", "()Ljava/util/List;", "getBizType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDefaultStatus", "getShowActionBar", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/resp/ConversationPage;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConversationPage implements Parcelable {
    public static final Parcelable.Creator<ConversationPage> CREATOR = null;

    @SerializedName("biz_type")
    private final Integer bizType;

    @SerializedName("default_status")
    private final Integer defaultStatus;

    @SerializedName("page_list")
    private final List<Integer> pageList;

    @SerializedName("show_action_bar")
    private final Boolean showActionBar;

    public static final class a implements Parcelable.Creator<ConversationPage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConversationPage createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            boolean r101 = false;
            Boolean r102 = null;
            if (r100.readInt() != 0) goto L5;
            ArrayList r103 = null;
        L9:
            if (r100.readInt() != 0) goto L11;
            Integer r104 = null;
        L13:
            if (r100.readInt() != 0) goto L15;
            Integer r105 = null;
        L17:
            if (r100.readInt() == 0) goto L24;
            if (r100.readInt() == 0) goto L22;
            r101 = true;
        L22:
            r102 = Boolean.valueOf(r101);
        L24:
            return new ConversationPage(r103, r104, r105, r102);
        L15:
            r105 = Integer.valueOf(r100.readInt());
            goto L17
        L11:
            r104 = Integer.valueOf(r100.readInt());
            goto L13
        L5:
            int r106 = r100.readInt();
            r103 = new ArrayList(r106);
            int r107 = 0;
        L6:
            if (r107 == r106) goto L9;
            r103.add(Integer.valueOf(r100.readInt()));
            r107 = r107 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ConversationPage[] newArray(int r100) {
            return new ConversationPage[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ConversationPage() {
        this(null, 0, 1, Boolean.FALSE);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConversationPage) == true) goto L8;
        return false;
    L8:
        ConversationPage r101 = (ConversationPage) r100;
        if (Intrinsics.areEqual(this.pageList, r101.pageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizType, r101.bizType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultStatus, r101.defaultStatus) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showActionBar, r101.showActionBar) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<Integer> r100 = this.pageList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.bizType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.defaultStatus;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.showActionBar;
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
        return "ConversationPage(pageList=" + this.pageList + ", bizType=" + this.bizType + ", defaultStatus=" + this.defaultStatus + ", showActionBar=" + this.showActionBar + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<Integer> r102 = this.pageList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        Integer r103 = this.bizType;
        if (r103 != null) goto L12;
        r100.writeInt(0);
    L13:
        Integer r104 = this.defaultStatus;
        if (r104 != null) goto L16;
        r100.writeInt(0);
    L17:
        Boolean r105 = this.showActionBar;
        if (r105 != null) goto L20;
        r100.writeInt(0);
        return;
    L20:
        r100.writeInt(1);
        r100.writeInt(r105.booleanValue() ? 1 : 0);
        return;
    L16:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L17
    L12:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L13
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Integer> r106 = r102.iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        r100.writeInt(r106.next().intValue());
        goto L7
    }

    public ConversationPage(List<Integer> r100, Integer r101, Integer r102, Boolean r103) {
        this.pageList = r100;
        this.bizType = r101;
        this.defaultStatus = r102;
        this.showActionBar = r103;
    }
}
