package com.larus.im.bean.bot;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import uc9.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00060\u0001j\u0002`\u0002:\u0002-.B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0003J8\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\fHÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/larus/im/bean/bot/FirstMet;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "prologue", "", "suggestSwitch", "", "suggests", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPrologue$annotations", "()V", "getPrologue", "()Ljava/lang/String;", "getSuggestSwitch$annotations", "getSuggestSwitch", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSuggests$annotations", "getSuggests", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/larus/im/bean/bot/FirstMet;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class FirstMet implements java.io.Serializable {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<d<Object>>[] f346468a = null;
    private final String prologue;
    private final Boolean suggestSwitch;

    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> suggests;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<FirstMet> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346469a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346470b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346470b;
        }

        static {
            a r100 = new a();
            f346469a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.FirstMet", r100, 3);
            r101.j("prologue", true);
            r101.j("suggest_switch", true);
            r101.j("suggests", true);
            f346470b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(v2.f520790a), kuc.a.d(i.f520705a), kuc.a.d((d) FirstMet.access$get$childSerializers$cp()[2].getValue())};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346470b;
            c r101 = r110.beginStructure(r100);
            Lazy[] r102 = FirstMet.access$get$childSerializers$cp();
            String r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            Boolean r105 = (Boolean) r101.decodeNullableSerializableElement(r100, 1, i.f520705a, null);
            List r111 = (List) r101.decodeNullableSerializableElement(r100, 2, (juc.c) r102[2].getValue(), null);
            String r112 = r104;
            Boolean r113 = r105;
            int r114 = 7;
        L19:
            r101.endStructure(r100);
            return new FirstMet(r114, r112, r113, r111, null);
        L5:
            Boolean r106 = null;
            List r107 = null;
            int r108 = 0;
            boolean r115 = true;
        L6:
            if (r115 == false) goto L18;
            int r116 = r101.decodeElementIndex(r100);
            if (r116 != (-1)) goto L9;
            r115 = false;
            goto L6
        L9:
            if (r116 != 0) goto L10;
            r103 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r103);
            r108 = r108 | 1;
            goto L6
        L10:
            if (r116 != 1) goto L11;
            r106 = (Boolean) r101.decodeNullableSerializableElement(r100, 1, i.f520705a, r106);
            r108 = r108 | 2;
            goto L6
        L11:
            if (r116 != 2) goto L14;
            r107 = (List) r101.decodeNullableSerializableElement(r100, 2, (juc.c) r102[2].getValue(), r107);
            r108 = r108 | 4;
            goto L6
        L14:
            throw new UnknownFieldException(r116);
        L18:
            r114 = r108;
            r112 = r103;
            r113 = r106;
            r111 = r107;
            goto L19
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            FirstMet r102 = (FirstMet) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346470b;
            muc.d r104 = r100.beginStructure(r103);
            FirstMet.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<FirstMet> serializer() {
            return a.f346469a;
        }
    }

    public FirstMet() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FirstMet copy$default(FirstMet r100, String r101, Boolean r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.prologue;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.suggestSwitch;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.suggests;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("prologue")
    public static /* synthetic */ void getPrologue$annotations() {
    }

    @SerialName("suggest_switch")
    public static /* synthetic */ void getSuggestSwitch$annotations() {
    }

    @SerialName("suggests")
    public static /* synthetic */ void getSuggests$annotations() {
    }

    public final String component1() {
        return this.prologue;
    }

    public final Boolean component2() {
        return this.suggestSwitch;
    }

    public final List<String> component3() {
        return this.suggests;
    }

    public final FirstMet copy(String r100, Boolean r101, List<String> r102) {
        return new FirstMet(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FirstMet) == true) goto L8;
        return false;
    L8:
        FirstMet r101 = (FirstMet) r100;
        if (Intrinsics.areEqual(this.prologue, r101.prologue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.suggestSwitch, r101.suggestSwitch) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.suggests, r101.suggests) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.prologue;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.suggestSwitch;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.suggests;
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
        return "FirstMet(prologue=" + this.prologue + ", suggestSwitch=" + this.suggestSwitch + ", suggests=" + this.suggests + ')';
    }

    static {
        Companion = new b();
        f346468a = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new x())};
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return f346468a;
    }

    public final String getPrologue() {
        return this.prologue;
    }

    public final Boolean getSuggestSwitch() {
        return this.suggestSwitch;
    }

    public final List<String> getSuggests() {
        return this.suggests;
    }

    public FirstMet(String r100, Boolean r101, List<String> r102) {
        this.prologue = r100;
        this.suggestSwitch = r101;
        this.suggests = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(FirstMet r100, muc.d r101, f r102) {
        Lazy<d<Object>>[] r103 = f346468a;
        boolean r104 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.prologue);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L21;
        r101.encodeNullableSerializableElement(r102, 1, i.f520705a, r100.suggestSwitch);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r104 = true;
    L26:
        if (r104 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, r103[2].getValue(), r100.suggests);
        return;
    L29:
        return;
    L24:
        if (r100.suggests == null) goto L26;
    L15:
        if (r100.suggestSwitch != null) goto L13;
        r106 = false;
        goto L18
    L6:
        if (r100.prologue != null) goto L4;
        r105 = false;
        goto L9
    }

    public FirstMet(int r100, String r101, Boolean r102, List r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346470b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.prologue = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.suggestSwitch = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.suggests = null;
        return;
    L15:
        this.suggests = r103;
        return;
    L11:
        this.suggestSwitch = r102;
        goto L13
    L7:
        this.prologue = r101;
        goto L9
    }

    public /* synthetic */ FirstMet(String r100, Boolean r101, List r102, int r103, DefaultConstructorMarker r104) {
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
