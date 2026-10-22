package com.obric.assistant.activation.presentation.contract;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r¨\u0006$"}, d2 = {"Lcom/obric/assistant/activation/presentation/contract/ObricListeningViewState;", "Landroid/os/Parcelable;", "mode", "Lcom/obric/assistant/activation/presentation/contract/ObricListeningVisualMode;", "visible", "", "amplitude", "", "<init>", "(Lcom/obric/assistant/activation/presentation/contract/ObricListeningVisualMode;ZF)V", "getMode", "()Lcom/obric/assistant/activation/presentation/contract/ObricListeningVisualMode;", "getVisible", "()Z", "getAmplitude", "()F", "shouldRender", "getShouldRender", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "contract_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricListeningViewState implements Parcelable {
    public static final Parcelable.Creator<ObricListeningViewState> CREATOR = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ObricListeningViewState f385269d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricListeningVisualMode f385270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f385271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f385272c;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<ObricListeningViewState> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ObricListeningViewState createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ObricListeningVisualMode r101 = ObricListeningVisualMode.valueOf(r100.readString());
            if (r100.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            return new ObricListeningViewState(r101, r102, r100.readFloat());
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ObricListeningViewState[] newArray(int r100) {
            return new ObricListeningViewState[r100];
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
        if ((r100 instanceof ObricListeningViewState) == true) goto L8;
        return false;
    L8:
        ObricListeningViewState r101 = (ObricListeningViewState) r100;
        if (this.f385270a == r101.f385270a) goto L12;
        return false;
    L12:
        if (this.f385271b == r101.f385271b) goto L15;
        return false;
    L15:
        if (Float.compare(this.f385272c, r101.f385272c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f385270a.hashCode() * 31;
        if (this.f385271b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + Float.floatToIntBits(this.f385272c);
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ObricListeningViewState(mode=" + this.f385270a + ", visible=" + this.f385271b + ", amplitude=" + this.f385272c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f385270a.name());
        r100.writeInt(this.f385271b ? 1 : 0);
        r100.writeFloat(this.f385272c);
    }

    static {
        CREATOR = new b();
        f385269d = new ObricListeningViewState(ObricListeningVisualMode.HIDDEN, false, 0.0f);
    }

    public final boolean b() {
        if (this.f385270a != ObricListeningVisualMode.HIDDEN) goto L5;
    L7:
        return false;
    L5:
        if (this.f385271b == false) goto L7;
        return true;
    }

    public ObricListeningViewState(ObricListeningVisualMode r100, boolean r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f385270a = r100;
        this.f385271b = r101;
        this.f385272c = r102;
    }

    public static ObricListeningViewState a(ObricListeningViewState r100, ObricListeningVisualMode r101, float r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f385270a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        boolean r104 = r100.f385271b;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = r100.f385272c;
    L12:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "mode");
        return new ObricListeningViewState(r101, r104, r102);
    L8:
        r104 = false;
        goto L10
    }
}
