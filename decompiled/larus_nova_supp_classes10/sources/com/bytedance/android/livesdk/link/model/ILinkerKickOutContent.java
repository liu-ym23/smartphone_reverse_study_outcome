package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerKickOutContent;", "Lvh7/c;", "", "getFromUserId", "()Ljava/lang/String;", "getFromUserId$annotations", "()V", "fromUserId", "KickOutSource", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerKickOutContent extends vh7.c<ILinkerKickOutContent> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerKickOutContent$KickOutSource;", "", "Unknown", "FromOrganizer", "General", "RTCLeave", "RTCUnLink", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum KickOutSource extends Enum<KickOutSource> {
        public static final KickOutSource FromOrganizer = null;
        public static final KickOutSource General = null;
        public static final KickOutSource RTCLeave = null;
        public static final KickOutSource RTCUnLink = null;
        public static final KickOutSource Unknown = null;
        public static final /* synthetic */ KickOutSource[] a = null;

        static {
            KickOutSource r1 = new KickOutSource("Unknown", 0);
            Unknown = r1;
            KickOutSource r2 = new KickOutSource("FromOrganizer", 1);
            FromOrganizer = r2;
            KickOutSource r3 = new KickOutSource("General", 2);
            General = r3;
            KickOutSource r4 = new KickOutSource("RTCLeave", 3);
            RTCLeave = r4;
            KickOutSource r5 = new KickOutSource("RTCUnLink", 4);
            RTCUnLink = r5;
            a = new KickOutSource[]{r1, r2, r3, r4, r5};
        }

        public static KickOutSource valueOf(String r1) {
            return (KickOutSource) r27.a.a(KickOutSource.class, r1);
        }

        public static KickOutSource[] values() {
            return (KickOutSource[]) a.clone();
        }

        public KickOutSource(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "from_open_id")
    String getFromUserId();
}
