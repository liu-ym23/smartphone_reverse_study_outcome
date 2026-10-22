package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00042\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0006j\b\u0012\u0004\u0012\u00020\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "type", "", "conditions", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getConditions", "()Ljava/util/ArrayList;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ConditionGroup implements Condition, Parcelable {
    public static final Parcelable.Creator<ConditionGroup> CREATOR = null;
    private final ArrayList<Condition> conditions;
    private final String type;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ConditionGroup> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionGroup createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r102 = r100.readString();
            int r103 = r100.readInt();
            ArrayList r104 = new ArrayList(r103);
            int r105 = 0;
        L3:
            if (r105 == r103) goto L5;
            r104.add(r100.readParcelable(ConditionGroup.class.getClassLoader()));
            r105 = r105 + 1;
            goto L3
        L5:
            ConditionGroup r106 = new ConditionGroup(r102, r104);
            int r107 = Math.min(r101, 0);
            ClassLoader r108 = a.class.getClassLoader();
            int r109 = 1;
        L6:
            if (r109 > r107) goto L8;
            r109 = r109 + 1;
        L8:
            if (r109 > r101) goto L10;
            joa.a.d(r100, r108);
            r109 = r109 + 1;
            goto L8
        L10:
            return r106;
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionGroup[] newArray(int r100) {
            return new ConditionGroup[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ConditionGroup(@ConditionGroupType String r100, ArrayList<Condition> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "conditions");
        this.type = r100;
        this.conditions = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConditionGroup copy$default(ConditionGroup r100, String r101, ArrayList r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.conditions;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.type;
    }

    public final ArrayList<Condition> component2() {
        return this.conditions;
    }

    public final ConditionGroup copy(@ConditionGroupType String r100, ArrayList<Condition> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "conditions");
        return new ConditionGroup(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ConditionGroup.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionGroup");
        ConditionGroup r102 = (ConditionGroup) r100;
        if (Intrinsics.areEqual(this.type, r102.type) == true) goto L15;
    L19:
        return false;
    L15:
        if (this.conditions.size() != r102.conditions.size()) goto L19;
        if (Intrinsics.areEqual(CollectionsKt.toSet(this.conditions), CollectionsKt.toSet(r102.conditions)) == false) goto L19;
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final ArrayList<Condition> getConditions() {
        return this.conditions;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + CollectionsKt.toSet(this.conditions).hashCode();
    }

    public String toString() {
        return "ConditionGroup(type=" + this.type + ", conditions=" + this.conditions + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.type);
        ArrayList<Condition> r102 = this.conditions;
        r100.writeInt(r102.size());
        Iterator<Condition> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeParcelable(r103.next(), r101);
        goto L4
    }
}
