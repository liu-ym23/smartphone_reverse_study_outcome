package com.bytedance.ee.bear.sheet.inputbar.subpanel;

import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.text.Selection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final SheetNumKeyboardView a;
    public Editable b;
    public final b c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.sheet.inputbar.subpanel.a$a, reason: collision with other inner class name */
    public class C0178a implements KeyboardView.OnKeyboardActionListener {
        public final /* synthetic */ a a;

        @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
        public final void onPress(int r1) {
        }

        @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
        public final void onRelease(int r1) {
        }

        @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
        public final void onText(CharSequence r1) {
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

        public C0178a(a r1) {
            this.a = r1;
        }

        @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
        public final void onKey(int r3, int[] r4) {
            a r5 = this.a;
            if (r5.b != null) goto L6;
            tt5.a.h("SheetNumKeyboardHandler", "editable is null");
            return;
        L6:
            r5.c.KE();
            int r0 = 0;
            if (r3 == (-5)) goto L29;
            switch(r3) {
                case 1001: goto L28;
                case 1002: goto L27;
                case 1003: goto L26;
                case 1004: goto L14;
                case 1005: goto L13;
                case 1006: goto L12;
                case 1007: goto L11;
                case 1008: goto L10;
                default: goto L9;
            };
        L9:
            a.b(this.a, Character.toString((char) r3));
            return;
        L10:
            a r6 = this.a;
            a.b(r6, a.a(r6, 1008));
            return;
        L11:
            this.a.c.Iw();
            return;
        L12:
            this.a.c.s90();
            return;
        L13:
            a r7 = this.a;
            a.b(r7, a.a(r7, 1005));
            return;
        L14:
            Editable r8 = this.a.b;
            if (r8 == null) goto L23;
            if (r8.length() <= 0) goto L23;
            if (this.a.b.toString().charAt(0) != '-') goto L21;
            this.a.b.delete(0, 1);
        L25:
            this.a.c.cY();
            return;
        L21:
            this.a.b.insert(0, "-");
        L23:
            if (this.a.b.length() != 0) goto L25;
            this.a.b.insert(0, "-");
            goto L25
        L26:
            a r9 = this.a;
            a.b(r9, a.a(r9, 1003));
            this.a.c.UH();
            return;
        L27:
            a r10 = this.a;
            a.b(r10, a.a(r10, 1002));
            this.a.c.Pl();
            return;
        L28:
            a r11 = this.a;
            a.b(r11, a.a(r11, 1001));
            this.a.c.fE();
            return;
        L29:
            Editable r12 = this.a.b;
            if (r12 != null) goto L32;
            return;
        L32:
            if (r12.length() <= 0) goto L60;
            int r13 = this.a.c();
            a r14 = this.a;
            Editable r1 = r14.b;
            if (r1 == null) goto L43;
            int r2 = Selection.getSelectionEnd(r1);
            if (r2 >= 0) goto L39;
            r2 = r14.c();
        L39:
            Editable r15 = r14.b;
            if (r15 == null) goto L43;
            r0 = Math.max(0, Math.min(r2, r15.length()));
        L43:
            if (r13 != r0) goto L46;
            if (r13 <= 0) goto L46;
            this.a.b.delete(r13 - 1, r13);
            return;
        L46:
            int r16 = Math.min(r13, r0);
            int r17 = Math.max(r13, r0);
            if (r16 >= r17) goto L62;
            this.a.b.delete(r16, r17);
            return;
        L62:
            return;
        }
    }

    public interface b {
        void Iw();

        void KE();

        void Pl();

        void UH();

        void cY();

        void fE();

        void s90();
    }

    public final int c() {
        Editable r0 = this.b;
        if (r0 != null) goto L5;
        return 0;
    L5:
        int r1 = Selection.getSelectionStart(r0);
        if (r1 >= 0) goto L8;
        r1 = this.b.getSpanStart(Selection.SELECTION_START);
    L8:
        Editable r2 = this.b;
        if (r2 != null) goto L12;
        return 0;
    L12:
        return Math.max(0, Math.min(r1, r2.length()));
    }

    public a(SheetNumKeyboardView r2, b r3) {
        this.b = null;
        C0178a r0 = new C0178a(this);
        this.a = r2;
        this.c = r3;
        r2.setOnKeyboardActionListener(r0);
        r2.setEnabled(true);
        r2.setPreviewEnabled(false);
    }

    public static String a(a r1, int r2) {
        if (r2 == 1001) goto L19;
        r1.a.getClass();
        if (r2 != 1002) goto L9;
        return "%";
    L9:
        if (r2 != 1003) goto L12;
        return "/";
    L12:
        if (r2 != 1005) goto L15;
        return "00";
    L15:
        if (r2 != 1008) goto L17;
        return ".";
    L17:
        return "";
    L19:
        return r1.a.getCurrencySymbol();
    }

    public static void b(a r4, String r5) {
        if (r4.b == null) goto L21;
        if (r5 == null) goto L22;
        int r0 = r4.c();
        Editable r1 = r4.b;
        int r2 = 0;
        if (r1 == null) goto L16;
        int r3 = Selection.getSelectionEnd(r1);
        if (r3 >= 0) goto L12;
        r3 = r4.c();
    L12:
        Editable r6 = r4.b;
        if (r6 == null) goto L16;
        r2 = Math.max(0, Math.min(r3, r6.length()));
    L16:
        int r7 = Math.min(r0, r2);
        int r8 = Math.max(r0, r2);
        if (r7 >= r8) goto L19;
        r4.b.delete(r7, r8);
    L19:
        r4.b.insert(r7, r5);
        return;
    L22:
        return;
    }
}
