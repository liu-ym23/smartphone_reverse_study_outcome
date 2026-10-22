package com.bytedance.flow.search.kmp.api.model.payload;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.flow.search.kmp.api.model.FlowFilterData;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\bJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bJ%\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\b8\u0016X\u0097D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006+"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/payload/SearchFilterPayload;", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "domainFilter", "", "Lcom/bytedance/flow/search/kmp/api/model/FlowFilterData;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDomainFilter", "()Ljava/util/List;", "type", "getType$annotations", "()V", "getType", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SearchFilterPayload extends ISearchDataPayload {
    public static final Parcelable.Creator<SearchFilterPayload> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f243477k = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<FlowFilterData> f243478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f243479j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<SearchFilterPayload> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243480a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243481b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243481b;
        }

        static {
            a r100 = new a();
            f243480a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.payload.SearchFilterPayload", r100, 1);
            r101.j("domainFilter", false);
            f243481b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{SearchFilterPayload.f243477k[0].getValue()};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            g2 r101 = f243481b;
            muc.c r102 = r100.beginStructure(r101);
            Lazy<d<Object>>[] r103 = SearchFilterPayload.f243477k;
            int r104 = 1;
            List r105 = null;
            if (r102.decodeSequentially() == false) goto L5;
            List r106 = (List) r102.decodeSerializableElement(r101, 0, r103[0].getValue(), null);
        L15:
            r102.endStructure(r101);
            return new SearchFilterPayload(r104, r106);
        L5:
            int r107 = 0;
        L6:
            if (r104 == 0) goto L14;
            int r108 = r102.decodeElementIndex(r101);
            if (r108 != (-1)) goto L9;
            r104 = 0;
            goto L6
        L9:
            if (r108 != 0) goto L12;
            r105 = (List) r102.decodeSerializableElement(r101, 0, r103[0].getValue(), r105);
            r107 = r107 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r108);
        L14:
            r104 = r107;
            r106 = r105;
            goto L15
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            SearchFilterPayload r102 = (SearchFilterPayload) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243481b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeSerializableElement(r103, 0, SearchFilterPayload.f243477k[0].getValue(), r102.f243478i);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SearchFilterPayload> serializer() {
            return a.f243480a;
        }
    }

    public static final class c implements Parcelable.Creator<SearchFilterPayload> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchFilterPayload createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            ArrayList r102 = new ArrayList(r101);
            int r103 = 0;
        L3:
            if (r103 == r101) goto L6;
            r102.add(FlowFilterData.CREATOR.createFromParcel(r100));
            r103 = r103 + 1;
            goto L3
        L6:
            return new SearchFilterPayload(r102);
        }

        @Override // android.os.Parcelable.Creator
        public final SearchFilterPayload[] newArray(int r100) {
            return new SearchFilterPayload[r100];
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
        if ((r100 instanceof SearchFilterPayload) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f243478i, ((SearchFilterPayload) r100).f243478i) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f243478i.hashCode();
    }

    public final String toString() {
        return "SearchFilterPayload(domainFilter=" + this.f243478i + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<FlowFilterData> r102 = this.f243478i;
        r100.writeInt(r102.size());
        Iterator<FlowFilterData> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().writeToParcel(r100, r101);
        goto L4
    }

    static {
        Companion = new b();
        CREATOR = new c();
        f243477k = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new xv5.c())};
    }

    @Override // com.bytedance.flow.search.kmp.api.model.ISearchDataPayload
    public int getType() {
        return this.f243479j;
    }

    public SearchFilterPayload(List<FlowFilterData> r100) {
        Intrinsics.checkNotNullParameter(r100, "domainFilter");
        this.f243478i = r100;
        this.f243479j = 100;
    }

    public SearchFilterPayload(int r100, List r101) {
        if (1 != (r100 & 1)) goto L6;
        this.f243478i = r101;
        this.f243479j = 100;
        return;
    L6:
        b2.b(r100, 1, a.f243481b);
        throw null;
    }
}
