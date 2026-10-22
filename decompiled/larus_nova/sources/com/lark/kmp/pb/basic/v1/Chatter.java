package com.lark.kmp.pb.basic.v1;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
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
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
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

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u008f\u00012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0012\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u008c\u0001\u001a\u00020\u0002H\u0016J\t\u0010\u008d\u0001\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b \u0010\"R\u0015\u0010$\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0013\u0010%\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000bR\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010+\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u000bR\u0013\u0010-\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000bR\u0013\u0010/\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000bR\u0013\u00101\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u000bR\u0013\u00103\u001a\u0004\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0015\u00107\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b8\u0010\"R\u0013\u00109\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u000bR\u0013\u0010;\u001a\u0004\u0018\u00010<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010?\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000bR\u0013\u0010A\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u000bR\u0013\u0010C\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u000bR\u0015\u0010E\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010H\u001a\u0004\bF\u0010GR\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010M\u001a\u0004\u0018\u00010N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0015\u0010Q\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\bQ\u0010\"R\u0015\u0010R\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\bR\u0010\"R\u0013\u0010S\u001a\u0004\u0018\u00010T¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010W\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u000bR\u0013\u0010Y\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u000bR\u0015\u0010[\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b[\u0010\"R\u0015\u0010\\\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\\\u0010\"R\u0013\u0010]\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\u000bR\u0013\u0010_\u001a\u0004\u0018\u00010`¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0013\u0010c\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\u000bR\u0015\u0010e\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010H\u001a\u0004\bf\u0010GR\u0015\u0010g\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\bg\u0010\"R\u0013\u0010h\u001a\u0004\u0018\u00010i¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020\t0J¢\u0006\b\n\u0000\u001a\u0004\bm\u0010LR\u0013\u0010n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u000bR\u0015\u0010p\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\bq\u0010\"R\u0015\u0010r\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\bs\u0010\"R\u0013\u0010t\u001a\u0004\u0018\u00010u¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u0013\u0010x\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u000bR\u0015\u0010z\u001a\u0004\u0018\u00010{¢\u0006\n\n\u0002\u0010~\u001a\u0004\b|\u0010}R\u0015\u0010\u007f\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u007f\u0010\"R\u001a\u0010\u0080\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010J¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010LR\u0017\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0017\u0010\u0087\u0001\u001a\u0004\u0018\u00010!¢\u0006\u000b\n\u0002\u0010#\u001a\u0005\b\u0088\u0001\u0010\"R\u001a\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010J¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010L¨\u0006\u0097\u0001"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "type", "Lcom/lark/kmp/pb/basic/v1/Chatter$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Chatter$Type;", "avatar", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getAvatar$annotations", "()V", "getAvatar", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "update_time", "", "getUpdate_time", "()J", "name_pinyin", "getName_pinyin", "creator_id", "getCreator_id", "is_resigned", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_registered", "en_us_name", "getEn_us_name", "description", "Lcom/lark/kmp/pb/basic/v1/Chatter$Description;", "getDescription", "()Lcom/lark/kmp/pb/basic/v1/Chatter$Description;", "avatar_key", "getAvatar_key", "tenant_id", "getTenant_id", "localized_name", "getLocalized_name", "alias", "getAlias", "work_status", "Lcom/lark/kmp/pb/basic/v1/WorkStatus;", "getWork_status", "()Lcom/lark/kmp/pb/basic/v1/WorkStatus;", "profile_enabled", "getProfile_enabled", "account_id", "getAccount_id", "access_info", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo;", "getAccess_info", "()Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo;", "open_app_id", "getOpen_app_id", "avatar_path", "getAvatar_path", "email", "getEmail", "do_not_disturb_end_time", "getDo_not_disturb_end_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "avatar_urls", "", "getAvatar_urls", "()Ljava/util/List;", "time_zone", "Lcom/lark/kmp/pb/basic/v1/Chatter$TimeZone;", "getTime_zone", "()Lcom/lark/kmp/pb/basic/v1/Chatter$TimeZone;", "is_frozen", com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS, "avatar_medal", "Lcom/lark/kmp/pb/basic/v1/AvatarMedal;", "getAvatar_medal", "()Lcom/lark/kmp/pb/basic/v1/AvatarMedal;", "name_with_another_name", "getName_with_another_name", "another_name", "getAnother_name", "is_default_avatar", "is_special_focus", "major_language", "getMajor_language", "tag_info", "Lcom/lark/kmp/pb/basic/v1/TagData;", "getTag_info", "()Lcom/lark/kmp/pb/basic/v1/TagData;", "private_description", "getPrivate_description", "private_description_id", "getPrivate_description_id", "is_tenant_certification", "tenant_name_status", "Lcom/lark/kmp/pb/basic/v1/TenantNameStatus;", "getTenant_name_status", "()Lcom/lark/kmp/pb/basic/v1/TenantNameStatus;", "common_locales", "getCommon_locales", "with_bot_tag", "getWith_bot_tag", "in_contacts", "getIn_contacts", "can_join_group", "getCan_join_group", "muted_info", "Lcom/lark/kmp/pb/basic/v1/Chatter$BotMutedInfo;", "getMuted_info", "()Lcom/lark/kmp/pb/basic/v1/Chatter$BotMutedInfo;", "chat_chatter_list_department_name", "getChat_chatter_list_department_name", "bot_ext_type", "", "getBot_ext_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_agent", "status", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatterCustomStatus;", "getStatus", "chat_extra", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra;", "getChat_extra", "()Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra;", "accept_sms_phone_urgent", "getAccept_sms_phone_urgent", PromotionProductPrivilegesStruct.TAGS, "Lcom/lark/kmp/pb/basic/v1/Tag;", "getTags", "newBuilder", "toString", "Builder", "Companion", "Type", "Description", "AccessInfo", "TimeZone", "BotMutedInfo", "ChatterCustomStatus", "ChatExtra", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f279178id;
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

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$Builder;Lokio/ByteString;)V", "phone_call", "", "getPhone_call", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "voice_call", "getVoice_call", "video_call", "getVideo_call", "access_profile", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile;", "getAccess_profile", "()Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile;", "newBuilder", "toString", "", "Builder", "Companion", "AccessProfile", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0015\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$Builder;Lokio/ByteString;)V", "access_message_phone_call", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage;", "getAccess_message_phone_call", "()Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage;", "access_message_voice_call", "getAccess_message_voice_call", "access_message_video_call", "getAccess_message_video_call", "access_message_urgent", "getAccess_message_urgent", "newBuilder", "toString", "", "Builder", "Companion", "AccessMessage", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class AccessProfile extends com.lark.wire.Message<AccessProfile, a> {
            public static final ProtoAdapter<AccessProfile> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final AccessMessage access_message_phone_call;
            private final AccessMessage access_message_urgent;
            private final AccessMessage access_message_video_call;
            private final AccessMessage access_message_voice_call;

            @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage$Builder;Lokio/ByteString;)V", "is_accessible", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "inaccessible_code", "Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage$InaccessibleCode;", "getInaccessible_code", "()Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage$InaccessibleCode;", "newBuilder", "toString", "", "Builder", "Companion", "InaccessibleCode", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class AccessMessage extends com.lark.wire.Message<AccessMessage, a> {
                public static final ProtoAdapter<AccessMessage> ADAPTER = null;
                public static final c Companion = null;
                public static final InaccessibleCode DEFAULT_INACCESSIBLE_CODE = null;
                public static final boolean DEFAULT_IS_ACCESSIBLE = true;
                private static final long serialVersionUID = 0;
                private final InaccessibleCode inaccessible_code;
                private final Boolean is_accessible;

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$AccessInfo$AccessProfile$AccessMessage$InaccessibleCode;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "EXECUTIVES", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
                public static final enum InaccessibleCode extends Enum<InaccessibleCode> implements o0 {
                    public static final ProtoAdapter<InaccessibleCode> ADAPTER = null;
                    public static final b Companion = null;
                    public static final InaccessibleCode DEFAULT = null;
                    public static final InaccessibleCode EXECUTIVES = null;

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ InaccessibleCode[] f279179a = null;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public static final /* synthetic */ EnumEntries f279180b = null;
                    private final int value;

                    public static final class a extends d<InaccessibleCode> {
                        @Override // com.lark.wire.d
                        public final o0 n(int r100) {
                            InaccessibleCode.Companion.getClass();
                            if (r100 == 0) goto L9;
                            if (r100 == 1) goto L11;
                            return null;
                        L11:
                            return InaccessibleCode.EXECUTIVES;
                        L9:
                            return InaccessibleCode.DEFAULT;
                        }

                        public a(KClass<InaccessibleCode> r100, Syntax r101, InaccessibleCode r102) {
                            super(r100, r101, r102);
                        }
                    }

                    public static final class b {
                        public b() {
                        }
                    }

                    public static EnumEntries<InaccessibleCode> getEntries() {
                        return f279180b;
                    }

                    static {
                        InaccessibleCode r100 = new InaccessibleCode("DEFAULT", 0, 0);
                        DEFAULT = r100;
                        InaccessibleCode r101 = new InaccessibleCode("EXECUTIVES", 1, 1);
                        EXECUTIVES = r101;
                        InaccessibleCode[] r102 = {r100, r101};
                        f279179a = r102;
                        f279180b = EnumEntriesKt.enumEntries(r102);
                        Companion = new b();
                        ADAPTER = new a(Reflection.getOrCreateKotlinClass(InaccessibleCode.class), Syntax.PROTO_2, r100);
                    }

                    public static InaccessibleCode[] values() {
                        return (InaccessibleCode[]) f279179a.clone();
                    }

                    @Override // com.lark.wire.o0
                    public int getValue() {
                        return this.value;
                    }

                    @JvmStatic
                    public static final InaccessibleCode fromValue(int r100) {
                        Companion.getClass();
                        if (r100 == 0) goto L9;
                        if (r100 == 1) goto L11;
                        return null;
                    L11:
                        return EXECUTIVES;
                    L9:
                        return DEFAULT;
                    }

                    public static InaccessibleCode valueOf(String r100) {
                        return (InaccessibleCode) r27.a.a(InaccessibleCode.class, r100);
                    }

                    public InaccessibleCode(String r100, int r101, int r102) {
                        super(r100, r101);
                        this.value = r102;
                    }
                }

                public static final class a extends com.lark.wire.Message.a<AccessMessage, a> {

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    public Boolean f279181d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    public InaccessibleCode f279182e;

                    @Override // com.lark.wire.Message.a
                    public final com.lark.wire.Message b() {
                        return new AccessMessage(this, c(), null);
                    }

                    public a() {
                    }
                }

                public static final class b extends ProtoAdapter<AccessMessage> {
                    @Override // com.lark.wire.ProtoAdapter
                    public final AccessMessage c(g0 r100) {
                        Intrinsics.checkNotNullParameter(r100, "reader");
                        a r101 = new a();
                        long r102 = r100.c();
                    L3:
                        int r103 = r100.e();
                        if (r103 == (-1)) goto L16;
                        if (r103 != 1) goto L8;
                        r101.f279181d = (Boolean) ProtoAdapter.f282718g.c(r100);
                        goto L3
                    L8:
                        if (r103 != 2) goto L9;
                        r101.f279182e = InaccessibleCode.ADAPTER.c(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
                    L12:
                        e = move-exception;
                        r100.a(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                        Unit r104 = Unit.INSTANCE;
                        goto L3
                    L9:
                        r100.j(r103);
                        goto L3
                    L16:
                        return new AccessMessage(r101, r100.d(r102), null);
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final int k(AccessMessage r100) {
                        AccessMessage r101 = r100;
                        Intrinsics.checkNotNullParameter(r101, "value");
                        return (r101.unknownFields().size() + ProtoAdapter.f282718g.l(1, r101.is_accessible())) + InaccessibleCode.ADAPTER.l(2, r101.getInaccessible_code());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void f(j0 r100, AccessMessage r101) {
                        AccessMessage r102 = r101;
                        Intrinsics.checkNotNullParameter(r100, "writer");
                        Intrinsics.checkNotNullParameter(r102, "value");
                        ProtoAdapter.f282718g.i(r100, 1, r102.is_accessible());
                        InaccessibleCode.ADAPTER.i(r100, 2, r102.getInaccessible_code());
                        r100.a(r102.unknownFields());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void g(n0 r100, AccessMessage r101) {
                        AccessMessage r102 = r101;
                        Intrinsics.checkNotNullParameter(r100, "writer");
                        Intrinsics.checkNotNullParameter(r102, "value");
                        r100.d(r102.unknownFields());
                        InaccessibleCode.ADAPTER.j(r100, 2, r102.getInaccessible_code());
                        ProtoAdapter.f282718g.j(r100, 1, r102.is_accessible());
                    }

                    public b(FieldEncoding r100, KClass<AccessMessage> r101, Syntax r102) {
                        super(r100, r101, "type.googleapis.com/basic.v1.Chatter.AccessInfo.AccessProfile.AccessMessage", r102, null);
                    }
                }

                public static final class c {
                    public c() {
                    }
                }

                public /* synthetic */ AccessMessage(a r100, ByteString r101, DefaultConstructorMarker r102) {
                    this(r100, r101);
                }

                static {
                    Companion = new c();
                    DEFAULT_INACCESSIBLE_CODE = InaccessibleCode.DEFAULT;
                    ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AccessMessage.class), Syntax.PROTO_2);
                }

                @Override // com.lark.wire.Message
                public a newBuilder() {
                    a r100 = new a();
                    r100.f279181d = this.is_accessible;
                    r100.f279182e = this.inaccessible_code;
                    r100.a(unknownFields());
                    return r100;
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

                public AccessMessage(a r100, ByteString r101) {
                    super(ADAPTER, r101);
                    this.is_accessible = r100.f279181d;
                    this.inaccessible_code = r100.f279182e;
                }

                public /* synthetic */ AccessMessage(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
                    if ((r102 & 2) == 0) goto L5;
                    r101 = ByteString.EMPTY;
                L5:
                    this(r100, r101);
                }
            }

            public static final class a extends com.lark.wire.Message.a<AccessProfile, a> {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public AccessMessage f279183d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public AccessMessage f279184e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public AccessMessage f279185f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public AccessMessage f279186g;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new AccessProfile(this, c(), null);
                }

                public a() {
                }
            }

            public static final class b extends ProtoAdapter<AccessProfile> {
                @Override // com.lark.wire.ProtoAdapter
                public final AccessProfile c(g0 r100) {
                    Intrinsics.checkNotNullParameter(r100, "reader");
                    a r101 = new a();
                    long r102 = r100.c();
                L3:
                    int r103 = r100.e();
                    if (r103 == (-1)) goto L19;
                    if (r103 != 1) goto L8;
                    r101.f279183d = AccessMessage.ADAPTER.c(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.f279184e = AccessMessage.ADAPTER.c(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.f279185f = AccessMessage.ADAPTER.c(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.f279186g = AccessMessage.ADAPTER.c(r100);
                    goto L3
                L13:
                    r100.j(r103);
                    Unit r104 = Unit.INSTANCE;
                    goto L3
                L19:
                    return new AccessProfile(r101, r100.d(r102), null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(AccessProfile r100) {
                    AccessProfile r101 = r100;
                    Intrinsics.checkNotNullParameter(r101, "value");
                    int r102 = r101.unknownFields().size();
                    ProtoAdapter<AccessMessage> r103 = AccessMessage.ADAPTER;
                    return (((r102 + r103.l(1, r101.getAccess_message_phone_call())) + r103.l(2, r101.getAccess_message_voice_call())) + r103.l(3, r101.getAccess_message_video_call())) + r103.l(4, r101.getAccess_message_urgent());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r100, AccessProfile r101) {
                    AccessProfile r102 = r101;
                    Intrinsics.checkNotNullParameter(r100, "writer");
                    Intrinsics.checkNotNullParameter(r102, "value");
                    ProtoAdapter<AccessMessage> r103 = AccessMessage.ADAPTER;
                    r103.i(r100, 1, r102.getAccess_message_phone_call());
                    r103.i(r100, 2, r102.getAccess_message_voice_call());
                    r103.i(r100, 3, r102.getAccess_message_video_call());
                    r103.i(r100, 4, r102.getAccess_message_urgent());
                    r100.a(r102.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r100, AccessProfile r101) {
                    AccessProfile r102 = r101;
                    Intrinsics.checkNotNullParameter(r100, "writer");
                    Intrinsics.checkNotNullParameter(r102, "value");
                    r100.d(r102.unknownFields());
                    ProtoAdapter<AccessMessage> r103 = AccessMessage.ADAPTER;
                    r103.j(r100, 4, r102.getAccess_message_urgent());
                    r103.j(r100, 3, r102.getAccess_message_video_call());
                    r103.j(r100, 2, r102.getAccess_message_voice_call());
                    r103.j(r100, 1, r102.getAccess_message_phone_call());
                }

                public b(FieldEncoding r100, KClass<AccessProfile> r101, Syntax r102) {
                    super(r100, r101, "type.googleapis.com/basic.v1.Chatter.AccessInfo.AccessProfile", r102, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ AccessProfile(a r100, ByteString r101, DefaultConstructorMarker r102) {
                this(r100, r101);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AccessProfile.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r100 = new a();
                r100.f279183d = this.access_message_phone_call;
                r100.f279184e = this.access_message_voice_call;
                r100.f279185f = this.access_message_video_call;
                r100.f279186g = this.access_message_urgent;
                r100.a(unknownFields());
                return r100;
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

            public AccessProfile(a r100, ByteString r101) {
                super(ADAPTER, r101);
                this.access_message_phone_call = r100.f279183d;
                this.access_message_voice_call = r100.f279184e;
                this.access_message_video_call = r100.f279185f;
                this.access_message_urgent = r100.f279186g;
            }

            public /* synthetic */ AccessProfile(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 2) == 0) goto L5;
                r101 = ByteString.EMPTY;
            L5:
                this(r100, r101);
            }
        }

        public static final class a extends com.lark.wire.Message.a<AccessInfo, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Boolean f279187d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Boolean f279188e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Boolean f279189f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public AccessProfile f279190g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new AccessInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<AccessInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final AccessInfo c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L19;
                if (r103 != 1) goto L8;
                r101.f279187d = (Boolean) ProtoAdapter.f282718g.c(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.f279188e = (Boolean) ProtoAdapter.f282718g.c(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.f279189f = (Boolean) ProtoAdapter.f282718g.c(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.f279190g = AccessProfile.ADAPTER.c(r100);
                goto L3
            L13:
                r100.j(r103);
                Unit r104 = Unit.INSTANCE;
                goto L3
            L19:
                return new AccessInfo(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(AccessInfo r100) {
                AccessInfo r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                int r102 = r101.unknownFields().size();
                l r103 = ProtoAdapter.f282718g;
                return (((r102 + r103.l(1, r101.getPhone_call())) + r103.l(2, r101.getVoice_call())) + r103.l(3, r101.getVideo_call())) + AccessProfile.ADAPTER.l(4, r101.getAccess_profile());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, AccessInfo r101) {
                AccessInfo r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                l r103 = ProtoAdapter.f282718g;
                r103.i(r100, 1, r102.getPhone_call());
                r103.i(r100, 2, r102.getVoice_call());
                r103.i(r100, 3, r102.getVideo_call());
                AccessProfile.ADAPTER.i(r100, 4, r102.getAccess_profile());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, AccessInfo r101) {
                AccessInfo r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                AccessProfile.ADAPTER.j(r100, 4, r102.getAccess_profile());
                l r103 = ProtoAdapter.f282718g;
                r103.j(r100, 3, r102.getVideo_call());
                r103.j(r100, 2, r102.getVoice_call());
                r103.j(r100, 1, r102.getPhone_call());
            }

            public b(FieldEncoding r100, KClass<AccessInfo> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chatter.AccessInfo", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ AccessInfo(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AccessInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279187d = this.phone_call;
            r100.f279188e = this.voice_call;
            r100.f279189f = this.video_call;
            r100.f279190g = this.access_profile;
            r100.a(unknownFields());
            return r100;
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

        public AccessInfo(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.phone_call = r100.f279187d;
            this.voice_call = r100.f279188e;
            this.video_call = r100.f279189f;
            this.access_profile = r100.f279190g;
        }

        public /* synthetic */ AccessInfo(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$BotMutedInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$BotMutedInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$BotMutedInfo$Builder;Lokio/ByteString;)V", "muted_scenes", "", "", "", "getMuted_scenes", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BotMutedInfo extends com.lark.wire.Message<BotMutedInfo, a> {
        public static final ProtoAdapter<BotMutedInfo> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, Boolean> muted_scenes;

        public static final class a extends com.lark.wire.Message.a<BotMutedInfo, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Map<String, Boolean> f279192d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new BotMutedInfo(this, c(), null);
            }

            public a() {
                this.f279192d = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ BotMutedInfo(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new b();
            final FieldEncoding r100 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r101 = Reflection.getOrCreateKotlinClass(BotMutedInfo.class);
            final Syntax r102 = Syntax.PROTO_2;
            ADAPTER = new Chatter$BotMutedInfo$Companion$ADAPTER$1(r100, r101, r102);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279192d = this.muted_scenes;
            r100.a(unknownFields());
            return r100;
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

        public BotMutedInfo(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.muted_scenes = com.lark.wire.internal.a.d("muted_scenes", r100.f279192d);
        }

        public /* synthetic */ BotMutedInfo(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001a\u001b\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$Builder;Lokio/ByteString;)V", "chat_id", "", "getChat_id", "()Ljava/lang/String;", "nick_name", "getNick_name", "oncall_role", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$OncallRole;", "getOncall_role", "()Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$OncallRole;", "nick_name_pinyin", "getNick_name_pinyin", "tag_infos", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo;", "getTag_infos", "()Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo;", "newBuilder", "toString", "Builder", "Companion", "OncallRole", "ChatChatterTagInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatExtra extends com.lark.wire.Message<ChatExtra, a> {
        public static final ProtoAdapter<ChatExtra> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String chat_id;
        private final String nick_name;
        private final String nick_name_pinyin;
        private final OncallRole oncall_role;
        private final ChatChatterTagInfo tag_infos;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0010\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$Builder;Lokio/ByteString;)V", PromotionProductPrivilegesStruct.TAGS, "", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo;", "getTags", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "TagInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ChatChatterTagInfo extends com.lark.wire.Message<ChatChatterTagInfo, a> {
            public static final ProtoAdapter<ChatChatterTagInfo> ADAPTER = null;
            public static final c Companion = null;
            private static final long serialVersionUID = 0;
            private final List<TagInfo> tags;

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0012\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo$Builder;Lokio/ByteString;)V", com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo$TagType;", "getTag_type", "()Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo$TagType;", "description", "", "getDescription", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "TagType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class TagInfo extends com.lark.wire.Message<TagInfo, a> {
                public static final ProtoAdapter<TagInfo> ADAPTER = null;
                public static final c Companion = null;
                private static final long serialVersionUID = 0;
                private final String description;
                private final TagType tag_type;

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$ChatChatterTagInfo$TagInfo$TagType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CLASS_TEACHER", "DISCIPLINE_TEACHER", "ADMIN_USER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
                public static final enum TagType extends Enum<TagType> implements o0 {
                    public static final ProtoAdapter<TagType> ADAPTER = null;
                    public static final TagType ADMIN_USER = null;
                    public static final TagType CLASS_TEACHER = null;
                    public static final b Companion = null;
                    public static final TagType DISCIPLINE_TEACHER = null;
                    public static final TagType UNKNOWN = null;

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ TagType[] f279193a = null;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public static final /* synthetic */ EnumEntries f279194b = null;
                    private final int value;

                    public static final class a extends d<TagType> {
                        @Override // com.lark.wire.d
                        public final o0 n(int r100) {
                            TagType.Companion.getClass();
                            if (r100 == 0) goto L15;
                            if (r100 == 1) goto L19;
                            if (r100 == 2) goto L18;
                            if (r100 == 3) goto L17;
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

                        public a(KClass<TagType> r100, Syntax r101, TagType r102) {
                            super(r100, r101, r102);
                        }
                    }

                    public static final class b {
                        public b() {
                        }
                    }

                    public static EnumEntries<TagType> getEntries() {
                        return f279194b;
                    }

                    static {
                        TagType r100 = new TagType("UNKNOWN", 0, 0);
                        UNKNOWN = r100;
                        TagType r101 = new TagType("CLASS_TEACHER", 1, 1);
                        CLASS_TEACHER = r101;
                        TagType r102 = new TagType("DISCIPLINE_TEACHER", 2, 2);
                        DISCIPLINE_TEACHER = r102;
                        TagType r103 = new TagType("ADMIN_USER", 3, 3);
                        ADMIN_USER = r103;
                        TagType[] r104 = {r100, r101, r102, r103};
                        f279193a = r104;
                        f279194b = EnumEntriesKt.enumEntries(r104);
                        Companion = new b();
                        ADAPTER = new a(Reflection.getOrCreateKotlinClass(TagType.class), Syntax.PROTO_2, r100);
                    }

                    public static TagType[] values() {
                        return (TagType[]) f279193a.clone();
                    }

                    @Override // com.lark.wire.o0
                    public int getValue() {
                        return this.value;
                    }

                    @JvmStatic
                    public static final TagType fromValue(int r100) {
                        Companion.getClass();
                        if (r100 == 0) goto L15;
                        if (r100 == 1) goto L19;
                        if (r100 == 2) goto L18;
                        if (r100 == 3) goto L17;
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

                    public static TagType valueOf(String r100) {
                        return (TagType) r27.a.a(TagType.class, r100);
                    }

                    public TagType(String r100, int r101, int r102) {
                        super(r100, r101);
                        this.value = r102;
                    }
                }

                public static final class a extends com.lark.wire.Message.a<TagInfo, a> {

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    public TagType f279195d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    public String f279196e;

                    @Override // com.lark.wire.Message.a
                    public final com.lark.wire.Message b() {
                        return new TagInfo(this, c(), null);
                    }

                    public a() {
                    }
                }

                public static final class b extends ProtoAdapter<TagInfo> {
                    @Override // com.lark.wire.ProtoAdapter
                    public final TagInfo c(g0 r110) {
                        Intrinsics.checkNotNullParameter(r110, "reader");
                        a r100 = new a();
                        long r101 = r110.c();
                    L3:
                        int r102 = r110.e();
                        if (r102 == (-1)) goto L16;
                        if (r102 != 1) goto L8;
                        r100.f279195d = TagType.ADAPTER.c(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
                    L13:
                        e = move-exception;
                        r110.a(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                        Unit r103 = Unit.INSTANCE;
                        goto L3
                    L8:
                        if (r102 != 2) goto L9;
                        ProtoAdapter.f282728q.getClass();
                        Intrinsics.checkNotNullParameter(r110, "reader");
                        r100.f279196e = r110.i();
                        goto L3
                    L9:
                        r110.j(r102);
                        goto L3
                    L16:
                        return new TagInfo(r100, r110.d(r101), null);
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final int k(TagInfo r100) {
                        TagInfo r101 = r100;
                        Intrinsics.checkNotNullParameter(r101, "value");
                        return (r101.unknownFields().size() + TagType.ADAPTER.l(1, r101.getTag_type())) + ProtoAdapter.f282728q.l(2, r101.getDescription());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void f(j0 r100, TagInfo r101) {
                        TagInfo r102 = r101;
                        Intrinsics.checkNotNullParameter(r100, "writer");
                        Intrinsics.checkNotNullParameter(r102, "value");
                        TagType.ADAPTER.i(r100, 1, r102.getTag_type());
                        ProtoAdapter.f282728q.i(r100, 2, r102.getDescription());
                        r100.a(r102.unknownFields());
                    }

                    @Override // com.lark.wire.ProtoAdapter
                    public final void g(n0 r100, TagInfo r101) {
                        TagInfo r102 = r101;
                        Intrinsics.checkNotNullParameter(r100, "writer");
                        Intrinsics.checkNotNullParameter(r102, "value");
                        r100.d(r102.unknownFields());
                        ProtoAdapter.f282728q.j(r100, 2, r102.getDescription());
                        TagType.ADAPTER.j(r100, 1, r102.getTag_type());
                    }

                    public b(FieldEncoding r100, KClass<TagInfo> r101, Syntax r102) {
                        super(r100, r101, "type.googleapis.com/basic.v1.Chatter.ChatExtra.ChatChatterTagInfo.TagInfo", r102, null);
                    }
                }

                public static final class c {
                    public c() {
                    }
                }

                public /* synthetic */ TagInfo(a r100, ByteString r101, DefaultConstructorMarker r102) {
                    this(r100, r101);
                }

                static {
                    Companion = new c();
                    ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TagInfo.class), Syntax.PROTO_2);
                }

                @Override // com.lark.wire.Message
                public a newBuilder() {
                    a r100 = new a();
                    r100.f279195d = this.tag_type;
                    r100.f279196e = this.description;
                    r100.a(unknownFields());
                    return r100;
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

                public TagInfo(a r100, ByteString r101) {
                    super(ADAPTER, r101);
                    this.tag_type = r100.f279195d;
                    this.description = r100.f279196e;
                }

                public /* synthetic */ TagInfo(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
                    if ((r102 & 2) == 0) goto L5;
                    r101 = ByteString.EMPTY;
                L5:
                    this(r100, r101);
                }
            }

            public static final class a extends com.lark.wire.Message.a<ChatChatterTagInfo, a> {

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public List<TagInfo> f279197d;

                @Override // com.lark.wire.Message.a
                public final com.lark.wire.Message b() {
                    return new ChatChatterTagInfo(this, c(), null);
                }

                public a() {
                    this.f279197d = CollectionsKt.emptyList();
                }
            }

            public static final class b extends ProtoAdapter<ChatChatterTagInfo> {
                @Override // com.lark.wire.ProtoAdapter
                public final ChatChatterTagInfo c(g0 r100) {
                    Intrinsics.checkNotNullParameter(r100, "reader");
                    a r101 = new a();
                    ArrayList r102 = new ArrayList();
                    long r103 = r100.c();
                L3:
                    int r104 = r100.e();
                    if (r104 == (-1)) goto L9;
                    if (r104 == 1) goto L7;
                    r100.j(r104);
                    goto L3
                L7:
                    r102.add(TagInfo.ADAPTER.c(r100));
                    goto L3
                L9:
                    ByteString r105 = r100.d(r103);
                    Intrinsics.checkNotNullParameter(r102, PromotionProductPrivilegesStruct.TAGS);
                    com.lark.wire.internal.a.a(r102);
                    r101.f279197d = r102;
                    return new ChatChatterTagInfo(r101, r105, null);
                }

                @Override // com.lark.wire.ProtoAdapter
                public final int k(ChatChatterTagInfo r100) {
                    ChatChatterTagInfo r101 = r100;
                    Intrinsics.checkNotNullParameter(r101, "value");
                    return r101.unknownFields().size() + TagInfo.ADAPTER.a().l(1, r101.getTags());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void f(j0 r100, ChatChatterTagInfo r101) {
                    ChatChatterTagInfo r102 = r101;
                    Intrinsics.checkNotNullParameter(r100, "writer");
                    Intrinsics.checkNotNullParameter(r102, "value");
                    TagInfo.ADAPTER.a().i(r100, 1, r102.getTags());
                    r100.a(r102.unknownFields());
                }

                @Override // com.lark.wire.ProtoAdapter
                public final void g(n0 r100, ChatChatterTagInfo r101) {
                    ChatChatterTagInfo r102 = r101;
                    Intrinsics.checkNotNullParameter(r100, "writer");
                    Intrinsics.checkNotNullParameter(r102, "value");
                    r100.d(r102.unknownFields());
                    TagInfo.ADAPTER.a().j(r100, 1, r102.getTags());
                }

                public b(FieldEncoding r100, KClass<ChatChatterTagInfo> r101, Syntax r102) {
                    super(r100, r101, "type.googleapis.com/basic.v1.Chatter.ChatExtra.ChatChatterTagInfo", r102, null);
                }
            }

            public static final class c {
                public c() {
                }
            }

            public /* synthetic */ ChatChatterTagInfo(a r100, ByteString r101, DefaultConstructorMarker r102) {
                this(r100, r101);
            }

            static {
                Companion = new c();
                ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatChatterTagInfo.class), Syntax.PROTO_2);
            }

            @Override // com.lark.wire.Message
            public a newBuilder() {
                a r100 = new a();
                r100.f279197d = this.tags;
                r100.a(unknownFields());
                return r100;
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

            public ChatChatterTagInfo(a r100, ByteString r101) {
                super(ADAPTER, r101);
                this.tags = com.lark.wire.internal.a.c(PromotionProductPrivilegesStruct.TAGS, r100.f279197d);
            }

            public /* synthetic */ ChatChatterTagInfo(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 2) == 0) goto L5;
                r101 = ByteString.EMPTY;
            L5:
                this(r100, r101);
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatExtra$OncallRole;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "ONCALL", "ONCALL_HELPER", "USER_HELPER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum OncallRole extends Enum<OncallRole> implements o0 {
            public static final ProtoAdapter<OncallRole> ADAPTER = null;
            public static final b Companion = null;
            public static final OncallRole ONCALL = null;
            public static final OncallRole ONCALL_HELPER = null;
            public static final OncallRole UNKNOWN = null;
            public static final OncallRole USER = null;
            public static final OncallRole USER_HELPER = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ OncallRole[] f279198a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279199b = null;
            private final int value;

            public static final class a extends d<OncallRole> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    OncallRole.Companion.getClass();
                    return b.a(r100);
                }

                public a(KClass<OncallRole> r100, Syntax r101, OncallRole r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }

                @JvmStatic
                public static OncallRole a(int r100) {
                    if (r100 == 0) goto L17;
                    if (r100 == 3) goto L22;
                    if (r100 == 4) goto L21;
                    if (r100 == 5) goto L20;
                    if (r100 == 6) goto L19;
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
            public static final OncallRole fromValue(int r100) {
                Companion.getClass();
                return b.a(r100);
            }

            public static EnumEntries<OncallRole> getEntries() {
                return f279199b;
            }

            static {
                OncallRole r100 = new OncallRole("UNKNOWN", 0, 0);
                UNKNOWN = r100;
                OncallRole r101 = new OncallRole(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 3);
                USER = r101;
                OncallRole r102 = new OncallRole("ONCALL", 2, 4);
                ONCALL = r102;
                OncallRole r103 = new OncallRole("ONCALL_HELPER", 3, 5);
                ONCALL_HELPER = r103;
                OncallRole r104 = new OncallRole("USER_HELPER", 4, 6);
                USER_HELPER = r104;
                OncallRole[] r110 = {r100, r101, r102, r103, r104};
                f279198a = r110;
                f279199b = EnumEntriesKt.enumEntries(r110);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(OncallRole.class), Syntax.PROTO_2, r100);
            }

            public static OncallRole[] values() {
                return (OncallRole[]) f279198a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            public static OncallRole valueOf(String r100) {
                return (OncallRole) r27.a.a(OncallRole.class, r100);
            }

            public OncallRole(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<ChatExtra, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f279200d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f279201e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public OncallRole f279202f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public String f279203g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public ChatChatterTagInfo f279204h;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatExtra(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ChatExtra> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChatExtra c(g0 r110) {
                Intrinsics.checkNotNullParameter(r110, "reader");
                a r100 = new a();
                long r101 = r110.c();
            L3:
                int r102 = r110.e();
                if (r102 == (-1)) goto L25;
                if (r102 != 1) goto L8;
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r110, "reader");
                String r103 = r110.i();
                Intrinsics.checkNotNullParameter(r103, "chat_id");
                r100.f279200d = r103;
                goto L3
            L8:
                if (r102 != 2) goto L10;
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r110, "reader");
                r100.f279201e = r110.i();
                goto L3
            L10:
                if (r102 != 3) goto L12;
                r100.f279202f = OncallRole.ADAPTER.c(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r110.a(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r104 = Unit.INSTANCE;
                goto L3
            L12:
                if (r102 != 4) goto L14;
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r110, "reader");
                r100.f279203g = r110.i();
                goto L3
            L14:
                if (r102 != 5) goto L15;
                r100.f279204h = ChatChatterTagInfo.ADAPTER.c(r110);
                goto L3
            L15:
                r110.j(r102);
                Unit r105 = Unit.INSTANCE;
                goto L3
            L25:
                return new ChatExtra(r100, r110.d(r101), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatExtra r100) {
                ChatExtra r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                int r102 = r101.unknownFields().size();
                w r103 = ProtoAdapter.f282728q;
                return ((((r102 + r103.l(1, r101.getChat_id())) + r103.l(2, r101.getNick_name())) + OncallRole.ADAPTER.l(3, r101.getOncall_role())) + r103.l(4, r101.getNick_name_pinyin())) + ChatChatterTagInfo.ADAPTER.l(5, r101.getTag_infos());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, ChatExtra r101) {
                ChatExtra r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                w r103 = ProtoAdapter.f282728q;
                r103.i(r100, 1, r102.getChat_id());
                r103.i(r100, 2, r102.getNick_name());
                OncallRole.ADAPTER.i(r100, 3, r102.getOncall_role());
                r103.i(r100, 4, r102.getNick_name_pinyin());
                ChatChatterTagInfo.ADAPTER.i(r100, 5, r102.getTag_infos());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, ChatExtra r101) {
                ChatExtra r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                ChatChatterTagInfo.ADAPTER.j(r100, 5, r102.getTag_infos());
                w r103 = ProtoAdapter.f282728q;
                r103.j(r100, 4, r102.getNick_name_pinyin());
                OncallRole.ADAPTER.j(r100, 3, r102.getOncall_role());
                r103.j(r100, 2, r102.getNick_name());
                r103.j(r100, 1, r102.getChat_id());
            }

            public b(FieldEncoding r100, KClass<ChatExtra> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chatter.ChatExtra", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatExtra(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatExtra.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279200d = this.chat_id;
            r100.f279201e = this.nick_name;
            r100.f279202f = this.oncall_role;
            r100.f279203g = this.nick_name_pinyin;
            r100.f279204h = this.tag_infos;
            r100.a(unknownFields());
            return r100;
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

        public ChatExtra(a r100, ByteString r101) {
            super(ADAPTER, r101);
            String r102 = r100.f279200d;
            Intrinsics.checkNotNull(r102);
            this.chat_id = r102;
            this.nick_name = r100.f279201e;
            this.oncall_role = r100.f279202f;
            this.nick_name_pinyin = r100.f279203g;
            this.tag_infos = r100.f279204h;
        }

        public /* synthetic */ ChatExtra(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002'(B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010%\u001a\u00020\u0002H\u0016J\b\u0010&\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0010\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$ChatterCustomStatus;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$ChatterCustomStatus$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$ChatterCustomStatus$Builder;Lokio/ByteString;)V", "title", "", "getTitle", "()Ljava/lang/String;", "icon_key", "getIcon_key", "fs_unit", "getFs_unit", "is_not_disturb_mode", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "effective_interval", "Lcom/lark/kmp/pb/basic/v1/StatusEffectiveInterval;", "getEffective_interval", "()Lcom/lark/kmp/pb/basic/v1/StatusEffectiveInterval;", "tag_info", "Lcom/lark/kmp/pb/basic/v1/TagInfo;", "getTag_info", "()Lcom/lark/kmp/pb/basic/v1/TagInfo;", "time_format", "Lcom/lark/kmp/pb/basic/v1/TimeFormat;", "getTime_format", "()Lcom/lark/kmp/pb/basic/v1/TimeFormat;", "status_id", "", "getStatus_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f279205d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f279206e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public String f279207f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Boolean f279208g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public StatusEffectiveInterval f279209h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public TagInfo f279210i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public TimeFormat f279211j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public Long f279212k;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatterCustomStatus(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ChatterCustomStatus> {
            @Override // com.lark.wire.ProtoAdapter
            public final ChatterCustomStatus c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L16;
                switch(r103) {
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
                r101.f279212k = (Long) ProtoAdapter.f282722k.c(r100);
                goto L3
            L8:
                r101.f279211j = TimeFormat.ADAPTER.c(r100);
                goto L3
            L9:
                r101.f279210i = TagInfo.ADAPTER.c(r100);
                goto L3
            L10:
                r101.f279209h = StatusEffectiveInterval.ADAPTER.c(r100);
                goto L3
            L11:
                r101.f279208g = (Boolean) ProtoAdapter.f282718g.c(r100);
                goto L3
            L12:
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                r101.f279207f = r100.i();
                goto L3
            L13:
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                r101.f279206e = r100.i();
                goto L3
            L14:
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                r101.f279205d = r100.i();
                goto L3
            L6:
                r100.j(r103);
                Unit r104 = Unit.INSTANCE;
                goto L3
            L16:
                return new ChatterCustomStatus(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ChatterCustomStatus r100) {
                ChatterCustomStatus r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                int r102 = r101.unknownFields().size();
                w r103 = ProtoAdapter.f282728q;
                return (((((((r102 + r103.l(1, r101.getTitle())) + r103.l(2, r101.getIcon_key())) + r103.l(3, r101.getFs_unit())) + ProtoAdapter.f282718g.l(4, r101.is_not_disturb_mode())) + StatusEffectiveInterval.ADAPTER.l(5, r101.getEffective_interval())) + TagInfo.ADAPTER.l(6, r101.getTag_info())) + TimeFormat.ADAPTER.l(7, r101.getTime_format())) + ProtoAdapter.f282722k.l(8, r101.getStatus_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, ChatterCustomStatus r101) {
                ChatterCustomStatus r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                w r103 = ProtoAdapter.f282728q;
                r103.i(r100, 1, r102.getTitle());
                r103.i(r100, 2, r102.getIcon_key());
                r103.i(r100, 3, r102.getFs_unit());
                ProtoAdapter.f282718g.i(r100, 4, r102.is_not_disturb_mode());
                StatusEffectiveInterval.ADAPTER.i(r100, 5, r102.getEffective_interval());
                TagInfo.ADAPTER.i(r100, 6, r102.getTag_info());
                TimeFormat.ADAPTER.i(r100, 7, r102.getTime_format());
                ProtoAdapter.f282722k.i(r100, 8, r102.getStatus_id());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, ChatterCustomStatus r101) {
                ChatterCustomStatus r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                ProtoAdapter.f282722k.j(r100, 8, r102.getStatus_id());
                TimeFormat.ADAPTER.j(r100, 7, r102.getTime_format());
                TagInfo.ADAPTER.j(r100, 6, r102.getTag_info());
                StatusEffectiveInterval.ADAPTER.j(r100, 5, r102.getEffective_interval());
                ProtoAdapter.f282718g.j(r100, 4, r102.is_not_disturb_mode());
                w r103 = ProtoAdapter.f282728q;
                r103.j(r100, 3, r102.getFs_unit());
                r103.j(r100, 2, r102.getIcon_key());
                r103.j(r100, 1, r102.getTitle());
            }

            public b(FieldEncoding r100, KClass<ChatterCustomStatus> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chatter.ChatterCustomStatus", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ChatterCustomStatus(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ChatterCustomStatus.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279205d = this.title;
            r100.f279206e = this.icon_key;
            r100.f279207f = this.fs_unit;
            r100.f279208g = this.is_not_disturb_mode;
            r100.f279209h = this.effective_interval;
            r100.f279210i = this.tag_info;
            r100.f279211j = this.time_format;
            r100.f279212k = this.status_id;
            r100.a(unknownFields());
            return r100;
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

        public ChatterCustomStatus(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.title = r100.f279205d;
            this.icon_key = r100.f279206e;
            this.fs_unit = r100.f279207f;
            this.is_not_disturb_mode = r100.f279208g;
            this.effective_interval = r100.f279209h;
            this.tag_info = r100.f279210i;
            this.time_format = r100.f279211j;
            this.status_id = r100.f279212k;
        }

        public /* synthetic */ ChatterCustomStatus(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$Description;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$Description$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$Description$Builder;Lokio/ByteString;)V", "text", "", "getText", "()Ljava/lang/String;", "type", "Lcom/lark/kmp/pb/basic/v1/Chatter$Description$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Chatter$Description$Type;", "description_id", "", "getDescription_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "newBuilder", "toString", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Description extends com.lark.wire.Message<Description, a> {
        public static final ProtoAdapter<Description> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Long description_id;
        private final String text;
        private final Type type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$Description$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ON_DEFAULT", "ON_BUSINESS", "ON_LEAVE", "ON_MEETING", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Type extends Enum<Type> implements o0 {
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final b Companion = null;
            public static final Type ON_BUSINESS = null;
            public static final Type ON_DEFAULT = null;
            public static final Type ON_LEAVE = null;
            public static final Type ON_MEETING = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Type[] f279213a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f279214b = null;
            private final int value;

            public static final class a extends d<Type> {
                @Override // com.lark.wire.d
                public final o0 n(int r100) {
                    Type.Companion.getClass();
                    if (r100 == 0) goto L15;
                    if (r100 == 1) goto L19;
                    if (r100 == 2) goto L18;
                    if (r100 == 3) goto L17;
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

                public a(KClass<Type> r100, Syntax r101, Type r102) {
                    super(r100, r101, r102);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<Type> getEntries() {
                return f279214b;
            }

            static {
                Type r100 = new Type("ON_DEFAULT", 0, 0);
                ON_DEFAULT = r100;
                Type r101 = new Type("ON_BUSINESS", 1, 1);
                ON_BUSINESS = r101;
                Type r102 = new Type("ON_LEAVE", 2, 2);
                ON_LEAVE = r102;
                Type r103 = new Type("ON_MEETING", 3, 3);
                ON_MEETING = r103;
                Type[] r104 = {r100, r101, r102, r103};
                f279213a = r104;
                f279214b = EnumEntriesKt.enumEntries(r104);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r100);
            }

            public static Type[] values() {
                return (Type[]) f279213a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final Type fromValue(int r100) {
                Companion.getClass();
                if (r100 == 0) goto L15;
                if (r100 == 1) goto L19;
                if (r100 == 2) goto L18;
                if (r100 == 3) goto L17;
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

            public static Type valueOf(String r100) {
                return (Type) r27.a.a(Type.class, r100);
            }

            public Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public static final class a extends com.lark.wire.Message.a<Description, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f279215d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Type f279216e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Long f279217f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Description(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Description> {
            @Override // com.lark.wire.ProtoAdapter
            public final Description c(g0 r110) {
                Intrinsics.checkNotNullParameter(r110, "reader");
                a r100 = new a();
                long r101 = r110.c();
            L3:
                int r102 = r110.e();
                if (r102 == (-1)) goto L19;
                if (r102 != 1) goto L8;
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r110, "reader");
                r100.f279215d = r110.i();
                goto L3
            L8:
                if (r102 != 2) goto L10;
                r100.f279216e = Type.ADAPTER.c(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r110.a(r102, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r103 = Unit.INSTANCE;
                goto L3
            L10:
                if (r102 != 3) goto L11;
                r100.f279217f = (Long) ProtoAdapter.f282722k.c(r110);
                goto L3
            L11:
                r110.j(r102);
                goto L3
            L19:
                return new Description(r100, r110.d(r101), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Description r100) {
                Description r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return ((r101.unknownFields().size() + ProtoAdapter.f282728q.l(1, r101.getText())) + Type.ADAPTER.l(2, r101.getType())) + ProtoAdapter.f282722k.l(3, r101.getDescription_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, Description r101) {
                Description r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                ProtoAdapter.f282728q.i(r100, 1, r102.getText());
                Type.ADAPTER.i(r100, 2, r102.getType());
                ProtoAdapter.f282722k.i(r100, 3, r102.getDescription_id());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, Description r101) {
                Description r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                ProtoAdapter.f282722k.j(r100, 3, r102.getDescription_id());
                Type.ADAPTER.j(r100, 2, r102.getType());
                ProtoAdapter.f282728q.j(r100, 1, r102.getText());
            }

            public b(FieldEncoding r100, KClass<Description> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chatter.Description", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Description(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Description.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279215d = this.text;
            r100.f279216e = this.type;
            r100.f279217f = this.description_id;
            r100.a(unknownFields());
            return r100;
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

        public Description(a r100, ByteString r101) {
            super(ADAPTER, r101);
            this.text = r100.f279215d;
            this.type = r100.f279216e;
            this.description_id = r100.f279217f;
        }

        public /* synthetic */ Description(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$TimeZone;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Chatter$TimeZone$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Chatter$TimeZone$Builder;Lokio/ByteString;)V", "time_zone_id", "", "getTime_zone_id", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TimeZone extends com.lark.wire.Message<TimeZone, a> {
        public static final ProtoAdapter<TimeZone> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String time_zone_id;

        public static final class a extends com.lark.wire.Message.a<TimeZone, a> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f279218d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new TimeZone(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<TimeZone> {
            @Override // com.lark.wire.ProtoAdapter
            public final TimeZone c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                a r101 = new a();
                long r102 = r100.c();
            L3:
                int r103 = r100.e();
                if (r103 == (-1)) goto L10;
                if (r103 == 1) goto L7;
                r100.j(r103);
                goto L3
            L7:
                ProtoAdapter.f282728q.getClass();
                Intrinsics.checkNotNullParameter(r100, "reader");
                String r104 = r100.i();
                Intrinsics.checkNotNullParameter(r104, "time_zone_id");
                r101.f279218d = r104;
                goto L3
            L10:
                return new TimeZone(r101, r100.d(r102), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(TimeZone r100) {
                TimeZone r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "value");
                return r101.unknownFields().size() + ProtoAdapter.f282728q.l(1, r101.getTime_zone_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, TimeZone r101) {
                TimeZone r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                ProtoAdapter.f282728q.i(r100, 1, r102.getTime_zone_id());
                r100.a(r102.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, TimeZone r101) {
                TimeZone r102 = r101;
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter(r102, "value");
                r100.d(r102.unknownFields());
                ProtoAdapter.f282728q.j(r100, 1, r102.getTime_zone_id());
            }

            public b(FieldEncoding r100, KClass<TimeZone> r101, Syntax r102) {
                super(r100, r101, "type.googleapis.com/basic.v1.Chatter.TimeZone", r102, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ TimeZone(a r100, ByteString r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TimeZone.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r100 = new a();
            r100.f279218d = this.time_zone_id;
            r100.a(unknownFields());
            return r100;
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

        public TimeZone(a r100, ByteString r101) {
            super(ADAPTER, r101);
            String r102 = r100.f279218d;
            Intrinsics.checkNotNull(r102);
            this.time_zone_id = r102;
        }

        public /* synthetic */ TimeZone(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = ByteString.EMPTY;
        L5:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Chatter$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "BOT", "AI", "DOUBAO", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AI = null;
        public static final Type BOT = null;
        public static final b Companion = null;
        public static final Type DOUBAO = null;
        public static final Type UNKNOWN = null;
        public static final Type USER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f279219a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f279220b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r100) {
                Type.Companion.getClass();
                return b.a(r100);
            }

            public a(KClass<Type> r100, Syntax r101, Type r102) {
                super(r100, r101, r102);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r100) {
                if (r100 == 0) goto L17;
                if (r100 == 1) goto L22;
                if (r100 == 2) goto L21;
                if (r100 == 3) goto L20;
                if (r100 == 4) goto L19;
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
        public static final Type fromValue(int r100) {
            Companion.getClass();
            return b.a(r100);
        }

        public static EnumEntries<Type> getEntries() {
            return f279220b;
        }

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            Type r102 = new Type("BOT", 2, 2);
            BOT = r102;
            Type r103 = new Type("AI", 3, 3);
            AI = r103;
            Type r104 = new Type("DOUBAO", 4, 4);
            DOUBAO = r104;
            Type[] r105 = {r100, r101, r102, r103, r104};
            f279219a = r105;
            f279220b = EnumEntriesKt.enumEntries(r105);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r100);
        }

        public static Type[] values() {
            return (Type[]) f279219a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
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

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public String f279221J;
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

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public List<? extends Tag> f279222a0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f279223d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f279224e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Type f279225f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ImageSet f279226g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Long f279227h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f279228i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f279229j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Boolean f279230k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Boolean f279231l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f279232m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Description f279233n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f279234o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f279235p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f279236q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f279237r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public WorkStatus f279238s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Boolean f279239t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f279240u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public AccessInfo f279241v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f279242w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f279243x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public String f279244y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public Long f279245z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Chatter(this, c(), null);
        }

        public a() {
            this.A = CollectionsKt.emptyList();
            this.P = CollectionsKt.emptyList();
            this.X = CollectionsKt.emptyList();
            this.f279222a0 = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Chatter> {
        @Override // com.lark.wire.ProtoAdapter
        public final Chatter c(g0 r110) {
            Intrinsics.checkNotNullParameter(r110, "reader");
            a r100 = new a();
            ArrayList r101 = new ArrayList();
            ArrayList r102 = new ArrayList();
            ArrayList r103 = new ArrayList();
            ArrayList r104 = new ArrayList();
            long r105 = r110.c();
        L3:
            int r106 = r110.e();
            if (r106 == (-1)) goto L81;
            if (r106 != 36) goto L8;
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.L = r110.i();
            goto L3
        L8:
            if (r106 != 37) goto L10;
            r100.M = (Long) ProtoAdapter.f282722k.c(r110);
            goto L3
        L10:
            if (r106 != 150) goto L12;
            r103.add(ChatterCustomStatus.ADAPTER.c(r110));
            goto L3
        L12:
            if (r106 != 200) goto L14;
            Tag.ADAPTER.m(r110, r104);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L75
        L77:
            Unit r107 = Unit.INSTANCE;
        L75:
            e = move-exception;
            r110.a(r106, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L77
        L14:
            if (r106 != 1000) goto L16;
            r100.Y = ChatExtra.ADAPTER.c(r110);
            goto L3
        L16:
            if (r106 != 1001) goto L17;
            r100.Z = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L17:
            switch(r106) {
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
            Type r108 = Type.ADAPTER.c(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L54
            Intrinsics.checkNotNullParameter(r108, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L54
            r100.f279225f = r108;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L54
        L54:
            e = move-exception;
            r110.a(r106, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r109 = Unit.INSTANCE;
            goto L3
        L21:
            r100.K = TagData.ADAPTER.c(r110);
            goto L3
        L22:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279221J = r110.i();
            goto L3
        L23:
            r100.I = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L24:
            r100.H = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L25:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.G = r110.i();
            goto L3
        L26:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.F = r110.i();
            goto L3
        L27:
            r100.E = AvatarMedal.ADAPTER.c(r110);
            goto L3
        L28:
            r100.D = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L29:
            r100.C = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L30:
            r100.B = TimeZone.ADAPTER.c(r110);
            goto L3
        L31:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r101.add(r110.i());
            goto L3
        L32:
            r100.f279245z = (Long) ProtoAdapter.f282722k.c(r110);
            goto L3
        L33:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279244y = r110.i();
            goto L3
        L34:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279243x = r110.i();
            goto L3
        L35:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279242w = r110.i();
            goto L3
        L36:
            r100.f279241v = AccessInfo.ADAPTER.c(r110);
            goto L3
        L37:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279240u = r110.i();
            goto L3
        L38:
            r100.f279239t = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L39:
            r100.f279238s = WorkStatus.ADAPTER.c(r110);
            goto L3
        L40:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279237r = r110.i();
            goto L3
        L41:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279236q = r110.i();
            goto L3
        L42:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279235p = r110.i();
            goto L3
        L43:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279234o = r110.i();
            goto L3
        L44:
            r100.f279233n = Description.ADAPTER.c(r110);
            goto L3
        L45:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279232m = r110.i();
            goto L3
        L46:
            r100.f279231l = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L47:
            r100.f279230k = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L48:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.f279229j = r110.i();
            goto L3
        L49:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            String r111 = r110.i();
            Intrinsics.checkNotNullParameter(r111, "name_pinyin");
            r100.f279228i = r111;
            goto L3
        L50:
            r100.f279227h = Long.valueOf(((Number) ProtoAdapter.f282722k.c(r110)).longValue());
            goto L3
        L51:
            r100.f279226g = ImageSet.ADAPTER.c(r110);
            goto L3
        L56:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            String r112 = r110.i();
            Intrinsics.checkNotNullParameter(r112, "name");
            r100.f279224e = r112;
            goto L3
        L57:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            String r113 = r110.i();
            Intrinsics.checkNotNullParameter(r113, "id");
            r100.f279223d = r113;
            goto L3
        L18:
            switch(r106) {
                case 45: goto L63;
                case 46: goto L83;
                case 47: goto L58;
                default: goto L19;
            };
        L83:
            r100.O = TenantNameStatus.ADAPTER.c(r110);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L61
        L61:
            e = move-exception;
            r110.a(r106, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r114 = Unit.INSTANCE;
            goto L3
        L58:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r102.add(r110.i());
            goto L3
        L63:
            r100.N = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L19:
            switch(r106) {
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
            r100.W = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L65:
            r100.V = (Integer) ProtoAdapter.f282719h.c(r110);
            goto L3
        L66:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.U = r110.i();
            goto L3
        L67:
            r100.T = BotMutedInfo.ADAPTER.c(r110);
            goto L3
        L68:
            r100.S = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L69:
            r100.R = (Boolean) ProtoAdapter.f282718g.c(r110);
            goto L3
        L70:
            ProtoAdapter.f282728q.getClass();
            Intrinsics.checkNotNullParameter(r110, "reader");
            r100.Q = r110.i();
            goto L3
        L20:
            r110.j(r106);
            Unit r115 = Unit.INSTANCE;
            goto L3
        L81:
            ByteString r116 = r110.d(r105);
            Intrinsics.checkNotNullParameter(r101, "avatar_urls");
            com.lark.wire.internal.a.a(r101);
            r100.A = r101;
            Intrinsics.checkNotNullParameter(r102, "common_locales");
            com.lark.wire.internal.a.a(r102);
            r100.P = r102;
            Intrinsics.checkNotNullParameter(r103, "status");
            com.lark.wire.internal.a.a(r103);
            r100.X = r103;
            Intrinsics.checkNotNullParameter(r104, PromotionProductPrivilegesStruct.TAGS);
            com.lark.wire.internal.a.a(r104);
            r100.f279222a0 = r104;
            return new Chatter(r100, r116, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Chatter r100) {
            Chatter r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "value");
            int r102 = r101.unknownFields().size();
            w r103 = ProtoAdapter.f282728q;
            int r104 = (((r102 + r103.l(1, r101.getId())) + r103.l(2, r101.getName())) + Type.ADAPTER.l(3, r101.getType())) + ImageSet.ADAPTER.l(4, r101.getAvatar());
            t r105 = ProtoAdapter.f282722k;
            int r106 = ((r104 + r105.l(5, Long.valueOf(r101.getUpdate_time()))) + r103.l(6, r101.getName_pinyin())) + r103.l(7, r101.getCreator_id());
            l r107 = ProtoAdapter.f282718g;
            return ((((((((((((((((((((((((((((((((((((((((((r106 + r107.l(8, r101.is_resigned())) + r107.l(9, r101.is_registered())) + r103.l(10, r101.getEn_us_name())) + Description.ADAPTER.l(11, r101.getDescription())) + r103.l(12, r101.getAvatar_key())) + r103.l(13, r101.getTenant_id())) + r103.l(14, r101.getLocalized_name())) + r103.l(15, r101.getAlias())) + WorkStatus.ADAPTER.l(16, r101.getWork_status())) + r107.l(17, r101.getProfile_enabled())) + r103.l(18, r101.getAccount_id())) + AccessInfo.ADAPTER.l(19, r101.getAccess_info())) + r103.l(20, r101.getOpen_app_id())) + r103.l(21, r101.getAvatar_path())) + r103.l(22, r101.getEmail())) + r105.l(23, r101.getDo_not_disturb_end_time())) + r103.a().l(24, r101.getAvatar_urls())) + TimeZone.ADAPTER.l(25, r101.getTime_zone())) + r107.l(26, r101.is_frozen())) + r107.l(27, r101.is_anonymous())) + AvatarMedal.ADAPTER.l(28, r101.getAvatar_medal())) + r103.l(29, r101.getName_with_another_name())) + r103.l(30, r101.getAnother_name())) + r107.l(31, r101.is_default_avatar())) + r107.l(32, r101.is_special_focus())) + r103.l(33, r101.getMajor_language())) + TagData.ADAPTER.l(34, r101.getTag_info())) + r103.l(36, r101.getPrivate_description())) + r105.l(37, r101.getPrivate_description_id())) + r107.l(45, r101.is_tenant_certification())) + TenantNameStatus.ADAPTER.l(46, r101.getTenant_name_status())) + r103.a().l(47, r101.getCommon_locales())) + r103.l(100, r101.getWith_bot_tag())) + r107.l(101, r101.getIn_contacts())) + r107.l(102, r101.getCan_join_group())) + BotMutedInfo.ADAPTER.l(103, r101.getMuted_info())) + r103.l(104, r101.getChat_chatter_list_department_name())) + ProtoAdapter.f282719h.l(105, r101.getBot_ext_type())) + r107.l(106, r101.is_agent())) + ChatterCustomStatus.ADAPTER.a().l(150, r101.getStatus())) + ChatExtra.ADAPTER.l(1000, r101.getChat_extra())) + r107.l(1001, r101.getAccept_sms_phone_urgent())) + Tag.ADAPTER.a().l(200, r101.getTags());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r100, Chatter r101) {
            Chatter r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            Intrinsics.checkNotNullParameter(r102, "value");
            w r103 = ProtoAdapter.f282728q;
            r103.i(r100, 1, r102.getId());
            r103.i(r100, 2, r102.getName());
            Type.ADAPTER.i(r100, 3, r102.getType());
            ImageSet.ADAPTER.i(r100, 4, r102.getAvatar());
            t r104 = ProtoAdapter.f282722k;
            r104.i(r100, 5, Long.valueOf(r102.getUpdate_time()));
            r103.i(r100, 6, r102.getName_pinyin());
            r103.i(r100, 7, r102.getCreator_id());
            l r105 = ProtoAdapter.f282718g;
            r105.i(r100, 8, r102.is_resigned());
            r105.i(r100, 9, r102.is_registered());
            r103.i(r100, 10, r102.getEn_us_name());
            Description.ADAPTER.i(r100, 11, r102.getDescription());
            r103.i(r100, 12, r102.getAvatar_key());
            r103.i(r100, 13, r102.getTenant_id());
            r103.i(r100, 14, r102.getLocalized_name());
            r103.i(r100, 15, r102.getAlias());
            WorkStatus.ADAPTER.i(r100, 16, r102.getWork_status());
            r105.i(r100, 17, r102.getProfile_enabled());
            r103.i(r100, 18, r102.getAccount_id());
            AccessInfo.ADAPTER.i(r100, 19, r102.getAccess_info());
            r103.i(r100, 20, r102.getOpen_app_id());
            r103.i(r100, 21, r102.getAvatar_path());
            r103.i(r100, 22, r102.getEmail());
            r104.i(r100, 23, r102.getDo_not_disturb_end_time());
            r103.a().i(r100, 24, r102.getAvatar_urls());
            TimeZone.ADAPTER.i(r100, 25, r102.getTime_zone());
            r105.i(r100, 26, r102.is_frozen());
            r105.i(r100, 27, r102.is_anonymous());
            AvatarMedal.ADAPTER.i(r100, 28, r102.getAvatar_medal());
            r103.i(r100, 29, r102.getName_with_another_name());
            r103.i(r100, 30, r102.getAnother_name());
            r105.i(r100, 31, r102.is_default_avatar());
            r105.i(r100, 32, r102.is_special_focus());
            r103.i(r100, 33, r102.getMajor_language());
            TagData.ADAPTER.i(r100, 34, r102.getTag_info());
            r103.i(r100, 36, r102.getPrivate_description());
            r104.i(r100, 37, r102.getPrivate_description_id());
            r105.i(r100, 45, r102.is_tenant_certification());
            TenantNameStatus.ADAPTER.i(r100, 46, r102.getTenant_name_status());
            r103.a().i(r100, 47, r102.getCommon_locales());
            r103.i(r100, 100, r102.getWith_bot_tag());
            r105.i(r100, 101, r102.getIn_contacts());
            r105.i(r100, 102, r102.getCan_join_group());
            BotMutedInfo.ADAPTER.i(r100, 103, r102.getMuted_info());
            r103.i(r100, 104, r102.getChat_chatter_list_department_name());
            ProtoAdapter.f282719h.i(r100, 105, r102.getBot_ext_type());
            r105.i(r100, 106, r102.is_agent());
            ChatterCustomStatus.ADAPTER.a().i(r100, 150, r102.getStatus());
            ChatExtra.ADAPTER.i(r100, 1000, r102.getChat_extra());
            r105.i(r100, 1001, r102.getAccept_sms_phone_urgent());
            Tag.ADAPTER.a().i(r100, 200, r102.getTags());
            r100.a(r102.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r100, Chatter r101) {
            Chatter r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "writer");
            Intrinsics.checkNotNullParameter(r102, "value");
            r100.d(r102.unknownFields());
            Tag.ADAPTER.a().j(r100, 200, r102.getTags());
            l r103 = ProtoAdapter.f282718g;
            r103.j(r100, 1001, r102.getAccept_sms_phone_urgent());
            ChatExtra.ADAPTER.j(r100, 1000, r102.getChat_extra());
            ChatterCustomStatus.ADAPTER.a().j(r100, 150, r102.getStatus());
            r103.j(r100, 106, r102.is_agent());
            ProtoAdapter.f282719h.j(r100, 105, r102.getBot_ext_type());
            w r104 = ProtoAdapter.f282728q;
            r104.j(r100, 104, r102.getChat_chatter_list_department_name());
            BotMutedInfo.ADAPTER.j(r100, 103, r102.getMuted_info());
            r103.j(r100, 102, r102.getCan_join_group());
            r103.j(r100, 101, r102.getIn_contacts());
            r104.j(r100, 100, r102.getWith_bot_tag());
            r104.a().j(r100, 47, r102.getCommon_locales());
            TenantNameStatus.ADAPTER.j(r100, 46, r102.getTenant_name_status());
            r103.j(r100, 45, r102.is_tenant_certification());
            t r105 = ProtoAdapter.f282722k;
            r105.j(r100, 37, r102.getPrivate_description_id());
            r104.j(r100, 36, r102.getPrivate_description());
            TagData.ADAPTER.j(r100, 34, r102.getTag_info());
            r104.j(r100, 33, r102.getMajor_language());
            r103.j(r100, 32, r102.is_special_focus());
            r103.j(r100, 31, r102.is_default_avatar());
            r104.j(r100, 30, r102.getAnother_name());
            r104.j(r100, 29, r102.getName_with_another_name());
            AvatarMedal.ADAPTER.j(r100, 28, r102.getAvatar_medal());
            r103.j(r100, 27, r102.is_anonymous());
            r103.j(r100, 26, r102.is_frozen());
            TimeZone.ADAPTER.j(r100, 25, r102.getTime_zone());
            r104.a().j(r100, 24, r102.getAvatar_urls());
            r105.j(r100, 23, r102.getDo_not_disturb_end_time());
            r104.j(r100, 22, r102.getEmail());
            r104.j(r100, 21, r102.getAvatar_path());
            r104.j(r100, 20, r102.getOpen_app_id());
            AccessInfo.ADAPTER.j(r100, 19, r102.getAccess_info());
            r104.j(r100, 18, r102.getAccount_id());
            r103.j(r100, 17, r102.getProfile_enabled());
            WorkStatus.ADAPTER.j(r100, 16, r102.getWork_status());
            r104.j(r100, 15, r102.getAlias());
            r104.j(r100, 14, r102.getLocalized_name());
            r104.j(r100, 13, r102.getTenant_id());
            r104.j(r100, 12, r102.getAvatar_key());
            Description.ADAPTER.j(r100, 11, r102.getDescription());
            r104.j(r100, 10, r102.getEn_us_name());
            r103.j(r100, 9, r102.is_registered());
            r103.j(r100, 8, r102.is_resigned());
            r104.j(r100, 7, r102.getCreator_id());
            r104.j(r100, 6, r102.getName_pinyin());
            r105.j(r100, 5, Long.valueOf(r102.getUpdate_time()));
            ImageSet.ADAPTER.j(r100, 4, r102.getAvatar());
            Type.ADAPTER.j(r100, 3, r102.getType());
            r104.j(r100, 2, r102.getName());
            r104.j(r100, 1, r102.getId());
        }

        public b(FieldEncoding r100, KClass<Chatter> r101, Syntax r102) {
            super(r100, r101, "type.googleapis.com/basic.v1.Chatter", r102, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Chatter(a r100, ByteString r101, DefaultConstructorMarker r102) {
        this(r100, r101);
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
        a r100 = new a();
        r100.f279223d = this.f279178id;
        r100.f279224e = this.name;
        r100.f279225f = this.type;
        r100.f279226g = this.avatar;
        r100.f279227h = Long.valueOf(this.update_time);
        r100.f279228i = this.name_pinyin;
        r100.f279229j = this.creator_id;
        r100.f279230k = this.is_resigned;
        r100.f279231l = this.is_registered;
        r100.f279232m = this.en_us_name;
        r100.f279233n = this.description;
        r100.f279234o = this.avatar_key;
        r100.f279235p = this.tenant_id;
        r100.f279236q = this.localized_name;
        r100.f279237r = this.alias;
        r100.f279238s = this.work_status;
        r100.f279239t = this.profile_enabled;
        r100.f279240u = this.account_id;
        r100.f279241v = this.access_info;
        r100.f279242w = this.open_app_id;
        r100.f279243x = this.avatar_path;
        r100.f279244y = this.email;
        r100.f279245z = this.do_not_disturb_end_time;
        r100.A = this.avatar_urls;
        r100.B = this.time_zone;
        r100.C = this.is_frozen;
        r100.D = this.is_anonymous;
        r100.E = this.avatar_medal;
        r100.F = this.name_with_another_name;
        r100.G = this.another_name;
        r100.H = this.is_default_avatar;
        r100.I = this.is_special_focus;
        r100.f279221J = this.major_language;
        r100.K = this.tag_info;
        r100.L = this.private_description;
        r100.M = this.private_description_id;
        r100.N = this.is_tenant_certification;
        r100.O = this.tenant_name_status;
        r100.P = this.common_locales;
        r100.Q = this.with_bot_tag;
        r100.R = this.in_contacts;
        r100.S = this.can_join_group;
        r100.T = this.muted_info;
        r100.U = this.chat_chatter_list_department_name;
        r100.V = this.bot_ext_type;
        r100.W = this.is_agent;
        r100.X = this.status;
        r100.Y = this.chat_extra;
        r100.Z = this.accept_sms_phone_urgent;
        r100.f279222a0 = this.tags;
        r100.a(unknownFields());
        return r100;
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
        return this.f279178id;
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

    public Chatter(a r100, ByteString r101) {
        super(ADAPTER, r101);
        String r102 = r100.f279223d;
        Intrinsics.checkNotNull(r102);
        this.f279178id = r102;
        String r103 = r100.f279224e;
        Intrinsics.checkNotNull(r103);
        this.name = r103;
        Type r104 = r100.f279225f;
        Intrinsics.checkNotNull(r104);
        this.type = r104;
        this.avatar = r100.f279226g;
        Long r105 = r100.f279227h;
        Intrinsics.checkNotNull(r105);
        this.update_time = r105.longValue();
        String r106 = r100.f279228i;
        Intrinsics.checkNotNull(r106);
        this.name_pinyin = r106;
        this.creator_id = r100.f279229j;
        this.is_resigned = r100.f279230k;
        this.is_registered = r100.f279231l;
        this.en_us_name = r100.f279232m;
        this.description = r100.f279233n;
        this.avatar_key = r100.f279234o;
        this.tenant_id = r100.f279235p;
        this.localized_name = r100.f279236q;
        this.alias = r100.f279237r;
        this.work_status = r100.f279238s;
        this.profile_enabled = r100.f279239t;
        this.account_id = r100.f279240u;
        this.access_info = r100.f279241v;
        this.open_app_id = r100.f279242w;
        this.avatar_path = r100.f279243x;
        this.email = r100.f279244y;
        this.do_not_disturb_end_time = r100.f279245z;
        this.avatar_urls = com.lark.wire.internal.a.c("avatar_urls", r100.A);
        this.time_zone = r100.B;
        this.is_frozen = r100.C;
        this.is_anonymous = r100.D;
        this.avatar_medal = r100.E;
        this.name_with_another_name = r100.F;
        this.another_name = r100.G;
        this.is_default_avatar = r100.H;
        this.is_special_focus = r100.I;
        this.major_language = r100.f279221J;
        this.tag_info = r100.K;
        this.private_description = r100.L;
        this.private_description_id = r100.M;
        this.is_tenant_certification = r100.N;
        this.tenant_name_status = r100.O;
        this.common_locales = com.lark.wire.internal.a.c("common_locales", r100.P);
        this.with_bot_tag = r100.Q;
        this.in_contacts = r100.R;
        this.can_join_group = r100.S;
        this.muted_info = r100.T;
        this.chat_chatter_list_department_name = r100.U;
        this.bot_ext_type = r100.V;
        this.is_agent = r100.W;
        this.status = com.lark.wire.internal.a.c("status", r100.X);
        this.chat_extra = r100.Y;
        this.accept_sms_phone_urgent = r100.Z;
        this.tags = com.lark.wire.internal.a.c(PromotionProductPrivilegesStruct.TAGS, r100.f279222a0);
    }

    public /* synthetic */ Chatter(a r100, ByteString r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = ByteString.EMPTY;
    L5:
        this(r100, r101);
    }
}
