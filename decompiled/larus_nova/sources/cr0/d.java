package cr0;

import android.content.DialogInterface;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameanchor.preview.PreviewMiniGameDialogFragment;
import java.util.HashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PreviewMiniGameDialogFragment f465033a;

    public d(PreviewMiniGameDialogFragment r100) {
        this.f465033a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        OpenPlatformContext r102 = this.f465033a.f85274e;
        if (r102 == null) goto L8;
        AnchorMiniGameAppLogContextService r103 = (AnchorMiniGameAppLogContextService) r102.getService(AnchorMiniGameAppLogContextService.class);
        if (r103 == null) goto L9;
        HashMap<String, String> r104 = new HashMap();
        r104.put("screen_split_rate", "0.3");
        r104.put("click_type", "cancel");
        Unit r105 = Unit.INSTANCE;
        r103.reportPreviewMgAppLog("livesdk_takepage_mg_remove_pop_click", r104);
        return;
    L9:
        return;
    }
}
