package nab;

import com.bytedance.lark.pb.basic.v1.LanguageType;
import com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek;
import com.ss.android.lark.custom.repeat.entity.CalendarDate;
import com.ss.android.lark.custom.repeat.entity.RepeatMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RepeatMode f518485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CustomRepeatParams$DayOfWeek f518486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f518487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f518488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f518489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CalendarDate f518490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f518491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f518492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LanguageType f518493i;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f518485a, r101.f518485a) == true) goto L12;
        return false;
    L12:
        if (this.f518486b == r101.f518486b) goto L15;
        return false;
    L15:
        if (this.f518487c == r101.f518487c) goto L18;
        return false;
    L18:
        if (this.f518488d == r101.f518488d) goto L21;
        return false;
    L21:
        if (this.f518489e == r101.f518489e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f518490f, r101.f518490f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f518491g, r101.f518491g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f518492h, r101.f518492h) == true) goto L33;
        return false;
    L33:
        if (this.f518493i == r101.f518493i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        RepeatMode r100 = this.f518485a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f518486b.hashCode()) * 31;
        int r104 = 1231;
        if (this.f518487c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f518488d == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f518489e == true) goto L18;
        r104 = 1237;
    L18:
        int r109 = (((r108 + r104) * 31) + this.f518490f.hashCode()) * 31;
        Integer r110 = this.f518491g;
        if (r110 != null) goto L21;
        int r111 = 0;
    L22:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f518492h;
        if (r113 == null) goto L27;
        r101 = r113.hashCode();
    L27:
        return ((r112 + r101) * 31) + this.f518493i.hashCode();
    L21:
        r111 = r110.hashCode();
        goto L22
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CustomRepeatData(lastRepeatMode=" + this.f518485a + ", firstDayOfWeek=" + this.f518486b + ", isSingleInWeek=" + this.f518487c + ", isSingleInMonth=" + this.f518488d + ", isFixDefaultDate=" + this.f518489e + ", defaultDate=" + this.f518490f + ", bannedUnselectedStringId=" + this.f518491g + ", bannedSlideStringId=" + this.f518492h + ", languageType=" + this.f518493i + ')';
    }

    public /* synthetic */ a(int r110) {
        this(null, CustomRepeatParams$DayOfWeek.SUNDAY, false, false, false, new CalendarDate(), null, null, LanguageType.UNKNOWN_LANGUAGE);
    }

    public a(RepeatMode r100, CustomRepeatParams$DayOfWeek r101, boolean r102, boolean r103, boolean r104, CalendarDate r105, Integer r106, Integer r107, LanguageType r110) {
        Intrinsics.checkNotNullParameter(r101, "firstDayOfWeek");
        Intrinsics.checkNotNullParameter(r105, "defaultDate");
        Intrinsics.checkNotNullParameter(r110, "languageType");
        this.f518485a = r100;
        this.f518486b = r101;
        this.f518487c = r102;
        this.f518488d = r103;
        this.f518489e = r104;
        this.f518490f = r105;
        this.f518491g = r106;
        this.f518492h = r107;
        this.f518493i = r110;
    }
}
