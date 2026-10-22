package n7b;

import android.os.CountDownTimer;
import com.ss.android.lark.chatwindow.view.burn.CountDownView;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f518232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownView f518233b;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        CountDownView r100 = this.f518233b;
        int r101 = CountDownView.f416991c;
        r100.getClass();
        this.f518233b.f416993b = false;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r100) {
        CountDownView r101 = this.f518233b;
        int r102 = CountDownView.f416991c;
        r101.getClass();
        if (r100 == this.f518232a) goto L6;
        CountDownView r103 = this.f518233b;
        r103.getClass();
        r103.setText(CountDownView.x(r100));
        this.f518232a = r100;
        return;
    }

    public a(CountDownView r100, long r101) {
        this.f518233b = r100;
        super(r101, 0);
        this.f518232a = -1;
    }
}
