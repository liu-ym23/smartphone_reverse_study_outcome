package com.bytedance.ee.bear.share.view;

import android.content.res.Configuration;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.newshare.b;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.ee.bear.share.newshare.e0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/share/view/ShareViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "dataProvider", "Lcom/bytedance/ee/bear/share/newshare/ShareProvider;", "params", "Lcom/bytedance/ee/bear/share/export/ShareParams;", "init", "", "create", "host", "Lcom/bytedance/ee/bear/share/newshare/IShareHost;", "getMoreUIList", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/ee/bear/share/newshare/ShareUIList;", "getChangeUIItem", "Lcom/bytedance/ee/bear/share/newshare/UIShareItem;", "buildShareItemModelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "onResume", "release", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "ShareViewModel";
    private c0 dataProvider;
    private ShareParams params;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final km5.a buildShareItemModelParams() {
        c0 r100 = this.dataProvider;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    public final LiveData<e0> getChangeUIItem() {
        c0 r100 = this.dataProvider;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f237200e;
    }

    public final LiveData<d0> getMoreUIList() {
        c0 r100 = this.dataProvider;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f237199d;
    }

    public final void onResume() {
        c0 r100 = this.dataProvider;
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    public final void release() {
        c0 r100 = this.dataProvider;
        if (r100 == null) goto L5;
        r100.e();
    L5:
        this.dataProvider = null;
    }

    public ShareViewModel() {
    }

    public final void init(c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "dataProvider");
        this.dataProvider = r100;
    }

    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        c0 r101 = this.dataProvider;
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }

    public final void create(b r100, ShareParams r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.params = r101;
        c0 r102 = this.dataProvider;
        if (r102 == null) goto L6;
        r102.a(r100, new lm5.a(), r101);
        return;
    }
}
