package yr1;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.share.VsLiveShareType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public interface p {
    void a(xr1.a r100, String r101, VsLiveShareType r102, com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.r.c r103);

    View getQuickShotWatermark(Context r100, String r101);

    String publishToStory(Activity r100, String r101, String r102, String r103, String r104, Function1<? super Boolean, Unit> r105);

    void removePublishCallback(String r100);
}
