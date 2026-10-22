package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremdbiz.facade.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f412476a = 0;

    static {
    }

    public static boolean b(RichText r100) {
        Intrinsics.checkNotNullParameter(r100, "richText");
        List<String> r101 = r100.getMarkdownIds();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L18;
        List<String> r103 = r100.getAnchorIds();
        if (r103 == null) goto L13;
        int r104 = r103.size();
    L15:
        if (r104 < 100) goto L19;
        return true;
    L19:
        return false;
    L13:
        r104 = 0;
        goto L15
    L18:
        return false;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static n a(RichText r210, n r211) {
        Intrinsics.checkNotNullParameter(r210, "richText");
        Intrinsics.checkNotNullParameter(r211, "config");
        if (p.a() == true) goto L5;
        return r211;
    L5:
        if (b(r210) == false) goto L10;
        com.ss.android.lark.coremd.base.parse.b r100 = r211.f412532f.clone();
        com.ss.android.lark.widget.light.layout.h r101 = r211.f412534h;
        Context r110 = r101.f446159a;
        int r111 = r101.f446160b;
        boolean r112 = r101.f446161c;
        boolean r113 = r101.f446162d;
        com.ss.android.lark.widget.light.viewstub.f r114 = r101.f446163e;
        int r115 = r101.f446164f;
        float r102 = r101.f446165g;
        int r103 = r101.f446166h;
        Layout.Alignment r104 = r101.f446167i;
        float r105 = r101.f446168j;
        float r106 = r101.f446169k;
        boolean r107 = r101.f446170l;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, "spanViewCoordinator");
        Intrinsics.checkNotNullParameter(r104, "textAlignment");
        com.ss.android.lark.widget.light.layout.h r108 = new com.ss.android.lark.widget.light.layout.h(r110, r111, r112, r113, r114, r115, r102, r103, r104, r105, r106, r107, false);
        Context r109 = r211.f412527a;
        String r116 = r211.f412528b;
        com.ss.android.lark.richtextmd.parse.ext.b r117 = r211.f412529c;
        List<? extends com.ss.android.lark.coremd.base.parse.g> r118 = r211.f412530d;
        j r119 = r211.f412531e;
        List<? extends com.ss.android.lark.coremd.base.parse.f> r120 = r211.f412533g;
        Intrinsics.checkNotNullParameter(r109, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r116, "uniqueId");
        Intrinsics.checkNotNullParameter(r117, "richTextParseConfig");
        Intrinsics.checkNotNullParameter(r118, "markdownPlugins");
        Intrinsics.checkNotNullParameter(r119, "markdownTheme");
        Intrinsics.checkNotNullParameter(r100, "markdownContext");
        Intrinsics.checkNotNullParameter(r120, "parseListeners");
        Intrinsics.checkNotNullParameter(r108, "textLayoutBuildConfig");
        return new n(r109, r116, r117, r118, r119, r100, r120, r108);
    L10:
        return r211;
    }
}
