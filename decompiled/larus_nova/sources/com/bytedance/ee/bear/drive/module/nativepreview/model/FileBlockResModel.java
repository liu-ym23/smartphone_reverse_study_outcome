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

/* JADX INFO: loaded from: classes16.dex */
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
            Lazy r100 = FGDowngradeHelper.f216485a;
            return ((Boolean) FGDowngradeHelper.f216490f.getValue()).booleanValue();
        }

        public void release() {
        L24:
            th = move-exception;
            a.f(FileBlockResModel.TAG, th, false);
            return;
        L4:
            boolean r100 = true;
            if (isDowngradeDocLeakMemory() == true) goto L27;
            WeakReference<FragmentManager> r101 = this.mFragmentManagerRef;     // Catch: Throwable -> L24
            if (r101 != null) goto L9;
        L15:
            WeakReference<Fragment> r102 = this.fragmentRef;     // Catch: Throwable -> L24
            if (r102 == null) goto L39;
            b r103 = b.a.f518330a;     // Catch: Throwable -> L24
            Fragment r104 = r102.get();     // Catch: Throwable -> L24
            if (r104 != null) goto L21;
            r103.getClass();     // Catch: Throwable -> L24
        L20:
            r100 = false;
        L26:
            a.h(FileBlockResModel.TAG, "removeFragmentInCacheFM=" + r100);     // Catch: Throwable -> L24
            goto L39
        L21:
            FragmentManager r105 = r103.c(r104);     // Catch: Throwable -> L24
            if (r105 == null) goto L20;
            r105.beginTransaction().remove(r104).commitAllowingStateLoss();     // Catch: Throwable -> L24
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
            if (r101.get() == null) goto L15;
            WeakReference<Fragment> r106 = this.fragmentRef;     // Catch: Throwable -> L24
            if (r106 == null) goto L15;
            if (r106.get() == null) goto L15;
            this.mFragmentManagerRef.get().beginTransaction().remove(this.fragmentRef.get()).commitAllowingStateLoss();     // Catch: Throwable -> L24
            goto L39
        L27:
            FragmentManager r107 = this.mFragmentManager;     // Catch: Throwable -> L24
            if (r107 == null) goto L30;
            r107.beginTransaction().remove(this.fragment).commitAllowingStateLoss();     // Catch: Throwable -> L24
            goto L39
        L30:
            b r108 = b.a.f518330a;     // Catch: Throwable -> L24
            Fragment r109 = this.fragment;     // Catch: Throwable -> L24
            if (r109 != null) goto L34;
            r108.getClass();     // Catch: Throwable -> L24
        L33:
            r100 = false;
        L37:
            a.h(FileBlockResModel.TAG, "removeFragmentInCacheFM=" + r100);     // Catch: Throwable -> L24
            goto L39
        L34:
            FragmentManager r110 = r108.c(r109);     // Catch: Throwable -> L24
            if (r110 == null) goto L33;
            r110.beginTransaction().remove(r109).commitAllowingStateLoss();     // Catch: Throwable -> L24
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

        public void setComponentHashCode(String r100) {
            this.mComponentHashCode = r100;
        }

        public void setComponentRenderVM(DriveComponentRenderVM r100) {
            this.mComponentRenderVM = r100;
        }

        public void setContainerView(WeakReference<View> r100) {
            this.containerView = r100;
        }

        public void setFragment(Fragment r100) {
            if (isDowngradeDocLeakMemory() == true) goto L5;
            this.fragmentRef = new WeakReference(r100);
            return;
        L5:
            this.fragment = r100;
        }

        public void setFragmentManager(FragmentManager r100) {
            if (isDowngradeDocLeakMemory() == true) goto L5;
            this.mFragmentManagerRef = new WeakReference(r100);
            return;
        L5:
            this.mFragmentManager = r100;
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

    public void setFullScreen(boolean r100) {
        this.mIsFullScreen = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setNativeViewHolder(NativeViewHolder r100) {
        this.nativeViewHolder = r100;
    }

    public void setNeedShow(boolean r100) {
        this.needShow = r100;
    }

    public void setOpenEntity(BaseOpenEntity r100) {
        this.openEntity = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public FileBlockResModel(String r100, BaseOpenEntity r101, NativeViewHolder r102) {
        this.mIsFullScreen = false;
        this.needShow = false;
        this.updateTime = 0;
        this.key = r100;
        this.openEntity = r101;
        this.updateTime = System.currentTimeMillis();
        this.nativeViewHolder = r102;
    }
}
