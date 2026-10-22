package ut0;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes47.dex */
public interface e {
    MutableLiveData<Boolean> a();

    void b(boolean r100);

    void c(Context r100, UserProfileEvent r101);

    void d(Activity r100, UserProfileEvent r101);

    void showAnonymousUserSilentDialog(Context r100);
}
