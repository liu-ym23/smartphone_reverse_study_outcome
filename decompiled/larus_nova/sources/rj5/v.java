package rj5;

import android.os.Bundle;
import android.view.View;
import com.larus.nova.R;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v extends com.bytedance.ee.bear.more.protocol3.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.a f538115c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f538116a;

        public b(v r100) {
            this.f538116a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            v r100 = this.f538116a;
            r100.getHost().a();
            r100.f538115c.b();
            oj5.c r101 = r100.c();
            if (r101 == null) goto L6;
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new com.bytedance.ee.bear.more.i(new Bundle(), r101.getToken(), r101.getType(), r101.isShareFolder(), r101.b(), "My_AI", "none", "", "", r101 instanceof oj5.f, r101.m(), r101.H(), r101.isOwner(), r101.L()));
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        return com.bytedance.ee.bear.more.protocol3.g.i(this, new com.bytedance.ee.bear.more.protocol3.f.x(new com.bytedance.ee.bear.more.protocol3.d(R.string.LarkCCM_MyAi_FayeFallBack_aiName_Common, R.drawable.ud_icon_myai_colorful, R.color.lkui_transparent, e(R.string.LarkCCM_Docs_DocsAi_Menu))), new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false), CollectionsKt.listOf(new w(this)), null, new b(this), 8);
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b
    public final void create() {
        oj5.c r100 = c();
        if (r100 == null) goto L6;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).K(new com.bytedance.ee.bear.more.j(r100.getToken(), r100.getType(), r100.b(), r100 instanceof oj5.f, r100.m(), r100.isOwner(), r100.L()));
        return;
    }

    public v(com.bytedance.ee.bear.more.a r100) {
        Intrinsics.checkNotNullParameter(r100, "aiItemAbility");
        this.f538115c = r100;
    }
}
