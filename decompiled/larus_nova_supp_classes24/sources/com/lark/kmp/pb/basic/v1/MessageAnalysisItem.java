package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageAnalysisItem;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageAnalysisItem$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageAnalysisItem$Builder;Lokio/ByteString;)V", "name", "", "getName", "()Ljava/lang/String;", "icon_url", "getIcon_url", "jump_url", "getJump_url", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MessageAnalysisItem extends com.lark.wire.Message<MessageAnalysisItem, a> {
    public static final ProtoAdapter<MessageAnalysisItem> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String icon_url;
    private final String jump_url;
    private final String name;

    public static final class a extends com.lark.wire.Message.a<MessageAnalysisItem, a> {
        public String d;
        public String e;
        public String f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MessageAnalysisItem(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<MessageAnalysisItem> {
        @Override // com.lark.wire.ProtoAdapter
        public final MessageAnalysisItem c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L16;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.e = r7.i();
            goto L3
        L10:
            if (r4 != 3) goto L11;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.f = r7.i();
            goto L3
        L11:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L16:
            return new MessageAnalysisItem(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MessageAnalysisItem r5) {
            MessageAnalysisItem r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return ((r0 + r1.l(1, r6.getName())) + r1.l(2, r6.getIcon_url())) + r1.l(3, r6.getJump_url());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, MessageAnalysisItem r5) {
            MessageAnalysisItem r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getName());
            r0.i(r4, 2, r6.getIcon_url());
            r0.i(r4, 3, r6.getJump_url());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, MessageAnalysisItem r5) {
            MessageAnalysisItem r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 3, r6.getJump_url());
            r0.j(r4, 2, r6.getIcon_url());
            r0.j(r4, 1, r6.getName());
        }

        public b(FieldEncoding r7, KClass<MessageAnalysisItem> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.MessageAnalysisItem", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MessageAnalysisItem(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageAnalysisItem.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.name;
        r0.e = this.icon_url;
        r0.f = this.jump_url;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MessageAnalysisItem.class).getSimpleName() + '@' + hashCode();
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final String getJump_url() {
        return this.jump_url;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MessageAnalysisItem(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.name = r2.d;
        this.icon_url = r2.e;
        this.jump_url = r2.f;
    }

    public /* synthetic */ MessageAnalysisItem(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
