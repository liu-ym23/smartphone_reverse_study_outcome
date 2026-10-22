package com.bytedance.flow.search.kmp.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import wv5.g;
import wv5.h;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00060\u0001j\u0002`\u0002:\u0002;<Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006\u0018\u00010\f\u0012\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f0\u000e¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012By\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006\u0018\u00010\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u001d\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006\u0018\u00010\fHÆ\u0003J!\u0010'\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f0\u000e¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010\u0018\u00010\fHÆ\u0003Jy\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006\u0018\u00010\f2 \b\u0002\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f0\u000e¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010\u0018\u00010\fHÆ\u0001J\u0006\u0010)\u001a\u00020\bJ\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010-\u001a\u00020\bHÖ\u0001J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\bJ%\u00104\u001a\u0002002\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR%\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R)\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u000e\u0012\f0\u000e¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 ¨\u0006="}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/FlowQuery;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "keyword", "", "domains", "", "page", "", EffectConfiguration.KEY_CURSOR, "Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;", "filterMaps", "", "ext", "", "Lkotlinx/parcelize/RawValue;", "Lkotlinx/serialization/Contextual;", "<init>", "(Ljava/lang/String;Ljava/util/List;ILcom/bytedance/flow/search/kmp/api/model/SearchCursor;Ljava/util/Map;Ljava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;ILcom/bytedance/flow/search/kmp/api/model/SearchCursor;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKeyword", "()Ljava/lang/String;", "getDomains", "()Ljava/util/List;", "getPage", "()I", "getCursor", "()Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;", "getFilterMaps", "()Ljava/util/Map;", "getExt", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class FlowQuery implements Parcelable {
    public static final Parcelable.Creator<FlowQuery> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f243269g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f243271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f243272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SearchCursor f243273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, List<String>> f243274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f243275f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<FlowQuery> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243276a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243277b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243277b;
        }

        static {
            a r100 = new a();
            f243276a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.FlowQuery", r100, 6);
            r101.j("keyword", false);
            r101.j("domains", false);
            r101.j("page", true);
            r101.j(EffectConfiguration.KEY_CURSOR, true);
            r101.j("filterMaps", false);
            r101.j("ext", false);
            f243277b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy<d<Object>>[] r100 = FlowQuery.f243269g;
            return new d[]{v2.f520790a, r100[1].getValue(), w0.f520792a, kuc.a.d(SearchCursor.a.f243313a), kuc.a.d(r100[4].getValue()), kuc.a.d(r100[5].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f243277b;
            muc.c r101 = r110.beginStructure(r100);
            Lazy<d<Object>>[] r102 = FlowQuery.f243269g;
            if (r101.decodeSequentially() == false) goto L5;
            String r103 = r101.decodeStringElement(r100, 0);
            List r104 = (List) r101.decodeSerializableElement(r100, 1, r102[1].getValue(), null);
            int r105 = r101.decodeIntElement(r100, 2);
            SearchCursor r106 = (SearchCursor) r101.decodeNullableSerializableElement(r100, 3, SearchCursor.a.f243313a, null);
            Map r107 = (Map) r101.decodeNullableSerializableElement(r100, 4, r102[4].getValue(), null);
            Map r111 = (Map) r101.decodeNullableSerializableElement(r100, 5, r102[5].getValue(), null);
            String r112 = r103;
            Map r113 = r107;
            int r114 = r105;
            List r115 = r104;
            SearchCursor r116 = r106;
            int r108 = 63;
        L20:
            r101.endStructure(r100);
            return new FlowQuery(r108, r112, r115, r114, r116, r113, r111);
        L5:
            String r117 = null;
            Map r118 = null;
            List r119 = null;
            r113 = null;
            SearchCursor r120 = null;
            int r109 = 0;
            int r121 = 0;
            boolean r122 = true;
        L6:
            if (r122 == false) goto L19;
            int r123 = r101.decodeElementIndex(r100);
            switch(r123) {
                case -1: goto L18;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r123);
        L17:
            r117 = r101.decodeStringElement(r100, 0);
            r121 = r121 | 1;
            goto L6
        L18:
            r122 = false;
            goto L6
        L11:
            r121 = r121 | 32;
            r118 = (Map) r101.decodeNullableSerializableElement(r100, 5, r102[5].getValue(), r118);
            goto L6
        L12:
            r121 = r121 | 16;
            r113 = (Map) r101.decodeNullableSerializableElement(r100, 4, r102[4].getValue(), r113);
            goto L6
        L13:
            r121 = r121 | 8;
            r120 = (SearchCursor) r101.decodeNullableSerializableElement(r100, 3, SearchCursor.a.f243313a, r120);
            goto L6
        L14:
            r109 = r101.decodeIntElement(r100, 2);
            r121 = r121 | 4;
            goto L6
        L15:
            r121 = r121 | 2;
            r119 = (List) r101.decodeSerializableElement(r100, 1, r102[1].getValue(), r119);
            goto L6
        L19:
            r108 = r121;
            r112 = r117;
            r115 = r119;
            r116 = r120;
            r111 = r118;
            r114 = r109;
            goto L20
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            FlowQuery r102 = (FlowQuery) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243277b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<d<Object>>[] r105 = FlowQuery.f243269g;
            boolean r106 = false;
            r104.encodeStringElement(r103, 0, r102.f243270a);
            r104.encodeSerializableElement(r103, 1, r105[1].getValue(), r102.f243271b);
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeIntElement(r103, 2, r102.f243272c);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 3, SearchCursor.a.f243313a, r102.f243273d);
        L19:
            r104.encodeNullableSerializableElement(r103, 4, r105[4].getValue(), r102.f243274e);
            r104.encodeNullableSerializableElement(r103, 5, r105[5].getValue(), r102.f243275f);
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f243273d == null) goto L17;
        L6:
            if (r102.f243272c != 0) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<FlowQuery> serializer() {
            return a.f243276a;
        }
    }

    public static final class c implements Parcelable.Creator<FlowQuery> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final FlowQuery createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            ArrayList<String> r101 = r110.createStringArrayList();
            int r102 = r110.readInt();
            LinkedHashMap r103 = null;
            if (r110.readInt() != 0) goto L5;
            SearchCursor r104 = null;
        L6:
            SearchCursor r105 = r104;
            int r106 = 0;
            if (r110.readInt() != 0) goto L9;
            LinkedHashMap r107 = null;
        L13:
            if (r110.readInt() == 0) goto L19;
            int r108 = r110.readInt();
            r103 = new LinkedHashMap(r108);
        L16:
            if (r106 == r108) goto L19;
            r103.put(r110.readString(), r110.readValue(FlowQuery.class.getClassLoader()));
            r106 = r106 + 1;
        L19:
            return new FlowQuery(r100, r101, r102, r105, r107, r103);
        L9:
            int r109 = r110.readInt();
            r107 = new LinkedHashMap(r109);
            int r111 = 0;
        L10:
            if (r111 == r109) goto L13;
            r107.put(r110.readString(), r110.createStringArrayList());
            r111 = r111 + 1;
            goto L10
        L5:
            r104 = SearchCursor.CREATOR.createFromParcel(r110);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final FlowQuery[] newArray(int r100) {
            return new FlowQuery[r100];
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
        if ((r100 instanceof FlowQuery) == true) goto L8;
        return false;
    L8:
        FlowQuery r101 = (FlowQuery) r100;
        if (Intrinsics.areEqual(this.f243270a, r101.f243270a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243271b, r101.f243271b) == true) goto L15;
        return false;
    L15:
        if (this.f243272c == r101.f243272c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f243273d, r101.f243273d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f243274e, r101.f243274e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f243275f, r101.f243275f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f243270a.hashCode() * 31) + this.f243271b.hashCode()) * 31) + this.f243272c) * 31;
        SearchCursor r101 = this.f243273d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, List<String>> r105 = this.f243274e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, Object> r108 = this.f243275f;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowQuery(keyword=" + this.f243270a + ", domains=" + this.f243271b + ", page=" + this.f243272c + ", cursor=" + this.f243273d + ", filterMaps=" + this.f243274e + ", ext=" + this.f243275f + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243270a);
        r100.writeStringList(this.f243271b);
        r100.writeInt(this.f243272c);
        SearchCursor r102 = this.f243273d;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Map<String, List<String>> r103 = this.f243274e;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L13:
        Map<String, Object> r104 = this.f243275f;
        if (r104 != null) goto L16;
        r100.writeInt(0);
        return;
    L16:
        r100.writeInt(1);
        r100.writeInt(r104.size());
        Iterator<Map.Entry<String, Object>> r105 = r104.entrySet().iterator();
    L18:
        if (r105.hasNext() == false) goto L23;
        Map.Entry<String, Object> r106 = r105.next();
        r100.writeString(r106.getKey());
        r100.writeValue(r106.getValue());
        goto L18
    L23:
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<Map.Entry<String, List<String>>> r107 = r103.entrySet().iterator();
    L11:
        if (r107.hasNext() == false) goto L13;
        Map.Entry<String, List<String>> r108 = r107.next();
        r100.writeString(r108.getKey());
        r100.writeStringList(r108.getValue());
        goto L11
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f243269g = new Lazy[]{null, LazyKt.lazy(r100, new wv5.f()), null, null, LazyKt.lazy(r100, new g()), LazyKt.lazy(r100, new h())};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowQuery(String r100, List<String> r101, int r102, SearchCursor r103, Map<String, ? extends List<String>> r104, Map<String, ? extends Object> r105) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        Intrinsics.checkNotNullParameter(r101, "domains");
        this.f243270a = r100;
        this.f243271b = r101;
        this.f243272c = r102;
        this.f243273d = r103;
        this.f243274e = r104;
        this.f243275f = r105;
    }

    public static FlowQuery a(FlowQuery r100, String r101, List r102, int r110, Map r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f243270a;
    L5:
        String r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f243271b;
    L8:
        List r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.f243272c;
    L11:
        int r105 = r110;
        if ((r112 & 8) == 0) goto L14;
        SearchCursor r106 = r100.f243273d;
    L16:
        if ((r112 & 16) == 0) goto L18;
        r111 = r100.f243274e;
    L18:
        Map r107 = r111;
        if ((r112 & 32) == 0) goto L21;
        Map<String, Object> r108 = r100.f243275f;
    L22:
        Intrinsics.checkNotNullParameter(r103, "keyword");
        Intrinsics.checkNotNullParameter(r104, "domains");
        return new FlowQuery(r103, r104, r105, r106, r107, r108);
    L21:
        r108 = null;
        goto L22
    L14:
        r106 = null;
        goto L16
    }

    public FlowQuery(int r100, String r101, List r102, int r103, SearchCursor r104, Map r105, Map r110) {
        if (51 != (r100 & 51)) goto L14;
        this.f243270a = r101;
        this.f243271b = r102;
        if ((r100 & 4) != 0) goto L7;
        this.f243272c = 0;
    L9:
        if ((r100 & 8) != 0) goto L11;
        this.f243273d = null;
    L12:
        this.f243274e = r105;
        this.f243275f = r110;
        return;
    L11:
        this.f243273d = r104;
        goto L12
    L7:
        this.f243272c = r103;
        goto L9
    L14:
        b2.b(r100, 51, a.f243277b);
        throw null;
    }
}
