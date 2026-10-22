package mh2;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f513917a;

    public h(TextView r100) {
        this.f513917a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TextView r101 = this.f513917a;
        r101.setText((SpannableStringBuilder) r100);
    }
}
