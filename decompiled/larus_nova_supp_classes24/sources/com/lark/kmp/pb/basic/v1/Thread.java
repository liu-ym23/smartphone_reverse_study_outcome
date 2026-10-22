package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.s;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 }2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003|}~B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010z\u001a\u00020\u0002H\u0016J\b\u0010{\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R \u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0015R \u0010!\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010\u0015R\u0015\u0010$\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010)\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b*\u0010\u0015R \u0010+\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010/\u0012\u0004\b-\u0010\u001f\u001a\u0004\b+\u0010.R\u0013\u00100\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000bR\u0015\u00102\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b3\u0010\u0015R\u0015\u00104\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b5\u0010\u0015R\u0015\u00106\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b7\u0010\u0015R\u0015\u00108\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b9\u0010\u0015R\u0013\u0010:\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u000bR\u0015\u0010<\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b=\u0010\u0015R\u0015\u0010>\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\b>\u0010.R\u0015\u0010?\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\b?\u0010.R\u0013\u0010@\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u000bR\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020\t0C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0015\u0010F\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bF\u0010.R\u0015\u0010G\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\bH\u0010\u0015R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0C¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010ER\u0015\u0010K\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\bL\u0010'R\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020%0C¢\u0006\b\n\u0000\u001a\u0004\bN\u0010ER\u0015\u0010O\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\bP\u0010'R\u0015\u0010Q\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bQ\u0010.R\u0015\u0010R\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bR\u0010.R\u0015\u0010S\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bS\u0010.R\u0015\u0010T\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\bU\u0010'R\u0013\u0010V\u001a\u0004\u0018\u00010W¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0013\u0010Z\u001a\u0004\u0018\u00010[¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0015\u0010^\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b_\u0010'R\u0015\u0010`\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\ba\u0010'R \u0010b\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010/\u0012\u0004\bc\u0010\u001f\u001a\u0004\bb\u0010.R\u0013\u0010d\u001a\u0004\u0018\u00010e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0013\u0010h\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\u000bR\u0015\u0010j\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bk\u0010.R\u0015\u0010l\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bl\u0010.R\u0015\u0010m\u001a\u0004\u0018\u00010,¢\u0006\n\n\u0002\u0010/\u001a\u0004\bm\u0010.R\u0013\u0010n\u001a\u0004\u0018\u00010o¢\u0006\b\n\u0000\u001a\u0004\bp\u0010qR\u0013\u0010r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u000bR\u0013\u0010t\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u000bR\u0013\u0010v\u001a\u0004\u0018\u00010w¢\u0006\b\n\u0000\u001a\u0004\bx\u0010y¨\u0006\u007f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Thread;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Thread$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Thread$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "channel", "Lcom/lark/kmp/pb/basic/v1/Channel;", "getChannel", "()Lcom/lark/kmp/pb/basic/v1/Channel;", "topic", "getTopic", "position", "", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "root_message_id", "getRoot_message_id", "last_message_id", "getLast_message_id", "last_message_position", "getLast_message_position", "new_message_count", "getNew_message_count$annotations", "()V", "getNew_message_count", "no_badged_new_message_count", "getNo_badged_new_message_count$annotations", "getNo_badged_new_message_count", "update_time", "", "getUpdate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "reply_count", "getReply_count", "is_participant", "", "is_participant$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "owner_id", "getOwner_id", "last_message_position_badge_count", "getLast_message_position_badge_count", "read_position", "getRead_position", "read_position_badge_count", "getRead_position_badge_count", "last_visible_message_position", "getLast_visible_message_position", "last_visible_message_id", "getLast_visible_message_id", "badge_count", "getBadge_count", "is_visible", "is_badged", "subtitle", "getSubtitle", "last_reply_ids", "", "getLast_reply_ids", "()Ljava/util/List;", "is_no_trace_deleted", "origin_badge_count", "getOrigin_badge_count", "latest_at_message_id", "getLatest_at_message_id", "rank_time", "getRank_time", "top_repliers", "getTop_repliers", "latest_reply_time", "getLatest_reply_time", "is_reply_in_thread", "is_mock", "is_thread_card_reference", "ai_chat_mode_id", "getAi_chat_mode_id", "ai_chat_mode_url_preview_hang_point", "Lcom/lark/kmp/pb/basic/v1/PreviewHangPoint;", "getAi_chat_mode_url_preview_hang_point", "()Lcom/lark/kmp/pb/basic/v1/PreviewHangPoint;", "scene_info", "Lcom/lark/kmp/pb/basic/v1/Thread$SceneInfo;", "getScene_info", "()Lcom/lark/kmp/pb/basic/v1/Thread$SceneInfo;", "ai_knowledge_query_id", "getAi_knowledge_query_id", "query_create_time", "getQuery_create_time", "is_follow", "is_follow$annotations", "follow_status", "Lcom/lark/kmp/pb/basic/v1/ThreadFollowStatus;", "getFollow_status", "()Lcom/lark/kmp/pb/basic/v1/ThreadFollowStatus;", "anonymous_id", "getAnonymous_id", "anonymous_enable", "getAnonymous_enable", "is_remind", "is_flag", "feed_type", "Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "getFeed_type", "()Lcom/lark/kmp/pb/basic/v1/FeedCard$FeedType;", "avatar_key", "getAvatar_key", "avatar_path", "getAvatar_path", "state_info", "Lcom/lark/kmp/pb/basic/v1/ThreadStateInfo;", "getState_info", "()Lcom/lark/kmp/pb/basic/v1/ThreadStateInfo;", "newBuilder", "toString", "Builder", "Companion", "SceneInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Thread extends com.lark.wire.Message<Thread, a> {
    public static final ProtoAdapter<Thread> ADAPTER = null;
    public static final c Companion = null;
    public static final FeedCard.FeedType DEFAULT_FEED_TYPE = null;
    public static final ThreadFollowStatus DEFAULT_FOLLOW_STATUS = null;
    public static final boolean DEFAULT_IS_NO_TRACE_DELETED = false;
    public static final boolean DEFAULT_IS_REMIND = true;
    public static final String DEFAULT_LAST_MESSAGE_ID = "";
    public static final int DEFAULT_LAST_MESSAGE_POSITION = 0;
    public static final String DEFAULT_OWNER_ID = "";
    public static final int DEFAULT_POSITION = 0;
    public static final int DEFAULT_REPLY_COUNT = 0;
    public static final String DEFAULT_ROOT_MESSAGE_ID = "";
    public static final String DEFAULT_TOPIC = "";
    public static final long DEFAULT_UPDATE_TIME = 0;
    private static final long serialVersionUID = 0;
    private final Long ai_chat_mode_id;
    private final PreviewHangPoint ai_chat_mode_url_preview_hang_point;
    private final Long ai_knowledge_query_id;
    private final Boolean anonymous_enable;
    private final String anonymous_id;
    private final String avatar_key;
    private final String avatar_path;
    private final Integer badge_count;
    private final Channel channel;
    private final FeedCard.FeedType feed_type;
    private final ThreadFollowStatus follow_status;
    private final String id;
    private final Boolean is_badged;
    private final Boolean is_flag;
    private final Boolean is_follow;
    private final Boolean is_mock;
    private final Boolean is_no_trace_deleted;
    private final Boolean is_participant;
    private final Boolean is_remind;
    private final Boolean is_reply_in_thread;
    private final Boolean is_thread_card_reference;
    private final Boolean is_visible;
    private final String last_message_id;
    private final Integer last_message_position;
    private final Integer last_message_position_badge_count;
    private final List<String> last_reply_ids;
    private final String last_visible_message_id;
    private final Integer last_visible_message_position;
    private final List<String> latest_at_message_id;
    private final Long latest_reply_time;
    private final Integer new_message_count;
    private final Integer no_badged_new_message_count;
    private final Integer origin_badge_count;
    private final String owner_id;
    private final Integer position;
    private final Long query_create_time;
    private final Long rank_time;
    private final Integer read_position;
    private final Integer read_position_badge_count;
    private final Integer reply_count;
    private final String root_message_id;
    private final SceneInfo scene_info;
    private final ThreadStateInfo state_info;
    private final String subtitle;
    private final List<Long> top_repliers;
    private final String topic;
    private final Long update_time;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Thread$SceneInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Thread$SceneInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Thread$SceneInfo$Builder;Lokio/ByteString;)V", "scene_id", "", "getScene_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "scene_name", "", "getScene_name", "()Ljava/lang/String;", "scene_icon", "Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "getScene_icon", "()Lcom/lark/kmp/pb/basic/v1/ImageSetPassThrough;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class SceneInfo extends com.lark.wire.Message<SceneInfo, a> {
        public static final ProtoAdapter<SceneInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ImageSetPassThrough scene_icon;
        private final Long scene_id;
        private final String scene_name;

        public static final class a extends com.lark.wire.Message.a<SceneInfo, a> {
            public Long d;
            public String e;
            public ImageSetPassThrough f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new SceneInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<SceneInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final SceneInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L16;
                if (r4 != 1) goto L8;
                r1.d = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L10:
                if (r4 != 3) goto L11;
                r1.f = ImageSetPassThrough.ADAPTER.c(r7);
                goto L3
            L11:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L16:
                return new SceneInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(SceneInfo r5) {
                SceneInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + ProtoAdapter.k.l(1, r6.getScene_id())) + ProtoAdapter.q.l(2, r6.getScene_name())) + ImageSetPassThrough.ADAPTER.l(3, r6.getScene_icon());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, SceneInfo r5) {
                SceneInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.k.i(r4, 1, r6.getScene_id());
                ProtoAdapter.q.i(r4, 2, r6.getScene_name());
                ImageSetPassThrough.ADAPTER.i(r4, 3, r6.getScene_icon());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, SceneInfo r5) {
                SceneInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ImageSetPassThrough.ADAPTER.j(r4, 3, r6.getScene_icon());
                ProtoAdapter.q.j(r4, 2, r6.getScene_name());
                ProtoAdapter.k.j(r4, 1, r6.getScene_id());
            }

            public b(FieldEncoding r7, KClass<SceneInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Thread.SceneInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ SceneInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SceneInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.scene_id;
            r0.e = this.scene_name;
            r0.f = this.scene_icon;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(SceneInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final ImageSetPassThrough getScene_icon() {
            return this.scene_icon;
        }

        public final Long getScene_id() {
            return this.scene_id;
        }

        public final String getScene_name() {
            return this.scene_name;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public SceneInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.scene_id = r2.d;
            this.scene_name = r2.e;
            this.scene_icon = r2.f;
        }

        public /* synthetic */ SceneInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<Thread, a> {
        public Boolean A;
        public Integer B;
        public List<String> C;
        public Long D;
        public List<Long> E;
        public Long F;
        public Boolean G;
        public Boolean H;
        public Boolean I;
        public Long J;
        public PreviewHangPoint K;
        public SceneInfo L;
        public Long M;
        public Long N;
        public Boolean O;
        public ThreadFollowStatus P;
        public String Q;
        public Boolean R;
        public Boolean S;
        public Boolean T;
        public FeedCard.FeedType U;
        public String V;
        public String W;
        public ThreadStateInfo X;
        public String d;
        public Channel e;
        public String f;
        public Integer g;
        public String h;
        public String i;
        public Integer j;
        public Integer k;
        public Integer l;
        public Long m;
        public Integer n;
        public Boolean o;
        public String p;
        public Integer q;
        public Integer r;
        public Integer s;
        public Integer t;
        public String u;
        public Integer v;
        public Boolean w;
        public Boolean x;
        public String y;
        public List<String> z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Thread(this, c(), null);
        }

        public a() {
            this.z = CollectionsKt.emptyList();
            this.C = CollectionsKt.emptyList();
            this.E = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Thread> {
        @Override // com.lark.wire.ProtoAdapter
        public final Thread c(g0 r13) {
            Intrinsics.checkNotNullParameter(r13, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            ArrayList r4 = new ArrayList();
            long r5 = r13.c();
        L3:
            int r7 = r13.e();
            if (r7 == (-1)) goto L62;
            switch(r7) {
                case 1: goto L45;
                case 2: goto L44;
                case 3: goto L43;
                case 4: goto L42;
                case 5: goto L41;
                case 6: goto L40;
                case 7: goto L39;
                case 8: goto L38;
                case 9: goto L37;
                case 10: goto L36;
                case 11: goto L35;
                case 12: goto L34;
                case 13: goto L33;
                case 14: goto L32;
                case 15: goto L31;
                case 16: goto L30;
                case 17: goto L29;
                case 18: goto L28;
                case 19: goto L27;
                case 20: goto L26;
                case 21: goto L25;
                case 22: goto L24;
                case 23: goto L23;
                case 24: goto L22;
                case 25: goto L21;
                case 26: goto L20;
                case 27: goto L19;
                case 28: goto L18;
                case 29: goto L17;
                case 30: goto L16;
                case 31: goto L15;
                case 32: goto L14;
                case 33: goto L13;
                case 34: goto L12;
                case 35: goto L11;
                case 36: goto L10;
                case 37: goto L9;
                default: goto L6;
            };
        L9:
            r1.N = (Long) ProtoAdapter.k.c(r13);
            goto L3
        L10:
            r1.M = (Long) ProtoAdapter.k.c(r13);
            goto L3
        L11:
            r1.L = SceneInfo.ADAPTER.c(r13);
            goto L3
        L12:
            r1.K = PreviewHangPoint.ADAPTER.c(r13);
            goto L3
        L13:
            r1.J = (Long) ProtoAdapter.k.c(r13);
            goto L3
        L14:
            r1.I = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L15:
            r1.H = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L16:
            r1.G = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L17:
            r1.F = (Long) ProtoAdapter.k.c(r13);
            goto L3
        L18:
            r4.add(ProtoAdapter.k.c(r13));
            goto L3
        L19:
            r1.D = (Long) ProtoAdapter.k.c(r13);
            goto L3
        L20:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r3.add(r13.i());
            goto L3
        L21:
            r1.B = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L22:
            r1.A = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L23:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r2.add(r13.i());
            goto L3
        L24:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.y = r13.i();
            goto L3
        L25:
            r1.x = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L26:
            r1.w = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L27:
            r1.v = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L28:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.u = r13.i();
            goto L3
        L29:
            r1.t = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L30:
            r1.s = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L31:
            r1.r = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L32:
            r1.q = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L33:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.p = r13.i();
            goto L3
        L34:
            r1.o = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L35:
            r1.n = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L36:
            r1.m = (Long) ProtoAdapter.k.c(r13);
            goto L3
        L37:
            r1.l = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L38:
            r1.k = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L39:
            r1.j = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L40:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.i = r13.i();
            goto L3
        L41:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.h = r13.i();
            goto L3
        L42:
            r1.g = (Integer) ProtoAdapter.h.c(r13);
            goto L3
        L43:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.f = r13.i();
            goto L3
        L44:
            r1.e = Channel.ADAPTER.c(r13);
            goto L3
        L45:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            String r8 = r13.i();
            Intrinsics.checkNotNullParameter(r8, "id");
            r1.d = r8;
            goto L3
        L6:
            switch(r7) {
                case 50: goto L54;
                case 51: goto L66;
                case 52: goto L49;
                case 53: goto L48;
                case 54: goto L47;
                case 55: goto L46;
                default: goto L7;
            };
        L66:
            r1.P = ThreadFollowStatus.ADAPTER.c(r13);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L52
        L52:
            e = move-exception;
            r13.a(r7, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r9 = Unit.INSTANCE;
            goto L3
        L46:
            r1.T = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L47:
            r1.S = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L48:
            r1.R = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L49:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.Q = r13.i();
            goto L3
        L54:
            r1.O = (Boolean) ProtoAdapter.g.c(r13);
            goto L3
        L7:
            switch(r7) {
                case 100: goto L64;
                case 101: goto L57;
                case 102: goto L56;
                case 103: goto L55;
                default: goto L8;
            };
        L64:
            r1.U = FeedCard.FeedType.ADAPTER.c(r13);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L60
        L60:
            e = move-exception;
            r13.a(r7, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r10 = Unit.INSTANCE;
            goto L3
        L55:
            r1.X = ThreadStateInfo.ADAPTER.c(r13);
            goto L3
        L56:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.W = r13.i();
            goto L3
        L57:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r13, "reader");
            r1.V = r13.i();
            goto L3
        L8:
            r13.j(r7);
            Unit r11 = Unit.INSTANCE;
            goto L3
        L62:
            ByteString r14 = r13.d(r5);
            Intrinsics.checkNotNullParameter(r2, "last_reply_ids");
            com.lark.wire.internal.a.a(r2);
            r1.z = r2;
            Intrinsics.checkNotNullParameter(r3, "latest_at_message_id");
            com.lark.wire.internal.a.a(r3);
            r1.C = r3;
            Intrinsics.checkNotNullParameter(r4, "top_repliers");
            com.lark.wire.internal.a.a(r4);
            r1.E = r4;
            return new Thread(r1, r14, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Thread r9) {
            Thread r10 = r9;
            Intrinsics.checkNotNullParameter(r10, "value");
            int r0 = r10.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = ((r0 + r1.l(1, r10.getId())) + Channel.ADAPTER.l(2, r10.getChannel())) + r1.l(3, r10.getTopic());
            s r3 = ProtoAdapter.h;
            int r4 = (((((r2 + r3.l(4, r10.getPosition())) + r1.l(5, r10.getRoot_message_id())) + r1.l(6, r10.getLast_message_id())) + r3.l(7, r10.getLast_message_position())) + r3.l(8, r10.getNew_message_count())) + r3.l(9, r10.getNo_badged_new_message_count());
            t r5 = ProtoAdapter.k;
            int r6 = (r4 + r5.l(10, r10.getUpdate_time())) + r3.l(11, r10.getReply_count());
            l r7 = ProtoAdapter.g;
            return (((((((((((((((((((((((((((((((((((r6 + r7.l(12, r10.is_participant())) + r1.l(13, r10.getOwner_id())) + r3.l(14, r10.getLast_message_position_badge_count())) + r3.l(15, r10.getRead_position())) + r3.l(16, r10.getRead_position_badge_count())) + r3.l(17, r10.getLast_visible_message_position())) + r1.l(18, r10.getLast_visible_message_id())) + r3.l(19, r10.getBadge_count())) + r7.l(20, r10.is_visible())) + r7.l(21, r10.is_badged())) + r1.l(22, r10.getSubtitle())) + r1.a().l(23, r10.getLast_reply_ids())) + r7.l(24, r10.is_no_trace_deleted())) + r3.l(25, r10.getOrigin_badge_count())) + r1.a().l(26, r10.getLatest_at_message_id())) + r5.l(27, r10.getRank_time())) + r5.a().l(28, r10.getTop_repliers())) + r5.l(29, r10.getLatest_reply_time())) + r7.l(30, r10.is_reply_in_thread())) + r7.l(31, r10.is_mock())) + r7.l(32, r10.is_thread_card_reference())) + r5.l(33, r10.getAi_chat_mode_id())) + PreviewHangPoint.ADAPTER.l(34, r10.getAi_chat_mode_url_preview_hang_point())) + SceneInfo.ADAPTER.l(35, r10.getScene_info())) + r5.l(36, r10.getAi_knowledge_query_id())) + r5.l(37, r10.getQuery_create_time())) + r7.l(50, r10.is_follow())) + ThreadFollowStatus.ADAPTER.l(51, r10.getFollow_status())) + r1.l(52, r10.getAnonymous_id())) + r7.l(53, r10.getAnonymous_enable())) + r7.l(54, r10.is_remind())) + r7.l(55, r10.is_flag())) + FeedCard.FeedType.ADAPTER.l(100, r10.getFeed_type())) + r1.l(101, r10.getAvatar_key())) + r1.l(102, r10.getAvatar_path())) + ThreadStateInfo.ADAPTER.l(103, r10.getState_info());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r8, Thread r9) {
            Thread r10 = r9;
            Intrinsics.checkNotNullParameter(r8, "writer");
            Intrinsics.checkNotNullParameter(r10, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r8, 1, r10.getId());
            Channel.ADAPTER.i(r8, 2, r10.getChannel());
            r0.i(r8, 3, r10.getTopic());
            s r1 = ProtoAdapter.h;
            r1.i(r8, 4, r10.getPosition());
            r0.i(r8, 5, r10.getRoot_message_id());
            r0.i(r8, 6, r10.getLast_message_id());
            r1.i(r8, 7, r10.getLast_message_position());
            r1.i(r8, 8, r10.getNew_message_count());
            r1.i(r8, 9, r10.getNo_badged_new_message_count());
            t r2 = ProtoAdapter.k;
            r2.i(r8, 10, r10.getUpdate_time());
            r1.i(r8, 11, r10.getReply_count());
            l r3 = ProtoAdapter.g;
            r3.i(r8, 12, r10.is_participant());
            r0.i(r8, 13, r10.getOwner_id());
            r1.i(r8, 14, r10.getLast_message_position_badge_count());
            r1.i(r8, 15, r10.getRead_position());
            r1.i(r8, 16, r10.getRead_position_badge_count());
            r1.i(r8, 17, r10.getLast_visible_message_position());
            r0.i(r8, 18, r10.getLast_visible_message_id());
            r1.i(r8, 19, r10.getBadge_count());
            r3.i(r8, 20, r10.is_visible());
            r3.i(r8, 21, r10.is_badged());
            r0.i(r8, 22, r10.getSubtitle());
            r0.a().i(r8, 23, r10.getLast_reply_ids());
            r3.i(r8, 24, r10.is_no_trace_deleted());
            r1.i(r8, 25, r10.getOrigin_badge_count());
            r0.a().i(r8, 26, r10.getLatest_at_message_id());
            r2.i(r8, 27, r10.getRank_time());
            r2.a().i(r8, 28, r10.getTop_repliers());
            r2.i(r8, 29, r10.getLatest_reply_time());
            r3.i(r8, 30, r10.is_reply_in_thread());
            r3.i(r8, 31, r10.is_mock());
            r3.i(r8, 32, r10.is_thread_card_reference());
            r2.i(r8, 33, r10.getAi_chat_mode_id());
            PreviewHangPoint.ADAPTER.i(r8, 34, r10.getAi_chat_mode_url_preview_hang_point());
            SceneInfo.ADAPTER.i(r8, 35, r10.getScene_info());
            r2.i(r8, 36, r10.getAi_knowledge_query_id());
            r2.i(r8, 37, r10.getQuery_create_time());
            r3.i(r8, 50, r10.is_follow());
            ThreadFollowStatus.ADAPTER.i(r8, 51, r10.getFollow_status());
            r0.i(r8, 52, r10.getAnonymous_id());
            r3.i(r8, 53, r10.getAnonymous_enable());
            r3.i(r8, 54, r10.is_remind());
            r3.i(r8, 55, r10.is_flag());
            FeedCard.FeedType.ADAPTER.i(r8, 100, r10.getFeed_type());
            r0.i(r8, 101, r10.getAvatar_key());
            r0.i(r8, 102, r10.getAvatar_path());
            ThreadStateInfo.ADAPTER.i(r8, 103, r10.getState_info());
            r8.a(r10.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r8, Thread r9) {
            Thread r10 = r9;
            Intrinsics.checkNotNullParameter(r8, "writer");
            Intrinsics.checkNotNullParameter(r10, "value");
            r8.d(r10.unknownFields());
            ThreadStateInfo.ADAPTER.j(r8, 103, r10.getState_info());
            w r0 = ProtoAdapter.q;
            r0.j(r8, 102, r10.getAvatar_path());
            r0.j(r8, 101, r10.getAvatar_key());
            FeedCard.FeedType.ADAPTER.j(r8, 100, r10.getFeed_type());
            l r1 = ProtoAdapter.g;
            r1.j(r8, 55, r10.is_flag());
            r1.j(r8, 54, r10.is_remind());
            r1.j(r8, 53, r10.getAnonymous_enable());
            r0.j(r8, 52, r10.getAnonymous_id());
            ThreadFollowStatus.ADAPTER.j(r8, 51, r10.getFollow_status());
            r1.j(r8, 50, r10.is_follow());
            t r2 = ProtoAdapter.k;
            r2.j(r8, 37, r10.getQuery_create_time());
            r2.j(r8, 36, r10.getAi_knowledge_query_id());
            SceneInfo.ADAPTER.j(r8, 35, r10.getScene_info());
            PreviewHangPoint.ADAPTER.j(r8, 34, r10.getAi_chat_mode_url_preview_hang_point());
            r2.j(r8, 33, r10.getAi_chat_mode_id());
            r1.j(r8, 32, r10.is_thread_card_reference());
            r1.j(r8, 31, r10.is_mock());
            r1.j(r8, 30, r10.is_reply_in_thread());
            r2.j(r8, 29, r10.getLatest_reply_time());
            r2.a().j(r8, 28, r10.getTop_repliers());
            r2.j(r8, 27, r10.getRank_time());
            r0.a().j(r8, 26, r10.getLatest_at_message_id());
            s r3 = ProtoAdapter.h;
            r3.j(r8, 25, r10.getOrigin_badge_count());
            r1.j(r8, 24, r10.is_no_trace_deleted());
            r0.a().j(r8, 23, r10.getLast_reply_ids());
            r0.j(r8, 22, r10.getSubtitle());
            r1.j(r8, 21, r10.is_badged());
            r1.j(r8, 20, r10.is_visible());
            r3.j(r8, 19, r10.getBadge_count());
            r0.j(r8, 18, r10.getLast_visible_message_id());
            r3.j(r8, 17, r10.getLast_visible_message_position());
            r3.j(r8, 16, r10.getRead_position_badge_count());
            r3.j(r8, 15, r10.getRead_position());
            r3.j(r8, 14, r10.getLast_message_position_badge_count());
            r0.j(r8, 13, r10.getOwner_id());
            r1.j(r8, 12, r10.is_participant());
            r3.j(r8, 11, r10.getReply_count());
            r2.j(r8, 10, r10.getUpdate_time());
            r3.j(r8, 9, r10.getNo_badged_new_message_count());
            r3.j(r8, 8, r10.getNew_message_count());
            r3.j(r8, 7, r10.getLast_message_position());
            r0.j(r8, 6, r10.getLast_message_id());
            r0.j(r8, 5, r10.getRoot_message_id());
            r3.j(r8, 4, r10.getPosition());
            r0.j(r8, 3, r10.getTopic());
            Channel.ADAPTER.j(r8, 2, r10.getChannel());
            r0.j(r8, 1, r10.getId());
        }

        public b(FieldEncoding r7, KClass<Thread> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Thread", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Thread(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "new_message_count is deprecated")
    public static /* synthetic */ void getNew_message_count$annotations() {
    }

    @Deprecated(message = "no_badged_new_message_count is deprecated")
    public static /* synthetic */ void getNo_badged_new_message_count$annotations() {
    }

    @Deprecated(message = "is_follow is deprecated")
    public static /* synthetic */ void is_follow$annotations() {
    }

    @Deprecated(message = "is_participant is deprecated")
    public static /* synthetic */ void is_participant$annotations() {
    }

    static {
        Companion = new c();
        DEFAULT_FOLLOW_STATUS = ThreadFollowStatus.NOT_FOLLOWING;
        DEFAULT_FEED_TYPE = FeedCard.FeedType.INBOX;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Thread.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.channel;
        r0.f = this.topic;
        r0.g = this.position;
        r0.h = this.root_message_id;
        r0.i = this.last_message_id;
        r0.j = this.last_message_position;
        r0.k = this.new_message_count;
        r0.l = this.no_badged_new_message_count;
        r0.m = this.update_time;
        r0.n = this.reply_count;
        r0.o = this.is_participant;
        r0.p = this.owner_id;
        r0.q = this.last_message_position_badge_count;
        r0.r = this.read_position;
        r0.s = this.read_position_badge_count;
        r0.t = this.last_visible_message_position;
        r0.u = this.last_visible_message_id;
        r0.v = this.badge_count;
        r0.w = this.is_visible;
        r0.x = this.is_badged;
        r0.y = this.subtitle;
        r0.z = this.last_reply_ids;
        r0.A = this.is_no_trace_deleted;
        r0.B = this.origin_badge_count;
        r0.C = this.latest_at_message_id;
        r0.D = this.rank_time;
        r0.E = this.top_repliers;
        r0.F = this.latest_reply_time;
        r0.G = this.is_reply_in_thread;
        r0.H = this.is_mock;
        r0.I = this.is_thread_card_reference;
        r0.J = this.ai_chat_mode_id;
        r0.K = this.ai_chat_mode_url_preview_hang_point;
        r0.L = this.scene_info;
        r0.M = this.ai_knowledge_query_id;
        r0.N = this.query_create_time;
        r0.O = this.is_follow;
        r0.P = this.follow_status;
        r0.Q = this.anonymous_id;
        r0.R = this.anonymous_enable;
        r0.S = this.is_remind;
        r0.T = this.is_flag;
        r0.U = this.feed_type;
        r0.V = this.avatar_key;
        r0.W = this.avatar_path;
        r0.X = this.state_info;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Thread.class).getSimpleName() + '@' + hashCode();
    }

    public final Long getAi_chat_mode_id() {
        return this.ai_chat_mode_id;
    }

    public final PreviewHangPoint getAi_chat_mode_url_preview_hang_point() {
        return this.ai_chat_mode_url_preview_hang_point;
    }

    public final Long getAi_knowledge_query_id() {
        return this.ai_knowledge_query_id;
    }

    public final Boolean getAnonymous_enable() {
        return this.anonymous_enable;
    }

    public final String getAnonymous_id() {
        return this.anonymous_id;
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final String getAvatar_path() {
        return this.avatar_path;
    }

    public final Integer getBadge_count() {
        return this.badge_count;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final FeedCard.FeedType getFeed_type() {
        return this.feed_type;
    }

    public final ThreadFollowStatus getFollow_status() {
        return this.follow_status;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLast_message_id() {
        return this.last_message_id;
    }

    public final Integer getLast_message_position() {
        return this.last_message_position;
    }

    public final Integer getLast_message_position_badge_count() {
        return this.last_message_position_badge_count;
    }

    public final List<String> getLast_reply_ids() {
        return this.last_reply_ids;
    }

    public final String getLast_visible_message_id() {
        return this.last_visible_message_id;
    }

    public final Integer getLast_visible_message_position() {
        return this.last_visible_message_position;
    }

    public final List<String> getLatest_at_message_id() {
        return this.latest_at_message_id;
    }

    public final Long getLatest_reply_time() {
        return this.latest_reply_time;
    }

    public final Integer getNew_message_count() {
        return this.new_message_count;
    }

    public final Integer getNo_badged_new_message_count() {
        return this.no_badged_new_message_count;
    }

    public final Integer getOrigin_badge_count() {
        return this.origin_badge_count;
    }

    public final String getOwner_id() {
        return this.owner_id;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final Long getQuery_create_time() {
        return this.query_create_time;
    }

    public final Long getRank_time() {
        return this.rank_time;
    }

    public final Integer getRead_position() {
        return this.read_position;
    }

    public final Integer getRead_position_badge_count() {
        return this.read_position_badge_count;
    }

    public final Integer getReply_count() {
        return this.reply_count;
    }

    public final String getRoot_message_id() {
        return this.root_message_id;
    }

    public final SceneInfo getScene_info() {
        return this.scene_info;
    }

    public final ThreadStateInfo getState_info() {
        return this.state_info;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final List<Long> getTop_repliers() {
        return this.top_repliers;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    public final Boolean is_badged() {
        return this.is_badged;
    }

    public final Boolean is_flag() {
        return this.is_flag;
    }

    public final Boolean is_follow() {
        return this.is_follow;
    }

    public final Boolean is_mock() {
        return this.is_mock;
    }

    public final Boolean is_no_trace_deleted() {
        return this.is_no_trace_deleted;
    }

    public final Boolean is_participant() {
        return this.is_participant;
    }

    public final Boolean is_remind() {
        return this.is_remind;
    }

    public final Boolean is_reply_in_thread() {
        return this.is_reply_in_thread;
    }

    public final Boolean is_thread_card_reference() {
        return this.is_thread_card_reference;
    }

    public final Boolean is_visible() {
        return this.is_visible;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Thread(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        Channel r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.channel = r5;
        this.topic = r2.f;
        this.position = r2.g;
        this.root_message_id = r2.h;
        this.last_message_id = r2.i;
        this.last_message_position = r2.j;
        this.new_message_count = r2.k;
        this.no_badged_new_message_count = r2.l;
        this.update_time = r2.m;
        this.reply_count = r2.n;
        this.is_participant = r2.o;
        this.owner_id = r2.p;
        this.last_message_position_badge_count = r2.q;
        this.read_position = r2.r;
        this.read_position_badge_count = r2.s;
        this.last_visible_message_position = r2.t;
        this.last_visible_message_id = r2.u;
        this.badge_count = r2.v;
        this.is_visible = r2.w;
        this.is_badged = r2.x;
        this.subtitle = r2.y;
        this.last_reply_ids = com.lark.wire.internal.a.c("last_reply_ids", r2.z);
        this.is_no_trace_deleted = r2.A;
        this.origin_badge_count = r2.B;
        this.latest_at_message_id = com.lark.wire.internal.a.c("latest_at_message_id", r2.C);
        this.rank_time = r2.D;
        this.top_repliers = com.lark.wire.internal.a.c("top_repliers", r2.E);
        this.latest_reply_time = r2.F;
        this.is_reply_in_thread = r2.G;
        this.is_mock = r2.H;
        this.is_thread_card_reference = r2.I;
        this.ai_chat_mode_id = r2.J;
        this.ai_chat_mode_url_preview_hang_point = r2.K;
        this.scene_info = r2.L;
        this.ai_knowledge_query_id = r2.M;
        this.query_create_time = r2.N;
        this.is_follow = r2.O;
        this.follow_status = r2.P;
        this.anonymous_id = r2.Q;
        this.anonymous_enable = r2.R;
        this.is_remind = r2.S;
        this.is_flag = r2.T;
        this.feed_type = r2.U;
        this.avatar_key = r2.V;
        this.avatar_path = r2.W;
        this.state_info = r2.X;
    }

    public /* synthetic */ Thread(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
