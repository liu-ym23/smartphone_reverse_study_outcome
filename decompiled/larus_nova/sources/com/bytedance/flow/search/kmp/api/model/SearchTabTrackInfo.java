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
import nuc.w0;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00060\u0001j\u0002`\u0002:\u0002'(B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB-\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0006J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0006J%\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006)"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/SearchTabTrackInfo;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "tab", "", "switchLevel", "", "<init>", "(Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTab", "()Ljava/lang/String;", "getSwitchLevel", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SearchTabTrackInfo implements Parcelable {
    public static final Parcelable.Creator<SearchTabTrackInfo> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f243321b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<SearchTabTrackInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243322a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243323b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{v2.f520790a, w0.f520792a};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243323b;
        }

        static {
            a r100 = new a();
            f243322a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.SearchTabTrackInfo", r100, 2);
            r101.j("tab", false);
            r101.j("switchLevel", false);
            f243323b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f243323b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            String r101 = r111.decodeStringElement(r100, 0);
            int r102 = r111.decodeIntElement(r100, 1);
            int r103 = 3;
        L17:
            r111.endStructure(r100);
            return new SearchTabTrackInfo(r103, r101, r102);
        L5:
            r101 = null;
            int r104 = 0;
            int r105 = 0;
            boolean r106 = true;
        L6:
            if (r106 == false) goto L16;
            int r107 = r111.decodeElementIndex(r100);
            if (r107 != (-1)) goto L9;
            r106 = false;
            goto L6
        L9:
            if (r107 != 0) goto L10;
            r101 = r111.decodeStringElement(r100, 0);
            r105 = r105 | 1;
            goto L6
        L10:
            if (r107 != 1) goto L13;
            r104 = r111.decodeIntElement(r100, 1);
            r105 = r105 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r107);
        L16:
            r102 = r104;
            r103 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            SearchTabTrackInfo r102 = (SearchTabTrackInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243323b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeStringElement(r103, 0, r102.f243320a);
            r104.encodeIntElement(r103, 1, r102.f243321b);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SearchTabTrackInfo> serializer() {
            return a.f243322a;
        }
    }

    public static final class c implements Parcelable.Creator<SearchTabTrackInfo> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchTabTrackInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SearchTabTrackInfo(r100.readString(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final SearchTabTrackInfo[] newArray(int r100) {
            return new SearchTabTrackInfo[r100];
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
        if ((r100 instanceof SearchTabTrackInfo) == true) goto L8;
        return false;
    L8:
        SearchTabTrackInfo r101 = (SearchTabTrackInfo) r100;
        if (Intrinsics.areEqual(this.f243320a, r101.f243320a) == true) goto L12;
        return false;
    L12:
        if (this.f243321b == r101.f243321b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f243320a.hashCode() * 31) + this.f243321b;
    }

    public final String toString() {
        return "SearchTabTrackInfo(tab=" + this.f243320a + ", switchLevel=" + this.f243321b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243320a);
        r100.writeInt(this.f243321b);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public SearchTabTrackInfo(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        this.f243320a = r100;
        this.f243321b = r101;
    }

    public SearchTabTrackInfo(int r100, String r101, int r102) {
        if (3 != (r100 & 3)) goto L6;
        this.f243320a = r101;
        this.f243321b = r102;
        return;
    L6:
        b2.b(r100, 3, a.f243323b);
        throw null;
    }
}
