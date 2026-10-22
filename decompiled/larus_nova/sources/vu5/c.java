package vu5;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import io.reactivex.Observer;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends vu5.a<CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f557354a;

    public static final class a extends qtc.a implements TextWatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f557355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Observer<? super CharSequence> f557356c;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // qtc.a
        public final void b() {
            this.f557355b.removeTextChangedListener(this);
        }

        public a(TextView r100, Observer<? super CharSequence> r101) {
            this.f557355b = r100;
            this.f557356c = r101;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (isDisposed() == true) goto L6;
            this.f557356c.onNext(r100);
            return;
        }
    }

    public c(TextView r100) {
        this.f557354a = r100;
    }
}
