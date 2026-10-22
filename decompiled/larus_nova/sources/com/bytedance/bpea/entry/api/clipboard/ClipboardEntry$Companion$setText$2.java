package com.bytedance.bpea.entry.api.clipboard;

import android.text.ClipboardManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class ClipboardEntry$Companion$setText$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CharSequence $text;
    final /* synthetic */ ClipboardManager $this_setText;

    public ClipboardEntry$Companion$setText$2(ClipboardManager r100, CharSequence r101) {
        this.$this_setText = r100;
        this.$text = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ClipboardManager r100 = this.$this_setText;
        CharSequence r110 = this.$text;
        ArrayList r111 = new ArrayList();
        Object[] r112 = {r110};
        b r113 = new b();
        a r101 = ApiHookConfig.f245611b.get(101812);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r114 = r105;
        int r115 = r104;
        f06.a[] r210 = r103;
        d r107 = r106.preInvoke(101812, "android/text/ClipboardManager", "setText", r100, r112, "void", r113);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r111.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == true) goto L27;
        r100.setText(r110);
        return;
    L27:
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        r103 = r210;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
