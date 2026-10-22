package eb7;

import android.os.Bundle;
import com.larus.nova.view.FlowBDAuthorizeActivity;
import fb7.c;
import fb7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements db7.a {
    public a() {
    }

    @Override // db7.a
    public final boolean a(int r100, Bundle r101, FlowBDAuthorizeActivity.d r102) {
        if (r100 != 1) goto L16;
        c r103 = new c(r101);
        String r104 = r103.f476274g;
        if (r104 == null) goto L7;
        r103.f476274g = r104.replace(" ", "");
    L7:
        String r105 = r103.f476276i;
        if (r105 == null) goto L10;
        r103.f476276i = r105.replace(" ", "");
    L10:
        String r106 = r103.f476275h;
        if (r106 == null) goto L13;
        r103.f476275h = r106.replace(" ", "");
    L13:
        r102.b(r103);
        return true;
    L16:
        if (r100 != 2) goto L19;
        r102.c(new d(r101));
        return true;
    L19:
        return false;
    }
}
