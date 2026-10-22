package com.ss.android.photoeditor.graffiti;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.larus.nova.R;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes38.dex */
public class ShowTipsSeekBarLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatSeekBar f449213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f449214b;

    public class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekBar.OnSeekBarChangeListener f449215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShowTipsSeekBarLinearLayout f449216b;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            this.f449216b.f449214b.setVisibility(0);
            SeekBar.OnSeekBarChangeListener r101 = this.f449215a;
            if (r101 == null) goto L6;
            r101.onStartTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            this.f449216b.invalidate();
            this.f449216b.f449214b.setVisibility(4);
            SeekBar.OnSeekBarChangeListener r101 = this.f449215a;
            if (r101 == null) goto L6;
            r101.onStopTrackingTouch(r100);
            return;
        }

        public a(ShowTipsSeekBarLinearLayout r100, SeekBar.OnSeekBarChangeListener r101) {
            this.f449216b = r100;
            this.f449215a = r101;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            int r103 = r101 - 50;
            String r104 = String.valueOf(r103);
            if (r103 <= 0) goto L5;
            r104 = Marker.ANY_NON_NULL_MARKER + r104;
        L5:
            this.f449216b.f449214b.setText(r104);
            ShowTipsSeekBarLinearLayout r105 = this.f449216b;
            float r106 = r105.f449213a.getPaddingLeft();
            float r107 = ((r105.f449213a.getLeft() + r106) + (((r105.f449213a.getWidth() - (r106 * 2.0f)) / 100.0f) * r101)) - (r105.f449214b.getWidth() / 2.0f);
            float r108 = (r105.f449213a.getTop() - r105.f449214b.getHeight()) - com.ss.android.photoeditor.util.d.b(4);
            RelativeLayout.LayoutParams r109 = (RelativeLayout.LayoutParams) r105.f449214b.getLayoutParams();
            r109.leftMargin = (int) r107;
            r109.topMargin = (int) r108;
            r105.f449214b.setLayoutParams(r109);
            this.f449216b.invalidate();
            SeekBar.OnSeekBarChangeListener r110 = this.f449215a;
            if (r110 == null) goto L9;
            r110.onProgressChanged(r100, r101, r102);
            return;
        }
    }

    public final void a() {
        LinearLayout.inflate(getContext(), R.layout.view_photo_editor_graffiti_showtips_seekbar, this);
        this.f449214b = (TextView) findViewById(R.id.tv_tips);
        this.f449213a = (AppCompatSeekBar) findViewById(R.id.seek_bar_paint_size);
    }

    public ShowTipsSeekBarLinearLayout(Context r100) {
        super(r100);
        a();
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r100) {
        this.f449213a.setOnSeekBarChangeListener(new a(this, r100));
    }

    public void setProgress(int r100) {
        this.f449213a.setProgress(r100);
    }

    public ShowTipsSeekBarLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public ShowTipsSeekBarLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
