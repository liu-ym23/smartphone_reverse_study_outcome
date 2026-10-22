package com.bytedance.bdlocation.permission.request;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class Permissions {
    static final Impl IMPL = null;

    public static class BaseImpl implements Impl {
        final Handler mHandler;

        public BaseImpl() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // com.bytedance.bdlocation.permission.request.Permissions.Impl
        public void requestPermissions(Activity r2, final String[] r3, final Callback r4) {
            this.mHandler.post(new AnonymousClass1(this, r4, r3));
        }
    }

    public interface Callback {
        void onRequestPermissionResult(String[] r1, int[] r2);
    }

    public interface Impl {
        void requestPermissions(Activity r1, String[] r2, Callback r3);
    }

    public static class MarshmallowImpl implements Impl {
        public MarshmallowImpl() {
        }

        @Override // com.bytedance.bdlocation.permission.request.Permissions.Impl
        public void requestPermissions(Activity r4, String[] r5, Callback r6) {
            if (((PermissionFragment) r4.getFragmentManager().findFragmentByTag("permissions")) != null) goto L6;
            PermissionFragment r0 = new PermissionFragment();
            Bundle r2 = new Bundle();
            r2.putStringArray("permissions", r5);
            r0.setArguments(r2);
            r0.mCallback = r6;
            r4.getFragmentManager().beginTransaction().add(r0, "permissions").commitAllowingStateLoss();
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

    public static void requestPermissions(Activity r1, String[] r2, Callback r3) {
        IMPL.requestPermissions(r1, r2, r3);
    }
}
