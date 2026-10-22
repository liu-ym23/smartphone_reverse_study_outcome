package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/ASROutput;", "Landroid/os/Parcelable;", "asrResult", "", "asrName", "asrChatterEntity", "", "Lcom/ss/android/lark/intent/export/entity/output/AsrChatterEntity;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAsrResult", "()Ljava/lang/String;", "getAsrName", "getAsrChatterEntity", "()Ljava/util/List;", "setAsrChatterEntity", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ASROutput implements Parcelable {
    public static final Parcelable.Creator<ASROutput> CREATOR = null;
    private List<? extends List<AsrChatterEntity>> asrChatterEntity;
    private final String asrName;
    private final String asrResult;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ASROutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ASROutput createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            int r102 = r110.readInt();
            ArrayList r103 = new ArrayList(r102);
            int r104 = 0;
        L3:
            if (r104 == r102) goto L9;
            int r105 = r110.readInt();
            ArrayList r106 = new ArrayList(r105);
            int r107 = 0;
        L5:
            if (r107 == r105) goto L7;
            r106.add(AsrChatterEntity.CREATOR.createFromParcel(r110));
            r107 = r107 + 1;
            goto L5
        L7:
            r103.add(r106);
            r104 = r104 + 1;
            goto L3
        L9:
            return new ASROutput(r100, r101, r103);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ASROutput createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ASROutput[] newArray(int r100) {
            return new ASROutput[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ASROutput[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ASROutput copy$default(ASROutput r100, String r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.asrResult;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.asrName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.asrChatterEntity;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.asrResult;
    }

    public final String component2() {
        return this.asrName;
    }

    public final List<List<AsrChatterEntity>> component3() {
        return this.asrChatterEntity;
    }

    public final ASROutput copy(String r100, String r101, List<? extends List<AsrChatterEntity>> r102) {
        Intrinsics.checkNotNullParameter(r102, "asrChatterEntity");
        return new ASROutput(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ASROutput) == true) goto L8;
        return false;
    L8:
        ASROutput r101 = (ASROutput) r100;
        if (Intrinsics.areEqual(this.asrResult, r101.asrResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asrName, r101.asrName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.asrChatterEntity, r101.asrChatterEntity) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.asrResult;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.asrName;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.asrChatterEntity.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ASROutput(asrResult=" + this.asrResult + ", asrName=" + this.asrName + ", asrChatterEntity=" + this.asrChatterEntity + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.asrResult);
        r100.writeString(this.asrName);
        List<? extends List<AsrChatterEntity>> r102 = this.asrChatterEntity;
        r100.writeInt(r102.size());
        Iterator<? extends List<AsrChatterEntity>> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        List<AsrChatterEntity> r104 = r103.next();
        r100.writeInt(r104.size());
        Iterator<AsrChatterEntity> r105 = r104.iterator();
    L7:
        if (r105.hasNext() == false) goto L4;
        r105.next().writeToParcel(r100, r101);
        goto L7
    }

    public final List<List<AsrChatterEntity>> getAsrChatterEntity() {
        return this.asrChatterEntity;
    }

    public final String getAsrName() {
        return this.asrName;
    }

    public final String getAsrResult() {
        return this.asrResult;
    }

    public final void setAsrChatterEntity(List<? extends List<AsrChatterEntity>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.asrChatterEntity = r100;
    }

    public ASROutput(String r100, String r101, List<? extends List<AsrChatterEntity>> r102) {
        Intrinsics.checkNotNullParameter(r102, "asrChatterEntity");
        this.asrResult = r100;
        this.asrName = r101;
        this.asrChatterEntity = r102;
    }
}
