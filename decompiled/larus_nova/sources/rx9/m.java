package rx9;

import com.larus.applog.api.IApplog;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f539866a;

    public /* synthetic */ m(b r100) {
        this.f539866a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r100 = this.f539866a;
        long r101 = j.a().getLong("tick_interval", 0);
        Iterator<Map.Entry<String, ?>> r102 = j.a().getAll().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L19;
        Map.Entry<String, ?> r103 = r102.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        if (r104 == null) goto L4;
        int r106 = StringsKt.indexOf$default(r104, "_total_millis", 0, false, 6, null);
        if (r106 <= 0) goto L4;
        if ((r105 instanceof Long) == false) goto L13;
        Long r107 = (Long) r105;
    L14:
        if (r107 == null) goto L4;
        long r110 = r107.longValue();
        if (r110 <= 0) goto L4;
        String r108 = r104.substring(0, r106);
        IApplog.Companion r109 = IApplog.f287053a;
        JSONObject r111 = new JSONObject();
        r111.put("step", r101);
        r111.put("duration", r110);
        r111.put(AiProactiveTaskViewModel.PARAM_TASK_TYPE, o0.a(r108));
        Unit r112 = Unit.INSTANCE;
        r109.reportEvent("app_background_usage", r111);
        s.a("TickTaskAnalyzer", "app background usage, task=" + r108 + ", result=" + r110);
        goto L4
    L13:
        r107 = null;
        goto L14
    L19:
        j.a().clear();
        j.a().storeLong("tick_interval", r100.f539839a);
    }
}
