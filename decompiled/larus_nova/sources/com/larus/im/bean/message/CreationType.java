package com.larus.im.bean.message;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/im/bean/message/CreationType;", "", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface CreationType {
    public static final int CREATION_TYPE_IMAGE = 1;
    public static final int CREATION_TYPE_LOCAL_IMAGE = 3;
    public static final int CREATION_TYPE_LOCAL_VIDEO = 4;
    public static final int CREATION_TYPE_UNKNOWN = 0;
    public static final int CREATION_TYPE_VIDEO = 2;
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f346624a = null;

        static {
            f346624a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f346624a;
    }
}
