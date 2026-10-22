package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Deprecated;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005$%&'(B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001b\u0010\u001dR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b \u0010\u0011R\u0015\u0010!\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b!\u0010\u001d¨\u0006)"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/File;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/File$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/File$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "name", "getName", "size", "", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "mime", "getMime", "path", "getPath", "extra", "Lcom/lark/kmp/pb/basic/v1/File$Extra;", "getExtra", "()Lcom/lark/kmp/pb/basic/v1/File$Extra;", "is_destroyed", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "scene_id", "getScene_id", "is_folder", "newBuilder", "toString", "Builder", "Companion", "EntityType", "Source", "Extra", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class File extends com.lark.wire.Message<File, a> {
    public static final ProtoAdapter<File> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_MIME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PATH = "";
    public static final long DEFAULT_SIZE = 0;
    private static final long serialVersionUID = 0;
    private final Extra extra;
    private final Boolean is_destroyed;
    private final Boolean is_folder;
    private final String key;
    private final String mime;
    private final String name;
    private final String path;
    private final Long scene_id;
    private final Long size;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/File$EntityType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MESSAGE", "EMAIL", "CARD_FILE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum EntityType extends Enum<EntityType> implements o0 {
        public static final ProtoAdapter<EntityType> ADAPTER = null;
        public static final EntityType CARD_FILE = null;
        public static final b Companion = null;

        @Deprecated(message = "EMAIL is deprecated")
        public static final EntityType EMAIL = null;
        public static final EntityType MESSAGE = null;
        public static final /* synthetic */ EntityType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<EntityType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                EntityType.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 16) goto L14;
                return null;
            L14:
                return EntityType.CARD_FILE;
            L15:
                return EntityType.EMAIL;
            L12:
                return EntityType.MESSAGE;
            }

            public a(KClass<EntityType> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<EntityType> getEntries() {
            return b;
        }

        static {
            EntityType r0 = new EntityType("MESSAGE", 0, 1);
            MESSAGE = r0;
            EntityType r1 = new EntityType("EMAIL", 1, 2);
            EMAIL = r1;
            EntityType r4 = new EntityType("CARD_FILE", 2, 16);
            CARD_FILE = r4;
            EntityType[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(EntityType.class), Syntax.PROTO_2);
        }

        public static EntityType[] values() {
            return (EntityType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final EntityType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 16) goto L14;
            return null;
        L14:
            return CARD_FILE;
        L15:
            return EMAIL;
        L12:
            return MESSAGE;
        }

        public static EntityType valueOf(String r1) {
            return (EntityType) r27.a.a(EntityType.class, r1);
        }

        public EntityType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/File$Extra;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/File$Extra$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/File$Extra$Builder;Lokio/ByteString;)V", "thumbnail", "Lcom/lark/kmp/pb/basic/v1/Image;", "getThumbnail", "()Lcom/lark/kmp/pb/basic/v1/Image;", "source", "Lcom/lark/kmp/pb/basic/v1/File$Source;", "getSource", "()Lcom/lark/kmp/pb/basic/v1/File$Source;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Extra extends com.lark.wire.Message<Extra, a> {
        public static final ProtoAdapter<Extra> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Source source;
        private final Image thumbnail;

        public static final class a extends com.lark.wire.Message.a<Extra, a> {
            public Image d;
            public Source e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Extra(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Extra> {
            @Override // com.lark.wire.ProtoAdapter
            public final Extra c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = Image.ADAPTER.c(r9);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = Source.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L9:
                r9.j(r3);
                goto L3
            L16:
                return new Extra(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Extra r5) {
                Extra r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + Image.ADAPTER.l(1, r6.getThumbnail())) + Source.ADAPTER.l(2, r6.getSource());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Extra r5) {
                Extra r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Image.ADAPTER.i(r4, 1, r6.getThumbnail());
                Source.ADAPTER.i(r4, 2, r6.getSource());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Extra r5) {
                Extra r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                Source.ADAPTER.j(r4, 2, r6.getSource());
                Image.ADAPTER.j(r4, 1, r6.getThumbnail());
            }

            public b(FieldEncoding r7, KClass<Extra> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.File.Extra", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Extra(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Extra.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.thumbnail;
            r0.e = this.source;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Extra.class).getSimpleName() + '@' + hashCode();
        }

        public final Source getSource() {
            return this.source;
        }

        public final Image getThumbnail() {
            return this.thumbnail;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Extra(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.thumbnail = r2.d;
            this.source = r2.e;
        }

        public /* synthetic */ Extra(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/File$Source;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "LARK_SERVER", "NUT_STORE", "LAN_TRANS", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Source extends Enum<Source> implements o0 {
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final b Companion = null;
        public static final Source LAN_TRANS = null;
        public static final Source LARK_SERVER = null;
        public static final Source NUT_STORE = null;
        public static final Source UNKNOWN = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Source> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Source.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return Source.LAN_TRANS;
            L18:
                return Source.NUT_STORE;
            L19:
                return Source.LARK_SERVER;
            L15:
                return Source.UNKNOWN;
            }

            public a(KClass<Source> r1, Syntax r2, Source r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Source r1 = new Source("LARK_SERVER", 1, 1);
            LARK_SERVER = r1;
            Source r3 = new Source("NUT_STORE", 2, 2);
            NUT_STORE = r3;
            Source r5 = new Source("LAN_TRANS", 3, 3);
            LAN_TRANS = r5;
            Source[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Source.class), Syntax.PROTO_2, r0);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Source fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return LAN_TRANS;
        L18:
            return NUT_STORE;
        L19:
            return LARK_SERVER;
        L15:
            return UNKNOWN;
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<File, a> {
        public String d;
        public String e;
        public Long f;
        public String g;
        public String h;
        public Extra i;
        public Boolean j;
        public Long k;
        public Boolean l;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new File(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<File> {
        @Override // com.lark.wire.ProtoAdapter
        public final File c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L17;
            switch(r4) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r1.l = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L8:
            r1.k = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L9:
            r1.j = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L10:
            r1.i = Extra.ADAPTER.c(r7);
            goto L3
        L11:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.h = r7.i();
            goto L3
        L12:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.g = r7.i();
            goto L3
        L13:
            r1.f = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.e = r7.i();
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L6:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L17:
            return new File(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(File r6) {
            File r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.l(1, r7.getKey())) + r1.l(2, r7.getName());
            t r3 = ProtoAdapter.k;
            int r4 = (((r2 + r3.l(3, r7.getSize())) + r1.l(4, r7.getMime())) + r1.l(5, r7.getPath())) + Extra.ADAPTER.l(6, r7.getExtra());
            l r5 = ProtoAdapter.g;
            return ((r4 + r5.l(7, r7.is_destroyed())) + r3.l(8, r7.getScene_id())) + r5.l(9, r7.is_folder());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, File r6) {
            File r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getKey());
            r0.i(r5, 2, r7.getName());
            t r1 = ProtoAdapter.k;
            r1.i(r5, 3, r7.getSize());
            r0.i(r5, 4, r7.getMime());
            r0.i(r5, 5, r7.getPath());
            Extra.ADAPTER.i(r5, 6, r7.getExtra());
            l r2 = ProtoAdapter.g;
            r2.i(r5, 7, r7.is_destroyed());
            r1.i(r5, 8, r7.getScene_id());
            r2.i(r5, 9, r7.is_folder());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, File r6) {
            File r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            l r0 = ProtoAdapter.g;
            r0.j(r5, 9, r7.is_folder());
            t r1 = ProtoAdapter.k;
            r1.j(r5, 8, r7.getScene_id());
            r0.j(r5, 7, r7.is_destroyed());
            Extra.ADAPTER.j(r5, 6, r7.getExtra());
            w r2 = ProtoAdapter.q;
            r2.j(r5, 5, r7.getPath());
            r2.j(r5, 4, r7.getMime());
            r1.j(r5, 3, r7.getSize());
            r2.j(r5, 2, r7.getName());
            r2.j(r5, 1, r7.getKey());
        }

        public b(FieldEncoding r7, KClass<File> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.File", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ File(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(File.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.key;
        r0.e = this.name;
        r0.f = this.size;
        r0.g = this.mime;
        r0.h = this.path;
        r0.i = this.extra;
        r0.j = this.is_destroyed;
        r0.k = this.scene_id;
        r0.l = this.is_folder;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(File.class).getSimpleName() + '@' + hashCode();
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getMime() {
        return this.mime;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final Long getScene_id() {
        return this.scene_id;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Boolean is_destroyed() {
        return this.is_destroyed;
    }

    public final Boolean is_folder() {
        return this.is_folder;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public File(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.key = r2.d;
        this.name = r2.e;
        this.size = r2.f;
        this.mime = r2.g;
        this.path = r2.h;
        this.extra = r2.i;
        this.is_destroyed = r2.j;
        this.scene_id = r2.k;
        this.is_folder = r2.l;
    }

    public /* synthetic */ File(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
