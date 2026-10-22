package rsa;

import android.app.Dialog;
import com.ss.android.cert.manager.ablity.ICertLoadingDialog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes34.dex */
public final class b {
    public static String a() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.getDefault()).format(new Date());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(ICertLoadingDialog r100) {
        if (r100 == 0) goto L14;
        if ((r100 instanceof Dialog) == true) goto L6;
        r100.dismiss();     // Catch: Exception -> L10
    L11:
        return;
    L6:
        if (((Dialog) r100).isShowing() == false) goto L11;
        r100.dismiss();     // Catch: Exception -> L10
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(ICertLoadingDialog r100) {
        if (r100 == 0) goto L14;
        if ((r100 instanceof Dialog) == true) goto L6;
        r100.show();     // Catch: Exception -> L10
    L11:
        return;
    L6:
        if (((Dialog) r100).isShowing() == true) goto L11;
        r100.show();     // Catch: Exception -> L10
    L15:
        return;
    }
}
