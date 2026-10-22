package com.ss.android.lark.todo.impl.features.common.helper;

import android.content.Context;
import android.widget.TextView;
import com.larksuite.component.ui.tag.LarkNameTag;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.todo.impl.utils.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f442449a = 0;

    static {
    }

    public static void a(TextView r100, TagData r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (r101 == null) goto L5;
        int r102 = l.f444294a;
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "tagData");
        int r103 = LarkNameTag.f284333d;
        Context r104 = r100.getContext();
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarkNameTag.e r105 = new LarkNameTag.e(r104);
        TagData.Companion.getClass();
        r105.g(TagData.a.b(r101));
        r105.f().c(r100);
        return;
    L5:
        int r106 = l.f444294a;
        Intrinsics.checkNotNullParameter(r100, "textView");
        r100.setCompoundDrawables(null, null, null, null);
    }
}
