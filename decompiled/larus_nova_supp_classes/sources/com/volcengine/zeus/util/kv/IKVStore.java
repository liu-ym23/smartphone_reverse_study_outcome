package com.volcengine.zeus.util.kv;

import java.util.Set;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0001*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH&J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\fH&J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000eH&J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0011H&J'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0017H&J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\nH&J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\fH&J\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000eH&J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004H&J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bH&J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H&J*\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0011H&J/\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0014H&¢\u0006\u0004\b#\u0010$J\u001c\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H&J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H&¨\u0006+"}, d2 = {"Lcom/volcengine/zeus/util/kv/IKVStore;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "key", XmlPullParser.NO_NAMESPACE, "value", XmlPullParser.NO_NAMESPACE, "storeFloat", XmlPullParser.NO_NAMESPACE, "storeBoolean", XmlPullParser.NO_NAMESPACE, "storeInt", XmlPullParser.NO_NAMESPACE, "storeLong", XmlPullParser.NO_NAMESPACE, "storeDouble", "storeString", XmlPullParser.NO_NAMESPACE, "values", "storeStringSet", XmlPullParser.NO_NAMESPACE, "storeStringArray", "(Ljava/lang/String;[Ljava/lang/String;)V", XmlPullParser.NO_NAMESPACE, "storeBytes", "erase", "defValue", "getInt", "getLong", "getDouble", "getFloat", "getBoolean", "getBytes", "defValues", "getStringSet", "getStringArray", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "getString", "Lcom/volcengine/zeus/util/kv/IKVStore$a;", "listener", "registerChangeListener", "unRegisterChangeListener", "a", "zeus-core_release"}, k = 1, mv = {1, 4, 2})
public interface IKVStore {
    void erase(String r1);

    boolean getBoolean(String r1, boolean r2);

    byte[] getBytes(String r1, byte[] r2);

    double getDouble(String r1, double r2);

    float getFloat(String r1, float r2);

    int getInt(String r1, int r2);

    long getLong(String r1, long r2);

    String getString(String r1, String r2);

    String[] getStringArray(String r1, String[] r2);

    Set<String> getStringSet(String r1, Set<String> r2);

    void registerChangeListener(a r1);

    void storeBoolean(String r1, boolean r2);

    void storeBytes(String r1, byte[] r2);

    void storeDouble(String r1, double r2);

    void storeFloat(String r1, float r2);

    void storeInt(String r1, int r2);

    void storeLong(String r1, long r2);

    void storeString(String r1, String r2);

    void storeStringArray(String r1, String[] r2);

    void storeStringSet(String r1, Set<String> r2);

    void unRegisterChangeListener(a r1);
}
