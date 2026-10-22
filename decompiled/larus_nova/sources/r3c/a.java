package r3c;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.search.doubao.chat.empty.DoubaoSearchEmptyView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubaoSearchEmptyView f535973a;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    public a(DoubaoSearchEmptyView r100) {
        this.f535973a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        DoubaoSearchEmptyView r101 = this.f535973a;
        if (r101.f440060d != 4) goto L8;
        i4c.a.c r102 = r101.f440061e;
        if (r102 == null) goto L9;
        r102.onLoadCold();
        return;
    L9:
        return;
    }
}
