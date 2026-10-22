package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.k;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.common.utility.Lists;
import com.bytedance.live.datacontext.n;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/KComponentCoreViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/viewmodel/BaseCoreViewModel;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/w;", "result", "", "onSeiResult", "Loe2/b;", "ktvRoomProvider", "Lsb0/b;", "dataEntity", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "ktvContext", "<init>", "(Loe2/b;Lsb0/b;Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KComponentCoreViewModel extends BaseCoreViewModel {
    @Override // com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel, com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public void onSeiResult(w r7) {
        Intrinsics.checkNotNullParameter(r7, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r0 = r7.b;
        if ((r0 instanceof k) == false) goto L50;
        k r1 = (k) r0;
        getListenerLyricsHelper().d(r1);
        if (r1.G() == true) goto L21;
        if (r1.H() == true) goto L21;
        if (r1.I() == true) goto L21;
        KtvComponentContext r2 = KtvComponentContext.Companion.getContext();
        if (r2 == null) goto L15;
        n<Integer> r3 = r2.getKtvComponentStatus();
        if (r3 == null) goto L15;
        Integer r4 = (Integer) r3.getValue();
    L16:
        if (r4 == null) goto L41;
        if (r4.intValue() == 1) goto L21;
    L41:
        if (r1.d() != 1) goto L46;
        Iterator<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a> r8 = getKtvRoomSeiModelHandlers().iterator();
    L44:
        if (r8.hasNext() == false) goto L46;
        r8.next().f(r1);
    L46:
        setRoomInfoForVote(r1);
        return;
    L15:
        r4 = null;
    L21:
        if (r1.d() == 1) goto L41;
        if (Lists.isEmpty(r1.l()) == true) goto L26;
        setSeiParseResult(r7);
    L36:
        Iterator<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a> r5 = getKtvRoomSeiModelHandlers().iterator();
    L38:
        if (r5.hasNext() == false) goto L41;
        r5.next().g(r1, new JSONObject(r7.a));
        goto L38
    L26:
        if (Lists.isEmpty(r1.l()) == false) goto L36;
        String r6 = r1.p();
        if (r6 != null) goto L30;
    L33:
        boolean r9 = true;
    L34:
        if (r9 == false) goto L36;
        setSeiParseResult(null);
        goto L36
    L30:
        if (r6.length() == 0) goto L33;
        r9 = false;
        goto L34
    }

    public KComponentCoreViewModel(oe2.b r2, sb0.b r3, KtvContext r4) {
        Intrinsics.checkNotNullParameter(r2, "ktvRoomProvider");
        Intrinsics.checkNotNullParameter(r3, "dataEntity");
        Intrinsics.checkNotNullParameter(r4, "ktvContext");
        super(r2, r3, r4);
    }
}
