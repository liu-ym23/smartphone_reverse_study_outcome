package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR&\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/RecorderOperateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "action", "", "doraBluetoothId", "doraProductId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getDoraBluetoothId$annotations", "()V", "getDoraBluetoothId", "setDoraBluetoothId", "getDoraProductId$annotations", "getDoraProductId", "setDoraProductId", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecorderOperateParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<RecorderOperateParams> CREATOR = null;
    private String action;
    String doraBluetoothId;
    String doraProductId;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<RecorderOperateParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RecorderOperateParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            RecorderOperateParams r102 = new RecorderOperateParams(r100.readString(), null, null, 6, null);
            int r103 = Math.min(r101, 2);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L13;
            if (r105 != 1) goto L8;
            Object r106 = joa.a.c(r100, r104);
            if (r106 == null) goto L12;
            r102.doraBluetoothId = (String) r106;
        L12:
            r105 = r105 + 1;
            goto L3
        L8:
            if (r105 != 2) goto L12;
            Object r107 = joa.a.c(r100, r104);
            if (r107 == null) goto L12;
            r102.doraProductId = (String) r107;
        L13:
            if (r105 > r101) goto L15;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L13
        L15:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final RecorderOperateParams[] newArray(int r100) {
            return new RecorderOperateParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public RecorderOperateParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ RecorderOperateParams copy$default(RecorderOperateParams r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.action;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.doraBluetoothId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.doraProductId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public static /* synthetic */ void getDoraBluetoothId$annotations() {
    }

    public static /* synthetic */ void getDoraProductId$annotations() {
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.doraBluetoothId;
    }

    public final String component3() {
        return this.doraProductId;
    }

    public final RecorderOperateParams copy(String r100, String r101, String r102) {
        return new RecorderOperateParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecorderOperateParams) == true) goto L8;
        return false;
    L8:
        RecorderOperateParams r101 = (RecorderOperateParams) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.doraBluetoothId, r101.doraBluetoothId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.doraProductId, r101.doraProductId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.action;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.doraBluetoothId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.doraProductId;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RecorderOperateParams(action=" + this.action + ", doraBluetoothId=" + this.doraBluetoothId + ", doraProductId=" + this.doraProductId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(2);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.action);
        r100.writeValue(this.doraBluetoothId);
        r100.writeValue(this.doraProductId);
    }

    public boolean isParamsCompleted() {
        if (this.action == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getDoraBluetoothId() {
        return this.doraBluetoothId;
    }

    public final String getDoraProductId() {
        return this.doraProductId;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof RecorderOperateParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.action;
        if (r101 != null) goto L8;
        r101 = ((RecorderOperateParams) r100).action;
    L8:
        String r102 = this.doraBluetoothId;
        if (r102 != null) goto L11;
        r102 = ((RecorderOperateParams) r100).doraBluetoothId;
    L11:
        String r103 = this.doraProductId;
        if (r103 != null) goto L15;
        r103 = ((RecorderOperateParams) r100).doraProductId;
    L15:
        return new RecorderOperateParams(r101, r102, r103);
    }

    public final void setAction(String r100) {
        this.action = r100;
    }

    public final void setDoraBluetoothId(String r100) {
        this.doraBluetoothId = r100;
    }

    public final void setDoraProductId(String r100) {
        this.doraProductId = r100;
    }

    public RecorderOperateParams(String r100, String r101, String r102) {
        this.action = r100;
        this.doraBluetoothId = r101;
        this.doraProductId = r102;
    }

    public /* synthetic */ RecorderOperateParams(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
