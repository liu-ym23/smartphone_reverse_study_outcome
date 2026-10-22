package com.ss.android.lark.framework.larkwidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/* JADX INFO: loaded from: classes36.dex */
public interface b {
    <T extends ViewModel> T a(String r100, Class<T> r101, ViewModelProvider.Factory r102);

    <T extends c> T b(Class<? extends c> r100);

    Activity getActivity();

    Context getContext();

    Fragment getHostFragment();

    void startActivity(Intent r100);

    void startActivity(Intent r100, Bundle r101);

    void startActivityForResult(Intent r100, int r101);

    void startActivityForResult(Intent r100, int r101, Bundle r102);
}
