package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-BW\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003Jg\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0006\u0010 \u001a\u00020!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\t\u0010'\u001a\u00020\nHÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006."}, d2 = {"Lcom/obric/memorydata/sdk/realtime/RealTimeContext;", "Landroid/os/Parcelable;", "screenMetaValue", "", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "appEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "referenceAppEntities", "referenceMetaValue", "curTopAppPackageName", "", "curTopAppName", "curTopActivityName", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScreenMetaValue", "()Ljava/util/List;", "getAppEntities", "getReferenceAppEntities", "getReferenceMetaValue", "getCurTopAppPackageName", "()Ljava/lang/String;", "getCurTopAppName", "getCurTopActivityName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealTimeContext implements Parcelable {
    public static final Parcelable.Creator<RealTimeContext> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MetaValue> f397192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AppEntity> f397193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<AppEntity> f397194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<MetaValue> f397195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f397196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f397197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f397198g;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements Parcelable.Creator<RealTimeContext> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final RealTimeContext createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            ArrayList r101 = new ArrayList(r100);
            int r102 = 0;
            int r103 = 0;
        L3:
            if (r103 == r100) goto L5;
            r101.add(r110.readParcelable(RealTimeContext.class.getClassLoader()));
            r103 = r103 + 1;
            goto L3
        L5:
            int r104 = r110.readInt();
            ArrayList r105 = new ArrayList(r104);
            int r106 = 0;
        L6:
            if (r106 == r104) goto L8;
            r105.add(r110.readParcelable(RealTimeContext.class.getClassLoader()));
            r106 = r106 + 1;
            goto L6
        L8:
            int r107 = r110.readInt();
            ArrayList r108 = new ArrayList(r107);
            int r109 = 0;
        L9:
            if (r109 == r107) goto L11;
            r108.add(r110.readParcelable(RealTimeContext.class.getClassLoader()));
            r109 = r109 + 1;
            goto L9
        L11:
            int r111 = r110.readInt();
            ArrayList r112 = new ArrayList(r111);
        L12:
            if (r102 == r111) goto L15;
            r112.add(r110.readParcelable(RealTimeContext.class.getClassLoader()));
            r102 = r102 + 1;
            goto L12
        L15:
            return new RealTimeContext(r101, r105, r108, r112, r110.readString(), r110.readString(), r110.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final RealTimeContext[] newArray(int r100) {
            return new RealTimeContext[r100];
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
        if ((r100 instanceof RealTimeContext) == true) goto L8;
        return false;
    L8:
        RealTimeContext r101 = (RealTimeContext) r100;
        if (Intrinsics.areEqual(this.f397192a, r101.f397192a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397193b, r101.f397193b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397194c, r101.f397194c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397195d, r101.f397195d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f397196e, r101.f397196e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f397197f, r101.f397197f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f397198g, r101.f397198g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f397192a.hashCode() * 31) + this.f397193b.hashCode()) * 31) + this.f397194c.hashCode()) * 31) + this.f397195d.hashCode()) * 31) + this.f397196e.hashCode()) * 31) + this.f397197f.hashCode()) * 31) + this.f397198g.hashCode();
    }

    public final String toString() {
        return "RealTimeContext(screenMetaValue=" + this.f397192a + ", appEntities=" + this.f397193b + ", referenceAppEntities=" + this.f397194c + ", referenceMetaValue=" + this.f397195d + ", curTopAppPackageName=" + this.f397196e + ", curTopAppName=" + this.f397197f + ", curTopActivityName=" + this.f397198g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<MetaValue> r102 = this.f397192a;
        r100.writeInt(r102.size());
        Iterator<MetaValue> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeParcelable(r103.next(), r101);
        goto L4
    L6:
        List<AppEntity> r104 = this.f397193b;
        r100.writeInt(r104.size());
        Iterator<AppEntity> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r100.writeParcelable(r105.next(), r101);
        goto L8
    L10:
        List<AppEntity> r106 = this.f397194c;
        r100.writeInt(r106.size());
        Iterator<AppEntity> r107 = r106.iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        r100.writeParcelable(r107.next(), r101);
        goto L12
    L14:
        List<MetaValue> r108 = this.f397195d;
        r100.writeInt(r108.size());
        Iterator<MetaValue> r109 = r108.iterator();
    L16:
        if (r109.hasNext() == false) goto L18;
        r100.writeParcelable(r109.next(), r101);
        goto L16
    L18:
        r100.writeString(this.f397196e);
        r100.writeString(this.f397197f);
        r100.writeString(this.f397198g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealTimeContext(List<? extends MetaValue> r100, List<? extends AppEntity> r101, List<? extends AppEntity> r102, List<? extends MetaValue> r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "screenMetaValue");
        Intrinsics.checkNotNullParameter(r101, "appEntities");
        Intrinsics.checkNotNullParameter(r102, "referenceAppEntities");
        Intrinsics.checkNotNullParameter(r103, "referenceMetaValue");
        Intrinsics.checkNotNullParameter(r104, "curTopAppPackageName");
        Intrinsics.checkNotNullParameter(r105, "curTopAppName");
        Intrinsics.checkNotNullParameter(r106, "curTopActivityName");
        this.f397192a = r100;
        this.f397193b = r101;
        this.f397194c = r102;
        this.f397195d = r103;
        this.f397196e = r104;
        this.f397197f = r105;
        this.f397198g = r106;
    }
}
