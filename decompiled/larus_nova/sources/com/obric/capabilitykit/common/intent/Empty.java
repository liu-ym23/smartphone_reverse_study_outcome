package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/common/intent/Empty;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Empty implements Parcelable, IntentParams {
    public static final Parcelable.Creator<Empty> CREATOR = null;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<Empty> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Empty createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.readInt();
            return new Empty();
        }

        @Override // android.os.Parcelable.Creator
        public final Empty[] newArray(int r100) {
            return new Empty[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public Empty() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSubActionValue() {
        return null;
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public IntentParams mergeParams(Object r100) {
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeInt(1);
    }
}
