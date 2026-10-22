package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.content.Context;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.NonStickyMutableLiveData;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.FavoritePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.UnfavoritePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiFavoritePlugin extends BasePluginV2 {
    private static final String TAG = "WikiStarPlugin";
    private final CompositeDisposable disposables;
    private NetService netService;

    public static /* synthetic */ void a(WikiFavoritePlugin r0, Throwable r1) {
        r0.lambda$unfavorite$5(r1);
    }

    public static /* synthetic */ void c(WikiFavoritePlugin r0, Throwable r1) {
        r0.lambda$favorite$1(r1);
    }

    public static /* synthetic */ void d(WikiFavoritePlugin r0, String r1, String r2, Boolean r3) {
        r0.lambda$favorite$2(r1, r2, r3);
    }

    public static /* synthetic */ void e(WikiFavoritePlugin r0, Throwable r1) {
        r0.lambda$favorite$3(r1);
    }

    public static /* synthetic */ void f(WikiFavoritePlugin r0, WikiViewModel r1, Boolean r2) {
        r0.lambda$unfavorite$6(r1, r2);
    }

    public static /* synthetic */ void g(WikiFavoritePlugin r0, String r1, String r2, Boolean r3) {
        r0.lambda$unfavorite$4(r1, r2, r3);
    }

    public static /* synthetic */ void h(WikiFavoritePlugin r0, WikiViewModel r1, Boolean r2) {
        r0.lambda$favorite$0(r1, r2);
    }

    public static /* synthetic */ void i(WikiFavoritePlugin r0, Throwable r1) {
        r0.lambda$unfavorite$7(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public WikiFavoritePlugin() {
        this.disposables = new CompositeDisposable();
    }

    public void favorite() {
        final WikiViewModel r0 = g1.a(getHost());
        String r4 = r0.getSpaceId();
        String r5 = r0.getWikiToken();
        if (r0.getWikiMeta() != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        Boolean r8 = Boolean.valueOf(r1);
        String r9 = r0.getObjToken();
        String r11 = r0.getObjTypeValueString();
        if (r0.getWikiMeta() != null) goto L11;
    L13:
        boolean r12 = false;
    L14:
        gq5.d.d(new gq5.d.a("star_page", "none", r4, r5, r8, r9, r11, r12));
        this.disposables.add(new FavoritePuller(this.netService).c(new FavoritePuller.Params(r0.getSpaceId(), r0.getWikiToken())).map(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.v()).subscribe(new u(this, r0), new v(this)));
        return;
    L11:
        if (r0.getWikiMeta().origin_is_external == false) goto L13;
        r12 = true;
        goto L14
    L5:
        if (r0.getWikiMeta().isShortcut() == false) goto L7;
        r1 = true;
        goto L8
    }

    public void unfavorite() {
        final WikiViewModel r0 = g1.a(getHost());
        String r4 = r0.getSpaceId();
        String r5 = r0.getWikiToken();
        if (r0.getWikiMeta() != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        Boolean r8 = Boolean.valueOf(r1);
        String r9 = r0.getObjToken();
        String r11 = r0.getObjTypeValueString();
        if (r0.getWikiMeta() != null) goto L11;
    L13:
        boolean r12 = false;
    L14:
        gq5.d.d(new gq5.d.a("unstar_page", "none", r4, r5, r8, r9, r11, r12));
        this.disposables.add(new UnfavoritePuller(this.netService).c(new UnfavoritePuller.Params(r0.getSpaceId(), r0.getWikiToken())).map(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.z()).subscribe(new y(this, r0), new z(this)));
        return;
    L11:
        if (r0.getWikiMeta().origin_is_external == false) goto L13;
        r12 = true;
        goto L14
    L5:
        if (r0.getWikiMeta().isShortcut() == false) goto L7;
        r1 = true;
        goto L8
    }

    private void lambda$favorite$1(Throwable r4) throws Exception {
        tt5.a.e(TAG, "wiki favorite fail. ", r4, false);
        Context r0 = getHost().getContext();
        Map<String, Integer> r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showFailureText(r0, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.b(WikiAction.FAVORITE, r4));
    }

    private void lambda$favorite$3(Throwable r4) throws Exception {
        tt5.a.e(TAG, "wiki favorite fail. ", r4, false);
        Context r0 = getHost().getContext();
        Map<String, Integer> r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showFailureText(r0, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.b(WikiAction.FAVORITE, r4));
    }

    private void lambda$unfavorite$5(Throwable r4) throws Exception {
        tt5.a.e(TAG, "wiki unfavorite fail. ", r4, false);
        Context r0 = getHost().getContext();
        Map<String, Integer> r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showFailureText(r0, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.b(WikiAction.UNFAVORITE, r4));
    }

    private void lambda$unfavorite$7(Throwable r4) throws Exception {
        tt5.a.e(TAG, "wiki unfavorite fail. ", r4, false);
        Context r0 = getHost().getContext();
        Map<String, Integer> r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showFailureText(r0, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.b(WikiAction.UNFAVORITE, r4));
    }

    public void onAttachToHost(PluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        tt5.a.h(TAG, "onAttachToHost. ");
        this.netService = (NetService) r3.getUserComponent().a(NetService.class);
    }

    public void onDetachFromHost(PluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        this.disposables.clear();
    }

    private /* synthetic */ void lambda$favorite$0(WikiViewModel r1, Boolean r2) throws Exception {
        notifyDoFavorite(r1, true);
        Context r3 = getHost().getContext();
        Map<String, Integer> r4 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showSuccessText(r3, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f(WikiAction.FAVORITE));
    }

    private /* synthetic */ void lambda$unfavorite$6(WikiViewModel r1, Boolean r2) throws Exception {
        notifyDoFavorite(r1, false);
        Context r3 = getHost().getContext();
        Map<String, Integer> r4 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showSuccessText(r3, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f(WikiAction.UNFAVORITE));
    }

    private void notifyDoFavorite(WikiViewModel r4, boolean r5) {
        TreeNode r0 = r4.getWikiMeta();
        if (r0 == null) goto L5;
        r0.is_star = r5;
    L5:
        NonStickyMutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.f> r1 = WikiTreeObserver.a;
        WikiTreeObserver.b.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.b(r4.getSpaceId(), r4.getWikiToken(), r5));
    }

    public void favorite(final String r4, final String r5) {
        this.disposables.add(new FavoritePuller(this.netService).c(new FavoritePuller.Params(r4, r5)).map(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.v()).subscribe(new w(this, r4, r5), new x(this)));
    }

    public void unfavorite(final String r4, final String r5) {
        this.disposables.add(new UnfavoritePuller(this.netService).c(new UnfavoritePuller.Params(r4, r5)).map(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.z()).subscribe(new a0(this, r4, r5), new b0(this)));
    }

    private /* synthetic */ void lambda$favorite$2(String r1, String r2, Boolean r3) throws Exception {
        notifyDoFavorite(r1, r2, true);
        Context r4 = getHost().getContext();
        Map<String, Integer> r5 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showSuccessText(r4, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f(WikiAction.FAVORITE));
    }

    private /* synthetic */ void lambda$unfavorite$4(String r1, String r2, Boolean r3) throws Exception {
        notifyDoFavorite(r1, r2, false);
        Context r4 = getHost().getContext();
        Map<String, Integer> r5 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showSuccessText(r4, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f(WikiAction.UNFAVORITE));
    }

    private void notifyDoFavorite(String r3, String r4, boolean r5) {
        NonStickyMutableLiveData<com.bytedance.ee.bear.wikiv2.wikitreev2.f> r0 = WikiTreeObserver.a;
        WikiTreeObserver.b.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.b(r3, r4, r5));
    }
}
