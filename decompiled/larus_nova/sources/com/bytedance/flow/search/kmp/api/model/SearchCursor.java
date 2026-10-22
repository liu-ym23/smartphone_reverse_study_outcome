package com.bytedance.flow.search.kmp.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
import wv5.l;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002./B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0000J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u001d\u001a\u00020\nJ\u0013\u0010\u001e\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\nJ%\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014¨\u00060"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "local", "", "remote", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLocal", "()Ljava/lang/String;", "getRemote", "()Ljava/util/Map;", "isEmpty", "", "()Z", "isNotEmpty", "remoteOf", "domain", "merge", "other", "component1", "component2", "copy", "describeContents", "equals", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "Companion", "$serializer", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SearchCursor implements Parcelable {
    public static final Parcelable.Creator<SearchCursor> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f243309c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SearchCursor f243310d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f243312b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<SearchCursor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243313a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243314b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243314b;
        }

        static {
            a r100 = new a();
            f243313a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.SearchCursor", r100, 2);
            r101.j("local", true);
            r101.j("remote", true);
            f243314b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(v2.f520790a), kuc.a.d(SearchCursor.f243309c[1].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f243314b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy<d<Object>>[] r101 = SearchCursor.f243309c;
            Map r102 = null;
            if (r111.decodeSequentially() == false) goto L5;
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            Map r104 = (Map) r111.decodeNullableSerializableElement(r100, 1, r101[1].getValue(), null);
            int r105 = 3;
        L17:
            r111.endStructure(r100);
            return new SearchCursor(r105, r103, r104);
        L5:
            String r106 = null;
            int r107 = 0;
            boolean r108 = true;
        L6:
            if (r108 == false) goto L16;
            int r109 = r111.decodeElementIndex(r100);
            if (r109 != (-1)) goto L9;
            r108 = false;
            goto L6
        L9:
            if (r109 != 0) goto L10;
            r106 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r106);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L13;
            r102 = (Map) r111.decodeNullableSerializableElement(r100, 1, r101[1].getValue(), r102);
            r107 = r107 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r109);
        L16:
            r105 = r107;
            r104 = r102;
            r103 = r106;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            SearchCursor r102 = (SearchCursor) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243314b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<d<Object>>[] r105 = SearchCursor.f243309c;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f243311a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 1, r105[1].getValue(), r102.f243312b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f243312b == null) goto L17;
        L6:
            if (r102.f243311a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SearchCursor> serializer() {
            return a.f243313a;
        }

        public static SearchCursor a(String r100) {
            if (r100 != null) goto L4;
        L7:
            boolean r101 = true;
        L8:
            if (r101 == true) goto L12;
            Map r102 = null;
            return new SearchCursor(r100, r102, 2);
        L12:
            return SearchCursor.f243310d;
        L4:
            if (r100.length() == 0) goto L7;
            r101 = false;
            goto L8
        }
    }

    public static final class c implements Parcelable.Creator<SearchCursor> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchCursor createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            LinkedHashMap r102 = null;
        L10:
            return new SearchCursor(r101, r102);
        L5:
            int r103 = r100.readInt();
            LinkedHashMap r104 = new LinkedHashMap(r103);
            int r105 = 0;
        L6:
            if (r105 == r103) goto L8;
            r104.put(r100.readString(), r100.readString());
            r105 = r105 + 1;
            goto L6
        L8:
            r102 = r104;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final SearchCursor[] newArray(int r100) {
            return new SearchCursor[r100];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchCursor() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchCursor) == true) goto L8;
        return false;
    L8:
        SearchCursor r101 = (SearchCursor) r100;
        if (Intrinsics.areEqual(this.f243311a, r101.f243311a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243312b, r101.f243312b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f243311a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f243312b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchCursor(local=" + this.f243311a + ", remote=" + this.f243312b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243311a);
        Map<String, String> r102 = this.f243312b;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<String, String> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeString(r104.getValue());
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new b();
        CREATOR = new c();
        f243309c = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new l())};
        f243310d = new SearchCursor(null, 0 == true ? 1 : 0, 3);
    }

    public final boolean a() {
        String r100 = this.f243311a;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L20;
        Map<String, String> r103 = this.f243312b;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L20;
        r101 = true;
        goto L20
    L13:
        if (r103.isEmpty() == true) goto L16;
        r104 = false;
    L20:
        return !r101;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final SearchCursor b(SearchCursor r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        String r101 = r100.f243311a;
        if (r101 != null) goto L7;
        r101 = this.f243311a;
    L7:
        Map<String, String> r102 = this.f243312b;
        boolean r103 = false;
        if (r102 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        Map r105 = null;
        if (r104 == false) goto L25;
        Map<String, String> r106 = r100.f243312b;
        if (r106 != null) goto L19;
    L22:
        boolean r107 = true;
    L23:
        if (r107 == false) goto L25;
    L45:
        return new SearchCursor(r101, r105);
    L19:
        if (r106.isEmpty() == true) goto L22;
        r107 = false;
    L25:
        Map<String, String> r108 = this.f243312b;
        if (r108 != null) goto L28;
    L31:
        boolean r109 = true;
    L32:
        if (r109 == false) goto L36;
        Map<String, String> r110 = r100.f243312b;
        if (r110 == null) goto L45;
        r105 = MapsKt.toMap(r110);
        goto L45
    L36:
        Map<String, String> r111 = r100.f243312b;
        if (r111 != null) goto L39;
    L40:
        r103 = true;
    L41:
        if (r103 == false) goto L43;
        r105 = MapsKt.toMap(this.f243312b);
        goto L45
    L43:
        r105 = MapsKt.toMutableMap(this.f243312b);
        r105.putAll(r100.f243312b);
        goto L45
    L39:
        if (r111.isEmpty() == false) goto L41;
    L28:
        if (r108.isEmpty() == true) goto L31;
        r109 = false;
        goto L32
    L10:
        if (r102.isEmpty() == true) goto L13;
        r104 = false;
        goto L14
    }

    public SearchCursor(String r100, Map<String, String> r101) {
        this.f243311a = r100;
        this.f243312b = r101;
    }

    public SearchCursor(int r100, String r101, Map r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f243314b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f243311a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f243312b = null;
        return;
    L11:
        this.f243312b = r102;
        return;
    L7:
        this.f243311a = r101;
        goto L9
    }

    public /* synthetic */ SearchCursor(String r100, Map r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
