package com.bytedance.ee.bear.document.export.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel;
import com.bytedance.ee.bear.document.export.viewmodel.SlidesExportViewModel;
import i15.g;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rw4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/export/dialog/SlidesExportDialogFragment;", "Lcom/bytedance/ee/bear/document/export/dialog/BaseExportDialogFragment;", "Lcom/bytedance/ee/bear/document/export/viewmodel/SlidesExportViewModel;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "onCreateExportItem", "", "inflater", "Landroid/view/LayoutInflater;", "exportContainer", "Landroid/view/ViewGroup;", "onCreateViewModel", "getPsdaToken", "", "onClick", "v", "Landroid/view/View;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesExportDialogFragment extends BaseExportDialogFragment<SlidesExportViewModel> implements View.OnClickListener {
    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final String ba0() {
        return "LARK-PSDA-ccm_docs_slides_shareexport";
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final BaseExportViewModel ea0() {
        return (SlidesExportViewModel) ViewModelProviders.of(requireActivity()).get(SlidesExportViewModel.class);
    }

    public SlidesExportDialogFragment() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        int r4 = r3.getId();
        if (r4 != 2131371965) goto L6;
        aa0(n.h, null);
        return;
    L6:
        if (r4 != 2131371963) goto L10;
        aa0(n.d, null);
        return;
    }

    @Override // com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment
    public final void da0(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "exportContainer");
        View r5 = r3.inflate(2131560122, r4);
        ((ImageView) r5.findViewById(2131371966)).setImageResource(g.a(2131254599));
        ((ImageView) r5.findViewById(2131371964)).setImageResource(g.a(2131254594));
        TextView r6 = (TextView) r5.findViewById(2131371967);
        n r0 = n.c;
        r6.setText("pptx".toUpperCase(Locale.ROOT));
        r5.findViewById(2131371965).setOnClickListener(this);
        r5.findViewById(2131371963).setOnClickListener(this);
    }
}
