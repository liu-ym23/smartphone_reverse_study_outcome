package com.volcengine.zeus.util.kv;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0001*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH&J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\fH&J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000eH&J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0011H&J'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0017H&J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\nH&J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\fH&J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000eH&J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004H&J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bH&J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H&J*\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0011H&J/\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014H&¢\u0006\u0004\b#\u0010$J\u001c\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H&J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H&¨\u0006+"}, d2 = {"Lcom/volcengine/zeus/util/kv/IKVStore;", "", "", "key", "", "value", "", "storeFloat", "", "storeBoolean", "", "storeInt", "", "storeLong", "", "storeDouble", "storeString", "", "values", "storeStringSet", "", "storeStringArray", "(Ljava/lang/String;[Ljava/lang/String;)V", "", "storeBytes", "erase", "defValue", "getInt", "getLong", "getDouble", "getFloat", "getBoolean", "getBytes", "defValues", "getStringSet", "getStringArray", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "getString", "Lcom/volcengine/zeus/util/kv/IKVStore$a;", "listener", "registerChangeListener", "unRegisterChangeListener", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public interface IKVStore {

    /* JADX INFO: loaded from: classes41.dex */
    public interface a {
    }

    void erase(String r100);

    boolean getBoolean(String r100, boolean r101);

    byte[] getBytes(String r100, byte[] r101);

    double getDouble(String r100, double r101);

    float getFloat(String r100, float r101);

    int getInt(String r100, int r101);

    long getLong(String r100, long r101);

    String getString(String r100, String r101);

    String[] getStringArray(String r100, String[] r101);

    Set<String> getStringSet(String r100, Set<String> r101);

    void registerChangeListener(a r100);

    void storeBoolean(String r100, boolean r101);

    void storeBytes(String r100, byte[] r101);

    void storeDouble(String r100, double r101);

    void storeFloat(String r100, float r101);

    void storeInt(String r100, int r101);

    void storeLong(String r100, long r101);

    void storeString(String r100, String r101);

    void storeStringArray(String r100, String[] r101);

    void storeStringSet(String r100, Set<String> r101);

    void unRegisterChangeListener(a r100);
}
