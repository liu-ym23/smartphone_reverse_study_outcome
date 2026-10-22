package j65;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(PreviewViewModel r100, String r101) {
        if (r100 != null) goto L5;
        tt5.a.d("DrivePreviewStatusActionUtils", "onShowFailed preview viewModel is null, tag = " + r101);
    L5:
        tt5.a.h("DrivePreviewStatusActionUtils", "liveInnerPreviewShowStatus onShowFailed, tag = " + r101);
        if (r100 == null) goto L11;
        MutableLiveData<Integer> r102 = r100.liveInnerPreviewShowStatus();
        if (r102 == null) goto L12;
        r102.postValue(3);
        return;
    L12:
        return;
    }

    @JvmStatic
    public static final void b(PreviewViewModel r100, String r101) {
        if (r100 != null) goto L5;
        tt5.a.d("DrivePreviewStatusActionUtils", "onShowStart preview viewModel is null, tag = ".concat(r101));
    L5:
        tt5.a.h("DrivePreviewStatusActionUtils", "liveInnerPreviewShowStatus onShowStart, tag = ".concat(r101));
        if (r100 == null) goto L11;
        MutableLiveData<Integer> r102 = r100.liveInnerPreviewShowStatus();
        if (r102 == null) goto L12;
        r102.postValue(1);
        return;
    L12:
        return;
    }

    @JvmStatic
    public static final void c(PreviewViewModel r100, String r101) {
        if (r100 != null) goto L5;
        tt5.a.d("DrivePreviewStatusActionUtils", "onShowSuccess preview viewModel is null, tag = ".concat(r101));
    L5:
        tt5.a.h("DrivePreviewStatusActionUtils", "liveInnerPreviewShowStatus onShowSuccess, tag = ".concat(r101));
        if (r100 == null) goto L11;
        MutableLiveData<Integer> r102 = r100.liveInnerPreviewShowStatus();
        if (r102 == null) goto L12;
        r102.postValue(2);
        return;
    L12:
        return;
    }
}
