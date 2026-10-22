package com.larus.bmhome.chat.standarduikit.miaodaartifact.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\tJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/miaodaartifact/viewmodel/MiaodaArtifactVMData;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardVMData;", "Landroid/os/Parcelable;", "message", "Lcom/larus/im/bean/message/Message;", "resourceId", "", "fileName", "rootBackgroundRes", "", "<init>", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getMessage", "()Lcom/larus/im/bean/message/Message;", "getResourceId", "()Ljava/lang/String;", "getFileName", "getRootBackgroundRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/standarduikit/miaodaartifact/viewmodel/MiaodaArtifactVMData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiaodaArtifactVMData implements Parcelable {
    public static final Parcelable.Creator<MiaodaArtifactVMData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f309528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f309529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f309530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f309531d;

    public static final class a implements Parcelable.Creator<MiaodaArtifactVMData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MiaodaArtifactVMData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Message r101 = (Message) r100.readSerializable();
            String r102 = r100.readString();
            String r103 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Integer r104 = null;
        L7:
            return new MiaodaArtifactVMData(r101, r102, r103, r104);
        L5:
            r104 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MiaodaArtifactVMData[] newArray(int r100) {
            return new MiaodaArtifactVMData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MiaodaArtifactVMData) == true) goto L8;
        return false;
    L8:
        MiaodaArtifactVMData r101 = (MiaodaArtifactVMData) r100;
        if (Intrinsics.areEqual(this.f309528a, r101.f309528a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309529b, r101.f309529b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309530c, r101.f309530c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309531d, r101.f309531d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f309528a.hashCode() * 31;
        String r101 = this.f309529b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f309530c.hashCode()) * 31;
        Integer r105 = this.f309531d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MiaodaArtifactVMData(message=" + this.f309528a + ", resourceId=" + this.f309529b + ", fileName=" + this.f309530c + ", rootBackgroundRes=" + this.f309531d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeSerializable(this.f309528a);
        r100.writeString(this.f309529b);
        r100.writeString(this.f309530c);
        Integer r102 = this.f309531d;
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

    public MiaodaArtifactVMData(Message r100, String r101, String r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        this.f309528a = r100;
        this.f309529b = r101;
        this.f309530c = r102;
        this.f309531d = r103;
    }
}
