package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
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
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u009f\u00012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u001a\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001ª\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u009c\u0001\u001a\u00020\u0002H\u0016J\t\u0010\u009d\u0001\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010$\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010)\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010'R\u0015\u0010+\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b,\u0010'R\u0015\u0010-\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00100\u001a\u0004\b-\u0010/R\u0015\u00101\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00100\u001a\u0004\b1\u0010/R\u0015\u00102\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00100\u001a\u0004\b2\u0010/R\u0015\u00103\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00100\u001a\u0004\b3\u0010/R\u0015\u00104\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00100\u001a\u0004\b4\u0010/R\u0015\u00105\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00100\u001a\u0004\b5\u0010/R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020807¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0015\u0010;\u001a\u0004\u0018\u00010<¢\u0006\n\n\u0002\u0010?\u001a\u0004\b=\u0010>R\u0015\u0010@\u001a\u0004\u0018\u00010<¢\u0006\n\n\u0002\u0010?\u001a\u0004\bA\u0010>R\u0013\u0010B\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u001fR\u0013\u0010D\u001a\u0004\u0018\u00010E¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001e\u0010H\u001a\u0004\u0018\u00010I8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0013\u0010N\u001a\u0004\u0018\u00010O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010R\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u000bR\u0013\u0010T\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u000bR\u001e\u0010V\u001a\u0004\u0018\u00010W8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010K\u001a\u0004\bY\u0010ZR\u0015\u0010[\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\b\\\u0010'R\u0015\u0010]\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00100\u001a\u0004\b]\u0010/R\u0015\u0010^\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00100\u001a\u0004\b^\u0010/R\u0015\u0010_\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00100\u001a\u0004\b_\u0010/R\u0013\u0010`\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u000bR\u0013\u0010b\u001a\u0004\u0018\u00010c¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR \u0010f\u001a\u0004\u0018\u00010.8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00100\u0012\u0004\bg\u0010K\u001a\u0004\bf\u0010/R\u0015\u0010h\u001a\u0004\u0018\u00010%¢\u0006\n\n\u0002\u0010(\u001a\u0004\bi\u0010'R\u0013\u0010j\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\u000bR\u0013\u0010l\u001a\u0004\u0018\u00010m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0013\u0010p\u001a\u0004\u0018\u00010m¢\u0006\b\n\u0000\u001a\u0004\bq\u0010oR\u0013\u0010r\u001a\u0004\u0018\u00010s¢\u0006\b\n\u0000\u001a\u0004\bt\u0010uR\u0013\u0010v\u001a\u0004\u0018\u00010w¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0013\u0010z\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b{\u0010\u000bR\u0015\u0010|\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u00100\u001a\u0004\b}\u0010/R\u0015\u0010~\u001a\u0004\u0018\u00010\u007f¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u0010\u0086\u0001\u001a\u0004\u0018\u00010.¢\u0006\u000b\n\u0002\u00100\u001a\u0005\b\u0086\u0001\u0010/R\u0017\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0015\u0010\u008b\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u000bR\u0015\u0010\u008d\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u000bR\u0017\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0017\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0017\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0017\u0010\u009b\u0001\u001a\u0004\u0018\u00010.¢\u0006\u000b\n\u0002\u00100\u001a\u0005\b\u009b\u0001\u0010/¨\u0006«\u0001"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/Calendar$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/Calendar$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "server_id", "getServer_id", "email", "getEmail", "user_id", "getUser_id", "summary", "getSummary", "description", "getDescription", "type", "Lcom/lark/kmp/pb/calendar/v1/Calendar$Type;", "getType", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$Type;", "default_timezone", "getDefault_timezone", "default_access_role", "Lcom/lark/kmp/pb/calendar/v1/Calendar$AccessRole;", "getDefault_access_role", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$AccessRole;", "dirty_type", "Lcom/lark/kmp/pb/calendar/v1/CalendarDirtyType;", "getDirty_type", "()Lcom/lark/kmp/pb/calendar/v1/CalendarDirtyType;", "foreground_color", "", "getForeground_color", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "background_color", "getBackground_color", "weight", "getWeight", "is_default", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_synced", "is_visible", "is_primary", "is_public", "is_subscriber", "default_reminders", "", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventReminder;", "getDefault_reminders", "()Ljava/util/List;", "create_time", "", "getCreate_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "update_time", "getUpdate_time", "self_access_role", "getSelf_access_role", "self_status", "Lcom/lark/kmp/pb/calendar/v1/Calendar$Status;", "getSelf_status", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$Status;", "cal_color", "Lcom/lark/kmp/pb/calendar/v1/MappingColor;", "getCal_color$annotations", "()V", "getCal_color", "()Lcom/lark/kmp/pb/calendar/v1/MappingColor;", "source", "Lcom/lark/kmp/pb/calendar/v1/Calendar$Source;", "getSource", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$Source;", "localized_summary", "getLocalized_summary", "note", "getNote", "owner", "Lcom/lark/kmp/pb/calendar/v1/CalendarMember;", "getOwner$annotations", "getOwner", "()Lcom/lark/kmp/pb/calendar/v1/CalendarMember;", "resource_capacity", "getResource_capacity", "is_all_staff", "is_active", "is_disabled", "external_account_email", "getExternal_account_email", "work_hour_setting", "Lcom/lark/kmp/pb/calendar/v1/WorkHourSetting;", "getWork_hour_setting", "()Lcom/lark/kmp/pb/calendar/v1/WorkHourSetting;", "is_loading", "is_loading$annotations", "visibility_property", "getVisibility_property", "timezone", "getTimezone", "calendar_event_schema", "Lcom/lark/kmp/pb/calendar/v1/CalendarSchemaCollection;", "getCalendar_event_schema", "()Lcom/lark/kmp/pb/calendar/v1/CalendarSchemaCollection;", "calendar_schema", "getCalendar_schema", "schema_extra_data", "Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData;", "getSchema_extra_data", "()Lcom/lark/kmp/pb/calendar/v1/SchemaExtraData;", "auth_info", "Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarAuthInfo;", "getAuth_info", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarAuthInfo;", "successor_chatter_id", "getSuccessor_chatter_id", "external_password_invalid", "getExternal_password_invalid", "share_options", "Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarShareOptions;", "getShare_options", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarShareOptions;", "share_info", "Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarShareInfo;", "getShare_info", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarShareInfo;", "is_cross_tenant", "cover_image_set", "Lcom/lark/kmp/pb/calendar/v1/CalendarCoverImageSet;", "getCover_image_set", "()Lcom/lark/kmp/pb/calendar/v1/CalendarCoverImageSet;", "calendar_owner_id", "getCalendar_owner_id", "calendar_tenant_id", "getCalendar_tenant_id", "official_type", "Lcom/lark/kmp/pb/calendar/v1/Calendar$OfficialType;", "getOfficial_type", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$OfficialType;", "calendar_sync_info", "Lcom/lark/kmp/pb/calendar/v1/CalendarSyncInfo;", "getCalendar_sync_info", "()Lcom/lark/kmp/pb/calendar/v1/CalendarSyncInfo;", "personalization_settings", "Lcom/lark/kmp/pb/calendar/v1/CalendarPersonalizationSettings;", "getPersonalization_settings", "()Lcom/lark/kmp/pb/calendar/v1/CalendarPersonalizationSettings;", "is_creator_resigned", "newBuilder", "toString", "Builder", "Companion", "Type", "AccessRole", "Status", "Source", "VisibilityProperty", "ShareOption", "OfficialType", "CalendarEditAuthInfo", "CalendarAuthInfo", "CalendarShareOptions", "CalendarShareInfo", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Calendar extends Message<Calendar, a> {
    public static final ProtoAdapter<Calendar> ADAPTER = null;
    public static final c Companion = null;
    public static final int DEFAULT_BACKGROUND_COLOR = -1;
    public static final long DEFAULT_CREATE_TIME = 0;
    public static final AccessRole DEFAULT_DEFAULT_ACCESS_ROLE = null;
    public static final String DEFAULT_DEFAULT_TIMEZONE = "UTC";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final CalendarDirtyType DEFAULT_DIRTY_TYPE = null;
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_EXTERNAL_ACCOUNT_EMAIL = "";
    public static final boolean DEFAULT_EXTERNAL_PASSWORD_INVALID = false;
    public static final int DEFAULT_FOREGROUND_COLOR = -1;
    public static final boolean DEFAULT_IS_ACTIVE = false;
    public static final boolean DEFAULT_IS_ALL_STAFF = false;
    public static final boolean DEFAULT_IS_DEFAULT = false;
    public static final boolean DEFAULT_IS_DISABLED = false;
    public static final boolean DEFAULT_IS_PRIMARY = false;
    public static final boolean DEFAULT_IS_PUBLIC = false;
    public static final boolean DEFAULT_IS_SUBSCRIBER = false;
    public static final boolean DEFAULT_IS_SYNCED = true;
    public static final boolean DEFAULT_IS_VISIBLE = true;
    public static final String DEFAULT_LOCALIZED_SUMMARY = "";
    public static final String DEFAULT_NOTE = "";
    public static final int DEFAULT_RESOURCE_CAPACITY = 0;
    public static final AccessRole DEFAULT_SELF_ACCESS_ROLE = null;
    public static final Status DEFAULT_SELF_STATUS = null;
    public static final Source DEFAULT_SOURCE = null;
    public static final String DEFAULT_SUMMARY = "";
    public static final Type DEFAULT_TYPE = null;
    public static final long DEFAULT_UPDATE_TIME = 0;
    public static final int DEFAULT_VISIBILITY_PROPERTY = 0;
    public static final int DEFAULT_WEIGHT = 0;
    private static final long serialVersionUID = 0;
    private final CalendarAuthInfo auth_info;
    private final Integer background_color;
    private final MappingColor cal_color;
    private final CalendarSchemaCollection calendar_event_schema;
    private final String calendar_owner_id;
    private final CalendarSchemaCollection calendar_schema;
    private final CalendarSyncInfo calendar_sync_info;
    private final String calendar_tenant_id;
    private final CalendarCoverImageSet cover_image_set;
    private final Long create_time;
    private final AccessRole default_access_role;
    private final List<CalendarEventReminder> default_reminders;
    private final String default_timezone;
    private final String description;
    private final CalendarDirtyType dirty_type;
    private final String email;
    private final String external_account_email;
    private final Boolean external_password_invalid;
    private final Integer foreground_color;
    private final String id;
    private final Boolean is_active;
    private final Boolean is_all_staff;
    private final Boolean is_creator_resigned;
    private final Boolean is_cross_tenant;
    private final Boolean is_default;
    private final Boolean is_disabled;
    private final Boolean is_loading;
    private final Boolean is_primary;
    private final Boolean is_public;
    private final Boolean is_subscriber;
    private final Boolean is_synced;
    private final Boolean is_visible;
    private final String localized_summary;
    private final String note;
    private final OfficialType official_type;
    private final CalendarMember owner;
    private final CalendarPersonalizationSettings personalization_settings;
    private final Integer resource_capacity;
    private final SchemaExtraData schema_extra_data;
    private final AccessRole self_access_role;
    private final Status self_status;
    private final String server_id;
    private final CalendarShareInfo share_info;
    private final CalendarShareOptions share_options;
    private final Source source;
    private final String successor_chatter_id;
    private final String summary;
    private final String timezone;
    private final Type type;
    private final Long update_time;
    private final String user_id;
    private final Integer visibility_property;
    private final Integer weight;
    private final WorkHourSetting work_hour_setting;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$AccessRole;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_ACCESS_ROLE", "FREE_BUSY_READER", "READER", "WRITER", "OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum AccessRole extends Enum<AccessRole> implements o0 {
        public static final ProtoAdapter<AccessRole> ADAPTER = null;
        public static final b Companion = null;
        public static final AccessRole FREE_BUSY_READER = null;
        public static final AccessRole OWNER = null;
        public static final AccessRole READER = null;
        public static final AccessRole UNKNOWN_ACCESS_ROLE = null;
        public static final AccessRole WRITER = null;
        public static final /* synthetic */ AccessRole[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<AccessRole> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                AccessRole.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<AccessRole> r1, Syntax r2, AccessRole r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static AccessRole a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return AccessRole.OWNER;
            L20:
                return AccessRole.WRITER;
            L21:
                return AccessRole.READER;
            L22:
                return AccessRole.FREE_BUSY_READER;
            L17:
                return AccessRole.UNKNOWN_ACCESS_ROLE;
            }
        }

        @JvmStatic
        public static final AccessRole fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<AccessRole> getEntries() {
            return b;
        }

        static {
            AccessRole r0 = new AccessRole("UNKNOWN_ACCESS_ROLE", 0, 0);
            UNKNOWN_ACCESS_ROLE = r0;
            AccessRole r1 = new AccessRole("FREE_BUSY_READER", 1, 1);
            FREE_BUSY_READER = r1;
            AccessRole r3 = new AccessRole("READER", 2, 2);
            READER = r3;
            AccessRole r5 = new AccessRole("WRITER", 3, 3);
            WRITER = r5;
            AccessRole r7 = new AccessRole("OWNER", 4, 4);
            OWNER = r7;
            AccessRole[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(AccessRole.class), Syntax.PROTO_2, r0);
        }

        public static AccessRole[] values() {
            return (AccessRole[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static AccessRole valueOf(String r1) {
            return (AccessRole) r27.a.a(AccessRole.class, r1);
        }

        public AccessRole(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarAuthInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarAuthInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarAuthInfo$Builder;Lokio/ByteString;)V", "edit_auth_info", "Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarEditAuthInfo;", "getEdit_auth_info", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarEditAuthInfo;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CalendarAuthInfo extends Message<CalendarAuthInfo, a> {
        public static final ProtoAdapter<CalendarAuthInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final CalendarEditAuthInfo edit_auth_info;

        public static final class a extends Message.a<CalendarAuthInfo, a> {
            public CalendarEditAuthInfo d;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new CalendarAuthInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CalendarAuthInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final CalendarAuthInfo c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L10;
                if (r3 == 1) goto L7;
                r6.j(r3);
                goto L3
            L7:
                r0.d = CalendarEditAuthInfo.ADAPTER.c(r6);
                goto L3
            L10:
                return new CalendarAuthInfo(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CalendarAuthInfo r4) {
                CalendarAuthInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + CalendarEditAuthInfo.ADAPTER.l(1, r5.getEdit_auth_info());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CalendarAuthInfo r5) {
                CalendarAuthInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                CalendarEditAuthInfo.ADAPTER.i(r4, 1, r6.getEdit_auth_info());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, CalendarAuthInfo r4) {
                CalendarAuthInfo r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                CalendarEditAuthInfo.ADAPTER.j(r3, 1, r5.getEdit_auth_info());
            }

            public b(FieldEncoding r7, KClass<CalendarAuthInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.Calendar.CalendarAuthInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CalendarAuthInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarAuthInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.edit_auth_info;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CalendarAuthInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final CalendarEditAuthInfo getEdit_auth_info() {
            return this.edit_auth_info;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public CalendarAuthInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.edit_auth_info = r2.d;
        }

        public /* synthetic */ CalendarAuthInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\nR\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\nR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0010\u0010\nR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\nR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0012\u0010\nR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0013\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarEditAuthInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarEditAuthInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarEditAuthInfo$Builder;Lokio/ByteString;)V", "is_summary_editable", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_note_editable", "is_visibility_editable", "is_color_editable", "is_discription_editable", "is_member_editable", "is_unsubscribable", "is_deletable", "is_cover_image_editable", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CalendarEditAuthInfo extends Message<CalendarEditAuthInfo, a> {
        public static final ProtoAdapter<CalendarEditAuthInfo> ADAPTER = null;
        public static final c Companion = null;
        public static final boolean DEFAULT_IS_COLOR_EDITABLE = false;
        public static final boolean DEFAULT_IS_COVER_IMAGE_EDITABLE = false;
        public static final boolean DEFAULT_IS_DELETABLE = false;
        public static final boolean DEFAULT_IS_DISCRIPTION_EDITABLE = false;
        public static final boolean DEFAULT_IS_MEMBER_EDITABLE = false;
        public static final boolean DEFAULT_IS_NOTE_EDITABLE = false;
        public static final boolean DEFAULT_IS_SUMMARY_EDITABLE = false;
        public static final boolean DEFAULT_IS_UNSUBSCRIBABLE = false;
        public static final boolean DEFAULT_IS_VISIBILITY_EDITABLE = false;
        private static final long serialVersionUID = 0;
        private final Boolean is_color_editable;
        private final Boolean is_cover_image_editable;
        private final Boolean is_deletable;
        private final Boolean is_discription_editable;
        private final Boolean is_member_editable;
        private final Boolean is_note_editable;
        private final Boolean is_summary_editable;
        private final Boolean is_unsubscribable;
        private final Boolean is_visibility_editable;

        public static final class a extends Message.a<CalendarEditAuthInfo, a> {
            public Boolean d;
            public Boolean e;
            public Boolean f;
            public Boolean g;
            public Boolean h;
            public Boolean i;
            public Boolean j;
            public Boolean k;
            public Boolean l;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new CalendarEditAuthInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CalendarEditAuthInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final CalendarEditAuthInfo c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L17;
                switch(r3) {
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
                r0.l = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L8:
                r0.k = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L9:
                r0.j = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L10:
                r0.i = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L11:
                r0.h = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L12:
                r0.g = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L13:
                r0.f = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L14:
                r0.e = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L15:
                r0.d = (Boolean) ProtoAdapter.g.c(r6);
                goto L3
            L6:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L17:
                return new CalendarEditAuthInfo(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CalendarEditAuthInfo r5) {
                CalendarEditAuthInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                l r1 = ProtoAdapter.g;
                return ((((((((r0 + r1.l(1, r6.is_summary_editable())) + r1.l(2, r6.is_note_editable())) + r1.l(3, r6.is_visibility_editable())) + r1.l(4, r6.is_color_editable())) + r1.l(5, r6.is_discription_editable())) + r1.l(6, r6.is_member_editable())) + r1.l(7, r6.is_unsubscribable())) + r1.l(8, r6.is_deletable())) + r1.l(9, r6.is_cover_image_editable());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CalendarEditAuthInfo r5) {
                CalendarEditAuthInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                l r0 = ProtoAdapter.g;
                r0.i(r4, 1, r6.is_summary_editable());
                r0.i(r4, 2, r6.is_note_editable());
                r0.i(r4, 3, r6.is_visibility_editable());
                r0.i(r4, 4, r6.is_color_editable());
                r0.i(r4, 5, r6.is_discription_editable());
                r0.i(r4, 6, r6.is_member_editable());
                r0.i(r4, 7, r6.is_unsubscribable());
                r0.i(r4, 8, r6.is_deletable());
                r0.i(r4, 9, r6.is_cover_image_editable());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, CalendarEditAuthInfo r5) {
                CalendarEditAuthInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                l r0 = ProtoAdapter.g;
                r0.j(r4, 9, r6.is_cover_image_editable());
                r0.j(r4, 8, r6.is_deletable());
                r0.j(r4, 7, r6.is_unsubscribable());
                r0.j(r4, 6, r6.is_member_editable());
                r0.j(r4, 5, r6.is_discription_editable());
                r0.j(r4, 4, r6.is_color_editable());
                r0.j(r4, 3, r6.is_visibility_editable());
                r0.j(r4, 2, r6.is_note_editable());
                r0.j(r4, 1, r6.is_summary_editable());
            }

            public b(FieldEncoding r7, KClass<CalendarEditAuthInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.Calendar.CalendarEditAuthInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CalendarEditAuthInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEditAuthInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.is_summary_editable;
            r0.e = this.is_note_editable;
            r0.f = this.is_visibility_editable;
            r0.g = this.is_color_editable;
            r0.h = this.is_discription_editable;
            r0.i = this.is_member_editable;
            r0.j = this.is_unsubscribable;
            r0.k = this.is_deletable;
            r0.l = this.is_cover_image_editable;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CalendarEditAuthInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final Boolean is_color_editable() {
            return this.is_color_editable;
        }

        public final Boolean is_cover_image_editable() {
            return this.is_cover_image_editable;
        }

        public final Boolean is_deletable() {
            return this.is_deletable;
        }

        public final Boolean is_discription_editable() {
            return this.is_discription_editable;
        }

        public final Boolean is_member_editable() {
            return this.is_member_editable;
        }

        public final Boolean is_note_editable() {
            return this.is_note_editable;
        }

        public final Boolean is_summary_editable() {
            return this.is_summary_editable;
        }

        public final Boolean is_unsubscribable() {
            return this.is_unsubscribable;
        }

        public final Boolean is_visibility_editable() {
            return this.is_visibility_editable;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public CalendarEditAuthInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.is_summary_editable = r2.d;
            this.is_note_editable = r2.e;
            this.is_visibility_editable = r2.f;
            this.is_color_editable = r2.g;
            this.is_discription_editable = r2.h;
            this.is_member_editable = r2.i;
            this.is_unsubscribable = r2.j;
            this.is_deletable = r2.k;
            this.is_cover_image_editable = r2.l;
        }

        public /* synthetic */ CalendarEditAuthInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarShareInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarShareInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarShareInfo$Builder;Lokio/ByteString;)V", "share_url", "", "getShare_url", "()Ljava/lang/String;", "subscriber_num", "", "getSubscriber_num", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CalendarShareInfo extends Message<CalendarShareInfo, a> {
        public static final ProtoAdapter<CalendarShareInfo> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String share_url;
        private final Integer subscriber_num;

        public static final class a extends Message.a<CalendarShareInfo, a> {
            public String d;
            public Integer e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new CalendarShareInfo(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CalendarShareInfo> {
            @Override // com.lark.wire.ProtoAdapter
            public final CalendarShareInfo c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L9;
                r1.e = (Integer) ProtoAdapter.h.c(r7);
                goto L3
            L9:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                return new CalendarShareInfo(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CalendarShareInfo r5) {
                CalendarShareInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getShare_url())) + ProtoAdapter.h.l(2, r6.getSubscriber_num());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CalendarShareInfo r5) {
                CalendarShareInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getShare_url());
                ProtoAdapter.h.i(r4, 2, r6.getSubscriber_num());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, CalendarShareInfo r5) {
                CalendarShareInfo r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.h.j(r4, 2, r6.getSubscriber_num());
                ProtoAdapter.q.j(r4, 1, r6.getShare_url());
            }

            public b(FieldEncoding r7, KClass<CalendarShareInfo> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.Calendar.CalendarShareInfo", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CalendarShareInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarShareInfo.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.share_url;
            r0.e = this.subscriber_num;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CalendarShareInfo.class).getSimpleName() + '@' + hashCode();
        }

        public final String getShare_url() {
            return this.share_url;
        }

        public final Integer getSubscriber_num() {
            return this.subscriber_num;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public CalendarShareInfo(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.share_url = r2.d;
            this.subscriber_num = r2.e;
        }

        public /* synthetic */ CalendarShareInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarShareOptions;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarShareOptions$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/Calendar$CalendarShareOptions$Builder;Lokio/ByteString;)V", "default_share_option", "Lcom/lark/kmp/pb/calendar/v1/Calendar$ShareOption;", "getDefault_share_option", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$ShareOption;", "cross_default_share_option", "getCross_default_share_option", "cross_top_share_option", "getCross_top_share_option", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CalendarShareOptions extends Message<CalendarShareOptions, a> {
        public static final ProtoAdapter<CalendarShareOptions> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ShareOption cross_default_share_option;
        private final ShareOption cross_top_share_option;
        private final ShareOption default_share_option;

        public static final class a extends Message.a<CalendarShareOptions, a> {
            public ShareOption d;
            public ShareOption e;
            public ShareOption f;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new CalendarShareOptions(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CalendarShareOptions> {
            @Override // com.lark.wire.ProtoAdapter
            public final CalendarShareOptions c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L25;
                if (r3 != 1) goto L8;
                r0.d = ShareOption.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = ShareOption.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = ShareOption.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L25:
                return new CalendarShareOptions(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CalendarShareOptions r5) {
                CalendarShareOptions r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                ProtoAdapter<ShareOption> r1 = ShareOption.ADAPTER;
                return ((r0 + r1.l(1, r6.getDefault_share_option())) + r1.l(2, r6.getCross_default_share_option())) + r1.l(3, r6.getCross_top_share_option());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CalendarShareOptions r5) {
                CalendarShareOptions r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter<ShareOption> r0 = ShareOption.ADAPTER;
                r0.i(r4, 1, r6.getDefault_share_option());
                r0.i(r4, 2, r6.getCross_default_share_option());
                r0.i(r4, 3, r6.getCross_top_share_option());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, CalendarShareOptions r5) {
                CalendarShareOptions r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter<ShareOption> r0 = ShareOption.ADAPTER;
                r0.j(r4, 3, r6.getCross_top_share_option());
                r0.j(r4, 2, r6.getCross_default_share_option());
                r0.j(r4, 1, r6.getDefault_share_option());
            }

            public b(FieldEncoding r7, KClass<CalendarShareOptions> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.Calendar.CalendarShareOptions", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CalendarShareOptions(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarShareOptions.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.default_share_option;
            r0.e = this.cross_default_share_option;
            r0.f = this.cross_top_share_option;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CalendarShareOptions.class).getSimpleName() + '@' + hashCode();
        }

        public final ShareOption getCross_default_share_option() {
            return this.cross_default_share_option;
        }

        public final ShareOption getCross_top_share_option() {
            return this.cross_top_share_option;
        }

        public final ShareOption getDefault_share_option() {
            return this.default_share_option;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public CalendarShareOptions(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.default_share_option = r2.d;
            this.cross_default_share_option = r2.e;
            this.cross_top_share_option = r2.f;
        }

        public /* synthetic */ CalendarShareOptions(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$OfficialType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NOT_OFFICIAL", "BYTEDANCE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum OfficialType extends Enum<OfficialType> implements o0 {
        public static final ProtoAdapter<OfficialType> ADAPTER = null;
        public static final OfficialType BYTEDANCE = null;
        public static final b Companion = null;
        public static final OfficialType NOT_OFFICIAL = null;
        public static final /* synthetic */ OfficialType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<OfficialType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                OfficialType.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return OfficialType.BYTEDANCE;
            L9:
                return OfficialType.NOT_OFFICIAL;
            }

            public a(KClass<OfficialType> r1, Syntax r2, OfficialType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<OfficialType> getEntries() {
            return b;
        }

        static {
            OfficialType r0 = new OfficialType("NOT_OFFICIAL", 0, 0);
            NOT_OFFICIAL = r0;
            OfficialType r1 = new OfficialType("BYTEDANCE", 1, 1);
            BYTEDANCE = r1;
            OfficialType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(OfficialType.class), Syntax.PROTO_2, r0);
        }

        public static OfficialType[] values() {
            return (OfficialType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final OfficialType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return BYTEDANCE;
        L9:
            return NOT_OFFICIAL;
        }

        public static OfficialType valueOf(String r1) {
            return (OfficialType) r27.a.a(OfficialType.class, r1);
        }

        public OfficialType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$ShareOption;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_SHARE_OPT", "SHARE_OPT_PRIVATE", "SHARE_OPT_FREE_BUSY_READER", "SHARE_OPT_READER", "SHARE_OPT_WRITER", "SHARE_OPT_OWNER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ShareOption extends Enum<ShareOption> implements o0 {
        public static final ProtoAdapter<ShareOption> ADAPTER = null;
        public static final b Companion = null;
        public static final ShareOption SHARE_OPT_FREE_BUSY_READER = null;
        public static final ShareOption SHARE_OPT_OWNER = null;
        public static final ShareOption SHARE_OPT_PRIVATE = null;
        public static final ShareOption SHARE_OPT_READER = null;
        public static final ShareOption SHARE_OPT_WRITER = null;
        public static final ShareOption UNKNOWN_SHARE_OPT = null;
        public static final /* synthetic */ ShareOption[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ShareOption> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ShareOption.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<ShareOption> r1, Syntax r2, ShareOption r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static ShareOption a(int r1) {
                if (r1 == 0) goto L20;
                if (r1 == 5) goto L26;
                if (r1 == 10) goto L25;
                if (r1 == 15) goto L24;
                if (r1 == 20) goto L23;
                if (r1 == 25) goto L22;
                return null;
            L22:
                return ShareOption.SHARE_OPT_OWNER;
            L23:
                return ShareOption.SHARE_OPT_WRITER;
            L24:
                return ShareOption.SHARE_OPT_READER;
            L25:
                return ShareOption.SHARE_OPT_FREE_BUSY_READER;
            L26:
                return ShareOption.SHARE_OPT_PRIVATE;
            L20:
                return ShareOption.UNKNOWN_SHARE_OPT;
            }
        }

        @JvmStatic
        public static final ShareOption fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<ShareOption> getEntries() {
            return b;
        }

        static {
            ShareOption r0 = new ShareOption("UNKNOWN_SHARE_OPT", 0, 0);
            UNKNOWN_SHARE_OPT = r0;
            ShareOption r1 = new ShareOption("SHARE_OPT_PRIVATE", 1, 5);
            SHARE_OPT_PRIVATE = r1;
            ShareOption r3 = new ShareOption("SHARE_OPT_FREE_BUSY_READER", 2, 10);
            SHARE_OPT_FREE_BUSY_READER = r3;
            ShareOption r6 = new ShareOption("SHARE_OPT_READER", 3, 15);
            SHARE_OPT_READER = r6;
            ShareOption r8 = new ShareOption("SHARE_OPT_WRITER", 4, 20);
            SHARE_OPT_WRITER = r8;
            ShareOption r10 = new ShareOption("SHARE_OPT_OWNER", 5, 25);
            SHARE_OPT_OWNER = r10;
            ShareOption[] r12 = {r0, r1, r3, r6, r8, r10};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ShareOption.class), Syntax.PROTO_2, r0);
        }

        public static ShareOption[] values() {
            return (ShareOption[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static ShareOption valueOf(String r1) {
            return (ShareOption) r27.a.a(ShareOption.class, r1);
        }

        public ShareOption(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$Source;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "MEETING_ROOM_VIEW", "NORMAL_AND_MEETING_ROOM_VIEW", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Source extends Enum<Source> implements o0 {
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final b Companion = null;
        public static final Source MEETING_ROOM_VIEW = null;
        public static final Source NORMAL = null;
        public static final Source NORMAL_AND_MEETING_ROOM_VIEW = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Source> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Source.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return Source.NORMAL_AND_MEETING_ROOM_VIEW;
            L15:
                return Source.MEETING_ROOM_VIEW;
            L12:
                return Source.NORMAL;
            }

            public a(KClass<Source> r2, Syntax r3) {
                super(r2, r3, null);
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
            Source r0 = new Source("NORMAL", 0, 1);
            NORMAL = r0;
            Source r1 = new Source("MEETING_ROOM_VIEW", 1, 2);
            MEETING_ROOM_VIEW = r1;
            Source r4 = new Source("NORMAL_AND_MEETING_ROOM_VIEW", 2, 3);
            NORMAL_AND_MEETING_ROOM_VIEW = r4;
            Source[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Source.class), Syntax.PROTO_2);
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
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return NORMAL_AND_MEETING_ROOM_VIEW;
        L15:
            return MEETING_ROOM_VIEW;
        L12:
            return NORMAL;
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "ACCEPTED", "DECLINED", "INVITED", "REMOVED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final Status ACCEPTED = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final b Companion = null;
        public static final Status DECLINED = null;
        public static final Status DEFAULT = null;
        public static final Status INVITED = null;
        public static final Status REMOVED = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Status> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Status a(int r1) {
                if (r1 == 1) goto L18;
                if (r1 == 2) goto L23;
                if (r1 == 3) goto L22;
                if (r1 == 4) goto L21;
                if (r1 == 5) goto L20;
                return null;
            L20:
                return Status.REMOVED;
            L21:
                return Status.INVITED;
            L22:
                return Status.DECLINED;
            L23:
                return Status.ACCEPTED;
            L18:
                return Status.DEFAULT;
            }
        }

        @JvmStatic
        public static final Status fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("DEFAULT", 0, 1);
            DEFAULT = r0;
            Status r1 = new Status("ACCEPTED", 1, 2);
            ACCEPTED = r1;
            Status r4 = new Status("DECLINED", 2, 3);
            DECLINED = r4;
            Status r6 = new Status("INVITED", 3, 4);
            INVITED = r6;
            Status r8 = new Status("REMOVED", 4, 5);
            REMOVED = r8;
            Status[] r10 = {r0, r1, r4, r6, r8};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "PRIMARY", "OTHER", "GOOGLE", "RESOURCES", "GOOGLE_RESOURCE", "EXCHANGE", "ACTIVITY", "PHONE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final Type ACTIVITY = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type EXCHANGE = null;
        public static final Type GOOGLE = null;
        public static final Type GOOGLE_RESOURCE = null;
        public static final Type OTHER = null;
        public static final Type PHONE = null;
        public static final Type PRIMARY = null;
        public static final Type RESOURCES = null;
        public static final Type UNKNOWN_TYPE = null;
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
                    case 0: goto L13;
                    case 1: goto L22;
                    case 2: goto L21;
                    case 3: goto L20;
                    case 4: goto L19;
                    case 5: goto L18;
                    case 6: goto L3;
                    case 7: goto L3;
                    case 8: goto L17;
                    case 9: goto L16;
                    case 10: goto L15;
                    default: goto L3;
                };
            L3:
                return null;
            L15:
                return Type.PHONE;
            L16:
                return Type.ACTIVITY;
            L17:
                return Type.EXCHANGE;
            L18:
                return Type.GOOGLE_RESOURCE;
            L19:
                return Type.RESOURCES;
            L20:
                return Type.GOOGLE;
            L21:
                return Type.OTHER;
            L22:
                return Type.PRIMARY;
            L13:
                return Type.UNKNOWN_TYPE;
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
            Type r0 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            Type r1 = new Type("PRIMARY", 1, 1);
            PRIMARY = r1;
            Type r3 = new Type("OTHER", 2, 2);
            OTHER = r3;
            Type r5 = new Type("GOOGLE", 3, 3);
            GOOGLE = r5;
            Type r7 = new Type("RESOURCES", 4, 4);
            RESOURCES = r7;
            Type r9 = new Type("GOOGLE_RESOURCE", 5, 5);
            GOOGLE_RESOURCE = r9;
            Type r11 = new Type("EXCHANGE", 6, 8);
            EXCHANGE = r11;
            Type r13 = new Type("ACTIVITY", 7, 9);
            ACTIVITY = r13;
            Type r14 = new Type("PHONE", 8, 10);
            PHONE = r14;
            Type[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r14};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/Calendar$VisibilityProperty;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE_VIEW", "NORMAL_VIEW", "MEETING_VIEW", "TODAY_FEED_VIEW", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum VisibilityProperty extends Enum<VisibilityProperty> implements o0 {
        public static final ProtoAdapter<VisibilityProperty> ADAPTER = null;
        public static final b Companion = null;

        @Deprecated(message = "MEETING_VIEW is deprecated")
        public static final VisibilityProperty MEETING_VIEW = null;
        public static final VisibilityProperty NONE_VIEW = null;
        public static final VisibilityProperty NORMAL_VIEW = null;
        public static final VisibilityProperty TODAY_FEED_VIEW = null;
        public static final /* synthetic */ VisibilityProperty[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<VisibilityProperty> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                VisibilityProperty.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 4) goto L17;
                return null;
            L17:
                return VisibilityProperty.TODAY_FEED_VIEW;
            L18:
                return VisibilityProperty.MEETING_VIEW;
            L19:
                return VisibilityProperty.NORMAL_VIEW;
            L15:
                return VisibilityProperty.NONE_VIEW;
            }

            public a(KClass<VisibilityProperty> r1, Syntax r2, VisibilityProperty r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<VisibilityProperty> getEntries() {
            return b;
        }

        static {
            VisibilityProperty r0 = new VisibilityProperty("NONE_VIEW", 0, 0);
            NONE_VIEW = r0;
            VisibilityProperty r1 = new VisibilityProperty("NORMAL_VIEW", 1, 1);
            NORMAL_VIEW = r1;
            VisibilityProperty r3 = new VisibilityProperty("MEETING_VIEW", 2, 2);
            MEETING_VIEW = r3;
            VisibilityProperty r5 = new VisibilityProperty("TODAY_FEED_VIEW", 3, 4);
            TODAY_FEED_VIEW = r5;
            VisibilityProperty[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(VisibilityProperty.class), Syntax.PROTO_2, r0);
        }

        public static VisibilityProperty[] values() {
            return (VisibilityProperty[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final VisibilityProperty fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 4) goto L17;
            return null;
        L17:
            return TODAY_FEED_VIEW;
        L18:
            return MEETING_VIEW;
        L19:
            return NORMAL_VIEW;
        L15:
            return NONE_VIEW;
        }

        public static VisibilityProperty valueOf(String r1) {
            return (VisibilityProperty) r27.a.a(VisibilityProperty.class, r1);
        }

        public VisibilityProperty(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<Calendar, a> {
        public Status A;
        public MappingColor B;
        public Source C;
        public String D;
        public String E;
        public CalendarMember F;
        public Integer G;
        public Boolean H;
        public Boolean I;
        public Boolean J;
        public String K;
        public WorkHourSetting L;
        public Boolean M;
        public Integer N;
        public String O;
        public CalendarSchemaCollection P;
        public CalendarSchemaCollection Q;
        public SchemaExtraData R;
        public CalendarAuthInfo S;
        public String T;
        public Boolean U;
        public CalendarShareOptions V;
        public CalendarShareInfo W;
        public Boolean X;
        public CalendarCoverImageSet Y;
        public String Z;
        public String a0;
        public OfficialType b0;
        public CalendarSyncInfo c0;
        public String d;
        public CalendarPersonalizationSettings d0;
        public String e;
        public Boolean e0;
        public String f;
        public String g;
        public String h;
        public String i;
        public Type j;
        public String k;
        public AccessRole l;
        public CalendarDirtyType m;
        public Integer n;
        public Integer o;
        public Integer p;
        public Boolean q;
        public Boolean r;
        public Boolean s;
        public Boolean t;
        public Boolean u;
        public Boolean v;
        public List<CalendarEventReminder> w;
        public Long x;
        public Long y;
        public AccessRole z;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new Calendar(this, c(), null);
        }

        public a() {
            this.w = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<Calendar> {
        @Override // com.lark.wire.ProtoAdapter
        public final Calendar c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L82;
            switch(r5) {
                case 1: goto L81;
                case 2: goto L80;
                case 3: goto L79;
                case 4: goto L78;
                case 5: goto L77;
                case 6: goto L76;
                case 7: goto L94;
                case 8: goto L71;
                case 9: goto L84;
                case 10: goto L88;
                case 11: goto L62;
                case 12: goto L61;
                case 13: goto L60;
                case 14: goto L59;
                case 15: goto L58;
                case 16: goto L57;
                case 17: goto L56;
                case 18: goto L55;
                case 19: goto L54;
                case 20: goto L53;
                case 21: goto L52;
                case 22: goto L51;
                case 23: goto L90;
                case 24: goto L92;
                case 25: goto L42;
                case 26: goto L86;
                case 27: goto L37;
                case 28: goto L36;
                case 29: goto L35;
                case 30: goto L34;
                case 31: goto L33;
                case 32: goto L32;
                case 33: goto L31;
                case 34: goto L30;
                case 35: goto L29;
                case 36: goto L28;
                case 37: goto L27;
                case 38: goto L26;
                case 39: goto L25;
                case 40: goto L24;
                case 41: goto L23;
                case 42: goto L22;
                case 43: goto L21;
                case 44: goto L20;
                case 45: goto L19;
                case 46: goto L18;
                case 47: goto L17;
                case 48: goto L16;
                case 49: goto L15;
                case 50: goto L14;
                case 51: goto L96;
                case 52: goto L9;
                case 53: goto L8;
                case 54: goto L7;
                default: goto L6;
            };
        L84:
            r1.l = AccessRole.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L69
        L69:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L86:
            r1.C = Source.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L40
        L40:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L88:
            r1.m = CalendarDirtyType.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L65
        L65:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L90:
            r1.z = AccessRole.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L49
        L49:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r9 = Unit.INSTANCE;
            goto L3
        L92:
            r1.A = Status.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L45
        L45:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r10 = Unit.INSTANCE;
            goto L3
        L94:
            r1.j = Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L74
        L74:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r12 = Unit.INSTANCE;
            goto L3
        L96:
            r1.b0 = OfficialType.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r13 = Unit.INSTANCE;
            goto L3
        L7:
            r1.e0 = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L8:
            r1.d0 = CalendarPersonalizationSettings.ADAPTER.c(r11);
            goto L3
        L9:
            r1.c0 = CalendarSyncInfo.ADAPTER.c(r11);
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.a0 = r11.i();
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.Z = r11.i();
            goto L3
        L16:
            r1.Y = CalendarCoverImageSet.ADAPTER.c(r11);
            goto L3
        L17:
            r1.X = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L18:
            r1.W = CalendarShareInfo.ADAPTER.c(r11);
            goto L3
        L19:
            r1.V = CalendarShareOptions.ADAPTER.c(r11);
            goto L3
        L20:
            r1.U = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L21:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.T = r11.i();
            goto L3
        L22:
            r1.S = CalendarAuthInfo.ADAPTER.c(r11);
            goto L3
        L23:
            r1.R = SchemaExtraData.ADAPTER.c(r11);
            goto L3
        L24:
            r1.Q = CalendarSchemaCollection.ADAPTER.c(r11);
            goto L3
        L25:
            r1.P = CalendarSchemaCollection.ADAPTER.c(r11);
            goto L3
        L26:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.O = r11.i();
            goto L3
        L27:
            r1.N = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L28:
            r1.M = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L29:
            r1.L = WorkHourSetting.ADAPTER.c(r11);
            goto L3
        L30:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.K = r11.i();
            goto L3
        L31:
            r1.J = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L32:
            r1.I = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L33:
            r1.H = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L34:
            r1.G = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L35:
            r1.F = CalendarMember.ADAPTER.c(r11);
            goto L3
        L36:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.E = r11.i();
            goto L3
        L37:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.D = r11.i();
            goto L3
        L42:
            r1.B = MappingColor.ADAPTER.c(r11);
            goto L3
        L51:
            r1.y = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L52:
            r1.x = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L53:
            r2.add(CalendarEventReminder.ADAPTER.c(r11));
            goto L3
        L54:
            r1.v = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L55:
            r1.u = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L56:
            r1.t = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L57:
            r1.s = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L58:
            r1.r = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L59:
            r1.q = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L60:
            r1.p = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L61:
            r1.o = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L62:
            r1.n = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L71:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.k = r11.i();
            goto L3
        L76:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.i = r11.i();
            goto L3
        L77:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.h = r11.i();
            goto L3
        L78:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r14 = r11.i();
            Intrinsics.checkNotNullParameter(r14, "user_id");
            r1.g = r14;
            goto L3
        L79:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.f = r11.i();
            goto L3
        L80:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r15 = r11.i();
            Intrinsics.checkNotNullParameter(r15, "server_id");
            r1.e = r15;
            goto L3
        L81:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r16 = r11.i();
            Intrinsics.checkNotNullParameter(r16, "id");
            r1.d = r16;
            goto L3
        L6:
            r11.j(r5);
            Unit r17 = Unit.INSTANCE;
            goto L3
        L82:
            ByteString r19 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "default_reminders");
            com.lark.wire.internal.a.a(r2);
            r1.w = r2;
            return new Calendar(r1, r19, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Calendar r9) {
            Calendar r10 = r9;
            Intrinsics.checkNotNullParameter(r10, "value");
            int r0 = r10.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (((((((r0 + r1.l(1, r10.getId())) + r1.l(2, r10.getServer_id())) + r1.l(3, r10.getEmail())) + r1.l(4, r10.getUser_id())) + r1.l(5, r10.getSummary())) + r1.l(6, r10.getDescription())) + Type.ADAPTER.l(7, r10.getType())) + r1.l(8, r10.getDefault_timezone());
            ProtoAdapter<AccessRole> r3 = AccessRole.ADAPTER;
            int r4 = (r2 + r3.l(9, r10.getDefault_access_role())) + CalendarDirtyType.ADAPTER.l(10, r10.getDirty_type());
            s r5 = ProtoAdapter.h;
            int r6 = ((r4 + r5.l(11, r10.getForeground_color())) + r5.l(12, r10.getBackground_color())) + r5.l(13, r10.getWeight());
            l r7 = ProtoAdapter.g;
            int r8 = ((((((r6 + r7.l(14, r10.is_default())) + r7.l(15, r10.is_synced())) + r7.l(16, r10.is_visible())) + r7.l(17, r10.is_primary())) + r7.l(18, r10.is_public())) + r7.l(19, r10.is_subscriber())) + CalendarEventReminder.ADAPTER.a().l(20, r10.getDefault_reminders());
            t r11 = ProtoAdapter.k;
            int r12 = (((((((((((((((((r8 + r11.l(21, r10.getCreate_time())) + r11.l(22, r10.getUpdate_time())) + r3.l(23, r10.getSelf_access_role())) + Status.ADAPTER.l(24, r10.getSelf_status())) + MappingColor.ADAPTER.l(25, r10.getCal_color())) + Source.ADAPTER.l(26, r10.getSource())) + r1.l(27, r10.getLocalized_summary())) + r1.l(28, r10.getNote())) + CalendarMember.ADAPTER.l(29, r10.getOwner())) + r5.l(30, r10.getResource_capacity())) + r7.l(31, r10.is_all_staff())) + r7.l(32, r10.is_active())) + r7.l(33, r10.is_disabled())) + r1.l(34, r10.getExternal_account_email())) + WorkHourSetting.ADAPTER.l(35, r10.getWork_hour_setting())) + r7.l(36, r10.is_loading())) + r5.l(37, r10.getVisibility_property())) + r1.l(38, r10.getTimezone());
            ProtoAdapter<CalendarSchemaCollection> r13 = CalendarSchemaCollection.ADAPTER;
            return (((((((((((((((r12 + r13.l(39, r10.getCalendar_event_schema())) + r13.l(40, r10.getCalendar_schema())) + SchemaExtraData.ADAPTER.l(41, r10.getSchema_extra_data())) + CalendarAuthInfo.ADAPTER.l(42, r10.getAuth_info())) + r1.l(43, r10.getSuccessor_chatter_id())) + r7.l(44, r10.getExternal_password_invalid())) + CalendarShareOptions.ADAPTER.l(45, r10.getShare_options())) + CalendarShareInfo.ADAPTER.l(46, r10.getShare_info())) + r7.l(47, r10.is_cross_tenant())) + CalendarCoverImageSet.ADAPTER.l(48, r10.getCover_image_set())) + r1.l(49, r10.getCalendar_owner_id())) + r1.l(50, r10.getCalendar_tenant_id())) + OfficialType.ADAPTER.l(51, r10.getOfficial_type())) + CalendarSyncInfo.ADAPTER.l(52, r10.getCalendar_sync_info())) + CalendarPersonalizationSettings.ADAPTER.l(53, r10.getPersonalization_settings())) + r7.l(54, r10.is_creator_resigned());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r8, Calendar r9) {
            Calendar r10 = r9;
            Intrinsics.checkNotNullParameter(r8, "writer");
            Intrinsics.checkNotNullParameter(r10, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r8, 1, r10.getId());
            r0.i(r8, 2, r10.getServer_id());
            r0.i(r8, 3, r10.getEmail());
            r0.i(r8, 4, r10.getUser_id());
            r0.i(r8, 5, r10.getSummary());
            r0.i(r8, 6, r10.getDescription());
            Type.ADAPTER.i(r8, 7, r10.getType());
            r0.i(r8, 8, r10.getDefault_timezone());
            ProtoAdapter<AccessRole> r1 = AccessRole.ADAPTER;
            r1.i(r8, 9, r10.getDefault_access_role());
            CalendarDirtyType.ADAPTER.i(r8, 10, r10.getDirty_type());
            s r2 = ProtoAdapter.h;
            r2.i(r8, 11, r10.getForeground_color());
            r2.i(r8, 12, r10.getBackground_color());
            r2.i(r8, 13, r10.getWeight());
            l r3 = ProtoAdapter.g;
            r3.i(r8, 14, r10.is_default());
            r3.i(r8, 15, r10.is_synced());
            r3.i(r8, 16, r10.is_visible());
            r3.i(r8, 17, r10.is_primary());
            r3.i(r8, 18, r10.is_public());
            r3.i(r8, 19, r10.is_subscriber());
            CalendarEventReminder.ADAPTER.a().i(r8, 20, r10.getDefault_reminders());
            t r4 = ProtoAdapter.k;
            r4.i(r8, 21, r10.getCreate_time());
            r4.i(r8, 22, r10.getUpdate_time());
            r1.i(r8, 23, r10.getSelf_access_role());
            Status.ADAPTER.i(r8, 24, r10.getSelf_status());
            MappingColor.ADAPTER.i(r8, 25, r10.getCal_color());
            Source.ADAPTER.i(r8, 26, r10.getSource());
            r0.i(r8, 27, r10.getLocalized_summary());
            r0.i(r8, 28, r10.getNote());
            CalendarMember.ADAPTER.i(r8, 29, r10.getOwner());
            r2.i(r8, 30, r10.getResource_capacity());
            r3.i(r8, 31, r10.is_all_staff());
            r3.i(r8, 32, r10.is_active());
            r3.i(r8, 33, r10.is_disabled());
            r0.i(r8, 34, r10.getExternal_account_email());
            WorkHourSetting.ADAPTER.i(r8, 35, r10.getWork_hour_setting());
            r3.i(r8, 36, r10.is_loading());
            r2.i(r8, 37, r10.getVisibility_property());
            r0.i(r8, 38, r10.getTimezone());
            ProtoAdapter<CalendarSchemaCollection> r5 = CalendarSchemaCollection.ADAPTER;
            r5.i(r8, 39, r10.getCalendar_event_schema());
            r5.i(r8, 40, r10.getCalendar_schema());
            SchemaExtraData.ADAPTER.i(r8, 41, r10.getSchema_extra_data());
            CalendarAuthInfo.ADAPTER.i(r8, 42, r10.getAuth_info());
            r0.i(r8, 43, r10.getSuccessor_chatter_id());
            r3.i(r8, 44, r10.getExternal_password_invalid());
            CalendarShareOptions.ADAPTER.i(r8, 45, r10.getShare_options());
            CalendarShareInfo.ADAPTER.i(r8, 46, r10.getShare_info());
            r3.i(r8, 47, r10.is_cross_tenant());
            CalendarCoverImageSet.ADAPTER.i(r8, 48, r10.getCover_image_set());
            r0.i(r8, 49, r10.getCalendar_owner_id());
            r0.i(r8, 50, r10.getCalendar_tenant_id());
            OfficialType.ADAPTER.i(r8, 51, r10.getOfficial_type());
            CalendarSyncInfo.ADAPTER.i(r8, 52, r10.getCalendar_sync_info());
            CalendarPersonalizationSettings.ADAPTER.i(r8, 53, r10.getPersonalization_settings());
            r3.i(r8, 54, r10.is_creator_resigned());
            r8.a(r10.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r8, Calendar r9) {
            Calendar r10 = r9;
            Intrinsics.checkNotNullParameter(r8, "writer");
            Intrinsics.checkNotNullParameter(r10, "value");
            r8.d(r10.unknownFields());
            l r0 = ProtoAdapter.g;
            r0.j(r8, 54, r10.is_creator_resigned());
            CalendarPersonalizationSettings.ADAPTER.j(r8, 53, r10.getPersonalization_settings());
            CalendarSyncInfo.ADAPTER.j(r8, 52, r10.getCalendar_sync_info());
            OfficialType.ADAPTER.j(r8, 51, r10.getOfficial_type());
            w r1 = ProtoAdapter.q;
            r1.j(r8, 50, r10.getCalendar_tenant_id());
            r1.j(r8, 49, r10.getCalendar_owner_id());
            CalendarCoverImageSet.ADAPTER.j(r8, 48, r10.getCover_image_set());
            r0.j(r8, 47, r10.is_cross_tenant());
            CalendarShareInfo.ADAPTER.j(r8, 46, r10.getShare_info());
            CalendarShareOptions.ADAPTER.j(r8, 45, r10.getShare_options());
            r0.j(r8, 44, r10.getExternal_password_invalid());
            r1.j(r8, 43, r10.getSuccessor_chatter_id());
            CalendarAuthInfo.ADAPTER.j(r8, 42, r10.getAuth_info());
            SchemaExtraData.ADAPTER.j(r8, 41, r10.getSchema_extra_data());
            ProtoAdapter<CalendarSchemaCollection> r2 = CalendarSchemaCollection.ADAPTER;
            r2.j(r8, 40, r10.getCalendar_schema());
            r2.j(r8, 39, r10.getCalendar_event_schema());
            r1.j(r8, 38, r10.getTimezone());
            s r3 = ProtoAdapter.h;
            r3.j(r8, 37, r10.getVisibility_property());
            r0.j(r8, 36, r10.is_loading());
            WorkHourSetting.ADAPTER.j(r8, 35, r10.getWork_hour_setting());
            r1.j(r8, 34, r10.getExternal_account_email());
            r0.j(r8, 33, r10.is_disabled());
            r0.j(r8, 32, r10.is_active());
            r0.j(r8, 31, r10.is_all_staff());
            r3.j(r8, 30, r10.getResource_capacity());
            CalendarMember.ADAPTER.j(r8, 29, r10.getOwner());
            r1.j(r8, 28, r10.getNote());
            r1.j(r8, 27, r10.getLocalized_summary());
            Source.ADAPTER.j(r8, 26, r10.getSource());
            MappingColor.ADAPTER.j(r8, 25, r10.getCal_color());
            Status.ADAPTER.j(r8, 24, r10.getSelf_status());
            ProtoAdapter<AccessRole> r4 = AccessRole.ADAPTER;
            r4.j(r8, 23, r10.getSelf_access_role());
            t r5 = ProtoAdapter.k;
            r5.j(r8, 22, r10.getUpdate_time());
            r5.j(r8, 21, r10.getCreate_time());
            CalendarEventReminder.ADAPTER.a().j(r8, 20, r10.getDefault_reminders());
            r0.j(r8, 19, r10.is_subscriber());
            r0.j(r8, 18, r10.is_public());
            r0.j(r8, 17, r10.is_primary());
            r0.j(r8, 16, r10.is_visible());
            r0.j(r8, 15, r10.is_synced());
            r0.j(r8, 14, r10.is_default());
            r3.j(r8, 13, r10.getWeight());
            r3.j(r8, 12, r10.getBackground_color());
            r3.j(r8, 11, r10.getForeground_color());
            CalendarDirtyType.ADAPTER.j(r8, 10, r10.getDirty_type());
            r4.j(r8, 9, r10.getDefault_access_role());
            r1.j(r8, 8, r10.getDefault_timezone());
            Type.ADAPTER.j(r8, 7, r10.getType());
            r1.j(r8, 6, r10.getDescription());
            r1.j(r8, 5, r10.getSummary());
            r1.j(r8, 4, r10.getUser_id());
            r1.j(r8, 3, r10.getEmail());
            r1.j(r8, 2, r10.getServer_id());
            r1.j(r8, 1, r10.getId());
        }

        public b(FieldEncoding r7, KClass<Calendar> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.Calendar", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Calendar(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "cal_color is deprecated")
    public static /* synthetic */ void getCal_color$annotations() {
    }

    @Deprecated(message = "owner is deprecated")
    public static /* synthetic */ void getOwner$annotations() {
    }

    @Deprecated(message = "is_loading is deprecated")
    public static /* synthetic */ void is_loading$annotations() {
    }

    static {
        Companion = new c();
        DEFAULT_TYPE = Type.PRIMARY;
        AccessRole r0 = AccessRole.FREE_BUSY_READER;
        DEFAULT_DEFAULT_ACCESS_ROLE = r0;
        DEFAULT_DIRTY_TYPE = CalendarDirtyType.NONE_DIRTY_TYPE;
        DEFAULT_SELF_ACCESS_ROLE = r0;
        DEFAULT_SELF_STATUS = Status.DEFAULT;
        DEFAULT_SOURCE = Source.NORMAL;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Calendar.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.server_id;
        r0.f = this.email;
        r0.g = this.user_id;
        r0.h = this.summary;
        r0.i = this.description;
        r0.j = this.type;
        r0.k = this.default_timezone;
        r0.l = this.default_access_role;
        r0.m = this.dirty_type;
        r0.n = this.foreground_color;
        r0.o = this.background_color;
        r0.p = this.weight;
        r0.q = this.is_default;
        r0.r = this.is_synced;
        r0.s = this.is_visible;
        r0.t = this.is_primary;
        r0.u = this.is_public;
        r0.v = this.is_subscriber;
        r0.w = this.default_reminders;
        r0.x = this.create_time;
        r0.y = this.update_time;
        r0.z = this.self_access_role;
        r0.A = this.self_status;
        r0.B = this.cal_color;
        r0.C = this.source;
        r0.D = this.localized_summary;
        r0.E = this.note;
        r0.F = this.owner;
        r0.G = this.resource_capacity;
        r0.H = this.is_all_staff;
        r0.I = this.is_active;
        r0.J = this.is_disabled;
        r0.K = this.external_account_email;
        r0.L = this.work_hour_setting;
        r0.M = this.is_loading;
        r0.N = this.visibility_property;
        r0.O = this.timezone;
        r0.P = this.calendar_event_schema;
        r0.Q = this.calendar_schema;
        r0.R = this.schema_extra_data;
        r0.S = this.auth_info;
        r0.T = this.successor_chatter_id;
        r0.U = this.external_password_invalid;
        r0.V = this.share_options;
        r0.W = this.share_info;
        r0.X = this.is_cross_tenant;
        r0.Y = this.cover_image_set;
        r0.Z = this.calendar_owner_id;
        r0.a0 = this.calendar_tenant_id;
        r0.b0 = this.official_type;
        r0.c0 = this.calendar_sync_info;
        r0.d0 = this.personalization_settings;
        r0.e0 = this.is_creator_resigned;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Calendar.class).getSimpleName() + '@' + hashCode();
    }

    public final CalendarAuthInfo getAuth_info() {
        return this.auth_info;
    }

    public final Integer getBackground_color() {
        return this.background_color;
    }

    public final MappingColor getCal_color() {
        return this.cal_color;
    }

    public final CalendarSchemaCollection getCalendar_event_schema() {
        return this.calendar_event_schema;
    }

    public final String getCalendar_owner_id() {
        return this.calendar_owner_id;
    }

    public final CalendarSchemaCollection getCalendar_schema() {
        return this.calendar_schema;
    }

    public final CalendarSyncInfo getCalendar_sync_info() {
        return this.calendar_sync_info;
    }

    public final String getCalendar_tenant_id() {
        return this.calendar_tenant_id;
    }

    public final CalendarCoverImageSet getCover_image_set() {
        return this.cover_image_set;
    }

    public final Long getCreate_time() {
        return this.create_time;
    }

    public final AccessRole getDefault_access_role() {
        return this.default_access_role;
    }

    public final List<CalendarEventReminder> getDefault_reminders() {
        return this.default_reminders;
    }

    public final String getDefault_timezone() {
        return this.default_timezone;
    }

    public final String getDescription() {
        return this.description;
    }

    public final CalendarDirtyType getDirty_type() {
        return this.dirty_type;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getExternal_account_email() {
        return this.external_account_email;
    }

    public final Boolean getExternal_password_invalid() {
        return this.external_password_invalid;
    }

    public final Integer getForeground_color() {
        return this.foreground_color;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocalized_summary() {
        return this.localized_summary;
    }

    public final String getNote() {
        return this.note;
    }

    public final OfficialType getOfficial_type() {
        return this.official_type;
    }

    public final CalendarMember getOwner() {
        return this.owner;
    }

    public final CalendarPersonalizationSettings getPersonalization_settings() {
        return this.personalization_settings;
    }

    public final Integer getResource_capacity() {
        return this.resource_capacity;
    }

    public final SchemaExtraData getSchema_extra_data() {
        return this.schema_extra_data;
    }

    public final AccessRole getSelf_access_role() {
        return this.self_access_role;
    }

    public final Status getSelf_status() {
        return this.self_status;
    }

    public final String getServer_id() {
        return this.server_id;
    }

    public final CalendarShareInfo getShare_info() {
        return this.share_info;
    }

    public final CalendarShareOptions getShare_options() {
        return this.share_options;
    }

    public final Source getSource() {
        return this.source;
    }

    public final String getSuccessor_chatter_id() {
        return this.successor_chatter_id;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final Type getType() {
        return this.type;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final Integer getVisibility_property() {
        return this.visibility_property;
    }

    public final Integer getWeight() {
        return this.weight;
    }

    public final WorkHourSetting getWork_hour_setting() {
        return this.work_hour_setting;
    }

    public final Boolean is_active() {
        return this.is_active;
    }

    public final Boolean is_all_staff() {
        return this.is_all_staff;
    }

    public final Boolean is_creator_resigned() {
        return this.is_creator_resigned;
    }

    public final Boolean is_cross_tenant() {
        return this.is_cross_tenant;
    }

    public final Boolean is_default() {
        return this.is_default;
    }

    public final Boolean is_disabled() {
        return this.is_disabled;
    }

    public final Boolean is_loading() {
        return this.is_loading;
    }

    public final Boolean is_primary() {
        return this.is_primary;
    }

    public final Boolean is_public() {
        return this.is_public;
    }

    public final Boolean is_subscriber() {
        return this.is_subscriber;
    }

    public final Boolean is_synced() {
        return this.is_synced;
    }

    public final Boolean is_visible() {
        return this.is_visible;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public Calendar(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        String r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.server_id = r5;
        this.email = r2.f;
        String r6 = r2.g;
        Intrinsics.checkNotNull(r6);
        this.user_id = r6;
        this.summary = r2.h;
        this.description = r2.i;
        this.type = r2.j;
        this.default_timezone = r2.k;
        this.default_access_role = r2.l;
        this.dirty_type = r2.m;
        this.foreground_color = r2.n;
        this.background_color = r2.o;
        this.weight = r2.p;
        this.is_default = r2.q;
        this.is_synced = r2.r;
        this.is_visible = r2.s;
        this.is_primary = r2.t;
        this.is_public = r2.u;
        this.is_subscriber = r2.v;
        this.default_reminders = com.lark.wire.internal.a.c("default_reminders", r2.w);
        this.create_time = r2.x;
        this.update_time = r2.y;
        this.self_access_role = r2.z;
        this.self_status = r2.A;
        this.cal_color = r2.B;
        this.source = r2.C;
        this.localized_summary = r2.D;
        this.note = r2.E;
        this.owner = r2.F;
        this.resource_capacity = r2.G;
        this.is_all_staff = r2.H;
        this.is_active = r2.I;
        this.is_disabled = r2.J;
        this.external_account_email = r2.K;
        this.work_hour_setting = r2.L;
        this.is_loading = r2.M;
        this.visibility_property = r2.N;
        this.timezone = r2.O;
        this.calendar_event_schema = r2.P;
        this.calendar_schema = r2.Q;
        this.schema_extra_data = r2.R;
        this.auth_info = r2.S;
        this.successor_chatter_id = r2.T;
        this.external_password_invalid = r2.U;
        this.share_options = r2.V;
        this.share_info = r2.W;
        this.is_cross_tenant = r2.X;
        this.cover_image_set = r2.Y;
        this.calendar_owner_id = r2.Z;
        this.calendar_tenant_id = r2.a0;
        this.official_type = r2.b0;
        this.calendar_sync_info = r2.c0;
        this.personalization_settings = r2.d0;
        this.is_creator_resigned = r2.e0;
    }

    public /* synthetic */ Calendar(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
