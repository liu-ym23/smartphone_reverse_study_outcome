package com.bytedance.ee.bear.slides.toolbar;

import android.os.Bundle;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.edit_toolbar.ToolbarV2PanelViewModel;
import com.bytedance.ee.bear.document.model.toolbar.DocToolbarV2;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.AbsSubToolbarFragment;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/slides/toolbar/SlidesSubToolbarFragment;", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/AbsSubToolbarFragment;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getToolbarV2PanelViewModel", "Lcom/bytedance/ee/bear/edit/toolbar/toolbar2/BaseToolbarV2PanelViewModel;", "Lcom/bytedance/ee/bear/document/model/toolbar/DocToolbarV2;", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesSubToolbarFragment extends AbsSubToolbarFragment {
    public final BaseToolbarV2PanelViewModel<DocToolbarV2> Z90() {
        return q.a(this, ToolbarV2PanelViewModel.class);
    }

    public SlidesSubToolbarFragment() {
    }

    public final void onCreate(Bundle r1) {
        super/*com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment*/.onCreate(r1);
    }
}
