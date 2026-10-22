package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.BasePluginV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.AnalyticConstant;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.s4;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t4;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiShortcutPlugin extends BasePluginV2 implements sa5.a {
    private static final String TAG = "WikiShortcutPlugin";
    private final CompositeDisposable disposables;
    private WikiDialogs wikiDialogs;
    private WikiViewModel wikiViewModel;

    public class a extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ TreeNode c;
        public final /* synthetic */ String d;
        public final /* synthetic */ WikiShortcutPlugin e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r6) {
            Bundle r7 = new Bundle();
            r7.putString("ccm_open_type", AnalyticConstant.OpenType.WIKI_CREATE_NEW.getType());
            TreeNode r0 = this.c;
            String r1 = r0.space_id;
            String r2 = this.d;
            String r3 = r0.wiki_token;
            FragmentActivity r4 = WikiShortcutPlugin.access$000(this.e);
            int r5 = lw4.a.g;
            com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.a(r1, r2, r3, r7, Boolean.valueOf(com.bytedance.ee.util.ui.a.a(r4)));
            String r8 = WikiShortcutPlugin.access$100(this.e).getSpaceId();
            TreeNode r9 = this.c;
            gq5.d.b(r8, r9.wiki_token, r9.obj_token, sbb.e.c(r9.obj_type));
        }

        public a(WikiShortcutPlugin r1, TreeNode r2, String r3) {
            this.e = r1;
            this.c = r2;
            this.d = r3;
        }
    }

    public static /* synthetic */ Unit a(WikiShortcutPlugin r0, Document r1) {
        return r0.lambda$onActivityResult$0(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void checkWikiDialogs() {
        if (this.wikiDialogs != null) goto L6;
        this.wikiDialogs = new WikiDialogs();
        return;
    }

    public WikiShortcutPlugin() {
        this.disposables = new CompositeDisposable();
    }

    public boolean isVCFollow() {
        PluginHost r0 = getHost();
        if (r0 == null) goto L10;
        e4 r1 = r0.getHostAbilityOrNull(e4.class);
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.getDocumentMetadata().getOpenSource() != DocsOpenSource.vc) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static /* synthetic */ FragmentActivity access$000(WikiShortcutPlugin r0) {
        return r0.getActivity();
    }

    public static /* synthetic */ WikiViewModel access$100(WikiShortcutPlugin r0) {
        return r0.wikiViewModel;
    }

    private Unit lambda$onActivityResult$0(Document r4) {
        if (r4 == null) goto L8;
        WikiViewModel r0 = this.wikiViewModel;
        if (r0 == null) goto L9;
        gq5.d.b(r0.getSpaceId(), this.wikiViewModel.getWikiToken(), r4.d, sbb.e.c(r4.getType()));
        return null;
    L9:
        return null;
    L8:
        return null;
    }

    public void onAttachToHost(PluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        tt5.a.h(TAG, "onAttachToHost. ");
    }

    public void onDetachFromHost(PluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r1);
        this.disposables.clear();
    }

    public void shortcut(String r28) {
        WikiViewModel r1 = g1.a(getHost());
        this.wikiViewModel = r1;
        TreeNode r2 = r1.getWikiMeta();
        String r5 = this.wikiViewModel.getSpaceId();
        String r6 = this.wikiViewModel.getWikiToken();
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        Boolean r7 = Boolean.valueOf(r3);
        String r8 = this.wikiViewModel.getObjToken();
        String r9 = this.wikiViewModel.getObjTypeValueString();
        if (r2 != null) goto L11;
    L13:
        boolean r10 = false;
    L14:
        gq5.d.d(new gq5.d.a("create_shortcut", "ccm_wiki_file_location_select_view", r5, r6, r7, r8, r9, r10));
        Bundle r4 = new Bundle();
        r4.putString("src_token", this.wikiViewModel.getWikiToken());
        r4.putInt("src_obj_type", this.wikiViewModel.getObjType());
        String r11 = "";
        if (this.wikiViewModel.getWikiMeta() != null) goto L17;
        String r12 = "";
    L18:
        r4.putString("src_origin_token", r12);
        if (this.wikiViewModel.getWikiMeta() != null) goto L21;
    L23:
        boolean r13 = false;
    L24:
        r4.putBoolean("src_is_shortcut", r13);
        if (this.wikiViewModel.getWikiMeta() != null) goto L27;
        String r14 = "";
    L28:
        r4.putString("title", r14);
        if (this.wikiViewModel.getWikiMeta() != null) goto L31;
    L33:
        boolean r15 = false;
    L34:
        r4.putBoolean("src_origin_external", r15);
        r4.putInt("EXTRA_PAGE_MODE", 3);
        r4.putString("trigger_location", "wiki_tree");
        s4 r16 = getHostAbilityOrNull(s4.class);
        if (r16 == null) goto L37;
        Fragment r17 = r16.getFragment();
    L38:
        Fragment r18 = r17;
        if (r2 == null) goto L43;
        WikiDetailInfo r19 = r2.detail_info;
        if (r19 == null) goto L43;
        String r20 = r19.owner_id;
    L44:
        Context r110 = getContext();
        String r111 = this.wikiViewModel.getWikiToken();
        if (r2 == null) goto L48;
        r11 = r2.getOriginToken();
    L48:
        String r112 = r11;
        if (r2 != null) goto L51;
    L53:
        boolean r113 = false;
    L54:
        com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.e(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.d(r18, r110, r111, r112, r113, this.wikiViewModel.getObjToken(), this.wikiViewModel.getObjType(), r28, 1025, r4, false, t4.a(r20)));
        return;
    L51:
        if (r2.isShortcut() == false) goto L53;
        r113 = true;
    L43:
        r20 = "";
        goto L44
    L37:
        r17 = null;
        goto L38
    L31:
        if (this.wikiViewModel.getWikiMeta().origin_is_external == false) goto L33;
        r15 = true;
        goto L34
    L27:
        r14 = this.wikiViewModel.getWikiMeta().getOriginTitle();
        goto L28
    L21:
        if (this.wikiViewModel.getWikiMeta().isShortcut() == false) goto L23;
        r13 = true;
        goto L24
    L17:
        r12 = this.wikiViewModel.getWikiMeta().getOriginToken();
        goto L18
    L11:
        if (r2.origin_is_external == false) goto L13;
        r10 = true;
        goto L14
    L5:
        if (r2.isShortcut() == false) goto L7;
        r3 = true;
        goto L8
    }

    private void showShortcutToast(String r5, TreeNode r6) {
        checkWikiDialogs();
        if (this.wikiViewModel != null) goto L5;
        this.wikiViewModel = g1.a(getHost());
    L5:
        WikiDialogs r0 = this.wikiDialogs;
        Context r1 = getContext();
        Map<String, Integer> r2 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        int r3 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.f(WikiAction.SHORTCUT);
        a r4 = new a(this, r6, r5);
        r0.getClass();
        WikiDialogs.g(r1, r3, r4);
        gq5.d.c(this.wikiViewModel.getSpaceId(), r6.wiki_token, r6.obj_token, sbb.e.c(r6.obj_type));
    }

    public void onActivityResult(int r4, int r5, Intent r6) {
        if (r5 != (-1)) goto L10;
        if (r4 == 1025) goto L6;
        if (r4 != 4025) goto L10;
    L6:
        String[] r7 = com.bytedance.ee.bear.wikiv2.wikitreev2.main.o.g(r6);
        if (r7 == null) goto L15;
        showShortcutToast(r7[3], (TreeNode) r6.getParcelableExtra("tree_node"));
        return;
    L15:
        return;
    L10:
        if (r5 != 1027) goto L17;
        if (r4 == 1025) goto L13;
        if (r4 == 4025) goto L13;
        return;
    L13:
        int r8 = r6.getIntExtra("folder_type", sbb.e.f.b);
        String r9 = r6.getStringExtra("folder_url");
        final Document r10 = (Document) r6.getParcelableExtra("shortcut_info");
        vc5.a.a(r8, isVCFollow(), r9, new t0(this, r10));
        return;
    }
}
