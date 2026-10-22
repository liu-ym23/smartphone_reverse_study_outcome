package mh2;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ TextView a;

    public m(TextView r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        TextView r0 = this.a;
        r0.setText((SpannableStringBuilder) r2);
    }
}
