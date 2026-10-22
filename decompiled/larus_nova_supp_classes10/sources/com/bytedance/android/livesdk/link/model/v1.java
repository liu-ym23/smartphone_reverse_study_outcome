package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u000e\u000fR\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/v1;", "Lvh7/c;", "", "getMode", "()I", "getMode$annotations", "()V", "mode", "Lcom/bytedance/android/livesdk/link/model/v1$c;", "getStealTowerData", "()Lcom/bytedance/android/livesdk/link/model/v1$c;", "getStealTowerData$annotations", "stealTowerData", "Companion", "a", "c", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v1 extends vh7.c<v1> {
    public static final a Companion = null;
    public static final int MODE_NORMAL = 0;
    public static final int MODE_STEAL_TOWER = 1;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/v1$c;", "Lvh7/c;", "", "getTriggerTime", "()J", "getTriggerTime$annotations", "()V", "triggerTime", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface c extends vh7.c<c> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "trigger_time")
        long getTriggerTime();
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "mode")
    int getMode();

    @FieldName(name = "steal_tower_data")
    c getStealTowerData();
}
