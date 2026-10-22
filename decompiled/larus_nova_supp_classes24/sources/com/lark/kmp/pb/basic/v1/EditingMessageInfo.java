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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/EditingMessageInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/EditingMessageInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/EditingMessageInfo$Builder;Lokio/ByteString;)V", "message_type", "Lcom/lark/kmp/pb/basic/v1/Message$Type;", "getMessage_type", "()Lcom/lark/kmp/pb/basic/v1/Message$Type;", "content", "Lcom/lark/kmp/pb/basic/v1/EditMessageContent;", "getContent", "()Lcom/lark/kmp/pb/basic/v1/EditMessageContent;", "request_time_ms", "", "getRequest_time_ms", "()Ljava/lang/Long;", "Ljava/lang/Long;", "request_status", "Lcom/lark/kmp/pb/basic/v1/EditingMessageInfo$EditRequestStatus;", "getRequest_status", "()Lcom/lark/kmp/pb/basic/v1/EditingMessageInfo$EditRequestStatus;", "base_edit_version", "", "getBase_edit_version", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "EditRequestStatus", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EditingMessageInfo extends com.lark.wire.Message<EditingMessageInfo, a> {
    public static final ProtoAdapter<EditingMessageInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Integer base_edit_version;
    private final EditMessageContent content;
    private final Message.Type message_type;
    private final EditRequestStatus request_status;
    private final Long request_time_ms;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/EditingMessageInfo$EditRequestStatus;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NO_REQUEST", "WATING", "FAILED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum EditRequestStatus extends Enum<EditRequestStatus> implements o0 {
        public static final ProtoAdapter<EditRequestStatus> ADAPTER = null;
        public static final b Companion = null;
        public static final EditRequestStatus FAILED = null;
        public static final EditRequestStatus NO_REQUEST = null;
        public static final EditRequestStatus UNKNOWN = null;
        public static final EditRequestStatus WATING = null;
        public static final /* synthetic */ EditRequestStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<EditRequestStatus> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                EditRequestStatus.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return EditRequestStatus.FAILED;
            L18:
                return EditRequestStatus.WATING;
            L19:
                return EditRequestStatus.NO_REQUEST;
            L15:
                return EditRequestStatus.UNKNOWN;
            }

            public a(KClass<EditRequestStatus> r1, Syntax r2, EditRequestStatus r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<EditRequestStatus> getEntries() {
            return b;
        }

        static {
            EditRequestStatus r0 = new EditRequestStatus("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            EditRequestStatus r1 = new EditRequestStatus("NO_REQUEST", 1, 1);
            NO_REQUEST = r1;
            EditRequestStatus r3 = new EditRequestStatus("WATING", 2, 2);
            WATING = r3;
            EditRequestStatus r5 = new EditRequestStatus("FAILED", 3, 3);
            FAILED = r5;
            EditRequestStatus[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(EditRequestStatus.class), Syntax.PROTO_2, r0);
        }

        public static EditRequestStatus[] values() {
            return (EditRequestStatus[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final EditRequestStatus fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return FAILED;
        L18:
            return WATING;
        L19:
            return NO_REQUEST;
        L15:
            return UNKNOWN;
        }

        public static EditRequestStatus valueOf(String r1) {
            return (EditRequestStatus) r27.a.a(EditRequestStatus.class, r1);
        }

        public EditRequestStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<EditingMessageInfo, a> {
        public Message.Type d;
        public EditMessageContent e;
        public Long f;
        public EditRequestStatus g;
        public Integer h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new EditingMessageInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<EditingMessageInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final EditingMessageInfo c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L28;
            if (r3 != 1) goto L8;
            r0.d = Message.Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = EditMessageContent.ADAPTER.c(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.f = (Long) ProtoAdapter.k.c(r9);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.g = EditRequestStatus.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.h = (Integer) ProtoAdapter.h.c(r9);
            goto L3
        L15:
            r9.j(r3);
            goto L3
        L28:
            return new EditingMessageInfo(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(EditingMessageInfo r5) {
            EditingMessageInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((((r6.unknownFields().size() + Message.Type.ADAPTER.l(1, r6.getMessage_type())) + EditMessageContent.ADAPTER.l(2, r6.getContent())) + ProtoAdapter.k.l(3, r6.getRequest_time_ms())) + EditRequestStatus.ADAPTER.l(4, r6.getRequest_status())) + ProtoAdapter.h.l(5, r6.getBase_edit_version());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, EditingMessageInfo r5) {
            EditingMessageInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Message.Type.ADAPTER.i(r4, 1, r6.getMessage_type());
            EditMessageContent.ADAPTER.i(r4, 2, r6.getContent());
            ProtoAdapter.k.i(r4, 3, r6.getRequest_time_ms());
            EditRequestStatus.ADAPTER.i(r4, 4, r6.getRequest_status());
            ProtoAdapter.h.i(r4, 5, r6.getBase_edit_version());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, EditingMessageInfo r5) {
            EditingMessageInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.h.j(r4, 5, r6.getBase_edit_version());
            EditRequestStatus.ADAPTER.j(r4, 4, r6.getRequest_status());
            ProtoAdapter.k.j(r4, 3, r6.getRequest_time_ms());
            EditMessageContent.ADAPTER.j(r4, 2, r6.getContent());
            Message.Type.ADAPTER.j(r4, 1, r6.getMessage_type());
        }

        public b(FieldEncoding r7, KClass<EditingMessageInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.EditingMessageInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ EditingMessageInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EditingMessageInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.message_type;
        r0.e = this.content;
        r0.f = this.request_time_ms;
        r0.g = this.request_status;
        r0.h = this.base_edit_version;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EditingMessageInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getBase_edit_version() {
        return this.base_edit_version;
    }

    public final EditMessageContent getContent() {
        return this.content;
    }

    public final Message.Type getMessage_type() {
        return this.message_type;
    }

    public final EditRequestStatus getRequest_status() {
        return this.request_status;
    }

    public final Long getRequest_time_ms() {
        return this.request_time_ms;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public EditingMessageInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.message_type = r2.d;
        this.content = r2.e;
        this.request_time_ms = r2.f;
        this.request_status = r2.g;
        this.base_edit_version = r2.h;
    }

    public /* synthetic */ EditingMessageInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
