package lpa;

import com.lynx.clay.embedding.engine.utils.TimingClient;
import com.relax.RelaxView;
import com.relax.embedding.LLog;
import com.relax.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements TimingClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f510275a;

    @Override // com.lynx.clay.embedding.engine.utils.TimingClient
    public final void onTimingSetup(HashMap<String, Long> r100) {
        if (this.f510275a == null) goto L11;
        HashMap r101 = new HashMap();
        Iterator<Map.Entry<String, Long>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, Long> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());
        LLog.i("onTimingSetup:  key: " + r103.getKey() + " value: " + r103.getValue());
        goto L6
    L8:
        this.f510275a.getClass();
        return;
    }

    public e(v r100, RelaxView r101) {
        this.f510275a = r100;
    }

    @Override // com.lynx.clay.embedding.engine.utils.TimingClient
    public final void onTimingUpdate(HashMap<String, Long> r100, String r101) {
        if (this.f510275a == null) goto L11;
        HashMap r102 = new HashMap();
        Iterator<Map.Entry<String, Long>> r103 = r100.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, Long> r104 = r103.next();
        r102.put(r104.getKey(), r104.getValue());
        LLog.i("onTimingUpdate:  key: " + r104.getKey() + " value: " + r104.getValue() + " flag:" + r101);
        goto L6
    L8:
        this.f510275a.getClass();
        return;
    }
}
