package ym9;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import g45.d;

/* JADX INFO: loaded from: classes29.dex */
public abstract class a implements g45.a {
    private final MutableLiveData<Boolean> active;
    private String docLogicKeyInternal;

    @Override // g45.a
    public /* synthetic */ void onBecomeActive(d r100, g45.a r101) {
    }

    @Override // g45.a
    public /* synthetic */ void onBecomeInactive(d r100, g45.a r101) {
    }

    @Override // g45.a
    public void requestNotFocus(Context r100) {
    }

    public a() {
        this.active = new MutableLiveData(Boolean.FALSE);
        this.docLogicKeyInternal = "default_doc_logic_key";
    }

    @Override // g45.a
    public LiveData<Boolean> getActive() {
        return this.active;
    }

    public final String getDocLogicKeyInternal() {
        return this.docLogicKeyInternal;
    }

    @Override // g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.FOLLOW_KEYBOARD;
    }

    public final void setActive(boolean r100) {
        this.active.setValue(Boolean.valueOf(r100));
    }

    public final void setDocLogicKey(String r100) {
        this.docLogicKeyInternal = r100;
    }

    public final void setDocLogicKeyInternal(String r100) {
        this.docLogicKeyInternal = r100;
    }
}
