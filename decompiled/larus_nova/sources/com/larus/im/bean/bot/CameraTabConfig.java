package com.larus.im.bean.bot;

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
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import uc9.u;
import uc9.v;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00060\u0001j\u0002`\u0002:\u0002:;B]\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eBe\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0013\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003Jd\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0004HÖ\u0001J\t\u00101\u001a\u00020\tHÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u001dR \u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u0016R$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u001a¨\u0006<"}, d2 = {"Lcom/larus/im/bean/bot/CameraTabConfig;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "defaultLandingTab", "", "cameraTabList", "", "Lcom/larus/im/bean/bot/CameraTabItem;", "cameraNameUrl", "", "cameraName", "tipsShowOrder", "tips", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDefaultLandingTab$annotations", "()V", "getDefaultLandingTab", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCameraTabList$annotations", "getCameraTabList", "()Ljava/util/List;", "getCameraNameUrl$annotations", "getCameraNameUrl", "()Ljava/lang/String;", "getCameraName$annotations", "getCameraName", "getTipsShowOrder$annotations", "getTipsShowOrder", "getTips$annotations", "getTips", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/larus/im/bean/bot/CameraTabConfig;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CameraTabConfig implements java.io.Serializable {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f346457a = null;
    private final String cameraName;
    private final String cameraNameUrl;
    private final List<CameraTabItem> cameraTabList;
    private final Integer defaultLandingTab;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> tips;
    private final Integer tipsShowOrder;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CameraTabConfig> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346458a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346459b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346459b;
        }

        static {
            a r100 = new a();
            f346458a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.CameraTabConfig", r100, 6);
            r101.j("default_landing_tab", true);
            r101.j("camera_tab_list", true);
            r101.j("camera_name_url", true);
            r101.j("camera_name", true);
            r101.j("tips_show_order", true);
            r101.j("tips", true);
            f346459b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            Lazy[] r100 = CameraTabConfig.access$get$childSerializers$cp();
            w0 r101 = w0.f520792a;
            v2 r102 = v2.f520790a;
            return new d[]{kuc.a.d(r101), kuc.a.d((d) r100[1].getValue()), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d((d) r100[5].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346459b;
            c r101 = r210.beginStructure(r100);
            Lazy[] r102 = CameraTabConfig.access$get$childSerializers$cp();
            int r103 = 2;
            List r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            w0 r104 = w0.f520792a;
            Integer r105 = (Integer) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            List r106 = (List) r101.decodeNullableSerializableElement(r100, 1, (juc.c) r102[1].getValue(), null);
            v2 r111 = v2.f520790a;
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r111, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 3, r111, null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r104, null);
            List r112 = (List) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), null);
            Integer r113 = r109;
            String r114 = r107;
            String r115 = r108;
            List r116 = r106;
            Integer r117 = r105;
            int r118 = 63;
        L21:
            r101.endStructure(r100);
            return new CameraTabConfig(r118, r117, r116, r114, r115, r113, r112, null);
        L5:
            r117 = null;
            String r119 = null;
            r114 = null;
            List r120 = null;
            r113 = null;
            int r121 = 0;
            boolean r122 = true;
        L6:
            if (r122 == false) goto L20;
            int r123 = r101.decodeElementIndex(r100);
            switch(r123) {
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
            throw new UnknownFieldException(r123);
        L19:
            r103 = 2;
            r122 = false;
            goto L6
        L11:
            r110 = (List) r101.decodeNullableSerializableElement(r100, 5, (juc.c) r102[5].getValue(), r110);
            r121 = r121 | 32;
        L18:
            r103 = 2;
            goto L6
        L12:
            r113 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r113);
            r121 = r121 | 16;
            goto L18
        L13:
            r119 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r119);
            r121 = r121 | 8;
            goto L18
        L14:
            r114 = (String) r101.decodeNullableSerializableElement(r100, r103, v2.f520790a, r114);
            r121 = r121 | 4;
            goto L18
        L15:
            r120 = (List) r101.decodeNullableSerializableElement(r100, 1, (juc.c) r102[1].getValue(), r120);
            r121 = r121 | 2;
            goto L18
        L17:
            r121 = r121 | 1;
            r117 = (Integer) r101.decodeNullableSerializableElement(r100, 0, w0.f520792a, r117);
            goto L18
        L20:
            r112 = r110;
            r118 = r121;
            List r124 = r120;
            r115 = r119;
            r116 = r124;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            CameraTabConfig r102 = (CameraTabConfig) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346459b;
            muc.d r104 = r100.beginStructure(r103);
            CameraTabConfig.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CameraTabConfig> serializer() {
            return a.f346458a;
        }
    }

    public CameraTabConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraTabConfig copy$default(CameraTabConfig r100, Integer r101, List r102, String r103, String r104, Integer r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.defaultLandingTab;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.cameraTabList;
    L8:
        List r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.cameraNameUrl;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.cameraName;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.tipsShowOrder;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.tips;
    L20:
        Integer r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    @SerialName("camera_name")
    public static /* synthetic */ void getCameraName$annotations() {
    }

    @SerialName("camera_name_url")
    public static /* synthetic */ void getCameraNameUrl$annotations() {
    }

    @SerialName("camera_tab_list")
    public static /* synthetic */ void getCameraTabList$annotations() {
    }

    @SerialName("default_landing_tab")
    public static /* synthetic */ void getDefaultLandingTab$annotations() {
    }

    @SerialName("tips")
    public static /* synthetic */ void getTips$annotations() {
    }

    @SerialName("tips_show_order")
    public static /* synthetic */ void getTipsShowOrder$annotations() {
    }

    public final Integer component1() {
        return this.defaultLandingTab;
    }

    public final List<CameraTabItem> component2() {
        return this.cameraTabList;
    }

    public final String component3() {
        return this.cameraNameUrl;
    }

    public final String component4() {
        return this.cameraName;
    }

    public final Integer component5() {
        return this.tipsShowOrder;
    }

    public final List<String> component6() {
        return this.tips;
    }

    public final CameraTabConfig copy(Integer r100, List<CameraTabItem> r110, String r111, String r112, Integer r113, List<String> r114) {
        return new CameraTabConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraTabConfig) == true) goto L8;
        return false;
    L8:
        CameraTabConfig r101 = (CameraTabConfig) r100;
        if (Intrinsics.areEqual(this.defaultLandingTab, r101.defaultLandingTab) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cameraTabList, r101.cameraTabList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cameraNameUrl, r101.cameraNameUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cameraName, r101.cameraName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tipsShowOrder, r101.tipsShowOrder) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tips, r101.tips) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.defaultLandingTab;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<CameraTabItem> r104 = this.cameraTabList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.cameraNameUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.cameraName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.tipsShowOrder;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.tips;
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

    public String toString() {
        return "CameraTabConfig(defaultLandingTab=" + this.defaultLandingTab + ", cameraTabList=" + this.cameraTabList + ", cameraNameUrl=" + this.cameraNameUrl + ", cameraName=" + this.cameraName + ", tipsShowOrder=" + this.tipsShowOrder + ", tips=" + this.tips + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f346457a = new Lazy[]{null, LazyKt.lazy(r100, new u()), null, null, null, LazyKt.lazy(r100, new v())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return f346457a;
    }

    public final String getCameraName() {
        return this.cameraName;
    }

    public final String getCameraNameUrl() {
        return this.cameraNameUrl;
    }

    public final List<CameraTabItem> getCameraTabList() {
        return this.cameraTabList;
    }

    public final Integer getDefaultLandingTab() {
        return this.defaultLandingTab;
    }

    public final List<String> getTips() {
        return this.tips;
    }

    public final Integer getTipsShowOrder() {
        return this.tipsShowOrder;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(CameraTabConfig r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = f346457a;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, w0.f520792a, r100.defaultLandingTab);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, r103[1].getValue(), r100.cameraTabList);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.cameraNameUrl);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.cameraName);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r109 = true;
    L45:
        if (r109 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.tipsShowOrder);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        r104 = true;
    L53:
        if (r104 == false) goto L56;
        r101.encodeNullableSerializableElement(r102, 5, r103[5].getValue(), r100.tips);
        return;
    L56:
        return;
    L51:
        if (r100.tips == null) goto L53;
    L42:
        if (r100.tipsShowOrder != null) goto L40;
        r109 = false;
        goto L45
    L33:
        if (r100.cameraName != null) goto L31;
        r108 = false;
        goto L36
    L24:
        if (r100.cameraNameUrl != null) goto L22;
        r107 = false;
        goto L27
    L15:
        if (r100.cameraTabList != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.defaultLandingTab != null) goto L4;
        r105 = false;
        goto L9
    }

    public CameraTabConfig(Integer r100, List<CameraTabItem> r101, String r102, String r103, Integer r104, List<String> r105) {
        this.defaultLandingTab = r100;
        this.cameraTabList = r101;
        this.cameraNameUrl = r102;
        this.cameraName = r103;
        this.tipsShowOrder = r104;
        this.tips = r105;
    }

    public CameraTabConfig(int r100, Integer r101, List r102, String r103, String r104, Integer r105, List r106, q2 r107) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346459b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.defaultLandingTab = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.cameraTabList = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.cameraNameUrl = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.cameraName = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.tipsShowOrder = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.tips = null;
        return;
    L27:
        this.tips = r106;
        return;
    L23:
        this.tipsShowOrder = r105;
        goto L25
    L19:
        this.cameraName = r104;
        goto L21
    L15:
        this.cameraNameUrl = r103;
        goto L17
    L11:
        this.cameraTabList = r102;
        goto L13
    L7:
        this.defaultLandingTab = r101;
        goto L9
    }

    public /* synthetic */ CameraTabConfig(Integer r100, List r101, String r102, String r103, Integer r110, List r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Integer r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        List r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        List r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
