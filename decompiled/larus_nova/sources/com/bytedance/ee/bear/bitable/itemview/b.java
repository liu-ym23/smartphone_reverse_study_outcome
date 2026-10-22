package com.bytedance.ee.bear.bitable.itemview;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.model.LinkTableDataModelManager;
import com.bytedance.ee.bear.bitable.celleditor.model.BitableEditorViewModel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.k;
import com.bytedance.ee.bear.bitable.itemview.cell.link.LinkTableCellValue;
import com.bytedance.ee.bear.bitable.itemview.record.menu.h;
import com.bytedance.ee.bear.bitable.itemview.recordpages.ItemViewRecordPagesData;
import com.bytedance.ee.bear.bitable.itemview.stack.ItemViewStackContainer;
import com.bytedance.ee.bear.bitable.itemview.util.ItemViewTracker;
import com.bytedance.ee.bear.bitable.itemview.util.j;
import com.bytedance.ee.bear.bitable.share.ShareModel;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.bear.document.DocViewModel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes15.dex */
public interface b {
    boolean Af();

    j BB();

    void BR(LinkTableCellValue r100);

    void EB(k r100);

    void ES(k r100);

    DocViewModel H0();

    ItemViewStackContainer H60();

    BitableEditorViewModel HV();

    ItemViewRecordPagesData Kg();

    ItemViewTracker R0();

    void R80();

    h Sm();

    void Tz(String r100, String r101);

    void U7(ShareModel r100, boolean r101);

    boolean Ye(String r100);

    void aG();

    void bF(com.bytedance.ee.bear.bitable.itemview.util.a r100, SpaceThirdPartyOpenEntity r101, ArrayList<SpaceThirdPartyOpenEntity> r102, int r103);

    void createNewDiscuss(String r100, String r101, String r102);

    LinkTableDataModelManager fx();

    LiveData<Boolean> getCommentAble();

    String getDocEncryptId();

    Fragment getFragment();

    String getObjToken();

    PluginHost getPluginHost();

    ir4.h he();

    mr4.a o();

    boolean onBackPressed();

    void openDiscussDetailsPanel(String r100, String r101, String r102, String r103, int r104);

    FragmentActivity p0();

    BitableAnalytic q0();

    void tu(ItemViewRecordPagesData r100, String r101);
}
