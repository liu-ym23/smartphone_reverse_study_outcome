package com.larus.platform.kmp.chat;

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
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00060\u0001j\u0002`\u0002:\u000245B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J)\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0006\u0010!\u001a\u00020\u000bJ\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000bJ%\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u00066"}, d2 = {"Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateImage;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "url", "", "width", "", "height", "<init>", "(Ljava/lang/String;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl$annotations", "()V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getWidth$annotations", "getWidth", "()J", "setWidth", "(J)V", "getHeight$annotations", "getHeight", "setHeight", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class TemplateInfo$TemplateImage implements Parcelable {
    public static final Parcelable.Creator<TemplateInfo$TemplateImage> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f365411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f365412c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TemplateInfo$TemplateImage> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f365413a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f365414b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            g1 r100 = g1.f520681a;
            return new d[]{kuc.a.d(v2.f520790a), r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f365414b;
        }

        static {
            a r100 = new a();
            f365413a = r100;
            g2 r101 = new g2("com.larus.platform.kmp.chat.TemplateInfo.TemplateImage", r100, 3);
            r101.j("url", true);
            r101.j("width", true);
            r101.j("height", true);
            f365414b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f365414b;
            muc.c r101 = r210.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            String r110 = r103;
            long r111 = r101.decodeLongElement(r100, 1);
            long r112 = r101.decodeLongElement(r100, 2);
            int r113 = 7;
        L19:
            r101.endStructure(r100);
            return new TemplateInfo$TemplateImage(r113, r110, r111, r112);
        L5:
            long r104 = 0;
            long r105 = 0;
            int r106 = 0;
            boolean r114 = true;
        L6:
            if (r114 == false) goto L18;
            int r115 = r101.decodeElementIndex(r100);
            if (r115 != (-1)) goto L9;
            r114 = false;
            goto L6
        L9:
            if (r115 != 0) goto L10;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
            r106 = r106 | 1;
            goto L6
        L10:
            if (r115 != 1) goto L11;
            r104 = r101.decodeLongElement(r100, 1);
            r106 = r106 | 2;
            goto L6
        L11:
            if (r115 != 2) goto L14;
            r105 = r101.decodeLongElement(r100, 2);
            r106 = r106 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r115);
        L18:
            r113 = r106;
            r110 = r102;
            r111 = r104;
            r112 = r105;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            TemplateInfo$TemplateImage r112 = (TemplateInfo$TemplateImage) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f365414b;
            muc.d r113 = r110.beginStructure(r100);
            b r101 = TemplateInfo$TemplateImage.Companion;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeNullableSerializableElement(r100, 0, v2.f520790a, r112.f365410a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeLongElement(r100, 1, r112.f365411b);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            r102 = true;
        L26:
            if (r102 == false) goto L28;
            r113.encodeLongElement(r100, 2, r112.f365412c);
        L28:
            r113.endStructure(r100);
            return;
        L24:
            if (r112.f365412c == 0) goto L26;
        L15:
            if (r112.f365411b != 0) goto L16;
            r104 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r112.f365410a, "") == false) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<TemplateInfo$TemplateImage> serializer() {
            return a.f365413a;
        }
    }

    public static final class c implements Parcelable.Creator<TemplateInfo$TemplateImage> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateImage createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new TemplateInfo$TemplateImage(r100.readString(), r100.readLong(), r100.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final TemplateInfo$TemplateImage[] newArray(int r100) {
            return new TemplateInfo$TemplateImage[r100];
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
        if ((r100 instanceof TemplateInfo$TemplateImage) == true) goto L8;
        return false;
    L8:
        TemplateInfo$TemplateImage r101 = (TemplateInfo$TemplateImage) r100;
        if (Intrinsics.areEqual(this.f365410a, r101.f365410a) == true) goto L12;
        return false;
    L12:
        if (this.f365411b == r101.f365411b) goto L15;
        return false;
    L15:
        if (this.f365412c == r101.f365412c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f365410a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.f365411b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f365412c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateImage(url=" + this.f365410a + ", width=" + this.f365411b + ", height=" + this.f365412c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f365410a);
        r100.writeLong(this.f365411b);
        r100.writeLong(this.f365412c);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public TemplateInfo$TemplateImage() {
        this("", 0, 0);
    }

    public TemplateInfo$TemplateImage(String r100, long r101, long r102) {
        this.f365410a = r100;
        this.f365411b = r101;
        this.f365412c = r102;
    }

    public TemplateInfo$TemplateImage(int r100, String r101, long r102, long r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f365414b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = "";
    L7:
        this.f365410a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f365411b = 0;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f365412c = 0;
        return;
    L14:
        this.f365412c = r103;
        return;
    L10:
        this.f365411b = r102;
        goto L12
    }
}
