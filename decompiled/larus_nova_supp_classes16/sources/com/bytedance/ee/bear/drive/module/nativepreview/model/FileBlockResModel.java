package com.bytedance.ee.bear.drive.module.nativepreview.model;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import n85.b;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FileBlockResModel implements NonProguard {
    private static final String TAG = "FileBlockResModel";
    private String key;
    private boolean mIsFullScreen;
    private NativeViewHolder nativeViewHolder;
    private boolean needShow;
    private BaseOpenEntity openEntity;
    private long updateTime;

    public static class NativeViewHolder implements NonProguard {
        private WeakReference<View> containerView;
        private Fragment fragment;
        private WeakReference<Fragment> fragmentRef;
        private String mComponentHashCode;
        private DriveComponentRenderVM mComponentRenderVM;
        private FragmentManager mFragmentManager;
        private WeakReference<FragmentManager> mFragmentManagerRef;

        public NativeViewHolder() {
        }

        public boolean isDowngradeDocLeakMemory() {
            Lazy r0 = FGDowngradeHelper.a;
            return ((Boolean) FGDowngradeHelper.f.getValue()).booleanValue();
        }

        public void release() {
        L24:
            th = move-exception;
            a.f(FileBlockResModel.TAG, th, false);
            return;
        L4:
            boolean r3 = true;
            if (isDowngradeDocLeakMemory() == true) goto L27;
            WeakReference<FragmentManager> r2 = this.mFragmentManagerRef;     // Catch: Throwable -> L24
            if (r2 != null) goto L9;
        L15:
            WeakReference<Fragment> r4 = this.fragmentRef;     // Catch: Throwable -> L24
            if (r4 == null) goto L39;
            b r5 = b.a.a;     // Catch: Throwable -> L24
            Fragment r6 = r4.get();     // Catch: Throwable -> L24
            if (r6 != null) goto L21;
            r5.getClass();     // Catch: Throwable -> L24
        L20:
            r3 = false;
        L26:
            a.h(FileBlockResModel.TAG, "removeFragmentInCacheFM=" + r3);     // Catch: Throwable -> L24
            goto L39
        L21:
            FragmentManager r7 = r5.c(r6);     // Catch: Throwable -> L24
            if (r7 == null) goto L20;
            r7.beginTransaction().remove(r6).commitAllowingStateLoss();     // Catch: Throwable -> L24
        L39:
            if (getContainerView() != null) goto L41;
            return;
        L41:
            if (getContainerView().get() == null) goto L49;
            ((ViewGroup) getContainerView().get()).removeAllViews();     // Catch: Throwable -> L24
            return;
        L49:
            return;
        L9:
            if (r2.get() == null) goto L15;
            WeakReference<Fragment> r8 = this.fragmentRef;     // Catch: Throwable -> L24
            if (r8 == null) goto L15;
            if (r8.get() == null) goto L15;
            this.mFragmentManagerRef.get().beginTransaction().remove(this.fragmentRef.get()).commitAllowingStateLoss();     // Catch: Throwable -> L24
            goto L39
        L27:
            FragmentManager r9 = this.mFragmentManager;     // Catch: Throwable -> L24
            if (r9 == null) goto L30;
            r9.beginTransaction().remove(this.fragment).commitAllowingStateLoss();     // Catch: Throwable -> L24
            goto L39
        L30:
            b r10 = b.a.a;     // Catch: Throwable -> L24
            Fragment r11 = this.fragment;     // Catch: Throwable -> L24
            if (r11 != null) goto L34;
            r10.getClass();     // Catch: Throwable -> L24
        L33:
            r3 = false;
        L37:
            a.h(FileBlockResModel.TAG, "removeFragmentInCacheFM=" + r3);     // Catch: Throwable -> L24
            goto L39
        L34:
            FragmentManager r12 = r10.c(r11);     // Catch: Throwable -> L24
            if (r12 == null) goto L33;
            r12.beginTransaction().remove(r11).commitAllowingStateLoss();     // Catch: Throwable -> L24
            goto L37
        }

        public Fragment getFragment() {
            if (isDowngradeDocLeakMemory() == true) goto L6;
            return this.fragmentRef.get();
        L6:
            return this.fragment;
        }

        public String getComponentHashCode() {
            return this.mComponentHashCode;
        }

        public DriveComponentRenderVM getComponentRenderVM() {
            return this.mComponentRenderVM;
        }

        public WeakReference<View> getContainerView() {
            return this.containerView;
        }

        public void setComponentHashCode(String r1) {
            this.mComponentHashCode = r1;
        }

        public void setComponentRenderVM(DriveComponentRenderVM r1) {
            this.mComponentRenderVM = r1;
        }

        public void setContainerView(WeakReference<View> r1) {
            this.containerView = r1;
        }

        public void setFragment(Fragment r2) {
            if (isDowngradeDocLeakMemory() == true) goto L5;
            this.fragmentRef = new WeakReference(r2);
            return;
        L5:
            this.fragment = r2;
        }

        public void setFragmentManager(FragmentManager r2) {
            if (isDowngradeDocLeakMemory() == true) goto L5;
            this.mFragmentManagerRef = new WeakReference(r2);
            return;
        L5:
            this.mFragmentManager = r2;
        }
    }

    public String toString() {
        return "FileBlockResModel{, needShow=" + this.needShow + ", openEntity=" + this.openEntity + ", updateTime=" + this.updateTime + '}';
    }

    public String getKey() {
        return this.key;
    }

    public NativeViewHolder getNativeViewHolder() {
        return this.nativeViewHolder;
    }

    public BaseOpenEntity getOpenEntity() {
        return this.openEntity;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public boolean isIsFullScreen() {
        return this.mIsFullScreen;
    }

    public boolean isNeedShow() {
        return this.needShow;
    }

    public void setFullScreen(boolean r1) {
        this.mIsFullScreen = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setNativeViewHolder(NativeViewHolder r1) {
        this.nativeViewHolder = r1;
    }

    public void setNeedShow(boolean r1) {
        this.needShow = r1;
    }

    public void setOpenEntity(BaseOpenEntity r1) {
        this.openEntity = r1;
    }

    public void setUpdateTime(long r1) {
        this.updateTime = r1;
    }

    public FileBlockResModel(String r3, BaseOpenEntity r4, NativeViewHolder r5) {
        this.mIsFullScreen = false;
        this.needShow = false;
        this.updateTime = 0;
        this.key = r3;
        this.openEntity = r4;
        this.updateTime = System.currentTimeMillis();
        this.nativeViewHolder = r5;
    }
}
