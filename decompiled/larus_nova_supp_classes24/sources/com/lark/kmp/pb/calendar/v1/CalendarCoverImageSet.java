package com.lark.kmp.pb.calendar.v1;

import com.lark.kmp.pb.basic.v1.Image;
import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarCoverImageSet;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarCoverImageSet$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarCoverImageSet$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "thumb", "Lcom/lark/kmp/pb/basic/v1/Image;", "getThumb", "()Lcom/lark/kmp/pb/basic/v1/Image;", "middle", "getMiddle", "origin", "getOrigin", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarCoverImageSet extends Message<CalendarCoverImageSet, a> {
    public static final ProtoAdapter<CalendarCoverImageSet> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String key;
    private final Image middle;
    private final Image origin;
    private final Image thumb;

    public static final class a extends Message.a<CalendarCoverImageSet, a> {
        public String d;
        public Image e;
        public Image f;
        public Image g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarCoverImageSet(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarCoverImageSet> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarCoverImageSet c(g0 r7) {
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
            r1.e = Image.ADAPTER.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = Image.ADAPTER.c(r7);
            goto L3
        L12:
            if (r4 != 4) goto L13;
            r1.g = Image.ADAPTER.c(r7);
            goto L3
        L13:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L19:
            return new CalendarCoverImageSet(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarCoverImageSet r5) {
            CalendarCoverImageSet r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getKey());
            ProtoAdapter<Image> r1 = Image.ADAPTER;
            return ((r0 + r1.l(2, r6.getThumb())) + r1.l(3, r6.getMiddle())) + r1.l(4, r6.getOrigin());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarCoverImageSet r5) {
            CalendarCoverImageSet r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getKey());
            ProtoAdapter<Image> r0 = Image.ADAPTER;
            r0.i(r4, 2, r6.getThumb());
            r0.i(r4, 3, r6.getMiddle());
            r0.i(r4, 4, r6.getOrigin());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CalendarCoverImageSet r5) {
            CalendarCoverImageSet r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter<Image> r0 = Image.ADAPTER;
            r0.j(r4, 4, r6.getOrigin());
            r0.j(r4, 3, r6.getMiddle());
            r0.j(r4, 2, r6.getThumb());
            ProtoAdapter.q.j(r4, 1, r6.getKey());
        }

        public b(FieldEncoding r7, KClass<CalendarCoverImageSet> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarCoverImageSet", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarCoverImageSet(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarCoverImageSet.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.key;
        r0.e = this.thumb;
        r0.f = this.middle;
        r0.g = this.origin;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarCoverImageSet.class).getSimpleName() + '@' + hashCode();
    }

    public final String getKey() {
        return this.key;
    }

    public final Image getMiddle() {
        return this.middle;
    }

    public final Image getOrigin() {
        return this.origin;
    }

    public final Image getThumb() {
        return this.thumb;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarCoverImageSet(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.key = r2.d;
        this.thumb = r2.e;
        this.middle = r2.f;
        this.origin = r2.g;
    }

    public /* synthetic */ CalendarCoverImageSet(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
