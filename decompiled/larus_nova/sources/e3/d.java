package e3;

import android.app.Activity;
import android.view.View;
import com.bytedance.ai.bridge.context.RefType;
import com.google.gson.JsonObject;
import d3.a0;

/* JADX INFO: loaded from: classes43.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(e3.a r100, Class r101, Object r102) {
            r100.b(r101, r102, RefType.WEAK);
        }
    }

    void a(String r100, JsonObject r101);

    <T> void b(Class<T> r100, T r101, RefType r102);

    String c(int r100);

    <T> T d(Class<T> r100);

    a0 getContainerContext();

    View getEngineView();

    g getJsEventDelegate();

    Activity getOwnerActivity();
}
