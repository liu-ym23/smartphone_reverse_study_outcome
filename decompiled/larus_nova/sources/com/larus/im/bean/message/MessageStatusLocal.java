package com.larus.im.bean.message;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/im/bean/message/MessageStatusLocal;", "", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface MessageStatusLocal {
    public static final int ADD_LOCAL = 0;
    public static final a Companion = null;
    public static final int RECEIVED = 21;
    public static final int RECEIVE_FAILED = 22;
    public static final int RECEIVE_INTERRUPT = 23;
    public static final int RECEIVE_LOADING = 24;
    public static final int RECEIVING = 20;
    public static final int SENDING = 10;
    public static final int SEND_COMPLIANT = 14;
    public static final int SEND_FAILED = 12;
    public static final int SEND_INTERRUPT = 13;
    public static final int SEND_SUCCESS = 11;
    public static final int UNKNOWN = -1;
    public static final int UPLOADING = 1;
    public static final int UPLOAD_FAILED = 3;
    public static final int UPLOAD_SUCCESS = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f346679a = null;

        static {
            f346679a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f346679a;
    }
}
