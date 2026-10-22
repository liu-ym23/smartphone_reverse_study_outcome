package com.bytedance.ee.bear.sheet.inputbar.subpanel;

import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.text.Selection;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SheetNumKeyboardView f238079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Editable f238080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f238081c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.sheet.inputbar.subpanel.a$a, reason: collision with other inner class name */
    public class C3425a implements KeyboardView.OnKeyboardActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f238082a;

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

        public C3425a(a r100) {
            this.f238082a = r100;
        }

        @Override // android.inputmethodservice.KeyboardView.OnKeyboardActionListener
        public final void onKey(int r100, int[] r101) {
            a r102 = this.f238082a;
            if (r102.f238080b != null) goto L6;
            tt5.a.h("SheetNumKeyboardHandler", "editable is null");
            return;
        L6:
            r102.f238081c.KE();
            int r103 = 0;
            if (r100 == (-5)) goto L29;
            switch(r100) {
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
            a.b(this.f238082a, Character.toString((char) r100));
            return;
        L10:
            a r104 = this.f238082a;
            a.b(r104, a.a(r104, 1008));
            return;
        L11:
            this.f238082a.f238081c.Iw();
            return;
        L12:
            this.f238082a.f238081c.s90();
            return;
        L13:
            a r105 = this.f238082a;
            a.b(r105, a.a(r105, 1005));
            return;
        L14:
            Editable r106 = this.f238082a.f238080b;
            if (r106 == null) goto L23;
            if (r106.length() <= 0) goto L23;
            if (this.f238082a.f238080b.toString().charAt(0) != '-') goto L21;
            this.f238082a.f238080b.delete(0, 1);
        L25:
            this.f238082a.f238081c.cY();
            return;
        L21:
            this.f238082a.f238080b.insert(0, "-");
        L23:
            if (this.f238082a.f238080b.length() != 0) goto L25;
            this.f238082a.f238080b.insert(0, "-");
            goto L25
        L26:
            a r107 = this.f238082a;
            a.b(r107, a.a(r107, 1003));
            this.f238082a.f238081c.UH();
            return;
        L27:
            a r108 = this.f238082a;
            a.b(r108, a.a(r108, 1002));
            this.f238082a.f238081c.Pl();
            return;
        L28:
            a r109 = this.f238082a;
            a.b(r109, a.a(r109, 1001));
            this.f238082a.f238081c.fE();
            return;
        L29:
            Editable r110 = this.f238082a.f238080b;
            if (r110 != null) goto L32;
            return;
        L32:
            if (r110.length() <= 0) goto L60;
            int r111 = this.f238082a.c();
            a r112 = this.f238082a;
            Editable r113 = r112.f238080b;
            if (r113 == null) goto L43;
            int r114 = Selection.getSelectionEnd(r113);
            if (r114 >= 0) goto L39;
            r114 = r112.c();
        L39:
            Editable r115 = r112.f238080b;
            if (r115 == null) goto L43;
            r103 = Math.max(0, Math.min(r114, r115.length()));
        L43:
            if (r111 != r103) goto L46;
            if (r111 <= 0) goto L46;
            this.f238082a.f238080b.delete(r111 - 1, r111);
            return;
        L46:
            int r116 = Math.min(r111, r103);
            int r117 = Math.max(r111, r103);
            if (r116 >= r117) goto L62;
            this.f238082a.f238080b.delete(r116, r117);
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
        Editable r100 = this.f238080b;
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = Selection.getSelectionStart(r100);
        if (r101 >= 0) goto L8;
        r101 = this.f238080b.getSpanStart(Selection.SELECTION_START);
    L8:
        Editable r102 = this.f238080b;
        if (r102 != null) goto L12;
        return 0;
    L12:
        return Math.max(0, Math.min(r101, r102.length()));
    }

    public a(SheetNumKeyboardView r100, b r101) {
        this.f238080b = null;
        C3425a r102 = new C3425a(this);
        this.f238079a = r100;
        this.f238081c = r101;
        r100.setOnKeyboardActionListener(r102);
        r100.setEnabled(true);
        r100.setPreviewEnabled(false);
    }

    public static String a(a r100, int r101) {
        if (r101 == 1001) goto L19;
        r100.f238079a.getClass();
        if (r101 != 1002) goto L9;
        return GXTemplateKey.GAIAX_PE;
    L9:
        if (r101 != 1003) goto L12;
        return HTTP.URL_DEFAULT;
    L12:
        if (r101 != 1005) goto L15;
        return CustomAlbumViewModel.DEFAULT_TAB_ID;
    L15:
        if (r101 != 1008) goto L17;
        return ".";
    L17:
        return "";
    L19:
        return r100.f238079a.getCurrencySymbol();
    }

    public static void b(a r100, String r101) {
        if (r100.f238080b == null) goto L21;
        if (r101 == null) goto L22;
        int r102 = r100.c();
        Editable r103 = r100.f238080b;
        int r104 = 0;
        if (r103 == null) goto L16;
        int r105 = Selection.getSelectionEnd(r103);
        if (r105 >= 0) goto L12;
        r105 = r100.c();
    L12:
        Editable r106 = r100.f238080b;
        if (r106 == null) goto L16;
        r104 = Math.max(0, Math.min(r105, r106.length()));
    L16:
        int r107 = Math.min(r102, r104);
        int r108 = Math.max(r102, r104);
        if (r107 >= r108) goto L19;
        r100.f238080b.delete(r107, r108);
    L19:
        r100.f238080b.insert(r107, r101);
        return;
    L22:
        return;
    }
}
