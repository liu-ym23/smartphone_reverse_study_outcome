package com.ss.android.lark.chat.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatSizeUtils$enableCalendarOpt$2 extends Lambda implements Function0<Boolean> {
    public static final ChatSizeUtils$enableCalendarOpt$2 INSTANCE = null;

    static {
        INSTANCE = new ChatSizeUtils$enableCalendarOpt$2();
    }

    public ChatSizeUtils$enableCalendarOpt$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.productarch.navbar.calendar") == true) goto L5;
    L7:
        boolean r100 = false;
    L9:
        return Boolean.valueOf(r100);
    L5:
        if (ForsetiConfig.b() == false) goto L7;
        r100 = true;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
