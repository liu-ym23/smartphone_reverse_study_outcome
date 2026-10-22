package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0012B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/ForsetiMutableLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "value", "(Ljava/lang/Object;)V", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "removeObservers", "enable", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ForsetiMutableLiveData<T> extends MutableLiveData<T> {

    public static final class a {
    }

    static {
    }

    public ForsetiMutableLiveData() {
    }

    public ForsetiMutableLiveData(sbb.e r100) {
        super(r100);
    }

    public boolean a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (ForsetiConfig.b() == true) goto L5;
    L9:
        return false;
    L5:
        if (com.suite.lark.component.navroute.forseti.f.c(r100, true) == null) goto L9;
        if (DowngradeSettingUtil.a("downgradeObserveForsetiNode") == true) goto L9;
        return true;
    }

    @Override // androidx.lifecycle.LiveData
    public final void removeObservers(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L9:
        super.removeObservers(r100);
        return;
    L5:
        if (a((FragmentActivity) r100) == false) goto L9;
        LifecycleOwner r101 = j.a(r100);
        tt5.a.h("ForsetiMutableLiveData", "owner:" + r101 + ", removeObservers " + this);
        super.removeObservers(r101);
    }

    @Override // androidx.lifecycle.LiveData
    public final void observe(LifecycleOwner r100, Observer<? super T> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L9:
        super.observe(r100, r101);
        return;
    L5:
        if (a((FragmentActivity) r100) == false) goto L9;
        LifecycleOwner r102 = j.a(r100);
        tt5.a.h("ForsetiMutableLiveData", "owner:" + r102 + ", " + r101 + " observe " + this + ',');
        super.observe(r102, r101);
    }
}
