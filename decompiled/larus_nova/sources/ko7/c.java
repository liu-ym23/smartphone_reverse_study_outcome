package ko7;

import android.text.TextUtils;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.ug.sdk.share.impl.manager.h;
import com.bytedance.ug.sdk.share.impl.network.model.TokenRefluxInfo;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import oo7.k;
import oo7.q;
import oo7.r;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f504526a;

    public class a implements in7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f504527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f504528b;

        public a(c r100, String r101) {
            this.f504528b = r100;
            this.f504527a = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f504529a = null;

        static {
            f504529a = new c();
        }
    }

    public c() {
    }

    public static String a(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L19;
        Matcher r102 = PatternProtector.compile(r101).matcher(r100);     // Catch: Exception -> L11
        if (r102.find() == false) goto L18;
        return r102.group();
    L18:
        return null;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L19:
        return null;
    }

    public static boolean b(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r101 != 1) goto L9;
        List<TokenRefluxInfo> r102 = h.g.f272345a.e();
    L12:
        if (r102 != null) goto L14;
    L23:
        return false;
    L14:
        if (r102.isEmpty() == true) goto L23;
        Iterator<TokenRefluxInfo> r103 = r102.iterator();
    L17:
        if (r103.hasNext() == false) goto L23;
        TokenRefluxInfo r104 = r103.next();
        if ("niu".equals(r104.getId()) == false) goto L17;
        if (TextUtils.isEmpty(a(r100, r104.getToken())) == true) goto L17;
        return true;
    L9:
        if (r101 != 2) goto L11;
        r102 = h.g.f272345a.f();
        goto L12
    L11:
        r102 = h.g.f272345a.d();
        goto L12
    }

    public final void c(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (r101 == 1) goto L10;
        if (r101 == 2) goto L10;
        String r102 = "token";
    L11:
        a r103 = new a(this, r102);
        eo7.a r104 = eo7.a.b.f473353a;
        if (b(r100, r101) == false) goto L14;
        k.e("TokenParseManager", "parse token info is pending");
        return;
    L14:
        this.f504526a = true;
        if (r101 != 1) goto L17;
        String r105 = "image";
    L20:
        k.e("TokenParseManager", "start parsing token info");
        jo7.c.a(new q("reflow", "request flow request", null, r.f524639a));
        jo7.c.a(new io7.a(r100, r105, new ko7.b(this, r101, r103)));
        return;
    L17:
        if (r101 != 2) goto L19;
        r105 = "video";
        goto L20
    L19:
        r105 = DataType.CLIPBOARD;
    L10:
        r102 = "hidden_mark";
        goto L11
    }
}
