package com.ss.android.lark.location_ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public class SearchBar extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f431283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EditText f431284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f431285c;

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchBar f431286a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(SearchBar r100) {
            this.f431286a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (TextUtils.isEmpty(r100.toString()) == false) goto L5;
            this.f431286a.f431285c.setVisibility(4);
            return;
        L5:
            this.f431286a.f431285c.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f431284b.clearFocus();
    }

    public String getText() {
        return this.f431284b.getText().toString();
    }

    public SearchBar(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.location_widget_search_bar_layout, this, true);
        this.f431283a = (ImageView) findViewById(R.id.icon);
        this.f431284b = (EditText) findViewById(R.id.etSearchBar);
        ImageView r101 = (ImageView) findViewById(R.id.clearBtn);
        this.f431285c = r101;
        r101.setOnClickListener(this);
        this.f431284b.addTextChangedListener(new a(this));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != this.f431285c) goto L6;
        this.f431284b.setText(null);
        return;
    }

    public void setEditTextEnabled(boolean r100) {
        this.f431284b.setEnabled(r100);
        this.f431284b.setFocusable(r100);
        this.f431284b.setFocusableInTouchMode(r100);
    }

    public void setEditTextImeOptions(int r100) {
        this.f431284b.setImeOptions(r100);
    }

    public void setFilters(InputFilter[] r100) {
        this.f431284b.setFilters(r100);
    }

    public void setHint(int r100) {
        this.f431284b.setHint(r100);
    }

    public void setIcon(int r100) {
        this.f431283a.setImageResource(r100);
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r100) {
        this.f431284b.setOnFocusChangeListener(r100);
    }

    public void setSearchIconVisibility(int r100) {
        this.f431283a.setVisibility(r100);
    }

    public void setSelection(int r100) {
        this.f431284b.setSelection(r100);
    }

    public void setStyle(int r100) {
        this.f431284b.setTextAppearance(getContext(), r100);
    }

    public void setText(String r100) {
        this.f431284b.setText(r100);
    }

    public void setTextColor(int r100) {
        this.f431284b.setTextColor(r100);
    }

    public SearchBar(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public SearchBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
