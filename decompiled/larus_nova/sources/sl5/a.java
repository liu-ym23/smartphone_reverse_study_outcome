package sl5;

import android.content.Context;
import com.bytedance.ee.bear.reminder.model.EAlertTimeEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements pp5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<EAlertTimeEvent> f542465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f542466b;

    public final int b() {
        return ((ArrayList) this.f542465a).size();
    }

    public a(Context r100) {
        this.f542465a = new ArrayList();
        this.f542466b = r100;
    }

    public final Object a(int r100) {
        if (r100 >= 0) goto L4;
    L7:
        return "";
    L4:
        if (r100 >= ((ArrayList) this.f542465a).size()) goto L7;
        return this.f542466b.getString(((EAlertTimeEvent) ListProtector.get(this.f542465a, r100)).getRes());
    }
}
