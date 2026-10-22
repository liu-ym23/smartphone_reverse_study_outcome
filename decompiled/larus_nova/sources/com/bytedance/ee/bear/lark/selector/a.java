package com.bytedance.ee.bear.lark.selector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static void a(Activity r100, int r101, Bundle r102) {
        Intent r103 = new Intent(r100, DocSelectorActivity.class);
        r103.putExtras(r102);
        r100.startActivityForResult(r103, r101);
    }
}
