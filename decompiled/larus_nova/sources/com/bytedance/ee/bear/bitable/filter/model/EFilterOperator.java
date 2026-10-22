package com.bytedance.ee.bear.bitable.filter.model;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0006\u0010\u0015\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/EFilterOperator;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Is", "IsNot", "Contains", "ContainText", "DoesNotContain", "IsEmpty", "IsNotEmpty", "IsGreater", "IsGreaterEqual", "IsLess", "IsLessEqual", "UnSupport", "toString", "getReportText", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EFilterOperator extends Enum<EFilterOperator> {
    public static final a Companion = null;
    public static final EFilterOperator ContainText = null;
    public static final EFilterOperator Contains = null;
    public static final EFilterOperator DoesNotContain = null;
    public static final EFilterOperator Is = null;
    public static final EFilterOperator IsEmpty = null;
    public static final EFilterOperator IsGreater = null;
    public static final EFilterOperator IsGreaterEqual = null;
    public static final EFilterOperator IsLess = null;
    public static final EFilterOperator IsLessEqual = null;
    public static final EFilterOperator IsNot = null;
    public static final EFilterOperator IsNotEmpty = null;
    public static final EFilterOperator UnSupport = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EFilterOperator[] f211879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f211880b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static EFilterOperator a(String r100) {
            EFilterOperator[] r101 = EFilterOperator.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            EFilterOperator r104 = r101[r103];
            if (TextUtils.equals(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return EFilterOperator.UnSupport;
        L8:
            r104 = null;
            goto L9
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f211881a = null;

        static {
            int[] r100 = new int[EFilterOperator.values().length];
            r100[EFilterOperator.Is.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r100[EFilterOperator.IsNot.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r100[EFilterOperator.Contains.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[EFilterOperator.ContainText.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[EFilterOperator.DoesNotContain.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r100[EFilterOperator.IsEmpty.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r100[EFilterOperator.IsNotEmpty.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[EFilterOperator.IsGreater.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[EFilterOperator.IsGreaterEqual.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[EFilterOperator.IsLess.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r100[EFilterOperator.IsLessEqual.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f211881a = r100;
        }
    }

    public static EnumEntries<EFilterOperator> getEntries() {
        return f211880b;
    }

    @JvmStatic
    public static final EFilterOperator lookup(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        EFilterOperator r100 = new EFilterOperator("Is", 0, "is");
        Is = r100;
        EFilterOperator r101 = new EFilterOperator("IsNot", 1, "isNot");
        IsNot = r101;
        EFilterOperator r102 = new EFilterOperator("Contains", 2, "contains");
        Contains = r102;
        EFilterOperator r103 = new EFilterOperator("ContainText", 3, "containText");
        ContainText = r103;
        EFilterOperator r104 = new EFilterOperator("DoesNotContain", 4, "doesNotContain");
        DoesNotContain = r104;
        EFilterOperator r105 = new EFilterOperator("IsEmpty", 5, "isEmpty");
        IsEmpty = r105;
        EFilterOperator r110 = new EFilterOperator("IsNotEmpty", 6, "isNotEmpty");
        IsNotEmpty = r110;
        EFilterOperator r111 = new EFilterOperator("IsGreater", 7, "isGreater");
        IsGreater = r111;
        EFilterOperator r112 = new EFilterOperator("IsGreaterEqual", 8, "isGreaterEqual");
        IsGreaterEqual = r112;
        EFilterOperator r113 = new EFilterOperator("IsLess", 9, "isLess");
        IsLess = r113;
        EFilterOperator r106 = new EFilterOperator("IsLessEqual", 10, "isLessEqual");
        IsLessEqual = r106;
        EFilterOperator r107 = new EFilterOperator("UnSupport", 11, "");
        UnSupport = r107;
        EFilterOperator[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107};
        f211879a = r108;
        f211880b = EnumEntriesKt.enumEntries(r108);
        Companion = new a();
    }

    public static EFilterOperator[] values() {
        return (EFilterOperator[]) f211879a.clone();
    }

    public final String getReportText() {
        switch(b.f211881a[ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        return "unSupport";
    L5:
        return "less_or_equal";
    L6:
        return "less";
    L7:
        return "greater_or_equal";
    L8:
        return "greater";
    L9:
        return "not_empty";
    L10:
        return "is_empty";
    L11:
        return "not_contains";
    L12:
        return "contain_text";
    L13:
        return "contains";
    L14:
        return "is_not";
    L15:
        return "is";
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static EFilterOperator valueOf(String r100) {
        return (EFilterOperator) r27.a.a(EFilterOperator.class, r100);
    }

    public EFilterOperator(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
