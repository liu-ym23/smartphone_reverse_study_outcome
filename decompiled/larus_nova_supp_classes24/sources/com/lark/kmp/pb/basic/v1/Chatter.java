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
import com.larus.audio.call.dora.CommandStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
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
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u008f\u00012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0012\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u008c\u0001\u001a\u00020\u0002H\u0016J\t\u0010\u008d\u0001\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b \u0010\"R\u0015\u0010$\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0013\u0010%\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000bR\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010+\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u000bR\u0013\u0010-\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000bR\u0013\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000bR\u0013\u00101\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u000bR\u0013\u00103\u001a\u0004\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0015\u00107\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b8\u0010\"R\u0013\u00109\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u000bR\u0013\u0010;\u001a\u0004\u0018\u00010<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010?\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000bR\u0013\u0010A\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u000bR\u0013\u0010C\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u000bR\u0015\u0010E\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010H\u001a\u0004\bF\u0010GR\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010M\u001a\u0004\u0018\u00010N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0015\u0010Q\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\bQ\u0010\"R\u0015\u0010R\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\bR\u0010\"R\u0013\u0010S\u001a\u0004\u0018\u00010T¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010W\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u000bR\u0013\u0010Y\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u000bR\u0015\u0010[\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b[\u0010\"R\u0015\u0010\\\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\\\u0010\"R\u0013\u0010]\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u000bR\u0013\u0010_\u001a\u0004\u0018\u00010`¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0013\u0010c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\u000bR\u0015\u0010e\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010H\u001a\u0004\bf\u0010GR\u0015\u0010g\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\bg\u0010\"R\u0013\u0010h\u001a\u0004\u0018\u00010i¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020\t0J¢\u0006\b\n\u0000\u001a\u0004\bm\u0010LR\u0013\u0010n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u000bR\u0015\u0010p\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\bq\u0010\"R\u0015\u0010r\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\bs\u0010\"R\u0013\u0010t\u001a\u0004\u0018\u00010u¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0013\u0010x\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u000bR\u0015\u0010z\u001a\u0004\u0018\u00010{¢\u0006\n\n\u0002\u0010~\u001a\u0004\b|\u0010}R\u0015\u0010\u007f\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u007f\u0010\"R\u001a\u0010\u0080\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010J¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010LR\u0017\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0017\u0010\u0087\u0001\u001a\u0004\u0018\u00010!¢\u0006\u000b\n\u0002\u0010#\u001a\u0005\b\u0088\u0001\u0010\"R\u001a\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010J¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010L¨\u0006\u0097\u0001"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "type", "Lcom/lark/kmp/pb/basic/v1/Chatter$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Chatter$Type;", "avatar", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getAvatar$annotations", "()V", "getAvatar", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "update_time", "", "getUpdate_time", "()J", "name_pinyin", "getName_pinyin", "creator_id", "getCreator_id", "is_resigned", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_registered", "en_us_name", "getEn_us_name", "description", "Lcom/lark/kmp/pb/basic/v1/Chatter$Description;", "getDescription", "()Lcom/lark/kmp/pb/basic/v1/Chatter$Description;", "avatar_key", "getAvatar_key", "tenant_id", "getTenant_id", "localized_name", "getLocalized_name", "alias", "getAlias", "work_status", "Lcom/lark/kmp/pb/basic/v1/WorkStatus;", "getWork_status", "()Lcom/lark/kmp/pb/basic/v1/WorkStatus;", "profile_enabled", "getProfile_enabled", "account_id", "getAccount_id", "access_info", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo;", "getAccess_info", "()Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo;", "open_app_id", "getOpen_app_id", "avatar_path", "getAvatar_path", "email", "getEmail", "do_not_disturb_end_time", "getDo_not_disturb_end_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "avatar_urls", "", "getAvatar_urls", "()Ljava/util/List;", "time_zone", "Lcom/lark/kmp/pb/basic/v1/Chatter$TimeZone;", "getTime_zone", "()Lcom/lark/kmp/pb/basic/v1/Chatter$TimeZone;", "is_frozen", "is_anonymous", "avatar_medal", "Lcom/lark/kmp/pb/basic/v1/AvatarMedal;", "getAvatar_medal", "()Lcom/lark/kmp/pb/basic/v1/AvatarMedal;", "name_with_another_name", "getName_with_another_name", "another_name", "getAnother_name", "is_default_avatar", "is_special_focus", "major_language", "getMajor_language", "tag_info", "Lcom/lark/kmp/pb/basic/v1/TagData;", "getTag_info", "()Lcom/lark/kmp/pb/basic/v1/TagData;", "private_description", "getPrivate_description", "private_description_id", "getPrivate_description_id", "is_tenant_certification", "tenant_name_status", "Lcom/lark/kmp/pb/basic/v1/TenantNameStatus;", "getTenant_name_status", "()Lcom/lark/kmp/pb/basic/v1/TenantNameStatus;", "common_locales", "getCommon_locales", "with_bot_tag", "getWith_bot_tag", "in_contacts", "getIn_contacts", "can_join_group", "getCan_join_group", "muted_info", "Lcom/lark/kmp/pb/basic/v1/Chatter$BotMutedInfo;", "getMuted_info", "()Lcom/lark/kmp/pb/basic/v1/Chatter$BotMutedInfo;", "chat_chatter_list_department_name", "getChat_chatter_list_department_name", "bot_ext_type", "", "getBot_ext_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_agent", "status", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatterCustomStatus;", "getStatus", "chat_extra", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra;", "getChat_extra", "()Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra;", "accept_sms_phone_urgent", "getAccept_sms_phone_urgent", "tags", "Lcom/lark/kmp/pb/basic/v1/Tag;", "getTags", "newBuilder", "toString", "Builder", "Companion", "Type", "Description", "AccessInfo", "TimeZone", "BotMutedInfo", "ChatterCustomStatus", "ChatExtra", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Chatter extends com.lark.wire.Message<Chatter, a> {
    public static final ProtoAdapter<Chatter> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_CAN_JOIN_GROUP = true;
    public static final String DEFAULT_CREATOR_ID = "";
    public static final boolean DEFAULT_IN_CONTACTS = true;
    public static final boolean DEFAULT_IS_DEFAULT_AVATAR = false;
    public static final boolean DEFAULT_IS_FROZEN = false;
    public static final boolean DEFAULT_IS_REGISTERED = true;
    public static final boolean DEFAULT_IS_RESIGNED = false;
    public static final boolean DEFAULT_PROFILE_ENABLED = true;
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_WITH_BOT_TAG = "bot";
    private static final long serialVersionUID = 0;
    private final Boolean accept_sms_phone_urgent;
    private final AccessInfo access_info;
    private final String account_id;
    private final String alias;
    private final String another_name;
    private final ImageSet avatar;
    private final String avatar_key;
    private final AvatarMedal avatar_medal;
    private final String avatar_path;
    private final List<String> avatar_urls;
    private final Integer bot_ext_type;
    private final Boolean can_join_group;
    private final String chat_chatter_list_department_name;
    private final ChatExtra chat_extra;
    private final List<String> common_locales;
    private final String creator_id;
    private final Description description;
    private final Long do_not_disturb_end_time;
    private final String email;
    private final String en_us_name;
    private final String id;
    private final Boolean in_contacts;
    private final Boolean is_agent;
    private final Boolean is_anonymous;
    private final Boolean is_default_avatar;
    private final Boolean is_frozen;
    private final Boolean is_registered;
    private final Boolean is_resigned;
    private final Boolean is_special_focus;
    private final Boolean is_tenant_certification;
    private final String localized_name;
    private final String major_language;
    private final BotMutedInfo muted_info;
    private final String name;
    private final String name_pinyin;
    private final String name_with_another_name;
    private final String open_app_id;
    private final String private_description;
    private final Long private_description_id;
    private final Boolean profile_enabled;
    private final List<ChatterCustomStatus> status;
    private final TagData tag_info;
    private final List<Tag> tags;
    private final String tenant_id;
    private final TenantNameStatus tenant_name_status;
    private final TimeZone time_zone;
    private final Type type;
    private final long update_time;
    private final String with_bot_tag;
    private final WorkStatus work_status;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$Builder;Lokio/ByteString;)V", "phone_call", "", "getPhone_call", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "voice_call", "getVoice_call", "video_call", "getVideo_call", "access_profile", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile;", "getAccess_profile", "()Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile;", "newBuilder", "toString", "", "Builder", "Companion", "AccessProfile", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class AccessInfo extends com.lark.wire.Message<AccessInfo, a> {
        public static final ProtoAdapter<AccessInfo> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_PHONE_CALL = true;
        public static final boolean DEFAULT_VIDEO_CALL = true;
        public static final boolean DEFAULT_VOICE_CALL = true;
        private static final long serialVersionUID = 0;
        private final AccessProfile access_profile;
        private final Boolean phone_call;
        private final Boolean video_call;
        private final Boolean voice_call;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0015\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$Builder;Lokio/ByteString;)V", "access_message_phone_call", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage;", "getAccess_message_phone_call", "()Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage;", "access_message_voice_call", "getAccess_message_voice_call", "access_message_video_call", "getAccess_message_video_call", "access_message_urgent", "getAccess_message_urgent", "newBuilder", "toString", "", "Builder", "Companion", "AccessMessage", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class AccessProfile extends com.lark.wire.Message<AccessProfile, a> {
            public static final ProtoAdapter<AccessProfile> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final AccessMessage access_message_phone_call;
            private final AccessMessage access_message_urgent;
            private final AccessMessage access_message_video_call;
            private final AccessMessage access_message_voice_call;

            @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage$Builder;Lokio/ByteString;)V", "is_accessible", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "inaccessible_code", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage$InaccessibleCode;", "getInaccessible_code", "()Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage$InaccessibleCode;", "newBuilder", "toString", "", "Builder", "Companion", "InaccessibleCode", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final class AccessMessage extends com.lark.wire.Message<AccessMessage, a> {
                public static final ProtoAdapter<AccessMessage> ADAPTER = null;
                public static final c Companion = null;
                public static final InaccessibleCode DEFAULT_INACCESSIBLE_CODE = null;
                public static final boolean DEFAULT_IS_ACCESSIBLE = true;
                private static final long serialVersionUID = 0;
                private final InaccessibleCode inaccessible_code;
                private final Boolean is_accessible;

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage$InaccessibleCode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "EXECUTIVES", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
                public static final enum InaccessibleCode extends Enum<InaccessibleCode> implements o0 {
                    public static final ProtoAdapter<InaccessibleCode> ADAPTER = null;
                    public static final b Companion = null;
                    public static final InaccessibleCode DEFAULT = null;
                    public static final InaccessibleCode EXECUTIVES = null;
                    public static final /* synthetic */ InaccessibleCode[] a = null;
                    public static final /* synthetic */ EnumEntries b = null;
                    private final int value;

                    public static final class a extends d<InaccessibleCode> {
                        @Override // com.lark.wire.d
                        public final o0 n(int r2) {
                            InaccessibleCode.Companion.getClass();
                            if (r2 == 0) goto L9;
                            if (r2 == 1) goto L11;
                            return null;
                        L11:
                            return InaccessibleCode.EXECUTIVES;
                        L9:
                            return InaccessibleCode.DEFAULT;
                        }

                        public a(KClass<InaccessibleCode> r1, Syntax r2, InaccessibleCode r3) {
                            super(r1, r2, r3);
                        }
                    }

                    public static final class b {
                        public b() {
                        }
                    }

                    public static EnumEntries<InaccessibleCode> getEntries() {
                        return b;
                    }

                    static {
                        InaccessibleCode r0 = new InaccessibleCode("DEFAULT", 0, 0);
                        DEFAULT = r0;
                        InaccessibleCode r1 = new InaccessibleCode("EXECUTIVES", 1, 1);
                        EXECUTIVES = r1;
                        InaccessibleCode[] r3 = {r0, r1};
                        a = r3;
                        b = EnumEntriesKt.enumEntries(r3);
                        Companion = new b();
                        ADAPTER = new a(Reflection.getOrCreateKotlinClass(InaccessibleCode.class), Syntax.PROTO_2, r0);
                    }

                    public static InaccessibleCode[] values() {
                        return (InaccessibleCode[]) a.clone();
                    }

                    @Override // com.lark.wire.o0
                    public int getValue() {
                        return this.value;
                    }

                    @JvmStatic
                    public static final InaccessibleCode fromValue(int r1) {
                        Companion.getClass();
                        if (r1 == 0) goto L9;
                        if (r1 == 1) goto L11;
                        return null;
                    L11:
                        return EXECUTIVES;
                    L9:
                        return DEFAULT;
                    }

                    public static InaccessibleCode valueOf(String r1) {
                        return (InaccessibleCode) r27.a.a(InaccessibleCode.class, r1);
                    }

                    public InaccessibleCode(String r1, int r2, int r3) {
                        super(r1, r2);
                        this.value = r3;
                    }
                }

                public static final class a extends com.lark.wire.Message.a<AccessMessage, a> {
                    public Boolean d;
                    public InaccessibleCode e;

                    @Override // com.lark.wire.Message.a
                    public final com.lark.wire.Message b() {
                        return new AccessMessage(this, c(), null);
                    }

                    public a() {
                    }
                }

                public static final class b extends ProtoAdapter<AccessMessage> {
                    @Override // com.lark.wire.ProtoAdapter
                    public final AccessMessage c(g0 r9) {
                        Intrinsics.checkNotNullParameter(r9, "reader");
                        a r0 = new a();
                        long r1 = r9.c();
                    L3:
                        int r3 = r9.e();
                        if (r3 == (-1)) goto L16;
                        if (r3 != 1) goto L8;
                        r0.d = (Boolean) ProtoAdapter.g.c(r9);
                        goto L3
                    L8:
                        if (r3 != 2) goto L9;
                        r0.e = InaccessibleCode.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
                    L12:
                        e = move-exception;
                        r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                        Unit r4 = Unit.INSTANCE;
                        goto L3
                    L9:
                        r9.j(r3);
                        goto L3
                    L16:
                        return new AccessMessage(r0, r9.d(r1), null);
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final int k(AccessMessage r5) {
                        AccessMessage r6 = r5;
                        Intrinsics.checkNotNullParameter(r6, "value");
                        return (r6.unknownFields().size() + ProtoAdapter.g.l(1, r6.is_accessible())) + InaccessibleCode.ADAPTER.l(2, r6.getInaccessible_code());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void f(j0 r4, AccessMessage r5) {
                        AccessMessage r6 = r5;
                        Intrinsics.checkNotNullParameter(r4, "writer");
                        Intrinsics.checkNotNullParameter(r6, "value");
                        ProtoAdapter.g.i(r4, 1, r6.is_accessible());
                        InaccessibleCode.ADAPTER.i(r4, 2, r6.getInaccessible_code());
                        r4.a(r6.unknownFields());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void g(n0 r4, AccessMessage r5) {
                        AccessMessage r6 = r5;
                        Intrinsics.checkNotNullParameter(r4, "writer");
                        Intrinsics.checkNotNullParameter(r6, "value");
                        r4.d(r6.unknownFields());
                        InaccessibleCode.ADAPTER.j(r4, 2, r6.getInaccessible_code());
                        ProtoAdapter.g.j(r4, 1, r6.is_accessible());
                    }

                    public b(FieldEncoding r7, KClass<AccessMessage> r8, Syntax r9) {
                        super(r7, r8, "type.googleapis.com/basic.v1.Chatter.AccessInfo.AccessProfile.AccessMessage", r9, null);
                    }
                }

                public static final class c {
                    public c() {
                    }
                }

                public /* synthetic */ AccessMessage(a r1, ByteString r2, DefaultConstructorMarker r3) {
                    this(r1, r2);
                }

                static {
                    Companion = new c();
                    DEFAULT_INACCESSIBLE_CODE = InaccessibleCode.DEFAULT;
                    ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AccessMessage.class), Syntax.PROTO_2);
                }

                @Override // com.lark.wire.Message
                public a newBuilder() {
                    a r0 = new a();
                    r0.d = this.is_accessible;
                    r0.e = this.inaccessible_code;
                    r0.a(unknownFields());
                    return r0;
                }

                @Override // com.lark.wire.Message
                public String toString() {
                    return Reflection.getOrCreateKotlinClass(AccessMessage.class).getSimpleName() + '@' + hashCode();
                }

                public final InaccessibleCode getInaccessible_code() {
                    return this.inaccessible_code;
                }

                public final Boolean is_accessible() {
                    return this.is_accessible;
                }

                @Override // com.lark.wire.Message
                public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                    return newBuilder();
                }

                public AccessMessage(a r2, ByteString r3) {
                    super(ADAPTER, r3);
                    this.is_accessible = r2.d;
                    this.inaccessible_code = r2.e;
                }

                public /* synthetic */ AccessMessage(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                    if ((r3 & 2) == 0) goto L5;
                    r2 = ByteString.EMPTY;
                L5:
                    this(r1, r2);
                }
            }

            public static final class a extends com.lark.wire.Message.a<AccessProfile, a> {
                public AccessMessage d;
                public AccessMessage e;
                public AccessMessage f;
                public AccessMessage g;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new AccessProfile(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<AccessProfile> {
                @Override // com.lark.wire.ProtoAdapter
                public final AccessProfile c(g0 r6) {
                    Intrinsics.checkNotNullParameter(r6, "reader");
                    a r0 = new a();
                    long r1 = r6.c();
                L3:
                    int r3 = r6.e();
                    if (r3 == (-1)) goto L19;
                    if (r3 != 1) goto L8;
                    r0.d = AccessMessage.ADAPTER.c(r6);
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.e = AccessMessage.ADAPTER.c(r6);
                    goto L3
                L10:
                    if (r3 != 3) goto L12;
                    r0.f = AccessMessage.ADAPTER.c(r6);
                    goto L3
                L12:
                    if (r3 != 4) goto L13;
                    r0.g = AccessMessage.ADAPTER.c(r6);
                    goto L3
                L13:
                    r6.j(r3);
                    Unit r4 = Unit.INSTANCE;
                    goto L3
                L19:
                    return new AccessProfile(r0, r6.d(r1), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(AccessProfile r5) {
                    AccessProfile r6 = r5;
                    Intrinsics.checkNotNullParameter(r6, "value");
                    int r0 = r6.unknownFields().size();
                    ProtoAdapter<AccessMessage> r1 = AccessMessage.ADAPTER;
                    return (((r0 + r1.l(1, r6.getAccess_message_phone_call())) + r1.l(2, r6.getAccess_message_voice_call())) + r1.l(3, r6.getAccess_message_video_call())) + r1.l(4, r6.getAccess_message_urgent());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, AccessProfile r5) {
                    AccessProfile r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    ProtoAdapter<AccessMessage> r0 = AccessMessage.ADAPTER;
                    r0.i(r4, 1, r6.getAccess_message_phone_call());
                    r0.i(r4, 2, r6.getAccess_message_voice_call());
                    r0.i(r4, 3, r6.getAccess_message_video_call());
                    r0.i(r4, 4, r6.getAccess_message_urgent());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r4, AccessProfile r5) {
                    AccessProfile r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    r4.d(r6.unknownFields());
                    ProtoAdapter<AccessMessage> r0 = AccessMessage.ADAPTER;
                    r0.j(r4, 4, r6.getAccess_message_urgent());
                    r0.j(r4, 3, r6.getAccess_message_video_call());
                    r0.j(r4, 2, r6.getAccess_message_voice_call());
                    r0.j(r4, 1, r6.getAccess_message_phone_call());
                }

                public b(FieldEncoding r7, KClass<AccessProfile> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.Chatter.AccessInfo.AccessProfile", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ AccessProfile(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AccessProfile.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.access_message_phone_call;
                r0.e = this.access_message_voice_call;
                r0.f = this.access_message_video_call;
                r0.g = this.access_message_urgent;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(AccessProfile.class).getSimpleName() + '@' + hashCode();
            }

            public final AccessMessage getAccess_message_phone_call() {
                return this.access_message_phone_call;
            }

            public final AccessMessage getAccess_message_urgent() {
                return this.access_message_urgent;
            }

            public final AccessMessage getAccess_message_video_call() {
                return this.access_message_video_call;
            }

            public final AccessMessage getAccess_message_voice_call() {
                return this.access_message_voice_call;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public AccessProfile(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.access_message_phone_call = r2.d;
                this.access_message_voice_call = r2.e;
                this.access_message_video_call = r2.f;
                this.access_message_urgent = r2.g;
            }

            public /* synthetic */ AccessProfile(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        public static final class a extends com.lark.wire.Message.a<AccessInfo, a> {
            public Boolean d;
            public Boolean e;
            public Boolean f;
            public AccessProfile g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AccessInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AccessInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final AccessInfo c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L8;
                r0.d = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.f = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.g = AccessProfile.ADAPTER.c(r6);
                goto L3
            L13:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L19:
                return new AccessInfo(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AccessInfo r5) {
                AccessInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                l r1 = ProtoAdapter.g;
                return (((r0 + r1.l(1, r6.getPhone_call())) + r1.l(2, r6.getVoice_call())) + r1.l(3, r6.getVideo_call())) + AccessProfile.ADAPTER.l(4, r6.getAccess_profile());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, AccessInfo r5) {
                AccessInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                l r0 = ProtoAdapter.g;
                r0.i(r4, 1, r6.getPhone_call());
                r0.i(r4, 2, r6.getVoice_call());
                r0.i(r4, 3, r6.getVideo_call());
                AccessProfile.ADAPTER.i(r4, 4, r6.getAccess_profile());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, AccessInfo r5) {
                AccessInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                AccessProfile.ADAPTER.j(r4, 4, r6.getAccess_profile());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 3, r6.getVideo_call());
                r0.j(r4, 2, r6.getVoice_call());
                r0.j(r4, 1, r6.getPhone_call());
            }

            public b(FieldEncoding r7, KClass<AccessInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chatter.AccessInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AccessInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AccessInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.phone_call;
            r0.e = this.voice_call;
            r0.f = this.video_call;
            r0.g = this.access_profile;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(AccessInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final AccessProfile getAccess_profile() {
            return this.access_profile;
        }

        public final Boolean getPhone_call() {
            return this.phone_call;
        }

        public final Boolean getVideo_call() {
            return this.video_call;
        }

        public final Boolean getVoice_call() {
            return this.voice_call;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public AccessInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.phone_call = r2.d;
            this.voice_call = r2.e;
            this.video_call = r2.f;
            this.access_profile = r2.g;
        }

        public /* synthetic */ AccessInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$BotMutedInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$BotMutedInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$BotMutedInfo$Builder;Lokio/ByteString;)V", "muted_scenes", "", "", "", "getMuted_scenes", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class BotMutedInfo extends com.lark.wire.Message<BotMutedInfo, a> {
        public static final ProtoAdapter<BotMutedInfo> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, Boolean> muted_scenes;

        public static final class a extends com.lark.wire.Message.a<BotMutedInfo, a> {
            public Map<String, Boolean> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new BotMutedInfo(this, c(), null);
            }

            public a() {
                this.d = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ BotMutedInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(BotMutedInfo.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new Chatter$BotMutedInfo$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.muted_scenes;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(BotMutedInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, Boolean> getMuted_scenes() {
            return this.muted_scenes;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public BotMutedInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.muted_scenes = com.lark.wire.internal.a.d("muted_scenes", r2.d);
        }

        public /* synthetic */ BotMutedInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001a\u001b\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$Builder;Lokio/ByteString;)V", "chat_id", "", "getChat_id", "()Ljava/lang/String;", "nick_name", "getNick_name", "oncall_role", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$OncallRole;", "getOncall_role", "()Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$OncallRole;", "nick_name_pinyin", "getNick_name_pinyin", "tag_infos", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo;", "getTag_infos", "()Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo;", "newBuilder", "toString", "Builder", "Companion", "OncallRole", "ChatChatterTagInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChatExtra extends com.lark.wire.Message<ChatExtra, a> {
        public static final ProtoAdapter<ChatExtra> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String chat_id;
        private final String nick_name;
        private final String nick_name_pinyin;
        private final OncallRole oncall_role;
        private final ChatChatterTagInfo tag_infos;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$Builder;Lokio/ByteString;)V", "tags", "", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo;", "getTags", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "TagInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final class ChatChatterTagInfo extends com.lark.wire.Message<ChatChatterTagInfo, a> {
            public static final ProtoAdapter<ChatChatterTagInfo> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final List<TagInfo> tags;

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0012\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo$Builder;Lokio/ByteString;)V", "tag_type", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo$TagType;", "getTag_type", "()Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo$TagType;", "description", "", "getDescription", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "TagType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
            public static final class TagInfo extends com.lark.wire.Message<TagInfo, a> {
                public static final ProtoAdapter<TagInfo> ADAPTER = null;
                public static final c Companion = null;
                private static final long serialVersionUID = 0;
                private final String description;
                private final TagType tag_type;

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo$TagType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CLASS_TEACHER", "DISCIPLINE_TEACHER", "ADMIN_USER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
                public static final enum TagType extends Enum<TagType> implements o0 {
                    public static final ProtoAdapter<TagType> ADAPTER = null;
                    public static final TagType ADMIN_USER = null;
                    public static final TagType CLASS_TEACHER = null;
                    public static final b Companion = null;
                    public static final TagType DISCIPLINE_TEACHER = null;
                    public static final TagType UNKNOWN = null;
                    public static final /* synthetic */ TagType[] a = null;
                    public static final /* synthetic */ EnumEntries b = null;
                    private final int value;

                    public static final class a extends d<TagType> {
                        @Override // com.lark.wire.d
                        public final o0 n(int r2) {
                            TagType.Companion.getClass();
                            if (r2 == 0) goto L15;
                            if (r2 == 1) goto L19;
                            if (r2 == 2) goto L18;
                            if (r2 == 3) goto L17;
                            return null;
                        L17:
                            return TagType.ADMIN_USER;
                        L18:
                            return TagType.DISCIPLINE_TEACHER;
                        L19:
                            return TagType.CLASS_TEACHER;
                        L15:
                            return TagType.UNKNOWN;
                        }

                        public a(KClass<TagType> r1, Syntax r2, TagType r3) {
                            super(r1, r2, r3);
                        }
                    }

                    public static final class b {
                        public b() {
                        }
                    }

                    public static EnumEntries<TagType> getEntries() {
                        return b;
                    }

                    static {
                        TagType r0 = new TagType("UNKNOWN", 0, 0);
                        UNKNOWN = r0;
                        TagType r1 = new TagType("CLASS_TEACHER", 1, 1);
                        CLASS_TEACHER = r1;
                        TagType r3 = new TagType("DISCIPLINE_TEACHER", 2, 2);
                        DISCIPLINE_TEACHER = r3;
                        TagType r5 = new TagType("ADMIN_USER", 3, 3);
                        ADMIN_USER = r5;
                        TagType[] r7 = {r0, r1, r3, r5};
                        a = r7;
                        b = EnumEntriesKt.enumEntries(r7);
                        Companion = new b();
                        ADAPTER = new a(Reflection.getOrCreateKotlinClass(TagType.class), Syntax.PROTO_2, r0);
                    }

                    public static TagType[] values() {
                        return (TagType[]) a.clone();
                    }

                    @Override // com.lark.wire.o0
                    public int getValue() {
                        return this.value;
                    }

                    @JvmStatic
                    public static final TagType fromValue(int r1) {
                        Companion.getClass();
                        if (r1 == 0) goto L15;
                        if (r1 == 1) goto L19;
                        if (r1 == 2) goto L18;
                        if (r1 == 3) goto L17;
                        return null;
                    L17:
                        return ADMIN_USER;
                    L18:
                        return DISCIPLINE_TEACHER;
                    L19:
                        return CLASS_TEACHER;
                    L15:
                        return UNKNOWN;
                    }

                    public static TagType valueOf(String r1) {
                        return (TagType) r27.a.a(TagType.class, r1);
                    }

                    public TagType(String r1, int r2, int r3) {
                        super(r1, r2);
                        this.value = r3;
                    }
                }

                public static final class a extends com.lark.wire.Message.a<TagInfo, a> {
                    public TagType d;
                    public String e;

                    @Override // com.lark.wire.Message.a
                    public final com.lark.wire.Message b() {
                        return new TagInfo(this, c(), null);
                    }

                    public a() {
                    }
                }

                public static final class b extends ProtoAdapter<TagInfo> {
                    @Override // com.lark.wire.ProtoAdapter
                    public final TagInfo c(g0 r10) {
                        Intrinsics.checkNotNullParameter(r10, "reader");
                        a r1 = new a();
                        long r2 = r10.c();
                    L3:
                        int r4 = r10.e();
                        if (r4 == (-1)) goto L16;
                        if (r4 != 1) goto L8;
                        r1.d = TagType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
                    L13:
                        e = move-exception;
                        r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                        Unit r5 = Unit.INSTANCE;
                        goto L3
                    L8:
                        if (r4 != 2) goto L9;
                        ProtoAdapter.q.getClass();
                        Intrinsics.checkNotNullParameter(r10, "reader");
                        r1.e = r10.i();
                        goto L3
                    L9:
                        r10.j(r4);
                        goto L3
                    L16:
                        return new TagInfo(r1, r10.d(r2), null);
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final int k(TagInfo r5) {
                        TagInfo r6 = r5;
                        Intrinsics.checkNotNullParameter(r6, "value");
                        return (r6.unknownFields().size() + TagType.ADAPTER.l(1, r6.getTag_type())) + ProtoAdapter.q.l(2, r6.getDescription());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void f(j0 r4, TagInfo r5) {
                        TagInfo r6 = r5;
                        Intrinsics.checkNotNullParameter(r4, "writer");
                        Intrinsics.checkNotNullParameter(r6, "value");
                        TagType.ADAPTER.i(r4, 1, r6.getTag_type());
                        ProtoAdapter.q.i(r4, 2, r6.getDescription());
                        r4.a(r6.unknownFields());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void g(n0 r4, TagInfo r5) {
                        TagInfo r6 = r5;
                        Intrinsics.checkNotNullParameter(r4, "writer");
                        Intrinsics.checkNotNullParameter(r6, "value");
                        r4.d(r6.unknownFields());
                        ProtoAdapter.q.j(r4, 2, r6.getDescription());
                        TagType.ADAPTER.j(r4, 1, r6.getTag_type());
                    }

                    public b(FieldEncoding r7, KClass<TagInfo> r8, Syntax r9) {
                        super(r7, r8, "type.googleapis.com/basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo", r9, null);
                    }
                }

                public static final class c {
                    public c() {
                    }
                }

                public /* synthetic */ TagInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
                    this(r1, r2);
                }

                static {
                    Companion = new c();
                    ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TagInfo.class), Syntax.PROTO_2);
                }

                @Override // com.lark.wire.Message
                public a newBuilder() {
                    a r0 = new a();
                    r0.d = this.tag_type;
                    r0.e = this.description;
                    r0.a(unknownFields());
                    return r0;
                }

                @Override // com.lark.wire.Message
                public String toString() {
                    return Reflection.getOrCreateKotlinClass(TagInfo.class).getSimpleName() + '@' + hashCode();
                }

                public final String getDescription() {
                    return this.description;
                }

                public final TagType getTag_type() {
                    return this.tag_type;
                }

                @Override // com.lark.wire.Message
                public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                    return newBuilder();
                }

                public TagInfo(a r2, ByteString r3) {
                    super(ADAPTER, r3);
                    this.tag_type = r2.d;
                    this.description = r2.e;
                }

                public /* synthetic */ TagInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                    if ((r3 & 2) == 0) goto L5;
                    r2 = ByteString.EMPTY;
                L5:
                    this(r1, r2);
                }
            }

            public static final class a extends com.lark.wire.Message.a<ChatChatterTagInfo, a> {
                public List<TagInfo> d;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new ChatChatterTagInfo(this, c(), null);
                }

                public a() {
                    this.d = CollectionsKt.emptyList();
                }
            }

            public static final class b extends ProtoAdapter<ChatChatterTagInfo> {
                @Override // com.lark.wire.ProtoAdapter
                public final ChatChatterTagInfo c(g0 r7) {
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
                    r1.add(TagInfo.ADAPTER.c(r7));
                    goto L3
                L9:
                    ByteString r8 = r7.d(r2);
                    Intrinsics.checkNotNullParameter(r1, "tags");
                    com.lark.wire.internal.a.a(r1);
                    r0.d = r1;
                    return new ChatChatterTagInfo(r0, r8, null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(ChatChatterTagInfo r4) {
                    ChatChatterTagInfo r5 = r4;
                    Intrinsics.checkNotNullParameter(r5, "value");
                    return r5.unknownFields().size() + TagInfo.ADAPTER.a().l(1, r5.getTags());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r4, ChatChatterTagInfo r5) {
                    ChatChatterTagInfo r6 = r5;
                    Intrinsics.checkNotNullParameter(r4, "writer");
                    Intrinsics.checkNotNullParameter(r6, "value");
                    TagInfo.ADAPTER.a().i(r4, 1, r6.getTags());
                    r4.a(r6.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r3, ChatChatterTagInfo r4) {
                    ChatChatterTagInfo r5 = r4;
                    Intrinsics.checkNotNullParameter(r3, "writer");
                    Intrinsics.checkNotNullParameter(r5, "value");
                    r3.d(r5.unknownFields());
                    TagInfo.ADAPTER.a().j(r3, 1, r5.getTags());
                }

                public b(FieldEncoding r7, KClass<ChatChatterTagInfo> r8, Syntax r9) {
                    super(r7, r8, "type.googleapis.com/basic.v1.Chatter.ChatExtra.ChatChatterTagInfo", r9, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ ChatChatterTagInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
                this(r1, r2);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatChatterTagInfo.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r0 = new a();
                r0.d = this.tags;
                r0.a(unknownFields());
                return r0;
            }

            @Override // com.lark.wire.Message
            public String toString() {
                return Reflection.getOrCreateKotlinClass(ChatChatterTagInfo.class).getSimpleName() + '@' + hashCode();
            }

            public final List<TagInfo> getTags() {
                return this.tags;
            }

            @Override // com.lark.wire.Message
            public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
                return newBuilder();
            }

            public ChatChatterTagInfo(a r2, ByteString r3) {
                super(ADAPTER, r3);
                this.tags = com.lark.wire.internal.a.c("tags", r2.d);
            }

            public /* synthetic */ ChatChatterTagInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = ByteString.EMPTY;
            L5:
                this(r1, r2);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$OncallRole;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "USER", "ONCALL", "ONCALL_HELPER", "USER_HELPER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum OncallRole extends Enum<OncallRole> implements o0 {
            public static final ProtoAdapter<OncallRole> ADAPTER = null;
            public static final b Companion = null;
            public static final OncallRole ONCALL = null;
            public static final OncallRole ONCALL_HELPER = null;
            public static final OncallRole UNKNOWN = null;
            public static final OncallRole USER = null;
            public static final OncallRole USER_HELPER = null;
            public static final /* synthetic */ OncallRole[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<OncallRole> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    OncallRole.Companion.getClass();
                    return b.a(r2);
                }

                public a(KClass<OncallRole> r1, Syntax r2, OncallRole r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static OncallRole a(int r1) {
                    if (r1 == 0) goto L17;
                    if (r1 == 3) goto L22;
                    if (r1 == 4) goto L21;
                    if (r1 == 5) goto L20;
                    if (r1 == 6) goto L19;
                    return null;
                L19:
                    return OncallRole.USER_HELPER;
                L20:
                    return OncallRole.ONCALL_HELPER;
                L21:
                    return OncallRole.ONCALL;
                L22:
                    return OncallRole.USER;
                L17:
                    return OncallRole.UNKNOWN;
                }
            }

            @JvmStatic
            public static final OncallRole fromValue(int r1) {
                Companion.getClass();
                return b.a(r1);
            }

            public static EnumEntries<OncallRole> getEntries() {
                return b;
            }

            static {
                OncallRole r0 = new OncallRole("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                OncallRole r1 = new OncallRole("USER", 1, 3);
                USER = r1;
                OncallRole r3 = new OncallRole("ONCALL", 2, 4);
                ONCALL = r3;
                OncallRole r6 = new OncallRole("ONCALL_HELPER", 3, 5);
                ONCALL_HELPER = r6;
                OncallRole r9 = new OncallRole("USER_HELPER", 4, 6);
                USER_HELPER = r9;
                OncallRole[] r10 = {r0, r1, r3, r6, r9};
                a = r10;
                b = EnumEntriesKt.enumEntries(r10);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(OncallRole.class), Syntax.PROTO_2, r0);
            }

            public static OncallRole[] values() {
                return (OncallRole[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static OncallRole valueOf(String r1) {
                return (OncallRole) r27.a.a(OncallRole.class, r1);
            }

            public OncallRole(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ChatExtra, a> {
            public String d;
            public String e;
            public OncallRole f;
            public String g;
            public ChatChatterTagInfo h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatExtra(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ChatExtra> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChatExtra c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L25;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                String r5 = r10.i();
                Intrinsics.checkNotNullParameter(r5, "chat_id");
                r1.d = r5;
                goto L3
            L8:
                if (r4 != 2) goto L10;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L10:
                if (r4 != 3) goto L12;
                r1.f = OncallRole.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L12:
                if (r4 != 4) goto L14;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.g = r10.i();
                goto L3
            L14:
                if (r4 != 5) goto L15;
                r1.h = ChatChatterTagInfo.ADAPTER.c(r10);
                goto L3
            L15:
                r10.j(r4);
                Unit r7 = Unit.INSTANCE;
                goto L3
            L25:
                return new ChatExtra(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatExtra r6) {
                ChatExtra r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return ((((r0 + r1.l(1, r7.getChat_id())) + r1.l(2, r7.getNick_name())) + OncallRole.ADAPTER.l(3, r7.getOncall_role())) + r1.l(4, r7.getNick_name_pinyin())) + ChatChatterTagInfo.ADAPTER.l(5, r7.getTag_infos());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ChatExtra r6) {
                ChatExtra r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r5, 1, r7.getChat_id());
                r0.i(r5, 2, r7.getNick_name());
                OncallRole.ADAPTER.i(r5, 3, r7.getOncall_role());
                r0.i(r5, 4, r7.getNick_name_pinyin());
                ChatChatterTagInfo.ADAPTER.i(r5, 5, r7.getTag_infos());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ChatExtra r6) {
                ChatExtra r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                ChatChatterTagInfo.ADAPTER.j(r5, 5, r7.getTag_infos());
                w r0 = ProtoAdapter.q;
                r0.j(r5, 4, r7.getNick_name_pinyin());
                OncallRole.ADAPTER.j(r5, 3, r7.getOncall_role());
                r0.j(r5, 2, r7.getNick_name());
                r0.j(r5, 1, r7.getChat_id());
            }

            public b(FieldEncoding r7, KClass<ChatExtra> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chatter.ChatExtra", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatExtra(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatExtra.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.chat_id;
            r0.e = this.nick_name;
            r0.f = this.oncall_role;
            r0.g = this.nick_name_pinyin;
            r0.h = this.tag_infos;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatExtra.class).getSimpleName() + '@' + hashCode();
        }

        public final String getChat_id() {
            return this.chat_id;
        }

        public final String getNick_name() {
            return this.nick_name;
        }

        public final String getNick_name_pinyin() {
            return this.nick_name_pinyin;
        }

        public final OncallRole getOncall_role() {
            return this.oncall_role;
        }

        public final ChatChatterTagInfo getTag_infos() {
            return this.tag_infos;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatExtra(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.chat_id = r4;
            this.nick_name = r2.e;
            this.oncall_role = r2.f;
            this.nick_name_pinyin = r2.g;
            this.tag_infos = r2.h;
        }

        public /* synthetic */ ChatExtra(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002'(B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010%\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0010\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatterCustomStatus;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatterCustomStatus$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$ChatterCustomStatus$Builder;Lokio/ByteString;)V", "title", "", "getTitle", "()Ljava/lang/String;", "icon_key", "getIcon_key", "fs_unit", "getFs_unit", "is_not_disturb_mode", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "effective_interval", "Lcom/lark/kmp/pb/basic/v1/StatusEffectiveInterval;", "getEffective_interval", "()Lcom/lark/kmp/pb/basic/v1/StatusEffectiveInterval;", "tag_info", "Lcom/lark/kmp/pb/basic/v1/TagInfo;", "getTag_info", "()Lcom/lark/kmp/pb/basic/v1/TagInfo;", "time_format", "Lcom/lark/kmp/pb/basic/v1/TimeFormat;", "getTime_format", "()Lcom/lark/kmp/pb/basic/v1/TimeFormat;", "status_id", "", "getStatus_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChatterCustomStatus extends com.lark.wire.Message<ChatterCustomStatus, a> {
        public static final ProtoAdapter<ChatterCustomStatus> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final StatusEffectiveInterval effective_interval;
        private final String fs_unit;
        private final String icon_key;
        private final Boolean is_not_disturb_mode;
        private final Long status_id;
        private final TagInfo tag_info;
        private final TimeFormat time_format;
        private final String title;

        public static final class a extends com.lark.wire.Message.a<ChatterCustomStatus, a> {
            public String d;
            public String e;
            public String f;
            public Boolean g;
            public StatusEffectiveInterval h;
            public TagInfo i;
            public TimeFormat j;
            public Long k;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatterCustomStatus(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ChatterCustomStatus> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChatterCustomStatus c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L16;
                switch(r4) {
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L7:
                r1.k = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L8:
                r1.j = TimeFormat.ADAPTER.c(r7);
                goto L3
            L9:
                r1.i = TagInfo.ADAPTER.c(r7);
                goto L3
            L10:
                r1.h = StatusEffectiveInterval.ADAPTER.c(r7);
                goto L3
            L11:
                r1.g = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L12:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L13:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L14:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L16:
                return new ChatterCustomStatus(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatterCustomStatus r5) {
                ChatterCustomStatus r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (((((((r0 + r1.l(1, r6.getTitle())) + r1.l(2, r6.getIcon_key())) + r1.l(3, r6.getFs_unit())) + ProtoAdapter.g.l(4, r6.is_not_disturb_mode())) + StatusEffectiveInterval.ADAPTER.l(5, r6.getEffective_interval())) + TagInfo.ADAPTER.l(6, r6.getTag_info())) + TimeFormat.ADAPTER.l(7, r6.getTime_format())) + ProtoAdapter.k.l(8, r6.getStatus_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, ChatterCustomStatus r5) {
                ChatterCustomStatus r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getTitle());
                r0.i(r4, 2, r6.getIcon_key());
                r0.i(r4, 3, r6.getFs_unit());
                ProtoAdapter.g.i(r4, 4, r6.is_not_disturb_mode());
                StatusEffectiveInterval.ADAPTER.i(r4, 5, r6.getEffective_interval());
                TagInfo.ADAPTER.i(r4, 6, r6.getTag_info());
                TimeFormat.ADAPTER.i(r4, 7, r6.getTime_format());
                ProtoAdapter.k.i(r4, 8, r6.getStatus_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, ChatterCustomStatus r5) {
                ChatterCustomStatus r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.k.j(r4, 8, r6.getStatus_id());
                TimeFormat.ADAPTER.j(r4, 7, r6.getTime_format());
                TagInfo.ADAPTER.j(r4, 6, r6.getTag_info());
                StatusEffectiveInterval.ADAPTER.j(r4, 5, r6.getEffective_interval());
                ProtoAdapter.g.j(r4, 4, r6.is_not_disturb_mode());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 3, r6.getFs_unit());
                r0.j(r4, 2, r6.getIcon_key());
                r0.j(r4, 1, r6.getTitle());
            }

            public b(FieldEncoding r7, KClass<ChatterCustomStatus> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chatter.ChatterCustomStatus", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatterCustomStatus(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatterCustomStatus.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.title;
            r0.e = this.icon_key;
            r0.f = this.fs_unit;
            r0.g = this.is_not_disturb_mode;
            r0.h = this.effective_interval;
            r0.i = this.tag_info;
            r0.j = this.time_format;
            r0.k = this.status_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatterCustomStatus.class).getSimpleName() + '@' + hashCode();
        }

        public final StatusEffectiveInterval getEffective_interval() {
            return this.effective_interval;
        }

        public final String getFs_unit() {
            return this.fs_unit;
        }

        public final String getIcon_key() {
            return this.icon_key;
        }

        public final Long getStatus_id() {
            return this.status_id;
        }

        public final TagInfo getTag_info() {
            return this.tag_info;
        }

        public final TimeFormat getTime_format() {
            return this.time_format;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Boolean is_not_disturb_mode() {
            return this.is_not_disturb_mode;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatterCustomStatus(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.title = r2.d;
            this.icon_key = r2.e;
            this.fs_unit = r2.f;
            this.is_not_disturb_mode = r2.g;
            this.effective_interval = r2.h;
            this.tag_info = r2.i;
            this.time_format = r2.j;
            this.status_id = r2.k;
        }

        public /* synthetic */ ChatterCustomStatus(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$Description;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$Description$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$Description$Builder;Lokio/ByteString;)V", "text", "", "getText", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/Chatter$Description$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Chatter$Description$Type;", "description_id", "", "getDescription_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Description extends com.lark.wire.Message<Description, a> {
        public static final ProtoAdapter<Description> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Long description_id;
        private final String text;
        private final Type type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$Description$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ON_DEFAULT", "ON_BUSINESS", "ON_LEAVE", "ON_MEETING", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final b Companion = null;
            public static final Type ON_BUSINESS = null;
            public static final Type ON_DEFAULT = null;
            public static final Type ON_LEAVE = null;
            public static final Type ON_MEETING = null;
            public static final /* synthetic */ Type[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    Type.Companion.getClass();
                    if (r2 == 0) goto L15;
                    if (r2 == 1) goto L19;
                    if (r2 == 2) goto L18;
                    if (r2 == 3) goto L17;
                    return null;
                L17:
                    return Type.ON_MEETING;
                L18:
                    return Type.ON_LEAVE;
                L19:
                    return Type.ON_BUSINESS;
                L15:
                    return Type.ON_DEFAULT;
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
                Type r0 = new Type("ON_DEFAULT", 0, 0);
                ON_DEFAULT = r0;
                Type r1 = new Type("ON_BUSINESS", 1, 1);
                ON_BUSINESS = r1;
                Type r3 = new Type("ON_LEAVE", 2, 2);
                ON_LEAVE = r3;
                Type r5 = new Type("ON_MEETING", 3, 3);
                ON_MEETING = r5;
                Type[] r7 = {r0, r1, r3, r5};
                a = r7;
                b = EnumEntriesKt.enumEntries(r7);
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
                if (r1 == 0) goto L15;
                if (r1 == 1) goto L19;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L17;
                return null;
            L17:
                return ON_MEETING;
            L18:
                return ON_LEAVE;
            L19:
                return ON_BUSINESS;
            L15:
                return ON_DEFAULT;
            }

            public static Type valueOf(String r1) {
                return (Type) r27.a.a(Type.class, r1);
            }

            public Type(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends com.lark.wire.Message.a<Description, a> {
            public String d;
            public Type e;
            public Long f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Description(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Description> {
            @Override // com.lark.wire.ProtoAdapter
            public final Description c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L19;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.d = r10.i();
                goto L3
            L8:
                if (r4 != 2) goto L10;
                r1.e = Type.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L10:
                if (r4 != 3) goto L11;
                r1.f = (Long) ProtoAdapter.k.c(r10);
                goto L3
            L11:
                r10.j(r4);
                goto L3
            L19:
                return new Description(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Description r5) {
                Description r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return ((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getText())) + Type.ADAPTER.l(2, r6.getType())) + ProtoAdapter.k.l(3, r6.getDescription_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Description r5) {
                Description r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getText());
                Type.ADAPTER.i(r4, 2, r6.getType());
                ProtoAdapter.k.i(r4, 3, r6.getDescription_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Description r5) {
                Description r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.k.j(r4, 3, r6.getDescription_id());
                Type.ADAPTER.j(r4, 2, r6.getType());
                ProtoAdapter.q.j(r4, 1, r6.getText());
            }

            public b(FieldEncoding r7, KClass<Description> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chatter.Description", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Description(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Description.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.text;
            r0.e = this.type;
            r0.f = this.description_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Description.class).getSimpleName() + '@' + hashCode();
        }

        public final Long getDescription_id() {
            return this.description_id;
        }

        public final String getText() {
            return this.text;
        }

        public final Type getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Description(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.text = r2.d;
            this.type = r2.e;
            this.description_id = r2.f;
        }

        public /* synthetic */ Description(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$TimeZone;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$TimeZone$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$TimeZone$Builder;Lokio/ByteString;)V", "time_zone_id", "", "getTime_zone_id", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class TimeZone extends com.lark.wire.Message<TimeZone, a> {
        public static final ProtoAdapter<TimeZone> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String time_zone_id;

        public static final class a extends com.lark.wire.Message.a<TimeZone, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TimeZone(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TimeZone> {
            @Override // com.lark.wire.ProtoAdapter
            public final TimeZone c(g0 r7) {
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
                Intrinsics.checkNotNullParameter(r5, "time_zone_id");
                r1.d = r5;
                goto L3
            L10:
                return new TimeZone(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TimeZone r4) {
                TimeZone r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getTime_zone_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, TimeZone r5) {
                TimeZone r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getTime_zone_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, TimeZone r4) {
                TimeZone r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 1, r5.getTime_zone_id());
            }

            public b(FieldEncoding r7, KClass<TimeZone> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Chatter.TimeZone", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TimeZone(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TimeZone.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.time_zone_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(TimeZone.class).getSimpleName() + '@' + hashCode();
        }

        public final String getTime_zone_id() {
            return this.time_zone_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public TimeZone(a r2, ByteString r3) {
            super(ADAPTER, r3);
            String r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.time_zone_id = r4;
        }

        public /* synthetic */ TimeZone(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "USER", "BOT", "AI", "DOUBAO", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AI = null;
        public static final Type BOT = null;
        public static final b Companion = null;
        public static final Type DOUBAO = null;
        public static final Type UNKNOWN = null;
        public static final Type USER = null;
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
            public static Type a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return Type.DOUBAO;
            L20:
                return Type.AI;
            L21:
                return Type.BOT;
            L22:
                return Type.USER;
            L17:
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
            Type r1 = new Type("USER", 1, 1);
            USER = r1;
            Type r3 = new Type("BOT", 2, 2);
            BOT = r3;
            Type r5 = new Type("AI", 3, 3);
            AI = r5;
            Type r7 = new Type("DOUBAO", 4, 4);
            DOUBAO = r7;
            Type[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
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

    public static final class a extends com.lark.wire.Message.a<Chatter, a> {
        public List<String> A;
        public TimeZone B;
        public Boolean C;
        public Boolean D;
        public AvatarMedal E;
        public String F;
        public String G;
        public Boolean H;
        public Boolean I;
        public String J;
        public TagData K;
        public String L;
        public Long M;
        public Boolean N;
        public TenantNameStatus O;
        public List<String> P;
        public String Q;
        public Boolean R;
        public Boolean S;
        public BotMutedInfo T;
        public String U;
        public Integer V;
        public Boolean W;
        public List<ChatterCustomStatus> X;
        public ChatExtra Y;
        public Boolean Z;
        public List<? extends Tag> a0;
        public String d;
        public String e;
        public Type f;
        public ImageSet g;
        public Long h;
        public String i;
        public String j;
        public Boolean k;
        public Boolean l;
        public String m;
        public Description n;
        public String o;
        public String p;
        public String q;
        public String r;
        public WorkStatus s;
        public Boolean t;
        public String u;
        public AccessInfo v;
        public String w;
        public String x;
        public String y;
        public Long z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Chatter(this, c(), null);
        }

        public a() {
            this.A = CollectionsKt.emptyList();
            this.P = CollectionsKt.emptyList();
            this.X = CollectionsKt.emptyList();
            this.a0 = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Chatter> {
        @Override // com.lark.wire.ProtoAdapter
        public final Chatter c(g0 r14) {
            Intrinsics.checkNotNullParameter(r14, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            ArrayList r4 = new ArrayList();
            ArrayList r5 = new ArrayList();
            long r6 = r14.c();
        L3:
            int r8 = r14.e();
            if (r8 == (-1)) goto L81;
            if (r8 != 36) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.L = r14.i();
            goto L3
        L8:
            if (r8 != 37) goto L10;
            r1.M = (Long) ProtoAdapter.k.c(r14);
            goto L3
        L10:
            if (r8 != 150) goto L12;
            r4.add(ChatterCustomStatus.ADAPTER.c(r14));
            goto L3
        L12:
            if (r8 != 200) goto L14;
            Tag.ADAPTER.m(r14, r5);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L75
        L77:
            Unit r9 = Unit.INSTANCE;
        L75:
            e = move-exception;
            r14.a(r8, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L77
        L14:
            if (r8 != 1000) goto L16;
            r1.Y = ChatExtra.ADAPTER.c(r14);
            goto L3
        L16:
            if (r8 != 1001) goto L17;
            r1.Z = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L17:
            switch(r8) {
                case 1: goto L57;
                case 2: goto L56;
                case 3: goto L87;
                case 4: goto L51;
                case 5: goto L50;
                case 6: goto L49;
                case 7: goto L48;
                case 8: goto L47;
                case 9: goto L46;
                case 10: goto L45;
                case 11: goto L44;
                case 12: goto L43;
                case 13: goto L42;
                case 14: goto L41;
                case 15: goto L40;
                case 16: goto L39;
                case 17: goto L38;
                case 18: goto L37;
                case 19: goto L36;
                case 20: goto L35;
                case 21: goto L34;
                case 22: goto L33;
                case 23: goto L32;
                case 24: goto L31;
                case 25: goto L30;
                case 26: goto L29;
                case 27: goto L28;
                case 28: goto L27;
                case 29: goto L26;
                case 30: goto L25;
                case 31: goto L24;
                case 32: goto L23;
                case 33: goto L22;
                case 34: goto L21;
                default: goto L18;
            };
        L87:
            Type r10 = Type.ADAPTER.c(r14);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L54
            Intrinsics.checkNotNullParameter(r10, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L54
            r1.f = r10;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L54
        L54:
            e = move-exception;
            r14.a(r8, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r11 = Unit.INSTANCE;
            goto L3
        L21:
            r1.K = TagData.ADAPTER.c(r14);
            goto L3
        L22:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.J = r14.i();
            goto L3
        L23:
            r1.I = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L24:
            r1.H = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L25:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.G = r14.i();
            goto L3
        L26:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.F = r14.i();
            goto L3
        L27:
            r1.E = AvatarMedal.ADAPTER.c(r14);
            goto L3
        L28:
            r1.D = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L29:
            r1.C = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L30:
            r1.B = TimeZone.ADAPTER.c(r14);
            goto L3
        L31:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r2.add(r14.i());
            goto L3
        L32:
            r1.z = (Long) ProtoAdapter.k.c(r14);
            goto L3
        L33:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.y = r14.i();
            goto L3
        L34:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.x = r14.i();
            goto L3
        L35:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.w = r14.i();
            goto L3
        L36:
            r1.v = AccessInfo.ADAPTER.c(r14);
            goto L3
        L37:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.u = r14.i();
            goto L3
        L38:
            r1.t = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L39:
            r1.s = WorkStatus.ADAPTER.c(r14);
            goto L3
        L40:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.r = r14.i();
            goto L3
        L41:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.q = r14.i();
            goto L3
        L42:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.p = r14.i();
            goto L3
        L43:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.o = r14.i();
            goto L3
        L44:
            r1.n = Description.ADAPTER.c(r14);
            goto L3
        L45:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.m = r14.i();
            goto L3
        L46:
            r1.l = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L47:
            r1.k = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L48:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.j = r14.i();
            goto L3
        L49:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            String r12 = r14.i();
            Intrinsics.checkNotNullParameter(r12, "name_pinyin");
            r1.i = r12;
            goto L3
        L50:
            r1.h = Long.valueOf(((Number) ProtoAdapter.k.c(r14)).longValue());
            goto L3
        L51:
            r1.g = ImageSet.ADAPTER.c(r14);
            goto L3
        L56:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            String r13 = r14.i();
            Intrinsics.checkNotNullParameter(r13, "name");
            r1.e = r13;
            goto L3
        L57:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            String r15 = r14.i();
            Intrinsics.checkNotNullParameter(r15, "id");
            r1.d = r15;
            goto L3
        L18:
            switch(r8) {
                case 45: goto L63;
                case 46: goto L83;
                case 47: goto L58;
                default: goto L19;
            };
        L83:
            r1.O = TenantNameStatus.ADAPTER.c(r14);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L61
        L61:
            e = move-exception;
            r14.a(r8, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r16 = Unit.INSTANCE;
            goto L3
        L58:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r3.add(r14.i());
            goto L3
        L63:
            r1.N = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L19:
            switch(r8) {
                case 100: goto L70;
                case 101: goto L69;
                case 102: goto L68;
                case 103: goto L67;
                case 104: goto L66;
                case 105: goto L65;
                case 106: goto L64;
                default: goto L20;
            };
        L64:
            r1.W = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L65:
            r1.V = (Integer) ProtoAdapter.h.c(r14);
            goto L3
        L66:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.U = r14.i();
            goto L3
        L67:
            r1.T = BotMutedInfo.ADAPTER.c(r14);
            goto L3
        L68:
            r1.S = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L69:
            r1.R = (Boolean) ProtoAdapter.g.c(r14);
            goto L3
        L70:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r14, "reader");
            r1.Q = r14.i();
            goto L3
        L20:
            r14.j(r8);
            Unit r17 = Unit.INSTANCE;
            goto L3
        L81:
            ByteString r19 = r14.d(r6);
            Intrinsics.checkNotNullParameter(r2, "avatar_urls");
            com.lark.wire.internal.a.a(r2);
            r1.A = r2;
            Intrinsics.checkNotNullParameter(r3, "common_locales");
            com.lark.wire.internal.a.a(r3);
            r1.P = r3;
            Intrinsics.checkNotNullParameter(r4, "status");
            com.lark.wire.internal.a.a(r4);
            r1.X = r4;
            Intrinsics.checkNotNullParameter(r5, "tags");
            com.lark.wire.internal.a.a(r5);
            r1.a0 = r5;
            return new Chatter(r1, r19, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Chatter r8) {
            Chatter r9 = r8;
            Intrinsics.checkNotNullParameter(r9, "value");
            int r0 = r9.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (((r0 + r1.l(1, r9.getId())) + r1.l(2, r9.getName())) + Type.ADAPTER.l(3, r9.getType())) + ImageSet.ADAPTER.l(4, r9.getAvatar());
            t r3 = ProtoAdapter.k;
            int r4 = ((r2 + r3.l(5, Long.valueOf(r9.getUpdate_time()))) + r1.l(6, r9.getName_pinyin())) + r1.l(7, r9.getCreator_id());
            l r5 = ProtoAdapter.g;
            return ((((((((((((((((((((((((((((((((((((((((((r4 + r5.l(8, r9.is_resigned())) + r5.l(9, r9.is_registered())) + r1.l(10, r9.getEn_us_name())) + Description.ADAPTER.l(11, r9.getDescription())) + r1.l(12, r9.getAvatar_key())) + r1.l(13, r9.getTenant_id())) + r1.l(14, r9.getLocalized_name())) + r1.l(15, r9.getAlias())) + WorkStatus.ADAPTER.l(16, r9.getWork_status())) + r5.l(17, r9.getProfile_enabled())) + r1.l(18, r9.getAccount_id())) + AccessInfo.ADAPTER.l(19, r9.getAccess_info())) + r1.l(20, r9.getOpen_app_id())) + r1.l(21, r9.getAvatar_path())) + r1.l(22, r9.getEmail())) + r3.l(23, r9.getDo_not_disturb_end_time())) + r1.a().l(24, r9.getAvatar_urls())) + TimeZone.ADAPTER.l(25, r9.getTime_zone())) + r5.l(26, r9.is_frozen())) + r5.l(27, r9.is_anonymous())) + AvatarMedal.ADAPTER.l(28, r9.getAvatar_medal())) + r1.l(29, r9.getName_with_another_name())) + r1.l(30, r9.getAnother_name())) + r5.l(31, r9.is_default_avatar())) + r5.l(32, r9.is_special_focus())) + r1.l(33, r9.getMajor_language())) + TagData.ADAPTER.l(34, r9.getTag_info())) + r1.l(36, r9.getPrivate_description())) + r3.l(37, r9.getPrivate_description_id())) + r5.l(45, r9.is_tenant_certification())) + TenantNameStatus.ADAPTER.l(46, r9.getTenant_name_status())) + r1.a().l(47, r9.getCommon_locales())) + r1.l(100, r9.getWith_bot_tag())) + r5.l(101, r9.getIn_contacts())) + r5.l(102, r9.getCan_join_group())) + BotMutedInfo.ADAPTER.l(103, r9.getMuted_info())) + r1.l(104, r9.getChat_chatter_list_department_name())) + ProtoAdapter.h.l(105, r9.getBot_ext_type())) + r5.l(106, r9.is_agent())) + ChatterCustomStatus.ADAPTER.a().l(150, r9.getStatus())) + ChatExtra.ADAPTER.l(CommandStatus.DORA_TRACE, r9.getChat_extra())) + r5.l(1001, r9.getAccept_sms_phone_urgent())) + Tag.ADAPTER.a().l(com.lark.kmp.server.pb.improto.Packet.DEFAULT_STATUS, r9.getTags());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r7, Chatter r8) {
            Chatter r9 = r8;
            Intrinsics.checkNotNullParameter(r7, "writer");
            Intrinsics.checkNotNullParameter(r9, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r7, 1, r9.getId());
            r0.i(r7, 2, r9.getName());
            Type.ADAPTER.i(r7, 3, r9.getType());
            ImageSet.ADAPTER.i(r7, 4, r9.getAvatar());
            t r1 = ProtoAdapter.k;
            r1.i(r7, 5, Long.valueOf(r9.getUpdate_time()));
            r0.i(r7, 6, r9.getName_pinyin());
            r0.i(r7, 7, r9.getCreator_id());
            l r2 = ProtoAdapter.g;
            r2.i(r7, 8, r9.is_resigned());
            r2.i(r7, 9, r9.is_registered());
            r0.i(r7, 10, r9.getEn_us_name());
            Description.ADAPTER.i(r7, 11, r9.getDescription());
            r0.i(r7, 12, r9.getAvatar_key());
            r0.i(r7, 13, r9.getTenant_id());
            r0.i(r7, 14, r9.getLocalized_name());
            r0.i(r7, 15, r9.getAlias());
            WorkStatus.ADAPTER.i(r7, 16, r9.getWork_status());
            r2.i(r7, 17, r9.getProfile_enabled());
            r0.i(r7, 18, r9.getAccount_id());
            AccessInfo.ADAPTER.i(r7, 19, r9.getAccess_info());
            r0.i(r7, 20, r9.getOpen_app_id());
            r0.i(r7, 21, r9.getAvatar_path());
            r0.i(r7, 22, r9.getEmail());
            r1.i(r7, 23, r9.getDo_not_disturb_end_time());
            r0.a().i(r7, 24, r9.getAvatar_urls());
            TimeZone.ADAPTER.i(r7, 25, r9.getTime_zone());
            r2.i(r7, 26, r9.is_frozen());
            r2.i(r7, 27, r9.is_anonymous());
            AvatarMedal.ADAPTER.i(r7, 28, r9.getAvatar_medal());
            r0.i(r7, 29, r9.getName_with_another_name());
            r0.i(r7, 30, r9.getAnother_name());
            r2.i(r7, 31, r9.is_default_avatar());
            r2.i(r7, 32, r9.is_special_focus());
            r0.i(r7, 33, r9.getMajor_language());
            TagData.ADAPTER.i(r7, 34, r9.getTag_info());
            r0.i(r7, 36, r9.getPrivate_description());
            r1.i(r7, 37, r9.getPrivate_description_id());
            r2.i(r7, 45, r9.is_tenant_certification());
            TenantNameStatus.ADAPTER.i(r7, 46, r9.getTenant_name_status());
            r0.a().i(r7, 47, r9.getCommon_locales());
            r0.i(r7, 100, r9.getWith_bot_tag());
            r2.i(r7, 101, r9.getIn_contacts());
            r2.i(r7, 102, r9.getCan_join_group());
            BotMutedInfo.ADAPTER.i(r7, 103, r9.getMuted_info());
            r0.i(r7, 104, r9.getChat_chatter_list_department_name());
            ProtoAdapter.h.i(r7, 105, r9.getBot_ext_type());
            r2.i(r7, 106, r9.is_agent());
            ChatterCustomStatus.ADAPTER.a().i(r7, 150, r9.getStatus());
            ChatExtra.ADAPTER.i(r7, CommandStatus.DORA_TRACE, r9.getChat_extra());
            r2.i(r7, 1001, r9.getAccept_sms_phone_urgent());
            Tag.ADAPTER.a().i(r7, com.lark.kmp.server.pb.improto.Packet.DEFAULT_STATUS, r9.getTags());
            r7.a(r9.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r7, Chatter r8) {
            Chatter r9 = r8;
            Intrinsics.checkNotNullParameter(r7, "writer");
            Intrinsics.checkNotNullParameter(r9, "value");
            r7.d(r9.unknownFields());
            Tag.ADAPTER.a().j(r7, com.lark.kmp.server.pb.improto.Packet.DEFAULT_STATUS, r9.getTags());
            l r0 = ProtoAdapter.g;
            r0.j(r7, 1001, r9.getAccept_sms_phone_urgent());
            ChatExtra.ADAPTER.j(r7, CommandStatus.DORA_TRACE, r9.getChat_extra());
            ChatterCustomStatus.ADAPTER.a().j(r7, 150, r9.getStatus());
            r0.j(r7, 106, r9.is_agent());
            ProtoAdapter.h.j(r7, 105, r9.getBot_ext_type());
            w r1 = ProtoAdapter.q;
            r1.j(r7, 104, r9.getChat_chatter_list_department_name());
            BotMutedInfo.ADAPTER.j(r7, 103, r9.getMuted_info());
            r0.j(r7, 102, r9.getCan_join_group());
            r0.j(r7, 101, r9.getIn_contacts());
            r1.j(r7, 100, r9.getWith_bot_tag());
            r1.a().j(r7, 47, r9.getCommon_locales());
            TenantNameStatus.ADAPTER.j(r7, 46, r9.getTenant_name_status());
            r0.j(r7, 45, r9.is_tenant_certification());
            t r2 = ProtoAdapter.k;
            r2.j(r7, 37, r9.getPrivate_description_id());
            r1.j(r7, 36, r9.getPrivate_description());
            TagData.ADAPTER.j(r7, 34, r9.getTag_info());
            r1.j(r7, 33, r9.getMajor_language());
            r0.j(r7, 32, r9.is_special_focus());
            r0.j(r7, 31, r9.is_default_avatar());
            r1.j(r7, 30, r9.getAnother_name());
            r1.j(r7, 29, r9.getName_with_another_name());
            AvatarMedal.ADAPTER.j(r7, 28, r9.getAvatar_medal());
            r0.j(r7, 27, r9.is_anonymous());
            r0.j(r7, 26, r9.is_frozen());
            TimeZone.ADAPTER.j(r7, 25, r9.getTime_zone());
            r1.a().j(r7, 24, r9.getAvatar_urls());
            r2.j(r7, 23, r9.getDo_not_disturb_end_time());
            r1.j(r7, 22, r9.getEmail());
            r1.j(r7, 21, r9.getAvatar_path());
            r1.j(r7, 20, r9.getOpen_app_id());
            AccessInfo.ADAPTER.j(r7, 19, r9.getAccess_info());
            r1.j(r7, 18, r9.getAccount_id());
            r0.j(r7, 17, r9.getProfile_enabled());
            WorkStatus.ADAPTER.j(r7, 16, r9.getWork_status());
            r1.j(r7, 15, r9.getAlias());
            r1.j(r7, 14, r9.getLocalized_name());
            r1.j(r7, 13, r9.getTenant_id());
            r1.j(r7, 12, r9.getAvatar_key());
            Description.ADAPTER.j(r7, 11, r9.getDescription());
            r1.j(r7, 10, r9.getEn_us_name());
            r0.j(r7, 9, r9.is_registered());
            r0.j(r7, 8, r9.is_resigned());
            r1.j(r7, 7, r9.getCreator_id());
            r1.j(r7, 6, r9.getName_pinyin());
            r2.j(r7, 5, Long.valueOf(r9.getUpdate_time()));
            ImageSet.ADAPTER.j(r7, 4, r9.getAvatar());
            Type.ADAPTER.j(r7, 3, r9.getType());
            r1.j(r7, 2, r9.getName());
            r1.j(r7, 1, r9.getId());
        }

        public b(FieldEncoding r7, KClass<Chatter> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Chatter", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Chatter(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "avatar is deprecated")
    public static /* synthetic */ void getAvatar$annotations() {
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Chatter.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.name;
        r0.f = this.type;
        r0.g = this.avatar;
        r0.h = Long.valueOf(this.update_time);
        r0.i = this.name_pinyin;
        r0.j = this.creator_id;
        r0.k = this.is_resigned;
        r0.l = this.is_registered;
        r0.m = this.en_us_name;
        r0.n = this.description;
        r0.o = this.avatar_key;
        r0.p = this.tenant_id;
        r0.q = this.localized_name;
        r0.r = this.alias;
        r0.s = this.work_status;
        r0.t = this.profile_enabled;
        r0.u = this.account_id;
        r0.v = this.access_info;
        r0.w = this.open_app_id;
        r0.x = this.avatar_path;
        r0.y = this.email;
        r0.z = this.do_not_disturb_end_time;
        r0.A = this.avatar_urls;
        r0.B = this.time_zone;
        r0.C = this.is_frozen;
        r0.D = this.is_anonymous;
        r0.E = this.avatar_medal;
        r0.F = this.name_with_another_name;
        r0.G = this.another_name;
        r0.H = this.is_default_avatar;
        r0.I = this.is_special_focus;
        r0.J = this.major_language;
        r0.K = this.tag_info;
        r0.L = this.private_description;
        r0.M = this.private_description_id;
        r0.N = this.is_tenant_certification;
        r0.O = this.tenant_name_status;
        r0.P = this.common_locales;
        r0.Q = this.with_bot_tag;
        r0.R = this.in_contacts;
        r0.S = this.can_join_group;
        r0.T = this.muted_info;
        r0.U = this.chat_chatter_list_department_name;
        r0.V = this.bot_ext_type;
        r0.W = this.is_agent;
        r0.X = this.status;
        r0.Y = this.chat_extra;
        r0.Z = this.accept_sms_phone_urgent;
        r0.a0 = this.tags;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Chatter.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean getAccept_sms_phone_urgent() {
        return this.accept_sms_phone_urgent;
    }

    public final AccessInfo getAccess_info() {
        return this.access_info;
    }

    public final String getAccount_id() {
        return this.account_id;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getAnother_name() {
        return this.another_name;
    }

    public final ImageSet getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final AvatarMedal getAvatar_medal() {
        return this.avatar_medal;
    }

    public final String getAvatar_path() {
        return this.avatar_path;
    }

    public final List<String> getAvatar_urls() {
        return this.avatar_urls;
    }

    public final Integer getBot_ext_type() {
        return this.bot_ext_type;
    }

    public final Boolean getCan_join_group() {
        return this.can_join_group;
    }

    public final String getChat_chatter_list_department_name() {
        return this.chat_chatter_list_department_name;
    }

    public final ChatExtra getChat_extra() {
        return this.chat_extra;
    }

    public final List<String> getCommon_locales() {
        return this.common_locales;
    }

    public final String getCreator_id() {
        return this.creator_id;
    }

    public final Description getDescription() {
        return this.description;
    }

    public final Long getDo_not_disturb_end_time() {
        return this.do_not_disturb_end_time;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getEn_us_name() {
        return this.en_us_name;
    }

    public final String getId() {
        return this.id;
    }

    public final Boolean getIn_contacts() {
        return this.in_contacts;
    }

    public final String getLocalized_name() {
        return this.localized_name;
    }

    public final String getMajor_language() {
        return this.major_language;
    }

    public final BotMutedInfo getMuted_info() {
        return this.muted_info;
    }

    public final String getName() {
        return this.name;
    }

    public final String getName_pinyin() {
        return this.name_pinyin;
    }

    public final String getName_with_another_name() {
        return this.name_with_another_name;
    }

    public final String getOpen_app_id() {
        return this.open_app_id;
    }

    public final String getPrivate_description() {
        return this.private_description;
    }

    public final Long getPrivate_description_id() {
        return this.private_description_id;
    }

    public final Boolean getProfile_enabled() {
        return this.profile_enabled;
    }

    public final List<ChatterCustomStatus> getStatus() {
        return this.status;
    }

    public final TagData getTag_info() {
        return this.tag_info;
    }

    public final List<Tag> getTags() {
        return this.tags;
    }

    public final String getTenant_id() {
        return this.tenant_id;
    }

    public final TenantNameStatus getTenant_name_status() {
        return this.tenant_name_status;
    }

    public final TimeZone getTime_zone() {
        return this.time_zone;
    }

    public final Type getType() {
        return this.type;
    }

    public final long getUpdate_time() {
        return this.update_time;
    }

    public final String getWith_bot_tag() {
        return this.with_bot_tag;
    }

    public final WorkStatus getWork_status() {
        return this.work_status;
    }

    public final Boolean is_agent() {
        return this.is_agent;
    }

    public final Boolean is_anonymous() {
        return this.is_anonymous;
    }

    public final Boolean is_default_avatar() {
        return this.is_default_avatar;
    }

    public final Boolean is_frozen() {
        return this.is_frozen;
    }

    public final Boolean is_registered() {
        return this.is_registered;
    }

    public final Boolean is_resigned() {
        return this.is_resigned;
    }

    public final Boolean is_special_focus() {
        return this.is_special_focus;
    }

    public final Boolean is_tenant_certification() {
        return this.is_tenant_certification;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Chatter(a r3, ByteString r4) {
        super(ADAPTER, r4);
        String r5 = r3.d;
        Intrinsics.checkNotNull(r5);
        this.id = r5;
        String r6 = r3.e;
        Intrinsics.checkNotNull(r6);
        this.name = r6;
        Type r7 = r3.f;
        Intrinsics.checkNotNull(r7);
        this.type = r7;
        this.avatar = r3.g;
        Long r8 = r3.h;
        Intrinsics.checkNotNull(r8);
        this.update_time = r8.longValue();
        String r9 = r3.i;
        Intrinsics.checkNotNull(r9);
        this.name_pinyin = r9;
        this.creator_id = r3.j;
        this.is_resigned = r3.k;
        this.is_registered = r3.l;
        this.en_us_name = r3.m;
        this.description = r3.n;
        this.avatar_key = r3.o;
        this.tenant_id = r3.p;
        this.localized_name = r3.q;
        this.alias = r3.r;
        this.work_status = r3.s;
        this.profile_enabled = r3.t;
        this.account_id = r3.u;
        this.access_info = r3.v;
        this.open_app_id = r3.w;
        this.avatar_path = r3.x;
        this.email = r3.y;
        this.do_not_disturb_end_time = r3.z;
        this.avatar_urls = com.lark.wire.internal.a.c("avatar_urls", r3.A);
        this.time_zone = r3.B;
        this.is_frozen = r3.C;
        this.is_anonymous = r3.D;
        this.avatar_medal = r3.E;
        this.name_with_another_name = r3.F;
        this.another_name = r3.G;
        this.is_default_avatar = r3.H;
        this.is_special_focus = r3.I;
        this.major_language = r3.J;
        this.tag_info = r3.K;
        this.private_description = r3.L;
        this.private_description_id = r3.M;
        this.is_tenant_certification = r3.N;
        this.tenant_name_status = r3.O;
        this.common_locales = com.lark.wire.internal.a.c("common_locales", r3.P);
        this.with_bot_tag = r3.Q;
        this.in_contacts = r3.R;
        this.can_join_group = r3.S;
        this.muted_info = r3.T;
        this.chat_chatter_list_department_name = r3.U;
        this.bot_ext_type = r3.V;
        this.is_agent = r3.W;
        this.status = com.lark.wire.internal.a.c("status", r3.X);
        this.chat_extra = r3.Y;
        this.accept_sms_phone_urgent = r3.Z;
        this.tags = com.lark.wire.internal.a.c("tags", r3.a0);
    }

    public /* synthetic */ Chatter(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
