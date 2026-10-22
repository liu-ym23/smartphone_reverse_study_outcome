package h55;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import z75.d;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483876a = 0;

    /* JADX INFO: renamed from: h55.a$a, reason: collision with other inner class name */
    public static final class C6102a {
        @JvmStatic
        public static String a(DriveViewModel r100) {
            Intrinsics.checkNotNullParameter(r100, "viewModel");
            BaseOpenEntity r101 = r100.getOpenEntity();
            if ((r101 instanceof SpaceFileOpenEntity) == false) goto L6;
            SpaceFileOpenEntity r102 = (SpaceFileOpenEntity) r101;
            return d.a(r102.getFileId(), r102.getPreviewFrom(), r102.getUrl());
        L6:
            return "";
        }
    }

    static {
    }
}
