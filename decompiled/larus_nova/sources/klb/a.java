package klb;

import android.os.SystemClock;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f504026a;

    /* JADX INFO: renamed from: klb.a$a, reason: collision with other inner class name */
    public static final class C6570a {
    }

    static {
    }

    public a() {
    }

    public final boolean a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        long r101 = SystemClock.uptimeMillis();
        long r102 = r101 - this.f504026a;
        this.f504026a = r101;
        if (r102 >= 500) goto L6;
        Log.d("BaseClickSpan", "url click elapsed too short");
        return true;
    L6:
        return false;
    }
}
