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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00060\u0001j\u0002`\u0002:\u0002\"#B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u000f¨\u0006$"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotBaseIcon;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "iconImage", "Lcom/larus/im/internal/jni/bean/OmniBotImage;", "iconPrompt", "", "<init>", "(Lcom/larus/im/internal/jni/bean/OmniBotImage;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/larus/im/internal/jni/bean/OmniBotImage;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIconImage$annotations", "()V", "getIconPrompt$annotations", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniBotBaseIcon implements java.io.Serializable {
    public static final Companion Companion = null;
    public final OmniBotImage iconImage;
    public final String iconPrompt;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniBotBaseIcon$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniBotBaseIcon;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniBotBaseIcon> serializer() {
            return OmniBotBaseIcon$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OmniBotBaseIcon() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OmniBotBaseIcon copy$default(OmniBotBaseIcon r100, OmniBotImage r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.iconImage;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.iconPrompt;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("icon_image")
    public static /* synthetic */ void getIconImage$annotations() {
    }

    @SerialName("icon_prompt")
    public static /* synthetic */ void getIconPrompt$annotations() {
    }

    public final OmniBotImage component1() {
        return this.iconImage;
    }

    public final String component2() {
        return this.iconPrompt;
    }

    public final OmniBotBaseIcon copy(OmniBotImage r100, String r101) {
        return new OmniBotBaseIcon(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniBotBaseIcon) == true) goto L8;
        return false;
    L8:
        OmniBotBaseIcon r101 = (OmniBotBaseIcon) r100;
        if (Intrinsics.areEqual(this.iconImage, r101.iconImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconPrompt, r101.iconPrompt) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        OmniBotImage r100 = this.iconImage;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.iconPrompt;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OmniBotBaseIcon(iconImage=" + this.iconImage + ", iconPrompt=" + this.iconPrompt + ')';
    }

    public OmniBotBaseIcon(OmniBotImage r100, String r101) {
        this.iconImage = r100;
        this.iconPrompt = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniBotBaseIcon r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, OmniBotImage$$serializer.INSTANCE, r100.iconImage);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        r103 = true;
    L17:
        if (r103 == false) goto L20;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.iconPrompt);
        return;
    L20:
        return;
    L15:
        if (r100.iconPrompt == null) goto L17;
    L6:
        if (r100.iconImage != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniBotBaseIcon(int r100, OmniBotImage r101, String r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniBotBaseIcon$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.iconImage = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.iconPrompt = null;
        return;
    L11:
        this.iconPrompt = r102;
        return;
    L7:
        this.iconImage = r101;
        goto L9
    }

    public /* synthetic */ OmniBotBaseIcon(OmniBotImage r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
