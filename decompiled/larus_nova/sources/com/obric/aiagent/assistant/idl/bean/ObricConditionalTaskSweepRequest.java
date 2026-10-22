package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/ObricConditionalTaskSweepRequest;", "Landroid/os/Parcelable;", "taskList", "", "Lcom/obric/aiagent/assistant/idl/bean/ObricConditionalTaskCreateRequest;", "extra", "", "", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getTaskList", "()Ljava/util/List;", "getExtra", "()Ljava/util/Map;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricConditionalTaskSweepRequest implements Parcelable {
    public static final Parcelable.Creator<ObricConditionalTaskSweepRequest> CREATOR = null;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("task_list")
    private final List<ObricConditionalTaskCreateRequest> taskList;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<ObricConditionalTaskSweepRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ObricConditionalTaskSweepRequest createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = 0;
            LinkedHashMap r102 = null;
            if (r100.readInt() != 0) goto L5;
            ArrayList r103 = null;
        L9:
            if (r100.readInt() == 0) goto L15;
            int r104 = r100.readInt();
            r102 = new LinkedHashMap(r104);
        L12:
            if (r101 == r104) goto L15;
            r102.put(r100.readString(), r100.readString());
            r101 = r101 + 1;
        L15:
            return new ObricConditionalTaskSweepRequest(r103, r102);
        L5:
            int r105 = r100.readInt();
            r103 = new ArrayList(r105);
            int r106 = 0;
        L6:
            if (r106 == r105) goto L9;
            r103.add(ObricConditionalTaskCreateRequest.CREATOR.createFromParcel(r100));
            r106 = r106 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ObricConditionalTaskSweepRequest[] newArray(int r100) {
            return new ObricConditionalTaskSweepRequest[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricConditionalTaskSweepRequest() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricConditionalTaskSweepRequest copy$default(ObricConditionalTaskSweepRequest r100, List r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.taskList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extra;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<ObricConditionalTaskCreateRequest> component1() {
        return this.taskList;
    }

    public final Map<String, String> component2() {
        return this.extra;
    }

    public final ObricConditionalTaskSweepRequest copy(List<ObricConditionalTaskCreateRequest> r100, Map<String, String> r101) {
        return new ObricConditionalTaskSweepRequest(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricConditionalTaskSweepRequest) == true) goto L8;
        return false;
    L8:
        ObricConditionalTaskSweepRequest r101 = (ObricConditionalTaskSweepRequest) r100;
        if (Intrinsics.areEqual(this.taskList, r101.taskList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<ObricConditionalTaskCreateRequest> r100 = this.taskList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.extra;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricConditionalTaskSweepRequest(taskList=" + this.taskList + ", extra=" + this.extra + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<ObricConditionalTaskCreateRequest> r102 = this.taskList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        Map<String, String> r103 = this.extra;
        if (r103 != null) goto L12;
        r100.writeInt(0);
        return;
    L12:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L14:
        if (r104.hasNext() == false) goto L19;
        Map.Entry<String, String> r105 = r104.next();
        r100.writeString(r105.getKey());
        r100.writeString(r105.getValue());
        goto L14
    L19:
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<ObricConditionalTaskCreateRequest> r106 = r102.iterator();
    L7:
        if (r106.hasNext() == false) goto L9;
        r106.next().writeToParcel(r100, r101);
        goto L7
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final List<ObricConditionalTaskCreateRequest> getTaskList() {
        return this.taskList;
    }

    public ObricConditionalTaskSweepRequest(List<ObricConditionalTaskCreateRequest> r100, Map<String, String> r101) {
        this.taskList = r100;
        this.extra = r101;
    }

    public /* synthetic */ ObricConditionalTaskSweepRequest(List r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
