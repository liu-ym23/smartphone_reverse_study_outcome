package com.larus.platform.api.creation;

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

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00060\u0001j\u0002`\u0002:\u0002)*B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\tJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\tJ%\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006+"}, d2 = {"Lcom/larus/platform/api/creation/UpdateUserCreationMusic;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "title", "", "coverUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "getCoverUri$annotations", "getCoverUri", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class UpdateUserCreationMusic implements Parcelable {
    public static final Parcelable.Creator<UpdateUserCreationMusic> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f364983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f364984b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UpdateUserCreationMusic> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f364985a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f364986b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f364986b;
        }

        static {
            a r100 = new a();
            f364985a = r100;
            g2 r101 = new g2("com.larus.platform.api.creation.UpdateUserCreationMusic", r100, 2);
            r101.j("title", true);
            r101.j("cover_uri", true);
            f364986b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f364986b;
            muc.c r111 = r110.beginStructure(r100);
            String r101 = null;
            if (r111.decodeSequentially() == false) goto L5;
            v2 r102 = v2.f520790a;
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 0, r102, null);
            String r104 = (String) r111.decodeNullableSerializableElement(r100, 1, r102, null);
            int r105 = 3;
        L17:
            r111.endStructure(r100);
            return new UpdateUserCreationMusic(r105, r103, r104);
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
            r101 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r101);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r109 != 1) goto L13;
            r106 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r106);
            r107 = r107 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r109);
        L16:
            r105 = r107;
            r103 = r101;
            r104 = r106;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            UpdateUserCreationMusic r102 = (UpdateUserCreationMusic) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f364986b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = UpdateUserCreationMusic.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f364983a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f364984b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (r102.f364984b == null) goto L17;
        L6:
            if (r102.f364983a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UpdateUserCreationMusic> serializer() {
            return a.f364985a;
        }
    }

    public static final class c implements Parcelable.Creator<UpdateUserCreationMusic> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UpdateUserCreationMusic createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new UpdateUserCreationMusic(r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final UpdateUserCreationMusic[] newArray(int r100) {
            return new UpdateUserCreationMusic[r100];
        }
    }

    public UpdateUserCreationMusic() {
        this(null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateUserCreationMusic) == true) goto L8;
        return false;
    L8:
        UpdateUserCreationMusic r101 = (UpdateUserCreationMusic) r100;
        if (Intrinsics.areEqual(this.f364983a, r101.f364983a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f364984b, r101.f364984b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f364983a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f364984b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UpdateUserCreationMusic(title=" + this.f364983a + ", coverUri=" + this.f364984b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f364983a);
        r100.writeString(this.f364984b);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public UpdateUserCreationMusic(String r100, String r101) {
        this.f364983a = r100;
        this.f364984b = r101;
    }

    public UpdateUserCreationMusic(int r100, String r101, String r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f364986b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f364983a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f364984b = null;
        return;
    L11:
        this.f364984b = r102;
        return;
    L7:
        this.f364983a = r101;
        goto L9
    }
}
