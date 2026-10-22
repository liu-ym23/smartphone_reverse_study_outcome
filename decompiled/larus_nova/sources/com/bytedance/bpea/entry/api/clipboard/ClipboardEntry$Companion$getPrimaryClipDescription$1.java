package com.bytedance.bpea.entry.api.clipboard;

import android.content.ClipDescription;
import android.content.ClipboardManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/content/ClipDescription;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class ClipboardEntry$Companion$getPrimaryClipDescription$1 extends Lambda implements Function0<ClipDescription> {
    final /* synthetic */ ClipboardManager $this_getPrimaryClipDescription;

    public ClipboardEntry$Companion$getPrimaryClipDescription$1(ClipboardManager r100) {
        this.$this_getPrimaryClipDescription = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ClipDescription invoke() {
        ClipboardManager r100 = this.$this_getPrimaryClipDescription;
        ArrayList r110 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        a r101 = ApiHookConfig.f245611b.get(101809);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r103[r105];
        int r113 = r105;
        int r114 = r104;
        f06.a[] r115 = r103;
        d r107 = r106.preInvoke(101809, "android/content/ClipboardManager", "getPrimaryClipDescription", r100, r111, "android.content.ClipDescription", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r110.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L20;
        return (ClipDescription) r107.f474983b;
    L20:
        return r100.getPrimaryClipDescription();
    L14:
        r105 = r113 + 1;
        r104 = r114;
        r103 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ClipDescription invoke() {
        return invoke();
    }
}
