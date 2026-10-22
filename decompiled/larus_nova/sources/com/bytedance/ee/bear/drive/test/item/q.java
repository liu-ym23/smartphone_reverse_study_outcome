package com.bytedance.ee.bear.drive.test.item;

import android.content.Context;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class q implements z85.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f224692a;

    @Override // z85.a
    public final View.OnClickListener a() {
        return new o(this);
    }

    @Override // z85.a
    public final String getButtonName() {
        return (String) this.f224692a.getText(R.string.Bitable_Attachment_LocalFile);
    }

    public q(Context r100) {
        this.f224692a = r100;
    }
}
