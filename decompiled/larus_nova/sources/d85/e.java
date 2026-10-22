package d85;

import android.util.SparseArray;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.image.entity.LoadParams;
import g85.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDownloader f467406a;

    public e(IDownloader r100) {
        this.f467406a = r100;
    }

    public static boolean b(String r100) {
        if (yu5.c.a(r100, "jpg") == false) goto L5;
    L10:
        return true;
    L5:
        if (yu5.c.a(r100, LoadParams.ImageFormat.JPEG) == true) goto L10;
        if (yu5.c.a(r100, "jpe") == true) goto L10;
        return false;
    }

    @Override // d85.d
    public final boolean a(w75.c r100, w75.c r110) {
        this.f467406a.adjustPriority(r110);
        List<Integer> r101 = r110.p();
        if (hu5.a.d(r101) == true) goto L44;
        int r102 = ((Integer) ListProtector.get(r101, 0)).intValue();
        String r103 = r100.B();
        SparseArray<String> r104 = g.f480400a;
        if (r102 != 11) goto L8;
        r103 = "JPG";
    L14:
        String r105 = r100.B();
        tt5.a.h("DRIVE_PREVIEW_FLOW", "transformPriority=" + Arrays.toString(r101.toArray(new Integer[0])));
        tt5.a.h("DRIVE_PREVIEW_FLOW", "priorityExt=" + r103 + " localPreviewExt=" + r105);
        ArrayList r106 = new ArrayList(4);
        r106.add(-4);
        r106.add(-3);
        r106.add(-2);
        r106.add(-1);
        if (r106.contains(Integer.valueOf(r102)) == false) goto L19;
        r110.z(r105);
        r110.g(r100.getLocalFilePath());
        return false;
    L19:
        if ("txt".equalsIgnoreCase(r103) == false) goto L27;
        if ("txt".equalsIgnoreCase(r105) == false) goto L27;
        if ("3".equals(r100.getDetails().f558553v) == false) goto L27;
        tt5.a.h("DRIVE_PREVIEW_FLOW", "isCacheNotAvailable isTxt sourceFrom=upload ignore upload cache");
        return true;
    L27:
        if (b(r103) == false) goto L33;
        if (b(r105) == false) goto L33;
        r110.z(r105);
        r110.g(r100.getLocalFilePath());
        return false;
    L33:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.drive.mobile.video_little_rate") == true) goto L35;
        boolean r107 = false;
    L36:
        if (r107 == false) goto L40;
        r110.z(r105);
        r110.g(r100.getLocalFilePath());
        return false;
    L40:
        if (yu5.c.a(r103, r105) == false) goto L43;
        r110.z(r105);
        r110.g(r100.getLocalFilePath());
        return false;
    L43:
        tt5.a.h("DRIVE_PREVIEW_FLOW", "preview ext is changed");
        goto L44
    L35:
        r107 = yu5.c.a(r105, "mov");
        goto L36
    L8:
        if (r102 != 12) goto L11;
        r103 = "PNG";
        goto L14
    L11:
        if (r102 == 20) goto L14;
        r103 = g.f480400a.get(r102, null);
    L44:
        return true;
    }
}
