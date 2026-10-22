package i4c;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.utils.y0;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f488244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f488245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f488246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f488247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f488248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f488249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f488250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f488251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f488252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f488253j;

    /* JADX INFO: renamed from: i4c.a$a, reason: collision with other inner class name */
    public static final class C6229a {
    }

    public interface b {
        boolean a();
    }

    public interface c {
        String a();

        void b();

        void onLoadCold();
    }

    public static final class d extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f488254a;

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
        }

        public d(a r100) {
            this.f488254a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            a r101 = this.f488254a;
            if (r101.f488248e != 4) goto L8;
            c r102 = r101.f488253j;
            if (r102 == null) goto L9;
            r102.onLoadCold();
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f488244a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f488244a = r100;
        this.f488249f = true;
        this.f488251h = r100.getResources().getString(R.string.Lark_Legacy_Noresult);
        this.f488252i = -1;
    }

    public final void b(String r100, TextView r101) {
        String r102 = TextUtils.ellipsize(r100, r101.getPaint(), this.f488250g, TextUtils.TruncateAt.MIDDLE).toString();
        String r103 = UIHelper.mustacheFormat(this.f488251h, Keys.API_PARAM_KEY_SEARCH_KEY, r102);
        int r104 = this.f488252i;
        if (r104 == (-1)) goto L5;
        int r105 = r104 + r102.length();
        CharSequence r106 = y0.b(r103, this.f488252i, r105, r102, UIHelper.getColor(R.color.primary_fill_default));
        Intrinsics.checkNotNull(r106);
        r101.setText(a(r106, this.f488252i, r105));
        return;
    L5:
        r101.setText(r103);
    }

    public final CharSequence a(CharSequence r100, int r101, int r102) {
        SpannableStringBuilder r103 = new SpannableStringBuilder(r100);
        r103.setSpan(new d(this), r101, r102, 33);
        TextView r104 = this.f488246c;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r104 = null;
    L5:
        r104.setMovementMethod(LinkMovementMethod.getInstance());
        return r103;
    }
}
