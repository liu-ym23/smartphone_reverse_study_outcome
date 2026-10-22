package com.larus.bmhome.chat.standarduikit.codeartifact.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016JF\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\nJ\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006,"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/codeartifact/viewmodel/CodeArtifactVMData;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardVMData;", "Landroid/os/Parcelable;", "message", "Lcom/larus/im/bean/message/Message;", "codeId", "", "fileName", "", "version", "", "rootBackgroundRes", "<init>", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMessage", "()Lcom/larus/im/bean/message/Message;", "getCodeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFileName", "()Ljava/lang/String;", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRootBackgroundRes", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/standarduikit/codeartifact/viewmodel/CodeArtifactVMData;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeArtifactVMData implements Parcelable {
    public static final Parcelable.Creator<CodeArtifactVMData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f308974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f308975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f308976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f308977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f308978e;

    public static final class a implements Parcelable.Creator<CodeArtifactVMData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CodeArtifactVMData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Message r101 = (Message) r100.readSerializable();
            if (r100.readInt() != 0) goto L5;
            Long r102 = null;
        L6:
            String r103 = r100.readString();
            if (r100.readInt() != 0) goto L9;
            Integer r104 = null;
        L11:
            if (r100.readInt() != 0) goto L13;
            Integer r105 = null;
        L15:
            return new CodeArtifactVMData(r101, r102, r103, r104, r105);
        L13:
            r105 = Integer.valueOf(r100.readInt());
            goto L15
        L9:
            r104 = Integer.valueOf(r100.readInt());
            goto L11
        L5:
            r102 = Long.valueOf(r100.readLong());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CodeArtifactVMData[] newArray(int r100) {
            return new CodeArtifactVMData[r100];
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
        if ((r100 instanceof CodeArtifactVMData) == true) goto L8;
        return false;
    L8:
        CodeArtifactVMData r101 = (CodeArtifactVMData) r100;
        if (Intrinsics.areEqual(this.f308974a, r101.f308974a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f308975b, r101.f308975b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f308976c, r101.f308976c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f308977d, r101.f308977d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f308978e, r101.f308978e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f308974a.hashCode() * 31;
        Long r101 = this.f308975b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f308976c.hashCode()) * 31;
        Integer r105 = this.f308977d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f308978e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CodeArtifactVMData(message=" + this.f308974a + ", codeId=" + this.f308975b + ", fileName=" + this.f308976c + ", version=" + this.f308977d + ", rootBackgroundRes=" + this.f308978e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeSerializable(this.f308974a);
        Long r102 = this.f308975b;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.f308976c);
        Integer r103 = this.f308977d;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        Integer r104 = this.f308978e;
        if (r104 != null) goto L13;
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public CodeArtifactVMData(Message r100, Long r101, String r102, Integer r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        this.f308974a = r100;
        this.f308975b = r101;
        this.f308976c = r102;
        this.f308977d = r103;
        this.f308978e = r104;
    }
}
