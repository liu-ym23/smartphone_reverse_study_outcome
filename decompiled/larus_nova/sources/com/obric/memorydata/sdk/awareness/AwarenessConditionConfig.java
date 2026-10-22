package com.obric.memorydata.sdk.awareness;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0013\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006&"}, d2 = {"Lcom/obric/memorydata/sdk/awareness/AwarenessConditionConfig;", "Landroid/os/Parcelable;", "valueType", "", "matchMode", "rules", "Ljava/util/ArrayList;", "Lcom/obric/memorydata/sdk/awareness/AwarenessConditionRule;", "Lkotlin/collections/ArrayList;", "extraKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getValueType", "()Ljava/lang/String;", "getMatchMode", "getRules", "()Ljava/util/ArrayList;", "getExtraKey", "isAlways", "", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessConditionConfig implements Parcelable {
    public static final Parcelable.Creator<AwarenessConditionConfig> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<AwarenessConditionRule> f397085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f397086d;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements Parcelable.Creator<AwarenessConditionConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final AwarenessConditionConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            int r103 = r100.readInt();
            ArrayList r104 = new ArrayList(r103);
            int r105 = 0;
        L3:
            if (r105 == r103) goto L6;
            r104.add(AwarenessConditionRule.CREATOR.createFromParcel(r100));
            r105 = r105 + 1;
            goto L3
        L6:
            return new AwarenessConditionConfig(r101, r102, r104, r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final AwarenessConditionConfig[] newArray(int r100) {
            return new AwarenessConditionConfig[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AwarenessConditionConfig) == true) goto L8;
        return false;
    L8:
        AwarenessConditionConfig r101 = (AwarenessConditionConfig) r100;
        if (Intrinsics.areEqual(this.f397083a, r101.f397083a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397084b, r101.f397084b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397085c, r101.f397085c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397086d, r101.f397086d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f397083a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f397084b.hashCode()) * 31) + this.f397085c.hashCode()) * 31;
        String r104 = this.f397086d;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AwarenessConditionConfig(valueType=" + this.f397083a + ", matchMode=" + this.f397084b + ", rules=" + this.f397085c + ", extraKey=" + this.f397086d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f397083a);
        r100.writeString(this.f397084b);
        ArrayList<AwarenessConditionRule> r102 = this.f397085c;
        r100.writeInt(r102.size());
        Iterator<AwarenessConditionRule> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().writeToParcel(r100, r101);
        goto L4
    L6:
        r100.writeString(this.f397086d);
    }

    public AwarenessConditionConfig() {
        this(null, "all", new ArrayList(), null);
    }

    public AwarenessConditionConfig(String r100, String r101, ArrayList<AwarenessConditionRule> r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "matchMode");
        Intrinsics.checkNotNullParameter(r102, "rules");
        this.f397083a = r100;
        this.f397084b = r101;
        this.f397085c = r102;
        this.f397086d = r103;
    }
}
