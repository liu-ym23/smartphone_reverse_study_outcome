package com.bytedance.flow.search.kmp.api.spi;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
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
import nuc.w0;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 G2\u00060\u0001j\u0002`\u0002:\u0002FGB\u0081\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0012\u0010\u0017J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\u0083\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\bHÆ\u0001J\u0006\u00103\u001a\u00020\bJ\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\bHÖ\u0001J\t\u00109\u001a\u00020\u0004HÖ\u0001J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\bJ%\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001dR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001d¨\u0006H"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/spi/SearchDriveItem;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "fileName", "", "fileToken", "driveToken", "driveObjType", "", "fileURL", "openTime", "", "editTime", "iconInfo", "fileTypeValue", "isOwner", "extra", "iconResId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFileName", "()Ljava/lang/String;", "getFileToken", "getDriveToken", "getDriveObjType", "()I", "getFileURL", "getOpenTime", "()J", "getEditTime", "getIconInfo", "getFileTypeValue", "getExtra", "getIconResId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$aggregate_search_kmp_api_release", "$serializer", "Companion", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SearchDriveItem implements Parcelable {
    public static final Parcelable.Creator<SearchDriveItem> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f243533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f243534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f243535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f243536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f243537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f243538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f243539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f243540i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f243541j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f243542k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f243543l;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<SearchDriveItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f243544a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f243545b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f243545b;
        }

        static {
            a r100 = new a();
            f243544a = r100;
            g2 r101 = new g2("com.bytedance.flow.search.kmp.api.spi.SearchDriveItem", r100, 12);
            r101.j("fileName", true);
            r101.j("fileToken", true);
            r101.j("driveToken", true);
            r101.j("driveObjType", true);
            r101.j("fileURL", true);
            r101.j("openTime", true);
            r101.j("editTime", true);
            r101.j("iconInfo", true);
            r101.j("fileTypeValue", true);
            r101.j("isOwner", true);
            r101.j("extra", true);
            r101.j("iconResId", true);
            f243545b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            g1 r102 = g1.f520681a;
            return new d[]{r100, r100, r100, r101, r100, r102, r102, r100, r100, r101, kuc.a.d(r100), r101};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f243545b;
            muc.c r101 = r310.beginStructure(r100);
            int r102 = 4;
            int r103 = 0;
            if (r101.decodeSequentially() == false) goto L5;
            String r104 = r101.decodeStringElement(r100, 0);
            String r105 = r101.decodeStringElement(r100, 1);
            String r106 = r101.decodeStringElement(r100, 2);
            int r107 = r101.decodeIntElement(r100, 3);
            String r108 = r101.decodeStringElement(r100, 4);
            long r110 = r101.decodeLongElement(r100, 5);
            long r111 = r101.decodeLongElement(r100, 6);
            String r112 = r101.decodeStringElement(r100, 7);
            String r109 = r101.decodeStringElement(r100, 8);
            int r113 = r101.decodeIntElement(r100, 9);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, null);
            String r115 = r109;
            int r210 = r101.decodeIntElement(r100, 11);
            int r116 = r107;
            String r211 = r114;
            int r212 = r113;
            String r117 = r112;
            long r118 = r110;
            r103 = UnixStat.PERM_MASK;
            String r119 = r104;
            String r120 = r108;
            String r121 = r106;
            String r122 = r105;
        L28:
            r101.endStructure(r100);
            return new SearchDriveItem(r103, r119, r122, r121, r116, r120, r118, r111, r117, r115, r212, r211, r210);
        L5:
            String r123 = null;
            String r213 = null;
            String r214 = null;
            String r215 = null;
            String r216 = null;
            String r217 = null;
            String r218 = null;
            long r219 = 0;
            int r124 = 0;
            int r125 = 0;
            boolean r220 = true;
            long r126 = 0;
            int r127 = 0;
        L6:
            if (r220 == false) goto L27;
            int r128 = r101.decodeElementIndex(r100);
            switch(r128) {
                case -1: goto L26;
                case 0: goto L24;
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r128);
        L22:
            r217 = r101.decodeStringElement(r100, 2);
            r103 = r103 | 4;
            goto L6
        L23:
            r103 = r103 | 2;
            r216 = r101.decodeStringElement(r100, 1);
        L25:
            r102 = 4;
            goto L6
        L24:
            r103 = r103 | 1;
            r214 = r101.decodeStringElement(r100, 0);
            goto L25
        L26:
            r102 = 4;
            r220 = false;
            goto L6
        L11:
            r124 = r101.decodeIntElement(r100, 11);
            int r129 = r103 | 2048;
        L20:
            r103 = r129;
            goto L6
        L12:
            r103 = r103 | 1024;
            r123 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r123);
            goto L6
        L13:
            r127 = r101.decodeIntElement(r100, 9);
            r129 = r103 | 512;
            goto L20
        L14:
            r103 = r103 | 256;
            r218 = r101.decodeStringElement(r100, 8);
            goto L6
        L15:
            r103 = r103 | 128;
            r213 = r101.decodeStringElement(r100, 7);
            goto L6
        L16:
            r219 = r101.decodeLongElement(r100, 6);
            r129 = r103 | 64;
            goto L20
        L17:
            r126 = r101.decodeLongElement(r100, 5);
            r129 = r103 | 32;
            goto L20
        L18:
            r103 = r103 | 16;
            r215 = r101.decodeStringElement(r100, r102);
            goto L6
        L19:
            r125 = r101.decodeIntElement(r100, 3);
            r129 = r103 | 8;
            goto L20
        L27:
            r116 = r125;
            r118 = r126;
            r117 = r213;
            r119 = r214;
            r120 = r215;
            r122 = r216;
            r121 = r217;
            r115 = r218;
            r210 = r124;
            r211 = r123;
            r212 = r127;
            r111 = r219;
            goto L28
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            SearchDriveItem r112 = (SearchDriveItem) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f243545b;
            muc.d r113 = r110.beginStructure(r100);
            b r101 = SearchDriveItem.Companion;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeStringElement(r100, 0, r112.f243532a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeStringElement(r100, 1, r112.f243533b);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeStringElement(r100, 2, r112.f243534c);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeIntElement(r100, 3, r112.f243535d);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
        L43:
            boolean r107 = true;
        L45:
            if (r107 == false) goto L48;
            r113.encodeStringElement(r100, 4, r112.f243536e);
        L48:
            if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
        L52:
            boolean r108 = true;
        L54:
            if (r108 == false) goto L57;
            r113.encodeLongElement(r100, 5, r112.f243537f);
        L57:
            if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
        L61:
            boolean r109 = true;
        L63:
            if (r109 == false) goto L66;
            r113.encodeLongElement(r100, 6, r112.f243538g);
        L66:
            if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r113.encodeStringElement(r100, 7, r112.f243539h);
        L75:
            if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r113.encodeStringElement(r100, 8, r112.f243540i);
        L84:
            if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
        L88:
            boolean r116 = true;
        L90:
            if (r116 == false) goto L93;
            r113.encodeIntElement(r100, 9, r112.f243541j);
        L93:
            if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L96;
        L97:
            boolean r117 = true;
        L99:
            if (r117 == false) goto L102;
            r113.encodeNullableSerializableElement(r100, 10, v2.f520790a, r112.f243542k);
        L102:
            if (r113.shouldEncodeElementDefault(r100, 11) == false) goto L105;
        L106:
            r102 = true;
        L107:
            if (r102 == false) goto L109;
            r113.encodeIntElement(r100, 11, r112.f243543l);
        L109:
            r113.endStructure(r100);
            return;
        L105:
            if (r112.f243543l == 0) goto L107;
        L96:
            if (r112.f243542k != null) goto L97;
            r117 = false;
            goto L99
        L87:
            if (r112.f243541j != 1) goto L88;
            r116 = false;
            goto L90
        L78:
            if (Intrinsics.areEqual(r112.f243540i, "others") == false) goto L79;
            r115 = false;
            goto L81
        L69:
            if (Intrinsics.areEqual(r112.f243539h, "") == false) goto L70;
            r114 = false;
            goto L72
        L60:
            if (r112.f243538g != 0) goto L61;
            r109 = false;
            goto L63
        L51:
            if (r112.f243537f != 0) goto L52;
            r108 = false;
            goto L54
        L42:
            if (Intrinsics.areEqual(r112.f243536e, "") == false) goto L43;
            r107 = false;
            goto L45
        L33:
            if (r112.f243535d != 0) goto L34;
            r106 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r112.f243534c, "") == false) goto L25;
            r105 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r112.f243533b, "") == false) goto L16;
            r104 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r112.f243532a, "") == false) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<SearchDriveItem> serializer() {
            return a.f243544a;
        }
    }

    public static final class c implements Parcelable.Creator<SearchDriveItem> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchDriveItem createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new SearchDriveItem(r110.readString(), r110.readString(), r110.readString(), r110.readInt(), r110.readString(), r110.readLong(), r110.readLong(), r110.readString(), r110.readString(), r110.readInt(), r110.readString(), r110.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final SearchDriveItem[] newArray(int r100) {
            return new SearchDriveItem[r100];
        }
    }

    public SearchDriveItem() {
        this(null, null, 0, null, null, null, 0, UnixStat.PERM_MASK);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchDriveItem) == true) goto L8;
        return false;
    L8:
        SearchDriveItem r101 = (SearchDriveItem) r100;
        if (Intrinsics.areEqual(this.f243532a, r101.f243532a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243533b, r101.f243533b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f243534c, r101.f243534c) == true) goto L18;
        return false;
    L18:
        if (this.f243535d == r101.f243535d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f243536e, r101.f243536e) == true) goto L24;
        return false;
    L24:
        if (this.f243537f == r101.f243537f) goto L27;
        return false;
    L27:
        if (this.f243538g == r101.f243538g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f243539h, r101.f243539h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f243540i, r101.f243540i) == true) goto L36;
        return false;
    L36:
        if (this.f243541j == r101.f243541j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f243542k, r101.f243542k) == true) goto L42;
        return false;
    L42:
        if (this.f243543l == r101.f243543l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f243532a.hashCode() * 31) + this.f243533b.hashCode()) * 31) + this.f243534c.hashCode()) * 31) + this.f243535d) * 31) + this.f243536e.hashCode()) * 31;
        long r101 = this.f243537f;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f243538g;
        int r104 = (((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f243539h.hashCode()) * 31) + this.f243540i.hashCode()) * 31) + this.f243541j) * 31;
        String r105 = this.f243542k;
        if (r105 != null) goto L5;
        int r106 = 0;
    L7:
        return ((r104 + r106) * 31) + this.f243543l;
    L5:
        r106 = r105.hashCode();
        goto L7
    }

    public final String toString() {
        return "SearchDriveItem(fileName=" + this.f243532a + ", fileToken=" + this.f243533b + ", driveToken=" + this.f243534c + ", driveObjType=" + this.f243535d + ", fileURL=" + this.f243536e + ", openTime=" + this.f243537f + ", editTime=" + this.f243538g + ", iconInfo=" + this.f243539h + ", fileTypeValue=" + this.f243540i + ", isOwner=" + this.f243541j + ", extra=" + this.f243542k + ", iconResId=" + this.f243543l + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f243532a);
        r100.writeString(this.f243533b);
        r100.writeString(this.f243534c);
        r100.writeInt(this.f243535d);
        r100.writeString(this.f243536e);
        r100.writeLong(this.f243537f);
        r100.writeLong(this.f243538g);
        r100.writeString(this.f243539h);
        r100.writeString(this.f243540i);
        r100.writeInt(this.f243541j);
        r100.writeString(this.f243542k);
        r100.writeInt(this.f243543l);
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public /* synthetic */ SearchDriveItem(String r110, String r210, int r211, String r212, String r213, String r214, int r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r216 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r216 & 128) == 0) goto L25;
        String r111 = "";
    L27:
        if ((r216 & 256) == 0) goto L29;
        String r112 = "others";
    L31:
        if ((r216 & 512) == 0) goto L33;
        int r113 = 1;
    L35:
        if ((r216 & 2048) == 0) goto L37;
        int r114 = 0;
    L38:
        this(r100, r101, r102, r103, r104, 0, 0, r111, r112, r113, null, r114);
        return;
    L37:
        r114 = r215;
        goto L38
    L33:
        r113 = 0;
        goto L35
    L29:
        r112 = r214;
        goto L31
    L25:
        r111 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public SearchDriveItem(String r100, String r101, String r102, int r103, String r104, long r105, long r106, String r110, String r111, int r112, String r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "fileToken");
        Intrinsics.checkNotNullParameter(r102, "driveToken");
        Intrinsics.checkNotNullParameter(r104, "fileURL");
        Intrinsics.checkNotNullParameter(r110, "iconInfo");
        Intrinsics.checkNotNullParameter(r111, "fileTypeValue");
        this.f243532a = r100;
        this.f243533b = r101;
        this.f243534c = r102;
        this.f243535d = r103;
        this.f243536e = r104;
        this.f243537f = r105;
        this.f243538g = r106;
        this.f243539h = r110;
        this.f243540i = r111;
        this.f243541j = r112;
        this.f243542k = r113;
        this.f243543l = r114;
    }

    public SearchDriveItem(int r110, String r111, String r112, String r113, int r114, String r115, long r116, long r117, String r210, String r211, int r212, String r213, int r214) {
        if ((r110 & 0) == 0) goto L5;
        b2.b(r110, 0, a.f243545b);
        throw null;
    L5:
        if ((r110 & 1) != 0) goto L7;
        this.f243532a = "";
    L9:
        if ((r110 & 2) != 0) goto L11;
        this.f243533b = "";
    L13:
        if ((r110 & 4) != 0) goto L15;
        this.f243534c = "";
    L17:
        if ((r110 & 8) != 0) goto L19;
        this.f243535d = 0;
    L21:
        if ((r110 & 16) != 0) goto L23;
        this.f243536e = "";
    L24:
        long r100 = 0;
        if ((r110 & 32) != 0) goto L27;
        this.f243537f = 0;
    L29:
        if ((r110 & 64) == 0) goto L32;
        r100 = r117;
    L32:
        this.f243538g = r100;
        if ((r110 & 128) != 0) goto L35;
        this.f243539h = "";
    L37:
        if ((r110 & 256) != 0) goto L39;
        String r101 = "others";
    L40:
        this.f243540i = r101;
        if ((r110 & 512) != 0) goto L43;
        int r102 = 1;
    L44:
        this.f243541j = r102;
        if ((r110 & 1024) != 0) goto L47;
        this.f243542k = null;
    L49:
        if ((r110 & 2048) != 0) goto L51;
        this.f243543l = 0;
        return;
    L51:
        this.f243543l = r214;
        return;
    L47:
        this.f243542k = r213;
        goto L49
    L43:
        r102 = r212;
        goto L44
    L39:
        r101 = r211;
        goto L40
    L35:
        this.f243539h = r210;
        goto L37
    L27:
        this.f243537f = r116;
        goto L29
    L23:
        this.f243536e = r115;
        goto L24
    L19:
        this.f243535d = r114;
        goto L21
    L15:
        this.f243534c = r113;
        goto L17
    L11:
        this.f243533b = r112;
        goto L13
    L7:
        this.f243532a = r111;
        goto L9
    }
}
