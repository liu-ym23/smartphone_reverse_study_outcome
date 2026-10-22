package com.bytedance.locallife.pdp;

import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.locallife.dito.event.BusMutableLiveData;
import kotlin.Metadata;
import yw6.o;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R%\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00030\u00030\u00198\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR%\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00030\u00030\u00198\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001f\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u00198\u0006¢\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001eR\"\u0010$\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/locallife/pdp/GoodsDetailContainerViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/locallife/dito/event/BusMutableLiveData;", "", "backEvent", "Lcom/bytedance/locallife/dito/event/BusMutableLiveData;", "getBackEvent", "()Lcom/bytedance/locallife/dito/event/BusMutableLiveData;", "Landroid/net/Uri;", "routerUri", "Landroid/net/Uri;", "getRouterUri", "()Landroid/net/Uri;", "setRouterUri", "(Landroid/net/Uri;)V", "", "maskingHeight", "I", "getMaskingHeight", "()I", "setMaskingHeight", "(I)V", "popupHeight", "getPopupHeight", "setPopupHeight", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "titleBarFloat", "Landroidx/lifecycle/MutableLiveData;", "getTitleBarFloat", "()Landroidx/lifecycle/MutableLiveData;", "resetBodyListScrollPosition", "getResetBodyListScrollPosition", "Lyw6/o;", "exitAction", "getExitAction", "isInGdActivity", "Z", "()Z", "setInGdActivity", "(Z)V", "<init>", "()V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class GoodsDetailContainerViewModel extends ViewModel {
    private final BusMutableLiveData<Boolean> backEvent;
    private final MutableLiveData<o> exitAction;
    private boolean isInGdActivity;
    private int maskingHeight;
    private int popupHeight;
    private final MutableLiveData<Boolean> resetBodyListScrollPosition;
    private Uri routerUri;
    private final MutableLiveData<Boolean> titleBarFloat;

    public GoodsDetailContainerViewModel() {
        this.backEvent = new BusMutableLiveData();
        this.maskingHeight = -1;
        this.popupHeight = -1;
        this.titleBarFloat = new MutableLiveData(Boolean.TRUE);
        this.resetBodyListScrollPosition = new MutableLiveData(Boolean.FALSE);
        this.exitAction = new MutableLiveData(null);
    }

    public final BusMutableLiveData<Boolean> getBackEvent() {
        return this.backEvent;
    }

    public final MutableLiveData<o> getExitAction() {
        return this.exitAction;
    }

    public final int getMaskingHeight() {
        return this.maskingHeight;
    }

    public final int getPopupHeight() {
        return this.popupHeight;
    }

    public final MutableLiveData<Boolean> getResetBodyListScrollPosition() {
        return this.resetBodyListScrollPosition;
    }

    public final Uri getRouterUri() {
        return this.routerUri;
    }

    public final MutableLiveData<Boolean> getTitleBarFloat() {
        return this.titleBarFloat;
    }

    public final boolean isInGdActivity() {
        return this.isInGdActivity;
    }

    public final void setInGdActivity(boolean r100) {
        this.isInGdActivity = r100;
    }

    public final void setMaskingHeight(int r100) {
        this.maskingHeight = r100;
    }

    public final void setPopupHeight(int r100) {
        this.popupHeight = r100;
    }

    public final void setRouterUri(Uri r100) {
        this.routerUri = r100;
    }
}
