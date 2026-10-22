package i9c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class c extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f488832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f488833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f488834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f488835d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IRequestCreator f488836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f488837b;

        public a(IRequestCreator r100, ImageView r101) {
            this.f488836a = r100;
            this.f488837b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f488836a.into(this.f488837b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IRequestCreator f488838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f488839b;

        public b(IRequestCreator r100, ImageView r101) {
            this.f488838a = r100;
            this.f488839b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f488838a.into(this.f488839b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract void a();

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        a();
        this.f488832a = findViewById(R.id.card_layout);
        this.f488833b = (TextView) findViewById(R.id.title);
        this.f488834c = (ImageView) findViewById(R.id.front_pic);
        this.f488835d = (ImageView) findViewById(R.id.back_pic);
    }

    public void setBackImageUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        ImageView r101 = this.f488835d;
        if (r101 == null) goto L6;
        UICallbackExecutor.execute(new a(ImageLoader.with(getContext()).load(r100).asDrawable(), r101));
        return;
    }

    public void setFrontImageUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "imageUrl");
        ImageView r101 = this.f488834c;
        if (r101 == null) goto L6;
        UICallbackExecutor.execute(new b(ImageLoader.with(getContext()).load(r100).asDrawable(), r101));
        return;
    }

    public void setTitle(String r100) {
        TextView r101 = this.f488833b;
        if (r101 == null) goto L5;
        r101.setText(r100);
    L5:
        TextView r102 = this.f488833b;
        if (r102 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        int r103 = 8;
    L11:
        r102.setVisibility(r103);
        return;
    L10:
        r103 = 0;
        goto L11
    }
}
