package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.w;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005&'()*B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CommonAIReply;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CommonAIReply$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CommonAIReply$Builder;Lokio/ByteString;)V", "status", "Lcom/lark/kmp/pb/basic/v1/CommonAIReply$Status;", "getStatus", "()Lcom/lark/kmp/pb/basic/v1/CommonAIReply$Status;", "sequence_id", "", "getSequence_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "rich_text", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getRich_text", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "references", "getReferences", "text_without_citation", "", "getText_without_citation", "()Ljava/lang/String;", "cot_text", "getCot_text", "ai_reply_id", "getAi_reply_id", "reference_list", "", "Lcom/lark/kmp/pb/basic/v1/CommonAIReply$ReferenceItem;", "getReference_list", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "Status", "ReferenceType", "ReferenceItem", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CommonAIReply extends com.lark.wire.Message<CommonAIReply, a> {
    public static final ProtoAdapter<CommonAIReply> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String ai_reply_id;
    private final String cot_text;
    private final List<ReferenceItem> reference_list;
    private final RichText references;
    private final RichText rich_text;
    private final Integer sequence_id;
    private final Status status;
    private final String text_without_citation;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CommonAIReply$ReferenceItem;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CommonAIReply$ReferenceItem$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CommonAIReply$ReferenceItem$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "title", "getTitle", "src_type", "Lcom/lark/kmp/pb/basic/v1/CommonAIReply$ReferenceType;", "getSrc_type", "()Lcom/lark/kmp/pb/basic/v1/CommonAIReply$ReferenceType;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ReferenceItem extends com.lark.wire.Message<ReferenceItem, a> {
        public static final ProtoAdapter<ReferenceItem> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ReferenceType src_type;
        private final String title;
        private final String url;

        public static final class a extends com.lark.wire.Message.a<ReferenceItem, a> {
            public String d;
            public String e;
            public ReferenceType f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ReferenceItem(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ReferenceItem> {
            @Override // com.lark.wire.ProtoAdapter
            public final ReferenceItem c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.d = r10.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L10:
                if (r4 != 3) goto L11;
                r1.f = ReferenceType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L11:
                r10.j(r4);
                goto L3
            L19:
                return new ReferenceItem(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ReferenceItem r5) {
                ReferenceItem r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((r0 + r1.l(1, r6.getUrl())) + r1.l(2, r6.getTitle())) + ReferenceType.ADAPTER.l(3, r6.getSrc_type());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ReferenceItem r5) {
                ReferenceItem r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getUrl());
                r0.i(r4, 2, r6.getTitle());
                ReferenceType.ADAPTER.i(r4, 3, r6.getSrc_type());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ReferenceItem r5) {
                ReferenceItem r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ReferenceType.ADAPTER.j(r4, 3, r6.getSrc_type());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getTitle());
                r0.j(r4, 1, r6.getUrl());
            }

            public b(FieldEncoding r7, KClass<ReferenceItem> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CommonAIReply.ReferenceItem", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ReferenceItem(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ReferenceItem.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.url;
            r0.e = this.title;
            r0.f = this.src_type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ReferenceItem.class).getSimpleName() + '@' + hashCode();
        }

        public final ReferenceType getSrc_type() {
            return this.src_type;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ReferenceItem(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.url = r2.d;
            this.title = r2.e;
            this.src_type = r2.f;
        }

        public /* synthetic */ ReferenceItem(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CommonAIReply$ReferenceType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "HELPDESK", "WIKI", "DOC", "WEB", "LINGO", "MESSAGE", "COMMENT", "MINUTES", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ReferenceType extends Enum<ReferenceType> implements o0 {
        public static final ProtoAdapter<ReferenceType> ADAPTER = null;
        public static final ReferenceType COMMENT = null;
        public static final b Companion = null;
        public static final ReferenceType DOC = null;
        public static final ReferenceType HELPDESK = null;
        public static final ReferenceType LINGO = null;
        public static final ReferenceType MESSAGE = null;
        public static final ReferenceType MINUTES = null;
        public static final ReferenceType UNKNOWN_TYPE = null;
        public static final ReferenceType WEB = null;
        public static final ReferenceType WIKI = null;
        public static final /* synthetic */ ReferenceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ReferenceType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ReferenceType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<ReferenceType> r1, Syntax r2, ReferenceType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static ReferenceType a(int r0) {
                switch(r0) {
                    case 0: goto L13;
                    case 1: goto L22;
                    case 2: goto L21;
                    case 3: goto L20;
                    case 4: goto L19;
                    case 5: goto L18;
                    case 6: goto L17;
                    case 7: goto L16;
                    case 8: goto L15;
                    default: goto L3;
                };
            L3:
                return null;
            L15:
                return ReferenceType.MINUTES;
            L16:
                return ReferenceType.COMMENT;
            L17:
                return ReferenceType.MESSAGE;
            L18:
                return ReferenceType.LINGO;
            L19:
                return ReferenceType.WEB;
            L20:
                return ReferenceType.DOC;
            L21:
                return ReferenceType.WIKI;
            L22:
                return ReferenceType.HELPDESK;
            L13:
                return ReferenceType.UNKNOWN_TYPE;
            }
        }

        @JvmStatic
        public static final ReferenceType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<ReferenceType> getEntries() {
            return b;
        }

        static {
            ReferenceType r0 = new ReferenceType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            ReferenceType r1 = new ReferenceType("HELPDESK", 1, 1);
            HELPDESK = r1;
            ReferenceType r3 = new ReferenceType("WIKI", 2, 2);
            WIKI = r3;
            ReferenceType r5 = new ReferenceType("DOC", 3, 3);
            DOC = r5;
            ReferenceType r7 = new ReferenceType("WEB", 4, 4);
            WEB = r7;
            ReferenceType r9 = new ReferenceType("LINGO", 5, 5);
            LINGO = r9;
            ReferenceType r11 = new ReferenceType("MESSAGE", 6, 6);
            MESSAGE = r11;
            ReferenceType r13 = new ReferenceType("COMMENT", 7, 7);
            COMMENT = r13;
            ReferenceType r15 = new ReferenceType("MINUTES", 8, 8);
            MINUTES = r15;
            ReferenceType[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
            a = r14;
            b = EnumEntriesKt.enumEntries(r14);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ReferenceType.class), Syntax.PROTO_2, r0);
        }

        public static ReferenceType[] values() {
            return (ReferenceType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static ReferenceType valueOf(String r1) {
            return (ReferenceType) r27.a.a(ReferenceType.class, r1);
        }

        public ReferenceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CommonAIReply$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STATUS", "START", "TRANSMIT", "OVER", "FAILED", "NO_RECOMENDATION", "NO_ANSWER", "CLOSE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status CLOSE = null;
        public static final b Companion = null;
        public static final Status FAILED = null;
        public static final Status NO_ANSWER = null;
        public static final Status NO_RECOMENDATION = null;
        public static final Status OVER = null;
        public static final Status START = null;
        public static final Status TRANSMIT = null;
        public static final Status UNKNOWN_STATUS = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Status> r1, Syntax r2, Status r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Status a(int r0) {
                switch(r0) {
                    case 0: goto L12;
                    case 1: goto L20;
                    case 2: goto L19;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    default: goto L3;
                };
            L3:
                return null;
            L14:
                return Status.CLOSE;
            L15:
                return Status.NO_ANSWER;
            L16:
                return Status.NO_RECOMENDATION;
            L17:
                return Status.FAILED;
            L18:
                return Status.OVER;
            L19:
                return Status.TRANSMIT;
            L20:
                return Status.START;
            L12:
                return Status.UNKNOWN_STATUS;
            }
        }

        @JvmStatic
        public static final Status fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("UNKNOWN_STATUS", 0, 0);
            UNKNOWN_STATUS = r0;
            Status r1 = new Status("START", 1, 1);
            START = r1;
            Status r3 = new Status("TRANSMIT", 2, 2);
            TRANSMIT = r3;
            Status r5 = new Status("OVER", 3, 3);
            OVER = r5;
            Status r7 = new Status("FAILED", 4, 4);
            FAILED = r7;
            Status r9 = new Status("NO_RECOMENDATION", 5, 5);
            NO_RECOMENDATION = r9;
            Status r11 = new Status("NO_ANSWER", 6, 6);
            NO_ANSWER = r11;
            Status r13 = new Status("CLOSE", 7, 7);
            CLOSE = r13;
            Status[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2, r0);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<CommonAIReply, a> {
        public Status d;
        public Integer e;
        public RichText f;
        public RichText g;
        public String h;
        public String i;
        public String j;
        public List<ReferenceItem> k;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new CommonAIReply(this, c(), null);
        }

        public a() {
            this.k = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<CommonAIReply> {
        @Override // com.lark.wire.ProtoAdapter
        public final CommonAIReply c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L18;
            switch(r5) {
                case 2: goto L20;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L6;
                case 10: goto L7;
                default: goto L6;
            };
        L20:
            r1.d = Status.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L7:
            r2.add(ReferenceItem.ADAPTER.c(r11));
            goto L3
        L8:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.j = r11.i();
            goto L3
        L9:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.i = r11.i();
            goto L3
        L10:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.h = r11.i();
            goto L3
        L11:
            r1.g = RichText.ADAPTER.c(r11);
            goto L3
        L12:
            r1.f = RichText.ADAPTER.c(r11);
            goto L3
        L13:
            r1.e = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L6:
            r11.j(r5);
            Unit r7 = Unit.INSTANCE;
            goto L3
        L18:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "reference_list");
            com.lark.wire.internal.a.a(r2);
            r1.k = r2;
            return new CommonAIReply(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CommonAIReply r5) {
            CommonAIReply r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = (r6.unknownFields().size() + Status.ADAPTER.l(2, r6.getStatus())) + ProtoAdapter.h.l(3, r6.getSequence_id());
            ProtoAdapter<RichText> r1 = RichText.ADAPTER;
            int r2 = (r0 + r1.l(4, r6.getRich_text())) + r1.l(5, r6.getReferences());
            w r3 = ProtoAdapter.q;
            return (((r2 + r3.l(6, r6.getText_without_citation())) + r3.l(7, r6.getCot_text())) + r3.l(8, r6.getAi_reply_id())) + ReferenceItem.ADAPTER.a().l(10, r6.getReference_list());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CommonAIReply r5) {
            CommonAIReply r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Status.ADAPTER.i(r4, 2, r6.getStatus());
            ProtoAdapter.h.i(r4, 3, r6.getSequence_id());
            ProtoAdapter<RichText> r0 = RichText.ADAPTER;
            r0.i(r4, 4, r6.getRich_text());
            r0.i(r4, 5, r6.getReferences());
            w r1 = ProtoAdapter.q;
            r1.i(r4, 6, r6.getText_without_citation());
            r1.i(r4, 7, r6.getCot_text());
            r1.i(r4, 8, r6.getAi_reply_id());
            ReferenceItem.ADAPTER.a().i(r4, 10, r6.getReference_list());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CommonAIReply r5) {
            CommonAIReply r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ReferenceItem.ADAPTER.a().j(r4, 10, r6.getReference_list());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 8, r6.getAi_reply_id());
            r0.j(r4, 7, r6.getCot_text());
            r0.j(r4, 6, r6.getText_without_citation());
            ProtoAdapter<RichText> r1 = RichText.ADAPTER;
            r1.j(r4, 5, r6.getReferences());
            r1.j(r4, 4, r6.getRich_text());
            ProtoAdapter.h.j(r4, 3, r6.getSequence_id());
            Status.ADAPTER.j(r4, 2, r6.getStatus());
        }

        public b(FieldEncoding r7, KClass<CommonAIReply> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.CommonAIReply", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CommonAIReply(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CommonAIReply.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.status;
        r0.e = this.sequence_id;
        r0.f = this.rich_text;
        r0.g = this.references;
        r0.h = this.text_without_citation;
        r0.i = this.cot_text;
        r0.j = this.ai_reply_id;
        r0.k = this.reference_list;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CommonAIReply.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAi_reply_id() {
        return this.ai_reply_id;
    }

    public final String getCot_text() {
        return this.cot_text;
    }

    public final List<ReferenceItem> getReference_list() {
        return this.reference_list;
    }

    public final RichText getReferences() {
        return this.references;
    }

    public final RichText getRich_text() {
        return this.rich_text;
    }

    public final Integer getSequence_id() {
        return this.sequence_id;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final String getText_without_citation() {
        return this.text_without_citation;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public CommonAIReply(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.status = r2.d;
        this.sequence_id = r2.e;
        this.rich_text = r2.f;
        this.references = r2.g;
        this.text_without_citation = r2.h;
        this.cot_text = r2.i;
        this.ai_reply_id = r2.j;
        this.reference_list = com.lark.wire.internal.a.c("reference_list", r2.k);
    }

    public /* synthetic */ CommonAIReply(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
