package com.bytedance.ee.bear.lark.aidl;

import android.os.RemoteCallbackList;
import com.ss.android.lark.doc.IRemindStateChangeListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static a b;
    public final RemoteCallbackList<IRemindStateChangeListener> a;

    public a() {
        this.a = new RemoteCallbackList();
    }
}
