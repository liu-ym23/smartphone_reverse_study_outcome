package com.bytedance.ee.bear.wikiv2.extension;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.feed.export.bean.h;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import s45.p;
import xp5.e;
import xp5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LoadDataToCacheExtension extends g implements LifecycleObserver {
    public final ce5.a b;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        tt5.a.h("LoadDataToCacheExtension", "onDestroy");
    }

    @Override // xp5.g
    public final void k(Intent r4) {
        ce5.a r5 = this.b;
        String r0 = getActivity().getIntent().getStringExtra(ResourceData.KEY_URL);
        BearUrl r1 = getActivity().getIntent().getParcelableExtra("bear_url");
        if (r1 != null) goto L5;
    L6:
        r1 = p.a().Z(p.a().v8(r0));
    L7:
        m(r5, r1, null);
        return;
    L5:
        if (r1.e != null) goto L7;
        goto L6
    }

    public LoadDataToCacheExtension(AppCompatActivity r3, ce5.a r4) {
        super(r3);
        this.b = r4;
        r3.getLifecycle().addObserver(this);
        ((h) org.koin.java.a.a(h.class)).h();
        d r5 = (d) org.koin.java.a.a(d.class);
        r5.h("start_open");
        r5.j("start_open", "start_time", String.valueOf(System.currentTimeMillis()));
        DocBridgeWebViewV2.w3 = System.currentTimeMillis();
        j.a.a.a().observe(getActivity(), new xp5.c());
    }

    public static void m(final ce5.a r2, final BearUrl r3, final WikiInfo r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        d25.d.i();
        Flowable.just("").observeOn(fo5.d.b()).subscribe(new xp5.d(r3, r4, r2), new e());
    }
}
