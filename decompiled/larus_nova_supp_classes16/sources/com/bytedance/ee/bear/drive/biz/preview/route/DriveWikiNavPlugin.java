package com.bytedance.ee.bear.drive.biz.preview.route;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.DocContainerInfo;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.contract.route.parcelable.WikiRouteBean;
import com.bytedance.ee.bear.contract.route.parcelable.k;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.s4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.biz.multitask.DriveMultiTaskPlugin;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DriveHostAbilityPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import jdb.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/route/DriveWikiNavPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "handleContainerInfo", "containerInfo", "Lcom/bytedance/ee/bear/DocContainerInfo;", "handleMoveToWiki", "wikiToken", "", "logid", "routeToWiki", "addRouteEntry", "logId", "checkFinish", "sendMoveToWikiToVC", "generateWikiUrl", "onDetachFromHost", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveWikiNavPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    public static final String FROM_MOV_WIKI = "move_to_wiki";
    public static final String TAG = "DriveWikiNavPlugin";
    private final CompositeDisposable disposable;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DriveWikiNavPlugin a;

        public b(DriveWikiNavPlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            DocContainerInfo r4 = (DocContainerInfo) r3;
            tt5.a.h(DriveWikiNavPlugin.TAG, "resp drive containerinfo is " + r4);
            DriveWikiNavPlugin r0 = this.a;
            Intrinsics.checkNotNull(r4);
            DriveWikiNavPlugin.access$handleContainerInfo(r0, r4);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            tt5.a.d(DriveWikiNavPlugin.TAG, "request drive containerinfo error " + ((Throwable) r3).getMessage());
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveWikiNavPlugin() {
        this.disposable = new CompositeDisposable();
    }

    private final void checkFinish() {
        if (getHost().c.isVCFollowMode() == false) goto L5;
        return;
    L5:
        if (AppInfoUtils.f().booleanValue() == true) goto L9;
        getHost().getActivity().getIntent().putExtra("release_webview", false);
        getHost().getActivity().finish();
        getHost().getActivity().overridePendingTransition(0, 0);
        return;
    }

    private final void sendMoveToWikiToVC() {
        if (getHost().c.isVCFollowMode() == false) goto L6;
        getHost().findPluginToDo(FollowPlugin.class, d.a);
        return;
    }

    private final String generateWikiUrl(String r4) {
        if (a95.b.a("ccm.mobile.domain_geo_replace_ecm") == false) goto L20;
        DriveHostAbilityPlugin r0 = (DriveHostAbilityPlugin) findPlugin(DriveHostAbilityPlugin.class);
        String r1 = null;
        if (r0 == null) goto L10;
        BearUrl r2 = r0.getOriginBearUrl();
        if (r2 == null) goto L10;
        Map<String, String> r3 = r2.d;
        if (r3 == null) goto L10;
    L15:
        if (r0 == null) goto L18;
        r1 = r0.getOriginUrl();
    L18:
        return z75.d.b(r4, r3, r1);
    L10:
        if (r0 == null) goto L14;
        BearUrl r5 = r0.getBearUrl();
        if (r5 == null) goto L14;
        r3 = r5.d;
    L14:
        r3 = null;
        goto L15
    L20:
        if (TextUtils.isEmpty(r4) == false) goto L24;
        return "";
    L24:
        if ((getHost().c.getOpenEntity() instanceof SpaceFileOpenEntity) == false) goto L37;
        DriveHostAbilityPlugin r6 = (DriveHostAbilityPlugin) findPlugin(DriveHostAbilityPlugin.class);
        if (r6 == null) goto L31;
        BearUrl r7 = r6.getBearUrl();
        if (r7 == null) goto L31;
        Map<String, String> r8 = r7.d;
        if (r8 == null) goto L31;
    L33:
        if (r8.containsKey(DocRedirectToDocxPlugin.FROM) == true) goto L38;
        r8.put(DocRedirectToDocxPlugin.FROM, FROM_MOV_WIKI);
    L38:
        return p.a().Le(e.n.getType(), r4, r8);
    L31:
        r8 = new HashMap();
        goto L33
    L37:
        return p.a().A9(e.n.getType(), r4);
    }

    private final void handleContainerInfo(DocContainerInfo r3) {
        int r0 = r3.getBiz_type();
        int r1 = com.bytedance.ee.bear.a.a;
        if (r0 != 2) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        handleMoveToWiki(r3.getNode_token(), r3.getLogId());
        return;
    L9:
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final void routeToWiki(String r11) {
        String r0 = generateWikiUrl(r11);
        if (TextUtils.isEmpty(r0) == true) goto L6;
        sendMoveToWikiToVC();
        h r1 = (h) org.koin.java.a.c(h.class, null, null, 6);
        tt5.a.h(TAG, "This file has been moved to wiki. wikiToken: " + du5.b.i(r11));
        WikiRouteBean r2 = new WikiRouteBean(getHost().c.getFileId(), 12, r11, "", "");
        Bundle r12 = new Bundle();
        r12.putBoolean("popLastDocument", true);
        r12.putString("redirect", FROM_MOV_WIKI);
        ((RouteBean) r2).n = r12;
        ((RouteBean) r2).a = 0;
        int r13 = lw4.a.g;
        ((RouteBean) r2).o = com.bytedance.ee.util.ui.a.a(getActivity());
        r1.m9(r0, r2);
        checkFinish();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        tt5.a.b(TAG, "onAttachToHost !");
        super.onAttachToHost(r4);
        if (r4.c.isTypeWiki() == false) goto L5;
        return;
    L5:
        a95.a r0 = r4.e;
        if (r0 == null) goto L10;
        g r1 = r0.c;
        if (r1 == null) goto L10;
        boolean r2 = r1.isEnable("ccm.mobile.drive_wiki_nav_history");
    L11:
        if (r2 == true) goto L13;
    L15:
        String r5 = r4.c.getFileId();
        Disposable r6 = ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).d(r5, 12).subscribe(new b(this), c.a);
        this.disposable.add(r6);
        return;
    L13:
        if (Intrinsics.areEqual(r4.c.getOpenEntity().getPreviewFrom(), "history") == false) goto L15;
        return;
    L10:
        r2 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.disposable.clear();
        super.onDetachFromHost(r2);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$handleContainerInfo(DriveWikiNavPlugin r0, DocContainerInfo r1) {
        r0.handleContainerInfo(r1);
    }

    private final void addRouteEntry(String r9, String r10) {
        String r3 = getHost().c.getFileId();
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L20;
        DrivePluginHost r0 = getHost();
        if (r0 == null) goto L13;
        s4 r1 = (s4) r0.getHostAbility(s4.class);
        if (r1 == null) goto L13;
        Fragment r2 = r1.getFragment();
        if (r2 == null) goto L13;
        Bundle r4 = r2.getArguments();
    L14:
        if (r4 == null) goto L16;
        String r5 = r4.getString("redirect");
    L17:
        ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.a.class, null, null, 6)).n(new k(r9, r3, 12, !TextUtils.isEmpty(r5), r10));
        return;
    L16:
        r5 = null;
    L13:
        r4 = null;
        goto L14
    }

    private final void handleMoveToWiki(String r3, String r4) {
        DriveMultiTaskPlugin r0 = (DriveMultiTaskPlugin) findPlugin(DriveMultiTaskPlugin.class);
        if (r0 == null) goto L5;
        r0.setNeedAddVisitRecord(false);
    L5:
        routeToWiki(r3);
        addRouteEntry(r3, r4);
    }
}
