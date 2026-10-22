package com.bytedance.android.livesdk.livecommerce.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m0 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static final Gson a = null;
        public static final Gson b = null;

        static {
            a = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            b = new Gson();
            new JsonParser();
        }
    }

    static {
    }
}
