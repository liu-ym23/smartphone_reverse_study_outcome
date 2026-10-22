package com.ss.android.lark.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.bytedance.ee.bear.lark.selector.auth.ChatDocAuthSeletorAdapter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.ss.android.lark.doc.entity.DocResult;
import java.util.HashMap;

/* JADX INFO: loaded from: classes38.dex */
public class ToggleButton extends LinearLayout implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RadioButton f445642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RadioButton f445643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f445644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f445645d;

    public interface a {
    }

    public final void b() {
        this.f445642a.setChecked(!this.f445645d);
        this.f445643b.setChecked(this.f445645d);
    }

    public ToggleButton(Context r100) {
        super(r100);
        this.f445645d = false;
        a(null);
    }

    public final void a(AttributeSet r100) {
        removeAllViews();
        setOrientation(0);
        this.f445642a = new RadioButton(getContext());
        this.f445643b = new RadioButton(getContext());
        String r101 = null;
        this.f445642a.setButtonDrawable(null);
        this.f445643b.setButtonDrawable(null);
        addView(this.f445642a);
        addView(this.f445643b);
        int r102 = -1;
        if (r100 == null) goto L5;
        TypedArray r103 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.checked, R.attr.textColor, R.attr.textOff, R.attr.textOn, R.attr.textPadding, R.attr.textSize, R.attr.thumb});
        String r104 = r103.getString(3);
        String r105 = r103.getString(2);
        r102 = r103.getResourceId(6, -1);
        ColorStateList r106 = r103.getColorStateList(1);
        int r107 = r103.getDimensionPixelSize(4, 5);
        int r108 = r103.getDimensionPixelSize(5, 12);
        this.f445645d = r103.getBoolean(0, false);
        r103.recycle();
        String r109 = r104;
        r101 = r105;
    L6:
        b();
        this.f445642a.setText(r101);
        this.f445643b.setText(r109);
        this.f445642a.setBackgroundResource(r102);
        this.f445642a.setPadding(r107, r107, r107, r107);
        this.f445642a.setTextColor(r106);
        float r110 = r108;
        this.f445642a.setTextSize(r110);
        this.f445643b.setBackgroundResource(r102);
        this.f445643b.setPadding(r107, r107, r107, r107);
        this.f445643b.setTextColor(r106);
        this.f445643b.setTextSize(r110);
        this.f445642a.setOnCheckedChangeListener(this);
        this.f445643b.setOnCheckedChangeListener(this);
        return;
    L5:
        Resources r111 = getContext().getResources();
        r107 = TypedValue.complexToDimensionPixelSize(5, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()));
        Resources r112 = getContext().getResources();
        r108 = TypedValue.complexToDimensionPixelSize(12, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()));
        r109 = null;
        r106 = null;
        goto L6
    }

    public void setChecked(boolean r100) {
        this.f445645d = r100;
        b();
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f445642a.setEnabled(r100);
        this.f445643b.setEnabled(r100);
    }

    public void setOnCheckedChangeListener(a r100) {
        this.f445644c = r100;
    }

    public ToggleButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f445645d = false;
        a(r101);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        if (r101 == true) goto L4;
        return;
    L4:
        if (r100 != this.f445643b) goto L6;
        boolean r102 = true;
    L7:
        this.f445645d = r102;
        b();
        a r103 = this.f445644c;
        if (r103 == null) goto L16;
        boolean r104 = this.f445645d;
        ChatDocAuthSeletorAdapter r105 = (ChatDocAuthSeletorAdapter) r103;
        r105.getClass();
        DocResult r106 = (DocResult) getTag();
        HashMap<String, DocPermPair.PermType> r107 = r105.f227482d;
        String r108 = r106.getDoc().getUrl();
        if (r104 == false) goto L12;
        DocPermPair.PermType r109 = DocPermPair.PermType.EDIT;
    L13:
        r107.put(r108, r109);
        return;
    L12:
        r109 = DocPermPair.PermType.READ;
        goto L13
    L16:
        return;
    L6:
        r102 = false;
        goto L7
    }
}
