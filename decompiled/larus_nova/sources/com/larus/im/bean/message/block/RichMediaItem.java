package com.larus.im.bean.message.block;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.bean.message.CreationItem;
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
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.w0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 B2\u00060\u0001j\u0002`\u0002:\u0002ABBs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016Bu\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0015\u0010\u001aJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0014HÆ\u0003Jz\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0004HÖ\u0001J\t\u00107\u001a\u000208HÖ\u0001J%\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0002\b@R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u0012\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u001cR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001cR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001cR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001cR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001cR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001c¨\u0006C"}, d2 = {"Lcom/larus/im/bean/message/block/RichMediaItem;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "type", "", "image", "Lcom/larus/im/bean/message/block/SearchImageItem;", "video", "Lcom/larus/im/bean/message/block/SearchVideoItem;", "ruyi", "Lcom/larus/im/bean/message/block/SearchRuyiCardItem;", "applet", "Lcom/larus/im/bean/message/block/SearchAppletCardItem;", "ugcItem", "Lcom/larus/im/bean/message/block/UgcItem;", "creation", "Lcom/larus/im/bean/message/CreationItem;", "imageItem", "Lcom/larus/im/bean/message/block/GenericImageItem;", "videoItem", "Lcom/larus/im/bean/message/block/GenericVideoItem;", "<init>", "(Ljava/lang/Integer;Lcom/larus/im/bean/message/block/SearchImageItem;Lcom/larus/im/bean/message/block/SearchVideoItem;Lcom/larus/im/bean/message/block/SearchRuyiCardItem;Lcom/larus/im/bean/message/block/SearchAppletCardItem;Lcom/larus/im/bean/message/block/UgcItem;Lcom/larus/im/bean/message/CreationItem;Lcom/larus/im/bean/message/block/GenericImageItem;Lcom/larus/im/bean/message/block/GenericVideoItem;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Lcom/larus/im/bean/message/block/SearchImageItem;Lcom/larus/im/bean/message/block/SearchVideoItem;Lcom/larus/im/bean/message/block/SearchRuyiCardItem;Lcom/larus/im/bean/message/block/SearchAppletCardItem;Lcom/larus/im/bean/message/block/UgcItem;Lcom/larus/im/bean/message/CreationItem;Lcom/larus/im/bean/message/block/GenericImageItem;Lcom/larus/im/bean/message/block/GenericVideoItem;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType$annotations", "()V", "Ljava/lang/Integer;", "getImage$annotations", "getVideo$annotations", "getRuyi$annotations", "getApplet$annotations", "getUgcItem$annotations", "getCreation$annotations", "getImageItem$annotations", "getVideoItem$annotations", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Lcom/larus/im/bean/message/block/SearchImageItem;Lcom/larus/im/bean/message/block/SearchVideoItem;Lcom/larus/im/bean/message/block/SearchRuyiCardItem;Lcom/larus/im/bean/message/block/SearchAppletCardItem;Lcom/larus/im/bean/message/block/UgcItem;Lcom/larus/im/bean/message/CreationItem;Lcom/larus/im/bean/message/block/GenericImageItem;Lcom/larus/im/bean/message/block/GenericVideoItem;)Lcom/larus/im/bean/message/block/RichMediaItem;", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class RichMediaItem implements java.io.Serializable {
    public static final b Companion = null;
    public final SearchAppletCardItem applet;
    public final CreationItem creation;
    public final SearchImageItem image;
    public final GenericImageItem imageItem;
    public final SearchRuyiCardItem ruyi;
    public final Integer type;
    public final UgcItem ugcItem;
    public final SearchVideoItem video;
    public final GenericVideoItem videoItem;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<RichMediaItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f347035a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f347036b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f347036b;
        }

        static {
            a r100 = new a();
            f347035a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.RichMediaItem", r100, 9);
            r101.j("type", true);
            r101.j("image", true);
            r101.j("video", true);
            r101.j("ruyi", true);
            r101.j("applet", true);
            r101.j("ugc_item", true);
            r101.j("creation", true);
            r101.j("image_item", true);
            r101.j("video_item", true);
            f347036b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(w0.f520792a), kuc.a.d(SearchImageItem.a.f347046a), kuc.a.d(SearchVideoItem.a.f347067a), kuc.a.d(SearchRuyiCardItem.a.f347060a), kuc.a.d(SearchAppletCardItem.a.f347043a), kuc.a.d(UgcItem.a.f347084a), kuc.a.d(CreationItem.a.f346621a), kuc.a.d(GenericImageItem.a.f346877a), kuc.a.d(GenericVideoItem.a.f346882a)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f347036b;
            c r101 = r210.beginStructure(r100);
            int r102 = 8;
            int r103 = 5;
            SearchImageItem r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            Integer r104 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, null);
            SearchImageItem r105 = (SearchImageItem) r101.decodeNullableSerializableElement(r100, 1, SearchImageItem.a.f347046a, null);
            SearchVideoItem r106 = (SearchVideoItem) r101.decodeNullableSerializableElement(r100, 2, SearchVideoItem.a.f347067a, null);
            SearchRuyiCardItem r107 = (SearchRuyiCardItem) r101.decodeNullableSerializableElement(r100, 3, SearchRuyiCardItem.a.f347060a, null);
            SearchAppletCardItem r108 = (SearchAppletCardItem) r101.decodeNullableSerializableElement(r100, 4, SearchAppletCardItem.a.f347043a, null);
            UgcItem r109 = (UgcItem) r101.decodeNullableSerializableElement(r100, 5, UgcItem.a.f347084a, null);
            CreationItem r111 = (CreationItem) r101.decodeNullableSerializableElement(r100, 6, CreationItem.a.f346621a, null);
            GenericImageItem r112 = (GenericImageItem) r101.decodeNullableSerializableElement(r100, 7, GenericImageItem.a.f346877a, null);
            Integer r113 = r104;
            GenericVideoItem r114 = (GenericVideoItem) r101.decodeNullableSerializableElement(r100, 8, GenericVideoItem.a.f346882a, null);
            SearchRuyiCardItem r115 = r107;
            UgcItem r116 = r109;
            GenericImageItem r117 = r112;
            SearchVideoItem r118 = r106;
            SearchAppletCardItem r119 = r108;
            r110 = r105;
            CreationItem r120 = r111;
            int r121 = 511;
        L25:
            r101.endStructure(r100);
            return new RichMediaItem(r121, r113, r110, r118, r115, r119, r116, r120, r117, r114, null);
        L5:
            SearchAppletCardItem r122 = null;
            SearchRuyiCardItem r123 = null;
            GenericVideoItem r124 = null;
            SearchVideoItem r125 = null;
            UgcItem r126 = null;
            CreationItem r127 = null;
            GenericImageItem r128 = null;
            Integer r129 = null;
            int r130 = 0;
            boolean r211 = true;
        L6:
            if (r211 == false) goto L24;
            int r131 = r101.decodeElementIndex(r100);
            switch(r131) {
                case -1: goto L23;
                case 0: goto L21;
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r131);
        L23:
            r102 = 8;
            r103 = 5;
            r211 = false;
            goto L6
        L11:
            r124 = (GenericVideoItem) r101.decodeNullableSerializableElement(r100, r102, GenericVideoItem.a.f346882a, r124);
            r130 = r130 | 256;
        L22:
            r102 = 8;
            r103 = 5;
            goto L6
        L12:
            r128 = (GenericImageItem) r101.decodeNullableSerializableElement(r100, 7, GenericImageItem.a.f346877a, r128);
            r130 = r130 | 128;
            goto L22
        L13:
            r127 = (CreationItem) r101.decodeNullableSerializableElement(r100, 6, CreationItem.a.f346621a, r127);
            r130 = r130 | 64;
            goto L22
        L14:
            r126 = (UgcItem) r101.decodeNullableSerializableElement(r100, r103, UgcItem.a.f347084a, r126);
            r130 = r130 | 32;
            goto L22
        L15:
            r122 = (SearchAppletCardItem) r101.decodeNullableSerializableElement(r100, 4, SearchAppletCardItem.a.f347043a, r122);
            r130 = r130 | 16;
            goto L22
        L16:
            r123 = (SearchRuyiCardItem) r101.decodeNullableSerializableElement(r100, 3, SearchRuyiCardItem.a.f347060a, r123);
            r130 = r130 | 8;
            goto L22
        L17:
            r125 = (SearchVideoItem) r101.decodeNullableSerializableElement(r100, 2, SearchVideoItem.a.f347067a, r125);
            r130 = r130 | 4;
            goto L22
        L19:
            r110 = (SearchImageItem) r101.decodeNullableSerializableElement(r100, 1, SearchImageItem.a.f347046a, r110);
            r130 = r130 | 2;
            goto L22
        L21:
            r130 = r130 | 1;
            r129 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, r129);
            goto L22
        L24:
            r113 = r129;
            r114 = r124;
            r116 = r126;
            r120 = r127;
            r117 = r128;
            r119 = r122;
            r115 = r123;
            r118 = r125;
            r121 = r130;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            RichMediaItem r102 = (RichMediaItem) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f347036b;
            muc.d r104 = r100.beginStructure(r103);
            RichMediaItem.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<RichMediaItem> serializer() {
            return a.f347035a;
        }
    }

    public RichMediaItem() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ RichMediaItem copy$default(RichMediaItem r110, Integer r111, SearchImageItem r112, SearchVideoItem r113, SearchRuyiCardItem r114, SearchAppletCardItem r115, UgcItem r116, CreationItem r117, GenericImageItem r118, GenericVideoItem r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Integer r100 = r110.type;
    L7:
        if ((r210 & 2) == 0) goto L9;
        SearchImageItem r101 = r110.image;
    L11:
        if ((r210 & 4) == 0) goto L13;
        SearchVideoItem r102 = r110.video;
    L15:
        if ((r210 & 8) == 0) goto L17;
        SearchRuyiCardItem r103 = r110.ruyi;
    L19:
        if ((r210 & 16) == 0) goto L21;
        SearchAppletCardItem r104 = r110.applet;
    L23:
        if ((r210 & 32) == 0) goto L25;
        UgcItem r105 = r110.ugcItem;
    L27:
        if ((r210 & 64) == 0) goto L29;
        CreationItem r106 = r110.creation;
    L31:
        if ((r210 & 128) == 0) goto L33;
        GenericImageItem r107 = r110.imageItem;
    L35:
        if ((r210 & 256) == 0) goto L37;
        GenericVideoItem r108 = r110.videoItem;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @SerialName("applet")
    public static /* synthetic */ void getApplet$annotations() {
    }

    @SerialName("creation")
    public static /* synthetic */ void getCreation$annotations() {
    }

    @SerialName("image")
    public static /* synthetic */ void getImage$annotations() {
    }

    @SerialName("image_item")
    public static /* synthetic */ void getImageItem$annotations() {
    }

    @SerialName("ruyi")
    public static /* synthetic */ void getRuyi$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("ugc_item")
    public static /* synthetic */ void getUgcItem$annotations() {
    }

    @SerialName("video")
    public static /* synthetic */ void getVideo$annotations() {
    }

    @SerialName("video_item")
    public static /* synthetic */ void getVideoItem$annotations() {
    }

    public final Integer component1() {
        return this.type;
    }

    public final SearchImageItem component2() {
        return this.image;
    }

    public final SearchVideoItem component3() {
        return this.video;
    }

    public final SearchRuyiCardItem component4() {
        return this.ruyi;
    }

    public final SearchAppletCardItem component5() {
        return this.applet;
    }

    public final UgcItem component6() {
        return this.ugcItem;
    }

    public final CreationItem component7() {
        return this.creation;
    }

    public final GenericImageItem component8() {
        return this.imageItem;
    }

    public final GenericVideoItem component9() {
        return this.videoItem;
    }

    public final RichMediaItem copy(Integer r110, SearchImageItem r111, SearchVideoItem r112, SearchRuyiCardItem r113, SearchAppletCardItem r114, UgcItem r115, CreationItem r116, GenericImageItem r117, GenericVideoItem r210) {
        return new RichMediaItem(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RichMediaItem) == true) goto L8;
        return false;
    L8:
        RichMediaItem r101 = (RichMediaItem) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.ruyi, r101.ruyi) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.applet, r101.applet) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ugcItem, r101.ugcItem) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.creation, r101.creation) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.imageItem, r101.imageItem) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.videoItem, r101.videoItem) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        SearchImageItem r104 = this.image;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        SearchVideoItem r107 = this.video;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        SearchRuyiCardItem r110 = this.ruyi;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        SearchAppletCardItem r113 = this.applet;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        UgcItem r116 = this.ugcItem;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        CreationItem r119 = this.creation;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        GenericImageItem r122 = this.imageItem;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        GenericVideoItem r125 = this.videoItem;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
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
        return "RichMediaItem(type=" + this.type + ", image=" + this.image + ", video=" + this.video + ", ruyi=" + this.ruyi + ", applet=" + this.applet + ", ugcItem=" + this.ugcItem + ", creation=" + this.creation + ", imageItem=" + this.imageItem + ", videoItem=" + this.videoItem + ')';
    }

    static {
        Companion = new b();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(RichMediaItem r100, muc.d r101, f r102) {
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
        r101.encodeNullableSerializableElement(r102, 1, SearchImageItem.a.f347046a, r100.image);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, SearchVideoItem.a.f347067a, r100.video);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, SearchRuyiCardItem.a.f347060a, r100.ruyi);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, SearchAppletCardItem.a.f347043a, r100.applet);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, UgcItem.a.f347084a, r100.ugcItem);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r110 = true;
    L63:
        if (r110 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, CreationItem.a.f346621a, r100.creation);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r111 = true;
    L72:
        if (r111 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, GenericImageItem.a.f346877a, r100.imageItem);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        r103 = true;
    L80:
        if (r103 == false) goto L83;
        r101.encodeNullableSerializableElement(r102, 8, GenericVideoItem.a.f346882a, r100.videoItem);
        return;
    L83:
        return;
    L78:
        if (r100.videoItem == null) goto L80;
    L69:
        if (r100.imageItem != null) goto L67;
        r111 = false;
        goto L72
    L60:
        if (r100.creation != null) goto L58;
        r110 = false;
        goto L63
    L51:
        if (r100.ugcItem != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.applet != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.ruyi != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.video != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.image != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.type != null) goto L4;
        r104 = false;
        goto L9
    }

    public RichMediaItem(Integer r100, SearchImageItem r101, SearchVideoItem r102, SearchRuyiCardItem r103, SearchAppletCardItem r104, UgcItem r105, CreationItem r106, GenericImageItem r107, GenericVideoItem r108) {
        this.type = r100;
        this.image = r101;
        this.video = r102;
        this.ruyi = r103;
        this.applet = r104;
        this.ugcItem = r105;
        this.creation = r106;
        this.imageItem = r107;
        this.videoItem = r108;
    }

    public RichMediaItem(int r100, Integer r101, SearchImageItem r102, SearchVideoItem r103, SearchRuyiCardItem r104, SearchAppletCardItem r105, UgcItem r106, CreationItem r107, GenericImageItem r110, GenericVideoItem r111, q2 r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f347036b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.type = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.image = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.video = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.ruyi = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.applet = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.ugcItem = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.creation = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.imageItem = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.videoItem = null;
        return;
    L39:
        this.videoItem = r111;
        return;
    L35:
        this.imageItem = r110;
        goto L37
    L31:
        this.creation = r107;
        goto L33
    L27:
        this.ugcItem = r106;
        goto L29
    L23:
        this.applet = r105;
        goto L25
    L19:
        this.ruyi = r104;
        goto L21
    L15:
        this.video = r103;
        goto L17
    L11:
        this.image = r102;
        goto L13
    L7:
        this.type = r101;
        goto L9
    }

    public /* synthetic */ RichMediaItem(Integer r110, SearchImageItem r111, SearchVideoItem r112, SearchRuyiCardItem r113, SearchAppletCardItem r114, UgcItem r115, CreationItem r116, GenericImageItem r117, GenericVideoItem r118, int r210, DefaultConstructorMarker r211) {
        GenericVideoItem r100 = null;
        if ((r210 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        SearchImageItem r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        SearchVideoItem r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        SearchRuyiCardItem r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        SearchAppletCardItem r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        UgcItem r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        CreationItem r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        GenericImageItem r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
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
}
