package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.view.View;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f196412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DmtTextView f196413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f196414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DmtTextView f196415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DmtTextView f196416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ DmtTextView f196417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ECMultiProCardVPAdapter f196418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ View f196419h;

    public final void a() {
        long r100 = this.f196412a - (System.currentTimeMillis() / ((long) 1000));
        if (r100 <= 0) goto L39;
        long r101 = 86400;
        if (r100 <= r101) goto L18;
        int r102 = (int) (r100 / r101);
        DmtTextView r103 = this.f196413b;
        if (r103 == null) goto L10;
        StringBuilder r104 = new StringBuilder();
        r104.append(r102);
        r104.append(22825);
        r103.setText(r104.toString());
    L10:
        DmtTextView r105 = this.f196413b;
        if (r105 == null) goto L14;
        r105.setVisibility(0);
    L14:
        View r106 = this.f196414c;
        if (r106 == null) goto L38;
        r106.setVisibility(8);
    L38:
        this.f196418g.f196356d.postDelayed(this, 1000);
        return;
    L18:
        long r107 = AnnouncementViewModel.HOUR_DURATION;
        int r108 = (int) (r100 / r107);
        long r109 = 60;
        int r110 = (int) ((r100 % r107) / r109);
        int r111 = (int) (r100 % r109);
        DmtTextView r112 = this.f196415d;
        if (r112 == null) goto L22;
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        r112.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r108)}, 1)));
    L22:
        DmtTextView r114 = this.f196416e;
        if (r114 == null) goto L26;
        StringCompanionObject r115 = StringCompanionObject.INSTANCE;
        r114.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r110)}, 1)));
    L26:
        DmtTextView r116 = this.f196417f;
        if (r116 == null) goto L30;
        StringCompanionObject r117 = StringCompanionObject.INSTANCE;
        r116.setText(String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r111)}, 1)));
    L30:
        DmtTextView r118 = this.f196413b;
        if (r118 == null) goto L34;
        r118.setVisibility(8);
    L34:
        View r119 = this.f196414c;
        if (r119 == null) goto L38;
        r119.setVisibility(0);
        goto L38
    L39:
        DmtTextView r120 = this.f196413b;
        if (r120 == null) goto L43;
        r120.setText("0天");
    L43:
        DmtTextView r121 = this.f196413b;
        if (r121 == null) goto L47;
        r121.setVisibility(0);
    L47:
        View r122 = this.f196414c;
        if (r122 == null) goto L51;
        r122.setVisibility(8);
    L51:
        this.f196418g.f196357e.remove(this.f196419h);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(long r100, DmtTextView r101, View r102, DmtTextView r103, DmtTextView r104, DmtTextView r105, ECMultiProCardVPAdapter r106, View r107) {
        this.f196412a = r100;
        this.f196413b = r101;
        this.f196414c = r102;
        this.f196415d = r103;
        this.f196416e = r104;
        this.f196417f = r105;
        this.f196418g = r106;
        this.f196419h = r107;
    }
}
