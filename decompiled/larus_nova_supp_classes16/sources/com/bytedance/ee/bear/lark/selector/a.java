package com.bytedance.ee.bear.lark.selector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static void a(Activity r2, int r3, Bundle r4) {
        Intent r0 = new Intent(r2, DocSelectorActivity.class);
        r0.putExtras(r4);
        r2.startActivityForResult(r0, r3);
    }
}
