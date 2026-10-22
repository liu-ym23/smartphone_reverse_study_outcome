package s5c;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f540771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f540772b;

    @Override // s5c.d
    public final JSONObject toJson() {
        return d.b.c(this);
    }

    @Override // s5c.d
    public final String getKey() {
        return this.f540771a;
    }

    @Override // s5c.d
    public final String getValue() {
        return this.f540772b;
    }

    @Override // s5c.d
    public final d plus(Map<String, ? extends Object> r100) {
        return d.b.a(this, r100);
    }

    @Override // s5c.d
    public final d plus(d r100) {
        return d.b.b(this, r100);
    }

    public a(String r100, String r101) {
        this.f540771a = r100;
        this.f540772b = r101;
    }
}
