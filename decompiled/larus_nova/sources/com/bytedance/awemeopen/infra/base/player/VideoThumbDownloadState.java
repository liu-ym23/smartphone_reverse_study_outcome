package com.bytedance.awemeopen.infra.base.player;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes46.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/player/VideoThumbDownloadState;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface VideoThumbDownloadState {
    public static final a Companion = null;
    public static final int FAIL = 3;
    public static final int INIT = 0;
    public static final int START = 1;
    public static final int SUCCESS = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f198733a = null;

        static {
            f198733a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f198733a;
    }
}
