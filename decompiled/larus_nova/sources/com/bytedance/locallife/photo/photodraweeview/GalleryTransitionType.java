package com.bytedance.locallife.photo.photodraweeview;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes21.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0006B\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/photo/photodraweeview/GalleryTransitionType;", "", "", "type", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface GalleryTransitionType {
    public static final a Companion = null;
    public static final int IMAGE = 0;
    public static final int LOOK_MORE = 2;
    public static final int POI_COMMENT_LIVE_PHOTO = 5;
    public static final int POI_COMMENT_VIDEO = 4;
    public static final int POI_VIDEO = 3;
    public static final int UPLOAD_VIDEO = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f262080a = null;

        static {
            f262080a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f262080a;
    }

    int type();
}
