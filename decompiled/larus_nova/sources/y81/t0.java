package y81;

import android.widget.TextSwitcher;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes47.dex */
public final class t0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f566833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f566834b;

    public t0(d0 r100, String r101) {
        this.f566833a = r100;
        this.f566834b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        long r102 = System.currentTimeMillis() / ((long) 1000);
        d0 r103 = this.f566833a;
        long r104 = r103.f566713f0 - r102;
        if (r104 <= 0) goto L10;
        long r105 = 60;
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        String r107 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r104 / r105), Long.valueOf(r104 % r105)}, 2));
        TextSwitcher r108 = this.f566833a.Q;
        if (r108 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r108);
    L7:
        TextSwitcher r109 = this.f566833a.Q;
        if (r109 == null) goto L18;
        r109.setCurrentText(r107);
        return;
    L18:
        return;
    L10:
        TextSwitcher r110 = r103.Q;
        if (r110 == null) goto L13;
        r110.setCurrentText(this.f566834b);
    L13:
        Disposable r111 = this.f566833a.f566731z;
        if (r111 == null) goto L16;
        r111.dispose();
    L16:
        this.f566833a.f566731z = null;
    }
}
