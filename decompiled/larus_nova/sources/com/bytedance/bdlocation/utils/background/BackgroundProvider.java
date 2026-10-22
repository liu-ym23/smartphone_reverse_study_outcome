package com.bytedance.bdlocation.utils.background;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BackgroundProvider {
    private volatile boolean isEnterBackground;
    private List<Callback> mCallback;

    public interface Callback {
        void onAppBackgroundSwitch(boolean r100);
    }

    public BackgroundProvider() {
        this.mCallback = new ArrayList();
        this.isEnterBackground = true;
    }

    public List<Callback> getCallback() {
        return this.mCallback;
    }

    public boolean isBackground() {
        return this.isEnterBackground;
    }

    public void addCallback(Callback r100) {
        List<Callback> r101 = this.mCallback;
        if (r101 == null) goto L6;
        r101.add(r100);
        return;
    }

    public void onAppBackgroundSwitch(boolean r100) {
        this.isEnterBackground = r100;
        List<Callback> r101 = this.mCallback;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() <= 0) goto L17;
        int r102 = 0;
    L8:
        if (r102 >= this.mCallback.size()) goto L18;
        if (ListProtector.get(this.mCallback, r102) == null) goto L12;
        ((Callback) ListProtector.get(this.mCallback, r102)).onAppBackgroundSwitch(r100);
    L12:
        r102 = r102 + 1;
        goto L8
    L18:
        return;
    }

    public void setCallback(List<Callback> r100) {
        if (r100 == null) goto L5;
        this.mCallback = r100;
        return;
    }
}
