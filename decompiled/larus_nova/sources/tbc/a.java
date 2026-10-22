package tbc;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements s5c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f545339b;

    @Override // s5c.d
    public final JSONObject toJson() {
        return s5c.d.b.c(this);
    }

    @Override // s5c.d
    public final String getKey() {
        return this.f545339b;
    }

    @Override // s5c.d
    public final String getValue() {
        return this.f545338a;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS, "key");
        this.f545338a = r100;
        this.f545339b = com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS;
    }

    @Override // s5c.d
    public final s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public final s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }
}
