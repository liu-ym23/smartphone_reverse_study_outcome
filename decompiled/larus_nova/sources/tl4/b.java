package tl4;

import android.content.res.Resources;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.forms.DuxBoxInputView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxBoxInputView.b f546622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DuxBoxInputView f546623b;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public b(DuxBoxInputView.b r100, DuxBoxInputView r101) {
        this.f546622a = r100;
        this.f546623b = r101;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (this.f546622a.f205113d == null) goto L23;
        Resources r104 = this.f546623b.getResources();
        Object[] r105 = new Object[2];
        if (r100 == null) goto L7;
        String r106 = Integer.valueOf(r100.length()).toString();
    L8:
        r105[0] = r106;
        r105[1] = String.valueOf(this.f546622a.f205113d);
        SpannableString r107 = new SpannableString(r104.getString(R.string.dux_form_counter, r105));
        if (r100 == null) goto L11;
        int r108 = r100.length();
    L12:
        Integer r109 = this.f546622a.f205113d;
        Intrinsics.checkNotNull(r109);
        if (r108 <= r109.intValue()) goto L21;
        ForegroundColorSpan r110 = new ForegroundColorSpan(ContextCompat.getColor(this.f546623b.getContext(), R.color.Primary));
        if (r100 == null) goto L19;
        String r111 = Integer.valueOf(r100.length()).toString();
        if (r111 == null) goto L19;
        int r112 = r111.length();
    L20:
        r107.setSpan(r110, 0, r112, 18);
    L19:
        r112 = 0;
    L21:
        this.f546623b.getTvCounter().setText(r107, TextView.BufferType.SPANNABLE);
        return;
    L11:
        r108 = 0;
        goto L12
    L7:
        r106 = null;
        goto L8
    }
}
