package ue8;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f549812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f549813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f549814c;

    public static final class a extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.larus.bmhome.chat.exposure.a f549815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f549816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f549817c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f549818d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Paint f549819e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Paint f549820f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Paint f549821g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f549822h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int[] f549823i;

        public final com.larus.bmhome.chat.exposure.a getManager() {
            return this.f549815a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            Paint r101 = new Paint();
            r101.setColor(Color.argb(40, 66, 133, 244));
            r101.setStyle(Paint.Style.FILL);
            this.f549816b = r101;
            Paint r102 = new Paint();
            r102.setColor(Color.argb(150, 66, 133, 244));
            r102.setStyle(Paint.Style.STROKE);
            r102.setStrokeWidth(4.0f);
            this.f549817c = r102;
            Paint r103 = new Paint();
            r103.setColor(Color.argb(180, 255, 193, 7));
            r103.setStyle(Paint.Style.STROKE);
            r103.setStrokeWidth(3.0f);
            this.f549818d = r103;
            Paint r104 = new Paint();
            r104.setColor(Color.argb(50, 76, 175, 80));
            r104.setStyle(Paint.Style.FILL);
            this.f549819e = r104;
            Paint r105 = new Paint();
            r105.setColor(Color.argb(200, 76, 175, 80));
            r105.setStyle(Paint.Style.STROKE);
            r105.setStrokeWidth(4.0f);
            this.f549820f = r105;
            Paint r106 = new Paint();
            r106.setColor(-1);
            r106.setTextSize(28.0f);
            r106.setAntiAlias(true);
            r106.setShadowLayer(3.0f, 1.0f, 1.0f, -16777216);
            this.f549821g = r106;
            this.f549822h = new int[2];
            this.f549823i = new int[2];
            setWillNotDraw(false);
            setElevation(Float.MAX_VALUE);
        }

        @Override // android.view.View
        public final void onDraw(Canvas r210) {
            Intrinsics.checkNotNullParameter(r210, "canvas");
            super.onDraw(r210);
            com.larus.bmhome.chat.exposure.a r100 = this.f549815a;
            if (r100 != null) goto L5;
            return;
        L5:
            getLocationOnScreen(this.f549823i);
            int[] r101 = this.f549823i;
            int r110 = r101[0];
            int r111 = r101[1];
            Rect r102 = r100.a();
            if (r102 == null) goto L9;
            float r112 = r102.left - r110;
            float r113 = r102.top - r111;
            float r114 = r102.right - r110;
            float r103 = r102.bottom - r111;
            r210.drawRect(r112, r113, r114, r103, this.f549816b);
            r210.drawRect(r112, r113, r114, r103, this.f549817c);
            r210.drawText("检测区域", r112 + 12.0f, r113 + 36.0f, this.f549821g);
        L9:
            Iterator<j> r104 = r100.f302981b.a().iterator();
        L11:
            if (r104.hasNext() == false) goto L21;
            j r115 = r104.next();
            View r105 = r115.f549827b.get();
            if (r105 == null) goto L11;
            if (r105.isAttachedToWindow() == false) goto L11;
            r105.getLocationOnScreen(this.f549822h);
            int[] r106 = this.f549822h;
            float r116 = r106[0] - r110;
            float r117 = r106[1] - r111;
            float r118 = r116 + r105.getWidth();
            float r119 = r117 + r105.getHeight();
            if (r115.f549829d == true) goto L19;
            r210.drawRect(r116, r117, r118, r119, this.f549818d);
            r210.drawText(r115.f549826a, r116 + 8.0f, r117 + 32.0f, this.f549821g);
            goto L11
        L19:
            r210.drawRect(r116, r117, r118, r119, this.f549819e);
            r210.drawRect(r116, r117, r118, r119, this.f549820f);
            r210.drawText("✓ " + r115.f549826a, r116 + 8.0f, r117 + 32.0f, this.f549821g);
            goto L11
        }

        public final void setManager(com.larus.bmhome.chat.exposure.a r100) {
            this.f549815a = r100;
        }
    }

    public f(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f549812a = r100;
    }
}
