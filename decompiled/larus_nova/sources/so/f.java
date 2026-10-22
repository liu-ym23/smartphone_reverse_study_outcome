package so;

import android.view.View;
import androidx.core.provider.FontsContractCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.window.base.dynamicview.impl.widget.DynamicTextView;
import com.bytedance.android.shopping.extensions.k;
import com.google.gson.annotations.SerializedName;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class f extends com.bytedance.android.ec.window.base.dynamicview.renderer.a<DynamicTextView, a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f542697d = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lso/f$a;", "Lto/a;", "", "text", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "fontColor", "c", "", "fontWeight", "Ljava/lang/Float;", "e", "()Ljava/lang/Float;", "fontSize", "d", "", "maxLines", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends to.a {

        @SerializedName("font_color")
        private final String fontColor;

        @SerializedName("font_size")
        private final Float fontSize;

        @SerializedName(FontsContractCompat.Columns.WEIGHT)
        private final Float fontWeight;

        @SerializedName("max_lines")
        private final Integer maxLines;

        @SerializedName("text")
        private final String text;

        public final String c() {
            return this.fontColor;
        }

        public final Float d() {
            return this.fontSize;
        }

        public final Float e() {
            return this.fontWeight;
        }

        public final Integer f() {
            return this.maxLines;
        }

        public final String g() {
            return this.text;
        }
    }

    static {
        f542697d = new f();
    }

    public f() {
        super(DynamicTextView.class, a.class, "text");
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final void c(View r100) {
        DynamicTextView r101 = (DynamicTextView) r100;
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        r101.setText("");
        r101.setMaxLines(Integer.MAX_VALUE);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final to.a d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        return a(r100);
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.renderer.a
    public final void b(View r100, to.a r101) {
        DynamicTextView r102 = (DynamicTextView) r100;
        a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r102, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r103, "vo");
        String r104 = r103.g();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r102.setText(r104);
        String r105 = r103.c();
        Integer r106 = null;
        if (k.c(r105) == true) goto L10;
        r105 = null;
    L10:
        if (r105 == null) goto L12;
    L15:
        r102.setTextColor(s.a(r105, -15329245));
        Float r107 = r103.d();
        if (r107 == null) goto L18;
    L21:
        if (r107 == null) goto L23;
        r102.setTextSize(1, r107.floatValue());
    L23:
        Float r108 = r103.e();
        if (r108 == null) goto L26;
        r106 = Integer.valueOf((int) r108.floatValue());
    L26:
        if (r106 == null) goto L28;
    L31:
        if (r106 == null) goto L33;
        com.bytedance.android.shopping.extensions.f.e(r102, Integer.valueOf(r106.intValue()));
    L33:
        Integer r109 = r103.f();
        if (r109 == null) goto L37;
        r102.setMaxLines(r109.intValue());
        return;
    L37:
        return;
    L28:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == false) goto L31;
        goto L31
    L18:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == false) goto L21;
        goto L21
    L12:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L15;
        Integer.toString(-15329245, CharsKt.checkRadix(16));
        goto L15
    }
}
