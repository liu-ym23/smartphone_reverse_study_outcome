package sl5;

import android.content.Context;
import com.bytedance.ee.bear.reminder.model.EAlertTimeEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements pp5.a {
    public final List<EAlertTimeEvent> a;
    public final Context b;

    public final int b() {
        return ((ArrayList) this.a).size();
    }

    public a(Context r2) {
        this.a = new ArrayList();
        this.b = r2;
    }

    public final Object a(int r3) {
        if (r3 >= 0) goto L4;
    L7:
        return "";
    L4:
        if (r3 >= ((ArrayList) this.a).size()) goto L7;
        return this.b.getString(((EAlertTimeEvent) ListProtector.get(this.a, r3)).getRes());
    }
}
