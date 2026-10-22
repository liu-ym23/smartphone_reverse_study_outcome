package t97;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends f {
    public a() {
    }

    public static Activity d(Context r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return d(((ContextWrapper) r100).getBaseContext());
    }

    @Override // t97.f
    public final void c(Context r100, Intent r101) {
        com.bytedance.router.c r102 = this.f545104b;
        Uri r103 = r102.f267537k;
        if (r103 == null) goto L5;
        r101.setData(r103);
    L5:
        Activity r104 = d(r100);
        if (r104 == null) goto L19;
        int r105 = r102.f267536j;
        if (r105 == Integer.MIN_VALUE) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L13;
        r104.startActivityForResult(r101, r105);
    L15:
        if (r102.f267534h == (-1)) goto L17;
    L18:
        com.bytedance.router.c r107 = this.f545104b;
        r104.overridePendingTransition(r107.f267534h, r107.f267535i);
        return;
    L17:
        if (r102.f267535i != (-1)) goto L18;
        return;
    L13:
        r100.startActivity(r101);
        goto L15
    L10:
        r106 = false;
        goto L11
    L19:
        r101.addFlags(268435456);
        r100.startActivity(r101);
    }
}
