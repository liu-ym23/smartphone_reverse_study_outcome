package com.larus.im.depend;

import android.os.SystemClock;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.q2;
import nuc.v2;
import nuc.w0;
import ouc.d0;

/* JADX INFO: loaded from: classes29.dex */
public interface ISDKPointCallback {

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fBE\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lcom/larus/im/depend/ISDKPointCallback$EndMsg;", "", "id", "", "contentType", "", "status", "hasSuggest", "", "curTime", "", "<init>", "(Ljava/lang/String;IIZJ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IIZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getContentType", "()I", "getStatus", "getHasSuggest", "()Z", "getCurTime", "()J", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    public static final class EndMsg {
        public static final b Companion = null;
        private final int contentType;
        private final long curTime;
        private final boolean hasSuggest;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f347136id;
        private final int status;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements m0<EndMsg> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f347137a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f347138b = null;

            public a() {
            }

            @Override // nuc.m0
            public final d<?>[] childSerializers() {
                w0 r100 = w0.f520792a;
                return new d[]{v2.f520790a, r100, r100, i.f520705a, g1.f520681a};
            }

            @Override // juc.d, juc.n, juc.c
            public final f getDescriptor() {
                return f347138b;
            }

            static {
                a r100 = new a();
                f347137a = r100;
                g2 r101 = new g2("com.larus.im.depend.ISDKPointCallback.EndMsg", r100, 5);
                r101.j("id", false);
                r101.j("contentType", false);
                r101.j("status", false);
                r101.j("hasSuggest", false);
                r101.j("curTime", true);
                f347138b = r101;
            }

            @Override // nuc.m0
            public final d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f347138b;
                c r101 = r210.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                String r102 = r101.decodeStringElement(r100, 0);
                int r103 = r101.decodeIntElement(r100, 1);
                int r104 = r101.decodeIntElement(r100, 2);
                String r110 = r102;
                int r111 = r104;
                int r112 = r103;
                boolean r211 = r101.decodeBooleanElement(r100, 3);
                long r212 = r101.decodeLongElement(r100, 4);
                int r113 = 31;
            L24:
                r101.endStructure(r100);
                return new EndMsg(r113, r110, r112, r111, r211, r212, null);
            L5:
                String r105 = null;
                long r114 = 0;
                int r106 = 0;
                int r107 = 0;
                int r115 = 0;
                boolean r116 = false;
                boolean r117 = true;
            L6:
                if (r117 == false) goto L23;
                int r118 = r101.decodeElementIndex(r100);
                if (r118 != (-1)) goto L9;
                r117 = false;
                goto L6
            L9:
                if (r118 != 0) goto L10;
                r105 = r101.decodeStringElement(r100, 0);
                r107 = r107 | 1;
                goto L6
            L10:
                if (r118 == 1) goto L19;
                if (r118 == 2) goto L18;
                if (r118 == 3) goto L17;
                if (r118 != 4) goto L16;
                r114 = r101.decodeLongElement(r100, 4);
                int r108 = r107 | 16;
            L20:
                r107 = r108;
                goto L6
            L16:
                throw new UnknownFieldException(r118);
            L17:
                r116 = r101.decodeBooleanElement(r100, 3);
                r108 = r107 | 8;
                goto L20
            L18:
                r106 = r101.decodeIntElement(r100, 2);
                r108 = r107 | 4;
                goto L20
            L19:
                r115 = r101.decodeIntElement(r100, 1);
                r108 = r107 | 2;
                goto L20
            L23:
                r110 = r105;
                r111 = r106;
                r113 = r107;
                r112 = r115;
                r211 = r116;
                r212 = r114;
                goto L24
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                EndMsg r102 = (EndMsg) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f347138b;
                muc.d r104 = r100.beginStructure(r103);
                EndMsg.write$Self$core_release(r102, r104, r103);
                r104.endStructure(r103);
            }
        }

        public static final class b {
            public b() {
            }

            public final d<EndMsg> serializer() {
                return a.f347137a;
            }
        }

        public static /* synthetic */ EndMsg copy$default(EndMsg r100, String r101, int r102, int r103, boolean r104, long r105, int r110, Object r111) {
            if ((r110 & 1) == 0) goto L6;
            r101 = r100.f347136id;
        L6:
            if ((r110 & 2) == 0) goto L8;
            r102 = r100.contentType;
        L8:
            int r112 = r102;
            if ((r110 & 4) == 0) goto L11;
            r103 = r100.status;
        L11:
            int r106 = r103;
            if ((r110 & 8) == 0) goto L14;
            r104 = r100.hasSuggest;
        L14:
            boolean r107 = r104;
            if ((r110 & 16) == 0) goto L17;
            r105 = r100.curTime;
        L17:
            String r108 = r101;
            return r100.copy(r108, r112, r106, r107, r105);
        }

        public final String component1() {
            return this.f347136id;
        }

        public final int component2() {
            return this.contentType;
        }

        public final int component3() {
            return this.status;
        }

        public final boolean component4() {
            return this.hasSuggest;
        }

        public final long component5() {
            return this.curTime;
        }

        public final EndMsg copy(String r100, int r110, int r111, boolean r112, long r113) {
            Intrinsics.checkNotNullParameter(r100, "id");
            return new EndMsg(r100, r110, r111, r112, r113);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof EndMsg) == true) goto L8;
            return false;
        L8:
            EndMsg r101 = (EndMsg) r100;
            if (Intrinsics.areEqual(this.f347136id, r101.f347136id) == true) goto L12;
            return false;
        L12:
            if (this.contentType == r101.contentType) goto L15;
            return false;
        L15:
            if (this.status == r101.status) goto L18;
            return false;
        L18:
            if (this.hasSuggest == r101.hasSuggest) goto L21;
            return false;
        L21:
            if (this.curTime == r101.curTime) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r100 = ((((this.f347136id.hashCode() * 31) + this.contentType) * 31) + this.status) * 31;
            if (this.hasSuggest == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            long r103 = this.curTime;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        L5:
            r101 = 1237;
            goto L6
        }

        static {
            Companion = new b();
        }

        public String toString() {
            return "id=" + this.f347136id + ",contentType=" + this.contentType + ",status=" + this.status + ",hasSuggest=" + this.hasSuggest;
        }

        public final int getContentType() {
            return this.contentType;
        }

        public final long getCurTime() {
            return this.curTime;
        }

        public final boolean getHasSuggest() {
            return this.hasSuggest;
        }

        public final String getId() {
            return this.f347136id;
        }

        public final int getStatus() {
            return this.status;
        }

        @JvmStatic
        public static final void write$Self$core_release(EndMsg r100, muc.d r101, f r110) {
            boolean r102 = false;
            r101.encodeStringElement(r110, 0, r100.f347136id);
            r101.encodeIntElement(r110, 1, r100.contentType);
            r101.encodeIntElement(r110, 2, r100.status);
            r101.encodeBooleanElement(r110, 3, r100.hasSuggest);
            if (r101.shouldEncodeElementDefault(r110, 4) == false) goto L6;
        L4:
            r102 = true;
        L8:
            if (r102 == false) goto L11;
            r101.encodeLongElement(r110, 4, r100.curTime);
            return;
        L11:
            return;
        L6:
            if (r100.curTime == SystemClock.elapsedRealtime()) goto L8;
            goto L8
        }

        public EndMsg(String r100, int r101, int r102, boolean r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "id");
            this.f347136id = r100;
            this.contentType = r101;
            this.status = r102;
            this.hasSuggest = r103;
            this.curTime = r104;
        }

        public EndMsg(int r100, String r101, int r102, int r103, boolean r104, long r105, q2 r106) {
            if (15 != (r100 & 15)) goto L9;
            this.f347136id = r101;
            this.contentType = r102;
            this.status = r103;
            this.hasSuggest = r104;
            if ((r100 & 16) != 0) goto L7;
            this.curTime = SystemClock.elapsedRealtime();
            return;
        L7:
            this.curTime = r105;
            return;
        L9:
            b2.b(r100, 15, a.f347138b);
            throw null;
        }

        public EndMsg(String r100, int r101, int r110, boolean r111, long r112, int r113, DefaultConstructorMarker r114) {
            if ((r113 & 16) == 0) goto L5;
            r112 = SystemClock.elapsedRealtime();
        L5:
            this(r100, r101, r110, r111, r112);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f347139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f347140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f347141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f347142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final d0 f347143e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f347139a, r101.f347139a) == true) goto L12;
            return false;
        L12:
            if (this.f347140b == r101.f347140b) goto L15;
            return false;
        L15:
            if (this.f347141c == r101.f347141c) goto L18;
            return false;
        L18:
            if (this.f347142d == r101.f347142d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f347143e, r101.f347143e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f347139a.hashCode() * 31) + this.f347140b) * 31) + this.f347141c) * 31;
            long r101 = this.f347142d;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            d0 r103 = this.f347143e;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "FirstPackageMsg(id=" + this.f347139a + ", contentType=" + this.f347140b + ", status=" + this.f347141c + ", curTime=" + this.f347142d + ", params=" + this.f347143e + ')';
        }

        public a(String r100, int r101, int r102, long r103, d0 r104) {
            Intrinsics.checkNotNullParameter(r100, "id");
            this.f347139a = r100;
            this.f347140b = r101;
            this.f347141c = r102;
            this.f347142d = r103;
            this.f347143e = r104;
        }
    }

    void a(String r100);

    void b(String r100, String r101);

    void c(String r100, a r101, long r102);

    void d(String r100, EndMsg r101);

    void e(String r100, String r101, Map<String, String> r102);

    void onReportEvent(String r100, String r101, String r102);
}
