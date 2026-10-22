package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes16.dex */
public class SimpleDialogContentView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f225961d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f225962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f225963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f225964c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BtnOrientation {
    }

    public interface a {
    }

    public void setClickListener(a r100) {
    }

    static {
        com.bytedance.ee.util.ui.n.d(50);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.drive_simple_dialog_content_view, this);
        this.f225962a = (TextView) findViewById(R.id.confirm_tv);
        this.f225963b = (TextView) findViewById(R.id.cancel_tv);
        TextView r100 = (TextView) findViewById(R.id.title_tv);
        TextView r101 = (TextView) findViewById(R.id.message_tv);
        this.f225964c = findViewById(R.id.btn_divider_view);
        this.f225962a.setOnClickListener(new n(this));
        this.f225963b.setOnClickListener(new o(this));
    }

    public SimpleDialogContentView(Context r100) {
        super(r100);
        a();
    }

    public SimpleDialogContentView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public SimpleDialogContentView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
