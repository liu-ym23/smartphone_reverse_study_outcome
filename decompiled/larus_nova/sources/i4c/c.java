package i4c;

import android.widget.TextView;
import com.alipay.sdk.m.u.i;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f488256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f488257b;

    public c(a r100, String r101) {
        this.f488256a = r100;
        this.f488257b = r101;
    }

    public final void a() {
        a r100 = this.f488256a;
        r100.f488252i = StringsKt.indexOf$default(r100.f488251h, "{", 0, false, 6, null);
        int r101 = StringsKt.lastIndexOf$default(this.f488256a.f488251h, i.f25855d, 0, false, 6, null) + 1;
        StringBuilder r102 = new StringBuilder();
        a r103 = this.f488256a;
        r102.append(r103.f488251h.substring(0, r103.f488252i));
        r102.append(this.f488256a.f488251h.substring(r101));
        String r104 = r102.toString();
        TextView r105 = this.f488256a.f488246c;
        TextView r106 = null;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r105 = null;
    L5:
        float r107 = r105.getPaint().measureText(r104);
        TextView r108 = this.f488256a.f488246c;
        if (r108 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r108 = null;
    L8:
        int r109 = r108.getPaddingLeft();
        TextView r110 = this.f488256a.f488246c;
        if (r110 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r110 = null;
    L11:
        int r111 = r110.getPaddingRight();
        a r112 = this.f488256a;
        TextView r113 = r112.f488246c;
        if (r113 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r113 = null;
    L14:
        r112.f488250g = ((r113.getWidth() - r109) - r111) - r107;
        a r114 = this.f488256a;
        String r115 = this.f488257b;
        TextView r116 = r114.f488246c;
        if (r116 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
    L18:
        r114.b(r115, r106);
        return;
    L17:
        r106 = r116;
        goto L18
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
