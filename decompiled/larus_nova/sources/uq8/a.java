package uq8;

import android.text.Editable;
import android.text.TextWatcher;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import oq8.b;
import qq8.c;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f551330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Pair<Integer, Integer>> f551331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<oq8.a, Unit> f551332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public oq8.a f551333d;

    /* JADX INFO: renamed from: uq8.a$a, reason: collision with other inner class name */
    public static final class C7917a {
    }

    static {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r110) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("afterTextChanged textLen=");
        if (r110 == null) goto L5;
        int r102 = r110.length();
    L6:
        r101.append(r102);
        r101.append(" suppress=false");
        r100.d("InlineTriggerWatcher", r101.toString());
        if (r110 != null) goto L10;
        this.f551333d = null;
        return;
    L10:
        Pair<Integer, Integer> r103 = this.f551331b.invoke();
        int r104 = r103.component1().intValue();
        int r105 = r103.component2().intValue();
        r100.d("InlineTriggerWatcher", "selection start=" + r104 + " end=" + r105);
        if (r104 == r105) goto L14;
        this.f551333d = null;
        return;
    L14:
        boolean r106 = false;
        int r107 = RangesKt.coerceIn(r105, 0, r110.length());
        r100.d("InlineTriggerWatcher", "findTriggerStart cursor=" + r107);
        if (r107 > 0) goto L17;
    L16:
        Integer r108 = null;
    L26:
        if (r108 == null) goto L55;
        int r109 = r108.intValue();
        FLogger.f375446a.d("InlineTriggerWatcher", "isInsideToken triggerStart=" + r109 + " cursor=" + r107);
        Iterator r111 = ArrayIteratorKt.iterator((tq8.a[]) r110.getSpans(r109, r107, tq8.a.class));
    L29:
        if (r111.hasNext() == false) goto L36;
        tq8.a r112 = (tq8.a) r111.next();
        int r113 = r110.getSpanStart(r112);
        int r114 = r110.getSpanEnd(r112);
        if (r113 < 0) goto L29;
        if (r114 < 0) goto L29;
        if (r109 < r113) goto L29;
        if (r109 >= r114) goto L29;
        boolean r115 = true;
    L37:
        if (r115 == false) goto L40;
        this.f551333d = null;
        return;
    L40:
        char r116 = r110.charAt(r109);
        String r117 = r110.subSequence(r109 + 1, r107).toString();
        int r118 = 0;
    L42:
        if (r118 >= r117.length()) goto L47;
        if (CharsKt.isWhitespace(r117.charAt(r118)) == true) goto L45;
        r118 = r118 + 1;
        goto L42
    L45:
        r106 = true;
    L47:
        if (r106 == false) goto L50;
        this.f551333d = null;
        return;
    L50:
        oq8.a r119 = new oq8.a(r116, r117, r109, r107);
        if (Intrinsics.areEqual(r119, this.f551333d) == false) goto L53;
        return;
    L53:
        this.f551333d = r119;
        FLogger.f375446a.i("InlineTriggerWatcher", "request trigger='" + r116 + "' keywordLen=" + r117.length() + " triggerStart=" + r109 + " cursor=" + r107);
        this.f551332c.invoke(r119);
        return;
    L36:
        r115 = false;
        goto L37
    L55:
        this.f551333d = null;
        return;
    L17:
        int r120 = r107 - 1;
    L18:
        if ((-1) >= r120) goto L16;
        char r121 = r110.charAt(r120);
        if (CharsKt.isWhitespace(r121) == true) goto L16;
        if (this.f551330a.f524899a.contains(Character.valueOf(r121)) == true) goto L24;
        r120 = r120 - 1;
        goto L18
    L24:
        r108 = Integer.valueOf(r120);
        goto L26
    L5:
        r102 = -1;
        goto L6
    }

    public a(b r100, qq8.b r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "selectionProvider");
        Intrinsics.checkNotNullParameter(r102, "onRequest");
        this.f551330a = r100;
        this.f551331b = r101;
        this.f551332c = r102;
    }
}
