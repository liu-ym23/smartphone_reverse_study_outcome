package pfc;

import android.view.View;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f529095a;

    public s(v r100) {
        this.f529095a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        k r101 = this.f529095a.f529114p;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        sfc.a.f541747a.getClass();
        if (sfc.a.f541758l == null) goto L13;
        Statistics.sendEvent("pic_edit_withdraw_click", null);
    L13:
        Statistics.sendEvent("public_pic_edit_click", new JSONObject().put("click", "undo"));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Log.e("PluginViewHandler", "sendClickEvent error, " + th.getMessage());
    }
}
