package com.bytedance.ee.bear.templates;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BaseAnnounceTemplateViewModel extends ViewModel {
    public abstract LiveData<Boolean> getPanelActive();

    public abstract int[] getPanelLocOnScreenS();

    public BaseAnnounceTemplateViewModel() {
    }
}
