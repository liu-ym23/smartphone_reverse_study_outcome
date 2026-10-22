package q35;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f531503d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f531504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpannableStringBuilder f531505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f531506c;

    /* JADX INFO: renamed from: q35.a$a, reason: collision with other inner class name */
    public static final class C7274a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f531507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f531508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Object> f531509c;

        public b() {
            this.f531509c = new ArrayList();
        }
    }

    static {
    }

    public final SpannableStringBuilder a() {
        Iterator<T> r100 = this.f531506c.iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        b r101 = (b) r100.next();
        if (((ArrayList) r101.f531509c).size() <= 0) goto L4;
        if (r101.f531507a < 0) goto L4;
        if (r101.f531508b < 0) goto L4;
        int r102 = ((ArrayList) r101.f531509c).size();
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L4;
        Object r104 = ListProtector.get(r101.f531509c, r103);
        this.f531505b.setSpan(r104, r101.f531507a, r101.f531508b, 17);
        r103 = r103 + 1;
        goto L12
    L15:
        return this.f531505b;
    }

    public final b b() {
        List<b> r100 = this.f531506c;
        return (b) ListProtector.get(r100, ((ArrayList) r100).size() - 1);
    }

    public final void e() {
        ForegroundColorSpan r100 = new ForegroundColorSpan(ContextCompat.getColor(this.f531504a, R.color.colorful_blue));
        ((ArrayList) b().f531509c).add(r100);
    }

    public final Context getContext() {
        return this.f531504a;
    }

    public a(Context r100) {
        this.f531504a = r100;
        this.f531505b = new SpannableStringBuilder();
        this.f531506c = new ArrayList();
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f531505b.append(r100);
        List<b> r101 = this.f531506c;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new b());
        b r103 = b();
        r103.f531507a = this.f531505b.length() - r100.length();
        r103.f531508b = this.f531505b.length();
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        int r101 = StringsKt.indexOf$default(this.f531505b, r100, 0, false, 6, null);
        if (r101 < 0) goto L5;
        int r102 = r100.length() + r101;
    L6:
        List<b> r103 = this.f531506c;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new b());
        b r105 = b();
        r105.f531507a = r101;
        r105.f531508b = r102;
        return;
    L5:
        r102 = -1;
        goto L6
    }

    public static void c(a r100, TextView r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r101, "textView");
        Intrinsics.checkNotNullParameter(r102, "listener");
        r101.setMovementMethod(LinkMovementMethod.getInstance());
        r101.setHighlightColor(0);
        b r103 = r100.b();
        q35.b r104 = new q35.b(false, r102, r100, r103);
        ((ArrayList) r103.f531509c).add(r104);
    }
}
