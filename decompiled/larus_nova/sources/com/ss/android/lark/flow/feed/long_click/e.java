package com.ss.android.lark.flow.feed.long_click;

import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.page.binder2.o;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements o {
    public e() {
    }

    @Override // com.ss.android.lark.feed.shared.page.binder2.o
    public final UDDialog a(View r100, UIFeedCard r110, ueb.a r111, LinkedHashMap<FeedActionType, aeb.c> r112, aeb.a r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        Intrinsics.checkNotNullParameter(r110, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r111, "itemContainer");
        Intrinsics.checkNotNullParameter(r112, "feedActionMap");
        Intrinsics.checkNotNullParameter(r113, "actionStatusListener");
        return new FlowFeedDialogBuilder(r100, r110, r111, r112, r113, r114).c();
    }
}
