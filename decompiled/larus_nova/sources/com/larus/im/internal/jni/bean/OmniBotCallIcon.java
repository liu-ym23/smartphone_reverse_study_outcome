package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import juc.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00060\u0001j\u0002`\u0002:\u0002'(B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0010¨\u0006)"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotCallIcon;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "dynamicAudioImgUri", "", "dynamicAudioImgUrl", "audioIconUri", "audioIconUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDynamicAudioImgUri$annotations", "()V", "getDynamicAudioImgUrl$annotations", "getAudioIconUri$annotations", "getAudioIconUrl$annotations", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniBotCallIcon implements java.io.Serializable {
    public static final Companion Companion = null;
    public final String audioIconUri;
    public final String audioIconUrl;
    public final String dynamicAudioImgUri;
    public final String dynamicAudioImgUrl;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotCallIcon$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBotCallIcon;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniBotCallIcon> serializer() {
            return OmniBotCallIcon$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniBotCallIcon() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ OmniBotCallIcon copy$default(OmniBotCallIcon r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.dynamicAudioImgUri;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.dynamicAudioImgUrl;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.audioIconUri;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.audioIconUrl;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    @SerialName("audio_icon_uri")
    public static /* synthetic */ void getAudioIconUri$annotations() {
    }

    @SerialName("audio_icon_url")
    public static /* synthetic */ void getAudioIconUrl$annotations() {
    }

    @SerialName("dynamic_audio_img_uri")
    public static /* synthetic */ void getDynamicAudioImgUri$annotations() {
    }

    @SerialName("dynamic_audio_img_url")
    public static /* synthetic */ void getDynamicAudioImgUrl$annotations() {
    }

    public final String component1() {
        return this.dynamicAudioImgUri;
    }

    public final String component2() {
        return this.dynamicAudioImgUrl;
    }

    public final String component3() {
        return this.audioIconUri;
    }

    public final String component4() {
        return this.audioIconUrl;
    }

    public final OmniBotCallIcon copy(String r100, String r101, String r102, String r103) {
        return new OmniBotCallIcon(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniBotCallIcon) == true) goto L8;
        return false;
    L8:
        OmniBotCallIcon r101 = (OmniBotCallIcon) r100;
        if (Intrinsics.areEqual(this.dynamicAudioImgUri, r101.dynamicAudioImgUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dynamicAudioImgUrl, r101.dynamicAudioImgUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.audioIconUri, r101.audioIconUri) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.audioIconUrl, r101.audioIconUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.dynamicAudioImgUri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.dynamicAudioImgUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.audioIconUri;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.audioIconUrl;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "OmniBotCallIcon(dynamicAudioImgUri=" + this.dynamicAudioImgUri + ", dynamicAudioImgUrl=" + this.dynamicAudioImgUrl + ", audioIconUri=" + this.audioIconUri + ", audioIconUrl=" + this.audioIconUrl + ')';
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniBotCallIcon r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.dynamicAudioImgUri);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.dynamicAudioImgUrl);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.audioIconUri);
    L30:
        if (r101.shouldEncodeElementDefault(r102, 3) == false) goto L33;
    L31:
        r103 = true;
    L35:
        if (r103 == false) goto L38;
        r101.encodeNullableSerializableElement(r102, 3, v2.f520790a, r100.audioIconUrl);
        return;
    L38:
        return;
    L33:
        if (r100.audioIconUrl == null) goto L35;
    L24:
        if (r100.audioIconUri != null) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.dynamicAudioImgUrl != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.dynamicAudioImgUri != null) goto L4;
        r104 = false;
        goto L9
    }

    public OmniBotCallIcon(String r100, String r101, String r102, String r103) {
        this.dynamicAudioImgUri = r100;
        this.dynamicAudioImgUrl = r101;
        this.audioIconUri = r102;
        this.audioIconUrl = r103;
    }

    public /* synthetic */ OmniBotCallIcon(int r100, String r101, String r102, String r103, String r104, q2 r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniBotCallIcon$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.dynamicAudioImgUri = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.dynamicAudioImgUrl = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.audioIconUri = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.audioIconUrl = null;
        return;
    L19:
        this.audioIconUrl = r104;
        return;
    L15:
        this.audioIconUri = r103;
        goto L17
    L11:
        this.dynamicAudioImgUrl = r102;
        goto L13
    L7:
        this.dynamicAudioImgUri = r101;
        goto L9
    }

    public /* synthetic */ OmniBotCallIcon(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
