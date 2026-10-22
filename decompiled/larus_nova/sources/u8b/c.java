package u8b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.conditional.access.utils.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f549192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f549193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f549194c;

    public interface a extends View.OnClickListener {
        void Vg(TextPaint r100);
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - this.f549194c) <= 500) goto L6;
        this.f549194c = r101;
        this.f549193b.onClick(r100);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        this.f549193b.Vg(r100);
        r100.setUnderlineText(false);
        r100.setColor(this.f549192a.getResources().getColor(R.color.primary_fill_default));
    }

    public c(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mCallback");
        this.f549192a = r100;
        this.f549193b = r101;
    }
}
