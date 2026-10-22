package com.bytedance.ee.bear.lark.dependency;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.maincore.TabType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface s {
    void a(Context r1);

    void b(wb5.d r1);

    boolean enableFgMainTabContainer();

    TabType getTabType();

    void isEnableWikiTab();

    void launchMainWindow(Context r1, String r2, Bundle r3);
}
