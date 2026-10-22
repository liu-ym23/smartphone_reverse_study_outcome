package com.bytedance.ee.bear.doc.cover.selectcover;

import com.bytedance.ee.bear.doc.cover.selectcover.local.LocalCoverSelectionFragment;
import com.bytedance.ee.bear.doc.cover.selectcover.official.OfficialCoverSelectionFragment;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum SubSelectCoverPanel extends Enum<SubSelectCoverPanel> {
    public static final SubSelectCoverPanel Local = null;
    public static final SubSelectCoverPanel Official = null;
    public static final /* synthetic */ SubSelectCoverPanel[] a = null;
    public String fragment;
    public int position;
    public int titleResId;

    static {
        SubSelectCoverPanel r6 = new SubSelectCoverPanel("Official", 0, 0, 2131887176, OfficialCoverSelectionFragment.class.getName());
        Official = r6;
        SubSelectCoverPanel r0 = new SubSelectCoverPanel("Local", 1, 1, 2131887174, LocalCoverSelectionFragment.class.getName());
        Local = r0;
        a = new SubSelectCoverPanel[]{r6, r0};
    }

    public static SubSelectCoverPanel[] values() {
        return (SubSelectCoverPanel[]) a.clone();
    }

    public static SubSelectCoverPanel valueOf(String r1) {
        return (SubSelectCoverPanel) a.a(SubSelectCoverPanel.class, r1);
    }

    public SubSelectCoverPanel(String r1, int r2, int r3, int r4, String r5) {
        super(r1, r2);
        this.titleResId = r4;
        this.position = r3;
        this.fragment = r5;
    }
}
