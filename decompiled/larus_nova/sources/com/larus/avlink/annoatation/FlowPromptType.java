package com.larus.avlink.annoatation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes23.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/annoatation/FlowPromptType;", "", "Companion", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface FlowPromptType {
    public static final int CHANGE_MIC = 1;
    public static final a Companion = null;
    public static final int NETWORK_ERR = 2;
    public static final int SHUTTER = 3;
    public static final int STOP = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f291628a = null;

        static {
            f291628a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f291628a;
    }
}
