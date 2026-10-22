package com.bytedance.ee.bear.contract.route.parcelable;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.more.itemv2.SpaceMoveToItem;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.wikiv2.more.WikiDeleteItem;
import com.bytedance.ee.bear.wikiv2.more.WikiExploreStarItem;
import com.bytedance.ee.bear.wikiv2.more.WikiMakeCopyItem;
import com.bytedance.ee.bear.wikiv2.more.WikiPinItem;
import com.bytedance.ee.bear.wikiv2.more.WikiShortcutItem;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.contract.route.parcelable.a$a, reason: collision with other inner class name */
    public static final class C0039a {
        public static /* synthetic */ BaseMoreItem a(a r1, PluginHost r2, String r3) {
            return r1.c(r2, r3, Boolean.FALSE);
        }
    }

    com.bytedance.ee.bear.wikiv2.more.e a(PluginHost r1);

    Flowable<l> b(String r1, String r2, int r3, String r4, String r5);

    WikiMakeCopyItem c(PluginHost r1, String r2, Boolean r3);

    Flowable d(DocumentPluginHost r1);

    WikiShortcutItem e(PluginHost r1, String r2);

    void f(PluginHost r1, String r2);

    void g();

    WikiInfo h(DocumentPluginHost r1);

    SelectCreationMenuConfig i();

    void j(Context r1);

    WikiExploreStarItem k(PluginHost r1);

    void l(Context r1, WikiInfo r2);

    boolean m();

    void n(k r1);

    LiveData o(DrivePluginHost r1);

    Flowable<WikiInfo> p(String r1);

    void q(String r1, String r2, String r3, int r4, FragmentActivity r5, NetService r6, CompositeDisposable r7);

    WikiPinItem r(PluginHost r1);

    SpaceMoveToItem s(PluginHost r1);

    void t(String r1);

    com.bytedance.ee.bear.wikiv2.more.a u(FragmentActivity r1, Document r2);

    String v(PluginHost r1, Bundle r2);

    int w(Throwable r1);

    WikiDeleteItem x(PluginHost r1);
}
