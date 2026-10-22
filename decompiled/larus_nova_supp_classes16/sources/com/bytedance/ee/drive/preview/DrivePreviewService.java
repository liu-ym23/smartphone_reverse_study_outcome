package com.bytedance.ee.drive.preview;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.container.ContainerFragment;
import com.bytedance.ee.bear.drive.core.fragment.j;
import com.bytedance.ee.bear.drive.loader.download.platform.api.DriveFileInfoLoader;
import com.bytedance.ee.bear.drive.loader.download.platform.api.DriveImagePreviewLoader;
import com.bytedance.ee.bear.drive.loader.download.platform.api.DriveVideoPreviewLoader;
import com.bytedance.ee.drive.render.m;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class DrivePreviewService implements f {
    public final String a;
    public volatile o b;
    public final CompositeDisposable c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final a85.c Jd() {
        return new DriveVideoPreviewLoader();
    }

    @Override // com.bytedance.ee.drive.preview.f
    public final void onDestroy() {
        this.c.clear();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final a85.a u8() {
        return new DriveFileInfoLoader();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final a85.b y7() {
        return new DriveImagePreviewLoader();
    }

    @Override // com.bytedance.ee.drive.preview.e
    public final boolean B1() {
        boolean r0 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("ccm.ai.html_preview");
        tt5.a.h(this.a, "isHtmlFilePreviewEnabled()...enable = " + r0);
        return r0;
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final o l6() {
        return this.b;
    }

    public DrivePreviewService(by4.b r3) {
        Intrinsics.checkNotNullParameter("OfficeDrivePreviewService", "logTag");
        Intrinsics.checkNotNullParameter(r3, "kvStorage");
        this.a = "OfficeDrivePreviewService";
        this.c = new CompositeDisposable();
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final void k1(o r3) {
        this.b = r3;
        StringBuilder r0 = new StringBuilder("setHostPluginProvider, hasProvider=");
        if (r3 == null) goto L5;
        boolean r4 = true;
    L6:
        r0.append(r4);
        tt5.a.h("DrivePreviewService", r0.toString());
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final DrivePreviewOpenRequest o9(final DrivePreviewOpenRequest r9) {
        Intrinsics.checkNotNullParameter(r9, "request");
        List<DrivePreviewOpenItem> r0 = r9.normalizedFileList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        DrivePreviewOpenItem r4 = (DrivePreviewOpenItem) r3;
        boolean r5 = false;
        if (r4.getToken().length() <= 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L11;
    L13:
        if (r5 == false) goto L4;
        r1.add(r3);
        goto L4
    L11:
        if (r4.getObjType() != 12) goto L13;
        r5 = true;
        goto L13
    L8:
        r6 = false;
        goto L9
    L15:
        int r7 = com.bytedance.ee.drive.render.g.a;
        com.bytedance.ee.drive.render.g.a r8 = com.bytedance.ee.drive.render.g.a(r1, r9.getCurrent().getToken(), DrivePreviewService$prepareOpenRequest$result$1.INSTANCE, new DrivePreviewService$prepareOpenRequest$result$2(j.a), new DrivePreviewService$prepareOpenRequest$result$3(r9));
        if (r8.c == false) goto L18;
        ArrayList r10 = r8.a;
    L20:
        return DrivePreviewOpenRequest.copy$default(r9, null, r10, null, null, 13, null);
    L18:
        r10 = new ArrayList();
        goto L20
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final Fragment Z5(String r3, hk5.a r4, com.bytedance.ee.bear.container.f r5) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Bundle r1 = new Bundle();
        r1.putString("url", r3);
        PassportcConvention.f(r1, LarkContext.getApplication());
        ContainerFragment r6 = new ContainerFragment();
        r6.s = r5;
        if (com.bytedance.ee.bear.bizwidget.officesdk.a.a() == false) goto L8;
        final String r7 = UUID.randomUUID().toString();
        r1.putString("plugin_host_callback_key", r7);
        if (r4 == null) goto L7;
        hk5.b.b(r7, r4);
    L7:
        r6.getLifecycle().addObserver(new DrivePreviewService$openPreviewFragment$2(r7));
    L8:
        r6.setArguments(r1);
        return r6;
    }

    @Override // com.bytedance.ee.drive.preview.d
    public final Fragment Ae(DrivePreviewOpenRequest r8, List<? extends i> r9, hk5.a r10, com.bytedance.ee.bear.container.f r11) {
        Intrinsics.checkNotNullParameter(r8, "request");
        StringBuilder r0 = new StringBuilder("openPreviewFragment, currentUrlIsNull=");
        boolean r2 = true;
        if (r8.getCurrent().getUrl() != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h("DrivePreviewService", r0.toString());
        String r3 = r8.getCurrent().getUrl();
        if (r3 != null) goto L9;
        r3 = p.a().A9(sbb.e.l.getType(), r8.getCurrent().getToken());
    L9:
        Fragment r12 = Z5(r3, r10, r11);
        Bundle r13 = r12.getArguments();
        if (r13 == null) goto L12;
        r13.putSerializable(DrivePreviewOpenRequest.EXTRA_KEY, r8);
    L12:
        List<? extends i> r14 = r9;
        if (r14 != null) goto L15;
    L18:
        if (r2 == true) goto L35;
        com.bytedance.ee.drive.render.j r16 = ((s85.a) this).U4(LarkContext.getApplication());
        m r17 = ((s85.a.b) r16).d();
        LinkedHashSet r4 = new LinkedHashSet();
        Iterator<T> r18 = r9.iterator();
    L21:
        if (r18.hasNext() == false) goto L32;
        i r5 = (i) r18.next();
        Class<?> r6 = r5.getClass();
        if (r4.add(r6) == true) goto L36;
        tt5.a.k("DrivePreviewService", "installHostAbilities duplicate abilityType=" + r6);
    L36:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L27
        r17.c(r5.getClass(), r5);     // Catch: Throwable -> L27
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L21;
        tt5.a.e("DrivePreviewService", "installHostAbilities failed, abilityType=" + r6, r20, false);
    L27:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L32:
        Bundle r22 = r12.getArguments();
        if (r22 == null) goto L35;
        r22.putString("drive_open_strategy_key", x75.a.b(r16));
    L35:
        return r12;
    L15:
        if (r14.isEmpty() == true) goto L18;
        r2 = false;
        goto L18
    L5:
        r1 = false;
        goto L6
    }
}
