package com.larus.im.bean.bot;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00060\u0001j\u0002`\u0002:\u0002()B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006*"}, d2 = {"Lcom/larus/im/bean/bot/BotConfItem;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "confGroupKey", "", "confKey", "confValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getConfGroupKey$annotations", "()V", "getConfGroupKey", "()Ljava/lang/String;", "getConfKey$annotations", "getConfKey", "getConfValue$annotations", "getConfValue", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class BotConfItem implements java.io.Serializable {
    public static final b Companion = null;
    private final String confGroupKey;
    private final String confKey;
    private final String confValue;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<BotConfItem> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346427a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346428b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346428b;
        }

        static {
            a r100 = new a();
            f346427a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.BotConfItem", r100, 3);
            r101.j("conf_group_key", true);
            r101.j("conf_key", true);
            r101.j("conf_value", true);
            f346428b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346428b;
            c r101 = r110.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            String r112 = r104;
            String r113 = r105;
            int r114 = 7;
        L19:
            r101.endStructure(r100);
            return new BotConfItem(r114, r112, r113, r111, null);
        L5:
            String r106 = null;
            String r107 = null;
            int r108 = 0;
            boolean r109 = true;
        L6:
            if (r109 == false) goto L18;
            int r115 = r101.decodeElementIndex(r100);
            if (r115 != (-1)) goto L9;
            r109 = false;
            goto L6
        L9:
            if (r115 != 0) goto L10;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r115 != 1) goto L11;
            r106 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r115 != 2) goto L14;
            r107 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r107);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r115);
        L18:
            r114 = r108;
            r112 = r102;
            r113 = r106;
            r111 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            BotConfItem r102 = (BotConfItem) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346428b;
            muc.d r104 = r100.beginStructure(r103);
            BotConfItem.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<BotConfItem> serializer() {
            return a.f346427a;
        }
    }

    public BotConfItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ BotConfItem copy$default(BotConfItem r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.confGroupKey;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.confKey;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.confValue;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("conf_group_key")
    public static /* synthetic */ void getConfGroupKey$annotations() {
    }

    @SerialName("conf_key")
    public static /* synthetic */ void getConfKey$annotations() {
    }

    @SerialName("conf_value")
    public static /* synthetic */ void getConfValue$annotations() {
    }

    public final String component1() {
        return this.confGroupKey;
    }

    public final String component2() {
        return this.confKey;
    }

    public final String component3() {
        return this.confValue;
    }

    public final BotConfItem copy(String r100, String r101, String r102) {
        return new BotConfItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotConfItem) == true) goto L8;
        return false;
    L8:
        BotConfItem r101 = (BotConfItem) r100;
        if (Intrinsics.areEqual(this.confGroupKey, r101.confGroupKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.confKey, r101.confKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.confValue, r101.confValue) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.confGroupKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.confKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.confValue;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BotConfItem(confGroupKey=" + this.confGroupKey + ", confKey=" + this.confKey + ", confValue=" + this.confValue + ')';
    }

    static {
        Companion = new b();
    }

    public final String getConfGroupKey() {
        return this.confGroupKey;
    }

    public final String getConfKey() {
        return this.confKey;
    }

    public final String getConfValue() {
        return this.confValue;
    }

    public BotConfItem(String r100, String r101, String r102) {
        this.confGroupKey = r100;
        this.confKey = r101;
        this.confValue = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(BotConfItem r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.confGroupKey);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.confKey);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.confValue);
        return;
    L29:
        return;
    L24:
        if (r100.confValue == null) goto L26;
    L15:
        if (r100.confKey != null) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.confGroupKey != null) goto L4;
        r104 = false;
        goto L9
    }

    public BotConfItem(int r100, String r101, String r102, String r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346428b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.confGroupKey = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.confKey = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.confValue = null;
        return;
    L15:
        this.confValue = r103;
        return;
    L11:
        this.confKey = r102;
        goto L13
    L7:
        this.confGroupKey = r101;
        goto L9
    }

    public /* synthetic */ BotConfItem(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
