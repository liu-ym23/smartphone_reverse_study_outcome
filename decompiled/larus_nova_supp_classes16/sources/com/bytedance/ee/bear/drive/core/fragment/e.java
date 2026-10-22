package com.bytedance.ee.bear.drive.core.fragment;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.drive.mimetype.MimeTypeCategory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    public final void onChanged(Object r1) {
        MimeTypeCategory r2 = (MimeTypeCategory) r1;
        this.a.l();
    }
}
