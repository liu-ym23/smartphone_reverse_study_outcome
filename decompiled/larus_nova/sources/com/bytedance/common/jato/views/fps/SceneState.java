package com.bytedance.common.jato.views.fps;

import android.app.Activity;
import android.view.Window;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes15.dex */
class SceneState {
    int activityId;
    List<WindowState> mWindows;

    public void updateWindows() {
        if (this.mWindows.size() != 0) goto L5;
        return;
    L5:
        List<WindowState> r100 = this.mWindows;
        WindowState r101 = (WindowState) ListProtector.get(r100, r100.size() - 1);
        List<WindowState> r102 = this.mWindows;
        ListIterator<WindowState> r103 = r102.listIterator(r102.size());
        int r104 = -1;
        boolean r105 = false;
    L7:
        if (r103.hasPrevious() == false) goto L9;
        WindowState r106 = r103.previous();
        r104 = Math.max(r104, r106.mOtherWinMinFrameInterval);
        r105 = r105 | r106.mPreventBackgroundFrame;
        r106.onWindowsUpdate(r101, r104, r105);
        goto L7
    }

    public SceneState(Activity r100) {
        this.mWindows = new ArrayList(2);
        this.activityId = r100.hashCode();
    }

    private WindowState findWindowState(Window r100) {
        Iterator<WindowState> r101 = this.mWindows.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        WindowState r102 = r101.next();
        if (r102.mWindow != r100) goto L4;
        return r102;
    L8:
        return null;
    }

    public boolean removeWindow(WindowState r100) {
        boolean r101 = this.mWindows.remove(r100);
        if (r101 == false) goto L5;
        r100.destroy();
    L5:
        updateWindows();
        return r101;
    }

    public WindowState addWindow(String r100, Window r101, WindowState.WindowConfig r102) {
        WindowState r103 = findWindowState(r101);
        if (r103 != null) goto L7;
        r103 = new WindowState(r100, r101, this, r102);
        this.mWindows.add(r103);
        if (WindowFPSManager.IS_DEBUG == false) goto L7;
        r103.toString();
    L7:
        updateWindows();
        return r103;
    }
}
