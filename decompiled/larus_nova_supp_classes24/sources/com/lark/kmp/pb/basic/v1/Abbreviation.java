package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Abbreviation;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Abbreviation$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Abbreviation$Builder;Lokio/ByteString;)V", "abbr_element_ref", "", "", "Lcom/lark/kmp/pb/basic/v1/Abbreviation$Abbrs;", "getAbbr_element_ref", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "entity", "Abbrs", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Abbreviation extends com.lark.wire.Message<Abbreviation, a> {
    public static final ProtoAdapter<Abbreviation> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final Map<String, Abbrs> abbr_element_ref;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Abbreviation$Abbrs;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Abbreviation$Abbrs$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Abbreviation$Abbrs$Builder;Lokio/ByteString;)V", "abbrs", "", "Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity;", "getAbbrs", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Abbrs extends com.lark.wire.Message<Abbrs, a> {
        public static final ProtoAdapter<Abbrs> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<entity> abbrs;

        public static final class a extends com.lark.wire.Message.a<Abbrs, a> {
            public List<entity> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Abbrs(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<Abbrs> {
            @Override // com.lark.wire.ProtoAdapter
            public final Abbrs c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r0 = new a();
                ArrayList r1 = new ArrayList();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L9;
                if (r4 == 1) goto L7;
                r7.j(r4);
                goto L3
            L7:
                r1.add(entity.ADAPTER.c(r7));
                goto L3
            L9:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "abbrs");
                com.lark.wire.internal.a.a(r1);
                r0.d = r1;
                return new Abbrs(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Abbrs r4) {
                Abbrs r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + entity.ADAPTER.a().l(1, r5.getAbbrs());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Abbrs r5) {
                Abbrs r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                entity.ADAPTER.a().i(r4, 1, r6.getAbbrs());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, Abbrs r4) {
                Abbrs r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                entity.ADAPTER.a().j(r3, 1, r5.getAbbrs());
            }

            public b(FieldEncoding r7, KClass<Abbrs> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Abbreviation.Abbrs", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Abbrs(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Abbrs.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.abbrs;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Abbrs.class).getSimpleName() + '@' + hashCode();
        }

        public final List<entity> getAbbrs() {
            return this.abbrs;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Abbrs(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.abbrs = com.lark.wire.internal.a.c("abbrs", r2.d);
        }

        public /* synthetic */ Abbrs(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<Abbreviation, a> {
        public Map<String, Abbrs> d;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Abbreviation(this, c(), null);
        }

        public a() {
            this.d = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity$Builder;Lokio/ByteString;)V", "abbr_id", "", "getAbbr_id", "()Ljava/lang/String;", "abbr_version", "", "getAbbr_version", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "abbr_type", "Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity$Type;", "getAbbr_type", "()Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity$Type;", "datetime", "Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity$DatetimeEntity;", "getDatetime", "()Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity$DatetimeEntity;", "newBuilder", "toString", "Builder", "Companion", "Type", "DatetimeEntity", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class entity extends com.lark.wire.Message<entity, a> {
        public static final ProtoAdapter<entity> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String abbr_id;
        private final Type abbr_type;
        private final Integer abbr_version;
        private final DatetimeEntity datetime;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity$DatetimeEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity$DatetimeEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity$DatetimeEntity$Builder;Lokio/ByteString;)V", "start", "", "getStart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "end", "getEnd", "duration", "", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "grain", "", "getGrain", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class DatetimeEntity extends com.lark.wire.Message<DatetimeEntity, a> {
            public static final ProtoAdapter<DatetimeEntity> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final Integer duration;
            private final Long end;
            private final String grain;
            private final Long start;

            public static final class a extends com.lark.wire.Message.a<DatetimeEntity, a> {
                public Long d;
                public Long e;
                public Integer f;
                public String g;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new DatetimeEntity(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<DatetimeEntity> {
                @Override // com.lark.wire.ProtoAdapter
                public final DatetimeEntity c(g0 r7) {
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    a r1 = new a();
                    long r2 = r7.c();
                L3:
                    int r4 = r7.e();
                    if (r4 == (-1)) goto L19;
                    if (r4 != 1) goto L8;
                    r1.d = (Long) ProtoAdapter.k.c(r7);
                    goto L3
                L8:
                    if (r4 != 2) goto L10;
                    r1.e = (Long) ProtoAdapter.k.c(r7);
                    goto L3
                L10:
                    if (r4 != 3) goto L12;
                    r1.f = (Integer) ProtoAdapter.h.c(r7);
                    goto L3
                L12:
                    if (r4 != 4) goto L13;
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r7, "reader");
                    r1.g = r7.i();
                    goto L3
                L13:
                    r7.j(r4);
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L19:
                    return new DatetimeEntity(r1, r7.d(r2), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(DatetimeEntity r5) {
                    DatetimeEntity r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = r6.unknownFields().size();
                    t r1 = ProtoAdapter.k;
                    return (((r0 + r1.l(1, r6.getStart())) + r1.l(2, r6.getEnd())) + ProtoAdapter.h.l(3, r6.getDuration())) + ProtoAdapter.q.l(4, r6.getGrain());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, DatetimeEntity r5) {
                    DatetimeEntity r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    t r0 = ProtoAdapter.k;
                    r0.i(r4, 1, r6.getStart());
                    r0.i(r4, 2, r6.getEnd());
                    ProtoAdapter.h.i(r4, 3, r6.getDuration());
                    ProtoAdapter.q.i(r4, 4, r6.getGrain());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, DatetimeEntity r5) {
                    DatetimeEntity r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    ProtoAdapter.q.j(r4, 4, r6.getGrain());
                    ProtoAdapter.h.j(r4, 3, r6.getDuration());
                    t r0 = ProtoAdapter.k;
                    r0.j(r4, 2, r6.getEnd());
                    r0.j(r4, 1, r6.getStart());
                }

                public b(FieldEncoding r7, KClass<DatetimeEntity> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.Abbreviation.entity.DatetimeEntity", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ DatetimeEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DatetimeEntity.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.start;
                r0.e = this.end;
                r0.f = this.duration;
                r0.g = this.grain;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(DatetimeEntity.class).getSimpleName() + '@' + hashCode();
            }

            public final Integer getDuration() {
                return this.duration;
            }

            public final Long getEnd() {
                return this.end;
            }

            public final String getGrain() {
                return this.grain;
            }

            public final Long getStart() {
                return this.start;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public DatetimeEntity(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.start = r2.d;
                this.end = r2.e;
                this.duration = r2.f;
                this.grain = r2.g;
            }

            public /* synthetic */ DatetimeEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Abbreviation$entity$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKOWN", "ACRONYM", "WIKI", "DATETIME", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final Type ACRONYM = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final b Companion = null;
            public static final Type DATETIME = null;
            public static final Type UNKOWN = null;
            public static final Type WIKI = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
                    return null;
                L17:
                    return Type.DATETIME;
                L18:
                    return Type.WIKI;
                L19:
                    return Type.ACRONYM;
                L15:
                    return Type.UNKOWN;
                }

                public a(KClass<Type> r1, Syntax r2, Type r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Type> getEntries() {
                return b;
            }

            static {
                Type r0 = new Type("UNKOWN", 0, 0);
                UNKOWN = r0;
                Type r1 = new Type("ACRONYM", 1, 1);
                ACRONYM = r1;
                Type r3 = new Type("WIKI", 2, 2);
                WIKI = r3;
                Type r5 = new Type("DATETIME", 3, 3);
                DATETIME = r5;
                Type[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
            }

            public static Type[] values() {
                return (Type[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Type fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
                return null;
            L17:
                return DATETIME;
            L18:
                return WIKI;
            L19:
                return ACRONYM;
            L15:
                return UNKOWN;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<entity, a> {
            public String d;
            public Integer e;
            public Type f;
            public DatetimeEntity g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new entity(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<entity> {
            @Override // com.lark.wire.ProtoAdapter
            public final entity c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.d = r10.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L12:
                if (r4 != 4) goto L13;
                r1.g = DatetimeEntity.ADAPTER.c(r10);
                goto L3
            L13:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L22:
                return new entity(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(entity r5) {
                entity r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getAbbr_id())) + ProtoAdapter.h.l(2, r6.getAbbr_version())) + Type.ADAPTER.l(3, r6.getAbbr_type())) + DatetimeEntity.ADAPTER.l(4, r6.getDatetime());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, entity r5) {
                entity r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getAbbr_id());
                ProtoAdapter.h.i(r4, 2, r6.getAbbr_version());
                Type.ADAPTER.i(r4, 3, r6.getAbbr_type());
                DatetimeEntity.ADAPTER.i(r4, 4, r6.getDatetime());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, entity r5) {
                entity r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                DatetimeEntity.ADAPTER.j(r4, 4, r6.getDatetime());
                Type.ADAPTER.j(r4, 3, r6.getAbbr_type());
                ProtoAdapter.h.j(r4, 2, r6.getAbbr_version());
                ProtoAdapter.q.j(r4, 1, r6.getAbbr_id());
            }

            public b(FieldEncoding r7, KClass<entity> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Abbreviation.entity", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ entity(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(entity.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.abbr_id;
            r0.e = this.abbr_version;
            r0.f = this.abbr_type;
            r0.g = this.datetime;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(entity.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAbbr_id() {
            return this.abbr_id;
        }

        public final Type getAbbr_type() {
            return this.abbr_type;
        }

        public final Integer getAbbr_version() {
            return this.abbr_version;
        }

        public final DatetimeEntity getDatetime() {
            return this.datetime;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public entity(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.abbr_id = r2.d;
            this.abbr_version = r2.e;
            this.abbr_type = r2.f;
            this.datetime = r2.g;
        }

        public /* synthetic */ entity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public /* synthetic */ Abbreviation(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(Abbreviation.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new Abbreviation$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.abbr_element_ref;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Abbreviation.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, Abbrs> getAbbr_element_ref() {
        return this.abbr_element_ref;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Abbreviation(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.abbr_element_ref = com.lark.wire.internal.a.d("abbr_element_ref", r2.d);
    }

    public /* synthetic */ Abbreviation(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
