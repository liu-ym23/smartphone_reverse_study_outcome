package com.bytedance.timon.foundation.interfaces;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0002\b\u0003\u0018\u00010\tH&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0013H&J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&J-\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00162\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016H&¢\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0005H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\rH&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000fH&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0011H&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0013H&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H&J#\u0010!\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016H&¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006%"}, d2 = {"Lcom/bytedance/timon/foundation/interfaces/IStoreRepo;", "", "clear", "", "contains", "", "key", "", "getAll", "", "getBoolean", "defValue", "getBytes", "", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringArray", "", "(Ljava/lang/String;[Ljava/lang/String;)[Ljava/lang/String;", "getStringSet", "", "putBoolean", "value", "putBytes", "putFloat", "putInt", "putLong", "putString", "putStringArray", "(Ljava/lang/String;[Ljava/lang/String;)V", "putStringSet", "remove", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
public interface IStoreRepo {
    void clear();

    boolean contains(String r100);

    Map<String, ?> getAll();

    boolean getBoolean(String r100, boolean r101);

    byte[] getBytes(String r100, byte[] r101);

    float getFloat(String r100, float r101);

    int getInt(String r100, int r101);

    long getLong(String r100, long r101);

    String getString(String r100, String r101);

    String[] getStringArray(String r100, String[] r101);

    Set<String> getStringSet(String r100, Set<String> r101);

    void putBoolean(String r100, boolean r101);

    void putBytes(String r100, byte[] r101);

    void putFloat(String r100, float r101);

    void putInt(String r100, int r101);

    void putLong(String r100, long r101);

    void putString(String r100, String r101);

    void putStringArray(String r100, String[] r101);

    void putStringSet(String r100, Set<String> r101);

    void remove(String r100);
}
