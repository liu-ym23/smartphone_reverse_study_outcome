package com.obric.livecard.api.island;

import android.content.Context;
import com.heytap.mcssdk.constant.b;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.exception.IslandUnsupportedException;
import com.obric.livecard.api.impl.OnTopCardChangedListener;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u0010H'J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0012H&J!\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010!J!\u0010\"\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/obric/livecard/api/island/IslandApi;", "", "addOnTopCardChangedListener", "", "callback", "Lcom/obric/livecard/api/impl/OnTopCardChangedListener;", "collapseIsland", "collapseNotificationPanel", "createSession", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/obric/livecard/api/entity/IslandSession;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "destroySession", "getIslandVersion", "", "getPriority", "", "(Lcom/obric/livecard/api/entity/IslandSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshScene", "removeOnTopCardChangedListener", "sendEvent", "targetSession", "targetWidget", "Lcom/obric/livecard/api/entity/IslandWidget;", b.f276361k, "", "jsonString", "setPriority", "priority", "tryExpand", "canFrontShow", "(Lcom/obric/livecard/api/entity/IslandSession;Ljava/lang/Boolean;)V", "updateAnimation", "(Lcom/obric/livecard/api/entity/IslandSession;Lcom/obric/livecard/api/entity/IslandWidget;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAudioAmplitude", "amplitudes", "", "updateSessionFlags", "updateWidget", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IslandApi {

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void tryExpand$default(IslandApi r100, IslandSession r101, Boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.tryExpand(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryExpand");
        }
    }

    void addOnTopCardChangedListener(OnTopCardChangedListener r100) throws IslandUnsupportedException;

    void collapseIsland();

    void collapseNotificationPanel() throws IslandUnsupportedException;

    boolean createSession(IslandSession r100, Context r101);

    void destroySession(IslandSession r100);

    @Deprecated(message = "请使用最新的方法: getVersion()", replaceWith = @ReplaceWith(expression = "ILiveCard.inst.getVersion()", imports = {}))
    int getIslandVersion();

    Object getPriority(IslandSession r100, Continuation<? super Long> r101) throws IslandUnsupportedException;

    void refreshScene(IslandSession r100) throws IslandUnsupportedException;

    void removeOnTopCardChangedListener(OnTopCardChangedListener r100) throws IslandUnsupportedException;

    void sendEvent(IslandSession r100, IslandWidget r101, String r102, String r103);

    void setPriority(IslandSession r100, long r101) throws IllegalArgumentException, IslandUnsupportedException;

    void tryExpand(IslandSession r100, Boolean r101);

    Object updateAnimation(IslandSession r100, IslandWidget r101, Continuation<? super Unit> r102);

    void updateAudioAmplitude(IslandSession r100, float r101) throws IslandUnsupportedException;

    void updateSessionFlags(IslandSession r100);

    void updateWidget(IslandSession r100, IslandWidget r101);
}
