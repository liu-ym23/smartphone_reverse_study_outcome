package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.document.s4;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.t4;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiMakeCopyPlugin extends BasePluginV2 implements sa5.a, LifecycleObserver {
    private static final String TAG = "WikiMakeCopyPlugin";
    private String destSpaceName;
    private final CompositeDisposable disposables;
    private String documentName;
    private TreeNode makeCopyNode;
    private String makeCopyUrl;

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private Long getFileSize() {
        w45.b r1 = getHostAbilityOrNull(w45.b.class);
        if (r1 != null) goto L5;
        return 0L;
    L5:
        return r1.getFileSize();
    }

    private void openCopyNode() {
        if (TextUtils.isEmpty(this.makeCopyUrl) == true) goto L6;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).u5(this.makeCopyUrl);
        this.makeCopyUrl = null;
    L6:
        if (this.makeCopyNode == null) goto L9;
        Bundle r0 = new Bundle();
        r0.putString("ccm_open_type", AnalyticConstant.OpenType.WIKI_CREATE_NEW.getType());
        TreeNode r2 = this.makeCopyNode;
        String r3 = r2.space_id;
        String r4 = this.destSpaceName;
        String r5 = r2.wiki_token;
        FragmentActivity r6 = getActivity();
        int r7 = lw4.a.g;
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.a(r3, r4, r5, r0, Boolean.valueOf(com.bytedance.ee.util.ui.a.a(r6)));
        this.makeCopyNode = null;
        this.destSpaceName = "";
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onFragmentResume() {
        tt5.a.h(TAG, "onFragmentResume");
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L6;
        openCopyNode();
        return;
    }

    public WikiMakeCopyPlugin() {
        this.disposables = new CompositeDisposable();
    }

    private String getTitle(WikiViewModel r2) {
        if (TextUtils.isEmpty(this.documentName) == true) goto L6;
        return this.documentName;
    L6:
        return com.bytedance.ee.bear.list.t0.e(getContext(), r2.getObjType());
    }

    public void onAttachToHost(PluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        tt5.a.h(TAG, "onAttachToHost. ");
    }

    public void onDetachFromHost(PluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        this.disposables.clear();
        this.makeCopyUrl = null;
    }

    public void makeCopy(String r36, boolean r37) {
        this.documentName = r36;
        WikiViewModel r1 = g1.a(getHost());
        TreeNode r2 = r1.getWikiMeta();
        String r6 = r1.getSpaceId();
        String r7 = r1.getWikiToken();
        Boolean r8 = Boolean.valueOf(r1.isShortcut());
        String r9 = r1.getObjToken();
        String r10 = r1.getObjTypeValueString();
        if (r2 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        gq5.d.d(new gq5.d.a("create_copy", "ccm_wiki_file_location_select_view", r6, r7, r8, r9, r10, r11));
        Bundle r3 = new Bundle();
        r3.putString("src_token", r1.getWikiToken());
        if (r2 != null) goto L11;
        String r5 = "";
    L12:
        r3.putString("src_origin_token", r5);
        if (r2 != null) goto L15;
    L17:
        boolean r12 = false;
    L18:
        r3.putBoolean("src_is_shortcut", r12);
        r3.putString("src_space_id", r1.getSpaceId());
        if (r2 != null) goto L21;
        String r13 = "";
    L22:
        r3.putString("src_origin_space_id", r13);
        if (r2 != null) goto L25;
        String r14 = "";
    L26:
        r3.putString("src_parent_token", r14);
        r3.putInt("src_obj_type", r1.getObjType());
        r3.putString("title", getTitle(r1));
        if (r2 != null) goto L29;
    L31:
        boolean r15 = false;
    L32:
        r3.putBoolean("src_origin_external", r15);
        r3.putLong("src_file_size", getFileSize().longValue());
        r3.putInt("EXTRA_PAGE_MODE", 4);
        r3.putString("trigger_location", "docs_topbar");
        s4 r16 = getHostAbilityOrNull(s4.class);
        if (r16 == null) goto L35;
        Fragment r17 = r16.getFragment();
    L36:
        Fragment r18 = r17;
        if (r2 == null) goto L41;
        WikiDetailInfo r19 = r2.detail_info;
        if (r19 == null) goto L41;
        String r20 = r19.owner_id;
    L42:
        er5.b r21 = (er5.b) org.koin.java.a.a(er5.b.class);
        if (r1.getObjType() != 8) goto L49;
        if (r37 == false) goto L49;
        if (r21.j() == false) goto L49;
        r21.h(getContext(), r1.getObjToken(), getTitle(r1));
        return;
    L49:
        qc5.a.j();
        Context r110 = getContext();
        String r111 = r1.getWikiToken();
        if (r2 != null) goto L52;
        String r112 = "";
    L53:
        String r22 = r1.getSpaceId();
        if (r2 != null) goto L56;
        String r23 = "";
    L57:
        String r24 = r1.getSpaceName();
        if (r2 != null) goto L60;
    L62:
        boolean r25 = false;
    L63:
        if (r2 != null) goto L65;
        String r26 = "";
    L66:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.c(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.a(r18, r110, r111, r112, r22, r23, r24, r25, r26, r1.getObjToken(), r1.getObjType(), getTitle(r1), getFileSize().longValue(), 1026, r3, false, true, t4.a(r20)));
        return;
    L65:
        r26 = r2.parent_wiki_token;
        goto L66
    L60:
        if (r2.isShortcut() == false) goto L62;
        r25 = true;
        goto L63
    L56:
        r23 = r2.origin_space_id;
        goto L57
    L52:
        r112 = r2.origin_wiki_token;
    L41:
        r20 = "";
        goto L42
    L35:
        r17 = null;
        goto L36
    L29:
        if (r2.origin_is_external == false) goto L31;
        r15 = true;
        goto L32
    L25:
        r14 = r2.parent_wiki_token;
        goto L26
    L21:
        r13 = r2.origin_space_id;
        goto L22
    L15:
        if (r2.isShortcut() == false) goto L17;
        r12 = true;
        goto L18
    L11:
        r5 = r2.getOriginToken();
        goto L12
    L5:
        if (r2.origin_is_external == false) goto L7;
        r11 = true;
        goto L8
    }

    public void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        tt5.a.h(TAG, "onAttachToUIContainer. ");
        if (getLifecycleOwner() == null) goto L6;
        getLifecycleOwner().getLifecycle().addObserver(this);
        return;
    }

    public void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        tt5.a.h(TAG, "onDetachFromUIContainer. ");
        if (getLifecycleOwner() == null) goto L6;
        getLifecycleOwner().getLifecycle().removeObserver(this);
        return;
    }

    public void onActivityResult(int r5, int r6, Intent r7) {
        if (r6 != (-1)) goto L13;
        if (r5 == 1026) goto L6;
        if (r5 != 4026) goto L13;
    L6:
        Toast.cancelLoading();
        Context r8 = getContext();
        Context r9 = getContext();
        Map<String, Integer> r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showSuccessText(r8, r9.getString(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f(WikiAction.MAKE_COPY)));
        if (r7 == null) goto L10;
        this.makeCopyNode = (TreeNode) r7.getParcelableExtra("tree_node");
        this.destSpaceName = r7.getStringExtra("space_name");
        tt5.a.h(TAG, "onActivityResult()...makeCopyNode.");
    L10:
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L23;
        openCopyNode();
        return;
    L23:
        return;
    L13:
        if (r6 != 1028) goto L25;
        if (r5 == 1026) goto L16;
        if (r5 == 4026) goto L16;
        return;
    L16:
        Toast.cancelLoading();
        Context r10 = getContext();
        Context r11 = getContext();
        Map<String, Integer> r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showSuccessText(r10, r11.getString(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f(WikiAction.MAKE_COPY)));
        if (r7 == null) goto L20;
        this.makeCopyUrl = r7.getStringExtra(ResourceData.KEY_URL);
        tt5.a.h(TAG, "onActivityResult()...makeCopyUrl = " + du5.b.g(this.makeCopyUrl));
    L20:
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L27;
        openCopyNode();
        return;
    L27:
        return;
    }
}
