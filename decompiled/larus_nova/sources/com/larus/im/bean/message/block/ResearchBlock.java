package com.larus.im.bean.message.block;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectInfo;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00060\u0001j\u0002`\u0002:\u000234BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u001a¨\u00065"}, d2 = {"Lcom/larus/im/bean/message/block/ResearchBlock;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "title", "", SelectInfo.BRIEF, "resourceId", "resourceType", "", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle$annotations", "()V", "getTitle", "()Ljava/lang/String;", "getBrief$annotations", "getBrief", "getResourceId$annotations", "getResourceId", "getResourceType$annotations", "getResourceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus$annotations", "getStatus", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/im/bean/message/block/ResearchBlock;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class ResearchBlock implements java.io.Serializable {
    public static final b Companion = null;
    private final String brief;
    private final String resourceId;
    private final Integer resourceType;
    private final Integer status;
    private final String title;

    /* JADX INFO: loaded from: classes4.dex */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<ResearchBlock> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f347027a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f347028b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            w0 r101 = w0.f520792a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f347028b;
        }

        static {
            a r100 = new a();
            f347027a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.ResearchBlock", r100, 5);
            r101.j("title", true);
            r101.j(SelectInfo.BRIEF, true);
            r101.j("resource_id", true);
            r101.j("resource_type", true);
            r101.j("status", true);
            f347028b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f347028b;
            c r101 = r210.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            w0 r107 = w0.f520792a;
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 3, r107, null);
            String r110 = r106;
            Integer r211 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r107, null);
            String r111 = r104;
            String r112 = r105;
            Integer r113 = r108;
            int r114 = 31;
        L23:
            r101.endStructure(r100);
            return new ResearchBlock(r114, r111, r112, r110, r113, r211, null);
        L5:
            String r109 = null;
            String r115 = null;
            Integer r116 = null;
            Integer r117 = null;
            int r118 = 0;
            boolean r119 = true;
        L6:
            if (r119 == false) goto L22;
            int r120 = r101.decodeElementIndex(r100);
            if (r120 != (-1)) goto L9;
            r119 = false;
            goto L6
        L9:
            if (r120 != 0) goto L10;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
            r118 = r118 | 1;
            goto L6
        L10:
            if (r120 != 1) goto L11;
            r109 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r109);
            r118 = r118 | 2;
            goto L6
        L11:
            if (r120 != 2) goto L12;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r115);
            r118 = r118 | 4;
            goto L6
        L12:
            if (r120 != 3) goto L13;
            r116 = (Integer) r101.decodeNullableSerializableElement(r100, 3, w0.f520792a, r116);
            r118 = r118 | 8;
            goto L6
        L13:
            if (r120 != 4) goto L16;
            r117 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r117);
            r118 = r118 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r120);
        L22:
            r114 = r118;
            r111 = r102;
            r112 = r109;
            r110 = r115;
            r113 = r116;
            r211 = r117;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            ResearchBlock r102 = (ResearchBlock) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f347028b;
            muc.d r104 = r100.beginStructure(r103);
            ResearchBlock.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<ResearchBlock> serializer() {
            return a.f347027a;
        }
    }

    public ResearchBlock() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ResearchBlock copy$default(ResearchBlock r100, String r101, String r102, String r103, Integer r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.brief;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.resourceId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.resourceType;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.status;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName(SelectInfo.BRIEF)
    public static /* synthetic */ void getBrief$annotations() {
    }

    @SerialName("resource_id")
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName("resource_type")
    public static /* synthetic */ void getResourceType$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.brief;
    }

    public final String component3() {
        return this.resourceId;
    }

    public final Integer component4() {
        return this.resourceType;
    }

    public final Integer component5() {
        return this.status;
    }

    public final ResearchBlock copy(String r100, String r101, String r110, Integer r111, Integer r112) {
        return new ResearchBlock(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResearchBlock) == true) goto L8;
        return false;
    L8:
        ResearchBlock r101 = (ResearchBlock) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.brief, r101.brief) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resourceType, r101.resourceType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.brief;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.resourceId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.resourceType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.status;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "ResearchBlock(title=" + this.title + ", brief=" + this.brief + ", resourceId=" + this.resourceId + ", resourceType=" + this.resourceType + ", status=" + this.status + ')';
    }

    static {
        Companion = new b();
    }

    public final String getBrief() {
        return this.brief;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final Integer getResourceType() {
        return this.resourceType;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(ResearchBlock r100, muc.d r101, f r102) {
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
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.brief);
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
        r101.encodeNullableSerializableElement(r102, 3, w0.f520792a, r100.resourceType);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeNullableSerializableElement(r102, 4, w0.f520792a, r100.status);
        return;
    L47:
        return;
    L42:
        if (r100.status == null) goto L44;
    L33:
        if (r100.resourceType != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.resourceId != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.brief != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.title != null) goto L4;
        r104 = false;
        goto L9
    }

    public ResearchBlock(String r100, String r101, String r102, Integer r103, Integer r104) {
        this.title = r100;
        this.brief = r101;
        this.resourceId = r102;
        this.resourceType = r103;
        this.status = r104;
    }

    public ResearchBlock(int r100, String r101, String r102, String r103, Integer r104, Integer r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f347028b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.title = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.brief = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.resourceId = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.resourceType = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.status = null;
        return;
    L23:
        this.status = r105;
        return;
    L19:
        this.resourceType = r104;
        goto L21
    L15:
        this.resourceId = r103;
        goto L17
    L11:
        this.brief = r102;
        goto L13
    L7:
        this.title = r101;
        goto L9
    }

    public /* synthetic */ ResearchBlock(String r100, String r101, String r102, Integer r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Integer r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
