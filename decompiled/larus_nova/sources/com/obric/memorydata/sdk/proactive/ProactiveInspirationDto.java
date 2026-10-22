package com.obric.memorydata.sdk.proactive;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.account.platform.api.IVKService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 42\u00020\u0001:\u00014BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001dJb\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u00065"}, d2 = {"Lcom/obric/memorydata/sdk/proactive/ProactiveInspirationDto;", "Landroid/os/Parcelable;", "inspirationId", "", DBDefinition.TASK_ID, "recommendId", "recommendStatus", "", "feedbackAction", "userFeedback", IVKService.ResponseConstants.CREATED, "", "feedbackValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/Integer;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getInspirationId", "()Ljava/lang/String;", "getTaskId", "getRecommendId", "getRecommendStatus", "()I", "getFeedbackAction", "getUserFeedback", "getCreated", "()J", "getFeedbackValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "writeToParcel", "", "dest", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/Integer;)Lcom/obric/memorydata/sdk/proactive/ProactiveInspirationDto;", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProactiveInspirationDto implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f397162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f397163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f397164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f397165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f397166h;

    public static final class a implements Parcelable.Creator<ProactiveInspirationDto> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveInspirationDto createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            if (r100 != null) goto L5;
            String r101 = "";
        L6:
            String r102 = r110.readString();
            if (r102 != null) goto L9;
            String r103 = "";
        L10:
            String r104 = r110.readString();
            if (r104 != null) goto L13;
            String r105 = "";
        L14:
            int r106 = r110.readInt();
            String r107 = r110.readString();
            if (r107 != null) goto L17;
            String r108 = "";
        L18:
            String r109 = r110.readString();
            long r111 = r110.readLong();
            if (r110.readInt() != 1) goto L21;
            Integer r112 = Integer.valueOf(r110.readInt());
        L23:
            return new ProactiveInspirationDto(r101, r103, r105, r106, r108, r109, r111, r112);
        L21:
            r112 = null;
            goto L23
        L17:
            r108 = r107;
            goto L18
        L13:
            r105 = r104;
            goto L14
        L9:
            r103 = r102;
            goto L10
        L5:
            r101 = r100;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ProactiveInspirationDto[] newArray(int r100) {
            return new ProactiveInspirationDto[r100];
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
        if ((r100 instanceof ProactiveInspirationDto) == true) goto L8;
        return false;
    L8:
        ProactiveInspirationDto r101 = (ProactiveInspirationDto) r100;
        if (Intrinsics.areEqual(this.f397159a, r101.f397159a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397160b, r101.f397160b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397161c, r101.f397161c) == true) goto L18;
        return false;
    L18:
        if (this.f397162d == r101.f397162d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f397163e, r101.f397163e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f397164f, r101.f397164f) == true) goto L27;
        return false;
    L27:
        if (this.f397165g == r101.f397165g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f397166h, r101.f397166h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f397159a.hashCode() * 31) + this.f397160b.hashCode()) * 31) + this.f397161c.hashCode()) * 31) + this.f397162d) * 31) + this.f397163e.hashCode()) * 31;
        String r101 = this.f397164f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.f397165g;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        Integer r106 = this.f397166h;
        if (r106 == null) goto L11;
        r102 = r106.hashCode();
    L11:
        return r105 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProactiveInspirationDto(inspirationId=" + this.f397159a + ", taskId=" + this.f397160b + ", recommendId=" + this.f397161c + ", recommendStatus=" + this.f397162d + ", feedbackAction=" + this.f397163e + ", userFeedback=" + this.f397164f + ", created=" + this.f397165g + ", feedbackValue=" + this.f397166h + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397159a);
        r100.writeString(this.f397160b);
        r100.writeString(this.f397161c);
        r100.writeInt(this.f397162d);
        r100.writeString(this.f397163e);
        r100.writeString(this.f397164f);
        r100.writeLong(this.f397165g);
        if (this.f397166h == null) goto L5;
        r100.writeInt(1);
        r100.writeInt(this.f397166h.intValue());
        return;
    L5:
        r100.writeInt(0);
    }

    public ProactiveInspirationDto(String r100, String r101, String r102, int r103, String r104, String r105, long r106, Integer r110) {
        Intrinsics.checkNotNullParameter(r100, "inspirationId");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "recommendId");
        Intrinsics.checkNotNullParameter(r104, "feedbackAction");
        this.f397159a = r100;
        this.f397160b = r101;
        this.f397161c = r102;
        this.f397162d = r103;
        this.f397163e = r104;
        this.f397164f = r105;
        this.f397165g = r106;
        this.f397166h = r110;
    }
}
