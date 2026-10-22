package com.bytedance.ee.bear.wikiv2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.more.itemv2.SpaceMoveToItem;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiException;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiInfoPlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiMakeCopyPlugin;
import com.bytedance.ee.bear.wikiv2.browser.plugin.g1;
import com.bytedance.ee.bear.wikiv2.browser.plugin.p0;
import com.bytedance.ee.bear.wikiv2.browser.plugin.t;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiHomeRepositoryImpl;
import com.bytedance.ee.bear.wikiv2.more.WikiDeleteItem;
import com.bytedance.ee.bear.wikiv2.more.WikiExploreStarItem;
import com.bytedance.ee.bear.wikiv2.more.WikiMakeCopyItem;
import com.bytedance.ee.bear.wikiv2.more.WikiPinItem;
import com.bytedance.ee.bear.wikiv2.more.WikiShortcutItem;
import com.bytedance.ee.bear.wikiv2.route.WikiRouteTable;
import com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.CreateNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yq5.j0;
import yq5.q;
import yq5.y;
import yq5.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements com.bytedance.ee.bear.contract.route.parcelable.a {

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r9) {
            TreeNode r10 = (TreeNode) r9;
            Intrinsics.checkNotNullParameter(r10, "treeNode");
            return new com.bytedance.ee.bear.contract.route.parcelable.l(r10.space_id, r10.wiki_token, r10.obj_token, r10.obj_type, r10.title, r10.url);
        }
    }

    public static final class c<P extends com.bytedance.ee.bear.browser.plugin.f> implements com.bytedance.ee.bear.browser.plugin.g {
        public final /* synthetic */ String a;

        public c(String r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.ee.bear.browser.plugin.f r3) {
            WikiMakeCopyPlugin r4 = (WikiMakeCopyPlugin) r3;
            Intrinsics.checkNotNullParameter(r4, "plugin");
            r4.makeCopy(this.a, false);
        }
    }

    static {
    }

    public i() {
    }

    public final void g() {
        tt5.a.h("WikiImpl", "clearWikiDb. ");
        q r0 = (q) WikiDatabase.c().d();
        r0.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r1 = r0.h.acquire();
        r0.a.beginTransaction();
        r1.executeUpdateDelete();     // Catch: Throwable -> L16
        r0.a.setTransactionSuccessful();     // Catch: Throwable -> L16
        r0.a.endTransaction();
        r0.h.release(r1);
        y r2 = (y) WikiDatabase.c().e();
        r2.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r3 = r2.c.acquire();
        r2.a.beginTransaction();
        r3.executeUpdateDelete();     // Catch: Throwable -> L13
        r2.a.setTransactionSuccessful();     // Catch: Throwable -> L13
        r2.a.endTransaction();
        r2.c.release(r3);
        int r4 = WikiHomeRepositoryImpl.e;
        ml5.a.SharedPreferencesC0268a r5 = WikiHomeRepositoryImpl.a.a().a;
        r5.getClass();
        r5.a.clear();
        j0 r6 = (j0) WikiDatabase.c().f();
        r6.a.beginTransaction();
        j0.e(r6);     // Catch: Throwable -> L10
        r6.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r6.a.endTransaction();
        return;
    L10:
        th = move-exception;
        r6.a.endTransaction();
        throw th;
    L13:
        th = move-exception;
        r2.a.endTransaction();
        r2.c.release(r3);
        throw th;
    L16:
        th = move-exception;
        r0.a.endTransaction();
        r0.h.release(r1);
        throw th;
    }

    public final SelectCreationMenuConfig i() {
        return com.bytedance.ee.bear.wikiv2.create.g.a();
    }

    public final boolean m() {
        return yp5.c.j();
    }

    public final com.bytedance.ee.bear.wikiv2.more.e a(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return new com.bytedance.ee.bear.wikiv2.more.e(r2);
    }

    public final Flowable d(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        WikiInfoPlugin r3 = r2.findPlugin(WikiInfoPlugin.class);
        if (r3 == null) goto L7;
        Flowable<Boolean> r4 = r3.updatePerm();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return Flowable.just(Boolean.FALSE);
    }

    public final WikiInfo h(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return (WikiInfo) g1.a(r2).getWikiInfo().getValue();
    }

    public final void j(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        tt5.a.h("WikiImpl", "prepareViewCache.");
        Lazy r0 = FGDowngradeHelper.a;
        if (FGDowngradeHelper.b() == false) goto L6;
        qq5.d.b(r3, new FrameLayout(r3));
        return;
    }

    public final WikiExploreStarItem k(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return new WikiExploreStarItem(r2);
    }

    public final void n(com.bytedance.ee.bear.contract.route.parcelable.k r3) {
        Intrinsics.checkNotNullParameter(r3, "entry");
        z r0 = new z();
        r0.b = r3.a;
        r0.c = r3.b;
        r0.d = r3.c;
        r0.e = r3.d;
        r0.g = r3.f;
        WikiRouteTable.c(r0, r3.e);
    }

    public final LiveData o(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return g1.a(r2).getWikiMetaStatus();
    }

    public final Flowable<WikiInfo> p(String r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        int r0 = ce5.a.h;
        return p0.i(new ce5.a(), r2);
    }

    public final WikiPinItem r(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return new WikiPinItem(r2);
    }

    public final SpaceMoveToItem s(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return new SpaceMoveToItem(r2);
    }

    public final void t(String r3) {
        if (r3 == null) goto L5;
        NonStickyMutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.f> r0 = WikiTreeObserver.a;
        WikiTreeObserver.c.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.c(r3));
        return;
    }

    public final int w(Throwable r3) {
        Intrinsics.checkNotNullParameter("add", "action");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        if (Intrinsics.areEqual("add", "add") == false) goto L7;
        Map<String, Integer> r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        return com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.d(WikiAction.ADD, r3);
    L7:
        if (Intrinsics.areEqual("add", "copy") == false) goto L10;
        Map<String, Integer> r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        return com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.d(WikiAction.MAKE_COPY, r3);
    L10:
        return 0;
    }

    public final WikiDeleteItem x(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return new WikiDeleteItem(r2);
    }

    public final WikiShortcutItem e(PluginHost r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return new WikiShortcutItem(r2, r3);
    }

    public final void f(PluginHost r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "pluginHost");
        r3.findPluginToDo(WikiMakeCopyPlugin.class, new c(r4));
    }

    public final void l(Context r2, WikiInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        WikiException.validate(r2, r3);
    }

    public final com.bytedance.ee.bear.wikiv2.more.a u(FragmentActivity r2, Document r3) {
        return new com.bytedance.ee.bear.wikiv2.more.a(r2, r3);
    }

    public final String v(PluginHost r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        return g1.a(r2).getSpaceId();
    }

    public final WikiMakeCopyItem c(PluginHost r2, String r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        return new WikiMakeCopyItem(r2, r3, r4);
    }

    public final Flowable<com.bytedance.ee.bear.contract.route.parcelable.l> b(String r9, String r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "extraInfo");
        if (TextUtils.isEmpty(r9) == false) goto L5;
        String r2 = null;
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L9;
        String r3 = null;
    L10:
        CreateNodePuller.Params r0 = new CreateNodePuller.Params(r2, r3, null, r11, "");
        r0.expand_shortcut = false;
        r0.wiki_token = null;
        if ((!StringsKt.isBlank(r13)) == false) goto L14;
        r0.ext_info_str = r13;
    L14:
        if (TextUtils.isEmpty(r12) == true) goto L17;
        r0.template_token = r12;
    L17:
        return new CreateNodePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(r0).map(b.a);
    L9:
        r3 = r10;
        goto L10
    L5:
        r2 = r9;
        goto L7
    }

    public final void q(String r11, String r12, String r13, int r14, FragmentActivity r15, NetService r16, CompositeDisposable r17) {
        Intrinsics.checkNotNullParameter(r11, "spaceId");
        Intrinsics.checkNotNullParameter(r12, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r13, "objToken");
        Intrinsics.checkNotNullParameter(r15, "activity");
        Intrinsics.checkNotNullParameter(r16, "netService");
        Intrinsics.checkNotNullParameter(r17, "disposables");
        r17.add(t.a(r16, r15, new WikiDialogs(), r11, r12, r13, r14, null));
    }
}
