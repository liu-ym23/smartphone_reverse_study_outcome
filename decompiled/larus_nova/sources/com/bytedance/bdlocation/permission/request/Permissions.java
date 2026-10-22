package com.bytedance.bdlocation.permission.request;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;

/* JADX INFO: loaded from: classes10.dex */
public class Permissions {
    static final Impl IMPL = null;

    public static class BaseImpl implements Impl {
        final Handler mHandler;

        public BaseImpl() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // com.bytedance.bdlocation.permission.request.Permissions.Impl
        public void requestPermissions(Activity r100, final String[] r101, final Callback r102) {
            this.mHandler.post(new AnonymousClass1(this, r102, r101));
        }
    }

    public interface Callback {
        void onRequestPermissionResult(String[] r100, int[] r101);
    }

    public interface Impl {
        void requestPermissions(Activity r100, String[] r101, Callback r102);
    }

    public static class MarshmallowImpl implements Impl {
        public MarshmallowImpl() {
        }

        @Override // com.bytedance.bdlocation.permission.request.Permissions.Impl
        public void requestPermissions(Activity r100, String[] r101, Callback r102) {
            if (((PermissionFragment) r100.getFragmentManager().findFragmentByTag(ComplianceResult.JsonKey.PERMISSIONS)) != null) goto L6;
            PermissionFragment r103 = new PermissionFragment();
            Bundle r104 = new Bundle();
            r104.putStringArray(ComplianceResult.JsonKey.PERMISSIONS, r101);
            r103.setArguments(r104);
            r103.mCallback = r102;
            r100.getFragmentManager().beginTransaction().add(r103, ComplianceResult.JsonKey.PERMISSIONS).commitAllowingStateLoss();
            return;
        }
    }

    public static boolean systemSupportsRuntimePermission() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        if (systemSupportsRuntimePermission() == false) goto L5;
        IMPL = new MarshmallowImpl();
        return;
    L5:
        IMPL = new BaseImpl();
    }

    public Permissions() {
    }

    public static void requestPermissions(Activity r100, String[] r101, Callback r102) {
        IMPL.requestPermissions(r100, r101, r102);
    }
}
