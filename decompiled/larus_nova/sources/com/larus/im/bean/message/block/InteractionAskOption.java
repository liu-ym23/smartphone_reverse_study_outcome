package com.larus.im.bean.message.block;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00060\u0001j\u0002`\u0002:\u000234BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBK\b\u0010\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003JC\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\nHÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001e¨\u00065"}, d2 = {"Lcom/larus/im/bean/message/block/InteractionAskOption;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "label", "", "description", "icon", "Lcom/larus/im/bean/message/block/InteractionAskIcon;", "optionId", ReportConstant.COMMON_ACTION_TYPE, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/block/InteractionAskIcon;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/block/InteractionAskIcon;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLabel$annotations", "()V", "getLabel", "()Ljava/lang/String;", "getDescription$annotations", "getDescription", "getIcon$annotations", "getIcon", "()Lcom/larus/im/bean/message/block/InteractionAskIcon;", "getOptionId$annotations", "getOptionId", "getActionType$annotations", "getActionType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class InteractionAskOption implements java.io.Serializable {
    public static final b Companion = null;
    private final int actionType;
    private final String description;
    private final InteractionAskIcon icon;
    private final String label;
    private final String optionId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<InteractionAskOption> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346906a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346907b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(InteractionAskIcon.a.f346904a), kuc.a.d(r100), w0.f520792a};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346907b;
        }

        static {
            a r100 = new a();
            f346906a = r100;
            g2 r101 = new g2("com.larus.im.bean.message.block.InteractionAskOption", r100, 5);
            r101.j("label", true);
            r101.j("description", true);
            r101.j("icon", true);
            r101.j("option_id", true);
            r101.j("action_type", true);
            f346907b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346907b;
            c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            v2 r102 = v2.f520790a;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, r102, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 1, r102, null);
            InteractionAskIcon r105 = (InteractionAskIcon) r101.decodeNullableSerializableElement(r100, 2, InteractionAskIcon.a.f346904a, null);
            String r110 = (String) r101.decodeNullableSerializableElement(r100, 3, r102, null);
            InteractionAskIcon r111 = r105;
            int r211 = r101.decodeIntElement(r100, 4);
            String r112 = r104;
            String r113 = r103;
            int r114 = 31;
        L23:
            r101.endStructure(r100);
            return new InteractionAskOption(r114, r113, r112, r111, r110, r211, null);
        L5:
            String r106 = null;
            String r115 = null;
            InteractionAskIcon r116 = null;
            String r117 = null;
            int r107 = 0;
            int r108 = 0;
            boolean r118 = true;
        L6:
            if (r118 == false) goto L22;
            int r119 = r101.decodeElementIndex(r100);
            if (r119 != (-1)) goto L9;
            r118 = false;
            goto L6
        L9:
            if (r119 != 0) goto L10;
            r106 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r106);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r119 != 1) goto L11;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r115);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r119 != 2) goto L12;
            r116 = (InteractionAskIcon) r101.decodeNullableSerializableElement(r100, 2, InteractionAskIcon.a.f346904a, r116);
            r108 = r108 | 4;
            goto L6
        L12:
            if (r119 != 3) goto L13;
            r117 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r117);
            r108 = r108 | 8;
            goto L6
        L13:
            if (r119 != 4) goto L16;
            r107 = r101.decodeIntElement(r100, 4);
            r108 = r108 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r119);
        L22:
            r211 = r107;
            r114 = r108;
            r113 = r106;
            r112 = r115;
            r111 = r116;
            r110 = r117;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            InteractionAskOption r102 = (InteractionAskOption) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346907b;
            muc.d r104 = r100.beginStructure(r103);
            InteractionAskOption.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<InteractionAskOption> serializer() {
            return a.f346906a;
        }
    }

    public InteractionAskOption() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ InteractionAskOption copy$default(InteractionAskOption r100, String r101, String r102, InteractionAskIcon r103, String r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.label;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.description;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.icon;
    L11:
        InteractionAskIcon r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.optionId;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.actionType;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("action_type")
    public static /* synthetic */ void getActionType$annotations() {
    }

    @SerialName("description")
    public static /* synthetic */ void getDescription$annotations() {
    }

    @SerialName("icon")
    public static /* synthetic */ void getIcon$annotations() {
    }

    @SerialName("label")
    public static /* synthetic */ void getLabel$annotations() {
    }

    @SerialName("option_id")
    public static /* synthetic */ void getOptionId$annotations() {
    }

    public final String component1() {
        return this.label;
    }

    public final String component2() {
        return this.description;
    }

    public final InteractionAskIcon component3() {
        return this.icon;
    }

    public final String component4() {
        return this.optionId;
    }

    public final int component5() {
        return this.actionType;
    }

    public final InteractionAskOption copy(String r100, String r101, InteractionAskIcon r110, String r111, int r112) {
        return new InteractionAskOption(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InteractionAskOption) == true) goto L8;
        return false;
    L8:
        InteractionAskOption r101 = (InteractionAskOption) r100;
        if (Intrinsics.areEqual(this.label, r101.label) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.optionId, r101.optionId) == true) goto L21;
        return false;
    L21:
        if (this.actionType == r101.actionType) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.label;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.description;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        InteractionAskIcon r107 = this.icon;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.optionId;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.actionType;
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
        return "InteractionAskOption(label=" + this.label + ", description=" + this.description + ", icon=" + this.icon + ", optionId=" + this.optionId + ", actionType=" + this.actionType + ')';
    }

    static {
        Companion = new b();
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final InteractionAskIcon getIcon() {
        return this.icon;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getOptionId() {
        return this.optionId;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(InteractionAskOption r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.label);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.description);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, InteractionAskIcon.a.f346904a, r100.icon);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.optionId);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeIntElement(r102, 4, r100.actionType);
        return;
    L47:
        return;
    L42:
        if (r100.actionType == 0) goto L44;
    L33:
        if (r100.optionId != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.icon != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.description != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.label != null) goto L4;
        r104 = false;
        goto L9
    }

    public InteractionAskOption(String r100, String r101, InteractionAskIcon r102, String r103, int r104) {
        this.label = r100;
        this.description = r101;
        this.icon = r102;
        this.optionId = r103;
        this.actionType = r104;
    }

    public InteractionAskOption(int r100, String r101, String r102, InteractionAskIcon r103, String r104, int r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346907b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.label = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.description = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.icon = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.optionId = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.actionType = 0;
        return;
    L23:
        this.actionType = r105;
        return;
    L19:
        this.optionId = r104;
        goto L21
    L15:
        this.icon = r103;
        goto L17
    L11:
        this.description = r102;
        goto L13
    L7:
        this.label = r101;
        goto L9
    }

    public /* synthetic */ InteractionAskOption(String r100, String r101, InteractionAskIcon r102, String r103, int r104, int r105, DefaultConstructorMarker r110) {
        String r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = null;
    L11:
        if ((r105 & 4) == 0) goto L13;
        InteractionAskIcon r108 = null;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        int r109 = 0;
    L22:
        this(r111, r107, r108, r106, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
