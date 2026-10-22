package mx;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class j extends a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View.OnClickListener f516144l;

    public j(String r100, String r110, boolean r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        r110 = "";
    L5:
        String r101 = r110;
        if ((r112 & 8) == 0) goto L8;
        boolean r102 = false;
    L9:
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "description");
        super(r100, r101, false, r102, false, null, 240);
        return;
    L8:
        r102 = r111;
        goto L9
    }
}
