package p98;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.avlink.env.prompt.DoraEnvObservePromptInputDialog;
import com.larus.avlink.impl.databinding.FragmentTextInputDialogBinding;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraEnvObservePromptInputDialog f528312a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public d(DoraEnvObservePromptInputDialog r100) {
        this.f528312a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        DoraEnvObservePromptInputDialog r101 = this.f528312a;
        if (r101.f292316f == false) goto L5;
        return;
    L5:
        r101.f292316f = true;
        if (r100 == null) goto L8;
        int r102 = r100.length();
    L9:
        if (r102 != 0) goto L22;
        Context r103 = this.f528312a.getContext();
        if (r103 == null) goto L34;
        DoraEnvObservePromptInputDialog r104 = this.f528312a;
        FragmentTextInputDialogBinding r105 = r104.f292314d;
        if (r105 == null) goto L17;
        TextView r106 = r105.f293150e;
        if (r106 == null) goto L17;
        r106.setClickable(false);
    L17:
        FragmentTextInputDialogBinding r107 = r104.f292314d;
        if (r107 == null) goto L34;
        TextView r108 = r107.f293150e;
        if (r108 == null) goto L34;
        r108.setTextColor(ContextCompat.getColor(r103, v19.c.b(R.attr.larus_neutral_50, r103, R.color.larus_neutral_50)));
    L34:
        DoraEnvObservePromptInputDialog r109 = this.f528312a;
        if (r109.f292315e > 0) goto L38;
        r109.f292316f = false;
        return;
    L38:
        if (r100 == null) goto L40;
        int r110 = r100.length();
    L41:
        DoraEnvObservePromptInputDialog r111 = this.f528312a;
        if (r110 <= r111.f292315e) goto L55;
        FragmentTextInputDialogBinding r112 = r111.f292314d;
        if (r112 == null) goto L48;
        TextView r113 = r112.f293148c;
        if (r113 == null) goto L48;
        r113.setVisibility(0);
    L48:
        if (r100 == null) goto L50;
        r100.delete(this.f528312a.f292315e, r100.length());
    L50:
        StringBuilder r114 = new StringBuilder();
        r114.append(this.f528312a.f292315e);
        r114.append('/');
        r114.append(this.f528312a.f292315e);
        String r115 = r114.toString();
        int r116 = String.valueOf(this.f528312a.f292315e).length();
        SpannableString r117 = new SpannableString(r115);
        r117.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FF3B30")), 0, r116, 33);
        FragmentTextInputDialogBinding r118 = this.f528312a.f292314d;
        if (r118 == null) goto L60;
        TextView r119 = r118.f293148c;
        if (r119 == null) goto L60;
        r119.setText(r117);
    L60:
        this.f528312a.f292316f = false;
        return;
    L55:
        FragmentTextInputDialogBinding r120 = r111.f292314d;
        if (r120 == null) goto L60;
        TextView r121 = r120.f293148c;
        if (r121 == null) goto L60;
        r121.setVisibility(8);
        goto L60
    L40:
        r110 = 0;
        goto L41
    L22:
        Context r122 = this.f528312a.getContext();
        if (r122 == null) goto L34;
        DoraEnvObservePromptInputDialog r123 = this.f528312a;
        FragmentTextInputDialogBinding r124 = r123.f292314d;
        if (r124 == null) goto L29;
        TextView r125 = r124.f293150e;
        if (r125 == null) goto L29;
        r125.setClickable(true);
    L29:
        FragmentTextInputDialogBinding r126 = r123.f292314d;
        if (r126 == null) goto L34;
        TextView r127 = r126.f293150e;
        if (r127 == null) goto L34;
        r127.setTextColor(ContextCompat.getColor(r122, v19.c.b(R.attr.larus_primary_50, r122, R.color.larus_primary_50)));
        goto L34
    L8:
        r102 = 0;
        goto L9
    }
}
