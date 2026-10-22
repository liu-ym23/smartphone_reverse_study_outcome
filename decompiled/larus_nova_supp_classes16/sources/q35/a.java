package q35;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int d = 0;
    public final Context a;
    public final SpannableStringBuilder b;
    public final List<b> c;

    /* JADX INFO: renamed from: q35.a$a, reason: collision with other inner class name */
    public static final class C0276a {
    }

    public static final class b {
        public int a;
        public int b;
        public final List<Object> c;

        public b() {
            this.c = new ArrayList();
        }
    }

    static {
    }

    public final SpannableStringBuilder a() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        b r1 = (b) r0.next();
        if (((ArrayList) r1.c).size() <= 0) goto L4;
        if (r1.a < 0) goto L4;
        if (r1.b < 0) goto L4;
        int r2 = ((ArrayList) r1.c).size();
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L4;
        Object r4 = ListProtector.get(r1.c, r3);
        this.b.setSpan(r4, r1.a, r1.b, 17);
        r3 = r3 + 1;
        goto L12
    L15:
        return this.b;
    }

    public final b b() {
        List<b> r0 = this.c;
        return (b) ListProtector.get(r0, ((ArrayList) r0).size() - 1);
    }

    public final void e() {
        ForegroundColorSpan r0 = new ForegroundColorSpan(ContextCompat.getColor(this.a, 2131101111));
        ((ArrayList) b().c).add(r0);
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r1) {
        this.a = r1;
        this.b = new SpannableStringBuilder();
        this.c = new ArrayList();
    }

    public final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        this.b.append(r3);
        List<b> r0 = this.c;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new b());
        b r2 = b();
        r2.a = this.b.length() - r3.length();
        r2.b = this.b.length();
    }

    public final void f(String r8) {
        Intrinsics.checkNotNullParameter(r8, "text");
        int r0 = StringsKt.indexOf$default(this.b, r8, 0, false, 6, null);
        if (r0 < 0) goto L5;
        int r9 = r8.length() + r0;
    L6:
        List<b> r1 = this.c;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new b());
        b r3 = b();
        r3.a = r0;
        r3.b = r9;
        return;
    L5:
        r9 = -1;
        goto L6
    }

    public static void c(a r2, TextView r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "textView");
        Intrinsics.checkNotNullParameter(r4, "listener");
        r3.setMovementMethod(LinkMovementMethod.getInstance());
        r3.setHighlightColor(0);
        b r5 = r2.b();
        q35.b r1 = new q35.b(false, r4, r2, r5);
        ((ArrayList) r5.c).add(r1);
    }
}
