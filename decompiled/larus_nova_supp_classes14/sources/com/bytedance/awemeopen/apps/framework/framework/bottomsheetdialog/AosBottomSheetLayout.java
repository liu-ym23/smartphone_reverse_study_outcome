package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.AosBottomSheetViewModel;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/AosBottomSheetLayout;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/AosBottomSheetViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosBaseLayout;", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/z;", "", "clickOutSideToRemove", "", "setClickOutSideToRemove", "Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/a0;", "callback", "setBottomSheetCallback", "", "getBottomSheetHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosBottomSheetLayout<VM extends AosBottomSheetViewModel> extends AosBaseLayout<VM> implements z {
    public final n i;

    @Override // com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog.z
    public int getBottomSheetHeight() {
        return 0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final boolean g() {
        n r0 = this.i;
        if (r0.g != 1) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        AosBaseFragment<?> r2 = r0.a;
        if (r2 == null) goto L12;
        r0.b(r2.getActivity(), r2);
        return true;
    L12:
        return true;
    L10:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public AosBottomSheetLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.i = new n();
    }

    public void setBottomSheetCallback(a0 r2) {
        this.i.f = r2;
    }

    public void setClickOutSideToRemove(boolean r2) {
        this.i.e = r2;
    }
}
