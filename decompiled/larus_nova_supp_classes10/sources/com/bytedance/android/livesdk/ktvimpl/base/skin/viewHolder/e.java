package com.bytedance.android.livesdk.ktvimpl.base.skin.viewHolder;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Runnable {
    public final /* synthetic */ KtvMidiSkinViewBinder.KtvMidiSkinViewHolder a;
    public final /* synthetic */ List b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Boolean d;
    public final /* synthetic */ String e;

    public e(KtvMidiSkinViewBinder.KtvMidiSkinViewHolder r1, List r2, String r3, Boolean r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        if (((RecyclerView.ViewHolder) this.a).itemView.isShown() == false) goto L22;
        String r0 = this.c;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L23;
        List r2 = this.b;
        if (r2 != null) goto L15;
    L16:
        this.a.e.c.a("midi", this.c);
        Long r3 = KtvLoggerHelper.a;
        if (Intrinsics.areEqual(this.d, Boolean.FALSE) == false) goto L19;
        String r4 = BDLocationException.ERROR_TIMEOUT;
    L20:
        KtvLoggerHelper.V("", "", "midi", r4, this.e, 32);
        return;
    L19:
        r4 = "1";
        goto L20
    L15:
        if (r2.contains(this.c) != true) goto L16;
        return;
    L23:
        return;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
        goto L11
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
