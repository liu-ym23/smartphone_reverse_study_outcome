package com.obric.aiagent.sharedstate;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\fH&J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003H&J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\nH&J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\fH&J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eH&J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H&J\u001e\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000eH&¨\u0006\u001f"}, d2 = {"Lcom/obric/aiagent/sharedstate/SharedStateHandle;", "", "getBoolean", "", "key", "", "defaultValue", "getDouble", "", "getFloat", "", "getInt", "", "getLong", "", "getString", "putBoolean", "", "value", "putDouble", "putFloat", "putInt", "putLong", "putString", "registerObserver", "keys", "", "observer", "Lcom/obric/aiagent/sharedstate/StateChangeListener;", "unregisterObserver", "subscriptionId", "shared-state-sdk_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
public interface SharedStateHandle {
    boolean getBoolean(String r100, boolean r101);

    double getDouble(String r100, double r101);

    float getFloat(String r100, float r101);

    int getInt(String r100, int r101);

    long getLong(String r100, long r101);

    String getString(String r100, String r101);

    void putBoolean(String r100, boolean r101);

    void putDouble(String r100, double r101);

    void putFloat(String r100, float r101);

    void putInt(String r100, int r101);

    void putLong(String r100, long r101);

    void putString(String r100, String r101);

    long registerObserver(List<String> r100, StateChangeListener r101);

    void unregisterObserver(long r100);
}
