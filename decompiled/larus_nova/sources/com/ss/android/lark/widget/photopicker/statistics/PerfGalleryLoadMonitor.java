package com.ss.android.lark.widget.photopicker.statistics;

import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.monitor.perf.BasePerfMonitor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class PerfGalleryLoadMonitor extends BasePerfMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PerfGalleryLoadMonitor f447609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f447610b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/widget/photopicker/statistics/PerfGalleryLoadMonitor$FromType;", "", "Companion", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FromType {
        public static final a Companion = null;
        public static final int GALLERY = 2;
        public static final int KEYBOARD = 1;
        public static final int UNKNOWN = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f447611a = null;

            static {
                f447611a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f447611a;
        }
    }

    public static class a extends BasePerfMonitor.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f447612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Scene f447613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f447614c;

        /* JADX INFO: renamed from: com.ss.android.lark.widget.photopicker.statistics.PerfGalleryLoadMonitor$a$a, reason: collision with other inner class name */
        public static final class C5420a {
        }

        static {
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.a
        public final String getEventName(int r100) {
            return "gallery_load";
        }

        public a() {
            this.f447612a = "";
            this.f447613b = Scene.Chat;
            this.f447614c = 2;
        }

        @Override // com.ss.android.lark.monitor.perf.BasePerfMonitor.b
        public final void end() {
            super.end();
            AppreciableKit.Companion r100 = AppreciableKit.Companion;
            r100.getInstance().spanEnd(this.f447612a, "data_load_cost");
            AppreciableKit.end$default(r100.getInstance(), this.f447612a, null, null, null, MapsKt.mapOf(TuplesKt.to("from_type", Integer.valueOf(this.f447614c))), 14, null);
            this.f447612a = "";
        }

        public final void a(Scene r100, int r110) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            super.start();
            this.f447613b = r100;
            this.f447614c = r110;
            AppreciableKit.Companion r101 = AppreciableKit.Companion;
            this.f447612a = AppreciableKit.start$default(r101.getInstance(), Biz.Core, this.f447613b, Event.gallery_load, "PhotoPickerActivity", false, 16, null);
            r101.getInstance().spanStart(this.f447612a, "data_load_cost");
        }
    }

    static {
        f447609a = new PerfGalleryLoadMonitor();
    }

    public static void c() {
        a r100 = f447610b;
        if (r100 != null) goto L5;
        return;
    L5:
        AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.Core, r100.f447613b, Event.gallery_load, ErrorType.Unknown, ErrorLevel.Exception, 5678, null, null, null, Boolean.FALSE, null, null, null, 7616, null));
        f447610b = null;
    }

    public PerfGalleryLoadMonitor() {
    }
}
