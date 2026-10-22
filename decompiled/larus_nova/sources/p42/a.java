package p42;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.IPSHighlightCompLifecycle$State;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f527648c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsPSHighlightComp f527649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IPSHighlightCompLifecycle$State f527650b;

    /* JADX INFO: renamed from: p42.a$a, reason: collision with other inner class name */
    public static final class C7149a {
        @JvmStatic
        public static a a(AbsPSHighlightComp r100) {
            Intrinsics.checkNotNullParameter(r100, "comp");
            return new a(r100, r100.f133403b.f64752a);
        }
    }

    static {
    }

    public a(AbsPSHighlightComp r100, IPSHighlightCompLifecycle$State r101) {
        this.f527649a = r100;
        this.f527650b = r101;
    }
}
