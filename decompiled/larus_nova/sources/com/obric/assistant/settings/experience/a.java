package com.obric.assistant.settings.experience;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: com.obric.assistant.settings.experience.a$a, reason: collision with other inner class name */
    public static final class C4625a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f392046a;

        public C4625a(int r100) {
            this.f392046a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            i r101 = SmartRouter.buildRoute(r100.getContext(), "//flow/webview");
            r101.f267554c.putExtra("link_url", "https://os.obriccloud.com/agreement/ux_improvement_plan");
            r101.d();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setColor(this.f392046a);
            r100.setUnderlineText(false);
        }
    }

    public static final CharSequence a(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r100.getString(r101);
        String r104 = r100.getString(R.string.obric_user_experience_plan_link);
        int r105 = StringsKt.indexOf$default(r103, r104, 0, false, 6, null);
        if (r105 >= 0) goto L5;
        return r103;
    L5:
        int r106 = ContextCompat.getColor(r100, r102);
        SpannableString r107 = new SpannableString(r103);
        r107.setSpan(new C4625a(r106), r105, r104.length() + r105, 33);
        return r107;
    }
}
