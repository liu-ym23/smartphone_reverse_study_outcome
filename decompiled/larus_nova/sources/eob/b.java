package eob;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473411a;

    public static final class a {
    }

    static {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f473411a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        KeyboardBaseModule.a().openUrl(r100.getContext(), this.f473411a, IOfflineExtraParser.ParserType.TODO);
    }
}
