package oh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.escape.request.EscapeRuleResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final Flowable<EscapeRuleResult> a(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new e()).a(new NetService.f(String.format(Locale.US, "/space/api/sec_label/escape_rule/approval/def?token=%s&type=%d", Arrays.copyOf(new Object[]{r4, Integer.valueOf(r5)}, 2))));
    }
}
