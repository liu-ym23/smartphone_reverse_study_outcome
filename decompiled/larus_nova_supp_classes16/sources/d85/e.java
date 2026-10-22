package d85;

import android.util.SparseArray;
import com.bytedance.ee.bear.drive.loader.download.platform.abs.IDownloader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import g85.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements d {
    public final IDownloader a;

    public e(IDownloader r1) {
        this.a = r1;
    }

    public static boolean b(String r1) {
        if (yu5.c.a(r1, "jpg") == false) goto L5;
    L10:
        return true;
    L5:
        if (yu5.c.a(r1, "jpeg") == true) goto L10;
        if (yu5.c.a(r1, "jpe") == true) goto L10;
        return false;
    }

    @Override // d85.d
    public final boolean a(w75.c r9, w75.c r10) {
        this.a.adjustPriority(r10);
        List<Integer> r0 = r10.p();
        if (hu5.a.d(r0) == true) goto L44;
        int r3 = ((Integer) ListProtector.get(r0, 0)).intValue();
        String r4 = r9.B();
        SparseArray<String> r5 = g.a;
        if (r3 != 11) goto L8;
        r4 = "JPG";
    L14:
        String r6 = r9.B();
        tt5.a.h("DRIVE_PREVIEW_FLOW", "transformPriority=" + Arrays.toString(r0.toArray(new Integer[0])));
        tt5.a.h("DRIVE_PREVIEW_FLOW", "priorityExt=" + r4 + " localPreviewExt=" + r6);
        ArrayList r1 = new ArrayList(4);
        r1.add(-4);
        r1.add(-3);
        r1.add(-2);
        r1.add(-1);
        if (r1.contains(Integer.valueOf(r3)) == false) goto L19;
        r10.z(r6);
        r10.g(r9.getLocalFilePath());
        return false;
    L19:
        if ("txt".equalsIgnoreCase(r4) == false) goto L27;
        if ("txt".equalsIgnoreCase(r6) == false) goto L27;
        if ("3".equals(r9.getDetails().v) == false) goto L27;
        tt5.a.h("DRIVE_PREVIEW_FLOW", "isCacheNotAvailable isTxt sourceFrom=upload ignore upload cache");
        return true;
    L27:
        if (b(r4) == false) goto L33;
        if (b(r6) == false) goto L33;
        r10.z(r6);
        r10.g(r9.getLocalFilePath());
        return false;
    L33:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.drive.mobile.video_little_rate") == true) goto L35;
        boolean r2 = false;
    L36:
        if (r2 == false) goto L40;
        r10.z(r6);
        r10.g(r9.getLocalFilePath());
        return false;
    L40:
        if (yu5.c.a(r4, r6) == false) goto L43;
        r10.z(r6);
        r10.g(r9.getLocalFilePath());
        return false;
    L43:
        tt5.a.h("DRIVE_PREVIEW_FLOW", "preview ext is changed");
        goto L44
    L35:
        r2 = yu5.c.a(r6, "mov");
        goto L36
    L8:
        if (r3 != 12) goto L11;
        r4 = "PNG";
        goto L14
    L11:
        if (r3 == 20) goto L14;
        r4 = g.a.get(r3, null);
    L44:
        return true;
    }
}
