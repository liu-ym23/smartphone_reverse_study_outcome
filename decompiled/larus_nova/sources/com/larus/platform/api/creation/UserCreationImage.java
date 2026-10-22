package com.larus.platform.api.creation;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.ImageInfo;
import com.ss.android.cert.manager.constants.EventConstant;
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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0002=>BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rBW\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003JQ\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0006\u0010*\u001a\u00020\u000fJ\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u000fHÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000fJ%\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u001eR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u001e¨\u0006?"}, d2 = {"Lcom/larus/platform/api/creation/UserCreationImage;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/Parcelable;", "imageInfo", "Lcom/larus/platform/api/ImageInfo;", "displayContent", "", EventConstant.Key.RETAIN_PROMPT, MapBundleKey.OfflineMapKey.OFFLINE_RATION, "Lcom/larus/platform/api/creation/OptionItem;", "styles", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "<init>", "(Lcom/larus/platform/api/ImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/OptionItem;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/platform/api/ImageInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/OptionItem;Lcom/larus/platform/api/creation/OptionItem;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageInfo$annotations", "()V", "getImageInfo", "()Lcom/larus/platform/api/ImageInfo;", "getDisplayContent$annotations", "getDisplayContent", "()Ljava/lang/String;", "getPrompt$annotations", "getPrompt", "getRatio$annotations", "getRatio", "()Lcom/larus/platform/api/creation/OptionItem;", "getStyles$annotations", "getStyles", "getModel$annotations", "getModel", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$platform_kmp_release", "$serializer", "Companion", "platform_kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class UserCreationImage implements Parcelable {
    public static final Parcelable.Creator<UserCreationImage> CREATOR = null;
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageInfo f365014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OptionItem f365017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OptionItem f365018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OptionItem f365019f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<UserCreationImage> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f365020a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f365021b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            OptionItem.a r101 = OptionItem.a.f364944a;
            return new d[]{kuc.a.d(ImageInfo.a.f364808a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f365021b;
        }

        static {
            a r100 = new a();
            f365020a = r100;
            g2 r101 = new g2("com.larus.platform.api.creation.UserCreationImage", r100, 6);
            r101.j("image_info", true);
            r101.j("display_content", true);
            r101.j(EventConstant.Key.RETAIN_PROMPT, true);
            r101.j(MapBundleKey.OfflineMapKey.OFFLINE_RATION, true);
            r101.j("style", true);
            r101.j(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, true);
            f365021b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f365021b;
            muc.c r101 = r110.beginStructure(r100);
            int r102 = 2;
            OptionItem r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            ImageInfo r104 = (ImageInfo) r101.decodeNullableSerializableElement(r100, 0, ImageInfo.a.f364808a, null);
            v2 r105 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            OptionItem.a r108 = OptionItem.a.f364944a;
            OptionItem r109 = (OptionItem) r101.decodeNullableSerializableElement(r100, 3, r108, null);
            ImageInfo r111 = r104;
            String r112 = r107;
            OptionItem r113 = (OptionItem) r101.decodeNullableSerializableElement(r100, 4, r108, null);
            OptionItem r114 = (OptionItem) r101.decodeNullableSerializableElement(r100, 5, r108, null);
            String r115 = r106;
            OptionItem r116 = r109;
            int r117 = 63;
        L21:
            r101.endStructure(r100);
            return new UserCreationImage(r117, r111, r115, r112, r116, r113, r114);
        L5:
            r111 = null;
            OptionItem r118 = null;
            r112 = null;
            String r119 = null;
            r113 = null;
            int r120 = 0;
            boolean r121 = true;
        L6:
            if (r121 == false) goto L20;
            int r122 = r101.decodeElementIndex(r100);
            switch(r122) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r122);
        L19:
            r102 = 2;
            r121 = false;
            goto L6
        L11:
            r103 = (OptionItem) r101.decodeNullableSerializableElement(r100, 5, OptionItem.a.f364944a, r103);
            r120 = r120 | 32;
        L18:
            r102 = 2;
            goto L6
        L12:
            r113 = (OptionItem) r101.decodeNullableSerializableElement(r100, 4, OptionItem.a.f364944a, r113);
            r120 = r120 | 16;
            goto L18
        L13:
            r118 = (OptionItem) r101.decodeNullableSerializableElement(r100, 3, OptionItem.a.f364944a, r118);
            r120 = r120 | 8;
            goto L18
        L14:
            r112 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r112);
            r120 = r120 | 4;
            goto L18
        L15:
            r119 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r119);
            r120 = r120 | 2;
            goto L18
        L17:
            r120 = r120 | 1;
            r111 = (ImageInfo) r101.decodeNullableSerializableElement(r100, 0, ImageInfo.a.f364808a, r111);
            goto L18
        L20:
            r114 = r103;
            r117 = r120;
            String r123 = r119;
            r116 = r118;
            r115 = r123;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            UserCreationImage r102 = (UserCreationImage) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f365021b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = UserCreationImage.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, ImageInfo.a.f364808a, r102.f365014a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f365015b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f365016c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 3, OptionItem.a.f364944a, r102.f365017d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, OptionItem.a.f364944a, r102.f365018e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            r106 = true;
        L53:
            if (r106 == false) goto L55;
            r104.encodeNullableSerializableElement(r103, 5, OptionItem.a.f364944a, r102.f365019f);
        L55:
            r104.endStructure(r103);
            return;
        L51:
            if (r102.f365019f == null) goto L53;
        L42:
            if (r102.f365018e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f365017d != null) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f365016c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f365015b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f365014a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<UserCreationImage> serializer() {
            return a.f365020a;
        }
    }

    public static final class c implements Parcelable.Creator<UserCreationImage> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationImage createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            OptionItem r101 = null;
            if (r100.readInt() != 0) goto L5;
            ImageInfo r102 = null;
        L6:
            ImageInfo r103 = r102;
            String r104 = r100.readString();
            String r105 = r100.readString();
            if (r100.readInt() != 0) goto L9;
            OptionItem r106 = null;
        L10:
            OptionItem r107 = r106;
            if (r100.readInt() != 0) goto L13;
            OptionItem r108 = null;
        L14:
            OptionItem r109 = r108;
            if (r100.readInt() == 0) goto L19;
            r101 = OptionItem.CREATOR.createFromParcel(r100);
        L19:
            return new UserCreationImage(r103, r104, r105, r107, r109, r101);
        L13:
            r108 = OptionItem.CREATOR.createFromParcel(r100);
            goto L14
        L9:
            r106 = OptionItem.CREATOR.createFromParcel(r100);
            goto L10
        L5:
            r102 = ImageInfo.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationImage[] newArray(int r100) {
            return new UserCreationImage[r100];
        }
    }

    public UserCreationImage() {
        this(null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserCreationImage) == true) goto L8;
        return false;
    L8:
        UserCreationImage r101 = (UserCreationImage) r100;
        if (Intrinsics.areEqual(this.f365014a, r101.f365014a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365015b, r101.f365015b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365016c, r101.f365016c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365017d, r101.f365017d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365018e, r101.f365018e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365019f, r101.f365019f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        ImageInfo r100 = this.f365014a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f365015b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f365016c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        OptionItem r110 = this.f365017d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        OptionItem r113 = this.f365018e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        OptionItem r116 = this.f365019f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserCreationImage(imageInfo=" + this.f365014a + ", displayContent=" + this.f365015b + ", prompt=" + this.f365016c + ", ratio=" + this.f365017d + ", styles=" + this.f365018e + ", model=" + this.f365019f + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        ImageInfo r102 = this.f365014a;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.f365015b);
        r100.writeString(this.f365016c);
        OptionItem r103 = this.f365017d;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        OptionItem r104 = this.f365018e;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        OptionItem r105 = this.f365019f;
        if (r105 != null) goto L17;
        r100.writeInt(0);
        return;
    L17:
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        return;
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L14
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public static UserCreationImage a(UserCreationImage r100, ImageInfo r101) {
        return new UserCreationImage(r101, r100.f365015b, r100.f365016c, r100.f365017d, r100.f365018e, r100.f365019f);
    }

    public UserCreationImage(ImageInfo r100, String r101, String r102, OptionItem r103, OptionItem r104, OptionItem r105) {
        this.f365014a = r100;
        this.f365015b = r101;
        this.f365016c = r102;
        this.f365017d = r103;
        this.f365018e = r104;
        this.f365019f = r105;
    }

    public UserCreationImage(int r100, ImageInfo r101, String r102, String r103, OptionItem r104, OptionItem r105, OptionItem r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f365021b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f365014a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f365015b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f365016c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f365017d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f365018e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f365019f = null;
        return;
    L27:
        this.f365019f = r106;
        return;
    L23:
        this.f365018e = r105;
        goto L25
    L19:
        this.f365017d = r104;
        goto L21
    L15:
        this.f365016c = r103;
        goto L17
    L11:
        this.f365015b = r102;
        goto L13
    L7:
        this.f365014a = r101;
        goto L9
    }
}
