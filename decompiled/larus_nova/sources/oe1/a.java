package oe1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001c¨\u0006)"}, d2 = {"Loe1/a;", "", "", "appId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appToken", "b", "setAppToken", "cluster", "c", "setCluster", "", "hotWordScale", "D", "e", "()D", "setHotWordScale", "(D)V", "", "defaultTimeoutMillSeconds", "J", "d", "()J", "setDefaultTimeoutMillSeconds", "(J)V", "", "audioBufferSize", "I", "getAudioBufferSize", "()I", "setAudioBufferSize", "(I)V", "partialResultInterval", "f", "setPartialResultInterval", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("app_id")
    private String appId;

    @SerializedName("app_token")
    private String appToken;

    @SerializedName("audio_buffer_size")
    private int audioBufferSize;

    @SerializedName("cluster")
    private String cluster;

    @SerializedName("default_timeout_mill_seconds")
    private long defaultTimeoutMillSeconds;

    @SerializedName("hot_word_scale")
    private double hotWordScale;

    @SerializedName("partial_result_interval")
    private long partialResultInterval;

    public a() {
        this.appId = "";
        this.appToken = "";
        this.cluster = "";
        this.hotWordScale = 1.0d;
        this.defaultTimeoutMillSeconds = 60000;
        this.audioBufferSize = 10;
        this.partialResultInterval = 200;
    }

    public final String a() {
        return this.appId;
    }

    public final String b() {
        return this.appToken;
    }

    public final String c() {
        return this.cluster;
    }

    public final long d() {
        return this.defaultTimeoutMillSeconds;
    }

    public final double e() {
        return this.hotWordScale;
    }

    public final long f() {
        return this.partialResultInterval;
    }
}
