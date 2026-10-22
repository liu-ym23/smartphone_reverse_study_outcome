package com.bytedance.locallife.photo.album.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes21.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/photo/album/model/PhotoSource;", "", "", "type", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-photo-api_release"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface PhotoSource {
    public static final int BUSINESS = 1;
    public static final a Companion = null;
    public static final int MODEL = 3;
    public static final int OTHER = 0;
    public static final int USER_UPLOAD = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f261969a = null;

        static {
            f261969a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f261969a;
    }

    int type();
}
