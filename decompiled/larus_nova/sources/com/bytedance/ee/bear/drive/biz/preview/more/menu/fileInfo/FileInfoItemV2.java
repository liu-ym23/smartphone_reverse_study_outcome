package com.bytedance.ee.bear.drive.biz.preview.more.menu.fileInfo;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.more.export.PageviewUIHolder;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.p;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import f85.a;
import java.util.HashMap;
import jg5.e;
import o75.b;
import oj5.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public class FileInfoItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String ID_FILE_STATS = "item_file_statsV2";
    private static final String TAG = "DRIVE_FileStatsItemV2";
    private DrivePluginHost pluginHost;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_info_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return ID_FILE_STATS;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.CC.$default$getMoreAction(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        return false;
    }

    public void onDetach() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.LarkCCM_Docs_DocumentDetails_Menu_Mob);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        c r100 = getMoreInfo();
        if (r100 != null) goto L5;
        return;
    L5:
        a r101 = (a) this.pluginHost.f224125c.getFileModel();
        if (r101 != null) goto L8;
        return;
    L8:
        FragmentActivity r102 = getHost().getHostFragment().getActivity();
        if (r102 != null) goto L11;
        return;
    L11:
        com.bytedance.ee.bear.drive.report.c r103 = b.a().Ke();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r100.getToken(), r100.getType(), false, r100.b(), "docs_details", "ccm_space_docs_details_view", "", "", false, r103.j(), r100.H(), r100.isOwner(), r100.L()));
        boolean r104 = DocVersion.isDocV2(r100.C());
        if (r100.c().f234419a.isFullAccess() == false) goto L14;
    L17:
        boolean r105 = true;
    L18:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.f499003a.g() == false) goto L21;
        r105 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).o(r100, "VIEW_DOC_HISTORY", r100.c().f234419a).getAllow();
    L21:
        boolean r106 = r105;
        String r110 = r100.getTitle();
        PageviewUIHolder r111 = new PageviewUIHolder();
        r111.f234509f = true;
        r111.f234504a = r102.getString(R.string.Drive_Drive_FileGeneral);
        r111.f234505b = r102.getString(R.string.Drive_Drive_FileType);
        r111.f234506c = r102.getString(R.string.Drive_Drive_FileSize);
        if (TextUtils.isEmpty(((a.C5868a) r101.f558532a).f558567k) == false) goto L24;
        String r107 = "";
    L25:
        r111.f234507d = r107;
        r111.f234508e = com.bytedance.ee.util.io.a.a(((a.C5868a) r101.f558532a).f558559c);
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).k(new p(r102, sbb.e.f541301l.f541317b, ((a.C5868a) r101.f558532a).f558557a, r104, r106, r110, r111, null, false, null, null));
        com.bytedance.ee.bear.drive.report.c.b r108 = com.bytedance.ee.bear.drive.report.c.e(r101);
        HashMap<String, Object> r109 = new HashMap();
        r109.put("action", "file_within_info_page");
        r103.z(r109, r108.f224592a, r108.f224593b);
        r103.f224585d.v("client_content_management", r109);
        JSONObject r112 = new JSONObject();
        if (((a.C5868a) r101.f558532a) != null) goto L43;
    L41:
        getHost().a();
        return;
    L43:
        r112.put(EventConstant.Key.MODULE, "drive");     // Catch: Exception -> L39
        r112.put("sub_module", "none");     // Catch: Exception -> L39
        if (TextUtils.isEmpty(((a.C5868a) r101.f558532a).f558557a) == true) goto L31;
        r112.put("file_id", du5.b.g(((a.C5868a) r101.f558532a).f558557a));     // Catch: Exception -> L39
    L32:
        r112.put("file_type", "drive");     // Catch: Exception -> L39
        if (TextUtils.isEmpty(((a.C5868a) r101.f558532a).f558567k) == true) goto L36;
        r112.put("sub_file_type", ((a.C5868a) r101.f558532a).f558567k);     // Catch: Exception -> L39
    L37:
        r112.put("container_id", "none");     // Catch: Exception -> L39
        r112.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, "none");     // Catch: Exception -> L39
        r112.put("app_form", "none");     // Catch: Exception -> L39
        r103.f224585d.i("ccm_space_docs_details_view", r112);     // Catch: Exception -> L39
        goto L41
    L36:
        r112.put("sub_file_type", "none");     // Catch: Exception -> L39
        goto L37
    L31:
        r112.put("file_id", "none");     // Catch: Exception -> L39
    L39:
        e = move-exception;
        tt5.a.d("DriveReport", "reportShowDocDetails()...error = " + e);
        goto L41
    L24:
        r107 = ((a.C5868a) r101.f558532a).f558567k.toUpperCase();
        goto L25
    L14:
        if (r100.c().f234419a.isSinglePageFullAccess() == true) goto L17;
        r105 = false;
        goto L18
    }

    public FileInfoItemV2(DrivePluginHost r100) {
        this.pluginHost = r100;
    }
}
