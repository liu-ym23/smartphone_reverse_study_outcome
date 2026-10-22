package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r¨\u0006'"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/ShortcutRecommendItem;", "Landroid/os/Parcelable;", DBDefinition.TASK_ID, "", "originQuery", "shortQuery", "isShortInstructEnable", "", "createTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V", "getTaskId", "()Ljava/lang/String;", "getOriginQuery", "getShortQuery", "()Z", "getCreateTime", "()J", "displayText", "getDisplayText", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShortcutRecommendItem implements Parcelable {
    public static final Parcelable.Creator<ShortcutRecommendItem> CREATOR = null;
    private final long createTime;
    private final boolean isShortInstructEnable;
    private final String originQuery;
    private final String shortQuery;
    private final String taskId;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<ShortcutRecommendItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutRecommendItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            String r103 = r100.readString();
            if (r100.readInt() == 0) goto L5;
            boolean r104 = true;
        L7:
            return new ShortcutRecommendItem(r101, r102, r103, r104, r100.readLong());
        L5:
            r104 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutRecommendItem[] newArray(int r100) {
            return new ShortcutRecommendItem[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ ShortcutRecommendItem copy$default(ShortcutRecommendItem r100, String r101, String r102, String r103, boolean r104, long r105, int r110, Object r111) {
        if ((r110 & 1) == 0) goto L6;
        r101 = r100.taskId;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r102 = r100.originQuery;
    L8:
        String r112 = r102;
        if ((r110 & 4) == 0) goto L11;
        r103 = r100.shortQuery;
    L11:
        String r106 = r103;
        if ((r110 & 8) == 0) goto L14;
        r104 = r100.isShortInstructEnable;
    L14:
        boolean r107 = r104;
        if ((r110 & 16) == 0) goto L17;
        r105 = r100.createTime;
    L17:
        String r108 = r101;
        return r100.copy(r108, r112, r106, r107, r105);
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.originQuery;
    }

    public final String component3() {
        return this.shortQuery;
    }

    public final boolean component4() {
        return this.isShortInstructEnable;
    }

    public final long component5() {
        return this.createTime;
    }

    public final ShortcutRecommendItem copy(String r100, String r110, String r111, boolean r112, long r113) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r110, "originQuery");
        return new ShortcutRecommendItem(r100, r110, r111, r112, r113);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShortcutRecommendItem) == true) goto L8;
        return false;
    L8:
        ShortcutRecommendItem r101 = (ShortcutRecommendItem) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originQuery, r101.originQuery) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.shortQuery, r101.shortQuery) == true) goto L18;
        return false;
    L18:
        if (this.isShortInstructEnable == r101.isShortInstructEnable) goto L21;
        return false;
    L21:
        if (this.createTime == r101.createTime) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.taskId.hashCode() * 31) + this.originQuery.hashCode()) * 31;
        String r101 = this.shortQuery;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isShortInstructEnable == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        long r106 = this.createTime;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ShortcutRecommendItem(taskId=" + this.taskId + ", originQuery=" + this.originQuery + ", shortQuery=" + this.shortQuery + ", isShortInstructEnable=" + this.isShortInstructEnable + ", createTime=" + this.createTime + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.taskId);
        r100.writeString(this.originQuery);
        r100.writeString(this.shortQuery);
        r100.writeInt(this.isShortInstructEnable ? 1 : 0);
        r100.writeLong(this.createTime);
    }

    public final String getDisplayText() {
        String r100 = this.shortQuery;
        String r101 = null;
        if (r100 != null) goto L5;
    L7:
        r100 = null;
    L8:
        String r102 = this.originQuery;
        if ((!StringsKt.isBlank(r102)) == false) goto L12;
        r101 = r102;
    L12:
        if (this.isShortInstructEnable == false) goto L16;
        if (r100 != null) goto L21;
        if (r101 == null) goto L23;
    L20:
        return r101;
    L23:
        return "";
    L21:
        return r100;
    L16:
        if (r101 != null) goto L20;
        if (r100 == null) goto L23;
        return r100;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        goto L7
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getOriginQuery() {
        return this.originQuery;
    }

    public final String getShortQuery() {
        return this.shortQuery;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
    }

    public ShortcutRecommendItem(String r100, String r101, String r102, boolean r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "originQuery");
        this.taskId = r100;
        this.originQuery = r101;
        this.shortQuery = r102;
        this.isShortInstructEnable = r103;
        this.createTime = r104;
    }
}
