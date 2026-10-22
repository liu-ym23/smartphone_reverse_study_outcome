package com.ss.android.update;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes40.dex */
public class UpdateContentLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f455213a;

    public UpdateContentLinearLayout(Context r100) {
        this(r100, null);
    }

    public final void a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f455213a.setText(r100);
        return;
    }

    public UpdateContentLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.update_content_layout, this);
        this.f455213a = (TextView) findViewById(R.id.update_check_description);
    }
}
