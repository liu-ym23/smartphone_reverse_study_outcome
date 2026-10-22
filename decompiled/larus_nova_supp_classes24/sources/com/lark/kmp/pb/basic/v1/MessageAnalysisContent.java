package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0017\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageAnalysisContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageAnalysisContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageAnalysisContent$Builder;Lokio/ByteString;)V", "content", "", "getContent", "()Ljava/lang/String;", "jump_url", "getJump_url", "rich_text", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getRich_text", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "button", "", "Lcom/lark/kmp/pb/basic/v1/Button;", "getButton", "()Ljava/util/List;", "is_closed", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MessageAnalysisContent extends com.lark.wire.Message<MessageAnalysisContent, a> {
    public static final ProtoAdapter<MessageAnalysisContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<Button> button;
    private final String content;
    private final Boolean is_closed;
    private final String jump_url;
    private final RichText rich_text;

    public static final class a extends com.lark.wire.Message.a<MessageAnalysisContent, a> {
        public String d;
        public String e;
        public RichText f;
        public List<Button> g;
        public Boolean h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MessageAnalysisContent(this, c(), null);
        }

        public a() {
            this.g = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<MessageAnalysisContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final MessageAnalysisContent c(g0 r8) {
            Intrinsics.checkNotNullParameter(r8, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r8.c();
        L3:
            int r5 = r8.e();
            if (r5 == (-1)) goto L21;
            if (r5 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.d = r8.i();
            goto L3
        L8:
            if (r5 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r8, "reader");
            r1.e = r8.i();
            goto L3
        L10:
            if (r5 != 3) goto L12;
            r1.f = RichText.ADAPTER.c(r8);
            goto L3
        L12:
            if (r5 != 4) goto L14;
            r2.add(Button.ADAPTER.c(r8));
            goto L3
        L14:
            if (r5 != 5) goto L15;
            r1.h = (Boolean) ProtoAdapter.g.c(r8);
            goto L3
        L15:
            r8.j(r5);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L21:
            ByteString r9 = r8.d(r3);
            Intrinsics.checkNotNullParameter(r2, "button");
            com.lark.wire.internal.a.a(r2);
            r1.g = r2;
            return new MessageAnalysisContent(r1, r9, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MessageAnalysisContent r5) {
            MessageAnalysisContent r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((((r0 + r1.l(1, r6.getContent())) + r1.l(2, r6.getJump_url())) + RichText.ADAPTER.l(3, r6.getRich_text())) + Button.ADAPTER.a().l(4, r6.getButton())) + ProtoAdapter.g.l(5, r6.is_closed());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, MessageAnalysisContent r5) {
            MessageAnalysisContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getContent());
            r0.i(r4, 2, r6.getJump_url());
            RichText.ADAPTER.i(r4, 3, r6.getRich_text());
            Button.ADAPTER.a().i(r4, 4, r6.getButton());
            ProtoAdapter.g.i(r4, 5, r6.is_closed());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, MessageAnalysisContent r5) {
            MessageAnalysisContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 5, r6.is_closed());
            Button.ADAPTER.a().j(r4, 4, r6.getButton());
            RichText.ADAPTER.j(r4, 3, r6.getRich_text());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 2, r6.getJump_url());
            r0.j(r4, 1, r6.getContent());
        }

        public b(FieldEncoding r7, KClass<MessageAnalysisContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.MessageAnalysisContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MessageAnalysisContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageAnalysisContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.content;
        r0.e = this.jump_url;
        r0.f = this.rich_text;
        r0.g = this.button;
        r0.h = this.is_closed;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MessageAnalysisContent.class).getSimpleName() + '@' + hashCode();
    }

    public final List<Button> getButton() {
        return this.button;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getJump_url() {
        return this.jump_url;
    }

    public final RichText getRich_text() {
        return this.rich_text;
    }

    public final Boolean is_closed() {
        return this.is_closed;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MessageAnalysisContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.content = r2.d;
        this.jump_url = r2.e;
        this.rich_text = r2.f;
        this.button = com.lark.wire.internal.a.c("button", r2.g);
        this.is_closed = r2.h;
    }

    public /* synthetic */ MessageAnalysisContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
