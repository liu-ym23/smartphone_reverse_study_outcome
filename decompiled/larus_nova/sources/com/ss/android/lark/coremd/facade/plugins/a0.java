package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class a0 extends IMMarkdownParsePlugin {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f419777b = null;

    static {
        f419777b = new a0();
    }

    @Override // com.ss.android.lark.coremd.facade.plugins.IMMarkdownParsePlugin, com.ss.android.lark.coremd.base.parse.h
    public final List<com.ss.android.lark.coremd.base.parse.g> e() {
        List<com.ss.android.lark.coremd.base.parse.g> r100 = this.f419775a;
        Map<ImExtensionType, List<Class<?>>> r101 = com.ss.android.lark.im.base.d.f425883a;
        List r102 = com.ss.android.lark.im.base.d.b(ImExtensionType.MESSAGE_RICH_TEXT_PARSER, com.ss.android.lark.biz.im.api.extension.message.h.class);
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        CollectionsKt.addAll(r103, ((com.ss.android.lark.biz.im.api.extension.message.h) r104.next()).a());
        goto L4
    L7:
        return CollectionsKt.plus(r100, r103);
    }

    public a0() {
    }
}
