package df2;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Ldf2/a;", "Lvh7/c;", "", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends c<a> {
    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    /* synthetic */ long getChannelId();

    /* synthetic */ long getScore();

    /* synthetic */ String getScoreStr();

    /* synthetic */ long getVersion();

    /* synthetic */ void setChannelId(long r100);

    /* synthetic */ void setScore(long r100);

    /* synthetic */ void setScoreStr(String r100);

    /* synthetic */ void setVersion(long r100);
}
