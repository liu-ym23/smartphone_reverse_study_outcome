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

/* JADX INFO: loaded from: classes16.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.contract.route.parcelable.a$a, reason: collision with other inner class name */
    public static final class C3095a {
        public static /* synthetic */ BaseMoreItem a(a r100, PluginHost r101, String r102) {
            return r100.c(r101, r102, Boolean.FALSE);
        }
    }

    com.bytedance.ee.bear.wikiv2.more.e a(PluginHost r100);

    Flowable<l> b(String r100, String r101, int r102, String r103, String r104);

    WikiMakeCopyItem c(PluginHost r100, String r101, Boolean r102);

    Flowable d(DocumentPluginHost r100);

    WikiShortcutItem e(PluginHost r100, String r101);

    void f(PluginHost r100, String r101);

    void g();

    WikiInfo h(DocumentPluginHost r100);

    SelectCreationMenuConfig i();

    void j(Context r100);

    WikiExploreStarItem k(PluginHost r100);

    void l(Context r100, WikiInfo r101);

    boolean m();

    void n(k r100);

    LiveData o(DrivePluginHost r100);

    Flowable<WikiInfo> p(String r100);

    void q(String r100, String r101, String r102, int r103, FragmentActivity r104, NetService r105, CompositeDisposable r106);

    WikiPinItem r(PluginHost r100);

    SpaceMoveToItem s(PluginHost r100);

    void t(String r100);

    com.bytedance.ee.bear.wikiv2.more.a u(FragmentActivity r100, Document r101);

    String v(PluginHost r100, Bundle r101);

    int w(Throwable r100);

    WikiDeleteItem x(PluginHost r100);
}
