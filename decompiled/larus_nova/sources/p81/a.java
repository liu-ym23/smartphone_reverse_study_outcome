package p81;

import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.android.live.room.api.view.SimpleIndicatorTextSwitcher2;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements ViewSwitcher.ViewFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleIndicatorTextSwitcher2 f528061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f528062b;

    /* JADX INFO: renamed from: p81.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7159a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f528063a;

        public ViewOnClickListenerC7159a(a r100) {
            this.f528063a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SimpleIndicatorTextSwitcher2 r101 = this.f528063a.f528061a;
            d r102 = (d) ListProtector.get(r101.f99156b, r101.getCurrentIndex());
            if (r102 == null) goto L8;
            View.OnClickListener r103 = r102.f528068b;
            if (r103 == null) goto L9;
            r103.onClick(r100);
            return;
        L9:
            return;
        }
    }

    public a(SimpleIndicatorTextSwitcher2 r100, String r101) {
        this.f528061a = r100;
        this.f528062b = r101;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public final View makeView() {
        TextView r100 = new TextView(this.f528061a.getContext());
        r100.setSingleLine(true);
        r100.setLines(1);
        r100.setSingleLine();
        r100.setText(this.f528062b);
        this.f528061a.f99155a.getClass();
        r100.setTextSize(1, 13.0f);
        this.f528061a.f99155a.getClass();
        r100.setTextColor(-1);
        r100.setGravity(this.f528061a.f99155a.f528069a);
        r100.setIncludeFontPadding(false);
        r100.setOnClickListener(new ViewOnClickListenerC7159a(this));
        return r100;
    }
}
