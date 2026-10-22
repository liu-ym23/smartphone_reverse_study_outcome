package com.lark.kmp.pb.basic.v1;

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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\"#$B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ChatUserAutoMuteSetting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ChatUserAutoMuteSetting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ChatUserAutoMuteSetting$Builder;Lokio/ByteString;)V", "user_auto_mute", "Lcom/lark/kmp/pb/basic/v1/AutoMuteConfig;", "getUser_auto_mute", "()Lcom/lark/kmp/pb/basic/v1/AutoMuteConfig;", "bot_auto_mute", "", "Lcom/lark/kmp/pb/basic/v1/BotAutoMuteConfig;", "getBot_auto_mute", "()Ljava/util/List;", "notice_type", "Lcom/lark/kmp/pb/basic/v1/ChatUserAutoMuteSetting$NoticeType;", "getNotice_type", "()Lcom/lark/kmp/pb/basic/v1/ChatUserAutoMuteSetting$NoticeType;", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "show_top_banner", "", "getShow_top_banner", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "NoticeType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatUserAutoMuteSetting extends com.lark.wire.Message<ChatUserAutoMuteSetting, a> {
    public static final ProtoAdapter<ChatUserAutoMuteSetting> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<BotAutoMuteConfig> bot_auto_mute;
    private final NoticeType notice_type;
    private final Boolean show_top_banner;
    private final Long update_time;
    private final AutoMuteConfig user_auto_mute;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ChatUserAutoMuteSetting$NoticeType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "DIGITAL_NOTICE", "RED_DOT_NOTICE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum NoticeType extends Enum<NoticeType> implements o0 {
        public static final ProtoAdapter<NoticeType> ADAPTER = null;
        public static final b Companion = null;
        public static final NoticeType DIGITAL_NOTICE = null;
        public static final NoticeType RED_DOT_NOTICE = null;
        public static final NoticeType UNKNOWN = null;
        public static final /* synthetic */ NoticeType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<NoticeType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                NoticeType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return NoticeType.RED_DOT_NOTICE;
            L15:
                return NoticeType.DIGITAL_NOTICE;
            L12:
                return NoticeType.UNKNOWN;
            }

            public a(KClass<NoticeType> r1, Syntax r2, NoticeType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<NoticeType> getEntries() {
            return b;
        }

        static {
            NoticeType r0 = new NoticeType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            NoticeType r1 = new NoticeType("DIGITAL_NOTICE", 1, 1);
            DIGITAL_NOTICE = r1;
            NoticeType r3 = new NoticeType("RED_DOT_NOTICE", 2, 2);
            RED_DOT_NOTICE = r3;
            NoticeType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(NoticeType.class), Syntax.PROTO_2, r0);
        }

        public static NoticeType[] values() {
            return (NoticeType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final NoticeType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return RED_DOT_NOTICE;
        L15:
            return DIGITAL_NOTICE;
        L12:
            return UNKNOWN;
        }

        public static NoticeType valueOf(String r1) {
            return (NoticeType) r27.a.a(NoticeType.class, r1);
        }

        public NoticeType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<ChatUserAutoMuteSetting, a> {
        public AutoMuteConfig d;
        public List<BotAutoMuteConfig> e;
        public NoticeType f;
        public Long g;
        public Boolean h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ChatUserAutoMuteSetting(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<ChatUserAutoMuteSetting> {
        @Override // com.lark.wire.ProtoAdapter
        public final ChatUserAutoMuteSetting c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L24;
            if (r4 != 1) goto L8;
            r0.d = AutoMuteConfig.ADAPTER.c(r10);
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.add(BotAutoMuteConfig.ADAPTER.c(r10));
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r0.f = NoticeType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L12:
            if (r4 != 4) goto L14;
            r0.g = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L14:
            if (r4 != 5) goto L15;
            r0.h = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L15:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L24:
            ByteString r11 = r10.d(r2);
            Intrinsics.checkNotNullParameter(r1, "bot_auto_mute");
            com.lark.wire.internal.a.a(r1);
            r0.e = r1;
            return new ChatUserAutoMuteSetting(r0, r11, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ChatUserAutoMuteSetting r5) {
            ChatUserAutoMuteSetting r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((((r6.unknownFields().size() + AutoMuteConfig.ADAPTER.l(1, r6.getUser_auto_mute())) + BotAutoMuteConfig.ADAPTER.a().l(2, r6.getBot_auto_mute())) + NoticeType.ADAPTER.l(3, r6.getNotice_type())) + ProtoAdapter.k.l(4, r6.getUpdate_time())) + ProtoAdapter.g.l(5, r6.getShow_top_banner());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ChatUserAutoMuteSetting r5) {
            ChatUserAutoMuteSetting r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            AutoMuteConfig.ADAPTER.i(r4, 1, r6.getUser_auto_mute());
            BotAutoMuteConfig.ADAPTER.a().i(r4, 2, r6.getBot_auto_mute());
            NoticeType.ADAPTER.i(r4, 3, r6.getNotice_type());
            ProtoAdapter.k.i(r4, 4, r6.getUpdate_time());
            ProtoAdapter.g.i(r4, 5, r6.getShow_top_banner());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ChatUserAutoMuteSetting r5) {
            ChatUserAutoMuteSetting r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 5, r6.getShow_top_banner());
            ProtoAdapter.k.j(r4, 4, r6.getUpdate_time());
            NoticeType.ADAPTER.j(r4, 3, r6.getNotice_type());
            BotAutoMuteConfig.ADAPTER.a().j(r4, 2, r6.getBot_auto_mute());
            AutoMuteConfig.ADAPTER.j(r4, 1, r6.getUser_auto_mute());
        }

        public b(FieldEncoding r7, KClass<ChatUserAutoMuteSetting> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ChatUserAutoMuteSetting", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ChatUserAutoMuteSetting(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatUserAutoMuteSetting.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.user_auto_mute;
        r0.e = this.bot_auto_mute;
        r0.f = this.notice_type;
        r0.g = this.update_time;
        r0.h = this.show_top_banner;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ChatUserAutoMuteSetting.class).getSimpleName() + '@' + hashCode();
    }

    public final List<BotAutoMuteConfig> getBot_auto_mute() {
        return this.bot_auto_mute;
    }

    public final NoticeType getNotice_type() {
        return this.notice_type;
    }

    public final Boolean getShow_top_banner() {
        return this.show_top_banner;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    public final AutoMuteConfig getUser_auto_mute() {
        return this.user_auto_mute;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ChatUserAutoMuteSetting(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.user_auto_mute = r2.d;
        this.bot_auto_mute = com.lark.wire.internal.a.c("bot_auto_mute", r2.e);
        this.notice_type = r2.f;
        this.update_time = r2.g;
        this.show_top_banner = r2.h;
    }

    public /* synthetic */ ChatUserAutoMuteSetting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
