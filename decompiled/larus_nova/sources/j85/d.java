package j85;

import androidx.lifecycle.Observer;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements Observer<Map<String, Long>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f497722a;

    public d(String r100) {
        this.f497722a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Map<String, Long> r100) {
        Long r101 = r100.get(this.f497722a);
        n85.b r102 = n85.b.a.f518330a;
        String r103 = this.f497722a;
        r102.f518320b.put(r103, r101);
    }
}
