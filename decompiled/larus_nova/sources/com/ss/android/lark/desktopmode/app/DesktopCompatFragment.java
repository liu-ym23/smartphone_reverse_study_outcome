package com.ss.android.lark.desktopmode.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.e;
import com.ss.android.lark.desktopmode.base.FragmentParams;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import wab.a;
import wab.b;

/* JADX INFO: loaded from: classes35.dex */
public class DesktopCompatFragment<T extends FragmentParams> extends Fragment {
    private static final String TAG = "CompatFragment";
    private Context mApplicationContext;
    private a mCallback;
    private String mFragmentInfoId;
    private T mFragmentParams;
    private int mRequestCode;
    private int mResultCode;
    private Intent mResultIntent;

    public a getLifecycleCallback() {
        return null;
    }

    public void onFinish() {
    }

    public boolean onNewArguments(Bundle r100) {
        return false;
    }

    public void onWindowFocusChanged(boolean r100) {
    }

    public void setLifecycleCallback(a r100) {
    }

    private String generateFragmentInfoId() {
        StringBuilder r100 = new StringBuilder();
        int r101 = e.f285955a;
        r100.append(String.valueOf(System.currentTimeMillis() / 1000));
        r100.append("_");
        r100.append(getClass().getName());
        return r100.toString();
    }

    public void onFragmentBringToFront() {
        b.a.f558910a.getClass();
    }

    public DesktopCompatFragment() {
        this.mResultCode = 0;
        this.mRequestCode = -1;
        this.mResultIntent = new Intent();
        this.mFragmentInfoId = generateFragmentInfoId();
        this.mFragmentParams = null;
        this.mApplicationContext = null;
    }

    public final void finish() {
        onFinish();
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L6;
        return;
    L6:
        if (DesktopUtil.a(r100) == false) goto L8;
        b r101 = b.a.f558910a;
        r101.getClass();
        if (this.mRequestCode >= 0) goto L19;
        return;
    L19:
        if (r101.f558909a.remove(getFragmentInfoId()) != null) goto L22;
        return;
    L22:
        throw null;
    L8:
        if (r100.isDestroyed() == false) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L24;
        r100.finish();
        return;
    L24:
        return;
    L10:
        if (r100.isFinishing() == true) goto L12;
        r102 = true;
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        Context r100 = super.getContext();
        if (r100 != null) goto L6;
        Log.i(TAG, new RuntimeException("getContext returns null"));
        return this.mApplicationContext;
    L6:
        return r100;
    }

    public final String getFragmentInfoId() {
        return this.mFragmentInfoId;
    }

    public T getFragmentParams() {
        return this.mFragmentParams;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (getContext() == null) goto L6;
        this.mApplicationContext = getContext().getApplicationContext();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r100) {
        super.onAttach(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
    }

    public void setFragmentParams(T r100) {
        this.mFragmentParams = r100;
    }

    public void setRequestCode(int r100) {
        this.mRequestCode = r100;
    }

    public void setResult(int r100) {
        setResult(r100, null);
    }

    public void setResult(int r100, Intent r101) {
        FragmentActivity r102 = getActivity();
        if (r102 != null) goto L7;
        Log.e(getClass().getSimpleName(), "setResult", new IllegalAccessException("getActivity returns null"));
        return;
    L7:
        if (DesktopUtil.a(r102) == false) goto L9;
        this.mResultCode = r100;
        this.mResultIntent = r101;
        return;
    L9:
        r102.setResult(r100, r101);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return super.onCreateView(r100, r101, r102);
    }
}
