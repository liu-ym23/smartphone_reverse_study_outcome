package com.bytedance.ee.bear.reminder.person;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
class PersonItemView extends FrameLayout {
    public ImageView a;

    public PersonItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PersonItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setPadding(0, 0, n.d(8), 0);
        LayoutInflater.from(getContext()).inflate(2131564277, this);
        this.a = (ImageView) findViewById(2131376548);
    }
}
