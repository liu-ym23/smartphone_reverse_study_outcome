package f65;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.core.DriveActivity;
import com.bytedance.ee.bear.m;
import com.ss.android.lark.log.Log;
import sj5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements c {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ b b;

    public final void a() {
        if (b.c(this.b, this.a) == null) goto L6;
        Log.i("MULTITASK-MultitaskHelper", "dropIntoBasket isInitialized = false");
        return;
    }

    public final boolean b() {
        msb.a r0 = b.c(this.b, this.a);
        if (r0 == null) goto L5;
        r0.c();
        return true;
    L5:
        return false;
    }

    public final boolean c() {
        b r0 = this.b;
        FragmentActivity r1 = this.a;
        r0.getClass();
        if ((r1 instanceof DriveActivity) == false) goto L5;
    L8:
        return true;
    L5:
        if ((r1 instanceof m) == true) goto L8;
        return false;
    }

    public final void terminate() {
        msb.a r0 = b.c(this.b, this.a);
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public a(b r1, FragmentActivity r2) {
        this.b = r1;
        this.a = r2;
    }
}
