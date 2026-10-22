package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/f0;", "Lvh7/c;", "", "Companion", "a", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f0 extends vh7.c<f0> {
    public static final int CHORUS_CLOSER_REASON_AGAIN = 7;
    public static final int CHORUS_CLOSER_REASON_ANCHOR_JOIN = 2;
    public static final int CHORUS_CLOSER_REASON_ANCHOR_LEAVE = 3;
    public static final int CHORUS_CLOSER_REASON_FALLBACK = 8;
    public static final int CHORUS_CLOSER_REASON_LEAD_LEAVE = 6;
    public static final int CHORUS_CLOSER_REASON_LINKMIC_CLOSE = 5;
    public static final int CHORUS_CLOSER_REASON_NORMAL = 1;
    public static final int CHORUS_CLOSER_REASON_RTC_SERVER_MIX_FALLBACK = 9;
    public static final int CHORUS_CLOSER_REASON_SWITCH_SCENE = 4;
    public static final int CHORUS_CLOSER_REASON_UNKNOWN = 0;
    public static final a Companion = null;
    public static final int TYPE_CHORUS_ORDERED_SONG_LIST_CHANGE = 3;
    public static final int TYPE_CLOSE_CHORUS = 2;
    public static final int TYPE_OPEN_CHORUS = 1;
    public static final int TYPE_UNKNOWN = 0;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ g0 getCloseChorusContent();

    /* synthetic */ int getMsgType();

    /* synthetic */ w1 getOpenChorusContent();
}
