package yp5;

import com.bytedance.ee.util.info.AppInfoUtils;
import idb.f;

/* JADX INFO: loaded from: classes18.dex */
public final class c {
    public static boolean a() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("spacekit.mobile.docx_create_enable");
        tt5.a.h("WikiFGHelperV2", "isEnableCreateWikiDocx:" + r100);
        return r100;
    }

    public static boolean b() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.i("ccm.workspace.mobile.copy_edtion_enable", false);
        tt5.a.h("WikiFGHelperV2", "isEnableEditionDocMakeCopy: " + r100);
        return r100;
    }

    public static boolean c() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("spacekit.mobile.wiki2.0_space_classify_enable");
        tt5.a.h("WikiFGHelperV2", "isEnableSpaceClassify:" + r100);
        return r100;
    }

    public static boolean d() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.spacekit.bitable.enable");
        tt5.a.h("WikiFGHelperV2", "isEnableWikiBitable:" + r100);
        return r100;
    }

    public static boolean e() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.workspace.folder_block_enable");
        tt5.a.h("WikiFGHelperV2", "isEnableWikiFolderBlock: " + r100);
        return r100;
    }

    public static boolean f() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("mindnote_enabled");
        tt5.a.h("WikiFGHelperV2", "isEnableWikiMindnote:" + r100);
        return r100;
    }

    public static boolean g() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.mobile.slides_enabled");
        tt5.a.h("WikiFGHelperV2", "isEnableWikiSlides:" + r100);
        return r100;
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
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.workspace.wiki_root_custom_homepage");
        tt5.a.h("WikiFGHelperV2", "isWikiRootCustomHomePageEnable: " + r100);
        return r100;
    }

    public static boolean j() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.workspace.wiki_to_quickaccess_enabled");
        tt5.a.h("WikiFGHelperV2", "isWikiToQuickAccessEnable: " + r100);
        return r100;
    }
}
