package com.bytedance.ee.bear.wikiv2.browser.plugin;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.DelSingleNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t {
    public static Disposable a(NetService r7, final FragmentActivity r8, final WikiDialogs r9, final String r10, final String r11, final String r12, final int r13, final WikiDeletePlugin.c r14) {
        DelSingleNodePuller.Params r0 = new DelSingleNodePuller.Params(r10, r11, String.valueOf(System.currentTimeMillis()));
        Flowable r15 = new DelSingleNodePuller(r7).c(r0).map(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.a0()).flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.k0(r7)).doOnSubscribe(new m(r9, r8));
        Objects.requireNonNull(r9);
        return r15.doFinally(new n(r9)).subscribe(new o(r13, r12, r11, r8, r14), new p(r13, r9, r8, r11, r10));
    }
}
