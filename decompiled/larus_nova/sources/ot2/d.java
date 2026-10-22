package ot2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;

/* JADX INFO: loaded from: classes11.dex */
public interface d {
    int attachToContainer(int r100, View r101);

    View createCustomView(int r100, ToolbarButton r101);

    ViewGroup getContainerView();

    LayoutInflater getLayoutInflate();

    void onChildViewChanged(boolean r100, int r101, View r102);

    void putView2ToolbarManager(ToolbarButton r100, View r101);
}
