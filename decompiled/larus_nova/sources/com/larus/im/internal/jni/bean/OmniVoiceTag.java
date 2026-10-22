package com.larus.im.internal.jni.bean;

import com.bytedance.android.ec.core.event.a;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00060\u0001j\u0002`\u0002:\u0002$%B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u000f¨\u0006&"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniVoiceTag;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "tagId", "", "tagType", "tagValue", "", "<init>", "(IILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTagId$annotations", "()V", "getTagType$annotations", "getTagValue$annotations", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class OmniVoiceTag implements java.io.Serializable {
    public static final Companion Companion = null;
    public final int tagId;
    public final int tagType;
    public final String tagValue;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/OmniVoiceTag$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/OmniVoiceTag;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<OmniVoiceTag> serializer() {
            return OmniVoiceTag$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniVoiceTag() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ OmniVoiceTag copy$default(OmniVoiceTag r100, int r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.tagId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.tagType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tagValue;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("tag_id")
    public static /* synthetic */ void getTagId$annotations() {
    }

    @SerialName(a.KEY_TAG_TYPE)
    public static /* synthetic */ void getTagType$annotations() {
    }

    @SerialName("tag_value")
    public static /* synthetic */ void getTagValue$annotations() {
    }

    public final int component1() {
        return this.tagId;
    }

    public final int component2() {
        return this.tagType;
    }

    public final String component3() {
        return this.tagValue;
    }

    public final OmniVoiceTag copy(int r100, int r101, String r102) {
        return new OmniVoiceTag(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniVoiceTag) == true) goto L8;
        return false;
    L8:
        OmniVoiceTag r101 = (OmniVoiceTag) r100;
        if (this.tagId == r101.tagId) goto L12;
        return false;
    L12:
        if (this.tagType == r101.tagType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tagValue, r101.tagValue) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.tagId * 31) + this.tagType) * 31;
        String r101 = this.tagValue;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "OmniVoiceTag(tagId=" + this.tagId + ", tagType=" + this.tagType + ", tagValue=" + this.tagValue + ')';
    }

    public OmniVoiceTag(int r100, int r101, String r102) {
        this.tagId = r100;
        this.tagType = r101;
        this.tagValue = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(OmniVoiceTag r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeIntElement(r102, 0, r100.tagId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeIntElement(r102, 1, r100.tagType);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.tagValue);
        return;
    L29:
        return;
    L24:
        if (r100.tagValue == null) goto L26;
    L15:
        if (r100.tagType != 0) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.tagId != 0) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ OmniVoiceTag(int r100, int r101, int r102, String r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, OmniVoiceTag$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.tagId = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.tagType = 0;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.tagValue = null;
        return;
    L15:
        this.tagValue = r103;
        return;
    L11:
        this.tagType = r102;
        goto L13
    L7:
        this.tagId = r101;
        goto L9
    }

    public /* synthetic */ OmniVoiceTag(int r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
