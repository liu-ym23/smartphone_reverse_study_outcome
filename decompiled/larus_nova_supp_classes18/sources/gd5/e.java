package gd5;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends RelativeLayout {
    public ProgressBar a;
    public ImageView b;

    public final void a() {
        setVisibility(8);
    }

    public e(Context r2) {
        super(r2);
        LayoutInflater.from(getContext()).inflate(2131563504, this);
        this.a = (ProgressBar) findViewById(2131378977);
        this.b = (ImageView) findViewById(2131387252);
    }
}
