package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/bean/SearchHighlightInfo;", "Landroid/os/Parcelable;", "fieldName", "", "positions", "", "Lcom/larus/bmhome/chat/bean/Position;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getFieldName", "()Ljava/lang/String;", "setFieldName", "(Ljava/lang/String;)V", "getPositions", "()Ljava/util/List;", "setPositions", "(Ljava/util/List;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchHighlightInfo implements Parcelable {
    public static final Parcelable.Creator<SearchHighlightInfo> CREATOR = null;

    @SerializedName("field_name")
    private String fieldName;

    @SerializedName("keyword_positions")
    private List<Position> positions;

    public static final class a implements Parcelable.Creator<SearchHighlightInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchHighlightInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            ArrayList r102 = null;
            if (r100.readInt() == 0) goto L14;
            int r103 = r100.readInt();
            ArrayList r104 = new ArrayList(r103);
            int r105 = 0;
        L6:
            if (r105 == r103) goto L12;
            if (r100.readInt() != 0) goto L10;
            Position r106 = null;
        L11:
            r104.add(r106);
            r105 = r105 + 1;
            goto L6
        L10:
            r106 = Position.CREATOR.createFromParcel(r100);
            goto L11
        L12:
            r102 = r104;
        L14:
            return new SearchHighlightInfo(r101, r102);
        }

        @Override // android.os.Parcelable.Creator
        public final SearchHighlightInfo[] newArray(int r100) {
            return new SearchHighlightInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SearchHighlightInfo() {
        this(null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchHighlightInfo) == true) goto L8;
        return false;
    L8:
        SearchHighlightInfo r101 = (SearchHighlightInfo) r100;
        if (Intrinsics.areEqual(this.fieldName, r101.fieldName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.positions, r101.positions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.fieldName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Position> r104 = this.positions;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchHighlightInfo(fieldName=" + this.fieldName + ", positions=" + this.positions + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.fieldName);
        List<Position> r102 = this.positions;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Position> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        Position r104 = r103.next();
        if (r104 == null) goto L10;
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public SearchHighlightInfo(String r100, List<Position> r101) {
        this.fieldName = r100;
        this.positions = r101;
    }
}
