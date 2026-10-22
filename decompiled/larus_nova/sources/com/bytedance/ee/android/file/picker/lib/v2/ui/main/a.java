package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.android.file.picker.lib.databinding.FilePickerMainItemFileBinding;
import com.bytedance.ee.android.file.picker.lib.utils.FileUtils;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.ee.android.file.picker.lib.v2.ui.adapter.ViewBindingHolder;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewBindingHolder f206134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileEntry f206135b;

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        String[] r101 = FileUtils.f206006a;
        Context r102 = ((FilePickerMainItemFileBinding) this.f206134a.f206091b).f205998a.getContext();
        Uri r103 = this.f206135b.f206014b;
        String r104 = FileUtils.c(r103);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "specificMimeType");
        String r105 = FileUtils.c(r103);
        if (FileUtils.d(r102, r103, r105) == false) goto L6;
        return;
    L6:
        if (TextUtils.equals(r105, r104) == true) goto L11;
        if (FileUtils.d(r102, r103, r104) == false) goto L11;
        return;
    L11:
        if (FileUtils.e(r102, r103, "*/*") == true) goto L17;
        LKUIToast.show(r102, R.string.Lark_Legacy_FileBrowserNotSupport);
        return;
    }

    public a(ViewBindingHolder r100, FileEntry r101) {
        this.f206134a = r100;
        this.f206135b = r101;
        super(500);
    }
}
