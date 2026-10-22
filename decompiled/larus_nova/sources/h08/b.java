package h08;

import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f483448d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.compose.foundation.toast.g f483449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDToast.a f483450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f483451c;

    static {
        f483448d = new Handler(Looper.getMainLooper());
    }

    public final void a() {
        com.ss.android.lark.compose.foundation.toast.g r100 = this.f483449a;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f483449a = null;
        this.f483450b = null;
    }

    public final void c() {
        if (this.f483449a != null) goto L8;
        UDToast.a r100 = this.f483450b;
        if (r100 != null) goto L7;
        return;
    L7:
        this.f483449a = r100.a();
    L8:
        this.f483449a.show();
    }

    public b(Context r100, UDToast.a r101) {
        this.f483449a = null;
        this.f483451c = r100;
        this.f483450b = r101;
    }

    public final void b(int r100, Animation r101) {
        if (r100 != (-1)) goto L6;
        return;
    L6:
        if ((r101 instanceof RotateAnimation) == true) goto L15;
        if (r100 == (-1)) goto L27;
        com.ss.android.lark.compose.foundation.toast.g r102 = this.f483449a;
        if (r102 != null) goto L14;
        UDToast.a r103 = this.f483450b;
        if (r103 == null) goto L22;
        r103.d(r100);
        return;
    L22:
        return;
    L14:
        r102.setIcon(r100);
        return;
    L27:
        return;
    L15:
        CircularProgressDrawable r104 = new CircularProgressDrawable(this.f483451c);
        r104.setStyle(1);
        r104.setColorSchemeColors(new int[]{UDColorUtils.getColor(this.f483451c, R.color.static_white)});
        r104.setStrokeCap(Paint.Cap.ROUND);
        com.ss.android.lark.compose.foundation.toast.g r105 = this.f483449a;
        if (r105 != null) goto L20;
        UDToast.a r106 = this.f483450b;
        if (r106 == null) goto L25;
        r106.e(r104);
        return;
    L25:
        return;
    L20:
        r105.setIcon(r104);
    }
}
