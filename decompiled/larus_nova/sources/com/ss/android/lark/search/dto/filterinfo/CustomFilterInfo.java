package com.ss.android.lark.search.dto.filterinfo;

import com.huawei.hms.support.feature.result.CommonConstant;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003678B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00100\"\u0004\b5\u00102¨\u00069"}, d2 = {"Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo;", "Ljava/io/Serializable;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", CommonConstant.KEY_DISPLAY_NAME, "getDisplayName", "setDisplayName", "filterType", "Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo$FilterType;", "getFilterType", "()Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo$FilterType;", "setFilterType", "(Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo$FilterType;)V", "predefineEnumValues", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo$EnumValue;", "Lkotlin/collections/ArrayList;", "getPredefineEnumValues", "()Ljava/util/ArrayList;", "setPredefineEnumValues", "(Ljava/util/ArrayList;)V", "optionMode", "Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo$OptionMode;", "getOptionMode", "()Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo$OptionMode;", "setOptionMode", "(Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo$OptionMode;)V", "referenceAppId", "getReferenceAppId", "setReferenceAppId", "associatedSmartFilter", "", "getAssociatedSmartFilter", "()I", "setAssociatedSmartFilter", "(I)V", "defaultCheckID", "getDefaultCheckID", "setDefaultCheckID", "shouldReport", "", "getShouldReport", "()Z", "setShouldReport", "(Z)V", "disableEmptySearchOnlyChecked", "getDisableEmptySearchOnlyChecked", "setDisableEmptySearchOnlyChecked", "FilterType", "EnumValue", "OptionMode", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomFilterInfo implements Serializable {
    private int associatedSmartFilter;
    private String defaultCheckID;
    private boolean disableEmptySearchOnlyChecked;
    private String displayName;
    private FilterType filterType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f440141id;
    private OptionMode optionMode;
    private ArrayList<EnumValue> predefineEnumValues;
    private String referenceAppId;
    private boolean shouldReport;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo$EnumValue;", "Ljava/io/Serializable;", "id", "", "displayText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getDisplayText", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EnumValue implements Serializable {
        private final String displayText;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f440142id;

        public static /* synthetic */ EnumValue copy$default(EnumValue r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f440142id;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.displayText;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.f440142id;
        }

        public final String component2() {
            return this.displayText;
        }

        public final EnumValue copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "displayText");
            return new EnumValue(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof EnumValue) == true) goto L8;
            return false;
        L8:
            EnumValue r101 = (EnumValue) r100;
            if (Intrinsics.areEqual(this.f440142id, r101.f440142id) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.displayText, r101.displayText) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f440142id.hashCode() * 31) + this.displayText.hashCode();
        }

        public String toString() {
            return "EnumValue(id=" + this.f440142id + ", displayText=" + this.displayText + ')';
        }

        public final String getDisplayText() {
            return this.displayText;
        }

        public final String getId() {
            return this.f440142id;
        }

        public EnumValue(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "displayText");
            this.f440142id = r100;
            this.displayText = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo$FilterType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "USER_FILTER", "TIME_FILTER", "SEARCHABLE_FILTER", "PREDEFINE_ENUM_FILTER", "MAIL_USER", "INPUT_TEXT_FILTER", "USER_CHAT_FILTER", "CALENDAR_FILTER", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FilterType extends Enum<FilterType> implements Serializable {
        public static final FilterType CALENDAR_FILTER = null;
        public static final a Companion = null;
        public static final FilterType INPUT_TEXT_FILTER = null;
        public static final FilterType MAIL_USER = null;
        public static final FilterType PREDEFINE_ENUM_FILTER = null;
        public static final FilterType SEARCHABLE_FILTER = null;
        public static final FilterType TIME_FILTER = null;
        public static final FilterType UNKNOWN = null;
        public static final FilterType USER_CHAT_FILTER = null;
        public static final FilterType USER_FILTER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FilterType[] f440143a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440144b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<FilterType> getEntries() {
            return f440144b;
        }

        static {
            FilterType r100 = new FilterType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            FilterType r101 = new FilterType("USER_FILTER", 1, 1);
            USER_FILTER = r101;
            FilterType r102 = new FilterType("TIME_FILTER", 2, 2);
            TIME_FILTER = r102;
            FilterType r103 = new FilterType("SEARCHABLE_FILTER", 3, 4);
            SEARCHABLE_FILTER = r103;
            FilterType r104 = new FilterType("PREDEFINE_ENUM_FILTER", 4, 5);
            PREDEFINE_ENUM_FILTER = r104;
            FilterType r110 = new FilterType("MAIL_USER", 5, 6);
            MAIL_USER = r110;
            FilterType r111 = new FilterType("INPUT_TEXT_FILTER", 6, 7);
            INPUT_TEXT_FILTER = r111;
            FilterType r112 = new FilterType("USER_CHAT_FILTER", 7, 8);
            USER_CHAT_FILTER = r112;
            FilterType r113 = new FilterType("CALENDAR_FILTER", 8, 9);
            CALENDAR_FILTER = r113;
            FilterType[] r105 = {r100, r101, r102, r103, r104, r110, r111, r112, r113};
            f440143a = r105;
            f440144b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static FilterType[] values() {
            return (FilterType[]) f440143a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FilterType valueOf(int r100) {
            Companion.getClass();
            switch(r100) {
                case 1: goto L13;
                case 2: goto L21;
                case 3: goto L14;
                case 4: goto L20;
                case 5: goto L19;
                case 6: goto L18;
                case 7: goto L17;
                case 8: goto L16;
                case 9: goto L15;
                default: goto L14;
            };
        L14:
            return UNKNOWN;
        L15:
            return CALENDAR_FILTER;
        L16:
            return USER_CHAT_FILTER;
        L17:
            return INPUT_TEXT_FILTER;
        L18:
            return MAIL_USER;
        L19:
            return PREDEFINE_ENUM_FILTER;
        L20:
            return SEARCHABLE_FILTER;
        L21:
            return TIME_FILTER;
        L13:
            return USER_FILTER;
        }

        public static FilterType valueOf(String r100) {
            return (FilterType) r27.a.a(FilterType.class, r100);
        }

        public FilterType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/search/dto/filterinfo/CustomFilterInfo$OptionMode;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SINGLE", "MULTIPLE", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum OptionMode extends Enum<OptionMode> implements Serializable {
        public static final a Companion = null;
        public static final OptionMode MULTIPLE = null;
        public static final OptionMode SINGLE = null;
        public static final OptionMode UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OptionMode[] f440145a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440146b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<OptionMode> getEntries() {
            return f440146b;
        }

        static {
            OptionMode r100 = new OptionMode("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            OptionMode r101 = new OptionMode("SINGLE", 1, 1);
            SINGLE = r101;
            OptionMode r102 = new OptionMode("MULTIPLE", 2, 2);
            MULTIPLE = r102;
            OptionMode[] r103 = {r100, r101, r102};
            f440145a = r103;
            f440146b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static OptionMode[] values() {
            return (OptionMode[]) f440145a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final OptionMode valueOf(int r100) {
            Companion.getClass();
            if (r100 == 1) goto L9;
            if (r100 == 2) goto L11;
            return UNKNOWN;
        L11:
            return MULTIPLE;
        L9:
            return SINGLE;
        }

        public static OptionMode valueOf(String r100) {
            return (OptionMode) r27.a.a(OptionMode.class, r100);
        }

        public OptionMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public CustomFilterInfo() {
        this.f440141id = "";
        this.displayName = "";
        this.filterType = FilterType.UNKNOWN;
        this.predefineEnumValues = new ArrayList();
        this.optionMode = OptionMode.UNKNOWN;
        this.referenceAppId = "";
    }

    public final int getAssociatedSmartFilter() {
        return this.associatedSmartFilter;
    }

    public final String getDefaultCheckID() {
        return this.defaultCheckID;
    }

    public final boolean getDisableEmptySearchOnlyChecked() {
        return this.disableEmptySearchOnlyChecked;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final FilterType getFilterType() {
        return this.filterType;
    }

    public final String getId() {
        return this.f440141id;
    }

    public final OptionMode getOptionMode() {
        return this.optionMode;
    }

    public final ArrayList<EnumValue> getPredefineEnumValues() {
        return this.predefineEnumValues;
    }

    public final String getReferenceAppId() {
        return this.referenceAppId;
    }

    public final boolean getShouldReport() {
        return this.shouldReport;
    }

    public final void setAssociatedSmartFilter(int r100) {
        this.associatedSmartFilter = r100;
    }

    public final void setDefaultCheckID(String r100) {
        this.defaultCheckID = r100;
    }

    public final void setDisableEmptySearchOnlyChecked(boolean r100) {
        this.disableEmptySearchOnlyChecked = r100;
    }

    public final void setDisplayName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.displayName = r100;
    }

    public final void setFilterType(FilterType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.filterType = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440141id = r100;
    }

    public final void setOptionMode(OptionMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.optionMode = r100;
    }

    public final void setPredefineEnumValues(ArrayList<EnumValue> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.predefineEnumValues = r100;
    }

    public final void setReferenceAppId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.referenceAppId = r100;
    }

    public final void setShouldReport(boolean r100) {
        this.shouldReport = r100;
    }
}
