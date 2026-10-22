package jp1;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes8.dex */
public interface b {
    RoomContext a();

    ViewModel b();

    WeakReference<b2> c();

    <V extends View> V findView(int r100);

    DataCenter getDataCenter();

    x3 getToolbarManager();
}
