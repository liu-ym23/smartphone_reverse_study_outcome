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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoAttachmentInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TodoAttachmentInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TodoAttachmentInfo$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/TodoAttachmentInfo$TodoAttachmentType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/TodoAttachmentInfo$TodoAttachmentType;", "newBuilder", "toString", "", "Builder", "Companion", "TodoAttachmentType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TodoAttachmentInfo extends com.lark.wire.Message<TodoAttachmentInfo, a> {
    public static final ProtoAdapter<TodoAttachmentInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final TodoAttachmentType type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoAttachmentInfo$TodoAttachmentType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_ATTACHMENT_TYPE", "IMAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum TodoAttachmentType extends Enum<TodoAttachmentType> implements o0 {
        public static final ProtoAdapter<TodoAttachmentType> ADAPTER = null;
        public static final b Companion = null;
        public static final TodoAttachmentType IMAGE = null;
        public static final TodoAttachmentType UNKNOWN_ATTACHMENT_TYPE = null;
        public static final /* synthetic */ TodoAttachmentType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<TodoAttachmentType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                TodoAttachmentType.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return TodoAttachmentType.IMAGE;
            L9:
                return TodoAttachmentType.UNKNOWN_ATTACHMENT_TYPE;
            }

            public a(KClass<TodoAttachmentType> r1, Syntax r2, TodoAttachmentType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<TodoAttachmentType> getEntries() {
            return b;
        }

        static {
            TodoAttachmentType r0 = new TodoAttachmentType("UNKNOWN_ATTACHMENT_TYPE", 0, 0);
            UNKNOWN_ATTACHMENT_TYPE = r0;
            TodoAttachmentType r1 = new TodoAttachmentType("IMAGE", 1, 1);
            IMAGE = r1;
            TodoAttachmentType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(TodoAttachmentType.class), Syntax.PROTO_2, r0);
        }

        public static TodoAttachmentType[] values() {
            return (TodoAttachmentType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final TodoAttachmentType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return IMAGE;
        L9:
            return UNKNOWN_ATTACHMENT_TYPE;
        }

        public static TodoAttachmentType valueOf(String r1) {
            return (TodoAttachmentType) r27.a.a(TodoAttachmentType.class, r1);
        }

        public TodoAttachmentType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<TodoAttachmentInfo, a> {
        public TodoAttachmentType d;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TodoAttachmentInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TodoAttachmentInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final TodoAttachmentInfo c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L13;
            if (r3 != 1) goto L11;
            r0.d = TodoAttachmentType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L11:
            r9.j(r3);
            goto L3
        L13:
            return new TodoAttachmentInfo(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TodoAttachmentInfo r4) {
            TodoAttachmentInfo r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + TodoAttachmentType.ADAPTER.l(1, r5.getType());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TodoAttachmentInfo r5) {
            TodoAttachmentInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            TodoAttachmentType.ADAPTER.i(r4, 1, r6.getType());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, TodoAttachmentInfo r4) {
            TodoAttachmentInfo r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            TodoAttachmentType.ADAPTER.j(r3, 1, r5.getType());
        }

        public b(FieldEncoding r7, KClass<TodoAttachmentInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TodoAttachmentInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TodoAttachmentInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TodoAttachmentInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TodoAttachmentInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final TodoAttachmentType getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TodoAttachmentInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.type = r2.d;
    }

    public /* synthetic */ TodoAttachmentInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
