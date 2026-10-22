package com.bytedance.ee.bear.drive.biz.preview.more.menu.fileInfo;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.more.export.PageviewUIHolder;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.p;
import f85.a;
import java.util.HashMap;
import jg5.e;
import o75.b;
import oj5.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileInfoItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String ID_FILE_STATS = "item_file_statsV2";
    private static final String TAG = "DRIVE_FileStatsItemV2";
    private DrivePluginHost pluginHost;

    public int getIcon() {
        return 2131254921;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return ID_FILE_STATS;
    }

    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.-CC.$default$getMoreAction(this);
    }

    public String getStateTips() {
        return "";
    }

    public String getUnableTips() {
        return "";
    }

    public boolean isEnable() {
        return true;
    }

    public boolean isVisible() {
        return true;
    }

    public boolean needShowBadge() {
        return false;
    }

    public void onDetach() {
    }

    public void onDisableClick() {
    }

    public String getTitle() {
        return getString(2131889043);
    }

    public void onClick() {
        c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        a r2 = (a) this.pluginHost.c.getFileModel();
        if (r2 != null) goto L8;
        return;
    L8:
        FragmentActivity r5 = getHost().getHostFragment().getActivity();
        if (r5 != null) goto L11;
        return;
    L11:
        com.bytedance.ee.bear.drive.report.c r3 = b.a().Ke();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r0.getToken(), r0.getType(), false, r0.b(), "docs_details", "ccm_space_docs_details_view", "", "", false, r3.j(), r0.H(), r0.isOwner(), r0.L()));
        boolean r8 = DocVersion.isDocV2(r0.C());
        if (r0.c().a.isFullAccess() == false) goto L14;
    L17:
        boolean r4 = true;
    L18:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L21;
        r4 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).o(r0, "VIEW_DOC_HISTORY", r0.c().a).getAllow();
    L21:
        boolean r9 = r4;
        String r10 = r0.getTitle();
        PageviewUIHolder r11 = new PageviewUIHolder();
        r11.f = true;
        r11.a = r5.getString(2131888389);
        r11.b = r5.getString(2131888397);
        r11.c = r5.getString(2131888396);
        if (TextUtils.isEmpty(((a.C0229a) r2.a).k) == false) goto L24;
        String r1 = "";
    L25:
        r11.d = r1;
        r11.e = com.bytedance.ee.util.io.a.a(((a.C0229a) r2.a).c);
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).k(new p(r5, sbb.e.l.b, ((a.C0229a) r2.a).a, r8, r9, r10, r11, null, false, null, null));
        com.bytedance.ee.bear.drive.report.c.b r6 = com.bytedance.ee.bear.drive.report.c.e(r2);
        HashMap<String, Object> r7 = new HashMap();
        r7.put(JSEventListener.ACTION, "file_within_info_page");
        r3.z(r7, r6.a, r6.b);
        r3.d.v("client_content_management", r7);
        JSONObject r12 = new JSONObject();
        if (((a.C0229a) r2.a) != null) goto L43;
    L41:
        getHost().a();
        return;
    L43:
        r12.put("module", "drive");     // Catch: Exception -> L39
        r12.put("sub_module", "none");     // Catch: Exception -> L39
        if (TextUtils.isEmpty(((a.C0229a) r2.a).a) == true) goto L31;
        r12.put("file_id", du5.b.g(((a.C0229a) r2.a).a));     // Catch: Exception -> L39
    L32:
        r12.put("file_type", "drive");     // Catch: Exception -> L39
        if (TextUtils.isEmpty(((a.C0229a) r2.a).k) == true) goto L36;
        r12.put("sub_file_type", ((a.C0229a) r2.a).k);     // Catch: Exception -> L39
    L37:
        r12.put("container_id", "none");     // Catch: Exception -> L39
        r12.put("container_type", "none");     // Catch: Exception -> L39
        r12.put("app_form", "none");     // Catch: Exception -> L39
        r3.d.i("ccm_space_docs_details_view", r12);     // Catch: Exception -> L39
        goto L41
    L36:
        r12.put("sub_file_type", "none");     // Catch: Exception -> L39
        goto L37
    L31:
        r12.put("file_id", "none");     // Catch: Exception -> L39
    L39:
        e = move-exception;
        tt5.a.d("DriveReport", "reportShowDocDetails()...error = " + e);
        goto L41
    L24:
        r1 = ((a.C0229a) r2.a).k.toUpperCase();
        goto L25
    L14:
        if (r0.c().a.isSinglePageFullAccess() == true) goto L17;
        r4 = false;
        goto L18
    }

    public FileInfoItemV2(DrivePluginHost r1) {
        this.pluginHost = r1;
    }
}
