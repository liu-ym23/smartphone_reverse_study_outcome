package uzb;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class h extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f552247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f552248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f552249c;

    public interface a extends View.OnClickListener {
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - this.f552249c) <= 500) goto L8;
        this.f552249c = r101;
        a r102 = this.f552248b;
        if (r102 == null) goto L9;
        ((i) r102).onClick(r100);
        return;
    L9:
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        this.f552248b.getClass();
        r100.setUnderlineText(false);
        r100.setColor(this.f552247a.getResources().getColor(R.color.primary_fill_default));
    }

    public h(FragmentActivity r100, i r101) {
        this.f552249c = 0;
        this.f552247a = r100;
        this.f552248b = r101;
    }
}
