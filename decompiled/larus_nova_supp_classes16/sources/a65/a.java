package a65;

import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static void a(PreviewViewModel r1) {
        if (r1 != null) goto L5;
        tt5.a.d("DriveEditModeSwitch", "onSwitchHide preview viewModel is null");
        return;
    L5:
        r1.liveInnerEditModeSwitchActive().postValue(Boolean.FALSE);
    }

    public static void b(PreviewViewModel r1) {
        if (r1 != null) goto L5;
        tt5.a.d("DriveEditModeSwitch", "onSwitchShow preview viewModel is null");
        return;
    L5:
        r1.liveInnerEditModeSwitchActive().postValue(Boolean.TRUE);
    }
}
