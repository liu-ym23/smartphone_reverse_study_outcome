package com.hihonor.mcs.system.diagnosis.core.pressure;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.EnumSet;
import java.util.Iterator;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public class Resource implements Parcelable {
    public static final Parcelable.Creator<Resource> CREATOR = null;
    private EnumSet<Kind> kindSet;

    public static final class Builder {
        EnumSet<Kind> subscribeKinds;

        public Builder() {
            this.subscribeKinds = EnumSet.noneOf(Kind.class);
        }

        public final Resource build() {
            return new Resource(this, null);
        }

        public final Builder withKind(Kind r100) {
            this.subscribeKinds.add(r100);
            return this;
        }
    }

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind RESOURCE_CPU = null;
        public static final Kind RESOURCE_IO = null;
        public static final Kind RESOURCE_MEMORY = null;
        public static final Kind RESOURCE_TEMPERATURE = null;

        static {
            Kind r100 = new Kind("RESOURCE_CPU", 0);
            RESOURCE_CPU = r100;
            Kind r101 = new Kind("RESOURCE_MEMORY", 1);
            RESOURCE_MEMORY = r101;
            Kind r102 = new Kind("RESOURCE_TEMPERATURE", 2);
            RESOURCE_TEMPERATURE = r102;
            Kind r103 = new Kind("RESOURCE_IO", 3);
            RESOURCE_IO = r103;
            $VALUES = new Kind[]{r100, r101, r102, r103};
        }

        private Kind(String r100, int r101) {
            super(r100, r101);
        }

        public static Kind valueOf(String r100) {
            return (Kind) a.a(Kind.class, r100);
        }

        public static Kind[] values() {
            return (Kind[]) $VALUES.clone();
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public Resource(Parcel r100) {
        this.kindSet = EnumSet.noneOf(Kind.class);
        this.kindSet = (EnumSet) r100.readSerializable();
    }

    private Resource(Builder r100) {
        this.kindSet = EnumSet.noneOf(Kind.class);
        this.kindSet = r100.subscribeKinds;
    }

    public /* synthetic */ Resource(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Resource) == true) goto L8;
        return false;
    L8:
        Resource r101 = (Resource) r100;
        if (this.kindSet.size() == r101.getKinds().size()) goto L11;
        return false;
    L11:
        Iterator r102 = r101.getKinds().iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        Kind r103 = (Kind) r102.next();
        if (this.kindSet.contains(r103) == true) goto L13;
        return false;
    L17:
        return true;
    }

    public EnumSet<Kind> getKinds() {
        return this.kindSet;
    }

    public int hashCode() {
        Iterator r100 = getKinds().iterator();
        int r101 = 1;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = (r101 * 31) + ((Kind) r100.next()).hashCode();
        goto L4
    L6:
        return r101;
    }

    public void readFromParcel(Parcel r100) {
        this.kindSet = (EnumSet) r100.readSerializable();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeSerializable(this.kindSet);
    }
}
