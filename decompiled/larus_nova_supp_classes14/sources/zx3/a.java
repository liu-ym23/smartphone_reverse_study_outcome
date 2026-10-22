package zx3;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.apps.framework.utils.u;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public int a;
    public final String b;
    public final Context c;
    public Toast d;

    public final void d() {
        AoLogger.b("DmtToast", new Object[]{"start to show toast!"});
    L18:
        e = move-exception;
        AoLogger.b("DmtToast", new Object[]{"show toast fail " + e.getMessage()});
        e.printStackTrace();
        return;
    L4:
        if (this.c != null) goto L6;
        return;
    L6:
        AoLogger.b("DmtToast", new Object[]{"context check!"});     // Catch: Exception -> L18
        if (TextUtils.isEmpty(this.b) == false) goto L9;
        return;
    L9:
        AoLogger.b("DmtToast", new Object[]{"content check!"});     // Catch: Exception -> L18
        AoLogger.b("DmtToast", new Object[]{"foreground check!"});     // Catch: Exception -> L18
        if ((this.c instanceof u) == false) goto L12;
        AoLogger.b("DmtToast", new Object[]{"actually show toast in D!"});     // Catch: Exception -> L18
        n0.b(this.c, 0, this.b, 0, 17);     // Catch: Exception -> L18
    L23:
        return;
    L12:
        AoLogger.b("DmtToast", new Object[]{"actually show toast in System!"});     // Catch: Exception -> L18
        View r2 = LayoutInflater.from(this.c).inflate(2131558675, null);     // Catch: Exception -> L15
        View r5 = r2.findViewById(2131384707);     // Catch: Exception -> L15
        r5.setBackgroundResource(2131231624);     // Catch: Exception -> L15
        r2.findViewById(2131376297).setVisibility(8);     // Catch: Exception -> L15
        TextView r6 = (TextView) r2.findViewById(2131390392);     // Catch: Exception -> L15
        r6.setTextColor(ContextCompat.getColor(this.c, 2131100271));     // Catch: Exception -> L15
        r6.setText(this.b);     // Catch: Exception -> L15
        r5.setAlpha(1.0f);     // Catch: Exception -> L15
        Toast r7 = new Toast(this.c);     // Catch: Exception -> L15
        this.d = r7;     // Catch: Exception -> L15
        r7.setDuration(0);     // Catch: Exception -> L15
        this.d.setGravity(this.a, 0, 0);     // Catch: Exception -> L15
        this.d.setView(r2);     // Catch: Exception -> L15
        this.d.show();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        AoLogger.b("DmtToast", new Object[]{"show system toast fail! " + e.getMessage()});     // Catch: Exception -> L18
        goto L23
    }

    public static a a(Context r2) {
        return new a(r2, r2.getString(2131894220));
    }

    public a(Context r2, String r3) {
        this.a = 17;
        this.b = r3;
        this.c = r2;
    }

    public static a b(Context r1, int r2) {
        return new a(r1, r1.getString(r2));
    }

    public static a c(Context r1, int r2) {
        return new a(r1, r1.getString(r2));
    }
}
