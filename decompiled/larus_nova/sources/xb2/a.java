package xb2;

import android.graphics.drawable.Drawable;
import android.text.style.CharacterStyle;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tb2.c;
import tb2.g;
import wb2.h;
import wb2.i;
import wb2.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements e {

    /* JADX INFO: renamed from: xb2.a$a, reason: collision with other inner class name */
    public static final class C8210a implements tb2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tb2.b f563105a;

        public C8210a(tb2.b r100) {
            this.f563105a = r100;
        }

        @Override // tb2.e
        public final m6 a() {
            return ((tb2.e) this.f563105a).a();
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.e
    public final List<CharacterStyle> a(c r100, Drawable r101) {
        Intrinsics.checkNotNullParameter(r100, "renderPiece");
        tb2.b r102 = r100.getClickAction();
        if (r102 == null) goto L12;
        ArrayList r103 = new ArrayList();
        if ((r102 instanceof tb2.e) == false) goto L8;
        r103.add(new i(new C8210a(r102)));
    L11:
        return r103;
    L8:
        if ((r102 instanceof g) == false) goto L10;
        r103.add(new k((g) r102));
        goto L11
    L10:
        r103.add(new h(r102));
        goto L11
    L12:
        return null;
    }
}
