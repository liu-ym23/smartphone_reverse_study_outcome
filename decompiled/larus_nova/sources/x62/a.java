package x62;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.widget.TextView;
import io.reactivex.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends qtc.a implements TextWatcher {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Observer<? super CharSequence> f562594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f562595c;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // qtc.a
    public final void b() {
        this.f562595c.removeTextChangedListener(this);
    }

    public a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        this.f562595c = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        Observer<? super CharSequence> r101 = this.f562594b;
        if (r101 == null) goto L10;
        CharSequence r102 = r100;
        if (r100 != null) goto L8;
        r102 = "";
    L8:
        r101.onNext(new SpannableStringBuilder(r102));
        return;
    }
}
