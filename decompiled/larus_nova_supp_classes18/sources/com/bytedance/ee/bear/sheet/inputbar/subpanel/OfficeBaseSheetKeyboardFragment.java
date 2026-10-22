package com.bytedance.ee.bear.sheet.inputbar.subpanel;

import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.inputbar.OfficeSheetEditViewModel;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import db5.g;
import io.reactivex.Single;
import java.util.List;
import xm5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class OfficeBaseSheetKeyboardFragment extends BaseFragment {
    public OfficeSheetEditViewModel e;

    public abstract int W90();

    public final MutableLiveData<Editable> U90() {
        return this.e.getEditable();
    }

    public final boolean V90() {
        if (this.e.isExpand() != null) goto L5;
        return false;
    L5:
        return Boolean.TRUE.equals(this.e.isExpand().getValue());
    }

    public final boolean onBackPressed() {
        this.e.setActive(false);
        tt5.a.h("BaseSheetKeyboardFragment", "onBackPressed mSheetEditViewModel setActive false");
        return true;
    }

    static {
    }

    public OfficeBaseSheetKeyboardFragment() {
    }

    public final Single<List<BaseSegment>> X90(Editable r2) {
        return Single.just(new g((SpannableStringBuilder) r2)).map(new f());
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.e = q.a(this, OfficeSheetEditViewModel.class);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(W90(), r3, false);
    }

    public final void Y90(int r13, List<BaseSegment> r14, String r15, String r16, String r17) {
        wm5.a r2 = this.e.getEditDelegate();
        if (r2 == null) goto L29;
        Editable r1 = (Editable) U90().getValue();
        boolean r3 = true;
        if (r1 == null) goto L12;
        String r5 = r1.toString();
        if (r5 == null) goto L12;
        if (r5.trim().startsWith("=") == false) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L27;
        int r7 = Selection.getSelectionStart(r1);
        int r8 = Selection.getSelectionEnd(r1);
        int r9 = BaseInputConnection.getComposingSpanStart(r1);
        int r10 = BaseInputConnection.getComposingSpanEnd(r1);
        if (r9 < 0) goto L19;
        if (r10 < 0) goto L19;
        int[] r11 = {r9, r10};
    L20:
        Integer r12 = Integer.valueOf(Math.max(0, Math.min(r7, r1.length())));
        Integer r4 = Integer.valueOf(Math.max(0, Math.min(r8, r1.length())));
        if (r11 != null) goto L23;
    L25:
        r3 = false;
    L26:
        r2.updateSheetEditWithFormulaMeta(r13, r14, r15, r16, r17, r12, r4, "keystroke", Boolean.valueOf(r3));
        return;
    L23:
        if (r11[1] <= r11[0]) goto L25;
    L19:
        r11 = null;
        goto L20
    L27:
        r2.updateSheetEdit(r13, r14, r15, r16, r17);
        return;
    L12:
        r6 = false;
        goto L13
    }
}
