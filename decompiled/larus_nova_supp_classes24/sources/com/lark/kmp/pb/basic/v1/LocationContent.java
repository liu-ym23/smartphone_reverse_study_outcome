package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001d\u0010\u001f¨\u0006%"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/LocationContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/LocationContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/LocationContent$Builder;Lokio/ByteString;)V", "longitude", "", "getLongitude", "()Ljava/lang/String;", "latitude", "getLatitude", "zoom_level", "", "getZoom_level", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "image", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getImage", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "vendor", "getVendor", "location", "Lcom/lark/kmp/pb/basic/v1/Location;", "getLocation", "()Lcom/lark/kmp/pb/basic/v1/Location;", "is_internal", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class LocationContent extends com.lark.wire.Message<LocationContent, a> {
    public static final ProtoAdapter<LocationContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ImageSet image;
    private final Boolean is_internal;
    private final String latitude;
    private final Location location;
    private final String longitude;
    private final String vendor;
    private final Integer zoom_level;

    public static final class a extends com.lark.wire.Message.a<LocationContent, a> {
        public String d;
        public String e;
        public Integer f;
        public ImageSet g;
        public String h;
        public Location i;
        public Boolean j;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new LocationContent(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<LocationContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final LocationContent c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L15;
            switch(r4) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r1.j = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L8:
            r1.i = Location.ADAPTER.c(r7);
            goto L3
        L9:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.h = r7.i();
            goto L3
        L10:
            r1.g = ImageSet.ADAPTER.c(r7);
            goto L3
        L11:
            r1.f = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r5 = r7.i();
            Intrinsics.checkNotNullParameter(r5, "latitude");
            r1.e = r5;
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r6 = r7.i();
            Intrinsics.checkNotNullParameter(r6, "longitude");
            r1.d = r6;
            goto L3
        L6:
            r7.j(r4);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L15:
            return new LocationContent(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(LocationContent r6) {
            LocationContent r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((((((r0 + r1.l(1, r7.getLongitude())) + r1.l(2, r7.getLatitude())) + ProtoAdapter.h.l(3, r7.getZoom_level())) + ImageSet.ADAPTER.l(4, r7.getImage())) + r1.l(5, r7.getVendor())) + Location.ADAPTER.l(6, r7.getLocation())) + ProtoAdapter.g.l(7, r7.is_internal());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, LocationContent r6) {
            LocationContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getLongitude());
            r0.i(r5, 2, r7.getLatitude());
            ProtoAdapter.h.i(r5, 3, r7.getZoom_level());
            ImageSet.ADAPTER.i(r5, 4, r7.getImage());
            r0.i(r5, 5, r7.getVendor());
            Location.ADAPTER.i(r5, 6, r7.getLocation());
            ProtoAdapter.g.i(r5, 7, r7.is_internal());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, LocationContent r6) {
            LocationContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter.g.j(r5, 7, r7.is_internal());
            Location.ADAPTER.j(r5, 6, r7.getLocation());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 5, r7.getVendor());
            ImageSet.ADAPTER.j(r5, 4, r7.getImage());
            ProtoAdapter.h.j(r5, 3, r7.getZoom_level());
            r0.j(r5, 2, r7.getLatitude());
            r0.j(r5, 1, r7.getLongitude());
        }

        public b(FieldEncoding r7, KClass<LocationContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.LocationContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ LocationContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LocationContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.longitude;
        r0.e = this.latitude;
        r0.f = this.zoom_level;
        r0.g = this.image;
        r0.h = this.vendor;
        r0.i = this.location;
        r0.j = this.is_internal;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(LocationContent.class).getSimpleName() + '@' + hashCode();
    }

    public final ImageSet getImage() {
        return this.image;
    }

    public final String getLatitude() {
        return this.latitude;
    }

    public final Location getLocation() {
        return this.location;
    }

    public final String getLongitude() {
        return this.longitude;
    }

    public final String getVendor() {
        return this.vendor;
    }

    public final Integer getZoom_level() {
        return this.zoom_level;
    }

    public final Boolean is_internal() {
        return this.is_internal;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public LocationContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.longitude = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.latitude = r5;
        this.zoom_level = r2.f;
        this.image = r2.g;
        this.vendor = r2.h;
        this.location = r2.i;
        this.is_internal = r2.j;
    }

    public /* synthetic */ LocationContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
