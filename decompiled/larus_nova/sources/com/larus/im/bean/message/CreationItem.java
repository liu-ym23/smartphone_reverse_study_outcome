package com.larus.im.bean.message;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0002=>Bg\u0012\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014Bk\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0012HÆ\u0003Jn\u0010.\u001a\u00020\u00002\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0004HÖ\u0001J\t\u00104\u001a\u00020\u0006HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u0012\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001d\u0010\u001aR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u0012\u0004\b\u001e\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001a¨\u0006?"}, d2 = {"Lcom/larus/im/bean/message/CreationItem;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "type", "", "id", "", "genDetail", "Lcom/larus/im/bean/message/CreationGenDetail;", "canPublish", "", "image", "Lcom/larus/im/bean/message/ImageData;", "video", "Lcom/larus/im/bean/message/VideoData;", "localImage", "Lcom/larus/im/bean/message/LocalImageData;", "localVideo", "Lcom/larus/im/bean/message/LocalVideoData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/im/bean/message/CreationGenDetail;Ljava/lang/Boolean;Lcom/larus/im/bean/message/ImageData;Lcom/larus/im/bean/message/VideoData;Lcom/larus/im/bean/message/LocalImageData;Lcom/larus/im/bean/message/LocalVideoData;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Lcom/larus/im/bean/message/CreationGenDetail;Ljava/lang/Boolean;Lcom/larus/im/bean/message/ImageData;Lcom/larus/im/bean/message/VideoData;Lcom/larus/im/bean/message/LocalImageData;Lcom/larus/im/bean/message/LocalVideoData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType$annotations", "()V", "Ljava/lang/Integer;", "getId$annotations", "getGenDetail$annotations", "getCanPublish$annotations", "Ljava/lang/Boolean;", "getImage$annotations", "getVideo$annotations", "getLocalImage$annotations", "getLocalVideo$annotations", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "()Ljava/lang/Boolean;", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/im/bean/message/CreationGenDetail;Ljava/lang/Boolean;Lcom/larus/im/bean/message/ImageData;Lcom/larus/im/bean/message/VideoData;Lcom/larus/im/bean/message/LocalImageData;Lcom/larus/im/bean/message/LocalVideoData;)Lcom/larus/im/bean/message/CreationItem;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CreationItem implements java.io.Serializable {
    public static final b Companion = null;
    public final Boolean canPublish;
    public final CreationGenDetail genDetail;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f346620id;
    public final ImageData image;
    public final LocalImageData localImage;
    public final LocalVideoData localVideo;
    public final Integer type;
    public final VideoData video;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346621a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346622b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346622b;
        }

        static {
            a r100 = new a();
            f346621a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.CreationItem", r100, 8);
            r101.j("type", true);
            r101.j("id", true);
            r101.j("gen_detail", true);
            r101.j("can_publish", true);
            r101.j("image", true);
            r101.j("video", true);
            r101.j("local_image", true);
            r101.j("local_video", true);
            f346622b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(w0.f520792a), kuc.a.d(v2.f520790a), kuc.a.d(CreationGenDetail.a.f346618a), kuc.a.d(i.f520705a), kuc.a.d(ImageData.a.f346647a), kuc.a.d(VideoData.a.f346758a), kuc.a.d(LocalImageData.a.f346661a), kuc.a.d(LocalVideoData.a.f346667a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346622b;
            muc.c r101 = r210.beginStructure(r100);
            int r102 = 4;
            String r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            Integer r103 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            CreationGenDetail r105 = (CreationGenDetail) r101.decodeNullableSerializableElement(r100, 2, CreationGenDetail.a.f346618a, null);
            Boolean r106 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, i.f520705a, null);
            ImageData r107 = (ImageData) r101.decodeNullableSerializableElement(r100, 4, ImageData.a.f346647a, null);
            VideoData r108 = (VideoData) r101.decodeNullableSerializableElement(r100, 5, VideoData.a.f346758a, null);
            LocalImageData r109 = (LocalImageData) r101.decodeNullableSerializableElement(r100, 6, LocalImageData.a.f346661a, null);
            ImageData r111 = r107;
            Boolean r112 = r106;
            LocalVideoData r113 = (LocalVideoData) r101.decodeNullableSerializableElement(r100, 7, LocalVideoData.a.f346667a, null);
            VideoData r114 = r108;
            LocalImageData r115 = r109;
            CreationGenDetail r116 = r105;
            String r117 = r104;
            int r118 = 255;
            Integer r119 = r103;
        L24:
            r101.endStructure(r100);
            return new CreationItem(r118, r119, r117, r116, r112, r111, r114, r115, r113, null);
        L5:
            Boolean r120 = null;
            LocalImageData r121 = null;
            ImageData r122 = null;
            LocalVideoData r123 = null;
            Integer r124 = null;
            CreationGenDetail r125 = null;
            VideoData r126 = null;
            int r127 = 0;
            boolean r128 = true;
        L6:
            if (r128 == false) goto L23;
            int r129 = r101.decodeElementIndex(r100);
            switch(r129) {
                case -1: goto L22;
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r129);
        L22:
            r102 = 4;
            r128 = false;
            goto L6
        L11:
            r123 = (LocalVideoData) r101.decodeNullableSerializableElement(r100, 7, LocalVideoData.a.f346667a, r123);
            r127 = r127 | 128;
        L21:
            r102 = 4;
            goto L6
        L12:
            r121 = (LocalImageData) r101.decodeNullableSerializableElement(r100, 6, LocalImageData.a.f346661a, r121);
            r127 = r127 | 64;
            goto L21
        L13:
            r126 = (VideoData) r101.decodeNullableSerializableElement(r100, 5, VideoData.a.f346758a, r126);
            r127 = r127 | 32;
            goto L21
        L14:
            r122 = (ImageData) r101.decodeNullableSerializableElement(r100, r102, ImageData.a.f346647a, r122);
            r127 = r127 | 16;
            goto L21
        L15:
            r120 = (Boolean) r101.decodeNullableSerializableElement(r100, 3, i.f520705a, r120);
            r127 = r127 | 8;
            goto L21
        L16:
            r125 = (CreationGenDetail) r101.decodeNullableSerializableElement(r100, 2, CreationGenDetail.a.f346618a, r125);
            r127 = r127 | 4;
            goto L21
        L18:
            r110 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r110);
            r127 = r127 | 2;
            goto L21
        L20:
            r127 = r127 | 1;
            r124 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, r124);
            goto L21
        L23:
            r112 = r120;
            r116 = r125;
            r118 = r127;
            r113 = r123;
            r114 = r126;
            Integer r130 = r124;
            r115 = r121;
            r119 = r130;
            String r131 = r110;
            r111 = r122;
            r117 = r131;
            goto L24
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            CreationItem r102 = (CreationItem) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346622b;
            muc.d r104 = r100.beginStructure(r103);
            CreationItem.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationItem> serializer() {
            return a.f346621a;
        }
    }

    public CreationItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ CreationItem copy$default(CreationItem r100, Integer r110, String r111, CreationGenDetail r112, Boolean r113, ImageData r114, VideoData r115, LocalImageData r116, LocalVideoData r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = r100.type;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.f346620id;
    L11:
        if ((r118 & 4) == 0) goto L13;
        CreationGenDetail r103 = r100.genDetail;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = r100.canPublish;
    L19:
        if ((r118 & 16) == 0) goto L21;
        ImageData r105 = r100.image;
    L23:
        if ((r118 & 32) == 0) goto L25;
        VideoData r106 = r100.video;
    L27:
        if ((r118 & 64) == 0) goto L29;
        LocalImageData r107 = r100.localImage;
    L31:
        if ((r118 & 128) == 0) goto L33;
        LocalVideoData r108 = r100.localVideo;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    @SerialName("can_publish")
    public static /* synthetic */ void getCanPublish$annotations() {
    }

    @SerialName("gen_detail")
    public static /* synthetic */ void getGenDetail$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("image")
    public static /* synthetic */ void getImage$annotations() {
    }

    @SerialName("local_image")
    public static /* synthetic */ void getLocalImage$annotations() {
    }

    @SerialName("local_video")
    public static /* synthetic */ void getLocalVideo$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("video")
    public static /* synthetic */ void getVideo$annotations() {
    }

    public final Integer component1() {
        return this.type;
    }

    public final String component2() {
        return this.f346620id;
    }

    public final CreationGenDetail component3() {
        return this.genDetail;
    }

    public final Boolean component4() {
        return this.canPublish;
    }

    public final ImageData component5() {
        return this.image;
    }

    public final VideoData component6() {
        return this.video;
    }

    public final LocalImageData component7() {
        return this.localImage;
    }

    public final LocalVideoData component8() {
        return this.localVideo;
    }

    public final CreationItem copy(@CreationType Integer r110, String r111, CreationGenDetail r112, Boolean r113, ImageData r114, VideoData r115, LocalImageData r116, LocalVideoData r117) {
        return new CreationItem(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationItem) == true) goto L8;
        return false;
    L8:
        CreationItem r101 = (CreationItem) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f346620id, r101.f346620id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.genDetail, r101.genDetail) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.canPublish, r101.canPublish) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.localImage, r101.localImage) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.localVideo, r101.localVideo) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f346620id;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CreationGenDetail r107 = this.genDetail;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.canPublish;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ImageData r113 = this.image;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        VideoData r116 = this.video;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        LocalImageData r119 = this.localImage;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        LocalVideoData r122 = this.localVideo;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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

    public String toString() {
        return "CreationItem(type=" + this.type + ", id=" + this.f346620id + ", genDetail=" + this.genDetail + ", canPublish=" + this.canPublish + ", image=" + this.image + ", video=" + this.video + ", localImage=" + this.localImage + ", localVideo=" + this.localVideo + ')';
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(CreationItem r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, w0.f520792a, r100.type);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.f346620id);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, CreationGenDetail.a.f346618a, r100.genDetail);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, i.f520705a, r100.canPublish);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, ImageData.a.f346647a, r100.image);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, VideoData.a.f346758a, r100.video);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, LocalImageData.a.f346661a, r100.localImage);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        r103 = true;
    L71:
        if (r103 == false) goto L74;
        r101.encodeNullableSerializableElement(r102, 7, LocalVideoData.a.f346667a, r100.localVideo);
        return;
    L74:
        return;
    L69:
        if (r100.localVideo == null) goto L71;
    L60:
        if (r100.localImage != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.video != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.image != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.canPublish != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.genDetail != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.f346620id != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.type != null) goto L4;
        r104 = false;
        goto L9
    }

    public CreationItem(@CreationType Integer r100, String r101, CreationGenDetail r102, Boolean r103, ImageData r104, VideoData r105, LocalImageData r106, LocalVideoData r107) {
        this.type = r100;
        this.f346620id = r101;
        this.genDetail = r102;
        this.canPublish = r103;
        this.image = r104;
        this.video = r105;
        this.localImage = r106;
        this.localVideo = r107;
    }

    public CreationItem(int r100, Integer r101, String r102, CreationGenDetail r103, Boolean r104, ImageData r105, VideoData r106, LocalImageData r107, LocalVideoData r110, q2 r111) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346622b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.type = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f346620id = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.genDetail = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.canPublish = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.image = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.video = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.localImage = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.localVideo = null;
        return;
    L35:
        this.localVideo = r110;
        return;
    L31:
        this.localImage = r107;
        goto L33
    L27:
        this.video = r106;
        goto L29
    L23:
        this.image = r105;
        goto L25
    L19:
        this.canPublish = r104;
        goto L21
    L15:
        this.genDetail = r103;
        goto L17
    L11:
        this.f346620id = r102;
        goto L13
    L7:
        this.type = r101;
        goto L9
    }

    public /* synthetic */ CreationItem(Integer r110, String r111, CreationGenDetail r112, Boolean r113, ImageData r114, VideoData r115, LocalImageData r116, LocalVideoData r117, int r118, DefaultConstructorMarker r119) {
        LocalVideoData r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        CreationGenDetail r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        ImageData r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        VideoData r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        LocalImageData r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
