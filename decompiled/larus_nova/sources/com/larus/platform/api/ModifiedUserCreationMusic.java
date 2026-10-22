package com.larus.platform.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u0002/0B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u000bJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000bJ%\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012¨\u00061"}, d2 = {"Lcom/larus/platform/api/ModifiedUserCreationMusic;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "title", "", "cover", "Lcom/larus/platform/api/ImageInfo;", "coverMainColor", "<init>", "(Ljava/lang/String;Lcom/larus/platform/api/ImageInfo;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/platform/api/ImageInfo;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "getCover$annotations", "getCover", "()Lcom/larus/platform/api/ImageInfo;", "getCoverMainColor$annotations", "getCoverMainColor", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ModifiedUserCreationMusic implements Parcelable {
    public static final Parcelable.Creator<ModifiedUserCreationMusic> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f364817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageInfo f364818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f364819c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<ModifiedUserCreationMusic> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f364820a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final nuc.g2 f364821b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            nuc.v2 r100 = nuc.v2.f520790a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(ImageInfo.a.f364808a), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f364821b;
        }

        static {
            a r100 = new a();
            f364820a = r100;
            nuc.g2 r101 = new nuc.g2("com.larus.platform.api.ModifiedUserCreationMusic", r100, 3);
            r101.j("title", true);
            r101.j("cover", true);
            r101.j("cover_main_color", true);
            f364821b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return nuc.i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            nuc.g2 r100 = f364821b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            nuc.v2 r102 = nuc.v2.f520790a;
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 0, r102, null);
            ImageInfo r104 = (ImageInfo) r111.decodeNullableSerializableElement(r100, 1, ImageInfo.a.f364808a, null);
            String r105 = (String) r111.decodeNullableSerializableElement(r100, 2, r102, null);
            int r106 = 7;
        L19:
            r111.endStructure(r100);
            return new ModifiedUserCreationMusic(r106, r103, r104, r105);
        L5:
            ImageInfo r107 = null;
            String r108 = null;
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
            r101 = (String) r111.decodeNullableSerializableElement(r100, 0, nuc.v2.f520790a, r101);
            r109 = r109 | 1;
            goto L6
        L10:
            if (r113 != 1) goto L11;
            r107 = (ImageInfo) r111.decodeNullableSerializableElement(r100, 1, ImageInfo.a.f364808a, r107);
            r109 = r109 | 2;
            goto L6
        L11:
            if (r113 != 2) goto L14;
            r108 = (String) r111.decodeNullableSerializableElement(r100, 2, nuc.v2.f520790a, r108);
            r109 = r109 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r113);
        L18:
            r106 = r109;
            r103 = r101;
            r104 = r107;
            r105 = r108;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ModifiedUserCreationMusic r102 = (ModifiedUserCreationMusic) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            nuc.g2 r103 = f364821b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = ModifiedUserCreationMusic.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, nuc.v2.f520790a, r102.f364817a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, ImageInfo.a.f364808a, r102.f364818b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            r106 = true;
        L26:
            if (r106 == false) goto L28;
            r104.encodeNullableSerializableElement(r103, 2, nuc.v2.f520790a, r102.f364819c);
        L28:
            r104.endStructure(r103);
            return;
        L24:
            if (Intrinsics.areEqual(r102.f364819c, "") == true) goto L26;
        L15:
            if (r102.f364818b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f364817a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<ModifiedUserCreationMusic> serializer() {
            return a.f364820a;
        }
    }

    public static final class c implements Parcelable.Creator<ModifiedUserCreationMusic> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final ModifiedUserCreationMusic createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            ImageInfo r102 = null;
        L7:
            return new ModifiedUserCreationMusic(r101, r102, r100.readString());
        L5:
            r102 = ImageInfo.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ModifiedUserCreationMusic[] newArray(int r100) {
            return new ModifiedUserCreationMusic[r100];
        }
    }

    public ModifiedUserCreationMusic() {
        this(null, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ModifiedUserCreationMusic) == true) goto L8;
        return false;
    L8:
        ModifiedUserCreationMusic r101 = (ModifiedUserCreationMusic) r100;
        if (Intrinsics.areEqual(this.f364817a, r101.f364817a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f364818b, r101.f364818b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f364819c, r101.f364819c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f364817a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ImageInfo r104 = this.f364818b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f364819c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ModifiedUserCreationMusic(title=" + this.f364817a + ", cover=" + this.f364818b + ", coverMainColor=" + this.f364819c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f364817a);
        ImageInfo r102 = this.f364818b;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.f364819c);
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

    public /* synthetic */ ModifiedUserCreationMusic(String r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r101 & 4) == 0) goto L8;
        String r102 = "";
    L9:
        this(r100, null, r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public ModifiedUserCreationMusic(String r100, ImageInfo r101, String r102) {
        this.f364817a = r100;
        this.f364818b = r101;
        this.f364819c = r102;
    }

    public ModifiedUserCreationMusic(int r100, String r101, ImageInfo r102, String r103) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f364821b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f364817a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f364818b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f364819c = "";
        return;
    L15:
        this.f364819c = r103;
        return;
    L11:
        this.f364818b = r102;
        goto L13
    L7:
        this.f364817a = r101;
        goto L9
    }
}
