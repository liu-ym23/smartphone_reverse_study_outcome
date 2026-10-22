package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.nextpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B;\u00122\u0010\u0004\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ5\u0010\r\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u0001`\bHÆ\u0003J?\u0010\u000e\u001a\u00020\u000024\b\u0002\u0010\u0004\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u0001`\bHÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R=\u0010\u0004\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/Apool;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "numToAttrib", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getNumToAttrib", "()Ljava/util/HashMap;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Apool implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<Apool> CREATOR = null;
    private final HashMap<String, List<String>> numToAttrib;

    public static final class a implements Parcelable.Creator<Apool> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Apool createFromParcel(Parcel r6) {
            Intrinsics.checkNotNullParameter(r6, "parcel");
            if (r6.readInt() != 0) goto L5;
            HashMap r7 = null;
        L10:
            return new Apool(r7);
        L5:
            int r0 = r6.readInt();
            HashMap r1 = new HashMap(r0);
            int r2 = 0;
        L6:
            if (r2 == r0) goto L8;
            r1.put(r6.readString(), r6.createStringArrayList());
            r2 = r2 + 1;
            goto L6
        L8:
            r7 = r1;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final Apool[] newArray(int r1) {
            return new Apool[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Apool copy$default(Apool r0, HashMap r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.numToAttrib;
    L6:
        return r0.copy(r1);
    }

    public final HashMap<String, List<String>> component1() {
        return this.numToAttrib;
    }

    public final Apool copy(HashMap<String, List<String>> r2) {
        return new Apool(r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof Apool) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.numToAttrib, ((Apool) r4).numToAttrib) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        HashMap<String, List<String>> r0 = this.numToAttrib;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "Apool(numToAttrib=" + this.numToAttrib + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        HashMap<String, List<String>> r5 = this.numToAttrib;
        if (r5 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.size());
        Iterator<Map.Entry<String, List<String>>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Map.Entry<String, List<String>> r0 = r6.next();
        r3.writeString(r0.getKey());
        r3.writeStringList(r0.getValue());
        goto L7
    }

    public Object clone() {
        return super.clone();
    }

    public final HashMap<String, List<String>> getNumToAttrib() {
        return this.numToAttrib;
    }

    public Apool(HashMap<String, List<String>> r1) {
        this.numToAttrib = r1;
    }
}
