package com.bytedance.ee.bear.lark.dependency;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.maincore.TabType;

/* JADX INFO: loaded from: classes16.dex */
public interface s {
    void a(Context r100);

    void b(wb5.d r100);

    boolean enableFgMainTabContainer();

    TabType getTabType();

    void isEnableWikiTab();

    void launchMainWindow(Context r100, String r101, Bundle r102);
}
