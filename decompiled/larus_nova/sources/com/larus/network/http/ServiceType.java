package com.larus.network.http;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes30.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/network/http/ServiceType;", "", "Companion", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ServiceType {
    public static final String AUDIO = "Audio";
    public static final String BASIC_SERVICE = "Basic";
    public static final String BASIC_TEC = "Infra";
    public static final a Companion = null;
    public static final String DOC = "Doc";
    public static final String DORA = "DORA";
    public static final String DRIVE = "Drive";
    public static final String ECOMMERCE = "Ecommerce";
    public static final String FIRST_PART = "AISDK";
    public static final String IM = "Message";
    public static final String MAIN_BOT = "MainBot";
    public static final String OBRIC = "OBRIC";
    public static final String OFFICE = "Office";
    public static final String UGC = "Social";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f360133a = null;

        static {
            f360133a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f360133a;
    }
}
