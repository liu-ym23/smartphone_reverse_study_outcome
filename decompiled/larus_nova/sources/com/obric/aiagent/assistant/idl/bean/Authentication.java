package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0005J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/Authentication;", "Landroid/os/Parcelable;", "isPass", "", "type", "", "<init>", "(ZLjava/lang/Integer;)V", "()Z", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ZLjava/lang/Integer;)Lcom/obric/aiagent/assistant/idl/bean/Authentication;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Authentication implements Parcelable {
    public static final Parcelable.Creator<Authentication> CREATOR = null;
    private final boolean isPass;
    private final Integer type;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<Authentication> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Authentication createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            if (r100.readInt() != 0) goto L9;
            Integer r102 = null;
        L11:
            return new Authentication(r101, r102);
        L9:
            r102 = Integer.valueOf(r100.readInt());
            goto L11
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Authentication[] newArray(int r100) {
            return new Authentication[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ Authentication copy$default(Authentication r100, boolean r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isPass;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isPass;
    }

    public final Integer component2() {
        return this.type;
    }

    public final Authentication copy(boolean r100, Integer r101) {
        return new Authentication(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Authentication) == true) goto L8;
        return false;
    L8:
        Authentication r101 = (Authentication) r100;
        if (this.isPass == r101.isPass) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.isPass == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Integer r102 = this.type;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "Authentication(isPass=" + this.isPass + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.isPass ? 1 : 0);
        Integer r102 = this.type;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        r100.writeInt(r103);
        return;
    L5:
        r100.writeInt(1);
        r103 = r102.intValue();
        goto L6
    }

    public final Integer getType() {
        return this.type;
    }

    public final boolean isPass() {
        return this.isPass;
    }

    public Authentication(boolean r100, Integer r101) {
        this.isPass = r100;
        this.type = r101;
    }

    public /* synthetic */ Authentication(boolean r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 0;
    L5:
        this(r100, r101);
    }
}
