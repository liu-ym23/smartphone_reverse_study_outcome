package jk6;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.bytedance.live.richcontent.engine.SpanRendClient;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements ik6.c {
    public c() {
    }

    @Override // ik6.c
    public final void a(SpanRendClient r100, ik6.d r101) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, "rendItem");
        gk6.a r102 = r101.f490269a.f472944b;
        if (r102 == null) goto L29;
        ArrayList r103 = new ArrayList();
        Integer r104 = r102.f481544a;
        if (r104 == null) goto L8;
        int r105 = r104.intValue();
        int r106 = com.bytedance.live.richcontent.utils.b.f255804a;
        r103.add(new ForegroundColorSpan(r105));
    L8:
        if (r102.f481547d == false) goto L11;
        int r107 = com.bytedance.live.richcontent.utils.b.f255804a;
        r103.add(new StyleSpan(1));
    L11:
        if (r102.f481548e == false) goto L14;
        int r108 = com.bytedance.live.richcontent.utils.b.f255804a;
        r103.add(new StyleSpan(2));
    L14:
        if (r102.f481549f == false) goto L16;
        int r109 = com.bytedance.live.richcontent.utils.b.f255804a;
        r103.add(new UnderlineSpan());
    L16:
        Integer r110 = r102.f481545b;
        if (r110 == null) goto L23;
        int r111 = r110.intValue();
        Boolean r112 = r102.f481546c;
        if (r112 == null) goto L21;
        boolean r113 = r112.booleanValue();
    L22:
        int r114 = com.bytedance.live.richcontent.utils.b.f255804a;
        r103.add(new AbsoluteSizeSpan(r111, r113));
        goto L23
    L21:
        r113 = false;
    L23:
        Iterator r115 = r103.iterator();
    L25:
        if (r115.hasNext() == false) goto L35;
        CharacterStyle r116 = (CharacterStyle) r115.next();
        Intrinsics.checkNotNullParameter(r116, "span");
        SpannableString r117 = r101.f490271c;
        if (r117 == null) goto L25;
        r117.setSpan(r116, 0, r117.length(), 33);
        goto L25
    L35:
        return;
    }
}
