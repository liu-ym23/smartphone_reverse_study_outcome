package mx;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class h extends a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View.OnClickListener f516142l;

    public h(String r100, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r110, "description");
        super(r100, r110, false, r111, false, null, 240);
    }
}
