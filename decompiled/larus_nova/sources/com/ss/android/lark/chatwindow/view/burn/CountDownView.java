package com.ss.android.lark.chatwindow.view.burn;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;

/* JADX INFO: loaded from: classes35.dex */
public class CountDownView extends AppCompatTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f416991c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CountDownTimer f416992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f416993b;

    public interface a {
    }

    public void setOnCountDownListener(a r100) {
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f416993b == true) goto L5;
        return;
    L5:
        if (0 > SystemClock.elapsedRealtime()) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L10;
        this.f416993b = false;
        return;
    L10:
        this.f416993b = false;
        CountDownTimer r101 = this.f416992a;
        if (r101 == null) goto L13;
        r101.cancel();
        this.f416992a = null;
    L13:
        this.f416993b = true;
        long r102 = 0 - SystemClock.elapsedRealtime();
        setText(x(r102));
        this.f416992a = new n7b.a(this, r102).start();
        return;
    L7:
        r100 = false;
        goto L8
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer r100 = this.f416992a;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f416992a = null;
        return;
    }

    public CountDownView(Context r100) {
        this(r100, null);
    }

    public static String x(long r100) {
        int r101 = (int) Math.round((r100 * 1.0d) / 1000.0d);
        int r102 = r101 / 86400;
        int r103 = r101 % 86400;
        int r104 = r103 / AnnouncementViewModel.HOUR_DURATION;
        int r105 = r103 % AnnouncementViewModel.HOUR_DURATION;
        int r106 = r105 / 60;
        int r107 = r105 % 60;
        if (r102 <= 0) goto L7;
        return String.format("%dd:%02dh:%02dm", new Object[]{Integer.valueOf(r102), Integer.valueOf(r104), Integer.valueOf(r106)});
    L7:
        return String.format("%02dh:%02dm:%02ds", new Object[]{Integer.valueOf(r104), Integer.valueOf(r106), Integer.valueOf(r107)});
    }

    public CountDownView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CountDownView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setMinimumWidth((int) getPaint().measureText(x(0)));
    }
}
