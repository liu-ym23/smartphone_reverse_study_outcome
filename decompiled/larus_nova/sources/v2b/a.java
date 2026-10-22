package v2b;

import android.content.Context;
import android.text.Layout;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import kotlin.jvm.functions.Function1;
import u2b.j;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f552775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Context, ? extends com.ss.android.lark.widget.light.viewstub.f> f552776b;

    /* JADX INFO: renamed from: v2b.a$a, reason: collision with other inner class name */
    public static final class C7958a {
    }

    static {
    }

    public a() {
        this.f552775a = UIHelper.dp2px(2.5f);
    }

    public final Layout a(CharSequence r100, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r101, Context r102) {
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b.InterfaceC4800b r103 = r101.G;
        if (r103 == null) goto L5;
        Integer r104 = r103.a();
    L7:
        switch(r101.f412431x) {
            case 17: goto L16;
            case 18: goto L15;
            case 19: goto L14;
            case 20: goto L13;
            case 21: goto L12;
            case 22: goto L11;
            case 23: goto L10;
            case 24: goto L9;
            default: goto L8;
        };
    L8:
        int r105 = Integer.MAX_VALUE;
    L18:
        if (r101.f412417j == false) goto L20;
    L22:
        boolean r106 = false;
    L23:
        int r107 = Math.max(r101.L, r101.M);
        if (r107 <= 0) goto L26;
        r105 = r107;
    L26:
        r101.L = 0;
        r101.M = 0;
        Function1<? super Context, ? extends com.ss.android.lark.widget.light.viewstub.f> r108 = this.f552776b;
        if (r108 == null) goto L30;
        com.ss.android.lark.widget.light.viewstub.f r109 = r108.invoke(r102);
        if (r109 == null) goto L30;
    L31:
        TextLayoutBuilder r110 = new TextLayoutBuilder();
        r110.h(r100);
        r110.f446127c.f446150s = r109;
        r110.j((int) zz7.b.h(r102, 17));
        if (r101.f412410e == false) goto L34;
        int r111 = v2c.a.b(r102, R.color.text_placeholder);
    L35:
        r110.i(r111);
        r110.f(r105);
        r110.l(1.0f);
        TextLayoutBuilder.a r112 = r110.f446127c;
        if (r112.f446144m == false) goto L38;
        r112.f446144m = false;
        r110.f446128d = null;
    L38:
        r110.m(h18.e.b(r102, 0));
        r110.d(null);
        r110.f446131g = r101.A;
        r110.c(r101.f412429v);
        r110.f446129e = new com.ss.android.lark.widget.light.layout.a();
        r110.k(UIHelper.dp2px(2.5f));
        r110.f446130f = r106;
        r110.f446127c.f446134c = this.f552775a;
        return r110.a();
    L34:
        r111 = v2c.a.b(r102, R.color.text_title);
    L30:
        r109 = new b(r102);
        goto L31
    L20:
        if (r101.f412430w == true) goto L22;
        r106 = true;
        goto L23
    L9:
        r105 = j.f(r102, r104);
        goto L18
    L10:
        r105 = j.j(r102, r101.f412414g, r104, r101.f412403a0);
        goto L18
    L11:
        r105 = j.i(r102, r101.f412414g, r104, r101.f412403a0);
        goto L18
    L12:
        r105 = j.l(r102, r104);
        goto L18
    L13:
        r105 = j.k(r102, r104);
        goto L18
    L14:
        r105 = j.e(r102, r104, r101.f412403a0, r101.f412414g);
        goto L18
    L15:
        r105 = j.b(r102, r104);
        goto L18
    L16:
        r105 = j.d(r102, r104);
        goto L18
    L5:
        r104 = null;
        goto L7
    }
}
