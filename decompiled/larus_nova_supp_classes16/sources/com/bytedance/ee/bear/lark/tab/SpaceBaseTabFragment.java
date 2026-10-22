package com.bytedance.ee.bear.lark.tab;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import cc5.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.maintab.export.BaseTabFragment;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sa5.d;
import sa5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0004J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J \u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u000fH\u0016J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u0011H\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u000fH\u0016J\b\u00101\u001a\u00020\u000fH\u0016J\u0010\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u000106H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/lark/tab/SpaceBaseTabFragment;", "Lcom/ss/android/lark/maintab/export/BaseTabFragment;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "Lcom/bytedance/ee/bear/facade/common/KeyEventHandler;", "<init>", "()V", "mActive", "", "isNewTab", "()Z", "setNewTab", "(Z)V", "tabActionDelegate", "Lcom/bytedance/ee/bear/lark/tab/ISpaceTabAction;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "isActive", "onBackPressed", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "onKeyEventBackPressed", "setTabActionDelegate", "delegate", "onAttach", "context", "Landroid/content/Context;", "needHandleBackPress", "onBind", "tabAppInfo", "Lcom/ss/android/lark/maintab/export/TabAppInfo;", "titleController", "Lcom/ss/android/lark/maintab/export/ITitleController;", "menuController", "Lcom/ss/android/lark/maintab/export/IMenuController;", "onPageSelect", "tabSite", "Lcom/ss/android/lark/maintab/export/TabSite;", "tabIndex", "", "onPageUnSelect", "execCommand", "bundle", "getTabTitleConfig", "Lcom/ss/android/lark/maintab/export/ITabTitleConfig;", "onSingleClick", "onTabDoubleClickedListener", "beginGuide", "callback", "Lcom/bytedance/ee/bear/banner/interfaces/UserNavigationFlowCallback;", "getSubModule", "", "Companion", "contentmanager-lark-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SpaceBaseTabFragment extends BaseTabFragment implements d, q {
    public boolean d;
    public boolean e;
    public c f;

    public static final class a {
    }

    static {
    }

    public boolean onBackPressed() {
        List r0 = getChildFragmentManager().getFragments();
        int r1 = r0.size() - 1;
        if (r1 < 0) goto L13;
    L4:
        int r2 = r1 - 1;
        d r3 = (Fragment) ListProtector.get(r0, r1);
        if ((r3 instanceof d) == true) goto L7;
    L10:
        if (r2 < 0) goto L17;
        r1 = r2;
        goto L4
    L17:
        return false;
    L7:
        if (r3.onBackPressed() == false) goto L10;
        tt5.a.h(((BaseFragment) this).PARENT_TAG, "Back press consumed by :" + r3);
        return true;
    L13:
        return false;
    }

    public void onDestroy() {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroy();
        this.d = false;
    }

    public SpaceBaseTabFragment() {
    }

    public final boolean isActive() {
        return this.d;
    }

    @Override // sa5.q
    public final boolean dispatchKeyEvent(KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3.getKeyCode() != 4) goto L7;
        r3.getAction();
        return false;
    L7:
        return false;
    }

    public void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onAttach(r2);
        c r0 = this.f;
        if (r0 == null) goto L6;
        r0.Bk(r2);
        return;
    }

    public void onCreate(Bundle r1) {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onCreate(r1);
        this.d = true;
    }

    public final void t40(TabAppInfo r3, com.ss.android.lark.maintab.export.d r4) {
        Intrinsics.checkNotNullParameter(r3, "tabAppInfo");
        Intrinsics.checkNotNullParameter(r4, "titleController");
        Intrinsics.checkNotNullParameter(null, "menuController");
        this.e = true;
        c r0 = this.f;
        if (r0 == null) goto L6;
        r0.t40(r3, r4);
        return;
    }
}
