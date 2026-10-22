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
import com.larus.nova.R;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import f85.a;
import java.util.HashMap;
import jg5.e;

/* JADX INFO: loaded from: classes16.dex */
public class RecordItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String ID_NAME = "item_recordV2";
    private static final String TAG = "RecordItemV2";
    private c mDriveReport;
    private DrivePluginHost pluginHost;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_history_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return ID_NAME;
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

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        return false;
    }

    public void onDetach() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        Context r100 = getHost().getHostFragment().getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        a r101 = (a) this.pluginHost.f224125c.getFileModel();
        if (r101 != null) goto L8;
        return;
    L8:
        a.C5868a r102 = (a.C5868a) r101.f558532a;
        if (r102 != null) goto L11;
        return;
    L11:
        oj5.c r103 = getMoreInfo();
        if (r103 != null) goto L14;
    L19:
        tt5.a.d(TAG, "record menu param error, doc info is empty");
    L20:
        getHost().a();
        return;
    L14:
        if (this.mDriveReport == null) goto L19;
        String r104 = r103.getToken();
        String r105 = r102.f558567k;
        String r106 = r102.f475872o;
        String r107 = r102.f475871n;
        Intent r108 = new Intent(r100, VersionOperationRecordV2Activity.class);
        r108.putExtra("extra_obj_token", r104);
        r108.putExtra("extra_file_name", r105);
        r108.putExtra("extra_launch_version", r106);
        r108.putExtra("extra_launch_mountPoint", r107);
        if ((r100 instanceof Application) == false) goto L18;
        r108.addFlags(268435456);
    L18:
        PassportcConvention.e(r108, LarkContext.getApplication());
        r100.startActivity(r108);
        c r109 = this.mDriveReport;
        String r110 = r103.getToken();
        String r111 = r102.f558567k;
        r109.getClass();
        HashMap<String, Object> r112 = new HashMap();
        r109.z(r112, r110, r111);
        r109.f224585d.v("click_enter_history_within", r112);
        ((b) org.koin.java.a.a(b.class)).c(new i(getHost().getHostFragment().getArguments(), r103.getToken(), r103.getType(), false, r103.b(), "history_version", "ccm_docs_history_page_view", "", "", false, this.mDriveReport.j(), r103.H(), r103.isOwner(), r103.L()));
        goto L20
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.Drive_Drive_HistoryRecordPageTitle);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.m() == false) goto L9;
        return false;
    L9:
        if (r100.c() == null) goto L16;
        if (r100.c().f234419a == null) goto L16;
        if (((b) org.koin.java.a.a(b.class)).v(r100, r100.c().f234419a, "PERCEIVE_CONTROL").booleanValue() == false) goto L16;
        return false;
    L16:
        return canEdit(r100);
    }

    public RecordItemV2(DrivePluginHost r100) {
        this.pluginHost = r100;
        this.mDriveReport = o75.b.a().Ke();
    }

    private boolean canEdit(oj5.c r100) {
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.f499003a.g() == false) goto L7;
        return ((b) org.koin.java.a.a(b.class)).t(r100.getToken(), r100, BizDomain.FileBizDomainCCM, "EDIT", r100.c().f234419a).getAllow();
    L7:
        return r100.n();
    }
}
