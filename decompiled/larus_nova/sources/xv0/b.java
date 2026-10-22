package xv0;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f565138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f565139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f565140c;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public b(EditText r100, c r101, long r102) {
        this.f565138a = r100;
        this.f565139b = r101;
        this.f565140c = r102;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        int r104 = 0;
        if (r100 == null) goto L9;
        if (StringsKt.startsWith$default(r100, "0", false, 2, null) != true) goto L9;
        this.f565138a.setText(Editable.Factory.getInstance().newEditable(r100.subSequence(1, r100.length()).toString()));
        return;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L12;
        this.f565139b.f565143c.getInputMoney().postValue(0L);
        return;
    L12:
        if (r100 == null) goto L16;
        String r105 = r100.toString();
        if (r105 == null) goto L16;
        long r106 = (long) (CastLongProtector.parseLong(r105) * 100.0f);
    L18:
        if (r106 != 0) goto L20;
        this.f565138a.setText(Editable.Factory.getInstance().newEditable(""));
    L26:
        this.f565139b.f565143c.getInputMoney().postValue(Long.valueOf(r106));
        return;
    L20:
        long r107 = this.f565140c;
        if (r106 <= r107) goto L26;
        this.f565138a.setText(Editable.Factory.getInstance().newEditable(String.valueOf((long) (this.f565140c / 100.0f))));
        EditText r108 = this.f565138a;
        Editable r109 = r108.getText();
        if (r109 == null) goto L25;
        r104 = r109.length();
    L25:
        r108.setSelection(r104);
        r106 = r107;
    L16:
        r106 = 0;
        goto L18
    }
}
