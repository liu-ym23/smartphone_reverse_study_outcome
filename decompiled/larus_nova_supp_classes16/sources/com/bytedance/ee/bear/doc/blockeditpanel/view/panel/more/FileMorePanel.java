package com.bytedance.ee.bear.doc.blockeditpanel.view.panel.more;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.blockmenu.BlockMenuPanel;
import com.bytedance.ee.bear.g;
import com.bytedance.ee.bear.h;
import hy4.b;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileMorePanel extends BlockMenuPanel {
    public static final /* synthetic */ int A = 0;
    public final CompositeDisposable z;

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.blockmenu.BlockMenuPanel, com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel
    public int getPanelHeight() {
        return 0;
    }

    public FileMorePanel(Context r2) {
        this(r2, null);
    }

    public FileMorePanel(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // com.bytedance.ee.bear.doc.blockeditpanel.view.panel.blockmenu.BlockMenuPanel
    public final void d(BlockEditPanelMenusModel.BlockEditPanel r8, BlockEditPanelMenusModel.BlockEditPanelMenuItem r9) {
        String r10 = r9.getId();
        FragmentActivity r0 = getContext();
        BlockEditPanelMenusModel.Extra r11 = r8.getExtra();
        if (r11 != null) goto L6;
        a.d("FileMorePanel", "handleItemClick err! params extra null");
        return;
    L6:
        Long r2 = r11.getFileSize();
        String r3 = r11.getFileName();
        SpaceThirdPartyOpenEntity r4 = new SpaceThirdPartyOpenEntity("44", r11.getBlockToken(), r3);
        r4.setMountPoint("docx_file");
        r4.setFileName(r3);
        r4.setDownloadFrom("from_docs_attachment_download");
        r4.setMimeType(r11.getMimeType());
        r4.setHostDocumentInfo(this.e.getHostDocumentInfo());
        r10.getClass();
        byte r5 = -1;
        switch(r10.hashCode()) {
            case -1772604468: goto L18;
            case 159770148: goto L14;
            case 1610988662: goto L10;
            default: goto L21;
        };
    L21:
        switch(r5) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            default: goto L22;
        };
    L22:
        a.h("FileMorePanel", "setOnClickListener error item id: ".concat(r10));
        return;
    L23:
        this.z.add(((h) org.koin.java.a.a(h.class)).hc(r0, r4, r2).subscribe(new hy4.a(), new b()));
        return;
    L24:
        ((g) org.koin.java.a.a(g.class)).a(r0, r4);
        return;
    L25:
        ((h) org.koin.java.a.a(h.class)).g4(r0, r4, r2);
        return;
    L10:
        if (r10.equals("fileSaveToDrive") == false) goto L21;
        r5 = 2;
        goto L21
    L14:
        if (r10.equals("fileDownload") == false) goto L21;
        r5 = 1;
        goto L21
    L18:
        if (r10.equals("fileOpenWith") == false) goto L21;
        r5 = 0;
        goto L21
    }

    public FileMorePanel(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.z = new CompositeDisposable();
        ((ArrayList) this.t).add("fileSaveToDrive");
        ((ArrayList) this.t).add("fileOpenWith");
        ((ArrayList) this.t).add("fileDownload");
    }
}
