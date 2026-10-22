package com.bytedance.ee.android.file.picker.lib.v2.ui.confirm;

import android.view.View;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.FileEntry;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.GroupEntity;
import com.bytedance.ee.android.file.picker.lib.v2.data.entity.Key;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConfirmAdapter f206097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GroupEntity f206098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileEntry f206099c;

    public a(ConfirmAdapter r100, GroupEntity r101, FileEntry r102) {
        this.f206097a = r100;
        this.f206098b = r101;
        this.f206099c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function2<? super Key, ? super Key, Unit> r101 = this.f206097a.f206093d;
        if (r101 == null) goto L6;
        r101.invoke(this.f206098b.f206023c, this.f206099c.f206020h);
        return;
    }
}
