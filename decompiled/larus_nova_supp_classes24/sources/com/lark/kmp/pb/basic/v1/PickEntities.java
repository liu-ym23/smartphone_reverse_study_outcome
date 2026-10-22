package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PickEntities;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/PickEntities$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/PickEntities$Builder;Lokio/ByteString;)V", "pick_type", "Lcom/lark/kmp/pb/basic/v1/PickEntities$PickType;", "getPick_type", "()Lcom/lark/kmp/pb/basic/v1/PickEntities$PickType;", "pick_ids", "", "", "getPick_ids", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "PickType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PickEntities extends com.lark.wire.Message<PickEntities, a> {
    public static final ProtoAdapter<PickEntities> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<String> pick_ids;
    private final PickType pick_type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/PickEntities$PickType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "USER", "CHAT", "DEPT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum PickType extends Enum<PickType> implements o0 {
        public static final ProtoAdapter<PickType> ADAPTER = null;
        public static final PickType CHAT = null;
        public static final b Companion = null;
        public static final PickType DEPT = null;
        public static final PickType UNKNOWN = null;
        public static final PickType USER = null;
        public static final /* synthetic */ PickType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<PickType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                PickType.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return PickType.DEPT;
            L18:
                return PickType.CHAT;
            L19:
                return PickType.USER;
            L15:
                return PickType.UNKNOWN;
            }

            public a(KClass<PickType> r1, Syntax r2, PickType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<PickType> getEntries() {
            return b;
        }

        static {
            PickType r0 = new PickType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            PickType r1 = new PickType("USER", 1, 1);
            USER = r1;
            PickType r3 = new PickType("CHAT", 2, 2);
            CHAT = r3;
            PickType r5 = new PickType("DEPT", 3, 3);
            DEPT = r5;
            PickType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(PickType.class), Syntax.PROTO_2, r0);
        }

        public static PickType[] values() {
            return (PickType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final PickType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return DEPT;
        L18:
            return CHAT;
        L19:
            return USER;
        L15:
            return UNKNOWN;
        }

        public static PickType valueOf(String r1) {
            return (PickType) r27.a.a(PickType.class, r1);
        }

        public PickType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<PickEntities, a> {
        public PickType d;
        public List<String> e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new PickEntities(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<PickEntities> {
        @Override // com.lark.wire.ProtoAdapter
        public final PickEntities c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L15;
            if (r5 != 1) goto L8;
            PickType r6 = PickType.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            Intrinsics.checkNotNullParameter(r6, "pick_type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            r1.d = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L8:
            if (r5 != 2) goto L9;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r2.add(r11.i());
            goto L3
        L9:
            r11.j(r5);
            goto L3
        L15:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "pick_ids");
            com.lark.wire.internal.a.a(r2);
            r1.e = r2;
            return new PickEntities(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(PickEntities r5) {
            PickEntities r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + PickType.ADAPTER.l(1, r6.getPick_type())) + ProtoAdapter.q.a().l(2, r6.getPick_ids());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, PickEntities r5) {
            PickEntities r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            PickType.ADAPTER.i(r4, 1, r6.getPick_type());
            ProtoAdapter.q.a().i(r4, 2, r6.getPick_ids());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, PickEntities r5) {
            PickEntities r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.q.a().j(r4, 2, r6.getPick_ids());
            PickType.ADAPTER.j(r4, 1, r6.getPick_type());
        }

        public b(FieldEncoding r7, KClass<PickEntities> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.PickEntities", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ PickEntities(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PickEntities.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.pick_type;
        r0.e = this.pick_ids;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(PickEntities.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getPick_ids() {
        return this.pick_ids;
    }

    public final PickType getPick_type() {
        return this.pick_type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public PickEntities(a r2, ByteString r3) {
        super(ADAPTER, r3);
        PickType r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.pick_type = r4;
        this.pick_ids = com.lark.wire.internal.a.c("pick_ids", r2.e);
    }

    public /* synthetic */ PickEntities(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
