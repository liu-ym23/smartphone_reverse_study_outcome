package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0006LMNOPQBa\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\t\u0010@\u001a\u00020\rHÆ\u0003J\t\u0010A\u001a\u00020\u000fHÆ\u0003J\t\u0010B\u001a\u00020\u000fHÆ\u0003J\t\u0010C\u001a\u00020\u0012HÆ\u0003Jc\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010E\u001a\u00020\u00122\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\t\u0010J\u001a\u00020KHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006R"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "timeZoneType", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeZoneType;", "formatType", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$FormatType;", "timePrecisionType", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimePrecisionType;", "timeStyle", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeStyle;", "datePrecisionType", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DatePrecisionType;", "dateStatusType", "Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DateStatusType;", "startTimeStamp", "", "endTimeStamp", "enableGmt", "", "<init>", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeZoneType;Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$FormatType;Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimePrecisionType;Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeStyle;Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DatePrecisionType;Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DateStatusType;JJZ)V", "getTimeZoneType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeZoneType;", "setTimeZoneType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeZoneType;)V", "getFormatType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$FormatType;", "setFormatType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$FormatType;)V", "getTimePrecisionType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimePrecisionType;", "setTimePrecisionType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimePrecisionType;)V", "getTimeStyle", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeStyle;", "setTimeStyle", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeStyle;)V", "getDatePrecisionType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DatePrecisionType;", "setDatePrecisionType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DatePrecisionType;)V", "getDateStatusType", "()Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DateStatusType;", "setDateStatusType", "(Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DateStatusType;)V", "getStartTimeStamp", "()J", "setStartTimeStamp", "(J)V", "getEndTimeStamp", "setEndTimeStamp", "getEnableGmt", "()Z", "setEnableGmt", "(Z)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "", "TimeZoneType", "FormatType", "TimePrecisionType", "TimeStyle", "DatePrecisionType", "DateStatusType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeZoneProperty extends BaseProperty {
    private DatePrecisionType datePrecisionType;
    private DateStatusType dateStatusType;
    private boolean enableGmt;
    private long endTimeStamp;
    private FormatType formatType;
    private long startTimeStamp;
    private TimePrecisionType timePrecisionType;
    private TimeStyle timeStyle;
    private TimeZoneType timeZoneType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DatePrecisionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DAY_TYPE", "MONTH_TYPE", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DatePrecisionType extends Enum<DatePrecisionType> {
        public static final a Companion = null;
        public static final DatePrecisionType DAY_TYPE = null;
        public static final DatePrecisionType MONTH_TYPE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DatePrecisionType[] f416259a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416260b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DatePrecisionType> getEntries() {
            return f416260b;
        }

        static {
            DatePrecisionType r100 = new DatePrecisionType("DAY_TYPE", 0, 0);
            DAY_TYPE = r100;
            DatePrecisionType r101 = new DatePrecisionType("MONTH_TYPE", 1, 1);
            MONTH_TYPE = r101;
            DatePrecisionType[] r102 = {r100, r101};
            f416259a = r102;
            f416260b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static DatePrecisionType[] values() {
            return (DatePrecisionType[]) f416259a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static DatePrecisionType valueOf(String r100) {
            return (DatePrecisionType) r27.a.a(DatePrecisionType.class, r100);
        }

        public DatePrecisionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$DateStatusType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ABSOLUTE", "RELATIVE", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DateStatusType extends Enum<DateStatusType> {
        public static final DateStatusType ABSOLUTE = null;
        public static final a Companion = null;
        public static final DateStatusType RELATIVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DateStatusType[] f416261a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416262b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<DateStatusType> getEntries() {
            return f416262b;
        }

        static {
            DateStatusType r100 = new DateStatusType("ABSOLUTE", 0, 0);
            ABSOLUTE = r100;
            DateStatusType r101 = new DateStatusType("RELATIVE", 1, 1);
            RELATIVE = r101;
            DateStatusType[] r102 = {r100, r101};
            f416261a = r102;
            f416262b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static DateStatusType[] values() {
            return (DateStatusType[]) f416261a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static DateStatusType valueOf(String r100) {
            return (DateStatusType) r27.a.a(DateStatusType.class, r100);
        }

        public DateStatusType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$FormatType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SHORT", "LONG", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FormatType extends Enum<FormatType> {
        public static final a Companion = null;
        public static final FormatType LONG = null;
        public static final FormatType SHORT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FormatType[] f416263a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416264b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<FormatType> getEntries() {
            return f416264b;
        }

        static {
            FormatType r100 = new FormatType("SHORT", 0, 0);
            SHORT = r100;
            FormatType r101 = new FormatType("LONG", 1, 1);
            LONG = r101;
            FormatType[] r102 = {r100, r101};
            f416263a = r102;
            f416264b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static FormatType[] values() {
            return (FormatType[]) f416263a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static FormatType valueOf(String r100) {
            return (FormatType) r27.a.a(FormatType.class, r100);
        }

        public FormatType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimePrecisionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SECOND", "MINUTE", "HOUR", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TimePrecisionType extends Enum<TimePrecisionType> {
        public static final a Companion = null;
        public static final TimePrecisionType HOUR = null;
        public static final TimePrecisionType MINUTE = null;
        public static final TimePrecisionType SECOND = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimePrecisionType[] f416265a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416266b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<TimePrecisionType> getEntries() {
            return f416266b;
        }

        static {
            TimePrecisionType r100 = new TimePrecisionType("SECOND", 0, 0);
            SECOND = r100;
            TimePrecisionType r101 = new TimePrecisionType("MINUTE", 1, 1);
            MINUTE = r101;
            TimePrecisionType r102 = new TimePrecisionType("HOUR", 2, 2);
            HOUR = r102;
            TimePrecisionType[] r103 = {r100, r101, r102};
            f416265a = r103;
            f416266b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static TimePrecisionType[] values() {
            return (TimePrecisionType[]) f416265a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static TimePrecisionType valueOf(String r100) {
            return (TimePrecisionType) r27.a.a(TimePrecisionType.class, r100);
        }

        public TimePrecisionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeStyle;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "BY_12_HOUR", "BY_24_HOUR", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TimeStyle extends Enum<TimeStyle> {
        public static final TimeStyle BY_12_HOUR = null;
        public static final TimeStyle BY_24_HOUR = null;
        public static final a Companion = null;
        public static final TimeStyle DEFAULT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimeStyle[] f416267a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416268b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<TimeStyle> getEntries() {
            return f416268b;
        }

        static {
            TimeStyle r100 = new TimeStyle("DEFAULT", 0, 0);
            DEFAULT = r100;
            TimeStyle r101 = new TimeStyle("BY_12_HOUR", 1, 1);
            BY_12_HOUR = r101;
            TimeStyle r102 = new TimeStyle("BY_24_HOUR", 2, 2);
            BY_24_HOUR = r102;
            TimeStyle[] r103 = {r100, r101, r102};
            f416267a = r103;
            f416268b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static TimeStyle[] values() {
            return (TimeStyle[]) f416267a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static TimeStyle valueOf(String r100) {
            return (TimeStyle) r27.a.a(TimeStyle.class, r100);
        }

        public TimeStyle(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeZoneProperty$TimeZoneType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MERIDIEM", "WEEK", "MONTH", "TIME", "DATE", "FULL_DATE", "DATE_TIME", "FULL_DATE_TIME", "DATE_RANGE", "DATE_TIME_RANGE", "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TimeZoneType extends Enum<TimeZoneType> {
        public static final a Companion = null;
        public static final TimeZoneType DATE = null;
        public static final TimeZoneType DATE_RANGE = null;
        public static final TimeZoneType DATE_TIME = null;
        public static final TimeZoneType DATE_TIME_RANGE = null;
        public static final TimeZoneType FULL_DATE = null;
        public static final TimeZoneType FULL_DATE_TIME = null;
        public static final TimeZoneType MERIDIEM = null;
        public static final TimeZoneType MONTH = null;
        public static final TimeZoneType TIME = null;
        public static final TimeZoneType WEEK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimeZoneType[] f416269a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416270b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static TimeZoneType a(int r100) {
                switch(r100) {
                    case 0: goto L14;
                    case 1: goto L24;
                    case 2: goto L23;
                    case 3: goto L22;
                    case 4: goto L21;
                    case 5: goto L20;
                    case 6: goto L19;
                    case 7: goto L18;
                    case 8: goto L17;
                    case 9: goto L16;
                    default: goto L15;
                };
            L15:
                return TimeZoneType.FULL_DATE_TIME;
            L16:
                return TimeZoneType.DATE_TIME_RANGE;
            L17:
                return TimeZoneType.DATE_RANGE;
            L18:
                return TimeZoneType.FULL_DATE_TIME;
            L19:
                return TimeZoneType.DATE_TIME;
            L20:
                return TimeZoneType.FULL_DATE;
            L21:
                return TimeZoneType.DATE;
            L22:
                return TimeZoneType.TIME;
            L23:
                return TimeZoneType.MONTH;
            L24:
                return TimeZoneType.WEEK;
            L14:
                return TimeZoneType.MERIDIEM;
            }
        }

        public static EnumEntries<TimeZoneType> getEntries() {
            return f416270b;
        }

        static {
            TimeZoneType r100 = new TimeZoneType("MERIDIEM", 0, 0);
            MERIDIEM = r100;
            TimeZoneType r101 = new TimeZoneType("WEEK", 1, 1);
            WEEK = r101;
            TimeZoneType r102 = new TimeZoneType("MONTH", 2, 2);
            MONTH = r102;
            TimeZoneType r103 = new TimeZoneType("TIME", 3, 3);
            TIME = r103;
            TimeZoneType r104 = new TimeZoneType("DATE", 4, 4);
            DATE = r104;
            TimeZoneType r105 = new TimeZoneType("FULL_DATE", 5, 5);
            FULL_DATE = r105;
            TimeZoneType r110 = new TimeZoneType("DATE_TIME", 6, 6);
            DATE_TIME = r110;
            TimeZoneType r111 = new TimeZoneType("FULL_DATE_TIME", 7, 7);
            FULL_DATE_TIME = r111;
            TimeZoneType r112 = new TimeZoneType("DATE_RANGE", 8, 8);
            DATE_RANGE = r112;
            TimeZoneType r113 = new TimeZoneType("DATE_TIME_RANGE", 9, 9);
            DATE_TIME_RANGE = r113;
            TimeZoneType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f416269a = r114;
            f416270b = EnumEntriesKt.enumEntries(r114);
            Companion = new a();
        }

        public static TimeZoneType[] values() {
            return (TimeZoneType[]) f416269a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static TimeZoneType valueOf(String r100) {
            return (TimeZoneType) r27.a.a(TimeZoneType.class, r100);
        }

        public TimeZoneType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public TimeZoneProperty() {
        this(null, null, null, null, null, null, 0, 0, false, 511, null);
    }

    public static /* synthetic */ TimeZoneProperty copy$default(TimeZoneProperty r110, TimeZoneType r111, FormatType r112, TimePrecisionType r113, TimeStyle r114, DatePrecisionType r115, DateStatusType r116, long r117, long r210, boolean r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        TimeZoneType r100 = r110.timeZoneType;
    L7:
        if ((r212 & 2) == 0) goto L9;
        FormatType r101 = r110.formatType;
    L11:
        if ((r212 & 4) == 0) goto L13;
        TimePrecisionType r102 = r110.timePrecisionType;
    L15:
        if ((r212 & 8) == 0) goto L17;
        TimeStyle r103 = r110.timeStyle;
    L19:
        if ((r212 & 16) == 0) goto L21;
        DatePrecisionType r104 = r110.datePrecisionType;
    L23:
        if ((r212 & 32) == 0) goto L25;
        DateStatusType r105 = r110.dateStatusType;
    L27:
        if ((r212 & 64) == 0) goto L29;
        long r106 = r110.startTimeStamp;
    L31:
        if ((r212 & 128) == 0) goto L33;
        long r118 = r110.endTimeStamp;
    L35:
        if ((r212 & 256) == 0) goto L37;
        boolean r107 = r110.enableGmt;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r118, r107);
    L37:
        r107 = r211;
        goto L39
    L33:
        r118 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final TimeZoneType component1() {
        return this.timeZoneType;
    }

    public final FormatType component2() {
        return this.formatType;
    }

    public final TimePrecisionType component3() {
        return this.timePrecisionType;
    }

    public final TimeStyle component4() {
        return this.timeStyle;
    }

    public final DatePrecisionType component5() {
        return this.datePrecisionType;
    }

    public final DateStatusType component6() {
        return this.dateStatusType;
    }

    public final long component7() {
        return this.startTimeStamp;
    }

    public final long component8() {
        return this.endTimeStamp;
    }

    public final boolean component9() {
        return this.enableGmt;
    }

    public final TimeZoneProperty copy(TimeZoneType r110, FormatType r111, TimePrecisionType r112, TimeStyle r113, DatePrecisionType r114, DateStatusType r115, long r210, long r211, boolean r212) {
        Intrinsics.checkNotNullParameter(r110, "timeZoneType");
        Intrinsics.checkNotNullParameter(r111, "formatType");
        Intrinsics.checkNotNullParameter(r112, "timePrecisionType");
        Intrinsics.checkNotNullParameter(r113, "timeStyle");
        Intrinsics.checkNotNullParameter(r114, "datePrecisionType");
        Intrinsics.checkNotNullParameter(r115, "dateStatusType");
        return new TimeZoneProperty(r110, r111, r112, r113, r114, r115, r210, r211, r212);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TimeZoneProperty) == true) goto L8;
        return false;
    L8:
        TimeZoneProperty r101 = (TimeZoneProperty) r100;
        if (this.timeZoneType == r101.timeZoneType) goto L12;
        return false;
    L12:
        if (this.formatType == r101.formatType) goto L15;
        return false;
    L15:
        if (this.timePrecisionType == r101.timePrecisionType) goto L18;
        return false;
    L18:
        if (this.timeStyle == r101.timeStyle) goto L21;
        return false;
    L21:
        if (this.datePrecisionType == r101.datePrecisionType) goto L24;
        return false;
    L24:
        if (this.dateStatusType == r101.dateStatusType) goto L27;
        return false;
    L27:
        if (this.startTimeStamp == r101.startTimeStamp) goto L30;
        return false;
    L30:
        if (this.endTimeStamp == r101.endTimeStamp) goto L33;
        return false;
    L33:
        if (this.enableGmt == r101.enableGmt) goto L35;
        return false;
    L35:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = ((((((((((this.timeZoneType.hashCode() * 31) + this.formatType.hashCode()) * 31) + this.timePrecisionType.hashCode()) * 31) + this.timeStyle.hashCode()) * 31) + this.datePrecisionType.hashCode()) * 31) + this.dateStatusType.hashCode()) * 31;
        long r101 = this.startTimeStamp;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.endTimeStamp;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        if (this.enableGmt == false) goto L5;
        int r105 = 1231;
    L7:
        return r104 + r105;
    L5:
        r105 = 1237;
        goto L7
    }

    public String toString() {
        return "TimeZoneProperty(timeZoneType=" + this.timeZoneType + ", formatType=" + this.formatType + ", timePrecisionType=" + this.timePrecisionType + ", timeStyle=" + this.timeStyle + ", datePrecisionType=" + this.datePrecisionType + ", dateStatusType=" + this.dateStatusType + ", startTimeStamp=" + this.startTimeStamp + ", endTimeStamp=" + this.endTimeStamp + ", enableGmt=" + this.enableGmt + ')';
    }

    public final DatePrecisionType getDatePrecisionType() {
        return this.datePrecisionType;
    }

    public final DateStatusType getDateStatusType() {
        return this.dateStatusType;
    }

    public final boolean getEnableGmt() {
        return this.enableGmt;
    }

    public final long getEndTimeStamp() {
        return this.endTimeStamp;
    }

    public final FormatType getFormatType() {
        return this.formatType;
    }

    public final long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public final TimePrecisionType getTimePrecisionType() {
        return this.timePrecisionType;
    }

    public final TimeStyle getTimeStyle() {
        return this.timeStyle;
    }

    public final TimeZoneType getTimeZoneType() {
        return this.timeZoneType;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L115;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        if (r103 == ComponentAttribute.time_zone_type.getValue()) goto L9;
        boolean r104 = true;
        if (r103 == ComponentAttribute.format_type.getValue()) goto L18;
        if (r103 == ComponentAttribute.time_precision_type.getValue()) goto L33;
        int r105 = 0;
        if (r103 == ComponentAttribute.time_style.getValue()) goto L50;
        if (r103 == ComponentAttribute.date_precision_type.getValue()) goto L64;
        if (r103 == ComponentAttribute.date_status_type.getValue()) goto L78;
        long r106 = 0;
        if (r103 == ComponentAttribute.start_time_stamp.getValue()) goto L93;
        if (r103 == ComponentAttribute.end_time_stamp.getValue()) goto L101;
        if (r103 != ComponentAttribute.enable_gmt.getValue()) goto L6;
        PreviewData r107 = r102.getValue();
        if (r107 == null) goto L114;
        Boolean r108 = r107.getBoolean();
        if (r108 == null) goto L114;
        r104 = r108.booleanValue();
    L114:
        this.enableGmt = r104;
        goto L6
    L101:
        PreviewData r109 = r102.getValue();
        if (r109 == null) goto L106;
        Long r110 = r109.getLong();
        if (r110 == null) goto L106;
        r106 = r110.longValue();
    L106:
        this.endTimeStamp = r106;
        goto L6
    L93:
        PreviewData r111 = r102.getValue();
        if (r111 == null) goto L98;
        Long r112 = r111.getLong();
        if (r112 == null) goto L98;
        r106 = r112.longValue();
    L98:
        this.startTimeStamp = r106;
        goto L6
    L78:
        DateStatusType.a r113 = DateStatusType.Companion;
        PreviewData r114 = r102.getValue();
        if (r114 == null) goto L83;
        Integer r115 = r114.getInt();
        if (r115 == null) goto L83;
        int r116 = r115.intValue();
    L84:
        r113.getClass();
        if (r116 == 0) goto L89;
        if (r116 == 1) goto L88;
        DateStatusType r117 = DateStatusType.RELATIVE;
    L90:
        this.dateStatusType = r117;
        goto L6
    L88:
        r117 = DateStatusType.RELATIVE;
        goto L90
    L89:
        r117 = DateStatusType.ABSOLUTE;
    L83:
        r116 = 1;
        goto L84
    L64:
        DatePrecisionType.a r118 = DatePrecisionType.Companion;
        PreviewData r119 = r102.getValue();
        if (r119 == null) goto L69;
        Integer r120 = r119.getInt();
        if (r120 == null) goto L69;
        r105 = r120.intValue();
    L69:
        r118.getClass();
        if (r105 == 0) goto L74;
        if (r105 == 1) goto L73;
        DatePrecisionType r121 = DatePrecisionType.DAY_TYPE;
    L75:
        this.datePrecisionType = r121;
        goto L6
    L73:
        r121 = DatePrecisionType.MONTH_TYPE;
        goto L75
    L74:
        r121 = DatePrecisionType.DAY_TYPE;
        goto L75
    L50:
        TimeStyle.a r122 = TimeStyle.Companion;
        PreviewData r123 = r102.getValue();
        if (r123 == null) goto L55;
        Integer r124 = r123.getInt();
        if (r124 == null) goto L55;
        r105 = r124.intValue();
    L55:
        r122.getClass();
        if (r105 == 1) goto L60;
        if (r105 == 2) goto L59;
        TimeStyle r125 = TimeStyle.DEFAULT;
    L61:
        this.timeStyle = r125;
        goto L6
    L59:
        r125 = TimeStyle.BY_24_HOUR;
        goto L61
    L60:
        r125 = TimeStyle.BY_12_HOUR;
        goto L61
    L33:
        TimePrecisionType.a r126 = TimePrecisionType.Companion;
        PreviewData r127 = r102.getValue();
        if (r127 == null) goto L38;
        Integer r128 = r127.getInt();
        if (r128 == null) goto L38;
        int r129 = r128.intValue();
    L39:
        r126.getClass();
        if (r129 == 0) goto L46;
        if (r129 == 1) goto L45;
        if (r129 == 2) goto L44;
        TimePrecisionType r130 = TimePrecisionType.MINUTE;
    L47:
        this.timePrecisionType = r130;
        goto L6
    L44:
        r130 = TimePrecisionType.HOUR;
        goto L47
    L45:
        r130 = TimePrecisionType.MINUTE;
        goto L47
    L46:
        r130 = TimePrecisionType.SECOND;
    L38:
        r129 = 1;
        goto L39
    L18:
        FormatType.a r131 = FormatType.Companion;
        PreviewData r132 = r102.getValue();
        if (r132 == null) goto L23;
        Integer r133 = r132.getInt();
        if (r133 == null) goto L23;
        int r134 = r133.intValue();
    L24:
        r131.getClass();
        if (r134 == 0) goto L29;
        if (r134 == 1) goto L28;
        FormatType r135 = FormatType.LONG;
    L30:
        this.formatType = r135;
        goto L6
    L28:
        r135 = FormatType.LONG;
        goto L30
    L29:
        r135 = FormatType.SHORT;
    L23:
        r134 = 1;
        goto L24
    L9:
        TimeZoneType.a r136 = TimeZoneType.Companion;
        PreviewData r137 = r102.getValue();
        if (r137 == null) goto L14;
        Integer r138 = r137.getInt();
        if (r138 == null) goto L14;
        int r139 = r138.intValue();
    L15:
        r136.getClass();
        this.timeZoneType = TimeZoneType.a.a(r139);
    L14:
        r139 = 7;
        goto L15
    }

    public final void setDatePrecisionType(DatePrecisionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.datePrecisionType = r100;
    }

    public final void setDateStatusType(DateStatusType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dateStatusType = r100;
    }

    public final void setEnableGmt(boolean r100) {
        this.enableGmt = r100;
    }

    public final void setEndTimeStamp(long r100) {
        this.endTimeStamp = r100;
    }

    public final void setFormatType(FormatType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.formatType = r100;
    }

    public final void setStartTimeStamp(long r100) {
        this.startTimeStamp = r100;
    }

    public final void setTimePrecisionType(TimePrecisionType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.timePrecisionType = r100;
    }

    public final void setTimeStyle(TimeStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.timeStyle = r100;
    }

    public final void setTimeZoneType(TimeZoneType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.timeZoneType = r100;
    }

    public TimeZoneProperty(TimeZoneType r100, FormatType r101, TimePrecisionType r102, TimeStyle r103, DatePrecisionType r104, DateStatusType r105, long r106, long r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "timeZoneType");
        Intrinsics.checkNotNullParameter(r101, "formatType");
        Intrinsics.checkNotNullParameter(r102, "timePrecisionType");
        Intrinsics.checkNotNullParameter(r103, "timeStyle");
        Intrinsics.checkNotNullParameter(r104, "datePrecisionType");
        Intrinsics.checkNotNullParameter(r105, "dateStatusType");
        super(Type.TIME_ZONE);
        this.timeZoneType = r100;
        this.formatType = r101;
        this.timePrecisionType = r102;
        this.timeStyle = r103;
        this.datePrecisionType = r104;
        this.dateStatusType = r105;
        this.startTimeStamp = r106;
        this.endTimeStamp = r110;
        this.enableGmt = r111;
    }

    public /* synthetic */ TimeZoneProperty(TimeZoneType r110, FormatType r111, TimePrecisionType r112, TimeStyle r113, DatePrecisionType r114, DateStatusType r115, long r116, long r210, boolean r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        TimeZoneType r100 = TimeZoneType.FULL_DATE_TIME;
    L7:
        if ((r212 & 2) == 0) goto L9;
        FormatType r101 = FormatType.LONG;
    L11:
        if ((r212 & 4) == 0) goto L13;
        TimePrecisionType r102 = TimePrecisionType.MINUTE;
    L15:
        if ((r212 & 8) == 0) goto L17;
        TimeStyle r103 = TimeStyle.DEFAULT;
    L19:
        if ((r212 & 16) == 0) goto L21;
        DatePrecisionType r104 = DatePrecisionType.DAY_TYPE;
    L23:
        if ((r212 & 32) == 0) goto L25;
        DateStatusType r105 = DateStatusType.RELATIVE;
    L26:
        long r106 = 0;
        if ((r212 & 64) == 0) goto L29;
        long r117 = 0;
    L31:
        if ((r212 & 128) != 0) goto L35;
        r106 = r210;
    L35:
        if ((r212 & 256) == 0) goto L37;
        boolean r107 = true;
    L38:
        this(r100, r101, r102, r103, r104, r105, r117, r106, r107);
        return;
    L37:
        r107 = r211;
        goto L38
    L29:
        r117 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
