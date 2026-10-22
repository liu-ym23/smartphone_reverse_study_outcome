package l75;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends ContextWrapper {
    public final Fragment a;

    public a(Context r1, Fragment r2) {
        super(r1);
        this.a = r2;
    }

    public void startActivityForResult(Intent r2, int r3) {
        Fragment r0 = this.a;
        if (r0 == null) goto L5;
        r0.startActivityForResult(r2, r3);
        return;
    L5:
        startActivity(r2);
    }
}
