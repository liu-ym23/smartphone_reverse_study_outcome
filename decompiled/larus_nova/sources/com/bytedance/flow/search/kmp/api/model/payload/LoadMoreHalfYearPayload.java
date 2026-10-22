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
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\tJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tJ%\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\t8\u0016X\u0097D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006."}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/payload/LoadMoreHalfYearPayload;", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "domain", "", EffectConfiguration.KEY_CURSOR, "Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;", "<init>", "(Ljava/lang/String;Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDomain", "()Ljava/lang/String;", "getCursor", "()Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;", "type", "getType$annotations", "()V", "getType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class LoadMoreHalfYearPayload extends ISearchDataPayload {
    public static final Parcelable.Creator<LoadMoreHalfYearPayload> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f243418i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SearchCursor f243419j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f243420k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<LoadMoreHalfYearPayload> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243421a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243422b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{v2.f520790a, SearchCursor.a.f243313a};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243422b;
        }

        static {
            a r100 = new a();
            f243421a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.payload.LoadMoreHalfYearPayload", r100, 2);
            r101.j("domain", true);
            r101.j(EffectConfiguration.KEY_CURSOR, true);
            f243422b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f243422b;
            muc.c r111 = r110.beginStructure(r100);
            SearchCursor r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            String r102 = r111.decodeStringElement(r100, 0);
            SearchCursor r103 = (SearchCursor) r111.decodeSerializableElement(r100, 1, SearchCursor.a.f243313a, null);
            int r104 = 3;
        L17:
            r111.endStructure(r100);
            return new LoadMoreHalfYearPayload(r104, r102, r103);
        L5:
            String r105 = null;
            int r106 = 0;
            boolean r107 = true;
        L6:
            if (r107 == false) goto L16;
            int r108 = r111.decodeElementIndex(r100);
            if (r108 != (-1)) goto L9;
            r107 = false;
            goto L6
        L9:
            if (r108 != 0) goto L10;
            r105 = r111.decodeStringElement(r100, 0);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r108 != 1) goto L13;
            r101 = (SearchCursor) r111.decodeSerializableElement(r100, 1, SearchCursor.a.f243313a, r101);
            r106 = r106 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r108);
        L16:
            r104 = r106;
            r103 = r101;
            r102 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            LoadMoreHalfYearPayload r102 = (LoadMoreHalfYearPayload) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243422b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = LoadMoreHalfYearPayload.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeStringElement(r103, 0, r102.f243418i);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == true) goto L16;
            SearchCursor r108 = r102.f243419j;
            SearchCursor.Companion.getClass();
            if (Intrinsics.areEqual(r108, SearchCursor.f243310d) == false) goto L16;
        L17:
            if (r106 == false) goto L19;
            r104.encodeSerializableElement(r103, 1, SearchCursor.a.f243313a, r102.f243419j);
        L19:
            r104.endStructure(r103);
            return;
        L16:
            r106 = true;
            goto L17
        L6:
            if (Intrinsics.areEqual(r102.f243418i, "") == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<LoadMoreHalfYearPayload> serializer() {
            return a.f243421a;
        }
    }

    public static final class c implements Parcelable.Creator<LoadMoreHalfYearPayload> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final LoadMoreHalfYearPayload createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new LoadMoreHalfYearPayload(r100.readString(), SearchCursor.CREATOR.createFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public final LoadMoreHalfYearPayload[] newArray(int r100) {
            return new LoadMoreHalfYearPayload[r100];
        }
    }

    public LoadMoreHalfYearPayload() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LoadMoreHalfYearPayload) == true) goto L8;
        return false;
    L8:
        LoadMoreHalfYearPayload r101 = (LoadMoreHalfYearPayload) r100;
        if (Intrinsics.areEqual(this.f243418i, r101.f243418i) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243419j, r101.f243419j) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f243418i.hashCode() * 31) + this.f243419j.hashCode();
    }

    public final String toString() {
        return "LoadMoreHalfYearPayload(domain=" + this.f243418i + ", cursor=" + this.f243419j + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243418i);
        this.f243419j.writeToParcel(r100, r101);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    @Override // com.bytedance.flow.search.kmp.api.model.ISearchDataPayload
    public int getType() {
        return this.f243420k;
    }

    public LoadMoreHalfYearPayload(int r100) {
        SearchCursor.Companion.getClass();
        this("", SearchCursor.f243310d);
    }

    public LoadMoreHalfYearPayload(String r100, SearchCursor r101) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_CURSOR);
        this.f243418i = r100;
        this.f243419j = r101;
        this.f243420k = 107;
    }

    public LoadMoreHalfYearPayload(int r100, String r101, SearchCursor r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f243422b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = "";
    L7:
        this.f243418i = r101;
        if ((r100 & 2) != 0) goto L10;
        SearchCursor.Companion.getClass();
        this.f243419j = SearchCursor.f243310d;
    L11:
        this.f243420k = 107;
        return;
    L10:
        this.f243419j = r102;
        goto L11
    }
}
