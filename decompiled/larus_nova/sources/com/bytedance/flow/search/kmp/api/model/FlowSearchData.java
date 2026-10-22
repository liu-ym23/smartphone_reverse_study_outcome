package com.bytedance.flow.search.kmp.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
import nuc.v2;
import nuc.w0;
import wv5.i;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00060\u0001j\u0002`\u0002:\u0002./B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\u0007\u001a\f0\b¢\u0006\u0002\b\t¢\u0006\u0002\b\n¢\u0006\u0004\b\u000b\u0010\fB7\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u0019\u001a\f0\b¢\u0006\u0002\b\t¢\u0006\u0002\b\nHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0012\b\u0002\u0010\u0007\u001a\f0\b¢\u0006\u0002\b\t¢\u0006\u0002\b\nHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u0006J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006J%\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\f0\b¢\u0006\u0002\b\t¢\u0006\u0002\b\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00060"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "domain", "", "resultType", "", "content", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "Lkotlinx/parcelize/RawValue;", "Lkotlinx/serialization/Contextual;", "<init>", "(Ljava/lang/String;ILcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDomain", "()Ljava/lang/String;", "getResultType", "()I", "getContent", "()Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class FlowSearchData implements Parcelable {
    public static final Parcelable.Creator<FlowSearchData> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f243278d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f243280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ISearchDataPayload f243281c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<FlowSearchData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243282a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243283b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243283b;
        }

        static {
            a r100 = new a();
            f243282a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.FlowSearchData", r100, 3);
            r101.j("domain", false);
            r101.j("resultType", false);
            r101.j("content", false);
            f243283b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{v2.f520790a, w0.f520792a, FlowSearchData.f243278d[2].getValue()};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f243283b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy<d<Object>>[] r101 = FlowSearchData.f243278d;
            if (r111.decodeSequentially() == false) goto L5;
            String r102 = r111.decodeStringElement(r100, 0);
            int r103 = r111.decodeIntElement(r100, 1);
            ISearchDataPayload r104 = (ISearchDataPayload) r111.decodeSerializableElement(r100, 2, r101[2].getValue(), null);
            int r105 = 7;
        L19:
            r111.endStructure(r100);
            return new FlowSearchData(r105, r102, r103, r104);
        L5:
            String r106 = null;
            ISearchDataPayload r107 = null;
            int r108 = 0;
            int r109 = 0;
            boolean r112 = true;
        L6:
            if (r112 == false) goto L18;
            int r113 = r111.decodeElementIndex(r100);
            if (r113 != (-1)) goto L9;
            r112 = false;
            goto L6
        L9:
            if (r113 != 0) goto L10;
            r106 = r111.decodeStringElement(r100, 0);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r109 = r111.decodeIntElement(r100, 1);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r107 = (ISearchDataPayload) r111.decodeSerializableElement(r100, 2, r101[2].getValue(), r107);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r113);
        L18:
            r105 = r108;
            r103 = r109;
            r102 = r106;
            r104 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            FlowSearchData r102 = (FlowSearchData) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243283b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<d<Object>>[] r105 = FlowSearchData.f243278d;
            r104.encodeStringElement(r103, 0, r102.f243279a);
            r104.encodeIntElement(r103, 1, r102.f243280b);
            r104.encodeSerializableElement(r103, 2, r105[2].getValue(), r102.f243281c);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<FlowSearchData> serializer() {
            return a.f243282a;
        }
    }

    public static final class c implements Parcelable.Creator<FlowSearchData> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final FlowSearchData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new FlowSearchData(r100.readString(), r100.readInt(), (ISearchDataPayload) r100.readParcelable(FlowSearchData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final FlowSearchData[] newArray(int r100) {
            return new FlowSearchData[r100];
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
        if ((r100 instanceof FlowSearchData) == true) goto L8;
        return false;
    L8:
        FlowSearchData r101 = (FlowSearchData) r100;
        if (Intrinsics.areEqual(this.f243279a, r101.f243279a) == true) goto L12;
        return false;
    L12:
        if (this.f243280b == r101.f243280b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f243281c, r101.f243281c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f243279a.hashCode() * 31) + this.f243280b) * 31) + this.f243281c.hashCode();
    }

    public final String toString() {
        return "FlowSearchData(domain=" + this.f243279a + ", resultType=" + this.f243280b + ", content=" + this.f243281c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243279a);
        r100.writeInt(this.f243280b);
        r100.writeParcelable(this.f243281c, r101);
    }

    static {
        Companion = new b();
        CREATOR = new c();
        f243278d = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new i())};
    }

    public FlowSearchData(String r100, int r101, ISearchDataPayload r102) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r102, "content");
        this.f243279a = r100;
        this.f243280b = r101;
        this.f243281c = r102;
    }

    public FlowSearchData(int r100, String r101, int r102, ISearchDataPayload r103) {
        if (7 != (r100 & 7)) goto L6;
        this.f243279a = r101;
        this.f243280b = r102;
        this.f243281c = r103;
        return;
    L6:
        b2.b(r100, 7, a.f243283b);
        throw null;
    }

    public static FlowSearchData a(FlowSearchData r100, int r101, ISearchDataPayload r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        String r104 = r100.f243279a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = r100.f243280b;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = r100.f243281c;
    L12:
        Intrinsics.checkNotNullParameter(r104, "domain");
        Intrinsics.checkNotNullParameter(r102, "content");
        return new FlowSearchData(r104, r101, r102);
    L5:
        r104 = null;
        goto L7
    }
}
