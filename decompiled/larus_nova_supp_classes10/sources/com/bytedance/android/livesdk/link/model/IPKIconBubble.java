package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\bg\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002%&R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\r\u001a\u00060\bj\u0002`\t8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0013\u001a\u00060\u000ej\u0002`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010#\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u0016¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPKIconBubble;", "Lvh7/c;", "", "getBubbleType", "()I", "getBubbleType$annotations", "()V", "bubbleType", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getDisplayTest", "()Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayTest$annotations", "displayTest", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getDisplayIcon", "()Lpy/k;", "getDisplayIcon$annotations", "displayIcon", "", "getSchema", "()Ljava/lang/String;", "getSchema$annotations", "schema", "", "getShowTime", "()J", "getShowTime$annotations", "showTime", "getShowCount", "getShowCount$annotations", "showCount", "getActivityType", "getActivityType$annotations", "activityType", "Companion", "a", "PKIconBubbleType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPKIconBubble extends vh7.c<IPKIconBubble> {
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPKIconBubble$PKIconBubbleType;", "", "PKIconBubbleTypeDefault", "PKIconBubbleTypeStarActivity", "PKIconBubbleTypeFateMatch", "PKIconBubbleTypeNewAnchor", "PKIconBubbleCommon", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum PKIconBubbleType extends Enum<PKIconBubbleType> {
        public static final PKIconBubbleType PKIconBubbleCommon = null;
        public static final PKIconBubbleType PKIconBubbleTypeDefault = null;
        public static final PKIconBubbleType PKIconBubbleTypeFateMatch = null;
        public static final PKIconBubbleType PKIconBubbleTypeNewAnchor = null;
        public static final PKIconBubbleType PKIconBubbleTypeStarActivity = null;
        public static final /* synthetic */ PKIconBubbleType[] a = null;

        static {
            PKIconBubbleType r1 = new PKIconBubbleType("PKIconBubbleTypeDefault", 0);
            PKIconBubbleTypeDefault = r1;
            PKIconBubbleType r2 = new PKIconBubbleType("PKIconBubbleTypeStarActivity", 1);
            PKIconBubbleTypeStarActivity = r2;
            PKIconBubbleType r3 = new PKIconBubbleType("PKIconBubbleTypeFateMatch", 2);
            PKIconBubbleTypeFateMatch = r3;
            PKIconBubbleType r4 = new PKIconBubbleType("PKIconBubbleTypeNewAnchor", 3);
            PKIconBubbleTypeNewAnchor = r4;
            PKIconBubbleType r5 = new PKIconBubbleType("PKIconBubbleCommon", 4);
            PKIconBubbleCommon = r5;
            a = new PKIconBubbleType[]{r1, r2, r3, r4, r5};
        }

        public static PKIconBubbleType valueOf(String r1) {
            return (PKIconBubbleType) r27.a.a(PKIconBubbleType.class, r1);
        }

        public static PKIconBubbleType[] values() {
            return (PKIconBubbleType[]) a.clone();
        }

        public PKIconBubbleType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final com.bytedance.android.live.base.model.message.a5 a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = vh7.f.c(com.bytedance.android.live.base.model.message.a5.class);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.b;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "activity_name")
    String getActivityType();

    @FieldName(name = "bubble_type")
    int getBubbleType();

    @FieldName(name = "display_icon")
    py.k getDisplayIcon();

    @FieldName(name = "display_text")
    com.bytedance.android.live.base.model.message.a5 getDisplayTest();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "show_count")
    long getShowCount();

    @FieldName(name = "show_time")
    long getShowTime();
}
