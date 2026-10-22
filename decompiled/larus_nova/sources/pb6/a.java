package pb6;

import com.bytedance.android.live.base.model.message.guestlink.k;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lpb6/a;", "Lvh7/e;", "Lcom/bytedance/android/live/base/model/message/guestlink/a;", "multi-link-service-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends e<com.bytedance.android.live.base.model.message.guestlink.a>, com.bytedance.android.live.base.model.message.guestlink.a {
    @Override // com.bytedance.android.live.base.model.message.guestlink.a, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.live.base.model.message.guestlink.a, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "call_duration")
    /* synthetic */ long getCallDuration();

    @FieldName(name = "channel_background")
    /* synthetic */ IVoiceLiveTheme getChannelBackground();

    @FieldName(name = "channel_id")
    /* synthetic */ long getChannelId();

    @FieldName(name = "channel_user_count")
    /* synthetic */ long getChannelUserCount();

    @FieldName(name = "channel_users")
    /* synthetic */ List<IBaseUser> getChannelUsers();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "link_threshold")
    /* synthetic */ long getLinkThreshold();

    @FieldName(name = "linked_users")
    /* synthetic */ List<k> getLinkedUsers();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCORE)
    /* synthetic */ long getScore();

    @FieldName(name = "score_str")
    /* synthetic */ String getScoreStr();

    @FieldName(name = "start_time_ms")
    /* synthetic */ long getStartTimeMs();

    @FieldName(name = "version")
    /* synthetic */ long getVersion();

    @FieldName(name = "call_duration#setter")
    /* synthetic */ void setCallDuration(long r100);

    @FieldName(name = "channel_background#setter")
    /* synthetic */ void setChannelBackground(IVoiceLiveTheme r100);

    @FieldName(name = "channel_id#setter")
    /* synthetic */ void setChannelId(long r100);

    @FieldName(name = "channel_user_count#setter")
    /* synthetic */ void setChannelUserCount(long r100);

    @FieldName(name = "channel_users#setter")
    /* synthetic */ void setChannelUsers(List<? extends IBaseUser> r100);

    @FieldName(name = "link_threshold#setter")
    /* synthetic */ void setLinkThreshold(long r100);

    @FieldName(name = "linked_users#setter")
    /* synthetic */ void setLinkedUsers(List<? extends k> r100);

    @FieldName(name = "score#setter")
    /* synthetic */ void setScore(long r100);

    @FieldName(name = "score_str#setter")
    /* synthetic */ void setScoreStr(String r100);

    @FieldName(name = "start_time_ms#setter")
    /* synthetic */ void setStartTimeMs(long r100);

    @FieldName(name = "version#setter")
    /* synthetic */ void setVersion(long r100);
}
