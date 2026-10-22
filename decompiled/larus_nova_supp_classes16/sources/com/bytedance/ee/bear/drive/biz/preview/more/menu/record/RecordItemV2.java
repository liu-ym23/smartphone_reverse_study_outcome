package com.bytedance.ee.bear.drive.biz.preview.more.menu.record;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.bytedance.ee.bear.drive.biz.versions.VersionOperationRecordV2Activity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.report.c;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.more.b;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import f85.a;
import java.util.HashMap;
import jg5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RecordItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String ID_NAME = "item_recordV2";
    private static final String TAG = "RecordItemV2";
    private c mDriveReport;
    private DrivePluginHost pluginHost;

    public int getIcon() {
        return 2131254879;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return ID_NAME;
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

    public boolean needShowBadge() {
        return false;
    }

    public void onDetach() {
    }

    public void onDisableClick() {
    }

    public void onClick() {
        Context r1 = getHost().getHostFragment().getContext();
        if (r1 != null) goto L5;
        return;
    L5:
        a r2 = (a) this.pluginHost.c.getFileModel();
        if (r2 != null) goto L8;
        return;
    L8:
        a.C0229a r3 = (a.C0229a) r2.a;
        if (r3 != null) goto L11;
        return;
    L11:
        oj5.c r4 = getMoreInfo();
        if (r4 != null) goto L14;
    L19:
        tt5.a.d(TAG, "record menu param error, doc info is empty");
    L20:
        getHost().a();
        return;
    L14:
        if (this.mDriveReport == null) goto L19;
        String r5 = r4.getToken();
        String r6 = r3.k;
        String r7 = r3.o;
        String r8 = r3.n;
        Intent r9 = new Intent(r1, VersionOperationRecordV2Activity.class);
        r9.putExtra("extra_obj_token", r5);
        r9.putExtra("extra_file_name", r6);
        r9.putExtra("extra_launch_version", r7);
        r9.putExtra("extra_launch_mountPoint", r8);
        if ((r1 instanceof Application) == false) goto L18;
        r9.addFlags(268435456);
    L18:
        PassportcConvention.e(r9, LarkContext.getApplication());
        r1.startActivity(r9);
        c r10 = this.mDriveReport;
        String r11 = r4.getToken();
        String r12 = r3.k;
        r10.getClass();
        HashMap<String, Object> r13 = new HashMap();
        r10.z(r13, r11, r12);
        r10.d.v("click_enter_history_within", r13);
        ((b) org.koin.java.a.a(b.class)).c(new i(getHost().getHostFragment().getArguments(), r4.getToken(), r4.getType(), false, r4.b(), "history_version", "ccm_docs_history_page_view", "", "", false, this.mDriveReport.j(), r4.H(), r4.isOwner(), r4.L()));
        goto L20
    }

    public String getTitle() {
        return getString(2131888402);
    }

    public boolean isVisible() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.m() == false) goto L9;
        return false;
    L9:
        if (r0.c() == null) goto L16;
        if (r0.c().a == null) goto L16;
        if (((b) org.koin.java.a.a(b.class)).v(r0, r0.c().a, "PERCEIVE_CONTROL").booleanValue() == false) goto L16;
        return false;
    L16:
        return canEdit(r0);
    }

    public RecordItemV2(DrivePluginHost r1) {
        this.pluginHost = r1;
        this.mDriveReport = o75.b.a().Ke();
    }

    private boolean canEdit(oj5.c r8) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.g() == false) goto L7;
        return ((b) org.koin.java.a.a(b.class)).t(r8.getToken(), r8, BizDomain.FileBizDomainCCM, "EDIT", r8.c().a).getAllow();
    L7:
        return r8.n();
    }
}
