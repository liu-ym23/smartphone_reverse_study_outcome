package op8;

import android.net.Uri;
import android.view.View;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public class c implements f {
    public c() {
    }

    @Override // op8.f
    public void A3(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "uriList");
    }

    @Override // op8.f
    public void M7(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "inputView");
        Intrinsics.checkNotNullParameter(r101, "addedItemUri");
    }

    @Override // op8.f
    public void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
    }

    @Override // op8.f
    public void b(int r100, long r101) {
    }

    @Override // op8.f
    public void d(int r100) {
    }

    @Override // op8.f
    public void e(f.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // op8.f
    public void f(f.b r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // op8.f
    public void f4(View r100) {
        Intrinsics.checkNotNullParameter(r100, "inputView");
    }

    @Override // op8.f
    public boolean g() {
        return false;
    }

    @Override // op8.f
    public void h(boolean r100) {
    }

    @Override // op8.f
    public void h0(Uri r100) {
    }

    @Override // op8.f
    public Map<String, String> getEventInfo() {
        return new LinkedHashMap();
    }
}
