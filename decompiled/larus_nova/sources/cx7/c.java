package cx7;

import com.ivy.ivykit.api.bridge.core.model.IvyReadableType;
import dx7.e;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public interface c {
    e getArray(int r100);

    boolean getBoolean(int r100);

    double getDouble(int r100);

    int getInt(int r100);

    dx7.b getMap(int r100);

    String getString(int r100);

    IvyReadableType getType(int r100);

    List<Object> toList();
}
