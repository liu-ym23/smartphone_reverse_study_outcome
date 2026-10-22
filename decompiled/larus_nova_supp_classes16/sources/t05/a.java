package t05;

import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Flowable;
import java.util.Arrays;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Flowable a(String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "token");
        c r0 = c.a.a;
        boolean r1 = r0.i("ccm.space.new_meta_enable", true);
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        String r4 = String.format("/api/meta/?token=%s&type=%s", Arrays.copyOf(new Object[]{r8, Integer.valueOf(r9)}, 2));
        if (r9 != e.g.b) goto L6;
    L19:
        NetService.f r10 = new NetService.f(r4);
        if (r9 == e.o.b) goto L22;
    L24:
        r10.b("need_extra_fields", "3");
    L26:
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new b()).a(r10);
    L22:
        if (r0.g("ccm.mobile.doc_upgrade_to_docx_v2") == false) goto L24;
        r10.a("need_extra_fields", CollectionsKt.arrayListOf(new String[]{"3", "4"}));
        goto L26
    L6:
        if (r9 != e.h.b) goto L11;
        if (r1 == true) goto L19;
        r4 = String.format("/api/sheet/%s/", Arrays.copyOf(new Object[]{r8}, 1));
        goto L19
    L11:
        if (r9 != e.i.b) goto L16;
        if (r1 == true) goto L19;
        r4 = String.format("/api/bitable/%s/", Arrays.copyOf(new Object[]{r8}, 1));
        goto L19
    L16:
        if (r9 != e.l.b) goto L18;
        r4 = String.format("/api/meta/?token=%s&type=%s", Arrays.copyOf(new Object[]{r8, Integer.valueOf(r9)}, 2));
        goto L19
    L18:
        r4 = String.format("/api/meta/?token=%s&type=%s", Arrays.copyOf(new Object[]{r8, Integer.valueOf(r9)}, 2));
        goto L19
    }
}
