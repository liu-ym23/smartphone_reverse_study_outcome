package com.ss.android.lark.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import butterknife.Unbinder;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;

/* JADX INFO: loaded from: classes34.dex */
public class BaseFragment extends DesktopCompatFragment {
    protected String PARENT_TAG;
    protected CallbackManager fragmentCallbackManager;
    protected Unbinder mBkUnbinder;
    protected CallbackManager mCallbackManager;
    protected Context mContext;
    protected CallbackManager viewCallbackManager;

    public BaseFragment() {
        this.PARENT_TAG = "time";
    }

    public boolean isActive() {
        if (isAdded() == true) goto L5;
    L7:
        return false;
    L5:
        if (getActivity() == null) goto L7;
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CallbackManager r100 = this.fragmentCallbackManager;
        if (r100 == null) goto L6;
        r100.cancelCallbacks();
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mCallbackManager.cancelCallbacks();
        CallbackManager r100 = this.viewCallbackManager;
        if (r100 == null) goto L6;
        r100.cancelCallbacks();
        return;
    }

    public CallbackManager getCallbackManager() {
        return this.mCallbackManager;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.mContext = getContext();
        this.mCallbackManager = new CallbackManager();
        this.fragmentCallbackManager = new CallbackManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.viewCallbackManager = new CallbackManager();
    }
}
