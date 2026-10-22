package lt;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.bytedance.android.gamecp.base.gamedetail.ShowType;
import com.bytedance.android.gamecp.base.gamedetail.i0;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i0 f510631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShowType f510632c;

    @Override // lt.f
    public void e(Dialog r100) {
    }

    public final i0 g() {
        if (this.f510631b != null) goto L12;
        ShowType r100 = this.f510632c;
        if (r100 != ShowType.FLOAT) goto L11;
        int r101 = y0.b(375.0f);
        int r102 = y0.f() - (y0.b(20.0f) * 2);
        int r103 = y0.b(700.0f);
        if (r103 <= r102) goto L9;
        int r104 = r102;
    L10:
        int r105 = y0.b(12.0f);
        int r110 = y0.b(20.0f);
        int r111 = y0.b(20.0f);
        this.f510631b = new i0(this.f510632c, r101, r104, r105, r105, r105, r105, 0, 0, r110, r111, VideoPlayDataContext.PLAYING_GRAVITY);
        goto L12
    L9:
        r104 = r103;
        goto L10
    L11:
        this.f510631b = new i0(r100, 4094);
    L12:
        i0 r106 = this.f510631b;
        if (r106 == null) goto L15;
        return r106;
    L15:
        return new i0(this.f510632c, 4094);
    }

    public a(ShowType r100) {
        Intrinsics.checkNotNullParameter(r100, "showType");
        this.f510632c = r100;
    }

    public static void f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r100.getFitsSystemWindows() == false) goto L6;
        ViewCompat.setOnApplyWindowInsetsListener(r100, new com.bytedance.android.gamecp.common.utils.i0());
        ViewCompat.setFitsSystemWindows(r100, true);
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L11;
        Iterator<View> r101 = UtilityKotlinExtentionsKt.a((ViewGroup) r100).iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        f(r101.next());
        goto L9
    L13:
        return;
    }

    @Override // lt.f
    public void a(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        if (Build.VERSION.SDK_INT < 28) goto L14;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
    L8:
        if (r102 == null) goto L10;
        r102.layoutInDisplayCutoutMode = 1;
    L10:
        Window r103 = r100.getWindow();
        if (r103 == null) goto L15;
        r103.setAttributes(r102);
        return;
    L15:
        return;
    L7:
        r102 = null;
        goto L8
    }
}
