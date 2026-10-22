package gt5;

import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements byb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ft5.a f482509a;

    public a(ft5.a r100) {
        this.f482509a = r100;
    }

    @Override // byb.d
    public final void a(String r100, HashMap<String, Object> r101, HashMap<String, Object> r102) {
        HashMap r103 = new HashMap();
        if (r101 != null) goto L5;
    L7:
        if (r102 == null) goto L12;
        if ((!r102.isEmpty()) == false) goto L12;
        r103.putAll(r102);
    L12:
        if ((!r103.isEmpty()) == false) goto L16;
        JSONObject r104 = new JSONObject(r103);
        ft5.a r105 = this.f482509a;
        if (r105 == null) goto L18;
        Intrinsics.checkNotNull(r100);
        r105.reportEvent(r100, r104);
        return;
    L18:
        return;
    L16:
        Log.e("BaseMonitor", "eventName = " + r100 + " , but eventData is null so return");
        return;
    L5:
        if ((!r101.isEmpty()) == false) goto L7;
        r103.putAll(r101);
        goto L7
    }
}
