package com.ss.android.lark.widget.span;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public class b extends n {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f448628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AbstractC5432b<?> f448629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<b, Unit> f448630i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Resources f448631j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f448632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f448633l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f448634m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f448635n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f448636o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f448637p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Paint f448638q;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.span.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC5432b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f448639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f448640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f448641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final T f448642d;

        /* JADX INFO: renamed from: com.ss.android.lark.widget.span.b$b$a */
        public static final class a extends AbstractC5432b<String> {
            public a(String r100, int r101, int r102) {
                Intrinsics.checkNotNullParameter(r100, "path");
                super(r100, r101, r102, r100);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.widget.span.b$b$b, reason: collision with other inner class name */
        public static final class C5433b extends AbstractC5432b<EncryptImage> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final String f448643e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final String f448644f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final ByteString f448645g;

            public /* synthetic */ C5433b(String r100, int r101, int r110, String r111, ByteString r112) {
                this(r100, r101, r110, r111, r112, 0);
            }

            public C5433b(String r100, int r101, int r102, String r103, ByteString r104, int r105) {
                Intrinsics.checkNotNullParameter(r100, "key");
                EncryptImage r106 = new EncryptImage(r100, r103, r104);
                r106.setDraftResourceSource(r105);
                Unit r107 = Unit.INSTANCE;
                super(r100, r101, r102, r106);
                this.f448643e = r100;
                this.f448644f = r103;
                this.f448645g = r104;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AbstractC5432b(String r100, int r101, int r102, Object r103) {
            this.f448639a = r100;
            this.f448640b = r101;
            this.f448641c = r102;
            this.f448642d = r103;
        }
    }

    public static final class c extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f448646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f448647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Drawable> f448648c;

        /* JADX WARN: Type inference failed for: r3v2, types: [T, android.graphics.drawable.Drawable, com.ss.android.lark.widget.span.k, java.lang.Object] */
        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
            ?? r102 = this.f448646a.b(r101);
            if (this.f448647b.element == false) goto L5;
            this.f448648c.element = r102;
            return;
        L5:
            b r103 = this.f448646a;
            r103.getClass();
            Intrinsics.checkNotNullParameter(r102, "drawable");
            r103.f448712e = r102;
            r103.f448636o = true;
            r103.f448630i.invoke(r103);
        }

        public c(b r100, Ref.BooleanRef r101, Ref.ObjectRef<Drawable> r102) {
            this.f448646a = r100;
            this.f448647b = r101;
            this.f448648c = r102;
        }
    }

    public static final class d extends BitmapDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f448649a;

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas r100) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            r100.drawRect(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight(), this.f448649a.f448638q);
            super.draw(r100);
        }

        public d(Bitmap r100, b r101, Resources r102) {
            this.f448649a = r101;
            super(r102, r100);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        if (this.f448636o == true) goto L34;
        Context r100 = this.f448628g;
        if ((r100 instanceof Activity) == true) goto L7;
    L9:
        AbstractC5432b<?> r101 = this.f448629h;
        boolean r102 = true;
        if ((r101 instanceof AbstractC5432b.a) == false) goto L12;
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(VFSFiles.f444819b.i((String) ((AbstractC5432b.a) r101).f448642d).getPath(), r103);
        Pair r104 = new Pair(Integer.valueOf(r103.outWidth), Integer.valueOf(r103.outHeight));
    L22:
        int[] r105 = ImageUtils.g(((Number) r104.component1()).intValue(), ((Number) r104.component2()).intValue(), this.f448632k, this.f448633l, 80, 80);
        Intrinsics.checkNotNull(r105);
        int r106 = r105[0];
        int r107 = r105[1];
        IRequestCreator r108 = ImageLoader.with(this.f448628g).load(this.f448629h.f448642d).asBitmap();
        Ref.ObjectRef r109 = new Ref.ObjectRef();
        Ref.BooleanRef r110 = new Ref.BooleanRef();
        r110.element = true;
        c r111 = new c(this, r110, r109);
        int r112 = this.f448637p;
        if (1 > r112) goto L26;
        if (r112 >= r107) goto L26;
    L27:
        if (r102 == false) goto L29;
        r108.centerCrop();
        r106 = this.f448637p;
        r107 = r106;
    L29:
        r108.override(r106, r107).into(r111);
        r110.element = false;
        Drawable r113 = (Drawable) r109.element;
        if (r113 != null) goto L35;
        Drawable r114 = UIUtils.getDrawable(this.f448628g, R.drawable.chat_window_image_item_holder);
        r114.setBounds(0, 0, r106, r107);
        Intrinsics.checkNotNull(r114);
        return r114;
    L35:
        return r113;
    L26:
        r102 = false;
        goto L27
    L12:
        int r115 = Integer.MAX_VALUE;
        if ((r101 instanceof AbstractC5432b.C5433b) == false) goto L21;
        AbstractC5432b.C5433b r116 = (AbstractC5432b.C5433b) r101;
        int r117 = r116.f448640b;
        int r118 = r116.f448641c;
        if (r117 != 0) goto L17;
        r117 = Integer.MAX_VALUE;
    L17:
        if (r118 == 0) goto L20;
        r115 = r118;
    L20:
        r104 = TuplesKt.to(Integer.valueOf(r117), Integer.valueOf(r115));
        goto L22
    L21:
        r104 = TuplesKt.to(Integer.MAX_VALUE, Integer.MAX_VALUE);
        goto L22
    L7:
        if (UIUtils.isActivityRunning((Activity) r100) == true) goto L9;
    L34:
        return super.getDrawable();
    }

    public k b(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        d r101 = new d(r100, this, this.f448631j);
        r101.setBounds(0, 0, r101.getIntrinsicWidth(), r101.getIntrinsicHeight());
        k r102 = new k(r101);
        r102.a(this.f448634m);
        r102.b(this.f448635n);
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context r100, AbstractC5432b<?> r101, Function1<? super b, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "loadInfo");
        Intrinsics.checkNotNullParameter(r102, "imageLoadHandle");
        super(r100);
        this.f448628g = r100;
        this.f448629h = r101;
        this.f448630i = r102;
        Resources r103 = r100.getResources();
        this.f448631j = r103;
        this.f448632k = (int) (((double) WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels) * 0.4d);
        this.f448633l = (int) (((double) WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).heightPixels) * 0.4d);
        this.f448637p = -1;
        Paint r104 = new Paint();
        r104.setColor(UIHelper.getColor(R.color.static_white));
        r104.setStyle(Paint.Style.FILL);
        this.f448638q = r104;
    }
}
