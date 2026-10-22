package com.ss.android.lark.statistics.translate;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import o5c.b;
import s5c.d;

/* JADX INFO: loaded from: classes38.dex */
public final class TranslateHitPoint extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TranslateHitPoint f440776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f440777b = null;

    static {
        f440776a = new TranslateHitPoint();
        f440777b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TranslateHitPoint$statistics$2.INSTANCE);
    }

    public final b a() {
        return (b) f440777b.getValue();
    }

    public TranslateHitPoint() {
    }

    public final void b(s5c.a r100, s5c.a r101, s5c.a r102, s5c.a r103, s5c.a r104, s5c.a r105, s5c.a r106) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "chatType");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r103, "targetLanguage");
        Intrinsics.checkNotNullParameter(r104, "messageLanguage");
        Intrinsics.checkNotNullParameter(r105, "click");
        Intrinsics.checkNotNullParameter(r106, PickerReporterConstants.KEY.TARGET);
        d r107 = d.b.b(r100, r101).plus(r102).plus(r103).plus(r104).plus(r105).plus(r106);
        a().sendEvent("asl_crosslang_translation_im_sub_click", r107.toJson());
    }
}
