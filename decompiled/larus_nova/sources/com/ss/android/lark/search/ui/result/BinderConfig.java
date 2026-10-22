package com.ss.android.lark.search.ui.result;

import android.content.Context;
import com.ss.android.lark.search.ui.result.constant.ShowExpandFoldBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;
import v3c.h;

/* JADX INFO: loaded from: classes38.dex */
public final class BinderConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f440244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f440245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f440246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e4c.b f440247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f440248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f440249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f440250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f440251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super String, Integer> f440252i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/search/ui/result/BinderConfig$Type;", "", "Companion", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Type {
        public static final a Companion = null;
        public static final int RECOMMEND_RESULT = 2;
        public static final int SEARCH_RESULT = 1;
        public static final int UNKNOWN = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f440253a = null;

            static {
                f440253a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f440253a;
        }
    }

    public final Context getContext() {
        return this.f440244a;
    }

    public final int getType() {
        return this.f440245b;
    }

    public BinderConfig(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f440244a = r100;
        this.f440245b = 1;
        this.f440246c = new a();
        this.f440247d = new e4c.b();
        this.f440250g = "";
        ShowExpandFoldBar r101 = ShowExpandFoldBar.SHOW_EXPAND_FOLD_BAR;
    }
}
