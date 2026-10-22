package com.bytedance.creativex.mediaimport.view.internal.pager;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public interface ConcatenateAdapter {

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0001J\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/creativex/mediaimport/view/internal/pager/ConcatenateAdapter$ConcatenateState;", "Landroid/os/Parcelable;", "states", "", "<init>", "(Ljava/util/List;)V", "getStates", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "feature-media-import_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConcatenateState implements Parcelable {
        public static final Parcelable.Creator<ConcatenateState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Parcelable> f203998a;

        public static final class a implements Parcelable.Creator<ConcatenateState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ConcatenateState createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                int r101 = r100.readInt();
                ArrayList r102 = new ArrayList(r101);
                int r103 = 0;
            L3:
                if (r103 == r101) goto L6;
                r102.add(r100.readParcelable(ConcatenateState.class.getClassLoader()));
                r103 = r103 + 1;
                goto L3
            L6:
                return new ConcatenateState(r102);
            }

            @Override // android.os.Parcelable.Creator
            public final ConcatenateState[] newArray(int r100) {
                return new ConcatenateState[r100];
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
            if ((r100 instanceof ConcatenateState) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f203998a, ((ConcatenateState) r100).f203998a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f203998a.hashCode();
        }

        public final String toString() {
            return "ConcatenateState(states=" + this.f203998a + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            List<Parcelable> r102 = this.f203998a;
            r100.writeInt(r102.size());
            Iterator<Parcelable> r103 = r102.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r100.writeParcelable(r103.next(), r101);
            goto L4
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ConcatenateState(List<? extends Parcelable> r100) {
            Intrinsics.checkNotNullParameter(r100, "states");
            this.f203998a = r100;
        }
    }

    boolean a(Object r100);
}
