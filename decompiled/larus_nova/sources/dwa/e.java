package dwa;

import android.content.Context;
import android.content.MutableContextWrapper;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends MutableContextWrapper implements d {
    @Override // dwa.d
    public final c Ey() {
        if ((getBaseContext() instanceof d) == false) goto L7;
        return ((d) getBaseContext()).Ey();
    L7:
        if ((getBaseContext() instanceof MutableContextWrapper) == true) goto L9;
        return null;
    L9:
        if ((((MutableContextWrapper) getBaseContext()).getBaseContext() instanceof d) == true) goto L11;
        return null;
    L11:
        return ((d) ((MutableContextWrapper) getBaseContext()).getBaseContext()).Ey();
    }

    public e(Context r100) {
        super(r100);
    }
}
