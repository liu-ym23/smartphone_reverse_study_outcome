package com.ss.android.lark.mention.base.impl.statistics;

import com.larksuite.framework.utils.CollectionUtils;
import com.obric.capabilitykit.EntityProvider;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class MentionBoardHitPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f431858a = 0;

    static {
    }

    public MentionBoardHitPoint() {
    }

    public static String a(List r100, Function1 r110) {
        List r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        r102.add(r110.invoke(r103.next()));
        goto L4
    L7:
        return CollectionsKt.joinToString$default(CollectionsKt.distinct(r102), ",", null, null, 0, null, null, 62, null);
    }

    @JvmStatic
    public static final void b(boolean r100, List<? extends BaseAtBean> r101) {
        Intrinsics.checkNotNullParameter(r101, "entityList");
        if (CollectionUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if (r100 == false) goto L8;
        String r102 = a(r101, MentionBoardHitPoint$sendIMMentionRefreshEvent$listType$1.INSTANCE);
        String r103 = a(r101, MentionBoardHitPoint$sendIMMentionRefreshEvent$entityType$1.INSTANCE);
        Statistics.sendEvent("im_mention_board_view", new JSONObject().put("mention_list_type", r102).put(EntityProvider.KEY_ENTITY_TYPE, r103));
        return;
    L8:
        String r104 = a(r101, MentionBoardHitPoint$sendIMMentionRefreshEvent$listType$2.INSTANCE);
        String r105 = a(r101, MentionBoardHitPoint$sendIMMentionRefreshEvent$entityType$2.INSTANCE);
        Statistics.sendEvent("im_mention_board_view", new JSONObject().put("mention_list_type", r104).put(EntityProvider.KEY_ENTITY_TYPE, r105));
    }
}
