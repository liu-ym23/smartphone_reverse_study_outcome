package em5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.image.entity.AvatarImage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class b {
    public final Context a;
    public final List<cpc.a> b;

    public static final class a extends SimpleTarget<Bitmap> {
        public final /* synthetic */ Function1<Bitmap, Unit> a;
        public final /* synthetic */ Context b;

        public final void onLoadFailed(Drawable r3) {
            super/*com.bumptech.glide.request.target.BaseTarget*/.onLoadFailed(r3);
            this.a.invoke(BitmapFactory.decodeResource(this.b.getResources(), 2131235295));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Bitmap, Unit> r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onResourceReady(Object r1, Transition r2) {
            Bitmap r3 = (Bitmap) r1;
            Intrinsics.checkNotNullParameter(r3, "resource");
            this.a.invoke(r3);
        }
    }

    public e a() {
        return null;
    }

    public void c(String r1, Object r2, Function1<? super cpc.a, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "loadCallback");
    }

    public Context getContext() {
        return this.a;
    }

    public b(Context r1) {
        this.a = r1;
        this.b = new ArrayList();
    }

    public static void b(Context r2, String r3, String r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "avatarKey");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r5, "callback");
        Glide.with(r2).asBitmap().load(AvatarImage.Builder.obtain(r3, r4, 24, 24).build()).into(new a(r5, r2));
    }
}
