package com.bytedance.bdp.appbase.strategy.sensitive;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 18})
final class SensitiveServiceHelper$storeHyperLinks$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $text;

    public SensitiveServiceHelper$storeHyperLinks$1(String r100) {
        this.$text = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        HashSet<String> r100 = a.f201047a;
        if (a.f201048b.f201064p == false) goto L16;
        HashSet<String> r101 = a.f201047a;
        monitor-enter(r101);
        Matcher r102 = Pattern.compile("https?://(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\.~#?&\\/\\/=]*)").matcher(this.$text);     // Catch: Throwable -> L13
    L8:
        if (r102.find() == false) goto L10;
        HashSet<String> r103 = a.f201047a;     // Catch: Throwable -> L13
        a.f201047a.add(r102.group());     // Catch: Throwable -> L13
        goto L8
    L10:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
