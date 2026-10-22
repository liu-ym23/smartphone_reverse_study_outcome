package com.bytedance.ee.bear.drive.view.preview.wrapper;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/wrapper/TitleBarViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "outlineEnable", "Landroidx/lifecycle/MutableLiveData;", "", "getOutlineEnable", "()Landroidx/lifecycle/MutableLiveData;", "outlineActive", "getOutlineActive", "aiEnable", "getAiEnable", "showOutlineMenu", "", "hideOutlineMenu", "showOutlineDialog", "dismissOutlineDialog", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleBarViewModel extends ViewModel {
    private final MutableLiveData<Boolean> aiEnable;
    private final MutableLiveData<Boolean> outlineActive;
    private final MutableLiveData<Boolean> outlineEnable;

    public final void dismissOutlineDialog() {
        this.outlineActive.postValue(Boolean.FALSE);
    }

    public final void hideOutlineMenu() {
        this.outlineEnable.postValue(Boolean.FALSE);
    }

    public TitleBarViewModel() {
        this.outlineEnable = new MutableLiveData();
        this.outlineActive = new MutableLiveData();
        this.aiEnable = new MutableLiveData();
    }

    public final void showOutlineDialog() {
        com.bytedance.ee.bear.drive.report.c r100 = o75.b.a().Ke();
        r100.getClass();
        HashMap<String, Object> r101 = new HashMap();
        r100.a(r101);
        com.bytedance.ee.bear.drive.report.c.d(r101);
        r101.put("click", "contents");
        r101.put(PickerReporterConstants.KEY.TARGET, "ccm_space_docs_contents_view");
        r101.put("convert_type", "none");
        r100.f224585d.n("ccm_space_docs_topbar_click", r101);
        this.outlineActive.postValue(Boolean.TRUE);
    }

    public final void showOutlineMenu() {
        com.bytedance.ee.bear.drive.report.c r100 = o75.b.a().Ke();
        r100.getClass();
        HashMap<String, Object> r101 = new HashMap();
        r100.a(r101);
        com.bytedance.ee.bear.drive.report.c.d(r101);
        r101.put("is_show_contents", String.valueOf(true));
        r100.f224585d.n("ccm_space_docs_topbar_view", r101);
        this.outlineEnable.postValue(Boolean.TRUE);
    }

    public final MutableLiveData<Boolean> getAiEnable() {
        return this.aiEnable;
    }

    public final MutableLiveData<Boolean> getOutlineActive() {
        return this.outlineActive;
    }

    public final MutableLiveData<Boolean> getOutlineEnable() {
        return this.outlineEnable;
    }
}
