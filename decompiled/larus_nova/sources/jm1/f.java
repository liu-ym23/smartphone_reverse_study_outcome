package jm1;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.chatroom.vs_host.ReplayDelegateFragment;

/* JADX INFO: loaded from: classes7.dex */
public interface f {
    void Ad(ReplayDelegateFragment.c r100);

    void TC(ReplayDelegateFragment.b r100);

    boolean isNestedOutside();

    boolean onBackPressed();

    void onScrollAway();

    d roomAction();

    e roomEventListener();

    Fragment self();

    void setNestedOutside(boolean r100);

    void startRoom(String r100);

    void stopRoom();
}
