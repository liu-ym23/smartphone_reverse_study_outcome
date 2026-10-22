package xka;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a implements vka.b<Unit> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f564247i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f564248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f564250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f564251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f564252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f564253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f564254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f564255h;

    /* JADX INFO: renamed from: xka.a$a, reason: collision with other inner class name */
    public static final class C8248a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(vka.f.f555548a, PerfLog.PARAM_KEY_CONTEXT_ID);
        ContentValues r100 = new ContentValues();
        r100.put("event_id", Long.valueOf(this.f564248a));
        r100.put("attendeeName", this.f564249b);
        r100.put("attendeeEmail", this.f564250c);
        r100.put("attendeeRelationship", this.f564251d);
        r100.put("attendeeType", this.f564252e);
        r100.put("attendeeStatus", this.f564253f);
        r100.put("attendeeIdentity", this.f564254g);
        r100.put("attendeeIdNamespace", this.f564255h);
        ContentResolver r101 = vka.f.d();
        Uri r102 = CalendarContract.Attendees.CONTENT_URI;
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r102, r100};
        f06.b r112 = new f06.b();
        g06.a r103 = ApiHookConfig.f245611b.get(240017);
        if (r103 == null) goto L5;
        f06.a[] r104 = r103.f479473i;
    L6:
        f06.a[] r113 = r104;
        int r114 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r114) goto L15;
        f06.a r106 = r113[r105];
        int r115 = r105;
        int r210 = r114;
        f06.a[] r211 = r113;
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r101, r111, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r110.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L19;
        Uri r108 = (Uri) r107.f474983b;
    L21:
        return Unit.INSTANCE;
    L19:
        r101.insert(r102, r100);
    L14:
        r105 = r115 + 1;
        r114 = r210;
        r113 = r211;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r104 = ApiHookConfig.f245613d;
        goto L6
    }

    public a(long r100, String r101, String r102, Integer r103, Integer r104, Integer r105, String r106, String r107) {
        this.f564248a = r100;
        this.f564249b = r101;
        this.f564250c = r102;
        this.f564251d = r103;
        this.f564252e = r104;
        this.f564253f = r105;
        this.f564254g = r106;
        this.f564255h = r107;
    }
}
