package com.bytedance.ee.bear.doc.cover.selectcover;

import com.amap.api.services.cloud.CloudSearch;
import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalCoverSelectionFragment;
import com.bytedance.ee.bear.doc.cover.selectcover.official.OfficialCoverSelectionFragment;
import com.larus.nova.R;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum SubSelectCoverPanel extends Enum<SubSelectCoverPanel> {
    public static final SubSelectCoverPanel Local = null;
    public static final SubSelectCoverPanel Official = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubSelectCoverPanel[] f217813a = null;
    public String fragment;
    public int position;
    public int titleResId;

    static {
        SubSelectCoverPanel r100 = new SubSelectCoverPanel("Official", 0, 0, R.string.CreationMobile_Docs_DocCover_OfficialGallery_Tab, OfficialCoverSelectionFragment.class.getName());
        Official = r100;
        SubSelectCoverPanel r101 = new SubSelectCoverPanel(CloudSearch.SearchBound.LOCAL_SHAPE, 1, 1, R.string.CreationMobile_Docs_DocCover_LocalUpload_Tab, LocalCoverSelectionFragment.class.getName());
        Local = r101;
        f217813a = new SubSelectCoverPanel[]{r100, r101};
    }

    public static SubSelectCoverPanel[] values() {
        return (SubSelectCoverPanel[]) f217813a.clone();
    }

    public static SubSelectCoverPanel valueOf(String r100) {
        return (SubSelectCoverPanel) a.a(SubSelectCoverPanel.class, r100);
    }

    public SubSelectCoverPanel(String r100, int r101, int r102, int r103, String r104) {
        super(r100, r101);
        this.titleResId = r103;
        this.position = r102;
        this.fragment = r104;
    }
}
