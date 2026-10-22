package ep2;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.config.n11;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public abstract class d<T> {

    public static final class a {
    }

    static {
    }

    public abstract String d();

    public abstract boolean e(T r100);

    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, String> b(T r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (fp2.b.e() == false) goto L5;
        String r102 = "true";
    L6:
        r101.put("isAnchor", r102);
        LiveMode r103 = fp2.b.b();
        if (r103 == null) goto L11;
        String r104 = r103.name();
        if (r104 == null) goto L11;
        String r105 = (String) r101.put("category", r104);
    L11:
        int r106 = fp2.b.c(d());
        if (r106 <= 0) goto L14;
        r101.put("sceneCode", String.valueOf(r106));
    L14:
        String r107 = fp2.b.d(d());
        if (r107 == null) goto L17;
        String r108 = (String) r101.put("scene", r107);
    L17:
        if (r100 == 0) goto L19;
        r101.put("page", r100.getClass().getName());
    L19:
        if (r100 != 0) goto L21;
    L25:
        return r101;
    L21:
        if ((r100 instanceof Fragment) == false) goto L25;
        String r109 = ((Fragment) r100).getTag();
        if (r109 == null) goto L25;
        String r110 = (String) r101.put("privacy_fragment_tag", r109);
        goto L25
    L5:
        r102 = "false";
        goto L6
    }

    public final void c(T r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L27
        if (e(r110) == true) goto L5;
    L25:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
        return;
    L5:
        if (fp2.b.e() == true) goto L17;
        String r101 = fp2.b.d(d());     // Catch: Throwable -> L27
        if (r101 != null) goto L9;
    L16:
        boolean r102 = false;
    L18:
        if (r102 == false) goto L25;
        cp2.b r103 = a(d(), r110);     // Catch: Throwable -> L27
        if (r103.f464628a != true) goto L23;
        q60.a r104 = q60.a.f531757d;     // Catch: Throwable -> L27
        q60.a.f531755b.a(d() + " start check camera");     // Catch: Throwable -> L27
        String r105 = d();     // Catch: Throwable -> L27
        Map<String, String> r106 = b(r110);     // Catch: Throwable -> L27
        com.bytedance.android.live.core.privacy.av.api.b.f65134a.getClass();     // Catch: Throwable -> L27
        r104.e("common", r105, r106, com.bytedance.android.live.core.privacy.av.api.b.a.f65135a, com.bytedance.android.live.core.privacy.av.api.a.f65132b);     // Catch: Throwable -> L27
    L23:
        if (r103.f464629b != true) goto L25;
        q60.a r107 = q60.a.f531757d;     // Catch: Throwable -> L27
        q60.a.f531755b.a(d() + " start check mic");     // Catch: Throwable -> L27
        String r108 = d();     // Catch: Throwable -> L27
        Map<String, String> r109 = b(r110);     // Catch: Throwable -> L27
        com.bytedance.android.live.core.privacy.av.api.b.f65134a.getClass();     // Catch: Throwable -> L27
        r107.c("common", r108, r109, com.bytedance.android.live.core.privacy.av.api.b.a.f65135a, com.bytedance.android.live.core.privacy.av.api.a.f65132b);     // Catch: Throwable -> L27
        goto L25
    L9:
        if ((!StringsKt.isBlank(r101)) != true) goto L16;
        Integer r111 = (Integer) hd0.c.f().f481009b;     // Catch: Throwable -> L27
        if (r111 == null) goto L16;
        if (r111.intValue() != 2) goto L16;
    L17:
        r102 = true;
    L27:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public cp2.b a(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "ruleTag");
        cp2.a r102 = new cp2.a(r100);
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L33
        n11 r104 = r102.f464626a;     // Catch: Throwable -> L33
        if (r104 == null) goto L6;
        Boolean r105 = r104.b();     // Catch: Throwable -> L33
    L8:
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L31;
        if (r100 != null) goto L12;
    L41:
        return fp2.b.a();
    L12:
        switch(r100.hashCode()) {
            case -1621407045: goto L28;
            case -1434403906: goto L25;
            case -844766084: goto L18;
            case 1450922333: goto L15;
            default: goto L41;
        };     // Catch: Throwable -> L33
    L15:
        if (r100.equals("rule_tag_new_fragment_appear") == false) goto L41;
    L39:
        return r102.b(r101);
    L18:
        if (r100.equals("rule_tag_app_enter_front") == false) goto L41;
        boolean r106 = true;
        cp2.b r107 = new cp2.b(true, true);     // Catch: Throwable -> L33
        r107.f464629b = false;     // Catch: Throwable -> L33
        if (fp2.b.b() == LiveMode.AUDIO) goto L23;
        r106 = false;
    L23:
        r107.f464628a = r106;     // Catch: Throwable -> L33
        return r107;
    L25:
        if (r100.equals("rule_tag_new_activity_appear") == false) goto L41;
    L28:
        if (r100.equals("rule_tag_app_enter_background") == false) goto L41;
        return r102.a();
    L31:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L36:
        return fp2.b.a();
    L6:
        r105 = null;
    L33:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    }
}
