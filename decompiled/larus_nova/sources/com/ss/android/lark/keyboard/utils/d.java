package com.ss.android.lark.keyboard.utils;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f430958a = 0;

    public static final class a implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f430959a;

        public a(Function0<Unit> r100) {
            this.f430959a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 != 4) goto L6;
            this.f430959a.invoke();
            return true;
        L6:
            return false;
        }
    }

    public static final class b implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f430960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f430961b;

        public b(Function0<Unit> r100) {
            this.f430961b = r100;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r100, int r101, KeyEvent r102) {
            Intrinsics.checkNotNullParameter(r102, "event");
            if ((r100 instanceof EditText) == false) goto L5;
            EditText r103 = (EditText) r100;
        L7:
            if (r103 != null) goto L10;
            return false;
        L10:
            if (r101 == 66) goto L12;
        L35:
            return false;
        L12:
            if (r102.getAction() != 0) goto L32;
            this.f430960a = false;
            if (r102.isShiftPressed() == true) goto L22;
            if (r102.isCtrlPressed() == true) goto L22;
            if (TextUtils.isEmpty(StringsKt.trim(r103.getText())) == true) goto L22;
            this.f430961b.invoke();
            this.f430960a = true;
            return true;
        L22:
            if (TextUtils.isEmpty(StringsKt.trim(r103.getText())) == false) goto L26;
            this.f430960a = true;
            return true;
        L26:
            if (r102.isCtrlPressed() == false) goto L28;
        L29:
            r103.append("\n");
            this.f430960a = true;
            return true;
        L28:
            if (r102.isShiftPressed() == false) goto L35;
        L32:
            if (r102.getAction() != 1) goto L35;
            return this.f430960a;
        L5:
            r103 = null;
            goto L7
        }
    }

    static {
    }

    public static void a(KeyboardFunctionEditText r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        Intrinsics.checkNotNullParameter(r101, "sendAction");
        Object r102 = r100.getTag(R.id.kb_enter_send_listener);
        if ((r102 instanceof View.OnKeyListener) == false) goto L5;
        View.OnKeyListener r103 = (View.OnKeyListener) r102;
    L7:
        if (r103 == null) goto L9;
        Intrinsics.checkNotNullParameter(r103, "onKeyListener");
        r100.f428954i.remove(r103);
        r100.setOnEditorActionListener(null);
        r100.setTag(R.id.kb_enter_send_listener, null);
    L9:
        r100.setImeOptions(4);
        r100.setInputType(16385);
        r100.setTransformationMethod(null);
        r100.setMaxLines(Integer.MAX_VALUE);
        r100.setHorizontallyScrolling(false);
        r100.setOnEditorActionListener(new a(r101));
        b r104 = new b(r101);
        Intrinsics.checkNotNullParameter(r104, "onKeyListener");
        ListProtector.add(r100.f428954i, 0, r104);
        r100.setTag(R.id.kb_enter_send_listener, r104);
        return;
    L5:
        r103 = null;
        goto L7
    }
}
