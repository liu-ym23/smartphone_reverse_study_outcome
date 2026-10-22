package com.ss.android.lark.base.embedded;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.window.embedding.SplitInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f409749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LKSplitController f409750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f409751c;

    public class a implements Consumer<List<SplitInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f409752a;

        public a(d r100) {
            this.f409752a = r100;
        }

        @Override // androidx.core.util.Consumer
        public final void accept(List<SplitInfo> r100) {
            List<SplitInfo> r101 = r100;
            if (r101.isEmpty() == true) goto L9;
            SplitInfo r102 = (SplitInfo) ListProtector.get(r101, 0);
            if (r102.getSecondaryActivityStack().isEmpty() == true) goto L9;
            if (r102.getPrimaryActivityStack().contains(this.f409752a.f409749a) == false) goto L9;
            this.f409752a.getClass();
            return;
        L9:
            this.f409752a.getClass();
        }
    }

    public d(Activity r100) {
        LKSplitController r101 = LKSplitController.f409739b;
        LKSplitController r102 = LKSplitController.a.a();
        this.f409750b = r102;
        a r103 = new a(this);
        this.f409751c = r103;
        this.f409749a = r100;
        if (r102.e() == true) goto L5;
        return;
    L5:
        r102.a(r100, ContextCompat.getMainExecutor(r100), r103);
    }
}
