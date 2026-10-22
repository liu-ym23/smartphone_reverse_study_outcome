package qc5;

import com.bytedance.ee.bear.lark.dependency.e0;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f532476a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        boolean r101 = r100.f23449d.isCurrentEnable("ccm.workspace.next.sidebar_my_ai_chat_entry");
        e0 r102 = (e0) LarkContext.spiByDwarf(e0.class);
        if (r102 == null) goto L5;
        r102.k();
    L5:
        tt5.a.h("SpaceFeatureGatingV3", "isAiEnable()...enable = " + r101 + " aiEnable =false");
        return false;
    }
}
