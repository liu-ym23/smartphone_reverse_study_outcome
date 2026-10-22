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
import com.huawei.hms.framework.common.ContainerUtils;
import db5.g;
import io.reactivex.Single;
import java.util.List;
import xm5.f;

/* JADX INFO: loaded from: classes18.dex */
public abstract class OfficeBaseSheetKeyboardFragment extends BaseFragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OfficeSheetEditViewModel f238035e;

    public abstract int W90();

    public final MutableLiveData<Editable> U90() {
        return this.f238035e.getEditable();
    }

    public final boolean V90() {
        if (this.f238035e.isExpand() != null) goto L5;
        return false;
    L5:
        return Boolean.TRUE.equals(this.f238035e.isExpand().getValue());
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        this.f238035e.setActive(false);
        tt5.a.h("BaseSheetKeyboardFragment", "onBackPressed mSheetEditViewModel setActive false");
        return true;
    }

    static {
    }

    public OfficeBaseSheetKeyboardFragment() {
    }

    public final Single<List<BaseSegment>> X90(Editable r100) {
        return Single.just(new g((SpannableStringBuilder) r100)).map(new f());
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f238035e = (OfficeSheetEditViewModel) q.a(this, OfficeSheetEditViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(W90(), r101, false);
    }

    public final void Y90(int r110, List<BaseSegment> r111, String r112, String r113, String r114) {
        wm5.a r100 = this.f238035e.getEditDelegate();
        if (r100 == null) goto L29;
        Editable r101 = U90().getValue();
        boolean r102 = true;
        if (r101 == null) goto L12;
        String r103 = r101.toString();
        if (r103 == null) goto L12;
        if (r103.trim().startsWith(ContainerUtils.KEY_VALUE_DELIMITER) == false) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L27;
        int r105 = Selection.getSelectionStart(r101);
        int r106 = Selection.getSelectionEnd(r101);
        int r107 = BaseInputConnection.getComposingSpanStart(r101);
        int r108 = BaseInputConnection.getComposingSpanEnd(r101);
        if (r107 < 0) goto L19;
        if (r108 < 0) goto L19;
        int[] r109 = {r107, r108};
    L20:
        Integer r115 = Integer.valueOf(Math.max(0, Math.min(r105, r101.length())));
        Integer r116 = Integer.valueOf(Math.max(0, Math.min(r106, r101.length())));
        if (r109 != null) goto L23;
    L25:
        r102 = false;
    L26:
        r100.updateSheetEditWithFormulaMeta(r110, r111, r112, r113, r114, r115, r116, "keystroke", Boolean.valueOf(r102));
        return;
    L23:
        if (r109[1] <= r109[0]) goto L25;
    L19:
        r109 = null;
        goto L20
    L27:
        r100.updateSheetEdit(r110, r111, r112, r113, r114);
        return;
    L12:
        r104 = false;
        goto L13
    }
}
