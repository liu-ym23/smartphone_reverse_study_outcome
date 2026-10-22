package k8c;

import com.bytedance.lark.pb.basic.v1.LanguageType;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import g7c.l;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f502137a = 0;

    static {
    }

    public a() {
    }

    public static long c() {
        GregorianCalendar r100 = new GregorianCalendar();
        r100.add(5, 8);
        r100.set(11, 18);
        r100.set(12, 0);
        r100.set(13, 0);
        return r100.getTimeInMillis();
    }

    public static long d() {
        GregorianCalendar r100 = new GregorianCalendar();
        r100.add(5, 7);
        r100.set(11, 18);
        r100.set(12, 0);
        r100.set(13, 0);
        return r100.getTimeInMillis();
    }

    public static long e() {
        GregorianCalendar r100 = new GregorianCalendar();
        r100.add(5, -1);
        r100.set(11, 18);
        r100.set(12, 0);
        r100.set(13, 0);
        return r100.getTimeInMillis();
    }

    public static long g() {
        GregorianCalendar r100 = new GregorianCalendar();
        GregorianCalendar r101 = new GregorianCalendar();
        r101.set(11, 17);
        r101.set(12, 0);
        r101.set(13, 0);
        if (r100.getTimeInMillis() >= r101.getTimeInMillis()) goto L5;
        r101.set(11, 18);
        return r101.getTimeInMillis();
    L5:
        r100.add(11, 2);
        r100.set(12, 0);
        r100.set(13, 0);
        GregorianCalendar r102 = new GregorianCalendar();
        r102.set(11, 23);
        r102.set(12, 59);
        r102.set(13, 59);
        return Math.min(r100.getTimeInMillis(), r102.getTimeInMillis());
    }

    public static long i() {
        GregorianCalendar r100 = new GregorianCalendar();
        r100.add(5, 1);
        r100.set(11, 18);
        r100.set(12, 0);
        r100.set(13, 0);
        return r100.getTimeInMillis();
    }

    public static long j() {
        GregorianCalendar r100 = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        r100.add(5, 1);
        r100.set(11, 0);
        r100.set(12, 0);
        r100.set(13, 0);
        r100.set(14, 0);
        return r100.getTimeInMillis();
    }

    public static LanguageType f() {
        l r100 = TodoDependencyHolder.a().languageDependency();
        if (r100.isZh() == false) goto L6;
        return LanguageType.ZH_CN;
    L6:
        if (r100.isEn() == false) goto L9;
        return LanguageType.EN_US;
    L9:
        if (r100.a() == false) goto L12;
        return LanguageType.JA_JP;
    L12:
        if (r100.c() == false) goto L15;
        return LanguageType.ES_ES;
    L15:
        if (r100.d() == false) goto L18;
        return LanguageType.IT_IT;
    L18:
        if (r100.i() == false) goto L21;
        return LanguageType.DE_DE;
    L21:
        if (r100.o() == false) goto L24;
        return LanguageType.FR_FR;
    L24:
        if (r100.l() == false) goto L27;
        return LanguageType.PT_BR;
    L27:
        if (r100.isId() == false) goto L30;
        return LanguageType.ID_ID;
    L30:
        if (r100.f() == false) goto L33;
        return LanguageType.ID_ID;
    L33:
        if (r100.g() == false) goto L36;
        return LanguageType.VI_VN;
    L36:
        if (r100.n() == false) goto L39;
        return LanguageType.TH_TH;
    L39:
        if (r100.m() == false) goto L42;
        return LanguageType.KO_KR;
    L42:
        if (r100.b() == false) goto L45;
        return LanguageType.RU_RU;
    L45:
        if (r100.j() == false) goto L48;
        return LanguageType.HI_IN;
    L48:
        if (r100.e() == false) goto L51;
        return LanguageType.ZH_HK;
    L51:
        if (r100.k() == false) goto L54;
        return LanguageType.ZH_TW;
    L54:
        if (r100.h() == false) goto L57;
        return LanguageType.MS_MY;
    L57:
        return LanguageType.UNKNOWN_LANGUAGE;
    }

    public static long h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "timeZoneStr");
        GregorianCalendar r101 = new GregorianCalendar();
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r101.setTimeZone(TimeZone.getTimeZone(r100));
    L8:
        r101.set(11, 0);
        r101.set(12, 0);
        r101.set(13, 0);
        r101.set(14, 0);
        return r101.getTimeInMillis();
    L5:
        r102 = false;
        goto L6
    }

    public static GregorianCalendar a(int r100, int r101, int r102) {
        GregorianCalendar r103 = new GregorianCalendar();
        r103.setTimeZone(TimeZone.getTimeZone("UTC"));
        r103.set(1, r100);
        r103.set(2, r101);
        r103.set(5, r102);
        r103.set(11, 0);
        r103.set(12, 0);
        r103.set(13, 0);
        r103.set(14, 0);
        return r103;
    }

    public static GregorianCalendar b(int r100, int r101, int r102, int r103, int r104, int r105) {
        if ((r105 & 8) == 0) goto L6;
        r103 = 0;
    L6:
        if ((r105 & 16) == 0) goto L8;
        r104 = 0;
    L8:
        GregorianCalendar r106 = new GregorianCalendar();
        r106.set(1, r100);
        r106.set(2, r101);
        r106.set(5, r102);
        r106.set(11, r103);
        r106.set(12, r104);
        r106.set(13, 0);
        r106.set(14, 0);
        return r106;
    }
}
