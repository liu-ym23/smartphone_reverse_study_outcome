package nu9;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: classes.dex */
public final class u {
    public u() {
    }

    public static t a() {
        t r100 = new t();
        r100.h(new JsonPrimitive(1));
        r100.g(new JsonPrimitive("2"));
        r100.f(new JsonPrimitive("6"));
        r100.j(new JsonPrimitive(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO));
        r100.i(new JsonPrimitive(BDLocationException.ERROR_SDK_NO_PERMISSION));
        return r100;
    }
}
