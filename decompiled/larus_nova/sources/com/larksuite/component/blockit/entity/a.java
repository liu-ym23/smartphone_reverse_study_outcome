package com.larksuite.component.blockit.entity;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public class a {

    @SerializedName("code")
    public Integer code;

    @SerializedName("data")
    public C3887a data;

    @SerializedName("msg")
    public String msg;

    /* JADX INFO: renamed from: com.larksuite.component.blockit.entity.a$a, reason: collision with other inner class name */
    public static class C3887a {

        @SerializedName("availableItemList")
        public List<C3888a> availableItemList;

        @SerializedName("minUpdateInterval")
        public long minUpdateInterval;

        /* JADX INFO: renamed from: ts, reason: collision with root package name */
        @SerializedName("ts")
        public long f282990ts;

        /* JADX INFO: renamed from: com.larksuite.component.blockit.entity.a$a$a, reason: collision with other inner class name */
        public static class C3888a {

            @SerializedName("appId")
            public String appId;

            @SerializedName("appName")
            public Map<String, String> appName;

            @SerializedName("blockTypeId")
            public String blockTypeId;

            @SerializedName("category")
            public String category;

            @SerializedName(SocialConstants.PARAM_APP_DESC)
            public Map<String, String> desc;

            @SerializedName("descImage")
            public Map<String, String> descImage;

            @SerializedName("key")
            public String key;

            @SerializedName("mobileIcon")
            public String mobileIcon;

            @SerializedName("name")
            public Map<String, String> name;

            public C3888a() {
            }
        }

        public C3887a() {
        }
    }

    public a() {
    }
}
