package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.todo.v1.TodoCommentReaction;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003$%&B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoCommentDetail;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TodoCommentDetail$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TodoCommentDetail$Builder;Lokio/ByteString;)V", "comment_id", "", "getComment_id", "()Ljava/lang/String;", "comment_type", "Lcom/lark/kmp/pb/basic/v1/TodoCommentDetail$TodoCommentType;", "getComment_type", "()Lcom/lark/kmp/pb/basic/v1/TodoCommentDetail$TodoCommentType;", "rich_content", "Lcom/lark/kmp/pb/basic/v1/RichContent;", "getRich_content", "()Lcom/lark/kmp/pb/basic/v1/RichContent;", "position", "", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "attachments", "", "Lcom/lark/kmp/pb/basic/v1/TodoAttachmentInfo;", "getAttachments", "()Ljava/util/List;", "newly_added_reaction", "Lcom/lark/kmp/pb/todo/v1/TodoCommentReaction;", "getNewly_added_reaction", "()Lcom/lark/kmp/pb/todo/v1/TodoCommentReaction;", "newBuilder", "toString", "Builder", "Companion", "TodoCommentType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TodoCommentDetail extends com.lark.wire.Message<TodoCommentDetail, a> {
    public static final ProtoAdapter<TodoCommentDetail> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<TodoAttachmentInfo> attachments;
    private final String comment_id;
    private final TodoCommentType comment_type;
    private final TodoCommentReaction newly_added_reaction;
    private final Integer position;
    private final RichContent rich_content;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TodoCommentDetail$TodoCommentType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "RICH_TEXT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum TodoCommentType extends Enum<TodoCommentType> implements o0 {
        public static final ProtoAdapter<TodoCommentType> ADAPTER = null;
        public static final b Companion = null;
        public static final TodoCommentType RICH_TEXT = null;
        public static final TodoCommentType UNKNOWN_TYPE = null;
        public static final /* synthetic */ TodoCommentType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<TodoCommentType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                TodoCommentType.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return TodoCommentType.RICH_TEXT;
            L9:
                return TodoCommentType.UNKNOWN_TYPE;
            }

            public a(KClass<TodoCommentType> r1, Syntax r2, TodoCommentType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<TodoCommentType> getEntries() {
            return b;
        }

        static {
            TodoCommentType r0 = new TodoCommentType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            TodoCommentType r1 = new TodoCommentType("RICH_TEXT", 1, 1);
            RICH_TEXT = r1;
            TodoCommentType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(TodoCommentType.class), Syntax.PROTO_2, r0);
        }

        public static TodoCommentType[] values() {
            return (TodoCommentType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final TodoCommentType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return RICH_TEXT;
        L9:
            return UNKNOWN_TYPE;
        }

        public static TodoCommentType valueOf(String r1) {
            return (TodoCommentType) r27.a.a(TodoCommentType.class, r1);
        }

        public TodoCommentType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<TodoCommentDetail, a> {
        public String d;
        public TodoCommentType e;
        public RichContent f;
        public Integer g;
        public List<TodoAttachmentInfo> h;
        public TodoCommentReaction i;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TodoCommentDetail(this, c(), null);
        }

        public a() {
            this.h = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<TodoCommentDetail> {
        @Override // com.lark.wire.ProtoAdapter
        public final TodoCommentDetail c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L16;
            switch(r5) {
                case 1: goto L15;
                case 2: goto L18;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r1.e = TodoCommentType.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L7:
            r1.i = TodoCommentReaction.ADAPTER.c(r11);
            goto L3
        L8:
            r2.add(TodoAttachmentInfo.ADAPTER.c(r11));
            goto L3
        L9:
            r1.g = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L10:
            r1.f = RichContent.ADAPTER.c(r11);
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.d = r11.i();
            goto L3
        L6:
            r11.j(r5);
            Unit r7 = Unit.INSTANCE;
            goto L3
        L16:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "attachments");
            com.lark.wire.internal.a.a(r2);
            r1.h = r2;
            return new TodoCommentDetail(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TodoCommentDetail r5) {
            TodoCommentDetail r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (((((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getComment_id())) + TodoCommentType.ADAPTER.l(2, r6.getComment_type())) + RichContent.ADAPTER.l(3, r6.getRich_content())) + ProtoAdapter.h.l(4, r6.getPosition())) + TodoAttachmentInfo.ADAPTER.a().l(5, r6.getAttachments())) + TodoCommentReaction.ADAPTER.l(6, r6.getNewly_added_reaction());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TodoCommentDetail r5) {
            TodoCommentDetail r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getComment_id());
            TodoCommentType.ADAPTER.i(r4, 2, r6.getComment_type());
            RichContent.ADAPTER.i(r4, 3, r6.getRich_content());
            ProtoAdapter.h.i(r4, 4, r6.getPosition());
            TodoAttachmentInfo.ADAPTER.a().i(r4, 5, r6.getAttachments());
            TodoCommentReaction.ADAPTER.i(r4, 6, r6.getNewly_added_reaction());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TodoCommentDetail r5) {
            TodoCommentDetail r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            TodoCommentReaction.ADAPTER.j(r4, 6, r6.getNewly_added_reaction());
            TodoAttachmentInfo.ADAPTER.a().j(r4, 5, r6.getAttachments());
            ProtoAdapter.h.j(r4, 4, r6.getPosition());
            RichContent.ADAPTER.j(r4, 3, r6.getRich_content());
            TodoCommentType.ADAPTER.j(r4, 2, r6.getComment_type());
            ProtoAdapter.q.j(r4, 1, r6.getComment_id());
        }

        public b(FieldEncoding r7, KClass<TodoCommentDetail> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TodoCommentDetail", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TodoCommentDetail(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TodoCommentDetail.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.comment_id;
        r0.e = this.comment_type;
        r0.f = this.rich_content;
        r0.g = this.position;
        r0.h = this.attachments;
        r0.i = this.newly_added_reaction;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TodoCommentDetail.class).getSimpleName() + '@' + hashCode();
    }

    public final List<TodoAttachmentInfo> getAttachments() {
        return this.attachments;
    }

    public final String getComment_id() {
        return this.comment_id;
    }

    public final TodoCommentType getComment_type() {
        return this.comment_type;
    }

    public final TodoCommentReaction getNewly_added_reaction() {
        return this.newly_added_reaction;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final RichContent getRich_content() {
        return this.rich_content;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TodoCommentDetail(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.comment_id = r2.d;
        this.comment_type = r2.e;
        this.rich_content = r2.f;
        this.position = r2.g;
        this.attachments = com.lark.wire.internal.a.c("attachments", r2.h);
        this.newly_added_reaction = r2.i;
    }

    public /* synthetic */ TodoCommentDetail(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
