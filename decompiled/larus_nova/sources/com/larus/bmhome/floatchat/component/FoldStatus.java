package com.larus.bmhome.floatchat.component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes26.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/floatchat/component/FoldStatus;", "", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface FoldStatus {
    public static final a Companion = null;
    public static final int DRAGGING = 4;
    public static final int FOLD = 0;
    public static final int FULL_SCREEN = 3;
    public static final int HALF_SCREEN = 1;
    public static final int NINE_SPLIT_SCREEN = 2;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f311711a = null;

        static {
            f311711a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f311711a;
    }
}
