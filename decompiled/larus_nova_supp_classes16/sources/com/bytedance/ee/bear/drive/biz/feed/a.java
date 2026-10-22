package com.bytedance.ee.bear.drive.biz.feed;

import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentVM;
import com.bytedance.ee.bear.drive.biz.comment.m1;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.f;
import com.bytedance.ee.bear.middleground.feed.export.bean.h;
import com.bytedance.ee.bear.middleground.feed.export.bean.i;
import dg5.a0;
import fo5.d;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import uf5.q0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a implements c {
    public final FragmentActivity a;
    public f b;
    public final FrameLayout c;
    public final DriveViewModel d;
    public final DriveMGPermissionVM e;
    public final DriveCommentVM f;

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public void a(boolean r1, boolean r2) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public void d(DriveFeedPlugin.b r1) {
    }

    public final boolean k() {
        if ((this.d.getOpenEntity() instanceof SpaceFileOpenEntity) == true) goto L5;
        return false;
    L5:
        SpaceFileOpenEntity r0 = (SpaceFileOpenEntity) this.d.getOpenEntity();
        if (iu5.b.a(r0.getUrl()) == false) goto L8;
    L9:
        return true;
    L8:
        if (iu5.b.b(r0.getUrl()) == true) goto L9;
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public final void e(Configuration r3) {
        com.bytedance.ee.bear.middleground.feed.a r0 = this.b;
        if (r0 == null) goto L6;
        a0 r1 = r0.a;
        r1.g();
        r1.j.e();
        r1.j.f();
        r1.b(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public final void g(List<String> r2) {
        com.bytedance.ee.bear.middleground.feed.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.e(r2);
        return;
    }

    public final void i(String r3) {
        DriveViewModel r0 = this.d;
        if (r0 != null) goto L5;
    L9:
        String r1 = null;
    L10:
        ((k) org.koin.java.a.a(k.class)).e(r3, r1);
        return;
    L5:
        if (r0.getFileModel() == null) goto L9;
        if (this.d.getFileModel().c() == null) goto L9;
        r1 = this.d.getFileModel().c().b;
        goto L10
    }

    public a(m1 r2, FrameLayout r3) {
        this.a = r2.getActivity();
        PreviewViewModel r0 = (PreviewViewModel) r2.a(PreviewViewModel.class);
        this.d = r2.S().c;
        this.e = (DriveMGPermissionVM) r2.a(DriveMGPermissionVM.class);
        this.c = r3;
        this.f = (DriveCommentVM) r2.a(DriveCommentVM.class);
        o75.b.a().getDriveConfig();
    }

    public static MessageConfig h(u55.b r3, boolean r4) {
        MessageConfig r0 = new MessageConfig();
        if (r3 != null) goto L5;
        return r0;
    L5:
        boolean r1 = r3.a();
        r0.setToken(r3.a);
        r0.setDocumentType(e.l);
        r0.setAuto(r4);
        r0.setCanReopen(r1);
        r0.setWhole(false);
        tt5.a.h("DriveFeedManager", "canCopy=" + r3.b());
        r0.setCanCopy(r3.b());
        r0.setOwner(r3.k());
        return r0;
    }

    public final void j(u55.b r9, i r10) {
        h r0 = (h) org.koin.java.a.a(h.class);
        if (r9 == null) goto L5;
        String r2 = r9.a;
    L6:
        q0 r1 = r0.a(r2, e.l);
        h r3 = (h) org.koin.java.a.a(h.class);
        com.bytedance.ee.bear.middleground.feed.export.bean.b r4 = new com.bytedance.ee.bear.middleground.feed.export.bean.b();
        FragmentActivity r5 = this.a;
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r4.a = r5;
        FrameLayout r6 = this.c;
        Intrinsics.checkNotNullParameter(r6, "parentView");
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r4.b = r6;
        boolean r7 = false;
        MessageConfig r8 = h(r9, false);
        Intrinsics.checkNotNullParameter(r8, "messageConfig");
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r4.e = r8;
        Intrinsics.checkNotNullParameter(r10, "feedListener");
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r4.d = r10;
        Intrinsics.checkNotNullParameter(r1, "feedData");
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r4.c = r1;
        com.bytedance.ee.bear.middleground.feed.a r11 = r3.k(r4);
        this.b = r11;
        if (r9 != null) goto L9;
    L11:
        r11.d(r7, "").subscribeOn(d.e()).subscribe(new g55.a(), new g55.b());
        return;
    L9:
        if (r9.k() == false) goto L11;
        r7 = true;
        goto L11
    L5:
        r2 = "";
        goto L6
    }
}
