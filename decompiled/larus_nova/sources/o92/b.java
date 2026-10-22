package o92;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.livesdk.interactivity.pin.ui.HighlightViewPager;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f522461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager f522462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f522463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f522464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f522465e;

    public b(HighlightViewPager r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        this.f522462b = r100;
        this.f522463c = r101;
        this.f522464d = false;
        this.f522465e = true;
    }
}
