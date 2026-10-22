package ke8;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class b extends le8.a<he8.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f503040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ThreeLoadingIndicator f503041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f503042d;

    @Override // le8.a
    public final void b() {
        this.f508969a = null;
        ThreeLoadingIndicator r100 = this.f503041c;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f503041c = null;
        this.f503042d = null;
    }

    private final TextView getTextView() {
        return (TextView) this.f503040b.getValue();
    }

    public b(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f503040b = LazyKt.lazy(new a(r100));
        getTextView().setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        addView(getTextView());
        TextView r101 = getTextView();
        r101.setTextSize(0, we8.a.a(i5.t(), false));
        r101.setLineSpacing(0.0f, 1.1f);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
    L6:
        if (r103 == null) goto L9;
        r103.setMarginStart(c7.b(16));
        r103.setMarginEnd(c7.b(16));
        r103.bottomMargin = c7.b(12);
        r103.topMargin = c7.b(12);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // le8.b
    public final void a(ie8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        SpannableStringBuilder r101 = new SpannableStringBuilder("\u200b");
        ThreeLoadingIndicator r102 = this.f503041c;
        if (r102 != null) goto L5;
    L9:
        r102 = new ThreeLoadingIndicator(getTextView(), R.drawable.larus_chat_common_loading_dot, getTextView().getContext(), null);
    L10:
        this.f503041c = r102;
        this.f503042d = Boolean.FALSE;
        Iterator<T> r103 = r102.f304930b.iterator();
    L11:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L23;
        v0 r105 = (v0) r103.next();
        if (r105 == null) goto L19;
        Drawable r106 = r105.getDrawable();
        if (r106 == null) goto L19;
        int r107 = (int) (i5.r0() * 1.0f);
        r106.setBounds(0, 0, r107, r107);
    L19:
        if (r101.length() == 0) goto L22;
        r104 = false;
    L22:
        r105.f305284f = r104;
        r101.append("⚫", r105, 17);
        goto L11
    L23:
        r102.b(true);
        r102.d();
        getTextView().setText(r101);
        return;
    L5:
        if (Intrinsics.areEqual(this.f503042d, Boolean.FALSE) == true) goto L8;
        r102 = null;
    L8:
        if (r102 != null) goto L10;
        goto L9
    }
}
