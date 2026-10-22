package com.larus.im.bean.conversation;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.bean.bot.BotStatistic;
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
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002;<BC\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rBM\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003JJ\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u000fHÖ\u0001J\t\u00102\u001a\u00020\bHÖ\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\b:R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u001fR&\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010#¨\u0006="}, d2 = {"Lcom/larus/im/bean/conversation/Templates;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "Lcom/larus/im/bean/conversation/ActionbarBaseData;", "id", "", "botId", "templateName", "", "botStats", "Lcom/larus/im/bean/bot/BotStatistic;", "requestId", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/larus/im/bean/bot/BotStatistic;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/larus/im/bean/bot/BotStatistic;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBotId$annotations", "getBotId", "getTemplateName$annotations", "getTemplateName", "()Ljava/lang/String;", "getBotStats$annotations", "getBotStats", "()Lcom/larus/im/bean/bot/BotStatistic;", "getRequestId$annotations", "getRequestId", "setRequestId", "(Ljava/lang/String;)V", "uniqueIdInType", "getContentFlag", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/larus/im/bean/bot/BotStatistic;Ljava/lang/String;)Lcom/larus/im/bean/conversation/Templates;", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class Templates implements java.io.Serializable {
    public static final b Companion = null;
    private final Long botId;
    private final BotStatistic botStats;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final Long f346547id;
    private String requestId;
    private final String templateName;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<Templates> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346548a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346549b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            g1 r100 = g1.f520681a;
            v2 r101 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(BotStatistic.a.f346447a), kuc.a.d(r101)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346549b;
        }

        static {
            a r100 = new a();
            f346548a = r100;
            g2 r101 = new g2("com.larus.im.bean.conversation.Templates", r100, 5);
            r101.j("id", true);
            r101.j("bot_id", true);
            r101.j("msg_template_name", true);
            r101.j("bot_stats", true);
            r101.j("request_id", true);
            f346549b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346549b;
            c r101 = r210.beginStructure(r100);
            Long r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            g1 r103 = g1.f520681a;
            Long r104 = (Long) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            Long r105 = (Long) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            v2 r106 = v2.f520790a;
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 2, r106, null);
            BotStatistic r108 = (BotStatistic) r101.decodeNullableSerializableElement(r100, 3, BotStatistic.a.f346447a, null);
            Long r110 = r105;
            String r111 = r107;
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 4, r106, null);
            Long r112 = r104;
            BotStatistic r113 = r108;
            int r114 = 31;
        L23:
            r101.endStructure(r100);
            return new Templates(r114, r112, r110, r111, r113, r211, null);
        L5:
            Long r109 = null;
            String r115 = null;
            BotStatistic r116 = null;
            String r117 = null;
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
            r102 = (Long) r101.decodeNullableSerializableElement(r100, 0, g1.f520681a, r102);
            r118 = r118 | 1;
            goto L6
        L10:
            if (r120 != 1) goto L11;
            r109 = (Long) r101.decodeNullableSerializableElement(r100, 1, g1.f520681a, r109);
            r118 = r118 | 2;
            goto L6
        L11:
            if (r120 != 2) goto L12;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r115);
            r118 = r118 | 4;
            goto L6
        L12:
            if (r120 != 3) goto L13;
            r116 = (BotStatistic) r101.decodeNullableSerializableElement(r100, 3, BotStatistic.a.f346447a, r116);
            r118 = r118 | 8;
            goto L6
        L13:
            if (r120 != 4) goto L16;
            r117 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r117);
            r118 = r118 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r120);
        L22:
            r114 = r118;
            r112 = r102;
            r110 = r109;
            r111 = r115;
            r113 = r116;
            r211 = r117;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            Templates r102 = (Templates) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346549b;
            muc.d r104 = r100.beginStructure(r103);
            Templates.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<Templates> serializer() {
            return a.f346548a;
        }
    }

    public Templates() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Templates copy$default(Templates r100, Long r101, Long r102, String r103, BotStatistic r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.f346547id;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.botId;
    L8:
        Long r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.templateName;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.botStats;
    L14:
        BotStatistic r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.requestId;
    L17:
        Long r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("bot_id")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @SerialName("bot_stats")
    public static /* synthetic */ void getBotStats$annotations() {
    }

    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName("request_id")
    public static /* synthetic */ void getRequestId$annotations() {
    }

    @SerialName("msg_template_name")
    public static /* synthetic */ void getTemplateName$annotations() {
    }

    public final Long component1() {
        return this.f346547id;
    }

    public final Long component2() {
        return this.botId;
    }

    public final String component3() {
        return this.templateName;
    }

    public final BotStatistic component4() {
        return this.botStats;
    }

    public final String component5() {
        return this.requestId;
    }

    public final Templates copy(Long r100, Long r101, String r110, BotStatistic r111, String r112) {
        return new Templates(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Templates) == true) goto L8;
        return false;
    L8:
        Templates r101 = (Templates) r100;
        if (Intrinsics.areEqual(this.f346547id, r101.f346547id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateName, r101.templateName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botStats, r101.botStats) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Long r100 = this.f346547id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.botId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.templateName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        BotStatistic r110 = this.botStats;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.requestId;
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
        return "Templates(id=" + this.f346547id + ", botId=" + this.botId + ", templateName=" + this.templateName + ", botStats=" + this.botStats + ", requestId=" + this.requestId + ')';
    }

    static {
        Companion = new b();
    }

    public String getContentFlag() {
        return this.templateName + '-' + this.botStats + '-' + this.botId;
    }

    public String uniqueIdInType() {
        return String.valueOf(this.f346547id);
    }

    public final Long getBotId() {
        return this.botId;
    }

    public final BotStatistic getBotStats() {
        return this.botStats;
    }

    public final Long getId() {
        return this.f346547id;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public final void setRequestId(String r100) {
        this.requestId = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(Templates r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L5;
    L4:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        r101.encodeNullableSerializableElement(r102, 0, g1.f520681a, r100.f346547id);
    L15:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L17;
    L16:
        boolean r105 = true;
    L24:
        if (r105 == false) goto L27;
        r101.encodeNullableSerializableElement(r102, 1, g1.f520681a, r100.botId);
    L27:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L30;
    L28:
        boolean r106 = true;
    L33:
        if (r106 == false) goto L36;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.templateName);
    L36:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L39;
    L37:
        boolean r107 = true;
    L42:
        if (r107 == false) goto L45;
        r101.encodeNullableSerializableElement(r102, 3, BotStatistic.a.f346447a, r100.botStats);
    L45:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L48;
    L46:
        r103 = true;
    L50:
        if (r103 == false) goto L53;
        r101.encodeNullableSerializableElement(r102, 4, v2.f520790a, r100.requestId);
        return;
    L53:
        return;
    L48:
        if (r100.requestId == null) goto L50;
    L39:
        if (r100.botStats != null) goto L37;
        r107 = false;
        goto L42
    L30:
        if (Intrinsics.areEqual(r100.templateName, "") == false) goto L28;
        r106 = false;
        goto L33
    L17:
        Long r108 = r100.botId;
        if (r108 == null) goto L16;
        if (r108.longValue() != 0) goto L16;
        r105 = false;
        goto L24
    L5:
        Long r109 = r100.f346547id;
        if (r109 == null) goto L4;
        if (r109.longValue() != 0) goto L4;
        r104 = false;
        goto L12
    }

    public Templates(Long r100, Long r101, String r102, BotStatistic r103, String r104) {
        this.f346547id = r100;
        this.botId = r101;
        this.templateName = r102;
        this.botStats = r103;
        this.requestId = r104;
    }

    public Templates(int r100, Long r101, Long r102, String r103, BotStatistic r104, String r105, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346549b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = 0L;
    L7:
        this.f346547id = r101;
        if ((r100 & 2) != 0) goto L10;
        this.botId = 0L;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.templateName = "";
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.botStats = null;
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.requestId = null;
        return;
    L22:
        this.requestId = r105;
        return;
    L18:
        this.botStats = r104;
        goto L20
    L14:
        this.templateName = r103;
        goto L16
    L10:
        this.botId = r102;
        goto L12
    }

    public /* synthetic */ Templates(Long r100, Long r101, String r102, BotStatistic r103, String r104, int r105, DefaultConstructorMarker r110) {
        Long r106 = 0L;
        if ((r105 & 1) == 0) goto L5;
        Long r111 = r106;
    L7:
        if ((r105 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r105 & 4) == 0) goto L13;
        r102 = "";
    L13:
        String r107 = r102;
        if ((r105 & 8) == 0) goto L16;
        BotStatistic r108 = null;
    L18:
        if ((r105 & 16) == 0) goto L20;
        String r109 = null;
    L21:
        this(r111, r106, r107, r108, r109);
        return;
    L20:
        r109 = r104;
        goto L21
    L16:
        r108 = r103;
        goto L18
    L5:
        r111 = r100;
        goto L7
    }
}
