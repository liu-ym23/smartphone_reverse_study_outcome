package com.ss.android.ugc.aweme.poi.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes40.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/event/PicJumpMode;", "", "type", "", "()I", "Companion", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface PicJumpMode {
    public static final Companion Companion = null;
    public static final int JUMP_ALBUM_PAGE = 1;
    public static final int JUMP_PREVIEWER_PAGE = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/event/PicJumpMode$Companion;", "", "<init>", "()V", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f451328a = null;

        static {
            f451328a = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.f451328a;
    }

    int type();
}
