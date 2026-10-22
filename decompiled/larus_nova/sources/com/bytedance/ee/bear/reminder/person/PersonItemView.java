package com.bytedance.ee.bear.reminder.person;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
class PersonItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f236489a;

    public PersonItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public PersonItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setPadding(0, 0, n.d(8), 0);
        LayoutInflater.from(getContext()).inflate(R.layout.reminder_person_item, this);
        this.f236489a = (ImageView) findViewById(R.id.iv_reminder_person);
    }
}
