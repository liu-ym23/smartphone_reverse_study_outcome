package xka;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class o implements vka.b<Boolean> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f564354f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f564357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f564358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f564359e;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(vka.f.f555548a, PerfLog.PARAM_KEY_CONTEXT_ID);
        final Uri r100 = CalendarContract.Colors.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", this.f564355a).appendQueryParameter("account_type", this.f564356b).build();
        if (this.f564357c == null) goto L5;
        final ContentValues r101 = new ContentValues();
        r101.put("account_name", this.f564355a);
        r101.put("account_type", this.f564356b);
        r101.put("color_type", this.f564357c);
        r101.put("color_index", this.f564358d);
        r101.put("color", Integer.valueOf(this.f564359e));
        Function0 r102 = new m(r100, r101);
    L7:
        return (Boolean) r102.invoke();
    L5:
        final ContentValues r103 = new ContentValues();
        r103.put("account_name", this.f564355a);
        r103.put("account_type", this.f564356b);
        r103.put("color", Integer.valueOf(this.f564359e));
        vka.k r104 = new vka.k();
        r104.a("account_type", this.f564356b);
        r104.a("account_name", this.f564355a);
        r104.a("color_index", this.f564358d);
        Pair<String, String[]> r105 = r104.b();
        final String r106 = r105.component1();
        final String[] r107 = r105.component2();
        r102 = new n(r100, r103, r106, r107);
        goto L7
    }

    public o(String r100, String r101, Integer r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "accountName");
        Intrinsics.checkNotNullParameter(r101, "accountType");
        Intrinsics.checkNotNullParameter(r103, "colorKey");
        this.f564355a = r100;
        this.f564356b = r101;
        this.f564357c = r102;
        this.f564358d = r103;
        this.f564359e = r104;
    }
}
