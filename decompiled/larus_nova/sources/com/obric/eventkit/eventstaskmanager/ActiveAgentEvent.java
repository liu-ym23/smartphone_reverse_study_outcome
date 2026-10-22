package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*Ba\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016R$\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R$\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R$\u0010\"\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011¨\u0006+"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "parcel", "readFromParcel", "", "toString", "query", "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "", "openMic", "Z", "getOpenMic", "()Z", "setOpenMic", "(Z)V", "forceOmni", "getForceOmni", "setForceOmni", "expandState", "getExpandState", "setExpandState", "instructionType", "getInstructionType", "setInstructionType", "instructionEntry", "getInstructionEntry", "setInstructionEntry", "id", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ActiveAgentEvent extends AppEvent {
    public static final a CREATOR = null;
    private String expandState;
    private boolean forceOmni;
    private String instructionEntry;
    private String instructionType;
    private boolean openMic;
    private String query;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ActiveAgentEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ActiveAgentEvent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            return (ActiveAgentEvent) AppEvent.CREATOR.createAppEventFromParcel$eventstaskkit_release(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ActiveAgentEvent[] newArray(int r100) {
            return new ActiveAgentEvent[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ActiveAgentEvent() {
        this(null, null, null, false, false, null, null, null, 255, null);
    }

    public ActiveAgentEvent(String r100, String r101, String r102, boolean r103, boolean r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r105, "expandState");
        super(r100, r101, null);
        this.query = r102;
        this.openMic = r103;
        this.forceOmni = r104;
        this.expandState = r105;
        this.instructionType = r106;
        this.instructionEntry = r107;
    }

    public /* synthetic */ ActiveAgentEvent(String r110, String r111, String r112, boolean r113, boolean r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L14:
        boolean r104 = false;
        if ((r118 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r118 & 16) != 0) goto L23;
        r104 = r114;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = "half";
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r105, r104, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String getExpandState() {
        return this.expandState;
    }

    public final boolean getForceOmni() {
        return this.forceOmni;
    }

    public final String getInstructionEntry() {
        return this.instructionEntry;
    }

    public final String getInstructionType() {
        return this.instructionType;
    }

    public final boolean getOpenMic() {
        return this.openMic;
    }

    public final String getQuery() {
        return this.query;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public void readFromParcel(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.readFromParcel(r100);
        this.query = r100.readString();
        boolean r101 = true;
        if (r100.readInt() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.openMic = r102;
        if (r100.readInt() != 0) goto L10;
        r101 = false;
    L10:
        this.forceOmni = r101;
        String r103 = r100.readString();
        if (r103 != null) goto L13;
        r103 = "half";
    L13:
        this.expandState = r103;
        this.instructionType = r100.readString();
        this.instructionEntry = r100.readString();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setExpandState(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.expandState = r100;
    }

    public final void setForceOmni(boolean r100) {
        this.forceOmni = r100;
    }

    public final void setInstructionEntry(String r100) {
        this.instructionEntry = r100;
    }

    public final void setInstructionType(String r100) {
        this.instructionType = r100;
    }

    public final void setOpenMic(boolean r100) {
        this.openMic = r100;
    }

    public final void setQuery(String r100) {
        this.query = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public String toString() {
        return "ActiveAgentEvent(id=" + getId() + ", content=" + getContent() + ", extra=" + getExtra() + ", createTime=" + getCreateTime() + ", lastModifiedTime=" + getLastModifiedTime() + ", source='" + getSource() + "', eventType='" + getEventType() + "', query='" + this.query + "', openMic=" + this.openMic + ", forceOmni=" + this.forceOmni + ", expandState='" + this.expandState + "'instructionType='" + this.instructionType + "', instructionEntry='" + this.instructionEntry + "')";
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        super.writeToParcel(r100, r101);
        r100.writeString(this.query);
        r100.writeInt(this.openMic ? 1 : 0);
        r100.writeInt(this.forceOmni ? 1 : 0);
        r100.writeString(this.expandState);
        r100.writeString(this.instructionType);
        r100.writeString(this.instructionEntry);
    }
}
