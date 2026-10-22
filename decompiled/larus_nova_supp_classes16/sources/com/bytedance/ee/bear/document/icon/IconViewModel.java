package com.bytedance.ee.bear.document.icon;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.icon.IconInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\rR\"\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR*\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/document/icon/IconViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "setActive", "(Landroidx/lifecycle/MutableLiveData;)V", "iconInfoList", "", "Lcom/bytedance/ee/bear/document/icon/DocIconNetResult$Icon;", "getIconInfoList", "setIconInfoList", "selectedIcon", "Lcom/bytedance/ee/bear/contract/icon/IconInfo;", "getSelectedIcon", "setSelectedIcon", "setIconCallback", "Lkotlin/Function1;", "", "getSetIconCallback", "()Lkotlin/jvm/functions/Function1;", "setSetIconCallback", "(Lkotlin/jvm/functions/Function1;)V", "setIcon", "iconInfoData", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconViewModel extends ViewModel {
    private MutableLiveData<Boolean> active;
    private MutableLiveData<List<DocIconNetResult.Icon>> iconInfoList;
    private MutableLiveData<IconInfo> selectedIcon;
    private Function1<? super DocIconNetResult.Icon, Unit> setIconCallback;

    public IconViewModel() {
        this.active = new MutableLiveData();
        this.iconInfoList = new MutableLiveData();
        this.selectedIcon = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final MutableLiveData<List<DocIconNetResult.Icon>> getIconInfoList() {
        return this.iconInfoList;
    }

    public final MutableLiveData<IconInfo> getSelectedIcon() {
        return this.selectedIcon;
    }

    public final Function1<DocIconNetResult.Icon, Unit> getSetIconCallback() {
        return this.setIconCallback;
    }

    public final void setActive(MutableLiveData<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.active = r2;
    }

    public final void setIcon(DocIconNetResult.Icon r2) {
        Function1<? super DocIconNetResult.Icon, Unit> r0 = this.setIconCallback;
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }

    public final void setIconInfoList(MutableLiveData<List<DocIconNetResult.Icon>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconInfoList = r2;
    }

    public final void setSelectedIcon(MutableLiveData<IconInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectedIcon = r2;
    }

    public final void setSetIconCallback(Function1<? super DocIconNetResult.Icon, Unit> r1) {
        this.setIconCallback = r1;
    }
}
