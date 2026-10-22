package com.bytedance.ee.bear.sheet.exportimage.exportshare;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.export.dialog.BaseExportDialogFragment;
import com.bytedance.ee.bear.document.export.viewmodel.BaseExportViewModel;
import com.bytedance.ee.util.ui.n;
import tm5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ExportShareDialogFragment extends BaseExportDialogFragment<ExportShareViewModel> implements View.OnClickListener {
    public static final /* synthetic */ int p = 0;

    public final String ba0() {
        return "LARK-PSDA-ccm_docs_sheetcard_shareexport";
    }

    public final int ca0() {
        return 2131887395;
    }

    public final BaseExportViewModel ea0() {
        return q.a(this, ExportShareViewModel.class);
    }

    public final void onCancel() {
        fa0();
        ((ExportShareViewModel) ((BaseExportDialogFragment) this).h).onCancel();
    }

    public ExportShareDialogFragment() {
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onCancel(DialogInterface r1) {
        super.onCancel(r1);
        onCancel();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Object r3 = r2.getTag();
        if ((r3 instanceof String) == false) goto L6;
        ((ExportShareViewModel) ((BaseExportDialogFragment) this).h).onClickItem((String) r3);
        return;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void da0(LayoutInflater r6, ViewGroup r7) {
        final LinearLayout r8 = new LinearLayout(getContext());
        r8.setOrientation(0);
        ViewGroup.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        r8.setPadding(n.d(4), n.d(24), 0, n.d(4));
        r7.addView(r8, r1);
        ((ExportShareViewModel) ((BaseExportDialogFragment) this).h).getShareItems().observe(this, new a(this, r8));
    }

    public final View ja0(String r4, int r5, int r6) {
        View r0 = LayoutInflater.from(getContext()).inflate(2131564548, null);
        AppCompatImageView r1 = r0.findViewById(2131371956);
        r1.setImageResource(r5);
        r1.setTag(r4);
        r1.setOnClickListener(this);
        TextView r7 = (TextView) r0.findViewById(2131371968);
        r7.setText(r6);
        r7.setTag(r4);
        r7.setOnClickListener(this);
        return r0;
    }
}
