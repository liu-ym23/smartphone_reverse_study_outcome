package com.bytedance.flow.search.kmp.api.model.payload;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0007J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007J%\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00078\u0016X\u0097D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e¨\u0006-"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/payload/SearchAccountPayload;", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "keyword", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKeyword$annotations", "()V", "getKeyword", "()Ljava/lang/String;", "type", "getType$annotations", "getType", "()I", "entityId", "getEntityId$annotations", "getEntityId", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SearchAccountPayload extends ISearchDataPayload {
    public static final Parcelable.Creator<SearchAccountPayload> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f243473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f243474j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<SearchAccountPayload> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243475a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243476b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{v2.f520790a};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243476b;
        }

        static {
            a r100 = new a();
            f243475a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.payload.SearchAccountPayload", r100, 1);
            r101.j("keyword", true);
            f243476b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            g2 r101 = f243476b;
            muc.c r102 = r100.beginStructure(r101);
            int r103 = 1;
            if (r102.decodeSequentially() == false) goto L5;
            String r104 = r102.decodeStringElement(r101, 0);
        L15:
            r102.endStructure(r101);
            return new SearchAccountPayload(r103, r104);
        L5:
            r104 = null;
            int r105 = 0;
        L6:
            if (r103 == 0) goto L14;
            int r106 = r102.decodeElementIndex(r101);
            if (r106 != (-1)) goto L9;
            r103 = 0;
            goto L6
        L9:
            if (r106 != 0) goto L12;
            r104 = r102.decodeStringElement(r101, 0);
            r105 = r105 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r106);
        L14:
            r103 = r105;
            goto L15
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            SearchAccountPayload r102 = (SearchAccountPayload) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243476b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = SearchAccountPayload.Companion;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L11;
            r104.encodeStringElement(r103, 0, r102.f243473i);
        L11:
            r104.endStructure(r103);
            return;
        L6:
            if (Intrinsics.areEqual(r102.f243473i, "") == false) goto L7;
            r106 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SearchAccountPayload> serializer() {
            return a.f243475a;
        }
    }

    public static final class c implements Parcelable.Creator<SearchAccountPayload> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchAccountPayload createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SearchAccountPayload(r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SearchAccountPayload[] newArray(int r100) {
            return new SearchAccountPayload[r100];
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
        if ((r100 instanceof SearchAccountPayload) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f243473i, ((SearchAccountPayload) r100).f243473i) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f243473i.hashCode();
    }

    public final String toString() {
        return "SearchAccountPayload(keyword=" + this.f243473i + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243473i);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public SearchAccountPayload() {
        this("");
    }

    @Override // com.bytedance.flow.search.kmp.api.model.ISearchDataPayload
    public final String c() {
        return this.f243473i;
    }

    @Override // com.bytedance.flow.search.kmp.api.model.ISearchDataPayload
    public int getType() {
        return this.f243474j;
    }

    public SearchAccountPayload(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        this.f243473i = r100;
        this.f243474j = 118;
    }

    public SearchAccountPayload(int r100, String r101) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f243476b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f243473i = "";
    L8:
        this.f243474j = 118;
        return;
    L7:
        this.f243473i = r101;
        goto L8
    }
}
