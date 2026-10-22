package zub;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import mcb.c;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f573670b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f573671a;

    /* JADX INFO: renamed from: zub.a$a, reason: collision with other inner class name */
    public static final class C8495a {
    }

    static {
        f573670b = new String[]{"lark_rtc", "feishu_rtc", "lark_pre_rtc", "feishu_pre_rtc", "lark_test_pre_rtc", "feishu_test_pre_rtc", "lark_test_gauss_rtc", "feishu_test_gauss_rtc", "lark_test_rtc", "feishu_test_rtc"};
    }

    public final String a() {
        String r100 = this.f573671a.a("api");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        Intrinsics.checkNotNull(r100);
        return r100;
    L6:
        return "";
    }

    public final String b() {
        List<String> r100 = this.f573671a.b("vc_mm");
        String r101 = "";
        if ((!r100.isEmpty()) == true) goto L5;
        return "";
    L5:
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).envType() != 3) goto L32;
        List<String> r102 = new Regex(EasyGoConstant.VERSION_SEPARATIVE_SIGN).split((CharSequence) ListProtector.get(r100, 0), 0);
        if (r102.isEmpty() == true) goto L17;
        ListIterator<String> r103 = r102.listIterator(r102.size());
    L10:
        if (r103.hasPrevious() == false) goto L17;
        if (r103.previous().length() != 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L10;
        List r105 = CollectionsKt.take(r102, r103.nextIndex() + 1);
    L18:
        String[] r106 = (String[]) r105.toArray(new String[0]);
        int r107 = r106.length;
        int r108 = 0;
    L19:
        if (r108 >= r107) goto L30;
        StringBuilder r109 = new StringBuilder();
        r109.append(r101);
        if (r108 != (r106.length - 2)) goto L27;
        StringBuilder r110 = new StringBuilder();
        r110.append(r106[r108]);
        if (StringsKt.endsWith$default(r106[r108], "-pre", false, 2, null) == false) goto L25;
        String r111 = ".";
    L26:
        r110.append(r111);
        String r112 = r110.toString();
    L28:
        r109.append(r112);
        r101 = r109.toString();
        r108 = r108 + 1;
        goto L19
    L25:
        r111 = "-pre.";
        goto L26
    L27:
        r112 = r106[r108] + '.';
        goto L28
    L30:
        return "https://" + r101.substring(0, r101.length() - 1);
    L14:
        r104 = false;
    L17:
        r105 = CollectionsKt.emptyList();
        goto L18
    L32:
        return "https://" + ((String) ListProtector.get(r100, 0));
    }

    public final String c() {
        String r100 = this.f573671a.a("vc_mm");
        if (TextUtils.isEmpty(r100) == true) goto L6;
        Intrinsics.checkNotNull(r100);
        return r100;
    L6:
        return "";
    }

    public final String d() {
        List<String> r100 = this.f573671a.b("vc_web");
        String r101 = "";
        if ((!r100.isEmpty()) == true) goto L5;
        return "";
    L5:
        if (((gpb.a) ApiUtils.getApi(gpb.a.class)).envType() != 3) goto L32;
        List<String> r102 = new Regex(EasyGoConstant.VERSION_SEPARATIVE_SIGN).split((CharSequence) ListProtector.get(r100, 0), 0);
        if (r102.isEmpty() == true) goto L17;
        ListIterator<String> r103 = r102.listIterator(r102.size());
    L10:
        if (r103.hasPrevious() == false) goto L17;
        if (r103.previous().length() != 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L10;
        List r105 = CollectionsKt.take(r102, r103.nextIndex() + 1);
    L18:
        String[] r106 = (String[]) r105.toArray(new String[0]);
        int r107 = r106.length;
        int r108 = 0;
    L19:
        if (r108 >= r107) goto L30;
        StringBuilder r109 = new StringBuilder();
        r109.append(r101);
        if (r108 != (r106.length - 2)) goto L27;
        StringBuilder r110 = new StringBuilder();
        r110.append(r106[r108]);
        if (StringsKt.endsWith$default(r106[r108], "-pre", false, 2, null) == false) goto L25;
        String r111 = ".";
    L26:
        r110.append(r111);
        String r112 = r110.toString();
    L28:
        r109.append(r112);
        r101 = r109.toString();
        r108 = r108 + 1;
        goto L19
    L25:
        r111 = "-pre.";
        goto L26
    L27:
        r112 = r106[r108] + '.';
        goto L28
    L30:
        return "https://" + r101.substring(0, r101.length() - 1);
    L14:
        r104 = false;
    L17:
        r105 = CollectionsKt.emptyList();
        goto L18
    L32:
        return "https://" + ((String) ListProtector.get(r100, 0));
    }

    public final List<String> e() {
        List<String> r100 = this.f573671a.b("rtc_defaultips");
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<String> g() {
        return this.f573671a.b("rtc_frontier");
    }

    public a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "userDomainConfig");
        this.f573671a = r100;
    }

    public final List<String> f(String r100) {
        String[] r101 = f573670b;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        String r104 = r101[r103];
        if (TextUtils.equals(r100, r104) == true) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return this.f573671a.b(r104);
    L10:
        return CollectionsKt.emptyList();
    }
}
