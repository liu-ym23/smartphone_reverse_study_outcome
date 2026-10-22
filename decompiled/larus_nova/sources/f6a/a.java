package f6a;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;

/* JADX INFO: loaded from: classes32.dex */
public interface a {
    ReadableArray asArray();

    boolean asBoolean();

    byte[] asByteArray();

    double asDouble();

    int asInt();

    long asLong();

    ReadableMap asMap();

    String asString();

    ReadableType getType();

    boolean isNull();

    void recycle();
}
