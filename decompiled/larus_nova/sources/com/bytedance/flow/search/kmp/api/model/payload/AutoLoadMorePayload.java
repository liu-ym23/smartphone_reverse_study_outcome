package com.bytedance.flow.search.kmp.api.model.payload;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.flow.search.kmp.api.model.ISearchDataPayload;
import com.bytedance.flow.search.kmp.api.model.SearchCursor;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
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
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u000bJ\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u000bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000bJ%\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u000b8\u0016X\u0097D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u00062"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/payload/AutoLoadMorePayload;", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "domain", "", "hasMore", "", EffectConfiguration.KEY_CURSOR, "Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;", "<init>", "(Ljava/lang/String;ZLcom/bytedance/flow/search/kmp/api/model/SearchCursor;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLcom/bytedance/flow/search/kmp/api/model/SearchCursor;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDomain", "()Ljava/lang/String;", "getHasMore", "()Z", "getCursor", "()Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;", "type", "getType$annotations", "()V", "getType", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class AutoLoadMorePayload extends ISearchDataPayload {
    public static final Parcelable.Creator<AutoLoadMorePayload> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f243324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f243325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SearchCursor f243326k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f243327l;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<AutoLoadMorePayload> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243328a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243329b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{v2.f520790a, i.f520705a, SearchCursor.a.f243313a};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243329b;
        }

        static {
            a r100 = new a();
            f243328a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.payload.AutoLoadMorePayload", r100, 3);
            r101.j("domain", true);
            r101.j("hasMore", true);
            r101.j(EffectConfiguration.KEY_CURSOR, true);
            f243329b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f243329b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            String r101 = r111.decodeStringElement(r100, 0);
            boolean r102 = r111.decodeBooleanElement(r100, 1);
            SearchCursor r103 = (SearchCursor) r111.decodeSerializableElement(r100, 2, SearchCursor.a.f243313a, null);
            int r104 = 7;
        L19:
            r111.endStructure(r100);
            return new AutoLoadMorePayload(r104, r101, r102, r103);
        L5:
            String r105 = null;
            SearchCursor r106 = null;
            boolean r107 = false;
            int r108 = 0;
            boolean r109 = true;
        L6:
            if (r109 == false) goto L18;
            int r112 = r111.decodeElementIndex(r100);
            if (r112 != (-1)) goto L9;
            r109 = false;
            goto L6
        L9:
            if (r112 != 0) goto L10;
            r105 = r111.decodeStringElement(r100, 0);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r112 != 1) goto L11;
            r107 = r111.decodeBooleanElement(r100, 1);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r112 != 2) goto L14;
            r106 = (SearchCursor) r111.decodeSerializableElement(r100, 2, SearchCursor.a.f243313a, r106);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r112);
        L18:
            r102 = r107;
            r104 = r108;
            r101 = r105;
            r103 = r106;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            AutoLoadMorePayload r102 = (AutoLoadMorePayload) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243329b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = AutoLoadMorePayload.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeStringElement(r103, 0, r102.f243324i);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeBooleanElement(r103, 1, r102.f243325j);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == true) goto L25;
            SearchCursor r109 = r102.f243326k;
            SearchCursor.Companion.getClass();
            if (Intrinsics.areEqual(r109, SearchCursor.f243310d) == false) goto L25;
        L26:
            if (r106 == false) goto L28;
            r104.encodeSerializableElement(r103, 2, SearchCursor.a.f243313a, r102.f243326k);
        L28:
            r104.endStructure(r103);
            return;
        L25:
            r106 = true;
            goto L26
        L15:
            if (r102.f243325j == true) goto L16;
            r108 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r102.f243324i, "") == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<AutoLoadMorePayload> serializer() {
            return a.f243328a;
        }
    }

    public static final class c implements Parcelable.Creator<AutoLoadMorePayload> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final AutoLoadMorePayload createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r100.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            return new AutoLoadMorePayload(r101, r102, SearchCursor.CREATOR.createFromParcel(r100));
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AutoLoadMorePayload[] newArray(int r100) {
            return new AutoLoadMorePayload[r100];
        }
    }

    public AutoLoadMorePayload() {
        this(null, false, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AutoLoadMorePayload) == true) goto L8;
        return false;
    L8:
        AutoLoadMorePayload r101 = (AutoLoadMorePayload) r100;
        if (Intrinsics.areEqual(this.f243324i, r101.f243324i) == true) goto L12;
        return false;
    L12:
        if (this.f243325j == r101.f243325j) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f243326k, r101.f243326k) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f243324i.hashCode() * 31;
        if (this.f243325j == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f243326k.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "AutoLoadMorePayload(domain=" + this.f243324i + ", hasMore=" + this.f243325j + ", cursor=" + this.f243326k + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243324i);
        r100.writeInt(this.f243325j ? 1 : 0);
        this.f243326k.writeToParcel(r100, r101);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    @Override // com.bytedance.flow.search.kmp.api.model.ISearchDataPayload
    public int getType() {
        return this.f243327l;
    }

    public AutoLoadMorePayload(String r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r102 & 4) == 0) goto L11;
        SearchCursor.Companion.getClass();
        SearchCursor r103 = SearchCursor.f243310d;
    L12:
        this(r100, r101, r103);
        return;
    L11:
        r103 = null;
        goto L12
    }

    public AutoLoadMorePayload(String r100, boolean r101, SearchCursor r102) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r102, EffectConfiguration.KEY_CURSOR);
        this.f243324i = r100;
        this.f243325j = r101;
        this.f243326k = r102;
        this.f243327l = 110;
    }

    public AutoLoadMorePayload(int r100, String r101, boolean r102, SearchCursor r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f243329b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = "";
    L7:
        this.f243324i = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f243325j = false;
    L12:
        if ((r100 & 4) != 0) goto L14;
        SearchCursor.Companion.getClass();
        this.f243326k = SearchCursor.f243310d;
    L15:
        this.f243327l = 110;
        return;
    L14:
        this.f243326k = r103;
        goto L15
    L10:
        this.f243325j = r102;
        goto L12
    }
}
