package sob;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f542818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Boolean, Unit> f542819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f542820c;

    public static final class a {
    }

    static {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 == null) goto L4;
        CharSequence r101 = StringsKt.trim(r100);
    L5:
        Function1<Boolean, Unit> r102 = this.f542819b;
        boolean r103 = false;
        if (r101 != null) goto L8;
    L10:
        r102.invoke(Boolean.valueOf(r103));
        return;
    L8:
        if (r101.length() <= 0) goto L10;
        r103 = true;
        goto L10
    L4:
        r101 = null;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function0<Unit> r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "mentionAction");
        Intrinsics.checkNotNullParameter(r101, "whenInputText");
        this.f542818a = r100;
        this.f542819b = r101;
        this.f542820c = System.currentTimeMillis();
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        boolean r104 = true;
        if (r103 == 1) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
    L9:
        boolean r105 = false;
    L10:
        if (r105 == false) goto L19;
        long r106 = System.currentTimeMillis();
        if ((r106 - this.f542820c) <= 1000) goto L14;
        this.f542820c = r106;
    L15:
        if (r104 == false) goto L20;
        this.f542818a.invoke();
        return;
    L20:
        return;
    L14:
        r104 = false;
        goto L15
    L19:
        return;
    L7:
        if (r100.charAt(r101) != '@') goto L9;
        r105 = true;
        goto L10
    }
}
