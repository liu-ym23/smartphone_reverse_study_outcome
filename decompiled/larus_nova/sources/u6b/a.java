package u6b;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.core.graphics.ColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends CharacterStyle {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f548988b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f548989a;

    /* JADX INFO: renamed from: u6b.a$a, reason: collision with other inner class name */
    public static final class C7841a {
        @JvmStatic
        public static Spannable a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            SpannableString r101 = new SpannableString(r100);
            r101.setSpan(new a(), 0, r100.length(), 17);
            return r101;
        }
    }

    static {
    }

    public a() {
        this.f548989a = ColorUtils.setAlphaComponent(UIHelper.getColor(R.color.text_title), 128);
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        if (r100 == null) goto L5;
        r100.setColor(this.f548989a);
        return;
    }
}
