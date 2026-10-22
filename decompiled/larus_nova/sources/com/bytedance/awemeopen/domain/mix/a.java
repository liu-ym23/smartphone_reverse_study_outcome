package com.bytedance.awemeopen.domain.mix;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import r14.a0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/domain/mix/a;", "Ln14/a;", "Lcom/bytedance/awemeopen/domain/mix/a$a;", "data", "Lcom/bytedance/awemeopen/domain/mix/a$a;", "e", "()Lcom/bytedance/awemeopen/domain/mix/a$a;", "setData", "(Lcom/bytedance/awemeopen/domain/mix/a$a;)V", "Lr14/a0;", "logPb", "Lr14/a0;", ce.f26391f, "()Lr14/a0;", "setLogPb", "(Lr14/a0;)V", "", "logId", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class a extends n14.a {

    @SerializedName("data")
    private C2861a data;

    @SerializedName("log_id")
    private String logId;

    @SerializedName("log_pb")
    private a0 logPb;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.domain.mix.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/awemeopen/domain/mix/a$a;", "", "", "minCursor", "Ljava/lang/String;", "getMinCursor", "()Ljava/lang/String;", "setMinCursor", "(Ljava/lang/String;)V", "", EffectConfiguration.KEY_CURSOR, "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setCursor", "(I)V", "", "hasMore", "Z", "b", "()Z", "setHasMore", "(Z)V", "", "Lr14/c;", "list", "Ljava/util/List;", "c", "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
    public static final class C2861a {

        @SerializedName(EffectConfiguration.KEY_CURSOR)
        private int cursor;

        @SerializedName("has_more")
        private boolean hasMore;

        @SerializedName("aweme_list")
        private List<r14.c> list;

        @SerializedName("min_cursor")
        private String minCursor;

        public C2861a() {
        }

        public final int a() {
            return this.cursor;
        }

        public final boolean b() {
            return this.hasMore;
        }

        public final List<r14.c> c() {
            return this.list;
        }

        public final void d(List<r14.c> r100) {
            this.list = r100;
        }
    }

    public a() {
    }

    public final C2861a e() {
        return this.data;
    }

    public final String f() {
        return this.logId;
    }

    public final a0 g() {
        return this.logPb;
    }
}
