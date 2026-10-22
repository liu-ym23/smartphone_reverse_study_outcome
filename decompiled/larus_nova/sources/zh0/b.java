package zh0;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.IMiddlewareLiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements yh0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, ? extends IMiddlewareLiveRoomPlayFragment> f572121a;

    public b() {
    }

    @Override // yh0.a
    public final void b(ArrayMap r100) {
        this.f572121a = r100;
    }

    @Override // yh0.a
    public final void a(IVoiceLiveTheme r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceLiveTheme");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        Map<String, ? extends IMiddlewareLiveRoomPlayFragment> r102 = this.f572121a;
        if (r102 == null) goto L17;
        int r103 = a.f572119a;
        Intrinsics.checkNotNullParameter(r101, "args");
        long r104 = r101.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID, -1);
        boolean r105 = r101.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_PSEUDO_LIVING, false);
        String r106 = String.valueOf(r104);
        if (r105 == false) goto L7;
        r106 = r106 + "_pseudo";
    L7:
        IMiddlewareLiveRoomPlayFragment r107 = r102.get(r106);
        if (r107 == null) goto L18;
        Fragment r108 = r107.getFragment();
        if (r108 == null) goto L19;
        Bundle r109 = r108.getArguments();
        if (r109 != null) goto L14;
        return;
    L14:
        if (a.a(r109) == true) goto L21;
        r109.putAll(a.c(r100));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }
}
