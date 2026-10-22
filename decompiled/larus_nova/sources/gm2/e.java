package gm2;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lgm2/e;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/g1;", "", "getClientAttachedInfoStr", "()Ljava/lang/String;", "getClientAttachedInfoStr$annotations", "()V", "clientAttachedInfoStr", "getBattleAttachedInfoStr", "getBattleAttachedInfoStr$annotations", "battleAttachedInfoStr", "", "getFromUserId", "()J", "getFromUserId$annotations", "fromUserId", "getSecFromUserId", "getSecFromUserId$annotations", "secFromUserId", "getWaitSec", "getWaitSec$annotations", "waitSec", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getAnchorLinkUser", "()Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getAnchorLinkUser$annotations", "anchorLinkUser", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface e extends vh7.e<g1>, g1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.g1, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.g1, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "invite_user")
    com.bytedance.android.livesdk.link.model.bridge.k getAnchorLinkUser();

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfoStr();

    @FieldName(name = "client_attached_info")
    String getClientAttachedInfoStr();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "from_user_id")
    long getFromUserId();

    /* synthetic */ int getInviteSource();

    /* synthetic */ List<com.bytedance.android.livesdk.link.model.bridge.k> getInviteeFollowUsers();

    /* synthetic */ List<com.bytedance.android.livesdk.link.model.bridge.k> getInviterUsers();

    /* synthetic */ boolean getInviterWithAudience();

    @FieldName(name = "sec_from_user_id")
    String getSecFromUserId();

    @FieldName(name = "wait_sec")
    long getWaitSec();

    /* synthetic */ String get_fromUid();

    /* synthetic */ String get_secFromUid();
}
