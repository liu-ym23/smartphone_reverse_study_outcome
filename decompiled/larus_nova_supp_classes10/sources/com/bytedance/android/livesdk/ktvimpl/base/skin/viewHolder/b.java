package com.bytedance.android.livesdk.ktvimpl.base.skin.viewHolder;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements Runnable {
    public final /* synthetic */ KtvHonorTagViewBinder.KtvHonorTagViewHolder a;
    public final /* synthetic */ List b;
    public final /* synthetic */ String c;
    public final /* synthetic */ MicPosTagInfo d;
    public final /* synthetic */ Boolean e;

    public b(KtvHonorTagViewBinder.KtvHonorTagViewHolder r1, List r2, String r3, MicPosTagInfo r4, Boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        if (((RecyclerView.ViewHolder) this.a).itemView.isShown() == false) goto L29;
        String r0 = this.c;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L30;
        List r2 = this.b;
        if (r2 != null) goto L15;
    L16:
        this.a.e.c.a("ksong", this.c);
        Long r3 = KtvLoggerHelper.a;
        MicPosTagInfo r4 = this.d;
        String r5 = null;
        if (r4 == null) goto L19;
        String r6 = String.valueOf(r4.getTagType());
    L20:
        MicPosTagInfo r7 = this.d;
        if (r7 == null) goto L23;
        r5 = r7.getPositionTagName();
    L23:
        String r8 = r5;
        if (Intrinsics.areEqual(this.e, Boolean.FALSE) == false) goto L26;
        String r9 = BDLocationException.ERROR_TIMEOUT;
    L27:
        KtvLoggerHelper.V(r6, r8, "ksong", r9, null, 48);
        return;
    L26:
        r9 = "1";
        goto L27
    L19:
        r6 = null;
        goto L20
    L15:
        if (r2.contains(this.c) != true) goto L16;
        return;
    L30:
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
