package mp2;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.f;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f514700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f514701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f514702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f514703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f514704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f514705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f514706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f514707h;

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        f.d().f();
    }

    public a(Context r100) {
        super(r100, R.style.ttlive_live_dialog);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_room_quit_layout, null);
        this.f514704e = r101;
        setContentView(r101);
        LinearLayout r102 = (LinearLayout) r101.findViewById(R.id.dialog_room_quit_layout);
        this.f514707h = r102;
        r102.setVisibility(4);
        this.f514700a = (RelativeLayout) r101.findViewById(R.id.top_image_container);
        this.f514701b = (HSImageView) r101.findViewById(R.id.image_left);
        this.f514702c = (HSImageView) r101.findViewById(R.id.image_middle);
        this.f514703d = (HSImageView) r101.findViewById(R.id.image_right);
        this.f514705f = (TextView) r101.findViewById(R.id.room_quit_button_left);
        this.f514706g = (TextView) r101.findViewById(R.id.room_quit_button_right);
    }
}
