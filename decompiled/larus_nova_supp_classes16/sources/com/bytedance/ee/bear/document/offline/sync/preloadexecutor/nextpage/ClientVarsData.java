package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.nextpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0005J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/ClientVarsData;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "code", "", "data", "Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/Data;", "<init>", "(Ljava/lang/Integer;Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/Data;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/Data;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/Data;)Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/ClientVarsData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClientVarsData implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<ClientVarsData> CREATOR = null;
    private final Integer code;
    private final Data data;

    public static final class a implements Parcelable.Creator<ClientVarsData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ClientVarsData createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            Data r2 = null;
            if (r5.readInt() != 0) goto L5;
            Integer r1 = null;
        L7:
            if (r5.readInt() == 0) goto L11;
            r2 = Data.CREATOR.createFromParcel(r5);
        L11:
            return new ClientVarsData(r1, r2);
        L5:
            r1 = Integer.valueOf(r5.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ClientVarsData[] newArray(int r1) {
            return new ClientVarsData[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ ClientVarsData copy$default(ClientVarsData r0, Integer r1, Data r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.data;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.code;
    }

    public final Data component2() {
        return this.data;
    }

    public final ClientVarsData copy(Integer r2, Data r3) {
        return new ClientVarsData(r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ClientVarsData) == true) goto L8;
        return false;
    L8:
        ClientVarsData r6 = (ClientVarsData) r5;
        if (Intrinsics.areEqual(this.code, r6.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.code;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Data r4 = this.data;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ClientVarsData(code=" + this.code + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        Integer r0 = this.code;
        if (r0 != null) goto L5;
        r4.writeInt(0);
    L6:
        Data r1 = this.data;
        if (r1 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r0.intValue());
        goto L6
    }

    public Object clone() {
        return super.clone();
    }

    public final Integer getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }

    public ClientVarsData(Integer r1, Data r2) {
        this.code = r1;
        this.data = r2;
    }
}
