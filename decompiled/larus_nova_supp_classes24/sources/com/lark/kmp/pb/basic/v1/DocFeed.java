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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003:;<B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00108\u001a\u00020\u0002H\u0016J\b\u00109\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000bR\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010(\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0002\u0010+\u001a\u0004\b(\u0010*R\u0015\u0010,\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u00101\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0002\u0010+\u001a\u0004\b1\u0010*R\u0015\u00102\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0002\u0010+\u001a\u0004\b2\u0010*R\u0017\u00103\u001a\b\u0012\u0004\u0012\u0002040%¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0013\u00106\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000b¨\u0006="}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocFeed;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/DocFeed$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/DocFeed$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "title", "getTitle", "type", "Lcom/lark/kmp/pb/basic/v1/DocFeed$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/DocFeed$Type;", "icon_key", "getIcon_key", "doc_url", "getDoc_url", "create_time", "", "getCreate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "update_time", "getUpdate_time", "owner_id", "getOwner_id", "new_message_count", "", "getNew_message_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "doc_message_ids", "", "getDoc_message_ids", "()Ljava/util/List;", "is_deleted", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_remind", "feed_type", "Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "getFeed_type", "()Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "is_cross_tenant", "is_shortcut", "tags", "Lcom/lark/kmp/pb/basic/v1/Tag;", "getTags", "icon_info", "getIcon_info", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class DocFeed extends com.lark.wire.Message<DocFeed, a> {
    public static final ProtoAdapter<DocFeed> ADAPTER = null;
    public static final c Companion = null;
    public static final long DEFAULT_CREATE_TIME = 0;
    public static final String DEFAULT_DOC_URL = "";
    public static final FeedCard.FeedType DEFAULT_FEED_TYPE = null;
    public static final String DEFAULT_ICON_INFO = "";
    public static final String DEFAULT_ICON_KEY = "";
    public static final boolean DEFAULT_IS_CROSS_TENANT = false;
    public static final boolean DEFAULT_IS_DELETED = false;
    public static final boolean DEFAULT_IS_REMIND = false;
    public static final boolean DEFAULT_IS_SHORTCUT = false;
    public static final int DEFAULT_NEW_MESSAGE_COUNT = 0;
    public static final String DEFAULT_OWNER_ID = "";
    public static final String DEFAULT_TITLE = "";
    public static final Type DEFAULT_TYPE = null;
    public static final long DEFAULT_UPDATE_TIME = 0;
    private static final long serialVersionUID = 0;
    private final Long create_time;
    private final List<String> doc_message_ids;
    private final String doc_url;
    private final FeedCard.FeedType feed_type;
    private final String icon_info;
    private final String icon_key;
    private final String id;
    private final Boolean is_cross_tenant;
    private final Boolean is_deleted;
    private final Boolean is_remind;
    private final Boolean is_shortcut;
    private final Integer new_message_count;
    private final String owner_id;
    private final List<Tag> tags;
    private final String title;
    private final Type type;
    private final Long update_time;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DocFeed$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DOC", "SHEET", "BITABLE", "MINDNOTE", "FILE", "SLIDE", "WIKI", "DOCX", "FOLDER", "CATALOG", "SLIDES", "SHORTCUT", "DOCX_SYNCED_BLOCK", "MIAODA", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
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
                    case 0: goto L19;
                    case 1: goto L34;
                    case 2: goto L33;
                    case 3: goto L32;
                    case 4: goto L31;
                    case 5: goto L30;
                    case 6: goto L29;
                    case 7: goto L28;
                    case 8: goto L27;
                    case 9: goto L26;
                    case 10: goto L25;
                    case 11: goto L24;
                    case 12: goto L23;
                    case 13: goto L22;
                    case 14: goto L21;
                    default: goto L3;
                };
            L3:
                return null;
            L21:
                return Type.MIAODA;
            L22:
                return Type.DOCX_SYNCED_BLOCK;
            L23:
                return Type.SHORTCUT;
            L24:
                return Type.SLIDES;
            L25:
                return Type.CATALOG;
            L26:
                return Type.FOLDER;
            L27:
                return Type.DOCX;
            L28:
                return Type.WIKI;
            L29:
                return Type.SLIDE;
            L30:
                return Type.FILE;
            L31:
                return Type.MINDNOTE;
            L32:
                return Type.BITABLE;
            L33:
                return Type.SHEET;
            L34:
                return Type.DOC;
            L19:
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
            Type[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
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

    public static final class a extends com.lark.wire.Message.a<DocFeed, a> {
        public String d;
        public String e;
        public Type f;
        public String g;
        public String h;
        public Long i;
        public Long j;
        public String k;
        public Integer l;
        public List<String> m;
        public Boolean n;
        public Boolean o;
        public FeedCard.FeedType p;
        public Boolean q;
        public Boolean r;
        public List<? extends Tag> s;
        public String t;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new DocFeed(this, c(), null);
        }

        public a() {
            this.m = CollectionsKt.emptyList();
            this.s = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<DocFeed> {
        @Override // com.lark.wire.ProtoAdapter
        public final DocFeed c(g0 r12) {
            Intrinsics.checkNotNullParameter(r12, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            long r4 = r12.c();
        L3:
            int r6 = r12.e();
            if (r6 == (-1)) goto L34;
            switch(r6) {
                case 1: goto L33;
                case 2: goto L32;
                case 3: goto L36;
                case 4: goto L27;
                case 5: goto L26;
                case 6: goto L25;
                case 7: goto L24;
                case 8: goto L23;
                case 9: goto L22;
                case 10: goto L21;
                case 11: goto L20;
                case 12: goto L19;
                case 13: goto L40;
                case 14: goto L14;
                case 15: goto L13;
                case 16: goto L38;
                case 17: goto L7;
                default: goto L6;
            };
        L36:
            r1.f = Type.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
        L30:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L38:
            Tag.ADAPTER.m(r12, r3);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L12:
            Unit r8 = Unit.INSTANCE;
        L10:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L12
        L40:
            r1.p = FeedCard.FeedType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r9 = Unit.INSTANCE;
            goto L3
        L7:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.t = r12.i();
            goto L3
        L13:
            r1.r = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L14:
            r1.q = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L19:
            r1.o = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L20:
            r1.n = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L21:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r2.add(r12.i());
            goto L3
        L22:
            r1.l = (Integer) ProtoAdapter.h.c(r12);
            goto L3
        L23:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.k = r12.i();
            goto L3
        L24:
            r1.j = (Long) ProtoAdapter.k.c(r12);
            goto L3
        L25:
            r1.i = (Long) ProtoAdapter.k.c(r12);
            goto L3
        L26:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.h = r12.i();
            goto L3
        L27:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.g = r12.i();
            goto L3
        L32:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.e = r12.i();
            goto L3
        L33:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r10 = r12.i();
            Intrinsics.checkNotNullParameter(r10, "id");
            r1.d = r10;
            goto L3
        L6:
            r12.j(r6);
            Unit r11 = Unit.INSTANCE;
            goto L3
        L34:
            ByteString r13 = r12.d(r4);
            Intrinsics.checkNotNullParameter(r2, "doc_message_ids");
            com.lark.wire.internal.a.a(r2);
            r1.m = r2;
            Intrinsics.checkNotNullParameter(r3, "tags");
            com.lark.wire.internal.a.a(r3);
            r1.s = r3;
            return new DocFeed(r1, r13, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(DocFeed r7) {
            DocFeed r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = ((((r0 + r1.l(1, r8.getId())) + r1.l(2, r8.getTitle())) + Type.ADAPTER.l(3, r8.getType())) + r1.l(4, r8.getIcon_key())) + r1.l(5, r8.getDoc_url());
            t r3 = ProtoAdapter.k;
            int r4 = ((((r2 + r3.l(6, r8.getCreate_time())) + r3.l(7, r8.getUpdate_time())) + r1.l(8, r8.getOwner_id())) + ProtoAdapter.h.l(9, r8.getNew_message_count())) + r1.a().l(10, r8.getDoc_message_ids());
            l r5 = ProtoAdapter.g;
            return ((((((r4 + r5.l(11, r8.is_deleted())) + r5.l(12, r8.is_remind())) + FeedCard.FeedType.ADAPTER.l(13, r8.getFeed_type())) + r5.l(14, r8.is_cross_tenant())) + r5.l(15, r8.is_shortcut())) + Tag.ADAPTER.a().l(16, r8.getTags())) + r1.l(17, r8.getIcon_info());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, DocFeed r7) {
            DocFeed r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r6, 1, r8.getId());
            r0.i(r6, 2, r8.getTitle());
            Type.ADAPTER.i(r6, 3, r8.getType());
            r0.i(r6, 4, r8.getIcon_key());
            r0.i(r6, 5, r8.getDoc_url());
            t r1 = ProtoAdapter.k;
            r1.i(r6, 6, r8.getCreate_time());
            r1.i(r6, 7, r8.getUpdate_time());
            r0.i(r6, 8, r8.getOwner_id());
            ProtoAdapter.h.i(r6, 9, r8.getNew_message_count());
            r0.a().i(r6, 10, r8.getDoc_message_ids());
            l r2 = ProtoAdapter.g;
            r2.i(r6, 11, r8.is_deleted());
            r2.i(r6, 12, r8.is_remind());
            FeedCard.FeedType.ADAPTER.i(r6, 13, r8.getFeed_type());
            r2.i(r6, 14, r8.is_cross_tenant());
            r2.i(r6, 15, r8.is_shortcut());
            Tag.ADAPTER.a().i(r6, 16, r8.getTags());
            r0.i(r6, 17, r8.getIcon_info());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, DocFeed r7) {
            DocFeed r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r6, 17, r8.getIcon_info());
            Tag.ADAPTER.a().j(r6, 16, r8.getTags());
            l r1 = ProtoAdapter.g;
            r1.j(r6, 15, r8.is_shortcut());
            r1.j(r6, 14, r8.is_cross_tenant());
            FeedCard.FeedType.ADAPTER.j(r6, 13, r8.getFeed_type());
            r1.j(r6, 12, r8.is_remind());
            r1.j(r6, 11, r8.is_deleted());
            r0.a().j(r6, 10, r8.getDoc_message_ids());
            ProtoAdapter.h.j(r6, 9, r8.getNew_message_count());
            r0.j(r6, 8, r8.getOwner_id());
            t r2 = ProtoAdapter.k;
            r2.j(r6, 7, r8.getUpdate_time());
            r2.j(r6, 6, r8.getCreate_time());
            r0.j(r6, 5, r8.getDoc_url());
            r0.j(r6, 4, r8.getIcon_key());
            Type.ADAPTER.j(r6, 3, r8.getType());
            r0.j(r6, 2, r8.getTitle());
            r0.j(r6, 1, r8.getId());
        }

        public b(FieldEncoding r7, KClass<DocFeed> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.DocFeed", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ DocFeed(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_TYPE = Type.DOC;
        DEFAULT_FEED_TYPE = FeedCard.FeedType.INBOX;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(DocFeed.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.title;
        r0.f = this.type;
        r0.g = this.icon_key;
        r0.h = this.doc_url;
        r0.i = this.create_time;
        r0.j = this.update_time;
        r0.k = this.owner_id;
        r0.l = this.new_message_count;
        r0.m = this.doc_message_ids;
        r0.n = this.is_deleted;
        r0.o = this.is_remind;
        r0.p = this.feed_type;
        r0.q = this.is_cross_tenant;
        r0.r = this.is_shortcut;
        r0.s = this.tags;
        r0.t = this.icon_info;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(DocFeed.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getCreate_time() {
        return this.create_time;
    }

    public final List<String> getDoc_message_ids() {
        return this.doc_message_ids;
    }

    public final String getDoc_url() {
        return this.doc_url;
    }

    public final FeedCard.FeedType getFeed_type() {
        return this.feed_type;
    }

    public final String getIcon_info() {
        return this.icon_info;
    }

    public final String getIcon_key() {
        return this.icon_key;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getNew_message_count() {
        return this.new_message_count;
    }

    public final String getOwner_id() {
        return this.owner_id;
    }

    public final List<Tag> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Type getType() {
        return this.type;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    public final Boolean is_cross_tenant() {
        return this.is_cross_tenant;
    }

    public final Boolean is_deleted() {
        return this.is_deleted;
    }

    public final Boolean is_remind() {
        return this.is_remind;
    }

    public final Boolean is_shortcut() {
        return this.is_shortcut;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public DocFeed(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        this.title = r2.e;
        this.type = r2.f;
        this.icon_key = r2.g;
        this.doc_url = r2.h;
        this.create_time = r2.i;
        this.update_time = r2.j;
        this.owner_id = r2.k;
        this.new_message_count = r2.l;
        this.doc_message_ids = com.lark.wire.internal.a.c("doc_message_ids", r2.m);
        this.is_deleted = r2.n;
        this.is_remind = r2.o;
        this.feed_type = r2.p;
        this.is_cross_tenant = r2.q;
        this.is_shortcut = r2.r;
        this.tags = com.lark.wire.internal.a.c("tags", r2.s);
        this.icon_info = r2.t;
    }

    public /* synthetic */ DocFeed(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
