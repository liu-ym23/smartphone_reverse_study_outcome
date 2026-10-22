package n17;

import android.content.Intent;
import com.bytedance.lynx.webview.internal.TTWebContext;
import l17.k;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static void a(String r100) {
        Intent r101 = new Intent();
        r101.setAction(a.f516672a);
        r101.putExtra("info", r100);
        TTWebContext.h().getContext().sendBroadcast(r101);
        k.d(new String[]{"BroadcastInfo: ".concat(r100)});
    }
}
