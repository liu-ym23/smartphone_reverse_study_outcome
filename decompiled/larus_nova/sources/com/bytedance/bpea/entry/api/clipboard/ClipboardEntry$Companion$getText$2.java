package com.bytedance.bpea.entry.api.clipboard;

import android.text.ClipboardManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import f06.b;
import f06.c;
import f06.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class ClipboardEntry$Companion$getText$2 extends Lambda implements Function0<CharSequence> {
    final /* synthetic */ ClipboardManager $this_getText;

    public ClipboardEntry$Companion$getText$2(ClipboardManager r100) {
        this.$this_getText = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CharSequence invoke() {
        ClipboardManager r100 = this.$this_getText;
        c r101 = new c();
        Object[] r110 = new Object[0];
        b r111 = new b();
        d r112 = r101.b(101810, "android/text/ClipboardManager", "getText", r100, r110, "java.lang.CharSequence", r111);
        if (r112.f474982a == false) goto L5;
        r101.a(101810, "android/text/ClipboardManager", "getText", r100, r110, null, r111, false);
        return (CharSequence) r112.f474983b;
    L5:
        CharSequence r113 = r100.getText();
        r101.a(101810, "android/text/ClipboardManager", "getText", r100, r110, r113, r111, true);
        return r113;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CharSequence invoke() {
        return invoke();
    }
}
