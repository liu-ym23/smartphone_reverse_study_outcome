package ew4;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t implements z {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
    }

    @Override // ew4.z
    public final boolean f() {
        return false;
    }

    @Override // ew4.z
    public final boolean H0() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    @Override // ew4.z
    public final boolean f1() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    @Override // ew4.z
    public final boolean o1() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    @Override // ew4.z
    public final g l() {
        return z.a.a();
    }

    @Override // ew4.z
    public final boolean c(DialogFragment r2, CommentImageSelectorDismissReason r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "reason");
        return false;
    }

    @Override // ew4.z
    public final DialogFragment e(c r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "request");
        return null;
    }
}
