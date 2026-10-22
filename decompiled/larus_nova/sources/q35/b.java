package q35;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f531510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f531511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f531512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a.b f531513d;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Function1<String, Unit> r101 = this.f531511b;
        SpannableStringBuilder r102 = this.f531512c.f531505b;
        a.b r103 = this.f531513d;
        r101.invoke(r102.subSequence(r103.f531507a, r103.f531508b).toString());
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        if (this.f531510a == true) goto L6;
        r100.setUnderlineText(false);
        r100.bgColor = 0;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(boolean r100, Function1<? super String, Unit> r101, a r102, a.b r103) {
        this.f531510a = r100;
        this.f531511b = r101;
        this.f531512c = r102;
        this.f531513d = r103;
    }
}
