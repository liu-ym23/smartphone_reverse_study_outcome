package com.larus.im.bean.bot;

import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.map.api.monitor.MapMonitorConst;
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
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 72\u00060\u0001j\u0002`\u0002:\u000267B3\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB?\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\b\u0010$\u001a\u00020\nH\u0016J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J5\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0006HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u0007\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00068"}, d2 = {"Lcom/larus/im/bean/bot/MixVoice;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "voiceItem", "Lcom/larus/im/bean/bot/SpeakerVoice;", LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, "", "isEnable", "", "tabName", "", "<init>", "(Lcom/larus/im/bean/bot/SpeakerVoice;IZLjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/bean/bot/SpeakerVoice;IZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVoiceItem$annotations", "()V", "getVoiceItem", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setVoiceItem", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "getPercentage$annotations", "getPercentage", "()I", "setPercentage", "(I)V", "isEnable$annotations", "()Z", "setEnable", "(Z)V", "getTabName", "()Ljava/lang/String;", "setTabName", "(Ljava/lang/String;)V", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class MixVoice implements java.io.Serializable {
    public static final b Companion = null;
    private boolean isEnable;
    private int percentage;
    private String tabName;
    private SpeakerVoice voiceItem;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<MixVoice> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346480a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346481b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(SpeakerVoice.a.f346504a), w0.f520792a, i.f520705a, kuc.a.d(v2.f520790a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346481b;
        }

        static {
            a r100 = new a();
            f346480a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.MixVoice", r100, 4);
            r101.j("voice_item", true);
            r101.j(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, true);
            r101.j(MapMonitorConst.IS_ENABLE, true);
            r101.j("tabName", true);
            f346481b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f346481b;
            c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            SpeakerVoice r102 = (SpeakerVoice) r101.decodeNullableSerializableElement(r100, 0, SpeakerVoice.a.f346504a, null);
            int r103 = r101.decodeIntElement(r100, 1);
            SpeakerVoice r110 = r102;
            boolean r111 = r101.decodeBooleanElement(r100, 2);
            int r112 = r103;
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, null);
            int r114 = 15;
        L21:
            r101.endStructure(r100);
            return new MixVoice(r114, r110, r112, r111, r113, null);
        L5:
            SpeakerVoice r104 = null;
            String r115 = null;
            boolean r105 = false;
            int r106 = 0;
            int r107 = 0;
            boolean r116 = true;
        L6:
            if (r116 == false) goto L20;
            int r117 = r101.decodeElementIndex(r100);
            if (r117 != (-1)) goto L9;
            r116 = false;
            goto L6
        L9:
            if (r117 != 0) goto L10;
            r104 = (SpeakerVoice) r101.decodeNullableSerializableElement(r100, 0, SpeakerVoice.a.f346504a, r104);
            r107 = r107 | 1;
            goto L6
        L10:
            if (r117 != 1) goto L11;
            r106 = r101.decodeIntElement(r100, 1);
            r107 = r107 | 2;
            goto L6
        L11:
            if (r117 != 2) goto L12;
            r105 = r101.decodeBooleanElement(r100, 2);
            r107 = r107 | 4;
            goto L6
        L12:
            if (r117 != 3) goto L15;
            r115 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r115);
            r107 = r107 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r117);
        L20:
            r111 = r105;
            r112 = r106;
            r114 = r107;
            r110 = r104;
            r113 = r115;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            MixVoice r102 = (MixVoice) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346481b;
            muc.d r104 = r100.beginStructure(r103);
            MixVoice.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<MixVoice> serializer() {
            return a.f346480a;
        }
    }

    public MixVoice() {
        this(null, 0, false, null, 15, null);
    }

    public static /* synthetic */ MixVoice copy$default(MixVoice r100, SpeakerVoice r101, int r102, boolean r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.voiceItem;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.percentage;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.isEnable;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.tabName;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName(LayoutSizeLargeModeConfig.TYPE_PERCENTAGE)
    public static /* synthetic */ void getPercentage$annotations() {
    }

    @SerialName("voice_item")
    public static /* synthetic */ void getVoiceItem$annotations() {
    }

    @SerialName(MapMonitorConst.IS_ENABLE)
    public static /* synthetic */ void isEnable$annotations() {
    }

    public final SpeakerVoice component1() {
        return this.voiceItem;
    }

    public final int component2() {
        return this.percentage;
    }

    public final boolean component3() {
        return this.isEnable;
    }

    public final String component4() {
        return this.tabName;
    }

    public final MixVoice copy(SpeakerVoice r100, int r101, boolean r102, String r103) {
        return new MixVoice(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MixVoice) == true) goto L8;
        return false;
    L8:
        MixVoice r101 = (MixVoice) r100;
        if (Intrinsics.areEqual(this.voiceItem, r101.voiceItem) == true) goto L12;
        return false;
    L12:
        if (this.percentage == r101.percentage) goto L15;
        return false;
    L15:
        if (this.isEnable == r101.isEnable) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        SpeakerVoice r100 = this.voiceItem;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.percentage) * 31;
        if (this.isEnable == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.tabName;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    static {
        Companion = new b();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("id:");
        SpeakerVoice r101 = this.voiceItem;
        Integer r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getId();
    L6:
        r100.append(r103);
        r100.append(", languageCode:");
        SpeakerVoice r104 = this.voiceItem;
        if (r104 == null) goto L9;
        String r105 = r104.getLanguageCode();
    L10:
        r100.append(r105);
        r100.append(", status:");
        SpeakerVoice r106 = this.voiceItem;
        if (r106 == null) goto L13;
        Integer r107 = Integer.valueOf(r106.getStatus());
    L14:
        r100.append(r107);
        r100.append(", nameStatus:");
        SpeakerVoice r108 = this.voiceItem;
        if (r108 == null) goto L17;
        Integer r109 = Integer.valueOf(r108.getNameStatus());
    L18:
        r100.append(r109);
        r100.append(", confStatus:");
        SpeakerVoice r110 = this.voiceItem;
        if (r110 == null) goto L21;
        r102 = Integer.valueOf(r110.getConfStatus());
    L21:
        r100.append(r102);
        r100.append(", percentage:");
        r100.append(this.percentage);
        r100.append(", isEnable:");
        r100.append(this.isEnable);
        return r100.toString();
    L17:
        r109 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final int getPercentage() {
        return this.percentage;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final SpeakerVoice getVoiceItem() {
        return this.voiceItem;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final void setEnable(boolean r100) {
        this.isEnable = r100;
    }

    public final void setPercentage(int r100) {
        this.percentage = r100;
    }

    public final void setTabName(String r100) {
        this.tabName = r100;
    }

    public final void setVoiceItem(SpeakerVoice r100) {
        this.voiceItem = r100;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(MixVoice r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, SpeakerVoice.a.f346504a, r100.voiceItem);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.percentage);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeBooleanElement(r102, 2, r100.isEnable);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r103 = true;
    L35:
        if (r103 == false) goto L38;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.tabName);
        return;
    L38:
        return;
    L33:
        if (r100.tabName == null) goto L35;
    L24:
        if (r100.isEnable != true) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.percentage != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.voiceItem != null) goto L4;
        r104 = false;
        goto L9
    }

    public MixVoice(SpeakerVoice r100, int r101, boolean r102, String r103) {
        this.voiceItem = r100;
        this.percentage = r101;
        this.isEnable = r102;
        this.tabName = r103;
    }

    public MixVoice(int r100, SpeakerVoice r101, int r102, boolean r103, String r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346481b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.voiceItem = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.percentage = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.isEnable = true;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.tabName = null;
        return;
    L19:
        this.tabName = r104;
        return;
    L15:
        this.isEnable = r103;
        goto L17
    L11:
        this.percentage = r102;
        goto L13
    L7:
        this.voiceItem = r101;
        goto L9
    }

    public /* synthetic */ MixVoice(SpeakerVoice r100, int r101, boolean r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = true;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
