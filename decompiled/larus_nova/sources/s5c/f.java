package s5c;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public abstract class f implements d {
    public f() {
    }

    @Override // s5c.d
    public final JSONObject toJson() {
        return d.b.c(this);
    }

    public final a a(String r100) {
        d.a r101 = d.f540773o2;
        String r102 = ((g) this).f540775a;
        r101.getClass();
        return new a(r102, r100);
    }

    @Override // s5c.d
    public final d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public final d plus(d r100) {
        return d.b.b(this, r100);
    }
}
