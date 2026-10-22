package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003./0B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\u0015\u0010!\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001bR\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Doc;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Doc$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Doc$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "url", "getUrl", "type", "Lcom/lark/kmp/pb/basic/v1/Doc$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Doc$Type;", "name", "getName", "icon_key", "getIcon_key", "abstract", "getAbstract", "create_time", "", "getCreate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "update_time", "getUpdate_time", "owner_name", "getOwner_name", "owner_id", "getOwner_id", "icon", "Lcom/lark/kmp/pb/basic/v1/Icon;", "getIcon", "()Lcom/lark/kmp/pb/basic/v1/Icon;", "tags", "", "Lcom/lark/kmp/pb/basic/v1/Tag;", "getTags", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Doc extends com.lark.wire.Message<Doc, a> {
    public static final ProtoAdapter<Doc> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: abstract, reason: not valid java name */
    private final String f1abstract;
    private final Long create_time;
    private final Icon icon;
    private final String icon_key;
    private final String key;
    private final String name;
    private final Long owner_id;
    private final String owner_name;
    private final List<Tag> tags;
    private final Type type;
    private final Long update_time;
    private final String url;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Doc$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DOC", "SHEET", "BITABLE", "MINDNOTE", "FILE", "SLIDE", "WIKI", "DOCX", "FOLDER", "CATALOG", "SLIDES", "SHORTCUT", "DOCX_SYNCED_BLOCK", "MIAODA", "MIAODA_APP_DEVELOPMENT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type BITABLE = null;
        public static final Type CATALOG = null;
        public static final b Companion = null;
        public static final Type DOC = null;
        public static final Type DOCX = null;
        public static final Type DOCX_SYNCED_BLOCK = null;
        public static final Type FILE = null;
        public static final Type FOLDER = null;
        public static final Type MIAODA = null;
        public static final Type MIAODA_APP_DEVELOPMENT = null;
        public static final Type MINDNOTE = null;
        public static final Type SHEET = null;
        public static final Type SHORTCUT = null;
        public static final Type SLIDE = null;
        public static final Type SLIDES = null;
        public static final Type UNKNOWN = null;
        public static final Type WIKI = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r0) {
                switch(r0) {
                    case 0: goto L20;
                    case 1: goto L36;
                    case 2: goto L35;
                    case 3: goto L34;
                    case 4: goto L33;
                    case 5: goto L32;
                    case 6: goto L31;
                    case 7: goto L30;
                    case 8: goto L29;
                    case 9: goto L28;
                    case 10: goto L27;
                    case 11: goto L26;
                    case 12: goto L25;
                    case 13: goto L24;
                    case 14: goto L23;
                    case 15: goto L22;
                    default: goto L3;
                };
            L3:
                return null;
            L22:
                return Type.MIAODA_APP_DEVELOPMENT;
            L23:
                return Type.MIAODA;
            L24:
                return Type.DOCX_SYNCED_BLOCK;
            L25:
                return Type.SHORTCUT;
            L26:
                return Type.SLIDES;
            L27:
                return Type.CATALOG;
            L28:
                return Type.FOLDER;
            L29:
                return Type.DOCX;
            L30:
                return Type.WIKI;
            L31:
                return Type.SLIDE;
            L32:
                return Type.FILE;
            L33:
                return Type.MINDNOTE;
            L34:
                return Type.BITABLE;
            L35:
                return Type.SHEET;
            L36:
                return Type.DOC;
            L20:
                return Type.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("DOC", 1, 1);
            DOC = r1;
            Type r3 = new Type("SHEET", 2, 2);
            SHEET = r3;
            Type r5 = new Type("BITABLE", 3, 3);
            BITABLE = r5;
            Type r7 = new Type("MINDNOTE", 4, 4);
            MINDNOTE = r7;
            Type r9 = new Type("FILE", 5, 5);
            FILE = r9;
            Type r11 = new Type("SLIDE", 6, 6);
            SLIDE = r11;
            Type r13 = new Type("WIKI", 7, 7);
            WIKI = r13;
            Type r15 = new Type("DOCX", 8, 8);
            DOCX = r15;
            Type r14 = new Type("FOLDER", 9, 9);
            FOLDER = r14;
            Type r12 = new Type("CATALOG", 10, 10);
            CATALOG = r12;
            Type r10 = new Type("SLIDES", 11, 11);
            SLIDES = r10;
            Type r8 = new Type("SHORTCUT", 12, 12);
            SHORTCUT = r8;
            Type r6 = new Type("DOCX_SYNCED_BLOCK", 13, 13);
            DOCX_SYNCED_BLOCK = r6;
            Type r4 = new Type("MIAODA", 14, 14);
            MIAODA = r4;
            Type r2 = new Type("MIAODA_APP_DEVELOPMENT", 15, 15);
            MIAODA_APP_DEVELOPMENT = r2;
            Type[] r16 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
            a = r16;
            b = EnumEntriesKt.enumEntries(r16);
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

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<Doc, a> {
        public String d;
        public String e;
        public Type f;
        public String g;
        public String h;
        public String i;
        public Long j;
        public Long k;
        public String l;
        public Long m;
        public Icon n;
        public List<? extends Tag> o;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Doc(this, c(), null);
        }

        public a() {
            this.o = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Doc> {
        @Override // com.lark.wire.ProtoAdapter
        public final Doc c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L26;
            switch(r5) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L30;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L28;
                default: goto L6;
            };
        L28:
            Tag.ADAPTER.m(r11, r2);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L11:
            Unit r6 = Unit.INSTANCE;
        L9:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L11
        L30:
            r1.f = Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L12:
            r1.n = Icon.ADAPTER.c(r11);
            goto L3
        L13:
            r1.m = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.l = r11.i();
            goto L3
        L15:
            r1.k = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L16:
            r1.j = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L17:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.i = r11.i();
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.h = r11.i();
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.g = r11.i();
            goto L3
        L24:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.e = r11.i();
            goto L3
        L25:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.d = r11.i();
            goto L3
        L6:
            r11.j(r5);
            Unit r8 = Unit.INSTANCE;
            goto L3
        L26:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "tags");
            com.lark.wire.internal.a.a(r2);
            r1.o = r2;
            return new Doc(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Doc r6) {
            Doc r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (((((r0 + r1.l(1, r7.getKey())) + r1.l(2, r7.getUrl())) + Type.ADAPTER.l(3, r7.getType())) + r1.l(4, r7.getName())) + r1.l(5, r7.getIcon_key())) + r1.l(6, r7.getAbstract());
            t r3 = ProtoAdapter.k;
            return (((((r2 + r3.l(7, r7.getCreate_time())) + r3.l(8, r7.getUpdate_time())) + r1.l(9, r7.getOwner_name())) + r3.l(10, r7.getOwner_id())) + Icon.ADAPTER.l(11, r7.getIcon())) + Tag.ADAPTER.a().l(12, r7.getTags());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, Doc r6) {
            Doc r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getKey());
            r0.i(r5, 2, r7.getUrl());
            Type.ADAPTER.i(r5, 3, r7.getType());
            r0.i(r5, 4, r7.getName());
            r0.i(r5, 5, r7.getIcon_key());
            r0.i(r5, 6, r7.getAbstract());
            t r1 = ProtoAdapter.k;
            r1.i(r5, 7, r7.getCreate_time());
            r1.i(r5, 8, r7.getUpdate_time());
            r0.i(r5, 9, r7.getOwner_name());
            r1.i(r5, 10, r7.getOwner_id());
            Icon.ADAPTER.i(r5, 11, r7.getIcon());
            Tag.ADAPTER.a().i(r5, 12, r7.getTags());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, Doc r6) {
            Doc r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            Tag.ADAPTER.a().j(r5, 12, r7.getTags());
            Icon.ADAPTER.j(r5, 11, r7.getIcon());
            t r0 = ProtoAdapter.k;
            r0.j(r5, 10, r7.getOwner_id());
            w r1 = ProtoAdapter.q;
            r1.j(r5, 9, r7.getOwner_name());
            r0.j(r5, 8, r7.getUpdate_time());
            r0.j(r5, 7, r7.getCreate_time());
            r1.j(r5, 6, r7.getAbstract());
            r1.j(r5, 5, r7.getIcon_key());
            r1.j(r5, 4, r7.getName());
            Type.ADAPTER.j(r5, 3, r7.getType());
            r1.j(r5, 2, r7.getUrl());
            r1.j(r5, 1, r7.getKey());
        }

        public b(FieldEncoding r7, KClass<Doc> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Doc", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Doc(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Doc.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.key;
        r0.e = this.url;
        r0.f = this.type;
        r0.g = this.name;
        r0.h = this.icon_key;
        r0.i = this.f1abstract;
        r0.j = this.create_time;
        r0.k = this.update_time;
        r0.l = this.owner_name;
        r0.m = this.owner_id;
        r0.n = this.icon;
        r0.o = this.tags;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Doc.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAbstract() {
        return this.f1abstract;
    }

    public final Long getCreate_time() {
        return this.create_time;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final String getIcon_key() {
        return this.icon_key;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getOwner_id() {
        return this.owner_id;
    }

    public final String getOwner_name() {
        return this.owner_name;
    }

    public final List<Tag> getTags() {
        return this.tags;
    }

    public final Type getType() {
        return this.type;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Doc(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.key = r2.d;
        this.url = r2.e;
        this.type = r2.f;
        this.name = r2.g;
        this.icon_key = r2.h;
        this.f1abstract = r2.i;
        this.create_time = r2.j;
        this.update_time = r2.k;
        this.owner_name = r2.l;
        this.owner_id = r2.m;
        this.icon = r2.n;
        this.tags = com.lark.wire.internal.a.c("tags", r2.o);
    }

    public /* synthetic */ Doc(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
