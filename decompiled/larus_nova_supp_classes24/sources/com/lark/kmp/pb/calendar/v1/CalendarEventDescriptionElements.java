package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements$Builder;Lokio/ByteString;)V", "elements", "", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements$DescriptionElement;", "getElements", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "ElementType", "DescriptionElement", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarEventDescriptionElements extends Message<CalendarEventDescriptionElements, a> {
    public static final ProtoAdapter<CalendarEventDescriptionElements> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<DescriptionElement> elements;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0017\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements$DescriptionElement;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements$DescriptionElement$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements$DescriptionElement$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements$ElementType;", "getType", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements$ElementType;", "text", "", "getText", "()Ljava/lang/String;", "url", "getUrl", "doc_type", "", "getDoc_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_doc_invalid", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DescriptionElement extends Message<DescriptionElement, a> {
        public static final ProtoAdapter<DescriptionElement> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer doc_type;
        private final Boolean is_doc_invalid;
        private final String text;
        private final ElementType type;
        private final String url;

        public static final class a extends Message.a<DescriptionElement, a> {
            public ElementType d;
            public String e;
            public String f;
            public Integer g;
            public Boolean h;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new DescriptionElement(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<DescriptionElement> {
            @Override // com.lark.wire.ProtoAdapter
            public final DescriptionElement c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L25;
                if (r4 != 1) goto L8;
                r1.d = ElementType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.f = r10.i();
                goto L3
            L12:
                if (r4 != 11) goto L14;
                r1.g = (Integer) ProtoAdapter.h.c(r10);
                goto L3
            L14:
                if (r4 != 12) goto L15;
                r1.h = (Boolean) ProtoAdapter.g.c(r10);
                goto L3
            L15:
                r10.j(r4);
                Unit r6 = Unit.INSTANCE;
                goto L3
            L25:
                return new DescriptionElement(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(DescriptionElement r5) {
                DescriptionElement r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size() + ElementType.ADAPTER.l(1, r6.getType());
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(2, r6.getText())) + r1.l(3, r6.getUrl())) + ProtoAdapter.h.l(11, r6.getDoc_type())) + ProtoAdapter.g.l(12, r6.is_doc_invalid());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, DescriptionElement r5) {
                DescriptionElement r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ElementType.ADAPTER.i(r4, 1, r6.getType());
                w r0 = ProtoAdapter.q;
                r0.i(r4, 2, r6.getText());
                r0.i(r4, 3, r6.getUrl());
                ProtoAdapter.h.i(r4, 11, r6.getDoc_type());
                ProtoAdapter.g.i(r4, 12, r6.is_doc_invalid());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, DescriptionElement r5) {
                DescriptionElement r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 12, r6.is_doc_invalid());
                ProtoAdapter.h.j(r4, 11, r6.getDoc_type());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 3, r6.getUrl());
                r0.j(r4, 2, r6.getText());
                ElementType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<DescriptionElement> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventDescriptionElements.DescriptionElement", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ DescriptionElement(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DescriptionElement.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.text;
            r0.f = this.url;
            r0.g = this.doc_type;
            r0.h = this.is_doc_invalid;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DescriptionElement.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getDoc_type() {
            return this.doc_type;
        }

        public final String getText() {
            return this.text;
        }

        public final ElementType getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Boolean is_doc_invalid() {
            return this.is_doc_invalid;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public DescriptionElement(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.text = r2.e;
            this.url = r2.f;
            this.doc_type = r2.g;
            this.is_doc_invalid = r2.h;
        }

        public /* synthetic */ DescriptionElement(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventDescriptionElements$ElementType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TEXT", "URL", "DOC", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ElementType extends Enum<ElementType> implements o0 {
        public static final ProtoAdapter<ElementType> ADAPTER = null;
        public static final b Companion = null;
        public static final ElementType DOC = null;
        public static final ElementType TEXT = null;
        public static final ElementType UNKNOWN = null;
        public static final ElementType URL = null;
        public static final /* synthetic */ ElementType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ElementType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ElementType.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return ElementType.DOC;
            L18:
                return ElementType.URL;
            L19:
                return ElementType.TEXT;
            L15:
                return ElementType.UNKNOWN;
            }

            public a(KClass<ElementType> r1, Syntax r2, ElementType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ElementType> getEntries() {
            return b;
        }

        static {
            ElementType r0 = new ElementType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ElementType r1 = new ElementType("TEXT", 1, 1);
            TEXT = r1;
            ElementType r3 = new ElementType("URL", 2, 2);
            URL = r3;
            ElementType r5 = new ElementType("DOC", 3, 3);
            DOC = r5;
            ElementType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ElementType.class), Syntax.PROTO_2, r0);
        }

        public static ElementType[] values() {
            return (ElementType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ElementType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return DOC;
        L18:
            return URL;
        L19:
            return TEXT;
        L15:
            return UNKNOWN;
        }

        public static ElementType valueOf(String r1) {
            return (ElementType) r27.a.a(ElementType.class, r1);
        }

        public ElementType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<CalendarEventDescriptionElements, a> {
        public List<DescriptionElement> d;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarEventDescriptionElements(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<CalendarEventDescriptionElements> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarEventDescriptionElements c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L9;
            if (r4 == 1) goto L7;
            r7.j(r4);
            goto L3
        L7:
            r1.add(DescriptionElement.ADAPTER.c(r7));
            goto L3
        L9:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "elements");
            com.lark.wire.internal.a.a(r1);
            r0.d = r1;
            return new CalendarEventDescriptionElements(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarEventDescriptionElements r4) {
            CalendarEventDescriptionElements r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "value");
            return r5.unknownFields().size() + DescriptionElement.ADAPTER.a().l(1, r5.getElements());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarEventDescriptionElements r5) {
            CalendarEventDescriptionElements r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            DescriptionElement.ADAPTER.a().i(r4, 1, r6.getElements());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r3, CalendarEventDescriptionElements r4) {
            CalendarEventDescriptionElements r5 = r4;
            Intrinsics.checkNotNullParameter(r3, "writer");
            Intrinsics.checkNotNullParameter(r5, "value");
            r3.d(r5.unknownFields());
            DescriptionElement.ADAPTER.a().j(r3, 1, r5.getElements());
        }

        public b(FieldEncoding r7, KClass<CalendarEventDescriptionElements> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventDescriptionElements", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarEventDescriptionElements(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEventDescriptionElements.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.elements;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarEventDescriptionElements.class).getSimpleName() + '@' + hashCode();
    }

    public final List<DescriptionElement> getElements() {
        return this.elements;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarEventDescriptionElements(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.elements = com.lark.wire.internal.a.c("elements", r2.d);
    }

    public /* synthetic */ CalendarEventDescriptionElements(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
