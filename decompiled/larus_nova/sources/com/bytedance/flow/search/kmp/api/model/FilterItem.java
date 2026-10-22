package com.bytedance.flow.search.kmp.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00060\u0001j\u0002`\u0002:\u0002./B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\fJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\fHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\fJ%\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u00060"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/FilterItem;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "id", "", "name", "value", "trackInfo", "Lcom/bytedance/flow/search/kmp/api/model/SearchTabTrackInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/flow/search/kmp/api/model/SearchTabTrackInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/flow/search/kmp/api/model/SearchTabTrackInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getValue", "getTrackInfo", "()Lcom/bytedance/flow/search/kmp/api/model/SearchTabTrackInfo;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class FilterItem implements Parcelable {
    public static final Parcelable.Creator<FilterItem> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f243255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f243256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SearchTabTrackInfo f243257d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<FilterItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243258a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243259b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{r100, r100, r100, SearchTabTrackInfo.a.f243322a};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243259b;
        }

        static {
            a r100 = new a();
            f243258a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.FilterItem", r100, 4);
            r101.j("id", false);
            r101.j("name", false);
            r101.j("value", false);
            r101.j("trackInfo", false);
            f243259b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f243259b;
            muc.c r101 = r110.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            String r103 = r101.decodeStringElement(r100, 0);
            String r104 = r101.decodeStringElement(r100, 1);
            String r111 = r103;
            String r112 = r101.decodeStringElement(r100, 2);
            String r113 = r104;
            SearchTabTrackInfo r114 = (SearchTabTrackInfo) r101.decodeSerializableElement(r100, 3, SearchTabTrackInfo.a.f243322a, null);
            int r115 = 15;
        L21:
            r101.endStructure(r100);
            return new FilterItem(r115, r111, r113, r112, r114);
        L5:
            String r105 = null;
            String r106 = null;
            SearchTabTrackInfo r116 = null;
            int r107 = 0;
            boolean r117 = true;
        L6:
            if (r117 == false) goto L20;
            int r118 = r101.decodeElementIndex(r100);
            if (r118 != (-1)) goto L9;
            r117 = false;
            goto L6
        L9:
            if (r118 != 0) goto L10;
            r102 = r101.decodeStringElement(r100, 0);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r118 != 1) goto L11;
            r105 = r101.decodeStringElement(r100, 1);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r118 != 2) goto L12;
            r106 = r101.decodeStringElement(r100, 2);
            r107 = r107 | 4;
            goto L6
        L12:
            if (r118 != 3) goto L15;
            r116 = (SearchTabTrackInfo) r101.decodeSerializableElement(r100, 3, SearchTabTrackInfo.a.f243322a, r116);
            r107 = r107 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r118);
        L20:
            r115 = r107;
            r111 = r102;
            r113 = r105;
            r112 = r106;
            r114 = r116;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            FilterItem r102 = (FilterItem) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243259b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeStringElement(r103, 0, r102.f243254a);
            r104.encodeStringElement(r103, 1, r102.f243255b);
            r104.encodeStringElement(r103, 2, r102.f243256c);
            r104.encodeSerializableElement(r103, 3, SearchTabTrackInfo.a.f243322a, r102.f243257d);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<FilterItem> serializer() {
            return a.f243258a;
        }
    }

    public static final class c implements Parcelable.Creator<FilterItem> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final FilterItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new FilterItem(r100.readString(), r100.readString(), r100.readString(), SearchTabTrackInfo.CREATOR.createFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public final FilterItem[] newArray(int r100) {
            return new FilterItem[r100];
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
        if ((r100 instanceof FilterItem) == true) goto L8;
        return false;
    L8:
        FilterItem r101 = (FilterItem) r100;
        if (Intrinsics.areEqual(this.f243254a, r101.f243254a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243255b, r101.f243255b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f243256c, r101.f243256c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f243257d, r101.f243257d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f243254a.hashCode() * 31) + this.f243255b.hashCode()) * 31) + this.f243256c.hashCode()) * 31) + this.f243257d.hashCode();
    }

    public final String toString() {
        return "FilterItem(id=" + this.f243254a + ", name=" + this.f243255b + ", value=" + this.f243256c + ", trackInfo=" + this.f243257d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243254a);
        r100.writeString(this.f243255b);
        r100.writeString(this.f243256c);
        this.f243257d.writeToParcel(r100, r101);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public FilterItem(String r100, String r101, String r102, SearchTabTrackInfo r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "value");
        Intrinsics.checkNotNullParameter(r103, "trackInfo");
        this.f243254a = r100;
        this.f243255b = r101;
        this.f243256c = r102;
        this.f243257d = r103;
    }

    public FilterItem(int r100, String r101, String r102, String r103, SearchTabTrackInfo r104) {
        if (15 != (r100 & 15)) goto L6;
        this.f243254a = r101;
        this.f243255b = r102;
        this.f243256c = r103;
        this.f243257d = r104;
        return;
    L6:
        b2.b(r100, 15, a.f243259b);
        throw null;
    }
}
