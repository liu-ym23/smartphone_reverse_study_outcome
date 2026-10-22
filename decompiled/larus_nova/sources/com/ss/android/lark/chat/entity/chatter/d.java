package com.ss.android.lark.chat.entity.chatter;

import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.tag.f;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {
    @Deprecated(message = "扩展方法在Java中调用可读性很差...", replaceWith = @ReplaceWith(expression = "TagInfo::apply", imports = {}))
    public static final void a(LarkNameTag.c r100, TagInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "tagInfo");
        int r102 = f.f284457g;
        f.a r103 = new f.a();
        r103.f284465b = r101.getType().getOrder();
        r103.f284467d = r101.getText();
        r103.f284468e = r101.getType().getTextColor();
        r103.f284470g = r101.getType().getBgColor();
        r100.d(new f(r103), true);
    }
}
