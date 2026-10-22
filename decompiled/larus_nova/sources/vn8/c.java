package vn8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.taskcard.view.TaskCardBtnAction;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import un8.m;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vn8.a f556465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f556466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f556467c;

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f556468a;

        @Override // un8.m
        public final boolean c() {
            c r100 = this.f556468a;
            vn8.a r101 = r100.f556465a;
            if (r101 != null) goto L5;
            return false;
        L5:
            b r102 = r100.f556466b;
            if (r102 == null) goto L9;
            r102.b(r101);
            return true;
        L9:
            return false;
        }

        public final void d() {
            b r100 = this.f556468a.f556466b;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        public a(c r100) {
            this.f556468a = r100;
        }

        @Override // un8.m
        public final void b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            c r101 = this.f556468a;
            vn8.a r102 = r101.f556465a;
            if (r102 != null) goto L5;
            return;
        L5:
            b r103 = r101.f556466b;
            if (r103 == null) goto L9;
            r103.c(r100, r102);
            return;
        }

        @Override // un8.m
        public final void a(Context r100, TaskCardBtnAction r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "action");
            c r102 = this.f556468a;
            vn8.a r103 = r102.f556465a;
            if (r103 != null) goto L5;
            return;
        L5:
            b r104 = r102.f556466b;
            if (r104 == null) goto L9;
            r104.d(r100, r103, r101);
            return;
        }
    }

    public c() {
        this.f556467c = new a(this);
    }
}
