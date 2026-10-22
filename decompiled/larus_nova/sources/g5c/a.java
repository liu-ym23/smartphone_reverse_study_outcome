package g5c;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public interface a {
    void cleanSharedPreference();

    void commit(boolean r100);

    boolean contains(String r100);

    Map<String, ?> getAll();

    boolean getBoolean(String r100);

    boolean getBoolean(String r100, boolean r101);

    float getFloat(String r100, float r101);

    int getInt(String r100);

    int getInt(String r100, int r101);

    <T> List<T> getJSONArray(String r100, Class<T> r101);

    <T> T getJSONObject(String r100, Class<T> r101);

    long getLong(String r100);

    long getLong(String r100, long r101);

    String getString(String r100);

    String getString(String r100, String r101);

    void putBoolean(String r100, boolean r101);

    void putFloat(String r100, float r101);

    void putInt(String r100, int r101);

    void putJSONArray(String r100, List r101);

    void putJSONObject(String r100, Object r101);

    boolean putLong(String r100, long r101);

    void putString(String r100, String r101);

    boolean remove(String r100);
}
