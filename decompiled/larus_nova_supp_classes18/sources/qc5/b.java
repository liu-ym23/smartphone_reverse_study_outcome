package qc5;

import com.bytedance.ee.bear.lark.dependency.e0;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        boolean r3 = r2.d.isCurrentEnable("ccm.workspace.next.sidebar_my_ai_chat_entry");
        e0 r0 = (e0) LarkContext.spiByDwarf(e0.class);
        if (r0 == null) goto L5;
        r0.k();
    L5:
        tt5.a.h("SpaceFeatureGatingV3", "isAiEnable()...enable = " + r3 + " aiEnable =false");
        return false;
    }
}
