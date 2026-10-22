package com.larus.bmhome.utils;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static FirstFeedSceneEnum f315009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f315010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f315011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<b> f315012d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f315013e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f315014f = null;

    /* JADX INFO: loaded from: classes26.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f315015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f315016b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f315015a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (f2.f315010b == true) goto L15;
            f2.f315010b = true;
            FLogger r100 = FLogger.f375446a;
            StringBuilder r101 = new StringBuilder("feedFirstShown by view: ");
            r101.append(this.f315015a.getClass().getSimpleName());
            r101.append(", act: ");
            r101.append(this.f315015a.getContext().getClass().getSimpleName());
            r101.append(", fragment: ");
            Fragment r102 = com.larus.utils.e1.k(this.f315015a);
            if (r102 != null) goto L7;
            String r103 = "null";
        L8:
            r101.append(r103);
            r100.i("launch_trace", r101.toString());
            String r104 = this.f315016b;
            Iterator r105 = new ArrayList(f2.f315012d).iterator();
        L10:
            if (r105.hasNext() == false) goto L15;
            ((b) r105.next()).a(r104);     // Catch: Throwable -> L14
            goto L10
        L7:
            r103 = r102.getClass().getSimpleName();
        L15:
            return true;
        }

        public a(View r100, String r101) {
            this.f315015a = r100;
            this.f315016b = r101;
        }
    }

    public interface b {
        void a(String r100);

        void b();

        void onFirstFrame();
    }

    static {
        f315009a = FirstFeedSceneEnum.CHAT_DETAIL;
        f315010b = false;
        f315011c = false;
        f315012d = Collections.synchronizedList(new ArrayList());
        f315013e = new AtomicBoolean(false);
        f315014f = new AtomicBoolean(false);
    }

    public static void a(View r100, String r101) {
        if (f315010b == false) goto L5;
        return;
    L5:
        a r102 = new a(r100, r101);
        r100.getViewTreeObserver().addOnPreDrawListener(r102);
    }
}
