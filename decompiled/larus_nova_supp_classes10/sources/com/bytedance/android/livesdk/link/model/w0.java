package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bR$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w0;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/link/model/w0$b;", "getOddStageInfo", "()Lcom/bytedance/android/livesdk/link/model/w0$b;", "setOddStageInfo", "(Lcom/bytedance/android/livesdk/link/model/w0$b;)V", "getOddStageInfo$annotations", "()V", "oddStageInfo", "b", "c", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w0 extends vh7.c<w0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w0$b;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/link/model/w0$c;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getUsers", "()Ljava/util/List;", "getUsers$annotations", "()V", "users", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "users")
        List<c> getUsers();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w0$c;", "Lvh7/c;", "", "getUserId", "()Ljava/lang/String;", "getUserId$annotations", "()V", "userId", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface c extends vh7.c<c> {

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        /* synthetic */ vh7.e castTo(Class r1);

        /* synthetic */ vh7.e castToOrNull(Class r1);

        @FieldName(name = "user_open_id")
        String getUserId();
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "odd_stage_info")
    b getOddStageInfo();

    @FieldName(name = "odd_stage_info#setter")
    void setOddStageInfo(b r1);
}
