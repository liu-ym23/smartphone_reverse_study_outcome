package pfc;

import android.view.View;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f529094a;

    public r(v r100) {
        this.f529094a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        k r101 = this.f529094a.f529114p;
        if (r101 == null) goto L5;
        r101.stop();
    L5:
        ofc.a r102 = (ofc.a) this.f529094a.f529100b;
        if (r102.f523137a.f523147j != null) goto L8;
    L16:
        Statistics.sendEvent("public_pic_edit_click", new JSONObject().put("click", "confirm"));     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Log.e("PluginViewHandler", "sendClickEvent error, " + th.getMessage());
        return;
    L8:
        if (f.i().f529049a.isEmpty() == false) goto L10;
        ofc.b r103 = r102.f523137a;
        r103.f523147j.a(r103.f523148k, null);
        goto L16
    L10:
        r102.f523137a.f523147j.a(f.i().h(), f.i().f529049a);
        goto L16
    }
}
