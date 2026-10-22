package rfb;

import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.ttvecamera.TECameraUtils;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f537651a = 0;

    static {
    }

    @JvmStatic
    public static final void a(boolean r110, ErrorType r111, int r112, String r210) {
        Intrinsics.checkNotNullParameter(r111, "errorType");
        ErrorParams r100 = new ErrorParams(Biz.Messenger, Scene.Chat, Event.file_download, r111, ErrorLevel.Fatal, r112, null, null, r210, Boolean.TRUE, null, null, MapsKt.mapOf(TuplesKt.to("is_crypto", Boolean.valueOf(r110))), TECameraUtils.CAPTURE_HQ_3X, null);
        AppreciableKit.Companion.getInstance().error(r100);
    }
}
