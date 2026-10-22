package u19;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.common_ui.toast.ToastLayout;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class c extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f548330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f548331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f548332f;

    @Override // u19.a
    public final void clear() {
        super.clear();
        this.f548331e = "";
        this.f548332f = null;
    }

    @Override // u19.e
    public final boolean b() {
        return this.f548330d;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, u19.b] */
    @Override // u19.a
    public final ToastLayout buildLayout(Context r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        ToastLayout r100 = new ToastLayout(v19.f.g(r110, r111));
        setToastLayout(r100);
        int r112 = getIconDrawableRes();
        CharSequence r101 = getText();
        CharSequence r102 = this.f548331e;
        ?? r103 = new b(this);
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "actionText");
        Intrinsics.checkNotNullParameter(r103, "onActionClick");
        ViewGroup.inflate(r100.getContext(), R.layout.larus_layout_toast_action, r100);
        r100.R5(r111);
        ((LottieAdapterView) r100.findViewById(R.id.lottieAdapterView)).setImageResource(r112);
        TextView r113 = (TextView) r100.findViewById(R.id.textView);
        SpannableStringBuilder r114 = new SpannableStringBuilder(r101);
        int r104 = StringsKt.indexOf$default(r114, r102.toString(), 0, false, 6, null);
        if (r104 >= 0) goto L13;
        FLogger.f375446a.w("ToastLogger", "action text missing from toast content, append as fallback");
        if (r114.length() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L10;
    L12:
        r104 = r114.length();
        r114.append(r102);
        goto L13
    L10:
        if (CharsKt.isWhitespace(StringsKt.last(r114)) == true) goto L12;
        r114.append(' ');
        goto L12
    L7:
        r105 = false;
    L13:
        r114.setSpan(new t19.a(r103, r100), r104, r102.length() + r104, 33);
        r113.setHighlightColor(0);
        r113.setMovementMethod(LinkMovementMethod.getInstance());
        r113.setText(r114);
        r100.setYOffsetPx(getToastYOffsetPx());
        return r100;
    }

    public c(int r100, CharSequence r101, CharSequence r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "actionText");
        Intrinsics.checkNotNullParameter(r103, "onActionClick");
        this.f548330d = true;
        this.f548331e = r102;
        this.f548332f = r103;
        icon(r100);
        text(r101);
    }
}
