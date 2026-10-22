package com.larus.larkfeed.impl.lark.holder.content;

import android.view.View;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.im.bean.message.Message;
import com.larus.larkfeed.impl.lark.holder.content.longpress.DouBaoMenuScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class s implements kc8.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f355410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DouBaoBlockContent f355411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DouBaoMenuScene f355412c;

    @Override // kc8.z
    public final void a(View r100) {
    }

    public s(View r100, DouBaoBlockContent r101, DouBaoMenuScene r102) {
        this.f355410a = r100;
        this.f355411b = r101;
        this.f355412c = r102;
    }

    @Override // kc8.z
    public final void b(View r100, st8.a r101, LongClickSource r102) {
        Intrinsics.checkNotNullParameter(r102, "longClickSource");
        Object r103 = this.f355410a.getTag();
        com.larus.larkfeed.impl.lark.holder.content.longpress.c.C4398c r104 = null;
        Message r105 = null;
        if ((r103 instanceof DouBaoBlockContent.a) == false) goto L5;
        DouBaoBlockContent.a r106 = (DouBaoBlockContent.a) r103;
    L6:
        DouBaoBlockContent r107 = this.f355411b;
        DouBaoMenuScene r108 = this.f355412c;
        r107.getClass();
        DouBaoMenuScene r109 = DouBaoMenuScene.GENERIC_CARD;
        if (r108 != r109) goto L18;
        if (r100 != null) goto L16;
        if (r101 != null) goto L16;
        if (DouBaoBlockContent.j(r106) == false) goto L15;
        r108 = DouBaoMenuScene.MUSIC_CARD;
        goto L18
    L15:
        r108 = r109;
    L16:
        r108 = DouBaoMenuScene.TEXT;
    L18:
        if (r108 == DouBaoMenuScene.TEXT) goto L20;
    L23:
        int r110 = com.larus.larkfeed.impl.lark.holder.content.longpress.f.f355384a;
        com.larus.larkfeed.impl.lark.holder.content.longpress.f.a(r106, r108, r104);
        return;
    L20:
        if (r106 == null) goto L22;
        r105 = r106.f355339a;
    L22:
        r104 = new com.larus.larkfeed.impl.lark.holder.content.longpress.c.C4398c(r102, r105);
        goto L23
    L5:
        r106 = null;
        goto L6
    }
}
