package com.ss.android.lark.widget.photo.preview.menu.action;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.widget.photo.preview.menu.ActionMenuBlock$downloadPhotoByType$action$1;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, Boolean> f446841i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f446843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PhotoItem f446844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Biz f446845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Scene f446846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f446847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IGetDataCallback<Boolean> f446848g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.ss.android.lark.compose.foundation.toast.g f446849h;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f446850a;

        @Override // java.lang.Runnable
        public final void run() {
            Context r100 = this.f446850a.f446842a;     // Catch: Throwable -> L6
            if ((r100 instanceof Activity) == false) goto L9;
            PhotoUtilsNew.n((Activity) r100, new c(this));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(d r100) {
            this.f446850a = r100;
        }
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String a() {
        return "";
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final String getId() {
        return "DOWNLOAD_IMAGE";
    }

    static {
        f446841i = new ConcurrentHashMap();
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final Runnable getAction() {
        return new a(this);
    }

    @Override // com.ss.android.lark.widget.photo.preview.menu.action.m
    public final boolean isValid() {
        return this.f446843b;
    }

    public d(Context r100, boolean r101, PhotoItem r102, Biz r103, Scene r104, int r105, ActionMenuBlock$downloadPhotoByType$action$1 r106) {
        Lifecycle r107 = null;
        this.f446849h = null;
        this.f446842a = r100;
        this.f446843b = r101;
        this.f446844c = r102;
        this.f446845d = r103;
        this.f446846e = r104;
        this.f446847f = r105;
        this.f446848g = r106;
        if ((r100 instanceof Activity) == false) goto L15;
        ComponentCallbacks2 r108 = Contexts.requireActivity(r100);     // Catch: Exception -> L10
        if ((r108 instanceof LifecycleOwner) == false) goto L7;
        r107 = ((LifecycleOwner) r108).getLifecycle();     // Catch: Exception -> L10
    L7:
        if (r107 == null) goto L16;
        r107.addObserver(new b(this, r107));     // Catch: Exception -> L10
        return;
    L16:
        return;
    L10:
        e = move-exception;
        Log.e("DownloadImageAction", "onDestroy failed:" + e);
        return;
    }
}
