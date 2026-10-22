package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0002*+B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0011¨\u0006,"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotMemoryInfo;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "botMemorySizeLimit", "", "botMemoryCntLimit", "switchStatus", "", "hintShouldDisplay", "enableBotMemory", "<init>", "(IIZZZ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBotMemorySizeLimit$annotations", "()V", "getBotMemoryCntLimit$annotations", "getSwitchStatus$annotations", "getHintShouldDisplay$annotations", "getEnableBotMemory$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniBotMemoryInfo implements java.io.Serializable {
    public static final Companion Companion = null;
    public final int botMemoryCntLimit;
    public final int botMemorySizeLimit;
    public final boolean enableBotMemory;
    public final boolean hintShouldDisplay;
    public final boolean switchStatus;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotMemoryInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBotMemoryInfo;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniBotMemoryInfo> serializer() {
            return OmniBotMemoryInfo$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniBotMemoryInfo() {
        this(0, 0, false, false, false, 31, null);
    }

    public static /* synthetic */ OmniBotMemoryInfo copy$default(OmniBotMemoryInfo r100, int r101, int r102, boolean r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.botMemorySizeLimit;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.botMemoryCntLimit;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.switchStatus;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.hintShouldDisplay;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.enableBotMemory;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    @SerialName("bot_memory_cnt_limit")
    public static /* synthetic */ void getBotMemoryCntLimit$annotations() {
    }

    @SerialName("bot_memory_size_limit")
    public static /* synthetic */ void getBotMemorySizeLimit$annotations() {
    }

    @SerialName("enable_bot_memory")
    public static /* synthetic */ void getEnableBotMemory$annotations() {
    }

    @SerialName("hint_should_display")
    public static /* synthetic */ void getHintShouldDisplay$annotations() {
    }

    @SerialName(EventConstants.ExtraJson.SWITCH_STATUS)
    public static /* synthetic */ void getSwitchStatus$annotations() {
    }

    public final int component1() {
        return this.botMemorySizeLimit;
    }

    public final int component2() {
        return this.botMemoryCntLimit;
    }

    public final boolean component3() {
        return this.switchStatus;
    }

    public final boolean component4() {
        return this.hintShouldDisplay;
    }

    public final boolean component5() {
        return this.enableBotMemory;
    }

    public final OmniBotMemoryInfo copy(int r100, int r101, boolean r110, boolean r111, boolean r112) {
        return new OmniBotMemoryInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniBotMemoryInfo) == true) goto L8;
        return false;
    L8:
        OmniBotMemoryInfo r101 = (OmniBotMemoryInfo) r100;
        if (this.botMemorySizeLimit == r101.botMemorySizeLimit) goto L12;
        return false;
    L12:
        if (this.botMemoryCntLimit == r101.botMemoryCntLimit) goto L15;
        return false;
    L15:
        if (this.switchStatus == r101.switchStatus) goto L18;
        return false;
    L18:
        if (this.hintShouldDisplay == r101.hintShouldDisplay) goto L21;
        return false;
    L21:
        if (this.enableBotMemory == r101.enableBotMemory) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.botMemorySizeLimit * 31) + this.botMemoryCntLimit) * 31;
        int r101 = 1231;
        if (this.switchStatus == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.hintShouldDisplay == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.enableBotMemory == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "OmniBotMemoryInfo(botMemorySizeLimit=" + this.botMemorySizeLimit + ", botMemoryCntLimit=" + this.botMemoryCntLimit + ", switchStatus=" + this.switchStatus + ", hintShouldDisplay=" + this.hintShouldDisplay + ", enableBotMemory=" + this.enableBotMemory + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniBotMemoryInfo r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.botMemorySizeLimit);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.botMemoryCntLimit);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeBooleanElement(r102, 2, r100.switchStatus);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeBooleanElement(r102, 3, r100.hintShouldDisplay);
    L39:
        if (r101.shouldEncodeElementDefault(r102, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeBooleanElement(r102, 4, r100.enableBotMemory);
        return;
    L47:
        return;
    L42:
        if (r100.enableBotMemory == false) goto L44;
    L33:
        if (r100.hintShouldDisplay == true) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.switchStatus == true) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.botMemoryCntLimit != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.botMemorySizeLimit != 0) goto L4;
        r104 = false;
        goto L9
    }

    public OmniBotMemoryInfo(int r100, int r101, boolean r102, boolean r103, boolean r104) {
        this.botMemorySizeLimit = r100;
        this.botMemoryCntLimit = r101;
        this.switchStatus = r102;
        this.hintShouldDisplay = r103;
        this.enableBotMemory = r104;
    }

    public /* synthetic */ OmniBotMemoryInfo(int r100, int r101, int r102, boolean r103, boolean r104, boolean r105, q2 r106) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniBotMemoryInfo$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.botMemorySizeLimit = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.botMemoryCntLimit = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.switchStatus = false;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.hintShouldDisplay = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.enableBotMemory = false;
        return;
    L23:
        this.enableBotMemory = r105;
        return;
    L19:
        this.hintShouldDisplay = r104;
        goto L21
    L15:
        this.switchStatus = r103;
        goto L17
    L11:
        this.botMemoryCntLimit = r102;
        goto L13
    L7:
        this.botMemorySizeLimit = r101;
        goto L9
    }

    public /* synthetic */ OmniBotMemoryInfo(int r100, int r101, boolean r102, boolean r103, boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        int r112 = 0;
    L7:
        if ((r110 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r110 & 4) == 0) goto L13;
        boolean r106 = false;
    L15:
        if ((r110 & 8) == 0) goto L17;
        boolean r107 = false;
    L19:
        if ((r110 & 16) == 0) goto L21;
        boolean r113 = false;
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
