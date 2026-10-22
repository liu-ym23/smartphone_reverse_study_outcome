package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.component.capture.a$a, reason: collision with other inner class name */
    public static final class C4152a {
        public static boolean a(a r100, CameraCaptureViewModel r101) {
            List<String> r102 = r100.d();
            if (r101 == null) goto L5;
            String r103 = r101.getCurrentCaptureMode();
        L7:
            return CollectionsKt.contains(r102, r103);
        L5:
            r103 = null;
            goto L7
        }

        public static boolean b(a r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "captureMode");
            return r100.d().contains(r101);
        }
    }

    List<String> d();
}
