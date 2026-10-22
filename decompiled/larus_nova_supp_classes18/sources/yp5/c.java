package yp5;

import com.bytedance.ee.util.info.AppInfoUtils;
import idb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static boolean a() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.docx_create_enable");
        tt5.a.h("WikiFGHelperV2", "isEnableCreateWikiDocx:" + r0);
        return r0;
    }

    public static boolean b() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.i("ccm.workspace.mobile.copy_edtion_enable", false);
        tt5.a.h("WikiFGHelperV2", "isEnableEditionDocMakeCopy: " + r0);
        return r0;
    }

    public static boolean c() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.f("spacekit.mobile.wiki2.0_space_classify_enable");
        tt5.a.h("WikiFGHelperV2", "isEnableSpaceClassify:" + r0);
        return r0;
    }

    public static boolean d() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.spacekit.bitable.enable");
        tt5.a.h("WikiFGHelperV2", "isEnableWikiBitable:" + r0);
        return r0;
    }

    public static boolean e() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.folder_block_enable");
        tt5.a.h("WikiFGHelperV2", "isEnableWikiFolderBlock: " + r0);
        return r0;
    }

    public static boolean f() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.f("mindnote_enabled");
        tt5.a.h("WikiFGHelperV2", "isEnableWikiMindnote:" + r0);
        return r0;
    }

    public static boolean g() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.mobile.slides_enabled");
        tt5.a.h("WikiFGHelperV2", "isEnableWikiSlides:" + r0);
        return r0;
    }

    public static boolean h() {
        if (Boolean.TRUE.equals(AppInfoUtils.f()) == false) goto L10;
        return false;
    L10:
        return f.a().isCurrentEnable("ccm.wiki.cross_space_search");
    L7:
        e = move-exception;
        tt5.a.l("WikiFGHelperV2", "isWikiCrossSpaceSearchEnable read failed", e);
        return false;
    }

    public static boolean i() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.wiki_root_custom_homepage");
        tt5.a.h("WikiFGHelperV2", "isWikiRootCustomHomePageEnable: " + r0);
        return r0;
    }

    public static boolean j() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.workspace.wiki_to_quickaccess_enabled");
        tt5.a.h("WikiFGHelperV2", "isWikiToQuickAccessEnable: " + r0);
        return r0;
    }
}
