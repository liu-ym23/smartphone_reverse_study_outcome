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
import com.larus.nova.R;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import f85.a;

/* JADX INFO: loaded from: classes16.dex */
public class ImportFileItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String ID_IMPORT_FILE = null;
    private static final String TAG = "DRIVE_ImportFileItemV2";
    private DrivePluginHost pluginHost;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_doc_replace_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
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

    public void onDetach() {
    }

    static {
        ID_IMPORT_FILE = f.o.f234875c.f234853a;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        a r100 = (a) this.pluginHost.f224125c.getFileModel();
        if (r100 != null) goto L7;
        return "";
    L7:
        return getString(n55.a.b(r100));
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        b r100 = (b) org.koin.java.a.a(b.class);
        String r101 = ID_IMPORT_FILE;
        boolean r102 = r100.l(r101);
        ((b) org.koin.java.a.a(b.class)).b(r101);
        return r102;
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
        getHost().a();
        c r102 = o75.b.a().Ke();
        a.C5868a r103 = (a.C5868a) r101.f558532a;
        ImportFileEntity r104 = new ImportFileEntity(r103.f558557a, r103.f558558b);
        r104.f224403c = new AnonymousClass1(this);
        u85.a.a(r100, r104);
        if (getMoreInfo() == null) goto L12;
        oj5.c r105 = getMoreInfo();
        ((b) org.koin.java.a.a(b.class)).c(new i(getHost().getHostFragment().getArguments(), r105.getToken(), r105.getType(), false, r105.b(), "import_as", "ccm_docs_page_view", "", "", false, r102.j(), r105.H(), r105.isOwner(), r105.L()));
        return;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L6;
        return true;
    L6:
        if (getAdminResult(r100).f481503a == true) goto L8;
    L10:
        return false;
    L8:
        if (r100.isSecretFileCopy() == true) goto L10;
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        if (isItemInvisibleByBenefit() == false) goto L5;
        return false;
    L5:
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L8;
        return false;
    L8:
        a r101 = (a) this.pluginHost.f224125c.getFileModel();
        if (r101 != null) goto L12;
        return false;
    L12:
        if (r100.q() == true) goto L14;
        return false;
    L14:
        if (n55.a.a(r101) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L5;
        return;
    L5:
        FileAuthResultFrom r101 = getAdminResult(r100).f481504b;
        if (r101 != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L9;
        ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r100.i(), r100.getToken());
        return;
    L9:
        if (r101 != FileAuthResultFrom.COME_FROM_AUTHZ) goto L13;
        Toast.showFailureText(eu5.b.a(), R.string.CreationMobile_ECM_AdminDisableToast);
        return;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return ID_IMPORT_FILE;
    }

    public ImportFileItemV2(DrivePluginHost r100) {
        this.pluginHost = r100;
    }

    private gj5.c getAdminResult(oj5.c r100) {
        return ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_CREATE_COPY", FileBizDomain.FileBizDomainCCM, r100.i(), r100.getToken());
    }
}
