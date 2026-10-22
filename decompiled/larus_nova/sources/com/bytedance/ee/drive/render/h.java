package com.bytedance.ee.drive.render;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.document.z5;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bk5.a f242738a;

    public static final class a {
    }

    static {
    }

    public h(bk5.a r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f242738a = r100;
    }

    @Override // com.bytedance.ee.bear.document.z5
    public final void reloadDocumentFragment(String r100, Map<String, String> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        tt5.a.k("DriveReloadAbilityImpl", "reloadDocumentFragment failed, url is empty");
        return;
    L6:
        Bundle r102 = new Bundle();
        r102.putString("url", r100);
        tt5.a.h("DriveReloadAbilityImpl", "reloadDocumentFragment via IContainer.reload");
        this.f242738a.o0(r102);
    }
}
