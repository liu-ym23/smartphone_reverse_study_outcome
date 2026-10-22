package cx7;

import com.ivy.ivykit.api.bridge.core.model.IvyReadableType;
import dx7.e;

/* JADX INFO: loaded from: classes23.dex */
public interface d {
    dx7.a get(String r100);

    e getArray(String r100);

    boolean getBoolean(String r100);

    double getDouble(String r100);

    int getInt(String r100);

    dx7.b getMap(String r100);

    String getString(String r100);

    IvyReadableType getType(String r100);

    boolean hasKey(String r100);

    dx7.d keyIterator();
}
