package nl6;

import android.content.Intent;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import us6.b;
import us6.c;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements us6.a {
    public a() {
    }

    @Override // us6.a
    public final void a() {
    }

    @Override // us6.a
    public final void b(PoiBundle r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, "poiBundle");
        Intrinsics.checkNotNullParameter(r101, "intent");
    }

    @Override // us6.a
    public final PoiBundle d(PoiBundle r100) {
        return r100;
    }

    @Override // us6.a
    public final void g() {
    }

    @Override // us6.a
    public final Map e() {
        Intrinsics.checkNotNullParameter("enter_poi_detail", "eventKey");
        return new LinkedHashMap();
    }

    @Override // us6.a
    public final b f() {
        return new b();
    }

    @Override // us6.a
    public final c c(Intent r110) {
        Intrinsics.checkNotNullParameter(r110, "intent");
        return new c("", "", "", "", "", "", 7168);
    }
}
