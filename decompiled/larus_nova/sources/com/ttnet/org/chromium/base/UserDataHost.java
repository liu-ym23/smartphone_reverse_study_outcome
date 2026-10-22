package com.ttnet.org.chromium.base;

import android.os.Process;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class UserDataHost {
    private final long mThreadId;
    private HashMap<Class<? extends UserData>, UserData> mUserDataMap;

    private void checkThreadAndState() {
        if (this.mThreadId != Process.myTid()) goto L10;
        if (this.mUserDataMap == null) goto L8;
        return;
    L8:
        throw new IllegalStateException("Operation is not allowed after destroy().");
    L10:
        throw new IllegalStateException("UserData must only be used on a single thread.");
    }

    public UserDataHost() {
        this.mThreadId = Process.myTid();
        this.mUserDataMap = new HashMap();
    }

    public void destroy() {
        checkThreadAndState();
        HashMap<Class<? extends UserData>, UserData> r100 = this.mUserDataMap;
        this.mUserDataMap = null;
        Iterator<UserData> r101 = r100.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().destroy();
        goto L4
    }

    private static void checkArgument(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Neither key nor object of UserDataHost can be null.");
    }

    public <T extends UserData> T getUserData(Class<T> r100) {
        checkThreadAndState();
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        checkArgument(r101);
        return r100.cast(this.mUserDataMap.get(r100));
    L5:
        r101 = false;
        goto L6
    }

    public <T extends UserData> T removeUserData(Class<T> r100) {
        checkThreadAndState();
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        checkArgument(r101);
        if (this.mUserDataMap.containsKey(r100) == false) goto L11;
        return r100.cast(this.mUserDataMap.remove(r100));
    L11:
        throw new IllegalStateException("UserData for the key is not present.");
    L5:
        r101 = false;
        goto L6
    }

    public <T extends UserData> T setUserData(Class<T> r100, T r101) {
        checkThreadAndState();
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        boolean r102 = true;
    L7:
        checkArgument(r102);
        this.mUserDataMap.put(r100, r101);
        return (T) getUserData(r100);
    L6:
        r102 = false;
        goto L7
    }
}
