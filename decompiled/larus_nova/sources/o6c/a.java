package o6c;

import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static final void delete(File r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == false) goto L8;
        r100.delete();
        return;
    }
}
