package wvb;

import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.supervisor.token.Token;
import com.larus.nova.R;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.lark.location.dto.POIConfig;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f561602a = 0;

    static {
    }

    public static void a(FragmentActivity r110, gqb.a r111) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "listener");
        Application r100 = LarkContext.getApplication();
        if (r100 != null) goto L6;
        int r112 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.FOUNDATION, EventVerify.TYPE_LAUNCH, "context is null", null);
        return;
    L6:
        POIConfig r101 = new POIConfig();
        r101.setActionText(r100.getString(R.string.MMWeb_G_UpdateLocation_Save_Button));
        r101.setSnapshot(false);
        r101.setSelfDefine(false);
        fqb.a.c(r110, null, r101, new Token("LARK-PSDA-mm_image_share_location"), Scene.Minutes.INSTANCE, r111, false, true);
    }
}
