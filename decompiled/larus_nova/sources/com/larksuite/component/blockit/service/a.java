package com.larksuite.component.blockit.service;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class a {

    @SerializedName("code")
    public Integer code;

    @SerializedName("data")
    public C3890a data;

    @SerializedName("msg")
    public String msg;

    /* JADX INFO: renamed from: com.larksuite.component.blockit.service.a$a, reason: collision with other inner class name */
    public static class C3890a {

        @SerializedName("availableItemList")
        public List<C3891a> availableItemList;

        @SerializedName("minUpdateInterval")
        public Integer minUpdateInterval;

        /* JADX INFO: renamed from: ts, reason: collision with root package name */
        @SerializedName("ts")
        public Integer f283138ts;

        /* JADX INFO: renamed from: com.larksuite.component.blockit.service.a$a$a, reason: collision with other inner class name */
        public static class C3891a {

            @SerializedName("appId")
            public String appId;

            @SerializedName("appName")
            public C3892a appName;

            @SerializedName("blockTypeId")
            public String blockTypeId;

            @SerializedName("category")
            public String category;

            @SerializedName(SocialConstants.PARAM_APP_DESC)
            public b desc;

            @SerializedName("descImage")
            public c descImage;

            @SerializedName("key")
            public String key;

            @SerializedName("mobileIcon")
            public String mobileIcon;

            @SerializedName("name")
            public d name;

            @SerializedName("pcIcon")
            public String pcIcon;

            /* JADX INFO: renamed from: com.larksuite.component.blockit.service.a$a$a$a, reason: collision with other inner class name */
            public static class C3892a {

                @SerializedName("zh_cn")
                public String zhCn;

                public C3892a() {
                }
            }

            /* JADX INFO: renamed from: com.larksuite.component.blockit.service.a$a$a$b */
            public static class b {

                @SerializedName("zh_cn")
                public String zhCn;

                public b() {
                }
            }

            /* JADX INFO: renamed from: com.larksuite.component.blockit.service.a$a$a$c */
            public static class c {

                @SerializedName("en_us")
                public String enUs;

                @SerializedName("ja_jp")
                public String jaJp;

                @SerializedName("zh_cn")
                public String zhCn;

                public c() {
                }
            }

            /* JADX INFO: renamed from: com.larksuite.component.blockit.service.a$a$a$d */
            public static class d {

                @SerializedName("zh_cn")
                public String zhCn;

                public d() {
                }
            }

            public C3891a() {
            }
        }

        public C3890a() {
        }
    }

    public a() {
    }
}
