package com.bytedance.push.settings;

import android.content.Context;
import j77.a;

/* JADX INFO: loaded from: classes3.dex */
public interface ILocalSettings {
    void registerValChanged(Context r100, String r101, String r102, a r103);

    void unregisterValChanged(a r100);
}
