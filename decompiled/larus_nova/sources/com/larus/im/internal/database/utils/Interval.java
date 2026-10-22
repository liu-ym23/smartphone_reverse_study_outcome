package com.larus.im.internal.database.utils;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.q2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\""}, d2 = {"Lcom/larus/im/internal/database/utils/Interval;", "", "minIndex", "", "maxIndex", "<init>", "(JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMinIndex", "()J", "getMaxIndex", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_release", "$serializer", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class Interval {
    public static final b Companion = null;
    private final long maxIndex;
    private final long minIndex;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<Interval> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f348150a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f348151b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            g1 r100 = g1.f520681a;
            return new juc.d[]{r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f348151b;
        }

        static {
            a r100 = new a();
            f348150a = r100;
            g2 r101 = new g2("com.larus.im.internal.database.utils.Interval", r100, 2);
            r101.j("minIndex", false);
            r101.j("maxIndex", false);
            f348151b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f348151b;
            muc.c r101 = r110.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            long r111 = r101.decodeLongElement(r100, 0);
            long r112 = r101.decodeLongElement(r100, 1);
            int r113 = 3;
        L17:
            r101.endStructure(r100);
            return new Interval(r113, r111, r112, null);
        L5:
            long r102 = 0;
            long r103 = 0;
            int r104 = 0;
            boolean r105 = true;
        L6:
            if (r105 == false) goto L16;
            int r114 = r101.decodeElementIndex(r100);
            if (r114 != (-1)) goto L9;
            r105 = false;
            goto L6
        L9:
            if (r114 != 0) goto L10;
            r102 = r101.decodeLongElement(r100, 0);
            r104 = r104 | 1;
            goto L6
        L10:
            if (r114 != 1) goto L13;
            r103 = r101.decodeLongElement(r100, 1);
            r104 = r104 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r114);
        L16:
            r113 = r104;
            r111 = r102;
            r112 = r103;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            Interval r102 = (Interval) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f348151b;
            muc.d r104 = r100.beginStructure(r103);
            Interval.write$Self$core_release(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<Interval> serializer() {
            return a.f348150a;
        }
    }

    public static /* synthetic */ Interval copy$default(Interval r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.minIndex;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.maxIndex;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.minIndex;
    }

    public final long component2() {
        return this.maxIndex;
    }

    public final Interval copy(long r100, long r101) {
        return new Interval(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Interval) == true) goto L8;
        return false;
    L8:
        Interval r101 = (Interval) r100;
        if (this.minIndex == r101.minIndex) goto L12;
        return false;
    L12:
        if (this.maxIndex == r101.maxIndex) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.minIndex;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.maxIndex;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "Interval(minIndex=" + this.minIndex + ", maxIndex=" + this.maxIndex + ')';
    }

    static {
        Companion = new b();
    }

    public final long getMaxIndex() {
        return this.maxIndex;
    }

    public final long getMinIndex() {
        return this.minIndex;
    }

    public Interval(long r100, long r101) {
        this.minIndex = r100;
        this.maxIndex = r101;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_release(Interval r100, muc.d r101, luc.f r102) {
        r101.encodeLongElement(r102, 0, r100.minIndex);
        r101.encodeLongElement(r102, 1, r100.maxIndex);
    }

    public Interval(int r100, long r101, long r102, q2 r103) {
        if (3 != (r100 & 3)) goto L6;
        this.minIndex = r101;
        this.maxIndex = r102;
        return;
    L6:
        b2.b(r100, 3, a.f348151b);
        throw null;
    }
}
