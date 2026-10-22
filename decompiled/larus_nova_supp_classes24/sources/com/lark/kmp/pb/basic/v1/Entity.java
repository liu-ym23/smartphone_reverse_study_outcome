package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.im.v1.UserGroupEntity;
import com.lark.kmp.pb.openplatform.v1.AppInfoItem;
import com.lark.kmp.pb.vote.v1.VotedInfo;
import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0096\u00012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\n\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0093\u0001\u001a\u00020\u0002H\u0016J\t\u0010\u0094\u0001\u001a\u00020\u000bH\u0016R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00190\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001c0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001f0\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\"0\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000eR\u001d\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020%0\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000eR\u001d\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020(0\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000eR(\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020+0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010-\u001a\u0004\b.\u0010\u000eR\u001d\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002000\n¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000eR\u001d\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002030\n¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u000eR\u001d\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002060\n¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000eR\u001d\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002090\n¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u000eR\u001d\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020<0\n¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000eR\u001d\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020?0\n¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000eR\u001d\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020B0\n¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000eR\u001d\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020E0\n¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u000eR\u001d\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020H0\n¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u000eR\u001d\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020K0\n¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u000eR\u001d\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020N0\n¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u000eR\u001d\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020Q0\n¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u000eR\u001d\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020T0\n¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u000eR\u001d\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u000eR\u001d\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020Y0\n¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u000eR\u001d\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\\0\n¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u000eR\u001d\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020_0\n¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u000eR\u001d\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020b0\n¢\u0006\b\n\u0000\u001a\u0004\bc\u0010\u000eR\u001d\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020e0\n¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u000eR\u001d\u0010g\u001a\u000e\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020i0\n¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u000eR\u001d\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020l0\n¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u000eR\u001d\u0010n\u001a\u000e\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020o0\n¢\u0006\b\n\u0000\u001a\u0004\bp\u0010\u000eR\u001d\u0010q\u001a\u000e\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020r0\n¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u000eR\u001d\u0010t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020u0\n¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\u000eR\u001d\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020x0\n¢\u0006\b\n\u0000\u001a\u0004\by\u0010\u000eR\u001d\u0010z\u001a\u000e\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b{\u0010\u000eR\u001d\u0010|\u001a\u000e\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020}0\n¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u000eR\u001b\u0010\u007f\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010\u0080\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030\u0085\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u000eR \u0010\u0087\u0001\u001a\u000f\u0012\u0004\u0012\u00020h\u0012\u0005\u0012\u00030\u0088\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u000eR \u0010\u008a\u0001\u001a\u000f\u0012\u0004\u0012\u00020h\u0012\u0005\u0012\u00030\u008b\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u000eR \u0010\u008d\u0001\u001a\u000f\u0012\u0004\u0012\u00020h\u0012\u0005\u0012\u00030\u008e\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u000eR \u0010\u0090\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030\u0091\u00010\n¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u000e¨\u0006\u009a\u0001"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Entity;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Entity$Builder;", "Lcom/bytedance/larksuite/wire/IUserScopeMessage;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Entity$Builder;Lokio/ByteString;)V", "messages", "", "", "Lcom/lark/kmp/pb/basic/v1/Message;", "getMessages", "()Ljava/util/Map;", "chats", "Lcom/lark/kmp/pb/basic/v1/Chat;", "getChats", "chatters", "Lcom/lark/kmp/pb/basic/v1/Chatter;", "getChatters", "quasi_messages", "Lcom/lark/kmp/pb/basic/v1/QuasiMessage;", "getQuasi_messages", "departments", "Lcom/lark/kmp/pb/basic/v1/Department;", "getDepartments", "urgents", "Lcom/lark/kmp/pb/basic/v1/Urgent;", "getUrgents", "drafts", "Lcom/lark/kmp/pb/basic/v1/Draft;", "getDrafts", "feed_cards", "Lcom/lark/kmp/pb/basic/v1/FeedCard;", "getFeed_cards", "emails", "Lcom/lark/kmp/pb/basic/v1/Email;", "getEmails", "docs", "Lcom/lark/kmp/pb/basic/v1/Doc;", "getDocs", "doc_permissions", "Lcom/lark/kmp/pb/basic/v1/DocPermission;", "getDoc_permissions$annotations", "()V", "getDoc_permissions", "doc_feeds", "Lcom/lark/kmp/pb/basic/v1/DocFeed;", "getDoc_feeds", "doc_messages", "Lcom/lark/kmp/pb/basic/v1/DocMessage;", "getDoc_messages", "threads", "Lcom/lark/kmp/pb/basic/v1/Thread;", "getThreads", "quasi_threads", "Lcom/lark/kmp/pb/basic/v1/QuasiThread;", "getQuasi_threads", "favorites", "Lcom/lark/kmp/pb/basic/v1/FavoritesObject;", "getFavorites", "translate_messages", "Lcom/lark/kmp/pb/basic/v1/TranslateInfo;", "getTranslate_messages", "tenants", "Lcom/lark/kmp/pb/basic/v1/Tenant;", "getTenants", "chat_chatters", "Lcom/lark/kmp/pb/basic/v1/Entity$ChatChatter;", "getChat_chatters", "message_id2doc_permission_infos", "Lcom/lark/kmp/pb/basic/v1/Entity$DocPermissionInfo;", "getMessage_id2doc_permission_infos", "open_apps", "Lcom/lark/kmp/pb/basic/v1/OpenApp;", "getOpen_apps", "oncalls", "Lcom/lark/kmp/pb/basic/v1/Oncall;", "getOncalls", "topic_groups", "Lcom/lark/kmp/pb/basic/v1/TopicGroup;", "getTopic_groups", "abbrevs", "Lcom/lark/kmp/pb/basic/v1/AbbreviationEntity;", "getAbbrevs", "ephemeral_messages", "getEphemeral_messages", "merge_forward_translate_messages", "Lcom/lark/kmp/pb/basic/v1/SubTranslateInfo;", "getMerge_forward_translate_messages", "mail_setting", "Lcom/lark/kmp/pb/basic/v1/ChatMailSetting;", "getMail_setting", "mentions", "Lcom/lark/kmp/pb/basic/v1/HashTagMentionEntity;", "getMentions", "preview_entities", "Lcom/lark/kmp/pb/basic/v1/PreviewEntityPair;", "getPreview_entities", "preview_templates", "Lcom/lark/kmp/pb/basic/v1/URLPreviewTemplate;", "getPreview_templates", "voted_infos", "", "Lcom/lark/kmp/pb/vote/v1/VotedInfo;", "getVoted_infos", "teams", "Lcom/lark/kmp/pb/basic/v1/Team;", "getTeams", "editing_message_infos", "Lcom/lark/kmp/pb/basic/v1/EditingMessageInfo;", "getEditing_message_infos", "message_fold_details", "Lcom/lark/kmp/pb/basic/v1/MessageFoldDetail;", "getMessage_fold_details", "quasi_schedule_message", "Lcom/lark/kmp/pb/basic/v1/QuasiScheduleMessage;", "getQuasi_schedule_message", "schedule_message", "Lcom/lark/kmp/pb/basic/v1/ScheduleMessage;", "getSchedule_message", "chat_themes", "getChat_themes", "message_local_data", "Lcom/lark/kmp/pb/basic/v1/MessageLocalDataInfoMap;", "getMessage_local_data", "pack_stack_infos", "", "Lcom/lark/kmp/pb/basic/v1/Entity$PackStackInfo;", "getPack_stack_infos", "()Ljava/util/List;", "message_links", "Lcom/lark/kmp/pb/basic/v1/MessageLink;", "getMessage_links", "chatter_id_to_sensitive_info", "Lcom/lark/kmp/pb/basic/v1/ChatterSensitiveInfo;", "getChatter_id_to_sensitive_info", "app_info_items", "Lcom/lark/kmp/pb/openplatform/v1/AppInfoItem;", "getApp_info_items", "user_groups", "Lcom/lark/kmp/pb/im/v1/UserGroupEntity;", "getUser_groups", "analysis_configs", "Lcom/lark/kmp/pb/basic/v1/MessageAnalysisConfig;", "getAnalysis_configs", "newBuilder", "toString", "Builder", "Companion", "ChatChatter", "DocPermissionInfo", "PackStackInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Entity extends com.lark.wire.Message<Entity, a> {
    public static final ProtoAdapter<Entity> ADAPTER = null;
    public static final b Companion = null;
    public static final c<Entity> RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    private final Map<String, AbbreviationEntity> abbrevs;
    private final Map<String, MessageAnalysisConfig> analysis_configs;
    private final Map<Long, AppInfoItem> app_info_items;
    private final Map<String, ChatChatter> chat_chatters;
    private final Map<Long, ByteString> chat_themes;
    private final Map<String, Chat> chats;
    private final Map<Long, ChatterSensitiveInfo> chatter_id_to_sensitive_info;
    private final Map<String, Chatter> chatters;
    private final Map<String, Department> departments;
    private final Map<String, DocFeed> doc_feeds;
    private final Map<String, DocMessage> doc_messages;
    private final Map<String, DocPermission> doc_permissions;
    private final Map<String, Doc> docs;
    private final Map<String, Draft> drafts;
    private final Map<Long, EditingMessageInfo> editing_message_infos;
    private final Map<String, Email> emails;
    private final Map<String, Message> ephemeral_messages;
    private final Map<String, FavoritesObject> favorites;
    private final Map<String, FeedCard> feed_cards;
    private final Map<String, ChatMailSetting> mail_setting;
    private final Map<String, HashTagMentionEntity> mentions;
    private final Map<String, SubTranslateInfo> merge_forward_translate_messages;
    private final Map<Long, MessageFoldDetail> message_fold_details;
    private final Map<String, DocPermissionInfo> message_id2doc_permission_infos;
    private final Map<String, MessageLink> message_links;
    private final Map<Long, MessageLocalDataInfoMap> message_local_data;
    private final Map<String, Message> messages;
    private final Map<String, Oncall> oncalls;
    private final Map<String, OpenApp> open_apps;
    private final List<PackStackInfo> pack_stack_infos;
    private final Map<String, PreviewEntityPair> preview_entities;
    private final Map<String, URLPreviewTemplate> preview_templates;
    private final Map<String, QuasiMessage> quasi_messages;
    private final Map<String, QuasiScheduleMessage> quasi_schedule_message;
    private final Map<String, QuasiThread> quasi_threads;
    private final Map<String, ScheduleMessage> schedule_message;
    private final Map<String, Team> teams;
    private final Map<String, Tenant> tenants;
    private final Map<String, Thread> threads;
    private final Map<String, TopicGroup> topic_groups;
    private final Map<String, TranslateInfo> translate_messages;
    private final Map<String, Urgent> urgents;
    private final Map<Long, UserGroupEntity> user_groups;
    private final Map<Long, VotedInfo> voted_infos;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Entity$ChatChatter;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Entity$ChatChatter$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Entity$ChatChatter$Builder;Lokio/ByteString;)V", "chatters", "", "", "Lcom/lark/kmp/pb/basic/v1/Chatter;", "getChatters", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ChatChatter extends com.lark.wire.Message<ChatChatter, a> {
        public static final ProtoAdapter<ChatChatter> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, Chatter> chatters;

        public static final class a extends com.lark.wire.Message.a<ChatChatter, a> {
            public Map<String, Chatter> d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new ChatChatter(this, c(), null);
            }

            public a() {
                this.d = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ ChatChatter(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(ChatChatter.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new Entity$ChatChatter$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.chatters;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ChatChatter.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, Chatter> getChatters() {
            return this.chatters;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public ChatChatter(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.chatters = com.lark.wire.internal.a.d("chatters", r2.d);
        }

        public /* synthetic */ ChatChatter(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Entity$DocPermissionInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Entity$DocPermissionInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Entity$DocPermissionInfo$Builder;Lokio/ByteString;)V", "token2doc_permissions", "", "", "Lcom/lark/kmp/pb/basic/v1/DocPermission;", "getToken2doc_permissions", "()Ljava/util/Map;", "url2doc_permissions", "getUrl2doc_permissions", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DocPermissionInfo extends com.lark.wire.Message<DocPermissionInfo, a> {
        public static final ProtoAdapter<DocPermissionInfo> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, DocPermission> token2doc_permissions;
        private final Map<String, DocPermission> url2doc_permissions;

        public static final class a extends com.lark.wire.Message.a<DocPermissionInfo, a> {
            public Map<String, DocPermission> d;
            public Map<String, DocPermission> e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new DocPermissionInfo(this, c(), null);
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

        public /* synthetic */ DocPermissionInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(DocPermissionInfo.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new Entity$DocPermissionInfo$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.token2doc_permissions;
            r0.e = this.url2doc_permissions;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(DocPermissionInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, DocPermission> getToken2doc_permissions() {
            return this.token2doc_permissions;
        }

        public final Map<String, DocPermission> getUrl2doc_permissions() {
            return this.url2doc_permissions;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public DocPermissionInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.token2doc_permissions = com.lark.wire.internal.a.d("token2doc_permissions", r2.d);
            this.url2doc_permissions = com.lark.wire.internal.a.d("url2doc_permissions", r2.e);
        }

        public /* synthetic */ DocPermissionInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Entity$PackStackInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Entity$PackStackInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Entity$PackStackInfo$Builder;Lokio/ByteString;)V", "messages", "", "", "", "getMessages", "()Ljava/util/Map;", "threads", "getThreads", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class PackStackInfo extends com.lark.wire.Message<PackStackInfo, a> {
        public static final ProtoAdapter<PackStackInfo> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<Long, Integer> messages;
        private final Map<Long, Integer> threads;

        public static final class a extends com.lark.wire.Message.a<PackStackInfo, a> {
            public Map<Long, Integer> d;
            public Map<Long, Integer> e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new PackStackInfo(this, c(), null);
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

        public /* synthetic */ PackStackInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(PackStackInfo.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new Entity$PackStackInfo$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.messages;
            r0.e = this.threads;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(PackStackInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<Long, Integer> getMessages() {
            return this.messages;
        }

        public final Map<Long, Integer> getThreads() {
            return this.threads;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public PackStackInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.messages = com.lark.wire.internal.a.d("messages", r2.d);
            this.threads = com.lark.wire.internal.a.d("threads", r2.e);
        }

        public /* synthetic */ PackStackInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends com.lark.wire.Message.a<Entity, a> implements d<Entity> {
        public Map<String, AbbreviationEntity> A;
        public Map<String, Message> B;
        public Map<String, SubTranslateInfo> C;
        public Map<String, ChatMailSetting> D;
        public Map<String, HashTagMentionEntity> E;
        public Map<String, PreviewEntityPair> F;
        public Map<String, URLPreviewTemplate> G;
        public Map<Long, VotedInfo> H;
        public Map<String, Team> I;
        public Map<Long, EditingMessageInfo> J;
        public Map<Long, MessageFoldDetail> K;
        public Map<String, QuasiScheduleMessage> L;
        public Map<String, ScheduleMessage> M;
        public Map<Long, ? extends ByteString> N;
        public Map<Long, MessageLocalDataInfoMap> O;
        public List<PackStackInfo> P;
        public Map<String, MessageLink> Q;
        public Map<Long, ChatterSensitiveInfo> R;
        public Map<Long, AppInfoItem> S;
        public Map<Long, UserGroupEntity> T;
        public Map<String, MessageAnalysisConfig> U;
        public Map<String, Message> d;
        public Map<String, Chat> e;
        public Map<String, Chatter> f;
        public Map<String, QuasiMessage> g;
        public Map<String, Department> h;
        public Map<String, Urgent> i;
        public Map<String, Draft> j;
        public Map<String, FeedCard> k;
        public Map<String, Email> l;
        public Map<String, Doc> m;
        public Map<String, DocPermission> n;
        public Map<String, DocFeed> o;
        public Map<String, DocMessage> p;
        public Map<String, Thread> q;
        public Map<String, QuasiThread> r;
        public Map<String, FavoritesObject> s;
        public Map<String, TranslateInfo> t;
        public Map<String, Tenant> u;
        public Map<String, ChatChatter> v;
        public Map<String, DocPermissionInfo> w;
        public Map<String, OpenApp> x;
        public Map<String, Oncall> y;
        public Map<String, TopicGroup> z;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Entity(this, c(), null);
        }

        public a() {
            this.d = MapsKt.emptyMap();
            this.e = MapsKt.emptyMap();
            this.f = MapsKt.emptyMap();
            this.g = MapsKt.emptyMap();
            this.h = MapsKt.emptyMap();
            this.i = MapsKt.emptyMap();
            this.j = MapsKt.emptyMap();
            this.k = MapsKt.emptyMap();
            this.l = MapsKt.emptyMap();
            this.m = MapsKt.emptyMap();
            this.n = MapsKt.emptyMap();
            this.o = MapsKt.emptyMap();
            this.p = MapsKt.emptyMap();
            this.q = MapsKt.emptyMap();
            this.r = MapsKt.emptyMap();
            this.s = MapsKt.emptyMap();
            this.t = MapsKt.emptyMap();
            this.u = MapsKt.emptyMap();
            this.v = MapsKt.emptyMap();
            this.w = MapsKt.emptyMap();
            this.x = MapsKt.emptyMap();
            this.y = MapsKt.emptyMap();
            this.z = MapsKt.emptyMap();
            this.A = MapsKt.emptyMap();
            this.B = MapsKt.emptyMap();
            this.C = MapsKt.emptyMap();
            this.D = MapsKt.emptyMap();
            this.E = MapsKt.emptyMap();
            this.F = MapsKt.emptyMap();
            this.G = MapsKt.emptyMap();
            this.H = MapsKt.emptyMap();
            this.I = MapsKt.emptyMap();
            this.J = MapsKt.emptyMap();
            this.K = MapsKt.emptyMap();
            this.L = MapsKt.emptyMap();
            this.M = MapsKt.emptyMap();
            this.N = MapsKt.emptyMap();
            this.O = MapsKt.emptyMap();
            this.P = CollectionsKt.emptyList();
            this.Q = MapsKt.emptyMap();
            this.R = MapsKt.emptyMap();
            this.S = MapsKt.emptyMap();
            this.T = MapsKt.emptyMap();
            this.U = MapsKt.emptyMap();
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ Entity(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "doc_permissions is deprecated")
    public static /* synthetic */ void getDoc_permissions$annotations() {
    }

    static {
        Companion = new b();
        Entity$Companion$ADAPTER$1 r3 = new Entity$Companion$ADAPTER$1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Entity.class), Syntax.PROTO_2);
        ADAPTER = r3;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<com.lark.kmp.pb.basic.v1.Entity>");
        RAW_TYPE_ADAPTER = r3;
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.messages;
        r0.e = this.chats;
        r0.f = this.chatters;
        r0.g = this.quasi_messages;
        r0.h = this.departments;
        r0.i = this.urgents;
        r0.j = this.drafts;
        r0.k = this.feed_cards;
        r0.l = this.emails;
        r0.m = this.docs;
        r0.n = this.doc_permissions;
        r0.o = this.doc_feeds;
        r0.p = this.doc_messages;
        r0.q = this.threads;
        r0.r = this.quasi_threads;
        r0.s = this.favorites;
        r0.t = this.translate_messages;
        r0.u = this.tenants;
        r0.v = this.chat_chatters;
        r0.w = this.message_id2doc_permission_infos;
        r0.x = this.open_apps;
        r0.y = this.oncalls;
        r0.z = this.topic_groups;
        r0.A = this.abbrevs;
        r0.B = this.ephemeral_messages;
        r0.C = this.merge_forward_translate_messages;
        r0.D = this.mail_setting;
        r0.E = this.mentions;
        r0.F = this.preview_entities;
        r0.G = this.preview_templates;
        r0.H = this.voted_infos;
        r0.I = this.teams;
        r0.J = this.editing_message_infos;
        r0.K = this.message_fold_details;
        r0.L = this.quasi_schedule_message;
        r0.M = this.schedule_message;
        r0.N = this.chat_themes;
        r0.O = this.message_local_data;
        r0.P = this.pack_stack_infos;
        r0.Q = this.message_links;
        r0.R = this.chatter_id_to_sensitive_info;
        r0.S = this.app_info_items;
        r0.T = this.user_groups;
        r0.U = this.analysis_configs;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Entity.class).getSimpleName() + '@' + hashCode();
    }

    public final Map<String, AbbreviationEntity> getAbbrevs() {
        return this.abbrevs;
    }

    public final Map<String, MessageAnalysisConfig> getAnalysis_configs() {
        return this.analysis_configs;
    }

    public final Map<Long, AppInfoItem> getApp_info_items() {
        return this.app_info_items;
    }

    public final Map<String, ChatChatter> getChat_chatters() {
        return this.chat_chatters;
    }

    public final Map<Long, ByteString> getChat_themes() {
        return this.chat_themes;
    }

    public final Map<String, Chat> getChats() {
        return this.chats;
    }

    public final Map<Long, ChatterSensitiveInfo> getChatter_id_to_sensitive_info() {
        return this.chatter_id_to_sensitive_info;
    }

    public final Map<String, Chatter> getChatters() {
        return this.chatters;
    }

    public final Map<String, Department> getDepartments() {
        return this.departments;
    }

    public final Map<String, DocFeed> getDoc_feeds() {
        return this.doc_feeds;
    }

    public final Map<String, DocMessage> getDoc_messages() {
        return this.doc_messages;
    }

    public final Map<String, DocPermission> getDoc_permissions() {
        return this.doc_permissions;
    }

    public final Map<String, Doc> getDocs() {
        return this.docs;
    }

    public final Map<String, Draft> getDrafts() {
        return this.drafts;
    }

    public final Map<Long, EditingMessageInfo> getEditing_message_infos() {
        return this.editing_message_infos;
    }

    public final Map<String, Email> getEmails() {
        return this.emails;
    }

    public final Map<String, Message> getEphemeral_messages() {
        return this.ephemeral_messages;
    }

    public final Map<String, FavoritesObject> getFavorites() {
        return this.favorites;
    }

    public final Map<String, FeedCard> getFeed_cards() {
        return this.feed_cards;
    }

    public final Map<String, ChatMailSetting> getMail_setting() {
        return this.mail_setting;
    }

    public final Map<String, HashTagMentionEntity> getMentions() {
        return this.mentions;
    }

    public final Map<String, SubTranslateInfo> getMerge_forward_translate_messages() {
        return this.merge_forward_translate_messages;
    }

    public final Map<Long, MessageFoldDetail> getMessage_fold_details() {
        return this.message_fold_details;
    }

    public final Map<String, DocPermissionInfo> getMessage_id2doc_permission_infos() {
        return this.message_id2doc_permission_infos;
    }

    public final Map<String, MessageLink> getMessage_links() {
        return this.message_links;
    }

    public final Map<Long, MessageLocalDataInfoMap> getMessage_local_data() {
        return this.message_local_data;
    }

    public final Map<String, Message> getMessages() {
        return this.messages;
    }

    public final Map<String, Oncall> getOncalls() {
        return this.oncalls;
    }

    public final Map<String, OpenApp> getOpen_apps() {
        return this.open_apps;
    }

    public final List<PackStackInfo> getPack_stack_infos() {
        return this.pack_stack_infos;
    }

    public final Map<String, PreviewEntityPair> getPreview_entities() {
        return this.preview_entities;
    }

    public final Map<String, URLPreviewTemplate> getPreview_templates() {
        return this.preview_templates;
    }

    public final Map<String, QuasiMessage> getQuasi_messages() {
        return this.quasi_messages;
    }

    public final Map<String, QuasiScheduleMessage> getQuasi_schedule_message() {
        return this.quasi_schedule_message;
    }

    public final Map<String, QuasiThread> getQuasi_threads() {
        return this.quasi_threads;
    }

    public final Map<String, ScheduleMessage> getSchedule_message() {
        return this.schedule_message;
    }

    public final Map<String, Team> getTeams() {
        return this.teams;
    }

    public final Map<String, Tenant> getTenants() {
        return this.tenants;
    }

    public final Map<String, Thread> getThreads() {
        return this.threads;
    }

    public final Map<String, TopicGroup> getTopic_groups() {
        return this.topic_groups;
    }

    public final Map<String, TranslateInfo> getTranslate_messages() {
        return this.translate_messages;
    }

    public final Map<String, Urgent> getUrgents() {
        return this.urgents;
    }

    public final Map<Long, UserGroupEntity> getUser_groups() {
        return this.user_groups;
    }

    public final Map<Long, VotedInfo> getVoted_infos() {
        return this.voted_infos;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Entity(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.messages = com.lark.wire.internal.a.d("messages", r2.d);
        this.chats = com.lark.wire.internal.a.d("chats", r2.e);
        this.chatters = com.lark.wire.internal.a.d("chatters", r2.f);
        this.quasi_messages = com.lark.wire.internal.a.d("quasi_messages", r2.g);
        this.departments = com.lark.wire.internal.a.d("departments", r2.h);
        this.urgents = com.lark.wire.internal.a.d("urgents", r2.i);
        this.drafts = com.lark.wire.internal.a.d("drafts", r2.j);
        this.feed_cards = com.lark.wire.internal.a.d("feed_cards", r2.k);
        this.emails = com.lark.wire.internal.a.d("emails", r2.l);
        this.docs = com.lark.wire.internal.a.d("docs", r2.m);
        this.doc_permissions = com.lark.wire.internal.a.d("doc_permissions", r2.n);
        this.doc_feeds = com.lark.wire.internal.a.d("doc_feeds", r2.o);
        this.doc_messages = com.lark.wire.internal.a.d("doc_messages", r2.p);
        this.threads = com.lark.wire.internal.a.d("threads", r2.q);
        this.quasi_threads = com.lark.wire.internal.a.d("quasi_threads", r2.r);
        this.favorites = com.lark.wire.internal.a.d("favorites", r2.s);
        this.translate_messages = com.lark.wire.internal.a.d("translate_messages", r2.t);
        this.tenants = com.lark.wire.internal.a.d("tenants", r2.u);
        this.chat_chatters = com.lark.wire.internal.a.d("chat_chatters", r2.v);
        this.message_id2doc_permission_infos = com.lark.wire.internal.a.d("message_id2doc_permission_infos", r2.w);
        this.open_apps = com.lark.wire.internal.a.d("open_apps", r2.x);
        this.oncalls = com.lark.wire.internal.a.d("oncalls", r2.y);
        this.topic_groups = com.lark.wire.internal.a.d("topic_groups", r2.z);
        this.abbrevs = com.lark.wire.internal.a.d("abbrevs", r2.A);
        this.ephemeral_messages = com.lark.wire.internal.a.d("ephemeral_messages", r2.B);
        this.merge_forward_translate_messages = com.lark.wire.internal.a.d("merge_forward_translate_messages", r2.C);
        this.mail_setting = com.lark.wire.internal.a.d("mail_setting", r2.D);
        this.mentions = com.lark.wire.internal.a.d("mentions", r2.E);
        this.preview_entities = com.lark.wire.internal.a.d("preview_entities", r2.F);
        this.preview_templates = com.lark.wire.internal.a.d("preview_templates", r2.G);
        this.voted_infos = com.lark.wire.internal.a.d("voted_infos", r2.H);
        this.teams = com.lark.wire.internal.a.d("teams", r2.I);
        this.editing_message_infos = com.lark.wire.internal.a.d("editing_message_infos", r2.J);
        this.message_fold_details = com.lark.wire.internal.a.d("message_fold_details", r2.K);
        this.quasi_schedule_message = com.lark.wire.internal.a.d("quasi_schedule_message", r2.L);
        this.schedule_message = com.lark.wire.internal.a.d("schedule_message", r2.M);
        this.chat_themes = com.lark.wire.internal.a.d("chat_themes", r2.N);
        this.message_local_data = com.lark.wire.internal.a.d("message_local_data", r2.O);
        this.pack_stack_infos = com.lark.wire.internal.a.c("pack_stack_infos", r2.P);
        this.message_links = com.lark.wire.internal.a.d("message_links", r2.Q);
        this.chatter_id_to_sensitive_info = com.lark.wire.internal.a.d("chatter_id_to_sensitive_info", r2.R);
        this.app_info_items = com.lark.wire.internal.a.d("app_info_items", r2.S);
        this.user_groups = com.lark.wire.internal.a.d("user_groups", r2.T);
        this.analysis_configs = com.lark.wire.internal.a.d("analysis_configs", r2.U);
    }

    public /* synthetic */ Entity(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
