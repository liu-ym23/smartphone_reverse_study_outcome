package wp4;

import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.text.Selection;
import com.bytedance.ee.bear.bitable.card.view.cell.number.STNumberKeyboardView;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements KeyboardView.OnKeyboardActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ STNumberKeyboardView f560592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f560593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.cell.number.a f560594c;

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onPress(int r100) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onRelease(int r100) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onText(CharSequence r100) {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeDown() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeLeft() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeRight() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void swipeUp() {
    }

    @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
    public final void onKey(int r100, int[] r101) {
        Editable r102 = this.f560592a.getEditableText();
        if (r102 != null) goto L6;
        this.f560593b.getClass();
        tt5.a.d("KeyboardUtil", "keyboardView is null,cannot respond...");
        return;
    L6:
        int r103 = r102.getSpanStart(Selection.SELECTION_START);
        int r104 = r102.getSpanEnd(Selection.SELECTION_END);
        if (r100 != (-5)) goto L9;
        if (r103 <= 0) goto L37;
        if (r103 != r104) goto L35;
        r102.delete(r103 - 1, r103);
        return;
    L35:
        if (r103 >= r104) goto L47;
        r102.delete(r103, r104);
        return;
    L47:
        return;
    L37:
        if (r103 != 0) goto L49;
        if (r103 >= r104) goto L50;
        r102.delete(0, r104);
        return;
    L50:
        return;
    L49:
        return;
    L9:
        if (r100 != 1002) goto L11;
        this.f560594c.c(true);
        return;
    L11:
        if (r100 == 1003) goto L22;
        if (r103 == 0) goto L14;
    L16:
        if (r103 >= r104) goto L18;
        r102.delete(r103, r104);
    L18:
        r102.insert(r103, Character.toString((char) r100));
        com.bytedance.ee.bear.bitable.card.view.cell.number.a.d r105 = this.f560594c.f207925e;
        if (r105 == null) goto L41;
        r105.a(r100);
        return;
    L41:
        return;
    L14:
        if (r104 != r102.length()) goto L16;
        r102.clear();
        goto L18
    L22:
        if (r102.length() > 0) goto L24;
        r102.insert(0, "-");
    L28:
        com.bytedance.ee.bear.bitable.card.view.cell.number.a.d r106 = this.f560594c.f207925e;
        if (r106 == null) goto L43;
        r106.a(1003);
        return;
    L43:
        return;
    L24:
        if (r102.toString().charAt(0) != '-') goto L26;
        r102.delete(0, 1);
        goto L28
    L26:
        r102.insert(0, "-");
        goto L28
    }

    public b(STNumberKeyboardView r100, a r101, com.bytedance.ee.bear.bitable.card.view.cell.number.a r102) {
        this.f560592a = r100;
        this.f560593b = r101;
        this.f560594c = r102;
    }
}
