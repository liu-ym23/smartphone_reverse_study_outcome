package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J?\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/QuAction;", "Landroid/os/Parcelable;", "actionId", "", "actionName", "", "inputParams", "", "Lcom/obric/memorydata/sdk/entity/search/ParamItem;", "searchResultCount", "<init>", "(ILjava/lang/String;Ljava/util/Map;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getActionId", "()I", "getActionName", "()Ljava/lang/String;", "getInputParams", "()Ljava/util/Map;", "getSearchResultCount", "setSearchResultCount", "(I)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class QuAction implements Parcelable {
    public static final a CREATOR = null;

    @SerializedName("id")
    private final int actionId;
    private final String actionName;
    private final Map<String, ParamItem> inputParams;
    private int searchResultCount;

    public static final class a implements Parcelable.Creator<QuAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QuAction createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new QuAction(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final QuAction[] newArray(int r100) {
            return new QuAction[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuAction copy$default(QuAction r100, int r101, String r102, Map r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.actionId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.actionName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.inputParams;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.searchResultCount;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.actionId;
    }

    public final String component2() {
        return this.actionName;
    }

    public final Map<String, ParamItem> component3() {
        return this.inputParams;
    }

    public final int component4() {
        return this.searchResultCount;
    }

    public final QuAction copy(int r100, String r101, Map<String, ParamItem> r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "actionName");
        return new QuAction(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QuAction) == true) goto L8;
        return false;
    L8:
        QuAction r101 = (QuAction) r100;
        if (this.actionId == r101.actionId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionName, r101.actionName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inputParams, r101.inputParams) == true) goto L18;
        return false;
    L18:
        if (this.searchResultCount == r101.searchResultCount) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.actionId * 31) + this.actionName.hashCode()) * 31;
        Map<String, ParamItem> r101 = this.inputParams;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.searchResultCount;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "QuAction(actionId=" + this.actionId + ", actionName=" + this.actionName + ", inputParams=" + this.inputParams + ", searchResultCount=" + this.searchResultCount + ')';
    }

    public final int getActionId() {
        return this.actionId;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final Map<String, ParamItem> getInputParams() {
        return this.inputParams;
    }

    public final int getSearchResultCount() {
        return this.searchResultCount;
    }

    public QuAction(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        int r101 = r100.readInt();
        String r102 = r100.readString();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this(r101, r102, r100.readHashMap(QuAction.class.getClassLoader()), r100.readInt());
    }

    public final void setSearchResultCount(int r100) {
        this.searchResultCount = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.actionId);
        r100.writeString(this.actionName);
        r100.writeMap(this.inputParams);
        r100.writeInt(this.searchResultCount);
    }

    public QuAction(int r100, String r101, Map<String, ParamItem> r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "actionName");
        this.actionId = r100;
        this.actionName = r101;
        this.inputParams = r102;
        this.searchResultCount = r103;
    }

    public /* synthetic */ QuAction(int r100, String r101, Map r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = 0;
    L5:
        this(r100, r101, r102, r103);
    }
}
