package com.bytedance.ee.bear.list.more.itemv2;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.drive.importfile.ImportFileEntity;
import com.bytedance.ee.bear.h;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.HashMap;
import pw4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ImportAsItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final int DEFAULT_FILE_SIZE_LIMIT = 20;
    private static final String ID_IMPORT_FILE = "import_fileV2";
    public static final int INVALID_RES = Integer.MAX_VALUE;
    private static final long NUM_1024 = 1024;
    private static final String TAG = "ImportAsItemV2";
    private Context mContext;
    private Document mDocument;
    private Long mFileSize;
    private Long mImportFileMaxSize;
    private int mImportType;
    private boolean mIsGrid;

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254247;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return ID_IMPORT_FILE;
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
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    private String getConvertType() {
        int r0 = this.mImportType;
        if (r0 != 101) goto L7;
        return DocumentType.DOC_NAME;
    L7:
        if (r0 != 102) goto L11;
        return DocumentType.SHEET_NAME;
    L11:
        if (r0 != 103) goto L14;
        return DocumentType.MINDNOTE_NAME;
    L14:
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        int r0 = ((f) org.koin.java.a.a(f.class)).getImportType(this.mDocument.a);
        this.mImportType = r0;
        Document r1 = this.mDocument;
        String[] r2 = t0.a;
        if (r1.getType() == sbb.e.l.b) goto L5;
    L4:
        int r3 = Integer.MAX_VALUE;
    L10:
        if (r3 != Integer.MAX_VALUE) goto L13;
        return "";
    L13:
        return getString(r3);
    L5:
        switch(r0) {
            case 101: goto L9;
            case 102: goto L8;
            case 103: goto L7;
            default: goto L4;
        };
    L7:
        r3 = 2131887761;
        goto L10
    L8:
        r3 = 2131887762;
        goto L10
    L9:
        r3 = 2131887760;
        goto L10
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        return !"".equals(getTitle());
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        oj5.c r1 = getMoreInfo();
        Document r2 = this.mDocument;
        boolean r3 = this.mIsGrid;
        String[] r4 = t0.a;
        ImportFileEntity r5 = new ImportFileEntity(r2.d, r2.a);
        HashMap r6 = new HashMap();
        r6.put("module", "favorites");
        r6.put("is_grid", String.valueOf(r3));
        r5.c = r6;
        ((h) org.koin.java.a.a(h.class)).m0(r5);
        if (r1 == null) goto L9;
        com.bytedance.ee.bear.more.b r7 = (com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class);
        Bundle r8 = getHost().getHostFragment().getArguments();
        String r9 = r1.getToken();
        int r10 = r1.getType();
        String r11 = r1.b();
        String r12 = getConvertType();
        if (r1.getType() != sbb.e.n.b) goto L7;
        boolean r13 = true;
    L8:
        r7.c(new i(r8, r9, r10, false, r11, "convert_to_online", "ccm_docs_page_view", "", r12, r13, false, r1.H(), r1.isOwner(), r1.L()));
        goto L9
    L7:
        r13 = false;
    L9:
        getHost().a();
    }

    private boolean havePermission() {
        if ((getMoreInfo() instanceof oj5.a) == false) goto L12;
        oj5.a r0 = (oj5.a) getMoreInfo();
        if (r0.p == false) goto L9;
        if (r0.q == false) goto L9;
        return false;
    L9:
        if (r0.p() == true) goto L15;
        return false;
    L15:
        return true;
    L12:
        return true;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        if (havePermission() == true) goto L7;
        return this.mContext.getString(2131887763);
    L7:
        return xo5.a.c(eu5.b.a, 2131889340, SheetInputData.InputData.FormatType.NUMBER, String.valueOf(com.bytedance.ee.bear.appsetting.c.a.a.d("drive_convert_file_size_limit", 20)));
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        if (havePermission() == true) goto L6;
        return false;
    L6:
        if ((getMoreInfo() instanceof oj5.a) == false) goto L11;
        ((oj5.a) getMoreInfo()).getClass();
        Long r0 = 0L;
        this.mFileSize = r0;
        if (r0.longValue() != 0) goto L11;
        this.mFileSize = Long.MAX_VALUE;
    L11:
        if (this.mFileSize.longValue() >= this.mImportFileMaxSize.longValue()) goto L14;
        return true;
    L14:
        return false;
    }

    public ImportAsItemV2(Context r3, Document r4, boolean r5) {
        this.mContext = r3;
        this.mDocument = r4;
        this.mIsGrid = r5;
        this.mFileSize = Long.MAX_VALUE;
        this.mImportFileMaxSize = Long.valueOf((((long) ((Integer) com.bytedance.ee.bear.appsetting.c.a.a.d("drive_convert_file_size_limit", 20)).intValue()) * NUM_1024) * NUM_1024);
    }
}
