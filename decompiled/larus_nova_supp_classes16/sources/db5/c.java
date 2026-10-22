package db5;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.bytedance.ee.bear.widget.p;
import java.util.ArrayList;
import kn4.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class c implements TextWatcher {
    public b a;

    public c() {
    }

    public static void a(SpannableStringBuilder r10) {
        ArrayList r0 = new ArrayList(2);
        r0.add(un5.l.class);
        r0.add(un5.e.class);
        r0.add(un5.d.class);
        tt5.a.b("CommentChangeWatcherImp", r10.toString());
        int r4 = 0;
        Object[] r1 = r10.getSpans(0, r10.length(), Object.class);
        int r3 = r1.length;
    L3:
        if (r4 >= r3) goto L11;
        Object r5 = r1[r4];
        if (r0.size() > 0) goto L7;
    L9:
        int r6 = r10.getSpanStart(r5);
        int r7 = r10.getSpanEnd(r5);
        tt5.a.b("CommentChangeWatcherImp", String.valueOf(r6) + " -> " + r7 + " | " + r5.toString() + " | " + r10.subSequence(r6, r7));
    L10:
        r4 = r4 + 1;
        goto L3
    L7:
        if (r0.contains(r5.getClass()) == true) goto L9;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r17) {
        tt5.a.b("CommentChangeWatcherImp", "afterTextChanged: ");
        if (this.a != null) goto L5;
        return;
    L5:
        SpannableStringBuilder r2 = (SpannableStringBuilder) r17;
        tt5.a.b("CommentChangeWatcherImp", "afterTextChanged: before handling comment changing.");
        a(r2);
        b r3 = this.a;
        p r4 = (p) this;
        tt5.a.b("AtEditor", "afterAtContentChanged: " + r3);
        b.a[] r5 = r3.a;
        if (r5 != null) goto L8;
    L42:
        tt5.a.b("CommentChangeWatcherImp", "afterTextChanged: after handling comment changing.");
        a(r2);
        this.a = null;
        return;
    L8:
        if (r5.length == 0) goto L42;
        m r7 = (m) r4.b.get();
        if (r7 == null) goto L13;
        r7.Sw();
    L13:
        tt5.a.b("AtEditor", "afterAtContentChanged: before modified.");
        int r6 = r3.b;
        int r8 = r5.length;
        int r9 = 0;
    L14:
        if (r9 >= r8) goto L38;
        b.a r10 = r5[r9];
        boolean r11 = true;
        if (r6 != 1) goto L18;
    L19:
        un5.i r12 = r10.a;
        if (r6 == 1) goto L23;
        r11 = false;
    L23:
        tt5.a.b("AtEditor", "modifyOrDeleteOneSpan: delete or modify");
        if (r12.E() == true) goto L37;
        int r13 = r2.getSpanStart(r12);
        int r14 = r2.getSpanEnd(r12);
        if (r13 < 0) goto L31;
        if (r14 <= r13) goto L31;
        un5.d[] r16 = (un5.d[]) r2.getSpans(r13, r14, un5.d.class);
        int r18 = r16.length;
        int r19 = 0;
    L29:
        if (r19 >= r18) goto L31;
        un5.d r110 = r16[r19];
        r2.delete(r2.getSpanStart(r110), r2.getSpanEnd(r110));
        r19 = r19 + 1;
    L31:
        if (r11 == false) goto L36;
        int r20 = r2.getSpanStart(r12);
        int r111 = r2.getSpanEnd(r12);
        if (r20 < 0) goto L36;
        if (r111 <= r20) goto L36;
        r2.delete(r20, r111);
    L36:
        r2.removeSpan(r12);
    L37:
        r9 = r9 + 1;
        goto L14
    L18:
        if (r6 != 3) goto L37;
    L38:
        tt5.a.b("AtEditor", "afterAtContentChanged: after modified.");
        m r21 = (m) r4.b.get();
        if (r21 == null) goto L42;
        r21.gr();
        goto L42
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r8, int r9, int r10, int r11) {
        tt5.a.b("CommentChangeWatcherImp", "beforeTextChanged: start = " + r9 + ", count = " + r10 + ", after = " + r11);
        int r0 = 1;
        int r1 = 0;
        if (r10 <= 0) goto L6;
        if (r11 != 0) goto L6;
        boolean r2 = true;
    L7:
        if (r10 != 0) goto L10;
        if (r11 <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r10 <= 0) goto L14;
        if (r11 <= 0) goto L14;
        boolean r12 = true;
    L15:
        if (r2 == true) goto L22;
        if (r3 == false) goto L19;
        r0 = 2;
        goto L22
    L19:
        if (r12 == false) goto L21;
        r0 = 3;
        goto L22
    L21:
        r0 = 0;
    L22:
        SpannableStringBuilder r13 = (SpannableStringBuilder) r8;
        int r14 = r10 + r9;
        un5.i[] r16 = (un5.i[]) r13.getSpans(r9, r14, un5.i.class);
        ArrayList r4 = new ArrayList();
        int r5 = r16.length;
    L23:
        if (r1 >= r5) goto L30;
        un5.i r6 = r16[r1];
        int r7 = r13.getSpanStart(r6);
        int r17 = r13.getSpanEnd(r6);
        if (r7 > r14) goto L29;
        if (r17 <= r9) goto L29;
        r4.add(new b.a(r6));
    L29:
        r1 = r1 + 1;
        goto L23
    L30:
        b.a[] r18 = new b.a[r4.size()];
        r4.toArray(r18);
        this.a = new b(r18, r0, r9, r13.subSequence(r9, r14));
        return;
    L14:
        r12 = false;
    L10:
        r3 = false;
    L6:
        r2 = false;
        goto L7
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
        tt5.a.b("CommentChangeWatcherImp", "onTextChanged: ");
        if (this.a != null) goto L5;
        return;
    L5:
        CharSequence r7 = r3.subSequence(r4, r6 + r4);
        b r8 = this.a;
        CharSequence r9 = r8.d;
        r8.e = r7;
        if (TextUtils.isEmpty(r9) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return;
    L10:
        if (this.a.b == 3) goto L12;
        return;
    L12:
        if (TextUtils.equals(r9, r7) == false) goto L14;
        int r10 = this.a.c + r9.length();
        b r11 = this.a;
        r11.b = 0;
        r11.c = r10;
        r11.d = new SpannableStringBuilder("");
        b r12 = this.a;
        r12.e = new SpannableStringBuilder("");
        return;
    L14:
        if (r7.length() <= r9.length()) goto L19;
        if (r7.toString().startsWith(r9.toString()) == false) goto L19;
        tt5.a.b("CommentChangeWatcherImp", "onTextChanged: change modify to add action");
        int r13 = this.a.c + r9.length();
        b r0 = this.a;
        r0.b = 2;
        r0.c = r13;
        r0.d = new SpannableStringBuilder("");
        b r14 = this.a;
        r14.e = r7.subSequence(r9.length(), r7.length());
        return;
    L19:
        if (r7.length() < r9.length()) goto L21;
        return;
    L21:
        if (r9.toString().startsWith(r7.toString()) == false) goto L30;
        tt5.a.b("CommentChangeWatcherImp", "onTextChanged: chagne modify to delete action");
        int r16 = this.a.c + r7.length();
        b r1 = this.a;
        r1.b = 1;
        r1.c = r16;
        r1.e = new SpannableStringBuilder("");
        b r17 = this.a;
        r17.d = r9.subSequence(r7.length(), r9.length());
        return;
    }
}
