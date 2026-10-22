package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.basic.v1.RichContent;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.bytedance.lark.pb.todo.v1.DatetimeFieldSettings;
import com.bytedance.lark.pb.todo.v1.DatetimeFieldValue;
import com.bytedance.lark.pb.todo.v1.FieldType;
import com.bytedance.lark.pb.todo.v1.MemberFieldSettings;
import com.bytedance.lark.pb.todo.v1.MemberFieldValue;
import com.bytedance.lark.pb.todo.v1.MultiSelectFieldSettings;
import com.bytedance.lark.pb.todo.v1.MultiSelectFieldValue;
import com.bytedance.lark.pb.todo.v1.NumberFieldSettings;
import com.bytedance.lark.pb.todo.v1.NumberFieldValue;
import com.bytedance.lark.pb.todo.v1.SelectFieldOption;
import com.bytedance.lark.pb.todo.v1.SingleSelectFieldSettings;
import com.bytedance.lark.pb.todo.v1.SingleSelectFieldValue;
import com.bytedance.lark.pb.todo.v1.TaskField;
import com.bytedance.lark.pb.todo.v1.TaskFieldSettings;
import com.bytedance.lark.pb.todo.v1.TaskFieldValue;
import com.bytedance.lark.pb.todo.v1.TaskItemMember;
import com.bytedance.lark.pb.todo.v1.TextFieldValue;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberType;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.ss.android.lark.log.Log;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoCustomFieldData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskField f443836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskFieldValue f443837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f443838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f443839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f443840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FieldType f443841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f443842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f443843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.ss.android.lark.todo.impl.features.detail.viewmodel.data.e f443844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.ss.android.lark.todo.impl.features.detail.viewmodel.data.c f443845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f443846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f443847l;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f443848a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f443849b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f443850c = null;

        static {
            int[] r100 = new int[DatetimeFieldSettings.DateFormat.values().length];
            r100[DatetimeFieldSettings.DateFormat.YYYY_MM_DD_DASH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L63:
            r100[DatetimeFieldSettings.DateFormat.YYYY_MM_DD_SLASH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L69:
            r100[DatetimeFieldSettings.DateFormat.MM_DD_YYYY_SLASH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L47:
            r100[DatetimeFieldSettings.DateFormat.DD_MM_YYYY_SLASH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L10:
            f443848a = r100;
            int[] r101 = new int[NumberFieldSettings.Format.values().length];
            r101[NumberFieldSettings.Format.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L65:
            r101[NumberFieldSettings.Format.PERCENTAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L41:
            r101[NumberFieldSettings.Format.CNY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L49:
            r101[NumberFieldSettings.Format.USD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L59:
            r101[NumberFieldSettings.Format.CUSTOM_SYMBOL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L17:
            f443849b = r101;
            int[] r102 = new int[FieldType.values().length];
            r102[FieldType.DATETIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L51:
            r102[FieldType.SINGLE_SELECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L61:
            r102[FieldType.MULTI_SELECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L67:
            r102[FieldType.TEXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L43:
            r102[FieldType.NUMBER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L53:
            r102[FieldType.MEMBER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
        L24:
            f443850c = r102;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((SelectFieldOption) r100).rank, ((SelectFieldOption) r101).rank);
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((SelectFieldOption) r100).rank, ((SelectFieldOption) r101).rank);
        }
    }

    public static final class e<T> implements Comparator {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((SelectFieldOption) r100).rank, ((SelectFieldOption) r101).rank);
        }
    }

    static {
    }

    public final List<SelectFieldOption> c() {
        FieldType r100 = this.f443841f;
        int r101 = b.f443850c[r100.ordinal()];
        if (r101 != 2) goto L5;
        i r102 = this.f443846k;
        if (r102 == null) goto L19;
        SelectFieldOption r103 = r102.f443861a;
        if (r103 == null) goto L19;
        List<SelectFieldOption> r104 = CollectionsKt.listOf(r103);
        if (r104 == null) goto L19;
        return r104;
    L19:
        return CollectionsKt.emptyList();
    L5:
        if (r101 != 3) goto L20;
        f r105 = this.f443847l;
        if (r105 == null) goto L22;
        List<SelectFieldOption> r106 = r105.f443855a;
        if (r106 == null) goto L22;
        return r106;
    L22:
        return CollectionsKt.emptyList();
    L20:
        return CollectionsKt.emptyList();
    }

    public final boolean d() {
        FieldType r100 = this.f443841f;
        String r101 = null;
        String r102 = null;
        SelectFieldOption r103 = null;
        switch(b.f443850c[r100.ordinal()]) {
            case 1: goto L39;
            case 2: goto L34;
            case 3: goto L28;
            case 4: goto L21;
            case 5: goto L10;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        com.ss.android.lark.todo.impl.features.detail.viewmodel.data.e r104 = this.f443844i;
        if (r104 == null) goto L4;
        List<TodoUser> r105 = r104.f443854b;
        if (r105 == null) goto L4;
        boolean r106 = r105.isEmpty();
    L50:
        return true ^ r106;
    L10:
        g r107 = this.f443842g;
        if (r107 == null) goto L13;
        r102 = r107.f443857a;
    L13:
        if (r102 != null) goto L15;
    L18:
        boolean r108 = true;
    L19:
        if (r108 == true) goto L4;
        return true;
    L15:
        if (r102.length() == 0) goto L18;
        r108 = false;
        goto L19
    L21:
        j r109 = this.f443843h;
        if (r109 == null) goto L4;
        RichContent r110 = r109.f443863a;
        if (r110 == null) goto L4;
        RichText r111 = r110.rich_text;
        if (r111 == null) goto L4;
        r106 = com.ss.android.lark.widget.richtext.i.l(j8c.c.a(r111));
        goto L50
    L28:
        f r112 = this.f443847l;
        if (r112 == null) goto L4;
        List<SelectFieldOption> r113 = r112.f443855a;
        if (r113 == null) goto L4;
        r106 = r113.isEmpty();
        goto L50
    L34:
        i r114 = this.f443846k;
        if (r114 == null) goto L37;
        r103 = r114.f443861a;
    L37:
        if (r103 == null) goto L4;
        return true;
    L39:
        com.ss.android.lark.todo.impl.features.detail.viewmodel.data.c r115 = this.f443845j;
        if (r115 == null) goto L42;
        r101 = r115.f443852a;
    L42:
        if (r101 != null) goto L44;
    L47:
        boolean r116 = true;
    L48:
        if (r116 == true) goto L4;
        return true;
    L44:
        if (r101.length() == 0) goto L47;
        r116 = false;
        goto L48
    }

    public final boolean e() {
        if (this.f443837b != null) goto L5;
        return false;
    L5:
        FieldType r100 = this.f443841f;
        switch(b.f443850c[r100.ordinal()]) {
            case 1: goto L30;
            case 2: goto L27;
            case 3: goto L24;
            case 4: goto L21;
            case 5: goto L11;
            case 6: goto L9;
            default: goto L39;
        };
    L11:
        String r101 = this.f443837b.number_field_value.value;
        if (r101 != null) goto L14;
    L17:
        boolean r102 = true;
    L18:
        if (r102 == true) goto L34;
    L31:
        return true;
    L34:
        return false;
    L14:
        if (r101.length() == 0) goto L17;
        r102 = false;
        goto L18
    L39:
        return false;
    L9:
        if (this.f443837b.member_field_value != null) goto L31;
        return false;
    L21:
        if (this.f443837b.text_field_value.value != null) goto L31;
        return false;
    L24:
        if (this.f443837b.multi_select_field_value != null) goto L31;
        return false;
    L27:
        if (this.f443837b.single_select_field_value != null) goto L31;
        return false;
    L30:
        if (this.f443837b.datetime_field_value != null) goto L31;
        return false;
    }

    public final int hashCode() {
        int r100 = ((((this.f443841f.hashCode() * 31) + this.f443840e.hashCode()) * 31) + this.f443839d.hashCode()) * 31;
        g r101 = this.f443842g;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        j r105 = this.f443843h;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        com.ss.android.lark.todo.impl.features.detail.viewmodel.data.e r108 = this.f443844i;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        com.ss.android.lark.todo.impl.features.detail.viewmodel.data.c r111 = this.f443845j;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        i r114 = this.f443846k;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        f r117 = this.f443847l;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        return r116 + r102;
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String a() {
        if (d() == false) goto L41;
        FieldType r100 = this.f443841f;
        RichContent r101 = null;
        switch(b.f443850c[r100.ordinal()]) {
            case 1: goto L30;
            case 2: goto L25;
            case 3: goto L20;
            case 4: goto L16;
            case 5: goto L13;
            case 6: goto L8;
            default: goto L42;
        };
    L8:
        com.ss.android.lark.todo.impl.features.detail.viewmodel.data.e r102 = this.f443844i;
        if (r102 == null) goto L34;
        List<TodoUser> r103 = r102.f443854b;
        if (r103 == null) goto L34;
        return CollectionsKt.joinToString$default(r103, ", ", null, null, 0, null, TodoCustomFieldData$getDisplayValueText$2.INSTANCE, 30, null);
    L34:
        return null;
    L13:
        g r104 = this.f443842g;
        if (r104 == null) goto L34;
        return r104.f443857a;
    L16:
        j r105 = this.f443843h;
        if (r105 == null) goto L37;
        r101 = r105.f443863a;
    L37:
        return com.ss.android.lark.widget.richtext.i.g(j8c.f.a(r101), true);
    L20:
        f r106 = this.f443847l;
        if (r106 == null) goto L34;
        List<SelectFieldOption> r107 = r106.f443855a;
        if (r107 == null) goto L34;
        return CollectionsKt.joinToString$default(r107, ", ", null, null, 0, null, TodoCustomFieldData$getDisplayValueText$1.INSTANCE, 30, null);
    L25:
        i r108 = this.f443846k;
        if (r108 == null) goto L34;
        SelectFieldOption r109 = r108.f443861a;
        if (r109 == null) goto L34;
        return r109.name;
    L30:
        com.ss.android.lark.todo.impl.features.detail.viewmodel.data.c r110 = this.f443845j;
        if (r110 == null) goto L34;
        return r110.f443852a;
    L42:
        return "-";
    L41:
        return "-";
    }

    public final String b() {
        if (d() == false) goto L49;
        FieldType r100 = this.f443841f;
        boolean r101 = true;
        String r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        RichContent r103 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        switch(b.f443850c[r100.ordinal()]) {
            case 1: goto L39;
            case 2: goto L34;
            case 3: goto L29;
            case 4: goto L25;
            case 5: goto L13;
            case 6: goto L8;
            default: goto L50;
        };
    L8:
        com.ss.android.lark.todo.impl.features.detail.viewmodel.data.e r104 = this.f443844i;
        if (r104 == null) goto L43;
        List<TodoUser> r105 = r104.f443854b;
        if (r105 == null) goto L43;
        return CollectionsKt.joinToString$default(r105, ", ", null, null, 0, null, TodoCustomFieldData$getOriginValueText$2.INSTANCE, 30, null);
    L43:
        return r102;
    L13:
        TaskFieldValue r106 = this.f443837b;
        if (r106 == null) goto L18;
        NumberFieldValue r107 = r106.number_field_value;
        if (r107 == null) goto L18;
        r102 = r107.value;
    L18:
        if (r102 != null) goto L20;
    L23:
        if (r101 == false) goto L43;
        return "-";
    L20:
        if (r102.length() == 0) goto L23;
        r101 = false;
        goto L23
    L25:
        j r108 = this.f443843h;
        if (r108 == null) goto L45;
        r103 = r108.f443863a;
    L45:
        return com.ss.android.lark.widget.richtext.i.g(j8c.f.a(r103), true);
    L29:
        f r109 = this.f443847l;
        if (r109 == null) goto L43;
        List<SelectFieldOption> r110 = r109.f443855a;
        if (r110 == null) goto L43;
        return CollectionsKt.joinToString$default(r110, ", ", null, null, 0, null, TodoCustomFieldData$getOriginValueText$1.INSTANCE, 30, null);
    L34:
        i r111 = this.f443846k;
        if (r111 == null) goto L43;
        SelectFieldOption r112 = r111.f443861a;
        if (r112 == null) goto L43;
        return r112.name;
    L39:
        com.ss.android.lark.todo.impl.features.detail.viewmodel.data.c r113 = this.f443845j;
        if (r113 == null) goto L43;
        return r113.f443852a;
    L50:
        return "-";
    L49:
        return "-";
    }

    public final FieldType getType() {
        return this.f443841f;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TodoCustomFieldData) == true) goto L8;
        return false;
    L8:
        TodoCustomFieldData r101 = (TodoCustomFieldData) r100;
        if (this.f443841f == r101.f443841f) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f443840e, r101.f443840e) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f443839d, r101.f443839d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f443842g, r101.f443842g) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f443843h, r101.f443843h) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f443844i, r101.f443844i) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f443845j, r101.f443845j) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f443846k, r101.f443846k) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f443847l, r101.f443847l) == true) goto L35;
        return false;
    L35:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v15, types: [java.text.DecimalFormat] */
    /* JADX WARN: Type inference failed for: r11v24, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r11v25, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r11v28, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.util.Collection] */
    public TodoCustomFieldData(TaskField r100, TaskFieldValue r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "field");
        this.f443836a = r100;
        this.f443837b = r110;
        this.f443838c = r111;
        this.f443839d = r100.key;
        this.f443840e = r100.name;
        FieldType r112 = r100.type;
        this.f443841f = r112;
        int r101 = -1;
        int r102 = 0;
        DatetimeFieldSettings.DateFormat r103 = null;
        List<TaskItemMember> r104 = null;
        r104 = null;
        BigDecimal r105 = null;
        RichContent r106 = null;
        r106 = null;
        Object r107 = null;
        SelectFieldOption r108 = null;
        r108 = null;
        switch(b.f443850c[r112.ordinal()]) {
            case 1: goto L178;
            case 2: goto L144;
            case 3: goto L97;
            case 4: goto L92;
            case 5: goto L36;
            case 6: goto L5;
            default: goto L252;
        };
    L5:
        TaskFieldSettings r109 = r100.settings;
        if (r109 == null) goto L8;
        MemberFieldSettings r113 = r109.member_field_settings;
    L9:
        if (r110 == null) goto L13;
        MemberFieldValue r114 = r110.member_field_value;
        if (r114 == null) goto L13;
        r104 = r114.value;
    L13:
        if (r113 == null) goto L17;
        Boolean r115 = r113.multiple;
        if (r115 == null) goto L17;
        boolean r116 = r115.booleanValue();
    L18:
        if (r104 == null) goto L34;
        ArrayList r117 = new ArrayList();
        Iterator r118 = r104.iterator();
    L21:
        if (r118.hasNext() == false) goto L28;
        Object r119 = r118.next();
        if (((TaskItemMember) r119).type != TodoItemMemberType.USER) goto L25;
        boolean r120 = true;
    L26:
        if (r120 == false) goto L21;
        r117.add(r119);
        goto L21
    L25:
        r120 = false;
        goto L26
    L28:
        List r121 = new ArrayList();
        Iterator r122 = r117.iterator();
    L30:
        if (r122.hasNext() == false) goto L35;
        TodoUser r123 = ((TaskItemMember) r122.next()).user;
        if (r123 == null) goto L30;
        r121.add(r123);
    L35:
        this.f443844i = new com.ss.android.lark.todo.impl.features.detail.viewmodel.data.e(r116, new ArrayList(r121));
        return;
    L34:
        r121 = CollectionsKt.emptyList();
    L17:
        r116 = false;
        goto L18
    L8:
        r113 = null;
        goto L9
    L36:
        TaskFieldSettings r124 = r100.settings;
        if (r124 == null) goto L39;
        NumberFieldSettings r125 = r124.number_field_settings;
    L40:
        if (r110 == null) goto L44;
        NumberFieldValue r126 = r110.number_field_value;
        if (r126 == null) goto L44;
        String r127 = r126.value;
    L45:
        ?? r128 = new DecimalFormat();
        if (r125 == null) goto L50;
        Integer r129 = r125.decimal_count;
        if (r129 == null) goto L50;
        int r130 = r129.intValue();
    L51:
        r128.setMaximumFractionDigits(r130);
        if (r125 == null) goto L56;
        Integer r131 = r125.decimal_count;
        if (r131 == null) goto L56;
        int r132 = r131.intValue();
    L57:
        r128.setMinimumFractionDigits(r132);
        if (r125 == null) goto L60;
        NumberFieldSettings.Separator r133 = r125.separator;
    L62:
        if (r133 != NumberFieldSettings.Separator.THOUSAND) goto L64;
        r102 = 3;
    L64:
        r128.setGroupingSize(r102);
        r128.setRoundingMode(RoundingMode.HALF_UP);
        r105 = new BigDecimal(r127);     // Catch: Exception -> L67
    L69:
        if (r105 == null) goto L243;
        String r134 = r128.format(r105);
        if (r125 == null) goto L91;
        NumberFieldSettings.Format r135 = r125.format;
        if (r135 == null) goto L77;
        r101 = b.f443849b[r135.ordinal()];
    L77:
        if (r101 == 2) goto L90;
        if (r101 == 3) goto L89;
        if (r101 != 4) goto L81;
        r134 = "$" + r134;
        goto L91
    L81:
        if (r101 != 5) goto L91;
        if (r125.custom_symbol_position != NumberFieldSettings.CustomSymbolPosition.RIGHT) goto L86;
        StringBuilder r136 = new StringBuilder();
        r136.append(r134);
        r136.append(r125.custom_symbol_chars);
    L87:
        r134 = r136.toString();
        goto L91
    L86:
        r136 = new StringBuilder();
        r136.append(r125.custom_symbol_chars);
        r136.append(r134);
        goto L87
    L89:
        r134 = "¥" + r134;
        goto L91
    L90:
        r134 = r128.format(r105.multiply(new BigDecimal(100))) + '%';
    L91:
        this.f443842g = new g(r134);
        return;
    L243:
        return;
    L67:
        e = move-exception;
        Log.w("TodoCustomFieldData", "parse number error", e);
        goto L69
    L60:
        r133 = null;
    L56:
        r132 = 0;
    L50:
        r130 = 0;
    L44:
        r127 = null;
        goto L45
    L39:
        r125 = null;
        goto L40
    L92:
        if (r110 == null) goto L96;
        TextFieldValue r137 = r110.text_field_value;
        if (r137 == null) goto L96;
        r106 = r137.value;
    L96:
        this.f443843h = new j(r106);
        return;
    L97:
        TaskFieldSettings r138 = r100.settings;
        if (r138 == null) goto L100;
        MultiSelectFieldSettings r139 = r138.multi_select_field_settings;
    L101:
        if (r110 == null) goto L105;
        MultiSelectFieldValue r140 = r110.multi_select_field_value;
        if (r140 == null) goto L105;
        List<String> r141 = r140.value;
    L106:
        ArrayList r142 = new ArrayList();
        if (r141 == null) goto L127;
        Iterator r143 = r141.iterator();
    L110:
        if (r143.hasNext() == false) goto L125;
        String r144 = (String) r143.next();
        if (r139 == null) goto L110;
        List<SelectFieldOption> r145 = r139.options;
        if (r145 == null) goto L110;
        Iterator r146 = r145.iterator();
    L117:
        if (r146.hasNext() == false) goto L121;
        Object r147 = r146.next();
        if (Intrinsics.areEqual(((SelectFieldOption) r147).guid, r144) == false) goto L117;
    L122:
        SelectFieldOption r148 = (SelectFieldOption) r147;
        if (r148 == null) goto L110;
        r142.add(r148);
        goto L110
    L121:
        r147 = null;
        goto L122
    L125:
        Unit r149 = Unit.INSTANCE;
    L127:
        if (r142.size() <= 1) goto L129;
        CollectionsKt.sortWith(r142, new e());
    L129:
        ArrayList r150 = new ArrayList();
        if (r139 == null) goto L139;
        List<SelectFieldOption> r151 = r139.options;
        if (r151 == null) goto L139;
        List r152 = new ArrayList();
        Iterator r153 = r151.iterator();
    L135:
        if (r153.hasNext() == false) goto L140;
        Object r154 = r153.next();
        if ((!((SelectFieldOption) r154).is_hidden.booleanValue()) == false) goto L135;
        r152.add(r154);
    L140:
        r150.addAll(r152);
        if (r150.size() <= 1) goto L143;
        CollectionsKt.sortWith(r150, new c());
    L143:
        Unit r155 = Unit.INSTANCE;
        this.f443847l = new f(r142, r150);
        return;
    L139:
        r152 = CollectionsKt.emptyList();
    L105:
        r141 = null;
        goto L106
    L100:
        r139 = null;
        goto L101
    L144:
        TaskFieldSettings r156 = r100.settings;
        if (r156 == null) goto L147;
        SingleSelectFieldSettings r157 = r156.single_select_field_settings;
    L148:
        if (r110 == null) goto L152;
        SingleSelectFieldValue r158 = r110.single_select_field_value;
        if (r158 == null) goto L152;
        String r159 = r158.value;
    L153:
        if (r157 == null) goto L163;
        List<SelectFieldOption> r160 = r157.options;
        if (r160 == null) goto L163;
        Iterator r161 = r160.iterator();
    L158:
        if (r161.hasNext() == false) goto L162;
        Object r162 = r161.next();
        if (Intrinsics.areEqual(((SelectFieldOption) r162).guid, r159) == false) goto L158;
        r107 = r162;
    L162:
        r108 = (SelectFieldOption) r107;
    L163:
        ArrayList r163 = new ArrayList();
        if (r157 == null) goto L173;
        List<SelectFieldOption> r164 = r157.options;
        if (r164 == null) goto L173;
        List r165 = new ArrayList();
        Iterator r166 = r164.iterator();
    L169:
        if (r166.hasNext() == false) goto L174;
        Object r167 = r166.next();
        if ((!((SelectFieldOption) r167).is_hidden.booleanValue()) == false) goto L169;
        r165.add(r167);
    L174:
        r163.addAll(r165);
        if (r163.size() <= 1) goto L177;
        CollectionsKt.sortWith(r163, new d());
    L177:
        Unit r168 = Unit.INSTANCE;
        this.f443846k = new i(r108, r163);
        return;
    L173:
        r165 = CollectionsKt.emptyList();
    L152:
        r159 = null;
        goto L153
    L147:
        r157 = null;
        goto L148
    L178:
        TaskFieldSettings r169 = r100.settings;
        if (r169 == null) goto L181;
        DatetimeFieldSettings r170 = r169.datetime_field_settings;
    L182:
        if (r170 == null) goto L184;
        r103 = r170.format;
    L184:
        if (r103 == null) goto L187;
        r101 = b.f443848a[r103.ordinal()];
    L187:
        if (r101 == 1) goto L195;
        if (r101 == 2) goto L194;
        if (r101 == 3) goto L193;
        if (r101 != 4) goto L195;
        String r171 = "dd/MM/yyyy";
    L196:
        if (r110 == null) goto L248;
        DatetimeFieldValue r172 = r110.datetime_field_value;
        if (r172 == null) goto L249;
        Long r173 = r172.value;
        if (r173 == null) goto L250;
        long r174 = r173.longValue();
        if (r174 == 0) goto L251;
        this.f443845j = new com.ss.android.lark.todo.impl.features.detail.viewmodel.data.c(new SimpleDateFormat(r171, Locale.getDefault()).format(new Date(r174)));
        return;
    L251:
        return;
    L250:
        return;
    L249:
        return;
    L248:
        return;
    L193:
        r171 = "MM/dd/yyyy";
        goto L196
    L194:
        r171 = "yyyy/MM/dd";
    L195:
        r171 = "yyyy-MM-dd";
        goto L196
    L181:
        r170 = null;
        goto L182
    }
}
