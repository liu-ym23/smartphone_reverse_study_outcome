package com.ss.android.photoeditor.text;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.photoeditor.base.view.ColorChoiceView;
import pfc.k;

/* JADX INFO: loaded from: classes38.dex */
public class TextEditorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextEditorDrawView f449491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextEditorGestureView f449492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextInputView f449493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k.a f449494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f449495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorChoiceView f449496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f449497g;

    public interface a {
    }

    public RectF getLocation() {
        return this.f449491a.getLocation();
    }

    public final void a() {
        FrameLayout.inflate(getContext(), R.layout.photo_editor_text_layout, this);
        this.f449491a = (TextEditorDrawView) findViewById(R.id.text_editor_show_view);
        this.f449492b = (TextEditorGestureView) findViewById(R.id.text_editor_gesture_view);
        TextInputView r100 = (TextInputView) findViewById(R.id.text_input_view);
        this.f449493c = r100;
        r100.setVisibility(8);
        this.f449492b.setOnEditTextListener(new b(this));
        this.f449493c.setOnInputSaveCallback(new c(this));
        this.f449493c.setBottomColorChoiceChangeCallback(new d(this));
        this.f449491a.setOnColorChangedListener(new e(this));
    }

    public TextEditorView(Context r100) {
        super(r100);
        a();
    }

    public void setActivity(Activity r100) {
        this.f449493c.setActivity(r100);
    }

    public void setBottomColorChoiceView(ColorChoiceView r100) {
        this.f449496f = r100;
    }

    public void setImageBitmap(Bitmap r100) {
        this.f449491a.setImageBitmap(r100);
    }

    public void setOnColorChangedListener(a r100) {
        this.f449495e = r100;
    }

    public void setPaintColor(int r100) {
        this.f449491a.setPaintColor(r100);
    }

    public void setPluginContext(k.a r100) {
        this.f449494d = r100;
        this.f449491a.setPluginContext(r100);
    }

    public void setToolBarVisiableCallback(TextEditorDrawView.d r100) {
        this.f449491a.setToolBarVisibleCallback(r100);
    }

    public TextEditorView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public TextEditorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
