package com.bytedance.android.shopping.anchorv4.voavhs.headbottom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.imagex.s0;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.experiment.h;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.t;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import io.reactivex.disposables.Disposable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/HeadBottomAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/HeadBottomAdapter$HeadBottomHolder;", "HeadBottomHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadBottomAdapter extends RecyclerView.Adapter<HeadBottomHolder> {
    public List<? extends ECUrlModel> a;
    public final HashMap<String, Disposable> b;
    public final Matrix c;
    public final BitmapFactory.Options d;
    public final Rect e;
    public final SparseArray<Bitmap> f;
    public final SparseArray<Bitmap> g;
    public int h;
    public boolean i;
    public final RecyclerView j;
    public final Context k;
    public final d83.b l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/HeadBottomAdapter$HeadBottomHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class HeadBottomHolder extends RecyclerView.ViewHolder {
        public ImageView a;

        public HeadBottomHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
            super(r2);
        }
    }

    public final int getItemCount() {
        if (this.a != null) goto L9;
        d83.b r0 = this.l;
        if (r0 == null) goto L7;
        List<ECUrlModel> r1 = r0.k();
    L8:
        this.a = r1;
        goto L9
    L7:
        r1 = null;
    L9:
        List<? extends ECUrlModel> r2 = this.a;
        if (r2 != null) goto L14;
        return 0;
    L14:
        return r2.size();
    }

    public final boolean A2(int r3) {
        ECUrlModel r1 = null;
        if (this.a != null) goto L9;
        d83.b r0 = this.l;
        if (r0 == null) goto L7;
        List<ECUrlModel> r2 = r0.k();
    L8:
        this.a = r2;
        goto L9
    L7:
        r2 = null;
    L9:
        List<? extends ECUrlModel> r4 = this.a;
        if (r4 == null) goto L12;
        r1 = (ECUrlModel) CollectionsKt.getOrNull(r4, r3);
    L12:
        if (r1 == null) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean B2(int r5, ECUrlModel r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        d83.b r1 = this.l;
        VideoModel r3 = null;
        if ((r1 instanceof s) == true) goto L8;
        r1 = null;
    L8:
        s r2 = (s) r1;
        if (r2 != null) goto L11;
        return false;
    L11:
        AnchorV4HeadV2VO r4 = r2.K10();
        if (r4 == null) goto L25;
        List<HeaderContentModel> r7 = r4.getCells();
        if (r7 == null) goto L25;
        HeaderContentModel r8 = (HeaderContentModel) CollectionsKt.getOrNull(r7, r5);
        if (r8 == null) goto L25;
        HeaderMediaModel r9 = r8.getMedia();
        if (r9 == null) goto L20;
        r3 = r9.getVideo();
    L20:
        if (r3 == null) goto L25;
        if (t.a(r2, r5, Integer.valueOf(r6.getWidth()), Integer.valueOf(r6.getHeight())) == true) goto L25;
        return true;
    L25:
        return false;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, final int r8) {
        final HeadBottomHolder r9 = (HeadBottomHolder) r7;
        Intrinsics.checkNotNullParameter(r9, "holder");
        final String r0 = String.valueOf(r9.hashCode());
        Disposable r1 = this.b.get(r0);
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.b.remove(r0);
        d83.b r2 = this.l;
        ECUrlModel r3 = null;
        if ((r2 instanceof s) == true) goto L8;
        r2 = null;
    L8:
        s r4 = (s) r2;
        if (r4 == null) goto L30;
        if (r4.W4() <= 0) goto L30;
        boolean r5 = true;
        if (r4.W4() != 1) goto L16;
        if (r8 != 0) goto L16;
    L18:
        if (r5 == true) goto L27;
        if (r4.isExpanded() == true) goto L27;
        if (r8 >= r4.W4()) goto L27;
        int r6 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.k;
        int r10 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.a.b(((s) this.l).getContext(), ((s) this.l).s00(), ((s) this.l).rR().d());
        if (r10 == ((RecyclerView.ViewHolder) r9).itemView.getLayoutParams().width) goto L30;
        View r11 = ((RecyclerView.ViewHolder) r9).itemView;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.width = r10;
        r12.height = -1;
        Unit r13 = Unit.INSTANCE;
        r11.setLayoutParams(r12);
    L27:
        if (((RecyclerView.ViewHolder) r9).itemView.getWidth() == (-1)) goto L30;
        View r14 = ((RecyclerView.ViewHolder) r9).itemView;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        r15.width = -1;
        r15.height = -1;
        Unit r16 = Unit.INSTANCE;
        r14.setLayoutParams(r15);
    L16:
        r5 = false;
    L30:
        if (A2(r8) == true) goto L35;
        ImageView r17 = r9.a;
        if (r17 == null) goto L59;
        r17.setImageBitmap(null);
        return;
    L59:
        return;
    L35:
        if (this.i == false) goto L47;
        List<? extends ECUrlModel> r18 = this.a;
        if (r18 == null) goto L39;
        ECUrlModel r19 = (ECUrlModel) CollectionsKt.getOrNull(r18, r8);
    L41:
        if (B2(r8, r19) == false) goto L47;
        Bitmap r20 = this.f.get(r8);
        if (r20 == null) goto L61;
        ImageView r21 = r9.a;
        if (r21 == null) goto L62;
        r21.setImageBitmap(r20);
        return;
    L62:
        return;
    L61:
        return;
    L39:
        r19 = null;
    L47:
        Lazy r22 = PdpPerfOpt.a;
        if (PdpMessageOpt.b.e() == false) goto L54;
        Bitmap r23 = this.g.get(r8);
        if (r23 == null) goto L64;
        ImageView r24 = r9.a;
        if (r24 == null) goto L65;
        r24.setImageBitmap(r23);
        return;
    L65:
        return;
    L64:
        return;
    L54:
        int r25 = s0.f;
        List<? extends ECUrlModel> r26 = this.a;
        if (r26 == null) goto L57;
        r3 = (ECUrlModel) CollectionsKt.getOrNull(r26, r8);
    L57:
        int r27 = r.h;
        this.b.put(r0, new s0(r3, r.a.a("HeadBottomView")).a(new HeadBottomAdapter$onBindViewHolder$disposable$1(this, r9, r8, r0)));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (PdpPerfOpt.e() == false) goto L5;
        ImageView r5 = new ImageView(r3.getContext());
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r5.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout r0 = new FrameLayout(r3.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.addView(r5);
        Unit r6 = Unit.INSTANCE;
        HeadBottomHolder r7 = new HeadBottomHolder(r0);
        r7.a = r5;
        return r7;
    L5:
        View r8 = th.a.c(r3.getContext(), 2131560498, r3, false);
        HeadBottomHolder r9 = new HeadBottomHolder(r8);
        r9.a = (ImageView) r8.findViewById(2131374213);
        return r9;
    }

    public final void z2(int r3, Bitmap r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        RecyclerView.ViewHolder r0 = this.j.findViewHolderForAdapterPosition(r3);
        if ((r0 instanceof HeadBottomHolder) == true) goto L7;
        r0 = null;
    L7:
        HeadBottomHolder r1 = (HeadBottomHolder) r0;
        if (r1 == null) goto L12;
        ImageView r5 = r1.a;
        if (r5 == null) goto L14;
        r5.setImageBitmap(r4);
        return;
    L14:
        return;
    L12:
        notifyItemChanged(r3);
    }

    public HeadBottomAdapter(RecyclerView r2, Context r3, d83.b r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this.j = r2;
        this.k = r3;
        this.l = r4;
        this.b = new HashMap();
        Matrix r5 = new Matrix();
        r5.setScale(1.0f, -1.0f);
        Unit r6 = Unit.INSTANCE;
        this.c = r5;
        BitmapFactory.Options r7 = new BitmapFactory.Options();
        r7.inPreferredConfig = Bitmap.Config.ARGB_8888;
        this.d = r7;
        this.e = new Rect();
        this.f = new SparseArray();
        this.g = new SparseArray();
        this.h = com.bytedance.android.shopping.extensions.b.b(12);
    }

    public final boolean C2(int r5, int r6, int r7) {
        if (h.a() == false) goto L11;
        d83.b r0 = this.l;
        Boolean r3 = null;
        if ((r0 instanceof s) == true) goto L7;
        r0 = null;
    L7:
        s r1 = (s) r0;
        if (r1 == null) goto L19;
        r3 = Boolean.valueOf(t.a(r1, r5, Integer.valueOf(r6), Integer.valueOf(r7)));
    L19:
        return true ^ Intrinsics.areEqual(r3, Boolean.TRUE);
    L11:
        d83.b r8 = this.l;
        if (r8 != null) goto L14;
    L17:
        return false;
    L14:
        if (r8.i() != true) goto L17;
        if (r6 != r7) goto L17;
        return true;
    }

    public static final void y2(HeadBottomAdapter r11, PolarisFileInputStreamWrapper r12, HeadBottomHolder r13, int r14) {
        r11.getClass();
        ByteArrayInputStream r0 = null;
        Bitmap r1 = null;
        ByteArrayInputStream r2 = null;
        ByteArrayInputStream r3 = null;
        ByteArrayInputStream r4 = null;
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();     // Catch: Throwable -> L28 Exception -> L36
        byte[] r6 = new byte[1024];     // Catch: Throwable -> L28 Exception -> L36
    L4:
        int r7 = r12.read(r6);     // Catch: Throwable -> L28 Exception -> L36
        if (r7 == (-1)) goto L7;
        r5.write(r6, 0, r7);     // Catch: Throwable -> L28 Exception -> L36
        goto L4
    L7:
        r5.flush();     // Catch: Throwable -> L28 Exception -> L36
        ByteArrayInputStream r8 = new ByteArrayInputStream(r5.toByteArray());     // Catch: Throwable -> L28 Exception -> L36
        ByteArrayInputStream r9 = new ByteArrayInputStream(r5.toByteArray());     // Catch: Throwable -> L24 Exception -> L26
        goto L27
    L52:
        BitmapRegionDecoder r10 = BitmapRegionDecoder.newInstance(r8, false);     // Catch: Throwable -> L21 Exception -> L23
        BitmapFactory.Options r15 = new BitmapFactory.Options();     // Catch: Throwable -> L21 Exception -> L23
        r15.inJustDecodeBounds = true;     // Catch: Throwable -> L21 Exception -> L23
        BitmapFactory.decodeStream(r9, null, r15);     // Catch: Throwable -> L21 Exception -> L23
        int r16 = r15.outWidth;     // Catch: Throwable -> L21 Exception -> L23
        int r17 = r15.outHeight;     // Catch: Throwable -> L21 Exception -> L23
        if (r11.C2(r14, r16, r17) == false) goto L14;
        Lazy r18 = UIUtils.a;     // Catch: Throwable -> L21 Exception -> L23
        UIUtils.e(new b(r13));     // Catch: Throwable -> L21 Exception -> L23
    L12:
        r8.close();     // Catch: Exception -> L44
    L41:
        r9.close();     // Catch: Exception -> L44
    L42:
        r12.close();     // Catch: Exception -> L44
        return;
    L14:
        Rect r19 = r11.e;     // Catch: Throwable -> L21 Exception -> L23
        r19.left = 0;     // Catch: Throwable -> L21 Exception -> L23
        r19.top = r17 - r11.h;     // Catch: Throwable -> L21 Exception -> L23
        r19.right = r16;     // Catch: Throwable -> L21 Exception -> L23
        r19.bottom = r17;     // Catch: Throwable -> L21 Exception -> L23
        if (r10 == null) goto L17;
        r1 = r10.decodeRegion(r19, r11.d);     // Catch: Throwable -> L21 Exception -> L23
    L17:
        Bitmap r20 = r1;
        if (r20 == null) goto L12;
        Bitmap r110 = Bitmap.createBitmap(r20, 0, 0, r20.getWidth(), r20.getHeight(), r11.c, true);     // Catch: Throwable -> L21 Exception -> L23
        Lazy r111 = UIUtils.a;     // Catch: Throwable -> L21 Exception -> L23
        UIUtils.e(new a(r110, r13));     // Catch: Throwable -> L21 Exception -> L23
    L23:
        r2 = r9;
    L21:
        th = th;
        r3 = r9;
    L25:
        ByteArrayInputStream r112 = r3;
        r0 = r8;
    L30:
        if (r0 != null) goto L48;
    L32:
        if (r112 == null) goto L34;
        r112.close();     // Catch: Exception -> L45
    L34:
        r12.close();     // Catch: Exception -> L45
    L35:
        throw th;
    L48:
        r0.close();     // Catch: Exception -> L45
    L24:
        th = th;
    L27:
        ByteArrayInputStream r113 = r2;
        r4 = r8;
    L37:
        if (r4 == null) goto L39;
        r4.close();     // Catch: Exception -> L44
    L39:
        if (r113 == null) goto L42;
        r9 = r113;
        goto L41
    L36:
        r113 = null;
    L28:
        th = th;
        r112 = null;
    }
}
