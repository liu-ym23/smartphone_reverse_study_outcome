package com.obric.assistant.activation.presentation.contract;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0019\u001a\u00020\u000bJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0006\u0010!\u001a\u00020\u0006J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017¨\u0006."}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/ObricListeningPresentationState;", "Landroid/os/Parcelable;", "revision", "", "heartbeatSequence", "renderer", "", "dataSource", "viewState", "Lcom/obric/assistant/activation/presentation/contract/ObricListeningViewState;", "childFeedbackPlayed", "", "<init>", "(JJIILcom/obric/assistant/activation/presentation/contract/ObricListeningViewState;Z)V", "getRevision", "()J", "getHeartbeatSequence", "getRenderer", "()I", "getDataSource", "getViewState", "()Lcom/obric/assistant/activation/presentation/contract/ObricListeningViewState;", "getChildFeedbackPlayed", "()Z", "isActive", "isValid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricListeningPresentationState implements Parcelable {
    public static final Parcelable.Creator<ObricListeningPresentationState> CREATOR = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ObricListeningPresentationState f385262g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f385263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f385264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f385265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f385266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ObricListeningViewState f385267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f385268f;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<ObricListeningPresentationState> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ObricListeningPresentationState createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            long r100 = r110.readLong();
            long r101 = r110.readLong();
            int r102 = r110.readInt();
            int r103 = r110.readInt();
            ObricListeningViewState r104 = ObricListeningViewState.CREATOR.createFromParcel(r110);
            if (r110.readInt() == 0) goto L5;
            boolean r105 = true;
        L7:
            return new ObricListeningPresentationState(r100, r101, r102, r103, r104, r105);
        L5:
            r105 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ObricListeningPresentationState[] newArray(int r100) {
            return new ObricListeningPresentationState[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricListeningPresentationState) == true) goto L8;
        return false;
    L8:
        ObricListeningPresentationState r101 = (ObricListeningPresentationState) r100;
        if (this.f385263a == r101.f385263a) goto L12;
        return false;
    L12:
        if (this.f385264b == r101.f385264b) goto L15;
        return false;
    L15:
        if (this.f385265c == r101.f385265c) goto L18;
        return false;
    L18:
        if (this.f385266d == r101.f385266d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f385267e, r101.f385267e) == true) goto L24;
        return false;
    L24:
        if (this.f385268f == r101.f385268f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f385263a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f385264b;
        int r103 = (((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f385265c) * 31) + this.f385266d) * 31) + this.f385267e.hashCode()) * 31;
        if (this.f385268f == false) goto L5;
        int r104 = 1231;
    L7:
        return r103 + r104;
    L5:
        r104 = 1237;
        goto L7
    }

    public final String toString() {
        return "ObricListeningPresentationState(revision=" + this.f385263a + ", heartbeatSequence=" + this.f385264b + ", renderer=" + this.f385265c + ", dataSource=" + this.f385266d + ", viewState=" + this.f385267e + ", childFeedbackPlayed=" + this.f385268f + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.f385263a);
        r100.writeLong(this.f385264b);
        r100.writeInt(this.f385265c);
        r100.writeInt(this.f385266d);
        this.f385267e.writeToParcel(r100, r101);
        r100.writeInt(this.f385268f ? 1 : 0);
    }

    static {
        CREATOR = new b();
        f385262g = new ObricListeningPresentationState(0, 0, 0, 0, ObricListeningViewState.f385269d, false);
    }

    public final boolean b() {
        return this.f385267e.b();
    }

    public final boolean isValid() {
        if (this.f385263a >= 0) goto L5;
        return false;
    L5:
        if (this.f385264b < 0) goto L31;
        int r100 = this.f385265c;
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L11;
        boolean r101 = false;
    L12:
        if (r101 == false) goto L32;
        if (r100 == 0) goto L33;
        int r102 = this.f385266d;
        if (r102 >= 0) goto L17;
    L19:
        boolean r103 = false;
    L20:
        if (r103 == false) goto L34;
        float r104 = this.f385267e.f385272c;
        if (Float.isInfinite(r104) == false) goto L24;
    L26:
        boolean r105 = false;
    L27:
        if (r105 == false) goto L35;
        return true;
    L35:
        return false;
    L24:
        if (Float.isNaN(r104) == true) goto L26;
        r105 = true;
        goto L27
    L34:
        return false;
    L17:
        if (r102 >= 2) goto L19;
        r103 = true;
        goto L20
    L33:
        return false;
    L32:
        return false;
    L11:
        r101 = true;
        goto L12
    L31:
        return false;
    }

    public ObricListeningPresentationState(long r100, long r101, int r102, int r103, ObricListeningViewState r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r104, "viewState");
        this.f385263a = r100;
        this.f385264b = r101;
        this.f385265c = r102;
        this.f385266d = r103;
        this.f385267e = r104;
        this.f385268f = r105;
    }

    public static ObricListeningPresentationState a(ObricListeningPresentationState r100, long r110, long r111, int r112, ObricListeningViewState r113, boolean r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        long r101 = r100.f385263a;
    L7:
        if ((r115 & 2) == 0) goto L9;
        long r102 = r100.f385264b;
    L11:
        if ((r115 & 4) == 0) goto L13;
        int r103 = r100.f385265c;
    L15:
        if ((r115 & 8) == 0) goto L17;
        int r104 = r100.f385266d;
    L19:
        if ((r115 & 16) == 0) goto L21;
        ObricListeningViewState r105 = r100.f385267e;
    L23:
        if ((r115 & 32) == 0) goto L25;
        boolean r106 = r100.f385268f;
    L26:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r105, "viewState");
        return new ObricListeningPresentationState(r101, r102, r103, r104, r105, r106);
    L25:
        r106 = r114;
        goto L26
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = 0;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
