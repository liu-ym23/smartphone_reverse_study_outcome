package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SimpleDialogContentView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public TextView a;
    public TextView b;
    public View c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BtnOrientation {
    }

    public interface a {
    }

    public void setClickListener(a r1) {
    }

    static {
        com.bytedance.ee.util.ui.n.d(50);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131560229, this);
        this.a = (TextView) findViewById(2131367674);
        this.b = (TextView) findViewById(2131365135);
        TextView r0 = (TextView) findViewById(2131388920);
        TextView r1 = (TextView) findViewById(2131380021);
        this.c = findViewById(2131364713);
        this.a.setOnClickListener(new n(this));
        this.b.setOnClickListener(new o(this));
    }

    public SimpleDialogContentView(Context r1) {
        super(r1);
        a();
    }

    public SimpleDialogContentView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public SimpleDialogContentView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }
}
