package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/AlarmMessage;", "Landroid/os/Parcelable;", "dataSource", "Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "isEnable", "", "needConfirm", "data", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/obric/aiagent/assistant/idl/bean/DataSource;ZZLjava/util/ArrayList;)V", "getDataSource", "()Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "setDataSource", "(Lcom/obric/aiagent/assistant/idl/bean/DataSource;)V", "()Z", "getNeedConfirm", "getData", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlarmMessage implements Parcelable {
    public static final Parcelable.Creator<AlarmMessage> CREATOR = null;
    private final ArrayList<AlarmEntity> data;
    private DataSource dataSource;
    private final boolean isEnable;
    private final boolean needConfirm;

    public static final class a implements Parcelable.Creator<AlarmMessage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AlarmMessage createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            DataSource r101 = DataSource.CREATOR.createFromParcel(r100);
            int r102 = 0;
            boolean r103 = true;
            if (r100.readInt() == 0) goto L5;
            boolean r104 = true;
        L7:
            if (r100.readInt() != 0) goto L10;
            r103 = false;
        L10:
            int r105 = r100.readInt();
            ArrayList r106 = new ArrayList(r105);
        L11:
            if (r102 == r105) goto L14;
            r106.add(r100.readParcelable(AlarmMessage.class.getClassLoader()));
            r102 = r102 + 1;
            goto L11
        L14:
            return new AlarmMessage(r101, r104, r103, r106);
        L5:
            r104 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AlarmMessage[] newArray(int r100) {
            return new AlarmMessage[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlarmMessage copy$default(AlarmMessage r100, DataSource r101, boolean r102, boolean r103, ArrayList r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.dataSource;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isEnable;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.needConfirm;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.data;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final DataSource component1() {
        return this.dataSource;
    }

    public final boolean component2() {
        return this.isEnable;
    }

    public final boolean component3() {
        return this.needConfirm;
    }

    public final ArrayList<AlarmEntity> component4() {
        return this.data;
    }

    public final AlarmMessage copy(DataSource r100, boolean r101, boolean r102, ArrayList<AlarmEntity> r103) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        Intrinsics.checkNotNullParameter(r103, "data");
        return new AlarmMessage(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AlarmMessage) == true) goto L8;
        return false;
    L8:
        AlarmMessage r101 = (AlarmMessage) r100;
        if (Intrinsics.areEqual(this.dataSource, r101.dataSource) == true) goto L12;
        return false;
    L12:
        if (this.isEnable == r101.isEnable) goto L15;
        return false;
    L15:
        if (this.needConfirm == r101.needConfirm) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.dataSource.hashCode() * 31;
        int r101 = 1231;
        if (this.isEnable == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.needConfirm == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.data.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "AlarmMessage(dataSource=" + this.dataSource + ", isEnable=" + this.isEnable + ", needConfirm=" + this.needConfirm + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        this.dataSource.writeToParcel(r100, r101);
        r100.writeInt(this.isEnable ? 1 : 0);
        r100.writeInt(this.needConfirm ? 1 : 0);
        ArrayList<AlarmEntity> r102 = this.data;
        r100.writeInt(r102.size());
        Iterator<AlarmEntity> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeParcelable(r103.next(), r101);
        goto L4
    }

    public final ArrayList<AlarmEntity> getData() {
        return this.data;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final void setDataSource(DataSource r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dataSource = r100;
    }

    public AlarmMessage(DataSource r100, boolean r101, boolean r102, ArrayList<AlarmEntity> r103) {
        Intrinsics.checkNotNullParameter(r100, "dataSource");
        Intrinsics.checkNotNullParameter(r103, "data");
        this.dataSource = r100;
        this.isEnable = r101;
        this.needConfirm = r102;
        this.data = r103;
    }
}
