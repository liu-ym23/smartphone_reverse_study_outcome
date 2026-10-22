package com.bytedance.ee.bear.contract.drive.sdk.entity.menu;

import com.bytedance.ee.bear.drive.biz.preview.more.manager.DriveIMAttachmentMoreMenuManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveShadowFileManager {
    public static final Lazy<DriveShadowFileManager> b = null;
    public final ConcurrentHashMap<String, c> a;

    public static final class a {
        public static DriveShadowFileManager a() {
            return (DriveShadowFileManager) DriveShadowFileManager.b.getValue();
        }
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DriveShadowFileManager$Companion$instance$2.INSTANCE);
    }

    public DriveShadowFileManager() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(String r3, DriveIMAttachmentMoreMenuManager r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        StringBuilder r0 = new StringBuilder("addMoreMenuManager, key=");
        r0.append(r3);
        r0.append(", manager=");
        if (r4 == null) goto L5;
        Integer r1 = Integer.valueOf(r4.hashCode());
    L6:
        r0.append(r1);
        tt5.a.h("DriveShadowFileManager", r0.toString());
        if (r4 == null) goto L10;
        this.a.put(r3, r4);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
