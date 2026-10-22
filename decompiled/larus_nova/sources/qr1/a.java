package qr1;

import com.bytedance.android.live.GsonHelper;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements Observer<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f534515a;

    public a(i r100) {
        this.f534515a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        String r101 = (String) r100;
        String r102 = String.valueOf(((Map) GsonHelper.getDefault().fromJson(r101, Map.class)).get("error_code"));     // Catch: Throwable -> L5
        this.f534515a.a("player_status", r102);     // Catch: Throwable -> L5
        i r103 = this.f534515a;     // Catch: Throwable -> L5
        r103.f534528f.f534542c = true;     // Catch: Throwable -> L5
        r103.h(3, "enter failed cause of player error");     // Catch: Throwable -> L5
        return;
    }
}
