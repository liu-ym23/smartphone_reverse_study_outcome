package t19;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.common_ui.toast.ToastLayout;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f544165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ToastLayout f544166b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        FLogger.f375446a.i("ToastLogger", "action toast span clicked");
        this.f544165a.invoke();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(ContextCompat.getColor(this.f544166b.getContext(), v19.c.b(R.attr.larus_primary_50, this.f544166b.getContext(), R.color.larus_primary_50)));
        r100.setUnderlineText(false);
    }

    public a(u19.b r100, ToastLayout r101) {
        this.f544165a = r100;
        this.f544166b = r101;
    }
}
