package com.larus.im.bean.message.block;

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
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00060\u0001j\u0002`\u0002:\u0002:;B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rBa\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJb\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u0004HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001bR \u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u001bR \u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u001bR \u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001c\u0012\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u001b¨\u0006<"}, d2 = {"Lcom/larus/im/bean/message/block/ResearchProcessBlock;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "title", "", "subtitle", "resourceId", "startTimestamp", "", "estimatedDuration", "status", "style", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle$annotations", "()V", "getSubtitle$annotations", "getSubtitle", "()Ljava/lang/String;", "getResourceId$annotations", "getResourceId", "getStartTimestamp$annotations", "getStartTimestamp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEstimatedDuration$annotations", "getEstimatedDuration", "getStatus$annotations", "getStatus", "getStyle$annotations", "getStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/im/bean/message/block/ResearchProcessBlock;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ResearchProcessBlock implements java.io.Serializable {
    public static final b Companion = null;
    private final Integer estimatedDuration;
    private final String resourceId;
    private final Integer startTimestamp;
    private final Integer status;
    private final Integer style;
    private final String subtitle;
    public final String title;

    /* JADX INFO: loaded from: classes4.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ResearchProcessBlock> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f347029a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f347030b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f347030b;
        }

        static {
            a r100 = new a();
            f347029a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.ResearchProcessBlock", r100, 7);
            r101.j("title", true);
            r101.j(BdpAppEventConstant.PARAMS_SUB_TITLE, true);
            r101.j("resource_id", true);
            r101.j("start_timestamp", true);
            r101.j("estimated_duration", true);
            r101.j("status", true);
            r101.j("style", true);
            f347030b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f347030b;
            c r101 = r110.beginStructure(r100);
            int r102 = 2;
            String r111 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            w0 r107 = w0.f520792a;
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 3, r107, null);
            Integer r109 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r107, null);
            Integer r112 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r107, null);
            String r113 = r106;
            Integer r114 = (Integer) r101.decodeNullableSerializableElement(r100, 6, r107, null);
            Integer r115 = r109;
            r111 = r104;
            String r116 = r105;
            Integer r117 = r112;
            Integer r118 = r108;
            int r119 = 127;
        L23:
            r101.endStructure(r100);
            return new ResearchProcessBlock(r119, r111, r116, r113, r118, r115, r117, r114, null);
        L5:
            Integer r120 = null;
            r116 = null;
            Integer r121 = null;
            String r122 = null;
            Integer r123 = null;
            Integer r124 = null;
            int r125 = 0;
            boolean r126 = true;
        L6:
            if (r126 == false) goto L22;
            int r127 = r101.decodeElementIndex(r100);
            switch(r127) {
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r127);
        L21:
            r102 = 2;
            r126 = false;
            goto L6
        L11:
            r121 = (Integer) r101.decodeNullableSerializableElement(r100, 6, w0.f520792a, r121);
            r125 = r125 | 64;
        L20:
            r102 = 2;
            goto L6
        L12:
            r123 = (Integer) r101.decodeNullableSerializableElement(r100, 5, w0.f520792a, r123);
            r125 = r125 | 32;
            goto L20
        L13:
            r120 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r120);
            r125 = r125 | 16;
            goto L20
        L14:
            r124 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r124);
            r125 = r125 | 8;
            goto L20
        L15:
            r122 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r122);
            r125 = r125 | 4;
            goto L20
        L17:
            r116 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r116);
            r125 = r125 | 2;
            goto L20
        L19:
            r125 = r125 | 1;
            r111 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r111);
            goto L20
        L22:
            r119 = r125;
            r114 = r121;
            r113 = r122;
            r118 = r124;
            r117 = r123;
            r115 = r120;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ResearchProcessBlock r102 = (ResearchProcessBlock) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f347030b;
            muc.d r104 = r100.beginStructure(r103);
            ResearchProcessBlock.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ResearchProcessBlock> serializer() {
            return a.f347029a;
        }
    }

    public ResearchProcessBlock() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ResearchProcessBlock copy$default(ResearchProcessBlock r100, String r101, String r102, String r103, Integer r104, Integer r110, Integer r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.subtitle;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.resourceId;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.startTimestamp;
    L14:
        Integer r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.estimatedDuration;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.status;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.style;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    @SerialName("estimated_duration")
    public static /* synthetic */ void getEstimatedDuration$annotations() {
    }

    @SerialName("resource_id")
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName("start_timestamp")
    public static /* synthetic */ void getStartTimestamp$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("style")
    public static /* synthetic */ void getStyle$annotations() {
    }

    @SerialName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    public static /* synthetic */ void getSubtitle$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subtitle;
    }

    public final String component3() {
        return this.resourceId;
    }

    public final Integer component4() {
        return this.startTimestamp;
    }

    public final Integer component5() {
        return this.estimatedDuration;
    }

    public final Integer component6() {
        return this.status;
    }

    public final Integer component7() {
        return this.style;
    }

    public final ResearchProcessBlock copy(String r110, String r111, String r112, Integer r113, Integer r114, Integer r115, Integer r116) {
        return new ResearchProcessBlock(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResearchProcessBlock) == true) goto L8;
        return false;
    L8:
        ResearchProcessBlock r101 = (ResearchProcessBlock) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.startTimestamp, r101.startTimestamp) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.estimatedDuration, r101.estimatedDuration) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.subtitle;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.resourceId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.startTimestamp;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.estimatedDuration;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.status;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.style;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "ResearchProcessBlock(title=" + this.title + ", subtitle=" + this.subtitle + ", resourceId=" + this.resourceId + ", startTimestamp=" + this.startTimestamp + ", estimatedDuration=" + this.estimatedDuration + ", status=" + this.status + ", style=" + this.style + ')';
    }

    static {
        Companion = new b();
    }

    public final Integer getEstimatedDuration() {
        return this.estimatedDuration;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final Integer getStartTimestamp() {
        return this.startTimestamp;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Integer getStyle() {
        return this.style;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ResearchProcessBlock r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.title);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.subtitle);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.resourceId);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, w0.f520792a, r100.startTimestamp);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        boolean r108 = true;
    L45:
        if (r108 == false) goto L48;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.estimatedDuration);
    L48:
        if (r101.shouldEncodeElementDefault(r102, 5) == false) goto L51;
    L49:
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r101.encodeNullableSerializableElement(r102, 5, w0.f520792a, r100.status);
    L57:
        if (r101.shouldEncodeElementDefault(r102, 6) == false) goto L60;
    L58:
        r103 = true;
    L62:
        if (r103 == false) goto L65;
        r101.encodeNullableSerializableElement(r102, 6, w0.f520792a, r100.style);
        return;
    L65:
        return;
    L60:
        if (r100.style == null) goto L62;
    L51:
        if (r100.status != null) goto L49;
        r109 = false;
        goto L54
    L42:
        if (r100.estimatedDuration != null) goto L40;
        r108 = false;
        goto L45
    L33:
        if (r100.startTimestamp != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.resourceId != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.subtitle != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.title != null) goto L4;
        r104 = false;
        goto L9
    }

    public ResearchProcessBlock(String r100, String r101, String r102, Integer r103, Integer r104, Integer r105, Integer r106) {
        this.title = r100;
        this.subtitle = r101;
        this.resourceId = r102;
        this.startTimestamp = r103;
        this.estimatedDuration = r104;
        this.status = r105;
        this.style = r106;
    }

    public ResearchProcessBlock(int r100, String r101, String r102, String r103, Integer r104, Integer r105, Integer r106, Integer r107, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f347030b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.title = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.subtitle = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.resourceId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.startTimestamp = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.estimatedDuration = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.status = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.style = null;
        return;
    L31:
        this.style = r107;
        return;
    L27:
        this.status = r106;
        goto L29
    L23:
        this.estimatedDuration = r105;
        goto L25
    L19:
        this.startTimestamp = r104;
        goto L21
    L15:
        this.resourceId = r103;
        goto L17
    L11:
        this.subtitle = r102;
        goto L13
    L7:
        this.title = r101;
        goto L9
    }

    public /* synthetic */ ResearchProcessBlock(String r100, String r101, String r102, Integer r110, Integer r111, Integer r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Integer r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
