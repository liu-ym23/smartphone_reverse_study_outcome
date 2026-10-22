package com.larus.im.bean.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import yc9.r;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00060\u0001j\u0002`\u0002:\u0002#$B%\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R \u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010¨\u0006%"}, d2 = {"Lcom/larus/im/bean/message/ImageContent;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "imageList", "", "Lcom/larus/im/bean/message/Image;", "src", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getImageList$annotations", "()V", "getSrc$annotations", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "Companion", "$serializer", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ImageContent implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    public static final String IMG_MSG_SRC_TEXT_2_IMG = "text-to-image";
    public static final String IMG_MSG_SRC_USER_SENT = "user-sent";
    private static final long serialVersionUID = 1;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public List<Image> imageList;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    public String f346644src;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ImageContent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346645a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346646b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346646b;
        }

        static {
            a r100 = new a();
            f346645a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.ImageContent", r100, 2);
            r101.j("image_list", true);
            r101.j("src", true);
            f346646b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d((d) ImageContent.access$get$childSerializers$cp()[0].getValue()), kuc.a.d(v2.f520790a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346646b;
            muc.c r111 = r110.beginStructure(r100);
            Lazy[] r101 = ImageContent.access$get$childSerializers$cp();
            if (r111.decodeSequentially() == false) goto L5;
            List r102 = (List) r111.decodeNullableSerializableElement(r100, 0, (juc.c) r101[0].getValue(), null);
            String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            int r104 = 3;
        L17:
            r111.endStructure(r100);
            return new ImageContent(r104, r102, r103, null);
        L5:
            List r105 = null;
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
            r105 = (List) r111.decodeNullableSerializableElement(r100, 0, (juc.c) r101[0].getValue(), r105);
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
            r102 = r105;
            r103 = r106;
            r104 = r107;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ImageContent r102 = (ImageContent) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346646b;
            muc.d r104 = r100.beginStructure(r103);
            ImageContent.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ImageContent> serializer() {
            return a.f346645a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageContent() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return new nuc.f(Image.a.f346642a);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageContent copy$default(ImageContent r100, List r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.imageList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f346644src;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("image_list")
    public static /* synthetic */ void getImageList$annotations() {
    }

    @SerialName("src")
    public static /* synthetic */ void getSrc$annotations() {
    }

    public final List<Image> component1() {
        return this.imageList;
    }

    public final String component2() {
        return this.f346644src;
    }

    public final ImageContent copy(List<Image> r100, String r101) {
        return new ImageContent(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageContent) == true) goto L8;
        return false;
    L8:
        ImageContent r101 = (ImageContent) r100;
        if (Intrinsics.areEqual(this.imageList, r101.imageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f346644src, r101.f346644src) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<Image> r100 = this.imageList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f346644src;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ImageContent(imageList=" + this.imageList + ", src=" + this.f346644src + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new r()), null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public ImageContent(List<Image> r100, String r101) {
        this.imageList = r100;
        this.f346644src = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(ImageContent r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, r103[0].getValue(), r100.imageList);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        r104 = true;
    L17:
        if (r104 == false) goto L20;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.f346644src);
        return;
    L20:
        return;
    L15:
        if (Intrinsics.areEqual(r100.f346644src, IMG_MSG_SRC_USER_SENT) == true) goto L17;
    L6:
        if (r100.imageList != null) goto L4;
        r105 = false;
        goto L9
    }

    public ImageContent(int r100, List r101, String r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346646b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.imageList = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f346644src = IMG_MSG_SRC_USER_SENT;
        return;
    L11:
        this.f346644src = r102;
        return;
    L7:
        this.imageList = r101;
        goto L9
    }

    public /* synthetic */ ImageContent(List r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = IMG_MSG_SRC_USER_SENT;
    L8:
        this(r100, r101);
    }
}
