package com.bytedance.ee.bear.contract.drive.sdk.entity.menu;

import com.bytedance.ee.bear.drive.biz.preview.more.manager.DriveIMAttachmentMoreMenuManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveShadowFileManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<DriveShadowFileManager> f217019b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f217020a;

    public static final class a {
        public static DriveShadowFileManager a() {
            return DriveShadowFileManager.f217019b.getValue();
        }
    }

    static {
        f217019b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DriveShadowFileManager$Companion$instance$2.INSTANCE);
    }

    public DriveShadowFileManager() {
        this.f217020a = new ConcurrentHashMap();
    }

    public final void a(String r100, DriveIMAttachmentMoreMenuManager r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        StringBuilder r102 = new StringBuilder("addMoreMenuManager, key=");
        r102.append(r100);
        r102.append(", manager=");
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.hashCode());
    L6:
        r102.append(r103);
        tt5.a.h("DriveShadowFileManager", r102.toString());
        if (r101 == null) goto L10;
        this.f217020a.put(r100, r101);
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
