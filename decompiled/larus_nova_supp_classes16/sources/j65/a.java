package j65;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(PreviewViewModel r3, String r4) {
        if (r3 != null) goto L5;
        tt5.a.d("DrivePreviewStatusActionUtils", "onShowFailed preview viewModel is null, tag = " + r4);
    L5:
        tt5.a.h("DrivePreviewStatusActionUtils", "liveInnerPreviewShowStatus onShowFailed, tag = " + r4);
        if (r3 == null) goto L11;
        MutableLiveData<Integer> r5 = r3.liveInnerPreviewShowStatus();
        if (r5 == null) goto L12;
        r5.postValue(3);
        return;
    L12:
        return;
    }

    @JvmStatic
    public static final void b(PreviewViewModel r2, String r3) {
        if (r2 != null) goto L5;
        tt5.a.d("DrivePreviewStatusActionUtils", "onShowStart preview viewModel is null, tag = ".concat(r3));
    L5:
        tt5.a.h("DrivePreviewStatusActionUtils", "liveInnerPreviewShowStatus onShowStart, tag = ".concat(r3));
        if (r2 == null) goto L11;
        MutableLiveData<Integer> r4 = r2.liveInnerPreviewShowStatus();
        if (r4 == null) goto L12;
        r4.postValue(1);
        return;
    L12:
        return;
    }

    @JvmStatic
    public static final void c(PreviewViewModel r2, String r3) {
        if (r2 != null) goto L5;
        tt5.a.d("DrivePreviewStatusActionUtils", "onShowSuccess preview viewModel is null, tag = ".concat(r3));
    L5:
        tt5.a.h("DrivePreviewStatusActionUtils", "liveInnerPreviewShowStatus onShowSuccess, tag = ".concat(r3));
        if (r2 == null) goto L11;
        MutableLiveData<Integer> r4 = r2.liveInnerPreviewShowStatus();
        if (r4 == null) goto L12;
        r4.postValue(2);
        return;
    L12:
        return;
    }
}
