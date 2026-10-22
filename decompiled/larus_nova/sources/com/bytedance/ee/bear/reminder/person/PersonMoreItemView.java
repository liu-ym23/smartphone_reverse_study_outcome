package com.bytedance.ee.bear.reminder.person;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
class PersonMoreItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f236490a;

    public PersonMoreItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public PersonMoreItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setPadding(n.d(4), 0, n.d(8), 0);
        LayoutInflater.from(getContext()).inflate(R.layout.reminder_person_more_item, this);
        this.f236490a = (TextView) findViewById(R.id.tv_reminder_person_more);
    }
}
