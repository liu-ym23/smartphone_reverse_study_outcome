package j30;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class i extends com.bytedance.android.live.browser.jsbridge.state.b<JsonObject> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f497072c;

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final /* bridge */ /* synthetic */ Object b() {
        return null;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.state.a<JsonObject> g() {
        return this;
    }

    public i() {
        this.f497072c = "js_kv_methods_20191113";
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.i.f d() {
        return com.bytedance.android.live.browser.jsbridge.i.g.j.f63220b;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final JsonElement e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        List r101 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r101.size() <= 1) goto L7;
        String r102 = (String) ListProtector.get(r101, 1);
        Intrinsics.checkNotNullParameter(r102, "key");
        SharedPreferences r103 = s1.getContext().getSharedPreferences(this.f497072c, 0);
        JsonObject r104 = new JsonObject();
        r104.addProperty(r102, r103.getString(r102, ""));
        return r104;
    L7:
        return super.e(r100);
    }
}
