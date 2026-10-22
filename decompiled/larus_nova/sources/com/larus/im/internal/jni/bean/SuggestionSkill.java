package com.larus.im.internal.jni.bean;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import de9.qc;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import sz1.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00060\u0001j\u0002`\u0002:\u0002,-B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBI\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J?\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u000fHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0014R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0014¨\u0006."}, d2 = {"Lcom/larus/im/internal/jni/bean/SuggestionSkill;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "name", "", "type", "Lcom/larus/im/internal/jni/bean/SkillType;", "lastUsedAtMs", "", "path", "isRecommend", "", "<init>", "(Ljava/lang/String;Lcom/larus/im/internal/jni/bean/SkillType;JLjava/lang/String;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/internal/jni/bean/SkillType;JLjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getType$annotations", "getLastUsedAtMs$annotations", "getPath$annotations", "isRecommend$annotations", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$omnisdk_release", "$serializer", "Companion", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class SuggestionSkill implements java.io.Serializable {
    private static final Lazy<d<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    public final boolean isRecommend;
    public final long lastUsedAtMs;
    public final String name;
    public final String path;
    public final SkillType type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/jni/bean/SuggestionSkill$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/larus/im/internal/jni/bean/SuggestionSkill;", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final d<SuggestionSkill> serializer() {
            return SuggestionSkill$$serializer.INSTANCE;
        }
    }

    public SuggestionSkill() {
        this(null, null, 0, null, false, 31, null);
    }

    private static final /* synthetic */ d _childSerializers$_anonymous_() {
        return SkillType.Companion.serializer();
    }

    public static /* synthetic */ d a() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ SuggestionSkill copy$default(SuggestionSkill r100, String r101, SkillType r102, long r103, String r104, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        SkillType r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.lastUsedAtMs;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.path;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.isRecommend;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    @SerialName("last_used_at_ms")
    public static /* synthetic */ void getLastUsedAtMs$annotations() {
    }

    @SerialName("name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("path")
    public static /* synthetic */ void getPath$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName(a.KEY_IS_RECOMMEND)
    public static /* synthetic */ void isRecommend$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final SkillType component2() {
        return this.type;
    }

    public final long component3() {
        return this.lastUsedAtMs;
    }

    public final String component4() {
        return this.path;
    }

    public final boolean component5() {
        return this.isRecommend;
    }

    public final SuggestionSkill copy(String r100, SkillType r110, long r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "type");
        return new SuggestionSkill(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SuggestionSkill) == true) goto L8;
        return false;
    L8:
        SuggestionSkill r101 = (SuggestionSkill) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (this.lastUsedAtMs == r101.lastUsedAtMs) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L21;
        return false;
    L21:
        if (this.isRecommend == r101.isRecommend) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.type.hashCode()) * 31;
        long r104 = this.lastUsedAtMs;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.path;
        if (r106 == null) goto L10;
        r101 = r106.hashCode();
    L10:
        int r107 = (r105 + r101) * 31;
        if (this.isRecommend == false) goto L13;
        int r108 = 1231;
    L15:
        return r107 + r108;
    L13:
        r108 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SuggestionSkill(name=" + this.name + ", type=" + this.type + ", lastUsedAtMs=" + this.lastUsedAtMs + ", path=" + this.path + ", isRecommend=" + this.isRecommend + ')';
    }

    static {
        Companion = new Companion(null);
        $childSerializers = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new qc()), null, null, null};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$omnisdk_release(SuggestionSkill r100, muc.d r101, f r110) {
        Lazy<d<Object>>[] r102 = $childSerializers;
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r110, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r110, 0, v2.f520790a, r100.name);
    L12:
        if (r101.shouldEncodeElementDefault(r110, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeSerializableElement(r110, 1, r102[1].getValue(), r100.type);
    L21:
        if (r101.shouldEncodeElementDefault(r110, 2) == false) goto L24;
    L22:
        boolean r106 = true;
    L27:
        if (r106 == false) goto L30;
        r101.encodeLongElement(r110, 2, r100.lastUsedAtMs);
    L30:
        if (r101.shouldEncodeElementDefault(r110, 3) == false) goto L33;
    L31:
        boolean r107 = true;
    L36:
        if (r107 == false) goto L39;
        r101.encodeNullableSerializableElement(r110, 3, v2.f520790a, r100.path);
    L39:
        if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L42;
    L40:
        r103 = true;
    L44:
        if (r103 == false) goto L47;
        r101.encodeBooleanElement(r110, 4, r100.isRecommend);
        return;
    L47:
        return;
    L42:
        if (r100.isRecommend == false) goto L44;
    L33:
        if (r100.path != null) goto L31;
        r107 = false;
        goto L36
    L24:
        if (r100.lastUsedAtMs != 0) goto L22;
        r106 = false;
        goto L27
    L15:
        if (r100.type != SkillType.SKILL_TYPE_NOT_USED) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.name != null) goto L4;
        r104 = false;
        goto L9
    }

    public SuggestionSkill(String r100, SkillType r101, long r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.name = r100;
        this.type = r101;
        this.lastUsedAtMs = r102;
        this.path = r103;
        this.isRecommend = r104;
    }

    public /* synthetic */ SuggestionSkill(int r100, String r101, SkillType r102, long r103, String r104, boolean r105, q2 r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, SuggestionSkill$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.name = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.type = SkillType.SKILL_TYPE_NOT_USED;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.lastUsedAtMs = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.path = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.isRecommend = false;
        return;
    L23:
        this.isRecommend = r105;
        return;
    L19:
        this.path = r104;
        goto L21
    L15:
        this.lastUsedAtMs = r103;
        goto L17
    L11:
        this.type = r102;
        goto L13
    L7:
        this.name = r101;
        goto L9
    }

    public /* synthetic */ SuggestionSkill(String r100, SkillType r101, long r102, String r103, boolean r110, int r111, DefaultConstructorMarker r112) {
        String r104 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        r101 = SkillType.SKILL_TYPE_NOT_USED;
    L9:
        SkillType r105 = r101;
        if ((r111 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        long r106 = r102;
        if ((r111 & 8) != 0) goto L17;
        r104 = r103;
    L17:
        if ((r111 & 16) == 0) goto L19;
        boolean r114 = false;
    L20:
        this(r113, r105, r106, r104, r114);
        return;
    L19:
        r114 = r110;
        goto L20
    L5:
        r113 = r100;
        goto L7
    }
}
