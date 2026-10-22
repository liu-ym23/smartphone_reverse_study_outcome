package mm6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import en6.n;
import fo6.d;
import fo6.e;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f514484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f514485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f514486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f514487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Intent f514488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public yt6.b f514489f;

    public final void a() {
        CopyOnWriteArrayList<d> r100 = e.f478167a;
        String r101 = this.f514485b;
        Intrinsics.checkNotNullParameter(r101, "schema");
        Uri r102 = UriProtector.parse(r101);     // Catch: Exception -> L34
        Intrinsics.checkNotNullParameter(r102, "uri");
        if (e.b(r102) == null) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L16;
        yt6.b r104 = this.f514489f;
        if (r104 == null) goto L13;
        r104.a(this.f514485b);
    L13:
        if (HostServiceUtilsKt.u().m() == false) goto L37;
        Toast.makeText(this.f514484a, "路由 " + this.f514485b + " 匹配失败。", 0).show();
        return;
    L37:
        return;
    L16:
        this.f514488e.putExtra("launch_timestamps", SystemClock.elapsedRealtime());
        if (e.c(this.f514484a, this.f514485b, this.f514488e) == false) goto L27;
        yt6.b r105 = this.f514489f;
        if (r105 == null) goto L22;
        r105.onSuccess();
    L22:
        if (this.f514486c == (-1)) goto L24;
    L25:
        Context r106 = this.f514484a;
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.app.Activity");
        ((Activity) r106).overridePendingTransition(this.f514486c, this.f514487d);
        return;
    L24:
        if (this.f514487d != (-1)) goto L25;
        return;
    L27:
        yt6.b r107 = this.f514489f;
        if (r107 == null) goto L31;
        r107.onFail(this.f514485b);
    L31:
        if (HostServiceUtilsKt.u().m() == false) goto L39;
        Toast.makeText(this.f514484a, "页面 " + this.f514485b + " 打开失败。", 0).show();
        return;
    L39:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public final a b(n.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f514489f = r100;
        return this;
    }

    public final a c(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        this.f514488e.putExtras(r100);
        return this;
    }

    public final a d(PoiBundle r100) {
        Intrinsics.checkNotNullParameter("poi_bundle", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f514488e.putExtra("poi_bundle", r100);
        return this;
    }

    public a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        this.f514484a = r100;
        this.f514485b = r101;
        this.f514486c = -1;
        this.f514487d = -1;
        this.f514488e = new Intent();
    }

    public final a e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f514488e.putExtra(r100, r101);
        return this;
    }
}
