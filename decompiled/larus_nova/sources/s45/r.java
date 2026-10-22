package s45;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pattern> f540605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f540606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f540607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f540608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f540609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f540610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f540611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f540612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f540613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f540614j;

    public r(String r100) {
        this.f540605a = new CopyOnWriteArrayList();
        this.f540606b = new CopyOnWriteArrayList();
        this.f540607c = new CopyOnWriteArraySet();
        this.f540608d = new CopyOnWriteArraySet();
        this.f540609e = "";
        this.f540610f = new CopyOnWriteArraySet();
        this.f540611g = "";
        this.f540612h = false;
        this.f540613i = r100;
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f540612h = r101.h("ccm.mobile.domain_regex_opt");
        this.f540614j = r101.h("ccm.mobile.need_match_domain");
        tt5.a.h("WhiteList", "mIpProxy = " + r100);
    }

    public final void a(String r110, String r111) {
        if (TextUtils.isEmpty(r110) == false) goto L7;
        tt5.a.h("WhiteList", "mergeDomain()...empty domain");
        return;
    L7:
        if (this.f540614j == false) goto L14;
        if (TextUtils.equals(r110, this.f540613i) == true) goto L14;
        String r100 = r110.trim().toLowerCase(Locale.US);
        if (TextUtils.isEmpty(r100) == true) goto L14;
        ((CopyOnWriteArraySet) this.f540608d).add(r100);
    L14:
        if (this.f540612h == true) goto L16;
        monitor-enter(this);
        String r101 = "";
        if (TextUtils.isEmpty(r110) == false) goto L39;
        monitor-exit(this);
    L53:
        if (TextUtils.isEmpty(r101) == false) goto L55;
        return;
    L55:
        if (((CopyOnWriteArrayList) this.f540606b).contains(r101) == true) goto L64;
        ((CopyOnWriteArrayList) this.f540606b).add(r101);
        ((CopyOnWriteArrayList) this.f540605a).add(PatternProtector.compile(r101));
        return;
    L64:
        return;
    L39:
        String r102 = r110.replace(".", EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Throwable -> L58
        if (r111 != null) goto L42;
        r111 = "";
    L42:
        String r103 = "(\\/|\\.)";
        if (TextUtils.equals(r110, this.f540613i) == false) goto L46;
        r103 = "";
    L46:
        if (r111.startsWith(HTTP.URL_DEFAULT) == false) goto L50;
        r101 = r103 + r102 + r111;     // Catch: Throwable -> L58
        monitor-exit(this);
        goto L53
    L50:
        r101 = r103 + r102 + HTTP.URL_DEFAULT + r111;     // Catch: Throwable -> L58
        monitor-exit(this);
    L58:
        th = move-exception;
        throw th;
    L16:
        if (TextUtils.equals(r110, this.f540613i) == false) goto L18;
        String r104 = "";
    L20:
        if (TextUtils.isEmpty(r104) == true) goto L27;
        Set<String> r105 = this.f540607c;
        if (TextUtils.equals(r110, this.f540613i) == false) goto L24;
        String r112 = "";
    L25:
        ((CopyOnWriteArraySet) r105).add(r112);
        goto L27
    L24:
        r112 = r110.replace(".", EasyGoConstant.VERSION_SEPARATIVE_SIGN);
    L27:
        if (TextUtils.isEmpty(r111) == true) goto L33;
        Set<String> r113 = this.f540610f;
        if (r111.startsWith(HTTP.URL_DEFAULT) == true) goto L32;
        r111 = HTTP.URL_DEFAULT.concat(r111);
    L32:
        ((CopyOnWriteArraySet) r113).add(r111);
    L33:
        this.f540609e = CollectionsKt.joinToString(this.f540607c, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "(", ")", -1, "...", null);
        this.f540611g = CollectionsKt.joinToString(this.f540610f, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "(", ")", -1, "...", null);
        return;
    L18:
        r104 = r110.replace(".", EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        goto L20
    }
}
