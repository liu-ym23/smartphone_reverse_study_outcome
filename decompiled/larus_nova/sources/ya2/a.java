package ya2;

import android.text.InputFilter;
import android.text.Spanned;
import com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f567015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f567016b;

    public a(RoomNoticeBaseDialog.b r100) {
        this.f567016b = r100;
        this.f567015a = PatternProtector.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66);
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        Object r106 = null;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L12
        if (this.f567015a.matcher(r100).find() == false) goto L9;
        c r108 = this.f567016b;     // Catch: Throwable -> L12
        if (r108 == null) goto L8;
        r108.a();     // Catch: Throwable -> L12
    L8:
        String r109 = "";
    L10:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L12
    L15:
        if (Result.m9452exceptionOrNullimpl(r110) != null) goto L18;
        r106 = r110;
    L18:
        return (CharSequence) r106;
    L9:
        r109 = null;
    L12:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
