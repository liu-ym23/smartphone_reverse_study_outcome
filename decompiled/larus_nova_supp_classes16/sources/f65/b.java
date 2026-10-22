package f65;

import androidx.fragment.app.FragmentActivity;
import c25.c;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.drive.core.DriveActivity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends c25.a<DrivePluginHost> {
    public b() {
    }

    @Override // c25.a
    public final c b(PluginHost r9) {
        DrivePluginHost r10 = (DrivePluginHost) r9;
        String r0 = "";
        if (r10 == null) goto L22;
        DriveViewModel r11 = r10.c;
        boolean r1 = r11.isTypeWiki();
        String r2 = r11.getFileId();
        BaseOpenEntity r4 = r11.getOpenEntity();
        if ((r4 instanceof SpaceFileOpenEntity) == false) goto L9;
        if (r1 == false) goto L8;
        String r5 = ((SpaceFileOpenEntity) r4).getWikiUrl();
    L11:
        if (r11.isIsDeleted() == false) goto L13;
    L17:
        String r6 = "";
    L19:
        if (r11.getFileName() == null) goto L21;
        r0 = r11.getFileName();
    L21:
        String r7 = r0;
        String r8 = r6;
        boolean r12 = r1;
        String r3 = r5;
        String r13 = r8;
    L24:
        return new c(r3, r2, 12, r13, r12, r7);
    L13:
        if (r11.getFileModel() == null) goto L17;
        if (r11.getFileModel().c() == null) goto L17;
        r6 = r11.getFileModel().c().k;
        goto L19
    L8:
        r5 = ((SpaceFileOpenEntity) r4).getUrl();
        goto L11
    L9:
        r5 = "";
        goto L11
    L22:
        r3 = "";
        r2 = r3;
        r13 = r2;
        r7 = r13;
        r12 = false;
        goto L24
    }

    public static msb.a c(b r1, FragmentActivity r2) {
        r1.getClass();
        boolean r3 = r2 instanceof DriveActivity;
        if (r3 == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L16;
        if (r3 == false) goto L14;
        return ((DriveActivity) r2).c;
    L14:
        if ((r2 instanceof m) == false) goto L16;
        return ((m) r2).Z();
    L16:
        return null;
    L5:
        if ((r2 instanceof m) == true) goto L8;
        r0 = false;
        goto L9
    }
}
