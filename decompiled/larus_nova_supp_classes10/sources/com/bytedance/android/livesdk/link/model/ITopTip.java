package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\"\u0010\r\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITopTip;", "Lvh7/c;", "", "getTopContent", "()Ljava/lang/String;", "getTopContent$annotations", "()V", "topContent", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getTopImg", "()Lpy/k;", "getTopImg$annotations", "topImg", "", "getTopTipType", "()I", "getTopTipType$annotations", "topTipType", "getSchemeUrl", "getSchemeUrl$annotations", "schemeUrl", "TopTipType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ITopTip extends vh7.c<ITopTip> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITopTip$TopTipType;", "", "TopTipUndefined", "TopTipTeamTask", "TopTipPunish", "TopTipsPeakGuide", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum TopTipType extends Enum<TopTipType> {
        public static final TopTipType TopTipPunish = null;
        public static final TopTipType TopTipTeamTask = null;
        public static final TopTipType TopTipUndefined = null;
        public static final TopTipType TopTipsPeakGuide = null;
        public static final /* synthetic */ TopTipType[] a = null;

        static {
            TopTipType r1 = new TopTipType("TopTipUndefined", 0);
            TopTipUndefined = r1;
            TopTipType r2 = new TopTipType("TopTipTeamTask", 1);
            TopTipTeamTask = r2;
            TopTipType r3 = new TopTipType("TopTipPunish", 2);
            TopTipPunish = r3;
            TopTipType r4 = new TopTipType("TopTipsPeakGuide", 3);
            TopTipsPeakGuide = r4;
            a = new TopTipType[]{r1, r2, r3, r4};
        }

        public static TopTipType valueOf(String r1) {
            return (TopTipType) r27.a.a(TopTipType.class, r1);
        }

        public static TopTipType[] values() {
            return (TopTipType[]) a.clone();
        }

        public TopTipType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "scheme_url")
    String getSchemeUrl();

    @FieldName(name = "content")
    String getTopContent();

    @FieldName(name = "img")
    py.k getTopImg();

    @FieldName(name = "top_tip_type")
    int getTopTipType();
}
