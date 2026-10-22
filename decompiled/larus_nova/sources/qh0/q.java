package qh0;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.log.j0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class q implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f532937a;

    public q(Map r100) {
        this.f532937a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        r100.dismiss();
        j0.l().sendLog("livesdk_anchor_face_recognition_cancel_click", this.f532937a, new Object[0]);
    }
}
