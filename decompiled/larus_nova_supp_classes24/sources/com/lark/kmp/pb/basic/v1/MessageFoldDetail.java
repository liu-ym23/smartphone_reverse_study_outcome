package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.lark.wire.t;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 32\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u00042345B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010/\u001a\u00020\u0002H\u0016J\b\u00100\u001a\u000201H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0019\u0010\u000bR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0015\u0010 \u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b!\u0010\u0016R\u0015\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b#\u0010\u000bR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010-\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b.\u0010\u000b¨\u00066"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail$Builder;Lokio/ByteString;)V", "fold_id", "", "getFold_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "message", "Lcom/lark/kmp/pb/basic/v1/Message;", "getMessage", "()Lcom/lark/kmp/pb/basic/v1/Message;", "root_message_id", "getRoot_message_id", "root_message_position", "", "getRoot_message_position", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "last_message_id", "getLast_message_id", "last_message_position", "getLast_message_position", "last_message_badge_count", "getLast_message_badge_count", "user_len", "getUser_len", "total_count", "getTotal_count", "update_time_ms", "getUpdate_time_ms", "user_counts", "", "Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail$FoldUserCount;", "getUser_counts", "()Ljava/util/List;", "recall_type", "Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail$RecallType;", "getRecall_type", "()Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail$RecallType;", "recall_user_id", "getRecall_user_id", "newBuilder", "toString", "", "Builder", "Companion", "FoldUserCount", "RecallType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MessageFoldDetail extends com.lark.wire.Message<MessageFoldDetail, a> {
    public static final ProtoAdapter<MessageFoldDetail> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Long fold_id;
    private final Integer last_message_badge_count;
    private final Long last_message_id;
    private final Integer last_message_position;
    private final Message message;
    private final RecallType recall_type;
    private final Long recall_user_id;
    private final Long root_message_id;
    private final Integer root_message_position;
    private final Integer total_count;
    private final Long update_time_ms;
    private final List<FoldUserCount> user_counts;
    private final Integer user_len;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail$FoldUserCount;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail$FoldUserCount$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail$FoldUserCount$Builder;Lokio/ByteString;)V", "user_id", "", "getUser_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "count", "", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class FoldUserCount extends com.lark.wire.Message<FoldUserCount, a> {
        public static final ProtoAdapter<FoldUserCount> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer count;
        private final Long user_id;

        public static final class a extends com.lark.wire.Message.a<FoldUserCount, a> {
            public Long d;
            public Integer e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new FoldUserCount(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<FoldUserCount> {
            @Override // com.lark.wire.ProtoAdapter
            public final FoldUserCount c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L8;
                r0.d = (Long) ProtoAdapter.k.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = (Integer) ProtoAdapter.h.c(r6);
                goto L3
            L9:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L13:
                return new FoldUserCount(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(FoldUserCount r5) {
                FoldUserCount r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.k.l(1, r6.getUser_id())) + ProtoAdapter.h.l(2, r6.getCount());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, FoldUserCount r5) {
                FoldUserCount r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.k.i(r4, 1, r6.getUser_id());
                ProtoAdapter.h.i(r4, 2, r6.getCount());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, FoldUserCount r5) {
                FoldUserCount r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 2, r6.getCount());
                ProtoAdapter.k.j(r4, 1, r6.getUser_id());
            }

            public b(FieldEncoding r7, KClass<FoldUserCount> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.MessageFoldDetail.FoldUserCount", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ FoldUserCount(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FoldUserCount.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.user_id;
            r0.e = this.count;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(FoldUserCount.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getCount() {
            return this.count;
        }

        public final Long getUser_id() {
            return this.user_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public FoldUserCount(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.user_id = r2.d;
            this.count = r2.e;
        }

        public /* synthetic */ FoldUserCount(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail$RecallType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NOT_RECALL", "USER_RECALL", "GROUP_OWNER_RECALL", "GROUP_ADMIN_RECALL", "ENTERPRISE_ADMIN_RECALL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum RecallType extends Enum<RecallType> implements o0 {
        public static final ProtoAdapter<RecallType> ADAPTER = null;
        public static final b Companion = null;
        public static final RecallType ENTERPRISE_ADMIN_RECALL = null;
        public static final RecallType GROUP_ADMIN_RECALL = null;
        public static final RecallType GROUP_OWNER_RECALL = null;
        public static final RecallType NOT_RECALL = null;
        public static final RecallType USER_RECALL = null;
        public static final /* synthetic */ RecallType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<RecallType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                RecallType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<RecallType> r1, Syntax r2, RecallType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static RecallType a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return RecallType.ENTERPRISE_ADMIN_RECALL;
            L20:
                return RecallType.GROUP_ADMIN_RECALL;
            L21:
                return RecallType.GROUP_OWNER_RECALL;
            L22:
                return RecallType.USER_RECALL;
            L17:
                return RecallType.NOT_RECALL;
            }
        }

        @JvmStatic
        public static final RecallType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<RecallType> getEntries() {
            return b;
        }

        static {
            RecallType r0 = new RecallType("NOT_RECALL", 0, 0);
            NOT_RECALL = r0;
            RecallType r1 = new RecallType("USER_RECALL", 1, 1);
            USER_RECALL = r1;
            RecallType r3 = new RecallType("GROUP_OWNER_RECALL", 2, 2);
            GROUP_OWNER_RECALL = r3;
            RecallType r5 = new RecallType("GROUP_ADMIN_RECALL", 3, 3);
            GROUP_ADMIN_RECALL = r5;
            RecallType r7 = new RecallType("ENTERPRISE_ADMIN_RECALL", 4, 4);
            ENTERPRISE_ADMIN_RECALL = r7;
            RecallType[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(RecallType.class), Syntax.PROTO_2, r0);
        }

        public static RecallType[] values() {
            return (RecallType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static RecallType valueOf(String r1) {
            return (RecallType) r27.a.a(RecallType.class, r1);
        }

        public RecallType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<MessageFoldDetail, a> {
        public Long d;
        public Message e;
        public Long f;
        public Integer g;
        public Long h;
        public Integer i;
        public Integer j;
        public Integer k;
        public Integer l;
        public Long m;
        public List<FoldUserCount> n;
        public RecallType o;
        public Long p;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MessageFoldDetail(this, c(), null);
        }

        public a() {
            this.n = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<MessageFoldDetail> {
        @Override // com.lark.wire.ProtoAdapter
        public final MessageFoldDetail c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L23;
            switch(r4) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L25;
                case 13: goto L7;
                default: goto L6;
            };
        L25:
            r0.o = RecallType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L7:
            r0.p = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L12:
            r1.add(FoldUserCount.ADAPTER.c(r10));
            goto L3
        L13:
            r0.m = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L14:
            r0.l = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L15:
            r0.k = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L16:
            r0.j = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L17:
            r0.i = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L18:
            r0.h = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L19:
            r0.g = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L20:
            r0.f = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L21:
            r0.e = Message.ADAPTER.c(r10);
            goto L3
        L22:
            r0.d = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L6:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L23:
            ByteString r11 = r10.d(r2);
            Intrinsics.checkNotNullParameter(r1, "user_counts");
            com.lark.wire.internal.a.a(r1);
            r0.n = r1;
            return new MessageFoldDetail(r0, r11, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MessageFoldDetail r6) {
            MessageFoldDetail r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            t r1 = ProtoAdapter.k;
            int r2 = ((r0 + r1.l(1, r7.getFold_id())) + Message.ADAPTER.l(2, r7.getMessage())) + r1.l(3, r7.getRoot_message_id());
            s r3 = ProtoAdapter.h;
            return (((((((((r2 + r3.l(4, r7.getRoot_message_position())) + r1.l(5, r7.getLast_message_id())) + r3.l(6, r7.getLast_message_position())) + r3.l(7, r7.getLast_message_badge_count())) + r3.l(8, r7.getUser_len())) + r3.l(9, r7.getTotal_count())) + r1.l(10, r7.getUpdate_time_ms())) + FoldUserCount.ADAPTER.a().l(11, r7.getUser_counts())) + RecallType.ADAPTER.l(12, r7.getRecall_type())) + r1.l(13, r7.getRecall_user_id());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, MessageFoldDetail r6) {
            MessageFoldDetail r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            t r0 = ProtoAdapter.k;
            r0.i(r5, 1, r7.getFold_id());
            Message.ADAPTER.i(r5, 2, r7.getMessage());
            r0.i(r5, 3, r7.getRoot_message_id());
            s r1 = ProtoAdapter.h;
            r1.i(r5, 4, r7.getRoot_message_position());
            r0.i(r5, 5, r7.getLast_message_id());
            r1.i(r5, 6, r7.getLast_message_position());
            r1.i(r5, 7, r7.getLast_message_badge_count());
            r1.i(r5, 8, r7.getUser_len());
            r1.i(r5, 9, r7.getTotal_count());
            r0.i(r5, 10, r7.getUpdate_time_ms());
            FoldUserCount.ADAPTER.a().i(r5, 11, r7.getUser_counts());
            RecallType.ADAPTER.i(r5, 12, r7.getRecall_type());
            r0.i(r5, 13, r7.getRecall_user_id());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, MessageFoldDetail r6) {
            MessageFoldDetail r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r5, 13, r7.getRecall_user_id());
            RecallType.ADAPTER.j(r5, 12, r7.getRecall_type());
            FoldUserCount.ADAPTER.a().j(r5, 11, r7.getUser_counts());
            r0.j(r5, 10, r7.getUpdate_time_ms());
            s r1 = ProtoAdapter.h;
            r1.j(r5, 9, r7.getTotal_count());
            r1.j(r5, 8, r7.getUser_len());
            r1.j(r5, 7, r7.getLast_message_badge_count());
            r1.j(r5, 6, r7.getLast_message_position());
            r0.j(r5, 5, r7.getLast_message_id());
            r1.j(r5, 4, r7.getRoot_message_position());
            r0.j(r5, 3, r7.getRoot_message_id());
            Message.ADAPTER.j(r5, 2, r7.getMessage());
            r0.j(r5, 1, r7.getFold_id());
        }

        public b(FieldEncoding r7, KClass<MessageFoldDetail> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.MessageFoldDetail", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MessageFoldDetail(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageFoldDetail.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.fold_id;
        r0.e = this.message;
        r0.f = this.root_message_id;
        r0.g = this.root_message_position;
        r0.h = this.last_message_id;
        r0.i = this.last_message_position;
        r0.j = this.last_message_badge_count;
        r0.k = this.user_len;
        r0.l = this.total_count;
        r0.m = this.update_time_ms;
        r0.n = this.user_counts;
        r0.o = this.recall_type;
        r0.p = this.recall_user_id;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MessageFoldDetail.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getFold_id() {
        return this.fold_id;
    }

    public final Integer getLast_message_badge_count() {
        return this.last_message_badge_count;
    }

    public final Long getLast_message_id() {
        return this.last_message_id;
    }

    public final Integer getLast_message_position() {
        return this.last_message_position;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final RecallType getRecall_type() {
        return this.recall_type;
    }

    public final Long getRecall_user_id() {
        return this.recall_user_id;
    }

    public final Long getRoot_message_id() {
        return this.root_message_id;
    }

    public final Integer getRoot_message_position() {
        return this.root_message_position;
    }

    public final Integer getTotal_count() {
        return this.total_count;
    }

    public final Long getUpdate_time_ms() {
        return this.update_time_ms;
    }

    public final List<FoldUserCount> getUser_counts() {
        return this.user_counts;
    }

    public final Integer getUser_len() {
        return this.user_len;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MessageFoldDetail(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.fold_id = r2.d;
        this.message = r2.e;
        this.root_message_id = r2.f;
        this.root_message_position = r2.g;
        this.last_message_id = r2.h;
        this.last_message_position = r2.i;
        this.last_message_badge_count = r2.j;
        this.user_len = r2.k;
        this.total_count = r2.l;
        this.update_time_ms = r2.m;
        this.user_counts = com.lark.wire.internal.a.c("user_counts", r2.n);
        this.recall_type = r2.o;
        this.recall_user_id = r2.p;
    }

    public /* synthetic */ MessageFoldDetail(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
