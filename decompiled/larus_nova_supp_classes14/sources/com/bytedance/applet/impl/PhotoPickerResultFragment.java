package com.bytedance.applet.impl;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.bridge.service.ChooseImageCallback;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/applet/impl/PhotoPickerResultFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "callback", "Lcom/bytedance/ai/bridge/service/ChooseImageCallback;", "maxCount", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getLauncher", "handleResult", "resultCode", "data", "removeSelf", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoPickerResultFragment extends Fragment {
    public static ChooseImageCallback g;
    public ChooseImageCallback d;
    public int e;
    public ActivityResultLauncher<Intent> f;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        this.d = null;
        getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    public PhotoPickerResultFragment() {
        this.e = 9;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        int r0 = 9;
        if (r4 == null) goto L5;
        r0 = r4.getInt("max_count", 9);
    L5:
        this.e = r0;
        this.d = g;
        g = null;
        this.f = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a2(this));
    }
}
