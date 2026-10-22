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
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J&\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R&\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0017\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lcom/larus/im/bean/bot/CreationIdInfo;", "", "creationId", "", "creationCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCreationId$annotations", "()V", "getCreationId", "()Ljava/lang/String;", "setCreationId", "(Ljava/lang/String;)V", "getCreationCount$annotations", "getCreationCount", "()Ljava/lang/Integer;", "setCreationCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/im/bean/bot/CreationIdInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$imsdkkmp_api_release", "$serializer", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class CreationIdInfo {
    public static final b Companion = null;
    private Integer creationCount;
    private String creationId;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<CreationIdInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f346466a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f346467b = null;

        public a() {
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            return new d[]{kuc.a.d(v2.f520790a), kuc.a.d(w0.f520792a)};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f346467b;
        }

        static {
            a r100 = new a();
            f346466a = r100;
            g2 r101 = new g2("com.larus.im.bean.bot.CreationIdInfo", r100, 2);
            r101.j("creation_id", true);
            r101.j("creation_count", true);
            f346467b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f346467b;
            c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            String r101 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
            Integer r102 = (Integer) r111.decodeNullableSerializableElement(r100, 1, w0.f520792a, null);
            int r103 = 3;
        L17:
            r111.endStructure(r100);
            return new CreationIdInfo(r103, r101, r102, null);
        L5:
            r101 = null;
            Integer r104 = null;
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
            r104 = (Integer) r111.decodeNullableSerializableElement(r100, 1, w0.f520792a, r104);
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
            CreationIdInfo r102 = (CreationIdInfo) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f346467b;
            muc.d r104 = r100.beginStructure(r103);
            CreationIdInfo.write$Self$imsdkkmp_api_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final d<CreationIdInfo> serializer() {
            return a.f346466a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationIdInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CreationIdInfo copy$default(CreationIdInfo r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.creationId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.creationCount;
    L9:
        return r100.copy(r101, r102);
    }

    @SerialName("creation_count")
    public static /* synthetic */ void getCreationCount$annotations() {
    }

    @SerialName("creation_id")
    public static /* synthetic */ void getCreationId$annotations() {
    }

    public final String component1() {
        return this.creationId;
    }

    public final Integer component2() {
        return this.creationCount;
    }

    public final CreationIdInfo copy(String r100, Integer r101) {
        return new CreationIdInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationIdInfo) == true) goto L8;
        return false;
    L8:
        CreationIdInfo r101 = (CreationIdInfo) r100;
        if (Intrinsics.areEqual(this.creationId, r101.creationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationCount, r101.creationCount) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.creationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.creationCount;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationIdInfo(creationId=" + this.creationId + ", creationCount=" + this.creationCount + ')';
    }

    static {
        Companion = new b();
    }

    public final Integer getCreationCount() {
        return this.creationCount;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final void setCreationCount(Integer r100) {
        this.creationCount = r100;
    }

    public final void setCreationId(String r100) {
        this.creationId = r100;
    }

    public CreationIdInfo(String r100, Integer r101) {
        this.creationId = r100;
        this.creationCount = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$imsdkkmp_api_release(CreationIdInfo r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.creationId);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L14;
    L13:
        r103 = true;
    L20:
        if (r103 == false) goto L23;
        r101.encodeNullableSerializableElement(r102, 1, w0.f520792a, r100.creationCount);
        return;
    L23:
        return;
    L14:
        Integer r105 = r100.creationCount;
        if (r105 == null) goto L13;
        if (r105.intValue() == 0) goto L20;
    L6:
        if (Intrinsics.areEqual(r100.creationId, "") == false) goto L4;
        r104 = false;
        goto L9
    }

    public CreationIdInfo(int r100, String r101, Integer r102, q2 r103) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f346467b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = "";
    L7:
        this.creationId = r101;
        if ((r100 & 2) != 0) goto L10;
        this.creationCount = 0;
        return;
    L10:
        this.creationCount = r102;
    }

    public /* synthetic */ CreationIdInfo(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
