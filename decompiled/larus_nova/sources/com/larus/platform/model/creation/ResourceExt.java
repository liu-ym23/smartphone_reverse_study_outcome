package com.larus.platform.model.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.platform.api.creation.Resource;
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

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0002()B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\nJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nJ%\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/larus/platform/model/creation/ResourceExt;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "resource", "Lcom/larus/platform/api/creation/Resource;", "coverImageUrl", "", "<init>", "(Lcom/larus/platform/api/creation/Resource;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/creation/Resource;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getResource", "()Lcom/larus/platform/api/creation/Resource;", "getCoverImageUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ResourceExt implements Parcelable {
    public static final Parcelable.Creator<ResourceExt> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resource f365630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365631b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ResourceExt> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f365632a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f365633b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(Resource.a.f364953a), kuc.a.d(v2.f520790a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f365633b;
        }

        static {
            a r100 = new a();
            f365632a = r100;
            g2 r101 = new g2("com.larus.platform.model.creation.ResourceExt", r100, 2);
            r101.j("resource", true);
            r101.j("coverImageUrl", true);
            f365633b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f365633b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            Resource r102 = (Resource) r111.decodeNullableSerializableElement(r100, 0, Resource.a.f364953a, null);
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            int r104 = 3;
        L17:
            r111.endStructure(r100);
            return new ResourceExt(r104, r102, r103);
        L5:
            Resource r105 = null;
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
            r105 = (Resource) r111.decodeNullableSerializableElement(r100, 0, Resource.a.f364953a, r105);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r108 != 1) goto L13;
            r101 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r101);
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
            ResourceExt r102 = (ResourceExt) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f365633b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = ResourceExt.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, Resource.a.f364953a, r102.f365630a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f365631b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f365631b == null) goto L17;
        L6:
            if (r102.f365630a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ResourceExt> serializer() {
            return a.f365632a;
        }
    }

    public static final class c implements Parcelable.Creator<ResourceExt> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceExt createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Resource r101 = null;
        L7:
            return new ResourceExt(r101, r100.readString());
        L5:
            r101 = Resource.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceExt[] newArray(int r100) {
            return new ResourceExt[r100];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceExt() {
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
        if ((r100 instanceof ResourceExt) == true) goto L8;
        return false;
    L8:
        ResourceExt r101 = (ResourceExt) r100;
        if (Intrinsics.areEqual(this.f365630a, r101.f365630a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365631b, r101.f365631b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Resource r100 = this.f365630a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f365631b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ResourceExt(resource=" + this.f365630a + ", coverImageUrl=" + this.f365631b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Resource r102 = this.f365630a;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.f365631b);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public ResourceExt(Resource r100, String r101) {
        this.f365630a = r100;
        this.f365631b = r101;
    }

    public ResourceExt(int r100, Resource r101, String r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f365633b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f365630a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f365631b = null;
        return;
    L11:
        this.f365631b = r102;
        return;
    L7:
        this.f365630a = r101;
        goto L9
    }

    public /* synthetic */ ResourceExt(Resource r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
