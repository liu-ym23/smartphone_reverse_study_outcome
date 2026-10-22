package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class TEEffectCallback {
    private VEListener.VEEditorEffectListener listener;

    public TEEffectCallback() {
    }

    public void setListener(Object r100) {
        this.listener = (VEListener.VEEditorEffectListener) r100;
    }

    public void onDone(int r100, boolean r101) {
        this.listener.onDone();
    }
}
