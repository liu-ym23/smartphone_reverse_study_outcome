package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "Landroid/os/Parcelable;", "isIdle", "", "isQuerying", "activeTasks", "", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "cardSession", "Lcom/obric/aiagent/assistant/idl/bean/IslandCardSession;", "<init>", "(ZZLjava/util/List;Lcom/obric/aiagent/assistant/idl/bean/IslandCardSession;)V", "()Z", "getActiveTasks", "()Ljava/util/List;", "getCardSession", "()Lcom/obric/aiagent/assistant/idl/bean/IslandCardSession;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DMStateInfo implements Parcelable {
    public static final Parcelable.Creator<DMStateInfo> CREATOR = null;
    private final List<DMTaskState> activeTasks;
    private final IslandCardSession cardSession;
    private final boolean isIdle;
    private final boolean isQuerying;

    public static final class a implements Parcelable.Creator<DMStateInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DMStateInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = 0;
            boolean r102 = true;
            if (r100.readInt() == 0) goto L5;
            boolean r103 = true;
        L7:
            if (r100.readInt() != 0) goto L10;
            r102 = false;
        L10:
            int r104 = r100.readInt();
            ArrayList r105 = new ArrayList(r104);
        L11:
            if (r101 == r104) goto L14;
            r105.add(DMTaskState.CREATOR.createFromParcel(r100));
            r101 = r101 + 1;
            goto L11
        L14:
            if (r100.readInt() != 0) goto L16;
            IslandCardSession r106 = null;
        L18:
            return new DMStateInfo(r103, r102, r105, r106);
        L16:
            r106 = IslandCardSession.CREATOR.createFromParcel(r100);
            goto L18
        L5:
            r103 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final DMStateInfo[] newArray(int r100) {
            return new DMStateInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DMStateInfo copy$default(DMStateInfo r100, boolean r101, boolean r102, List r103, IslandCardSession r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.isIdle;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isQuerying;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.activeTasks;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.cardSession;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.isIdle;
    }

    public final boolean component2() {
        return this.isQuerying;
    }

    public final List<DMTaskState> component3() {
        return this.activeTasks;
    }

    public final IslandCardSession component4() {
        return this.cardSession;
    }

    public final DMStateInfo copy(boolean r100, boolean r101, List<DMTaskState> r102, IslandCardSession r103) {
        Intrinsics.checkNotNullParameter(r102, "activeTasks");
        return new DMStateInfo(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DMStateInfo) == true) goto L8;
        return false;
    L8:
        DMStateInfo r101 = (DMStateInfo) r100;
        if (this.isIdle == r101.isIdle) goto L12;
        return false;
    L12:
        if (this.isQuerying == r101.isQuerying) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.activeTasks, r101.activeTasks) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cardSession, r101.cardSession) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isIdle == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isQuerying == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((r102 + r100) * 31) + this.activeTasks.hashCode()) * 31;
        IslandCardSession r104 = this.cardSession;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "DMStateInfo(isIdle=" + this.isIdle + ", isQuerying=" + this.isQuerying + ", activeTasks=" + this.activeTasks + ", cardSession=" + this.cardSession + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.isIdle ? 1 : 0);
        r100.writeInt(this.isQuerying ? 1 : 0);
        List<DMTaskState> r102 = this.activeTasks;
        r100.writeInt(r102.size());
        Iterator<DMTaskState> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().writeToParcel(r100, r101);
        goto L4
    L6:
        IslandCardSession r104 = this.cardSession;
        if (r104 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
    }

    public final List<DMTaskState> getActiveTasks() {
        return this.activeTasks;
    }

    public final IslandCardSession getCardSession() {
        return this.cardSession;
    }

    public final boolean isIdle() {
        return this.isIdle;
    }

    public final boolean isQuerying() {
        return this.isQuerying;
    }

    public DMStateInfo(boolean r100, boolean r101, List<DMTaskState> r102, IslandCardSession r103) {
        Intrinsics.checkNotNullParameter(r102, "activeTasks");
        this.isIdle = r100;
        this.isQuerying = r101;
        this.activeTasks = r102;
        this.cardSession = r103;
    }
}
