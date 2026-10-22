package sbb;

import com.amap.api.col.s.ce;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberOrientationPage$Param$From;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f541319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f541320b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f541321c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f541322d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f541323e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, String> f541324f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap<String, String> f541325g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap<String, String> f541326h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashMap<String, String> f541327i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap<String, String> f541328j = null;

    static {
        f541319a = new String[]{"/space/", "/drive/", "/blank/", "/record/", "/space/blank/", "/drive/blank/", "/(doc|docs|sheet|sheets|mindnote|mindnotes|slide|slides|file|bitable|base|folder|wiki|isv|docx)/", "/app/upgrade"};
        f541320b = new String[]{"docs.bytedance.net", "docs-staging.bytedance.net", "bear-test.bytedance.net", "feishu.cn", "feishu.net", "feishu-staging.cn", "feishu-boe.cn", "feishu-pre.cn", "larksuite.com", "larksuite-staging.com", "larksuite-pre.com", "larkoffice.com", "larkoffice-pre.com"};
        f541321c = new String[]{"/share/base/record/[^/]+/?$", "/share/base/add/[^/]+/?$"};
        f541322d = new String[]{"internal-api.feishu.cn", "internal-api-space.feishu.cn", "internal-api-space-hl.feishu.cn", "internal-api-space-lf.feishu.cn", "internal-api.larksuite.com", "internal-api-space.larksuite.com", "internal-api-space-hl.larksuite.com", "internal-api-space-lf.larksuite.com"};
        f541323e = new String[]{"/gpe/operation/quota", "/gpe/operation/no_permission", "/ccm/profile_main", "/ccm/docs/share", "/ccm/docs/entity_word"};
        HashMap r100 = new HashMap();
        f541324f = r100;
        new String[]{"doc", "docs"};
        HashMap<String, String> r101 = new HashMap();
        f541325g = r101;
        HashMap<String, String> r102 = new HashMap();
        f541326h = r102;
        HashMap<String, String> r103 = new HashMap();
        f541327i = r103;
        HashMap<String, String> r104 = new HashMap();
        f541328j = r104;
        r101.put("/app/upgrade/", InvRouter$InviteMemberOrientationPage$Param$From.UPGRADE);
        r101.put("/folder/", DocumentType.FOLDER_NAME);
        r101.put("/help/", "help");
        r101.put("/help/about-best/", "help");
        r101.put("/help/doc/", "help");
        r101.put("/home/", "recent");
        r101.put("/home/recents/", "recent");
        r101.put("/home/share/files/", "share");
        r101.put("/home/star/", ScoreTags.SCORE_TYPE_STAR);
        r101.put("/native/newyearsurvey/", "newyear_survey");
        r101.put("/share/folders/", "share_root");
        r101.put("/shared/folders/", "share_root");
        r101.put("/space/", "recent");
        r101.put("/space/app/upgrade/", InvRouter$InviteMemberOrientationPage$Param$From.UPGRADE);
        r101.put("/space/folder/", DocumentType.FOLDER_NAME);
        r101.put("/space/help/", "help");
        r101.put("/space/help/about-best/", "help");
        r101.put("/space/help/doc/", "help");
        r101.put("/space/home/", "recent");
        r101.put("/space/home/recents/", "recent");
        r101.put("/space/home/share/files/", "share");
        r101.put("/space/home/star/", ScoreTags.SCORE_TYPE_STAR);
        r101.put("/space/native/newyearsurvey/", "newyear_survey");
        r101.put("/space/share/folders/", "share_root");
        r101.put("/space/shared/folders/", "share_root");
        r101.put("/space/wiki/", "wiki_home");
        r101.put("/wiki/", "wiki_home");
        r101.put("/drive/home/", "recent");
        r101.put("/drive/home/recents/", "recent");
        r101.put("/drive/home/share/files/", "share");
        r101.put("/drive/home/star/", ScoreTags.SCORE_TYPE_STAR);
        r101.put("/drive/share/folders/", "share_root");
        r101.put("/drive/shared/folders/", "share_root");
        r101.put("/drive/help/doc/", "help");
        r101.put("/drive/help/", "help");
        r101.put("/drive/app/upgrade/", InvRouter$InviteMemberOrientationPage$Param$From.UPGRADE);
        r101.put("/drive/", "recent");
        r101.put("/drive/template_center/", "template_center");
        r101.put("/drive/template-center/", "template_center");
        r101.put("/space/api/obj_template/create_i18n_obj/", "template_create");
        r101.put("/drive/folder/", DocumentType.FOLDER_NAME);
        r101.put("/drive/sharedfolder/", "history_shared_folder");
        r101.put("/space/bitable/", "bitable_home");
        r101.put("/bitable/", "bitable_home");
        r102.put("blank", "/blank/");
        r102.put(InvRouter$InviteMemberOrientationPage$Param$From.UPGRADE, "/space/app/upgrade");
        r102.put("default", "/${type}/${token}");
        r102.put(DocumentType.FOLDER_NAME, "/drive/${type}/${token}");
        r102.put("phoenix", "/workspace/${type}/${token}");
        r100.put(ce.f26396k, "doc");
        r100.put(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, DocumentType.SHEET_NAME);
        r100.put("b", DocumentType.BITABLE_NAME);
        r100.put("c", DocumentType.MINDNOTE_NAME);
        r100.put("d", "slide");
        r100.put("e", "file");
        r103.put("doc", "docs");
        r103.put(DocumentType.DOCX_NAME, DocumentType.DOCX_NAME);
        r103.put(DocumentType.SHEET_NAME, "sheets");
        r103.put("slides", "slides");
        r103.put(DocumentType.MINDNOTE_NAME, "mindnotes");
        r103.put(DocumentType.BITABLE_NAME, "base");
        r103.put("file", "file");
        r103.put(DocumentType.FOLDER_NAME, DocumentType.FOLDER_NAME);
        r103.put("wiki", "wiki");
        r104.put("base", DocumentType.BITABLE_NAME);
        r104.put(DocumentType.BITABLE_NAME, DocumentType.BITABLE_NAME);
        r104.put("doc", "doc");
        r104.put("docs", "doc");
        r104.put(DocumentType.DOCX_NAME, DocumentType.DOCX_NAME);
        r104.put("file", "file");
        r104.put(DocumentType.FOLDER_NAME, DocumentType.FOLDER_NAME);
        r104.put(DocumentType.MINDNOTE_NAME, DocumentType.MINDNOTE_NAME);
        r104.put("mindnotes", DocumentType.MINDNOTE_NAME);
        r104.put(DocumentType.SHEET_NAME, DocumentType.SHEET_NAME);
        r104.put("sheets", DocumentType.SHEET_NAME);
        r104.put("slide", "slides");
        r104.put("slides", "slides");
        r104.put("wiki", "wiki");
        r104.put("isv", "isv");
    }
}
