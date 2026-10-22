package com.ss.android.photoeditor.text;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.log.Log;
import com.ss.android.photoeditor.base.view.ColorChoiceView;
import com.ss.android.photoeditor.util.PhotoEditorFG;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes38.dex */
public class TextInputView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f449498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f449499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f449500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f449501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f449502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f449503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorChoiceView f449504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Activity f449505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f449506i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f449507j;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextInputView f449508a;

        public a(TextInputView r100) {
            this.f449508a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = this.f449508a.f449503f.getText().toString();
            TextInputView r102 = this.f449508a;
            f r103 = r102.f449498a;
            if (r103 == null) goto L6;
            com.ss.android.photoeditor.text.c r104 = (com.ss.android.photoeditor.text.c) r103;
            r104.a(r101, r102.f449507j);
            return;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextInputView f449509a;

        public b(TextInputView r100) {
            this.f449509a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            f r101 = this.f449509a.f449498a;
            if (r101 == null) goto L6;
            ((com.ss.android.photoeditor.text.c) r101).a("", -1);
            return;
        }
    }

    public class c implements ColorChoiceView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextInputView f449510a;

        public c(TextInputView r100) {
            this.f449510a = r100;
        }

        @Override // com.ss.android.photoeditor.base.view.ColorChoiceView.b
        public final void a(int r100, ColorChoiceView.ChoiceColor r101) {
            this.f449510a.f449503f.setTextColor(r100);
            this.f449510a.f449507j = r100;
        }
    }

    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f449511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextInputView f449512b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            Rect r100 = new Rect();
            View r101 = this.f449512b.f449505h.getWindow().getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            r101.getWindowVisibleDisplayFrame(r100);
            if (((Boolean) PhotoEditorFG.f449540a.getValue()).booleanValue() == false) goto L10;
            int r103 = this.f449511a;
        L11:
            int r104 = r103 - r100.bottom;
            boolean r105 = this.f449512b.f449506i;
            Log.d("TextInputView", "keyboardHeight = " + r104);
            int r106 = 4;
            if (Math.abs(r104) <= (r103 / 5)) goto L20;
            TextInputView r107 = this.f449512b;
            r107.f449506i = true;
            e r108 = r107.f449499b;
            if (r108 == null) goto L19;
            TextEditorView r109 = ((com.ss.android.photoeditor.text.d) r108).f449533a;
            ColorChoiceView r110 = r109.f449496f;
            if (r109.f449497g == false) goto L18;
            r106 = 0;
        L18:
            r110.setVisibility(r106);
        L19:
            int[] r111 = new int[2];
            this.f449512b.getLocationOnScreen(r111);
            this.f449512b.f449504g.setTranslationY((-(r104 - (r103 - r111[1]))) - this.f449512b.getHeight());
            return;
        L20:
            if (r105 == false) goto L27;
            TextInputView r112 = this.f449512b;
            r112.f449504g.setTranslationY(0.0f);
            e r113 = r112.f449499b;
            if (r113 == null) goto L27;
            TextEditorView r114 = ((com.ss.android.photoeditor.text.d) r113).f449533a;
            ColorChoiceView r115 = r114.f449496f;
            if (r114.f449497g == false) goto L26;
            r106 = 0;
        L26:
            r115.setVisibility(r106);
        L27:
            this.f449512b.f449506i = false;
            return;
        L10:
            r103 = ((WindowManager) this.f449512b.getContext().getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getHeight();
            goto L11
        }

        public d(TextInputView r100) {
            this.f449512b = r100;
        }
    }

    public interface e {
    }

    public interface f {
    }

    public final void b() {
        Activity r100 = this.f449505h;
        if (r100 != null) goto L5;
        return;
    L5:
        ViewTreeObserver r101 = a(r100.getWindow()).getViewTreeObserver();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isAlive() == true) goto L10;
        return;
    L10:
        if (this.f449500c != null) goto L12;
        this.f449500c = new d(this);
    L12:
        r101.removeOnGlobalLayoutListener(this.f449500c);
        r101.addOnGlobalLayoutListener(this.f449500c);
    }

    public final void c() {
        RelativeLayout.inflate(getContext(), R.layout.photo_editor_text_input_view, this);
        this.f449501d = (TextView) findViewById(R.id.tv_confirm);
        this.f449502e = (TextView) findViewById(R.id.tv_back);
        this.f449503f = (EditText) findViewById(R.id.et_input);
        this.f449504g = (ColorChoiceView) findViewById(R.id.text_color_selector);
        this.f449501d.setOnClickListener(new a(this));
        this.f449502e.setOnClickListener(new b(this));
        this.f449504g.setOnColorChangedListener(new c(this));
        if ((getContext() instanceof Activity) == false) goto L6;
        setActivity((Activity) getContext());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Activity r100 = this.f449505h;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getWindow() != null) goto L7;
        return;
    L7:
        if (a(this.f449505h.getWindow()) != null) goto L9;
        return;
    L9:
        if (this.f449500c == null) goto L18;
        ViewTreeObserver r101 = a(this.f449505h.getWindow()).getViewTreeObserver();
        if (r101.isAlive() == false) goto L13;
        r101.removeOnGlobalLayoutListener(this.f449500c);
    L13:
        this.f449500c = null;
        return;
    }

    public TextInputView(Context r100) {
        super(r100);
        c();
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public void setActivity(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f449505h = r100;
        b();
    }

    public void setBottomColorChoiceChangeCallback(e r100) {
        this.f449499b = r100;
    }

    public void setOnInputSaveCallback(f r100) {
        this.f449498a = r100;
    }

    public void setText(CharSequence r100) {
        this.f449503f.setText(r100);
        this.f449503f.setSelection(r100.length());
    }

    public void setTextColor(int r100) {
        this.f449504g.a(r100);
        this.f449503f.setTextColor(r100);
        this.f449507j = r100;
    }

    public TextInputView(Context r100, AttributeSet r101) {
        super(r100, r101);
        c();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        d r102 = this.f449500c;
        if (r102 == null) goto L6;
        r102.f449511a = getMeasuredHeight();
        return;
    }

    public TextInputView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        c();
    }
}
