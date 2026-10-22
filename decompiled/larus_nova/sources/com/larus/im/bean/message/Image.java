package com.larus.im.bean.message;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
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
import kotlinx.serialization.Transient;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.a1;
import nuc.b2;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import yc9.q;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 M2\u00060\u0001j\u0002`\u0002:\u0002MNB»\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016B\u009f\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0015\u0010\u001bJ\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0017\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010;\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010<\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÂ\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\u00112\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020\u0018HÖ\u0001J\t\u0010D\u001a\u00020\u0004HÖ\u0001J%\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\bLR\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001dR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u001dR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u001dR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b!\u0010\u001dR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u001dR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b#\u0010\u001dR&\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001dR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u001dR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b&\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\n\n\u0002\u0010(\u0012\u0004\b'\u0010\u001dR(\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010(\u0012\u0004\b)\u0010\u001d\u001a\u0004\b\u0012\u0010*\"\u0004\b+\u0010,R(\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010(\u0012\u0004\b-\u0010\u001d\u001a\u0004\b\u0013\u0010*\"\u0004\b.\u0010,R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0000\u0012\u0004\b/\u0010\u001d¨\u0006O"}, d2 = {"Lcom/larus/im/bean/message/Image;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "key", "", "md5", "imageThumb", "Lcom/larus/im/bean/message/ImageObj;", "imageOri", "resourceId", "localResPath", LocationMonitorConst.IDENTIFIER, "ext", "", "previewImage", "imageOriRaw", "aiCreationImage", "", "isMarked", "isCropped", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getKey$annotations", "()V", "getMd5$annotations", "getImageThumb$annotations", "getImageOri$annotations", "getResourceId$annotations", "getLocalResPath$annotations", "getIdentifier$annotations", "getExt$annotations", "getPreviewImage$annotations", "getImageOriRaw$annotations", "getAiCreationImage$annotations", "Ljava/lang/Boolean;", "isMarked$annotations", "()Ljava/lang/Boolean;", "setMarked", "(Ljava/lang/Boolean;)V", "isCropped$annotations", "setCropped", "getSource$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/larus/im/bean/message/ImageObj;Lcom/larus/im/bean/message/ImageObj;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/im/bean/message/Image;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "Companion", "$serializer", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class Image implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 1;
    public Boolean aiCreationImage;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    public Map<String, String> ext;
    public String identifier;
    public ImageObj imageOri;
    public ImageObj imageOriRaw;
    public ImageObj imageThumb;
    private Boolean isCropped;
    private Boolean isMarked;
    public String key;
    public String localResPath;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    public String f346641md5;
    public ImageObj previewImage;
    public String resourceId;
    public String source;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<Image> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346642a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346643b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346643b;
        }

        static {
            a r100 = new a();
            f346642a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.Image", r100, 12);
            r101.j("key", true);
            r101.j("md5", true);
            r101.j("image_thumb", true);
            r101.j("image_ori", true);
            r101.j("resource_id", true);
            r101.j("local_res_path", true);
            r101.j(LocationMonitorConst.IDENTIFIER, true);
            r101.j("metadata", true);
            r101.j("preview_img", true);
            r101.j("image_ori_raw", true);
            r101.j("ai_creation_image", true);
            r101.j("source", true);
            f346643b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = Image.access$get$childSerializers$cp();
            v2 r101 = v2.f520790a;
            ImageObj.a r102 = ImageObj.a.f346651a;
            return new d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d((d) r100[7].getValue()), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(i.f520705a), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f346643b;
            muc.c r101 = r310.beginStructure(r100);
            Lazy[] r102 = Image.access$get$childSerializers$cp();
            int r110 = 9;
            String r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 1, r104, null);
            ImageObj.a r105 = ImageObj.a.f346651a;
            ImageObj r113 = (ImageObj) r101.decodeNullableSerializableElement(r100, 2, r105, null);
            ImageObj r106 = (ImageObj) r101.decodeNullableSerializableElement(r100, 3, r105, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 5, r104, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 6, r104, null);
            Map r109 = (Map) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), null);
            ImageObj r115 = (ImageObj) r101.decodeNullableSerializableElement(r100, 8, r105, null);
            ImageObj r116 = (ImageObj) r101.decodeNullableSerializableElement(r100, 9, r105, null);
            Boolean r117 = (Boolean) r101.decodeNullableSerializableElement(r100, 10, i.f520705a, null);
            Map r210 = r109;
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 11, r104, null);
            ImageObj r212 = r116;
            ImageObj r213 = r115;
            ImageObj r118 = r106;
            String r214 = r107;
            String r215 = r108;
            Boolean r216 = r117;
            ImageObj r119 = r113;
            String r217 = r114;
            String r120 = r111;
            String r121 = r112;
            int r122 = UnixStat.PERM_MASK;
        L34:
            r101.endStructure(r100);
            return new Image(r122, r120, r121, r119, r118, r217, r214, r215, r210, r213, r212, r216, r211, null);
        L5:
            int r123 = 11;
            ImageObj r124 = null;
            Map r125 = null;
            Boolean r126 = null;
            ImageObj r127 = null;
            String r128 = null;
            ImageObj r129 = null;
            ImageObj r130 = null;
            String r131 = null;
            String r218 = null;
            String r219 = null;
            String r220 = null;
            int r132 = 0;
            boolean r221 = true;
        L6:
            if (r221 == false) goto L33;
            int r133 = r101.decodeElementIndex(r100);
            switch(r133) {
                case -1: goto L31;
                case 0: goto L29;
                case 1: goto L28;
                case 2: goto L26;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L15;
                case 9: goto L13;
                case 10: goto L12;
                case 11: goto L11;
                default: goto L10;
            };
        L11:
            r128 = (String) r101.decodeNullableSerializableElement(r100, r123, v2.f520790a, r128);
            r132 = r132 | 2048;
        L16:
            r102 = r102;
            r219 = r219;
        L21:
            r125 = r125;
            String r134 = r218;
        L27:
            String r135 = r134;
            r125 = r125;
            String r136 = r220;
        L32:
            r220 = r136;
            r219 = r219;
            r218 = r135;
            r102 = r102;
            r123 = 11;
            r110 = 9;
            goto L6
        L12:
            r126 = (Boolean) r101.decodeNullableSerializableElement(r100, 10, i.f520705a, r126);
            r132 = r132 | 1024;
            goto L16
        L13:
            r129 = (ImageObj) r101.decodeNullableSerializableElement(r100, r110, ImageObj.a.f346651a, r129);
            r132 = r132 | 512;
            goto L16
        L15:
            r127 = (ImageObj) r101.decodeNullableSerializableElement(r100, 8, ImageObj.a.f346651a, r127);
            r132 = r132 | 256;
            goto L16
        L17:
            r125 = (Map) r101.decodeNullableSerializableElement(r100, 7, (juc.c) r102[7].getValue(), r125);
            int r137 = r132 | 128;
        L19:
            r132 = r137;
            r219 = r219;
            goto L21
        L18:
            r219 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r219);
            r137 = r132 | 64;
            goto L19
        L20:
            r102 = r102;
            r219 = r219;
            r131 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r131);
            r132 = r132 | 32;
            goto L21
        L23:
            int r138 = r132 | 16;
            String r139 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r218);
        L25:
            r132 = r138;
            r134 = r139;
            goto L27
        L24:
            r124 = (ImageObj) r101.decodeNullableSerializableElement(r100, 3, ImageObj.a.f346651a, r124);
            r139 = r218;
            r138 = r132 | 8;
            goto L25
        L26:
            r102 = r102;
            r125 = r125;
            r134 = r218;
            r219 = r219;
            r130 = (ImageObj) r101.decodeNullableSerializableElement(r100, 2, ImageObj.a.f346651a, r130);
            r132 = r132 | 4;
            goto L27
        L28:
            r135 = r218;
            int r140 = r132 | 2;
            String r141 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r220);
        L30:
            r132 = r140;
            r136 = r141;
            r125 = r125;
            goto L32
        L29:
            r135 = r218;
            r141 = r220;
            r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r103);
            r140 = r132 | 1;
            goto L30
        L31:
            r102 = r102;
            r135 = r218;
            r219 = r219;
            r136 = r220;
            r125 = r125;
            r221 = false;
            goto L32
        L10:
            throw new UnknownFieldException(r133);
        L33:
            Map r222 = r125;
            String r142 = r218;
            String r143 = r219;
            String r144 = r220;
            r120 = r103;
            r118 = r124;
            r216 = r126;
            r213 = r127;
            r215 = r143;
            r211 = r128;
            r212 = r129;
            r119 = r130;
            r214 = r131;
            r210 = r222;
            r122 = r132;
            r217 = r142;
            r121 = r144;
            goto L34
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            Image r102 = (Image) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346643b;
            muc.d r104 = r100.beginStructure(r103);
            Image.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<Image> serializer() {
            return a.f346642a;
        }
    }

    public Image() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        v2 r100 = v2.f520790a;
        return new a1(r100, r100);
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Image copy$default(Image r110, String r111, String r112, ImageObj r113, ImageObj r114, String r210, String r211, String r212, Map r213, ImageObj r214, ImageObj r215, Boolean r216, Boolean r217, Boolean r218, String r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = r110.key;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r101 = r110.f346641md5;
    L11:
        if ((r310 & 4) == 0) goto L13;
        ImageObj r102 = r110.imageThumb;
    L15:
        if ((r310 & 8) == 0) goto L17;
        ImageObj r103 = r110.imageOri;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = r110.resourceId;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r105 = r110.localResPath;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r106 = r110.identifier;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Map r107 = r110.ext;
    L35:
        if ((r310 & 256) == 0) goto L37;
        ImageObj r115 = r110.previewImage;
    L39:
        if ((r310 & 512) == 0) goto L41;
        ImageObj r116 = r110.imageOriRaw;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Boolean r117 = r110.aiCreationImage;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Boolean r118 = r110.isMarked;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Boolean r119 = r110.isCropped;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        String r108 = r110.source;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    @SerialName("ai_creation_image")
    public static /* synthetic */ void getAiCreationImage$annotations() {
    }

    @SerialName("metadata")
    public static /* synthetic */ void getExt$annotations() {
    }

    @SerialName(LocationMonitorConst.IDENTIFIER)
    public static /* synthetic */ void getIdentifier$annotations() {
    }

    @SerialName("image_ori")
    public static /* synthetic */ void getImageOri$annotations() {
    }

    @SerialName("image_ori_raw")
    public static /* synthetic */ void getImageOriRaw$annotations() {
    }

    @SerialName("image_thumb")
    public static /* synthetic */ void getImageThumb$annotations() {
    }

    @SerialName("key")
    public static /* synthetic */ void getKey$annotations() {
    }

    @SerialName("local_res_path")
    public static /* synthetic */ void getLocalResPath$annotations() {
    }

    @SerialName("md5")
    public static /* synthetic */ void getMd5$annotations() {
    }

    @SerialName("preview_img")
    public static /* synthetic */ void getPreviewImage$annotations() {
    }

    @SerialName("resource_id")
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName("source")
    public static /* synthetic */ void getSource$annotations() {
    }

    @Transient
    public static /* synthetic */ void isCropped$annotations() {
    }

    @Transient
    public static /* synthetic */ void isMarked$annotations() {
    }

    public final String component1() {
        return this.key;
    }

    public final ImageObj component10() {
        return this.imageOriRaw;
    }

    public final Boolean component11() {
        return this.aiCreationImage;
    }

    public final Boolean component12() {
        return this.isMarked;
    }

    public final Boolean component13() {
        return this.isCropped;
    }

    public final String component14() {
        return this.source;
    }

    public final String component2() {
        return this.f346641md5;
    }

    public final ImageObj component3() {
        return this.imageThumb;
    }

    public final ImageObj component4() {
        return this.imageOri;
    }

    public final String component5() {
        return this.resourceId;
    }

    public final String component6() {
        return this.localResPath;
    }

    public final String component7() {
        return this.identifier;
    }

    public final Map<String, String> component8() {
        return this.ext;
    }

    public final ImageObj component9() {
        return this.previewImage;
    }

    public final Image copy(String r110, String r111, ImageObj r112, ImageObj r210, String r211, String r212, String r213, Map<String, String> r214, ImageObj r215, ImageObj r216, Boolean r217, Boolean r218, Boolean r219, String r310) {
        return new Image(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Image) == true) goto L8;
        return false;
    L8:
        Image r101 = (Image) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f346641md5, r101.f346641md5) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageThumb, r101.imageThumb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageOri, r101.imageOri) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.localResPath, r101.localResPath) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.identifier, r101.identifier) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.previewImage, r101.previewImage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.imageOriRaw, r101.imageOriRaw) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.aiCreationImage, r101.aiCreationImage) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.isMarked, r101.isMarked) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.isCropped, r101.isCropped) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f346641md5;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ImageObj r107 = this.imageThumb;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ImageObj r110 = this.imageOri;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.resourceId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.localResPath;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.identifier;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.ext;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        ImageObj r125 = this.previewImage;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        ImageObj r128 = this.imageOriRaw;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.aiCreationImage;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.isMarked;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.isCropped;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.source;
        if (r140 == null) goto L59;
        r101 = r140.hashCode();
    L59:
        return r139 + r101;
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
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
        return "Image(key=" + this.key + ", md5=" + this.f346641md5 + ", imageThumb=" + this.imageThumb + ", imageOri=" + this.imageOri + ", resourceId=" + this.resourceId + ", localResPath=" + this.localResPath + ", identifier=" + this.identifier + ", ext=" + this.ext + ", previewImage=" + this.previewImage + ", imageOriRaw=" + this.imageOriRaw + ", aiCreationImage=" + this.aiCreationImage + ", isMarked=" + this.isMarked + ", isCropped=" + this.isCropped + ", source=" + this.source + ')';
    }

    static {
        Companion = new b();
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new q()), null, null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public final Boolean isCropped() {
        return this.isCropped;
    }

    public final Boolean isMarked() {
        return this.isMarked;
    }

    public final void setCropped(Boolean r100) {
        this.isCropped = r100;
    }

    public final void setMarked(Boolean r100) {
        this.isMarked = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(Image r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = $childSerializers;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.key);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.f346641md5);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, ImageObj.a.f346651a, r100.imageThumb);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, ImageObj.a.f346651a, r100.imageOri);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.resourceId);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, v2.f520790a, r100.localResPath);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        boolean r111 = true;
    L63:
        if (r111 == false) goto L66;
        r101.encodeNullableSerializableElement(r102, 6, v2.f520790a, r100.identifier);
    L66:
        if (r101.shouldEncodeElementDefault(r102, 7) == false) goto L69;
    L67:
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r101.encodeNullableSerializableElement(r102, 7, r103[7].getValue(), r100.ext);
    L75:
        if (r101.shouldEncodeElementDefault(r102, 8) == false) goto L78;
    L76:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r101.encodeNullableSerializableElement(r102, 8, ImageObj.a.f346651a, r100.previewImage);
    L84:
        if (r101.shouldEncodeElementDefault(r102, 9) == false) goto L87;
    L85:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r101.encodeNullableSerializableElement(r102, 9, ImageObj.a.f346651a, r100.imageOriRaw);
    L93:
        if (r101.shouldEncodeElementDefault(r102, 10) == false) goto L96;
    L94:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r101.encodeNullableSerializableElement(r102, 10, i.f520705a, r100.aiCreationImage);
    L102:
        if (r101.shouldEncodeElementDefault(r102, 11) == false) goto L105;
    L103:
        r104 = true;
    L107:
        if (r104 == false) goto L110;
        r101.encodeNullableSerializableElement(r102, 11, v2.f520790a, r100.source);
        return;
    L110:
        return;
    L105:
        if (r100.source == null) goto L107;
    L96:
        if (r100.aiCreationImage != null) goto L94;
        r115 = false;
        goto L99
    L87:
        if (r100.imageOriRaw != null) goto L85;
        r114 = false;
        goto L90
    L78:
        if (r100.previewImage != null) goto L76;
        r113 = false;
        goto L81
    L69:
        if (r100.ext != null) goto L67;
        r112 = false;
        goto L72
    L60:
        if (r100.identifier != null) goto L58;
        r111 = false;
        goto L63
    L51:
        if (r100.localResPath != null) goto L49;
        r110 = false;
        goto L54
    L42:
        if (r100.resourceId != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.imageOri != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.imageThumb != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.f346641md5 != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.key != null) goto L4;
        r105 = false;
        goto L9
    }

    public Image(int r100, String r101, String r102, ImageObj r103, ImageObj r104, String r105, String r106, String r107, Map r110, ImageObj r111, ImageObj r112, Boolean r113, String r114, q2 r115) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346643b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.key = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f346641md5 = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.imageThumb = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.imageOri = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.resourceId = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.localResPath = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.identifier = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.ext = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.previewImage = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.imageOriRaw = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.aiCreationImage = null;
    L48:
        this.isMarked = null;
        this.isCropped = null;
        if ((r100 & 2048) != 0) goto L51;
        this.source = null;
        return;
    L51:
        this.source = r114;
        return;
    L47:
        this.aiCreationImage = r113;
        goto L48
    L43:
        this.imageOriRaw = r112;
        goto L45
    L39:
        this.previewImage = r111;
        goto L41
    L35:
        this.ext = r110;
        goto L37
    L31:
        this.identifier = r107;
        goto L33
    L27:
        this.localResPath = r106;
        goto L29
    L23:
        this.resourceId = r105;
        goto L25
    L19:
        this.imageOri = r104;
        goto L21
    L15:
        this.imageThumb = r103;
        goto L17
    L11:
        this.f346641md5 = r102;
        goto L13
    L7:
        this.key = r101;
        goto L9
    }

    public Image(String r100, String r101, ImageObj r102, ImageObj r103, String r104, String r105, String r106, Map<String, String> r107, ImageObj r108, ImageObj r110, Boolean r111, Boolean r112, Boolean r113, String r114) {
        this.key = r100;
        this.f346641md5 = r101;
        this.imageThumb = r102;
        this.imageOri = r103;
        this.resourceId = r104;
        this.localResPath = r105;
        this.identifier = r106;
        this.ext = r107;
        this.previewImage = r108;
        this.imageOriRaw = r110;
        this.aiCreationImage = r111;
        this.isMarked = r112;
        this.isCropped = r113;
        this.source = r114;
    }

    public /* synthetic */ Image(String r110, String r111, ImageObj r112, ImageObj r113, String r210, String r211, String r212, Map r213, ImageObj r214, ImageObj r215, Boolean r216, Boolean r217, Boolean r218, String r219, int r310, DefaultConstructorMarker r311) {
        String r100 = null;
        if ((r310 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        ImageObj r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        ImageObj r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        Map r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        ImageObj r114 = null;
    L39:
        if ((r310 & 512) == 0) goto L41;
        ImageObj r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Boolean r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        Boolean r117 = null;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        Boolean r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
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
