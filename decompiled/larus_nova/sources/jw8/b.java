package jw8;

import android.text.Spanned;
import android.widget.TextView;
import lw8.d;
import tsc.o;

/* JADX INFO: loaded from: classes26.dex */
public interface b extends o {
    void a(TextView r100);

    void b(TextView r100, Spanned r101, d r102);

    void e(TextView r100, boolean r101);

    String getCode();

    Integer getEndIndex();

    String getLanguage();

    Integer getStartIndex();

    void m(Spanned r100, b r101);
}
