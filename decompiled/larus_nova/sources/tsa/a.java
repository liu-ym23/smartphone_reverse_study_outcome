package tsa;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f547428a;

    public a(Context r100, Fragment r101) {
        super(r100);
        this.f547428a = r101;
    }

    public void startActivityForResult(Intent r100, int r101) {
        Fragment r102 = this.f547428a;
        if (r102 == null) goto L5;
        r102.startActivityForResult(r100, r101);
        return;
    L5:
        startActivity(r100);
    }
}
