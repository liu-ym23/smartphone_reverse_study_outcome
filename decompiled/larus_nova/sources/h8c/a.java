package h8c;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.utils.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f484299b;

    public a(String r100) {
        this.f484298a = r100;
        this.f484299b = R.color.text_link_normal;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r110) {
        Intrinsics.checkNotNullParameter(r110, "widget");
        String r100 = this.f484298a;
        if (r100 == null) goto L6;
        com.ss.android.lark.todo.impl.features.detail.a.d(com.ss.android.lark.todo.impl.features.detail.a.f442563a, r110.getContext(), r100, null, false, null, null, null, null, false, 504);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(i.f444291a.a(this.f484299b));
    }
}
