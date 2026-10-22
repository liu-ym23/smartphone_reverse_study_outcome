package x83;

import android.view.View;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ll.c;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f562895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f562896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map.Entry<String, c> f562897c;

    public b(View r100, int r101, Map.Entry<String, c> r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "regionInfo");
        this.f562895a = r100;
        this.f562896b = r101;
        this.f562897c = r102;
    }
}
