package je0;

import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {
    public static final boolean a(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "linkMicMessage");
        Intrinsics.checkNotNullParameter(r100, "$this$validSceneExt");
        if (r100.getValidScene() != 4) goto L5;
        return true;
    L5:
        Intrinsics.checkNotNullParameter(r100, "$this$layoutExt");
        if (r100.getLayout() != 1) goto L8;
        return true;
    L8:
        return false;
    }

    public static final boolean b(z0 r100, IRoom r101) {
        Intrinsics.checkNotNullParameter(r100, "linkMicMessage");
        Intrinsics.checkNotNullParameter(r100, "$this$validSceneExt");
        int r102 = r100.getValidScene();
        if (r102 != 8) goto L5;
    L18:
        return true;
    L5:
        if (r102 == 12) goto L18;
        if (r102 != 16) goto L13;
        if (r101 == null) goto L13;
        if (r101.isLiveTypeAudio() == true) goto L13;
        return true;
    L13:
        Intrinsics.checkNotNullParameter(r100, "$this$layoutExt");
        if (r100.getLayout() != 16) goto L16;
        return true;
    L16:
        return false;
    }

    public static final boolean c(z0 r100, IRoom r101) {
        Intrinsics.checkNotNullParameter(r100, "linkMicMessage");
        Intrinsics.checkNotNullParameter(r100, "$this$validSceneExt");
        int r102 = r100.getValidScene();
        if (r102 != 5) goto L5;
    L20:
        return true;
    L5:
        if (r102 == 9) goto L20;
        if (r102 == 10) goto L20;
        if (r102 != 16) goto L15;
        if (r101 == null) goto L15;
        if (r101.isLiveTypeAudio() != true) goto L15;
        return true;
    L15:
        Intrinsics.checkNotNullParameter(r100, "$this$layoutExt");
        if (r100.getLayout() != 8) goto L18;
        return true;
    L18:
        return false;
    }
}
