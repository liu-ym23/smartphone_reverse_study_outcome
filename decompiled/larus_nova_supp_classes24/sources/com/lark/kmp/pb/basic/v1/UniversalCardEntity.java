package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.card.protocol.context.action.CardActionService;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 V2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0017UVWXYZ[\\]^_`abcdefghijkB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010S\u001a\u00020\u0002H\u0016J\b\u0010T\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000bR\u001d\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010'\u001a\u0004\u0018\u00010(¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u00108\u001a\u0004\u0018\u000109¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001d\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020=0 ¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"R\u0015\u0010?\u001a\u0004\u0018\u00010@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0015\u0010D\u001a\u0004\u0018\u00010@¢\u0006\n\n\u0002\u0010C\u001a\u0004\bE\u0010BR\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020H0G¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010K\u001a\u0004\u0018\u00010L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010O\u001a\u0004\u0018\u00010P¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010R¨\u0006l"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Builder;Lokio/ByteString;)V", CardActionService.CARD_ID, "", "getCard_id", "()Ljava/lang/String;", "version", "getVersion", "content", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Content;", "getContent", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Content;", "source_id", "getSource_id", "source_type", "", "getSource_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "action_status", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$ActionStatus;", "getAction_status", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$ActionStatus;", "action_url", "getAction_url", "local_extra", "", "getLocal_extra", "()Ljava/util/Map;", "app_info", "Lcom/lark/kmp/pb/basic/v1/CardAppInfo;", "getApp_info", "()Lcom/lark/kmp/pb/basic/v1/CardAppInfo;", "streaming_mode", "", "getStreaming_mode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "data_source", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$DataSource;", "getData_source", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$DataSource;", "streaming_config", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig;", "getStreaming_config", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig;", "data_type", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$DataType;", "getData_type", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$DataType;", "patch_info", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$PatchInfo;", "getPatch_info", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$PatchInfo;", "clean_resource_key_scene", "Lcom/lark/kmp/pb/basic/v1/ResourceCleanScene;", "getClean_resource_key_scene", "app_id", "", "getApp_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "bot_id", "getBot_id", "json_card_urls", "", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Url;", "getJson_card_urls", "()Ljava/util/List;", "card_header", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$CardHeader;", "getCard_header", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$CardHeader;", "action_data_source", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$ActionDataSource;", "getAction_data_source", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$ActionDataSource;", "newBuilder", "toString", "Builder", "Companion", "SourceType", "Config", "Action", "CharacterType", com.larksuite.component.card.protocol.data.person.Character.TAG, com.larksuite.component.card.protocol.data.media.AudioInfo.TAG, com.larksuite.component.card.protocol.data.media.VideoInfo.TAG, "SummaryContent", "Attachment", "Content", "ActionStatus", "LocalExtraKey", "DataSource", "ActionDataSource", "PrintStrategy", "StreamingConfig", "Url", "CardHeader", "PatchInfo", "DataType", "I18nInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardEntity extends com.lark.wire.Message<UniversalCardEntity, a> {
    public static final ProtoAdapter<UniversalCardEntity> ADAPTER = null;
    public static final b Companion = null;
    private static final long serialVersionUID = 0;
    private final ActionDataSource action_data_source;
    private final ActionStatus action_status;
    private final String action_url;
    private final Long app_id;
    private final CardAppInfo app_info;
    private final Long bot_id;
    private final CardHeader card_header;
    private final String card_id;
    private final Map<String, ResourceCleanScene> clean_resource_key_scene;
    private final Content content;
    private final DataSource data_source;
    private final DataType data_type;
    private final List<Url> json_card_urls;
    private final Map<Integer, String> local_extra;
    private final PatchInfo patch_info;
    private final String source_id;
    private final Integer source_type;
    private final StreamingConfig streaming_config;
    private final Boolean streaming_mode;
    private final String version;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Action;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Action$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Action$Builder;Lokio/ByteString;)V", "extra", "", "", "getExtra", "()Ljava/util/Map;", "message_extra", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Action$MessageExtra;", "getMessage_extra", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Action$MessageExtra;", "newBuilder", "toString", "Builder", "Companion", "MessageExtra", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Action extends com.lark.wire.Message<Action, a> {
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, String> extra;
        private final MessageExtra message_extra;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Action$MessageExtra;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Action$MessageExtra$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Action$MessageExtra$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "params", "", "getParams", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class MessageExtra extends com.lark.wire.Message<MessageExtra, a> {
            public static final ProtoAdapter<MessageExtra> ADAPTER = null;
            public static final b Companion = null;
            private static final long serialVersionUID = 0;
            private final Map<String, String> params;
            private final String url;

            public static final class a extends com.lark.wire.Message.a<MessageExtra, a> {
                public String d;
                public Map<String, String> e;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new MessageExtra(this, c(), null);
                }

                public a() {
                    this.e = MapsKt.emptyMap();
                }
            }

            public static final class b {
                public b() {
                }
            }

            public /* synthetic */ MessageExtra(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new b();
                final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
                final KClass r1 = Reflection.getOrCreateKotlinClass(MessageExtra.class);
                final Syntax r2 = Syntax.PROTO_2;
                ADAPTER = new UniversalCardEntity$Action$MessageExtra$Companion$ADAPTER$1(r0, r1, r2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.url;
                r0.e = this.params;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(MessageExtra.class).getSimpleName() + '@' + hashCode();
            }

            public final Map<String, String> getParams() {
                return this.params;
            }

            public final String getUrl() {
                return this.url;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public MessageExtra(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.url = r2.d;
                this.params = com.lark.wire.internal.a.d("params", r2.e);
            }

            public /* synthetic */ MessageExtra(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<Action, a> {
            public Map<String, String> d;
            public MessageExtra e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Action(this, c(), null);
            }

            public a() {
                this.d = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ Action(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(Action.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new UniversalCardEntity$Action$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.extra;
            r0.e = this.message_extra;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Action.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, String> getExtra() {
            return this.extra;
        }

        public final MessageExtra getMessage_extra() {
            return this.message_extra;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Action(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.extra = com.lark.wire.internal.a.d("extra", r2.d);
            this.message_extra = r2.e;
        }

        public /* synthetic */ Action(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$ActionDataSource;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IM_CONTENT", "STREAMING_CARD", "ENTITY_CARD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ActionDataSource extends Enum<ActionDataSource> implements o0 {
        public static final ProtoAdapter<ActionDataSource> ADAPTER = null;
        public static final b Companion = null;
        public static final ActionDataSource ENTITY_CARD = null;
        public static final ActionDataSource IM_CONTENT = null;
        public static final ActionDataSource STREAMING_CARD = null;
        public static final /* synthetic */ ActionDataSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ActionDataSource> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ActionDataSource.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return ActionDataSource.ENTITY_CARD;
            L15:
                return ActionDataSource.STREAMING_CARD;
            L12:
                return ActionDataSource.IM_CONTENT;
            }

            public a(KClass<ActionDataSource> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ActionDataSource> getEntries() {
            return b;
        }

        static {
            ActionDataSource r0 = new ActionDataSource("IM_CONTENT", 0, 1);
            IM_CONTENT = r0;
            ActionDataSource r1 = new ActionDataSource("STREAMING_CARD", 1, 2);
            STREAMING_CARD = r1;
            ActionDataSource r4 = new ActionDataSource("ENTITY_CARD", 2, 3);
            ENTITY_CARD = r4;
            ActionDataSource[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ActionDataSource.class), Syntax.PROTO_2);
        }

        public static ActionDataSource[] values() {
            return (ActionDataSource[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ActionDataSource fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return ENTITY_CARD;
        L15:
            return STREAMING_CARD;
        L12:
            return IM_CONTENT;
        }

        public static ActionDataSource valueOf(String r1) {
            return (ActionDataSource) r27.a.a(ActionDataSource.class, r1);
        }

        public ActionDataSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$ActionStatus;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$ActionStatus$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$ActionStatus$Builder;Lokio/ByteString;)V", "component_status_by_name", "", "", "getComponent_status_by_name", "()Ljava/util/Map;", "component_status_by_action_id", "getComponent_status_by_action_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ActionStatus extends com.lark.wire.Message<ActionStatus, a> {
        public static final ProtoAdapter<ActionStatus> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, String> component_status_by_action_id;
        private final Map<String, String> component_status_by_name;

        public static final class a extends com.lark.wire.Message.a<ActionStatus, a> {
            public Map<String, String> d;
            public Map<String, String> e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ActionStatus(this, c(), null);
            }

            public a() {
                this.d = MapsKt.emptyMap();
                this.e = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ ActionStatus(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(ActionStatus.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new UniversalCardEntity$ActionStatus$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.component_status_by_name;
            r0.e = this.component_status_by_action_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ActionStatus.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, String> getComponent_status_by_action_id() {
            return this.component_status_by_action_id;
        }

        public final Map<String, String> getComponent_status_by_name() {
            return this.component_status_by_name;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ActionStatus(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.component_status_by_name = com.lark.wire.internal.a.d("component_status_by_name", r2.d);
            this.component_status_by_action_id = com.lark.wire.internal.a.d("component_status_by_action_id", r2.e);
        }

        public /* synthetic */ ActionStatus(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002,-B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010*\u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"0\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011R\u0013\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001d\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020(0\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0011¨\u0006."}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Attachment;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Attachment$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Attachment$Builder;Lokio/ByteString;)V", "summary", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent;", "getSummary", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent;", "images", "", "", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$ImageProperty;", "getImages", "()Ljava/util/Map;", "at_users", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty;", "getAt_users", "characters", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Character;", "getCharacters", "ignore_at_remind", "", "getIgnore_at_remind", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "preview_image_key_list", "", "getPreview_image_key_list", "()Ljava/util/List;", "audios", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$AudioInfo;", "getAudios", "card_simple_summary", "getCard_simple_summary", "()Ljava/lang/String;", "videos", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$VideoInfo;", "getVideos", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Attachment extends com.lark.wire.Message<Attachment, a> {
        public static final ProtoAdapter<Attachment> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, RichTextElement.AtProperty> at_users;
        private final Map<String, AudioInfo> audios;
        private final String card_simple_summary;
        private final Map<String, Character> characters;
        private final Boolean ignore_at_remind;
        private final Map<String, RichTextElement.ImageProperty> images;
        private final List<String> preview_image_key_list;
        private final SummaryContent summary;
        private final Map<String, VideoInfo> videos;

        public static final class a extends com.lark.wire.Message.a<Attachment, a> {
            public SummaryContent d;
            public Map<String, RichTextElement.ImageProperty> e;
            public Map<String, RichTextElement.AtProperty> f;
            public Map<String, Character> g;
            public Boolean h;
            public List<String> i;
            public Map<String, AudioInfo> j;
            public String k;
            public Map<String, VideoInfo> l;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Attachment(this, c(), null);
            }

            public a() {
                this.e = MapsKt.emptyMap();
                this.f = MapsKt.emptyMap();
                this.g = MapsKt.emptyMap();
                this.i = CollectionsKt.emptyList();
                this.j = MapsKt.emptyMap();
                this.l = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ Attachment(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(Attachment.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new UniversalCardEntity$Attachment$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.summary;
            r0.e = this.images;
            r0.f = this.at_users;
            r0.g = this.characters;
            r0.h = this.ignore_at_remind;
            r0.i = this.preview_image_key_list;
            r0.j = this.audios;
            r0.k = this.card_simple_summary;
            r0.l = this.videos;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Attachment.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, RichTextElement.AtProperty> getAt_users() {
            return this.at_users;
        }

        public final Map<String, AudioInfo> getAudios() {
            return this.audios;
        }

        public final String getCard_simple_summary() {
            return this.card_simple_summary;
        }

        public final Map<String, Character> getCharacters() {
            return this.characters;
        }

        public final Boolean getIgnore_at_remind() {
            return this.ignore_at_remind;
        }

        public final Map<String, RichTextElement.ImageProperty> getImages() {
            return this.images;
        }

        public final List<String> getPreview_image_key_list() {
            return this.preview_image_key_list;
        }

        public final SummaryContent getSummary() {
            return this.summary;
        }

        public final Map<String, VideoInfo> getVideos() {
            return this.videos;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Attachment(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.summary = r2.d;
            this.images = com.lark.wire.internal.a.d("images", r2.e);
            this.at_users = com.lark.wire.internal.a.d("at_users", r2.f);
            this.characters = com.lark.wire.internal.a.d("characters", r2.g);
            this.ignore_at_remind = r2.h;
            this.preview_image_key_list = com.lark.wire.internal.a.c("preview_image_key_list", r2.i);
            this.audios = com.lark.wire.internal.a.d("audios", r2.j);
            this.card_simple_summary = r2.k;
            this.videos = com.lark.wire.internal.a.d("videos", r2.l);
        }

        public /* synthetic */ Attachment(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$AudioInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$AudioInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$AudioInfo$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "duration", "", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "size", "", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "visit_info", "Lcom/lark/kmp/pb/basic/v1/CardVisitInfo;", "getVisit_info", "()Lcom/lark/kmp/pb/basic/v1/CardVisitInfo;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AudioInfo extends com.lark.wire.Message<AudioInfo, a> {
        public static final ProtoAdapter<AudioInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer duration;
        private final String key;
        private final Long size;
        private final CardVisitInfo visit_info;

        public static final class a extends com.lark.wire.Message.a<AudioInfo, a> {
            public String d;
            public Integer e;
            public Long f;
            public CardVisitInfo g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AudioInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AudioInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final AudioInfo c(g0 r7) {
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
                r1.f = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L12:
                if (r4 != 4) goto L13;
                r1.g = CardVisitInfo.ADAPTER.c(r7);
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new AudioInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AudioInfo r5) {
                AudioInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getKey())) + ProtoAdapter.h.l(2, r6.getDuration())) + ProtoAdapter.k.l(3, r6.getSize())) + CardVisitInfo.ADAPTER.l(4, r6.getVisit_info());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, AudioInfo r5) {
                AudioInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getKey());
                ProtoAdapter.h.i(r4, 2, r6.getDuration());
                ProtoAdapter.k.i(r4, 3, r6.getSize());
                CardVisitInfo.ADAPTER.i(r4, 4, r6.getVisit_info());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, AudioInfo r5) {
                AudioInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                CardVisitInfo.ADAPTER.j(r4, 4, r6.getVisit_info());
                ProtoAdapter.k.j(r4, 3, r6.getSize());
                ProtoAdapter.h.j(r4, 2, r6.getDuration());
                ProtoAdapter.q.j(r4, 1, r6.getKey());
            }

            public b(FieldEncoding r7, KClass<AudioInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.AudioInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AudioInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AudioInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.key;
            r0.e = this.duration;
            r0.f = this.size;
            r0.g = this.visit_info;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AudioInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getDuration() {
            return this.duration;
        }

        public final String getKey() {
            return this.key;
        }

        public final Long getSize() {
            return this.size;
        }

        public final CardVisitInfo getVisit_info() {
            return this.visit_info;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AudioInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.key = r2.d;
            this.duration = r2.e;
            this.size = r2.f;
            this.visit_info = r2.g;
        }

        public /* synthetic */ AudioInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$CardHeader;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$CardHeader$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$CardHeader$Builder;Lokio/ByteString;)V", "title", "", "getTitle", "()Ljava/lang/String;", "main_title", "getMain_title", "subtitle", "getSubtitle", "theme", "getTheme", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CardHeader extends com.lark.wire.Message<CardHeader, a> {
        public static final ProtoAdapter<CardHeader> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String main_title;
        private final String subtitle;
        private final String theme;
        private final String title;

        public static final class a extends com.lark.wire.Message.a<CardHeader, a> {
            public String d;
            public String e;
            public String f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CardHeader(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CardHeader> {
            @Override // com.lark.wire.ProtoAdapter
            public final CardHeader c(g0 r7) {
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
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                if (r4 != 4) goto L13;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new CardHeader(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CardHeader r5) {
                CardHeader r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(1, r6.getTitle())) + r1.l(2, r6.getMain_title())) + r1.l(3, r6.getSubtitle())) + r1.l(4, r6.getTheme());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CardHeader r5) {
                CardHeader r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getTitle());
                r0.i(r4, 2, r6.getMain_title());
                r0.i(r4, 3, r6.getSubtitle());
                r0.i(r4, 4, r6.getTheme());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, CardHeader r5) {
                CardHeader r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 4, r6.getTheme());
                r0.j(r4, 3, r6.getSubtitle());
                r0.j(r4, 2, r6.getMain_title());
                r0.j(r4, 1, r6.getTitle());
            }

            public b(FieldEncoding r7, KClass<CardHeader> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.CardHeader", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CardHeader(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CardHeader.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.title;
            r0.e = this.main_title;
            r0.f = this.subtitle;
            r0.g = this.theme;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CardHeader.class).getSimpleName() + '@' + hashCode();
        }

        public final String getMain_title() {
            return this.main_title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTheme() {
            return this.theme;
        }

        public final String getTitle() {
            return this.title;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CardHeader(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.title = r2.d;
            this.main_title = r2.e;
            this.subtitle = r2.f;
            this.theme = r2.g;
        }

        public /* synthetic */ CardHeader(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Character;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Character$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Character$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$CharacterType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$CharacterType;", "id", "", "getId", "()Ljava/lang/String;", "content", "getContent", "avatar_key", "getAvatar_key", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Character extends com.lark.wire.Message<Character, a> {
        public static final ProtoAdapter<Character> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String avatar_key;
        private final String content;
        private final String id;
        private final CharacterType type;

        public static final class a extends com.lark.wire.Message.a<Character, a> {
            public CharacterType d;
            public String e;
            public String f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Character(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Character> {
            @Override // com.lark.wire.ProtoAdapter
            public final Character c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L22;
                if (r4 != 1) goto L8;
                CharacterType r5 = CharacterType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
                Intrinsics.checkNotNullParameter(r5, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
                r1.d = r5;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                String r7 = r10.i();
                Intrinsics.checkNotNullParameter(r7, "id");
                r1.e = r7;
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.f = r10.i();
                goto L3
            L12:
                if (r4 != 4) goto L13;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.g = r10.i();
                goto L3
            L13:
                r10.j(r4);
                Unit r8 = Unit.INSTANCE;
                goto L3
            L22:
                return new Character(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Character r5) {
                Character r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size() + CharacterType.ADAPTER.l(1, r6.getType());
                w r1 = ProtoAdapter.q;
                return ((r0 + r1.l(2, r6.getId())) + r1.l(3, r6.getContent())) + r1.l(4, r6.getAvatar_key());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Character r5) {
                Character r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                CharacterType.ADAPTER.i(r4, 1, r6.getType());
                w r0 = ProtoAdapter.q;
                r0.i(r4, 2, r6.getId());
                r0.i(r4, 3, r6.getContent());
                r0.i(r4, 4, r6.getAvatar_key());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Character r5) {
                Character r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 4, r6.getAvatar_key());
                r0.j(r4, 3, r6.getContent());
                r0.j(r4, 2, r6.getId());
                CharacterType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<Character> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.Character", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Character(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Character.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.id;
            r0.f = this.content;
            r0.g = this.avatar_key;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Character.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAvatar_key() {
            return this.avatar_key;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getId() {
            return this.id;
        }

        public final CharacterType getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Character(a r2, ByteString r3) {
            super(ADAPTER, r3);
            CharacterType r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.type = r4;
            String r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.id = r5;
            this.content = r2.f;
            this.avatar_key = r2.g;
        }

        public /* synthetic */ Character(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$CharacterType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHARACTER_UNKNOWN", "USER", "CHAT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CharacterType extends Enum<CharacterType> implements o0 {
        public static final ProtoAdapter<CharacterType> ADAPTER = null;
        public static final CharacterType CHARACTER_UNKNOWN = null;
        public static final CharacterType CHAT = null;
        public static final b Companion = null;
        public static final CharacterType USER = null;
        public static final /* synthetic */ CharacterType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<CharacterType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                CharacterType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return CharacterType.CHAT;
            L15:
                return CharacterType.USER;
            L12:
                return CharacterType.CHARACTER_UNKNOWN;
            }

            public a(KClass<CharacterType> r1, Syntax r2, CharacterType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<CharacterType> getEntries() {
            return b;
        }

        static {
            CharacterType r0 = new CharacterType("CHARACTER_UNKNOWN", 0, 0);
            CHARACTER_UNKNOWN = r0;
            CharacterType r1 = new CharacterType("USER", 1, 1);
            USER = r1;
            CharacterType r3 = new CharacterType("CHAT", 2, 2);
            CHAT = r3;
            CharacterType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(CharacterType.class), Syntax.PROTO_2, r0);
        }

        public static CharacterType[] values() {
            return (CharacterType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final CharacterType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return CHAT;
        L15:
            return USER;
        L12:
            return CHARACTER_UNKNOWN;
        }

        public static CharacterType valueOf(String r1) {
            return (CharacterType) r27.a.a(CharacterType.class, r1);
        }

        public CharacterType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003-./B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010+\u001a\u00020\u0002H\u0016J\b\u0010,\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0018\u0010\u000bR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001a\u0010\u000bR\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020 0\u001c¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0015\u0010\"\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\"\u0010\u000bR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010'\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b'\u0010\u000bR\u0013\u0010(\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0010R\u0015\u0010*\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b*\u0010\u000b¨\u00060"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Config;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Config$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Config$Builder;Lokio/ByteString;)V", "compact_width", "", "getCompact_width", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "width_mode", "", "getWidth_mode", "()Ljava/lang/String;", "enable_forward", "getEnable_forward", "wide_screen_mode", "getWide_screen_mode", "analytics_data", "getAnalytics_data", "enable_translate", "getEnable_translate", "use_custom_translation", "getUse_custom_translation", "user_card_language_detect", "", "getUser_card_language_detect", "()Ljava/util/Map;", "locale_info", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Config$LocaleInfo;", "getLocale_info", "is_gadget_preload", "gadget_client_ids", "", "getGadget_client_ids", "()Ljava/util/List;", "is_meego_pre_load", "custom_parameter", "getCustom_parameter", "is_forward", "newBuilder", "toString", "Builder", "Companion", "LocaleInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Config extends com.lark.wire.Message<Config, a> {
        public static final ProtoAdapter<Config> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final String analytics_data;
        private final Boolean compact_width;
        private final String custom_parameter;
        private final Boolean enable_forward;
        private final Boolean enable_translate;
        private final List<String> gadget_client_ids;
        private final Boolean is_forward;
        private final Boolean is_gadget_preload;
        private final Boolean is_meego_pre_load;
        private final Map<String, LocaleInfo> locale_info;
        private final Boolean use_custom_translation;
        private final Map<String, String> user_card_language_detect;
        private final Boolean wide_screen_mode;
        private final String width_mode;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Config$LocaleInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Config$LocaleInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Config$LocaleInfo$Builder;Lokio/ByteString;)V", "content_languages", "", "", "getContent_languages", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class LocaleInfo extends com.lark.wire.Message<LocaleInfo, a> {
            public static final ProtoAdapter<LocaleInfo> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final List<String> content_languages;

            public static final class a extends com.lark.wire.Message.a<LocaleInfo, a> {
                public List<String> d;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new LocaleInfo(this, c(), null);
                }

                public a() {
                    this.d = CollectionsKt.emptyList();
                }
            }

            public static final class b extends ProtoAdapter<LocaleInfo> {
                @Override // com.lark.wire.ProtoAdapter
                public final LocaleInfo c(g0 r8) {
                    Intrinsics.checkNotNullParameter(r8, "reader");
                    a r1 = new a();
                    ArrayList r2 = new ArrayList();
                    long r3 = r8.c();
                L3:
                    int r5 = r8.e();
                    if (r5 == (-1)) goto L9;
                    if (r5 == 1) goto L7;
                    r8.j(r5);
                    goto L3
                L7:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r8, "reader");
                    r2.add(r8.i());
                    goto L3
                L9:
                    ByteString r9 = r8.d(r3);
                    Intrinsics.checkNotNullParameter(r2, "content_languages");
                    com.lark.wire.internal.a.a(r2);
                    r1.d = r2;
                    return new LocaleInfo(r1, r9, null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(LocaleInfo r4) {
                    LocaleInfo r5 = r4;
                    Intrinsics.checkNotNullParameter(r5, "value");
                    return r5.unknownFields().size() + ProtoAdapter.q.a().l(1, r5.getContent_languages());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, LocaleInfo r5) {
                    LocaleInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    ProtoAdapter.q.a().i(r4, 1, r6.getContent_languages());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r3, LocaleInfo r4) {
                    LocaleInfo r5 = r4;
                    Intrinsics.checkNotNullParameter(r3, "writer");
                    Intrinsics.checkNotNullParameter(r5, "value");
                    r3.d(r5.unknownFields());
                    ProtoAdapter.q.a().j(r3, 1, r5.getContent_languages());
                }

                public b(FieldEncoding r7, KClass<LocaleInfo> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.Config.LocaleInfo", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ LocaleInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LocaleInfo.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.content_languages;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(LocaleInfo.class).getSimpleName() + '@' + hashCode();
            }

            public final List<String> getContent_languages() {
                return this.content_languages;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public LocaleInfo(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.content_languages = com.lark.wire.internal.a.c("content_languages", r2.d);
            }

            public /* synthetic */ LocaleInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<Config, a> {
            public Boolean d;
            public String e;
            public Boolean f;
            public Boolean g;
            public String h;
            public Boolean i;
            public Boolean j;
            public Map<String, String> k;
            public Map<String, LocaleInfo> l;
            public Boolean m;
            public List<String> n;
            public Boolean o;
            public String p;
            public Boolean q;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Config(this, c(), null);
            }

            public a() {
                this.k = MapsKt.emptyMap();
                this.l = MapsKt.emptyMap();
                this.n = CollectionsKt.emptyList();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ Config(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(Config.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new UniversalCardEntity$Config$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.compact_width;
            r0.e = this.width_mode;
            r0.f = this.enable_forward;
            r0.g = this.wide_screen_mode;
            r0.h = this.analytics_data;
            r0.i = this.enable_translate;
            r0.j = this.use_custom_translation;
            r0.k = this.user_card_language_detect;
            r0.l = this.locale_info;
            r0.m = this.is_gadget_preload;
            r0.n = this.gadget_client_ids;
            r0.o = this.is_meego_pre_load;
            r0.p = this.custom_parameter;
            r0.q = this.is_forward;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Config.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAnalytics_data() {
            return this.analytics_data;
        }

        public final Boolean getCompact_width() {
            return this.compact_width;
        }

        public final String getCustom_parameter() {
            return this.custom_parameter;
        }

        public final Boolean getEnable_forward() {
            return this.enable_forward;
        }

        public final Boolean getEnable_translate() {
            return this.enable_translate;
        }

        public final List<String> getGadget_client_ids() {
            return this.gadget_client_ids;
        }

        public final Map<String, LocaleInfo> getLocale_info() {
            return this.locale_info;
        }

        public final Boolean getUse_custom_translation() {
            return this.use_custom_translation;
        }

        public final Map<String, String> getUser_card_language_detect() {
            return this.user_card_language_detect;
        }

        public final Boolean getWide_screen_mode() {
            return this.wide_screen_mode;
        }

        public final String getWidth_mode() {
            return this.width_mode;
        }

        public final Boolean is_forward() {
            return this.is_forward;
        }

        public final Boolean is_gadget_preload() {
            return this.is_gadget_preload;
        }

        public final Boolean is_meego_pre_load() {
            return this.is_meego_pre_load;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Config(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.compact_width = r2.d;
            this.width_mode = r2.e;
            this.enable_forward = r2.f;
            this.wide_screen_mode = r2.g;
            this.analytics_data = r2.h;
            this.enable_translate = r2.i;
            this.use_custom_translation = r2.j;
            this.user_card_language_detect = com.lark.wire.internal.a.d("user_card_language_detect", r2.k);
            this.locale_info = com.lark.wire.internal.a.d("locale_info", r2.l);
            this.is_gadget_preload = r2.m;
            this.gadget_client_ids = com.lark.wire.internal.a.c("gadget_client_ids", r2.n);
            this.is_meego_pre_load = r2.o;
            this.custom_parameter = r2.p;
            this.is_forward = r2.q;
        }

        public /* synthetic */ Config(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Content;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Content$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Content$Builder;Lokio/ByteString;)V", "card", "", "getCard", "()Ljava/lang/String;", "config", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Config;", "getConfig", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Config;", "attachment", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Attachment;", "getAttachment", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Attachment;", "actions", "", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Action;", "getActions", "()Ljava/util/Map;", "i18n_info", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo;", "getI18n_info", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Content extends com.lark.wire.Message<Content, a> {
        public static final ProtoAdapter<Content> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, Action> actions;
        private final Attachment attachment;
        private final String card;
        private final Config config;
        private final I18nInfo i18n_info;

        public static final class a extends com.lark.wire.Message.a<Content, a> {
            public String d;
            public Config e;
            public Attachment f;
            public Map<String, Action> g;
            public I18nInfo h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Content(this, c(), null);
            }

            public a() {
                this.g = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ Content(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(Content.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new UniversalCardEntity$Content$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.card;
            r0.e = this.config;
            r0.f = this.attachment;
            r0.g = this.actions;
            r0.h = this.i18n_info;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Content.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, Action> getActions() {
            return this.actions;
        }

        public final Attachment getAttachment() {
            return this.attachment;
        }

        public final String getCard() {
            return this.card;
        }

        public final Config getConfig() {
            return this.config;
        }

        public final I18nInfo getI18n_info() {
            return this.i18n_info;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Content(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.card = r4;
            this.config = r2.e;
            this.attachment = r2.f;
            this.actions = com.lark.wire.internal.a.d("actions", r2.g);
            this.i18n_info = r2.h;
        }

        public /* synthetic */ Content(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$DataSource;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IM", "CARD", "STREAMING", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum DataSource extends Enum<DataSource> implements o0 {
        public static final ProtoAdapter<DataSource> ADAPTER = null;
        public static final DataSource CARD = null;
        public static final b Companion = null;
        public static final DataSource IM = null;
        public static final DataSource STREAMING = null;
        public static final /* synthetic */ DataSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<DataSource> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                DataSource.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return DataSource.STREAMING;
            L15:
                return DataSource.CARD;
            L12:
                return DataSource.IM;
            }

            public a(KClass<DataSource> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<DataSource> getEntries() {
            return b;
        }

        static {
            DataSource r0 = new DataSource("IM", 0, 1);
            IM = r0;
            DataSource r1 = new DataSource("CARD", 1, 2);
            CARD = r1;
            DataSource r4 = new DataSource("STREAMING", 2, 3);
            STREAMING = r4;
            DataSource[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(DataSource.class), Syntax.PROTO_2);
        }

        public static DataSource[] values() {
            return (DataSource[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final DataSource fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return STREAMING;
        L15:
            return CARD;
        L12:
            return IM;
        }

        public static DataSource valueOf(String r1) {
            return (DataSource) r27.a.a(DataSource.class, r1);
        }

        public DataSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$DataType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Card", "ActionSyncPatch", "CardRebind", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum DataType extends Enum<DataType> implements o0 {
        public static final ProtoAdapter<DataType> ADAPTER = null;
        public static final DataType ActionSyncPatch = null;
        public static final DataType Card = null;
        public static final DataType CardRebind = null;
        public static final b Companion = null;
        public static final /* synthetic */ DataType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<DataType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                DataType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return DataType.CardRebind;
            L15:
                return DataType.ActionSyncPatch;
            L12:
                return DataType.Card;
            }

            public a(KClass<DataType> r1, Syntax r2, DataType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<DataType> getEntries() {
            return b;
        }

        static {
            DataType r0 = new DataType("Card", 0, 0);
            Card = r0;
            DataType r1 = new DataType("ActionSyncPatch", 1, 1);
            ActionSyncPatch = r1;
            DataType r3 = new DataType("CardRebind", 2, 2);
            CardRebind = r3;
            DataType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(DataType.class), Syntax.PROTO_2, r0);
        }

        public static DataType[] values() {
            return (DataType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final DataType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return CardRebind;
        L15:
            return ActionSyncPatch;
        L12:
            return Card;
        }

        public static DataType valueOf(String r1) {
            return (DataType) r27.a.a(DataType.class, r1);
        }

        public DataType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004!\"#$B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0011H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\f\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001d0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b¨\u0006%"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo$Builder;Lokio/ByteString;)V", "i18n_type", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo$I18nTypeEnum;", "getI18n_type", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo$I18nTypeEnum;", "is_i18n", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "locale", "", "getLocale", "()Ljava/lang/String;", "all_locales", "", "getAll_locales", "()Ljava/util/List;", "content_language", "", "getContent_language", "()Ljava/util/Map;", "locale_info", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo$LocaleInfo;", "getLocale_info", "newBuilder", "toString", "Builder", "Companion", "I18nTypeEnum", "LocaleInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class I18nInfo extends com.lark.wire.Message<I18nInfo, a> {
        public static final ProtoAdapter<I18nInfo> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final List<String> all_locales;
        private final Map<String, String> content_language;
        private final I18nTypeEnum i18n_type;
        private final Boolean is_i18n;
        private final String locale;
        private final Map<String, LocaleInfo> locale_info;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo$I18nTypeEnum;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "GLOBAL_I18N", "LOCAL_I18N", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum I18nTypeEnum extends Enum<I18nTypeEnum> implements o0 {
            public static final ProtoAdapter<I18nTypeEnum> ADAPTER = null;
            public static final b Companion = null;
            public static final I18nTypeEnum GLOBAL_I18N = null;
            public static final I18nTypeEnum LOCAL_I18N = null;
            public static final /* synthetic */ I18nTypeEnum[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<I18nTypeEnum> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    I18nTypeEnum.Companion.getClass();
                    if (r2 == 0) goto L9;
                    if (r2 == 1) goto L11;
                    return null;
                L11:
                    return I18nTypeEnum.LOCAL_I18N;
                L9:
                    return I18nTypeEnum.GLOBAL_I18N;
                }

                public a(KClass<I18nTypeEnum> r1, Syntax r2, I18nTypeEnum r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<I18nTypeEnum> getEntries() {
                return b;
            }

            static {
                I18nTypeEnum r0 = new I18nTypeEnum("GLOBAL_I18N", 0, 0);
                GLOBAL_I18N = r0;
                I18nTypeEnum r1 = new I18nTypeEnum("LOCAL_I18N", 1, 1);
                LOCAL_I18N = r1;
                I18nTypeEnum[] r3 = {r0, r1};
                a = r3;
                b = EnumEntriesKt.enumEntries(r3);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(I18nTypeEnum.class), Syntax.PROTO_2, r0);
            }

            public static I18nTypeEnum[] values() {
                return (I18nTypeEnum[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final I18nTypeEnum fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L11;
                return null;
            L11:
                return LOCAL_I18N;
            L9:
                return GLOBAL_I18N;
            }

            public static I18nTypeEnum valueOf(String r1) {
                return (I18nTypeEnum) r27.a.a(I18nTypeEnum.class, r1);
            }

            public I18nTypeEnum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo$LocaleInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo$LocaleInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$I18nInfo$LocaleInfo$Builder;Lokio/ByteString;)V", "content_languages", "", "", "getContent_languages", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class LocaleInfo extends com.lark.wire.Message<LocaleInfo, a> {
            public static final ProtoAdapter<LocaleInfo> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final List<String> content_languages;

            public static final class a extends com.lark.wire.Message.a<LocaleInfo, a> {
                public List<String> d;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new LocaleInfo(this, c(), null);
                }

                public a() {
                    this.d = CollectionsKt.emptyList();
                }
            }

            public static final class b extends ProtoAdapter<LocaleInfo> {
                @Override // com.lark.wire.ProtoAdapter
                public final LocaleInfo c(g0 r8) {
                    Intrinsics.checkNotNullParameter(r8, "reader");
                    a r1 = new a();
                    ArrayList r2 = new ArrayList();
                    long r3 = r8.c();
                L3:
                    int r5 = r8.e();
                    if (r5 == (-1)) goto L9;
                    if (r5 == 1) goto L7;
                    r8.j(r5);
                    goto L3
                L7:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r8, "reader");
                    r2.add(r8.i());
                    goto L3
                L9:
                    ByteString r9 = r8.d(r3);
                    Intrinsics.checkNotNullParameter(r2, "content_languages");
                    com.lark.wire.internal.a.a(r2);
                    r1.d = r2;
                    return new LocaleInfo(r1, r9, null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(LocaleInfo r4) {
                    LocaleInfo r5 = r4;
                    Intrinsics.checkNotNullParameter(r5, "value");
                    return r5.unknownFields().size() + ProtoAdapter.q.a().l(1, r5.getContent_languages());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, LocaleInfo r5) {
                    LocaleInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    ProtoAdapter.q.a().i(r4, 1, r6.getContent_languages());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r3, LocaleInfo r4) {
                    LocaleInfo r5 = r4;
                    Intrinsics.checkNotNullParameter(r3, "writer");
                    Intrinsics.checkNotNullParameter(r5, "value");
                    r3.d(r5.unknownFields());
                    ProtoAdapter.q.a().j(r3, 1, r5.getContent_languages());
                }

                public b(FieldEncoding r7, KClass<LocaleInfo> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.I18nInfo.LocaleInfo", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ LocaleInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LocaleInfo.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.content_languages;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(LocaleInfo.class).getSimpleName() + '@' + hashCode();
            }

            public final List<String> getContent_languages() {
                return this.content_languages;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public LocaleInfo(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.content_languages = com.lark.wire.internal.a.c("content_languages", r2.d);
            }

            public /* synthetic */ LocaleInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<I18nInfo, a> {
            public I18nTypeEnum d;
            public Boolean e;
            public String f;
            public List<String> g;
            public Map<String, String> h;
            public Map<String, LocaleInfo> i;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new I18nInfo(this, c(), null);
            }

            public a() {
                this.g = CollectionsKt.emptyList();
                this.h = MapsKt.emptyMap();
                this.i = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ I18nInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(I18nInfo.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new UniversalCardEntity$I18nInfo$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.i18n_type;
            r0.e = this.is_i18n;
            r0.f = this.locale;
            r0.g = this.all_locales;
            r0.h = this.content_language;
            r0.i = this.locale_info;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(I18nInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final List<String> getAll_locales() {
            return this.all_locales;
        }

        public final Map<String, String> getContent_language() {
            return this.content_language;
        }

        public final I18nTypeEnum getI18n_type() {
            return this.i18n_type;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final Map<String, LocaleInfo> getLocale_info() {
            return this.locale_info;
        }

        public final Boolean is_i18n() {
            return this.is_i18n;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public I18nInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.i18n_type = r2.d;
            this.is_i18n = r2.e;
            this.locale = r2.f;
            this.all_locales = com.lark.wire.internal.a.c("all_locales", r2.g);
            this.content_language = com.lark.wire.internal.a.d("content_language", r2.h);
            this.locale_info = com.lark.wire.internal.a.d("locale_info", r2.i);
        }

        public /* synthetic */ I18nInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$LocalExtraKey;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "OPEN_PLATFORM_MESSAGE_CARD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum LocalExtraKey extends Enum<LocalExtraKey> implements o0 {
        public static final ProtoAdapter<LocalExtraKey> ADAPTER = null;
        public static final b Companion = null;
        public static final LocalExtraKey OPEN_PLATFORM_MESSAGE_CARD = null;
        public static final LocalExtraKey UNKNOWN = null;
        public static final /* synthetic */ LocalExtraKey[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<LocalExtraKey> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                LocalExtraKey.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return LocalExtraKey.OPEN_PLATFORM_MESSAGE_CARD;
            L9:
                return LocalExtraKey.UNKNOWN;
            }

            public a(KClass<LocalExtraKey> r1, Syntax r2, LocalExtraKey r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<LocalExtraKey> getEntries() {
            return b;
        }

        static {
            LocalExtraKey r0 = new LocalExtraKey("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            LocalExtraKey r1 = new LocalExtraKey("OPEN_PLATFORM_MESSAGE_CARD", 1, 1);
            OPEN_PLATFORM_MESSAGE_CARD = r1;
            LocalExtraKey[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(LocalExtraKey.class), Syntax.PROTO_2, r0);
        }

        public static LocalExtraKey[] values() {
            return (LocalExtraKey[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final LocalExtraKey fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return OPEN_PLATFORM_MESSAGE_CARD;
        L9:
            return UNKNOWN;
        }

        public static LocalExtraKey valueOf(String r1) {
            return (LocalExtraKey) r27.a.a(LocalExtraKey.class, r1);
        }

        public LocalExtraKey(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$PatchInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$PatchInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$PatchInfo$Builder;Lokio/ByteString;)V", "target_version", "", "getTarget_version", "()Ljava/lang/Long;", "Ljava/lang/Long;", "patch_version", "getPatch_version", "data_source", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$DataSource;", "getData_source", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$DataSource;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PatchInfo extends com.lark.wire.Message<PatchInfo, a> {
        public static final ProtoAdapter<PatchInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final DataSource data_source;
        private final Long patch_version;
        private final Long target_version;

        public static final class a extends com.lark.wire.Message.a<PatchInfo, a> {
            public Long d;
            public Long e;
            public DataSource f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new PatchInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<PatchInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final PatchInfo c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L8;
                r0.d = (Long) ProtoAdapter.k.c(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = (Long) ProtoAdapter.k.c(r9);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = DataSource.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L19:
                return new PatchInfo(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(PatchInfo r5) {
                PatchInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                t r1 = ProtoAdapter.k;
                return ((r0 + r1.l(1, r6.getTarget_version())) + r1.l(2, r6.getPatch_version())) + DataSource.ADAPTER.l(3, r6.getData_source());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, PatchInfo r5) {
                PatchInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r4, 1, r6.getTarget_version());
                r0.i(r4, 2, r6.getPatch_version());
                DataSource.ADAPTER.i(r4, 3, r6.getData_source());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, PatchInfo r5) {
                PatchInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                DataSource.ADAPTER.j(r4, 3, r6.getData_source());
                t r0 = ProtoAdapter.k;
                r0.j(r4, 2, r6.getPatch_version());
                r0.j(r4, 1, r6.getTarget_version());
            }

            public b(FieldEncoding r7, KClass<PatchInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.PatchInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ PatchInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PatchInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.target_version;
            r0.e = this.patch_version;
            r0.f = this.data_source;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PatchInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final DataSource getData_source() {
            return this.data_source;
        }

        public final Long getPatch_version() {
            return this.patch_version;
        }

        public final Long getTarget_version() {
            return this.target_version;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public PatchInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.target_version = r2.d;
            this.patch_version = r2.e;
            this.data_source = r2.f;
        }

        public /* synthetic */ PatchInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$PrintStrategy;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "FAST", "DELAY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum PrintStrategy extends Enum<PrintStrategy> implements o0 {
        public static final ProtoAdapter<PrintStrategy> ADAPTER = null;
        public static final b Companion = null;
        public static final PrintStrategy DEFAULT = null;
        public static final PrintStrategy DELAY = null;
        public static final PrintStrategy FAST = null;
        public static final /* synthetic */ PrintStrategy[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<PrintStrategy> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                PrintStrategy.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return PrintStrategy.DELAY;
            L15:
                return PrintStrategy.FAST;
            L12:
                return PrintStrategy.DEFAULT;
            }

            public a(KClass<PrintStrategy> r1, Syntax r2, PrintStrategy r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<PrintStrategy> getEntries() {
            return b;
        }

        static {
            PrintStrategy r0 = new PrintStrategy("DEFAULT", 0, 0);
            DEFAULT = r0;
            PrintStrategy r1 = new PrintStrategy("FAST", 1, 1);
            FAST = r1;
            PrintStrategy r3 = new PrintStrategy("DELAY", 2, 2);
            DELAY = r3;
            PrintStrategy[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(PrintStrategy.class), Syntax.PROTO_2, r0);
        }

        public static PrintStrategy[] values() {
            return (PrintStrategy[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final PrintStrategy fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return DELAY;
        L15:
            return FAST;
        L12:
            return DEFAULT;
        }

        public static PrintStrategy valueOf(String r1) {
            return (PrintStrategy) r27.a.a(PrintStrategy.class, r1);
        }

        public PrintStrategy(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SourceType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SOURCE_TYPE_UNKNOWN", "URL_PREVIEW", "PROFILE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum SourceType extends Enum<SourceType> implements o0 {
        public static final ProtoAdapter<SourceType> ADAPTER = null;
        public static final b Companion = null;
        public static final SourceType PROFILE = null;
        public static final SourceType SOURCE_TYPE_UNKNOWN = null;
        public static final SourceType URL_PREVIEW = null;
        public static final /* synthetic */ SourceType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<SourceType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                SourceType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 4) goto L14;
                return null;
            L14:
                return SourceType.PROFILE;
            L15:
                return SourceType.URL_PREVIEW;
            L12:
                return SourceType.SOURCE_TYPE_UNKNOWN;
            }

            public a(KClass<SourceType> r1, Syntax r2, SourceType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<SourceType> getEntries() {
            return b;
        }

        static {
            SourceType r0 = new SourceType("SOURCE_TYPE_UNKNOWN", 0, 0);
            SOURCE_TYPE_UNKNOWN = r0;
            SourceType r1 = new SourceType("URL_PREVIEW", 1, 2);
            URL_PREVIEW = r1;
            SourceType r3 = new SourceType("PROFILE", 2, 4);
            PROFILE = r3;
            SourceType[] r6 = {r0, r1, r3};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(SourceType.class), Syntax.PROTO_2, r0);
        }

        public static SourceType[] values() {
            return (SourceType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final SourceType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return PROFILE;
        L15:
            return URL_PREVIEW;
        L12:
            return SOURCE_TYPE_UNKNOWN;
        }

        public static SourceType valueOf(String r1) {
            return (SourceType) r27.a.a(SourceType.class, r1);
        }

        public SourceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0015\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig$Builder;Lokio/ByteString;)V", "print_frequency_ms", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig$PrintConfig;", "getPrint_frequency_ms", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig$PrintConfig;", "print_step", "getPrint_step", "print_strategy", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$PrintStrategy;", "getPrint_strategy", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$PrintStrategy;", "newBuilder", "toString", "", "Builder", "Companion", "PrintConfig", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class StreamingConfig extends com.lark.wire.Message<StreamingConfig, a> {
        public static final ProtoAdapter<StreamingConfig> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final PrintConfig print_frequency_ms;
        private final PrintConfig print_step;
        private final PrintStrategy print_strategy;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig$PrintConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig$PrintConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$StreamingConfig$PrintConfig$Builder;Lokio/ByteString;)V", "default", "", "getDefault", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "android", "getAndroid", "ios", "getIos", "pc", "getPc", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class PrintConfig extends com.lark.wire.Message<PrintConfig, a> {
            public static final ProtoAdapter<PrintConfig> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final Integer android;

            /* JADX INFO: renamed from: default, reason: not valid java name */
            private final Integer f2default;
            private final Integer ios;
            private final Integer pc;

            public static final class a extends com.lark.wire.Message.a<PrintConfig, a> {
                public Integer d;
                public Integer e;
                public Integer f;
                public Integer g;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new PrintConfig(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<PrintConfig> {
                @Override // com.lark.wire.ProtoAdapter
                public final PrintConfig c(g0 r6) {
                    Intrinsics.checkNotNullParameter(r6, "reader");
                    a r0 = new a();
                    long r1 = r6.c();
                L3:
                    int r3 = r6.e();
                    if (r3 == (-1)) goto L19;
                    if (r3 != 1) goto L8;
                    r0.d = (Integer) ProtoAdapter.h.c(r6);
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.e = (Integer) ProtoAdapter.h.c(r6);
                    goto L3
                L10:
                    if (r3 != 3) goto L12;
                    r0.f = (Integer) ProtoAdapter.h.c(r6);
                    goto L3
                L12:
                    if (r3 != 4) goto L13;
                    r0.g = (Integer) ProtoAdapter.h.c(r6);
                    goto L3
                L13:
                    r6.j(r3);
                    Unit r4 = Unit.INSTANCE;
                    goto L3
                L19:
                    return new PrintConfig(r0, r6.d(r1), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(PrintConfig r5) {
                    PrintConfig r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = r6.unknownFields().size();
                    s r1 = ProtoAdapter.h;
                    return (((r0 + r1.l(1, r6.getDefault())) + r1.l(2, r6.getAndroid())) + r1.l(3, r6.getIos())) + r1.l(4, r6.getPc());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, PrintConfig r5) {
                    PrintConfig r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    s r0 = ProtoAdapter.h;
                    r0.i(r4, 1, r6.getDefault());
                    r0.i(r4, 2, r6.getAndroid());
                    r0.i(r4, 3, r6.getIos());
                    r0.i(r4, 4, r6.getPc());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, PrintConfig r5) {
                    PrintConfig r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    s r0 = ProtoAdapter.h;
                    r0.j(r4, 4, r6.getPc());
                    r0.j(r4, 3, r6.getIos());
                    r0.j(r4, 2, r6.getAndroid());
                    r0.j(r4, 1, r6.getDefault());
                }

                public b(FieldEncoding r7, KClass<PrintConfig> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.StreamingConfig.PrintConfig", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ PrintConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(PrintConfig.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.f2default;
                r0.e = this.android;
                r0.f = this.ios;
                r0.g = this.pc;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(PrintConfig.class).getSimpleName() + '@' + hashCode();
            }

            public final Integer getAndroid() {
                return this.android;
            }

            public final Integer getDefault() {
                return this.f2default;
            }

            public final Integer getIos() {
                return this.ios;
            }

            public final Integer getPc() {
                return this.pc;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public PrintConfig(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.f2default = r2.d;
                this.android = r2.e;
                this.ios = r2.f;
                this.pc = r2.g;
            }

            public /* synthetic */ PrintConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<StreamingConfig, a> {
            public PrintConfig d;
            public PrintConfig e;
            public PrintStrategy f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new StreamingConfig(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<StreamingConfig> {
            @Override // com.lark.wire.ProtoAdapter
            public final StreamingConfig c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L8;
                r0.d = PrintConfig.ADAPTER.c(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = PrintConfig.ADAPTER.c(r9);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = PrintStrategy.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L19:
                return new StreamingConfig(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(StreamingConfig r5) {
                StreamingConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                ProtoAdapter<PrintConfig> r1 = PrintConfig.ADAPTER;
                return ((r0 + r1.l(1, r6.getPrint_frequency_ms())) + r1.l(2, r6.getPrint_step())) + PrintStrategy.ADAPTER.l(3, r6.getPrint_strategy());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, StreamingConfig r5) {
                StreamingConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter<PrintConfig> r0 = PrintConfig.ADAPTER;
                r0.i(r4, 1, r6.getPrint_frequency_ms());
                r0.i(r4, 2, r6.getPrint_step());
                PrintStrategy.ADAPTER.i(r4, 3, r6.getPrint_strategy());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, StreamingConfig r5) {
                StreamingConfig r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                PrintStrategy.ADAPTER.j(r4, 3, r6.getPrint_strategy());
                ProtoAdapter<PrintConfig> r0 = PrintConfig.ADAPTER;
                r0.j(r4, 2, r6.getPrint_step());
                r0.j(r4, 1, r6.getPrint_frequency_ms());
            }

            public b(FieldEncoding r7, KClass<StreamingConfig> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.StreamingConfig", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ StreamingConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(StreamingConfig.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.print_frequency_ms;
            r0.e = this.print_step;
            r0.f = this.print_strategy;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(StreamingConfig.class).getSimpleName() + '@' + hashCode();
        }

        public final PrintConfig getPrint_frequency_ms() {
            return this.print_frequency_ms;
        }

        public final PrintConfig getPrint_step() {
            return this.print_step;
        }

        public final PrintStrategy getPrint_strategy() {
            return this.print_strategy;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public StreamingConfig(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.print_frequency_ms = r2.d;
            this.print_step = r2.e;
            this.print_strategy = r2.f;
        }

        public /* synthetic */ StreamingConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Builder;Lokio/ByteString;)V", "items", "", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item;", "getItems", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "Item", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SummaryContent extends com.lark.wire.Message<SummaryContent, a> {
        public static final ProtoAdapter<SummaryContent> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final List<Item> items;

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\"#$%&'B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Builder;Lokio/ByteString;)V", "text", "", "getText", "()Ljava/lang/String;", "image", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Image;", "getImage", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Image;", "at_user", "Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty;", "getAt_user", "()Lcom/lark/kmp/pb/basic/v1/RichTextElement$AtProperty;", "emotion", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Emotion;", "getEmotion", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Emotion;", "person_list", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$CharacterList;", "getPerson_list", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$CharacterList;", "i18n_content", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$I18NContent;", "getI18n_content", "()Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$I18NContent;", "newBuilder", "toString", "Builder", "Companion", "Image", "Emotion", "CharacterList", "I18NContent", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class Item extends com.lark.wire.Message<Item, a> {
            public static final ProtoAdapter<Item> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final RichTextElement.AtProperty at_user;
            private final Emotion emotion;
            private final I18NContent i18n_content;
            private final Image image;
            private final CharacterList person_list;
            private final String text;

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$CharacterList;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$CharacterList$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$CharacterList$Builder;Lokio/ByteString;)V", "characters", "", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Character;", "getCharacters", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final class CharacterList extends com.lark.wire.Message<CharacterList, a> {
                public static final ProtoAdapter<CharacterList> ADAPTER = null;
                public static final c Companion = null;
                private static final long serialVersionUID = 0;
                private final List<Character> characters;

                public static final class a extends com.lark.wire.Message.a<CharacterList, a> {
                    public List<Character> d;

                    @Override // com.lark.wire.Message.a
                    public final com.lark.wire.Message b() {
                        return new CharacterList(this, c(), null);
                    }

                    public a() {
                        this.d = CollectionsKt.emptyList();
                    }
                }

                public static final class b extends ProtoAdapter<CharacterList> {
                    @Override // com.lark.wire.ProtoAdapter
                    public final CharacterList c(g0 r7) {
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
                        r1.add(Character.ADAPTER.c(r7));
                        goto L3
                    L9:
                        ByteString r8 = r7.d(r2);
                        Intrinsics.checkNotNullParameter(r1, "characters");
                        com.lark.wire.internal.a.a(r1);
                        r0.d = r1;
                        return new CharacterList(r0, r8, null);
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final int k(CharacterList r4) {
                        CharacterList r5 = r4;
                        Intrinsics.checkNotNullParameter(r5, "value");
                        return r5.unknownFields().size() + Character.ADAPTER.a().l(1, r5.getCharacters());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void f(j0 r4, CharacterList r5) {
                        CharacterList r6 = r5;
                        Intrinsics.checkNotNullParameter(r4, "writer");
                        Intrinsics.checkNotNullParameter(r6, "value");
                        Character.ADAPTER.a().i(r4, 1, r6.getCharacters());
                        r4.a(r6.unknownFields());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void g(n0 r3, CharacterList r4) {
                        CharacterList r5 = r4;
                        Intrinsics.checkNotNullParameter(r3, "writer");
                        Intrinsics.checkNotNullParameter(r5, "value");
                        r3.d(r5.unknownFields());
                        Character.ADAPTER.a().j(r3, 1, r5.getCharacters());
                    }

                    public b(FieldEncoding r7, KClass<CharacterList> r8, Syntax r9) {
                        super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.SummaryContent.Item.CharacterList", r9, null);
                    }
                }

                public static final class c {
                    public c() {
                    }
                }

                public /* synthetic */ CharacterList(a r1, ByteString r2, DefaultConstructorMarker r3) {
                    this(r1, r2);
                }

                static {
                    Companion = new c();
                    ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CharacterList.class), Syntax.PROTO_2);
                }

                @Override // com.lark.wire.Message
                public a newBuilder() {
                    a r0 = new a();
                    r0.d = this.characters;
                    r0.a(unknownFields());
                    return r0;
                }

                @Override // com.lark.wire.Message
                public String toString() {
                    return Reflection.getOrCreateKotlinClass(CharacterList.class).getSimpleName() + '@' + hashCode();
                }

                public final List<Character> getCharacters() {
                    return this.characters;
                }

                @Override // com.lark.wire.Message
                public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                    return newBuilder();
                }

                public CharacterList(a r2, ByteString r3) {
                    super(ADAPTER, r3);
                    this.characters = com.lark.wire.internal.a.c("characters", r2.d);
                }

                public /* synthetic */ CharacterList(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                    if ((r3 & 2) == 0) goto L5;
                    r2 = ByteString.EMPTY;
                L5:
                    this(r1, r2);
                }
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Emotion;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Emotion$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Emotion$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final class Emotion extends com.lark.wire.Message<Emotion, a> {
                public static final ProtoAdapter<Emotion> ADAPTER = null;
                public static final c Companion = null;
                private static final long serialVersionUID = 0;
                private final String key;

                public static final class a extends com.lark.wire.Message.a<Emotion, a> {
                    public String d;

                    @Override // com.lark.wire.Message.a
                    public final com.lark.wire.Message b() {
                        return new Emotion(this, c(), null);
                    }

                    public a() {
                    }
                }

                public static final class b extends ProtoAdapter<Emotion> {
                    @Override // com.lark.wire.ProtoAdapter
                    public final Emotion c(g0 r7) {
                        Intrinsics.checkNotNullParameter(r7, "reader");
                        a r1 = new a();
                        long r2 = r7.c();
                    L3:
                        int r4 = r7.e();
                        if (r4 == (-1)) goto L10;
                        if (r4 == 1) goto L7;
                        r7.j(r4);
                        goto L3
                    L7:
                        ProtoAdapter.q.getClass();
                        Intrinsics.checkNotNullParameter(r7, "reader");
                        String r5 = r7.i();
                        Intrinsics.checkNotNullParameter(r5, "key");
                        r1.d = r5;
                        goto L3
                    L10:
                        return new Emotion(r1, r7.d(r2), null);
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final int k(Emotion r4) {
                        Emotion r5 = r4;
                        Intrinsics.checkNotNullParameter(r5, "value");
                        return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getKey());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void f(j0 r4, Emotion r5) {
                        Emotion r6 = r5;
                        Intrinsics.checkNotNullParameter(r4, "writer");
                        Intrinsics.checkNotNullParameter(r6, "value");
                        ProtoAdapter.q.i(r4, 1, r6.getKey());
                        r4.a(r6.unknownFields());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void g(n0 r3, Emotion r4) {
                        Emotion r5 = r4;
                        Intrinsics.checkNotNullParameter(r3, "writer");
                        Intrinsics.checkNotNullParameter(r5, "value");
                        r3.d(r5.unknownFields());
                        ProtoAdapter.q.j(r3, 1, r5.getKey());
                    }

                    public b(FieldEncoding r7, KClass<Emotion> r8, Syntax r9) {
                        super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.SummaryContent.Item.Emotion", r9, null);
                    }
                }

                public static final class c {
                    public c() {
                    }
                }

                public /* synthetic */ Emotion(a r1, ByteString r2, DefaultConstructorMarker r3) {
                    this(r1, r2);
                }

                static {
                    Companion = new c();
                    ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Emotion.class), Syntax.PROTO_2);
                }

                @Override // com.lark.wire.Message
                public a newBuilder() {
                    a r0 = new a();
                    r0.d = this.key;
                    r0.a(unknownFields());
                    return r0;
                }

                @Override // com.lark.wire.Message
                public String toString() {
                    return Reflection.getOrCreateKotlinClass(Emotion.class).getSimpleName() + '@' + hashCode();
                }

                public final String getKey() {
                    return this.key;
                }

                @Override // com.lark.wire.Message
                public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                    return newBuilder();
                }

                public Emotion(a r2, ByteString r3) {
                    super(ADAPTER, r3);
                    String r4 = r2.d;
                    Intrinsics.checkNotNull(r4);
                    this.key = r4;
                }

                public /* synthetic */ Emotion(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                    if ((r3 & 2) == 0) goto L5;
                    r2 = ByteString.EMPTY;
                L5:
                    this(r1, r2);
                }
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$I18NContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$I18NContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$I18NContent$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "defaultValue", "getDefaultValue", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final class I18NContent extends com.lark.wire.Message<I18NContent, a> {
                public static final ProtoAdapter<I18NContent> ADAPTER = null;
                public static final c Companion = null;
                private static final long serialVersionUID = 0;
                private final String defaultValue;
                private final String key;

                public static final class a extends com.lark.wire.Message.a<I18NContent, a> {
                    public String d;
                    public String e;

                    @Override // com.lark.wire.Message.a
                    public final com.lark.wire.Message b() {
                        return new I18NContent(this, c(), null);
                    }

                    public a() {
                    }
                }

                public static final class b extends ProtoAdapter<I18NContent> {
                    @Override // com.lark.wire.ProtoAdapter
                    public final I18NContent c(g0 r7) {
                        Intrinsics.checkNotNullParameter(r7, "reader");
                        a r1 = new a();
                        long r2 = r7.c();
                    L3:
                        int r4 = r7.e();
                        if (r4 == (-1)) goto L13;
                        if (r4 != 1) goto L8;
                        ProtoAdapter.q.getClass();
                        Intrinsics.checkNotNullParameter(r7, "reader");
                        String r5 = r7.i();
                        Intrinsics.checkNotNullParameter(r5, "key");
                        r1.d = r5;
                        goto L3
                    L8:
                        if (r4 != 2) goto L9;
                        ProtoAdapter.q.getClass();
                        Intrinsics.checkNotNullParameter(r7, "reader");
                        r1.e = r7.i();
                        goto L3
                    L9:
                        r7.j(r4);
                        Unit r6 = Unit.INSTANCE;
                        goto L3
                    L13:
                        return new I18NContent(r1, r7.d(r2), null);
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final int k(I18NContent r5) {
                        I18NContent r6 = r5;
                        Intrinsics.checkNotNullParameter(r6, "value");
                        int r0 = r6.unknownFields().size();
                        w r1 = ProtoAdapter.q;
                        return (r0 + r1.l(1, r6.getKey())) + r1.l(2, r6.getDefaultValue());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void f(j0 r4, I18NContent r5) {
                        I18NContent r6 = r5;
                        Intrinsics.checkNotNullParameter(r4, "writer");
                        Intrinsics.checkNotNullParameter(r6, "value");
                        w r0 = ProtoAdapter.q;
                        r0.i(r4, 1, r6.getKey());
                        r0.i(r4, 2, r6.getDefaultValue());
                        r4.a(r6.unknownFields());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void g(n0 r4, I18NContent r5) {
                        I18NContent r6 = r5;
                        Intrinsics.checkNotNullParameter(r4, "writer");
                        Intrinsics.checkNotNullParameter(r6, "value");
                        r4.d(r6.unknownFields());
                        w r0 = ProtoAdapter.q;
                        r0.j(r4, 2, r6.getDefaultValue());
                        r0.j(r4, 1, r6.getKey());
                    }

                    public b(FieldEncoding r7, KClass<I18NContent> r8, Syntax r9) {
                        super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.SummaryContent.Item.I18NContent", r9, null);
                    }
                }

                public static final class c {
                    public c() {
                    }
                }

                public /* synthetic */ I18NContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
                    this(r1, r2);
                }

                static {
                    Companion = new c();
                    ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(I18NContent.class), Syntax.PROTO_2);
                }

                @Override // com.lark.wire.Message
                public a newBuilder() {
                    a r0 = new a();
                    r0.d = this.key;
                    r0.e = this.defaultValue;
                    r0.a(unknownFields());
                    return r0;
                }

                @Override // com.lark.wire.Message
                public String toString() {
                    return Reflection.getOrCreateKotlinClass(I18NContent.class).getSimpleName() + '@' + hashCode();
                }

                public final String getDefaultValue() {
                    return this.defaultValue;
                }

                public final String getKey() {
                    return this.key;
                }

                @Override // com.lark.wire.Message
                public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                    return newBuilder();
                }

                public I18NContent(a r2, ByteString r3) {
                    super(ADAPTER, r3);
                    String r4 = r2.d;
                    Intrinsics.checkNotNull(r4);
                    this.key = r4;
                    this.defaultValue = r2.e;
                }

                public /* synthetic */ I18NContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                    if ((r3 & 2) == 0) goto L5;
                    r2 = ByteString.EMPTY;
                L5:
                    this(r1, r2);
                }
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Image;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Image$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$SummaryContent$Item$Image$Builder;Lokio/ByteString;)V", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final class Image extends com.lark.wire.Message<Image, a> {
                public static final ProtoAdapter<Image> ADAPTER = null;
                public static final c Companion = null;
                private static final long serialVersionUID = 0;

                public static final class a extends com.lark.wire.Message.a<Image, a> {
                    @Override // com.lark.wire.Message.a
                    public final com.lark.wire.Message b() {
                        return new Image(this, c(), null);
                    }

                    public a() {
                    }
                }

                public static final class b extends ProtoAdapter<Image> {
                    @Override // com.lark.wire.ProtoAdapter
                    public final Image c(g0 r6) {
                        Intrinsics.checkNotNullParameter(r6, "reader");
                        a r0 = new a();
                        long r1 = r6.c();
                    L3:
                        int r3 = r6.e();
                        if (r3 == (-1)) goto L7;
                        r6.j(r3);
                        goto L3
                    L7:
                        return new Image(r0, r6.d(r1), null);
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final int k(Image r2) {
                        Image r3 = r2;
                        Intrinsics.checkNotNullParameter(r3, "value");
                        return r3.unknownFields().size();
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void f(j0 r2, Image r3) {
                        Image r4 = r3;
                        Intrinsics.checkNotNullParameter(r2, "writer");
                        Intrinsics.checkNotNullParameter(r4, "value");
                        r2.a(r4.unknownFields());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void g(n0 r2, Image r3) {
                        Image r4 = r3;
                        Intrinsics.checkNotNullParameter(r2, "writer");
                        Intrinsics.checkNotNullParameter(r4, "value");
                        r2.d(r4.unknownFields());
                    }

                    public b(FieldEncoding r7, KClass<Image> r8, Syntax r9) {
                        super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.SummaryContent.Item.Image", r9, null);
                    }
                }

                public static final class c {
                    public c() {
                    }
                }

                public /* synthetic */ Image(a r1, ByteString r2, DefaultConstructorMarker r3) {
                    this(r2);
                }

                static {
                    Companion = new c();
                    ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Image.class), Syntax.PROTO_2);
                }

                @Override // com.lark.wire.Message
                public a newBuilder() {
                    a r0 = new a();
                    r0.a(unknownFields());
                    return r0;
                }

                @Override // com.lark.wire.Message
                public String toString() {
                    return Reflection.getOrCreateKotlinClass(Image.class).getSimpleName() + '@' + hashCode();
                }

                @Override // com.lark.wire.Message
                public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                    return newBuilder();
                }

                public Image(ByteString r2) {
                    super(ADAPTER, r2);
                }

                public /* synthetic */ Image(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                    if ((r3 & 2) == 0) goto L5;
                    r2 = ByteString.EMPTY;
                L5:
                    this(r2);
                }
            }

            public static final class a extends com.lark.wire.Message.a<Item, a> {
                public String d;
                public Image e;
                public RichTextElement.AtProperty f;
                public Emotion g;
                public CharacterList h;
                public I18NContent i;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new Item(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<Item> {
                @Override // com.lark.wire.ProtoAdapter
                public final Item c(g0 r8) {
                    Intrinsics.checkNotNullParameter(r8, "reader");
                    a r1 = new a();
                    long r2 = r8.c();
                L3:
                    int r4 = r8.e();
                    DefaultConstructorMarker r6 = null;
                    if (r4 == (-1)) goto L14;
                    switch(r4) {
                        case 1: goto L12;
                        case 2: goto L11;
                        case 3: goto L10;
                        case 4: goto L9;
                        case 5: goto L8;
                        case 6: goto L7;
                        default: goto L6;
                    };
                L7:
                    r1.i = I18NContent.ADAPTER.c(r8);
                    r1.d = null;
                    r1.e = null;
                    r1.f = null;
                    r1.g = null;
                    r1.h = null;
                    goto L3
                L8:
                    r1.h = CharacterList.ADAPTER.c(r8);
                    r1.d = null;
                    r1.e = null;
                    r1.f = null;
                    r1.g = null;
                    r1.i = null;
                    goto L3
                L9:
                    r1.g = Emotion.ADAPTER.c(r8);
                    r1.d = null;
                    r1.e = null;
                    r1.f = null;
                    r1.h = null;
                    r1.i = null;
                    goto L3
                L10:
                    r1.f = RichTextElement.AtProperty.ADAPTER.c(r8);
                    r1.d = null;
                    r1.e = null;
                    r1.g = null;
                    r1.h = null;
                    r1.i = null;
                    goto L3
                L11:
                    r1.e = Image.ADAPTER.c(r8);
                    r1.d = null;
                    r1.f = null;
                    r1.g = null;
                    r1.h = null;
                    r1.i = null;
                    goto L3
                L12:
                    ProtoAdapter.q.getClass();
                    Intrinsics.checkNotNullParameter(r8, "reader");
                    r1.d = r8.i();
                    r1.e = null;
                    r1.f = null;
                    r1.g = null;
                    r1.h = null;
                    r1.i = null;
                    goto L3
                L6:
                    r8.j(r4);
                    Unit r5 = Unit.INSTANCE;
                    goto L3
                L14:
                    return new Item(r1, r8.d(r2), r6);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(Item r5) {
                    Item r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    return (((((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getText())) + Image.ADAPTER.l(2, r6.getImage())) + RichTextElement.AtProperty.ADAPTER.l(3, r6.getAt_user())) + Emotion.ADAPTER.l(4, r6.getEmotion())) + CharacterList.ADAPTER.l(5, r6.getPerson_list())) + I18NContent.ADAPTER.l(6, r6.getI18n_content());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, Item r5) {
                    Item r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    ProtoAdapter.q.i(r4, 1, r6.getText());
                    Image.ADAPTER.i(r4, 2, r6.getImage());
                    RichTextElement.AtProperty.ADAPTER.i(r4, 3, r6.getAt_user());
                    Emotion.ADAPTER.i(r4, 4, r6.getEmotion());
                    CharacterList.ADAPTER.i(r4, 5, r6.getPerson_list());
                    I18NContent.ADAPTER.i(r4, 6, r6.getI18n_content());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, Item r5) {
                    Item r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    I18NContent.ADAPTER.j(r4, 6, r6.getI18n_content());
                    CharacterList.ADAPTER.j(r4, 5, r6.getPerson_list());
                    Emotion.ADAPTER.j(r4, 4, r6.getEmotion());
                    RichTextElement.AtProperty.ADAPTER.j(r4, 3, r6.getAt_user());
                    Image.ADAPTER.j(r4, 2, r6.getImage());
                    ProtoAdapter.q.j(r4, 1, r6.getText());
                }

                public b(FieldEncoding r7, KClass<Item> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.SummaryContent.Item", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ Item(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Item.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.text;
                r0.e = this.image;
                r0.f = this.at_user;
                r0.g = this.emotion;
                r0.h = this.person_list;
                r0.i = this.i18n_content;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(Item.class).getSimpleName() + '@' + hashCode();
            }

            public final RichTextElement.AtProperty getAt_user() {
                return this.at_user;
            }

            public final Emotion getEmotion() {
                return this.emotion;
            }

            public final I18NContent getI18n_content() {
                return this.i18n_content;
            }

            public final Image getImage() {
                return this.image;
            }

            public final CharacterList getPerson_list() {
                return this.person_list;
            }

            public final String getText() {
                return this.text;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public Item(a r7, ByteString r8) {
                super(ADAPTER, r8);
                String r9 = r7.d;
                this.text = r9;
                Image r0 = r7.e;
                this.image = r0;
                RichTextElement.AtProperty r1 = r7.f;
                this.at_user = r1;
                Emotion r2 = r7.g;
                this.emotion = r2;
                CharacterList r3 = r7.h;
                this.person_list = r3;
                I18NContent r10 = r7.i;
                this.i18n_content = r10;
                boolean r5 = false;
                if (com.lark.wire.internal.a.b(r9, r0, r1, r2, new Object[]{r3, r10}) > 1) goto L5;
                r5 = true;
            L5:
                if (r5 == false) goto L8;
                return;
            L8:
                throw new IllegalArgumentException("At most one of text, image, at_user, emotion, person_list, i18n_content may be non-null".toString());
            }

            public /* synthetic */ Item(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<SummaryContent, a> {
            public List<Item> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SummaryContent(this, c(), null);
            }

            public a() {
                this.d = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<SummaryContent> {
            @Override // com.lark.wire.ProtoAdapter
            public final SummaryContent c(g0 r7) {
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
                r1.add(Item.ADAPTER.c(r7));
                goto L3
            L9:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "items");
                com.lark.wire.internal.a.a(r1);
                r0.d = r1;
                return new SummaryContent(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SummaryContent r4) {
                SummaryContent r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + Item.ADAPTER.a().l(1, r5.getItems());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SummaryContent r5) {
                SummaryContent r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Item.ADAPTER.a().i(r4, 1, r6.getItems());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, SummaryContent r4) {
                SummaryContent r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                Item.ADAPTER.a().j(r3, 1, r5.getItems());
            }

            public b(FieldEncoding r7, KClass<SummaryContent> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.SummaryContent", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SummaryContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SummaryContent.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.items;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SummaryContent.class).getSimpleName() + '@' + hashCode();
        }

        public final List<Item> getItems() {
            return this.items;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SummaryContent(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.items = com.lark.wire.internal.a.c("items", r2.d);
        }

        public /* synthetic */ SummaryContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Url;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Url$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$Url$Builder;Lokio/ByteString;)V", "url", "", "getUrl", "()Ljava/lang/String;", "ios_url", "getIos_url", "android_url", "getAndroid_url", "pc_url", "getPc_url", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Url extends com.lark.wire.Message<Url, a> {
        public static final ProtoAdapter<Url> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String android_url;
        private final String ios_url;
        private final String pc_url;
        private final String url;

        public static final class a extends com.lark.wire.Message.a<Url, a> {
            public String d;
            public String e;
            public String f;
            public String g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Url(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Url> {
            @Override // com.lark.wire.ProtoAdapter
            public final Url c(g0 r7) {
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
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                if (r4 != 4) goto L13;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L13:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L19:
                return new Url(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((r0 + r1.l(1, r6.getUrl())) + r1.l(2, r6.getIos_url())) + r1.l(3, r6.getAndroid_url())) + r1.l(4, r6.getPc_url());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getUrl());
                r0.i(r4, 2, r6.getIos_url());
                r0.i(r4, 3, r6.getAndroid_url());
                r0.i(r4, 4, r6.getPc_url());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Url r5) {
                Url r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 4, r6.getPc_url());
                r0.j(r4, 3, r6.getAndroid_url());
                r0.j(r4, 2, r6.getIos_url());
                r0.j(r4, 1, r6.getUrl());
            }

            public b(FieldEncoding r7, KClass<Url> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.Url", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Url(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Url.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.url;
            r0.e = this.ios_url;
            r0.f = this.android_url;
            r0.g = this.pc_url;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Url.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAndroid_url() {
            return this.android_url;
        }

        public final String getIos_url() {
            return this.ios_url;
        }

        public final String getPc_url() {
            return this.pc_url;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Url(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.url = r2.d;
            this.ios_url = r2.e;
            this.android_url = r2.f;
            this.pc_url = r2.g;
        }

        public /* synthetic */ Url(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$VideoInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$VideoInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/UniversalCardEntity$VideoInfo$Builder;Lokio/ByteString;)V", "key", "", "getKey", "()Ljava/lang/String;", "duration", "", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "size", "", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "url", "getUrl", "mime", "getMime", "fs_unit", "getFs_unit", "visit_info", "Lcom/lark/kmp/pb/basic/v1/CardVisitInfo;", "getVisit_info", "()Lcom/lark/kmp/pb/basic/v1/CardVisitInfo;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class VideoInfo extends com.lark.wire.Message<VideoInfo, a> {
        public static final ProtoAdapter<VideoInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Integer duration;
        private final String fs_unit;
        private final String key;
        private final String mime;
        private final Long size;
        private final String url;
        private final CardVisitInfo visit_info;

        public static final class a extends com.lark.wire.Message.a<VideoInfo, a> {
            public String d;
            public Integer e;
            public Long f;
            public String g;
            public String h;
            public String i;
            public CardVisitInfo j;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new VideoInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<VideoInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final VideoInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L15;
                switch(r4) {
                    case 1: goto L13;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L7:
                r1.j = CardVisitInfo.ADAPTER.c(r7);
                goto L3
            L8:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.i = r7.i();
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.h = r7.i();
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L11:
                r1.f = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L12:
                r1.e = (Integer) ProtoAdapter.h.c(r7);
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L15:
                return new VideoInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(VideoInfo r6) {
                VideoInfo r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((((((r0 + r1.l(1, r7.getKey())) + ProtoAdapter.h.l(2, r7.getDuration())) + ProtoAdapter.k.l(3, r7.getSize())) + r1.l(4, r7.getUrl())) + r1.l(5, r7.getMime())) + r1.l(6, r7.getFs_unit())) + CardVisitInfo.ADAPTER.l(7, r7.getVisit_info());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, VideoInfo r6) {
                VideoInfo r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getKey());
                ProtoAdapter.h.i(r5, 2, r7.getDuration());
                ProtoAdapter.k.i(r5, 3, r7.getSize());
                r0.i(r5, 4, r7.getUrl());
                r0.i(r5, 5, r7.getMime());
                r0.i(r5, 6, r7.getFs_unit());
                CardVisitInfo.ADAPTER.i(r5, 7, r7.getVisit_info());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, VideoInfo r6) {
                VideoInfo r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                CardVisitInfo.ADAPTER.j(r5, 7, r7.getVisit_info());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 6, r7.getFs_unit());
                r0.j(r5, 5, r7.getMime());
                r0.j(r5, 4, r7.getUrl());
                ProtoAdapter.k.j(r5, 3, r7.getSize());
                ProtoAdapter.h.j(r5, 2, r7.getDuration());
                r0.j(r5, 1, r7.getKey());
            }

            public b(FieldEncoding r7, KClass<VideoInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.UniversalCardEntity.VideoInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ VideoInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VideoInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.key;
            r0.e = this.duration;
            r0.f = this.size;
            r0.g = this.url;
            r0.h = this.mime;
            r0.i = this.fs_unit;
            r0.j = this.visit_info;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(VideoInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getDuration() {
            return this.duration;
        }

        public final String getFs_unit() {
            return this.fs_unit;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getMime() {
            return this.mime;
        }

        public final Long getSize() {
            return this.size;
        }

        public final String getUrl() {
            return this.url;
        }

        public final CardVisitInfo getVisit_info() {
            return this.visit_info;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public VideoInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.key = r2.d;
            this.duration = r2.e;
            this.size = r2.f;
            this.url = r2.g;
            this.mime = r2.h;
            this.fs_unit = r2.i;
            this.visit_info = r2.j;
        }

        public /* synthetic */ VideoInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<UniversalCardEntity, a> {
        public String d;
        public String e;
        public Content f;
        public String g;
        public Integer h;
        public ActionStatus i;
        public String j;
        public Map<Integer, String> k;
        public CardAppInfo l;
        public Boolean m;
        public DataSource n;
        public StreamingConfig o;
        public DataType p;
        public PatchInfo q;
        public Map<String, ResourceCleanScene> r;
        public Long s;
        public Long t;
        public List<Url> u;
        public CardHeader v;
        public ActionDataSource w;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new UniversalCardEntity(this, c(), null);
        }

        public a() {
            this.k = MapsKt.emptyMap();
            this.r = MapsKt.emptyMap();
            this.u = CollectionsKt.emptyList();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ UniversalCardEntity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new b();
        final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
        final KClass r1 = Reflection.getOrCreateKotlinClass(UniversalCardEntity.class);
        final Syntax r2 = Syntax.PROTO_2;
        ADAPTER = new UniversalCardEntity$Companion$ADAPTER$1(r0, r1, r2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.card_id;
        r0.e = this.version;
        r0.f = this.content;
        r0.g = this.source_id;
        r0.h = this.source_type;
        r0.i = this.action_status;
        r0.j = this.action_url;
        r0.k = this.local_extra;
        r0.l = this.app_info;
        r0.m = this.streaming_mode;
        r0.n = this.data_source;
        r0.o = this.streaming_config;
        r0.p = this.data_type;
        r0.q = this.patch_info;
        r0.r = this.clean_resource_key_scene;
        r0.s = this.app_id;
        r0.t = this.bot_id;
        r0.u = this.json_card_urls;
        r0.v = this.card_header;
        r0.w = this.action_data_source;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(UniversalCardEntity.class).getSimpleName() + '@' + hashCode();
    }

    public final ActionDataSource getAction_data_source() {
        return this.action_data_source;
    }

    public final ActionStatus getAction_status() {
        return this.action_status;
    }

    public final String getAction_url() {
        return this.action_url;
    }

    public final Long getApp_id() {
        return this.app_id;
    }

    public final CardAppInfo getApp_info() {
        return this.app_info;
    }

    public final Long getBot_id() {
        return this.bot_id;
    }

    public final CardHeader getCard_header() {
        return this.card_header;
    }

    public final String getCard_id() {
        return this.card_id;
    }

    public final Map<String, ResourceCleanScene> getClean_resource_key_scene() {
        return this.clean_resource_key_scene;
    }

    public final Content getContent() {
        return this.content;
    }

    public final DataSource getData_source() {
        return this.data_source;
    }

    public final DataType getData_type() {
        return this.data_type;
    }

    public final List<Url> getJson_card_urls() {
        return this.json_card_urls;
    }

    public final Map<Integer, String> getLocal_extra() {
        return this.local_extra;
    }

    public final PatchInfo getPatch_info() {
        return this.patch_info;
    }

    public final String getSource_id() {
        return this.source_id;
    }

    public final Integer getSource_type() {
        return this.source_type;
    }

    public final StreamingConfig getStreaming_config() {
        return this.streaming_config;
    }

    public final Boolean getStreaming_mode() {
        return this.streaming_mode;
    }

    public final String getVersion() {
        return this.version;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public UniversalCardEntity(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.card_id = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.version = r5;
        Content r6 = r2.f;
        Intrinsics.checkNotNull(r6);
        this.content = r6;
        this.source_id = r2.g;
        this.source_type = r2.h;
        this.action_status = r2.i;
        this.action_url = r2.j;
        this.local_extra = com.lark.wire.internal.a.d("local_extra", r2.k);
        this.app_info = r2.l;
        this.streaming_mode = r2.m;
        this.data_source = r2.n;
        this.streaming_config = r2.o;
        this.data_type = r2.p;
        this.patch_info = r2.q;
        this.clean_resource_key_scene = com.lark.wire.internal.a.d("clean_resource_key_scene", r2.r);
        this.app_id = r2.s;
        this.bot_id = r2.t;
        this.json_card_urls = com.lark.wire.internal.a.c("json_card_urls", r2.u);
        this.card_header = r2.v;
        this.action_data_source = r2.w;
    }

    public /* synthetic */ UniversalCardEntity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
