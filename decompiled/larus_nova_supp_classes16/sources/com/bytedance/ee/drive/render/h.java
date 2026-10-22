package com.bytedance.ee.drive.render;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.z5;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements z5 {
    public final bk5.a a;

    public static final class a {
    }

    static {
    }

    public h(bk5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.a = r2;
    }

    @Override // com.bytedance.ee.bear.document.z5
    public final void reloadDocumentFragment(String r3, Map<String, String> r4) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        tt5.a.k("DriveReloadAbilityImpl", "reloadDocumentFragment failed, url is empty");
        return;
    L6:
        Bundle r5 = new Bundle();
        r5.putString("url", r3);
        tt5.a.h("DriveReloadAbilityImpl", "reloadDocumentFragment via IContainer.reload");
        this.a.o0(r5);
    }
}
