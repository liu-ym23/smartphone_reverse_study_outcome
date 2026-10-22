package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTab;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfigData;
import com.bytedance.android.livesdkapi.model.TabName;
import com.bytedance.android.livesdkapi.model.UserType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final class BaseFirstLevelTabManager$fillFirstLevelTabArrayListAction$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseFirstLevelTabManager this$0;

    public BaseFirstLevelTabManager$fillFirstLevelTabArrayListAction$1(BaseFirstLevelTabManager r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m25invoke() {
        BaseFirstLevelTabManager r0 = this.this$0;
        r0.l().clear();
        LiveKtvFirstLevelTabConfigData r1 = r0.m();
        if (r1 == null) goto L23;
        List r2 = r1.getLiveKtvFirstLevelTabList();
        if (r2 == null) goto L23;
        Iterator r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L23;
        LiveKtvFirstLevelTab r4 = (LiveKtvFirstLevelTab) r3.next();
        if (Intrinsics.areEqual(r4.getUserType(), UserType.ALL.getValue()) == true) goto L11;
        if (Intrinsics.areEqual(r4.getUserType(), UserType.ANCHOR.getValue()) == false) goto L18;
        if (j.i() == false) goto L18;
        r0.l().add(r4.getTabName());
    L18:
        if (Intrinsics.areEqual(r4.getUserType(), UserType.AUDIENCE.getValue()) == false) goto L8;
        if (j.i() == true) goto L8;
        r0.l().add(r4.getTabName());
        goto L8
    L11:
        r0.l().add(r4.getTabName());
    L23:
        if (KtvUtilsKt.v() == true) goto L31;
        Room r5 = m.i().getCurrentRoom();
        if (r5 == null) goto L29;
        boolean r6 = true;
        if (r5.isVirtualLive() != true) goto L29;
    L30:
        if (r6 == true) goto L31;
        return;
    L29:
        r6 = false;
    L31:
        r0.l().remove(TabName.AUDIENCE_SING.getValue());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m25invoke();
        return Unit.INSTANCE;
    }
}
