package com.bytedance.ee.bear.share;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.export.m;
import com.bytedance.ee.bear.share.externalshare.OnIpcShareCallback;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import com.ss.android.lark.thirdshare.base.export.ShareEntity;
import com.ss.android.lark.vfs.VFSPath;
import java.util.Collections;
import rm5.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public e() {
    }

    public final void b(Context r3, VFSPath r4, m r5) {
        Uri r6 = com.bytedance.ee.util.io.e.b(r3, r4);
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.SEND");
        r0.putExtra("android.intent.extra.STREAM", r6);
        r0.setType("image/*");
        if (Build.VERSION.SDK_INT < 24) goto L11;
        r0.addFlags(1);
        r0.addFlags(2);
    L11:
        r3.startActivity(Intent.createChooser(r0, r3.getString(2131887685)));     // Catch: Exception -> L8
        r5.onSuccess();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r5.onFailed("Share failed. msg: " + e.getMessage());
        Toast.showFailureText(r3, r3.getString(2131887802), 0);
    }

    public final void c(Context r3, String r4, n r5) {
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.SEND");
        r0.putExtra("android.intent.extra.TEXT", r4);
        r0.setType("text/plain");
        r3.startActivity(Intent.createChooser(r0, r3.getResources().getString(2131887832)));     // Catch: Exception -> L7
        if (r5 == null) goto L14;
        r5.onSuccess();     // Catch: Exception -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        if (r5 == null) goto L10;
        r5.onFailed("Share failed. msg: " + e.getMessage());
    L10:
        Toast.showFailureText(r3, r3.getString(2131887802), 0);
    }

    public final void a(Context r2, ShareType r3, VFSPath r4, m r5) {
        if (km5.c.e(r2, r3) == true) goto L7;
        if (r5 == null) goto L16;
        r5.onFailed("App isn't installed.");
        return;
    L16:
        return;
    L7:
        if (com.bytedance.ee.util.io.b.c(r4) == true) goto L11;
        if (r5 == null) goto L10;
        r5.onFailed("File isn't image type.");
    L10:
        tt5.a.d("ExternalShareHelper", "the file is not image type");
        return;
    L11:
        ShareActionType r6 = km5.c.a(r3);
        ShareEntity.a r0 = new ShareEntity.a(r4.toFile());
        r0.c(Collections.singletonList(r6));
        r0.b(OnIpcShareCallback.class);
        ShareEntity r7 = r0.a();
        if (r5 == null) goto L14;
        r5.onSuccess();
    L14:
        km5.c.g(r2, r7);
    }

    public final void d(Context r4, ShareType r5, VFSPath r6, String r7, m r8) {
        if (km5.c.e(r4, r5) == true) goto L7;
        if (r8 == null) goto L33;
        r8.onFailed("App isn't installed.");
        return;
    L33:
        return;
    L7:
        if (com.bytedance.ee.util.io.b.c(r6) == true) goto L11;
        if (r8 == null) goto L10;
        r8.onFailed("File isn't image type.");
    L10:
        tt5.a.d("ExternalShareHelper", "the file is not image type");
        return;
    L11:
        Intent r0 = new Intent();
        ComponentName r9 = km5.d.a(r5);
        r0.setComponent(r9);
        r0.setAction("android.intent.action.SEND");
        Uri r10 = com.bytedance.ee.util.io.e.b(r4, r6);
        if (r9 == null) goto L14;
        r4.grantUriPermission(r9.getPackageName(), r10, 1);
    L14:
        r0.putExtra("android.intent.extra.STREAM", r10);
        if (TextUtils.isEmpty(r7) == false) goto L17;
        String r11 = "";
    L18:
        r0.putExtra("android.intent.extra.TEXT", r11);
        if (TextUtils.isEmpty(r7) == false) goto L21;
        r7 = "";
    L21:
        r0.putExtra("Kdescription", r7);
        r0.setType("image/*");
        r4.startActivity(r0);     // Catch: Exception -> L26
        if (r8 == null) goto L36;
        r8.onSuccess();     // Catch: Exception -> L26
        return;
    L36:
        return;
    L27:
        if (r8 == null) goto L29;
        r8.onFailed("File isn't image type.");
    L29:
        Toast.showFailureText(r4, r4.getResources().getString(2131887802), 0);
        return;
    L17:
        r11 = r7;
        goto L18
    }
}
