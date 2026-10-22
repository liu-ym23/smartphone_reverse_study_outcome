package com.bytedance.awemeopen.apps.framework.feed.ui.information.music.title;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.x;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends BaseElement<g, h, tz3.a, jz3.a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f196203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f196204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f196205i;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new g();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new h();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new f(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        a r100 = this.f196204h;
        if (r100 == null) goto L5;
        this.f196203g.removePlayStateListener(r100);
    L5:
        this.f196204h = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        h().f196211a.b(Boolean.TRUE);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        h().f196211a.b(Boolean.FALSE);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.f196027k;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r110) {
        jz3.a r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "data");
        this.f196205i = r111.f501173a.c();
        int r100 = x.f197748a;
        Context r101 = getContext();
        e24.b r102 = r111.f501173a.z();
        User r103 = r111.f501173a.f();
        r14.c r112 = r111.f501173a;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, ShareChannel.DOUYIN);
        boolean r104 = true;
        String r105 = "";
        if (r102 != null) goto L5;
        Resources r113 = r101.getResources();
        Object[] r106 = new Object[2];
        r106[0] = r101.getResources().getString(R.string.aos_music_info_default);
        if (r103 != null) goto L39;
        String r107 = "";
    L40:
        r106[1] = r107;
        String r114 = r113.getString(R.string.aos_music_title, r106);
    L41:
        if (r114 == null) goto L45;
        r105 = r114;
    L45:
        if (r105.length() == 0) goto L48;
        r104 = false;
    L48:
        if (r104 == false) goto L50;
    L63:
        j();
        return;
    L50:
        if (this.f196203g.getPageConfig().isTeenagerModel() == true) goto L63;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f195993e == false) goto L56;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f195995g == false) goto L63;
    L56:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f195996h == true) goto L63;
        if (Intrinsics.areEqual(this.f196203g.getPageConfig().getEnterFrom(), "volc_agent_card") == true) goto L63;
        p();
        h r115 = h();
        r115.getClass();
        Intrinsics.checkNotNullParameter(r105, "title");
        r115.f196213c.b(r105);
        if (this.f196204h != null) goto L65;
        a r116 = new a(this);
        this.f196203g.addPlayStateListener(r116);
        this.f196204h = r116;
        return;
    L65:
        return;
    L39:
        r107 = r103.t();
        goto L40
    L5:
        if (TextUtils.isEmpty(r112.A()) == true) goto L9;
        r114 = r112.A();
        if (r114 != null) goto L41;
        r114 = "";
        goto L41
    L9:
        t14.a r108 = r102.g();
        String r109 = null;
        if (r108 == null) goto L12;
        List<String> r117 = r108.g();
    L14:
        if (r112.S() == false) goto L16;
    L35:
        r114 = r101.getResources().getString(R.string.aos_music_title_with_music, new Object[]{r102.d(), r102.a()});
        goto L41
    L16:
        if (r102.c() == null) goto L35;
        e24.a r118 = r102.c();
        if (r118 == null) goto L20;
        String r119 = r118.a();
    L22:
        if (TextUtils.isEmpty(r119) == true) goto L35;
        if (r102.e() == 0) goto L35;
        if (r117 == null) goto L35;
        if (r117.size() <= 0) goto L35;
        if (r103 == null) goto L35;
        if (r103.P() == true) goto L35;
        StringBuilder r120 = new StringBuilder();
        r120.append(r101.getResources().getString(R.string.aos_music_title_with_music, new Object[]{r102.d(), r102.a()}));
        r120.append(65288);
        r120.append(r101.getResources().getString(R.string.aos_sound_title_origin));
        r120.append(65306);
        e24.a r121 = r102.c();
        if (r121 == null) goto L34;
        r109 = r121.a();
    L34:
        r120.append(r109);
        r120.append(65289);
        r114 = r120.toString();
        goto L41
    L20:
        r119 = null;
        goto L22
    L12:
        r117 = null;
        goto L14
    }

    public b(Context r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vm");
        super(r100);
        this.f196203g = r101;
    }
}
