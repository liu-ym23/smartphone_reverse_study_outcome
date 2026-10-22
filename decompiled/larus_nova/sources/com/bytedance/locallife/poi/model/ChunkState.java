package com.bytedance.locallife.poi.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes21.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/poi/model/ChunkState;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ChunkState {
    public static final String CHUNK_DISABLE = "0";
    public static final String CHUNK_ENABLE = "1";
    public static final String CHUNK_FORBIDDEN = "-1";
    public static final String CHUNK_NO_CONFIG = "-2";
    public static final String CHUNK_STATE_ERROR = "-3";
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f262949a = null;

        static {
            f262949a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f262949a;
    }
}
