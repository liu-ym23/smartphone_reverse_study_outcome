package h55;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import z75.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: h55.a$a, reason: collision with other inner class name */
    public static final class C0236a {
        @JvmStatic
        public static String a(DriveViewModel r2) {
            Intrinsics.checkNotNullParameter(r2, "viewModel");
            BaseOpenEntity r3 = r2.getOpenEntity();
            if ((r3 instanceof SpaceFileOpenEntity) == false) goto L6;
            SpaceFileOpenEntity r4 = (SpaceFileOpenEntity) r3;
            return d.a(r4.getFileId(), r4.getPreviewFrom(), r4.getUrl());
        L6:
            return "";
        }
    }

    static {
    }
}
