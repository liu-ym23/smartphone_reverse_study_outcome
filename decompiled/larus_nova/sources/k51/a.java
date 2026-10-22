package k51;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r11.c;
import vh7.b;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f501817a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f501818b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f501819c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f501820d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f501821e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f501822f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f501823g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f501824h = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "liveAnchorInteractVoteScoreRatio", "getLiveAnchorInteractVoteScoreRatio()I", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveInteractVoteRuleLynxUrl", "getLiveInteractVoteRuleLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "pkVoteTestTime", "getPkVoteTestTime()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveVoteSupportMulti", "getLiveVoteSupportMulti()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveInteractVoteConfig", "getLiveInteractVoteConfig()Lcom/bytedance/android/live/revlink/impl/config/InteractVoteConfig;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "liveMultiVoteTopicLynx", "getLiveMultiVoteTopicLynx()Ljava/lang/String;", 0))};
        f501817a = r100;
        f501824h = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_interact_vote_score_ratio", 30, Integer.TYPE, false);
        f501818b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_interact_vote_rule_lynx_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Frevenue_pk_hybrid_douyin%2Fpages%2Fpk_vote_rule%2Ftemplate.js&gravity=bottom&type=popup&rate_height=305&radius=8&pull_down_close=1&pull_down_indicator_not_show=1", String.class, false);
        f501819c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r103 = Boolean.FALSE;
        Class r104 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_vote_test_time_enable", r103, r104, false);
        f501820d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_vote_support_multi", Boolean.TRUE, r104, false);
        f501821e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        Class<?> r107 = ((JsonAdapter) c.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r108 = b.f554981a;
        Constructor r109 = r108.get(r107);
        if (r109 != null) goto L12;
        r109 = r107.getConstructor(new Class[0]);
        if (r109 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r110 = r108.putIfAbsent(r107, (Constructor<? extends SerializableObjectJsonAdapterBase>) r109);
        if (r110 == null) goto L12;
        r109 = r110;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r111 = ((SerializableObjectJsonAdapterBase) r109.newInstance(new Object[0])).createInstance();
        if (r111 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_interact_vote_config", (c) r111, c.class, false);
        f501822f = UltraSettingsManager.a().a(r112.f271017a, r112.f271018b, r112.getType(), r112.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_vote_topic_lynx", j51.a.a("sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_contribution_lynx_douyin%2Fpages%2Fvote%2Ftemplate.js&gravity=bottom&type=popup&rate_height=363", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_contribution_lynx_huoshan%2Fpages%2Fvote%2Ftemplate.js&gravity=bottom&type=popup&rate_height=363", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_contribution_lynx_saas%2Fpages%2Fvote%2Ftemplate.js&gravity=bottom&type=popup&rate_height=363"), String.class, false);
        f501823g = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[5]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.config.InteractVoteConfig");
    }

    public a() {
    }
}
