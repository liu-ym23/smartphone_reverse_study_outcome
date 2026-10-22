package com.bytedance.ee.bear.drive.biz.preview.more.menu.share;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import cj5.c;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.share.export.ShareParams;
import sbb.e;
import u55.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static void a(FragmentActivity r22, DriveViewModel r23, b r24) {
        if ((r23.getOpenEntity() instanceof SpaceFileOpenEntity) == true) goto L5;
    L20:
        tt5.a.d("DriveComponent", "showShareFragment() not SpaceFileOpenEntity or fileModel is null, entity=" + r23.getOpenEntity());
        return;
    L5:
        if (r23.getFileModel() == null) goto L20;
        if (r24 == null) goto L20;
        SpaceFileOpenEntity r1 = (SpaceFileOpenEntity) r23.getOpenEntity();
        String r2 = r1.getFeedId();
        boolean r3 = r23.isTypeWiki();
        if (r3 == true) goto L11;
    L13:
        int r4 = h55.a.a;
        String r5 = h55.a.C0236a.a(r23);
    L14:
        ShareParams.ShareParamsBuilder r6 = new ShareParams.ShareParamsBuilder(r22).source(2);
        e r7 = e.l;
        ShareParams r8 = r6.type(r7.b).docName(r23.getFileModel().c().b).token(r23.getFileModel().c().a).realToken(r23.getFileModel().c().a).realType(r7.b).url(r5).originUrl(r1.getOriginUrl()).isOwner(r24.k()).module("drive").isWiki(r3).subType(r23.getFileModel().c().k).feedId(r2).isAtVC(r23.isVCFollowMode()).build();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.b(r8.getType()) == false) goto L17;
        ((c) org.koin.java.a.a(c.class)).id(r8, r1.getReminderBinder());
    L18:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).ea("file", r1.getFileId());
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(null, r1.getFileId(), r7.b, false, r23.getFileModel().c().k, "share", "ccm_permission_share_view", "", "", false, r23.isVCFollowMode(), null, r24.k(), r24.b.a.getReportJson()));
        return;
    L17:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).aa(r8, r1.getReminderBinder(), null);
        goto L18
    L11:
        if (TextUtils.isEmpty(r1.getOriginUrl()) == true) goto L13;
        r5 = r1.getOriginUrl();
        goto L14
    }
}
