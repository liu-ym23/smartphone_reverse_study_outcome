package hi5;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class y extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f485341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f485342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f485343c;

    public interface a extends View.OnClickListener {
        void QF();
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - this.f485343c) <= 500) goto L8;
        this.f485343c = r101;
        a r102 = this.f485342b;
        if (r102 == null) goto L9;
        r102.onClick(r100);
        return;
    L9:
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        this.f485342b.QF();
        r100.setUnderlineText(false);
        r100.setColor(this.f485341a.getResources().getColor(R.color.text_link_normal));
    }

    public y(Context r100, a r101) {
        this.f485343c = 0;
        this.f485341a = r100;
        this.f485342b = r101;
    }
}
