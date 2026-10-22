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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B;\u00122\u0010\u0004\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ5\u0010\r\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u0001`\bHÆ\u0003J?\u0010\u000e\u001a\u00020\u000024\b\u0002\u0010\u0004\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u0001`\bHÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R=\u0010\u0004\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u00010\u0005j\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadexecutor/nextpage/Apool;", "Lcom/bytedance/ee/util/io/NonProguard;", "Landroid/os/Parcelable;", "", "numToAttrib", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getNumToAttrib", "()Ljava/util/HashMap;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Apool implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<Apool> CREATOR = null;
    private final HashMap<String, List<String>> numToAttrib;

    public static final class a implements Parcelable.Creator<Apool> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Apool createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            HashMap r101 = null;
        L10:
            return new Apool(r101);
        L5:
            int r102 = r100.readInt();
            HashMap r103 = new HashMap(r102);
            int r104 = 0;
        L6:
            if (r104 == r102) goto L8;
            r103.put(r100.readString(), r100.createStringArrayList());
            r104 = r104 + 1;
            goto L6
        L8:
            r101 = r103;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final Apool[] newArray(int r100) {
            return new Apool[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Apool copy$default(Apool r100, HashMap r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.numToAttrib;
    L6:
        return r100.copy(r101);
    }

    public final HashMap<String, List<String>> component1() {
        return this.numToAttrib;
    }

    public final Apool copy(HashMap<String, List<String>> r100) {
        return new Apool(r100);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Apool) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.numToAttrib, ((Apool) r100).numToAttrib) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        HashMap<String, List<String>> r100 = this.numToAttrib;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "Apool(numToAttrib=" + this.numToAttrib + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        HashMap<String, List<String>> r102 = this.numToAttrib;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, List<String>>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, List<String>> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeStringList(r104.getValue());
        goto L7
    }

    public Object clone() {
        return super.clone();
    }

    public final HashMap<String, List<String>> getNumToAttrib() {
        return this.numToAttrib;
    }

    public Apool(HashMap<String, List<String>> r100) {
        this.numToAttrib = r100;
    }
}
