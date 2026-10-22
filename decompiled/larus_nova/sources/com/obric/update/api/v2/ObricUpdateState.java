package com.obric.update.api.v2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes34.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/update/api/v2/ObricUpdateState;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ObricUpdateState {
    public static final a Companion = null;
    public static final int STATE_AVAILABLE = 1;
    public static final int STATE_DOWNLOADED = 4;
    public static final int STATE_DOWNLOADING = 2;
    public static final int STATE_DOWNLOAD_FAIL = 6;
    public static final int STATE_INSTALLED = 5;
    public static final int STATE_NOT_AVAILABLE = -1;
    public static final int STATE_PAUSE = 3;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f404039a = null;

        static {
            f404039a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f404039a;
    }
}
