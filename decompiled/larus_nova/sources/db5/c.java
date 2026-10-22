package db5;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.bytedance.ee.bear.widget.p;
import java.util.ArrayList;
import kn4.m;

/* JADX INFO: loaded from: classes16.dex */
public abstract class c implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f467814a;

    public c() {
    }

    public static void a(SpannableStringBuilder r110) {
        ArrayList r100 = new ArrayList(2);
        r100.add(un5.l.class);
        r100.add(un5.e.class);
        r100.add(un5.d.class);
        tt5.a.b("CommentChangeWatcherImp", r110.toString());
        int r101 = 0;
        Object[] r102 = r110.getSpans(0, r110.length(), Object.class);
        int r103 = r102.length;
    L3:
        if (r101 >= r103) goto L11;
        Object r104 = r102[r101];
        if (r100.size() > 0) goto L7;
    L9:
        int r105 = r110.getSpanStart(r104);
        int r106 = r110.getSpanEnd(r104);
        tt5.a.b("CommentChangeWatcherImp", String.valueOf(r105) + " -> " + r106 + " | " + r104.toString() + " | " + r110.subSequence(r105, r106));
    L10:
        r101 = r101 + 1;
        goto L3
    L7:
        if (r100.contains(r104.getClass()) == true) goto L9;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r110) {
        tt5.a.b("CommentChangeWatcherImp", "afterTextChanged: ");
        if (this.f467814a != null) goto L5;
        return;
    L5:
        SpannableStringBuilder r100 = (SpannableStringBuilder) r110;
        tt5.a.b("CommentChangeWatcherImp", "afterTextChanged: before handling comment changing.");
        a(r100);
        b r101 = this.f467814a;
        p r102 = (p) this;
        tt5.a.b("AtEditor", "afterAtContentChanged: " + r101);
        b.a[] r103 = r101.f467808a;
        if (r103 != null) goto L8;
    L42:
        tt5.a.b("CommentChangeWatcherImp", "afterTextChanged: after handling comment changing.");
        a(r100);
        this.f467814a = null;
        return;
    L8:
        if (r103.length == 0) goto L42;
        m r104 = r102.f239949b.get();
        if (r104 == null) goto L13;
        r104.Sw();
    L13:
        tt5.a.b("AtEditor", "afterAtContentChanged: before modified.");
        int r105 = r101.f467809b;
        int r106 = r103.length;
        int r107 = 0;
    L14:
        if (r107 >= r106) goto L38;
        b.a r111 = r103[r107];
        boolean r112 = true;
        if (r105 != 1) goto L18;
    L19:
        un5.i r113 = r111.f467813a;
        if (r105 == 1) goto L23;
        r112 = false;
    L23:
        tt5.a.b("AtEditor", "modifyOrDeleteOneSpan: delete or modify");
        if (r113.E() == true) goto L37;
        int r114 = r100.getSpanStart(r113);
        int r115 = r100.getSpanEnd(r113);
        if (r114 < 0) goto L31;
        if (r115 <= r114) goto L31;
        un5.d[] r116 = (un5.d[]) r100.getSpans(r114, r115, un5.d.class);
        int r117 = r116.length;
        int r118 = 0;
    L29:
        if (r118 >= r117) goto L31;
        un5.d r119 = r116[r118];
        r100.delete(r100.getSpanStart(r119), r100.getSpanEnd(r119));
        r118 = r118 + 1;
    L31:
        if (r112 == false) goto L36;
        int r108 = r100.getSpanStart(r113);
        int r120 = r100.getSpanEnd(r113);
        if (r108 < 0) goto L36;
        if (r120 <= r108) goto L36;
        r100.delete(r108, r120);
    L36:
        r100.removeSpan(r113);
    L37:
        r107 = r107 + 1;
        goto L14
    L18:
        if (r105 != 3) goto L37;
    L38:
        tt5.a.b("AtEditor", "afterAtContentChanged: after modified.");
        m r109 = r102.f239949b.get();
        if (r109 == null) goto L42;
        r109.gr();
        goto L42
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r110, int r111) {
        tt5.a.b("CommentChangeWatcherImp", "beforeTextChanged: start = " + r101 + ", count = " + r110 + ", after = " + r111);
        int r102 = 1;
        int r103 = 0;
        if (r110 <= 0) goto L6;
        if (r111 != 0) goto L6;
        boolean r104 = true;
    L7:
        if (r110 != 0) goto L10;
        if (r111 <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r110 <= 0) goto L14;
        if (r111 <= 0) goto L14;
        boolean r112 = true;
    L15:
        if (r104 == true) goto L22;
        if (r105 == false) goto L19;
        r102 = 2;
        goto L22
    L19:
        if (r112 == false) goto L21;
        r102 = 3;
        goto L22
    L21:
        r102 = 0;
    L22:
        SpannableStringBuilder r106 = (SpannableStringBuilder) r100;
        int r113 = r110 + r101;
        un5.i[] r114 = (un5.i[]) r106.getSpans(r101, r113, un5.i.class);
        ArrayList r107 = new ArrayList();
        int r108 = r114.length;
    L23:
        if (r103 >= r108) goto L30;
        un5.i r109 = r114[r103];
        int r115 = r106.getSpanStart(r109);
        int r116 = r106.getSpanEnd(r109);
        if (r115 > r113) goto L29;
        if (r116 <= r101) goto L29;
        r107.add(new b.a(r109));
    L29:
        r103 = r103 + 1;
        goto L23
    L30:
        b.a[] r117 = new b.a[r107.size()];
        r107.toArray(r117);
        this.f467814a = new b(r117, r102, r101, r106.subSequence(r101, r113));
        return;
    L14:
        r112 = false;
    L10:
        r105 = false;
    L6:
        r104 = false;
        goto L7
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        tt5.a.b("CommentChangeWatcherImp", "onTextChanged: ");
        if (this.f467814a != null) goto L5;
        return;
    L5:
        CharSequence r104 = r100.subSequence(r101, r103 + r101);
        b r105 = this.f467814a;
        CharSequence r106 = r105.f467811d;
        r105.f467812e = r104;
        if (TextUtils.isEmpty(r106) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r104) == false) goto L10;
        return;
    L10:
        if (this.f467814a.f467809b == 3) goto L12;
        return;
    L12:
        if (TextUtils.equals(r106, r104) == false) goto L14;
        int r107 = this.f467814a.f467810c + r106.length();
        b r108 = this.f467814a;
        r108.f467809b = 0;
        r108.f467810c = r107;
        r108.f467811d = new SpannableStringBuilder("");
        b r109 = this.f467814a;
        r109.f467812e = new SpannableStringBuilder("");
        return;
    L14:
        if (r104.length() <= r106.length()) goto L19;
        if (r104.toString().startsWith(r106.toString()) == false) goto L19;
        tt5.a.b("CommentChangeWatcherImp", "onTextChanged: change modify to add action");
        int r110 = this.f467814a.f467810c + r106.length();
        b r111 = this.f467814a;
        r111.f467809b = 2;
        r111.f467810c = r110;
        r111.f467811d = new SpannableStringBuilder("");
        b r112 = this.f467814a;
        r112.f467812e = r104.subSequence(r106.length(), r104.length());
        return;
    L19:
        if (r104.length() < r106.length()) goto L21;
        return;
    L21:
        if (r106.toString().startsWith(r104.toString()) == false) goto L30;
        tt5.a.b("CommentChangeWatcherImp", "onTextChanged: chagne modify to delete action");
        int r113 = this.f467814a.f467810c + r104.length();
        b r114 = this.f467814a;
        r114.f467809b = 1;
        r114.f467810c = r113;
        r114.f467812e = new SpannableStringBuilder("");
        b r115 = this.f467814a;
        r115.f467811d = r106.subSequence(r104.length(), r106.length());
        return;
    }
}
