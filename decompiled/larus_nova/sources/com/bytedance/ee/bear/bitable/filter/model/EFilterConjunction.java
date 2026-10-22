package com.bytedance.ee.bear.bitable.filter.model;

import android.text.TextUtils;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0006\u0010\u000b\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/EFilterConjunction;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "And", "Or", "toString", "getReportText", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EFilterConjunction extends Enum<EFilterConjunction> {
    public static final EFilterConjunction And = null;
    public static final a Companion = null;
    public static final EFilterConjunction Or = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EFilterConjunction[] f211873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f211874b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static EFilterConjunction a(String r100) {
            EFilterConjunction[] r101 = EFilterConjunction.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            EFilterConjunction r104 = r101[r103];
            if (TextUtils.equals(r104.getValue(), r100) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f211875a = null;

        static {
            int[] r100 = new int[EFilterConjunction.values().length];
            r100[EFilterConjunction.And.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[EFilterConjunction.Or.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f211875a = r100;
        }
    }

    public static EnumEntries<EFilterConjunction> getEntries() {
        return f211874b;
    }

    @JvmStatic
    public static final EFilterConjunction lookup(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        EFilterConjunction r100 = new EFilterConjunction("And", 0, "and");
        And = r100;
        EFilterConjunction r101 = new EFilterConjunction("Or", 1, SRStrategy.KEY_ORIGIN_RESOLUTION);
        Or = r101;
        EFilterConjunction[] r102 = {r100, r101};
        f211873a = r102;
        f211874b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static EFilterConjunction[] values() {
        return (EFilterConjunction[]) f211873a.clone();
    }

    public final String getReportText() {
        int r100 = b.f211875a[ordinal()];
        if (r100 != 1) goto L5;
        return "all_condition";
    L5:
        if (r100 != 2) goto L8;
        return "any_condition";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static EFilterConjunction valueOf(String r100) {
        return (EFilterConjunction) r27.a.a(EFilterConjunction.class, r100);
    }

    public EFilterConjunction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
