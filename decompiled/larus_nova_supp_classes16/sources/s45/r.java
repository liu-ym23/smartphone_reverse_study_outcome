package s45;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r {
    public final List<Pattern> a;
    public final List<String> b;
    public final Set<String> c;
    public final Set<String> d;
    public String e;
    public final Set<String> f;
    public String g;
    public final boolean h;
    public final String i;
    public final boolean j;

    public r(String r3) {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArraySet();
        this.d = new CopyOnWriteArraySet();
        this.e = "";
        this.f = new CopyOnWriteArraySet();
        this.g = "";
        this.h = false;
        this.i = r3;
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.h = r0.h("ccm.mobile.domain_regex_opt");
        this.j = r0.h("ccm.mobile.need_match_domain");
        tt5.a.h("WhiteList", "mIpProxy = " + r3);
    }

    public final void a(String r12, String r13) {
        if (TextUtils.isEmpty(r12) == false) goto L7;
        tt5.a.h("WhiteList", "mergeDomain()...empty domain");
        return;
    L7:
        if (this.j == false) goto L14;
        if (TextUtils.equals(r12, this.i) == true) goto L14;
        String r0 = r12.trim().toLowerCase(Locale.US);
        if (TextUtils.isEmpty(r0) == true) goto L14;
        ((CopyOnWriteArraySet) this.d).add(r0);
    L14:
        if (this.h == true) goto L16;
        monitor-enter(this);
        String r1 = "";
        if (TextUtils.isEmpty(r12) == false) goto L39;
        monitor-exit(this);
    L53:
        if (TextUtils.isEmpty(r1) == false) goto L55;
        return;
    L55:
        if (((CopyOnWriteArrayList) this.b).contains(r1) == true) goto L64;
        ((CopyOnWriteArrayList) this.b).add(r1);
        ((CopyOnWriteArrayList) this.a).add(PatternProtector.compile(r1));
        return;
    L64:
        return;
    L39:
        String r2 = r12.replace(".", "\\.");     // Catch: Throwable -> L58
        if (r13 != null) goto L42;
        r13 = "";
    L42:
        String r3 = "(\\/|\\.)";
        if (TextUtils.equals(r12, this.i) == false) goto L46;
        r3 = "";
    L46:
        if (r13.startsWith("/") == false) goto L50;
        r1 = r3 + r2 + r13;     // Catch: Throwable -> L58
        monitor-exit(this);
        goto L53
    L50:
        r1 = r3 + r2 + "/" + r13;     // Catch: Throwable -> L58
        monitor-exit(this);
    L58:
        th = move-exception;
        throw th;
    L16:
        if (TextUtils.equals(r12, this.i) == false) goto L18;
        String r4 = "";
    L20:
        if (TextUtils.isEmpty(r4) == true) goto L27;
        Set<String> r5 = this.c;
        if (TextUtils.equals(r12, this.i) == false) goto L24;
        String r14 = "";
    L25:
        ((CopyOnWriteArraySet) r5).add(r14);
        goto L27
    L24:
        r14 = r12.replace(".", "\\.");
    L27:
        if (TextUtils.isEmpty(r13) == true) goto L33;
        Set<String> r16 = this.f;
        if (r13.startsWith("/") == true) goto L32;
        r13 = "/".concat(r13);
    L32:
        ((CopyOnWriteArraySet) r16).add(r13);
    L33:
        this.e = CollectionsKt.joinToString(this.c, "|", "(", ")", -1, "...", null);
        this.g = CollectionsKt.joinToString(this.f, "|", "(", ")", -1, "...", null);
        return;
    L18:
        r4 = r12.replace(".", "\\.");
        goto L20
    }
}
