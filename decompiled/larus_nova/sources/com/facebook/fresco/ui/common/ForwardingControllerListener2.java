package com.facebook.fresco.ui.common;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ForwardingControllerListener2<I> extends BaseControllerListener2<I> {
    private static final String TAG = "FwdControllerListener2";
    private final List<ControllerListener2<I>> mListeners;

    public synchronized void removeAllListeners() {
        monitor-enter(this);
        this.mListeners.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public ForwardingControllerListener2() {
        this.mListeners = new ArrayList(2);
    }

    public synchronized void addListener(ControllerListener2<I> r100) {
        monitor-enter(this);
        this.mListeners.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void removeListener(ControllerListener2<I> r100) {
        monitor-enter(this);
        int r101 = this.mListeners.indexOf(r100);     // Catch: Throwable -> L8
        if (r101 == (-1)) goto L6;
        this.mListeners.remove(r101);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private synchronized void onException(String r100, Throwable r101) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(String r100, @Nullable ControllerListener2.Extras r101) {
        int r102 = this.mListeners.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        ControllerListener2<I> r104 = this.mListeners.get(r103);     // Catch: Exception -> L8
        if (r104 == null) goto L10;
        r104.onRelease(r100, r101);     // Catch: Exception -> L8
    L10:
        r103 = r103 + 1;
    L8:
        e = move-exception;
        onException("ForwardingControllerListener2 exception in onRelease", e);
        goto L10
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(String r100, @Nullable Throwable r101, @Nullable ControllerListener2.Extras r102) {
        int r103 = this.mListeners.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        ControllerListener2<I> r105 = this.mListeners.get(r104);     // Catch: Exception -> L8
        if (r105 == null) goto L10;
        r105.onFailure(r100, r101, r102);     // Catch: Exception -> L8
    L10:
        r104 = r104 + 1;
    L8:
        e = move-exception;
        onException("ForwardingControllerListener2 exception in onFailure", e);
        goto L10
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(String r100, @Nullable I r101, @Nullable ControllerListener2.Extras r102) {
        int r103 = this.mListeners.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        ControllerListener2<I> r105 = this.mListeners.get(r104);     // Catch: Exception -> L8
        if (r105 == null) goto L10;
        r105.onFinalImageSet(r100, r101, r102);     // Catch: Exception -> L8
    L10:
        r104 = r104 + 1;
    L8:
        e = move-exception;
        onException("ForwardingControllerListener2 exception in onFinalImageSet", e);
        goto L10
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(String r100, @Nullable Object r101, @Nullable ControllerListener2.Extras r102) {
        int r103 = this.mListeners.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        ControllerListener2<I> r105 = this.mListeners.get(r104);     // Catch: Exception -> L8
        if (r105 == null) goto L10;
        r105.onSubmit(r100, r101, r102);     // Catch: Exception -> L8
    L10:
        r104 = r104 + 1;
    L8:
        e = move-exception;
        onException("ForwardingControllerListener2 exception in onSubmit", e);
        goto L10
    }
}
