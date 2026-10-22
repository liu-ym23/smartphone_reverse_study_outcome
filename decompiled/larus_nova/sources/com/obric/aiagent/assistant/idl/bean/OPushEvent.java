package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0003J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OPushEvent;", "Landroid/os/Parcelable;", "eventType", "", "action", "Lcom/obric/aiagent/assistant/idl/bean/OAppAction;", "<init>", "(Ljava/lang/Integer;Lcom/obric/aiagent/assistant/idl/bean/OAppAction;)V", "getEventType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAction", "()Lcom/obric/aiagent/assistant/idl/bean/OAppAction;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/obric/aiagent/assistant/idl/bean/OAppAction;)Lcom/obric/aiagent/assistant/idl/bean/OPushEvent;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OPushEvent implements Parcelable {
    public static final Parcelable.Creator<OPushEvent> CREATOR = null;
    public static final a Companion = null;
    public static final int EVENT_TYPE_APP_ACTION = 3;

    @SerializedName("app_action")
    private final OAppAction action;

    @SerializedName("event_type")
    private final Integer eventType;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b implements Parcelable.Creator<OPushEvent> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final OPushEvent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            OAppAction r101 = null;
            if (r100.readInt() != 0) goto L5;
            Integer r102 = null;
        L7:
            if (r100.readInt() == 0) goto L11;
            r101 = OAppAction.CREATOR.createFromParcel(r100);
        L11:
            return new OPushEvent(r102, r101);
        L5:
            r102 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final OPushEvent[] newArray(int r100) {
            return new OPushEvent[r100];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OPushEvent() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OPushEvent copy$default(OPushEvent r100, Integer r101, OAppAction r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.eventType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.action;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.eventType;
    }

    public final OAppAction component2() {
        return this.action;
    }

    public final OPushEvent copy(Integer r100, OAppAction r101) {
        return new OPushEvent(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OPushEvent) == true) goto L8;
        return false;
    L8:
        OPushEvent r101 = (OPushEvent) r100;
        if (Intrinsics.areEqual(this.eventType, r101.eventType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.eventType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        OAppAction r104 = this.action;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OPushEvent(eventType=" + this.eventType + ", action=" + this.action + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this.eventType;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        OAppAction r103 = this.action;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public final OAppAction getAction() {
        return this.action;
    }

    public final Integer getEventType() {
        return this.eventType;
    }

    public OPushEvent(Integer r100, OAppAction r101) {
        this.eventType = r100;
        this.action = r101;
    }

    public /* synthetic */ OPushEvent(Integer r100, OAppAction r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 3;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
