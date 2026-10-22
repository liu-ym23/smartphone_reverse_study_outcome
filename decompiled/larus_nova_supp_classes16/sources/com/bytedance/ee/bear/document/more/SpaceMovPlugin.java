package com.bytedance.ee.bear.document.more;

import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.route.RouteBean;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/document/more/SpaceMovPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePluginV2;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpaceMovPlugin extends BasePluginV2 implements sa5.a {
    public static final a Companion = null;
    public static final String TAG = "SpaceMovPlugin";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SpaceMovPlugin() {
    }

    @Override // sa5.a
    public void onActivityResult(int r3, int r4, Intent r5) {
        tt5.a.h(TAG, "onActivityResult requestCode is " + r3 + " resultCode is " + r4);
        if (r3 != 1030) goto L15;
        if (r5 == null) goto L7;
        String r6 = r5.getStringExtra("move_wiki_token");
        if (r6 == null) goto L7;
    L9:
        if (TextUtils.isEmpty(r6) == true) goto L16;
        String r7 = s45.p.a().A9(FileInfoPuller.CALLER_WIKI, r6);
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L13;
        com.bytedance.ee.bear.route.h r8 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        RouteBean r9 = new RouteBean();
        r9.a(getHost().getHostFragment());
        r9.t = true;
        Unit r0 = Unit.INSTANCE;
        r8.m9(r7, r9);
        return;
    L13:
        getHost().getActivity().finish();
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).u5(r7);
        return;
    L16:
        return;
    L7:
        r6 = "";
        goto L9
    }
}
