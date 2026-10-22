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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003%&'B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\u001f\u0010!¨\u0006("}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TextUrlContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TextUrlContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TextUrlContent$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/TextUrlContent$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/TextUrlContent$Type;", "text", "", "getText", "()Ljava/lang/String;", "sequence_id", "", "getSequence_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "url", "getUrl", "title", "getTitle", "summary", "getSummary", "icon", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "is_hidden", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TextUrlContent extends com.lark.wire.Message<TextUrlContent, a> {
    public static final ProtoAdapter<TextUrlContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ImageSet icon;
    private final Boolean is_hidden;
    private final Integer sequence_id;
    private final String summary;
    private final String text;
    private final String title;
    private final Type type;
    private final String url;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TextUrlContent$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TEXT", "URL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type TEXT = null;
        public static final Type UNKNOWN = null;
        public static final Type URL = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return Type.URL;
            L15:
                return Type.TEXT;
            L12:
                return Type.UNKNOWN;
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("TEXT", 1, 1);
            TEXT = r1;
            Type r3 = new Type("URL", 2, 2);
            URL = r3;
            Type[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return URL;
        L15:
            return TEXT;
        L12:
            return UNKNOWN;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<TextUrlContent, a> {
        public Type d;
        public String e;
        public Integer f;
        public String g;
        public String h;
        public String i;
        public ImageSet j;
        public Boolean k;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TextUrlContent(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TextUrlContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final TextUrlContent c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L23;
            if (r4 != 1) goto L8;
            Type r5 = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            Intrinsics.checkNotNullParameter(r5, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            r1.d = r5;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L8:
            if (r4 != 100) goto L9;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L9:
            switch(r4) {
                case 200: goto L16;
                case 201: goto L15;
                case 202: goto L14;
                case 203: goto L13;
                case 204: goto L12;
                case 205: goto L11;
                default: goto L10;
            };
        L11:
            r1.k = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L12:
            r1.j = ImageSet.ADAPTER.c(r10);
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.i = r10.i();
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.h = r10.i();
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.g = r10.i();
            goto L3
        L16:
            r1.f = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L10:
            r10.j(r4);
            Unit r7 = Unit.INSTANCE;
            goto L3
        L23:
            return new TextUrlContent(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TextUrlContent r6) {
            TextUrlContent r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size() + Type.ADAPTER.l(1, r7.getType());
            w r1 = ProtoAdapter.q;
            return ((((((r0 + r1.l(100, r7.getText())) + ProtoAdapter.h.l(com.lark.kmp.server.pb.improto.Packet.DEFAULT_STATUS, r7.getSequence_id())) + r1.l(201, r7.getUrl())) + r1.l(202, r7.getTitle())) + r1.l(203, r7.getSummary())) + ImageSet.ADAPTER.l(204, r7.getIcon())) + ProtoAdapter.g.l(205, r7.is_hidden());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, TextUrlContent r6) {
            TextUrlContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            Type.ADAPTER.i(r5, 1, r7.getType());
            w r0 = ProtoAdapter.q;
            r0.i(r5, 100, r7.getText());
            ProtoAdapter.h.i(r5, com.lark.kmp.server.pb.improto.Packet.DEFAULT_STATUS, r7.getSequence_id());
            r0.i(r5, 201, r7.getUrl());
            r0.i(r5, 202, r7.getTitle());
            r0.i(r5, 203, r7.getSummary());
            ImageSet.ADAPTER.i(r5, 204, r7.getIcon());
            ProtoAdapter.g.i(r5, 205, r7.is_hidden());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, TextUrlContent r6) {
            TextUrlContent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter.g.j(r5, 205, r7.is_hidden());
            ImageSet.ADAPTER.j(r5, 204, r7.getIcon());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 203, r7.getSummary());
            r0.j(r5, 202, r7.getTitle());
            r0.j(r5, 201, r7.getUrl());
            ProtoAdapter.h.j(r5, com.lark.kmp.server.pb.improto.Packet.DEFAULT_STATUS, r7.getSequence_id());
            r0.j(r5, 100, r7.getText());
            Type.ADAPTER.j(r5, 1, r7.getType());
        }

        public b(FieldEncoding r7, KClass<TextUrlContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TextUrlContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TextUrlContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TextUrlContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.text;
        r0.f = this.sequence_id;
        r0.g = this.url;
        r0.h = this.title;
        r0.i = this.summary;
        r0.j = this.icon;
        r0.k = this.is_hidden;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TextUrlContent.class).getSimpleName() + '@' + hashCode();
    }

    public final ImageSet getIcon() {
        return this.icon;
    }

    public final Integer getSequence_id() {
        return this.sequence_id;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Type getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean is_hidden() {
        return this.is_hidden;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TextUrlContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Type r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.type = r4;
        this.text = r2.e;
        this.sequence_id = r2.f;
        this.url = r2.g;
        this.title = r2.h;
        this.summary = r2.i;
        this.icon = r2.j;
        this.is_hidden = r2.k;
    }

    public /* synthetic */ TextUrlContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
