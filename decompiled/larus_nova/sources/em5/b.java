package em5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.larus.nova.R;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f473088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<cpc.a> f473089b;

    public static final class a extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Bitmap, Unit> f473090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f473091b;

        @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            this.f473090a.invoke(BitmapFactory.decodeResource(this.f473091b.getResources(), R.drawable.facade_common_avatar_place_holder));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Bitmap, Unit> r100, Context r101) {
            this.f473090a = r100;
            this.f473091b = r101;
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void onResourceReady(Object r100, Transition r101) {
            Bitmap r102 = (Bitmap) r100;
            Intrinsics.checkNotNullParameter(r102, "resource");
            this.f473090a.invoke(r102);
        }
    }

    public e a() {
        return null;
    }

    public void c(String r100, Object r101, Function1<? super cpc.a, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r102, "loadCallback");
    }

    public Context getContext() {
        return this.f473088a;
    }

    public b(Context r100) {
        this.f473088a = r100;
        this.f473089b = new ArrayList();
    }

    public static void b(Context r100, String r101, String r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "avatarKey");
        Intrinsics.checkNotNullParameter(r102, "id");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Glide.with(r100).asBitmap().load(AvatarImage.Builder.obtain(r101, r102, 24, 24).build()).into(new a(r103, r100));
    }
}
