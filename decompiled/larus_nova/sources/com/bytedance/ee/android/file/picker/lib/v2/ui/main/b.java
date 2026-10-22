package com.bytedance.ee.android.file.picker.lib.v2.ui.main;

import android.view.View;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilePickerAdapter f206136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupEntity f206137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileEntry f206138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f206139d;

    public b(FilePickerAdapter r100, GroupEntity r101, FileEntry r102, boolean r103) {
        this.f206136a = r100;
        this.f206137b = r101;
        this.f206138c = r102;
        this.f206139d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function3<? super GroupEntity, ? super FileEntry, ? super Boolean, Unit> r101 = this.f206136a.f206111e;
        if (r101 == null) goto L6;
        r101.invoke(this.f206137b, this.f206138c, Boolean.valueOf(!this.f206139d));
        return;
    }
}
