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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J'\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u001c\u001a\u00020\nJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\nHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\nJ%\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\n8\u0016X\u0097D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u00061"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/payload/LoadMoreFailedPayload;", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "domain", "", EffectConfiguration.KEY_CURSOR, "Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;", "text", "<init>", "(Ljava/lang/String;Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDomain", "()Ljava/lang/String;", "getCursor", "()Lcom/bytedance/flow/search/kmp/api/model/SearchCursor;", "getText", "type", "getType$annotations", "()V", "getType", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class LoadMoreFailedPayload extends ISearchDataPayload {
    public static final Parcelable.Creator<LoadMoreFailedPayload> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f243408i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SearchCursor f243409j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f243410k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f243411l;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<LoadMoreFailedPayload> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243412a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243413b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{r100, SearchCursor.a.f243313a, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243413b;
        }

        static {
            a r100 = new a();
            f243412a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.payload.LoadMoreFailedPayload", r100, 3);
            r101.j("domain", true);
            r101.j(EffectConfiguration.KEY_CURSOR, true);
            r101.j("text", true);
            f243413b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f243413b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            String r102 = r111.decodeStringElement(r100, 0);
            SearchCursor r103 = (SearchCursor) r111.decodeSerializableElement(r100, 1, SearchCursor.a.f243313a, null);
            String r104 = r111.decodeStringElement(r100, 2);
            int r105 = 7;
        L19:
            r111.endStructure(r100);
            return new LoadMoreFailedPayload(r105, r102, r103, r104);
        L5:
            SearchCursor r106 = null;
            String r107 = null;
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
            r101 = r111.decodeStringElement(r100, 0);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r112 != 1) goto L11;
            r106 = (SearchCursor) r111.decodeSerializableElement(r100, 1, SearchCursor.a.f243313a, r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r112 != 2) goto L14;
            r107 = r111.decodeStringElement(r100, 2);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r112);
        L18:
            r105 = r108;
            r102 = r101;
            r103 = r106;
            r104 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            LoadMoreFailedPayload r102 = (LoadMoreFailedPayload) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243413b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = LoadMoreFailedPayload.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeStringElement(r103, 0, r102.f243408i);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == true) goto L16;
            SearchCursor r108 = r102.f243409j;
            SearchCursor.Companion.getClass();
            if (Intrinsics.areEqual(r108, SearchCursor.f243310d) == false) goto L16;
            boolean r109 = false;
        L18:
            if (r109 == false) goto L21;
            r104.encodeSerializableElement(r103, 1, SearchCursor.a.f243313a, r102.f243409j);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeStringElement(r103, 2, r102.f243410k);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (Intrinsics.areEqual(r102.f243410k, "加载失败，点击重试") == true) goto L26;
        L16:
            r109 = true;
            goto L18
        L6:
            if (Intrinsics.areEqual(r102.f243408i, "") == false) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<LoadMoreFailedPayload> serializer() {
            return a.f243412a;
        }
    }

    public static final class c implements Parcelable.Creator<LoadMoreFailedPayload> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final LoadMoreFailedPayload createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new LoadMoreFailedPayload(r100.readString(), SearchCursor.CREATOR.createFromParcel(r100), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final LoadMoreFailedPayload[] newArray(int r100) {
            return new LoadMoreFailedPayload[r100];
        }
    }

    public LoadMoreFailedPayload() {
        this(null, null, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LoadMoreFailedPayload) == true) goto L8;
        return false;
    L8:
        LoadMoreFailedPayload r101 = (LoadMoreFailedPayload) r100;
        if (Intrinsics.areEqual(this.f243408i, r101.f243408i) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243409j, r101.f243409j) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f243410k, r101.f243410k) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f243408i.hashCode() * 31) + this.f243409j.hashCode()) * 31) + this.f243410k.hashCode();
    }

    public final String toString() {
        return "LoadMoreFailedPayload(domain=" + this.f243408i + ", cursor=" + this.f243409j + ", text=" + this.f243410k + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243408i);
        this.f243409j.writeToParcel(r100, r101);
        r100.writeString(this.f243410k);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    @Override // com.bytedance.flow.search.kmp.api.model.ISearchDataPayload
    public int getType() {
        return this.f243411l;
    }

    public LoadMoreFailedPayload(String r100, SearchCursor r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L9;
        SearchCursor.Companion.getClass();
        r101 = SearchCursor.f243310d;
    L9:
        if ((r102 & 4) == 0) goto L11;
        String r103 = "加载失败，点击重试";
    L12:
        this(r100, r101, r103);
        return;
    L11:
        r103 = null;
        goto L12
    }

    public LoadMoreFailedPayload(String r100, SearchCursor r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_CURSOR);
        Intrinsics.checkNotNullParameter(r102, "text");
        this.f243408i = r100;
        this.f243409j = r101;
        this.f243410k = r102;
        this.f243411l = 112;
    }

    public LoadMoreFailedPayload(int r100, String r101, SearchCursor r102, String r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f243413b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = "";
    L7:
        this.f243408i = r101;
        if ((r100 & 2) != 0) goto L10;
        SearchCursor.Companion.getClass();
        this.f243409j = SearchCursor.f243310d;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f243410k = "加载失败，点击重试";
    L15:
        this.f243411l = 112;
        return;
    L14:
        this.f243410k = r103;
        goto L15
    L10:
        this.f243409j = r102;
        goto L12
    }
}
