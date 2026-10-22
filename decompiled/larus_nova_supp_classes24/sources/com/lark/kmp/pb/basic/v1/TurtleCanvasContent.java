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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TurtleCanvasContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TurtleCanvasContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TurtleCanvasContent$Builder;Lokio/ByteString;)V", "script_key", "", "getScript_key", "()Ljava/lang/String;", "script_version", "", "getScript_version", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "script_path", "getScript_path", "data", "getData", "()Lokio/ByteString;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TurtleCanvasContent extends com.lark.wire.Message<TurtleCanvasContent, a> {
    public static final ProtoAdapter<TurtleCanvasContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ByteString data;
    private final String script_key;
    private final String script_path;
    private final Integer script_version;

    public static final class a extends com.lark.wire.Message.a<TurtleCanvasContent, a> {
        public String d;
        public Integer e;
        public String f;
        public ByteString g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TurtleCanvasContent(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TurtleCanvasContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final TurtleCanvasContent c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.f = r7.i();
            goto L3
        L12:
            if (r4 != 4) goto L13;
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.g = r7.f();
            goto L3
        L13:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L19:
            return new TurtleCanvasContent(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TurtleCanvasContent r6) {
            TurtleCanvasContent r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((r0 + r1.l(1, r7.getScript_key())) + ProtoAdapter.h.l(2, r7.getScript_version())) + r1.l(3, r7.getScript_path())) + ProtoAdapter.p.l(4, r7.getData());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, TurtleCanvasContent r6) {
            TurtleCanvasContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getScript_key());
            ProtoAdapter.h.i(r5, 2, r7.getScript_version());
            r0.i(r5, 3, r7.getScript_path());
            ProtoAdapter.p.i(r5, 4, r7.getData());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, TurtleCanvasContent r6) {
            TurtleCanvasContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter.p.j(r5, 4, r7.getData());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 3, r7.getScript_path());
            ProtoAdapter.h.j(r5, 2, r7.getScript_version());
            r0.j(r5, 1, r7.getScript_key());
        }

        public b(FieldEncoding r7, KClass<TurtleCanvasContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TurtleCanvasContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TurtleCanvasContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TurtleCanvasContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.script_key;
        r0.e = this.script_version;
        r0.f = this.script_path;
        r0.g = this.data;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TurtleCanvasContent.class).getSimpleName() + '@' + hashCode();
    }

    public final ByteString getData() {
        return this.data;
    }

    public final String getScript_key() {
        return this.script_key;
    }

    public final String getScript_path() {
        return this.script_path;
    }

    public final Integer getScript_version() {
        return this.script_version;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TurtleCanvasContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.script_key = r2.d;
        this.script_version = r2.e;
        this.script_path = r2.f;
        this.data = r2.g;
    }

    public /* synthetic */ TurtleCanvasContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
