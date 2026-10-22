package com.bytedance.ee.bear.reminder.person;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
class PersonMoreItemView extends FrameLayout {
    public TextView a;

    public PersonMoreItemView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PersonMoreItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setPadding(n.d(4), 0, n.d(8), 0);
        LayoutInflater.from(getContext()).inflate(2131564278, this);
        this.a = (TextView) findViewById(2131391279);
    }
}
