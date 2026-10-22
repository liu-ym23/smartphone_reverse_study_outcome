package mx4;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        f.b r6 = (f.b) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        View r0 = this.a.g.c;
        Intrinsics.checkNotNull(r0);
        ((TextView) r0.findViewById(2131389261)).setText("总共" + r6.a + "篇文档");
        View r1 = this.a.g.c;
        Intrinsics.checkNotNull(r1);
        ((TextView) r1.findViewById(2131383766)).setText("已经打开过" + r6.b + "篇文档");
        Document r7 = r6.c;
        if (r7 == null) goto L6;
        this.a.b.u5(r7.p);
        a r8 = this.a;
        r8.getClass();
        tt5.a.h("DocAutoTestImpl2", "timeoutCalc. ");
        TimeUnit r2 = TimeUnit.SECONDS;
        r8.j.add(Flowable.timer(35, r2).observeOn(fo5.d.d()).map(new c(r8)).delay(3, r2).observeOn(fo5.d.d()).subscribe(new d(r8), e.a));
        return;
    }
}
