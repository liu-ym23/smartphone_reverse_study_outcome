package ao5;

import com.bytedance.ee.bear.templates.TemplateShowCardType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends e {
    public final CharSequence a;

    @Override // ao5.e
    public final int getTemplateShowType() {
        return TemplateShowCardType.SHOW_CARD_TYPE_HEAD.ordinal();
    }

    public d(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.a = r2;
    }
}
