package com.larksuite.component.ui.toast;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import j08.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes24.dex */
public class LKUINormalWarnToast extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f284475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f284476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f284477c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        public static final int ERROR = 0;
        public static final int INFO = 2;
        public static final int SUCCESS = 3;
        public static final int WARN = 1;
    }

    public LKUINormalWarnToast(Context r100) {
        this(r100, null);
    }

    public void setImage(int r100) {
        this.f284476b.setImageResource(r100);
    }

    public void setText(String r100) {
        this.f284477c.setText(r100);
    }

    public void setType(int r100) {
        if (r100 != 0) goto L5;
        this.f284475a.setBackgroundColor(b.c(getContext(), R.color.lkui_R500, 0.15f));
        this.f284477c.setTextColor(getResources().getColor(R.color.lkui_R500));
        return;
    L5:
        if (r100 != 1) goto L7;
        this.f284475a.setBackgroundColor(b.c(getContext(), R.color.lkui_Y500, 0.15f));
        this.f284477c.setTextColor(getResources().getColor(R.color.lkui_Y500));
        return;
    L7:
        if (r100 != 2) goto L9;
        this.f284475a.setBackgroundColor(b.c(getContext(), R.color.lkui_B500, 0.15f));
        this.f284477c.setTextColor(getResources().getColor(R.color.lkui_B500));
        return;
    L9:
        if (r100 == 3) goto L11;
        this.f284475a.setBackgroundColor(b.c(getContext(), R.color.lkui_R500, 0.15f));
        this.f284477c.setTextColor(getResources().getColor(R.color.lkui_R500));
        return;
    L11:
        this.f284475a.setBackgroundColor(b.c(getContext(), R.color.lkui_T500, 0.15f));
        this.f284477c.setTextColor(getResources().getColor(R.color.lkui_T500));
    }

    public LKUINormalWarnToast(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LKUINormalWarnToast(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.wt_icon, R.attr.wt_texts, R.attr.wt_type}, r102, 0);
        Drawable r104 = r103.getDrawable(0);
        CharSequence r105 = r103.getText(1);
        int r106 = r103.getInt(2, 0);
        r103.recycle();
        View r107 = LinearLayout.inflate(getContext(), R.layout.lkui_toast_warn, this);
        this.f284475a = r107.findViewById(R.id.container);
        ImageView r108 = (ImageView) r107.findViewById(R.id.icon);
        this.f284476b = r108;
        r108.setImageDrawable(r104);
        this.f284477c = (TextView) r107.findViewById(R.id.text);
        if (TextUtils.isEmpty(r105) == true) goto L5;
        setText(r105.toString());
    L5:
        setType(r106);
    }
}
