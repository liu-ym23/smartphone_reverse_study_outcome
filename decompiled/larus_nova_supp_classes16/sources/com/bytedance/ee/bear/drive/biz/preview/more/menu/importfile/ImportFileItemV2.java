package com.bytedance.ee.bear.drive.biz.preview.more.menu.importfile;

import android.content.Context;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.drive.report.c;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.b;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.protocol3.f;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import f85.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImportFileItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String ID_IMPORT_FILE = null;
    private static final String TAG = "DRIVE_ImportFileItemV2";
    private DrivePluginHost pluginHost;

    public int getIcon() {
        return 2131254247;
    }

    public int getIconTint() {
        return 2131102418;
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

    public void onDetach() {
    }

    static {
        ID_IMPORT_FILE = ((f) f.o.c).a;
    }

    public String getTitle() {
        a r0 = (a) this.pluginHost.c.getFileModel();
        if (r0 != null) goto L7;
        return "";
    L7:
        return getString(n55.a.b(r0));
    }

    public boolean needShowBadge() {
        b r0 = (b) org.koin.java.a.a(b.class);
        String r1 = ID_IMPORT_FILE;
        boolean r2 = r0.l(r1);
        ((b) org.koin.java.a.a(b.class)).b(r1);
        return r2;
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
        getHost().a();
        c r3 = o75.b.a().Ke();
        a.C0229a r4 = (a.C0229a) r2.a;
        ImportFileEntity r5 = new ImportFileEntity(r4.a, r4.b);
        r5.c = new AnonymousClass1(this);
        u85.a.a(r1, r5);
        if (getMoreInfo() == null) goto L12;
        oj5.c r6 = getMoreInfo();
        ((b) org.koin.java.a.a(b.class)).c(new i(getHost().getHostFragment().getArguments(), r6.getToken(), r6.getType(), false, r6.b(), "import_as", "ccm_docs_page_view", "", "", false, r3.j(), r6.H(), r6.isOwner(), r6.L()));
        return;
    }

    public boolean isEnable() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (getAdminResult(r0).a == true) goto L8;
    L10:
        return false;
    L8:
        if (r0.isSecretFileCopy() == true) goto L10;
        return true;
    }

    public boolean isVisible() {
        if (isItemInvisibleByBenefit() == false) goto L5;
        return false;
    L5:
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L8;
        return false;
    L8:
        a r2 = (a) this.pluginHost.c.getFileModel();
        if (r2 != null) goto L12;
        return false;
    L12:
        if (r0.q() == true) goto L14;
        return false;
    L14:
        if (n55.a.a(r2) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public void onDisableClick() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        FileAuthResultFrom r1 = getAdminResult(r0).b;
        if (r1 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L9;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r0.i(), r0.getToken());
        return;
    L9:
        if (r1 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L13;
        Toast.showFailureText(eu5.b.a(), 2131887246);
        return;
    }

    public String getId() {
        return ID_IMPORT_FILE;
    }

    public ImportFileItemV2(DrivePluginHost r1) {
        this.pluginHost = r1;
    }

    private gj5.c getAdminResult(oj5.c r5) {
        return ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r5.i(), r5.getToken());
    }
}
