package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00060\u0001j\u0002`\u0002:\u0002'(B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nB;\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0010¨\u0006)"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniAIJobScheduleTime;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "hasHour", "", "hour", "", "hasMinute", "minute", "<init>", "(ZIZI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZIZILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHasHour$annotations", "()V", "getHour$annotations", "getHasMinute$annotations", "getMinute$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniAIJobScheduleTime implements java.io.Serializable {
    public static final Companion Companion = null;
    public final boolean hasHour;
    public final boolean hasMinute;
    public final int hour;
    public final int minute;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniAIJobScheduleTime$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniAIJobScheduleTime;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniAIJobScheduleTime> serializer() {
            return OmniAIJobScheduleTime$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniAIJobScheduleTime() {
        this(false, 0, false, 0, 15, null);
    }

    public static /* synthetic */ OmniAIJobScheduleTime copy$default(OmniAIJobScheduleTime r100, boolean r101, int r102, boolean r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.hasHour;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.hour;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.hasMinute;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.minute;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("has_hour")
    public static /* synthetic */ void getHasHour$annotations() {
    }

    @SerialName("has_minute")
    public static /* synthetic */ void getHasMinute$annotations() {
    }

    @SerialName("hour")
    public static /* synthetic */ void getHour$annotations() {
    }

    @SerialName("minute")
    public static /* synthetic */ void getMinute$annotations() {
    }

    public final boolean component1() {
        return this.hasHour;
    }

    public final int component2() {
        return this.hour;
    }

    public final boolean component3() {
        return this.hasMinute;
    }

    public final int component4() {
        return this.minute;
    }

    public final OmniAIJobScheduleTime copy(boolean r100, int r101, boolean r102, int r103) {
        return new OmniAIJobScheduleTime(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAIJobScheduleTime) == true) goto L8;
        return false;
    L8:
        OmniAIJobScheduleTime r101 = (OmniAIJobScheduleTime) r100;
        if (this.hasHour == r101.hasHour) goto L12;
        return false;
    L12:
        if (this.hour == r101.hour) goto L15;
        return false;
    L15:
        if (this.hasMinute == r101.hasMinute) goto L18;
        return false;
    L18:
        if (this.minute == r101.minute) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.hasHour == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.hour) * 31;
        if (this.hasMinute == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.minute;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "OmniAIJobScheduleTime(hasHour=" + this.hasHour + ", hour=" + this.hour + ", hasMinute=" + this.hasMinute + ", minute=" + this.minute + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniAIJobScheduleTime r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeBooleanElement(r102, 0, r100.hasHour);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.hour);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeBooleanElement(r102, 2, r100.hasMinute);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r103 = true;
    L35:
        if (r103 == false) goto L38;
        r101.encodeIntElement(r102, 3, r100.minute);
        return;
    L38:
        return;
    L33:
        if (r100.minute == 0) goto L35;
    L24:
        if (r100.hasMinute == true) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.hour != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.hasHour == true) goto L4;
        r104 = false;
        goto L9
    }

    public OmniAIJobScheduleTime(boolean r100, int r101, boolean r102, int r103) {
        this.hasHour = r100;
        this.hour = r101;
        this.hasMinute = r102;
        this.minute = r103;
    }

    public /* synthetic */ OmniAIJobScheduleTime(int r100, boolean r101, int r102, boolean r103, int r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniAIJobScheduleTime$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.hasHour = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.hour = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.hasMinute = false;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.minute = 0;
        return;
    L19:
        this.minute = r104;
        return;
    L15:
        this.hasMinute = r103;
        goto L17
    L11:
        this.hour = r102;
        goto L13
    L7:
        this.hasHour = r101;
        goto L9
    }

    public /* synthetic */ OmniAIJobScheduleTime(boolean r100, int r101, boolean r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
