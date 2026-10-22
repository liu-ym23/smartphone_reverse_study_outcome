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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0012\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ScheduleMessageItem;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ScheduleMessageItem$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ScheduleMessageItem$Builder;Lokio/ByteString;)V", "item_id", "", "getItem_id", "()Ljava/lang/String;", "item_type", "Lcom/lark/kmp/pb/basic/v1/ScheduleMessageItem$ItemType;", "getItem_type", "()Lcom/lark/kmp/pb/basic/v1/ScheduleMessageItem$ItemType;", "newBuilder", "toString", "Builder", "Companion", "ItemType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ScheduleMessageItem extends com.lark.wire.Message<ScheduleMessageItem, a> {
    public static final ProtoAdapter<ScheduleMessageItem> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String item_id;
    private final ItemType item_type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ScheduleMessageItem$ItemType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "QUASI_SCHEDULE_MESSAGE", "SCHEDULE_MESSAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ItemType extends Enum<ItemType> implements o0 {
        public static final ProtoAdapter<ItemType> ADAPTER = null;
        public static final b Companion = null;
        public static final ItemType QUASI_SCHEDULE_MESSAGE = null;
        public static final ItemType SCHEDULE_MESSAGE = null;
        public static final /* synthetic */ ItemType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ItemType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ItemType.Companion.getClass();
                if (r2 == 1) goto L9;
                if (r2 == 2) goto L11;
                return null;
            L11:
                return ItemType.SCHEDULE_MESSAGE;
            L9:
                return ItemType.QUASI_SCHEDULE_MESSAGE;
            }

            public a(KClass<ItemType> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ItemType> getEntries() {
            return b;
        }

        static {
            ItemType r0 = new ItemType("QUASI_SCHEDULE_MESSAGE", 0, 1);
            QUASI_SCHEDULE_MESSAGE = r0;
            ItemType r1 = new ItemType("SCHEDULE_MESSAGE", 1, 2);
            SCHEDULE_MESSAGE = r1;
            ItemType[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ItemType.class), Syntax.PROTO_2);
        }

        public static ItemType[] values() {
            return (ItemType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ItemType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return null;
        L11:
            return SCHEDULE_MESSAGE;
        L9:
            return QUASI_SCHEDULE_MESSAGE;
        }

        public static ItemType valueOf(String r1) {
            return (ItemType) r27.a.a(ItemType.class, r1);
        }

        public ItemType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<ScheduleMessageItem, a> {
        public String d;
        public ItemType e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ScheduleMessageItem(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ScheduleMessageItem> {
        @Override // com.lark.wire.ProtoAdapter
        public final ScheduleMessageItem c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L16;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L8:
            if (r4 != 2) goto L9;
            r1.e = ItemType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L9:
            r10.j(r4);
            goto L3
        L16:
            return new ScheduleMessageItem(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ScheduleMessageItem r5) {
            ScheduleMessageItem r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getItem_id())) + ItemType.ADAPTER.l(2, r6.getItem_type());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ScheduleMessageItem r5) {
            ScheduleMessageItem r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getItem_id());
            ItemType.ADAPTER.i(r4, 2, r6.getItem_type());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ScheduleMessageItem r5) {
            ScheduleMessageItem r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ItemType.ADAPTER.j(r4, 2, r6.getItem_type());
            ProtoAdapter.q.j(r4, 1, r6.getItem_id());
        }

        public b(FieldEncoding r7, KClass<ScheduleMessageItem> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ScheduleMessageItem", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ScheduleMessageItem(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ScheduleMessageItem.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.item_id;
        r0.e = this.item_type;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ScheduleMessageItem.class).getSimpleName() + '@' + hashCode();
    }

    public final String getItem_id() {
        return this.item_id;
    }

    public final ItemType getItem_type() {
        return this.item_type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ScheduleMessageItem(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.item_id = r2.d;
        this.item_type = r2.e;
    }

    public /* synthetic */ ScheduleMessageItem(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
