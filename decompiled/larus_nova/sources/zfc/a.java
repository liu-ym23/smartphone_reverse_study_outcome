package zfc;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: zfc.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes5.dex */
    public interface InterfaceC8452a extends rgc.a {
        void Z();
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface b extends rgc.a {
        void F0();

        void U();

        void V(Bundle r100);

        void W2();

        boolean f();

        Map<String, String> getHttpCommonParams();

        boolean n0();

        void onEvent(Context r100, String r101, String r102, String r103, long r104, long r105, JSONObject r106);

        void onEventV3(String r100, JSONObject r101);
    }

    public static b a() {
        return (b) rgc.b.a(b.class);
    }
}
