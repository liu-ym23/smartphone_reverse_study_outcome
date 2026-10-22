package il7;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes22.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f490338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f490339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f490340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f490341d;

    public final void a() {
        Application r100 = rk7.m.f538347a;
        ik7.b r101 = rk7.m.f538351e;
        if (r101 == null) goto L11;
        an7.c r102 = ((dn7.b) r101).f469364a;
        if (r102 == null) goto L11;
        an7.d r103 = r102.f4554c;
        if (r103 == null) goto L11;
        bn7.d r104 = r103.f4555a;
        if (r104 == null) goto L11;
        r104.b();
    L11:
        int r105 = this.f490340c;
        if (r105 != 0) goto L15;
        Context r106 = this.f490338a;
        String r107 = this.f490339b;
        int r108 = this.f490341d;
        Context r109 = r106.getApplicationContext();
        View r110 = LayoutInflater.from(r109).inflate(R.layout.luckydog_layout_text_toast, null);
        ((TextView) r110.findViewById(R.id.tv_toast_message)).setText(r107);
        o.b(r109, r108, r110);
        return;
    L15:
        Context r111 = this.f490338a;
        String r112 = this.f490339b;
        int r113 = this.f490341d;
        Context r114 = r111.getApplicationContext();
        View r115 = LayoutInflater.from(r114).inflate(R.layout.luckydog_layout_toast_black, null);
        ((TextView) r115.findViewById(R.id.toast_text)).setText(r112);
        ((ImageView) r115.findViewById(R.id.iv_icon)).setImageResource(r105);
        o.b(r114, r113, r115);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(Context r100, String r101) {
        this.f490338a = r100;
        this.f490339b = r101;
        this.f490340c = 0;
        this.f490341d = 0;
    }
}
