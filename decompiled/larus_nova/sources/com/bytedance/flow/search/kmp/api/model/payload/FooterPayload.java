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
import nuc.w0;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0005J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0005J%\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\u00058\u0016X\u0097D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0010¨\u0006/"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/payload/FooterPayload;", "Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "text", "", "iconResId", "", "domain", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getIconResId", "()I", "getDomain", "type", "getType$annotations", "()V", "getType", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class FooterPayload extends ISearchDataPayload {
    public static final Parcelable.Creator<FooterPayload> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f243394i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f243395j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f243396k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f243397l;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<FooterPayload> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243398a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243399b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{r100, w0.f520792a, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243399b;
        }

        static {
            a r100 = new a();
            f243398a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.model.payload.FooterPayload", r100, 3);
            r101.j("text", false);
            r101.j("iconResId", false);
            r101.j("domain", true);
            f243399b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f243399b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            String r101 = r111.decodeStringElement(r100, 0);
            int r102 = r111.decodeIntElement(r100, 1);
            String r103 = r111.decodeStringElement(r100, 2);
            int r104 = 7;
        L19:
            r111.endStructure(r100);
            return new FooterPayload(r104, r101, r102, r103);
        L5:
            r101 = null;
            String r105 = null;
            int r106 = 0;
            int r107 = 0;
            boolean r108 = true;
        L6:
            if (r108 == false) goto L18;
            int r109 = r111.decodeElementIndex(r100);
            if (r109 != (-1)) goto L9;
            r108 = false;
            goto L6
        L9:
            if (r109 != 0) goto L10;
            r101 = r111.decodeStringElement(r100, 0);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L11;
            r106 = r111.decodeIntElement(r100, 1);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r109 != 2) goto L14;
            r105 = r111.decodeStringElement(r100, 2);
            r107 = r107 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r109);
        L18:
            r103 = r105;
            r102 = r106;
            r104 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            FooterPayload r102 = (FooterPayload) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f243399b;
            muc.d r104 = r100.beginStructure(r103);
            boolean r105 = false;
            r104.encodeStringElement(r103, 0, r102.f243394i);
            r104.encodeIntElement(r103, 1, r102.f243395j);
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L6;
        L7:
            r105 = true;
        L8:
            if (r105 == false) goto L10;
            r104.encodeStringElement(r103, 2, r102.f243396k);
        L10:
            r104.endStructure(r103);
            return;
        L6:
            if (Intrinsics.areEqual(r102.f243396k, "") == true) goto L8;
            goto L7
        }
    }

    public static final class b {
        public b() {
        }

        public final d<FooterPayload> serializer() {
            return a.f243398a;
        }
    }

    public static final class c implements Parcelable.Creator<FooterPayload> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final FooterPayload createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new FooterPayload(r100.readString(), r100.readInt(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final FooterPayload[] newArray(int r100) {
            return new FooterPayload[r100];
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
        if ((r100 instanceof FooterPayload) == true) goto L8;
        return false;
    L8:
        FooterPayload r101 = (FooterPayload) r100;
        if (Intrinsics.areEqual(this.f243394i, r101.f243394i) == true) goto L12;
        return false;
    L12:
        if (this.f243395j == r101.f243395j) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f243396k, r101.f243396k) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f243394i.hashCode() * 31) + this.f243395j) * 31) + this.f243396k.hashCode();
    }

    public final String toString() {
        return "FooterPayload(text=" + this.f243394i + ", iconResId=" + this.f243395j + ", domain=" + this.f243396k + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243394i);
        r100.writeInt(this.f243395j);
        r100.writeString(this.f243396k);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    @Override // com.bytedance.flow.search.kmp.api.model.ISearchDataPayload
    public int getType() {
        return this.f243397l;
    }

    public FooterPayload(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r102, "domain");
        this.f243394i = r100;
        this.f243395j = r101;
        this.f243396k = r102;
        this.f243397l = 109;
    }

    public FooterPayload(int r100, String r101, int r102, String r103) {
        if (3 != (r100 & 3)) goto L10;
        this.f243394i = r101;
        this.f243395j = r102;
        if ((r100 & 4) != 0) goto L7;
        this.f243396k = "";
    L8:
        this.f243397l = 109;
        return;
    L7:
        this.f243396k = r103;
        goto L8
    L10:
        b2.b(r100, 3, a.f243399b);
        throw null;
    }
}
