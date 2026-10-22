package com.larus.im.internal;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.internal.protocol.bean.MixedTokens;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lcom/larus/im/internal/TokenHolder;", "", "tokenV1", "", "tokenV2", "Lcom/larus/im/internal/protocol/bean/MixedTokens;", "<init>", "(Ljava/lang/String;Lcom/larus/im/internal/protocol/bean/MixedTokens;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/larus/im/internal/protocol/bean/MixedTokens;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTokenV1$annotations", "()V", "getTokenV1", "()Ljava/lang/String;", "getTokenV2$annotations", "getTokenV2", "()Lcom/larus/im/internal/protocol/bean/MixedTokens;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class TokenHolder {
    public static final b Companion = null;
    private final String tokenV1;
    private final MixedTokens tokenV2;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<TokenHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f347166a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f347167b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(v2.f520790a), kuc.a.d(MixedTokens.a.f349671a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f347167b;
        }

        static {
            a r100 = new a();
            f347166a = r100;
            g2 r101 = new g2("com.larus.im.internal.TokenHolder", r100, 2);
            r101.j("token", true);
            r101.j("mixed_token", true);
            f347167b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f347167b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            String r101 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            MixedTokens r102 = (MixedTokens) r111.decodeNullableSerializableElement(r100, 1, MixedTokens.a.f349671a, null);
            int r103 = 3;
        L17:
            r111.endStructure(r100);
            return new TokenHolder(r103, r101, r102, null);
        L5:
            r101 = null;
            MixedTokens r104 = null;
            int r105 = 0;
            boolean r106 = true;
        L6:
            if (r106 == false) goto L16;
            int r107 = r111.decodeElementIndex(r100);
            if (r107 != (-1)) goto L9;
            r106 = false;
            goto L6
        L9:
            if (r107 != 0) goto L10;
            r101 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r101);
            r105 = r105 | 1;
            goto L6
        L10:
            if (r107 != 1) goto L13;
            r104 = (MixedTokens) r111.decodeNullableSerializableElement(r100, 1, MixedTokens.a.f349671a, r104);
            r105 = r105 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r107);
        L16:
            r102 = r104;
            r103 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            TokenHolder r102 = (TokenHolder) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f347167b;
            muc.d r104 = r100.beginStructure(r103);
            TokenHolder.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<TokenHolder> serializer() {
            return a.f347166a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TokenHolder() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TokenHolder copy$default(TokenHolder r100, String r101, MixedTokens r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.tokenV1;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.tokenV2;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("token")
    public static /* synthetic */ void getTokenV1$annotations() {
    }

    @SerialName("mixed_token")
    public static /* synthetic */ void getTokenV2$annotations() {
    }

    public final String component1() {
        return this.tokenV1;
    }

    public final MixedTokens component2() {
        return this.tokenV2;
    }

    public final TokenHolder copy(String r100, MixedTokens r101) {
        return new TokenHolder(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TokenHolder) == true) goto L8;
        return false;
    L8:
        TokenHolder r101 = (TokenHolder) r100;
        if (Intrinsics.areEqual(this.tokenV1, r101.tokenV1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tokenV2, r101.tokenV2) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.tokenV1;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        MixedTokens r104 = this.tokenV2;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TokenHolder(tokenV1=" + this.tokenV1 + ", tokenV2=" + this.tokenV2 + ')';
    }

    static {
        Companion = new b();
    }

    public final String getTokenV1() {
        return this.tokenV1;
    }

    public final MixedTokens getTokenV2() {
        return this.tokenV2;
    }

    public TokenHolder(String r100, MixedTokens r101) {
        this.tokenV1 = r100;
        this.tokenV2 = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(TokenHolder r100, muc.d r101, luc.f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.tokenV1);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        r103 = true;
    L17:
        if (r103 == false) goto L20;
        r101.encodeNullableSerializableElement(r102, 1, MixedTokens.a.f349671a, r100.tokenV2);
        return;
    L20:
        return;
    L15:
        if (r100.tokenV2 == null) goto L17;
    L6:
        if (r100.tokenV1 != null) goto L4;
        r104 = false;
        goto L9
    }

    public TokenHolder(int r100, String r101, MixedTokens r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f347167b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.tokenV1 = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.tokenV2 = null;
        return;
    L11:
        this.tokenV2 = r102;
        return;
    L7:
        this.tokenV1 = r101;
        goto L9
    }

    public /* synthetic */ TokenHolder(String r100, MixedTokens r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
