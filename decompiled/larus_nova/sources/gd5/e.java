package gd5;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressBar f480942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f480943b;

    public final void a() {
        setVisibility(8);
    }

    public e(Context r100) {
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.list_layout_new_message_tip, this);
        this.f480942a = (ProgressBar) findViewById(R.id.loading);
        this.f480943b = (ImageView) findViewById(R.id.state);
    }
}
