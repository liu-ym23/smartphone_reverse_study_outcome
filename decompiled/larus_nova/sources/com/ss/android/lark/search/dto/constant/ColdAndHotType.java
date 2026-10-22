package com.ss.android.lark.search.dto.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes38.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/search/dto/constant/ColdAndHotType;", "", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ColdAndHotType {
    public static final int COLD_EMPTY = 5;
    public static final int COLD_TO_FINISH = 3;
    public static final a Companion = null;
    public static final int ERROR = 6;
    public static final int HOT_EMPTY = 4;
    public static final int HOT_TO_COLD = 2;
    public static final int LOAD_MORE = 1;
    public static final int UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f440132a = null;

        static {
            f440132a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f440132a;
    }
}
