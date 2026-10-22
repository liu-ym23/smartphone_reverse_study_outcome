package p55;

import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.DocObjInfo;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.more.b;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import oj5.f;
import s45.p;
import sbb.e;
import t45.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map a(boolean r4) {
        BenefitStore r0 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1();
        return ((b) org.koin.java.a.c(b.class, null, null, 6)).m(12, r4, false, r0);
    }

    public static oj5.a b(DrivePluginHost r50) {
        Intrinsics.checkNotNullParameter(r50, "drivePluginHost");
        c r1 = p.a();
        int r2 = h55.a.a;
        BearUrl r3 = r1.Z(h55.a.C0236a.a(r50.c));
        DriveViewModel r4 = r50.c;
        DriveMetaInfoVM r5 = (DriveMetaInfoVM) q.c(r50, DriveMetaInfoVM.class, null);
        DriveMGPermissionVM r0 = (DriveMGPermissionVM) q.c(r50, DriveMGPermissionVM.class, null);
        u55.a r6 = (u55.a) r5.getLiveMetaInfo().getValue();
        if (r6 != null) goto L5;
        r6 = new u55.a(r3.b, new DocMetaInfo(r4.getFileName(), false, null, null, null, null, null, null, null, false, false, null, null, false, null, 0, 0, 0, 0, null, 0, 0, false, false, false, null, null, 0, null, null, 0, null, 0, null, null, null, null, 0, -2, 63, null));
    L5:
        DocVersion r7 = (DocVersion) r5.getLiveDocVersion().getValue();
        if (r7 != null) goto L8;
        r7 = new DocVersion(0, 1, null);
        r7.setNil(true);
    L8:
        u55.b r8 = (u55.b) r0.livePerm().getValue();
        if (r8 != null) goto L11;
        r8 = new u55.b(r3.b, new DocPermission(null, 3));
    L11:
        Intrinsics.checkNotNullParameter(r4, "driveViewModel");
        Intrinsics.checkNotNullParameter(r6, "metaInfo");
        Intrinsics.checkNotNullParameter(r8, "permissionInfo");
        Intrinsics.checkNotNullParameter(r7, "ownerType");
        String r10 = h55.a.C0236a.a(r4);
        boolean r9 = r4.isVCFollowMode();
        DocMetaInfo r11 = r6.b;
        if (r4.isTypeWiki() == false) goto L18;
        int r12 = e.l.b;
        String r13 = r8.a;
        if (r13 != null) goto L16;
        String r14 = "";
    L17:
        Intrinsics.checkNotNull(r11);
        DocVersion r18 = r7;
        f r16 = new f(r12, r10, r14, null, false, false, r11, new DocObjInfo(false, false, false, false, null, null, 0, 127, null), r8.b, r18, r4.getWikiInfo().getWikiToken(), r9, null);
        r11.getOwnerUid();
        r16.S(a(true));
        return r16;
    L16:
        r14 = r13;
        goto L17
    L18:
        int r17 = e.l.b;
        String r19 = r8.a;
        if (r19 != null) goto L21;
        String r110 = "";
    L22:
        Intrinsics.checkNotNull(r11);
        oj5.a r20 = new oj5.a(r17, r10, r110, null, false, false, r11, new DocObjInfo(false, false, false, false, null, null, 0, 127, null), r8.b, r7, r9, false, false, null);
        r11.getOwnerUid();
        r20.S(a(false));
        return r20;
    L21:
        r110 = r19;
        goto L22
    }
}
