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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f573878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f573879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f573880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Toast f573881d;

    public final void d() {
        AoLogger.b("DmtToast", new Object[]{"start to show toast!"});
    L18:
        e = move-exception;
        AoLogger.b("DmtToast", new Object[]{"show toast fail " + e.getMessage()});
        e.printStackTrace();
        return;
    L4:
        if (this.f573880c != null) goto L6;
        return;
    L6:
        AoLogger.b("DmtToast", new Object[]{"context check!"});     // Catch: Exception -> L18
        if (TextUtils.isEmpty(this.f573879b) == false) goto L9;
        return;
    L9:
        AoLogger.b("DmtToast", new Object[]{"content check!"});     // Catch: Exception -> L18
        AoLogger.b("DmtToast", new Object[]{"foreground check!"});     // Catch: Exception -> L18
        if ((this.f573880c instanceof u) == false) goto L12;
        AoLogger.b("DmtToast", new Object[]{"actually show toast in D!"});     // Catch: Exception -> L18
        n0.b(this.f573880c, 0, this.f573879b, 0, 17);     // Catch: Exception -> L18
    L23:
        return;
    L12:
        AoLogger.b("DmtToast", new Object[]{"actually show toast in System!"});     // Catch: Exception -> L18
        View r100 = LayoutInflater.from(this.f573880c).inflate(R.layout.aos_layout_toast_for_d, null);     // Catch: Exception -> L15
        View r101 = r100.findViewById(R.id.rl_rootview);     // Catch: Exception -> L15
        r101.setBackgroundResource(R.drawable.aos_uikit_bg_new_toast_bg_douyin_12);     // Catch: Exception -> L15
        r100.findViewById(R.id.iv_icon).setVisibility(8);     // Catch: Exception -> L15
        TextView r102 = (TextView) r100.findViewById(R.id.tv_content);     // Catch: Exception -> L15
        r102.setTextColor(ContextCompat.getColor(this.f573880c, R.color.aos_const_text_inverse));     // Catch: Exception -> L15
        r102.setText(this.f573879b);     // Catch: Exception -> L15
        r101.setAlpha(1.0f);     // Catch: Exception -> L15
        Toast r103 = new Toast(this.f573880c);     // Catch: Exception -> L15
        this.f573881d = r103;     // Catch: Exception -> L15
        r103.setDuration(0);     // Catch: Exception -> L15
        this.f573881d.setGravity(this.f573878a, 0, 0);     // Catch: Exception -> L15
        this.f573881d.setView(r100);     // Catch: Exception -> L15
        this.f573881d.show();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        AoLogger.b("DmtToast", new Object[]{"show system toast fail! " + e.getMessage()});     // Catch: Exception -> L18
        goto L23
    }

    public static a a(Context r100) {
        return new a(r100, r100.getString(R.string.aos_load_more_error_toast));
    }

    public a(Context r100, String r101) {
        this.f573878a = 17;
        this.f573879b = r101;
        this.f573880c = r100;
    }

    public static a b(Context r100, int r101) {
        return new a(r100, r100.getString(r101));
    }

    public static a c(Context r100, int r101) {
        return new a(r100, r100.getString(r101));
    }
}
