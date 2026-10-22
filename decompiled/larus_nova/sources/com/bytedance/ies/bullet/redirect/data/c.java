package com.bytedance.ies.bullet.redirect.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001c\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000f¨\u00062"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/c;", "", "", "statusCode", "I", "getStatusCode", "()I", "setStatusCode", "(I)V", "", "originSchema", "Ljava/lang/String;", "getOriginSchema", "()Ljava/lang/String;", "setOriginSchema", "(Ljava/lang/String;)V", "resolvedSchema", "getResolvedSchema", "setResolvedSchema", "configType", "getConfigType", "setConfigType", "configVersion", "getConfigVersion", "setConfigVersion", com.heytap.mcssdk.constant.b.C, "getSdkVersion", "setSdkVersion", "entry", "getEntry", "setEntry", "defaultSchema", "getDefaultSchema", "setDefaultSchema", "loopIndex", "getLoopIndex", "setLoopIndex", "Lorg/json/JSONArray;", "ruleTypes", "Lorg/json/JSONArray;", "getRuleTypes", "()Lorg/json/JSONArray;", "setRuleTypes", "(Lorg/json/JSONArray;)V", "errorCode", "getErrorCode", "setErrorCode", "errorMessage", "getErrorMessage", "setErrorMessage", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("config_type")
    private String configType;

    @SerializedName("config_version")
    private String configVersion;

    @SerializedName("default_schema")
    private String defaultSchema;

    @SerializedName("entry")
    private String entry;

    @SerializedName("error_code")
    private int errorCode;

    @SerializedName("error_message")
    private String errorMessage;

    @SerializedName("loop_index")
    private int loopIndex;

    @SerializedName("origin_schema")
    private String originSchema;

    @SerializedName("resolved_schema")
    private String resolvedSchema;

    @SerializedName("rule_types")
    private JSONArray ruleTypes;

    @SerializedName("sdk_version")
    private String sdkVersion;

    @SerializedName("status_code")
    private int statusCode;
}
