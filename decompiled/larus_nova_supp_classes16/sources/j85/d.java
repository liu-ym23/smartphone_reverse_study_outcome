package j85;

import androidx.lifecycle.Observer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements Observer<Map<String, Long>> {
    public final /* synthetic */ String a;

    public d(String r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Long r4 = (Long) ((Map) r3).get(this.a);
        n85.b r0 = n85.b.a.a;
        String r1 = this.a;
        r0.b.put(r1, r4);
    }
}
