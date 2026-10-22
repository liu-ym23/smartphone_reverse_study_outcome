package com.bytedance.ee.bear.more.protocol3;

import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.protocol3.d f234854b;

    public static final class a extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f234855c = null;

        static {
            f234855c = new a();
        }

        public a() {
            super("ai_summary", R.string.LarkCCM_Docs_AiSummary_Show_Switch, R.drawable.ud_icon_edit_discription_outlined, null, 24);
        }
    }

    public static final class a0 extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a0 f234856c = null;

        static {
            f234856c = new a0();
        }

        public a0() {
            super("permission", R.string.LarkCCM_Docs_PermissionSettings_Menu_Mob, R.drawable.ud_icon_setting_outlined, null, 24);
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f234857c = null;

        static {
            f234857c = new b();
        }

        public b() {
            super("add_shortcut", R.string.LarkCCM_Workspace_Menu_AddShortcutTo, kac.a.b(R.drawable.ud_icon_new_shortcut_outlined), null, 24);
        }
    }

    public static final class b0 extends f {
        public b0(boolean r100) {
            if (r100 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r101 = new com.bytedance.ee.bear.more.protocol3.d(R.string.Doc_List_Remove_Access, R.drawable.ud_icon_cancel_buzz_outlined, 0, 12);
        L6:
            super("pin", r101);
            return;
        L5:
            r101 = new com.bytedance.ee.bear.more.protocol3.d(R.string.Doc_List_Add_Access, R.drawable.ud_icon_buzz_outlined, 0, 12);
            goto L6
        }
    }

    public static final class c extends f {
        public c(boolean r100) {
            String r101 = CommonMoreItemId.ADD_TO_WORKBENCH.getId();
            if (r100 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r102 = new com.bytedance.ee.bear.more.protocol3.d(R.string.Bitable_ShareToWorkplace_AddedToWorkplace_Dropdown, R.drawable.ud_icon_find_app_colorful, R.color.lkui_transparent, 8);
        L6:
            super(r101, r102);
            return;
        L5:
            r102 = new com.bytedance.ee.bear.more.protocol3.d(R.string.Bitable_ShareToWorkplace_ShareToWorkplace_Dropdown, R.drawable.ud_icon_find_app_outlined, 0, 12);
            goto L6
        }
    }

    public static final class c0 extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c0 f234858c = null;

        static {
            f234858c = new c0();
        }

        public c0() {
            super("remove_from_workspace", R.string.LarkCCM_Workspace_Menu_RemoveFromSpace_Mob, R.drawable.ud_icon_no_outlined, null, 24);
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f234859c = null;

        static {
            f234859c = new d();
        }

        public d() {
            super("bitable_add_to_workspace", R.string.Bitable_BaseWorkspace_Home_AddToBaseSpace_Button, R.drawable.ud_icon_move_outlined, null, 24);
        }
    }

    public static final class d0 extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d0 f234860c = null;

        static {
            f234860c = new d0();
        }

        public d0() {
            super(CommonMoreItemId.RENAME.getId(), R.string.Doc_More_RenameSheetTitle, R.drawable.ud_icon_ccm_rename_outlined, null, 24);
        }
    }

    public static final class e extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f234861c = null;

        static {
            f234861c = new e();
        }

        public e() {
            super("bitable_change_workspace", R.string.Bitable_BaseWorkspace_Home_ChangeSpace_Button, R.drawable.ud_icon_switch_outlined, null, 24);
        }
    }

    public static final class e0 extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e0 f234862c = null;

        static {
            f234862c = new e0();
        }

        public e0() {
            super("retention_label", R.string.CreationMobile_Docs_Retention_Settings, R.drawable.ud_icon_operationrecord_outlined, null, 24);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.protocol3.f$f, reason: collision with other inner class name */
    public static final class C3367f extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C3367f f234863c = null;

        static {
            f234863c = new C3367f();
        }

        public C3367f() {
            super("bitable_move_out_workspace", R.string.Bitable_BaseWorkspace_RemoveItFromBaseWorkspace_Button_Mob, R.drawable.ud_icon_no_outlined, null, 24);
        }
    }

    public static final class f0 extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f0 f234864c = null;

        static {
            f234864c = new f0();
        }

        public f0() {
            super("item_revision_switch", R.string.LarkCCM_Docs_Mobile_SuggestMode_Switch, R.drawable.ud_icon_contact_outlined, null, 24);
        }
    }

    public static final class g extends f {
        public g(boolean r100) {
            if (r100 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r101 = new com.bytedance.ee.bear.more.protocol3.d(R.string.CreationMobile_Wiki_Unclip_Option, R.drawable.ud_icon_unpin_outlined, 0, 12);
        L6:
            super("clip_top", r101);
            return;
        L5:
            r101 = new com.bytedance.ee.bear.more.protocol3.d(R.string.CreationMobile_Wiki_ClipToTop_Option, R.drawable.ud_icon_chat_pin_outlined, 0, 12);
            goto L6
        }
    }

    public static final class g0 extends f {
        public g0(boolean r100) {
            if (r100 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r101 = new com.bytedance.ee.bear.more.protocol3.d(R.string.LarkCCM_NewCM_RemoveFromPins_Menu, R.drawable.ud_icon_unpin_outlined, 0, 12);
        L6:
            super("sidebar_pin", r101);
            return;
        L5:
            r101 = new com.bytedance.ee.bear.more.protocol3.d(R.string.LarkCCM_NewCM_AddToPins_Menu, R.drawable.ud_icon_chat_pin_outlined, 0, 12);
            goto L6
        }
    }

    public static final class h extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f234865c = null;

        static {
            f234865c = new h();
        }

        public h() {
            super("copy_link", R.string.Doc_List_Copy_Link, R.drawable.ud_icon_link_copy_outlined, null, 24);
        }
    }

    public static final class h0 extends f {
        public h0(boolean r100) {
            if (r100 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r101 = new com.bytedance.ee.bear.more.protocol3.d(R.string.LarkCCM_NewCM_RemoveFromFavorites_Button, R.drawable.ud_icon_cancel_collection_outlined, R.color.icon_n1, 8);
        L6:
            super(ScoreTags.SCORE_TYPE_STAR, r101);
            return;
        L5:
            r101 = new com.bytedance.ee.bear.more.protocol3.d(R.string.Doc_Facade_AddToFavorites, R.drawable.ud_icon_collection_outlined, R.color.icon_n1, 8);
            goto L6
        }
    }

    public static final class i extends f {
        public i(String r100, int r101, String r102, int r103) {
            if ((r103 & 4) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r103 & 8) == 0) goto L8;
            int r104 = R.color.icon_n1;
        L10:
            if ((r103 & 16) == 0) goto L12;
            r102 = null;
        L12:
            Intrinsics.checkNotNullParameter(r100, "id");
            super(r100, new com.bytedance.ee.bear.more.protocol3.d(0, r101, r104, r102));
            return;
        L8:
            r104 = 0;
            goto L10
        }
    }

    public static final class i0 extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i0 f234866c = null;

        static {
            f234866c = new i0();
        }

        public i0() {
            super("transfer_apply", R.string.LarkCCM_Docs_TransferOwnerRequest_TransferOwner_Button, R.drawable.ud_icon_pa_change_outlined, null, 24);
        }
    }

    public static final class j extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final j f234867c = null;

        static {
            f234867c = new j();
        }

        public j() {
            super("delete", R.string.Doc_Facade_Delete, R.drawable.ud_icon_delete_trash_outlined, null, 24);
        }
    }

    public static final class j0 extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final j0 f234868c = null;

        static {
            f234868c = new j0();
        }

        public j0() {
            super("tts", R.string.LarkCCM_Docs_ReadAloud_Menu, R.drawable.icon_earphone_outlined, null, 24);
        }
    }

    public static final class k extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final k f234869c = null;

        static {
            f234869c = new k();
        }

        public k() {
            super("delete_shortcut", R.string.CreationMobile_Wiki_Shortcuts_DeleteShortcuts_Tooltip, R.drawable.ud_icon_delete_trash_outlined, null, 24);
        }
    }

    public static final class k0 extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final k0 f234870c = null;

        static {
            f234870c = new k0();
        }

        public k0() {
            super("ai_smart", R.string.LarkCCM_CM_AI_SmartResponse_Option, R.drawable.ud_icon_chat_ai_colorful, null, 24);
        }
    }

    public static final class l extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final l f234871c = null;

        static {
            f234871c = new l();
        }

        public l() {
            super("disassociate", R.string.LarkCCM_Docs_AppLinkDoc_Unlink_Tooltip, R.drawable.ud_icon_unbound_group_outlined, null, 24);
        }
    }

    public static final class l0 extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final l0 f234872c = null;

        static {
            f234872c = new l0();
        }

        public l0() {
        }
    }

    public static final class m extends f {
        public m(String r100) {
            super("docx_translate", R.string.Doc_More_Translate, R.drawable.ud_icon_translate_outlined, r100, 8);
        }
    }

    public static final class m0 extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final m0 f234873c = null;

        static {
            f234873c = new m0();
        }

        public m0() {
            super("wiki_make_copy", R.string.Doc_Facade_MakeCopy, R.drawable.ud_icon_copy_outlined, null, 24);
        }
    }

    public static final class n extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final n f234874c = null;

        static {
            f234874c = new n();
        }

        public n() {
            super("download", R.string.CreationMobile_ECM_SaveToLocal_option, R.drawable.ud_icon_download_outlined, null, 24);
        }
    }

    public static final class o extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final o f234875c = null;

        static {
            f234875c = new o();
        }

        public o() {
            super("drive_detail_import_as", R.string.Doc_Facade_ImportAsSheet, R.drawable.ud_icon_doc_replace_outlined, null, 24);
        }
    }

    public static final class p extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final p f234876c = null;

        static {
            f234876c = new p();
        }

        public p() {
            super("dropdown", R.string.LarkCCM_Workspace_Menu_OriginalDocumentDeleted_Tooltip, R.drawable.ud_icon_info_outlined, null, 24);
        }
    }

    public static final class q extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final q f234877c = null;

        static {
            f234877c = new q();
        }

        public q() {
            super("edition_list", R.string.LarkCCM_Docx_VersionMgmt_View_SavedVs_Button, R.drawable.ud_icon_operationrecord_outlined, null, 24);
        }
    }

    public static final class r extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final r f234878c = null;

        static {
            f234878c = new r();
        }

        public r() {
            super("expired_content", R.string.LarkCCM_CM_Verify_AskOwner_Menu, R.drawable.ud_icon_submit_feedback_outlined, null, 24);
        }
    }

    public static final class s extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final s f234879c = null;

        static {
            f234879c = new s();
        }

        public s() {
            super("freshNess", R.string.LarkCCM_CM_Verify_Validity_Title, R.drawable.ud_icon_verify_outlined, null, 24);
        }
    }

    public static final class t extends f {
        public t(int r100) {
            super("import_as", r100, R.drawable.ud_icon_doc_replace_outlined, null, 24);
        }
    }

    public static final class u extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final u f234880c = null;

        static {
            f234880c = new u();
        }

        public u() {
            super("make_copy", R.string.Doc_Facade_MakeCopy, R.drawable.ud_icon_copy_outlined, null, 24);
        }
    }

    public static final class v extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final v f234881c = null;

        static {
            f234881c = new v();
        }

        public v() {
            super("move_to", R.string.LarkCCM_Docs_MoveTo_Menu_Mob, R.drawable.ud_icon_into_item_outlined, null, 24);
        }
    }

    public static final class w extends f {
        public w(boolean r100) {
            if (r100 == false) goto L5;
            com.bytedance.ee.bear.more.protocol3.d r101 = new com.bytedance.ee.bear.more.protocol3.d(R.string.Lark_Core_AddAPPtoNaviBar_Button, R.drawable.ud_icon_more_launcher_outlined, 0, 12);
        L6:
            super("add_main_nav", r101);
            return;
        L5:
            r101 = new com.bytedance.ee.bear.more.protocol3.d(R.string.Lark_Core_RemoveAppFromNaviBar_Button, R.drawable.ud_icon_more_launcher_no_outlined, 0, 12);
            goto L6
        }
    }

    public static final class x extends f {
        public x(com.bytedance.ee.bear.more.protocol3.d r100) {
            Intrinsics.checkNotNullParameter(r100, "itemRes");
            super("my_ai", r100);
        }
    }

    public static final class y extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final y f234882c = null;

        static {
            f234882c = new y();
        }

        public y() {
            super(CommonMoreItemId.BROWSER_VIEW.getId(), R.string.LarkCCM_NewCM_OpenInBrowser_Menu_Mob, R.drawable.ud_icon_browser_mac_outlined, null, 24);
        }
    }

    public static final class z extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final z f234883c = null;

        static {
            f234883c = new z();
        }

        public z() {
            super("item_page_settings", R.string.LarkCCM_Docs_MoreMenu_PageSettings_Option_Mob, R.drawable.ud_icon_info_ccm_outlined, null, 24);
        }
    }

    public f() {
        this.f234853a = "wiki_delete";
        this.f234854b = new com.bytedance.ee.bear.more.protocol3.d(-1, -1, 0, 12);
    }

    public f(String r100, com.bytedance.ee.bear.more.protocol3.d r101) {
        this.f234853a = r100;
        this.f234854b = r101;
    }

    public f(String r100, int r101, int r102, String r103, int r104) {
        if ((r104 & 8) == 0) goto L5;
        int r105 = R.color.icon_n1;
    L7:
        if ((r104 & 16) == 0) goto L9;
        r103 = null;
    L9:
        this.f234853a = r100;
        this.f234854b = new com.bytedance.ee.bear.more.protocol3.d(r101, r102, r105, r103);
        return;
    L5:
        r105 = 0;
        goto L7
    }
}
