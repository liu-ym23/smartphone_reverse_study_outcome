package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.f;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarLocation;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarLocation$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarLocation$Builder;Lokio/ByteString;)V", "location", "", "getLocation", "()Ljava/lang/String;", "address", "getAddress", "latitude", "", "getLatitude", "()Ljava/lang/Float;", "Ljava/lang/Float;", "longitude", "getLongitude", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarLocation extends Message<CalendarLocation, a> {
    public static final ProtoAdapter<CalendarLocation> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_ADDRESS = "";
    public static final float DEFAULT_LATITUDE = 360.0f;
    public static final String DEFAULT_LOCATION = "";
    public static final float DEFAULT_LONGITUDE = 360.0f;
    private static final long serialVersionUID = 0;
    private final String address;
    private final Float latitude;
    private final String location;
    private final Float longitude;

    public static final class a extends Message.a<CalendarLocation, a> {
        public String d;
        public String e;
        public Float f;
        public Float g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarLocation(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarLocation> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarLocation c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.e = r7.i();
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = (Float) ProtoAdapter.n.c(r7);
            goto L3
        L12:
            if (r4 != 4) goto L13;
            r1.g = (Float) ProtoAdapter.n.c(r7);
            goto L3
        L13:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L19:
            return new CalendarLocation(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarLocation r5) {
            CalendarLocation r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.l(1, r6.getLocation())) + r1.l(2, r6.getAddress());
            f r3 = ProtoAdapter.n;
            return (r2 + r3.l(3, r6.getLatitude())) + r3.l(4, r6.getLongitude());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarLocation r5) {
            CalendarLocation r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getLocation());
            r0.i(r4, 2, r6.getAddress());
            f r1 = ProtoAdapter.n;
            r1.i(r4, 3, r6.getLatitude());
            r1.i(r4, 4, r6.getLongitude());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CalendarLocation r5) {
            CalendarLocation r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            f r0 = ProtoAdapter.n;
            r0.j(r4, 4, r6.getLongitude());
            r0.j(r4, 3, r6.getLatitude());
            w r1 = ProtoAdapter.q;
            r1.j(r4, 2, r6.getAddress());
            r1.j(r4, 1, r6.getLocation());
        }

        public b(FieldEncoding r7, KClass<CalendarLocation> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarLocation", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarLocation(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarLocation.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.location;
        r0.e = this.address;
        r0.f = this.latitude;
        r0.g = this.longitude;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarLocation.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAddress() {
        return this.address;
    }

    public final Float getLatitude() {
        return this.latitude;
    }

    public final String getLocation() {
        return this.location;
    }

    public final Float getLongitude() {
        return this.longitude;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarLocation(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.location = r2.d;
        this.address = r2.e;
        this.latitude = r2.f;
        this.longitude = r2.g;
    }

    public /* synthetic */ CalendarLocation(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
